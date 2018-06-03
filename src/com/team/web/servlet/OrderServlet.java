package com.team.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.team.domain.Order;
import com.team.domain.OrderItem;
import com.team.domain.Schedule;
import com.team.domain.Seat;
import com.team.domain.User;
import com.team.service.OrderService;
import com.team.service.ScheduleService;
import com.team.service.SeatService;
import com.team.service.impl.OrderServiceImpl;
import com.team.service.impl.ScheduleServiceImpl;
import com.team.service.impl.SeatServiceImpl;
import com.team.utils.PaymentUtil;
import com.team.utils.UUIDUtils;
import com.team.web.base.BaseServlet;

import net.sf.json.JSONArray;

/**
 * 订单模块
 */
public class OrderServlet extends BaseServlet {

	// 默认
	public String execute(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		String sid = request.getParameter("sid");
		// 表演计划表
		ScheduleService service = new ScheduleServiceImpl();
		// 全部的详细信息
		Schedule list = service.findPlayInfoById(sid);
		request.setAttribute("s", list);
		return "/jsp/orderPre.jsp";
	}
	//支付转发
	public String payOrderUI(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		
		return "/jsp/pay.jsp";
	}
	
	//删除订单
	public String deleteOrder(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		
		String oid = request.getParameter("oid");
		OrderService service = new OrderServiceImpl();
		//删除订单
		service.deleteOrder(oid);
		return "/index.jsp";
		
	}
	// 提交订单
	public String submitOrder(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		
		// 确认用户登录状态
		User user = (User) request.getSession().getAttribute("userLogin");
		/*if (null == user) {
			request.setAttribute("msg", "请登录之后在下单");
			return "/jsp/info.jsp";
		}*/
		// 电影票的数量
		int num = Integer.parseInt(request.getParameter("num"));
		// 获取演出计划的id
		String sid = request.getParameter("sid");
		// 获取总金额
		int subTotal = Integer.parseInt(request.getParameter("total"));
		// 获取座位的信息
		String cart = request.getParameter("cart");

		ScheduleService service = new ScheduleServiceImpl();
		OrderItem orderItem = service.findOrderInfo(sid);
		orderItem.setOiid(UUIDUtils.getId());
		orderItem.setNum(num);
		orderItem.setSubTotal(subTotal);
		//保存座位的信息
		orderItem.setSeat(cart);
		
		cart = cart.substring(0, cart.length() - 1);
		String[] s = cart.split("座");
		List<Seat> list = new ArrayList<>();


		// 关联订单和订单详情
		OrderService os = new OrderServiceImpl();
		Order order = new Order();
		order.setOid(UUIDUtils.getId());
		// 设置用户id
		order.setUid(user.getUid());
		order.setOrderTime(new Date());
		order.setState(0);
		order.setTotal(orderItem.getSubTotal());
		orderItem.setOid(order.getOid());
		
		for (String str : s) {
			list.add(new Seat(UUIDUtils.getId(), Integer.parseInt(str.split("排")[0]),
					Integer.parseInt(str.split("排")[1]), "1", orderItem.getHall().getHid(),order.getOid()));
		}
		// 保存座位
		SeatService seatservice = new SeatServiceImpl();
		seatservice.saveSeat(list);
		
		// 保存订单
		os.submitOrder(order);
		// 保存订单条目
		os.submitOrderItem(orderItem);
		request.getSession().setAttribute("oi", orderItem);
		return "jsp/pay.jsp";
	}
	//查看订单详情
	public String findOrderByUid(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		String uid = request.getParameter("uid");
		OrderService service = new OrderServiceImpl();
		List<Order> list = service.findOrderByUid(uid);
		request.setAttribute("list", list);
		return "jsp/myorder.jsp";
		
	}
	//查看订单中包含的所有条目
	public String findOrderByOid(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String oid = request.getParameter("oid");
		OrderService service = new OrderServiceImpl();
		List<OrderItem> list = service.findOrderItemByOid(oid);
		String str = JSONArray.fromObject(list).toString();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(str);
		return null;
	}

	//支付订单
	public String payOrder(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		// 获取订单oid,收货人地址,姓名,电话,银行
/*		String oid = req.getParameter("oid");
		String address = req.getParameter("address");
		String name = req.getParameter("name");
		String telephone = req.getParameter("telephone");
		String pd_FrpId = req.getParameter("pd_FrpId");
		// 更新订单上收货人的地址,姓名,电话
		OrderService OrderService = new OrderServiceImpl();
		Order order = OrderService.findOrderByOid(oid);
		OrderService.updateOrder(order);*/
		// 向易宝支付发送参数
		// 把付款所需要的参数准备好:
		String p0_Cmd = "Buy";
		// 商户编号
		String p1_MerId = "10001126856";
		// 订单编号
		//String p2_Order = oid;
		// 金额
		String p3_Amt = "0.01";
		String p4_Cur = "CNY";
		String p5_Pid = "";
		String p6_Pcat = "";
		String p7_Pdesc = "";
		// 接受响应参数的Servlet
		String p8_Url = "http://localhost:8080/store_v5/OrderServlet?method=callBack";
		String p9_SAF = "";
		String pa_MP = "";
		String pr_NeedResponse = "1";
		// 公司的秘钥
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";

		// 调用易宝的加密算法,对所有数据进行加密,返回电子签名
	//	String hmac = PaymentUtil.buildHmac(p0_Cmd, p1_MerId, p2_Order, p3_Amt, p4_Cur, p5_Pid, p6_Pcat, p7_Pdesc,
	//			p8_Url, p9_SAF, pa_MP, pd_FrpId, pr_NeedResponse, keyValue);

		StringBuffer sb = new StringBuffer("https://www.yeepay.com/app-merchant-proxy/node?");
		sb.append("p0_Cmd=").append(p0_Cmd).append("&");
		sb.append("p1_MerId=").append(p1_MerId).append("&");
		//sb.append("p2_Order=").append(p2_Order).append("&");
		sb.append("p3_Amt=").append(p3_Amt).append("&");
		sb.append("p4_Cur=").append(p4_Cur).append("&");
		sb.append("p5_Pid=").append(p5_Pid).append("&");
		sb.append("p6_Pcat=").append(p6_Pcat).append("&");
		sb.append("p7_Pdesc=").append(p7_Pdesc).append("&");
		sb.append("p8_Url=").append(p8_Url).append("&");
		sb.append("p9_SAF=").append(p9_SAF).append("&");
		sb.append("pa_MP=").append(pa_MP).append("&");
		//sb.append("pd_FrpId=").append(pd_FrpId).append("&");
		sb.append("pr_NeedResponse=").append(pr_NeedResponse).append("&");
		//sb.append("hmac=").append(hmac);

		System.out.println(sb.toString());
		// 使用重定向：
		resp.sendRedirect(sb.toString());
		return null;
	}

	// callBack
	public String callBack(HttpServletRequest request, HttpServletResponse resp) throws Exception {
		// 接收易宝支付的数据
		// 验证请求来源和数据有效性
		// 阅读支付结果参数说明
		// System.out.println("==============================================");
		String p1_MerId = request.getParameter("p1_MerId");
		String r0_Cmd = request.getParameter("r0_Cmd");
		String r1_Code = request.getParameter("r1_Code");
		String r2_TrxId = request.getParameter("r2_TrxId");
		String r3_Amt = request.getParameter("r3_Amt");
		String r4_Cur = request.getParameter("r4_Cur");
		String r5_Pid = request.getParameter("r5_Pid");
		String r6_Order = request.getParameter("r6_Order");
		String r7_Uid = request.getParameter("r7_Uid");
		String r8_MP = request.getParameter("r8_MP");
		String r9_BType = request.getParameter("r9_BType");
		String rb_BankId = request.getParameter("rb_BankId");
		String ro_BankOrderId = request.getParameter("ro_BankOrderId");
		String rp_PayDate = request.getParameter("rp_PayDate");
		String rq_CardNo = request.getParameter("rq_CardNo");
		String ru_Trxtime = request.getParameter("ru_Trxtime");

		// hmac
		String hmac = request.getParameter("hmac");
		// 利用本地密钥和加密算法 加密数据
		String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";

		// 保证数据合法性
		boolean isValid = PaymentUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId, r3_Amt, r4_Cur, r5_Pid,
				r6_Order, r7_Uid, r8_MP, r9_BType, keyValue);
		if (isValid) {
			// 有效
			if (r9_BType.equals("1")) {
				// 浏览器重定向

				// 如果支付成功,更新订单状态
				OrderService OrderService = new OrderServiceImpl();
				Order order = OrderService.findOrderByOid(r6_Order);
				order.setState(2);
				OrderService.updateOrder(order);
				// 向request放入提示信息
				request.setAttribute("msg", "支付成功！订单号：" + r6_Order + "金额：" + r3_Amt);
				// 转发到/jsp/info.jsp
				return "/jsp/info.jsp";

			} else if (r9_BType.equals("2")) {
				// 修改订单状态:
				// 服务器点对点，来自于易宝的通知
				System.out.println("收到易宝通知，修改订单状态！");//
				// 回复给易宝success，如果不回复，易宝会一直通知
				resp.getWriter().print("success");
			}

		} else {
			throw new RuntimeException("数据被篡改！");
		}
		return null;
	}
}

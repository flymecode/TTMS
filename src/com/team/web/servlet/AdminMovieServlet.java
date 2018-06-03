package com.team.web.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.team.domain.Movie;
import com.team.service.MovieService;
import com.team.service.impl.MovieServiceImpl;
import com.team.web.base.BaseServlet;

/**
 * 电影后台模块
 */
public class AdminMovieServlet extends BaseServlet {

	public String findAllMovieWithPage(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		MovieService service = new MovieServiceImpl();
		List<Movie> list = service.findAllMovieWithPage();
		request.setAttribute("list", list);

		return "admin/main/movie.jsp";
	}
	//删除电影
	public String deleteMovie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		
		String mid = request.getParameter("mid");
		MovieService service = new MovieServiceImpl();
		service.deleteMovie(mid);
		//response.sendRedirect("admin/main/movie.jsp");
		return "admin/main/movie.jsp";
	}
	//转发电影
	public String addMovieUI(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException {
		return "admin/main/addmovie.jsp";
	}
	
	/*// 添加电影
	public String addMovie(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, SQLException, FileUploadException, IllegalAccessException, InvocationTargetException {
		// 存储表单中的数据
		Map<String, String> map = new HashMap<String, String>();
		//建立movie对象
		Movie movie = new Movie();

		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(fac);
		// 获取全部的请求数据
		List<FileItem> list = upload.parseRequest(request);
		// 遍历集合
		for (FileItem fileItem : list) {
			if (fileItem.isFormField()) {
				// 讲普通项上name属性做为键,将获取到的内容作为值
				map.put(fileItem.getFieldName(), fileItem.getString("UTF-8"));
			} else {
				
				
				//获取到原始文件名称
				String oldFileName = fileItem.getName();
				//获取到要保存的文件的名称
				String newFileName = UploadUtils.getUUIDName(oldFileName);
				//通过FileItem获取输入流对象
				InputStream is = fileItem.getInputStream();
				//获取当前项目下真实的路径
				String relPath = getServletContext().getRealPath("/img/");
				String dir=UploadUtils.getDir(newFileName); // /f/e/d/c/4/9/8/4
				//String path=realPath+dir; //D:\tomcat\tomcat71_sz07\webapps\store_v5\products\3/f/e/d/c/4/9/8/4
				//内存中声明一个目录
				File newDir=new File();
				if(!newDir.exists()){
					newDir.mkdirs();
				}
				//在服务端创建一个空文件(后缀必须和上传到服务端的文件名后缀一致)
				File finalFile=new File(newDir,newFileName);
				if(!finalFile.exists()){
					finalFile.createNewFile();
				}
				//建立和空文件对应的输出流
				OutputStream os=new FileOutputStream(finalFile);
				//将输入流中的数据刷到输出流中
				IOUtils.copy(is, os);
				//释放资源
				IOUtils.closeQuietly(is);
				IOUtils.closeQuietly(os);
				//向map中存入一个键值对的数据 userhead<===> /image/11.bmp
				// {username<==>tom,password<==>1234,userhead<===>image/11.bmp}
				map.put("pimage", "/products/3/"+dir+"/"+newFileName);
			}
		}
		
		BeanUtils.populate(movie, map);
		MovieService service = new MovieServiceImpl();
		//service.addMovie(movie);
		return "admin/main/addmovie.jsp";
	}*/
	
	//修改电影转发
	public String updateMovieUI(HttpServletRequest request, HttpServletResponse resp)
			throws ServletException, IOException, SQLException {
		System.out.println("3333");
		String mid = request.getParameter("mid");
		MovieService service = new MovieServiceImpl();
		Movie movie = service.findMovieById(mid);
		request.setAttribute("movie", movie);
		return "admin/main/updateMovie.jsp";
	}
}

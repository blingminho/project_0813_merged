package team.project.commentservice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.CommentDao;
import team.project.dao.UserDao;
import team.project.service.NextPage;
import team.project.service.UserService;

public class CommentDeleteService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println();
		System.out.println("2. CommentDeleteService Start");

		String commentId= (String)request.getParameter("commentId");
		System.out.println(commentId);
		String userId= (String)request.getSession().getAttribute("userId");

		NextPage nextPage = new NextPage();
		String commentUpdate=null;
		int idchek;
		try {
			idchek=UserDao.getInstance().idCheck(userId);
			System.out.println("idchek : "+idchek);
			if(idchek==1){
				System.out.println(idchek+" , 코멘트아이디 : "+commentId);
				commentUpdate = CommentDao.getInstance().commentDelete(commentId);
				request.getSession().setAttribute("message", "success");

				nextPage.setPageName("index.jsp");
				nextPage.setRedirect(true);
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMSG", "fail");
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false);
		}
		return null;
	}


}

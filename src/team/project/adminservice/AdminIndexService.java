package team.project.adminservice;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import team.project.dto.Admin;
import team.project.service.NextPage;
import team.project.service.UserService;


public class AdminIndexService implements UserService {
	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("2.AdminIndexService");
		Admin admin = new AdminIndexService_ajax();
		
		// 4. 페이지 이동
		NextPage nextPage = new NextPage();

		if (admin != null) {
			System.out.println("널값 아니다");
			nextPage.setPageName("./jsp/adminindex.jsp");
			request.getSession().setAttribute("adminToday", admin);
			nextPage.setRedirect(true);
		}
		else {
			System.out.println("널값이다 알려줘");
			request.setAttribute("errorMSG", "오류발생");
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false);
		}
		return nextPage;
	}

}

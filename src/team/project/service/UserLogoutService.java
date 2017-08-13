package team.project.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.project.dao.UserDao;

public class UserLogoutService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println();
		System.out.println("2. UserLogoutService");
		// 1. ��û�Ķ���� ó��
		HttpSession session = request.getSession();

		// 2. DBó��
		session.removeAttribute("loginedUser");
		// 3. DB��� ó��
		String result = "";
		result = (String) session.getAttribute("loginedUser");
		// 4. ���������� ó��
		NextPage nextPage = new NextPage();
		// �α׾ƿ�
		if (result == null) {
			System.out.println("loginedUser : " + result);
			System.out.println("if loginedUser is null, logout have completed");
			
			nextPage.setPageName("/webproject7/jsp/index.jsp");
			nextPage.setRedirect(true);
		}
		// �α׾ƿ� ����
		else {
			request.setAttribute("errorMSG", "�α��ο� �����߽��ϴ�.");
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false);
		}
		return nextPage;
	}

}

package team.project.service;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import team.project.dao.UserDao;
import team.project.dto.User;

public class UserLoginService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println();
		System.out.println("2. UserLoginService");
		//1. ��û�Ķ���� ó��
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		User user = new User();
		user.setEmail(email);
		user.setPassword(password);
		User loginedUser = null;
		//2. DBó��
		try {
			loginedUser = UserDao.getInstance().login(user);
			//UserDao.getInstance().hiveTest("1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//3. DB��� ó��
		
		//4. ���������� ó��
		
		NextPage nextPage = new NextPage();
		HttpSession session = request.getSession();
		//ȸ������ ����
		if(loginedUser !=null) {
			
			session.setAttribute("loginedUser", loginedUser);
			
			System.out.println("loginedUser : " + loginedUser);

			nextPage.setPageName("/webproject7/jsp/index.jsp");
			nextPage.setRedirect(true);
		}
		//ȸ������ ����
		else {
			request.setAttribute("errorMSG","�α��ο� �����߽��ϴ�.");
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false);
		}
		return nextPage;
	}

}

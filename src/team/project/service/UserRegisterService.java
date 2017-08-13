package team.project.service;

import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.UserDao;
import team.project.dto.User;

public class UserRegisterService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println();
		System.out.println("2. UserRegisterService");
		//1. ��û�Ķ���� ó��
		//String UserId = request.getParameter("userId");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String born = request.getParameter("born");
		System.out.println(email);
		System.out.println(password);
		System.out.println(name);
		System.out.println(gender);
		
		
		Calendar cal = Calendar.getInstance();
	    String dateString = String.format("%02d%02d%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
	    Integer randomId = (int)(Math.random()*10000);

		User user = new User();
		String UserId ="local:"+dateString+randomId;
		user.setUserId(UserId);
		user.setEmail(email);
		user.setPassword(password);
		user.setName(name);
		user.setGender(gender);
		user.setBorn(born);


		
		//2. DBó��
		int result=0;
		try {
			result = UserDao.getInstance().insert(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		//3. DB��� ó��
		
		//4. ���������� ó��
		NextPage nextPage = new NextPage();
		//ȸ������ ����
		if(result !=0) {
			nextPage.setPageName("./jsp/registermsg.jsp");
			request.setAttribute("name", name);
			nextPage.setRedirect(true);
		}
		//ȸ������ ����
		else {
			request.setAttribute("errorMSG","ȸ�����Կ� �����߽��ϴ�.");
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false);
		}
		return nextPage;
	}

}

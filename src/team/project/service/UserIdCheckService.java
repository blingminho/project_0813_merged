package team.project.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.UserDao;

public class UserIdCheckService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println();
		System.out.println("2. UserIdCheckService");
		String email = request.getParameter("email");
		System.out.println(email);
		
		int result = 0;
		result = UserDao.getInstance().idCheck(email);
		
		//�ߺ�
		System.out.println(result);
		PrintWriter out;
		
		try {
			out = response.getWriter();
			out.print(result);//ajax ������
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}

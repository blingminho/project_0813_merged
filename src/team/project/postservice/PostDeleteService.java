package team.project.postservice;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.PostDao;
import team.project.dto.Post;
import team.project.dto.User;
import team.project.service.NextPage;
import team.project.service.UserService;

public class PostDeleteService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println();
		System.out.println("2. PostDeleteService Start");

		User loginedUser = (User) request.getSession().getAttribute("loginedUser"); // 로그인한 유저객체
		String postNo = request.getParameter("postNo"); // 삭제할 게시글의 postNO
		NextPage nextPage = new NextPage(); // 다음url 객체
		int result = 0; // DB에서 삭제된 게시글 개수

		// 로그인 상태가 아니면 메인페이지로 이동
		if (loginedUser == null) {
			nextPage.setPageName("logout.puppy");
			return nextPage;
		}

		// 유저가 로그인 상태면 게시글 삭제
		else if (loginedUser != null) {
			try {
				result = PostDao.getInstance().postDelete(Integer.parseInt(postNo));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//게시글이 DB에서 삭제됬으면(DB에서 삭제한 게시글 수가 0이 아니면),
		// 다음 url : 게시글을 보여주는 postList.puppy 서비스 실행
		if (result != 0) {
			System.out.println(result + "개의 게시글이 삭제되었습니다.");

			nextPage.setPageName("postList.puppy");
			nextPage.setRedirect(true);
		}
		// ȸ������ ����
		else {
			System.out.println("게시글 삭제를 실패했습니다.");
			request.setAttribute("errorMSG", "�α��ο� �����߽��ϴ�.");
			nextPage.setPageName("index.jsp");
			nextPage.setRedirect(false);
		}
		return nextPage;
	}

}

package team.project.postservice;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import team.project.dao.PostDao;
import team.project.dto.Post;
import team.project.service.UserService;
import team.project.service.NextPage;

//게시글 리스트를 보여주는 서비스
public class PostListService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println();
		System.out.println("2. PostListService Start");

		int totalCount = 0; // 전체 글 수
		ArrayList<Post> postList = null; // 보여줄 게시글 리스트
		NextPage nextPage = new NextPage(); // 다음url 객체

		try {
			// 전체 게시글 리스트를 리턴하는 selectPostList메소드
			postList = PostDao.getInstance().selectPostList();
			System.out.println("postList : " + postList);
			// 전체 게시글 수를 리턴하는 getPostTotalCount메소드
			totalCount = PostDao.getInstance().getPostTotalCount();
			System.out.println("totalCount : " + totalCount);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// postList가 존재하면 postList를 session영역에 설정
		// 다음url : 게시글리스트를 보여주는 ./postlist.jsp
		if (postList != null) {
			request.getSession().setAttribute("postList", postList);
			nextPage.setPageName("./postlist.jsp");
			nextPage.setRedirect(false);
		}
		// ȸ������ ����
		else {
			request.setAttribute("errorMSG", "�α��ο� �����߽��ϴ�.");
			nextPage.setPageName("error.jsp");
			nextPage.setRedirect(false);
		}
		return nextPage;
	}

}

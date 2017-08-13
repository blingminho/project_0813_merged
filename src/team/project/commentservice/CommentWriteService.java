package team.project.commentservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import team.project.dao.CommentDao;
import team.project.dto.Comment;
import team.project.dto.User;
import team.project.service.NextPage;
import team.project.service.UserService;

public class CommentWriteService implements UserService {

	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println();
		System.out.println("2. CommentWriteService Start");

		User loginedUser = (User) request.getSession().getAttribute("loginedUser");
		String content = request.getParameter("content");
		String postNo = request.getParameter("postNo");
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		JSONArray jsonArray = new JSONArray();
		Comment comment = new Comment(); // DB에 저장할 댓글 객체생성
		NextPage nextPage = new NextPage(); // 다음 url 객체
		int result = 0; // DB에 저장한 댓글 수

		System.out.println("content : " + content);
		System.out.println("postNo : " + postNo);
		System.out.println("userId : " + userId);
		System.out.println("name : " + name);

		// 유저가 로그인 상태가 아니면 댓글 삽입 불가, 메인페이지로 이동
		if (loginedUser == null) {
			nextPage.setPageName("logout.puppy");
			return nextPage;
		}

		// 유저가 로그인 상태이면 삽입할 댓글 객체 필드값 설정
		else if (loginedUser != null) {
			comment.setContent(content);
			comment.setPostNo(Integer.parseInt(postNo));
			comment.setUserId(userId);
			comment.setName(name);
			try {
				// 댓글 객체를 DB에 저장
				result = CommentDao.getInstance().commentWrite(comment);
				// 해당 게시글의 commentList 가져오기
				comment = CommentDao.getInstance().selectComment(Integer.parseInt(postNo));
				System.out.println("comment : " + comment);
			} catch (SQLException | NumberFormatException | ClassNotFoundException e) {
				e.printStackTrace();
			}

			System.out.println("---------JSON Start---------");
			try {
				/*for (int i = 0; i < commentList.size(); i++) {

					JSONObject obj = new JSONObject();
					obj.put("commentId", commentList.get(i).getCommentId());
					obj.put("content", commentList.get(i).getContent());
					obj.put("postNo", commentList.get(i).getPostNo());
					obj.put("userId", commentList.get(i).getUserId());
					obj.put("commentDt", commentList.get(i).getCommentDt());
					obj.put("superComment", commentList.get(i).getSuperComment());
					obj.put("likeCt", commentList.get(i).getSuperComment());
					obj.put("name", commentList.get(i).getName());
					jsonArray.put(obj);
				}*/
				JSONObject obj = new JSONObject();
				obj.put("commentId", comment.getCommentId());
				obj.put("content", comment.getContent());
				obj.put("postNo", comment.getPostNo());
				obj.put("userId", comment.getUserId());
				obj.put("commentDt", comment.getCommentDt());
				obj.put("superComment", comment.getSuperComment());
				obj.put("likeCt", comment.getSuperComment());
				obj.put("name", comment.getName());
				jsonArray.put(obj);
				
				PrintWriter out = response.getWriter();
				out.print(jsonArray);
			} catch (JSONException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getSession().setAttribute("comment", comment);
		}
		
		System.out.println(result + " 개의 댓글이 저장되었습니다.");
		
		/*// 댓글 객체가 DB저장 됐으면(DB에 저장한 댓글 수가 0이 아니면),
		// 다음url : 게시글 보여주는 postRead.puppy 서비스 실행
		if (result != 0) {
			System.out.println(result + "개의 게시글이 삽입되었습니다.");
			System.out.println(comment);

			nextPage.setPageName("postRead.puppy?postNo=" + postNo);
			nextPage.setRedirect(true);
		}

		else {
			System.out.println("댓글 삽입이 실패했습니다.");
			request.setAttribute("errorMSG", "�α��ο� �����߽��ϴ�.");
			nextPage.setPageName("index.jsp");
			nextPage.setRedirect(false);
		}*/
		return null;
	}

}

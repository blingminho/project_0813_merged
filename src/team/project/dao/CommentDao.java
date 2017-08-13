package team.project.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import team.project.dto.Comment;
import team.project.dto.Post;
import team.project.dto.User;
import team.project.util.DBUtil;
public class CommentDao {
	private static CommentDao dao = new CommentDao();
	private CommentDao(){}
	public static CommentDao getInstance(){
		return dao;
	}
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	StringBuffer query;
	Comment comment;
	
	Calendar cal = Calendar.getInstance();
	String dateString = String.format("%04d-%02d-%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
	cal.get(Calendar.DAY_OF_MONTH));
	
	//코멘트를 작성하는 메소드
	public synchronized int commentWrite(Comment comment) throws SQLException{
		System.out.println("3. CommentDao commentWrite()");
		
		con = DBUtil.getConnection();
		query = new StringBuffer();
		query.append("insert into comment (content, postNo, userId, commentDt, name) values(?,?,?,?,?)");
		
		pstmt = con.prepareStatement(query.toString());
		pstmt.setString(1, comment.getContent());
		pstmt.setInt(2, comment.getPostNo());
		pstmt.setString(3, comment.getUserId());
		pstmt.setString(4, dateString);
		pstmt.setString(5, comment.getName());
		
		int result = pstmt.executeUpdate();
		
		DBUtil.close(con, pstmt);
		
		return result;	
	}
	
	public Comment selectComment(int postNo) throws ClassNotFoundException, SQLException{
		System.out.println("3. CommentDao selectComment()");
		
		con = DBUtil.getConnection();
		query = new StringBuffer();
		query.append("SELECT *  FROM comment WHERE postNo = ? order by commentId desc");
		
		pstmt = con.prepareStatement(query.toString());
		pstmt.setString(1, Integer.toString(postNo));
		rs = pstmt.executeQuery();
		
		comment = new Comment();
		if (rs.next()) {
			comment.setCommentId(rs.getInt("commentId"));
			comment.setContent(rs.getString("content"));
			comment.setPostNo(rs.getInt("postNo"));
			comment.setUserId(rs.getString("userId"));
			comment.setCommentDt(rs.getString("commentDt"));
			comment.setSuperComment(rs.getInt("superComment"));
			comment.setLikeCt(rs.getInt("likeCt"));
			comment.setName(rs.getString("name"));
		}
		
		DBUtil.close(con, pstmt);
		return comment;
	}
	
	public ArrayList<Comment> selectCommentList(int postNo) throws SQLException{
		System.out.println("3. CommentDao selectCommentList()");
		
		con = DBUtil.getConnection();
		query = new StringBuffer();
		query.append("select * from comment where postNo=?");
		
		pstmt = con.prepareStatement(query.toString());
		pstmt.setInt(1, postNo);
		rs = pstmt.executeQuery();
		
		ArrayList<Comment> commentList = new ArrayList<Comment>();
		while(rs.next()){
			comment = new Comment();
			
			comment.setCommentId(rs.getInt("commentId"));
			comment.setContent(rs.getString("content"));
			comment.setPostNo(rs.getInt("postNo"));
			comment.setUserId(rs.getString("userId"));
			comment.setCommentDt(rs.getString("commentDt"));
			comment.setSuperComment(rs.getInt("superComment"));
			comment.setLikeCt(rs.getInt("likeCt"));
			comment.setName(rs.getString("name"));
			
			commentList.add(comment);
		}
		
		DBUtil.close(con, pstmt);
		
		return commentList;
		
	}
	
	public String commentUpdate(String content, String commentId) throws SQLException{
		System.out.println("3. CommentDao commentUpdate()");
		Connection con = DBUtil.getConnection();
		String sql = "update comment set content='"+content+"',commentDt='"+dateString+"' where commentId='"+commentId+"'";
		System.out.println(content);
		System.out.println(commentId);
	    System.out.println("data : " +dateString);
	    PreparedStatement pstmt=null;
	    try{
	    	pstmt = con.prepareStatement(sql);

//			pstmt.setString(1, commentId);
			int result = pstmt.executeUpdate();
			System.out.println("result : "+result);
			DBUtil.close(con, pstmt);
	    }catch(Exception e){
	    	e.printStackTrace();
	    	DBUtil.close(con, pstmt);
	    }
		return sql;
		
	}
	
	public String commentDelete(String commentId) throws SQLException{
		System.out.println("3. CommentDao commentDelete()");
		Connection con = DBUtil.getConnection();
		String sql = "delete from comment where commentId='"+commentId+"'";
	    PreparedStatement pstmt=null;
	    try{
	    	pstmt = con.prepareStatement(sql);

			int result = pstmt.executeUpdate();
			System.out.println("result : "+result);
			DBUtil.close(con, pstmt);
	    }catch(Exception e){
	    	e.printStackTrace();
	    	DBUtil.close(con, pstmt);
	    }
		return sql;
		
		
		
	}
	
}

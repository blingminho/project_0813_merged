package team.project.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import team.project.dto.User;
import team.project.util.DBUtil;
import team.project.util.HiveDBUtil;



public class UserDao {
	private static UserDao dao = new UserDao();
	
	private UserDao() {}
	public static UserDao getInstance() {
		return dao;
	}
	Calendar cal = Calendar.getInstance();
    String dateString = String.format("%04d-%02d-%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
	// 1.ȸ������
		public int insert(User user) throws SQLException {
			System.out.println("3. UserDao insert()");

			Connection con = DBUtil.getConnection();
			String sql = "insert into user values (?,?,?,?,?,?,null,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getEmail());
			pstmt.setString(3, user.getPassword());
			pstmt.setString(4, user.getName());
			pstmt.setString(5, user.getGender());
			pstmt.setString(6, user.getBorn());
			pstmt.setString(7, dateString);

			int result = pstmt.executeUpdate();
			
			DBUtil.close(con, pstmt);

			return result;
		}
		//2. �α���
		public User login(User user) throws SQLException {
			System.out.println("3. UserDao login()");
			Connection con = DBUtil.getConnection();
			String sql ="select born,email,gender,name,password,regDt,userId from user where email=? and password=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, user.getEmail());
			pstmt.setString(2, user.getPassword());
			
			ResultSet rs = null;
			rs = pstmt.executeQuery();
			String result = "";
			if (rs.next()) {//�����Ͱ� ������
				if(rs.getString("email").equals(user.getEmail())) {
					if(rs.getString("password").equals(user.getPassword())) {
						User loginedUser = new User();
						loginedUser.setBorn(rs.getString("born"));
						loginedUser.setEmail(rs.getString("email"));
						loginedUser.setGender(rs.getString("gender"));
						loginedUser.setName(rs.getString("name"));
						loginedUser.setPassword(rs.getString("password"));
						loginedUser.setRegDt(rs.getString("regDt"));
						loginedUser.setUserId(rs.getString("userId"));
						
						DBUtil.close(con, pstmt, rs);
						return loginedUser;//���̵��� �� ������� ����
					}else DBUtil.close(con, pstmt, rs);return null;//����� Ʋ����
				}else DBUtil.close(con, pstmt, rs);return null;//
			}else DBUtil.close(con, pstmt, rs);return null;
		}
		//3.���̵� üũ
		public int idCheck(String email) {
			System.out.println("3. UserDao IdCheck()");
			Connection con;
			PreparedStatement pstmt;
			String sql = "select * from user where email=?";
			ResultSet rs = null;
					
			try {
				con = DBUtil.getConnection();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, email);
				rs = pstmt.executeQuery();
				//System.out.println(rs.getFetchSize());
				if(rs.next()) {//���Ұ�
					DBUtil.close(con, pstmt, rs);
					return 0;
				}else DBUtil.close(con, pstmt, rs);return 1; //��밡��.
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;

		}
		public int hiveTest(String string) {
			System.out.println("3. UserDao IdCheck()");
			Connection con;
			PreparedStatement pstmt;
			String sql = "show tables";
			ResultSet rs = null;
					
			try {
				con = HiveDBUtil.getConnection();
				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();
				//System.out.println(rs.getFetchSize());
				if(rs.next()) {//���Ұ�
					System.out.println("있따"+rs.getString(1));
					HiveDBUtil.close(con, pstmt, rs);
					return 0;
				}else HiveDBUtil.close(con, pstmt, rs);return 1; //��밡��.
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return 1;

		}
		
}

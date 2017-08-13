package team.project.adminservice;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import team.project.dto.Admin;
import team.project.dto.Time_now;
import team.project.service.NextPage;
import team.project.service.UserService;


public class AdminIndexService_ajax implements UserService {
	@Override
	public NextPage execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("2.AdminIndexService_ajax");
		
		AdminIndexSelectService AdminIndexSelect = new AdminIndexSelectService();
		Admin admin = new Admin();
		Time_now now = new DateToday().getDate();
		AdminIndexSelect.selectTodayData(now, admin);
		AdminIndexSelect.selectMonthData(now, admin);
		AdminIndexSelect.selectAllData(now, admin);
		System.out.println(admin);
		/*
		List<Admin> list = new ArrayList<>();
		list = null;
		list = AdminIndexSelect.selectDataJson(admin);
		*/
		System.out.println("json--------------------");
		JSONArray jsonarray = new JSONArray();
		/*
		for (int i = 0; i < list.size(); i++) {
			JSONObject jsonobj = new JSONObject();
			
			jsonobj.put("allPost", String.valueOf(list.get(i).getAllPost()));
			jsonobj.put("allVisit", String.valueOf(list.get(i).getAllVisit()));
			jsonobj.put("allPuppy", String.valueOf(list.get(i).getAllPuppy()));
			jsonobj.put("allUser", String.valueOf(list.get(i).getAllUser()));
			
			jsonobj.put("todayPost", String.valueOf(list.get(i).getTodayPost()));
			jsonobj.put("todayVisit", String.valueOf(list.get(i).getTodayVisit()));
			jsonobj.put("todayPuppy", String.valueOf(list.get(i).getTodayPuppy()));
			jsonobj.put("todayUser", String.valueOf(list.get(i).getTodayUser()));
			
			jsonobj.put("monthPost", String.valueOf(list.get(i).getMonthPost()));
			jsonobj.put("monthVisit", String.valueOf(list.get(i).getMonthVisit()));
			jsonobj.put("monthPuppy", String.valueOf(list.get(i).getMonthPuppy()));
			jsonobj.put("monthUser", String.valueOf(list.get(i).getMonthUser()));
			
			jsonobj.put("monthPost", String.valueOf(list.get(i).getMonthPost()));
			jsonobj.put("monthVisit", String.valueOf(list.get(i).getMonthVisit()));
			jsonobj.put("monthPuppy", String.valueOf(list.get(i).getMonthPuppy()));
			jsonobj.put("monthUser", String.valueOf(list.get(i).getMonthUser()));
			
			jsonobj.put("month1Post", String.valueOf(list.get(i).getMonth1Post()));
			jsonobj.put("month1Visit", String.valueOf(list.get(i).getMonth1Visit()));
			jsonobj.put("month1Puppy", String.valueOf(list.get(i).getMonth1Puppy()));
			jsonobj.put("month1User", String.valueOf(list.get(i).getMonth1User()));
			
			jsonobj.put("month2Post", String.valueOf(list.get(i).getMonth2Post()));
			jsonobj.put("month2Visit", String.valueOf(list.get(i).getMonth2Visit()));
			jsonobj.put("month2Puppy", String.valueOf(list.get(i).getMonth2Puppy()));
			jsonobj.put("month2User", String.valueOf(list.get(i).getMonth2User()));
			
			jsonobj.put("month3Post", String.valueOf(list.get(i).getMonth3Post()));
			jsonobj.put("month3Visit", String.valueOf(list.get(i).getMonth3Visit()));
			jsonobj.put("month3Puppy", String.valueOf(list.get(i).getMonth3Puppy()));
			jsonobj.put("month3User", String.valueOf(list.get(i).getMonth3User()));
						
			jsonobj.put("month4Post", String.valueOf(list.get(i).getMonth4Post()));
			jsonobj.put("month4Visit", String.valueOf(list.get(i).getMonth4Visit()));
			jsonobj.put("month4Puppy", String.valueOf(list.get(i).getMonth4Puppy()));
			jsonobj.put("month4User", String.valueOf(list.get(i).getMonth4User()));
			
			jsonobj.put("month5Post", String.valueOf(list.get(i).getMonth5Post()));
			jsonobj.put("month5Visit", String.valueOf(list.get(i).getMonth5Visit()));
			jsonobj.put("month5Puppy", String.valueOf(list.get(i).getMonth5Puppy()));
			jsonobj.put("month5User", String.valueOf(list.get(i).getMonth5User()));
			
			jsonarray.add(jsonobj);
		}
		*/
		JSONObject jsonobj = new JSONObject();
		
		jsonobj.put("allPost", String.valueOf(admin.getAllPost()));
		jsonobj.put("allVisit", String.valueOf(admin.getAllVisit()));
		jsonobj.put("allPuppy", String.valueOf(admin.getAllPuppy()));
		jsonobj.put("allUser", String.valueOf(admin.getAllUser()));
		
		jsonobj.put("todayPost", String.valueOf(admin.getTodayPost()));
		jsonobj.put("todayVisit", String.valueOf(admin.getTodayVisit()));
		jsonobj.put("todayPuppy", String.valueOf(admin.getTodayPuppy()));
		jsonobj.put("todayUser", String.valueOf(admin.getTodayUser()));
		
		jsonobj.put("monthPost", String.valueOf(admin.getMonthPost()));
		jsonobj.put("monthVisit", String.valueOf(admin.getMonthVisit()));
		jsonobj.put("monthPuppy", String.valueOf(admin.getMonthPuppy()));
		jsonobj.put("monthUser", String.valueOf(admin.getMonthUser()));
		
		jsonobj.put("monthPost", String.valueOf(admin.getMonthPost()));
		jsonobj.put("monthVisit", String.valueOf(admin.getMonthVisit()));
		jsonobj.put("monthPuppy", String.valueOf(admin.getMonthPuppy()));
		jsonobj.put("monthUser", String.valueOf(admin.getMonthUser()));
		
		jsonobj.put("month1Post", String.valueOf(admin.getMonth1Post()));
		jsonobj.put("month1Visit", String.valueOf(admin.getMonth1Visit()));
		jsonobj.put("month1Puppy", String.valueOf(admin.getMonth1Puppy()));
		jsonobj.put("month1User", String.valueOf(admin.getMonth1User()));
		
		jsonobj.put("month2Post", String.valueOf(admin.getMonth2Post()));
		jsonobj.put("month2Visit", String.valueOf(admin.getMonth2Visit()));
		jsonobj.put("month2Puppy", String.valueOf(admin.getMonth2Puppy()));
		jsonobj.put("month2User", String.valueOf(admin.getMonth2User()));
		
		jsonobj.put("month3Post", String.valueOf(admin.getMonth3Post()));
		jsonobj.put("month3Visit", String.valueOf(admin.getMonth3Visit()));
		jsonobj.put("month3Puppy", String.valueOf(admin.getMonth3Puppy()));
		jsonobj.put("month3User", String.valueOf(admin.getMonth3User()));
					
		jsonobj.put("month4Post", String.valueOf(admin.getMonth4Post()));
		jsonobj.put("month4Visit", String.valueOf(admin.getMonth4Visit()));
		jsonobj.put("month4Puppy", String.valueOf(admin.getMonth4Puppy()));
		jsonobj.put("month4User", String.valueOf(admin.getMonth4User()));
		
		jsonobj.put("month5Post", String.valueOf(admin.getMonth5Post()));
		jsonobj.put("month5Visit", String.valueOf(admin.getMonth5Visit()));
		jsonobj.put("month5Puppy", String.valueOf(admin.getMonth5Puppy()));
		jsonobj.put("month5User", String.valueOf(admin.getMonth5User()));
		jsonarray.add(jsonobj);
		
		System.out.println(jsonarray);
		NextPage nextPage = new NextPage(); // 다음url 객체
		
		if (jsonarray != null) {
			request.getSession().setAttribute("json", jsonarray);
			nextPage.setPageName("./adminindex.jsp");
			nextPage.setRedirect(true);
		}
		else {
			request.setAttribute("errorMSG", "오류발생");
			nextPage.setPageName("./error.jsp");
			nextPage.setRedirect(false);
		}
		
		PrintWriter out = null;
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(jsonarray);
		
		return null;
	}
}

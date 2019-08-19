package action;

import java.text.SimpleDateFormat;
import java.util.List;

import entity.Students;
import service.StudentsDAO;
import service.impl.StudentsDAOImpl;

// 学生Action类,处理对应的请求和业务逻辑
public class StudentsAction extends SuperAction{

	private static final long serialVersionUID = 1L;
	private Students student = new Students();
	
	//查询所有学生的动作
	public String query(){
		StudentsDAO sdao = new StudentsDAOImpl();
		List<Students> list = sdao.queryAllStudents();
		if(list!=null && list.size()>0){
			// 将查询到的学生信息存入session
			session.setAttribute("students_list", list);
		}
		return "query_success";
	}
	
	//删除学生动作
	public String delete(){
		StudentsDAO sdao = new StudentsDAOImpl();
		String sid = request.getParameter("sid");
		sdao.deleteStudents(sid);
		return "delete_success";
	}
	
	//添加学生资料
	public String add() throws Exception{
		Students s = new Students();
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDAO sdao = new StudentsDAOImpl();
		sdao.addStudents(s);
		return "add_success";	
	}
	
	//修改学生资料
	public String modify(){
		String sid = request.getParameter("sid");
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = sdao.queryStudentsBySid(sid);
		
		session.setAttribute("modify_students", s);
		return "modify_success";
	}
	
	//保存
	public String save() throws Exception{
		Students s = new Students();
		s.setSid(request.getParameter("sid"));
		s.setSname(request.getParameter("sname"));
		s.setGender(request.getParameter("gender"));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");
		s.setBirthday(sdf.parse(request.getParameter("birthday")));
		s.setAddress(request.getParameter("address"));
		StudentsDAO sdao = new StudentsDAOImpl();
		sdao.updateStudents(s);
		return "save_success";
	}
	
	//根据学号查询学生信息
	public String queryBySid(){
		String sid = request.getParameter("sid");
		StudentsDAO sdao = new StudentsDAOImpl();
		Students s = sdao.queryStudentsBySid(sid);
		if(s != null){
			session.setAttribute("students_query", s);
			return "queryBySid_success";
		}
		session.setAttribute("Sid", sid);
		return "queryBySid_failure";
	}

	public Students getModel() {
		// TODO Auto-generated method stub
		return null;
	}		
}
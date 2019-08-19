package service.impl;

import java.util.List;

import org.junit.Test;

import entity.Students;
import service.StudentsDAO;


// StudentDAO的单元测试,输出学生信息
public class TestStudentsDAOImpl {
	
	@Test
	public void testQueryAllStudents(){
		 StudentsDAO sdao = new StudentsDAOImpl();
		 List<Students> list = sdao.queryAllStudents();
		 for(int i=0; i < list.size(); i++){
			 System.out.println(list.get(i));
		 }
	}
}

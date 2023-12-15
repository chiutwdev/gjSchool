package dao;

import java.util.List;
import model.student;

public interface studentDao {
	//create
	//void add(String name,int chi,int eng);
	void add(student s);   //<=== 不用上面 一個個:參數帶入
	
	//read
	String queryAll1();
	List<student> queryAll2();
	
	
	//update
	
	
	//delete

}

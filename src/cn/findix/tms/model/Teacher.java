package cn.findix.tms.model;

import com.jfinal.plugin.activerecord.Model;

import java.util.List;

/**
 * Created by Sean on 2014/11/27.
 */
public class Teacher extends Model<Teacher> {
    public static final Teacher DAO = new Teacher();

    public String getDepartmentName() {
        return Department.DAO.findById(get("did")).get("dname");
    }

    public boolean isExisted(String id, String password) {
        String sql = "select tname from Teacher where tid=? and password=?";
        return DAO.findFirst(sql, id, password) != null;
    }

    public List<Teacher> findAll() {
        return find("SELECT teacher.tid, teacher.tname, teacher.`password`, teacher.type, teacher.did, department.dname, auth.aname FROM teacher, department, auth WHERE teacher.did = department.did AND teacher.type = auth.type ORDER BY teacher.tid ASC");
    }
}

package com.hellobbs.Cms;

import com.hellobbs.database.Permission;
import com.hellobbs.database.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cms")
public class Cmscontrollerpermiss {

    @Autowired
    SqlSession sqlSession;

    @GetMapping("/changeroles/{id}")
    public String changeroles(@PathVariable int id,Map<String,Object>map) {
        User getuser = sqlSession.selectOne("cms.getoneuser",id);
        map.put("getuser",getuser);
        return "cms_changuser";
    }

    @PostMapping("/changeroles")
    public String postchangeroles(String userroles) {
        User user = new User();
        user.setId(5);
        user.setUserroles(userroles);
        sqlSession.update("cms.updateoneuser",user);
        return "isokcms";
    }


    @GetMapping("/getalluser")
    public String getalluser(Map<String,Object>map) {
        List<Permission> getalluser = sqlSession.selectList("cms.getalluser");

        map.put("getalluser",getalluser);
        return "cms_users";
    }


    @GetMapping("/getallpermission")
    public String getallpermission(Map<String,Object>map) {
        List<Permission> getallpermiss = sqlSession.selectList("cms.getallpermission");
        map.put("getallpermiss",getallpermiss);
        return "cms_rolespermiss";
    }

    @PostMapping("/addpermiss")
    public String addpermiss(String userroles,String permission) {
        Permission p = new Permission();
        p.setUserroles(userroles);
        p.setPermissions(permission);
        sqlSession.insert("cms.addpermission",p);
        return "isokcms";
    }

    @GetMapping("/removepermiss/{id}")
    public String removepermiss(@PathVariable int id) {
        sqlSession.delete("cms.removepermiss",id);
        return "isokcms";
    }

    @GetMapping("/changepermiss/{id}")
    public String changepermiss(@PathVariable int id,Map<String,Object>map) {
        Permission permission = sqlSession.selectOne("cms.getonepermiss",id);
        map.put("permission",permission);
        return "cms_changepermiss";
    }

    @PostMapping("/changepermiss")
    public String postchangepermiss(String userroles,String permission) {
        return "cms_changepermiss";
    }


}

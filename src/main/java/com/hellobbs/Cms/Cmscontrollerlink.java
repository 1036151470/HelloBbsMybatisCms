package com.hellobbs.Cms;

import com.hellobbs.database.Forlink;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/cms")
public class Cmscontrollerlink {

    @Autowired
    SqlSession sqlSession;

    @GetMapping("/forlink")
    public String forlink(Map<String, Object> map) {
        List<Forlink> forlink = sqlSession.selectList("cms.forlink");
        map.put("forlink", forlink);
        return "cms_forlink";
    }

    @GetMapping("/delforcmsid/{id}")
    public String delforcmsid(@PathVariable int id) {

        sqlSession.delete("cms.delforcmsid", id);
        return "isokcms";
    }

    @GetMapping("/forlinkadd")
    public String forlinkadd() {

        return "cms_forlinkadd";
    }

    @PostMapping("/forlinkadd")
    public String postforlinkadd(String address, String pics, String name) {
        Forlink forlink = new Forlink();
        forlink.setName(name);
        forlink.setPics(pics);
        forlink.setAddress(address);
        sqlSession.insert("cms.forlinkadd", forlink);
        return "isokcms";
    }
}

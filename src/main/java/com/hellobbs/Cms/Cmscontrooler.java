package com.hellobbs.Cms;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hellobbs.database.Boardcontext;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Controller
@RequestMapping("/cms")
public class Cmscontrooler {

    @Autowired
    SqlSession sqlSession;

    @PostMapping("/edit")
    public String postedit(String dbname,String title, String con){
        System.out.println(dbname);
        System.out.println(title);
        System.out.println(con);
        return "/isokcms";
    }

    @GetMapping("/edit/{dbname}/{id}")
    public String edit(@PathVariable String dbname,@PathVariable int id,Map<String,Object>map){
        Boardcontext boardcontext = new Boardcontext();
        Map<String,Object> mapc = new ConcurrentHashMap<>();
        mapc.put("id",id);
        mapc.put("dbname",dbname);
        boardcontext =  sqlSession.selectOne("cms.edit",mapc);
        map.put(dbname,dbname);
        map.put("context",boardcontext);
        return "cms_wirtedatahtml";
    }

    @RequestMapping("/delid/{dbname}/{id}")
    public String delid(@PathVariable String dbname,@PathVariable int id){
        Map<String,Object> mapc = new ConcurrentHashMap<>();
        mapc.put("id",id);
        mapc.put("dbname",dbname);
        sqlSession.delete("cms.delid",mapc);
        return "cms";
    }

    @RequestMapping("forcomplain/page/{num}")
    public String forcomplainindex(@PathVariable int num, Map<String, Object> map) {
        int page = 0;

        if (num <= 0) {
            return "redirect:/";
        }
        List<Boardcontext> userlist = sqlSession.selectList("forcomplain.getallbbs_everythingtotalk");
        PageInfo<Boardcontext> pageInfo = new PageInfo<Boardcontext>(userlist);
        int basesize = (int) pageInfo.getTotal();


        if (basesize <= 0) {
            return "cms_contexttoorder";
        } else {

            page = 0;

            if (basesize % 20 == 0) {
                page = (int) (basesize / 20);
            } else {

                page = (int) (basesize / 20) + 1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < page; i++) {
            if (i == page) {
                break;
            }
            list.add(page - i);
        }
        PageHelper.startPage(num, 20);

        Iterable<Boardcontext> iterable = sqlSession.selectList("forcomplain.getallbbs_everythingtotalk");
        map.put("context", iterable);
        map.put("list", list);
        map.put("boardname", "/cms/forcomplain/page/");
        map.put("dbname", "bbs_forcomplain");
        return "cms_contexttoorder";
    }

    @GetMapping("/forcomplain")
    public String forcomplain(Map<String, Object> map) {
        List<Boardcontext> userlist = sqlSession.selectList("forcomplain.getallbbs_everythingtotalk");
        PageInfo<Boardcontext> pageInfo = new PageInfo<Boardcontext>(userlist);
        int basesize = (int) pageInfo.getTotal();


        if (basesize <= 0) {
            return "cms_contexttoorder";
        } else {

            int page = 0;

            if (basesize % 20 == 0) {
                page = (int) (basesize / 20);
            } else {

                page = (int) (basesize / 20) + 1;
            }
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < page; i++) {
                if (i == page) {
                    break;
                }
                list.add(page - i);
            }
            PageHelper.startPage(page, 20);
            Iterable<Boardcontext> iterable = sqlSession.selectList("forcomplain.getallbbs_everythingtotalk");
            map.put("context", iterable);
            map.put("list", list);
            map.put("boardname", "/cms/forcomplain/page/");
            map.put("dbname", "bbs_forcomplain");
            return "cms_contexttoorder";
        }
    }

    @RequestMapping("forwindows/page/{num}")
    public String forwindowsindex(@PathVariable int num, Map<String, Object> map) {
        int page = 0;

        if (num <= 0) {
            return "redirect:/";
        }
        List<Boardcontext> userlist = sqlSession.selectList("forwindows.getallbbs_everythingtotalk");
        PageInfo<Boardcontext> pageInfo = new PageInfo<Boardcontext>(userlist);
        int basesize = (int) pageInfo.getTotal();


        if (basesize <= 0) {
            return "cms_contexttoorder";
        } else {

            page = 0;

            if (basesize % 20 == 0) {
                page = (int) (basesize / 20);
            } else {

                page = (int) (basesize / 20) + 1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < page; i++) {
            if (i == page) {
                break;
            }
            list.add(page - i);
        }
        PageHelper.startPage(num, 20);

        Iterable<Boardcontext> iterable = sqlSession.selectList("forwindows.getallbbs_everythingtotalk");
        map.put("context", iterable);
        map.put("list", list);
        map.put("boardname", "/cms/forwindows/page/");
        map.put("dbname", "bbs_forwindows");
        return "cms_contexttoorder";
    }

    @GetMapping("/forwindows")
    public String forwindows(Map<String, Object> map) {
        List<Boardcontext> userlist = sqlSession.selectList("forwindows.getallbbs_everythingtotalk");
        PageInfo<Boardcontext> pageInfo = new PageInfo<Boardcontext>(userlist);
        int basesize = (int) pageInfo.getTotal();


        if (basesize <= 0) {
            return "cms_contexttoorder";
        } else {

            int page = 0;

            if (basesize % 20 == 0) {
                page = (int) (basesize / 20);
            } else {

                page = (int) (basesize / 20) + 1;
            }
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < page; i++) {
                if (i == page) {
                    break;
                }
                list.add(page - i);
            }
            PageHelper.startPage(page, 20);
            Iterable<Boardcontext> iterable = sqlSession.selectList("forwindows.getallbbs_everythingtotalk");
            map.put("context", iterable);
            map.put("list", list);
            map.put("boardname", "/cms/forwindows/page/");
            map.put("dbname", "bbs_forwindows");
            return "cms_contexttoorder";
        }
    }

    @RequestMapping("forweb/page/{num}")
    public String forwebindex(@PathVariable int num, Map<String, Object> map) {
        int page = 0;

        if (num <= 0) {
            return "redirect:/";
        }
        List<Boardcontext> userlist = sqlSession.selectList("forweb.getallbbs_everythingtotalk");
        PageInfo<Boardcontext> pageInfo = new PageInfo<Boardcontext>(userlist);
        int basesize = (int) pageInfo.getTotal();


        if (basesize <= 0) {
            return "cms_contexttoorder";
        } else {

            page = 0;

            if (basesize % 20 == 0) {
                page = (int) (basesize / 20);
            } else {

                page = (int) (basesize / 20) + 1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < page; i++) {
            if (i == page) {
                break;
            }
            list.add(page - i);
        }
        PageHelper.startPage(num, 20);

        Iterable<Boardcontext> iterable = sqlSession.selectList("forweb.getallbbs_everythingtotalk");
        map.put("context", iterable);
        map.put("list", list);
        map.put("boardname", "/cms/forweb/page/");
        map.put("dbname", "bbs_forweb");
        return "cms_contexttoorder";
    }

    @GetMapping("/forweb")
    public String forweb(Map<String, Object> map) {
        List<Boardcontext> userlist = sqlSession.selectList("forweb.getallbbs_everythingtotalk");
        PageInfo<Boardcontext> pageInfo = new PageInfo<Boardcontext>(userlist);
        int basesize = (int) pageInfo.getTotal();


        if (basesize <= 0) {
            return "cms_contexttoorder";
        } else {

            int page = 0;

            if (basesize % 20 == 0) {
                page = (int) (basesize / 20);
            } else {

                page = (int) (basesize / 20) + 1;
            }
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < page; i++) {
                if (i == page) {
                    break;
                }
                list.add(page - i);
            }
            PageHelper.startPage(page, 20);
            Iterable<Boardcontext> iterable = sqlSession.selectList("forweb.getallbbs_everythingtotalk");
            map.put("context", iterable);
            map.put("list", list);
            map.put("boardname", "/cms/forweb/page/");
            map.put("dbname", "bbs_forweb");
            return "cms_contexttoorder";
        }
    }

    @RequestMapping("forandroid/page/{num}")
    public String forandroidindex(@PathVariable int num, Map<String, Object> map) {
        int page = 0;

        if (num <= 0) {
            return "redirect:/";
        }
        List<Boardcontext> userlist = sqlSession.selectList("forandroid.getallbbs_everythingtotalk");
        PageInfo<Boardcontext> pageInfo = new PageInfo<Boardcontext>(userlist);
        int basesize = (int) pageInfo.getTotal();


        if (basesize <= 0) {
            return "cms_contexttoorder";
        } else {

            page = 0;

            if (basesize % 20 == 0) {
                page = (int) (basesize / 20);
            } else {

                page = (int) (basesize / 20) + 1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < page; i++) {
            if (i == page) {
                break;
            }
            list.add(page - i);
        }
        PageHelper.startPage(num, 20);

        Iterable<Boardcontext> iterable = sqlSession.selectList("forandroid.getallbbs_everythingtotalk");
        map.put("context", iterable);
        map.put("list", list);
        map.put("boardname", "/cms/forandroid/page/");
        map.put("dbname", "bbs_forandroid");
        return "cms_contexttoorder";
    }

    @GetMapping("/forandroid")
    public String forandroid(Map<String, Object> map) {
        List<Boardcontext> userlist = sqlSession.selectList("forandroid.getallbbs_everythingtotalk");
        PageInfo<Boardcontext> pageInfo = new PageInfo<Boardcontext>(userlist);
        int basesize = (int) pageInfo.getTotal();


        if (basesize <= 0) {
            return "cms_contexttoorder";
        } else {

            int page = 0;

            if (basesize % 20 == 0) {
                page = (int) (basesize / 20);
            } else {

                page = (int) (basesize / 20) + 1;
            }
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < page; i++) {
                if (i == page) {
                    break;
                }
                list.add(page - i);
            }
            PageHelper.startPage(page, 20);
            Iterable<Boardcontext> iterable = sqlSession.selectList("forandroid.getallbbs_everythingtotalk");
            map.put("context", iterable);
            map.put("list", list);
            map.put("boardname", "/cms/forandroid/page/");
            map.put("dbname", "bbs_forandroid");
            return "cms_contexttoorder";
        }
    }

    @RequestMapping("codetoshare/page/{num}")
    public String codetoshareindex(@PathVariable int num, Map<String, Object> map) {
        int page = 0;

        if (num <= 0) {
            return "redirect:/";
        }
        List<Boardcontext> userlist = sqlSession.selectList("codetoshare.getallbbs_everythingtotalk");
        PageInfo<Boardcontext> pageInfo = new PageInfo<Boardcontext>(userlist);
        int basesize = (int) pageInfo.getTotal();


        if (basesize <= 0) {
            return "cms_contexttoorder";
        } else {

            page = 0;

            if (basesize % 20 == 0) {
                page = (int) (basesize / 20);
            } else {

                page = (int) (basesize / 20) + 1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < page; i++) {
            if (i == page) {
                break;
            }
            list.add(page - i);
        }
        PageHelper.startPage(num, 20);

        Iterable<Boardcontext> iterable = sqlSession.selectList("codetoshare.getallbbs_everythingtotalk");
        map.put("context", iterable);
        map.put("list", list);
        map.put("boardname", "/cms/codetoshare/page/");
        map.put("dbname", "bbs_codetoshare");
        return "cms_contexttoorder";
    }

    @GetMapping("/codetoshare")
    public String codetoshare(Map<String, Object> map) {
        List<Boardcontext> userlist = sqlSession.selectList("codetoshare.getallbbs_everythingtotalk");
        PageInfo<Boardcontext> pageInfo = new PageInfo<Boardcontext>(userlist);
        int basesize = (int) pageInfo.getTotal();


        if (basesize <= 0) {
            return "cms_contexttoorder";
        } else {

            int page = 0;

            if (basesize % 20 == 0) {
                page = (int) (basesize / 20);
            } else {

                page = (int) (basesize / 20) + 1;
            }
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < page; i++) {
                if (i == page) {
                    break;
                }
                list.add(page - i);
            }
            PageHelper.startPage(page, 20);
            Iterable<Boardcontext> iterable = sqlSession.selectList("codetoshare.getallbbs_everythingtotalk");
            map.put("context", iterable);
            map.put("list", list);
            map.put("boardname", "/cms/codetoshare/page/");
            map.put("dbname", "bbs_codetoshare");
            return "cms_contexttoorder";
        }
    }

    @RequestMapping("learnfromothers/page/{num}")
    public String learnfromothersindex(@PathVariable int num, Map<String, Object> map) {
        int page = 0;

        if (num <= 0) {
            return "redirect:/";
        }
        List<Boardcontext> userlist = sqlSession.selectList("learnfromothers.getallbbs_everythingtotalk");
        PageInfo<Boardcontext> pageInfo = new PageInfo<Boardcontext>(userlist);
        int basesize = (int) pageInfo.getTotal();


        if (basesize <= 0) {
            return "cms_contexttoorder";
        } else {

            page = 0;

            if (basesize % 20 == 0) {
                page = (int) (basesize / 20);
            } else {

                page = (int) (basesize / 20) + 1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < page; i++) {
            if (i == page) {
                break;
            }
            list.add(page - i);
        }
        PageHelper.startPage(num, 20);

        Iterable<Boardcontext> iterable = sqlSession.selectList("learnfromothers.getallbbs_everythingtotalk");
        map.put("context", iterable);
        map.put("list", list);
        map.put("boardname", "/cms/learnfromothers/page/");
        map.put("dbname", "bbs_learnfromothers");
        return "cms_contexttoorder";
    }

    @GetMapping("/learnfromothers")
    public String learnfromothers(Map<String, Object> map) {
        List<Boardcontext> userlist = sqlSession.selectList("learnfromothers.getallbbs_everythingtotalk");
        PageInfo<Boardcontext> pageInfo = new PageInfo<Boardcontext>(userlist);
        int basesize = (int) pageInfo.getTotal();


        if (basesize <= 0) {
            return "cms_contexttoorder";
        } else {

            int page = 0;

            if (basesize % 20 == 0) {
                page = (int) (basesize / 20);
            } else {

                page = (int) (basesize / 20) + 1;
            }
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < page; i++) {
                if (i == page) {
                    break;
                }
                list.add(page - i);
            }
            PageHelper.startPage(page, 20);
            Iterable<Boardcontext> iterable = sqlSession.selectList("learnfromothers.getallbbs_everythingtotalk");
            map.put("context", iterable);
            map.put("list", list);
            map.put("boardname", "/cms/learnfromothers/page/");
            map.put("dbname", "bbs_learnfromothers");
            return "cms_contexttoorder";
        }
    }

    @RequestMapping("everythingtotalk/page/{num}")
    public String index(@PathVariable int num, Map<String, Object> map) {
        int page = 0;

        if (num <= 0) {
            return "redirect:/";
        }
        List<Boardcontext> userlist = sqlSession.selectList("everythingtotalk.getallbbs_everythingtotalk");
        PageInfo<Boardcontext> pageInfo = new PageInfo<Boardcontext>(userlist);
        int basesize = (int) pageInfo.getTotal();


        if (basesize <= 0) {
            return "cms_contexttoorder";
        } else {

            page = 0;

            if (basesize % 20 == 0) {
                page = (int) (basesize / 20);
            } else {

                page = (int) (basesize / 20) + 1;
            }
        }
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < page; i++) {
            if (i == page) {
                break;
            }
            list.add(page - i);
        }
        PageHelper.startPage(num, 20);

        Iterable<Boardcontext> iterable = sqlSession.selectList("everythingtotalk.getallbbs_everythingtotalk");
        map.put("context", iterable);
        map.put("list", list);
        map.put("boardname", "/cms/everythingtotalk/page/");
        map.put("dbname", "bbs_everythingtotalk");
        return "cms_contexttoorder";
    }

    @GetMapping("/everythingtotalk")
    public String everythingtotalk(Map<String, Object> map) {
        List<Boardcontext> userlist = sqlSession.selectList("everythingtotalk.getallbbs_everythingtotalk");
        PageInfo<Boardcontext> pageInfo = new PageInfo<Boardcontext>(userlist);
        int basesize = (int) pageInfo.getTotal();


        if (basesize <= 0) {
            return "cms_contexttoorder";
        } else {

            int page = 0;

            if (basesize % 20 == 0) {
                page = (int) (basesize / 20);
            } else {

                page = (int) (basesize / 20) + 1;
            }
            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < page; i++) {
                if (i == page) {
                    break;
                }
                list.add(page - i);
            }
            PageHelper.startPage(page, 20);
            Iterable<Boardcontext> iterable = sqlSession.selectList("everythingtotalk.getallbbs_everythingtotalk");
            map.put("context", iterable);
            map.put("list", list);
            map.put("boardname", "/cms/everythingtotalk/page/");
            map.put("dbname", "bbs_everythingtotalk");
            return "cms_contexttoorder";
        }
    }

    @GetMapping({"/", "/index"})
    public String cms() {
        return "cms";
    }


}

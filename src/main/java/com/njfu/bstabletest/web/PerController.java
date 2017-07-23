package com.njfu.bstabletest.web;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.njfu.bstabletest.domain.Per;
import com.njfu.bstabletest.service.PerService;
import com.njfu.bstabletest.util.Message;
import com.njfu.bstabletest.util.PaginationResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PerController {

    @Autowired
    private PerService perService;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/getPers")
    public @ResponseBody
    PaginationResult getPers(int offset, int limit, String name, String age) {
        Page<Object> page = PageHelper.offsetPage(offset, limit);
        List<Per> pers = perService.getPers(name, age);
        return new PaginationResult(page.getTotal(), pers);
    }

    @PostMapping("/addPer")
    public @ResponseBody
    Message addPer(String name, String age, String address) {
        return perService.addPer(name, age, address);
    }

    @PostMapping("/delPer")
    public @ResponseBody
    Message delPer(Integer id) {
        return perService.removePerById(id);
    }

    @PostMapping("/modifyPer")
    public @ResponseBody
    Message modifyPer(Integer id, String name, String age, String address) {
        return perService.modifyPer(id, name, age, address);
    }
}

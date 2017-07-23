package com.njfu.bstabletest.service.impl;

import com.njfu.bstabletest.domain.Per;
import com.njfu.bstabletest.mapper.PerMapper;
import com.njfu.bstabletest.service.PerService;
import com.njfu.bstabletest.util.Message;
import com.njfu.bstabletest.util.MessageEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerServiceImpl implements PerService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private PerMapper perMapper;

    /**
     * 用于将输入的年龄查询条件进行转换
     * @param ageStr
     * @param per
     * @return 返回转换结果信息
     */
    private Message convertAgeStr(String ageStr, Per per) {
        Message msg = null;
        try {
            Integer age = Integer.parseInt(ageStr);
            per.setAge(age);
            msg = new Message(MessageEnum.SUCCESS.getCode());
        } catch (NumberFormatException e) {
            log.error("条件转换失败，e = {}", e.getMessage());
            msg =  new Message(MessageEnum.FAIL.getCode(), "年龄填写有误，操作失败！");
        }
        return msg;
    }


    @Override
    public List<Per> getPers(String name, String ageStr) {
        Per per = new Per();
        per.setName(name.trim());

        if (ageStr.length() != 0) {
            Message msg = convertAgeStr(ageStr, per);
            // 返回转换失败信息向前端bootstrap-table返回空List，否则会出错
            // 在本例的页面中对年龄输入已经做了正则校验
            if (msg.getCode() == MessageEnum.FAIL.getCode()) {
                return new ArrayList<Per>();
            }
        }
        return perMapper.selectPers(per);
    }

    @Override
    public Message<Per> addPer(String name, String ageStr, String address) {
        Message msg = null;
        Per per = new Per();
        per.setName(name.trim());
        per.setAddress(address);

        Message convertMessage = convertAgeStr(ageStr, per);
        if (convertMessage.getCode() == MessageEnum.FAIL.getCode()) {
            msg = convertMessage;
        } else {
            int rowCount = perMapper.insertPer(per);
            if (rowCount == 0) {
                msg = new Message(MessageEnum.FAIL.getCode(), "新增失败！");
            } else {
                msg = new Message(MessageEnum.SUCCESS.getCode(), "新增成功！");
            }
        }

        return msg;
    }

    @Override
    public Message<Per> modifyPer(Integer id, String name, String ageStr, String address) {
        Message msg = null;
        Per per = new Per();
        per.setId(id);
        per.setName(name.trim());
        per.setAddress(address);

        Message convertMessage = convertAgeStr(ageStr, per);
        if (convertMessage.getCode() == MessageEnum.FAIL.getCode()) {
            msg = convertMessage;
        } else {
            int rowCount = perMapper.updatePer(per);
            if (rowCount == 0) {
                msg = new Message(MessageEnum.FAIL.getCode(), "修改失败！");
            } else {
                msg = new Message(MessageEnum.SUCCESS.getCode(), "修改成功！");
            }
        }

        return msg;
    }

    @Override
    public Message<Per> removePerById(Integer id) {
        Message msg = null;
        int rowCount = perMapper.deletePerById(id);
        if (rowCount == 0) {
            msg = new Message(MessageEnum.FAIL.getCode(), "删除失败！");
        }else {
            msg = new Message(MessageEnum.SUCCESS.getCode(), "删除成功！");
        }
        return msg;
    }

}

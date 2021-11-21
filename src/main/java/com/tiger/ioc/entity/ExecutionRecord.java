package com.tiger.ioc.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.tiger.ioc.annotation.Autowired;
import com.tiger.ioc.annotation.Component;
import com.tiger.ioc.annotation.Value;

import java.util.Date;

/**
 * @author youxuehu
 * @version v1.0
 * @className ExecutionRecord
 * @date 2021/11/7 7:31 下午
 * @desrription 这是类的描述信息
 */
@Component
public class ExecutionRecord extends ToString {

    @Value("1")
    private Long id;

    @Value("10")
    private Long experimentId;

    @Value("42")
    private Integer type;

    @Value("WB520289")
    private String owner;

    @JSONField(format="yyyy-MM-dd HH:mm:ss.SSS")
    @Value("2021-11-21 11:54:03")
    private Date gmtCreate;

    @Value("2021-11-21 11:54:03")
    @JSONField(format="yyyy-MM-dd HH:mm:ss.SSS")
    private Date gmtUpdate;

    @Value("2021-11-21 11:54:03")
    @JSONField(format="yyyy-MM-dd HH:mm:ss.SSS")
    private Date gmtDelete;

    @Value("false")
    private Boolean isDeleted;

    @Autowired
    private Person person;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getExperimentId() {
        return experimentId;
    }

    public void setExperimentId(Long experimentId) {
        this.experimentId = experimentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtUpdate() {
        return gmtUpdate;
    }

    public void setGmtUpdate(Date gmtUpdate) {
        this.gmtUpdate = gmtUpdate;
    }

    public Date getGmtDelete() {
        return gmtDelete;
    }

    public void setGmtDelete(Date gmtDelete) {
        this.gmtDelete = gmtDelete;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}


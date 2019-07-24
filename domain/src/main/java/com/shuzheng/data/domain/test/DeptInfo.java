package com.shuzheng.data.domain.test;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author : JavierWang
 * @Date : Created in 13:42 2019-07-20
 * @Description : dept_info表实体类
 * @Version : 0.0.1-SNAPSHOT
 */
@Entity
@Table(name = "dept_info")
public class DeptInfo {
    @Id
    @Column(name = "id", nullable = false, unique = true)
    @GeneratedValue
    private Integer id;
    @Column(name = "orgcoding")
    private String orgCoding;
    @Column(name = "dept_short_name")
    private String deptShortName;
    @Column(name = "dept_name")
    private String deptName;
    @Column(name = "maxOccurs")
    private String maxOccurs;
    @Column(name = "linked_man")
    private String linkedMan;
    @Column(name = "linked_tel")
    private String linkedTel;
    @Column(name = "create_time")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgcoding() {
        return orgCoding;
    }

    public void setOrgcoding(String orgCoding) {
        this.orgCoding = orgCoding;
    }

    public String getDeptShortName() {
        return deptShortName;
    }

    public void setDeptShortName(String deptShortName) {
        this.deptShortName = deptShortName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getMaxOccurs() {
        return maxOccurs;
    }

    public void setMaxOccurs(String maxOccurs) {
        this.maxOccurs = maxOccurs;
    }

    public String getLinkedMan() {
        return linkedMan;
    }

    public void setLinkedMan(String linkedMan) {
        this.linkedMan = linkedMan;
    }

    public String getLinkedTel() {
        return linkedTel;
    }

    public void setLinkedTel(String linkedTel) {
        this.linkedTel = linkedTel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "DeptInfo{" +
                "id=" + id +
                ", orgCoding='" + orgCoding + '\'' +
                ", deptShortName='" + deptShortName + '\'' +
                ", deptName='" + deptName + '\'' +
                ", maxOccurs='" + maxOccurs + '\'' +
                ", linkedMan='" + linkedMan + '\'' +
                ", linkedTel='" + linkedTel + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

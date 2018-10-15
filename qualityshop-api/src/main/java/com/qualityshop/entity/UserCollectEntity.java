package com.qualityshop.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * 收藏接口
 *
 * @author huojg
 */
@TableName("user_collect")
public class UserCollectEntity implements Serializable{
    /**
     * 收藏ID
     */
    @TableId
    private String id;

    /**
     * 用户Id
     */
    private String user_id;

    /**
     * 项目Id
     */
    private String project_id;

    /**
     * 用户名
     */
    private String user_name;

    /**
     * 收藏内容
     */

    private  String collect_message;

    /**
     * 收藏状态
     */

    private String state;

    /***
     *
     * 收藏时间
     */

    private Date create_time;
    private String collect_name;
    private String collect_price;
    private String collect_nubmer;

    private String product_img;
    private String product_tab;
    private String product_price;
    private String product_resouce;
    //收集虚拟字段
    private String[] product_tabs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getProject_id() {
        return project_id;
    }

    public void setProject_id(String project_id) {
        this.project_id = project_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getCollect_message() {
        return collect_message;
    }

    public void setCollect_message(String collect_message) {
        this.collect_message = collect_message;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getCollect_name() {
        return collect_name;
    }

    public void setCollect_name(String collect_name) {
        this.collect_name = collect_name;
    }

    public String getCollect_price() {
        return collect_price;
    }

    public void setCollect_price(String collect_price) {
        this.collect_price = collect_price;
    }

    public String getCollect_nubmer() {
        return collect_nubmer;
    }

    public void setCollect_nubmer(String collect_nubmer) {
        this.collect_nubmer = collect_nubmer;
    }

    public String getProduct_img() {
        return product_img;
    }

    public void setProduct_img(String product_img) {
        this.product_img = product_img;
    }

    public String getProduct_tab() {
        return product_tab;
    }

    public void setProduct_tab(String product_tab) {
        this.product_tab = product_tab;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_resouce() {
        return product_resouce;
    }

    public void setProduct_resouce(String product_resouce) {
        this.product_resouce = product_resouce;
    }

    public String[] getProduct_tabs() {
        return product_tabs;
    }

    public void setProduct_tabs(String[] product_tabs) {
        this.product_tabs = product_tabs;
    }
}

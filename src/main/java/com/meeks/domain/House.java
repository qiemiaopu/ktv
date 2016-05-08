package com.meeks.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 包房
 */
public class House {
    /** 空 */
    public static final int EMPTY = 0;
    /** 使用中 */
    public static final int USING = 1;
    /** 快到期 */
    public static final int EXPIRE = 2;
    /** 打扫中 */
    public static final int CLEANING = 3;
    /** 被预定 */
    public static final int RESERVED = 4;

    private Integer id;
	private String name;
    private Integer type;//[1:小包,2:中包,3:大包,4:豪包]
    private Double value;
    private Integer discount;//折扣

    private Date startTime;
    private Date endTime;
    private Integer status;//[0:空,1:使用中,2:快到期,3:打扫中,4:被预定]
    private String action1;

    private Set<Reserve> reserves = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAction1() {
        return action1;
    }

    public void setAction1(String action1) {
        this.action1 = action1;
    }

    public Set<Reserve> getReserves() {
        return reserves;
    }

    public void setReserves(Set<Reserve> reserves) {
        this.reserves = reserves;
    }
}

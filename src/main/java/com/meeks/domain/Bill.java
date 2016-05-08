package com.meeks.domain;

import java.util.Date;

/**
 * 账单
 */
public class Bill {
    private Long id;
    private Date createDate;
    private Double value;
    private String description;

    public Bill() {
    }

    public Bill(Double value, String description) {
        this.value = value;
        this.description = description;
        this.createDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

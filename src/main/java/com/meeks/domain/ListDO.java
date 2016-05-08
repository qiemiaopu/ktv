package com.meeks.domain;

import java.util.List;

/**
 * Created by maple on 16/4/16.
 */
public class ListDO {
    private List beans;

    public ListDO(List beans) {
        this.beans = beans;
    }

    public List getBeans() {
        return beans;
    }

    public void setBeans(List beans) {
        this.beans = beans;
    }
}

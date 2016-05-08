package com.meeks.view.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.meeks.base.BaseAction;
import com.meeks.domain.Bill;
import com.meeks.util.QueryHelper;

@Controller
@Scope("prototype")
public class BillAction extends BaseAction<Bill> {

    /**
     * 列表
     */
    public String list() throws Exception {
        new QueryHelper(Bill.class, "r")//
                .push(billService);
        return "list";
    }

}

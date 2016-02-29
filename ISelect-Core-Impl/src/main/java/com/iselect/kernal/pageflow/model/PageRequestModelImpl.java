/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.model;

import com.iselect.kernal.pageflow.entity.PageRequestEntityImpl;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

/**
 *
 * @author Hiep
 */
@NamedQueries({
    @NamedQuery(name=PageRequestModel.QUERY_BY_PATH_METHOD,
            query="FROM PageRequestModelImpl WHERE actionPath=:"+PageRequestModel.PARAM_ACTION_PATH +" AND actionMethod=:"+PageRequestModel.PARAM_ACTION_METHOD),
    @NamedQuery(name=PageRequestModel.QUERY_BY_STATUSFLAG,
            query="FROM PageRequestModelImpl WHERE statusFlag=:"+PageRequestModel.PARAM_VFLAG)
})
public class PageRequestModelImpl
        extends PageRequestEntityImpl<PageResponseModelImpl>
        implements PageRequestModel<PageResponseModelImpl> {

    public PageRequestModelImpl() {
    }
    
    public PageRequestModelImpl(Long id) {
        this.id=id;
    }

}

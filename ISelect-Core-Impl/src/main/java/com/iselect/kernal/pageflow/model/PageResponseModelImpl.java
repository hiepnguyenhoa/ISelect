/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.model;

import com.iselect.kernal.pageflow.entity.PageResponseEntityImpl;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Hiep
 */
@Entity
@Table(name="PAGE_RESPONSE")
@NamedQueries(value={
        @NamedQuery(name=PageResponseModel.QUERY_RESPONSES_BY_STATUS,
                query="FROM PageResponseModelImpl WHERE " + PageResponseModel.PARAM_VFLAG+"=:"+PageResponseModel.PARAM_VFLAG),
        @NamedQuery(name=PageResponseModel.QUERY_RESPONSES_BY_REQUEST_ID,
                query="FROM PageResponseModelImpl WHERE " + PageResponseModel.PARAM_REQUEST+"=:"+PageResponseModel.PARAM_REQUEST)
})
public class PageResponseModelImpl extends PageResponseEntityImpl<PageRequestModelImpl> implements PageResponseModel<PageRequestModelImpl>{

}

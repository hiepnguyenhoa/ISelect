/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.pageflow.service;

import com.iselect.kernal.ISelectService;
import com.iselect.kernal.exception.ISelectException;
import com.iselect.kernal.pageflow.entity.PageFlowRequestType;
import java.util.List;
import com.iselect.kernal.pageflow.dto.PageResponseDto;
import com.iselect.kernal.pageflow.dto.PageRequestDto;

/**
 *
 * @author Hiep
 */
public interface PageFlowService extends ISelectService{
    
    String PREFIX_CLASS="class://";
    
    public void parseControllers(String packName);
    
    /**
     * get all pageflowRequests
     * @return
     * @throws ISelectException 
     */
    public List<? extends PageRequestDto> getPageFlowRequests() throws ISelectException;
    /**
     * get pageflowRequests by type.
     * @param type could be GET,POST, ALL
     * @return
     * @throws ISelectException 
     */
    public List<? extends PageRequestDto> getPageFlowRequests(PageFlowRequestType type)throws ISelectException;
    public List<? extends PageRequestDto> getPageFlowRequestsOrderBySecurityOrder() throws ISelectException;
    
    public PageRequestDto getPageRequest(long id);
    
    public List<? extends PageResponseDto> getPageFlowResponses();
    public List<? extends PageResponseDto> getPageFlowResponses(long requestId);
    public PageRequestDto getPageFlowResponse(long id);

    public void updatePageResponses(PageRequestDto pageflowRequest);
    
    /**
     * To insert a new PageFlowRequestModel into database the function will check whether the model is existing in database.
     * There are three case could happen
     * (1) the model is existing in database, in the case the method will return the model retrieved from database
     * (2) if the model doesn't exist in database, the model will be inserted into database and returned;
     * (3) exception could be thrown.
     * @param requestDto
     * @return PageFlowRequestModelImpl
     * @throws ISelectException 
     */
    public void insertPageFlowRequest(PageRequestDto requestDto) throws ISelectException;
    
    public void insertPageFlowResponse(PageResponseDto responseDto)throws ISelectException;

}

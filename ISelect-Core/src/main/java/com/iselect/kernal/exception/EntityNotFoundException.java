/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iselect.kernal.exception;

/**
 *
 * @author Hiep
 */
public class EntityNotFoundException extends Exception {
    private final String entityId;

    public EntityNotFoundException(String entityId) {
        this.entityId = entityId;
    }

    public EntityNotFoundException(String entityId, String message) {
        super(message);
        this.entityId = entityId;
    }

    public EntityNotFoundException(String entityId, String message, Throwable cause) {
        super(message, cause);
        this.entityId = entityId;
    }

    public EntityNotFoundException(String entityId, Throwable cause) {
        super(cause);
        this.entityId = entityId;
    }

    public EntityNotFoundException(String entityId, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.entityId = entityId;
    }

    public String getEntityId() {
        return entityId;
    }

}

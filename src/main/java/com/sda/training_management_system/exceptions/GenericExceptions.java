package com.sda.training_management_system.exceptions;

public class GenericExceptions extends RuntimeException{
    private final Integer status;
    GenericExceptions(String message, Integer status){
        super(message);
        this.status = status;
    }
    public static GenericExceptions idNotNull() {
    return new GenericExceptions("Id not null", 400);
    }
    public static GenericExceptions idIsNull(){
        return new GenericExceptions("Id is null", 400);
    }
    public static GenericExceptions notFound(Object id){
        return new GenericExceptions(String.format("Record with id %s does not exist", id), 404);
    }
    public static GenericExceptions usernameExist(String usename){
        String message = String.format("Record with username %s exists", usename);
        return new GenericExceptions(message, 400);
    }
    public Integer getStatus(){
        return status;
    }

}

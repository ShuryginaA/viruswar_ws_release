package com.viruswar.server.dto;

public class ClientGameCommandDto {
    
    public String command;
    public Object mutex;
    public String group_name;
    public String status;
    
    public ClientGameCommandDto() {
        mutex = new Object();
    }
}

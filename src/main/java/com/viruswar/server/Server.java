package com.viruswar.server;

import com.viruswar.server.communication.ServerService;

import javax.xml.ws.Endpoint;

public class Server {

    public static final String CROSS_VIRUS = "cross";
    public static final String ROUND_VIRUS = "round";

    public static final String url = "http://localhost:8081/viruswar";

    public static void main(String[] args) {
        ServerService serverService = new ServerService();
        Endpoint.publish(url, serverService);
    }
}

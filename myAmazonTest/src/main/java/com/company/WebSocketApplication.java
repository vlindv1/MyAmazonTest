package com.company;

import com.company.SomeSmallTests;
import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
//import org.graphwalker.websocket.WebSocketListner;
import org.graphwalker.websocket.WebSocketServer;

import java.io.IOException;
import java.net.InetSocketAddress;


public class WebSocketApplication {
    public static void main(String[] args) throws IOException {
        System.out.println("output");
        Executor executor = new TestExecutor(SomeSmallTests.class);
        //WebSocketListner server = new WebSocketListner(new InetSocketAddress("localhost", 9090), executor.getMachine());

        WebSocketServer server = new WebSocketServer(8887, executor.getMachine());

        //server.startService();
        server.start();
        Result result = executor.execute(true);




        if (result.hasErrors()) {
            for (String error : result.getErrors()) {
                System.out.println(error);
            }
        }
        System.out.println("Done: [" + result.getResults().toString(2) + "]");
    }
}

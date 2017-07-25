package com.company;

import com.company.SomeSmallTests;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphwalker.core.event.Observer;
import org.graphwalker.java.test.Executor;
import org.graphwalker.java.test.Result;
import org.graphwalker.java.test.TestExecutor;
import com.company.observers.GraphStreamObserver;
import org.graphstream.graph.Graph;

import java.io.IOException;

public class GraphStreamApplication {
    public static void main(String[] args) throws IOException {
        System.setProperty("org.graphstream.ui.renderer",
                "org.graphstream.ui.j2dviewer.J2DGraphRenderer");
        Graph graph = new SingleGraph("GraphWalker MeetUp");
        graph.display(true);
        Executor executor = new TestExecutor(SomeSmallTests.class);
        Observer observer = new GraphStreamObserver(graph);
        executor.getMachine().addObserver(observer);

        Result result = executor.execute(true);
        if (result.hasErrors()) {
            for (String error : result.getErrors()) {
                System.out.println(error);
            }
        }
        System.out.println("Done: [" + result.getResults().toString(2) + "]");
    }
}

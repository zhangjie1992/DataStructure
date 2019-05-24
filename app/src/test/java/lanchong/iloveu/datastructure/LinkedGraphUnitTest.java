package lanchong.iloveu.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;

import lanchong.iloveu.datastructure.util.LinkedGraph;
import lanchong.iloveu.datastructure.util.MyQueue;

import static org.junit.Assert.assertTrue;

public class LinkedGraphUnitTest {

    private LinkedGraph<Integer> graph;

    @Test
    public void bfs() {
        LinkedGraph<Integer>.Vertex vertex0 = graph.get(0);
        LinkedGraph<Integer>.Vertex target = graph.get(7);
        HashMap<LinkedGraph<Integer>.Vertex, LinkedGraph<Integer>.Vertex> bfs = graph.bfs(vertex0, target);
        if (bfs == null) {
            System.out.println("bfs没找到");
        } else {
            LinkedGraph<Integer>.Vertex curr = target;
            while (curr != null) {
                System.out.println("路径:" + curr.data);
                curr = bfs.get(curr);
            }
        }
    }

    @Test
    public void dfs() {
        LinkedGraph<Integer>.Vertex vertex0 = graph.get(0);
        LinkedGraph<Integer>.Vertex target = graph.get(6);
        HashMap<LinkedGraph<Integer>.Vertex, LinkedGraph<Integer>.Vertex> dfs = graph.dfs(vertex0, target);
        if (dfs == null) {
            System.out.println("dfs没找到");
        } else {
            LinkedGraph<Integer>.Vertex curr = target;
            while (curr != null) {
                System.out.println("路径:" + curr.data);
                curr = dfs.get(curr);
            }
        }
    }




    @Before
    public void init() {
        graph = new LinkedGraph<>();
        for (int i = 0; i < 8; i++) {
            graph.add(i);
        }
        LinkedGraph<Integer>.Vertex vertex0 = graph.get(0);
        LinkedGraph<Integer>.Vertex vertex1 = graph.get(1);
        LinkedGraph<Integer>.Vertex vertex2 = graph.get(2);
        LinkedGraph<Integer>.Vertex vertex3 = graph.get(3);
        LinkedGraph<Integer>.Vertex vertex4 = graph.get(4);
        LinkedGraph<Integer>.Vertex vertex5 = graph.get(5);
        LinkedGraph<Integer>.Vertex vertex6 = graph.get(6);
        LinkedGraph<Integer>.Vertex vertex7 = graph.get(7);
        vertex0.addLinked(vertex1);
        vertex0.addLinked(vertex3);

        vertex1.addLinked(vertex2);
        vertex1.addLinked(vertex4);
        vertex1.addLinked(vertex0);

        vertex2.addLinked(vertex5);
        vertex2.addLinked(vertex1);

        vertex3.addLinked(vertex4);
        vertex3.addLinked(vertex0);

        vertex4.addLinked(vertex1);
        vertex4.addLinked(vertex5);
        vertex4.addLinked(vertex6);
        vertex4.addLinked(vertex3);

        vertex5.addLinked(vertex2);
        vertex5.addLinked(vertex7);
        vertex5.addLinked(vertex4);

        vertex6.addLinked(vertex4);
        vertex6.addLinked(vertex7);

        vertex7.addLinked(vertex5);
        vertex7.addLinked(vertex6);


    }
}

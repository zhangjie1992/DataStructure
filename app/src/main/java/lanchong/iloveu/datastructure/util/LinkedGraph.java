package lanchong.iloveu.datastructure.util;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 图
 * 无相邻接表的实现
 */
public class LinkedGraph<E> {


    /**
     * 顶点个数
     */
    private int size;
    /**
     * 邻接表
     */
    private LinkedList<Vertex> vertexs = new LinkedList<>();


    public void add(E e) {
        Vertex vertex = new Vertex(e);
        vertexs.add(vertex);
        size++;
    }

    public int size() {
        return size;
    }

    public Vertex get(int idx) {
        return vertexs.get(idx);
    }


    /**
     * 广度优先遍历
     */
    public HashMap<Vertex, Vertex> bfs(Vertex src, Vertex target) {
        //是否被访问
        HashSet<Vertex> visited = new HashSet<>(size, 1);
        //搜索路径
        HashMap<Vertex, Vertex> track = new HashMap<>(size, 1);
        //访问队列
        Queue<Vertex> queue = new LinkedList<>();

        queue.add(src);
        track.put(src, null);
        while (!queue.isEmpty()) {
            Vertex poll = queue.poll();
            if (poll == target) {
                //找到了
                return track;
            }
            visited.add(poll);
            for (Vertex vertex : poll.degree) {
                if (visited.contains(vertex) || queue.contains(vertex)) {
                    continue;
                }
                track.put(vertex, poll);
                queue.add(vertex);
            }
        }
        return null;
    }

    /**
     * 深度优先遍历
     */
    public HashMap<Vertex, Vertex> dfs(Vertex src, Vertex target) {
        found = false;
        //是否被访问
        HashSet<Vertex> visited = new HashSet<>(size, 1);
        //搜索路径
        HashMap<Vertex, Vertex> track = new HashMap<>(size, 1);
        track.put(src, null);

        dfsRecursion(visited, track, src, target);

        return track;
    }

    private boolean found;

    private void dfsRecursion(HashSet<Vertex> visited, HashMap<Vertex, Vertex> track, Vertex src, Vertex target) {
        visited.add(src);
        if (src == target) {
            found = true;
            return;
        }
        for (Vertex vertex : src.degree) {
            if (visited.contains(vertex)) {
                continue;
            }
            track.put(vertex, src);
            dfsRecursion(visited, track, vertex, target);
            if (found) {
                return;
            }
        }
    }

    public class Vertex {

        public E data;

        /**
         * 度
         */
        public LinkedList<Vertex> degree;

        public Vertex(E data) {
            this.data = data;
            degree = new LinkedList<>();
        }

        public boolean addLinked(Vertex vertex) {
            if (degree.contains(vertex)) {
                return false;
            }
            return degree.add(vertex);
        }

        public boolean removeLinked(Vertex vertex) {
            return degree.remove(vertex);
        }
    }


}

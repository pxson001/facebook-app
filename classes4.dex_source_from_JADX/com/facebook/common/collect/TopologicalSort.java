package com.facebook.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: fb_object_type */
public class TopologicalSort {

    /* compiled from: fb_object_type */
    public class Node<T> {
        public final T f11990a;
        public final List<Edge<T>> f11991b = Lists.a();
        public final List<Edge<T>> f11992c = Lists.a();

        public Node(T t) {
            this.f11990a = t;
        }

        public final void m12651a(Node<T> node) {
            Edge edge = new Edge(this, node);
            this.f11992c.add(edge);
            node.f11991b.add(edge);
        }
    }

    /* compiled from: fb_object_type */
    public class Edge<T> {
        public final Node<T> f12533a;
        public final Node<T> f12534b;

        public Edge(Node<T> node, Node<T> node2) {
            this.f12533a = node;
            this.f12534b = node2;
        }
    }

    public static <T> ImmutableList<Node<T>> m13280a(Collection<Node<T>> collection) {
        Node node;
        Set c = Sets.c();
        for (Node node2 : collection) {
            if (node2.f11991b.isEmpty()) {
                c.add(node2);
            }
        }
        Builder builder = ImmutableList.builder();
        while (!c.isEmpty()) {
            node2 = (Node) c.iterator().next();
            c.remove(node2);
            builder.c(node2);
            Iterator it = node2.f11992c.iterator();
            while (it.hasNext()) {
                Edge edge = (Edge) it.next();
                Node node3 = edge.f12534b;
                it.remove();
                node3.f11991b.remove(edge);
                if (node3.f11991b.isEmpty()) {
                    c.add(node3);
                }
            }
        }
        for (Node node22 : collection) {
            if (!node22.f11991b.isEmpty()) {
                throw new RuntimeException("Cycle in background tasks dependencies");
            }
        }
        return builder.b();
    }
}

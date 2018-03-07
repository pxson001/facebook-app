package com.google.common.collect;

import java.util.ArrayDeque;
import java.util.concurrent.ConcurrentLinkedQueue;

/* compiled from: viewer_feedback_reaction_key */
public final class Queues {
    private Queues() {
    }

    public static <E> ArrayDeque<E> m2122a() {
        return new ArrayDeque();
    }

    public static <E> ConcurrentLinkedQueue<E> m2123b() {
        return new ConcurrentLinkedQueue();
    }
}

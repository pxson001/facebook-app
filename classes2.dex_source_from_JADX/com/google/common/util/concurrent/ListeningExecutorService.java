package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

/* compiled from: wall_time */
public interface ListeningExecutorService extends ExecutorService {
    ListenableFuture<?> mo269a(Runnable runnable);

    <T> ListenableFuture<T> mo270a(Runnable runnable, T t);

    <T> ListenableFuture<T> mo271a(Callable<T> callable);
}

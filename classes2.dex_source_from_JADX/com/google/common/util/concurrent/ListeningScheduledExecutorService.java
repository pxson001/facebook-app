package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Beta
/* compiled from: vnd.android.cursor.item/vnd.facebook.katana.userstatuses */
public interface ListeningScheduledExecutorService extends ListeningExecutorService, ScheduledExecutorService {
    ListenableScheduledFuture<?> mo309a(Runnable runnable, long j, long j2, TimeUnit timeUnit);

    ListenableScheduledFuture<?> mo310a(Runnable runnable, long j, TimeUnit timeUnit);

    <V> ListenableScheduledFuture<V> mo311a(Callable<V> callable, long j, TimeUnit timeUnit);

    ListenableScheduledFuture<?> mo313b(Runnable runnable, long j, long j2, TimeUnit timeUnit);
}

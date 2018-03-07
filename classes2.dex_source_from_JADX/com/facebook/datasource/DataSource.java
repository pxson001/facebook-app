package com.facebook.datasource;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/* compiled from: unchanged_count */
public interface DataSource<T> {
    void mo2783a(DataSubscriber<T> dataSubscriber, Executor executor);

    boolean mo2784b();

    boolean mo2785c();

    @Nullable
    T mo2781d();

    @Nullable
    Throwable mo2786e();

    float mo2787f();

    boolean mo2782g();
}

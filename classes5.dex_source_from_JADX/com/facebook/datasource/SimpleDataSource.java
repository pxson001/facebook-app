package com.facebook.datasource;

import com.facebook.common.internal.Preconditions;

/* compiled from: search_result_actions */
public class SimpleDataSource<T> extends AbstractDataSource<T> {
    private SimpleDataSource() {
    }

    public static <T> SimpleDataSource<T> m4029h() {
        return new SimpleDataSource();
    }

    public final boolean m4030a(T t, boolean z) {
        return super.a(Preconditions.a(t), z);
    }

    public final boolean m4032b(T t) {
        return super.a(Preconditions.a(t), true);
    }

    public final boolean m4031a(Throwable th) {
        return super.a((Throwable) Preconditions.a(th));
    }
}

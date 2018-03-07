package com.facebook.datasource;

import com.facebook.common.internal.Supplier;

/* compiled from: search_result_style_list */
public class DataSources {

    /* compiled from: search_result_style_list */
    public final class C02051 implements Supplier<DataSource<T>> {
        final /* synthetic */ Throwable f2886a;

        public C02051(Throwable th) {
            this.f2886a = th;
        }

        public final Object m4027a() {
            return DataSources.m4028a(this.f2886a);
        }
    }

    private DataSources() {
    }

    public static <T> DataSource<T> m4028a(Throwable th) {
        SimpleDataSource h = SimpleDataSource.m4029h();
        h.m4031a(th);
        return h;
    }
}

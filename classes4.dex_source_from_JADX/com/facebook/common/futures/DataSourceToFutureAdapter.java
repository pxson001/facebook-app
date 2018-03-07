package com.facebook.common.futures;

import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.ForwardingListenableFuture$SimpleForwardingListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: mqtt_client */
public class DataSourceToFutureAdapter<T> extends ForwardingListenableFuture$SimpleForwardingListenableFuture<T> {
    public final SettableFuture<T> f7501a;
    private final DataSource<T> f7502b;

    /* compiled from: mqtt_client */
    class C03691 extends BaseDataSubscriber<T> {
        final /* synthetic */ DataSourceToFutureAdapter f7504a;

        C03691(DataSourceToFutureAdapter dataSourceToFutureAdapter) {
            this.f7504a = dataSourceToFutureAdapter;
        }

        public final void m7807e(DataSource<T> dataSource) {
            if (dataSource.b()) {
                FutureDetour.a(this.f7504a.f7501a, dataSource.d(), 625287928);
            }
        }

        public final void m7808f(DataSource<T> dataSource) {
            Throwable e = dataSource.e();
            if (e == null) {
                e = new RuntimeException("DataSourceFailed");
            }
            this.f7504a.f7501a.a(e);
        }
    }

    public static <T> DataSourceToFutureAdapter<T> m7803a(DataSource<T> dataSource) {
        return new DataSourceToFutureAdapter(dataSource, SettableFuture.f());
    }

    private DataSourceToFutureAdapter(DataSource<T> dataSource, SettableFuture<T> settableFuture) {
        super(settableFuture);
        this.f7502b = dataSource;
        this.f7501a = settableFuture;
        this.f7502b.a(new C03691(this), MoreExecutors.a());
    }

    public boolean cancel(boolean z) {
        this.f7502b.g();
        return super.cancel(z);
    }
}

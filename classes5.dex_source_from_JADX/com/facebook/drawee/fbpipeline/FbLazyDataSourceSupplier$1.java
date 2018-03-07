package com.facebook.drawee.fbpipeline;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.BaseDataSubscriber;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.memory.PooledByteBuffer;

/* compiled from: [...] */
public class FbLazyDataSourceSupplier$1 extends BaseDataSubscriber<CloseableReference<PooledByteBuffer>> {
    final /* synthetic */ FbLazyDataSourceSupplier f11971a;

    public FbLazyDataSourceSupplier$1(FbLazyDataSourceSupplier fbLazyDataSourceSupplier) {
        this.f11971a = fbLazyDataSourceSupplier;
    }

    protected final void m19971e(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
        if (dataSource.b() && dataSource.c()) {
            this.f11971a.c();
        }
    }

    protected final void m19972f(DataSource<CloseableReference<PooledByteBuffer>> dataSource) {
    }
}

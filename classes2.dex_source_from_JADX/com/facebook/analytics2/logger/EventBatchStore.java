package com.facebook.analytics2.logger;

import com.facebook.analytics2.logger.BatchLockState.BatchLock;
import com.facebook.crudolib.params.ParamsCollection;
import com.facebook.crudolib.params.ParamsCollectionPool;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.nio.ByteBuffer;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: t_ts_rp */
public abstract class EventBatchStore<T> {
    @Nullable
    protected BatchSession f3389a;
    @Nullable
    public Batch f3390b;
    @Nullable
    protected BatchSessionMetadataHelper f3391c;
    public final int f3392d;
    public final int f3393e;
    private final BatchFixedMetadataHelper f3394f;
    private final ParamsCollectionPool f3395g;
    public final char[] f3396h = new char[1024];
    public final ByteBuffer f3397i = ByteBuffer.allocate(2048);

    /* compiled from: t_ts_rp */
    public abstract class Batch {
        public final BatchLock f3497c;
        public final Writer f3498d;
        public final BatchWriterStructure f3499e = new BatchWriterStructure(this.f3498d);
        public int f3500f;
        final /* synthetic */ EventBatchStore f3501g;

        public Batch(EventBatchStore eventBatchStore, OutputStream outputStream, BatchLock batchLock) {
            this.f3501g = eventBatchStore;
            this.f3497c = batchLock;
            this.f3498d = new PoolFriendlyBufferedWriter(new PoolFriendlyOutputStreamWriter(outputStream, eventBatchStore.f3397i), eventBatchStore.f3396h);
        }

        public final void m5713a() {
            this.f3498d.close();
            this.f3497c.m5699a();
        }
    }

    protected abstract Batch mo748a(String str);

    @Nullable
    abstract T mo749a();

    EventBatchStore(int i, int i2, BatchFixedMetadataHelper batchFixedMetadataHelper, ParamsCollectionPool paramsCollectionPool) {
        if (i > i2) {
            throw new IllegalArgumentException(i + " > " + i2);
        }
        this.f3392d = i;
        this.f3393e = i2;
        this.f3394f = batchFixedMetadataHelper;
        this.f3395g = paramsCollectionPool;
    }

    final void m5613a(ParamsCollection paramsCollection) {
        m5608f();
        Batch e = m5607e();
        try {
            e.f3499e.m5727a(paramsCollection);
            e.f3498d.flush();
            e.f3500f++;
        } finally {
            e.f3497c.m5710f(this);
        }
    }

    @Nonnull
    private Batch m5607e() {
        if (this.f3390b == null || !this.f3390b.f3497c.m5706d(this)) {
            m5614d();
            this.f3390b = mo748a(this.f3389a.f3373b);
            this.f3390b.f3499e.m5725a(this.f3394f);
            this.f3390b.f3499e.m5726a(this.f3391c);
        }
        return this.f3390b;
    }

    final void m5614d() {
        if (this.f3390b != null) {
            m5608f();
            m5609g();
        }
    }

    private void m5608f() {
        if (this.f3391c == null) {
            throw new IllegalStateException("mBatchSessionMetadataHelper is null");
        }
    }

    private void m5609g() {
        if (this.f3390b != null) {
            try {
                this.f3390b.m5713a();
            } catch (IOException e) {
            }
            this.f3390b = null;
        }
    }

    final void m5612a(BatchSession batchSession) {
        this.f3389a = batchSession;
        this.f3391c = new BatchSessionMetadataHelper(this.f3395g, this.f3389a);
        m5609g();
    }
}

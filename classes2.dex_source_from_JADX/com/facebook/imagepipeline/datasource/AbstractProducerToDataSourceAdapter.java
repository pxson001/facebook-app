package com.facebook.imagepipeline.datasource;

import com.facebook.common.internal.Preconditions;
import com.facebook.datasource.AbstractDataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.BaseConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: mediaset/brpi.%s */
public abstract class AbstractProducerToDataSourceAdapter<T> extends AbstractDataSource<T> {
    private final SettableProducerContext f14490a;
    private final RequestListener f14491b;

    /* compiled from: mediaset/brpi.%s */
    public class C06041 extends BaseConsumer<T> {
        final /* synthetic */ AbstractProducerToDataSourceAdapter f14498a;

        public C06041(AbstractProducerToDataSourceAdapter abstractProducerToDataSourceAdapter) {
            this.f14498a = abstractProducerToDataSourceAdapter;
        }

        protected final void mo2788a(@Nullable T t, boolean z) {
            this.f14498a.mo2780b((Object) t, z);
        }

        protected final void mo2790b(Throwable th) {
            AbstractProducerToDataSourceAdapter.m20870b(this.f14498a, th);
        }

        protected final void mo2791c() {
            AbstractProducerToDataSourceAdapter.m20871i(this.f14498a);
        }

        protected final void mo2789b(float f) {
            boolean a = this.f14498a.m20884a(f);
        }
    }

    protected AbstractProducerToDataSourceAdapter(Producer<T> producer, SettableProducerContext settableProducerContext, RequestListener requestListener) {
        this.f14490a = settableProducerContext;
        this.f14491b = requestListener;
        this.f14491b.mo2103a(settableProducerContext.f14480a, this.f14490a.f14483d, this.f14490a.f14481b, this.f14490a.m20862f());
        producer.mo2774a(new C06041(this), settableProducerContext);
    }

    protected void mo2780b(@Nullable T t, boolean z) {
        if (super.m20885a((Object) t, z) && z) {
            this.f14491b.mo2105a(this.f14490a.f14480a, this.f14490a.f14481b, this.f14490a.m20862f());
        }
    }

    public static void m20870b(AbstractProducerToDataSourceAdapter abstractProducerToDataSourceAdapter, Throwable th) {
        if (super.m20886a(th)) {
            abstractProducerToDataSourceAdapter.f14491b.mo2104a(abstractProducerToDataSourceAdapter.f14490a.f14480a, abstractProducerToDataSourceAdapter.f14490a.f14481b, th, abstractProducerToDataSourceAdapter.f14490a.m20862f());
        }
    }

    public static synchronized void m20871i(AbstractProducerToDataSourceAdapter abstractProducerToDataSourceAdapter) {
        synchronized (abstractProducerToDataSourceAdapter) {
            Preconditions.b(abstractProducerToDataSourceAdapter.m20883a());
        }
    }

    public final boolean mo2782g() {
        if (!super.mo2782g()) {
            return false;
        }
        if (!super.mo2784b()) {
            this.f14491b.mo2111b(this.f14490a.f14481b);
            this.f14490a.m20865i();
        }
        return true;
    }
}

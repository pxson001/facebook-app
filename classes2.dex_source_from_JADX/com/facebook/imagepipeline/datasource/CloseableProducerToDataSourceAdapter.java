package com.facebook.imagepipeline.datasource;

import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.SettableProducerContext;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: mediaset/brpo.%s */
public class CloseableProducerToDataSourceAdapter<T> extends AbstractProducerToDataSourceAdapter<CloseableReference<T>> {
    protected final void mo2779a(Object obj) {
        CloseableReference.m15681c((CloseableReference) obj);
    }

    protected final void mo2780b(Object obj, boolean z) {
        super.mo2780b(CloseableReference.m15680b((CloseableReference) obj), z);
    }

    public static <T> DataSource<CloseableReference<T>> m20866a(Producer<CloseableReference<T>> producer, SettableProducerContext settableProducerContext, RequestListener requestListener) {
        return new CloseableProducerToDataSourceAdapter(producer, settableProducerContext, requestListener);
    }

    private CloseableProducerToDataSourceAdapter(Producer<CloseableReference<T>> producer, SettableProducerContext settableProducerContext, RequestListener requestListener) {
        super(producer, settableProducerContext, requestListener);
    }

    @Nullable
    public final Object mo2781d() {
        return CloseableReference.m15680b((CloseableReference) super.mo2781d());
    }
}

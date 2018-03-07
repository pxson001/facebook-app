package com.facebook.feed.environment.impl;

import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasRowKey;
import com.facebook.feed.rows.core.RowKey;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.feed.rows.core.parts.EnvironmentController;
import com.facebook.feed.rows.core.parts.PartWithViewType;
import com.facebook.inject.InjectorLike;
import com.facebook.multirow.api.AnyEnvironment;
import java.util.LinkedList;
import javax.annotation.Nullable;

/* compiled from: news_feed_rerank */
public class FeedEnvironmentController<E extends HasPositionInformation & HasRowKey & HasIsAsync> implements EnvironmentController<E> {
    private final LinkedList<Data> f12294a = new LinkedList();
    private boolean f12295b;

    public static FeedEnvironmentController m18325a(InjectorLike injectorLike) {
        return new FeedEnvironmentController();
    }

    public final void mo2462a(AnyEnvironment anyEnvironment) {
        HasPositionInformation hasPositionInformation = (HasPositionInformation) anyEnvironment;
        hasPositionInformation.mo2457k();
        ((HasRowKey) hasPositionInformation).mo2460n();
        this.f12295b = !this.f12294a.isEmpty();
        if (this.f12295b) {
            Data data = (Data) this.f12294a.pop();
            m18327b(hasPositionInformation, data.a, data.b, data.c, data.d, data.e, data.f, data.g);
        }
    }

    private void m18326a(E e, @Nullable PartWithViewType partWithViewType, @Nullable PartWithViewType partWithViewType2, @Nullable PartWithViewType partWithViewType3, @Nullable Object obj, @Nullable Object obj2, @Nullable RowKey rowKey, boolean z) {
        if (this.f12295b) {
            this.f12294a.push(new Data(e.hK_(), e.mo2449f(), e.mo2451h(), e.mo2455i(), e.mo2456j(), ((HasRowKey) e).mo2461o() ? ((HasRowKey) e).mo2459m() : null, z));
        }
        m18327b(e, partWithViewType, partWithViewType2, partWithViewType3, obj, obj2, rowKey, z);
        this.f12295b = true;
    }

    private static void m18327b(E e, PartWithViewType partWithViewType, PartWithViewType partWithViewType2, PartWithViewType partWithViewType3, Object obj, Object obj2, RowKey rowKey, boolean z) {
        ((HasRowKey) e).mo2428a(rowKey);
        e.mo2429a(partWithViewType, partWithViewType2, partWithViewType3, obj, obj2);
        ((HasIsAsync) e).mo2445b(z);
    }
}

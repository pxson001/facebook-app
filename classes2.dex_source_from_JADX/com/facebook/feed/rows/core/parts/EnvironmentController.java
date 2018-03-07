package com.facebook.feed.rows.core.parts;

import com.facebook.feed.rows.core.RowKey;
import com.facebook.multirow.api.AnyEnvironment;
import javax.annotation.Nullable;

/* compiled from: news_feed_implementation */
public interface EnvironmentController<E2 extends AnyEnvironment> {
    void mo2462a(E2 e2);

    void mo2463a(E2 e2, @Nullable PartWithViewType partWithViewType, @Nullable PartWithViewType partWithViewType2, @Nullable PartWithViewType partWithViewType3, @Nullable Object obj, @Nullable Object obj2, @Nullable RowKey rowKey, boolean z);
}

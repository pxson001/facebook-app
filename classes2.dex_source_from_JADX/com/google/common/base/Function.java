package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import javax.annotation.Nullable;

@GwtCompatible
/* compiled from: zero_campaign_api_graphql */
public interface Function<F, T> {
    @Nullable
    T apply(@Nullable F f);

    boolean equals(@Nullable Object obj);
}

package com.facebook.photos.mediafetcher;

import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesInterfaces.MediaPageInfo;
import com.facebook.photos.mediafetcher.protocol.MediaFetchQueriesModels.MediaPageInfoModel;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;

@VisibleForTesting
/* compiled from: last_break_timestamp_ms */
public class PageResult<E> {
    public final ImmutableList<? extends E> f10533a;
    @Nullable
    final MediaPageInfoModel f10534b;

    public PageResult(ImmutableList<? extends E> immutableList, MediaPageInfo mediaPageInfo) {
        this.f10533a = immutableList;
        this.f10534b = mediaPageInfo;
    }
}

package com.facebook.feed.fragment.generatedenvironments;

import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.feed.rows.prefetch.MultiRowImagePrefetcherWrapper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: new_story_count */
public class HasPrefetcherImplProvider extends AbstractAssistedProvider<HasPrefetcherImpl> {
    public final HasPrefetcherImpl m18352a(MultiRowImagePrefetcherWrapper multiRowImagePrefetcherWrapper) {
        return new HasPrefetcherImpl(multiRowImagePrefetcherWrapper, FbErrorReporterImpl.m2317a((InjectorLike) this));
    }
}

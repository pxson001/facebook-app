package com.facebook.timeline.aboutpage.collection;

import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.timeline.aboutpage.CollectionsQeHelper;
import com.facebook.timeline.aboutpage.CollectionsQueryExecutor;
import com.facebook.timeline.aboutpage.StandardCollectionSizes;

/* compiled from: NAVIGATED_BACK */
public class CollectionInitialConnectionConfigurationProvider extends AbstractAssistedProvider<CollectionInitialConnectionConfiguration> {
    public final CollectionInitialConnectionConfiguration m13839a(String str, String str2) {
        return new CollectionInitialConnectionConfiguration(str, str2, CollectionsQueryExecutor.m13769a((InjectorLike) this), StandardCollectionSizes.m13827a(this), CollectionsQeHelper.m13763b(this));
    }
}

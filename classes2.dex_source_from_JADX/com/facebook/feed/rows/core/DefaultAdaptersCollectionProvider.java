package com.facebook.feed.rows.core;

import com.facebook.api.feed.data.collections.ListItemCollection;
import com.facebook.feed.rows.qe.AndroidComponentsExperimentHelper;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.multirow.api.AnyEnvironment;

/* compiled from: phone_android_type */
public class DefaultAdaptersCollectionProvider extends AbstractAssistedProvider<DefaultAdaptersCollection> {
    public final <T> DefaultAdaptersCollection<T> m15278a(FeedUnitAdapterFactory feedUnitAdapterFactory, ListItemCollection listItemCollection, AnyEnvironment anyEnvironment, ListItemComparator listItemComparator) {
        return new DefaultAdaptersCollection(feedUnitAdapterFactory, listItemCollection, anyEnvironment, listItemComparator, AndroidComponentsExperimentHelper.m10053a((InjectorLike) this));
    }
}

package com.facebook.timeline.aboutpage.collection;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder;
import com.facebook.timeline.aboutpage.CollectionsViewFramer;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.timeline.aboutpage.views.ListCollectionItemDataFactory;

/* compiled from: Moved Permanently */
public class CollectionsCollectionCursorAdaptorProvider extends AbstractAssistedProvider<CollectionsCollectionCursorAdaptor> {
    public final CollectionsCollectionCursorAdaptor m13857a(ProfileViewerContext profileViewerContext, Context context, LayoutInflater layoutInflater, CollectionsAnalyticsLogger collectionsAnalyticsLogger) {
        return new CollectionsCollectionCursorAdaptor(profileViewerContext, context, layoutInflater, collectionsAnalyticsLogger, CollectionsViewFramer.m13790a((InjectorLike) this), ListCollectionItemDataFactory.m14997a(this), CollectionsViewFactory.m14940a((InjectorLike) this), CollectionStyleMapper.m14915a((InjectorLike) this), CollectionsUriIntentBuilder.m13782a(this));
    }
}

package com.facebook.timeline.aboutpage.collection;

import android.content.Context;
import android.view.LayoutInflater;
import com.facebook.analytics.InteractionLogger;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder;
import com.facebook.timeline.aboutpage.CollectionsViewFramer;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.timeline.aboutpage.views.ListCollectionItemDataFactory;

/* compiled from: N */
public class CollectionsCollectionAdapterProvider extends AbstractAssistedProvider<CollectionsCollectionAdapter> {
    public final CollectionsCollectionAdapter m13849a(Context context, ProfileViewerContext profileViewerContext, CollectionsAnalyticsLogger collectionsAnalyticsLogger, LayoutInflater layoutInflater) {
        return new CollectionsCollectionAdapter(context, profileViewerContext, CollectionsViewFactory.m14940a((InjectorLike) this), CollectionStyleMapper.m14915a((InjectorLike) this), ListCollectionItemDataFactory.m14997a(this), CollectionsViewFramer.m13790a((InjectorLike) this), collectionsAnalyticsLogger, InteractionLogger.a(this), CollectionsUriIntentBuilder.m13782a(this), layoutInflater);
    }
}

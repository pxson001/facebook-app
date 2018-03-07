package com.facebook.timeline.aboutpage.sections;

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

/* compiled from: MINUTIAE_METADATA */
public class CollectionsSectionAdapterProvider extends AbstractAssistedProvider<CollectionsSectionAdapter> {
    public final CollectionsSectionAdapter m14759a(Context context, ProfileViewerContext profileViewerContext, CollectionsAnalyticsLogger collectionsAnalyticsLogger, LayoutInflater layoutInflater) {
        return new CollectionsSectionAdapter(context, profileViewerContext, CollectionsViewFactory.m14940a((InjectorLike) this), ListCollectionItemDataFactory.m14997a(this), CollectionStyleMapper.m14915a((InjectorLike) this), CollectionsViewFramer.m13790a((InjectorLike) this), collectionsAnalyticsLogger, CollectionsUriIntentBuilder.m13782a(this), layoutInflater);
    }
}

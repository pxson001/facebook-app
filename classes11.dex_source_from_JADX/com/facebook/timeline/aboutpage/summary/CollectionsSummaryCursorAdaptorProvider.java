package com.facebook.timeline.aboutpage.summary;

import android.content.Context;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.profile.api.ProfileViewerContext;
import com.facebook.timeline.aboutpage.CollectionsAnalyticsLogger;
import com.facebook.timeline.aboutpage.CollectionsQeHelper;
import com.facebook.timeline.aboutpage.CollectionsViewFramer;
import com.facebook.timeline.aboutpage.util.TimelineAppSectionUrlBuilder;
import com.facebook.timeline.aboutpage.views.CollectionStyleMapper;
import com.facebook.timeline.aboutpage.views.CollectionsViewFactory;
import com.facebook.timeline.aboutpage.views.ProfileBasicFieldViewBinder;

/* compiled from: LoginFragment */
public class CollectionsSummaryCursorAdaptorProvider extends AbstractAssistedProvider<CollectionsSummaryCursorAdaptor> {
    public final CollectionsSummaryCursorAdaptor m14817a(Context context, ProfileViewerContext profileViewerContext, CollectionsAnalyticsLogger collectionsAnalyticsLogger) {
        return new CollectionsSummaryCursorAdaptor(context, profileViewerContext, collectionsAnalyticsLogger, CollectionSummaryItemRenderer.m14785a((InjectorLike) this), CollectionsViewFactory.m14940a((InjectorLike) this), CollectionsViewFramer.m13790a((InjectorLike) this), CollectionStyleMapper.m14915a((InjectorLike) this), TimelineAppSectionUrlBuilder.m14867a((InjectorLike) this), ProfileBasicFieldViewBinder.m15030b(this), CollectionsQeHelper.m13763b(this));
    }
}

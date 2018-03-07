package com.facebook.feedplugins.pyma;

import android.content.Context;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.HoneyAnalyticsEvent;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.graphql.enums.GraphQLPYMACategory;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnit;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnitItem;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.graphql.model.StorySharingHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: collections_icon */
public class PYMAAnalyticsHelper {
    private static PYMAAnalyticsHelper f8614c;
    private static final Object f8615d = new Object();
    private final NewsFeedAnalyticsEventBuilder f8616a;
    public final AnalyticsLogger f8617b;

    private static PYMAAnalyticsHelper m9457b(InjectorLike injectorLike) {
        return new PYMAAnalyticsHelper(AnalyticsLoggerMethodAutoProvider.a(injectorLike), NewsFeedAnalyticsEventBuilder.a(injectorLike));
    }

    @Inject
    public PYMAAnalyticsHelper(AnalyticsLogger analyticsLogger, NewsFeedAnalyticsEventBuilder newsFeedAnalyticsEventBuilder) {
        this.f8616a = newsFeedAnalyticsEventBuilder;
        this.f8617b = analyticsLogger;
    }

    public final void m9458a(GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit, String str) {
        String str2;
        String str3;
        HoneyAnalyticsEvent honeyAnalyticsEvent;
        ImmutableList s = graphQLPagesYouMayAdvertiseFeedUnit.s();
        if (s.isEmpty()) {
            str2 = "Cannot get page ID. feedUnit.getItems() is empty.";
        } else if (s.get(0) == null) {
            str2 = "Cannot get page ID. feedUnit.getItems().get(0) is null.";
        } else if (((GraphQLPagesYouMayAdvertiseFeedUnitItem) s.get(0)).m() == null) {
            str2 = "Cannot get page ID. feedUnit.getItems().get(0).getProfile() is null.";
        } else {
            str2 = ((GraphQLPagesYouMayAdvertiseFeedUnitItem) s.get(0)).m().b();
        }
        String str4 = str2;
        s = graphQLPagesYouMayAdvertiseFeedUnit.s();
        if (graphQLPagesYouMayAdvertiseFeedUnit.r() == GraphQLPYMACategory.PROMOTE_PAGE_LIKE) {
            str3 = null;
        } else if (s.isEmpty()) {
            str3 = "Cannot get debug id. feedUnit.getItems() is empty.";
        } else if (s.get(0) == null) {
            str3 = "Cannot get debug id. feedItems.get(0) == null";
        } else if (((GraphQLPagesYouMayAdvertiseFeedUnitItem) s.get(0)).j() == null) {
            str3 = "Cannot get debug id. feedItems.get(0).getFeedUnitPreview() == null";
        } else {
            GraphQLStory graphQLStory = (GraphQLStory) ((GraphQLPagesYouMayAdvertiseFeedUnitItem) s.get(0)).j();
            if (StoryAttachmentHelper.o(graphQLStory) == null) {
                str3 = "Cannot get debug id. getFirstAttachment() is null";
            } else if (StoryAttachmentHelper.o(graphQLStory).z() == null) {
                str3 = "Cannot get debug id. getTarget() is null";
            } else {
                str3 = StoryAttachmentHelper.o(graphQLStory).z().dp();
            }
            if (!(StorySharingHelper.a(graphQLStory).isEmpty() || StorySharingHelper.a(graphQLStory).contentEquals(str3))) {
                str3 = str3 + " ShareableId=" + StorySharingHelper.a(graphQLStory);
            }
        }
        String str5 = str3;
        ArrayNode a = FeedTrackableUtil.a(graphQLPagesYouMayAdvertiseFeedUnit);
        String valueOf = String.valueOf(graphQLPagesYouMayAdvertiseFeedUnit.r());
        if (NewsFeedAnalyticsEventBuilder.B(a)) {
            honeyAnalyticsEvent = null;
        } else {
            HoneyClientEvent b = new HoneyClientEvent("pyma_error").a("tracking", a).b("error_msg", str).b("pyma_category", valueOf).b("page_id", str4).b("debug_id", str5);
            b.c = "native_newsfeed";
            honeyAnalyticsEvent = b;
        }
        this.f8617b.a(honeyAnalyticsEvent);
    }

    public static PYMAAnalyticsHelper m9456a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PYMAAnalyticsHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8615d) {
                PYMAAnalyticsHelper pYMAAnalyticsHelper;
                if (a2 != null) {
                    pYMAAnalyticsHelper = (PYMAAnalyticsHelper) a2.a(f8615d);
                } else {
                    pYMAAnalyticsHelper = f8614c;
                }
                if (pYMAAnalyticsHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9457b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8615d, b3);
                        } else {
                            f8614c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pYMAAnalyticsHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

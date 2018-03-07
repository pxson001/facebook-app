package com.facebook.feedplugins.pyma;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.analytics.NewsFeedAnalyticsEventBuilder;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.pyma.rows.PagesYouMayAdvertiseBodyPartDefinition;
import com.facebook.feedplugins.pyma.rows.PagesYouMayAdvertiseFooterPartDefinition;
import com.facebook.feedplugins.pyma.rows.PagesYouMayAdvertiseHeaderPartDefinition;
import com.facebook.graphql.model.FeedTrackableUtil;
import com.facebook.graphql.model.GraphQLPagesYouMayAdvertiseFeedUnit;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import javax.inject.Inject;

@ContextScoped
/* compiled from: collections_collection */
public class PagesYouMayAdvertisePartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLPagesYouMayAdvertiseFeedUnit>, Void, FeedEnvironment> {
    private static PagesYouMayAdvertisePartDefinition f8621e;
    private static final Object f8622f = new Object();
    private final PagesYouMayAdvertiseHeaderPartDefinition f8623a;
    private final PagesYouMayAdvertiseBodyPartDefinition f8624b;
    private final PagesYouMayAdvertiseFooterPartDefinition f8625c;
    private final PYMAAnalyticsHelper f8626d;

    private static PagesYouMayAdvertisePartDefinition m9466b(InjectorLike injectorLike) {
        return new PagesYouMayAdvertisePartDefinition(PagesYouMayAdvertiseHeaderPartDefinition.a(injectorLike), PagesYouMayAdvertiseBodyPartDefinition.m9469a(injectorLike), PagesYouMayAdvertiseFooterPartDefinition.m9475a(injectorLike), PYMAAnalyticsHelper.m9456a(injectorLike));
    }

    public final Object m9467a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f8623a, feedProps);
        baseMultiRowSubParts.a(this.f8624b, feedProps);
        baseMultiRowSubParts.a(this.f8625c, feedProps);
        PYMAAnalyticsHelper pYMAAnalyticsHelper = this.f8626d;
        GraphQLPagesYouMayAdvertiseFeedUnit graphQLPagesYouMayAdvertiseFeedUnit = (GraphQLPagesYouMayAdvertiseFeedUnit) feedProps.a;
        pYMAAnalyticsHelper.f8617b.a(NewsFeedAnalyticsEventBuilder.a(FeedTrackableUtil.a(graphQLPagesYouMayAdvertiseFeedUnit), String.valueOf(graphQLPagesYouMayAdvertiseFeedUnit.r())));
        return null;
    }

    public final boolean m9468a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return this.f8623a.a(feedProps) && this.f8624b.m9473a(feedProps) && this.f8625c.m9480a(feedProps);
    }

    @Inject
    public PagesYouMayAdvertisePartDefinition(PagesYouMayAdvertiseHeaderPartDefinition pagesYouMayAdvertiseHeaderPartDefinition, PagesYouMayAdvertiseBodyPartDefinition pagesYouMayAdvertiseBodyPartDefinition, PagesYouMayAdvertiseFooterPartDefinition pagesYouMayAdvertiseFooterPartDefinition, PYMAAnalyticsHelper pYMAAnalyticsHelper) {
        this.f8623a = pagesYouMayAdvertiseHeaderPartDefinition;
        this.f8624b = pagesYouMayAdvertiseBodyPartDefinition;
        this.f8625c = pagesYouMayAdvertiseFooterPartDefinition;
        this.f8626d = pYMAAnalyticsHelper;
    }

    public static PagesYouMayAdvertisePartDefinition m9465a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesYouMayAdvertisePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8622f) {
                PagesYouMayAdvertisePartDefinition pagesYouMayAdvertisePartDefinition;
                if (a2 != null) {
                    pagesYouMayAdvertisePartDefinition = (PagesYouMayAdvertisePartDefinition) a2.a(f8622f);
                } else {
                    pagesYouMayAdvertisePartDefinition = f8621e;
                }
                if (pagesYouMayAdvertisePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9466b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8622f, b3);
                        } else {
                            f8621e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesYouMayAdvertisePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.feedplugins.psym.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitPagerIndicatorPartDefinition;
import com.facebook.feedplugins.storyset.rows.NetEgoStorySetHScrollPartDefinition;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLPageStoriesYouMissedFeedUnit;
import com.facebook.graphql.model.IsValidUtil;
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
/* compiled from: collections_overview */
public class PagesStoriesYouMissedPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLPageStoriesYouMissedFeedUnit>, Void, FeedEnvironment> {
    private static PagesStoriesYouMissedPartDefinition f8609d;
    private static final Object f8610e = new Object();
    private final PagesStoriesYouMissedHeaderPartDefinition f8611a;
    private final NetEgoStorySetHScrollPartDefinition f8612b;
    private final GatekeeperStoreImpl f8613c;

    private static PagesStoriesYouMissedPartDefinition m9453b(InjectorLike injectorLike) {
        return new PagesStoriesYouMissedPartDefinition(PagesStoriesYouMissedHeaderPartDefinition.m9446a(injectorLike), NetEgoStorySetHScrollPartDefinition.m10081a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m9454a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f8611a, feedProps);
        baseMultiRowSubParts.a(this.f8612b, new FeedUnitAndChangePageListener(feedProps, FeedUnitPagerIndicatorPartDefinition.b()));
        return null;
    }

    public final boolean m9455a(Object obj) {
        return IsValidUtil.a((GraphQLPageStoriesYouMissedFeedUnit) ((FeedProps) obj).a) && this.f8613c.a(1066, false);
    }

    @Inject
    public PagesStoriesYouMissedPartDefinition(PagesStoriesYouMissedHeaderPartDefinition pagesStoriesYouMissedHeaderPartDefinition, NetEgoStorySetHScrollPartDefinition netEgoStorySetHScrollPartDefinition, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f8611a = pagesStoriesYouMissedHeaderPartDefinition;
        this.f8612b = netEgoStorySetHScrollPartDefinition;
        this.f8613c = gatekeeperStoreImpl;
    }

    public static PagesStoriesYouMissedPartDefinition m9452a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PagesStoriesYouMissedPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8610e) {
                PagesStoriesYouMissedPartDefinition pagesStoriesYouMissedPartDefinition;
                if (a2 != null) {
                    pagesStoriesYouMissedPartDefinition = (PagesStoriesYouMissedPartDefinition) a2.a(f8610e);
                } else {
                    pagesStoriesYouMissedPartDefinition = f8609d;
                }
                if (pagesStoriesYouMissedPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m9453b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8610e, b3);
                        } else {
                            f8609d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = pagesStoriesYouMissedPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

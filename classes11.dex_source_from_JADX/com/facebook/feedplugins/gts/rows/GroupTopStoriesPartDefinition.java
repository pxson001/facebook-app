package com.facebook.feedplugins.gts.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitAndChangePageListener;
import com.facebook.feed.rows.sections.hscrollrecyclerview.FeedUnitPagerIndicatorPartDefinition;
import com.facebook.feedplugins.storyset.rows.NetEgoStorySetHScrollPartDefinition;
import com.facebook.graphql.model.GraphQLGroupTopStoriesFeedUnit;
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
/* compiled from: d24876fc1d5d96c6d6000669dd789142 */
public class GroupTopStoriesPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGroupTopStoriesFeedUnit>, Void, FeedEnvironment> {
    private static GroupTopStoriesPartDefinition f7771c;
    private static final Object f7772d = new Object();
    private final GroupTopStoriesHeaderPartDefinition f7773a;
    private final NetEgoStorySetHScrollPartDefinition f7774b;

    private static GroupTopStoriesPartDefinition m8943b(InjectorLike injectorLike) {
        return new GroupTopStoriesPartDefinition(GroupTopStoriesHeaderPartDefinition.m8936a(injectorLike), NetEgoStorySetHScrollPartDefinition.m10081a(injectorLike));
    }

    public final Object m8944a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f7773a, feedProps);
        if (feedProps.a != null) {
            baseMultiRowSubParts.a(this.f7774b, new FeedUnitAndChangePageListener(feedProps, FeedUnitPagerIndicatorPartDefinition.b()));
        }
        return null;
    }

    public final boolean m8945a(Object obj) {
        FeedProps feedProps = (FeedProps) obj;
        return (feedProps.a == null || ((GraphQLGroupTopStoriesFeedUnit) feedProps.a).l() == null || ((GraphQLGroupTopStoriesFeedUnit) feedProps.a).l().a() == null || ((GraphQLGroupTopStoriesFeedUnit) feedProps.a).l().a().size() <= 1) ? false : true;
    }

    @Inject
    public GroupTopStoriesPartDefinition(GroupTopStoriesHeaderPartDefinition groupTopStoriesHeaderPartDefinition, NetEgoStorySetHScrollPartDefinition netEgoStorySetHScrollPartDefinition) {
        this.f7773a = groupTopStoriesHeaderPartDefinition;
        this.f7774b = netEgoStorySetHScrollPartDefinition;
    }

    public static GroupTopStoriesPartDefinition m8942a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupTopStoriesPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f7772d) {
                GroupTopStoriesPartDefinition groupTopStoriesPartDefinition;
                if (a2 != null) {
                    groupTopStoriesPartDefinition = (GroupTopStoriesPartDefinition) a2.a(f7772d);
                } else {
                    groupTopStoriesPartDefinition = f7771c;
                }
                if (groupTopStoriesPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m8943b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f7772d, b3);
                        } else {
                            f7771c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupTopStoriesPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

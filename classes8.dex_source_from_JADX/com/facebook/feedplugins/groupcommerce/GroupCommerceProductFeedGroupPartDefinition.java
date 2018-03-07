package com.facebook.feedplugins.groupcommerce;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryCommerceHelper;
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
/* compiled from: friendversary_polaroids_ipb */
public class GroupCommerceProductFeedGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static GroupCommerceProductFeedGroupPartDefinition f12781b;
    private static final Object f12782c = new Object();
    private final GroupCommerceCompactItemPartDefinition f12783a;

    private static GroupCommerceProductFeedGroupPartDefinition m14569b(InjectorLike injectorLike) {
        return new GroupCommerceProductFeedGroupPartDefinition(GroupCommerceCompactItemPartDefinition.m14496a(injectorLike));
    }

    public final Object m14570a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        baseMultiRowSubParts.a(this.f12783a, (FeedProps) obj);
        return null;
    }

    public final boolean m14571a(Object obj) {
        return StoryCommerceHelper.b((GraphQLStory) ((FeedProps) obj).a);
    }

    @Inject
    public GroupCommerceProductFeedGroupPartDefinition(GroupCommerceCompactItemPartDefinition groupCommerceCompactItemPartDefinition) {
        this.f12783a = groupCommerceCompactItemPartDefinition;
    }

    public static GroupCommerceProductFeedGroupPartDefinition m14568a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupCommerceProductFeedGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12782c) {
                GroupCommerceProductFeedGroupPartDefinition groupCommerceProductFeedGroupPartDefinition;
                if (a2 != null) {
                    groupCommerceProductFeedGroupPartDefinition = (GroupCommerceProductFeedGroupPartDefinition) a2.a(f12782c);
                } else {
                    groupCommerceProductFeedGroupPartDefinition = f12781b;
                }
                if (groupCommerceProductFeedGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14569b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12782c, b3);
                        } else {
                            f12781b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupCommerceProductFeedGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.groups.feed.ui.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.groupcommerce.GroupCommerceProductFeedGroupPartDefinition;
import com.facebook.graphql.model.GraphQLStory;
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
/* compiled from: ThreadListLoader FETCH_MORE_THREADS */
public class GroupsProductFeedGraphQLStorySelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static GroupsProductFeedGraphQLStorySelectorPartDefinition f22503c;
    private static final Object f22504d = new Object();
    private final GroupsBasicGroupPartDefinition f22505a;
    private final GroupCommerceProductFeedGroupPartDefinition f22506b;

    private static GroupsProductFeedGraphQLStorySelectorPartDefinition m23552b(InjectorLike injectorLike) {
        return new GroupsProductFeedGraphQLStorySelectorPartDefinition(GroupCommerceProductFeedGroupPartDefinition.a(injectorLike), GroupsBasicGroupPartDefinition.m23516a(injectorLike));
    }

    public final Object m23553a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f22506b, feedProps).a(this.f22505a, feedProps);
        return null;
    }

    @Inject
    public GroupsProductFeedGraphQLStorySelectorPartDefinition(GroupCommerceProductFeedGroupPartDefinition groupCommerceProductFeedGroupPartDefinition, GroupsBasicGroupPartDefinition groupsBasicGroupPartDefinition) {
        this.f22505a = groupsBasicGroupPartDefinition;
        this.f22506b = groupCommerceProductFeedGroupPartDefinition;
    }

    public final boolean m23554a(Object obj) {
        return true;
    }

    public static GroupsProductFeedGraphQLStorySelectorPartDefinition m23551a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsProductFeedGraphQLStorySelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22504d) {
                GroupsProductFeedGraphQLStorySelectorPartDefinition groupsProductFeedGraphQLStorySelectorPartDefinition;
                if (a2 != null) {
                    groupsProductFeedGraphQLStorySelectorPartDefinition = (GroupsProductFeedGraphQLStorySelectorPartDefinition) a2.a(f22504d);
                } else {
                    groupsProductFeedGraphQLStorySelectorPartDefinition = f22503c;
                }
                if (groupsProductFeedGraphQLStorySelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23552b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22504d, b3);
                        } else {
                            f22503c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsProductFeedGraphQLStorySelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

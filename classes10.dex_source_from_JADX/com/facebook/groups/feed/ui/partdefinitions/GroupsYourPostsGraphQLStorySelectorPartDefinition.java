package com.facebook.groups.feed.ui.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feedplugins.groupcommerce.GroupCommerceGroupPartDefinition;
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
/* compiled from: ThreadListItemBackgroundLoader */
public class GroupsYourPostsGraphQLStorySelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static GroupsYourPostsGraphQLStorySelectorPartDefinition f22517c;
    private static final Object f22518d = new Object();
    private final GroupsBasicGroupPartDefinition f22519a;
    private final GroupCommerceGroupPartDefinition f22520b;

    private static GroupsYourPostsGraphQLStorySelectorPartDefinition m23560b(InjectorLike injectorLike) {
        return new GroupsYourPostsGraphQLStorySelectorPartDefinition(GroupCommerceGroupPartDefinition.a(injectorLike), GroupsBasicGroupPartDefinition.m23516a(injectorLike));
    }

    public final Object m23561a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f22520b, feedProps).a(this.f22519a, feedProps);
        return null;
    }

    @Inject
    public GroupsYourPostsGraphQLStorySelectorPartDefinition(GroupCommerceGroupPartDefinition groupCommerceGroupPartDefinition, GroupsBasicGroupPartDefinition groupsBasicGroupPartDefinition) {
        this.f22519a = groupsBasicGroupPartDefinition;
        this.f22520b = groupCommerceGroupPartDefinition;
    }

    public final boolean m23562a(Object obj) {
        return true;
    }

    public static GroupsYourPostsGraphQLStorySelectorPartDefinition m23559a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsYourPostsGraphQLStorySelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22518d) {
                GroupsYourPostsGraphQLStorySelectorPartDefinition groupsYourPostsGraphQLStorySelectorPartDefinition;
                if (a2 != null) {
                    groupsYourPostsGraphQLStorySelectorPartDefinition = (GroupsYourPostsGraphQLStorySelectorPartDefinition) a2.a(f22518d);
                } else {
                    groupsYourPostsGraphQLStorySelectorPartDefinition = f22517c;
                }
                if (groupsYourPostsGraphQLStorySelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23560b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22518d, b3);
                        } else {
                            f22517c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsYourPostsGraphQLStorySelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

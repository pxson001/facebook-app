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
/* compiled from: getAldrinLoggedOutUser */
public class GroupCommerceGroupPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static GroupCommerceGroupPartDefinition f12698c;
    private static final Object f12699d = new Object();
    private final GroupCommerceSellerActionsPartDefinition f12700a;
    private final GroupCommerceCompactItemPartDefinition f12701b;

    private static GroupCommerceGroupPartDefinition m14504b(InjectorLike injectorLike) {
        return new GroupCommerceGroupPartDefinition(GroupCommerceCompactItemPartDefinition.m14496a(injectorLike), GroupCommerceSellerActionsPartDefinition.m14573a(injectorLike));
    }

    public final Object m14505a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f12701b, feedProps);
        baseMultiRowSubParts.a(this.f12700a, feedProps);
        return null;
    }

    public final boolean m14506a(Object obj) {
        return StoryCommerceHelper.b((GraphQLStory) ((FeedProps) obj).a);
    }

    @Inject
    public GroupCommerceGroupPartDefinition(GroupCommerceCompactItemPartDefinition groupCommerceCompactItemPartDefinition, GroupCommerceSellerActionsPartDefinition groupCommerceSellerActionsPartDefinition) {
        this.f12700a = groupCommerceSellerActionsPartDefinition;
        this.f12701b = groupCommerceCompactItemPartDefinition;
    }

    public static GroupCommerceGroupPartDefinition m14503a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupCommerceGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12699d) {
                GroupCommerceGroupPartDefinition groupCommerceGroupPartDefinition;
                if (a2 != null) {
                    groupCommerceGroupPartDefinition = (GroupCommerceGroupPartDefinition) a2.a(f12699d);
                } else {
                    groupCommerceGroupPartDefinition = f12698c;
                }
                if (groupCommerceGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14504b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12699d, b3);
                        } else {
                            f12698c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupCommerceGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

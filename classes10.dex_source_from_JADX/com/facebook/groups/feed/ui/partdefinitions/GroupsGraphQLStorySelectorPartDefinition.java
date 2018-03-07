package com.facebook.groups.feed.ui.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.parts.SubPartsSelector;
import com.facebook.feed.rows.core.props.FeedProps;
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
/* compiled from: ThreadSummary found to be null in DataCache during group payment sends */
public class GroupsGraphQLStorySelectorPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLStory>, Void, FeedEnvironment> {
    private static GroupsGraphQLStorySelectorPartDefinition f22454d;
    private static final Object f22455e = new Object();
    private final GroupsOfflineGroupPartDefinition f22456a;
    private final GroupsSharedStoryPartDefinition f22457b;
    private final GroupsBasicGroupPartDefinition f22458c;

    private static GroupsGraphQLStorySelectorPartDefinition m23526b(InjectorLike injectorLike) {
        return new GroupsGraphQLStorySelectorPartDefinition(GroupsBasicGroupPartDefinition.m23516a(injectorLike), GroupsSharedStoryPartDefinition.m23555a(injectorLike), GroupsOfflineGroupPartDefinition.m23547a(injectorLike));
    }

    public final Object m23527a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        SubPartsSelector.a(baseMultiRowSubParts, this.f22456a, feedProps).a(this.f22457b, feedProps).a(this.f22458c, feedProps);
        return null;
    }

    @Inject
    public GroupsGraphQLStorySelectorPartDefinition(GroupsBasicGroupPartDefinition groupsBasicGroupPartDefinition, GroupsSharedStoryPartDefinition groupsSharedStoryPartDefinition, GroupsOfflineGroupPartDefinition groupsOfflineGroupPartDefinition) {
        this.f22456a = groupsOfflineGroupPartDefinition;
        this.f22457b = groupsSharedStoryPartDefinition;
        this.f22458c = groupsBasicGroupPartDefinition;
    }

    public final boolean m23528a(Object obj) {
        return true;
    }

    public static GroupsGraphQLStorySelectorPartDefinition m23525a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsGraphQLStorySelectorPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f22455e) {
                GroupsGraphQLStorySelectorPartDefinition groupsGraphQLStorySelectorPartDefinition;
                if (a2 != null) {
                    groupsGraphQLStorySelectorPartDefinition = (GroupsGraphQLStorySelectorPartDefinition) a2.a(f22455e);
                } else {
                    groupsGraphQLStorySelectorPartDefinition = f22454d;
                }
                if (groupsGraphQLStorySelectorPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23526b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f22455e, b3);
                        } else {
                            f22454d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsGraphQLStorySelectorPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

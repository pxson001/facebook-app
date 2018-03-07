package com.facebook.feedplugins.egolistview.rows;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnit;
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
/* compiled from: grid_friend_impressions */
public class GroupYouShouldJoinPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GroupsYouShouldJoinFeedUnit>, Void, FeedEnvironment> {
    private static GroupYouShouldJoinPartDefinition f12030d;
    private static final Object f12031e = new Object();
    private final GroupsYouShouldJoinHeaderPartDefinition f12032a;
    private final GroupsYouShouldJoinRecyclerViewPartDefinition<FeedEnvironment> f12033b;
    private final GroupsYouShouldJoinFooterPartDefinition f12034c;

    private static GroupYouShouldJoinPartDefinition m14081b(InjectorLike injectorLike) {
        return new GroupYouShouldJoinPartDefinition(GroupsYouShouldJoinHeaderPartDefinition.m14094a(injectorLike), GroupsYouShouldJoinRecyclerViewPartDefinition.m14106a(injectorLike), GroupsYouShouldJoinFooterPartDefinition.m14089a(injectorLike));
    }

    public final Object m14082a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        baseMultiRowSubParts.a(this.f12032a, feedProps);
        baseMultiRowSubParts.a(this.f12033b, feedProps);
        baseMultiRowSubParts.a(this.f12034c, feedProps);
        return null;
    }

    @Inject
    public GroupYouShouldJoinPartDefinition(GroupsYouShouldJoinHeaderPartDefinition groupsYouShouldJoinHeaderPartDefinition, GroupsYouShouldJoinRecyclerViewPartDefinition groupsYouShouldJoinRecyclerViewPartDefinition, GroupsYouShouldJoinFooterPartDefinition groupsYouShouldJoinFooterPartDefinition) {
        this.f12032a = groupsYouShouldJoinHeaderPartDefinition;
        this.f12033b = groupsYouShouldJoinRecyclerViewPartDefinition;
        this.f12034c = groupsYouShouldJoinFooterPartDefinition;
    }

    public final boolean m14083a(Object obj) {
        return true;
    }

    public static GroupYouShouldJoinPartDefinition m14080a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupYouShouldJoinPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12031e) {
                GroupYouShouldJoinPartDefinition groupYouShouldJoinPartDefinition;
                if (a2 != null) {
                    groupYouShouldJoinPartDefinition = (GroupYouShouldJoinPartDefinition) a2.a(f12031e);
                } else {
                    groupYouShouldJoinPartDefinition = f12030d;
                }
                if (groupYouShouldJoinPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14081b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12031e, b3);
                        } else {
                            f12030d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupYouShouldJoinPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

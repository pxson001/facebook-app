package com.facebook.feedplugins.gysc.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.FeedEnvironment;
import com.facebook.feed.rows.core.FeedListName;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.model.GraphQLGroupsYouShouldCreateFeedUnit;
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
/* compiled from: friends_who_visited_count */
public class GroupsYouShouldCreateHScrollRowPartDefinition extends BaseMultiRowGroupPartDefinition<FeedProps<GraphQLGroupsYouShouldCreateFeedUnit>, Void, FeedEnvironment> {
    private static GroupsYouShouldCreateHScrollRowPartDefinition f12828e;
    private static final Object f12829f = new Object();
    private final GroupsYouShouldCreateHeaderPartDefinition f12830a;
    private final GroupsYouShouldCreateHScrollPartDefinition f12831b;
    private final GroupsYouShouldCreateFooterPartDefinition f12832c;
    public final GatekeeperStoreImpl f12833d;

    private static GroupsYouShouldCreateHScrollRowPartDefinition m14600b(InjectorLike injectorLike) {
        return new GroupsYouShouldCreateHScrollRowPartDefinition(GroupsYouShouldCreateHeaderPartDefinition.m14603a(injectorLike), GroupsYouShouldCreateHScrollPartDefinition.m14594a(injectorLike), GroupsYouShouldCreateFooterPartDefinition.m14587a(injectorLike), GatekeeperStoreImplMethodAutoProvider.a(injectorLike));
    }

    public final Object m14601a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        FeedProps feedProps = (FeedProps) obj;
        FeedEnvironment feedEnvironment = (FeedEnvironment) anyEnvironment;
        if (this.f12833d.a(672, false) || feedEnvironment.c().a() != FeedListName.FEED) {
            baseMultiRowSubParts.a(this.f12830a, feedProps);
            baseMultiRowSubParts.a(this.f12831b, feedProps);
            baseMultiRowSubParts.a(this.f12832c, feedProps);
        }
        return null;
    }

    @Inject
    public GroupsYouShouldCreateHScrollRowPartDefinition(GroupsYouShouldCreateHeaderPartDefinition groupsYouShouldCreateHeaderPartDefinition, GroupsYouShouldCreateHScrollPartDefinition groupsYouShouldCreateHScrollPartDefinition, GroupsYouShouldCreateFooterPartDefinition groupsYouShouldCreateFooterPartDefinition, GatekeeperStoreImpl gatekeeperStoreImpl) {
        this.f12830a = groupsYouShouldCreateHeaderPartDefinition;
        this.f12831b = groupsYouShouldCreateHScrollPartDefinition;
        this.f12832c = groupsYouShouldCreateFooterPartDefinition;
        this.f12833d = gatekeeperStoreImpl;
    }

    public final boolean m14602a(Object obj) {
        return true;
    }

    public static GroupsYouShouldCreateHScrollRowPartDefinition m14599a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsYouShouldCreateHScrollRowPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f12829f) {
                GroupsYouShouldCreateHScrollRowPartDefinition groupsYouShouldCreateHScrollRowPartDefinition;
                if (a2 != null) {
                    groupsYouShouldCreateHScrollRowPartDefinition = (GroupsYouShouldCreateHScrollRowPartDefinition) a2.a(f12829f);
                } else {
                    groupsYouShouldCreateHScrollRowPartDefinition = f12828e;
                }
                if (groupsYouShouldCreateHScrollRowPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14600b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f12829f, b3);
                        } else {
                            f12828e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = groupsYouShouldCreateHScrollRowPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

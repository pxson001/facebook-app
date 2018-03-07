package com.facebook.feedplugins.egolistview.rows;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.egolistview.views.GroupsYouShouldJoinPageView;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GroupsYouShouldJoinFeedUnitItem;
import com.facebook.graphql.model.conversion.FeedUnitItemProfileHelper;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseSinglePartDefinition;
import com.facebook.multirow.api.SubParts;
import java.util.List;

@ContextScoped
/* compiled from: grid */
public class GroupsImagePartDefinition extends BaseSinglePartDefinition<GroupsYouShouldJoinFeedUnitItem, State, AnyEnvironment, GroupsYouShouldJoinPageView> {
    public static final CallerContext f12038a = CallerContext.a(GroupsYouShouldJoinPagePartDefinition.class, "native_newsfeed");
    private static GroupsImagePartDefinition f12039b;
    private static final Object f12040c = new Object();

    /* compiled from: grid */
    public class State {
        public final List<Uri> f12035a;
        public final Uri f12036b;
        public final int f12037c;

        public State(List<Uri> list, Uri uri, int i) {
            this.f12035a = list;
            this.f12036b = uri;
            this.f12037c = i;
        }
    }

    private static GroupsImagePartDefinition m14084a() {
        return new GroupsImagePartDefinition();
    }

    public final Object m14086a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GroupsYouShouldJoinFeedUnitItem groupsYouShouldJoinFeedUnitItem = (GroupsYouShouldJoinFeedUnitItem) obj;
        GraphQLProfile a = FeedUnitItemProfileHelper.a(groupsYouShouldJoinFeedUnitItem);
        return new State(GroupsYouShouldJoinPagePartDefinition.b(groupsYouShouldJoinFeedUnitItem), GroupsYouShouldJoinPagePartDefinition.a(groupsYouShouldJoinFeedUnitItem), a != null ? a.L() : 0);
    }

    public final /* bridge */ /* synthetic */ void m14087a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -805425003);
        State state = (State) obj2;
        GroupsYouShouldJoinPageView groupsYouShouldJoinPageView = (GroupsYouShouldJoinPageView) view;
        if (state.f12037c != 0 || state.f12036b == null) {
            groupsYouShouldJoinPageView.m14112a(state.f12035a, f12038a);
        } else {
            groupsYouShouldJoinPageView.m14111a(state.f12036b, f12038a);
        }
        Logger.a(8, EntryType.MARK_POP, -1280884775, a);
    }

    public static GroupsImagePartDefinition m14085a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GroupsImagePartDefinition a2;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a3 = ContextScope.a(b2);
            synchronized (f12040c) {
                GroupsImagePartDefinition groupsImagePartDefinition;
                if (a3 != null) {
                    groupsImagePartDefinition = (GroupsImagePartDefinition) a3.a(f12040c);
                } else {
                    groupsImagePartDefinition = f12039b;
                }
                if (groupsImagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m14084a();
                        if (a3 != null) {
                            a3.a(f12040c, a2);
                        } else {
                            f12039b = a2;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    a2 = groupsImagePartDefinition;
                }
            }
            return a2;
        } finally {
            a.c(b);
        }
    }
}

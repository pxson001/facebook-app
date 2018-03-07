package com.facebook.feedplugins.sgny.rows;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feedplugins.sgny.views.SaleGroupsNearYouPageView;
import com.facebook.graphql.model.GraphQLProfile;
import com.facebook.graphql.model.GraphQLSaleGroupsNearYouFeedUnitGroupsEdge;
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
/* compiled from: bundle_animation_params */
public class GroupsImagePartDefinition extends BaseSinglePartDefinition<GraphQLSaleGroupsNearYouFeedUnitGroupsEdge, State, AnyEnvironment, SaleGroupsNearYouPageView> {
    public static final CallerContext f9370a = CallerContext.a(SaleGroupsNearYouPagePartDefinition.class, "native_newsfeed");
    private static GroupsImagePartDefinition f9371b;
    private static final Object f9372c = new Object();

    /* compiled from: bundle_animation_params */
    public class State {
        public final List<Uri> f9367a;
        public final Uri f9368b;
        public final int f9369c;

        public State(List<Uri> list, Uri uri, int i) {
            this.f9367a = list;
            this.f9368b = uri;
            this.f9369c = i;
        }
    }

    private static GroupsImagePartDefinition m9966a() {
        return new GroupsImagePartDefinition();
    }

    public final Object m9968a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        GraphQLSaleGroupsNearYouFeedUnitGroupsEdge graphQLSaleGroupsNearYouFeedUnitGroupsEdge = (GraphQLSaleGroupsNearYouFeedUnitGroupsEdge) obj;
        GraphQLProfile a = FeedUnitItemProfileHelper.a(graphQLSaleGroupsNearYouFeedUnitGroupsEdge);
        return new State(SaleGroupsNearYouPagePartDefinition.b(graphQLSaleGroupsNearYouFeedUnitGroupsEdge), SaleGroupsNearYouPagePartDefinition.a(graphQLSaleGroupsNearYouFeedUnitGroupsEdge), a != null ? a.L() : 0);
    }

    public final /* bridge */ /* synthetic */ void m9969a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, -600013163);
        State state = (State) obj2;
        SaleGroupsNearYouPageView saleGroupsNearYouPageView = (SaleGroupsNearYouPageView) view;
        if (state.f9369c != 0 || state.f9368b == null) {
            saleGroupsNearYouPageView.a(state.f9367a, f9370a);
        } else {
            saleGroupsNearYouPageView.a(state.f9368b, f9370a);
        }
        Logger.a(8, EntryType.MARK_POP, 1718648511, a);
    }

    public static GroupsImagePartDefinition m9967a(InjectorLike injectorLike) {
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
            synchronized (f9372c) {
                GroupsImagePartDefinition groupsImagePartDefinition;
                if (a3 != null) {
                    groupsImagePartDefinition = (GroupsImagePartDefinition) a3.a(f9372c);
                } else {
                    groupsImagePartDefinition = f9371b;
                }
                if (groupsImagePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        injectorThreadStack.e();
                        a2 = m9966a();
                        if (a3 != null) {
                            a3.a(f9372c, a2);
                        } else {
                            f9371b = a2;
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

package com.facebook.today.ui.notificationslist;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.SubParts;
import com.facebook.multirow.api.ViewType;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.today.notifications.TodayNotificationsHolder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: transactionsQueryType */
public class TodayNotificationsSeeAllFlatPartDefinition extends MultiRowSinglePartDefinition<ReactionUnitComponentNode, State, HasReactionInteractionTracker, TodayNotificationsListSeeAllView> {
    public static final ViewType f1388a = new C01371();
    private static TodayNotificationsSeeAllFlatPartDefinition f1389e;
    private static final Object f1390f = new Object();
    private final TodayNotificationsHolder f1391b;
    private final TodayNotificationsSeeAllClickListenerProvider f1392c;
    private final Resources f1393d;

    /* compiled from: transactionsQueryType */
    final class C01371 extends ViewType {
        C01371() {
        }

        public final View m1500a(Context context) {
            return new TodayNotificationsListSeeAllView(context);
        }
    }

    /* compiled from: transactionsQueryType */
    public class State {
        public final OnClickListener f1386a;
        public final String f1387b;

        public State(String str, OnClickListener onClickListener) {
            this.f1386a = onClickListener;
            this.f1387b = str;
        }
    }

    private static TodayNotificationsSeeAllFlatPartDefinition m1502b(InjectorLike injectorLike) {
        return new TodayNotificationsSeeAllFlatPartDefinition(TodayNotificationsHolder.m1361a(injectorLike), (TodayNotificationsSeeAllClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TodayNotificationsSeeAllClickListenerProvider.class), ResourcesMethodAutoProvider.a(injectorLike));
    }

    public final Object m1504a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        OnClickListener a = this.f1392c.m1499a(Boolean.valueOf(this.f1391b.m1368a()), ((HasReactionInteractionTracker) anyEnvironment).kE_(), reactionUnitComponentNode.c, reactionUnitComponentNode.d);
        String string = this.f1393d.getString(2131239628);
        if (this.f1391b.m1368a()) {
            ReactionUnitComponentFields reactionUnitComponentFields = reactionUnitComponentNode.b;
            string = reactionUnitComponentFields.bE() == null ? null : reactionUnitComponentFields.bE().a();
        }
        return new State(string, a);
    }

    public final /* bridge */ /* synthetic */ void m1505a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1720263484);
        State state = (State) obj2;
        TodayNotificationsListSeeAllView todayNotificationsListSeeAllView = (TodayNotificationsListSeeAllView) view;
        todayNotificationsListSeeAllView.f1378a.setText(state.f1387b);
        todayNotificationsListSeeAllView.setOnClickListener(state.f1386a);
        Logger.a(8, EntryType.MARK_POP, 1898104808, a);
    }

    public final void m1507b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((TodayNotificationsListSeeAllView) view).setOnClickListener(null);
    }

    @Inject
    public TodayNotificationsSeeAllFlatPartDefinition(TodayNotificationsHolder todayNotificationsHolder, TodayNotificationsSeeAllClickListenerProvider todayNotificationsSeeAllClickListenerProvider, Resources resources) {
        this.f1391b = todayNotificationsHolder;
        this.f1392c = todayNotificationsSeeAllClickListenerProvider;
        this.f1393d = resources;
    }

    public static TodayNotificationsSeeAllFlatPartDefinition m1501a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TodayNotificationsSeeAllFlatPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1390f) {
                TodayNotificationsSeeAllFlatPartDefinition todayNotificationsSeeAllFlatPartDefinition;
                if (a2 != null) {
                    todayNotificationsSeeAllFlatPartDefinition = (TodayNotificationsSeeAllFlatPartDefinition) a2.a(f1390f);
                } else {
                    todayNotificationsSeeAllFlatPartDefinition = f1389e;
                }
                if (todayNotificationsSeeAllFlatPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1502b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1390f, b3);
                        } else {
                            f1389e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = todayNotificationsSeeAllFlatPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m1506a(Object obj) {
        return true;
    }

    public final ViewType m1503a() {
        return f1388a;
    }
}

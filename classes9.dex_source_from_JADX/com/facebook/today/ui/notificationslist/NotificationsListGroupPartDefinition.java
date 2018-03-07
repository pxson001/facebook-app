package com.facebook.today.ui.notificationslist;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.notifications.multirow.partdefinition.TodayNotificationSinglePartDefinition;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.reaction.common.ReactionUnitComponentNode;
import com.facebook.reaction.feed.common.ReactionDividerUnitComponentPartDefinition;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.today.notifications.TodayNotificationsHolder;
import javax.inject.Inject;

@ContextScoped
/* compiled from: transfer_context */
public class NotificationsListGroupPartDefinition<E extends HasInvalidate & HasReactionInteractionTracker> extends BaseMultiRowGroupPartDefinition<ReactionUnitComponentNode, Void, E> {
    private static NotificationsListGroupPartDefinition f1368e;
    private static final Object f1369f = new Object();
    private final ReactionDividerUnitComponentPartDefinition<ReactionUnitComponentNode> f1370a;
    private final TodayNotificationsSeeAllFlatPartDefinition f1371b;
    private final TodayNotificationSinglePartDefinition f1372c;
    private final TodayNotificationsHolder f1373d;

    private static NotificationsListGroupPartDefinition m1495b(InjectorLike injectorLike) {
        return new NotificationsListGroupPartDefinition(ReactionDividerUnitComponentPartDefinition.a(injectorLike), TodayNotificationsSeeAllFlatPartDefinition.m1501a(injectorLike), TodayNotificationSinglePartDefinition.a(injectorLike), TodayNotificationsHolder.m1361a(injectorLike));
    }

    public final Object m1496a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        ReactionUnitComponentNode reactionUnitComponentNode = (ReactionUnitComponentNode) obj;
        for (NotificationsEdgeFields a : this.f1373d.m1369b()) {
            baseMultiRowSubParts.a(this.f1372c, a);
        }
        if (this.f1373d.m1370e()) {
            baseMultiRowSubParts.a(this.f1370a, reactionUnitComponentNode);
            baseMultiRowSubParts.a(this.f1371b, reactionUnitComponentNode);
        }
        return null;
    }

    @Inject
    public NotificationsListGroupPartDefinition(ReactionDividerUnitComponentPartDefinition reactionDividerUnitComponentPartDefinition, TodayNotificationsSeeAllFlatPartDefinition todayNotificationsSeeAllFlatPartDefinition, TodayNotificationSinglePartDefinition todayNotificationSinglePartDefinition, TodayNotificationsHolder todayNotificationsHolder) {
        this.f1370a = reactionDividerUnitComponentPartDefinition;
        this.f1371b = todayNotificationsSeeAllFlatPartDefinition;
        this.f1372c = todayNotificationSinglePartDefinition;
        this.f1373d = todayNotificationsHolder;
    }

    public static NotificationsListGroupPartDefinition m1494a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationsListGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f1369f) {
                NotificationsListGroupPartDefinition notificationsListGroupPartDefinition;
                if (a2 != null) {
                    notificationsListGroupPartDefinition = (NotificationsListGroupPartDefinition) a2.a(f1369f);
                } else {
                    notificationsListGroupPartDefinition = f1368e;
                }
                if (notificationsListGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m1495b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f1369f, b3);
                        } else {
                            f1368e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationsListGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m1497a(Object obj) {
        return true;
    }
}

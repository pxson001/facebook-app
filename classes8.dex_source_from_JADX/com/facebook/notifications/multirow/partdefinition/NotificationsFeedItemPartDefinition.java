package com.facebook.notifications.multirow.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.reaction.feed.unitcomponents.partdefinition.ReactionVerticalComponentsNoBottomGapGroupPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: custom_cta_click_save_mobile */
public class NotificationsFeedItemPartDefinition extends BaseMultiRowGroupPartDefinition<NotificationsEdgeFields, Void, AnyEnvironment> {
    private static NotificationsFeedItemPartDefinition f16142c;
    private static final Object f16143d = new Object();
    private final Lazy<TodayNotificationSinglePartDefinition> f16144a;
    private final Lazy<ReactionVerticalComponentsNoBottomGapGroupPartDefinition> f16145b;

    private static NotificationsFeedItemPartDefinition m18963b(InjectorLike injectorLike) {
        return new NotificationsFeedItemPartDefinition(IdBasedLazy.a(injectorLike, 8705), IdBasedLazy.a(injectorLike, 10023));
    }

    public final Object m18964a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        NotificationsEdgeFields notificationsEdgeFields = (NotificationsEdgeFields) obj;
        baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f16144a.get(), notificationsEdgeFields);
        if (!(notificationsEdgeFields.n() == null || notificationsEdgeFields.gs_())) {
            baseMultiRowSubParts.a((MultiRowPartWithIsNeeded) this.f16145b.get(), notificationsEdgeFields.n());
        }
        return null;
    }

    @Inject
    public NotificationsFeedItemPartDefinition(Lazy<TodayNotificationSinglePartDefinition> lazy, Lazy<ReactionVerticalComponentsNoBottomGapGroupPartDefinition> lazy2) {
        this.f16144a = lazy;
        this.f16145b = lazy2;
    }

    public final boolean m18965a(Object obj) {
        return true;
    }

    public static NotificationsFeedItemPartDefinition m18962a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationsFeedItemPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f16143d) {
                NotificationsFeedItemPartDefinition notificationsFeedItemPartDefinition;
                if (a2 != null) {
                    notificationsFeedItemPartDefinition = (NotificationsFeedItemPartDefinition) a2.a(f16143d);
                } else {
                    notificationsFeedItemPartDefinition = f16142c;
                }
                if (notificationsFeedItemPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18963b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f16143d, b3);
                        } else {
                            f16142c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationsFeedItemPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

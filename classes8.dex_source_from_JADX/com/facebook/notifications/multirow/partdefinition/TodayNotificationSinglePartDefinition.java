package com.facebook.notifications.multirow.partdefinition;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLStorySeenState;
import com.facebook.graphql.model.GraphQLStory;
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
import com.facebook.notifications.multirow.TodayNotificationClickListenerProvider;
import com.facebook.notifications.multirow.TodayNotificationLongClickListener;
import com.facebook.notifications.multirow.TodayNotificationLongClickListenerProvider;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLInterfaces.NotificationsEdgeFields;
import com.facebook.notifications.util.NotificationsInlineActionsHelper;
import com.facebook.notifications.util.NotificationsRowWithActionHelper;
import com.facebook.notifications.util.NotificationsRowWithActionHelper.3;
import com.facebook.notifications.util.NotificationsRowWithActionHelper.RowWithActionTaken;
import com.facebook.notifications.widget.DefaultNotificationsRenderer;
import com.facebook.notifications.widget.SwitchableNotificationView;
import com.facebook.today.abtest.TodayExperimentController;
import com.facebook.today.common.HasNotifications;
import com.facebook.tools.dextr.runtime.LogUtils;
import javax.inject.Inject;

@ContextScoped
/* compiled from: custom_cta_click_delete_mobile */
public class TodayNotificationSinglePartDefinition<E extends HasInvalidate & HasNotifications> extends MultiRowSinglePartDefinition<NotificationsEdgeFields, State, E, SwitchableNotificationView> {
    public static final ViewType f16159a = new C17301();
    private static TodayNotificationSinglePartDefinition f16160g;
    private static final Object f16161h = new Object();
    private final NotificationsInlineActionsHelper f16162b;
    private final DefaultNotificationsRenderer f16163c;
    private final NotificationsRowWithActionHelper f16164d;
    private final TodayNotificationClickListenerProvider f16165e;
    private final TodayNotificationLongClickListenerProvider f16166f;

    /* compiled from: custom_cta_click_delete_mobile */
    final class C17301 extends ViewType {
        C17301() {
        }

        public final View m18975a(Context context) {
            return LayoutInflater.from(context).inflate(2130907358, null);
        }
    }

    /* compiled from: custom_cta_click_delete_mobile */
    public class State {
        public final NotificationsEdgeFields f16155a;
        public final OnClickListener f16156b;
        public final OnLongClickListener f16157c;
        public final OnClickListener f16158d;

        public State(NotificationsEdgeFields notificationsEdgeFields, OnClickListener onClickListener, OnLongClickListener onLongClickListener, OnClickListener onClickListener2) {
            this.f16155a = notificationsEdgeFields;
            this.f16156b = onClickListener;
            this.f16157c = onLongClickListener;
            this.f16158d = onClickListener2;
        }
    }

    private static TodayNotificationSinglePartDefinition m18978b(InjectorLike injectorLike) {
        return new TodayNotificationSinglePartDefinition(NotificationsInlineActionsHelper.a(injectorLike), DefaultNotificationsRenderer.a(injectorLike), NotificationsRowWithActionHelper.a(injectorLike), (TodayNotificationClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TodayNotificationClickListenerProvider.class), (TodayNotificationLongClickListenerProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(TodayNotificationLongClickListenerProvider.class));
    }

    public final Object m18980a(SubParts subParts, Object obj, AnyEnvironment anyEnvironment) {
        final NotificationsEdgeFields notificationsEdgeFields = (NotificationsEdgeFields) obj;
        final HasInvalidate hasInvalidate = (HasInvalidate) anyEnvironment;
        OnClickListener c17312 = new OnClickListener(this) {
            final /* synthetic */ TodayNotificationSinglePartDefinition f16154c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1720413872);
                ((HasNotifications) hasInvalidate).mo976a(notificationsEdgeFields, !notificationsEdgeFields.gs_());
                hasInvalidate.hL_();
                LogUtils.a(-237290701, a);
            }
        };
        OnClickListener a = this.f16165e.m18961a(notificationsEdgeFields, hasInvalidate);
        TodayNotificationLongClickListenerProvider todayNotificationLongClickListenerProvider = this.f16166f;
        return new State(notificationsEdgeFields, a, new TodayNotificationLongClickListener(notificationsEdgeFields, NotificationsInlineActionsHelper.a(todayNotificationLongClickListenerProvider), NotificationsRowWithActionHelper.a(todayNotificationLongClickListenerProvider), TodayExperimentController.a(todayNotificationLongClickListenerProvider)), c17312);
    }

    public final /* bridge */ /* synthetic */ void m18981a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 807783934);
        m18977a((State) obj2, (SwitchableNotificationView) view);
        Logger.a(8, EntryType.MARK_POP, -1021447646, a);
    }

    public final void m18983b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        SwitchableNotificationView switchableNotificationView = (SwitchableNotificationView) view;
        switchableNotificationView.setOnClickListener(null);
        if (this.f16162b.b()) {
            switchableNotificationView.setOnLongClickListener(null);
        }
    }

    public static TodayNotificationSinglePartDefinition m18976a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            TodayNotificationSinglePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f16161h) {
                TodayNotificationSinglePartDefinition todayNotificationSinglePartDefinition;
                if (a2 != null) {
                    todayNotificationSinglePartDefinition = (TodayNotificationSinglePartDefinition) a2.a(f16161h);
                } else {
                    todayNotificationSinglePartDefinition = f16160g;
                }
                if (todayNotificationSinglePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m18978b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f16161h, b3);
                        } else {
                            f16160g = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = todayNotificationSinglePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public TodayNotificationSinglePartDefinition(NotificationsInlineActionsHelper notificationsInlineActionsHelper, DefaultNotificationsRenderer defaultNotificationsRenderer, NotificationsRowWithActionHelper notificationsRowWithActionHelper, TodayNotificationClickListenerProvider todayNotificationClickListenerProvider, TodayNotificationLongClickListenerProvider todayNotificationLongClickListenerProvider) {
        this.f16162b = notificationsInlineActionsHelper;
        this.f16163c = defaultNotificationsRenderer;
        this.f16164d = notificationsRowWithActionHelper;
        this.f16165e = todayNotificationClickListenerProvider;
        this.f16166f = todayNotificationLongClickListenerProvider;
    }

    private void m18977a(State state, SwitchableNotificationView switchableNotificationView) {
        NotificationsEdgeFields notificationsEdgeFields = state.f16155a;
        GraphQLStory k = notificationsEdgeFields.k();
        3 a = this.f16164d.a(k.g(), k.c());
        this.f16163c.a(switchableNotificationView, notificationsEdgeFields, a, 0, false, state.f16158d);
        if (GraphQLStorySeenState.SEEN_AND_READ.equals(k.au())) {
            switchableNotificationView.setBackgroundResource(2131361920);
        } else {
            switchableNotificationView.setBackgroundResource(2131362821);
        }
        switchableNotificationView.setOnClickListener(state.f16156b);
        if (this.f16162b.b()) {
            switchableNotificationView.setOnLongClickListener(state.f16157c);
        }
        RowWithActionTaken c = this.f16164d.c(k.g());
        if (c != null && c.a().equals(k.g())) {
            this.f16163c.a(switchableNotificationView, this.f16164d.c(k.g()), this.f16164d, notificationsEdgeFields, a, 0);
            switchableNotificationView.a(com.facebook.notifications.widget.SwitchableNotificationView.State.POST_FEEDBACK, this.f16164d.c(k.g()).d());
            this.f16164d.c(k.g()).g = false;
        }
    }

    public final boolean m18982a(Object obj) {
        return true;
    }

    public final ViewType m18979a() {
        return f16159a;
    }
}

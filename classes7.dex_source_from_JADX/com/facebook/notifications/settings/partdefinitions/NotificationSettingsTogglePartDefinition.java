package com.facebook.notifications.settings.partdefinitions;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbui.widget.contentview.ContentViewWithButton;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.parts.MultiRowSinglePartDefinition;
import com.facebook.graphql.enums.GraphQLNotifOptionRowDisplayStyle;
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
import com.facebook.multirow.parts.ContentViewThumbnailUriStringPartDefinition;
import com.facebook.multirow.parts.ContentViewTitlePartDefinition;
import com.facebook.notifications.action.NotificationsActionExecutor;
import com.facebook.notifications.logging.NotificationSettingsLogger.Surface;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment.NotifOptions.Nodes;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotifOptionFragmentModel.OptionDisplayModel;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLModels.NotifOptionSetFragmentModel.OptionSetDisplayModel;
import com.facebook.notifications.settings.NotifOptionSetNode;
import com.facebook.notifications.settings.persistentstate.NotificationSettingsActivatableKey;
import com.facebook.notifications.settings.persistentstate.NotificationSettingsActivatablePersistentState;
import com.facebook.widget.SwitchCompat;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: minutiae_tables */
public class NotificationSettingsTogglePartDefinition<E extends HasContext & HasPersistentState> extends MultiRowSinglePartDefinition<NotifOptionSetNode, State, E, ContentViewWithButton> {
    public static final ViewType f8825a = ViewType.a(2130905484);
    private static NotificationSettingsTogglePartDefinition f8826e;
    private static final Object f8827f = new Object();
    public final NotificationsActionExecutor f8828b;
    private final ContentViewTitlePartDefinition f8829c;
    private final ContentViewThumbnailUriStringPartDefinition f8830d;

    /* compiled from: minutiae_tables */
    public class State {
        public final Nodes f8822a;
        public final Nodes f8823b;
        public final NotificationSettingsActivatablePersistentState f8824c;

        public State(Nodes nodes, Nodes nodes2, NotificationSettingsActivatablePersistentState notificationSettingsActivatablePersistentState) {
            this.f8822a = nodes;
            this.f8823b = nodes2;
            this.f8824c = notificationSettingsActivatablePersistentState;
        }
    }

    private static NotificationSettingsTogglePartDefinition m10754b(InjectorLike injectorLike) {
        return new NotificationSettingsTogglePartDefinition(NotificationsActionExecutor.a(injectorLike), ContentViewTitlePartDefinition.m9521a(injectorLike), ContentViewThumbnailUriStringPartDefinition.m9518a(injectorLike));
    }

    public final /* bridge */ /* synthetic */ void m10757a(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        int a = Logger.a(8, EntryType.MARK_PUSH, 1321115769);
        final State state = (State) obj2;
        final HasContext hasContext = (HasContext) anyEnvironment;
        final ContentViewWithButton contentViewWithButton = (ContentViewWithButton) view;
        SwitchCompat switchCompat = (SwitchCompat) contentViewWithButton.a;
        switchCompat.setChecked(state.f8824c.f8841a);
        switchCompat.setOnCheckedChangeListener(new OnCheckedChangeListener(this) {
            final /* synthetic */ NotificationSettingsTogglePartDefinition f8821d;

            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                this.f8821d.f8828b.a(hasContext.getContext(), z ? state.f8822a : state.f8823b, Surface.TOGGLE);
                state.f8824c.f8841a = z;
                contentViewWithButton.setThumbnailUri(z ? state.f8822a.mo462d().m10461d().m10448a() : state.f8823b.mo462d().m10461d().m10448a());
            }
        });
        Logger.a(8, EntryType.MARK_POP, -1632244831, a);
    }

    public final boolean m10758a(Object obj) {
        NotifOptionSetNode notifOptionSetNode = (NotifOptionSetNode) obj;
        OptionSetDisplayModel d = notifOptionSetNode.f8710a.mo468d();
        if (d == null || Strings.isNullOrEmpty(d.m10510b()) || notifOptionSetNode.f8710a.mo467c() == null || notifOptionSetNode.f8710a.mo467c().mo464a().size() != 2) {
            return false;
        }
        ImmutableList a = notifOptionSetNode.f8710a.mo467c().mo464a();
        int size = a.size();
        int i = 0;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        while (i < size) {
            Nodes nodes = (Nodes) a.get(i);
            if (GraphQLNotifOptionRowDisplayStyle.TOGGLE_ON.equals(nodes.mo462d().gu_())) {
                z3 = true;
            }
            if (GraphQLNotifOptionRowDisplayStyle.TOGGLE_OFF.equals(nodes.mo462d().gu_())) {
                z2 = true;
            }
            if (nodes.mo462d() == null || nodes.mo462d().m10463j() == null || Strings.isNullOrEmpty(nodes.mo462d().m10463j().a()) || nodes.mo462d().m10461d() == null || Strings.isNullOrEmpty(nodes.mo462d().m10461d().m10448a())) {
                return false;
            }
            boolean z4;
            if (nodes.mo461c().equals(d.m10510b())) {
                z4 = true;
            } else {
                z4 = z;
            }
            i++;
            z = z4;
        }
        if (z3 && r3 && z) {
            return true;
        }
        return false;
    }

    public final void m10759b(Object obj, Object obj2, AnyEnvironment anyEnvironment, View view) {
        ((SwitchCompat) ((ContentViewWithButton) view).a).setOnCheckedChangeListener(null);
    }

    @Inject
    public NotificationSettingsTogglePartDefinition(NotificationsActionExecutor notificationsActionExecutor, ContentViewTitlePartDefinition contentViewTitlePartDefinition, ContentViewThumbnailUriStringPartDefinition contentViewThumbnailUriStringPartDefinition) {
        this.f8828b = notificationsActionExecutor;
        this.f8829c = contentViewTitlePartDefinition;
        this.f8830d = contentViewThumbnailUriStringPartDefinition;
    }

    public static NotificationSettingsTogglePartDefinition m10752a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationSettingsTogglePartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8827f) {
                NotificationSettingsTogglePartDefinition notificationSettingsTogglePartDefinition;
                if (a2 != null) {
                    notificationSettingsTogglePartDefinition = (NotificationSettingsTogglePartDefinition) a2.a(f8827f);
                } else {
                    notificationSettingsTogglePartDefinition = f8826e;
                }
                if (notificationSettingsTogglePartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10754b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8827f, b3);
                        } else {
                            f8826e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationSettingsTogglePartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final ViewType m10755a() {
        return f8825a;
    }

    private State m10751a(SubParts<E> subParts, NotifOptionSetNode notifOptionSetNode, E e) {
        Nodes nodes = null;
        NotificationSettingsActivatablePersistentState notificationSettingsActivatablePersistentState = (NotificationSettingsActivatablePersistentState) ((HasPersistentState) e).a(new NotificationSettingsActivatableKey(notifOptionSetNode.m10674f().mo466b()), notifOptionSetNode);
        String b = notifOptionSetNode.m10674f().mo468d().m10510b();
        ImmutableList a = notifOptionSetNode.m10674f().mo467c().mo464a();
        int size = a.size();
        Nodes nodes2 = null;
        for (int i = 0; i < size; i++) {
            Nodes nodes3 = (Nodes) a.get(i);
            GraphQLNotifOptionRowDisplayStyle gu_ = nodes3.mo462d().gu_();
            if (GraphQLNotifOptionRowDisplayStyle.TOGGLE_ON.equals(gu_)) {
                nodes2 = nodes3;
            } else if (GraphQLNotifOptionRowDisplayStyle.TOGGLE_OFF.equals(gu_)) {
                nodes = nodes3;
            }
            if (!notificationSettingsActivatablePersistentState.m10767b() && nodes3.mo461c().equals(b)) {
                boolean z;
                m10753a(subParts, nodes3);
                if (GraphQLNotifOptionRowDisplayStyle.TOGGLE_ON == gu_) {
                    z = true;
                } else {
                    z = false;
                }
                notificationSettingsActivatablePersistentState.f8841a = z;
                notificationSettingsActivatablePersistentState.f8842b = true;
            }
        }
        return new State(nodes2, nodes, notificationSettingsActivatablePersistentState);
    }

    private void m10753a(SubParts<E> subParts, Nodes nodes) {
        OptionDisplayModel d = nodes.mo462d();
        subParts.a(this.f8829c, d.m10463j().a());
        if (d.m10461d() != null) {
            subParts.a(this.f8830d, d.m10461d().m10448a());
        }
    }
}

package com.facebook.notifications.settings.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.graphql.enums.GraphQLNotifOptionRowDisplayStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment.NotifOptions.Nodes;
import com.facebook.notifications.settings.NotifOptionNode;
import com.facebook.notifications.settings.NotifOptionSetNode;
import com.facebook.notifications.settings.NotificationSettingsOptionsStyleMapper;
import com.facebook.notifications.settings.persistentstate.NotificationSettingsRemovableRowKey;
import com.facebook.notifications.settings.persistentstate.NotificationSettingsRemovableRowPersistentState;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: minutiae_verb_background_fetch_failed */
public class NotificationSettingsRemovableGroupPartDefinition<E extends HasPersistentState> extends BaseMultiRowGroupPartDefinition<NotifOptionSetNode, Void, E> {
    private static NotificationSettingsRemovableGroupPartDefinition f8779b;
    private static final Object f8780c = new Object();
    private final NotificationSettingsOptionsStyleMapper f8781a;

    /* compiled from: minutiae_verb_background_fetch_failed */
    public class Props {
        public final NotifOptionNode f8777a;
        public final NotificationSettingsRemovableRowPersistentState f8778b;

        public Props(NotifOptionNode notifOptionNode, NotificationSettingsRemovableRowPersistentState notificationSettingsRemovableRowPersistentState) {
            this.f8777a = notifOptionNode;
            this.f8778b = notificationSettingsRemovableRowPersistentState;
        }
    }

    private static NotificationSettingsRemovableGroupPartDefinition m10728b(InjectorLike injectorLike) {
        return new NotificationSettingsRemovableGroupPartDefinition(NotificationSettingsOptionsStyleMapper.m10702a(injectorLike));
    }

    public final Object m10729a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        NotifOptionSetNode notifOptionSetNode = (NotifOptionSetNode) obj;
        NotificationSettingsRemovableRowPersistentState notificationSettingsRemovableRowPersistentState = (NotificationSettingsRemovableRowPersistentState) ((HasPersistentState) anyEnvironment).a(new NotificationSettingsRemovableRowKey(notifOptionSetNode.f8710a.mo466b()), notifOptionSetNode);
        if (notifOptionSetNode.f8710a.mo467c() != null) {
            ImmutableList a = notifOptionSetNode.f8710a.mo467c().mo464a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                Nodes nodes = (Nodes) a.get(i);
                if (nodes.mo462d() != null) {
                    GraphQLNotifOptionRowDisplayStyle gu_ = nodes.mo462d().gu_();
                    if (this.f8781a.m10705b(gu_)) {
                        if (!notificationSettingsRemovableRowPersistentState.f8848a.contains(nodes.mo461c())) {
                            baseMultiRowSubParts.a(this.f8781a.m10704a(gu_), new Props(new NotifOptionNode(nodes), notificationSettingsRemovableRowPersistentState));
                        }
                    }
                }
            }
        }
        return null;
    }

    public final boolean m10730a(Object obj) {
        NotifOptionSetNode notifOptionSetNode = (NotifOptionSetNode) obj;
        return notifOptionSetNode.f8710a.mo467c() != null && CollectionUtil.b(notifOptionSetNode.f8710a.mo467c().mo464a());
    }

    @Inject
    public NotificationSettingsRemovableGroupPartDefinition(NotificationSettingsOptionsStyleMapper notificationSettingsOptionsStyleMapper) {
        this.f8781a = notificationSettingsOptionsStyleMapper;
    }

    public static NotificationSettingsRemovableGroupPartDefinition m10727a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationSettingsRemovableGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8780c) {
                NotificationSettingsRemovableGroupPartDefinition notificationSettingsRemovableGroupPartDefinition;
                if (a2 != null) {
                    notificationSettingsRemovableGroupPartDefinition = (NotificationSettingsRemovableGroupPartDefinition) a2.a(f8780c);
                } else {
                    notificationSettingsRemovableGroupPartDefinition = f8779b;
                }
                if (notificationSettingsRemovableGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10728b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8780c, b3);
                        } else {
                            f8779b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationSettingsRemovableGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

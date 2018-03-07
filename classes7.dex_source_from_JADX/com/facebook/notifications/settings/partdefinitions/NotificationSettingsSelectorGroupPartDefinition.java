package com.facebook.notifications.settings.partdefinitions;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.CollectionUtil;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.graphql.enums.GraphQLNotifOptionRowSetDisplayStyle;
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
import com.facebook.notifications.settings.persistentstate.NotificationSettingsMultiSelectorKey;
import com.facebook.notifications.settings.persistentstate.NotificationSettingsMultiSelectorPersistentState;
import com.facebook.notifications.settings.persistentstate.NotificationSettingsSingleSelectorKey;
import com.facebook.notifications.settings.persistentstate.NotificationSettingsSingleSelectorPersistentState;
import com.facebook.notifications.settings.persistentstate.SelectablePersistentState;
import javax.inject.Inject;

@ContextScoped
/* compiled from: minutiae_taggable_object_fetch_fail */
public class NotificationSettingsSelectorGroupPartDefinition<E extends HasPersistentState> extends BaseMultiRowGroupPartDefinition<NotifOptionSetNode, Void, E> {
    private static NotificationSettingsSelectorGroupPartDefinition f8785b;
    private static final Object f8786c = new Object();
    private final NotificationSettingsSelectorPartDefinition f8787a;

    /* compiled from: minutiae_taggable_object_fetch_fail */
    public class Props {
        public final NotifOptionNode f8782a;
        public final boolean f8783b;
        public final SelectablePersistentState f8784c;

        public Props(NotifOptionNode notifOptionNode, boolean z, SelectablePersistentState selectablePersistentState) {
            this.f8782a = notifOptionNode;
            this.f8783b = z;
            this.f8784c = selectablePersistentState;
        }
    }

    private static NotificationSettingsSelectorGroupPartDefinition m10732b(InjectorLike injectorLike) {
        return new NotificationSettingsSelectorGroupPartDefinition(NotificationSettingsSelectorPartDefinition.m10737a(injectorLike));
    }

    private static boolean m10734b(NotifOptionSetNode notifOptionSetNode) {
        return notifOptionSetNode.f8710a.mo468d().mo465c() == GraphQLNotifOptionRowSetDisplayStyle.SINGLE_SELECTOR;
    }

    public final Object m10735a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        SelectablePersistentState selectablePersistentState;
        NotifOptionSetNode notifOptionSetNode = (NotifOptionSetNode) obj;
        HasPersistentState hasPersistentState = (HasPersistentState) anyEnvironment;
        if (m10734b(notifOptionSetNode)) {
            NotificationSettingsSingleSelectorPersistentState notificationSettingsSingleSelectorPersistentState = (NotificationSettingsSingleSelectorPersistentState) hasPersistentState.a(new NotificationSettingsSingleSelectorKey(notifOptionSetNode.g()), notifOptionSetNode);
            if (!notificationSettingsSingleSelectorPersistentState.f8852b) {
                notificationSettingsSingleSelectorPersistentState.f8851a = notifOptionSetNode.f8710a.mo468d().m10510b();
                notificationSettingsSingleSelectorPersistentState.f8852b = true;
            }
            selectablePersistentState = notificationSettingsSingleSelectorPersistentState;
        } else {
            selectablePersistentState = m10733b(hasPersistentState, notifOptionSetNode);
        }
        for (int i = 0; i < notifOptionSetNode.f8710a.mo467c().mo464a().size(); i++) {
            baseMultiRowSubParts.a(this.f8787a, new Props(new NotifOptionNode((Nodes) notifOptionSetNode.f8710a.mo467c().mo464a().get(i)), m10734b(notifOptionSetNode), selectablePersistentState));
        }
        return null;
    }

    public final boolean m10736a(Object obj) {
        NotifOptionSetNode notifOptionSetNode = (NotifOptionSetNode) obj;
        return (notifOptionSetNode.f8710a.mo468d() == null || notifOptionSetNode.f8710a.mo467c() == null || !CollectionUtil.b(notifOptionSetNode.f8710a.mo467c().mo464a())) ? false : true;
    }

    @Inject
    public NotificationSettingsSelectorGroupPartDefinition(NotificationSettingsSelectorPartDefinition notificationSettingsSelectorPartDefinition) {
        this.f8787a = notificationSettingsSelectorPartDefinition;
    }

    public static NotificationSettingsSelectorGroupPartDefinition m10731a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationSettingsSelectorGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8786c) {
                NotificationSettingsSelectorGroupPartDefinition notificationSettingsSelectorGroupPartDefinition;
                if (a2 != null) {
                    notificationSettingsSelectorGroupPartDefinition = (NotificationSettingsSelectorGroupPartDefinition) a2.a(f8786c);
                } else {
                    notificationSettingsSelectorGroupPartDefinition = f8785b;
                }
                if (notificationSettingsSelectorGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10732b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8786c, b3);
                        } else {
                            f8785b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationSettingsSelectorGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    private static SelectablePersistentState m10733b(E e, NotifOptionSetNode notifOptionSetNode) {
        NotificationSettingsMultiSelectorPersistentState notificationSettingsMultiSelectorPersistentState = (NotificationSettingsMultiSelectorPersistentState) e.a(new NotificationSettingsMultiSelectorKey(notifOptionSetNode.g()), notifOptionSetNode);
        if (!notificationSettingsMultiSelectorPersistentState.f8846b) {
            notificationSettingsMultiSelectorPersistentState.m10771a(notifOptionSetNode.f8710a.mo468d().m10510b(), true);
            notificationSettingsMultiSelectorPersistentState.f8846b = true;
        }
        return notificationSettingsMultiSelectorPersistentState;
    }
}

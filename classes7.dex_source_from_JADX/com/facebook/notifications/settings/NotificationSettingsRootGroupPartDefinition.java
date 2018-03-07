package com.facebook.notifications.settings;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
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
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.notifications.settings.partdefinitions.NotificationSettingsGapPartDefinition;
import javax.inject.Inject;

@ContextScoped
/* compiled from: minutiae_verb_picker_time_to_fetch_end_cached */
public class NotificationSettingsRootGroupPartDefinition extends BaseMultiRowGroupPartDefinition<NotifOptionSetNode, Void, AnyEnvironment> {
    private static NotificationSettingsRootGroupPartDefinition f8748d;
    private static final Object f8749e = new Object();
    private final NotificationSettingsHeaderPartDefinition f8750a;
    private final NotificationSettingsGapPartDefinition f8751b;
    private final NotificationSettingsOptionSetsStyleMapper f8752c;

    private static NotificationSettingsRootGroupPartDefinition m10715b(InjectorLike injectorLike) {
        return new NotificationSettingsRootGroupPartDefinition(NotificationSettingsHeaderPartDefinition.m10690a(injectorLike), NotificationSettingsGapPartDefinition.m10723a(injectorLike), NotificationSettingsOptionSetsStyleMapper.m10700a(injectorLike));
    }

    public final Object m10716a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        MultiRowPartWithIsNeeded multiRowPartWithIsNeeded;
        NotifOptionSetNode notifOptionSetNode = (NotifOptionSetNode) obj;
        if (NotificationSettingsHeaderPartDefinition.m10691a(notifOptionSetNode) || notifOptionSetNode.f8711b != 0) {
            baseMultiRowSubParts.a(this.f8751b, null);
        }
        baseMultiRowSubParts.a(this.f8750a, notifOptionSetNode);
        GraphQLNotifOptionRowSetDisplayStyle c = notifOptionSetNode.f8710a.mo468d().mo465c();
        NotificationSettingsOptionSetsStyleMapper notificationSettingsOptionSetsStyleMapper = this.f8752c;
        if (notificationSettingsOptionSetsStyleMapper.f8732a.containsKey(c)) {
            multiRowPartWithIsNeeded = (MultiRowPartWithIsNeeded) notificationSettingsOptionSetsStyleMapper.f8732a.get(c);
        } else {
            multiRowPartWithIsNeeded = (MultiRowPartWithIsNeeded) notificationSettingsOptionSetsStyleMapper.f8733b.get();
        }
        baseMultiRowSubParts.a(multiRowPartWithIsNeeded, notifOptionSetNode);
        return null;
    }

    public final boolean m10717a(Object obj) {
        NotifOptionSetNode notifOptionSetNode = (NotifOptionSetNode) obj;
        return (notifOptionSetNode.f8710a.mo468d() == null || notifOptionSetNode.f8710a.mo468d().mo465c() == null) ? false : true;
    }

    @Inject
    public NotificationSettingsRootGroupPartDefinition(NotificationSettingsHeaderPartDefinition notificationSettingsHeaderPartDefinition, NotificationSettingsGapPartDefinition notificationSettingsGapPartDefinition, NotificationSettingsOptionSetsStyleMapper notificationSettingsOptionSetsStyleMapper) {
        this.f8750a = notificationSettingsHeaderPartDefinition;
        this.f8751b = notificationSettingsGapPartDefinition;
        this.f8752c = notificationSettingsOptionSetsStyleMapper;
    }

    public static NotificationSettingsRootGroupPartDefinition m10714a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationSettingsRootGroupPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f8749e) {
                NotificationSettingsRootGroupPartDefinition notificationSettingsRootGroupPartDefinition;
                if (a2 != null) {
                    notificationSettingsRootGroupPartDefinition = (NotificationSettingsRootGroupPartDefinition) a2.a(f8749e);
                } else {
                    notificationSettingsRootGroupPartDefinition = f8748d;
                }
                if (notificationSettingsRootGroupPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10715b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f8749e, b3);
                        } else {
                            f8748d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationSettingsRootGroupPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

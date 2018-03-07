package com.facebook.notifications.notificationsfriending.abtest;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

@ContextScoped
/* compiled from: string-array */
public class NotificationsFriendingExperimentController {
    private static NotificationsFriendingExperimentController f3999b;
    private static final Object f4000c = new Object();
    public final QeAccessor f4001a;

    private static NotificationsFriendingExperimentController m6600b(InjectorLike injectorLike) {
        return new NotificationsFriendingExperimentController(QeInternalImplMethodAutoProvider.m3744a(injectorLike));
    }

    @Inject
    public NotificationsFriendingExperimentController(QeAccessor qeAccessor) {
        this.f4001a = qeAccessor;
    }

    public final boolean m6601b() {
        return this.f4001a.mo596a(ExperimentsForNotificationsFriendingAbTestModule.f7047p, false);
    }

    public static NotificationsFriendingExperimentController m6599a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            NotificationsFriendingExperimentController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f4000c) {
                NotificationsFriendingExperimentController notificationsFriendingExperimentController;
                if (a2 != null) {
                    notificationsFriendingExperimentController = (NotificationsFriendingExperimentController) a2.mo818a(f4000c);
                } else {
                    notificationsFriendingExperimentController = f3999b;
                }
                if (notificationsFriendingExperimentController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m6600b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f4000c, b3);
                        } else {
                            f3999b = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = notificationsFriendingExperimentController;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final int m6602g() {
        return this.f4001a.mo572a(ExperimentsForNotificationsFriendingAbTestModule.f7045n, 6);
    }

    public final int m6603h() {
        return this.f4001a.mo572a(ExperimentsForNotificationsFriendingAbTestModule.f7046o, 30);
    }

    public final long m6604i() {
        return this.f4001a.mo575a(ExperimentsForNotificationsFriendingAbTestModule.f7044m, 60);
    }

    public final boolean m6608p() {
        return this.f4001a.mo596a(ExperimentsForNotificationsFriendingAbTestModule.f7042k, false) || m6605m();
    }

    public final boolean m6605m() {
        return this.f4001a.mo596a(ExperimentsForNotificationsFriendingAbTestModule.f7040i, false);
    }

    public final boolean m6606n() {
        return this.f4001a.mo596a(ExperimentsForNotificationsFriendingAbTestModule.f7041j, false);
    }

    public final boolean m6607o() {
        return this.f4001a.mo596a(ExperimentsForNotificationsFriendingAbTestModule.f7039h, false);
    }
}

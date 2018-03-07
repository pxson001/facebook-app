package com.facebook.notifications.abtest;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.graphql.enums.GraphQLNotifOptionRowSetDisplayStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: method_key */
public class NotificationsJewelExperimentController {
    public final QeAccessor f7750a;
    public final Resources f7751b;

    public static NotificationsJewelExperimentController m8058b(InjectorLike injectorLike) {
        return new NotificationsJewelExperimentController(ResourcesMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public NotificationsJewelExperimentController(Resources resources, QeAccessor qeAccessor) {
        this.f7750a = qeAccessor;
        this.f7751b = resources;
    }

    public static NotificationsJewelExperimentController m8057a(InjectorLike injectorLike) {
        return m8058b(injectorLike);
    }

    public final String m8059c() {
        return this.f7750a.a(ExperimentsForNotificationsAbtestModule.f7782u, this.f7751b.getString(2131233705));
    }

    public final String m8060f() {
        return this.f7750a.a(ExperimentsForNotificationsAbtestModule.f7775n, GraphQLNotifOptionRowSetDisplayStyle.LONGPRESS_MENU.name());
    }

    public final boolean m8061k() {
        return this.f7750a.a(ExperimentsForNotificationsAbtestModule.f7752A, false);
    }
}

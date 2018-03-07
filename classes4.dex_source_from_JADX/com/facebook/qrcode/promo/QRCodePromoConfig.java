package com.facebook.qrcode.promo;

import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import javax.inject.Inject;

/* compiled from: load_type */
public class QRCodePromoConfig {
    private final GatekeeperStoreImpl f9221a;
    private final QeAccessor f9222b;

    public static QRCodePromoConfig m9570b(InjectorLike injectorLike) {
        return new QRCodePromoConfig(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public QRCodePromoConfig(GatekeeperStoreImpl gatekeeperStoreImpl, QeAccessor qeAccessor) {
        this.f9221a = gatekeeperStoreImpl;
        this.f9222b = qeAccessor;
    }

    public final boolean m9572a() {
        if (m9571c()) {
            return this.f9222b.a(ExperimentsForQRCodePromoModule.b, true);
        }
        return false;
    }

    public final boolean m9573b() {
        if (m9571c()) {
            return this.f9222b.a(ExperimentsForQRCodePromoModule.a, true);
        }
        return false;
    }

    private boolean m9571c() {
        return this.f9221a.a(6).asBoolean(false);
    }
}

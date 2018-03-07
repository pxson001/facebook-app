package com.facebook.abtest.qe.login;

import com.facebook.abtest.qe.service.QuickExperimentDataMaintenanceHelper;
import com.facebook.abtest.qe.service.QuickExperimentDataMaintenanceHelper.C00841;
import com.facebook.auth.component.persistent.PersistentComponent;
import com.facebook.auth.component.persistent.PersistentComponent.ComponentType;
import com.facebook.common.util.SecureHashUtil;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.qe.api.manager.QeManager;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: syncType */
public class QePersistentComponent implements PersistentComponent {
    private final QuickExperimentDataMaintenanceHelper f1507a;
    private final Provider<String> f1508b;
    private final QeManager f1509c;

    @Inject
    public QePersistentComponent(QuickExperimentDataMaintenanceHelper quickExperimentDataMaintenanceHelper, Provider<String> provider, QeManager qeManager) {
        this.f1507a = quickExperimentDataMaintenanceHelper;
        this.f1508b = provider;
        this.f1509c = qeManager;
    }

    public final void mo94a() {
        String str = (String) this.f1508b.get();
        this.f1509c.a(str == null ? null : SecureHashUtil.a(str));
    }

    public final boolean cn_() {
        if (this.f1509c.f()) {
            return false;
        }
        this.f1507a.m1358a();
        return true;
    }

    public final BatchComponent mo95c() {
        return new C00841(this.f1507a, false);
    }

    public final void mo97d() {
        this.f1509c.b();
    }

    public final ComponentType mo98e() {
        return ComponentType.QE;
    }
}

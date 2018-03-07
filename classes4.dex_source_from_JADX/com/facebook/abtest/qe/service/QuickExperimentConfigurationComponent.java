package com.facebook.abtest.qe.service;

import com.facebook.config.background.ConfigurationComponent;
import com.facebook.gk.store.GatekeeperStore;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.inject.Lazy;
import javax.inject.Inject;

/* compiled from: rtc_logging_uni */
public class QuickExperimentConfigurationComponent implements ConfigurationComponent {
    public final Lazy<QuickExperimentDataMaintenanceHelper> f3261a;
    private final GatekeeperStoreImpl f3262b;

    @Inject
    public QuickExperimentConfigurationComponent(Lazy<QuickExperimentDataMaintenanceHelper> lazy, GatekeeperStore gatekeeperStore) {
        this.f3261a = lazy;
        this.f3262b = gatekeeperStore;
    }

    public final BatchComponent mo101b() {
        boolean a = this.f3262b.a(295, false);
        boolean a2 = this.f3262b.a(519, false);
        if (a || !a2) {
            return null;
        }
        return new MyBatchComponent(this);
    }

    public final long co_() {
        return 14400000;
    }
}

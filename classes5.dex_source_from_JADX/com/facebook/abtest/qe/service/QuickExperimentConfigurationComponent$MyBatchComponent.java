package com.facebook.abtest.qe.service;

import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import java.util.Map;

/* compiled from: topic_pyml */
class QuickExperimentConfigurationComponent$MyBatchComponent implements BatchComponent {
    final /* synthetic */ QuickExperimentConfigurationComponent f1773a;

    public QuickExperimentConfigurationComponent$MyBatchComponent(QuickExperimentConfigurationComponent quickExperimentConfigurationComponent) {
        this.f1773a = quickExperimentConfigurationComponent;
    }

    public final Iterable<BatchOperation> m2453a() {
        return ((QuickExperimentDataMaintenanceHelper) this.f1773a.a.get()).b(false);
    }

    public final void m2454a(Map<String, Object> map) {
        ((QuickExperimentDataMaintenanceHelper) this.f1773a.a.get()).a(map, false);
    }
}

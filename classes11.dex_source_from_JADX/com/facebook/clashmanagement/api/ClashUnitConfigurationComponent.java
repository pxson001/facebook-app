package com.facebook.clashmanagement.api;

import com.facebook.config.background.ConfigurationComponent;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: kpi */
public class ClashUnitConfigurationComponent implements ConfigurationComponent {
    private final ClashUnitDataMaintenanceHelper f5908a;

    private static ClashUnitConfigurationComponent m7303b(InjectorLike injectorLike) {
        return new ClashUnitConfigurationComponent(ClashUnitDataMaintenanceHelper.a(injectorLike));
    }

    @Inject
    public ClashUnitConfigurationComponent(ClashUnitDataMaintenanceHelper clashUnitDataMaintenanceHelper) {
        this.f5908a = clashUnitDataMaintenanceHelper;
    }

    public final BatchComponent m7304b() {
        return this.f5908a.e();
    }

    public final long co_() {
        return 7200000;
    }
}

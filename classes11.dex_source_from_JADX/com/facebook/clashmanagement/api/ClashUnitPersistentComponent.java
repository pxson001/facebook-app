package com.facebook.clashmanagement.api;

import com.facebook.auth.component.persistent.PersistentComponent;
import com.facebook.auth.component.persistent.PersistentComponent.ComponentType;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;

/* compiled from: keyboardType */
public class ClashUnitPersistentComponent implements PersistentComponent {
    private final ClashUnitDataMaintenanceHelper f5909a;

    private static ClashUnitPersistentComponent m7308b(InjectorLike injectorLike) {
        return new ClashUnitPersistentComponent(ClashUnitDataMaintenanceHelper.a(injectorLike));
    }

    @Inject
    public ClashUnitPersistentComponent(ClashUnitDataMaintenanceHelper clashUnitDataMaintenanceHelper) {
        this.f5909a = clashUnitDataMaintenanceHelper;
    }

    public final void m7309a() {
        this.f5909a.c();
    }

    public final boolean cn_() {
        return this.f5909a.b();
    }

    public final BatchComponent m7310c() {
        return this.f5909a.e();
    }

    public final void m7311d() {
        this.f5909a.d();
    }

    public final ComponentType m7312e() {
        return ComponentType.OTHER;
    }
}

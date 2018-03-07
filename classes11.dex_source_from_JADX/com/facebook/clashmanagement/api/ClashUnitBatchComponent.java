package com.facebook.clashmanagement.api;

import com.facebook.clashmanagement.api.ClashUnitQueryModels.ClashUnitQueryModel;
import com.facebook.http.protocol.BatchComponent;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.inject.Assisted;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: language_packs */
public class ClashUnitBatchComponent implements BatchComponent {
    private final List<String> f5905a;
    private final ClashUnitGraphQlMethod f5906b;
    private final ClashUnitDataMaintenanceHelper f5907c;

    @Inject
    public ClashUnitBatchComponent(@Assisted List<String> list, ClashUnitGraphQlMethod clashUnitGraphQlMethod, ClashUnitDataMaintenanceHelper clashUnitDataMaintenanceHelper) {
        this.f5906b = clashUnitGraphQlMethod;
        this.f5905a = list;
        this.f5907c = clashUnitDataMaintenanceHelper;
    }

    public final Iterable<BatchOperation> m7301a() {
        Builder a = BatchOperation.a(this.f5906b, this.f5905a);
        a.c = "ClashUnits";
        return ImmutableList.of(a.a());
    }

    public final void m7302a(Map<String, Object> map) {
        this.f5907c.a((ClashUnitQueryModel) map.get("ClashUnits"));
    }
}

package com.facebook.analytics2.logger;

import com.facebook.crudolib.params.ParamsCollection;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.crudolib.params.ParamsJsonEncoder;
import com.facebook.tools.dextr.runtime.detour.TraceCompatDetour;
import java.io.Writer;

/* compiled from: t_st */
class BatchSessionMetadataHelper {
    private final ParamsCollectionPool f3438a;
    private final BatchSession f3439b;

    public BatchSessionMetadataHelper(ParamsCollectionPool paramsCollectionPool, BatchSession batchSession) {
        this.f3438a = paramsCollectionPool;
        this.f3439b = batchSession;
    }

    public final void m5652a(Writer writer) {
        ParamsCollection b = this.f3438a.m5398b();
        TraceCompatDetour.a("writeNewSessionData", 1372948351);
        try {
            b.m5421a("session_id", this.f3439b.m5583a());
            b.m5420a("seq", Integer.valueOf(this.f3439b.m5585c()));
            b.m5421a("uid", this.f3439b.m5584b());
            ParamsJsonEncoder.m5454a().m5463b(writer, b);
        } finally {
            b.m5434a();
            TraceCompatDetour.a(-1880040653);
        }
    }
}

package com.facebook.analytics2.logger;

import android.os.Build;
import android.os.Build.VERSION;
import com.facebook.analytics2.loggermodule.Analytics2LoggerModule.C02012;
import com.facebook.analytics2.loggermodule.FbandroidAppInfoProvider;
import com.facebook.crudolib.params.ParamsCollection;
import com.facebook.crudolib.params.ParamsCollectionPool;
import com.facebook.crudolib.params.ParamsJsonEncoder;
import com.facebook.tools.dextr.runtime.detour.TraceCompatDetour;
import java.io.Writer;

/* compiled from: tap_continue_reading */
class BatchFixedMetadataHelper {
    private final ParamsCollectionPool f3257a;
    private final FbandroidAppInfoProvider f3258b;
    private final C02012 f3259c;

    public BatchFixedMetadataHelper(ParamsCollectionPool paramsCollectionPool, FbandroidAppInfoProvider fbandroidAppInfoProvider, C02012 c02012) {
        this.f3257a = paramsCollectionPool;
        this.f3258b = fbandroidAppInfoProvider;
        this.f3259c = c02012;
    }

    public final void m5407a(Writer writer) {
        ParamsCollection b = this.f3257a.m5398b();
        TraceCompatDetour.a("writeFixedData", 577190018);
        try {
            b.m5420a("time", Long.valueOf(System.currentTimeMillis()));
            b.m5421a("app_id", this.f3258b.m5318a());
            b.m5421a("app_ver", this.f3258b.m5319b());
            b.m5420a("build_num", Integer.valueOf(this.f3258b.m5320c()));
            b.m5421a("device", Build.MODEL);
            b.m5421a("os_ver", VERSION.RELEASE);
            b.m5421a("device_id", this.f3259c.m5349a());
            ParamsJsonEncoder.m5454a().m5463b(writer, b);
        } finally {
            b.m5434a();
            TraceCompatDetour.a(1693243976);
        }
    }
}

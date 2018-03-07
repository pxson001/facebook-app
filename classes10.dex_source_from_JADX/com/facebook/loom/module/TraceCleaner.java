package com.facebook.loom.module;

import android.content.Context;
import com.facebook.auth.privacy.IHaveUserData;
import com.facebook.debug.log.BLog;
import com.facebook.loom.core.TraceOrchestrator;
import javax.inject.Inject;

/* compiled from: threads  */
public class TraceCleaner implements IHaveUserData {
    private Context f1450a;

    @Inject
    public TraceCleaner(Context context) {
        this.f1450a = context;
    }

    public void clearUserData() {
        if (!TraceOrchestrator.b().a(this.f1450a)) {
            BLog.a("LoomTraceCleaner", "Could not clear config or traces!");
        }
    }
}

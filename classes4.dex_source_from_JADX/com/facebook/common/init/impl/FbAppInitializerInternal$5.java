package com.facebook.common.init.impl;

import android.os.MessageQueue.IdleHandler;
import com.facebook.common.init.INeedInit;
import com.facebook.common.init.INeedInitIterator;
import com.facebook.loom.logger.api.LoomLogger;
import com.facebook.tools.dextr.runtime.detour.LoomLoggerDetour;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;

/* compiled from: nameEntries */
class FbAppInitializerInternal$5 implements IdleHandler {
    INeedInit f7309a;
    final /* synthetic */ INeedInitIterator f7310b;
    final /* synthetic */ FbAppInitializerInternal f7311c;

    FbAppInitializerInternal$5(FbAppInitializerInternal fbAppInitializerInternal, INeedInitIterator iNeedInitIterator) {
        this.f7311c = fbAppInitializerInternal;
        this.f7310b = iNeedInitIterator;
    }

    public boolean queueIdle() {
        TracerDetour.a("FbAppInitializer-LowPriUIThread", 1807874820);
        try {
            if (this.f7309a != null) {
                TracerDetour.a(this.f7309a.getClass().getName(), 543809165);
                LoomLogger.a(LoomLoggerDetour.a(-460208132), "Current INeedInit name", this.f7309a.getClass().getName());
                try {
                    int i = this.f7309a;
                    i.init();
                    TracerDetour.a(i);
                    this.f7309a = null;
                } finally {
                    TracerDetour.a(-618062705);
                    this.f7309a = null;
                }
            } else if (this.f7310b.hasNext()) {
                this.f7309a = (INeedInit) this.f7310b.next();
                this.f7310b.remove();
            }
            try {
                if (this.f7309a != null || this.f7310b.hasNext()) {
                    TracerDetour.a(949016648);
                    return true;
                }
                TracerDetour.a(-252675722);
                return false;
            } catch (Throwable th) {
                TracerDetour.a(1844923987);
            }
        } catch (Throwable th2) {
            FbAppInitializerInternal.a(this.f7311c, th2);
            TracerDetour.a(-2086649596);
            return false;
        }
    }
}

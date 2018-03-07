package com.facebook.imagepipeline.producers;

import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
/* compiled from: media_upload_append_records_on_restart */
public abstract class BaseConsumer<T> {
    private boolean f14499a = false;

    protected abstract void mo2788a(T t, boolean z);

    protected abstract void mo2790b(Throwable th);

    protected abstract void mo2791c();

    public final synchronized void m20910b(@Nullable T t, boolean z) {
        if (!this.f14499a) {
            this.f14499a = z;
            try {
                mo2788a(t, z);
            } catch (Exception e) {
                m20904a(e);
            }
        }
    }

    public final synchronized void m20907a(Throwable th) {
        if (!this.f14499a) {
            this.f14499a = true;
            try {
                mo2790b(th);
            } catch (Exception e) {
                m20904a(e);
            }
        }
    }

    public final synchronized void m20908b() {
        if (!this.f14499a) {
            this.f14499a = true;
            try {
                mo2791c();
            } catch (Exception e) {
                m20904a(e);
            }
        }
    }

    public final synchronized void m20905a(float f) {
        if (!this.f14499a) {
            try {
                mo2789b(f);
            } catch (Exception e) {
                m20904a(e);
            }
        }
    }

    protected void mo2789b(float f) {
    }

    private void m20904a(Exception exception) {
        Class cls = getClass();
        String str = "unhandled exception";
        if (FLog.a.b(6)) {
            FLog.a.c(FLog.a(cls), str, exception);
        }
    }
}

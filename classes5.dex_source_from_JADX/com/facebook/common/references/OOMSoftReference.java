package com.facebook.common.references;

import java.lang.ref.SoftReference;

/* compiled from: alarm_manager_experiment_logged */
public class OOMSoftReference<T> {
    public SoftReference<T> f11101a = null;
    public SoftReference<T> f11102b = null;
    public SoftReference<T> f11103c = null;

    public final void m19099b() {
        if (this.f11101a != null) {
            this.f11101a.clear();
            this.f11101a = null;
        }
        if (this.f11102b != null) {
            this.f11102b.clear();
            this.f11102b = null;
        }
        if (this.f11103c != null) {
            this.f11103c.clear();
            this.f11103c = null;
        }
    }
}

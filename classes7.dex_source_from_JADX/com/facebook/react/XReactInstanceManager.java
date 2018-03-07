package com.facebook.react;

import android.content.Context;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.uimanager.UIImplementationProvider;

/* compiled from: gv_editing_entries */
public abstract class XReactInstanceManager {

    /* compiled from: gv_editing_entries */
    public class Builder extends com.facebook.react.ReactInstanceManager.Builder {
        public final ReactInstanceManager mo639a() {
            boolean z = false;
            boolean z2 = this.f11362f || this.f11358b != null;
            Assertions.a(z2, "JS Bundle File has to be provided when dev support is disabled");
            if (!(this.f11359c == null && this.f11358b == null)) {
                z = true;
            }
            Assertions.a(z, "Either MainModuleName or JS Bundle File needs to be provided");
            if (this.f11364h == null) {
                this.h = new UIImplementationProvider();
            }
            return new XReactInstanceManagerImpl((Context) Assertions.a(this.f11361e, "Application property has not been set with this builder"), this.f11367k, this.f11368l, this.f11358b, this.f11359c, this.f11357a, this.f11362f, this.f11360d, (LifecycleState) Assertions.a(this.f11363g, "Initial lifecycle state was not set"), this.f11364h, this.f11365i, this.f11366j);
        }
    }

    public static Builder m13330a() {
        return new Builder();
    }
}

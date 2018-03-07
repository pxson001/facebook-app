package com.facebook.inject;

import android.content.Context;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: wifi_status */
public class InjectorThreadStack {
    private final Context f742a;
    private final List<Context> f743b = Lists.m1296a();
    private final List<ScopeAwareInjector> f744c = Lists.m1296a();

    public InjectorThreadStack(Context context) {
        this.f742a = context;
    }

    public final void m1469a(Context context) {
        this.f743b.add(context);
    }

    public final void m1468a() {
        this.f743b.add(this.f742a);
    }

    public final void m1471b() {
        Preconditions.checkState(!this.f743b.isEmpty());
        this.f743b.remove(this.f743b.size() - 1);
    }

    public final void m1470a(ScopeAwareInjector scopeAwareInjector) {
        this.f744c.add(scopeAwareInjector);
    }

    public final void m1472c() {
        Preconditions.checkState(!this.f744c.isEmpty());
        this.f744c.remove(this.f744c.size() - 1);
    }

    public final Context m1473d() {
        return this.f743b.isEmpty() ? this.f742a : (Context) this.f743b.get(this.f743b.size() - 1);
    }

    public final ScopeAwareInjector m1474e() {
        return this.f744c.isEmpty() ? null : (ScopeAwareInjector) this.f744c.get(this.f744c.size() - 1);
    }
}

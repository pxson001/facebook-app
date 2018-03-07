package com.facebook.qe.store;

import com.facebook.common.preconditions.Preconditions;
import com.facebook.debug.log.BLog;
import com.facebook.qe.module.QeMigratedExperimentProvider;
import com.facebook.qe.schema.Schema;
import java.io.IOException;
import java.nio.ByteBuffer;

/* compiled from: typeahead_session_id */
public class Store {
    public static final Class<Store> f2102a = Store.class;
    private final StoreFs f2103b;
    public final Schema f2104c;
    public final Index f2105d;
    private final String f2106e;
    public final QeMigratedExperimentProvider f2107f;
    private final boolean f2108g;
    private final boolean f2109h;
    public volatile View f2110i;
    public volatile View f2111j;

    public static Store m4286a(StoreFs storeFs, Schema schema, Index index, String str, QeMigratedExperimentProvider qeMigratedExperimentProvider, boolean z, boolean z2) {
        return new Store(storeFs, schema, index, str, qeMigratedExperimentProvider, z, z2);
    }

    public static Store m4289b(StoreFs storeFs, Schema schema, Index index, String str, QeMigratedExperimentProvider qeMigratedExperimentProvider, boolean z, boolean z2) {
        return new Store(storeFs, schema, index, str, qeMigratedExperimentProvider, z, z2);
    }

    private Store(StoreFs storeFs, Schema schema, Index index, String str, QeMigratedExperimentProvider qeMigratedExperimentProvider, boolean z, boolean z2) {
        boolean z3;
        boolean z4 = true;
        Preconditions.m2017b(storeFs != null);
        if (schema != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.m2017b(z3);
        if (index != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.m2017b(z3);
        if (str == null || str.isEmpty()) {
            z3 = false;
        } else {
            z3 = true;
        }
        Preconditions.m2017b(z3);
        if (qeMigratedExperimentProvider == null) {
            z4 = false;
        }
        Preconditions.m2017b(z4);
        this.f2103b = storeFs;
        this.f2104c = schema;
        this.f2105d = index;
        this.f2106e = str;
        this.f2107f = qeMigratedExperimentProvider;
        this.f2108g = z;
        this.f2109h = z2;
    }

    public final void m4293a() {
        String a = this.f2103b.m3872a(this.f2106e);
        if (a == null && !this.f2108g) {
            m4288a(false);
        } else if (a == null && this.f2108g) {
            BLog.a(f2102a, "Cannot create empty view for read-only store");
        }
        m4290e();
    }

    public final void m4294a(ByteBuffer byteBuffer) {
        Throwable e;
        if (!this.f2108g) {
            try {
                String c = this.f2104c.mo569c();
                this.f2103b.m3873a(this.f2106e, c);
                this.f2103b.m3874a(this.f2106e, c, byteBuffer.array());
                View view = new View(this.f2103b.m3876b(this.f2106e, c));
                this.f2111j = view;
                if (this.f2109h && this.f2110i.m4320a()) {
                    this.f2110i = view;
                }
            } catch (IOException e2) {
                e = e2;
                BLog.b(f2102a, "Could not update data", e);
            } catch (StoreIntegrityException e3) {
                e = e3;
                BLog.b(f2102a, "Could not update data", e);
            }
        }
    }

    private void m4291f() {
        View view = new View(this.f2103b.m3876b(this.f2106e, this.f2104c.mo569c()));
        this.f2110i = view;
        this.f2111j = view;
    }

    public final Schema m4295b() {
        return this.f2104c;
    }

    public final View m4296c() {
        return this.f2110i;
    }

    public final View m4297d() {
        return this.f2111j;
    }

    private void m4290e() {
        Throwable e;
        String a = this.f2103b.m3872a(this.f2106e);
        if (a == null && this.f2108g) {
            BLog.a(f2102a, "Using temporary empty view for read-only store");
            m4292g();
            return;
        }
        if (!(a == null || m4295b().mo569c().equals(a))) {
            try {
                if (this.f2108g) {
                    BLog.a(f2102a, "Cannot upgrade read-only store");
                    m4292g();
                    return;
                }
                m4287a(a);
            } catch (StoreIntegrityException e2) {
                e = e2;
                m4288a(false);
                BLog.b(f2102a, "Could not upgrade", e);
                m4291f();
            } catch (IOException e3) {
                e = e3;
                m4288a(false);
                BLog.b(f2102a, "Could not upgrade", e);
                m4291f();
            }
        }
        try {
            m4291f();
        } catch (StoreIntegrityException e4) {
            e = e4;
            m4288a(false);
            BLog.b(f2102a, "Could not load current view", e);
            try {
                m4291f();
            } catch (StoreIntegrityException e5) {
                e = e5;
                BLog.b(f2102a, "Could not load empty current view", e);
                m4292g();
            } catch (IOException e6) {
                e = e6;
                BLog.b(f2102a, "Could not load empty current view", e);
                m4292g();
            }
        } catch (IOException e7) {
            e = e7;
            m4288a(false);
            BLog.b(f2102a, "Could not load current view", e);
            m4291f();
        }
    }

    private void m4292g() {
        View view = new View(new ViewBuilder(this.f2104c.mo567a()));
        this.f2110i = view;
        this.f2111j = view;
    }

    private void m4288a(boolean z) {
        String c = this.f2104c.mo569c();
        Index a = Index.m4008a();
        View view = new View(new ViewBuilder(0));
        ViewBuilder viewBuilder = new ViewBuilder(this.f2104c.mo567a());
        this.f2105d.m4017a(new StoreUpgradeIndexVisitor(a, view, viewBuilder, this.f2107f));
        try {
            this.f2103b.m3873a(this.f2106e, c);
            this.f2103b.m3877b(this.f2106e, c, this.f2104c.mo570d());
            this.f2103b.m3874a(this.f2106e, c, viewBuilder.a().array());
            this.f2103b.m3879d(this.f2106e, c);
            return;
        } catch (StoreIntegrityException e) {
        } catch (IOException e2) {
        }
        if (!z) {
            this.f2103b.m3880e(this.f2106e, c);
            m4288a(true);
        }
    }

    private void m4287a(String str) {
        ByteBuffer c = this.f2103b.m3878c(this.f2106e, str);
        ByteBuffer b = this.f2103b.m3876b(this.f2106e, str);
        String c2 = this.f2104c.mo569c();
        Index index = new Index(c, true);
        View view = new View(b);
        ViewBuilder viewBuilder = new ViewBuilder(this.f2104c.mo567a());
        this.f2105d.m4017a(new StoreUpgradeIndexVisitor(index, view, viewBuilder, this.f2107f));
        byte[] array = viewBuilder.a().array();
        this.f2103b.m3873a(this.f2106e, c2);
        this.f2103b.m3877b(this.f2106e, c2, this.f2104c.mo570d());
        this.f2103b.m3874a(this.f2106e, c2, array);
        this.f2103b.m3879d(this.f2106e, c2);
    }
}

package com.facebook.analytics2.logger;

import android.support.v4.util.Pools$Pool;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.crudolib.params.ParamsCollection;
import com.facebook.crudolib.params.ParamsCollectionMap;
import com.facebook.crudolib.params.ParamsJsonEncoder;
import com.facebook.crudolib.processname.ProcessNameHelper;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: tap_profile_pic_sponsored */
public class EventBuilder {
    boolean f3212a;
    public Analytics2Logger f3213b;
    @Nullable
    public String f3214c;
    public String f3215d;
    public EventLogType f3216e;
    boolean f3217f;
    public boolean f3218g;
    @Nullable
    public String f3219h;
    @Nullable
    public String f3220i;
    @Nullable
    public Boolean f3221j;
    public long f3222k = -1;
    @Nullable
    public String f3223l;
    @Nullable
    public String f3224m;
    @Nullable
    public String f3225n;
    @Nullable
    public String f3226o;
    @Nullable
    public String f3227p;
    private final boolean f3228q;
    public ParamsCollectionMap f3229r;
    @Nullable
    public ParamsCollectionMap f3230s;
    public volatile boolean f3231t;

    EventBuilder(boolean z) {
        this.f3228q = z;
    }

    public final boolean m5385a() {
        this.f3212a = true;
        return this.f3228q;
    }

    private void m5370e() {
        if (!this.f3212a) {
            throw new IllegalStateException("isSampled was not invoked, how can you have known?");
        } else if (!this.f3228q) {
            throw new IllegalStateException("Event is not sampled");
        }
    }

    final void m5383a(Analytics2Logger analytics2Logger, @Nullable String str, String str2, EventLogType eventLogType, boolean z) {
        this.f3213b = analytics2Logger;
        this.f3214c = str;
        this.f3215d = str2;
        this.f3216e = eventLogType;
        this.f3217f = z;
        this.f3229r = analytics2Logger.f3206g.m5398b();
        this.f3229r.m5438a(ParamsJsonEncoder.m5454a());
        m5372g();
    }

    private void m5371f() {
        m5373i();
        if (this.f3229r == null && this.f3230s == null) {
            Pools$Pool pools$Pool = this.f3213b.f3200a;
            this.f3214c = null;
            this.f3215d = null;
            this.f3216e = null;
            this.f3217f = false;
            this.f3219h = null;
            this.f3221j = null;
            this.f3222k = -1;
            this.f3223l = null;
            this.f3224m = null;
            this.f3225n = null;
            this.f3226o = null;
            this.f3227p = null;
            this.f3213b = null;
            this.f3220i = null;
            this.f3212a = false;
            this.f3218g = false;
            pools$Pool.mo741a(this);
            return;
        }
        throw new IllegalStateException("Must call ejectBaseParameters before release");
    }

    private void m5372g() {
        m5373i();
        this.f3231t = true;
    }

    private void m5373i() {
        if (this.f3231t) {
            throw new IllegalStateException("Expected immutability");
        }
    }

    private void m5374j() {
        if (!this.f3231t) {
            throw new IllegalStateException("Expected mutability");
        }
    }

    private void m5375k() {
        m5370e();
        m5374j();
    }

    public final EventBuilder m5379a(String str) {
        m5375k();
        if (str == null) {
            throw new IllegalArgumentException("processName cannot be null if specified explicitly");
        }
        this.f3219h = str;
        return this;
    }

    public final EventBuilder m5378a(long j) {
        m5375k();
        this.f3222k = j;
        return this;
    }

    public final EventBuilder m5382a(@Nullable String str, @Nullable String str2) {
        m5375k();
        this.f3223l = str;
        this.f3224m = str2;
        return this;
    }

    public final EventBuilder m5386b(@Nullable String str) {
        m5375k();
        this.f3225n = str;
        return this;
    }

    @Deprecated
    public final EventBuilder m5387b(@Nullable String str, @Nullable String str2) {
        m5375k();
        this.f3226o = str;
        this.f3227p = str2;
        return this;
    }

    public final EventBuilder m5389d(String str, String str2) {
        m5375k();
        m5388c().m5421a(str, str2);
        return this;
    }

    public final EventBuilder m5381a(String str, Number number) {
        m5375k();
        m5388c().m5420a(str, number);
        return this;
    }

    public final EventBuilder m5380a(String str, Boolean bool) {
        m5375k();
        m5388c().m5419a(str, bool);
        return this;
    }

    public final void m5384a(ParamsCollectionMap paramsCollectionMap) {
        m5375k();
        if (this.f3230s != null) {
            throw new IllegalStateException("mExtras has already been set!");
        } else if (paramsCollectionMap != null) {
            this.f3230s = paramsCollectionMap;
            this.f3229r.m5418a(this.f3216e.getExtraJsonKey(), this.f3230s);
        }
    }

    public final ParamsCollectionMap m5388c() {
        m5375k();
        if (this.f3230s == null) {
            this.f3230s = this.f3213b.f3206g.m5398b();
            this.f3229r.m5418a(this.f3216e.getExtraJsonKey(), this.f3230s);
        }
        return this.f3230s;
    }

    public final void m5390d() {
        m5375k();
        if (this.f3219h == null && this.f3213b.f3204e != null && this.f3213b.f3204e.m5310a()) {
            this.f3219h = ProcessNameHelper.m2551a();
        }
        if (this.f3221j == null && this.f3213b.f3201b != null) {
            this.f3221j = Boolean.valueOf(this.f3213b.f3201b.m5348a());
        }
        if (this.f3222k == -1) {
            this.f3222k = System.currentTimeMillis();
        }
        if (this.f3213b.f3202c != null) {
            this.f3220i = ((FbNetworkManager) this.f3213b.f3202c.f3185a.get()).m3837m();
        }
        if (this.f3219h != null) {
            m5388c().m5421a("process", this.f3219h);
        }
        if (this.f3220i != null) {
            m5388c().m5421a("radio_type", this.f3220i);
        }
        this.f3229r.m5421a("log_type", this.f3216e.getProtocolValue());
        if (this.f3221j != null) {
            this.f3229r.m5421a("bg", this.f3221j.booleanValue() ? "true" : "false");
        }
        this.f3229r.m5420a("time", Double.valueOf(((double) this.f3222k) / 1000.0d));
        if (this.f3214c != null) {
            this.f3229r.m5421a("module", this.f3214c);
        }
        this.f3229r.m5421a("name", this.f3215d);
        if (this.f3223l != null) {
            this.f3229r.m5421a("obj_type", this.f3223l);
        }
        if (this.f3224m != null) {
            this.f3229r.m5421a("obj_id", this.f3224m);
        }
        if (this.f3225n != null) {
            this.f3229r.m5421a("uuid", this.f3225n);
        }
        if (this.f3226o != null) {
            this.f3229r.m5421a("interface", this.f3226o);
            this.f3229r.m5421a("src_interface", this.f3226o);
        }
        if (this.f3227p != null) {
            this.f3229r.m5421a("dst_interface", this.f3227p);
        }
        this.f3229r.m5447f();
        if (this.f3230s != null) {
            this.f3230s.m5447f();
        }
        this.f3231t = false;
        EventProcessor m;
        ParamsCollectionMap l;
        WriterHandler writerHandler;
        if (this.f3218g) {
            m = m5377m();
            l = m5376l();
            writerHandler = m.f3343a;
            writerHandler.sendMessageAtFrontOfQueue(writerHandler.obtainMessage(1, l));
        } else {
            m = m5377m();
            l = m5376l();
            writerHandler = m.f3343a;
            writerHandler.sendMessage(writerHandler.obtainMessage(1, l));
        }
        m5371f();
    }

    private ParamsCollectionMap m5376l() {
        ParamsCollection paramsCollection = this.f3229r;
        paramsCollection.m5447f();
        if (this.f3230s != null) {
            this.f3230s.m5447f();
        }
        this.f3230s = null;
        this.f3229r = null;
        return paramsCollection;
    }

    private EventProcessor m5377m() {
        if (this.f3217f) {
            return this.f3213b.f3205f.m5405d();
        }
        return this.f3213b.f3205f.m5403b();
    }
}

package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.AdError;
import com.facebook.ads.NativeAd.Image;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.util.C1975b;
import com.facebook.ads.internal.util.C1976c;
import com.facebook.ads.internal.util.C1980f;
import java.util.Map;
import org.json.JSONObject;

public class C1911k extends C1910p {
    private Context f14040a;
    private C1917n f14041b;

    public final void mo711a(int i) {
        if (this.f14041b != null) {
            C1917n c1917n = this.f14041b;
            if (i == 0 && c1917n.f14073L > 0 && c1917n.f14074M != null) {
                C1976c.m14446a(C1975b.m14442a(c1917n.f14073L, c1917n.f14074M, c1917n.f14065D));
                c1917n.f14073L = 0;
                c1917n.f14074M = null;
            }
        }
    }

    public final void mo712a(Context context, C1919q c1919q, Map<String, Object> map) {
        this.f14041b = C1917n.m14304a((JSONObject) map.get("data"));
        this.f14040a = context;
        if (this.f14041b == null || C1980f.m14454a(context, this.f14041b)) {
            AdError adError = AdError.f13883b;
            c1919q.mo736b(this);
            return;
        }
        if (c1919q != null) {
            c1919q.mo735a(this);
        }
        C1975b.f14313a = this.f14041b.f14065D;
    }

    public final void mo713a(Map<String, Object> map) {
        if (this.f14041b != null) {
            this.f14041b.m14313a((Map) map);
        }
    }

    public final void mo708b() {
    }

    public final void mo714b(Map<String, Object> map) {
        if (this.f14041b != null) {
            this.f14041b.m14312a(this.f14040a, (Map) map);
        }
    }

    public final boolean mo715c() {
        return this.f14041b.f14092s;
    }

    public final boolean mo716d() {
        return this.f14041b.f14093t;
    }

    public final int mo717e() {
        C1917n c1917n = this.f14041b;
        int i = (c1917n.f14095v < 0 || c1917n.f14095v > 100) ? 0 : c1917n.f14095v;
        return i;
    }

    public final int mo718f() {
        return this.f14041b.f14096w;
    }

    public final int mo719g() {
        return this.f14041b.f14097x;
    }

    public final Image mo720h() {
        return !m14295s() ? null : this.f14041b.f14081h;
    }

    public final Image mo721i() {
        return !m14295s() ? null : this.f14041b.f14082i;
    }

    public final String mo722j() {
        return !m14295s() ? null : this.f14041b.m14316f();
    }

    public final String mo723k() {
        return !m14295s() ? null : this.f14041b.m14317g();
    }

    public final String mo724l() {
        return !m14295s() ? null : this.f14041b.m14318h();
    }

    public final String mo725m() {
        return !m14295s() ? null : this.f14041b.m14319i();
    }

    public final String mo726n() {
        return !m14295s() ? null : this.f14041b.f14069H;
    }

    public final String mo727o() {
        return !m14295s() ? null : this.f14041b.f14098y;
    }

    public final String mo728p() {
        return !m14295s() ? null : this.f14041b.f14099z;
    }

    public final String mo729q() {
        return !m14295s() ? null : this.f14041b.f14062A;
    }

    public final AdExtras mo730r() {
        return !m14295s() ? null : this.f14041b.f14067F;
    }

    public final boolean m14295s() {
        return this.f14041b != null;
    }
}

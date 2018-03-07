package com.facebook.ads.internal.adapters;

import android.content.Context;
import com.facebook.ads.NativeAd.Image;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.server.AdPlacementType;
import java.util.Map;

public abstract class C1910p implements AdAdapter {
    public final AdPlacementType mo706a() {
        return AdPlacementType.NATIVE;
    }

    public abstract void mo711a(int i);

    public abstract void mo712a(Context context, C1919q c1919q, Map<String, Object> map);

    public abstract void mo713a(Map<String, Object> map);

    public abstract void mo714b(Map<String, Object> map);

    public abstract boolean mo715c();

    public abstract boolean mo716d();

    public abstract int mo717e();

    public abstract int mo718f();

    public abstract int mo719g();

    public abstract Image mo720h();

    public abstract Image mo721i();

    public abstract String mo722j();

    public abstract String mo723k();

    public abstract String mo724l();

    public abstract String mo725m();

    public abstract String mo726n();

    public abstract String mo727o();

    public abstract String mo728p();

    public abstract String mo729q();

    public abstract AdExtras mo730r();
}

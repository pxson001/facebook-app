package com.facebook.ads;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.ads.NativeAdView.Type;
import com.facebook.ads.internal.C1921c;
import com.facebook.ads.internal.C1945h;
import com.facebook.ads.internal.adapters.C1885c;
import com.facebook.ads.internal.adapters.C1900e;
import com.facebook.ads.internal.adapters.C1900e.C1882a;
import com.facebook.ads.internal.adapters.C1910p;
import com.facebook.ads.internal.adapters.C1918o;
import com.facebook.ads.internal.dto.C1927d;
import com.facebook.ads.internal.extra.AdExtras;
import com.facebook.ads.internal.util.C1986k;
import com.facebook.ads.internal.view.C2001o;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

public class NativeAd {
    private static final C1921c f13924a = C1921c.ADS;
    private static final String f13925b = NativeAd.class.getSimpleName();
    private static WeakHashMap<View, WeakReference<NativeAd>> f13926c = new WeakHashMap();
    private final Context f13927d;
    private final String f13928e;
    public AdListener f13929f;
    public ImpressionListener f13930g;
    public C1945h f13931h;
    private volatile boolean f13932i;
    public C1910p f13933j;
    public C1927d f13934k;
    public View f13935l;
    public List<View> f13936m;
    public OnTouchListener f13937n;
    private C1900e f13938o;
    public C1918o f13939p;
    public C1884a f13940q;
    private C2001o f13941r;
    public Type f13942s;
    public boolean f13943t;
    public boolean f13944u;
    public boolean f13945v;

    public class C18812 {
        public final /* synthetic */ NativeAd f13904a;

        C18812(NativeAd nativeAd) {
            this.f13904a = nativeAd;
        }
    }

    class C18833 extends C1882a {
        final /* synthetic */ NativeAd f13905a;

        C18833(NativeAd nativeAd) {
            this.f13905a = nativeAd;
        }

        public final void mo700a() {
            this.f13905a.f13939p.f14105g = this.f13905a.f13935l;
            this.f13905a.f13939p.f14101c = this.f13905a.f13942s;
            this.f13905a.f13939p.f14102d = this.f13905a.f13943t;
            this.f13905a.f13939p.f14103e = this.f13905a.f13944u;
            this.f13905a.f13939p.f14104f = this.f13905a.f13945v;
            this.f13905a.f13939p.m14232a();
        }
    }

    public class Image {
        public final String f13906a;
        private final int f13907b;
        private final int f13908c;

        private Image(String str, int i, int i2) {
            this.f13906a = str;
            this.f13907b = i;
            this.f13908c = i2;
        }

        public static Image m14175a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            String optString = jSONObject.optString("url");
            return optString != null ? new Image(optString, jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)) : null;
        }

        public final String m14176a() {
            return this.f13906a;
        }
    }

    public enum MediaCacheFlag {
        NONE(0),
        ICON(1),
        IMAGE(2);
        
        public static final EnumSet<MediaCacheFlag> ALL = null;
        private final long f13910a;

        static {
            ALL = EnumSet.allOf(MediaCacheFlag.class);
        }

        private MediaCacheFlag(long j) {
            this.f13910a = j;
        }

        public final long getCacheFlagValue() {
            return this.f13910a;
        }
    }

    public class Rating {
        private final double f13911a;
        private final double f13912b;

        private Rating(double d, double d2) {
            this.f13911a = d;
            this.f13912b = d2;
        }

        public static Rating m14177a(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            double optDouble = jSONObject.optDouble("value", 0.0d);
            double optDouble2 = jSONObject.optDouble("scale", 0.0d);
            return (optDouble == 0.0d || optDouble2 == 0.0d) ? null : new Rating(optDouble, optDouble2);
        }
    }

    public class C1884a implements OnClickListener, OnTouchListener {
        final /* synthetic */ NativeAd f13913a;
        public int f13914b;
        public int f13915c;
        public int f13916d;
        public int f13917e;
        public float f13918f;
        public float f13919g;
        public int f13920h;
        public int f13921i;
        private boolean f13922j;

        public C1884a(NativeAd nativeAd) {
            this.f13913a = nativeAd;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1618727904);
            if (this.f13913a.f13929f != null) {
                AdListener adListener = this.f13913a.f13929f;
            }
            if (!this.f13922j) {
                Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
            }
            Map hashMap = new HashMap();
            hashMap.put("clickX", Integer.valueOf(this.f13914b));
            hashMap.put("clickY", Integer.valueOf(this.f13915c));
            hashMap.put("width", Integer.valueOf(this.f13916d));
            hashMap.put("height", Integer.valueOf(this.f13917e));
            hashMap.put("adPositionX", Float.valueOf(this.f13918f));
            hashMap.put("adPositionY", Float.valueOf(this.f13919g));
            hashMap.put("visibleWidth", Integer.valueOf(this.f13921i));
            hashMap.put("visibleHeight", Integer.valueOf(this.f13920h));
            Map map = hashMap;
            if (this.f13913a.f13942s != null) {
                map.put("nti", String.valueOf(this.f13913a.f13942s.getValue()));
            }
            if (this.f13913a.f13943t) {
                map.put("nhs", String.valueOf(this.f13913a.f13943t));
            }
            this.f13913a.f13933j.mo714b(map);
            Logger.a(2, EntryType.UI_INPUT_END, 1765764273, a);
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0 && this.f13913a.f13935l != null) {
                this.f13916d = this.f13913a.f13935l.getWidth();
                this.f13917e = this.f13913a.f13935l.getHeight();
                int[] iArr = new int[2];
                this.f13913a.f13935l.getLocationInWindow(iArr);
                this.f13918f = (float) iArr[0];
                this.f13919g = (float) iArr[1];
                Rect rect = new Rect();
                this.f13913a.f13935l.getGlobalVisibleRect(rect);
                this.f13921i = rect.width();
                this.f13920h = rect.height();
                int[] iArr2 = new int[2];
                view.getLocationInWindow(iArr2);
                this.f13914b = (((int) motionEvent.getX()) + iArr2[0]) - iArr[0];
                this.f13915c = (iArr2[1] + ((int) motionEvent.getY())) - iArr[1];
                this.f13922j = true;
            }
            return this.f13913a.f13937n != null && this.f13913a.f13937n.onTouch(view, motionEvent);
        }
    }

    class C1886c extends C1885c {
        final /* synthetic */ NativeAd f13923a;

        public C1886c(NativeAd nativeAd) {
            this.f13923a = nativeAd;
        }

        public final void mo701a() {
            if (this.f13923a.f13930g != null) {
                ImpressionListener impressionListener = this.f13923a.f13930g;
            }
            if ((this.f13923a.f13929f instanceof ImpressionListener) && this.f13923a.f13929f != this.f13923a.f13930g) {
                AdListener adListener = this.f13923a.f13929f;
            }
        }

        public final boolean mo702b() {
            return false;
        }
    }

    public NativeAd(Context context, C1910p c1910p, C1927d c1927d) {
        this(context, null);
        this.f13934k = c1927d;
        this.f13932i = true;
        this.f13933j = c1910p;
    }

    private NativeAd(Context context, String str) {
        this.f13936m = new ArrayList();
        this.f13927d = context;
        this.f13928e = str;
    }

    public NativeAd(NativeAd nativeAd) {
        this(nativeAd.f13927d, null);
        this.f13934k = nativeAd.f13934k;
        this.f13932i = true;
        this.f13933j = nativeAd.f13933j;
    }

    public static void m14182a(Image image, ImageView imageView) {
        if (image != null && imageView != null) {
            new C1986k(imageView).execute(new String[]{image.f13906a});
        }
    }

    private boolean m14183m() {
        return this.f13933j != null;
    }

    public final Image m14184a() {
        return !m14183m() ? null : this.f13933j.mo720h();
    }

    public final void m14185a(View view, List<View> list) {
        if (view == null) {
            throw new IllegalArgumentException("Must provide a View");
        } else if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("Invalid set of clickable views");
        } else if (m14183m()) {
            if (this.f13935l != null) {
                Log.w(f13925b, "Native Ad was already registered with a View. Auto unregistering and proceeding.");
                m14198l();
            }
            if (f13926c.containsKey(view)) {
                Log.w(f13925b, "View already registered with a NativeAd. Auto unregistering and proceeding.");
                ((NativeAd) ((WeakReference) f13926c.get(view)).get()).m14198l();
            }
            this.f13940q = new C1884a(this);
            this.f13935l = view;
            if (view instanceof ViewGroup) {
                this.f13941r = new C2001o(view.getContext(), new C18812(this));
                ((ViewGroup) view).addView(this.f13941r);
            }
            for (View view2 : list) {
                this.f13936m.add(view2);
                view2.setOnClickListener(this.f13940q);
                view2.setOnTouchListener(this.f13940q);
            }
            this.f13939p = new C1918o(this.f13927d, new C1886c(this), this.f13933j);
            this.f13939p.f14106h = list;
            int i = 1;
            if (this.f13934k != null) {
                i = this.f13934k.f14144b;
            } else if (!(this.f13931h == null || this.f13931h.m14368a() == null)) {
                i = this.f13931h.m14368a().f14144b;
            }
            this.f13938o = new C1900e(this.f13927d, this.f13935l, i, new C18833(this));
            C1900e c1900e = this.f13938o;
            i = this.f13934k != null ? this.f13934k.f14144b : this.f13933j != null ? this.f13933j.mo718f() : (this.f13931h == null || this.f13931h.m14368a() == null) ? 0 : this.f13931h.m14368a().f14148f;
            c1900e.f13992a = i;
            c1900e = this.f13938o;
            i = this.f13934k != null ? this.f13934k.f14149g : this.f13933j != null ? this.f13933j.mo719g() : (this.f13931h == null || this.f13931h.m14368a() == null) ? 1000 : this.f13931h.m14368a().f14149g;
            c1900e.f13993b = i;
            this.f13938o.m14236a();
            f13926c.put(view, new WeakReference(this));
        } else {
            Log.e(f13925b, "Ad not loaded");
        }
    }

    final void m14186a(boolean z) {
        this.f13944u = z;
    }

    public final Image m14187b() {
        return !m14183m() ? null : this.f13933j.mo721i();
    }

    public final void m14188b(boolean z) {
        this.f13945v = z;
    }

    public final String m14189c() {
        return !m14183m() ? null : this.f13933j.mo722j();
    }

    public final String m14190d() {
        return !m14183m() ? null : this.f13933j.mo723k();
    }

    public final String m14191e() {
        return !m14183m() ? null : this.f13933j.mo724l();
    }

    public final String m14192f() {
        return !m14183m() ? null : this.f13933j.mo725m();
    }

    public final String m14193g() {
        return !m14183m() ? null : this.f13933j.mo726n();
    }

    public final AdExtras m14194h() {
        return !m14183m() ? null : this.f13933j.mo730r();
    }

    final String m14195i() {
        return !m14183m() ? null : this.f13933j.mo727o();
    }

    final String m14196j() {
        return !m14183m() ? null : this.f13933j.mo728p();
    }

    final String m14197k() {
        return !m14183m() ? null : this.f13933j.mo729q();
    }

    public final void m14198l() {
        if (this.f13935l != null) {
            if (f13926c.containsKey(this.f13935l) && ((WeakReference) f13926c.get(this.f13935l)).get() == this) {
                if ((this.f13935l instanceof ViewGroup) && this.f13941r != null) {
                    ((ViewGroup) this.f13935l).removeView(this.f13941r);
                    this.f13941r = null;
                }
                f13926c.remove(this.f13935l);
                for (View view : this.f13936m) {
                    view.setOnClickListener(null);
                    view.setOnTouchListener(null);
                }
                this.f13936m.clear();
                this.f13935l = null;
                if (this.f13938o != null) {
                    this.f13938o.m14237b();
                    this.f13938o = null;
                }
                this.f13939p = null;
                return;
            }
            throw new IllegalStateException("View not registered with this NativeAd");
        }
    }
}

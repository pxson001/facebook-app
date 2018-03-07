package com.facebook.android.maps;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.facebook.android.maps.FacebookMap.OnMapDoubleClickListener;
import com.facebook.android.maps.internal.AutoAnimationsHelper;
import com.facebook.android.maps.internal.AutoAnimationsHelper.Listener;
import com.facebook.android.maps.internal.GestureDetector;
import com.facebook.android.maps.internal.GrandCentralDispatch;
import com.facebook.android.maps.internal.GrandCentralDispatch.Dispatchable;
import com.facebook.android.maps.internal.MapConfig;
import com.facebook.android.maps.internal.MapConfig$OnConfigUpdateListener;
import com.facebook.android.maps.internal.SynchronizedPool;
import com.facebook.android.maps.internal.analytics.AnalyticsEvent;
import com.facebook.android.maps.model.CameraPosition;
import com.facebook.android.maps.model.LatLng;
import com.facebook.android.maps.model.TileOverlay;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.maps.delegate.MapDelegate.3;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* compiled from: b */
public class MapView extends FrameLayout implements Listener, GestureDetector.Listener, MapConfig$OnConfigUpdateListener {
    static final double f8184a = Math.log(2.0d);
    private boolean f8185A;
    private final RectF f8186B;
    private float f8187C;
    private float f8188D;
    private GestureDetector f8189E;
    private boolean f8190F;
    private final float[] f8191G;
    private final float[] f8192H;
    private AutoAnimationsHelper f8193I;
    public Queue<OnMapReadyCallback> f8194J;
    private MapDrawable f8195K;
    private long f8196L;
    private float f8197M;
    private boolean f8198N;
    private boolean f8199O;
    private boolean f8200P;
    public long f8201Q;
    public long f8202R;
    private boolean f8203S;
    private final ComponentCallbacks f8204T;
    private final BroadcastReceiver f8205U;
    boolean f8206b;
    int f8207c;
    int f8208d;
    float f8209e;
    float f8210f;
    int f8211g;
    float f8212h;
    float f8213i;
    protected float f8214j;
    final Matrix f8215k;
    final Matrix f8216l;
    double f8217m;
    double f8218n;
    double f8219o;
    double f8220p;
    boolean f8221q;
    long f8222r;
    int f8223s;
    private Context f8224t;
    private FacebookMapOptions f8225u;
    public FacebookMap f8226v;
    private UiSettings f8227w;
    private final Paint f8228x;
    private boolean f8229y;
    private boolean f8230z;

    /* compiled from: b */
    class C09111 implements ComponentCallbacks {
        final /* synthetic */ MapView f8181a;

        C09111(MapView mapView) {
            this.f8181a = mapView;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
            this.f8181a.m14366b();
        }
    }

    /* compiled from: b */
    class C09122 extends BroadcastReceiver {
        final /* synthetic */ MapView f8182a;

        C09122(MapView mapView) {
            this.f8182a = mapView;
        }

        public void onReceive(Context context, Intent intent) {
            boolean z = false;
            int a = Logger.a(2, EntryType.LIFECYCLE_BROADCAST_RECEIVER_START, 2097541487);
            if (intent != null && intent.getBooleanExtra("noConnectivity", false)) {
                z = true;
            }
            if (!z) {
                this.f8182a.invalidate();
            }
            LogUtils.a(intent, 549044634, a);
        }
    }

    /* compiled from: b */
    class C09133 extends Dispatchable {
        final /* synthetic */ MapView f8183a;

        C09133(MapView mapView) {
            this.f8183a = mapView;
        }

        public void run() {
            if (this.f8183a.f8194J != null) {
                while (true) {
                    OnMapReadyCallback onMapReadyCallback = (OnMapReadyCallback) this.f8183a.f8194J.poll();
                    if (onMapReadyCallback != null) {
                        onMapReadyCallback.m14384a(this.f8183a.f8226v);
                    } else {
                        this.f8183a.f8194J = null;
                        return;
                    }
                }
            }
        }
    }

    public MapView(Context context) {
        super(context);
        this.f8228x = new Paint(2);
        this.f8186B = new RectF();
        this.f8215k = new Matrix();
        this.f8216l = new Matrix();
        this.f8191G = new float[2];
        this.f8192H = new float[4];
        this.f8217m = 0.5d;
        this.f8218n = 0.5d;
        this.f8196L = SystemClock.uptimeMillis();
        this.f8204T = new C09111(this);
        this.f8205U = new C09122(this);
        m14342a(context, new FacebookMapOptions());
    }

    public MapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8228x = new Paint(2);
        this.f8186B = new RectF();
        this.f8215k = new Matrix();
        this.f8216l = new Matrix();
        this.f8191G = new float[2];
        this.f8192H = new float[4];
        this.f8217m = 0.5d;
        this.f8218n = 0.5d;
        this.f8196L = SystemClock.uptimeMillis();
        this.f8204T = new C09111(this);
        this.f8205U = new C09122(this);
        m14342a(context, FacebookMapOptions.m14310a(context, attributeSet));
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8228x = new Paint(2);
        this.f8186B = new RectF();
        this.f8215k = new Matrix();
        this.f8216l = new Matrix();
        this.f8191G = new float[2];
        this.f8192H = new float[4];
        this.f8217m = 0.5d;
        this.f8218n = 0.5d;
        this.f8196L = SystemClock.uptimeMillis();
        this.f8204T = new C09111(this);
        this.f8205U = new C09122(this);
        m14342a(context, FacebookMapOptions.m14310a(context, attributeSet));
    }

    public MapView(Context context, FacebookMapOptions facebookMapOptions) {
        super(context);
        this.f8228x = new Paint(2);
        this.f8186B = new RectF();
        this.f8215k = new Matrix();
        this.f8216l = new Matrix();
        this.f8191G = new float[2];
        this.f8192H = new float[4];
        this.f8217m = 0.5d;
        this.f8218n = 0.5d;
        this.f8196L = SystemClock.uptimeMillis();
        this.f8204T = new C09111(this);
        this.f8205U = new C09122(this);
        m14342a(context, facebookMapOptions);
    }

    private void m14342a(Context context, FacebookMapOptions facebookMapOptions) {
        boolean z = false;
        this.f8201Q = AnalyticsEvent.a();
        setWillNotDraw(false);
        this.f8224t = context;
        this.f8225u = facebookMapOptions;
        this.f8189E = new GestureDetector(context, this);
        this.f8189E.f8411b = this.f8216l;
        this.f8189E.f8405E = 0.87f;
        this.f8189E.f8406F = 0.85f;
        this.f8230z = this.f8224t.getPackageManager().hasSystemFeature("android.hardware.touchscreen.multitouch.distinct");
        if (VERSION.SDK_INT >= 11) {
            z = true;
        }
        this.f8185A = z;
        this.f8193I = new AutoAnimationsHelper(this, this);
        this.f8193I.f8300m = this.f8216l;
        MapConfig.h.add(new WeakReference(this));
        MapConfig.a();
    }

    @TargetApi(14)
    private void m14353j() {
        if (this.f8226v.m14302j() && !this.f8226v.f8136j.e) {
            this.f8226v.f8136j.a(true);
        }
        if (!this.f8199O) {
            if (VERSION.SDK_INT >= 14) {
                this.f8224t.registerComponentCallbacks(this.f8204T);
            }
            this.f8224t.registerReceiver(this.f8205U, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f8199O = true;
        }
    }

    @TargetApi(14)
    private void m14354k() {
        if (this.f8226v.f8136j.e) {
            this.f8226v.f8136j.a(false);
        }
        if (this.f8199O) {
            if (VERSION.SDK_INT >= 14) {
                this.f8224t.unregisterComponentCallbacks(this.f8204T);
            }
            this.f8224t.unregisterReceiver(this.f8205U);
            this.f8199O = false;
        }
        this.f8226v.m14279a();
        AnalyticsEvent.b();
    }

    @Deprecated
    public final FacebookMap getMap() {
        return this.f8226v;
    }

    public final void m14364a(OnMapReadyCallback onMapReadyCallback) {
        if (this.f8229y) {
            onMapReadyCallback.m14384a(this.f8226v);
            return;
        }
        if (this.f8194J == null) {
            this.f8194J = new LinkedList();
        }
        this.f8194J.add(onMapReadyCallback);
    }

    public final void m14363a(Bundle bundle) {
        this.f8226v = new FacebookMap(this, this.f8225u);
        if (this.f8225u.f8153a == null) {
            m14341a((int) this.f8226v.f8128b, (this.f8226v.f8128b % 1.0f) + 1.0f);
        } else {
            CameraPosition cameraPosition = this.f8225u.f8153a;
            m14341a((int) cameraPosition.f8547b, (cameraPosition.f8547b % 1.0f) + 1.0f);
            if (cameraPosition.f8546a != null) {
                this.f8217m = (double) Projection.d(cameraPosition.f8546a.f8569b);
                this.f8218n = (double) Projection.b(cameraPosition.f8546a.f8568a);
            }
            this.f8214j = cameraPosition.f8549d;
        }
        this.f8227w = this.f8226v.f8116E;
        this.f8215k.setScale(this.f8212h, this.f8212h);
        this.f8215k.postRotate(this.f8214j);
        this.f8215k.invert(this.f8216l);
        m14348c(bundle);
    }

    public static void m14340a() {
    }

    public final void m14366b() {
        int size = this.f8226v.f8135i.size();
        for (int i = 0; i < size; i++) {
            MapDrawable mapDrawable = (MapDrawable) this.f8226v.f8135i.get(i);
            if (mapDrawable instanceof TiledMapDrawable) {
                ((TiledMapDrawable) mapDrawable).mo1073q();
            }
        }
        SynchronizedPool.m14513b();
    }

    public static void m14347c() {
    }

    public static void m14350d() {
    }

    protected final void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            if (bundle.containsKey("zoom")) {
                if (bundle.containsKey("parentBundle")) {
                    super.onRestoreInstanceState(bundle.getParcelable("parentBundle"));
                }
                m14348c(bundle);
                return;
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    private void m14348c(Bundle bundle) {
        if (bundle != null && bundle.containsKey("zoom")) {
            m14341a(bundle.getInt("zoom"), bundle.getFloat("scale"));
            this.f8217m = bundle.getDouble("xVisibleCenter") - ((double) (((long) (this.f8226v.f8129c - this.f8226v.f8131e)) / (this.f8222r << 1)));
            this.f8218n = bundle.getDouble("yVisibleCenter") - ((double) (((long) (this.f8226v.f8130d - this.f8226v.f8132f)) / (this.f8222r << 1)));
            this.f8214j = bundle.getFloat("rotation");
            this.f8215k.setScale(this.f8212h, this.f8212h);
            this.f8215k.postRotate(this.f8214j);
            this.f8215k.invert(this.f8216l);
            this.f8200P = false;
        }
    }

    protected final Parcelable onSaveInstanceState() {
        if (this.f8200P) {
            return super.onSaveInstanceState();
        }
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        m14369b(bundle);
        bundle.putParcelable("parentBundle", onSaveInstanceState);
        return bundle;
    }

    public final void m14369b(Bundle bundle) {
        if (!this.f8200P) {
            bundle.putDouble("xVisibleCenter", this.f8217m + ((double) (((long) (this.f8226v.f8129c - this.f8226v.f8131e)) / (this.f8222r << 1))));
            bundle.putDouble("yVisibleCenter", this.f8218n + ((double) (((long) (this.f8226v.f8130d - this.f8226v.f8132f)) / (this.f8222r << 1))));
            bundle.putInt("zoom", this.f8211g);
            bundle.putFloat("scale", this.f8212h);
            bundle.putFloat("rotation", this.f8214j);
            this.f8200P = true;
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        long a = AnalyticsEvent.a();
        super.onLayout(z, i, i2, i3, i4);
        this.f8207c = getWidth();
        this.f8208d = getHeight();
        this.f8209e = ((float) this.f8207c) / 2.0f;
        this.f8210f = ((float) this.f8208d) / 2.0f;
        Object obj = null;
        this.f8213i = (float) Math.ceil(Math.log((double) ((int) Math.ceil((((double) Math.max(this.f8208d, this.f8207c)) * 1.0d) / ((double) this.f8226v.f8113B)))) / f8184a);
        this.f8226v.m14305n();
        if ((((float) this.f8211g) + this.f8212h) - 1.0f < this.f8226v.f8128b) {
            m14341a((int) this.f8226v.f8128b, 1.0f + (this.f8226v.f8128b % 1.0f));
            obj = 1;
        }
        m14356m();
        if (!this.f8229y) {
            m14372c((((float) this.f8211g) + this.f8212h) - 1.0f, this.f8226v.m14303k(), this.f8226v.m14304l());
            m14359a(this.f8217m, this.f8218n);
            m14374d(this.f8214j, this.f8226v.m14303k(), this.f8226v.m14304l());
            this.f8229y = true;
            obj = 1;
        }
        if (obj != null) {
            this.f8226v.m14307q();
        }
        int size = this.f8226v.f8135i.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((MapDrawable) this.f8226v.f8135i.get(i5)).mo1036b();
        }
        if (this.f8194J != null) {
            GrandCentralDispatch.c(new C09133(this));
        }
        AnalyticsEvent.b.a(AnalyticsEvent.a() - a);
    }

    private static MapDrawable m14337a(List<MapDrawable> list, float f, float f2) {
        MapDrawable mapDrawable = null;
        int i = 0;
        int size = list.size() - 1;
        while (size >= 0) {
            MapDrawable mapDrawable2;
            int i2;
            MapDrawable mapDrawable3 = (MapDrawable) list.get(size);
            if (mapDrawable3.f8084i) {
                int a = mapDrawable3.mo1031a(f, f2);
                if (a == 2) {
                    return mapDrawable3;
                }
                if (a > i) {
                    int i3 = a;
                    mapDrawable2 = mapDrawable3;
                    i2 = i3;
                    size--;
                    mapDrawable = mapDrawable2;
                    i = i2;
                }
            }
            i2 = i;
            mapDrawable2 = mapDrawable;
            size--;
            mapDrawable = mapDrawable2;
            i = i2;
        }
        return mapDrawable;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -995886380);
        long a2 = AnalyticsEvent.a();
        try {
            boolean a3 = this.f8189E.m14485a(motionEvent);
            AnalyticsEvent.c.a(AnalyticsEvent.a() - a2);
            Logger.a(2, EntryType.UI_INPUT_END, 331451852, a);
            return a3;
        } catch (Throwable th) {
            AnalyticsEvent.c.a(AnalyticsEvent.a() - a2);
            LogUtils.a(-1976329213, a);
        }
    }

    private void m14355l() {
        this.f8226v.f8138l.m14406b(true);
        this.f8221q = true;
        this.f8226v.m14279a();
        this.f8193I.m14425d();
    }

    public final void mo1047a(float f, float f2) {
        this.f8190F = false;
        this.f8198N = false;
        this.f8197M = 0.0f;
        this.f8195K = m14337a(this.f8226v.f8135i, f, f2);
        if (this.f8195K != null) {
            this.f8195K.mo1078m();
        }
    }

    public final void mo1051b(float f, float f2) {
        this.f8221q = false;
        if (this.f8190F && !this.f8193I.f8292e) {
            this.f8226v.m14307q();
        }
        if (this.f8195K != null) {
            this.f8195K.mo1079n();
        }
    }

    public final void mo1054c(float f, float f2) {
        this.f8221q = false;
        if (this.f8195K == null || !this.f8195K.mo1038b(f, f2)) {
            this.f8226v.m14293c(null);
            if (this.f8226v.f8142p != null) {
                3 3 = this.f8226v.f8142p;
                LatLng a = this.f8226v.f8137k.a(f, f2);
                3.a.a();
                return;
            }
            return;
        }
        this.f8226v.m14293c(this.f8195K);
    }

    public final void mo1056e() {
        this.f8221q = false;
        if (this.f8227w.f8286e) {
            this.f8226v.m14282a(CameraUpdateFactory.m14206b(), 200, null);
        }
    }

    public final void mo1055d(float f, float f2) {
        if (this.f8195K == null || !this.f8195K.mo1085e(f, f2)) {
            if (this.f8226v.f8143q != null) {
                this.f8226v.f8137k.a(f, f2);
            }
            this.f8221q = false;
        }
    }

    public final void mo1057e(float f, float f2) {
        this.f8221q = false;
        if (this.f8195K == null || !this.f8195K.mo1041c(f, f2)) {
            if (this.f8226v.f8144r != null) {
                OnMapDoubleClickListener onMapDoubleClickListener = this.f8226v.f8144r;
                this.f8226v.f8137k.a(f, f2);
                if (onMapDoubleClickListener.m14270a()) {
                    return;
                }
            }
            if (this.f8227w.f8286e) {
                this.f8226v.m14282a(CameraUpdateFactory.m14201a(1.0f, new Point((int) f, (int) f2)), 200, null);
            }
        }
    }

    public final void mo1049a(float f, float f2, float f3, float f4) {
        if ((this.f8195K == null || !this.f8195K.mo1077d(f, f2)) && this.f8227w.f8284c) {
            m14355l();
            m14352h(f3, f4);
            invalidate();
            if (!(this.f8226v.f8133g == null && this.f8226v.f8134h.isEmpty()) && (Math.abs(f3) > 1.0f || Math.abs(f4) > 1.0f)) {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (uptimeMillis - this.f8196L >= 200) {
                    this.f8226v.m14307q();
                    this.f8196L = uptimeMillis;
                }
            }
            this.f8190F = true;
        }
    }

    public final void mo1048a(float f, float f2, float f3) {
        if (this.f8227w.f8286e) {
            m14355l();
            this.f8187C = f2;
            this.f8188D = f3;
            if (m14351e(f, f2, f3) && this.f8185A) {
                AutoAnimationsHelper autoAnimationsHelper = this.f8193I;
                autoAnimationsHelper.f8301n = f - 1.0f;
                autoAnimationsHelper.f8302o = 0;
            }
            invalidate();
        }
    }

    public final void mo1052b(float f, float f2, float f3) {
        if (!this.f8227w.f8283b) {
            return;
        }
        if (this.f8198N) {
            m14355l();
            this.f8187C = f2;
            this.f8188D = f3;
            m14374d(this.f8214j + f, f2, f3);
            if (this.f8185A) {
                AutoAnimationsHelper autoAnimationsHelper = this.f8193I;
                autoAnimationsHelper.f8303p = f;
                autoAnimationsHelper.f8304q = 0;
            }
            invalidate();
            return;
        }
        this.f8197M += f;
        if (Math.abs(this.f8197M) > 8.0f) {
            this.f8198N = true;
        }
    }

    public final void mo1059f(float f, float f2) {
        if (this.f8227w.f8284c) {
            this.f8221q = false;
            this.f8193I.m14423a(this.f8207c, this.f8208d, (int) f, (int) f2);
            m14357n();
        }
    }

    public final void mo1058f() {
        if (this.f8227w.f8286e) {
            this.f8221q = false;
            this.f8193I.f8297j = true;
            m14357n();
        }
    }

    public final void mo1060g() {
        if (this.f8227w.f8283b && this.f8198N) {
            this.f8221q = false;
            this.f8193I.f8298k = true;
            m14357n();
        }
    }

    public final boolean mo1061g(float f, float f2) {
        m14352h(f, f2);
        return true;
    }

    public final boolean mo1050a(float f) {
        m14374d(this.f8214j + f, this.f8187C, this.f8188D);
        return true;
    }

    public final boolean mo1053b(float f) {
        return m14351e(f, this.f8187C, this.f8188D);
    }

    public final void mo1062h() {
        this.f8226v.m14307q();
    }

    private void m14356m() {
        this.f8186B.left = 0.0f;
        this.f8186B.right = (float) this.f8207c;
        this.f8186B.top = 0.0f;
        this.f8186B.bottom = (float) this.f8208d;
        this.f8216l.mapRect(this.f8186B);
        this.f8192H[0] = -this.f8209e;
        this.f8192H[1] = -this.f8210f;
        this.f8192H[2] = this.f8209e;
        this.f8192H[3] = -this.f8210f;
        this.f8216l.mapVectors(this.f8192H);
        float max = Math.max(Math.abs(this.f8192H[0]), Math.abs(this.f8192H[2]));
        float max2 = Math.max(Math.abs(this.f8192H[1]), Math.abs(this.f8192H[3]));
        this.f8219o = (double) (max / ((float) this.f8222r));
        this.f8220p = (double) (max2 / ((float) this.f8222r));
    }

    @SuppressLint({"WrongCall"})
    protected void onDraw(Canvas canvas) {
        m14343a(canvas, false);
    }

    private void m14343a(Canvas canvas, boolean z) {
        long a = AnalyticsEvent.a();
        super.onDraw(canvas);
        canvas.drawColor(-987675);
        this.f8206b = true;
        int size = this.f8226v.f8135i.size();
        for (int i = 0; i < size; i++) {
            MapDrawable mapDrawable = (MapDrawable) this.f8226v.f8135i.get(i);
            if (mapDrawable.f8084i && (!z || (z && mapDrawable.m14232h()))) {
                mapDrawable.mo1032a(canvas);
                if (mapDrawable instanceof TileOverlay) {
                    int i2;
                    TileOverlay tileOverlay = (TileOverlay) mapDrawable;
                    boolean z2 = this.f8206b;
                    if (tileOverlay.f8276s == 0) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    this.f8206b = i2 & z2;
                    int i3 = tileOverlay.f8275r;
                }
            }
        }
        if (this.f8206b) {
            if (this.f8226v.f8146t != null) {
                this.f8226v.m14306p();
            }
            if (this.f8203S) {
                this.f8226v.f8138l.m14491a(this.f8225u.m14311m());
                this.f8203S = false;
            }
        }
        final long a2 = AnalyticsEvent.a();
        final String m = this.f8225u.m14311m();
        AnalyticsEvent.a.a(a2 - a);
        if (this.f8201Q > 0) {
            AnalyticsEvent.B.a(new HashMap<String, Object>() {
            });
            this.f8201Q = 0;
        }
        if (this.f8202R > 0) {
            AnalyticsEvent.A.a(new HashMap<String, Object>() {
            });
            this.f8202R = 0;
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f8226v.m14309t();
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 985644278);
        super.onAttachedToWindow();
        if (this.f8226v == null) {
            RuntimeException runtimeException = new RuntimeException("MapView.onCreate() must be called!");
            Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -512979122, a);
            throw runtimeException;
        }
        m14353j();
        if (AnalyticsEvent.z.c()) {
            final String str = this.f8225u.f8165m;
            AnalyticsEvent.z.a(new HashMap<String, String>() {
            });
        }
        this.f8202R = AnalyticsEvent.a();
        if (!this.f8203S) {
            this.f8226v.f8138l.f8441A.mo1067b();
            this.f8203S = true;
        }
        LogUtils.g(-761523511, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1407247971);
        super.onDetachedFromWindow();
        FacebookMap facebookMap = this.f8226v;
        if (facebookMap.f8149w != null) {
            facebookMap.f8149w.m14511p();
        }
        facebookMap.m14309t();
        SynchronizedPool.m14513b();
        m14354k();
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1826184611, a);
    }

    @TargetApi(14)
    protected void onWindowVisibilityChanged(int i) {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1534762860);
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            m14353j();
        } else {
            m14354k();
        }
        LogUtils.g(1664356537, a);
    }

    static double m14336a(double d) {
        int i = d < 0.0d ? 1 : d > 1.0d ? -1 : 0;
        return ((double) i) + d;
    }

    final double m14358a(double d, long j) {
        double d2 = (((double) this.f8222r) / ((double) j)) * this.f8220p;
        double d3 = 1.0d - d2;
        if (d < d2) {
            return d2;
        }
        return d > d3 ? d3 : d;
    }

    private void m14352h(float f, float f2) {
        this.f8217m = m14336a(this.f8217m - ((double) (f / ((float) this.f8222r))));
        this.f8218n = m14358a(this.f8218n - ((double) (f2 / ((float) this.f8222r))), this.f8222r);
    }

    final void m14359a(double d, double d2) {
        this.f8217m = m14336a(d);
        this.f8218n = m14358a(d2, this.f8222r);
    }

    public final boolean m14372c(float f, float f2, float f3) {
        this.f8226v.f8137k.a(f2, f3, this.f8191G);
        float f4 = this.f8191G[0];
        float f5 = this.f8191G[1];
        float min = Math.min(Math.max(f, this.f8226v.f8128b), this.f8226v.f8127a);
        int i = (int) min;
        min = (min % 1.0f) + 1.0f;
        int i2 = this.f8211g;
        float f6 = min / this.f8212h;
        m14341a(i, min);
        this.f8215k.postScale(f6, f6, f2, f3);
        this.f8215k.invert(this.f8216l);
        m14356m();
        m14345b(f2, f3, f4, f5);
        if (this.f8211g != i2) {
            this.f8226v.m14307q();
        }
        if (f6 != 1.0f) {
            return true;
        }
        return false;
    }

    public float getZoom() {
        return (((float) this.f8211g) + this.f8212h) - 1.0f;
    }

    private boolean m14351e(float f, float f2, float f3) {
        float f4 = this.f8212h * f;
        int i = this.f8211g;
        while (f4 > 2.0f) {
            f4 /= 2.0f;
            i++;
        }
        while (f4 < 1.0f) {
            f4 *= 2.0f;
            i--;
        }
        return m14372c((((float) i) + f4) - 1.0f, f2, f3);
    }

    final void m14374d(float f, float f2, float f3) {
        if (this.f8230z) {
            this.f8226v.f8137k.a(f2, f3, this.f8191G);
            float f4 = this.f8191G[0];
            float f5 = this.f8191G[1];
            this.f8215k.postRotate(f - this.f8214j, f2, f3);
            this.f8215k.invert(this.f8216l);
            this.f8214j = f % 360.0f;
            m14356m();
            m14345b(f2, f3, f4, f5);
        }
    }

    private void m14357n() {
        this.f8226v.f8138l.m14406b(true);
        this.f8193I.m14424c();
    }

    private void m14341a(int i, float f) {
        this.f8211g = i;
        this.f8212h = f;
        this.f8223s = 1 << this.f8211g;
        this.f8222r = (long) (this.f8223s * this.f8226v.f8113B);
    }

    public final void mo1063i() {
        invalidate();
    }

    private void m14345b(float f, float f2, float f3, float f4) {
        this.f8191G[0] = this.f8209e - f;
        this.f8191G[1] = this.f8210f - f2;
        this.f8216l.mapVectors(this.f8191G);
        this.f8217m = m14336a((double) ((this.f8191G[0] / ((float) this.f8222r)) + f3));
        this.f8218n = m14358a((double) ((this.f8191G[1] / ((float) this.f8222r)) + f4), this.f8222r);
    }
}

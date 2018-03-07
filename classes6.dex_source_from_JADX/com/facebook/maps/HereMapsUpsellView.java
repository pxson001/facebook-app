package com.facebook.maps;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.common.locale.Locales;
import com.facebook.inject.FbInjector;
import com.facebook.maps.ExternalMapLauncher.C00172;
import com.facebook.maps.ExternalMapLauncher.C00183;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.io.IOException;
import java.io.InputStream;
import java.math.RoundingMode;
import java.net.URL;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import org.json.JSONObject;

/* compiled from: while uploading video */
public class HereMapsUpsellView extends ListView implements OnItemClickListener {
    @Inject
    public Locales f238a;
    private Intent f239b;
    public Handler f240c;
    private Handler f241d;
    private boolean f242e;
    public Adapter f243f;
    private boolean f244g;
    public final Context f245h;
    public Double f246i;
    public Double f247j;
    public final Double f248k;
    public final Double f249l;
    private final String f250m;
    private final String f251n;
    private C00172 f252o;
    private C00183 f253p;

    /* compiled from: while uploading video */
    class C00371 extends ResolveInfo {
        final /* synthetic */ HereMapsUpsellView f228a;

        C00371(HereMapsUpsellView hereMapsUpsellView) {
            this.f228a = hereMapsUpsellView;
        }

        public CharSequence loadLabel(PackageManager packageManager) {
            return "Here Maps";
        }

        public Drawable loadIcon(PackageManager packageManager) {
            return this.f228a.getResources().getDrawable(2130840781);
        }
    }

    /* compiled from: while uploading video */
    class C00392 implements Runnable {
        final /* synthetic */ HereMapsUpsellView f231a;

        C00392(HereMapsUpsellView hereMapsUpsellView) {
            this.f231a = hereMapsUpsellView;
        }

        public void run() {
            if ((this.f231a.f246i == null || this.f231a.f247j == null) && (VERSION.SDK_INT < 23 || (this.f231a.f245h.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && this.f231a.f245h.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0))) {
                LocationManager locationManager = (LocationManager) this.f231a.getContext().getSystemService("location");
                List<String> providers = locationManager.getProviders(true);
                Location location = null;
                if (providers != null) {
                    for (String lastKnownLocation : providers) {
                        Location lastKnownLocation2 = locationManager.getLastKnownLocation(lastKnownLocation);
                        if (location != null) {
                            Object obj = null;
                            if (lastKnownLocation2 != null) {
                                int i;
                                if (location == null) {
                                    i = 1;
                                } else {
                                    long time = lastKnownLocation2.getTime() - location.getTime();
                                    if (time > 120000) {
                                        i = 1;
                                    } else if (time >= -120000) {
                                        Object obj2;
                                        Object obj3 = time > 0 ? 1 : null;
                                        int accuracy = (int) (lastKnownLocation2.getAccuracy() - location.getAccuracy());
                                        if (accuracy <= 0) {
                                            obj2 = 1;
                                        } else {
                                            obj2 = null;
                                        }
                                        Object obj4;
                                        if (accuracy > 200) {
                                            obj4 = 1;
                                        } else {
                                            obj4 = null;
                                        }
                                        String provider = lastKnownLocation2.getProvider();
                                        String provider2 = location.getProvider();
                                        boolean equals = provider == null ? provider2 == null : provider.equals(provider2);
                                        if (obj2 != null || (obj3 != null && r10 == null && r11)) {
                                            i = 1;
                                        }
                                    }
                                }
                            }
                            if (obj == null) {
                                lastKnownLocation2 = location;
                            }
                        }
                        location = lastKnownLocation2;
                    }
                }
                if (location != null) {
                    this.f231a.f246i = Double.valueOf(location.getLatitude());
                    this.f231a.f247j = Double.valueOf(location.getLongitude());
                }
            }
            final Bitmap a = this.f231a.m223a(this.f231a.f246i, this.f231a.f247j, this.f231a.f248k, this.f231a.f249l, this.f231a.f243f.m220a(), this.f231a.f243f.m221b());
            HandlerDetour.a(this.f231a.f240c, new Runnable(this) {
                final /* synthetic */ C00392 f230b;

                public void run() {
                    BaseAdapter baseAdapter = this.f230b.f231a.f243f;
                    baseAdapter.f236e = a;
                    baseAdapter.f235d = false;
                    AdapterDetour.b(baseAdapter, -1674052272);
                }
            }, -1796427441);
        }
    }

    /* compiled from: while uploading video */
    public class Adapter extends ArrayAdapter<ResolveInfo> {
        private final Context f232a;
        private final PackageManager f233b;
        private final float f234c;
        public boolean f235d = true;
        public Bitmap f236e;
        private View f237f;

        public Adapter(Context context, List<ResolveInfo> list) {
            super(context, 0, list);
            this.f232a = context;
            this.f233b = context.getPackageManager();
            this.f234c = context.getResources().getDisplayMetrics().density;
        }

        public final int m220a() {
            return this.f237f.findViewById(2131562880).getWidth();
        }

        public final int m221b() {
            return this.f237f.findViewById(2131562880).getHeight();
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            ProgressBar progressBar;
            int i2;
            Bitmap bitmap;
            int i3;
            int i4;
            int i5 = 8;
            view = (RelativeLayout) view;
            if (view == null) {
                if (this.f237f == null) {
                    this.f237f = viewGroup;
                }
                View view2 = (RelativeLayout) View.inflate(this.f232a, 2130904777, null);
                ProgressBar progressBar2 = (ProgressBar) view2.findViewById(2131562881);
                progressBar2.getIndeterminateDrawable().setColorFilter(new LightingColorFilter(0, -6842473));
                progressBar = progressBar2;
                view = view2;
            } else {
                progressBar = (ProgressBar) view.findViewById(2131562881);
            }
            View findViewById = view.findViewById(2131562879);
            ImageView imageView = (ImageView) view.findViewById(2131559122);
            TextView textView = (TextView) view.findViewById(2131558966);
            ImageView imageView2 = (ImageView) view.findViewById(2131562880);
            View findViewById2 = view.findViewById(2131560055);
            if (i == 0) {
                i2 = 0;
            } else {
                i2 = 8;
            }
            findViewById.setVisibility(i2);
            if (i == 0) {
                bitmap = this.f236e;
            } else {
                bitmap = null;
            }
            imageView2.setImageBitmap(bitmap);
            if (i != 0 || (!this.f235d && this.f236e == null)) {
                i2 = 8;
            } else {
                i2 = 0;
            }
            imageView2.setVisibility(i2);
            if (i == 0 && this.f235d) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            progressBar.setVisibility(i3);
            if (i < getCount() - 1) {
                i5 = 0;
            }
            findViewById2.setVisibility(i5);
            ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
            imageView.setImageDrawable(resolveInfo.loadIcon(this.f233b));
            textView.setText(resolveInfo.loadLabel(this.f233b));
            if (i == 0) {
                i4 = (int) (3.0f * this.f234c);
            } else {
                i4 = 0;
            }
            textView.setPadding(0, 0, 0, i4);
            return view;
        }
    }

    public static void m225a(Object obj, Context context) {
        ((HereMapsUpsellView) obj).f238a = Locales.a(FbInjector.get(context));
    }

    public HereMapsUpsellView(Context context, Intent intent, double d, double d2, @Nullable String str, @Nullable String str2) {
        super(context);
        Class cls = HereMapsUpsellView.class;
        m225a((Object) this, getContext());
        this.f245h = context;
        this.f248k = Double.valueOf(d);
        this.f249l = Double.valueOf(d2);
        this.f250m = str;
        this.f251n = str2;
        m224a(context, intent);
    }

    public void setOnIntentClickListener(C00172 c00172) {
        this.f252o = c00172;
    }

    public void setOnMapImageDownloadListener(C00183 c00183) {
        this.f253p = c00183;
    }

    private void m224a(Context context, Intent intent) {
        ResolveInfo resolveInfo;
        boolean z;
        this.f239b = intent;
        this.f240c = new Handler(Looper.getMainLooper());
        HandlerThread handlerThread = new HandlerThread("background");
        handlerThread.start();
        this.f241d = new Handler(handlerThread.getLooper());
        Drawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(201326592));
        setSelector(stateListDrawable);
        setDrawSelectorOnTop(true);
        setDividerHeight(0);
        setOnItemClickListener(this);
        setCacheColorHint(0);
        float f = getContext().getResources().getDisplayMetrics().density;
        setPadding(0, ((int) f) * 16, 0, ((int) f) * 8);
        List arrayList = new ArrayList(context.getPackageManager().queryIntentActivities(this.f239b, 65536));
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ResolveInfo resolveInfo2 = (ResolveInfo) arrayList.get(i);
            if ("com.here.app.maps".equalsIgnoreCase(resolveInfo2.activityInfo.packageName)) {
                arrayList.remove(i);
                resolveInfo = resolveInfo2;
                break;
            }
        }
        resolveInfo = null;
        if (resolveInfo != null) {
            z = true;
        } else {
            z = false;
        }
        this.f242e = z;
        ResolveInfo c00371 = new C00371(this);
        c00371.activityInfo = resolveInfo != null ? resolveInfo.activityInfo : null;
        arrayList.add(0, c00371);
        this.f243f = new Adapter(getContext(), arrayList);
        setAdapter(this.f243f);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.f244g) {
            this.f244g = true;
            HandlerDetour.a(this.f241d, new C00392(this), -1930661747);
        }
    }

    @SuppressLint({"BadMethodUse-android.content.Context.startActivity"})
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        Intent intent;
        ResolveInfo resolveInfo = (ResolveInfo) this.f243f.getItem(i);
        if (i != 0 || this.f242e) {
            Intent className = new Intent(this.f239b).setClassName(resolveInfo.activityInfo.packageName, resolveInfo.activityInfo.name);
            if (this.f252o != null) {
                this.f252o.m81a("App: " + resolveInfo.activityInfo.packageName);
            }
            intent = className;
        } else {
            String str = "http://share.here.com/r/mylocation/e-";
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", this.f250m == null ? "" : this.f250m);
                jSONObject.put("latitude", this.f248k);
                jSONObject.put("longitude", this.f249l);
                if (this.f251n != null) {
                    jSONObject.put("address", this.f251n);
                }
                str = str + Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 10);
            } catch (Exception e) {
            }
            intent = new Intent("android.intent.action.VIEW").setData(Uri.parse(str + "?ref=fb_android&fb_locale=" + this.f238a.c()));
            if (this.f252o != null) {
                this.f252o.m81a("HERE Web");
            }
        }
        getContext().startActivity(intent);
    }

    private Bitmap m223a(Double d, Double d2, Double d3, Double d4, int i, int i2) {
        InputStream inputStream;
        String str;
        InputStream inputStream2;
        Bitmap decodeStream;
        Throwable th;
        if (i <= 0 || i2 <= 0) {
            if (this.f253p != null) {
                this.f253p.m82a("Width or height too small");
            }
            return null;
        } else if (d3 == null || d4 == null) {
            if (this.f253p != null) {
                this.f253p.m82a("No dest location");
            }
            return null;
        } else {
            long uptimeMillis = SystemClock.uptimeMillis();
            NumberFormat instance = NumberFormat.getInstance(Locale.US);
            instance.setRoundingMode(RoundingMode.DOWN);
            instance.setMaximumIntegerDigits(3);
            instance.setMaximumFractionDigits(8);
            int i3 = getContext().getResources().getDisplayMetrics().densityDpi;
            i3 = i3 <= 72 ? 72 : i3 <= 250 ? 250 : 320;
            int i4 = (int) (getContext().getResources().getDisplayMetrics().density * 4.5f);
            if (!(d == null || d2 == null)) {
                String str2 = "https://image.maps.api.here.com/mia/1.6/routing?app_id=caQ6Zhx3wcs0WZsbDu6A&app_code=quSjSoc_a3XZp8p_icIMmQ&t=0&ppi=" + i3 + "&w=" + i + "&h=" + i2 + "&lw=" + i4 + "&lc=FF1652B4" + "&waypoint0=" + instance.format(d) + "," + instance.format(d2) + "&waypoint1=" + instance.format(d3) + "," + instance.format(d4);
                inputStream = null;
                try {
                    InputStream openStream = new URL(str2).openStream();
                    try {
                        Bitmap decodeStream2 = BitmapFactory.decodeStream(openStream);
                        if (decodeStream2 != null) {
                            try {
                                openStream.close();
                            } catch (Exception e) {
                            }
                            if (!(this.f253p == null || decodeStream2 == null)) {
                                this.f253p.m83a("Route", SystemClock.uptimeMillis() - uptimeMillis);
                            }
                            return decodeStream2;
                        }
                        try {
                            openStream.close();
                        } catch (Exception e2) {
                        }
                        if (!(this.f253p == null || decodeStream2 == null)) {
                            this.f253p.m83a("Route", SystemClock.uptimeMillis() - uptimeMillis);
                        }
                    } catch (IOException e3) {
                        inputStream = openStream;
                        try {
                            inputStream.close();
                        } catch (Exception e4) {
                        }
                        this.f253p.m83a("Route", SystemClock.uptimeMillis() - uptimeMillis);
                        str = "https://image.maps.api.here.com/mia/1.6/mapview?app_id=caQ6Zhx3wcs0WZsbDu6A&app_code=quSjSoc_a3XZp8p_icIMmQ&t=0&ppi=" + i3 + "&w=" + i + "&h=" + i2 + "&z=17" + "&poix0=" + instance.format(d3) + "," + instance.format(d4) + ";white;white;25;.";
                        inputStream2 = null;
                        inputStream = new URL(str).openStream();
                        decodeStream = BitmapFactory.decodeStream(inputStream);
                        try {
                            inputStream.close();
                        } catch (Exception e5) {
                        }
                        if (this.f253p != null) {
                            return decodeStream;
                        }
                        if (decodeStream != null) {
                            this.f253p.m83a("Place", SystemClock.uptimeMillis() - uptimeMillis);
                            return decodeStream;
                        }
                        this.f253p.m82a("Loading error");
                        return decodeStream;
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = openStream;
                        try {
                            inputStream.close();
                        } catch (Exception e6) {
                        }
                        this.f253p.m83a("Route", SystemClock.uptimeMillis() - uptimeMillis);
                        throw th;
                    }
                } catch (IOException e7) {
                    inputStream.close();
                    if (!(this.f253p == null || null == null)) {
                        this.f253p.m83a("Route", SystemClock.uptimeMillis() - uptimeMillis);
                    }
                    str = "https://image.maps.api.here.com/mia/1.6/mapview?app_id=caQ6Zhx3wcs0WZsbDu6A&app_code=quSjSoc_a3XZp8p_icIMmQ&t=0&ppi=" + i3 + "&w=" + i + "&h=" + i2 + "&z=17" + "&poix0=" + instance.format(d3) + "," + instance.format(d4) + ";white;white;25;.";
                    inputStream2 = null;
                    inputStream = new URL(str).openStream();
                    decodeStream = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                    if (this.f253p != null) {
                        return decodeStream;
                    }
                    if (decodeStream != null) {
                        this.f253p.m82a("Loading error");
                        return decodeStream;
                    }
                    this.f253p.m83a("Place", SystemClock.uptimeMillis() - uptimeMillis);
                    return decodeStream;
                } catch (Throwable th3) {
                    th = th3;
                    inputStream.close();
                    if (!(this.f253p == null || null == null)) {
                        this.f253p.m83a("Route", SystemClock.uptimeMillis() - uptimeMillis);
                    }
                    throw th;
                }
            }
            str = "https://image.maps.api.here.com/mia/1.6/mapview?app_id=caQ6Zhx3wcs0WZsbDu6A&app_code=quSjSoc_a3XZp8p_icIMmQ&t=0&ppi=" + i3 + "&w=" + i + "&h=" + i2 + "&z=17" + "&poix0=" + instance.format(d3) + "," + instance.format(d4) + ";white;white;25;.";
            inputStream2 = null;
            try {
                inputStream = new URL(str).openStream();
                try {
                    decodeStream = BitmapFactory.decodeStream(inputStream);
                    inputStream.close();
                    if (this.f253p != null) {
                        return decodeStream;
                    }
                    if (decodeStream != null) {
                        this.f253p.m83a("Place", SystemClock.uptimeMillis() - uptimeMillis);
                        return decodeStream;
                    }
                    this.f253p.m82a("Loading error");
                    return decodeStream;
                } catch (IOException e8) {
                    inputStream2 = inputStream;
                    try {
                        inputStream2.close();
                    } catch (Exception e9) {
                    }
                    if (this.f253p != null) {
                        if (null == null) {
                            this.f253p.m83a("Place", SystemClock.uptimeMillis() - uptimeMillis);
                        } else {
                            this.f253p.m82a("Loading error");
                        }
                    }
                    return null;
                } catch (Throwable th4) {
                    th = th4;
                    try {
                        inputStream.close();
                    } catch (Exception e10) {
                    }
                    if (this.f253p != null) {
                        if (null == null) {
                            this.f253p.m83a("Place", SystemClock.uptimeMillis() - uptimeMillis);
                        } else {
                            this.f253p.m82a("Loading error");
                        }
                    }
                    throw th;
                }
            } catch (IOException e11) {
                inputStream2.close();
                if (this.f253p != null) {
                    if (null == null) {
                        this.f253p.m82a("Loading error");
                    } else {
                        this.f253p.m83a("Place", SystemClock.uptimeMillis() - uptimeMillis);
                    }
                }
                return null;
            } catch (Throwable th5) {
                Throwable th6 = th5;
                inputStream = null;
                th = th6;
                inputStream.close();
                if (this.f253p != null) {
                    if (null == null) {
                        this.f253p.m82a("Loading error");
                    } else {
                        this.f253p.m83a("Place", SystemClock.uptimeMillis() - uptimeMillis);
                    }
                }
                throw th;
            }
        }
    }
}

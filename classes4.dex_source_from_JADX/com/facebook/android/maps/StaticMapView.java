package com.facebook.android.maps;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.TextView;
import com.facebook.android.maps.internal.GrandCentralDispatch;
import com.facebook.android.maps.internal.GrandCentralDispatch.Dispatchable;
import com.facebook.android.maps.internal.MapConfig;
import com.facebook.android.maps.internal.analytics.AnalyticsEvent;
import com.facebook.android.maps.model.LatLng;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: profile_picture */
public class StaticMapView extends FrameLayout {
    public static final Uri f13374a = Uri.parse("https://maps.googleapis.com/maps/api/staticmap?");
    private static final Typeface f13375d = Typeface.DEFAULT_BOLD;
    private static float[] f13376n;
    protected int f13377b;
    protected int f13378c;
    public final StaticMapOptions f13379e;
    public Dispatchable f13380f;
    private View f13381g;
    private TextView f13382h;
    private Drawable f13383i;
    public Uri f13384j;
    public int f13385k;
    private int f13386l;
    public MapReporterLauncher f13387m;
    private final Paint f13388o;
    private int f13389p;
    private int f13390q;
    public long f13391r;
    private final float[] f13392s;

    /* compiled from: profile_picture */
    class C01942 extends HashMap<String, String> {
        C01942() {
            put("map_url", StaticMapView.this.f13384j.toString());
            put("surface", StaticMapView.this.f13379e.f13393a);
        }
    }

    /* compiled from: profile_picture */
    public class StaticMapOptions implements Parcelable {
        public static final Creator<StaticMapOptions> CREATOR = new C06321();
        public String f13393a;
        public String f13394b;
        public String f13395c;
        public String f13396d;
        public String f13397e;
        public String f13398f;
        public String f13399g;
        public List<String> f13400h = Collections.EMPTY_LIST;

        /* compiled from: profile_picture */
        final class C06321 implements Creator<StaticMapOptions> {
            C06321() {
            }

            public final Object createFromParcel(Parcel parcel) {
                StaticMapOptions staticMapOptions = new StaticMapOptions(parcel.readString());
                staticMapOptions.f13394b = parcel.readString();
                staticMapOptions.f13395c = parcel.readString();
                staticMapOptions.f13399g = parcel.readString();
                staticMapOptions.f13396d = parcel.readString();
                staticMapOptions.f13397e = parcel.readString();
                staticMapOptions.f13398f = parcel.readString();
                staticMapOptions.f13400h = new ArrayList();
                parcel.readStringList(staticMapOptions.f13400h);
                return staticMapOptions;
            }

            public final Object[] newArray(int i) {
                return new StaticMapOptions[i];
            }
        }

        public StaticMapOptions(String str) {
            this.f13393a = str;
        }

        public final StaticMapOptions m14296a(int i) {
            this.f13394b = String.valueOf(i);
            return this;
        }

        public final StaticMapOptions m14299a(LatLng latLng) {
            this.f13395c = latLng.a + "," + latLng.b;
            return this;
        }

        public final StaticMapOptions m14298a(Location location) {
            this.f13395c = location.getLatitude() + "," + location.getLongitude();
            return this;
        }

        public final StaticMapOptions m14294a(double d, double d2) {
            this.f13395c = d + ", " + d2;
            return this;
        }

        public final StaticMapOptions m14297a(RectF rectF) {
            List<LatLng> asList = Arrays.asList(new LatLng[]{new LatLng((double) rectF.top, (double) rectF.left), new LatLng((double) rectF.bottom, (double) rectF.right)});
            if (asList.isEmpty()) {
                this.f13399g = null;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                for (LatLng latLng : asList) {
                    stringBuilder.append('|').append(latLng.a).append(',').append(latLng.b);
                }
                this.f13399g = stringBuilder.toString().substring(1);
            }
            return this;
        }

        public final StaticMapOptions m14295a(double d, double d2, String str) {
            this.f13397e = (str == null ? "" : "color:" + str + "|") + d + ", " + d2;
            return this;
        }

        public final StaticMapOptions m14302a(List<LatLng> list, String str) {
            if (list.isEmpty()) {
                this.f13397e = null;
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                if (!TextUtils.isEmpty(str)) {
                    stringBuilder.append("|color:").append(str);
                }
                for (LatLng latLng : list) {
                    stringBuilder.append('|').append(latLng.a).append(',').append(latLng.b);
                }
                this.f13397e = stringBuilder.toString().substring(1);
            }
            return this;
        }

        public final StaticMapOptions m14300a(List<Marker> list) {
            if (list.isEmpty()) {
                this.f13400h.clear();
            } else {
                this.f13400h = new ArrayList(list.size());
                for (Marker marker : list) {
                    List list2 = this.f13400h;
                    StringBuilder stringBuilder = new StringBuilder();
                    if (!TextUtils.isEmpty(marker.a)) {
                        stringBuilder.append("icon:").append(marker.a).append("|anchor:").append(marker.c).append(",").append(marker.d).append("|");
                    }
                    list2.add(stringBuilder.append(marker.b.a).append(",").append(marker.b.b).toString());
                }
            }
            return this;
        }

        public final StaticMapOptions m14301a(List<LatLng> list, int i, int i2, @Nullable String str, @Nullable String str2) {
            if (list.isEmpty()) {
                this.f13398f = null;
            } else {
                int i3 = (i << 8) | (i >>> 24);
                StringBuilder append = new StringBuilder("color:0x").append(String.format(Locale.US, "%08X", new Object[]{Integer.valueOf(i3)}).toUpperCase(Locale.US)).append("|weight:").append(i2);
                if (str != null) {
                    append.append("|route:").append(str);
                }
                if (str2 != null) {
                    append.append("|dashed:").append(str2);
                }
                int size = list.size();
                for (i3 = 0; i3 < size; i3++) {
                    LatLng latLng = (LatLng) list.get(i3);
                    append.append("|").append(latLng.a).append(",").append(latLng.b);
                }
                this.f13398f = append.toString();
            }
            return this;
        }

        public final StaticMapOptions m14293a() {
            this.f13394b = null;
            this.f13395c = null;
            this.f13399g = null;
            this.f13396d = null;
            this.f13397e = null;
            this.f13398f = null;
            this.f13400h.clear();
            return this;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean equals(java.lang.Object r5) {
            /*
            r4 = this;
            r0 = 1;
            r1 = 0;
            if (r4 != r5) goto L_0x0005;
        L_0x0004:
            return r0;
        L_0x0005:
            r2 = r5 instanceof com.facebook.android.maps.StaticMapView.StaticMapOptions;
            if (r2 != 0) goto L_0x000b;
        L_0x0009:
            r0 = r1;
            goto L_0x0004;
        L_0x000b:
            r5 = (com.facebook.android.maps.StaticMapView.StaticMapOptions) r5;
            r2 = r4.f13393a;
            if (r2 != 0) goto L_0x0051;
        L_0x0011:
            r2 = r5.f13393a;
            if (r2 != 0) goto L_0x004f;
        L_0x0015:
            r2 = r4.f13394b;
            if (r2 != 0) goto L_0x005c;
        L_0x0019:
            r2 = r5.f13394b;
            if (r2 != 0) goto L_0x004f;
        L_0x001d:
            r2 = r4.f13395c;
            if (r2 != 0) goto L_0x0067;
        L_0x0021:
            r2 = r5.f13395c;
            if (r2 != 0) goto L_0x004f;
        L_0x0025:
            r2 = r4.f13399g;
            if (r2 != 0) goto L_0x0072;
        L_0x0029:
            r2 = r5.f13399g;
            if (r2 != 0) goto L_0x004f;
        L_0x002d:
            r2 = r4.f13396d;
            if (r2 != 0) goto L_0x007d;
        L_0x0031:
            r2 = r5.f13396d;
            if (r2 != 0) goto L_0x004f;
        L_0x0035:
            r2 = r4.f13397e;
            if (r2 != 0) goto L_0x0088;
        L_0x0039:
            r2 = r5.f13397e;
            if (r2 != 0) goto L_0x004f;
        L_0x003d:
            r2 = r4.f13398f;
            if (r2 != 0) goto L_0x0093;
        L_0x0041:
            r2 = r5.f13398f;
            if (r2 != 0) goto L_0x004f;
        L_0x0045:
            r2 = r4.f13400h;
            r3 = r5.f13400h;
            r2 = r2.equals(r3);
            if (r2 != 0) goto L_0x0004;
        L_0x004f:
            r0 = r1;
            goto L_0x0004;
        L_0x0051:
            r2 = r4.f13393a;
            r3 = r5.f13393a;
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x004f;
        L_0x005b:
            goto L_0x0015;
        L_0x005c:
            r2 = r4.f13394b;
            r3 = r5.f13394b;
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x004f;
        L_0x0066:
            goto L_0x001d;
        L_0x0067:
            r2 = r4.f13395c;
            r3 = r5.f13395c;
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x004f;
        L_0x0071:
            goto L_0x0025;
        L_0x0072:
            r2 = r4.f13399g;
            r3 = r5.f13399g;
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x004f;
        L_0x007c:
            goto L_0x002d;
        L_0x007d:
            r2 = r4.f13396d;
            r3 = r5.f13396d;
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x004f;
        L_0x0087:
            goto L_0x0035;
        L_0x0088:
            r2 = r4.f13397e;
            r3 = r5.f13397e;
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x004f;
        L_0x0092:
            goto L_0x003d;
        L_0x0093:
            r2 = r4.f13398f;
            r3 = r5.f13398f;
            r2 = r2.equals(r3);
            if (r2 == 0) goto L_0x004f;
        L_0x009d:
            goto L_0x0045;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.android.maps.StaticMapView.StaticMapOptions.equals(java.lang.Object):boolean");
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((this.f13397e == null ? 0 : this.f13397e.hashCode()) + (((this.f13396d == null ? 0 : this.f13396d.hashCode()) + (((this.f13399g == null ? 0 : this.f13399g.hashCode()) + (((this.f13395c == null ? 0 : this.f13395c.hashCode()) + (((this.f13394b == null ? 0 : this.f13394b.hashCode()) + (((this.f13393a == null ? 0 : this.f13393a.hashCode()) + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
            if (this.f13398f != null) {
                i = this.f13398f.hashCode();
            }
            return ((hashCode + i) * 31) + this.f13400h.hashCode();
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.f13393a);
            parcel.writeString(this.f13394b);
            parcel.writeString(this.f13395c);
            parcel.writeString(this.f13399g);
            parcel.writeString(this.f13396d);
            parcel.writeString(this.f13397e);
            parcel.writeString(this.f13398f);
            parcel.writeStringList(this.f13400h);
        }
    }

    /* compiled from: profile_picture */
    class C06333 implements OnClickListener {
        final /* synthetic */ StaticMapView f13401a;

        C06333(StaticMapView staticMapView) {
            this.f13401a = staticMapView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -696469730);
            if (this.f13401a.f13384j == null) {
                Logger.a(2, EntryType.UI_INPUT_END, 205236084, a);
                return;
            }
            AnalyticsEvent.f13536w.m14394a(null);
            if (this.f13401a.f13387m == null) {
                this.f13401a.f13387m = new MapReporterLauncher(this.f13401a.getContext());
            }
            this.f13401a.f13387m.m14311a(view.getContext(), this.f13401a.f13384j);
            LogUtils.a(-1237510872, a);
        }
    }

    public StaticMapView(Context context) {
        super(context);
        this.f13379e = new StaticMapOptions("");
        this.f13385k = 2;
        this.f13388o = new Paint();
        this.f13391r = 0;
        this.f13392s = new float[2];
        m14286a(null);
    }

    public StaticMapView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f13379e = new StaticMapOptions("");
        this.f13385k = 2;
        this.f13388o = new Paint();
        this.f13391r = 0;
        this.f13392s = new float[2];
        m14286a(attributeSet);
    }

    public StaticMapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f13379e = new StaticMapOptions("");
        this.f13385k = 2;
        this.f13388o = new Paint();
        this.f13391r = 0;
        this.f13392s = new float[2];
        m14286a(attributeSet);
    }

    private void m14286a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            int attributeResourceValue = attributeSet.getAttributeResourceValue("http://schemas.android.com/apk/facebook", "centeredMapPinDrawable", 0);
            float attributeFloatValue = attributeSet.getAttributeFloatValue("http://schemas.android.com/apk/facebook", "centeredMapPinDrawableAnchorU", 0.5f);
            float attributeFloatValue2 = attributeSet.getAttributeFloatValue("http://schemas.android.com/apk/facebook", "centeredMapPinDrawableAnchorV", 0.5f);
            if (attributeResourceValue != 0) {
                m14291a(getResources().getDrawable(attributeResourceValue), attributeFloatValue, attributeFloatValue2);
            }
        }
        setWillNotDraw(false);
        float f = getResources().getDisplayMetrics().density;
        this.f13389p = (int) (16.0f * f);
        this.f13390q = Math.max(1, (int) (f * 1.0f));
        this.f13388o.setStrokeWidth((float) this.f13390q);
        this.f13388o.setColor(-1842984);
        this.f13381g = mo952a();
        addView(this.f13381g, -1, -1);
        this.f13382h = m14289d();
        addView(this.f13382h);
        setReportButtonVisibility(8);
    }

    public final void setMapOptions(StaticMapOptions staticMapOptions) {
        if (!this.f13379e.equals(staticMapOptions)) {
            StaticMapOptions staticMapOptions2 = this.f13379e;
            staticMapOptions2.f13393a = staticMapOptions.f13393a;
            staticMapOptions2.f13394b = staticMapOptions.f13394b;
            staticMapOptions2.f13395c = staticMapOptions.f13395c;
            staticMapOptions2.f13399g = staticMapOptions.f13399g;
            staticMapOptions2.f13396d = staticMapOptions.f13396d;
            staticMapOptions2.f13397e = staticMapOptions.f13397e;
            staticMapOptions2.f13398f = staticMapOptions.f13398f;
            staticMapOptions2.f13400h = staticMapOptions.f13400h;
            m14287b();
        }
    }

    public void setCenteredMapPinDrawable(Drawable drawable) {
        m14291a(drawable, 0.5f, 0.5f);
    }

    public final void m14291a(Drawable drawable, float f, float f2) {
        this.f13392s[0] = f;
        this.f13392s[1] = f2;
        this.f13383i = drawable;
        m14288c();
        invalidate();
    }

    public void setEnabled(boolean z) {
        if (z) {
            this.f13381g.setVisibility(0);
            this.f13382h.setVisibility(this.f13386l);
            m14287b();
            return;
        }
        this.f13381g.setVisibility(8);
        this.f13382h.setVisibility(8);
    }

    public boolean isEnabled() {
        return this.f13381g.getVisibility() == 0;
    }

    public void setReportButtonVisibility(int i) {
        this.f13386l = i;
        if (isEnabled()) {
            this.f13382h.setVisibility(i);
        }
    }

    public static Uri m14284a(int i, int i2, int i3, Resources resources, String str, StaticMapOptions staticMapOptions) {
        int a = m14282a(resources);
        Builder appendQueryParameter = m14283a(i3).buildUpon().appendQueryParameter("size", (i / a) + "x" + (i2 / a)).appendQueryParameter("scale", String.valueOf(a)).appendQueryParameter("language", str).appendQueryParameter("format", staticMapOptions.f13396d == null ? "jpg" : staticMapOptions.f13396d);
        m14285a(appendQueryParameter, "visible", staticMapOptions.f13399g);
        m14285a(appendQueryParameter, "markers", staticMapOptions.f13397e);
        m14285a(appendQueryParameter, "path", staticMapOptions.f13398f);
        m14285a(appendQueryParameter, "center", staticMapOptions.f13395c);
        m14285a(appendQueryParameter, "zoom", staticMapOptions.f13394b);
        int size = staticMapOptions.f13400h.size();
        for (int i4 = 0; i4 < size; i4++) {
            m14285a(appendQueryParameter, "marker_list[" + i4 + "]", (String) staticMapOptions.f13400h.get(i4));
        }
        return appendQueryParameter.build();
    }

    public Uri getStaticMapBaseUrl() {
        return m14283a(this.f13385k);
    }

    public void setMapReporterLauncher(MapReporterLauncher mapReporterLauncher) {
        this.f13387m = mapReporterLauncher;
    }

    protected static int m14282a(Resources resources) {
        return resources.getDisplayMetrics().density < 1.5f ? 1 : 2;
    }

    protected View mo952a() {
        View imageView = new ImageView(getContext());
        imageView.setScaleType(ScaleType.CENTER_CROP);
        return imageView;
    }

    protected void mo953a(View view, Uri uri, String str) {
        this.f13391r = AnalyticsEvent.m14382a();
        if (this.f13380f != null) {
            Dispatchable dispatchable = this.f13380f;
            for (Dispatchable dispatchable2 : GrandCentralDispatch.f13557b) {
                if (dispatchable2 == dispatchable) {
                    GrandCentralDispatch.f13557b.remove(dispatchable2);
                    dispatchable2.mo971a();
                }
            }
        }
        ((ImageView) view).setImageDrawable(null);
        this.f13380f = new 1(this, view, str, uri);
        GrandCentralDispatch.m14421a(this.f13380f);
    }

    protected String getLanguageCode() {
        return MapConfig.f13474a;
    }

    protected CharSequence getReportButtonText() {
        return "Report";
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        int i5 = this.f13377b;
        int i6 = this.f13378c;
        this.f13377b = this.f13381g.getWidth();
        this.f13378c = this.f13381g.getHeight();
        if (!(i5 == this.f13377b && i6 == this.f13378c)) {
            m14287b();
        }
        m14288c();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f13381g.getVisibility() == 0) {
            int save = canvas.save();
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop();
            int width = getWidth() - getPaddingRight();
            int height = getHeight() - getPaddingBottom();
            canvas.clipRect(paddingLeft, paddingTop, width, height);
            canvas.drawColor(-987675);
            int i = width - paddingLeft;
            int i2 = height - paddingTop;
            canvas.translate((float) paddingLeft, (float) paddingTop);
            paddingLeft = ((((this.f13389p + i) - 1) / this.f13389p) + (((this.f13389p + i2) - 1) / this.f13389p)) << 2;
            if (f13376n == null || f13376n.length < paddingLeft) {
                f13376n = new float[paddingLeft];
            }
            paddingLeft = this.f13389p - ((this.f13390q + 1) / 2);
            width = paddingLeft;
            paddingTop = 0;
            while (width < i) {
                int i3 = paddingTop + 1;
                f13376n[paddingTop] = (float) width;
                height = i3 + 1;
                f13376n[i3] = 0.0f;
                i3 = height + 1;
                f13376n[height] = (float) width;
                height = i3 + 1;
                f13376n[i3] = (float) i2;
                width = this.f13389p + width;
                paddingTop = height;
            }
            while (paddingLeft < i2) {
                height = paddingTop + 1;
                f13376n[paddingTop] = 0.0f;
                width = height + 1;
                f13376n[height] = (float) paddingLeft;
                height = width + 1;
                f13376n[width] = (float) i;
                paddingTop = height + 1;
                f13376n[height] = (float) paddingLeft;
                paddingLeft += this.f13389p;
            }
            canvas.drawLines(f13376n, 0, paddingTop, this.f13388o);
            canvas.restoreToCount(save);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f13381g.getVisibility() == 0 && this.f13383i != null) {
            this.f13383i.draw(canvas);
        }
    }

    private static void m14285a(Builder builder, String str, String str2) {
        if (str2 != null) {
            builder.appendQueryParameter(str, str2);
        }
    }

    private static Uri m14283a(int i) {
        if (i != 2) {
            return f13374a;
        }
        MapConfig.m14371a();
        return Uri.parse(MapConfig.f13485l.f13492c);
    }

    private void m14287b() {
        if (this.f13377b != 0 && this.f13378c != 0) {
            Object obj;
            StaticMapOptions staticMapOptions = this.f13379e;
            if ((staticMapOptions.f13394b == null || staticMapOptions.f13395c == null) && staticMapOptions.f13399g == null && staticMapOptions.f13397e == null && staticMapOptions.f13400h.isEmpty() && staticMapOptions.f13398f == null) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null && this.f13381g.getVisibility() == 0) {
                Uri a = m14284a(this.f13377b, this.f13378c, this.f13385k, getResources(), getLanguageCode(), this.f13379e);
                if (!a.equals(this.f13384j)) {
                    this.f13384j = a;
                    if (AnalyticsEvent.f13538y.m14395c()) {
                        AnalyticsEvent.f13538y.m14394a(new C01942());
                    }
                    mo953a(this.f13381g, a, this.f13379e.f13393a);
                }
            }
        }
    }

    private void m14288c() {
        if (this.f13383i != null) {
            int intrinsicWidth = this.f13383i.getIntrinsicWidth();
            int intrinsicHeight = this.f13383i.getIntrinsicHeight();
            int paddingLeft = (getPaddingLeft() + (((getWidth() - getPaddingLeft()) - getPaddingRight()) / 2)) - ((int) (((float) intrinsicWidth) * this.f13392s[0]));
            int paddingTop = (getPaddingTop() + (((getHeight() - getPaddingTop()) - getPaddingBottom()) / 2)) - ((int) (((float) intrinsicHeight) * this.f13392s[1]));
            this.f13383i.setBounds(paddingLeft, paddingTop, intrinsicWidth + paddingLeft, intrinsicHeight + paddingTop);
        }
    }

    private TextView m14289d() {
        float f = getResources().getDisplayMetrics().density;
        this.f13382h = new TextView(getContext());
        this.f13382h.setText(getReportButtonText());
        this.f13382h.setTypeface(f13375d);
        this.f13382h.setTextColor(-1711276032);
        this.f13382h.setTextSize(10.0f);
        this.f13382h.setPaintFlags(this.f13382h.getPaintFlags() | 8);
        this.f13382h.setShadowLayer(1.5f * f, 0.0f, 0.0f, -1056964609);
        LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.setMargins(0, 0, (int) (8.0f * f), (int) (f * 8.0f));
        layoutParams.gravity = 85;
        this.f13382h.setLayoutParams(layoutParams);
        this.f13382h.setOnClickListener(new C06333(this));
        return this.f13382h;
    }
}

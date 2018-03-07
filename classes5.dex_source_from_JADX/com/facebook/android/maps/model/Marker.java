package com.facebook.android.maps.model;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Vibrator;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.android.maps.CameraUpdateFactory;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.MapDrawable;
import com.facebook.android.maps.MarkerInteractionHandler;
import com.facebook.android.maps.Projection;
import com.facebook.android.maps.internal.RectD;
import com.facebook.android.maps.internal.analytics.AnalyticsEvent;
import com.facebook.maps.delegate.MapDelegate.17;
import com.facebook.maps.delegate.MarkerDelegate;

/* compiled from: authClient */
public final class Marker extends MapDrawable {
    private static final Matrix f8578o = new Matrix();
    private static final Paint f8579p = new Paint(1);
    private static final Path f8580q = new Path();
    private static final RectD f8581r = new RectD();
    private static boolean f8582s;
    private static Vibrator f8583t;
    private BitmapDescriptor f8584A;
    private LatLng f8585B;
    private float f8586C;
    public String f8587D;
    private String f8588E;
    private final float[] f8589F = new float[2];
    private final float[] f8590G = new float[2];
    public MarkerInteractionHandler f8591H;
    private View f8592I;
    private boolean f8593J;
    public boolean f8594K;
    private boolean f8595L;
    private boolean f8596M;
    private boolean f8597N;
    private float f8598O;
    private float f8599P;
    private float f8600Q;
    private float f8601R;
    private float f8602S;
    private float f8603T;
    private float f8604U;
    private float f8605V;
    private float f8606W;
    private float f8607X;
    private int f8608Y;
    private int f8609Z;
    private final float[] aa = new float[2];
    private float ab;
    private float ac;
    private float ad;
    private float ae;
    private float af;
    private float ag;
    private final float f8610u;
    private final float f8611v;
    private final int f8612w;
    private float f8613x;
    private boolean f8614y;
    private boolean f8615z;

    public Marker(FacebookMap facebookMap, MarkerOptions markerOptions) {
        super(facebookMap);
        this.f8585B = markerOptions.f8617b;
        this.m = (double) Projection.d(this.f8585B.f8569b);
        this.n = (double) Projection.b(this.f8585B.f8568a);
        this.f8584A = markerOptions.f8618c;
        this.f8614y = markerOptions.f8620e;
        this.f8615z = markerOptions.f8621f;
        this.f8586C = markerOptions.f8622g;
        this.f8588E = markerOptions.f8624i;
        this.f8587D = markerOptions.f8623h;
        this.f8613x = markerOptions.f8619d;
        this.i = markerOptions.f8626k;
        this.k = markerOptions.f8625j;
        this.f8590G[0] = markerOptions.m14600b();
        this.f8590G[1] = markerOptions.m14601c();
        this.f8589F[0] = markerOptions.m14602e();
        this.f8589F[1] = markerOptions.m14603f();
        this.f8610u = this.f8079d * 48.0f;
        this.f8612w = (int) (this.f8079d * 8.0f);
        this.f8611v = this.f8079d * 5.0f;
        m14575r();
    }

    private void m14575r() {
        Bitmap bitmap = this.f8584A.f8534a;
        float width = (float) bitmap.getWidth();
        this.f8600Q = this.f8590G[0] * width;
        this.f8601R = width - this.f8600Q;
        float height = (float) bitmap.getHeight();
        this.f8602S = this.f8590G[1] * height;
        this.f8603T = height - this.f8602S;
        this.f8604U = this.f8589F[0] * width;
        this.f8605V = this.f8589F[1] * height;
        if (width < this.f8610u) {
            this.f8606W = (this.f8610u - width) / 2.0f;
        } else {
            this.f8606W = 0.0f;
        }
        if (height < this.f8610u) {
            this.f8607X = (this.f8610u - height) / 2.0f;
        } else {
            this.f8607X = 0.0f;
        }
        f8578o.setRotate(this.f8586C);
        this.f8078c[0] = this.f8600Q - this.f8604U;
        this.f8078c[1] = this.f8602S - this.f8605V;
        f8578o.mapPoints(this.f8078c);
        this.ae = (((float) this.f8608Y) + this.f8611v) + this.f8078c[1];
        this.af = ((float) (this.f8609Z / 2)) + this.f8078c[0];
        this.ag = ((float) (this.f8609Z / 2)) - this.f8078c[0];
    }

    public final int mo1031a(float f, float f2) {
        if (m14576s() && m14574g(f, f2)) {
            this.f8596M = true;
            return 2;
        }
        this.f8596M = false;
        if (!m14578u()) {
            return 0;
        }
        long a = AnalyticsEvent.a();
        try {
            this.aa[0] = f;
            this.aa[1] = f2;
            f8578o.setRotate(-this.ad, this.ab, this.ac);
            f8578o.mapPoints(this.aa);
            if (this.aa[0] >= this.ab - this.f8600Q && this.aa[0] <= this.ab + this.f8601R && this.aa[1] >= this.ac - this.f8602S && this.aa[1] <= this.ac + this.f8603T) {
                return 2;
            }
            if (this.aa[0] < (this.ab - this.f8600Q) - this.f8606W || this.aa[0] > (this.ab + this.f8601R) + this.f8606W || this.aa[1] < (this.ac - this.f8602S) - this.f8607X || this.aa[1] > (this.ac + this.f8603T) + this.f8607X) {
                AnalyticsEvent.h.a(AnalyticsEvent.a() - a);
                return 0;
            }
            AnalyticsEvent.h.a(AnalyticsEvent.a() - a);
            return 1;
        } finally {
            AnalyticsEvent.h.a(AnalyticsEvent.a() - a);
        }
    }

    private boolean m14574g(float f, float f2) {
        f8578o.setRotate(this.ad);
        this.aa[0] = this.f8604U - this.f8600Q;
        this.aa[1] = this.f8605V - this.f8602S;
        f8578o.mapPoints(this.aa);
        float[] fArr = this.aa;
        fArr[0] = fArr[0] + this.ab;
        fArr = this.aa;
        fArr[1] = fArr[1] + (this.ac - this.f8611v);
        int i = this.f8609Z / 2;
        float f3 = this.aa[1] - ((float) this.f8608Y);
        float f4 = this.aa[1];
        float f5 = this.aa[0] - ((float) i);
        float f6 = ((float) i) + this.aa[0];
        if (((float) this.f8608Y) <= this.f8610u) {
            f3 -= this.f8607X;
            f4 -= this.f8607X;
        }
        if (((float) this.f8609Z) <= this.f8610u) {
            f5 -= this.f8606W;
            f6 += this.f8606W;
        }
        if (f < f5 || f > r4 || f2 < r1 || f2 > r0) {
            return false;
        }
        return true;
    }

    public final void m14586a(String str) {
        this.f8587D = str;
        m14577t();
    }

    public final void m14582a(float f) {
        this.f8613x = f;
        m14231f();
    }

    public final LatLng mo1081a() {
        if (this.f8597N) {
            m14579v();
        }
        return this.f8585B;
    }

    public final void m14585a(LatLng latLng) {
        this.f8585B = latLng;
        this.m = (double) Projection.d(this.f8585B.f8569b);
        this.n = (double) Projection.b(this.f8585B.f8568a);
        m14231f();
    }

    public final void m14592f(float f, float f2) {
        this.f8590G[0] = f;
        this.f8590G[1] = f2;
        m14575r();
        m14231f();
    }

    public final void m14598q() {
        m14577t();
        m14220a(2);
        this.f8594K = true;
    }

    private boolean m14576s() {
        return this.f8594K;
    }

    public final void mo1065l() {
        if (this.f8594K) {
            m14597p();
        }
        this.f8080e.m14289b((MapDrawable) this);
    }

    public final void m14597p() {
        if (this.f8594K) {
            m14220a(1);
        }
        this.f8594K = false;
    }

    public final void m14584a(BitmapDescriptor bitmapDescriptor) {
        this.f8584A = bitmapDescriptor;
        m14575r();
        m14231f();
    }

    public final void mo1032a(Canvas canvas) {
        Object obj = 1;
        long a = AnalyticsEvent.a();
        try {
            Bitmap bitmap = this.f8584A.f8534a;
            if (!m14576s() || (this.f8588E == null && this.f8587D == null)) {
                obj = null;
            }
            if (m14578u()) {
                f8579p.setAlpha((int) (this.f8613x * 255.0f));
                f8578o.setTranslate(this.ab - this.f8600Q, this.ac - this.f8602S);
                f8578o.postRotate(this.ad, this.ab, this.ac);
                canvas.drawBitmap(bitmap, f8578o, f8579p);
                f8579p.setAlpha(255);
                if (obj != null) {
                    this.aa[0] = this.f8604U;
                    this.aa[1] = this.f8605V;
                    f8578o.mapPoints(this.aa);
                    long a2 = AnalyticsEvent.a();
                    int i = this.f8609Z / 2;
                    if (this.f8593J) {
                        f8580q.reset();
                        f8580q.moveTo(this.aa[0] - ((float) i), (this.aa[1] - ((float) this.f8608Y)) - this.f8611v);
                        f8580q.lineTo(this.aa[0] + ((float) i), (this.aa[1] - ((float) this.f8608Y)) - this.f8611v);
                        f8580q.lineTo(this.aa[0] + ((float) i), this.aa[1] - this.f8611v);
                        f8580q.lineTo(this.aa[0] + this.f8611v, this.aa[1] - this.f8611v);
                        f8580q.lineTo(this.aa[0], this.aa[1]);
                        f8580q.lineTo(this.aa[0] - this.f8611v, this.aa[1] - this.f8611v);
                        f8580q.lineTo(this.aa[0] - ((float) i), this.aa[1] - this.f8611v);
                        f8580q.close();
                        f8579p.setColor(-16777216);
                        f8579p.setShadowLayer(12.0f, 0.0f, 0.0f, -16777216);
                        canvas.drawPath(f8580q, f8579p);
                        f8579p.setColor(this.f8595L ? -2236963 : -1);
                        canvas.drawPath(f8580q, f8579p);
                    }
                    f8578o.setTranslate(this.aa[0] - ((float) i), (this.aa[1] - ((float) this.f8608Y)) - this.f8611v);
                    this.f8592I.setDrawingCacheEnabled(true);
                    canvas.drawBitmap(this.f8592I.getDrawingCache(), f8578o, f8579p);
                    AnalyticsEvent.i.a(AnalyticsEvent.a() - a2);
                }
                AnalyticsEvent.g.a(AnalyticsEvent.a() - a);
            }
        } finally {
            AnalyticsEvent.g.a(AnalyticsEvent.a() - a);
        }
    }

    private void m14577t() {
        this.f8592I = null;
        17 17 = this.f8080e.f8125N;
        if (17 != null) {
            this.f8592I = 17.a.b(MarkerDelegate.a(this));
            if (this.f8592I != null) {
                this.f8593J = false;
            } else {
                this.f8592I = 17.a.a(MarkerDelegate.a(this));
                this.f8593J = true;
            }
        }
        if (this.f8592I == null) {
            int i;
            View textView;
            this.f8593J = true;
            LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            View linearLayout = new LinearLayout(this.f8082g);
            linearLayout.setLayoutParams(layoutParams);
            linearLayout.setOrientation(1);
            if (this.f8588E == null || this.f8587D == null) {
                i = this.f8612w;
            } else {
                i = this.f8612w / 3;
            }
            if (this.f8588E != null) {
                textView = new TextView(this.f8082g);
                textView.setPadding(this.f8612w, this.f8612w, this.f8612w, i);
                textView.setText(this.f8588E);
                textView.setEllipsize(TruncateAt.END);
                textView.setMaxLines(1);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setGravity(17);
                textView.setTextColor(-16777216);
                layoutParams.width = -1;
                linearLayout.addView(textView, layoutParams);
            }
            if (this.f8587D != null) {
                textView = new TextView(this.f8082g);
                textView.setPadding(this.f8612w, i, this.f8612w, this.f8612w);
                textView.setText(this.f8587D);
                textView.setMaxLines(5);
                textView.setEllipsize(TruncateAt.END);
                textView.setTextColor(-12303292);
                layoutParams.gravity = 3;
                linearLayout.addView(textView, layoutParams);
            }
            this.f8592I = linearLayout;
        } else if (this.f8592I.getLayoutParams() == null) {
            this.f8592I.setLayoutParams(new LayoutParams(-2, -2));
        }
        this.f8592I.measure(MeasureSpec.makeMeasureSpec(this.f8080e.f8112A.getWidth(), Integer.MIN_VALUE), MeasureSpec.makeMeasureSpec(this.f8080e.f8112A.getHeight(), Integer.MIN_VALUE));
        this.f8609Z = this.f8592I.getMeasuredWidth();
        this.f8608Y = this.f8592I.getMeasuredHeight();
        this.f8592I.layout(0, 0, this.f8609Z, this.f8608Y);
        m14575r();
        m14231f();
    }

    public final void mo1078m() {
        if (this.f8596M) {
            this.f8595L = true;
            m14231f();
        }
    }

    public final void mo1079n() {
        if (this.f8596M && this.f8595L) {
            this.f8595L = false;
            m14231f();
        }
        if (this.f8597N) {
            m14579v();
            this.f8597N = false;
            m14220a(1);
            m14231f();
        }
    }

    public final boolean mo1038b(float f, float f2) {
        if (!((this.f8596M && this.f8591H.mo1035a(this)) || this.f8591H.mo1039b(this))) {
            m14598q();
            this.f8080e.m14282a(CameraUpdateFactory.m14202a(mo1081a()), 500, null);
        }
        return true;
    }

    public final void mo1045e() {
        m14597p();
    }

    public final void mo1086o() {
        this.f8591H.mo1044d(this);
    }

    public final boolean mo1041c(float f, float f2) {
        return this.f8591H.mo1042c(this);
    }

    public final boolean mo1085e(float f, float f2) {
        if (!this.f8614y) {
            return false;
        }
        this.f8597N = true;
        m14220a(2);
        this.f8081f.b(this.f8088m, this.f8089n, this.f8078c);
        this.ab = this.f8078c[0];
        this.ac = this.f8078c[1] - ((this.f8610u * 3.0f) / 5.0f);
        this.f8598O = f - this.ab;
        this.f8599P = f2 - this.ac;
        if (!f8582s) {
            f8582s = true;
            if (this.f8082g.getPackageManager().checkPermission("android.permission.VIBRATE", this.f8082g.getPackageName()) == 0) {
                f8583t = (Vibrator) this.f8082g.getSystemService("vibrator");
            }
        }
        if (f8583t != null) {
            f8583t.vibrate(10);
        }
        m14231f();
        return true;
    }

    public final boolean mo1077d(float f, float f2) {
        if (!this.f8597N) {
            return false;
        }
        this.ab = f - this.f8598O;
        this.ac = f2 - this.f8599P;
        m14231f();
        return true;
    }

    private boolean m14578u() {
        float b;
        if (!this.f8594K || (this.f8588E == null && this.f8587D == null)) {
            boolean z = false;
        } else {
            int i = 1;
        }
        float f = this.f8586C;
        if (this.f8615z) {
            b = this.f8081f.b();
        } else {
            b = 0.0f;
        }
        this.ad = b + f;
        f8581r.c = this.f8088m - this.f8081f.a(this.f8600Q);
        f8581r.d = this.f8088m + this.f8081f.a(this.f8601R);
        f8581r.a = this.f8089n - this.f8081f.a(this.f8602S);
        f8581r.b = this.f8089n + this.f8081f.a(this.f8603T);
        if (this.f8586C != 0.0f) {
            f8581r.a(Math.toRadians((double) this.f8586C), this.f8088m, this.f8089n);
        }
        if (i != 0) {
            double a = this.f8089n - this.f8081f.a(this.ae);
            if (a < f8581r.a) {
                f8581r.a = a;
            }
            a = this.f8088m - this.f8081f.a(this.af);
            if (a < f8581r.c) {
                f8581r.c = a;
            }
            a = this.f8088m + this.f8081f.a(this.ag);
            if (f8581r.d < a) {
                f8581r.d = a;
            }
        }
        if (!m14223a(f8581r, this.f8078c)) {
            return false;
        }
        float f2 = this.f8078c[0];
        if (!this.f8597N) {
            this.f8081f.b(this.f8088m + ((double) f2), this.f8089n, this.f8078c);
            this.ab = this.f8078c[0];
            this.ac = this.f8078c[1];
        }
        return true;
    }

    private void m14579v() {
        this.f8081f.a(this.ab, this.ac, this.f8078c);
        this.m = (double) this.f8078c[0];
        this.n = (double) this.f8078c[1];
        this.f8585B = new LatLng(Projection.a(this.f8089n), Projection.c(this.f8088m));
    }
}

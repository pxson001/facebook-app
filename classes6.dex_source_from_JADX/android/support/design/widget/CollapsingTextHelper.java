package android.support.design.widget;

import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.animation.Interpolator;
import com.facebook.R;

/* compiled from: purchased_ticket_orders */
public final class CollapsingTextHelper {
    private static final boolean f6907a = (VERSION.SDK_INT < 18);
    private static final Paint f6908b = null;
    private boolean f6909A;
    private Bitmap f6910B;
    private Paint f6911C;
    private float f6912D;
    private float f6913E;
    private float f6914F;
    private float f6915G;
    private boolean f6916H;
    private final TextPaint f6917I;
    public Interpolator f6918J;
    public Interpolator f6919K;
    private float f6920L;
    private float f6921M;
    private float f6922N;
    private int f6923O;
    private float f6924P;
    private float f6925Q;
    private float f6926R;
    private int f6927S;
    public final View f6928c;
    private boolean f6929d;
    public float f6930e;
    public final Rect f6931f;
    public final Rect f6932g;
    public final RectF f6933h;
    public int f6934i = 16;
    public int f6935j = 16;
    public float f6936k = 15.0f;
    public float f6937l = 15.0f;
    private int f6938m;
    public int f6939n;
    public float f6940o;
    public float f6941p;
    private float f6942q;
    private float f6943r;
    private float f6944s;
    private float f6945t;
    public Typeface f6946u;
    public Typeface f6947v;
    private Typeface f6948w;
    public CharSequence f6949x;
    private CharSequence f6950y;
    private boolean f6951z;

    static {
        if (null != null) {
            f6908b.setAntiAlias(true);
            f6908b.setColor(-65281);
        }
    }

    public CollapsingTextHelper(View view) {
        this.f6928c = view;
        this.f6917I = new TextPaint();
        this.f6917I.setAntiAlias(true);
        this.f6932g = new Rect();
        this.f6931f = new Rect();
        this.f6933h = new RectF();
    }

    final void m10050a(int i) {
        if (this.f6939n != i) {
            this.f6939n = i;
            m10063g();
        }
    }

    final void m10055b(int i) {
        if (this.f6938m != i) {
            this.f6938m = i;
            m10063g();
        }
    }

    final void m10051a(int i, int i2, int i3, int i4) {
        if (!m10040a(this.f6931f, i, i2, i3, i4)) {
            this.f6931f.set(i, i2, i3, i4);
            this.f6916H = true;
            m10045j();
        }
    }

    final void m10056b(int i, int i2, int i3, int i4) {
        if (!m10040a(this.f6932g, i, i2, i3, i4)) {
            this.f6932g.set(i, i2, i3, i4);
            this.f6916H = true;
            m10045j();
        }
    }

    private void m10045j() {
        boolean z = this.f6932g.width() > 0 && this.f6932g.height() > 0 && this.f6931f.width() > 0 && this.f6931f.height() > 0;
        this.f6929d = z;
    }

    final void m10058c(int i) {
        if (this.f6934i != i) {
            this.f6934i = i;
            m10063g();
        }
    }

    final void m10060d(int i) {
        if (this.f6935j != i) {
            this.f6935j = i;
            m10063g();
        }
    }

    final void m10061e(int i) {
        TypedArray obtainStyledAttributes = this.f6928c.getContext().obtainStyledAttributes(i, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f6939n = obtainStyledAttributes.getColor(3, this.f6939n);
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.f6937l = (float) obtainStyledAttributes.getDimensionPixelSize(0, (int) this.f6937l);
        }
        this.f6923O = obtainStyledAttributes.getInt(6, 0);
        this.f6921M = obtainStyledAttributes.getFloat(7, 0.0f);
        this.f6922N = obtainStyledAttributes.getFloat(8, 0.0f);
        this.f6920L = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.f6946u = m10044g(i);
        }
        m10063g();
    }

    final void m10062f(int i) {
        TypedArray obtainStyledAttributes = this.f6928c.getContext().obtainStyledAttributes(i, R.styleable.TextAppearance);
        if (obtainStyledAttributes.hasValue(3)) {
            this.f6938m = obtainStyledAttributes.getColor(3, this.f6938m);
        }
        if (obtainStyledAttributes.hasValue(0)) {
            this.f6936k = (float) obtainStyledAttributes.getDimensionPixelSize(0, (int) this.f6936k);
        }
        this.f6927S = obtainStyledAttributes.getInt(6, 0);
        this.f6925Q = obtainStyledAttributes.getFloat(7, 0.0f);
        this.f6926R = obtainStyledAttributes.getFloat(8, 0.0f);
        this.f6924P = obtainStyledAttributes.getFloat(9, 0.0f);
        obtainStyledAttributes.recycle();
        if (VERSION.SDK_INT >= 16) {
            this.f6947v = m10044g(i);
        }
        m10063g();
    }

    private Typeface m10044g(int i) {
        TypedArray obtainStyledAttributes = this.f6928c.getContext().obtainStyledAttributes(i, new int[]{16843692});
        try {
            String string = obtainStyledAttributes.getString(0);
            if (string != null) {
                Typeface create = Typeface.create(string, 0);
                return create;
            }
            obtainStyledAttributes.recycle();
            return null;
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    final void m10059c(Typeface typeface) {
        this.f6947v = typeface;
        this.f6946u = typeface;
        m10063g();
    }

    final Typeface m10057c() {
        return this.f6946u != null ? this.f6946u : Typeface.DEFAULT;
    }

    final void m10054b(float f) {
        float a = MathUtils.m10147a(f, 0.0f, 1.0f);
        if (a != this.f6930e) {
            this.f6930e = a;
            m10046k();
        }
    }

    private void m10046k() {
        m10041c(this.f6930e);
    }

    private void m10041c(float f) {
        this.f6933h.left = m10037a((float) this.f6931f.left, (float) this.f6932g.left, f, this.f6918J);
        this.f6933h.top = m10037a(this.f6940o, this.f6941p, f, this.f6918J);
        this.f6933h.right = m10037a((float) this.f6931f.right, (float) this.f6932g.right, f, this.f6918J);
        this.f6933h.bottom = m10037a((float) this.f6931f.bottom, (float) this.f6932g.bottom, f, this.f6918J);
        this.f6944s = m10037a(this.f6942q, this.f6943r, f, this.f6918J);
        this.f6945t = m10037a(this.f6940o, this.f6941p, f, this.f6918J);
        m10042e(m10037a(this.f6936k, this.f6937l, f, this.f6919K));
        if (this.f6939n != this.f6938m) {
            this.f6917I.setColor(m10038a(this.f6938m, this.f6939n, f));
        } else {
            this.f6917I.setColor(this.f6939n);
        }
        this.f6917I.setShadowLayer(m10037a(this.f6924P, this.f6920L, f, null), m10037a(this.f6925Q, this.f6921M, f, null), m10037a(this.f6926R, this.f6922N, f, null), m10038a(this.f6927S, this.f6923O, f));
        ViewCompat.d(this.f6928c);
    }

    private void m10047l() {
        int i;
        int i2 = 1;
        float f = 0.0f;
        float f2 = this.f6915G;
        m10043f(this.f6937l);
        float measureText = this.f6950y != null ? this.f6917I.measureText(this.f6950y, 0, this.f6950y.length()) : 0.0f;
        int i3 = this.f6935j;
        if (this.f6951z) {
            i = 1;
        } else {
            i = 0;
        }
        i = GravityCompat.a(i3, i);
        switch (i & 112) {
            case 48:
                this.f6941p = ((float) this.f6932g.top) - this.f6917I.ascent();
                break;
            case 80:
                this.f6941p = (float) this.f6932g.bottom;
                break;
            default:
                this.f6941p = (((this.f6917I.descent() - this.f6917I.ascent()) / 2.0f) - this.f6917I.descent()) + ((float) this.f6932g.centerY());
                break;
        }
        switch (i & 7) {
            case 1:
                this.f6943r = ((float) this.f6932g.centerX()) - (measureText / 2.0f);
                break;
            case 5:
                this.f6943r = ((float) this.f6932g.right) - measureText;
                break;
            default:
                this.f6943r = (float) this.f6932g.left;
                break;
        }
        m10043f(this.f6936k);
        if (this.f6950y != null) {
            f = this.f6917I.measureText(this.f6950y, 0, this.f6950y.length());
        }
        int i4 = this.f6934i;
        if (!this.f6951z) {
            i2 = 0;
        }
        i4 = GravityCompat.a(i4, i2);
        switch (i4 & 112) {
            case 48:
                this.f6940o = ((float) this.f6931f.top) - this.f6917I.ascent();
                break;
            case 80:
                this.f6940o = (float) this.f6931f.bottom;
                break;
            default:
                this.f6940o = (((this.f6917I.descent() - this.f6917I.ascent()) / 2.0f) - this.f6917I.descent()) + ((float) this.f6931f.centerY());
                break;
        }
        switch (i4 & 7) {
            case 1:
                this.f6942q = ((float) this.f6931f.centerX()) - (f / 2.0f);
                break;
            case 5:
                this.f6942q = ((float) this.f6931f.right) - f;
                break;
            default:
                this.f6942q = (float) this.f6931f.left;
                break;
        }
        m10049n();
        m10042e(f2);
    }

    public final void m10052a(Canvas canvas) {
        int save = canvas.save();
        if (this.f6950y != null && this.f6929d) {
            float f;
            float f2 = this.f6944s;
            float f3 = this.f6945t;
            int i = (!this.f6909A || this.f6910B == null) ? 0 : 1;
            this.f6917I.setTextSize(this.f6915G);
            if (i != 0) {
                f = this.f6912D * this.f6914F;
            } else {
                this.f6917I.ascent();
                f = 0.0f;
                this.f6917I.descent();
            }
            if (i != 0) {
                f3 += f;
            }
            if (this.f6914F != 1.0f) {
                canvas.scale(this.f6914F, this.f6914F, f2, f3);
            }
            if (i != 0) {
                canvas.drawBitmap(this.f6910B, f2, f3, this.f6911C);
            } else {
                canvas.drawText(this.f6950y, 0, this.f6950y.length(), f2, f3, this.f6917I);
            }
        }
        canvas.restoreToCount(save);
    }

    private void m10042e(float f) {
        m10043f(f);
        boolean z = f6907a && this.f6914F != 1.0f;
        this.f6909A = z;
        if (this.f6909A) {
            m10048m();
        }
        ViewCompat.d(this.f6928c);
    }

    private void m10043f(float f) {
        boolean z = true;
        if (this.f6949x != null) {
            float width;
            float f2;
            boolean z2;
            if (m10039a(f, this.f6937l)) {
                width = (float) this.f6932g.width();
                float f3 = this.f6937l;
                this.f6914F = 1.0f;
                if (this.f6948w != this.f6946u) {
                    this.f6948w = this.f6946u;
                    f2 = width;
                    width = f3;
                    z2 = true;
                } else {
                    f2 = width;
                    width = f3;
                    z2 = false;
                }
            } else {
                f2 = (float) this.f6931f.width();
                width = this.f6936k;
                if (this.f6948w != this.f6947v) {
                    this.f6948w = this.f6947v;
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (m10039a(f, this.f6936k)) {
                    this.f6914F = 1.0f;
                } else {
                    this.f6914F = f / this.f6936k;
                }
            }
            if (f2 > 0.0f) {
                if (!(this.f6915G != width || this.f6916H || z2)) {
                    z = false;
                }
                this.f6915G = width;
                this.f6916H = false;
            } else {
                z = z2;
            }
            if (this.f6950y == null || r1) {
                this.f6917I.setTextSize(this.f6915G);
                this.f6917I.setTypeface(this.f6948w);
                CharSequence ellipsize = TextUtils.ellipsize(this.f6949x, this.f6917I, f2, TruncateAt.END);
                if (!TextUtils.equals(ellipsize, this.f6950y)) {
                    TextDirectionHeuristicCompat textDirectionHeuristicCompat;
                    this.f6950y = ellipsize;
                    ellipsize = this.f6950y;
                    int i = 1;
                    if (ViewCompat.h(this.f6928c) != 1) {
                        i = 0;
                    }
                    if (i != 0) {
                        textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.d;
                    } else {
                        textDirectionHeuristicCompat = TextDirectionHeuristicsCompat.c;
                    }
                    this.f6951z = textDirectionHeuristicCompat.a(ellipsize, 0, ellipsize.length());
                }
            }
        }
    }

    private void m10048m() {
        if (this.f6910B == null && !this.f6931f.isEmpty() && !TextUtils.isEmpty(this.f6950y)) {
            m10041c(0.0f);
            this.f6912D = this.f6917I.ascent();
            this.f6913E = this.f6917I.descent();
            int round = Math.round(this.f6917I.measureText(this.f6950y, 0, this.f6950y.length()));
            int round2 = Math.round(this.f6913E - this.f6912D);
            if (round > 0 || round2 > 0) {
                this.f6910B = Bitmap.createBitmap(round, round2, Config.ARGB_8888);
                new Canvas(this.f6910B).drawText(this.f6950y, 0, this.f6950y.length(), 0.0f, ((float) round2) - this.f6917I.descent(), this.f6917I);
                if (this.f6911C == null) {
                    this.f6911C = new Paint(3);
                }
            }
        }
    }

    public final void m10063g() {
        if (this.f6928c.getHeight() > 0 && this.f6928c.getWidth() > 0) {
            m10047l();
            m10046k();
        }
    }

    final void m10053a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f6949x)) {
            this.f6949x = charSequence;
            this.f6950y = null;
            m10049n();
            m10063g();
        }
    }

    private void m10049n() {
        if (this.f6910B != null) {
            this.f6910B.recycle();
            this.f6910B = null;
        }
    }

    private static boolean m10039a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    private static int m10038a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((((float) Color.alpha(i)) * f2) + (((float) Color.alpha(i2)) * f)), (int) ((((float) Color.red(i)) * f2) + (((float) Color.red(i2)) * f)), (int) ((((float) Color.green(i)) * f2) + (((float) Color.green(i2)) * f)), (int) ((f2 * ((float) Color.blue(i))) + (((float) Color.blue(i2)) * f)));
    }

    public static float m10037a(float f, float f2, float f3, Interpolator interpolator) {
        if (interpolator != null) {
            f3 = interpolator.getInterpolation(f3);
        }
        return AnimationUtils.m9978a(f, f2, f3);
    }

    private static boolean m10040a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}

package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.FillType;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import java.util.ArrayList;

/* compiled from: nux_id */
public class MaterialProgressDrawable extends Drawable implements Animatable {
    public static final Interpolator f11723b = new LinearInterpolator();
    public static final Interpolator f11724c = new EndCurveInterpolator();
    public static final Interpolator f11725d = new StartCurveInterpolator();
    private static final Interpolator f11726e = new AccelerateDecelerateInterpolator();
    boolean f11727a;
    private final int[] f11728f = new int[]{-16777216};
    private final ArrayList<Animation> f11729g = new ArrayList();
    public final Ring f11730h;
    private float f11731i;
    private Resources f11732j;
    private View f11733k;
    public Animation f11734l;
    public float f11735m;
    private double f11736n;
    private double f11737o;
    private final Callback f11738p = new C04893(this);

    /* compiled from: nux_id */
    class EndCurveInterpolator extends AccelerateDecelerateInterpolator {
        public float getInterpolation(float f) {
            return super.getInterpolation(Math.max(0.0f, (f - 0.5f) * 2.0f));
        }
    }

    /* compiled from: nux_id */
    class StartCurveInterpolator extends AccelerateDecelerateInterpolator {
        public float getInterpolation(float f) {
            return super.getInterpolation(Math.min(1.0f, 2.0f * f));
        }
    }

    /* compiled from: nux_id */
    class C04893 implements Callback {
        final /* synthetic */ MaterialProgressDrawable f11739a;

        C04893(MaterialProgressDrawable materialProgressDrawable) {
            this.f11739a = materialProgressDrawable;
        }

        public void invalidateDrawable(Drawable drawable) {
            this.f11739a.invalidateSelf();
        }

        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            this.f11739a.scheduleSelf(runnable, j);
        }

        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            this.f11739a.unscheduleSelf(runnable);
        }
    }

    /* compiled from: nux_id */
    public class Ring {
        private final RectF f11740a = new RectF();
        private final Paint f11741b = new Paint();
        private final Paint f11742c = new Paint();
        private final Callback f11743d;
        public float f11744e = 0.0f;
        public float f11745f = 0.0f;
        private float f11746g = 0.0f;
        public float f11747h = 5.0f;
        private float f11748i = 2.5f;
        public int[] f11749j;
        public int f11750k;
        public float f11751l;
        public float f11752m;
        public float f11753n;
        private boolean f11754o;
        private Path f11755p;
        private float f11756q;
        private double f11757r;
        private int f11758s;
        private int f11759t;
        public int f11760u;
        private final Paint f11761v = new Paint();
        public int f11762w;

        public Ring(Callback callback) {
            this.f11743d = callback;
            this.f11741b.setStrokeCap(Cap.SQUARE);
            this.f11741b.setAntiAlias(true);
            this.f11741b.setStyle(Style.STROKE);
            this.f11742c.setStyle(Style.FILL);
            this.f11742c.setAntiAlias(true);
        }

        public final void m17008a(float f, float f2) {
            this.f11758s = (int) f;
            this.f11759t = (int) f2;
        }

        public final void m17010a(Canvas canvas, Rect rect) {
            RectF rectF = this.f11740a;
            rectF.set(rect);
            rectF.inset(this.f11748i, this.f11748i);
            float f = (this.f11744e + this.f11746g) * 360.0f;
            float f2 = ((this.f11745f + this.f11746g) * 360.0f) - f;
            this.f11741b.setColor(this.f11749j[this.f11750k]);
            canvas.drawArc(rectF, f, f2, false, this.f11741b);
            m17004a(canvas, f, f2, rect);
            if (this.f11760u < 255) {
                this.f11761v.setColor(this.f11762w);
                this.f11761v.setAlpha(255 - this.f11760u);
                canvas.drawCircle(rect.exactCenterX(), rect.exactCenterY(), (float) (rect.width() / 2), this.f11761v);
            }
        }

        private void m17004a(Canvas canvas, float f, float f2, Rect rect) {
            if (this.f11754o) {
                if (this.f11755p == null) {
                    this.f11755p = new Path();
                    this.f11755p.setFillType(FillType.EVEN_ODD);
                } else {
                    this.f11755p.reset();
                }
                float f3 = ((float) (((int) this.f11748i) / 2)) * this.f11756q;
                float cos = (float) ((this.f11757r * Math.cos(0.0d)) + ((double) rect.exactCenterX()));
                float sin = (float) ((this.f11757r * Math.sin(0.0d)) + ((double) rect.exactCenterY()));
                this.f11755p.moveTo(0.0f, 0.0f);
                this.f11755p.lineTo(((float) this.f11758s) * this.f11756q, 0.0f);
                this.f11755p.lineTo((((float) this.f11758s) * this.f11756q) / 2.0f, ((float) this.f11759t) * this.f11756q);
                this.f11755p.offset(cos - f3, sin);
                this.f11755p.close();
                this.f11742c.setColor(this.f11749j[this.f11750k]);
                canvas.rotate((f + f2) - 5.0f, rect.exactCenterX(), rect.exactCenterY());
                canvas.drawPath(this.f11755p, this.f11742c);
            }
        }

        public final void m17013a(@NonNull int[] iArr) {
            this.f11749j = iArr;
            this.f11750k = 0;
        }

        public final void m17011a(ColorFilter colorFilter) {
            this.f11741b.setColorFilter(colorFilter);
            m17005l();
        }

        public final void m17007a(float f) {
            this.f11747h = f;
            this.f11741b.setStrokeWidth(f);
            m17005l();
        }

        public final void m17014b(float f) {
            this.f11744e = f;
            m17005l();
        }

        public final void m17015c(float f) {
            this.f11745f = f;
            m17005l();
        }

        public final void m17016d(float f) {
            this.f11746g = f;
            m17005l();
        }

        public final void m17009a(int i, int i2) {
            float min = (float) Math.min(i, i2);
            if (this.f11757r <= 0.0d || min < 0.0f) {
                min = (float) Math.ceil((double) (this.f11747h / 2.0f));
            } else {
                min = (float) (((double) (min / 2.0f)) - this.f11757r);
            }
            this.f11748i = min;
        }

        public final void m17006a(double d) {
            this.f11757r = d;
        }

        public final double m17018h() {
            return this.f11757r;
        }

        public final void m17012a(boolean z) {
            if (this.f11754o != z) {
                this.f11754o = z;
                m17005l();
            }
        }

        public final void m17017e(float f) {
            if (f != this.f11756q) {
                this.f11756q = f;
                m17005l();
            }
        }

        public final void m17019j() {
            this.f11751l = this.f11744e;
            this.f11752m = this.f11745f;
            this.f11753n = this.f11746g;
        }

        public final void m17020k() {
            this.f11751l = 0.0f;
            this.f11752m = 0.0f;
            this.f11753n = 0.0f;
            m17014b(0.0f);
            m17015c(0.0f);
            m17016d(0.0f);
        }

        private void m17005l() {
            this.f11743d.invalidateDrawable(null);
        }
    }

    public MaterialProgressDrawable(Context context, View view) {
        this.f11733k = view;
        this.f11732j = context.getResources();
        this.f11730h = new Ring(this.f11738p);
        this.f11730h.m17013a(this.f11728f);
        m17000a(1);
        final Ring ring = this.f11730h;
        Animation c04901 = new Animation(this) {
            final /* synthetic */ MaterialProgressDrawable f11764b;

            public void applyTransformation(float f, Transformation transformation) {
                if (this.f11764b.f11727a) {
                    MaterialProgressDrawable materialProgressDrawable = this.f11764b;
                    Ring ring = ring;
                    float floor = (float) (Math.floor((double) (ring.f11753n / 0.8f)) + 1.0d);
                    ring.m17014b(ring.f11751l + ((ring.f11752m - ring.f11751l) * f));
                    ring.m17016d(((floor - ring.f11753n) * f) + ring.f11753n);
                    return;
                }
                float toRadians = (float) Math.toRadians(((double) ring.f11747h) / (6.283185307179586d * ring.m17018h()));
                float f2 = ring.f11752m;
                float f3 = ring.f11751l;
                float f4 = ring.f11753n;
                ring.m17015c(((0.8f - toRadians) * MaterialProgressDrawable.f11725d.getInterpolation(f)) + f2);
                ring.m17014b((MaterialProgressDrawable.f11724c.getInterpolation(f) * 0.8f) + f3);
                ring.m17016d((0.25f * f) + f4);
                this.f11764b.m17003c((144.0f * f) + (720.0f * (this.f11764b.f11735m / 5.0f)));
            }
        };
        c04901.setRepeatCount(-1);
        c04901.setRepeatMode(1);
        c04901.setInterpolator(f11723b);
        c04901.setAnimationListener(new AnimationListener(this) {
            final /* synthetic */ MaterialProgressDrawable f11766b;

            public void onAnimationStart(Animation animation) {
                this.f11766b.f11735m = 0.0f;
            }

            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
                ring.m17019j();
                Ring ring = ring;
                ring.f11750k = (ring.f11750k + 1) % ring.f11749j.length;
                ring.m17014b(ring.f11745f);
                if (this.f11766b.f11727a) {
                    this.f11766b.f11727a = false;
                    animation.setDuration(1333);
                    ring.m17012a(false);
                    return;
                }
                this.f11766b.f11735m = (this.f11766b.f11735m + 1.0f) % 5.0f;
            }
        });
        this.f11734l = c04901;
    }

    private void m16997a(double d, double d2, double d3, double d4, float f, float f2) {
        Ring ring = this.f11730h;
        float f3 = this.f11732j.getDisplayMetrics().density;
        this.f11736n = ((double) f3) * d;
        this.f11737o = ((double) f3) * d2;
        ring.m17007a(((float) d4) * f3);
        ring.m17006a(((double) f3) * d3);
        ring.f11750k = 0;
        ring.m17008a(f * f3, f3 * f2);
        ring.m17009a((int) this.f11736n, (int) this.f11737o);
    }

    public final void m17000a(@ProgressDrawableSize int i) {
        if (i == 0) {
            m16997a(56.0d, 56.0d, 12.5d, 3.0d, 12.0f, 6.0f);
        } else {
            m16997a(40.0d, 40.0d, 8.75d, 2.5d, 10.0f, 5.0f);
        }
    }

    public final void m17001a(boolean z) {
        this.f11730h.m17012a(z);
    }

    public final void m16998a(float f) {
        this.f11730h.m17017e(f);
    }

    public final void m16999a(float f, float f2) {
        this.f11730h.m17014b(f);
        this.f11730h.m17015c(f2);
    }

    public final void m17002b(int i) {
        this.f11730h.f11762w = i;
    }

    public int getIntrinsicHeight() {
        return (int) this.f11737o;
    }

    public int getIntrinsicWidth() {
        return (int) this.f11736n;
    }

    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        int save = canvas.save();
        canvas.rotate(this.f11731i, bounds.exactCenterX(), bounds.exactCenterY());
        this.f11730h.m17010a(canvas, bounds);
        canvas.restoreToCount(save);
    }

    public void setAlpha(int i) {
        this.f11730h.f11760u = i;
    }

    public int getAlpha() {
        return this.f11730h.f11760u;
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f11730h.m17011a(colorFilter);
    }

    final void m17003c(float f) {
        this.f11731i = f;
        invalidateSelf();
    }

    public int getOpacity() {
        return -3;
    }

    public boolean isRunning() {
        ArrayList arrayList = this.f11729g;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Animation animation = (Animation) arrayList.get(i);
            if (animation.hasStarted() && !animation.hasEnded()) {
                return true;
            }
        }
        return false;
    }

    public void start() {
        this.f11734l.reset();
        this.f11730h.m17019j();
        if (this.f11730h.f11745f != this.f11730h.f11744e) {
            this.f11727a = true;
            this.f11734l.setDuration(666);
            this.f11733k.startAnimation(this.f11734l);
            return;
        }
        this.f11730h.f11750k = 0;
        this.f11730h.m17020k();
        this.f11734l.setDuration(1333);
        this.f11733k.startAnimation(this.f11734l);
    }

    public void stop() {
        this.f11733k.clearAnimation();
        m17003c(0.0f);
        this.f11730h.m17012a(false);
        this.f11730h.f11750k = 0;
        this.f11730h.m17020k();
    }
}

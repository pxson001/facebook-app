package com.facebook.imagepipeline.animated.base;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.time.MonotonicClock;
import com.facebook.drawable.base.DrawableWithCaches;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: TREEHOUSE_NOTIF */
public abstract class AbstractAnimatedDrawable extends Drawable implements Animatable, DrawableWithCaches {
    private static final Class<?> f13564a = AnimatedDrawable.class;
    private boolean f13565A;
    public boolean f13566B;
    public long f13567C = -1;
    private final Runnable f13568D = new C12921(this);
    private final Runnable f13569E = new C12932(this);
    private final Runnable f13570F = new C12943(this);
    public final Runnable f13571G = new C12954(this);
    public final ScheduledExecutorService f13572b;
    private final AnimatedDrawableDiagnostics f13573c;
    public final MonotonicClock f13574d;
    public final int f13575e;
    private final int f13576f;
    private final int f13577g;
    private final Paint f13578h = new Paint(6);
    private final Rect f13579i = new Rect();
    private final Paint f13580j;
    public volatile String f13581k;
    public AnimatedDrawableCachingBackend f13582l;
    private long f13583m;
    public int f13584n;
    public int f13585o;
    public int f13586p;
    public int f13587q;
    private int f13588r = -1;
    private int f13589s = -1;
    private CloseableReference<Bitmap> f13590t;
    public boolean f13591u;
    public long f13592v = -1;
    public boolean f13593w;
    public boolean f13594x;
    private float f13595y = 1.0f;
    private float f13596z = 1.0f;

    /* compiled from: TREEHOUSE_NOTIF */
    class C12921 implements Runnable {
        final /* synthetic */ AbstractAnimatedDrawable f13560a;

        C12921(AbstractAnimatedDrawable abstractAnimatedDrawable) {
            this.f13560a = abstractAnimatedDrawable;
        }

        public void run() {
            AbstractAnimatedDrawable.m22838e(this.f13560a);
        }
    }

    /* compiled from: TREEHOUSE_NOTIF */
    class C12932 implements Runnable {
        final /* synthetic */ AbstractAnimatedDrawable f13561a;

        C12932(AbstractAnimatedDrawable abstractAnimatedDrawable) {
            this.f13561a = abstractAnimatedDrawable;
        }

        public void run() {
            String str = this.f13561a.f13581k;
            AbstractAnimatedDrawable.m22839f(this.f13561a);
        }
    }

    /* compiled from: TREEHOUSE_NOTIF */
    class C12943 implements Runnable {
        final /* synthetic */ AbstractAnimatedDrawable f13562a;

        C12943(AbstractAnimatedDrawable abstractAnimatedDrawable) {
            this.f13562a = abstractAnimatedDrawable;
        }

        public void run() {
            String str = this.f13562a.f13581k;
            this.f13562a.f13566B = false;
            AbstractAnimatedDrawable.m22841i(this.f13562a);
        }
    }

    /* compiled from: TREEHOUSE_NOTIF */
    class C12954 implements Runnable {
        final /* synthetic */ AbstractAnimatedDrawable f13563a;

        C12954(AbstractAnimatedDrawable abstractAnimatedDrawable) {
            this.f13563a = abstractAnimatedDrawable;
        }

        public void run() {
            String str = this.f13563a.f13581k;
            AbstractAnimatedDrawable abstractAnimatedDrawable = this.f13563a;
            boolean z = false;
            abstractAnimatedDrawable.f13594x = false;
            if (abstractAnimatedDrawable.f13593w) {
                long now = abstractAnimatedDrawable.f13574d.now();
                boolean z2 = abstractAnimatedDrawable.f13591u && now - abstractAnimatedDrawable.f13592v > 1000;
                if (abstractAnimatedDrawable.f13567C != -1 && now - abstractAnimatedDrawable.f13567C > 1000) {
                    z = true;
                }
                if (z2 || r3) {
                    abstractAnimatedDrawable.aj_();
                    AbstractAnimatedDrawable.m22841i(abstractAnimatedDrawable);
                    return;
                }
                abstractAnimatedDrawable.f13572b.schedule(abstractAnimatedDrawable.f13571G, 2000, TimeUnit.MILLISECONDS);
                abstractAnimatedDrawable.f13594x = true;
            }
        }
    }

    public AbstractAnimatedDrawable(ScheduledExecutorService scheduledExecutorService, AnimatedDrawableCachingBackend animatedDrawableCachingBackend, AnimatedDrawableDiagnostics animatedDrawableDiagnostics, MonotonicClock monotonicClock) {
        this.f13572b = scheduledExecutorService;
        this.f13582l = animatedDrawableCachingBackend;
        this.f13573c = animatedDrawableDiagnostics;
        this.f13574d = monotonicClock;
        this.f13575e = this.f13582l.mo1242b();
        this.f13576f = this.f13582l.mo1244c();
        this.f13573c.mo1267a(this.f13582l);
        this.f13577g = this.f13582l.mo1246d();
        this.f13580j = new Paint();
        this.f13580j.setColor(0);
        this.f13580j.setStyle(Style.FILL);
        this.f13584n = this.f13582l.mo1254i();
        this.f13585o = this.f13584n;
        this.f13586p = -1;
        this.f13587q = -1;
    }

    protected void finalize() {
        super.finalize();
        if (this.f13590t != null) {
            this.f13590t.close();
            this.f13590t = null;
        }
    }

    public int getIntrinsicWidth() {
        return this.f13582l.mo1248e();
    }

    public int getIntrinsicHeight() {
        return this.f13582l.mo1250f();
    }

    public void setAlpha(int i) {
        this.f13578h.setAlpha(i);
        m22841i(this);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f13578h.setColorFilter(colorFilter);
        m22841i(this);
    }

    public int getOpacity() {
        return -3;
    }

    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f13565A = true;
        if (this.f13590t != null) {
            this.f13590t.close();
            this.f13590t = null;
        }
        this.f13588r = -1;
        this.f13589s = -1;
        this.f13582l.mo1256k();
    }

    public static void m22838e(AbstractAnimatedDrawable abstractAnimatedDrawable) {
        if (abstractAnimatedDrawable.f13593w) {
            abstractAnimatedDrawable.f13573c.mo1264a();
            try {
                abstractAnimatedDrawable.f13583m = abstractAnimatedDrawable.f13574d.now();
                abstractAnimatedDrawable.f13584n = 0;
                abstractAnimatedDrawable.f13585o = 0;
                long d = abstractAnimatedDrawable.f13583m + ((long) abstractAnimatedDrawable.f13582l.mo1247d(0));
                abstractAnimatedDrawable.scheduleSelf(abstractAnimatedDrawable.f13569E, d);
                abstractAnimatedDrawable.f13567C = d;
                m22841i(abstractAnimatedDrawable);
            } finally {
                abstractAnimatedDrawable.f13573c.mo1268b();
            }
        }
    }

    public static void m22839f(AbstractAnimatedDrawable abstractAnimatedDrawable) {
        abstractAnimatedDrawable.f13567C = -1;
        if (abstractAnimatedDrawable.f13593w && abstractAnimatedDrawable.f13575e != 0) {
            abstractAnimatedDrawable.f13573c.mo1270c();
            try {
                abstractAnimatedDrawable.m22836a(true);
            } finally {
                abstractAnimatedDrawable.f13573c.mo1271d();
            }
        }
    }

    private void m22836a(boolean z) {
        if (this.f13575e != 0) {
            long now = this.f13574d.now();
            int i = (int) ((now - this.f13583m) / ((long) this.f13575e));
            if (this.f13577g <= 0 || i < this.f13577g) {
                int i2 = (int) ((now - this.f13583m) % ((long) this.f13575e));
                int b = this.f13582l.mo1243b(i2);
                Object obj = this.f13584n != b ? 1 : null;
                this.f13584n = b;
                this.f13585o = (i * this.f13576f) + b;
                if (!z) {
                    return;
                }
                if (obj != null) {
                    m22841i(this);
                    return;
                }
                int c = (this.f13582l.mo1245c(this.f13584n) + this.f13582l.mo1247d(this.f13584n)) - i2;
                i = (this.f13584n + 1) % this.f13576f;
                now += (long) c;
                if (this.f13567C == -1 || this.f13567C > now) {
                    String str = this.f13581k;
                    Integer.valueOf(i);
                    Integer.valueOf(c);
                    unscheduleSelf(this.f13569E);
                    scheduleSelf(this.f13569E, now);
                    this.f13567C = now;
                }
            }
        }
    }

    public void draw(Canvas canvas) {
        int i = 0;
        this.f13573c.mo1272e();
        try {
            this.f13591u = false;
            if (this.f13593w && !this.f13594x) {
                this.f13572b.schedule(this.f13571G, 2000, TimeUnit.MILLISECONDS);
                this.f13594x = true;
            }
            if (this.f13565A) {
                this.f13579i.set(getBounds());
                if (!this.f13579i.isEmpty()) {
                    AnimatedDrawableCachingBackend b = this.f13582l.mo1261b(this.f13579i);
                    if (b != this.f13582l) {
                        this.f13582l.mo1256k();
                        this.f13582l = b;
                        this.f13573c.mo1267a(b);
                    }
                    this.f13595y = ((float) this.f13579i.width()) / ((float) this.f13582l.mo1252g());
                    this.f13596z = ((float) this.f13579i.height()) / ((float) this.f13582l.mo1253h());
                    this.f13565A = false;
                }
            }
            if (!this.f13579i.isEmpty()) {
                boolean a;
                String str;
                String str2;
                canvas.save();
                canvas.scale(this.f13595y, this.f13596z);
                if (this.f13586p != -1) {
                    a = m22837a(canvas, this.f13586p, this.f13587q);
                    i = a | 0;
                    if (a) {
                        str = this.f13581k;
                        Integer.valueOf(this.f13586p);
                        this.f13586p = -1;
                        this.f13587q = -1;
                    } else {
                        str = this.f13581k;
                        Integer.valueOf(this.f13586p);
                        m22840g();
                    }
                }
                if (this.f13586p == -1) {
                    if (this.f13593w) {
                        m22836a(false);
                    }
                    a = m22837a(canvas, this.f13584n, this.f13585o);
                    i |= a;
                    if (a) {
                        str = this.f13581k;
                        Integer.valueOf(this.f13584n);
                        if (this.f13593w) {
                            m22836a(true);
                        }
                    } else {
                        str = this.f13581k;
                        Integer.valueOf(this.f13584n);
                        this.f13586p = this.f13584n;
                        this.f13587q = this.f13585o;
                        m22840g();
                    }
                }
                if (i == 0 && this.f13590t != null) {
                    canvas.drawBitmap((Bitmap) this.f13590t.a(), 0.0f, 0.0f, this.f13578h);
                    str2 = this.f13581k;
                    Integer.valueOf(this.f13588r);
                    i = 1;
                }
                if (i == 0) {
                    CloseableReference l = this.f13582l.mo1263l();
                    if (l != null) {
                        canvas.drawBitmap((Bitmap) l.a(), 0.0f, 0.0f, this.f13578h);
                        l.close();
                        str2 = this.f13581k;
                        i = 1;
                    }
                }
                if (i == 0) {
                    canvas.drawRect(0.0f, 0.0f, (float) this.f13579i.width(), (float) this.f13579i.height(), this.f13580j);
                    str2 = this.f13581k;
                }
                canvas.restore();
                this.f13573c.mo1266a(canvas, this.f13579i);
                this.f13573c.mo1273f();
            }
        } finally {
            this.f13573c.mo1273f();
        }
    }

    private void m22840g() {
        if (!this.f13566B) {
            this.f13566B = true;
            scheduleSelf(this.f13570F, 5);
        }
    }

    private boolean m22837a(Canvas canvas, int i, int i2) {
        CloseableReference g = this.f13582l.mo1262g(i);
        if (g == null) {
            return false;
        }
        canvas.drawBitmap((Bitmap) g.a(), 0.0f, 0.0f, this.f13578h);
        if (this.f13590t != null) {
            this.f13590t.close();
        }
        if (this.f13593w && i2 > this.f13589s) {
            int i3 = (i2 - this.f13589s) - 1;
            this.f13573c.mo1269b(1);
            this.f13573c.mo1265a(i3);
            if (i3 > 0) {
                String str = this.f13581k;
                Integer.valueOf(i3);
            }
        }
        this.f13590t = g;
        this.f13588r = i;
        this.f13589s = i2;
        String str2 = this.f13581k;
        Integer.valueOf(i);
        return true;
    }

    public static void m22841i(AbstractAnimatedDrawable abstractAnimatedDrawable) {
        abstractAnimatedDrawable.f13591u = true;
        abstractAnimatedDrawable.f13592v = abstractAnimatedDrawable.f13574d.now();
        abstractAnimatedDrawable.invalidateSelf();
    }

    public void start() {
        if (this.f13575e != 0 && this.f13576f > 1) {
            this.f13593w = true;
            scheduleSelf(this.f13568D, this.f13574d.now());
        }
    }

    public void stop() {
        this.f13593w = false;
    }

    public boolean isRunning() {
        return this.f13593w;
    }

    protected boolean onLevelChange(int i) {
        if (this.f13593w) {
            return false;
        }
        int b = this.f13582l.mo1243b(i);
        if (b == this.f13584n) {
            return false;
        }
        try {
            this.f13584n = b;
            this.f13585o = b;
            m22841i(this);
            return true;
        } catch (IllegalStateException e) {
            return false;
        }
    }

    public final void aj_() {
        String str = this.f13581k;
        if (this.f13590t != null) {
            this.f13590t.close();
            this.f13590t = null;
            this.f13588r = -1;
            this.f13589s = -1;
        }
        this.f13582l.mo1256k();
    }
}

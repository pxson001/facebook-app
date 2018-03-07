package com.facebook.android.maps.model;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.facebook.android.maps.internal.GrandCentralDispatch.Dispatchable;
import com.facebook.android.maps.internal.SynchronizedPool;
import com.facebook.android.maps.internal.analytics.AnalyticsEvent;

/* compiled from: audio_play_mode */
public final class Tile {
    public static final Bitmap f8650a = Bitmap.createBitmap(1, 1, Config.ALPHA_8);
    private static final SynchronizedPool<Tile> f8651m = new SynchronizedPool(128);
    private static final SynchronizedPool<Bitmap> f8652n = new SynchronizedPool(32);
    private static final SynchronizedPool<Bitmap> f8653o = new SynchronizedPool(20);
    private static Options f8654p;
    private static boolean f8655q;
    public int f8656b = -1;
    public int f8657c = -1;
    public long f8658d = -1;
    public int f8659e = -1;
    public int f8660f = -1;
    public int f8661g = -1;
    public int f8662h = 0;
    public final Tile[] f8663i = new Tile[4];
    public Tile f8664j = null;
    public Tile f8665k = null;
    public volatile int f8666l = 0;
    public Bitmap f8667r;
    private Options f8668s;
    public final Dispatchable f8669t = new C09351(this);

    /* compiled from: audio_play_mode */
    class C09351 extends Dispatchable {
        final /* synthetic */ Tile f8649a;

        C09351(Tile tile) {
            this.f8649a = tile;
        }

        public void run() {
            Tile.m14612e(this.f8649a);
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 11) {
            z = false;
        }
        f8655q = z;
    }

    @TargetApi(11)
    private Tile(int i, int i2) {
        this.f8657c = i;
        this.f8656b = i2;
        if (f8655q) {
            this.f8668s = new Options();
            this.f8668s.inSampleSize = 1;
            this.f8668s.inPreferredConfig = Config.RGB_565;
            this.f8668s.inMutable = true;
            return;
        }
        if (f8654p == null) {
            Options options = new Options();
            f8654p = options;
            options.inPreferredConfig = Config.RGB_565;
        }
        this.f8668s = f8654p;
    }

    public final Tile m14614a(int i, int i2, int i3) {
        this.f8660f = i;
        this.f8661g = i2;
        this.f8659e = i3;
        return this;
    }

    public static Tile m14609a() {
        return m14610a(-1, -1);
    }

    public static Tile m14610a(int i, int i2) {
        Tile tile = (Tile) f8651m.m14516c();
        if (tile == null) {
            return new Tile(i, i2);
        }
        tile.f8657c = i;
        tile.f8656b = i2;
        return tile;
    }

    @TargetApi(11)
    public static Tile m14611a(byte[] bArr, int i) {
        Tile a = m14609a();
        if (f8655q && a.f8668s.inBitmap == null) {
            a.f8668s.inBitmap = (Bitmap) f8652n.m14516c();
        }
        try {
            a.f8667r = BitmapFactory.decodeByteArray(bArr, 0, i, a.f8668s);
            if (f8655q) {
                a.f8668s.inBitmap = null;
            }
        } catch (Throwable e) {
            AnalyticsEvent.l.a(e);
            f8655q = false;
            a.f8668s.inBitmap.recycle();
            a.f8668s.inBitmap = null;
            f8652n.m14517d();
            a.f8667r = BitmapFactory.decodeByteArray(bArr, 0, i, a.f8668s);
        }
        if (a.f8667r == null) {
            a.m14617c();
            return null;
        }
        a.f8657c = a.f8667r.getWidth();
        a.f8656b = a.f8667r.getHeight();
        return a;
    }

    public final Bitmap m14616b() {
        return this.f8667r;
    }

    public final void m14615a(Bitmap bitmap) {
        if (this.f8667r != bitmap) {
            m14613f();
        }
        this.f8667r = bitmap;
    }

    public final void m14617c() {
        this.f8657c = -1;
        this.f8656b = -1;
        for (int i = 0; i < 4; i++) {
            this.f8663i[i] = null;
        }
        m14613f();
        this.f8666l = 0;
        this.f8665k = null;
        this.f8664j = null;
        this.f8660f = -1;
        this.f8661g = -1;
        this.f8659e = -1;
        this.f8662h = 0;
        this.f8658d = -1;
        f8651m.m14515a(this);
    }

    public final String toString() {
        return getClass().getSimpleName() + " {x=" + this.f8660f + ", y=" + this.f8661g + ", zoom=" + this.f8659e + ", status=" + this.f8666l + "}" + (this.f8667r == null ? "x" : "o");
    }

    public static void m14612e(Tile tile) {
        tile.f8666l = 0;
        if (tile.f8665k == null && tile.f8664j == null) {
            tile.m14617c();
        }
    }

    @TargetApi(11)
    private void m14613f() {
        if (this.f8667r == null || this.f8667r == f8650a) {
            this.f8667r = null;
            return;
        }
        if (this.f8667r.getConfig() == Config.ARGB_8888) {
            f8653o.m14515a(this.f8667r);
        } else if (f8655q) {
            f8652n.m14515a(this.f8667r);
        } else {
            this.f8667r.recycle();
        }
        this.f8667r = null;
    }
}

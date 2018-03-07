package com.facebook.android.maps;

import android.graphics.Canvas;
import android.graphics.Canvas.EdgeType;
import android.os.Build.VERSION;
import android.os.Looper;
import android.os.SystemClock;
import com.facebook.android.maps.internal.FacadeTile;
import com.facebook.android.maps.internal.GrandCentralDispatch;
import com.facebook.android.maps.internal.GrandCentralDispatch.Dispatchable;
import com.facebook.android.maps.internal.RectD;
import com.facebook.android.maps.internal.TileTree;
import com.facebook.android.maps.model.Tile;
import com.facebook.android.maps.model.TileProvider;
import java.util.ArrayList;

/* compiled from: away_team_score */
public abstract class TiledMapDrawable extends MapDrawable {
    private static final String[] f8265x = new String[20];
    public static final ArrayList<TiledMapDrawable> f8266y = new ArrayList(5);
    private int f8267A;
    private int f8268B;
    private int f8269C;
    private int f8270D;
    private int f8271E;
    protected final TileTree f8272o;
    protected FacadeTile f8273p = new FacadeTile();
    protected double f8274q = 1.2d;
    public int f8275r;
    public int f8276s;
    protected int f8277t;
    protected boolean f8278u;
    protected int f8279v = -1;
    protected final int[] f8280w = new int[2];
    public final RectD f8281z = new RectD();

    protected abstract Tile mo1069b(int i, int i2, int i3);

    static {
        for (int i = 0; i <= 19; i++) {
            f8265x[i] = String.valueOf(i);
        }
    }

    public TiledMapDrawable(FacebookMap facebookMap, TileTree tileTree) {
        super(facebookMap);
        this.f8272o = tileTree;
    }

    public void mo1032a(Canvas canvas) {
        MapView g = this.f8080e.m14300g();
        this.f8275r = 0;
        this.f8276s = 0;
        if (g.f8211g != this.f8267A) {
            GrandCentralDispatch.a(f8265x[this.f8267A]);
        }
        this.f8267A = g.f8211g;
        if (m14399u()) {
            this.f8081f.a(this.f8281z);
            double d = g.f8217m;
            if (d < this.f8281z.c) {
                d += Math.ceil(g.f8219o);
            }
            double d2 = g.f8218n;
            canvas.save(1);
            canvas.rotate(g.f8214j, g.f8209e, g.f8210f);
            canvas.scale(g.f8212h, g.f8212h, g.f8209e, g.f8210f);
            int i = (int) (((double) g.f8223s) * this.f8281z.c);
            int i2 = (int) (((double) g.f8223s) * this.f8281z.a);
            int i3 = (int) (((double) g.f8223s) * this.f8281z.d);
            int i4 = (int) (((double) g.f8223s) * this.f8281z.b);
            if (!(this.f8268B == i && this.f8269C == i2 && this.f8270D == i3 && this.f8271E == i4)) {
                GrandCentralDispatch.a(f8265x[g.f8211g]);
            }
            this.f8268B = i;
            this.f8269C = i2;
            this.f8270D = i3;
            this.f8271E = i4;
            int i5 = g.f8223s - 1;
            int i6 = 0;
            int i7 = -1;
            int i8 = (i3 - i) + 1;
            int i9 = (i4 - i2) + 1;
            int i10 = i8 > i9 ? i8 : i9;
            int i11 = i10 * i10;
            int i12 = i + ((i8 - 1) >> 1);
            int i13 = i2 + ((i9 - 1) >> 1);
            float f = (float) (((((((double) i12) * 1.0d) / ((double) g.f8223s)) - d) * ((double) g.f8222r)) + ((double) g.f8209e));
            float f2 = (float) ((((double) g.f8222r) * (((((double) i13) * 1.0d) / ((double) g.f8223s)) - d2)) + ((double) g.f8210f));
            Object obj = null;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            while (i14 < i11) {
                Object obj2;
                Object obj3;
                int i17;
                int i18;
                int i19 = i16 + i12;
                int i20 = i15 + i13;
                float f3 = f + ((float) (this.f8083h * i16));
                float f4 = f2 + ((float) (this.f8083h * i15));
                if (i20 >= i2 && i20 <= i4) {
                    if (!canvas.quickReject(f3, f4, f3 + ((float) this.f8083h), f4 + ((float) this.f8083h), EdgeType.BW)) {
                        obj2 = null;
                        if (obj2 == null) {
                            i8 = i19 & i5;
                            this.f8272o.m14524a(i8, i20, g.f8211g, this.f8273p);
                            obj2 = this.f8273p.f8389a == null ? 1 : null;
                            if (obj2 != null && this.f8273p.f8396h != 1) {
                                m14400a(i8, i20, g.f8211g, 2);
                            } else if (this.f8273p.f8396h == 1 && !f8266y.contains(this)) {
                                f8266y.add(this);
                            }
                            this.f8273p.mo1068a(canvas, f3, f4);
                            this.f8275r++;
                            if (obj2 == null) {
                                this.f8276s++;
                                obj3 = obj;
                            } else if (this.f8273p.f8389a.f8658d != -1) {
                                i9 = 1;
                            }
                            if (i16 != i15 || ((i16 < 0 && (-i16) == i15) || (i16 > 0 && i16 == 1 - i15))) {
                                i8 = -i7;
                                i10 = i6;
                            } else {
                                i10 = i7;
                                i8 = i6;
                            }
                            i17 = i19 + i8;
                            i18 = i20 + i10;
                            if (i2 <= i18 || i18 > i4 || i > i17 || i17 > i3) {
                                i18 = ((i10 >> 1) & 1) + ((((i8 & 1) << 1) - 1) * i16);
                                i17 = ((((i10 & 1) << 1) - 1) * i15) + (((-i8) >> 1) & 1);
                                i8 = -i8;
                                i10 = -i10;
                            } else {
                                i18 = i16 + i8;
                                i17 = i15 + i10;
                            }
                            i14++;
                            i15 = i17;
                            i16 = i18;
                            obj = obj3;
                            i7 = i10;
                            i6 = i8;
                        }
                        obj3 = obj;
                        if (i16 != i15) {
                        }
                        i8 = -i7;
                        i10 = i6;
                        i17 = i19 + i8;
                        i18 = i20 + i10;
                        if (i2 <= i18) {
                        }
                        i18 = ((i10 >> 1) & 1) + ((((i8 & 1) << 1) - 1) * i16);
                        i17 = ((((i10 & 1) << 1) - 1) * i15) + (((-i8) >> 1) & 1);
                        i8 = -i8;
                        i10 = -i10;
                        i14++;
                        i15 = i17;
                        i16 = i18;
                        obj = obj3;
                        i7 = i10;
                        i6 = i8;
                    }
                }
                obj2 = 1;
                if (obj2 == null) {
                    i8 = i19 & i5;
                    this.f8272o.m14524a(i8, i20, g.f8211g, this.f8273p);
                    if (this.f8273p.f8389a == null) {
                    }
                    if (obj2 != null) {
                    }
                    f8266y.add(this);
                    this.f8273p.mo1068a(canvas, f3, f4);
                    this.f8275r++;
                    if (obj2 == null) {
                        this.f8276s++;
                        obj3 = obj;
                    } else if (this.f8273p.f8389a.f8658d != -1) {
                        i9 = 1;
                    }
                    if (i16 != i15) {
                    }
                    i8 = -i7;
                    i10 = i6;
                    i17 = i19 + i8;
                    i18 = i20 + i10;
                    if (i2 <= i18) {
                    }
                    i18 = ((i10 >> 1) & 1) + ((((i8 & 1) << 1) - 1) * i16);
                    i17 = ((((i10 & 1) << 1) - 1) * i15) + (((-i8) >> 1) & 1);
                    i8 = -i8;
                    i10 = -i10;
                    i14++;
                    i15 = i17;
                    i16 = i18;
                    obj = obj3;
                    i7 = i10;
                    i6 = i8;
                }
                obj3 = obj;
                if (i16 != i15) {
                }
                i8 = -i7;
                i10 = i6;
                i17 = i19 + i8;
                i18 = i20 + i10;
                if (i2 <= i18) {
                }
                i18 = ((i10 >> 1) & 1) + ((((i8 & 1) << 1) - 1) * i16);
                i17 = ((((i10 & 1) << 1) - 1) * i15) + (((-i8) >> 1) & 1);
                i8 = -i8;
                i10 = -i10;
                i14++;
                i15 = i17;
                i16 = i18;
                obj = obj3;
                i7 = i10;
                i6 = i8;
            }
            if (this.f8275r > this.f8277t) {
                this.f8277t = this.f8275r;
                mo1070a(this.f8280w);
                this.f8272o.m14523a(this.f8280w[0]).m14526b(this.f8280w[1]);
            }
            canvas.restore();
            if (obj != null) {
                m14398t();
            }
        }
    }

    protected final void m14400a(int i, int i2, int i3, int i4) {
        final Tile a = Tile.m14610a(this.f8083h, this.f8083h);
        a.m14614a(i, i2, i3);
        a.f8666l = 1;
        this.f8272o.m14525a(a);
        final int i5 = i;
        final int i6 = i2;
        final int i7 = i3;
        final int i8 = i4;
        C09201 c09201 = new Dispatchable(this) {
            final /* synthetic */ TiledMapDrawable f8264f;

            public void run() {
                boolean z;
                Tile b = this.f8264f.mo1069b(i5, i6, i7);
                if (b != TileProvider.f8307a) {
                    z = false;
                } else {
                    b = Tile.m14610a(b.f8657c, b.f8656b);
                    b.m14615a(Tile.f8650a);
                    z = true;
                }
                if (b != null) {
                    b.m14614a(i5, i6, i7);
                }
                GrandCentralDispatch.c(new Dispatchable(this) {
                    final /* synthetic */ C09201 f8258c;

                    public void run() {
                        int i = this.f8258c.f8264f.f8080e.f8112A.f8211g;
                        int size;
                        int i2;
                        if (b != null) {
                            this.f8258c.f8264f.f8272o.m14525a(b);
                            if (!z && i7 <= i + 1) {
                                if (this.f8258c.f8264f.f8278u) {
                                    b.f8658d = SystemClock.uptimeMillis();
                                }
                                this.f8258c.f8264f.m14231f();
                                if (!TiledMapDrawable.f8266y.isEmpty()) {
                                    size = TiledMapDrawable.f8266y.size();
                                    for (i2 = 0; i2 < size; i2++) {
                                        ((TiledMapDrawable) TiledMapDrawable.f8266y.get(i2)).m14231f();
                                    }
                                    TiledMapDrawable.f8266y.clear();
                                }
                            }
                        } else if (i8 > 0) {
                            if (i7 != this.f8258c.f8264f.f8279v) {
                                if (i7 == i) {
                                    MapDrawable mapDrawable = this.f8258c.f8264f;
                                    i2 = i5;
                                    size = i6;
                                    int i3 = 1;
                                    int i4 = 1 << i7;
                                    mapDrawable.f8081f.a(mapDrawable.f8281z);
                                    if (mapDrawable.f8281z.c * ((double) i4) > ((double) i2) || ((double) i2) > mapDrawable.f8281z.d * ((double) i4) || mapDrawable.f8281z.a * ((double) i4) > ((double) size) || ((double) size) > mapDrawable.f8281z.b * ((double) i4)) {
                                        i3 = 0;
                                    }
                                    if (i3 == 0) {
                                        return;
                                    }
                                }
                                return;
                            }
                            this.f8258c.f8264f.m14400a(i5, i6, i7, i8 - 1);
                        }
                    }
                });
            }

            public final void m14396a() {
                Tile tile = a;
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    Tile.m14612e(tile);
                } else {
                    GrandCentralDispatch.c(tile.f8669t);
                }
            }
        };
        String str = f8265x[i3];
        int i9 = GrandCentralDispatch.d;
        GrandCentralDispatch.d = i9 - 1;
        c09201.a = ((long) i9) << 32;
        c09201.c = str;
        c09201.b = 0;
        GrandCentralDispatch.b.add(c09201);
    }

    protected void mo1036b() {
        super.mo1036b();
        m14397s();
    }

    public void mo1065l() {
        super.mo1065l();
        mo1072p();
    }

    public void mo1064a(boolean z) {
        super.mo1064a(z);
        m14397s();
    }

    public final void m14406b(boolean z) {
        if (z && this.f8272o.f8487d == -1) {
            this.f8272o.f8487d = mo1071c();
            m14397s();
        } else if (!z && this.f8272o.f8487d != -1) {
            this.f8272o.f8487d = -1;
        }
    }

    protected int mo1071c() {
        return -1;
    }

    private void m14397s() {
        if (this.f8279v != -1 && this.f8084i) {
            this.f8272o.f8487d = this.f8279v;
            int i = 1 << this.f8279v;
            for (int i2 = 0; i2 < i; i2++) {
                for (int i3 = 0; i3 < i; i3++) {
                    this.f8272o.m14524a(i2, i3, this.f8279v, this.f8273p);
                    if (this.f8273p.f8389a == null && this.f8273p.f8396h != 1) {
                        m14400a(i2, i3, this.f8279v, 2);
                    }
                }
            }
        }
    }

    private void m14398t() {
        if (VERSION.SDK_INT >= 16) {
            this.f8080e.f8112A.postInvalidateOnAnimation();
        } else {
            this.f8080e.f8112A.postInvalidateDelayed(10);
        }
    }

    protected void mo1070a(int[] iArr) {
        int i = ((int) (((double) this.f8277t) * this.f8274q)) + 1;
        int i2 = (i - this.f8277t) - 1;
        iArr[0] = i;
        iArr[1] = Math.max(i2, 1);
    }

    public void mo1072p() {
        this.f8272o.m14528c();
    }

    public void mo1073q() {
        mo1072p();
        this.f8279v = -1;
        this.f8272o.f8487d = -1;
    }

    private static boolean m14399u() {
        return true;
    }
}

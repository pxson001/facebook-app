package com.facebook.android.maps.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.facebook.android.maps.FacebookMap;
import com.facebook.android.maps.MapDrawable;
import com.facebook.android.maps.MapView;
import com.facebook.android.maps.internal.analytics.AnalyticsEvent;
import com.facebook.android.maps.model.Tile;
import com.facebook.android.maps.model.TileOverlay;
import com.facebook.android.maps.model.TileOverlayOptions;
import com.facebook.android.maps.model.TileProvider;
import java.util.ArrayList;

/* compiled from: average_age */
public class MapTileOverlay extends TileOverlay {
    private static TileTree f8438x;
    private static final ArrayList<MapTileOverlay> f8439y = new ArrayList(5);
    public static Bitmap f8440z;
    public final MapTileProvider f8441A;
    public final CopyrightLogoDrawable f8442B;
    private boolean f8443C;
    public int f8444D;

    /* compiled from: average_age */
    class C09301 extends FacadeTile {
        final /* synthetic */ MapTileOverlay f8436i;

        C09301(MapTileOverlay mapTileOverlay) {
            this.f8436i = mapTileOverlay;
        }

        public final void mo1068a(Canvas canvas, float f, float f2) {
            int i = 0;
            super.mo1068a(canvas, f, f2);
            if (this.f8389a == null) {
                canvas.drawBitmap(MapTileOverlay.f8440z, f, f2, this.f8392d);
            }
            if (this.f8389a != null) {
                if (this.f8389a.f8662h == 0) {
                    this.f8389a.f8662h = MapConfig.a(this.f8389a, this.f8436i.f8444D);
                }
                i = this.f8389a.f8662h;
            } else {
                int i2;
                if (this.f8391c != null) {
                    i2 = 0;
                    for (int i3 = 0; i3 < 4; i3++) {
                        Bitmap bitmap;
                        if (this.f8391c[i3] != null) {
                            bitmap = this.f8391c[i3].f8667r;
                        } else {
                            bitmap = null;
                        }
                        if (!(bitmap == null || bitmap == Tile.f8650a)) {
                            i2 |= this.f8391c[i3].f8662h;
                            i++;
                        }
                    }
                    int i4 = i;
                    i = i2;
                    i2 = i4;
                } else {
                    i2 = 0;
                }
                if (i2 != 4) {
                    Bitmap bitmap2;
                    if (this.f8390b != null) {
                        bitmap2 = this.f8390b.f8667r;
                    } else {
                        bitmap2 = null;
                    }
                    if (!(bitmap2 == null || bitmap2 == Tile.f8650a)) {
                        i |= this.f8390b.f8662h;
                    }
                }
            }
            CopyrightLogoDrawable copyrightLogoDrawable = this.f8436i.f8442B;
            copyrightLogoDrawable.f8334o = i | copyrightLogoDrawable.f8334o;
        }
    }

    private static TileTree m14489u() {
        if (f8438x == null) {
            f8438x = new TileTree();
        }
        return f8438x;
    }

    public MapTileOverlay(FacebookMap facebookMap, MapTileProvider mapTileProvider) {
        super(facebookMap, new TileOverlayOptions().m14618a((TileProvider) mapTileProvider).m14619a(false), m14489u());
        this.f8444D = 1;
        this.j = 0;
        this.q = 2.0d;
        this.f8441A = mapTileProvider;
        this.f8442B = new CopyrightLogoDrawable(facebookMap);
        this.f8080e.m14277a(this.f8442B);
        this.p = new C09301(this);
        if (f8440z == null) {
            int d = this.f8080e.m14296d();
            int i = this.f8080e.m14299f().getResources().getDisplayMetrics().densityDpi;
            f8440z = Bitmap.createBitmap(d, d, Config.ALPHA_8);
            Canvas canvas = new Canvas(f8440z);
            int i2 = i >= 320 ? 32 : 16;
            Paint paint = new Paint();
            paint.setColor(-7235677);
            float f = 0.0f;
            while (f <= ((float) d)) {
                int i3 = (f == 0.0f || f == ((float) d)) ? 44 : 18;
                paint.setAlpha(i3);
                canvas.drawLine(f, 0.0f, f, (float) d, paint);
                canvas.drawLine(f - 1.0f, 0.0f, f - 1.0f, (float) d, paint);
                canvas.drawLine(0.0f, f, (float) d, f, paint);
                canvas.drawLine(0.0f, f - 1.0f, (float) d, f - 1.0f, paint);
                f += (float) i2;
            }
        }
    }

    protected final void mo1036b() {
        boolean z;
        boolean z2 = true;
        super.mo1036b();
        MapView mapView = this.f8080e.f8112A;
        float f = 250.0f * this.f8079d;
        if (((float) mapView.getWidth()) < f || ((float) mapView.getHeight()) < f) {
            z = false;
        } else {
            z = true;
        }
        this.f8443C = z;
        MapDrawable mapDrawable = this.f8442B;
        if (!(this.f8443C && this.f8084i)) {
            z2 = false;
        }
        mapDrawable.mo1064a(z2);
    }

    public final void mo1032a(Canvas canvas) {
        long a = AnalyticsEvent.a();
        this.f8442B.f8334o = 0;
        super.mo1032a(canvas);
        AnalyticsEvent.j.a(AnalyticsEvent.a() - a);
    }

    public final void mo1072p() {
        this.f8441A.mo1075a();
        this.t = 0;
        f8439y.remove(this);
        if (f8439y.isEmpty()) {
            m14406b(false);
        }
        m14488b(this.f8280w);
        TileTree tileTree = this.f8272o;
        tileTree.f8488e = this.f8280w[0];
        tileTree = tileTree;
        tileTree.f8489f = this.f8280w[1];
        tileTree.m14527b();
    }

    protected final Tile mo1069b(int i, int i2, int i3) {
        Tile b = super.mo1069b(i, i2, i3);
        if (b != null) {
            b.m14614a(i, i2, i3);
            b.f8662h = MapConfig.a(b, this.f8444D);
        }
        return b;
    }

    public final void mo1064a(boolean z) {
        super.mo1064a(z);
        MapDrawable mapDrawable = this.f8442B;
        boolean z2 = this.f8443C && z;
        mapDrawable.mo1064a(z2);
    }

    public final void mo1073q() {
        this.q = 1.2d;
    }

    public final void mo1065l() {
        super.mo1065l();
        this.f8442B.mo1065l();
    }

    public final void m14491a(String str) {
        this.f8441A.m14439a(str);
    }

    protected final int mo1071c() {
        return 1;
    }

    protected final void mo1070a(int[] iArr) {
        if (!f8439y.contains(this)) {
            f8439y.add(this);
        }
        m14488b(iArr);
    }

    private static void m14488b(int[] iArr) {
        int size = f8439y.size();
        if (size == 0) {
            iArr[0] = 0;
            iArr[1] = 0;
            return;
        }
        int i;
        double max = Math.max(1.6d - (((double) size) * 0.1d), 1.1d);
        int i2 = 0;
        for (i = 0; i < size; i++) {
            i2 += ((MapTileOverlay) f8439y.get(i)).f8277t;
        }
        int i3 = ((int) (((double) i2) * max)) + 1;
        i = (i3 - i2) - 1;
        iArr[0] = i3;
        iArr[1] = Math.max(i, 1);
    }
}

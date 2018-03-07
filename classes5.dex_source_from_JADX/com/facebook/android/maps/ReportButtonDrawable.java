package com.facebook.android.maps;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.support.v7.widget.LinearLayoutCompat;
import com.facebook.android.maps.StaticMapView.StaticMapOptions;
import com.facebook.android.maps.internal.MapConfig;
import com.facebook.android.maps.model.CameraPosition;

/* compiled from: aymt_channel */
public class ReportButtonDrawable extends MapDrawable {
    private float f8231o;
    private float f8232p;
    private float f8233q;
    private final float f8234r;
    private final Paint f8235s;
    private final Rect f8236t;
    private final RectF f8237u;
    private final RectF f8238v;
    private final String f8239w;
    private final int f8240x;
    public MapReporterLauncher f8241y;

    public ReportButtonDrawable(Context context, FacebookMap facebookMap, int i) {
        this(facebookMap, i, new MapReporterLauncher(context), "Report");
    }

    public ReportButtonDrawable(FacebookMap facebookMap, int i, MapReporterLauncher mapReporterLauncher, String str) {
        super(facebookMap);
        this.f8235s = new Paint(1);
        this.f8236t = new Rect();
        this.f8237u = new RectF();
        this.f8238v = new RectF();
        this.f8241y = mapReporterLauncher;
        this.f8234r = (48.0f * this.f8079d) / 2.0f;
        this.f8231o = (float) ((int) (8.0f * this.f8079d));
        this.j = 3;
        this.k = 4.0f;
        this.f8235s.setUnderlineText(true);
        this.f8235s.setTypeface(Typeface.DEFAULT_BOLD);
        this.f8235s.setShadowLayer(1.5f * this.f8079d, 0.0f, 0.0f, -1056964609);
        this.f8235s.setTextSize(10.0f * this.f8079d);
        this.f8235s.setColor(-1711276032);
        this.f8239w = str;
        this.f8240x = i;
        this.l = false;
    }

    public final int mo1031a(float f, float f2) {
        if (this.f8237u.contains(f, f2)) {
            return 2;
        }
        if (this.f8238v.contains(f, f2)) {
            return 1;
        }
        return 0;
    }

    public final boolean mo1038b(float f, float f2) {
        CameraPosition c = this.f8080e.m14292c();
        this.f8241y.a(this.f8082g, StaticMapView.a(this.f8080e.f8112A.getWidth(), this.f8080e.f8112A.getHeight(), 2, this.f8080e.f8152z.getResources(), MapConfig.a, new StaticMapOptions("dynamic_map_report_button").a(c.f8546a).a((int) c.f8547b)));
        return true;
    }

    protected final void mo1036b() {
        MapView mapView = this.f8080e.f8112A;
        this.f8235s.getTextBounds(this.f8239w, 0, this.f8239w.length(), this.f8236t);
        switch (this.f8240x) {
            case 1:
                this.f8232p = this.f8231o + ((float) this.f8080e.f8129c);
                this.f8233q = (((float) (mapView.getHeight() - this.f8236t.height())) - this.f8231o) - ((float) this.f8080e.f8132f);
                break;
            case LinearLayoutCompat.SHOW_DIVIDER_MIDDLE /*2*/:
                this.f8232p = (((float) (mapView.getWidth() - this.f8236t.width())) - this.f8231o) - ((float) this.f8080e.f8131e);
                this.f8233q = this.f8231o + ((float) this.f8080e.f8130d);
                break;
            case 3:
                this.f8232p = this.f8231o + ((float) this.f8080e.f8129c);
                this.f8233q = this.f8231o + ((float) this.f8080e.f8130d);
                break;
            default:
                this.f8232p = (((float) (mapView.getWidth() - this.f8236t.width())) - this.f8231o) - ((float) this.f8080e.f8131e);
                this.f8233q = (((float) (mapView.getHeight() - this.f8236t.height())) - this.f8231o) - ((float) this.f8080e.f8132f);
                break;
        }
        this.f8237u.set(this.f8236t);
        this.f8237u.offsetTo(this.f8232p, this.f8233q);
        float centerX = this.f8237u.centerX();
        float centerY = this.f8237u.centerY();
        this.f8238v.set(centerX - this.f8234r, centerY - this.f8234r, centerX + this.f8234r, centerY + this.f8234r);
    }

    public final void mo1032a(Canvas canvas) {
        canvas.drawText(this.f8239w, this.f8232p, (this.f8233q + this.f8237u.bottom) - this.f8237u.top, this.f8235s);
    }
}

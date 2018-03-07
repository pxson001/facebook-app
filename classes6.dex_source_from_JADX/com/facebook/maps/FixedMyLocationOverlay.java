package com.facebook.maps;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.location.Location;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Projection;

/* compiled from: xy_tag_count */
public class FixedMyLocationOverlay extends MyLocationOverlay {
    private boolean f168a = false;
    private Paint f169b;
    private Point f170c;
    private Point f171d;
    private Drawable f172e;
    private int f173f;
    private int f174g;

    public FixedMyLocationOverlay(Context context, MapView mapView) {
        super(context, mapView);
    }

    protected void drawMyLocation(Canvas canvas, MapView mapView, Location location, GeoPoint geoPoint, long j) {
        if (!this.f168a) {
            try {
                super.drawMyLocation(canvas, mapView, location, geoPoint, j);
            } catch (Exception e) {
                this.f168a = true;
            }
        }
        if (this.f168a) {
            if (this.f172e == null) {
                this.f169b = new Paint();
                this.f169b.setAntiAlias(true);
                this.f169b.setStrokeWidth(2.0f);
                this.f172e = mapView.getContext().getResources().getDrawable(2130842125);
                this.f173f = this.f172e.getIntrinsicWidth();
                this.f174g = this.f172e.getIntrinsicHeight();
                this.f170c = new Point();
                this.f171d = new Point();
            }
            Projection projection = mapView.getProjection();
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            float accuracy = location.getAccuracy();
            float[] fArr = new float[1];
            Location.distanceBetween(latitude, longitude, latitude, longitude + 1.0d, fArr);
            projection.toPixels(new GeoPoint((int) (latitude * 1000000.0d), (int) ((longitude - ((double) (accuracy / fArr[0]))) * 1000000.0d)), this.f171d);
            projection.toPixels(geoPoint, this.f170c);
            int i = this.f170c.x - this.f171d.x;
            this.f169b.setColor(-10066177);
            this.f169b.setStyle(Style.STROKE);
            canvas.drawCircle((float) this.f170c.x, (float) this.f170c.y, (float) i, this.f169b);
            this.f169b.setColor(409364223);
            this.f169b.setStyle(Style.FILL);
            canvas.drawCircle((float) this.f170c.x, (float) this.f170c.y, (float) i, this.f169b);
            this.f172e.setBounds(this.f170c.x - (this.f173f / 2), this.f170c.y - (this.f174g / 2), this.f170c.x + (this.f173f / 2), this.f170c.y + (this.f174g / 2));
            this.f172e.draw(canvas);
        }
    }
}

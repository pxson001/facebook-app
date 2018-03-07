package com.facebook.android.maps;

import android.graphics.Canvas;
import com.facebook.android.maps.internal.RectD;

/* compiled from: away_team_object */
public abstract class WrappedMapDrawable extends MapDrawable {
    protected abstract void mo1082b(Canvas canvas);

    protected abstract RectD mo1083c();

    protected abstract boolean mo1084p();

    public WrappedMapDrawable(FacebookMap facebookMap) {
        super(facebookMap);
    }

    public final void mo1032a(Canvas canvas) {
        if (m14223a(mo1083c(), this.f8078c)) {
            float f = this.f8078c[0];
            float f2 = this.f8078c[1];
            if (mo1084p()) {
                MapView mapView = this.f8080e.f8112A;
                canvas.save(1);
                float f3 = f2 - f;
                for (int i = 0; ((float) i) <= f3; i++) {
                    if (i == 0) {
                        this.f8078c[0] = ((float) mapView.f8222r) * f;
                        this.f8078c[1] = 0.0f;
                        mapView.f8215k.mapVectors(this.f8078c);
                    } else if (i == 1) {
                        this.f8078c[0] = (float) mapView.f8222r;
                        this.f8078c[1] = 0.0f;
                        mapView.f8215k.mapVectors(this.f8078c);
                    }
                    canvas.translate(this.f8078c[0], this.f8078c[1]);
                    mo1082b(canvas);
                }
                canvas.restore();
            }
        }
    }
}

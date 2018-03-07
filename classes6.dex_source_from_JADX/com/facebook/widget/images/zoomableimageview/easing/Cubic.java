package com.facebook.widget.images.zoomableimageview.easing;

/* compiled from: remove_photo */
public class Cubic {
    public final double m8560a(double d, double d2, double d3, double d4) {
        double d5 = (d / d4) - 1.0d;
        return (((d5 * (d5 * d5)) + 1.0d) * d3) + d2;
    }

    public final double m8561b(double d, double d2, double d3, double d4) {
        double d5 = d / (d4 / 2.0d);
        if (d5 < 1.0d) {
            return (d5 * (((d3 / 2.0d) * d5) * d5)) + d2;
        }
        d5 -= 2.0d;
        return (((d5 * (d5 * d5)) + 2.0d) * (d3 / 2.0d)) + d2;
    }
}

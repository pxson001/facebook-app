package android.support.v4.widget;

import android.graphics.Canvas;
import android.widget.EdgeEffect;

/* compiled from: product_view */
class EdgeEffectCompatIcs {
    EdgeEffectCompatIcs() {
    }

    public static void m13829a(Object obj, int i, int i2) {
        ((EdgeEffect) obj).setSize(i, i2);
    }

    public static boolean m13830a(Object obj) {
        return ((EdgeEffect) obj).isFinished();
    }

    public static void m13834b(Object obj) {
        ((EdgeEffect) obj).finish();
    }

    public static boolean m13831a(Object obj, float f) {
        ((EdgeEffect) obj).onPull(f);
        return true;
    }

    public static boolean m13835c(Object obj) {
        EdgeEffect edgeEffect = (EdgeEffect) obj;
        edgeEffect.onRelease();
        return edgeEffect.isFinished();
    }

    public static boolean m13832a(Object obj, int i) {
        ((EdgeEffect) obj).onAbsorb(i);
        return true;
    }

    public static boolean m13833a(Object obj, Canvas canvas) {
        return ((EdgeEffect) obj).draw(canvas);
    }
}

package com.facebook.rtc.opengl;

import java.nio.FloatBuffer;

/* compiled from: application/vnd.wap.connectivity-wbxml */
public class Drawable2d {
    private static final float[] f19848a = new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};
    private static final float[] f19849b = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
    public static final FloatBuffer f19850c = GlUtil.m19598a(f19848a);
    private static final FloatBuffer f19851d = GlUtil.m19598a(f19849b);

    public static FloatBuffer m19572b() {
        return f19851d;
    }

    public static int m19573c() {
        return f19848a.length / 2;
    }

    public static int m19574d() {
        return 8;
    }

    public static int m19575e() {
        return 8;
    }

    public static int m19576f() {
        return 2;
    }
}

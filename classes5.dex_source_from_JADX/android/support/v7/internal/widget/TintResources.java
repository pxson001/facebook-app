package android.support.v7.internal.widget;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;

/* compiled from: unable to initialize EGL14 */
class TintResources extends ResourcesWrapper {
    private final TintManager f1227a;

    public TintResources(Resources resources, TintManager tintManager) {
        super(resources);
        this.f1227a = tintManager;
    }

    public Drawable getDrawable(int i) {
        Drawable drawable = super.getDrawable(i);
        if (drawable != null) {
            this.f1227a.m1691a(i, drawable);
        }
        return drawable;
    }
}

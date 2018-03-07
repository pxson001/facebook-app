package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

/* compiled from: qe_group */
public class DrawableCompat {
    public static final DrawableImpl f3953a;

    /* compiled from: qe_group */
    class KitKatDrawableImpl extends HoneycombDrawableImpl {
        public final void mo295a(Drawable drawable, boolean z) {
            drawable.setAutoMirrored(z);
        }

        public final boolean mo296b(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        KitKatDrawableImpl() {
        }

        public Drawable mo297c(Drawable drawable) {
            return DrawableCompatKitKat.b(drawable);
        }
    }

    /* compiled from: qe_group */
    class HoneycombDrawableImpl extends BaseDrawableImpl {
        public final void mo298a(Drawable drawable) {
            drawable.jumpToCurrentState();
        }

        HoneycombDrawableImpl() {
        }

        public Drawable mo297c(Drawable drawable) {
            return DrawableCompatHoneycomb.m4446b(drawable);
        }
    }

    /* compiled from: qe_group */
    class BaseDrawableImpl implements DrawableImpl {
        BaseDrawableImpl() {
        }

        public void mo298a(Drawable drawable) {
        }

        public void mo295a(Drawable drawable, boolean z) {
        }

        public boolean mo296b(Drawable drawable) {
            return false;
        }

        public void mo299a(Drawable drawable, float f, float f2) {
        }

        public void mo301a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void mo300a(Drawable drawable, int i) {
            DrawableCompatBase.a(drawable, i);
        }

        public void mo302a(Drawable drawable, ColorStateList colorStateList) {
            DrawableCompatBase.a(drawable, colorStateList);
        }

        public void mo303a(Drawable drawable, Mode mode) {
            DrawableCompatBase.a(drawable, mode);
        }

        public Drawable mo297c(Drawable drawable) {
            return DrawableCompatBase.a(drawable);
        }
    }

    /* compiled from: qe_group */
    public interface DrawableImpl {
        void mo298a(Drawable drawable);

        void mo299a(Drawable drawable, float f, float f2);

        void mo300a(Drawable drawable, int i);

        void mo301a(Drawable drawable, int i, int i2, int i3, int i4);

        void mo302a(Drawable drawable, ColorStateList colorStateList);

        void mo303a(Drawable drawable, Mode mode);

        void mo295a(Drawable drawable, boolean z);

        boolean mo296b(Drawable drawable);

        Drawable mo297c(Drawable drawable);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f3953a = new LollipopDrawableImpl();
        } else if (i >= 19) {
            f3953a = new KitKatDrawableImpl();
        } else if (i >= 11) {
            f3953a = new HoneycombDrawableImpl();
        } else {
            f3953a = new BaseDrawableImpl();
        }
    }

    public static void m4415a(Drawable drawable) {
        f3953a.mo298a(drawable);
    }

    public static void m4421a(Drawable drawable, boolean z) {
        f3953a.mo295a(drawable, z);
    }

    public static void m4416a(Drawable drawable, float f, float f2) {
        f3953a.mo299a(drawable, f, f2);
    }

    public static void m4418a(Drawable drawable, int i, int i2, int i3, int i4) {
        f3953a.mo301a(drawable, i, i2, i3, i4);
    }

    public static void m4417a(Drawable drawable, int i) {
        f3953a.mo300a(drawable, i);
    }

    public static void m4419a(Drawable drawable, ColorStateList colorStateList) {
        f3953a.mo302a(drawable, colorStateList);
    }

    public static void m4420a(Drawable drawable, Mode mode) {
        f3953a.mo303a(drawable, mode);
    }

    public static Drawable m4422c(Drawable drawable) {
        return f3953a.mo297c(drawable);
    }
}

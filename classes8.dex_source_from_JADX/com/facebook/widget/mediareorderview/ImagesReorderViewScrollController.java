package com.facebook.widget.mediareorderview;

import android.widget.ScrollView;
import com.facebook.springs.QcValueConverter;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.springs.SpringUtil;

/* compiled from: location_opt_in_google_play_location_status_check_dialog_already_attempted */
public class ImagesReorderViewScrollController {
    private static final double f9883a = QcValueConverter.b(30.0d);
    private static final double f9884b = QcValueConverter.b(220.0d);
    private static final double f9885c = QcValueConverter.b(30.0d);
    private static final SpringConfig f9886d = SpringConfig.a(10.0d, f9884b);
    public final ScrollView f9887e;
    private final Spring f9888f;
    private final SpringConfig f9889g;
    public ImagesReorderViewDimensions f9890h;
    public boolean f9891i;

    /* compiled from: location_opt_in_google_play_location_status_check_dialog_already_attempted */
    class ScrollSpringListener extends SimpleSpringListener {
        final /* synthetic */ ImagesReorderViewScrollController f9882a;

        public ScrollSpringListener(ImagesReorderViewScrollController imagesReorderViewScrollController) {
            this.f9882a = imagesReorderViewScrollController;
        }

        public final void m11593a(Spring spring) {
            if (this.f9882a.f9891i) {
                int d = ImagesReorderViewScrollController.m11599d(this.f9882a);
                int i = this.f9882a.f9890h.f9880h;
                if (d == 0 || d == i) {
                    this.f9882a.m11601a();
                }
                this.f9882a.f9887e.scrollTo(0, d);
            }
        }
    }

    public ImagesReorderViewScrollController(ScrollView scrollView, SpringSystem springSystem) {
        this.f9887e = scrollView;
        Spring a = springSystem.a().a(f9886d);
        a.c = true;
        this.f9888f = a.a(new ScrollSpringListener(this));
        this.f9889g = this.f9888f.b;
    }

    public final void m11603a(ImagesReorderViewDimensions imagesReorderViewDimensions) {
        m11601a();
        this.f9890h = imagesReorderViewDimensions;
        this.f9889g.a = f9884b;
        this.f9888f.a((double) this.f9890h.f9881i);
    }

    public final void m11602a(int i) {
        float a = m11594a((float) i);
        if (a == 0.0f) {
            m11601a();
            return;
        }
        int d = m11599d(this);
        int i2 = this.f9890h.f9880h;
        if (d == 0 && a < 0.0f) {
            return;
        }
        if (d != i2 || a <= 0.0f) {
            int i3 = this.f9890h.f9874b;
            int i4 = this.f9890h.f9879g;
            if (!this.f9891i) {
                this.f9888f.a((double) this.f9887e.getScrollY());
                m11598c();
            }
            this.f9889g.a = SpringUtil.a((double) Math.abs(a), 0.0d, 1.0d, f9884b, f9883a);
            this.f9888f.b(a < 0.0f ? (double) (-i3) : (double) i4);
        }
    }

    private void m11598c() {
        this.f9891i = true;
    }

    public final void m11601a() {
        this.f9891i = false;
        this.f9888f.l();
    }

    public final boolean m11604b() {
        return !this.f9891i || this.f9889g.a > f9885c;
    }

    private float m11594a(float f) {
        float f2 = ((float) this.f9890h.f9874b) / 2.0f;
        float abs = f2 - Math.abs(f2 - f);
        float f3 = ((float) this.f9890h.f9874b) * 0.4f;
        if (abs >= f3) {
            return 0.0f;
        }
        float f4 = 0.15f * ((float) this.f9890h.f9874b);
        f2 = Math.signum(f - f2);
        if (abs <= f4) {
            return f2;
        }
        return (float) (SpringUtil.a((double) abs, (double) f3, (double) f4, 0.0d, 1.0d) * ((double) f2));
    }

    public static int m11599d(ImagesReorderViewScrollController imagesReorderViewScrollController) {
        return (int) SpringUtil.a(imagesReorderViewScrollController.f9888f.d(), 0.0d, (double) imagesReorderViewScrollController.f9890h.f9880h);
    }
}

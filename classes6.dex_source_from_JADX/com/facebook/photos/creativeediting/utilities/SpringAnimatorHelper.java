package com.facebook.photos.creativeediting.utilities;

import com.facebook.common.util.MathUtil;
import com.facebook.photos.creativeediting.swipeable.composer.SwipeableTouchEventController.4;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringSystem;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: import_id */
public class SpringAnimatorHelper {
    private final SpringListener f12861a = new C08201(this);
    private final SpringSystem f12862b;
    public Optional<Spring> f12863c = Absent.INSTANCE;
    public float f12864d;
    private float f12865e;
    public float f12866f;
    public float f12867g = 80.0f;
    public float f12868h = 15.0f;
    public 4 f12869i;
    public boolean f12870j;

    /* compiled from: import_id */
    class C08201 implements SpringListener {
        final /* synthetic */ SpringAnimatorHelper f12860a;

        C08201(SpringAnimatorHelper springAnimatorHelper) {
            this.f12860a = springAnimatorHelper;
        }

        public final void m20251a(Spring spring) {
            if (this.f12860a.f12869i != null) {
                float d = (float) spring.d();
                if (this.f12860a.f12870j) {
                    d *= 1.2f;
                }
                if (d >= 1.0f) {
                    spring.l();
                    return;
                }
                this.f12860a.f12869i.a(MathUtil.a(this.f12860a.f12866f, this.f12860a.f12864d, d), false);
            }
        }

        public final void m20252b(Spring spring) {
            if (this.f12860a.f12869i != null) {
                this.f12860a.f12869i.a(this.f12860a.f12864d, true);
                this.f12860a.f12863c = Absent.INSTANCE;
                spring.a();
            }
        }

        public final void m20253c(Spring spring) {
        }

        public final void m20254d(Spring spring) {
        }
    }

    @Inject
    public SpringAnimatorHelper(SpringSystem springSystem) {
        this.f12862b = springSystem;
    }

    public final void m20256a(4 4, float f, float f2) {
        this.f12870j = false;
        this.f12869i = 4;
        this.f12864d = f2;
        this.f12865e = f;
        this.f12866f = this.f12865e;
        Spring b = this.f12862b.a().a(SpringConfig.a((double) this.f12867g, (double) this.f12868h)).a(0.0d).b(1.0d);
        b.l = 0.05000000074505806d;
        b = b;
        b.k = 0.05000000074505806d;
        this.f12863c = Optional.of(b.a(this.f12861a));
    }

    public final void m20255a() {
        if (this.f12863c.isPresent()) {
            this.f12870j = false;
            ((Spring) this.f12863c.get()).l();
        }
    }
}

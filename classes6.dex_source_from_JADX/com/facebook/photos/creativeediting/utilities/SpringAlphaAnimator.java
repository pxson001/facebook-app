package com.facebook.photos.creativeediting.utilities;

import android.annotation.TargetApi;
import android.view.View;
import com.facebook.common.util.MathUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringListener;
import com.facebook.springs.SpringSystem;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

@TargetApi(11)
/* compiled from: impression_count/ */
public class SpringAlphaAnimator {
    @VisibleForTesting
    SpringListener f12853a = new C08191(this);
    private final SpringSystem f12854b;
    public Optional<Spring> f12855c = Absent.INSTANCE;
    public float f12856d;
    public float f12857e;
    public float f12858f = 80.0f;
    public WeakReference<View> f12859g = new WeakReference(null);

    /* compiled from: impression_count/ */
    class C08191 implements SpringListener {
        final /* synthetic */ SpringAlphaAnimator f12852a;

        C08191(SpringAlphaAnimator springAlphaAnimator) {
            this.f12852a = springAlphaAnimator;
        }

        public final void m20244a(Spring spring) {
            View view = (View) this.f12852a.f12859g.get();
            if (view != null) {
                view.setAlpha(MathUtil.a(this.f12852a.f12857e, this.f12852a.f12856d, (float) spring.d()));
            }
        }

        public final void m20245b(Spring spring) {
            View view = (View) this.f12852a.f12859g.get();
            if (view != null) {
                view.setAlpha(this.f12852a.f12856d);
                this.f12852a.f12855c = Absent.INSTANCE;
                spring.a();
            }
        }

        public final void m20246c(Spring spring) {
        }

        public final void m20247d(Spring spring) {
        }
    }

    public static SpringAlphaAnimator m20248b(InjectorLike injectorLike) {
        return new SpringAlphaAnimator(SpringSystem.b(injectorLike));
    }

    @Inject
    public SpringAlphaAnimator(SpringSystem springSystem) {
        this.f12854b = springSystem;
    }

    public final void m20250a(View view, int i) {
        this.f12859g = new WeakReference(view);
        this.f12856d = (float) i;
        this.f12857e = view.getAlpha();
        this.f12855c = Optional.of(this.f12854b.a().a(SpringConfig.a((double) this.f12858f, 15.0d)).a(0.0d).b(1.0d).a(this.f12853a));
    }

    public final void m20249a() {
        if (this.f12855c.isPresent()) {
            ((Spring) this.f12855c.get()).l();
            this.f12853a.b((Spring) this.f12855c.get());
        }
    }
}

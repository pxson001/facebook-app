package android.support.v4.animation;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* compiled from: work_group_creation_dialog */
class DonutAnimatorCompatProvider implements AnimatorProvider {

    /* compiled from: work_group_creation_dialog */
    public class DonutFloatValueAnimator implements ValueAnimatorCompat {
        public List<AnimatorListenerCompat> f3a = new ArrayList();
        public List<AnimatorUpdateListenerCompat> f4b = new ArrayList();
        View f5c;
        public long f6d;
        public long f7e = 200;
        public float f8f = 0.0f;
        private boolean f9g = false;
        private boolean f10h = false;
        public Runnable f11i = new C00001(this);

        /* compiled from: work_group_creation_dialog */
        class C00001 implements Runnable {
            final /* synthetic */ DonutFloatValueAnimator f2a;

            C00001(DonutFloatValueAnimator donutFloatValueAnimator) {
                this.f2a = donutFloatValueAnimator;
            }

            public void run() {
                float e = (((float) (DonutFloatValueAnimator.m13e(this.f2a) - this.f2a.f6d)) * 1.0f) / ((float) this.f2a.f7e);
                if (e > 1.0f || this.f2a.f5c.getParent() == null) {
                    e = 1.0f;
                }
                this.f2a.f8f = e;
                ValueAnimatorCompat valueAnimatorCompat = this.f2a;
                for (int size = valueAnimatorCompat.f4b.size() - 1; size >= 0; size--) {
                    ((AnimatorUpdateListenerCompat) valueAnimatorCompat.f4b.get(size)).mo457a(valueAnimatorCompat);
                }
                if (this.f2a.f8f >= 1.0f) {
                    DonutFloatValueAnimator.m14g(this.f2a);
                } else {
                    this.f2a.f5c.postDelayed(this.f2a.f11i, 16);
                }
            }
        }

        public final void mo5a(View view) {
            this.f5c = view;
        }

        public final void mo3a(AnimatorListenerCompat animatorListenerCompat) {
            this.f3a.add(animatorListenerCompat);
        }

        public final void mo2a(long j) {
            if (!this.f9g) {
                this.f7e = j;
            }
        }

        public final void mo1a() {
            if (!this.f9g) {
                this.f9g = true;
                for (int size = this.f3a.size() - 1; size >= 0; size--) {
                    this.f3a.get(size);
                }
                this.f8f = 0.0f;
                this.f6d = m13e(this);
                this.f5c.postDelayed(this.f11i, 16);
            }
        }

        public static long m13e(DonutFloatValueAnimator donutFloatValueAnimator) {
            return donutFloatValueAnimator.f5c.getDrawingTime();
        }

        public static void m14g(DonutFloatValueAnimator donutFloatValueAnimator) {
            for (int size = donutFloatValueAnimator.f3a.size() - 1; size >= 0; size--) {
                ((AnimatorListenerCompat) donutFloatValueAnimator.f3a.get(size)).mo455a(donutFloatValueAnimator);
            }
        }

        public final void mo6b() {
            if (!this.f10h) {
                this.f10h = true;
                if (this.f9g) {
                    for (int size = this.f3a.size() - 1; size >= 0; size--) {
                        ((AnimatorListenerCompat) this.f3a.get(size)).mo454a();
                    }
                }
                m14g(this);
            }
        }

        public final void mo4a(AnimatorUpdateListenerCompat animatorUpdateListenerCompat) {
            this.f4b.add(animatorUpdateListenerCompat);
        }

        public final float mo7c() {
            return this.f8f;
        }
    }

    DonutAnimatorCompatProvider() {
    }

    public final ValueAnimatorCompat mo8a() {
        return new DonutFloatValueAnimator();
    }

    public final void mo9a(View view) {
    }
}

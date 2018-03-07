package com.facebook.particles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import com.facebook.feedback.reactions.ui.FloatingReactionsLauncher$1;
import com.facebook.particles.suppliers.FloatSupplier;
import com.facebook.particles.suppliers.GaussianInRange;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.FrameCallbackWrapper;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: max_deltas_able_to_process */
public class ParticleSystemDrawable extends Drawable {
    private final ChoreographerWrapper f9219a;
    public final Queue<ParticleStyle> f9220b = new LinkedList();
    public final Deque<Particle> f9221c = new LinkedList();
    public final Queue<Particle> f9222d = new LinkedList();
    private final Paint f9223e = new Paint();
    public final FloatSupplier f9224f;
    private long f9225g;
    public GestureDetector f9226h;
    public FloatingReactionsLauncher$1 f9227i;
    public Particle f9228j;
    private final FrameCallbackWrapper f9229k = new C07381(this);

    /* compiled from: max_deltas_able_to_process */
    class C07381 extends FrameCallbackWrapper {
        final /* synthetic */ ParticleSystemDrawable f9217a;

        C07381(ParticleSystemDrawable particleSystemDrawable) {
            this.f9217a = particleSystemDrawable;
        }

        public final void m11269a(long j) {
            ParticleSystemDrawable.m11273c(this.f9217a);
        }
    }

    /* compiled from: max_deltas_able_to_process */
    class MyOnGestureListener extends SimpleOnGestureListener {
        final /* synthetic */ ParticleSystemDrawable f9218a;

        public MyOnGestureListener(ParticleSystemDrawable particleSystemDrawable) {
            this.f9218a = particleSystemDrawable;
        }

        public boolean onDown(MotionEvent motionEvent) {
            Particle a = ParticleSystemDrawable.m11270a(this.f9218a, motionEvent.getX(), motionEvent.getY());
            if (a == null) {
                return false;
            }
            this.f9218a.f9228j = a;
            a = this.f9218a.f9228j;
            a.f9216n = 0;
            a.f9208f = 0.0f;
            a.f9209g = 0.0f;
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f9218a.f9228j.f9205c -= f;
            this.f9218a.f9228j.f9206d -= f2;
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            this.f9218a.f9228j.f9208f = f;
            this.f9218a.f9228j.f9209g = f2;
            return true;
        }
    }

    @Inject
    public ParticleSystemDrawable(Context context, ChoreographerWrapper choreographerWrapper) {
        this.f9219a = choreographerWrapper;
        this.f9226h = new GestureDetector(context, new MyOnGestureListener(this));
        this.f9226h.setIsLongpressEnabled(false);
        this.f9224f = new GaussianInRange(-0.4f, 0.4f);
    }

    public final void m11274a(SimpleParticleStyle simpleParticleStyle) {
        if (!m11272b()) {
            this.f9219a.a(this.f9229k);
        }
        if (this.f9220b.isEmpty()) {
            this.f9225g = SystemClock.uptimeMillis();
        }
        this.f9220b.add(simpleParticleStyle);
    }

    private boolean m11272b() {
        return (this.f9221c.isEmpty() && this.f9220b.isEmpty()) ? false : true;
    }

    public void draw(Canvas canvas) {
        long uptimeMillis = SystemClock.uptimeMillis();
        canvas.save();
        canvas.translate((float) (canvas.getWidth() / 2), 0.0f);
        for (Particle a : this.f9221c) {
            a.m11261a(canvas, this.f9223e, uptimeMillis);
        }
        canvas.restore();
    }

    public void setAlpha(int i) {
        this.f9223e.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f9223e.setColorFilter(colorFilter);
    }

    public int getOpacity() {
        return -3;
    }

    public static void m11273c(ParticleSystemDrawable particleSystemDrawable) {
        if (particleSystemDrawable.getBounds().height() > 0) {
            long uptimeMillis = SystemClock.uptimeMillis();
            particleSystemDrawable.m11271a((float) uptimeMillis);
            int height = particleSystemDrawable.getBounds().height();
            Iterator it = particleSystemDrawable.f9221c.iterator();
            while (it.hasNext()) {
                Particle particle = (Particle) it.next();
                if (particleSystemDrawable.f9228j != particle) {
                    particle.m11264b(uptimeMillis);
                }
                if ((particle.f9207e >= 0.0f && particle.f9206d - ((float) (Math.max(particle.f9203a.m11278a(), particle.f9203a.m11280b()) / 2)) >= ((float) height)) || (particle.f9207e < 0.0f && particle.f9206d + ((float) (Math.max(particle.f9203a.m11278a(), particle.f9203a.m11280b()) / 2)) < 0.0f)) {
                    it.remove();
                    particleSystemDrawable.f9222d.add(particle);
                }
            }
            particleSystemDrawable.invalidateSelf();
        }
        if (particleSystemDrawable.m11272b()) {
            particleSystemDrawable.f9219a.a(particleSystemDrawable.f9229k);
        } else if (particleSystemDrawable.f9227i != null) {
            particleSystemDrawable.f9227i.m4505a();
        }
    }

    private void m11271a(float f) {
        while (!this.f9220b.isEmpty() && f - ((float) this.f9225g) >= 50.0f) {
            long j = 50 + this.f9225g;
            SimpleParticleStyle simpleParticleStyle = (SimpleParticleStyle) this.f9220b.poll();
            long j2 = this.f9225g;
            Particle particle = (Particle) this.f9222d.poll();
            if (particle != null) {
                particle.m11262a(simpleParticleStyle);
            } else {
                particle = new Particle(simpleParticleStyle);
            }
            Particle particle2 = particle;
            particle2.f9215m = j2;
            particle2.f9205c = this.f9224f.mo482a() * ((float) getBounds().width());
            float max = (float) (Math.max(simpleParticleStyle.m11278a(), simpleParticleStyle.m11280b()) / 2);
            if (simpleParticleStyle.m11281f() > 0.0f) {
                max = -max;
            } else {
                max += (float) getBounds().height();
            }
            particle2.f9206d = max;
            this.f9221c.add(particle2);
            this.f9225g = j;
        }
    }

    @Nullable
    public static Particle m11270a(ParticleSystemDrawable particleSystemDrawable, float f, float f2) {
        Particle particle = null;
        Matrix matrix = new Matrix();
        int width = particleSystemDrawable.getBounds().width();
        float[] fArr = new float[]{f, f2};
        float[] fArr2 = new float[2];
        Iterator descendingIterator = particleSystemDrawable.f9221c.descendingIterator();
        while (descendingIterator.hasNext()) {
            Particle particle2 = (Particle) descendingIterator.next();
            float f3 = particle2.m11267f();
            float g = particle2.m11268g();
            matrix.reset();
            matrix.postTranslate((-f3) / 2.0f, (-g) / 2.0f);
            matrix.postScale(particle2.m11266e(), particle2.m11266e());
            matrix.postRotate(particle2.m11265d());
            matrix.postTranslate(particle2.m11260a() + ((float) (width / 2)), particle2.m11263b());
            matrix.invert(matrix);
            matrix.mapPoints(fArr2, fArr);
            float f4 = fArr2[0];
            float f5 = fArr2[1];
            if (f4 >= 0.0f && f5 >= 0.0f && f4 < f3 && f5 < g) {
                return particle2;
            }
            if (particle != null || f4 < (-f3) / 4.0f || f4 >= (f3 * 5.0f) / 4.0f || f5 < (-g) / 4.0f || f5 >= (5.0f * g) / 4.0f) {
                particle2 = particle;
            }
            particle = particle2;
        }
        return particle;
    }
}

package com.facebook.kenburns;

import android.graphics.PointF;
import com.facebook.kenburns.interpolators.OscillatingLinearInterpolator;
import com.facebook.messaging.momentsinvite.kenburns.KenBurnsSlideShowAnimation.KenBurnsAnimationDelegateImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: p2p_initiate_request */
public class KenBurnsAnimation {
    private static final ImmutableList<InterestPoint> f7598a = RegularImmutableList.a;
    private final PointF f7599b;
    private final PointF f7600c;
    private final PointF f7601d;
    private final List<InterestPoint> f7602e;
    private final List<InterestPoint> f7603f;
    private final long f7604g;
    private final KenBurnsAnimationDelegateImpl f7605h;
    private final List<KeyFrame> f7606i;
    private final OscillatingLinearInterpolator f7607j;
    private final boolean f7608k;
    private long f7609l;
    private float f7610m;
    private float f7611n;
    private float f7612o;
    private float f7613p;
    private float f7614q;
    public boolean f7615r;

    /* compiled from: p2p_initiate_request */
    class C08461 implements Comparator<InterestPoint> {
        final /* synthetic */ KenBurnsAnimation f7592a;

        C08461(KenBurnsAnimation kenBurnsAnimation) {
            this.f7592a = kenBurnsAnimation;
        }

        public int compare(Object obj, Object obj2) {
            return (int) (((InterestPoint) obj).f7590b - ((InterestPoint) obj2).f7590b);
        }
    }

    /* compiled from: p2p_initiate_request */
    class C08472 implements Comparator<InterestPoint> {
        final /* synthetic */ KenBurnsAnimation f7593a;

        C08472(KenBurnsAnimation kenBurnsAnimation) {
            this.f7593a = kenBurnsAnimation;
        }

        public int compare(Object obj, Object obj2) {
            return (int) (((InterestPoint) obj).f7589a - ((InterestPoint) obj2).f7589a);
        }
    }

    /* compiled from: p2p_initiate_request */
    public class KeyFrame {
        public float f7594a;
        public float f7595b;
        public float f7596c;
        final /* synthetic */ KenBurnsAnimation f7597d;

        public KeyFrame(KenBurnsAnimation kenBurnsAnimation, float f, float f2, float f3) {
            this.f7597d = kenBurnsAnimation;
            this.f7594a = f;
            this.f7595b = f2;
            this.f7596c = f3;
        }
    }

    /* compiled from: p2p_initiate_request */
    enum RelativeXPosition {
        RIGHT_OF,
        LEFT_OF
    }

    private static float m7886a(float f, float f2, float f3, float f4, float f5, float f6) {
        float f7 = f3 / f4;
        float abs = f - Math.abs(f5 * 2.0f);
        float abs2 = f2 - Math.abs(f6 * 2.0f);
        float f8 = abs / abs2;
        if (f7 >= f8) {
            f4 = f3;
        }
        if (f7 >= f8) {
            abs2 = abs;
        }
        return f4 / abs2;
    }

    public KenBurnsAnimation(PointF pointF, PointF pointF2, long j, int i, KenBurnsAnimationDelegate kenBurnsAnimationDelegate, ImageAnimationInterpolator imageAnimationInterpolator, float f, boolean z, @Nullable List<InterestPoint> list) {
        this(pointF, pointF2, j, i, kenBurnsAnimationDelegate, imageAnimationInterpolator, f, z, list, true);
    }

    private KenBurnsAnimation(PointF pointF, PointF pointF2, long j, int i, KenBurnsAnimationDelegate kenBurnsAnimationDelegate, ImageAnimationInterpolator imageAnimationInterpolator, float f, boolean z, @Nullable List<InterestPoint> list, boolean z2) {
        this.f7615r = z2;
        this.f7599b = pointF;
        this.f7600c = pointF2;
        this.f7601d = new PointF(pointF2.x / 2.0f, pointF2.y / 2.0f);
        this.f7604g = j;
        this.f7605h = kenBurnsAnimationDelegate;
        this.f7611n = f;
        if (list == null) {
            list = f7598a;
        }
        this.f7602e = list;
        this.f7603f = Lists.a();
        this.f7607j = imageAnimationInterpolator;
        this.f7610m = (float) i;
        this.f7608k = z;
        this.f7606i = m7889a();
        this.f7609l = -1;
        m7897a(0);
    }

    private List<KeyFrame> m7889a() {
        Object a;
        Object b;
        Builder builder = ImmutableList.builder();
        float f = this.f7599b.x / this.f7599b.y;
        int i = (f > 1.1f || f < 0.9f) ? 0 : 1;
        KeyFrame keyFrame;
        InterestPoint interestPoint;
        KeyFrame a2;
        switch (this.f7602e.size()) {
            case 0:
                if (i == 0) {
                    keyFrame = new KeyFrame(this, 0.0f, 0.0f, 1.0f);
                    KeyFrame keyFrame2 = new KeyFrame(this, 0.0f, 0.0f, 1.0f);
                    m7890a(keyFrame, keyFrame2, this.f7610m);
                    break;
                }
                a = m7887a(new InterestPoint(this.f7599b.x / 2.0f, this.f7599b.y / 2.0f, 1.5f));
                b = m7892b();
                break;
            case 1:
                interestPoint = (InterestPoint) this.f7602e.get(0);
                if (i == 0) {
                    keyFrame = m7887a(interestPoint);
                    b = m7888a(RelativeXPosition.RIGHT_OF, keyFrame, 50.0f);
                    break;
                }
                interestPoint.f7591c = Math.max(1.5f, interestPoint.f7591c);
                a = m7887a(interestPoint);
                b = m7892b();
                break;
            case 2:
                interestPoint = (InterestPoint) this.f7602e.get(0);
                InterestPoint interestPoint2 = (InterestPoint) this.f7602e.get(1);
                if (interestPoint.f7589a >= interestPoint2.f7589a) {
                    a = m7887a(interestPoint2);
                    b = m7887a(interestPoint);
                    break;
                }
                a2 = m7887a(interestPoint);
                b = m7887a(interestPoint2);
                keyFrame = a2;
                break;
            default:
                this.f7603f.addAll(this.f7602e);
                Collections.sort(this.f7603f, new C08461(this));
                float f2 = ((InterestPoint) this.f7603f.get(this.f7603f.size() >> 1)).f7590b;
                Collections.sort(this.f7603f, new C08472(this));
                interestPoint = (InterestPoint) this.f7603f.get(0);
                a2 = m7887a(new InterestPoint(interestPoint.f7589a, f2, interestPoint.f7591c));
                b = m7887a(new InterestPoint(((InterestPoint) this.f7603f.get(this.f7603f.size() - 1)).f7589a, f2, interestPoint.f7591c));
                this.f7603f.clear();
                a = a2;
                break;
        }
        builder.c(a);
        builder.c(b);
        return builder.b();
    }

    private void m7890a(KeyFrame keyFrame, KeyFrame keyFrame2, float f) {
        KeyFrame b = m7892b();
        KeyFrame a = m7888a(RelativeXPosition.LEFT_OF, b, f / 2.0f);
        keyFrame.f7594a = a.f7594a;
        keyFrame.f7595b = a.f7595b;
        keyFrame.f7596c = (this.f7608k ? 1.0f : 1.35f) * a.f7596c;
        float f2 = (b.f7594a - keyFrame.f7594a) + b.f7594a;
        float f3 = b.f7595b + (b.f7595b - keyFrame.f7595b);
        float a2 = m7884a(m7883a(f2), m7891b(f3));
        keyFrame2.f7594a = f2;
        keyFrame2.f7595b = f3;
        keyFrame2.f7596c = a2;
    }

    private KeyFrame m7887a(InterestPoint interestPoint) {
        float min = Math.min(Math.max(interestPoint.f7589a, m7894d()), m7893c());
        float min2 = Math.min(Math.max(interestPoint.f7590b, m7896f()), m7895e());
        return new KeyFrame(this, min, min2, m7884a(m7883a(min), m7891b(min2)) * interestPoint.f7591c);
    }

    private KeyFrame m7888a(RelativeXPosition relativeXPosition, KeyFrame keyFrame, float f) {
        float max;
        float random;
        if (relativeXPosition == RelativeXPosition.LEFT_OF) {
            max = Math.max(keyFrame.f7594a - f, m7894d());
        } else {
            max = Math.min(keyFrame.f7594a + f, m7893c());
        }
        float max2 = Math.max(keyFrame.f7595b - f, m7896f());
        float min = Math.min(keyFrame.f7595b + f, m7895e());
        if (this.f7615r) {
            random = ((float) Math.random()) * (min - max2);
        } else {
            random = (min - max2) / 2.0f;
        }
        max2 = random + max2;
        return new KeyFrame(this, max, max2, m7884a(m7883a(max), m7891b(max2)));
    }

    private KeyFrame m7892b() {
        float f = this.f7599b.x / 2.0f;
        float f2 = this.f7599b.y / 2.0f;
        return new KeyFrame(this, f, f2, m7884a(m7883a(f), m7891b(f2)));
    }

    private float m7884a(float f, float f2) {
        return m7886a(this.f7599b.x, this.f7599b.y, this.f7600c.x, this.f7600c.y, f, f2);
    }

    private float m7893c() {
        return Math.max(this.f7599b.x - m7894d(), this.f7599b.x / 2.0f);
    }

    private float m7894d() {
        return Math.min(this.f7601d.x / this.f7611n, this.f7599b.x / 2.0f);
    }

    private float m7895e() {
        return Math.max(this.f7599b.y - m7896f(), this.f7599b.y / 2.0f);
    }

    private float m7896f() {
        return Math.min(this.f7601d.y / this.f7611n, this.f7599b.y / 2.0f);
    }

    public final void m7897a(long j) {
        if (this.f7609l != j) {
            this.f7609l = j;
            OscillatingLinearInterpolator oscillatingLinearInterpolator = this.f7607j;
            float f = ((float) this.f7609l) / ((float) this.f7604g);
            float abs = Math.abs(((float) Math.round(((Math.floor((double) f) % 2.0d) - ((double) (f % 1.0f))) * 1000.0d)) / 1000.0f);
            KeyFrame keyFrame = (KeyFrame) this.f7606i.get(0);
            KeyFrame keyFrame2 = (KeyFrame) this.f7606i.get(1);
            f = m7885a(keyFrame.f7594a, keyFrame2.f7594a, abs);
            float a = m7885a(keyFrame.f7595b, keyFrame2.f7595b, abs);
            float a2 = m7885a(keyFrame.f7596c, keyFrame2.f7596c, abs);
            this.f7605h.m12762a(f, a, a2, this.f7601d.x - f, this.f7601d.y - a);
            this.f7612o = f;
            this.f7613p = a;
            this.f7614q = a2;
        }
    }

    private static float m7885a(float f, float f2, float f3) {
        return ((f2 - f) * f3) + f;
    }

    private float m7883a(float f) {
        return f - (this.f7599b.x / 2.0f);
    }

    private float m7891b(float f) {
        return f - (this.f7599b.y / 2.0f);
    }
}

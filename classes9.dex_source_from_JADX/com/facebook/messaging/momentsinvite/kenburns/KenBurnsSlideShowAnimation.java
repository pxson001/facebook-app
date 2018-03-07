package com.facebook.messaging.momentsinvite.kenburns;

import android.graphics.PointF;
import android.net.Uri;
import com.facebook.kenburns.KenBurnsAnimation;
import com.facebook.kenburns.interpolators.OscillatingLinearInterpolator;
import com.facebook.messaging.momentsinvite.ui.MomentsInviteImageLoader;
import com.google.common.base.Objects;
import javax.annotation.Nullable;

/* compiled from: item_logging_data */
public class KenBurnsSlideShowAnimation {
    public final MomentsInviteImageLoader f12297a;
    public final KenBurnsSlideShowAnimationDelegate f12298b;
    private final long f12299c;
    @Nullable
    public Uri f12300d;
    @Nullable
    public PointF f12301e;
    @Nullable
    private PointF f12302f;
    @Nullable
    private KenBurnsAnimation f12303g;
    private boolean f12304h;
    public double f12305i;
    public double f12306j;

    /* compiled from: item_logging_data */
    public class KenBurnsAnimationDelegateImpl {
        final /* synthetic */ KenBurnsSlideShowAnimation f12296a;

        public KenBurnsAnimationDelegateImpl(KenBurnsSlideShowAnimation kenBurnsSlideShowAnimation) {
            this.f12296a = kenBurnsSlideShowAnimation;
        }

        public final void m12762a(float f, float f2, float f3, float f4, float f5) {
            boolean z = true;
            float f6 = 1.0f;
            switch (this.f12296a.m12769b()) {
                case NOT_READY:
                case READY:
                    f6 = 0.0f;
                    break;
                case FADE_IN:
                    f6 = ((float) this.f12296a.f12305i) / 2000.0f;
                    break;
                case NORMAL:
                case WAIT_FOR_NEXT_READY:
                    break;
                case FADE_OUT:
                    f6 = 1.0f - (((float) (this.f12296a.f12305i - this.f12296a.f12306j)) / 2000.0f);
                    break;
                case FINISHED:
                    z = false;
                    break;
                default:
                    z = false;
                    break;
            }
            this.f12296a.f12298b.mo461a(f, f2, f3, f4, f5, z, f6);
        }
    }

    public KenBurnsSlideShowAnimation(MomentsInviteImageLoader momentsInviteImageLoader, KenBurnsSlideShowAnimationDelegate kenBurnsSlideShowAnimationDelegate, long j) {
        this.f12297a = momentsInviteImageLoader;
        this.f12298b = kenBurnsSlideShowAnimationDelegate;
        this.f12299c = j;
    }

    private void m12763a(int i, int i2) {
        this.f12301e = new PointF((float) i, (float) i2);
        m12764d();
    }

    public final void m12766a(@Nullable PointF pointF) {
        this.f12302f = pointF;
        m12764d();
    }

    public final void m12768a(boolean z) {
        this.f12304h = z;
        m12764d();
    }

    private void m12764d() {
        if (this.f12304h && this.f12302f != null) {
            this.f12298b.mo463a(null);
            this.f12298b.mo462a((int) this.f12302f.x, (int) this.f12302f.y);
        } else if (this.f12300d != null && this.f12301e != null && this.f12302f != null) {
            this.f12298b.mo463a(this.f12300d);
            this.f12298b.mo462a((int) this.f12301e.x, (int) this.f12301e.y);
            this.f12303g = new KenBurnsAnimation(this.f12301e, this.f12302f, 8000, Math.round(Math.min(this.f12301e.x, this.f12301e.y) / 2.0f), new KenBurnsAnimationDelegateImpl(this), new OscillatingLinearInterpolator(), 1.5f, false, null);
        }
    }

    public final KenBurnsSlideShowAnimationState m12769b() {
        if (!this.f12304h) {
            if (this.f12300d == null || this.f12303g == null) {
                return KenBurnsSlideShowAnimationState.NOT_READY;
            }
            if (this.f12305i <= 0.0d) {
                return KenBurnsSlideShowAnimationState.READY;
            }
            if (this.f12305i <= 2000.0d) {
                return KenBurnsSlideShowAnimationState.FADE_IN;
            }
            if (this.f12305i <= 6000.0d) {
                return KenBurnsSlideShowAnimationState.NORMAL;
            }
        }
        if (this.f12306j <= 0.0d) {
            return KenBurnsSlideShowAnimationState.WAIT_FOR_NEXT_READY;
        }
        if (this.f12305i <= this.f12306j + 2000.0d) {
            return KenBurnsSlideShowAnimationState.FADE_OUT;
        }
        return KenBurnsSlideShowAnimationState.FINISHED;
    }

    public final void m12765a(double d) {
        if (m12769b() != KenBurnsSlideShowAnimationState.NOT_READY) {
            this.f12305i += d;
            if (!this.f12304h) {
                this.f12303g.m7897a(this.f12299c + Math.round(this.f12305i));
            }
        }
    }

    public final void m12767a(Uri uri, int i, int i2) {
        if (Objects.equal(this.f12300d, uri)) {
            m12763a(i, i2);
        }
    }
}

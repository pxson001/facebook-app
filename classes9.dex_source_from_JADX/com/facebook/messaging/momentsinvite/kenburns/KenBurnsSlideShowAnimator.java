package com.facebook.messaging.momentsinvite.kenburns;

import android.graphics.PointF;
import android.net.Uri;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.messaging.momentsinvite.ui.MomentsInviteImageLoader;
import com.facebook.messaging.momentsinvite.ui.MomentsInviteImageLoader.C13581;
import com.facebook.ui.choreographer.ChoreographerWrapper;
import com.facebook.ui.choreographer.DefaultChoreographerWrapper;
import com.facebook.ui.choreographer.FrameCallbackWrapper;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import javax.annotation.Nullable;

/* compiled from: item_description */
public class KenBurnsSlideShowAnimator {
    private final MomentsInviteImageLoader f12309a;
    public final ImmutableList<KenBurnsSlideShowAnimationDelegate> f12310b;
    public final ChoreographerWrapper f12311c;
    public final AnimatorFrameCallback f12312d;
    @Nullable
    private PointF f12313e;
    public ImmutableList<Uri> f12314f;
    private boolean f12315g;
    public boolean f12316h;
    public double f12317i;
    public double f12318j;
    public int f12319k;
    public int f12320l;
    @Nullable
    public KenBurnsSlideShowAnimation f12321m;
    @Nullable
    public KenBurnsSlideShowAnimation f12322n;

    /* compiled from: item_description */
    class AnimatorFrameCallback extends FrameCallbackWrapper {
        final /* synthetic */ KenBurnsSlideShowAnimator f12308a;

        public AnimatorFrameCallback(KenBurnsSlideShowAnimator kenBurnsSlideShowAnimator) {
            this.f12308a = kenBurnsSlideShowAnimator;
        }

        public final void m12775a(long j) {
            if (this.f12308a.f12316h) {
                this.f12308a.f12311c.a(this.f12308a.f12312d);
            }
            if (this.f12308a.f12321m != null) {
                double b = m12774b(j);
                this.f12308a.f12321m.m12765a(b);
                switch (this.f12308a.f12321m.m12769b()) {
                    case WAIT_FOR_NEXT_READY:
                        KenBurnsSlideShowAnimator.m12788o(this.f12308a);
                        if (this.f12308a.f12322n.m12769b() != KenBurnsSlideShowAnimationState.NOT_READY) {
                            KenBurnsSlideShowAnimation kenBurnsSlideShowAnimation = this.f12308a.f12321m;
                            if (kenBurnsSlideShowAnimation.f12306j <= 0.0d) {
                                kenBurnsSlideShowAnimation.f12306j = Math.max(kenBurnsSlideShowAnimation.f12305i, 6000.0d);
                            }
                            return;
                        }
                        return;
                    case FADE_OUT:
                        KenBurnsSlideShowAnimator.m12788o(this.f12308a);
                        this.f12308a.f12322n.m12765a(b);
                        return;
                    case FINISHED:
                        KenBurnsSlideShowAnimator.m12788o(this.f12308a);
                        this.f12308a.f12322n.m12765a(b);
                        KenBurnsSlideShowAnimator.m12789p(this.f12308a);
                        return;
                    default:
                        return;
                }
            }
        }

        private double m12774b(long j) {
            double d = 0.0d;
            double d2 = ((double) j) / 1000000.0d;
            if (this.f12308a.f12318j > 0.0d) {
                d = d2 - this.f12308a.f12318j;
            }
            this.f12308a.f12318j = d2;
            KenBurnsSlideShowAnimator kenBurnsSlideShowAnimator = this.f12308a;
            kenBurnsSlideShowAnimator.f12317i += d;
            return d;
        }
    }

    public KenBurnsSlideShowAnimator(ImageLoader imageLoader, ImmutableList<KenBurnsSlideShowAnimationDelegate> immutableList) {
        Preconditions.checkArgument(!immutableList.isEmpty());
        this.f12309a = imageLoader;
        this.f12310b = immutableList;
        this.f12311c = new DefaultChoreographerWrapper();
        this.f12312d = new AnimatorFrameCallback(this);
        this.f12314f = RegularImmutableList.a;
    }

    public final void m12791a(int i, int i2) {
        if (this.f12313e == null || this.f12313e.x != ((float) i) || this.f12313e.y != ((float) i2)) {
            this.f12313e = new PointF((float) i, (float) i2);
            m12777c();
        }
    }

    public final void m12792a(ImmutableList<Uri> immutableList) {
        if (!Objects.equal(this.f12314f, immutableList)) {
            this.f12314f = immutableList;
            m12777c();
        }
    }

    private void m12777c() {
        int size = this.f12310b.size();
        for (int i = 0; i < size; i++) {
            ((KenBurnsSlideShowAnimationDelegate) this.f12310b.get(i)).mo460a();
        }
        this.f12317i = 0.0d;
        this.f12318j = 0.0d;
        this.f12319k = -1;
        this.f12320l = 0;
        this.f12321m = null;
        this.f12322n = null;
        m12778e();
    }

    private void m12778e() {
        if (this.f12313e != null && !this.f12314f.isEmpty()) {
            if (this.f12314f.size() == 1) {
                m12786m().mo463a((Uri) this.f12314f.get(0));
                m12786m().mo462a((int) this.f12313e.x, (int) this.f12313e.y);
            } else {
                this.f12321m = new KenBurnsSlideShowAnimation(this.f12309a, m12786m(), 0);
                this.f12321m.m12766a(this.f12313e);
                this.f12321m.m12768a(true);
                this.f12322n = null;
            }
            m12779f();
        }
    }

    public final void m12790a() {
        this.f12315g = true;
        m12779f();
    }

    public final void m12793b() {
        this.f12315g = false;
        m12779f();
    }

    private void m12779f() {
        if (m12780g() && !this.f12316h) {
            this.f12316h = true;
            this.f12318j = -1.0d;
            this.f12311c.a(this.f12312d);
        } else if (!m12780g() && this.f12316h) {
            this.f12316h = false;
            this.f12311c.b(this.f12312d);
        }
    }

    private boolean m12780g() {
        return this.f12315g && this.f12313e != null && this.f12314f.size() > 1;
    }

    private int m12781h() {
        return this.f12314f.isEmpty() ? 0 : (this.f12319k + 1) % this.f12314f.size();
    }

    private void m12782i() {
        this.f12319k = m12781h();
    }

    @Nullable
    private Uri m12783j() {
        int h = m12781h();
        Uri uri = (h < 0 || h >= this.f12314f.size()) ? null : (Uri) this.f12314f.get(h);
        return uri;
    }

    private int m12784k() {
        return (this.f12320l + 1) % this.f12310b.size();
    }

    private void m12785l() {
        this.f12320l = m12784k();
    }

    private KenBurnsSlideShowAnimationDelegate m12776b(int i) {
        return (KenBurnsSlideShowAnimationDelegate) this.f12310b.get(i % this.f12310b.size());
    }

    private KenBurnsSlideShowAnimationDelegate m12786m() {
        return m12776b(this.f12320l);
    }

    private KenBurnsSlideShowAnimationDelegate m12787n() {
        return m12776b(m12784k());
    }

    public static void m12788o(KenBurnsSlideShowAnimator kenBurnsSlideShowAnimator) {
        if (kenBurnsSlideShowAnimator.f12322n == null) {
            kenBurnsSlideShowAnimator.f12322n = new KenBurnsSlideShowAnimation(kenBurnsSlideShowAnimator.f12309a, kenBurnsSlideShowAnimator.m12787n(), Math.round(kenBurnsSlideShowAnimator.f12317i));
            KenBurnsSlideShowAnimation kenBurnsSlideShowAnimation = kenBurnsSlideShowAnimator.f12322n;
            kenBurnsSlideShowAnimation.f12300d = kenBurnsSlideShowAnimator.m12783j();
            kenBurnsSlideShowAnimation.f12301e = null;
            if (kenBurnsSlideShowAnimation.f12300d != null) {
                MomentsInviteImageLoader momentsInviteImageLoader = kenBurnsSlideShowAnimation.f12297a;
                Uri uri = kenBurnsSlideShowAnimation.f12300d;
                ImageRequest a = ImageRequest.a(uri);
                if (a != null) {
                    momentsInviteImageLoader.f12335b.c(a, MomentsInviteImageLoader.f12334a).a(new C13581(momentsInviteImageLoader, kenBurnsSlideShowAnimation, uri), momentsInviteImageLoader.f12336c);
                }
            }
            kenBurnsSlideShowAnimator.f12322n.m12766a(kenBurnsSlideShowAnimator.f12313e);
        }
    }

    public static void m12789p(KenBurnsSlideShowAnimator kenBurnsSlideShowAnimator) {
        kenBurnsSlideShowAnimator.f12321m = kenBurnsSlideShowAnimator.f12322n;
        kenBurnsSlideShowAnimator.f12322n = null;
        kenBurnsSlideShowAnimator.m12782i();
        kenBurnsSlideShowAnimator.m12785l();
    }
}

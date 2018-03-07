package com.facebook.photos.creativeediting.ui;

import android.annotation.TargetApi;
import android.widget.ImageView;
import com.facebook.inject.Assisted;
import com.facebook.photos.creativeediting.renderers.MovableItemContainer;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import java.lang.ref.WeakReference;
import javax.inject.Inject;

/* compiled from: live_video_subscriptions */
public class MovableItemAnimationController {
    public static final SpringConfig f9995a = SpringConfig.a(120.0d, 12.0d);
    public static final SpringConfig f9996b = SpringConfig.a(45.0d, 5.0d);
    public boolean f9997c;
    public SpringSystem f9998d;
    public ImageView f9999e;
    public final MovableItemContainer f10000f;
    private final WeakReference<MovableContainerView> f10001g;
    public Spring f10002h;
    public Spring f10003i;
    public Spring f10004j;
    public Spring f10005k;
    public StickerTrashingAnimationState f10006l;
    public double f10007m;
    public int f10008n = 2130842875;

    /* compiled from: live_video_subscriptions */
    public class C08381 extends SimpleSpringListener {
        final /* synthetic */ MovableItemAnimationController f9991a;

        public C08381(MovableItemAnimationController movableItemAnimationController) {
            this.f9991a = movableItemAnimationController;
        }

        @TargetApi(11)
        public final void m11941a(Spring spring) {
            float d = (float) spring.d();
            if (d < 0.0f && this.f9991a.f9997c) {
                this.f9991a.f9999e.setImageResource(this.f9991a.f10008n);
                this.f9991a.f9997c = false;
            } else if (d >= 0.0f && !this.f9991a.f9997c) {
                this.f9991a.f9999e.setImageResource(2130842880);
                this.f9991a.f9997c = true;
            }
            this.f9991a.f9999e.setScaleX(Math.abs(d));
            this.f9991a.f9999e.setScaleY(Math.abs(d));
            MovableItemAnimationController.m11946i(this.f9991a);
        }

        public final void m11942b(Spring spring) {
            if (spring.g(1.5d)) {
                this.f9991a.f10006l = StickerTrashingAnimationState.OPENING_COMPLETE;
                return;
            }
            this.f9991a.f10006l = StickerTrashingAnimationState.DEFAULT;
        }
    }

    /* compiled from: live_video_subscriptions */
    public class C08392 extends SimpleSpringListener {
        final /* synthetic */ MovableItemAnimationController f9992a;

        public C08392(MovableItemAnimationController movableItemAnimationController) {
            this.f9992a = movableItemAnimationController;
        }

        @TargetApi(11)
        public final void m11943a(Spring spring) {
            if (this.f9992a.f10000f.f9592k != null) {
                this.f9992a.f10000f.m11503a(spring.d());
                MovableItemAnimationController.m11946i(this.f9992a);
            }
        }
    }

    /* compiled from: live_video_subscriptions */
    public class C08403 extends SimpleSpringListener {
        final /* synthetic */ MovableItemAnimationController f9993a;

        public C08403(MovableItemAnimationController movableItemAnimationController) {
            this.f9993a = movableItemAnimationController;
        }

        public final void m11944a(Spring spring) {
            double d = spring.d();
            if (this.f9993a.f10000f.f9592k != null) {
                this.f9993a.f10000f.m11505a((int) d);
                MovableItemAnimationController.m11946i(this.f9993a);
            }
        }
    }

    /* compiled from: live_video_subscriptions */
    public class C08414 extends SimpleSpringListener {
        final /* synthetic */ MovableItemAnimationController f9994a;

        public C08414(MovableItemAnimationController movableItemAnimationController) {
            this.f9994a = movableItemAnimationController;
        }

        public final void m11945a(Spring spring) {
            double d = spring.d();
            if (this.f9994a.f10000f.f9592k != null) {
                this.f9994a.f10000f.m11512b((int) d);
                MovableItemAnimationController.m11946i(this.f9994a);
            }
        }
    }

    /* compiled from: live_video_subscriptions */
    public enum StickerTrashingAnimationState {
        DEFAULT,
        OPENING,
        OPENING_COMPLETE,
        CLOSING
    }

    @Inject
    public MovableItemAnimationController(@Assisted ImageView imageView, @Assisted MovableItemContainer movableItemContainer, @Assisted MovableContainerView movableContainerView, SpringSystem springSystem) {
        this.f9998d = springSystem;
        this.f9999e = imageView;
        this.f10000f = movableItemContainer;
        this.f10001g = new WeakReference(movableContainerView);
        Spring a = this.f9998d.a().a(f9996b);
        a.c = true;
        this.f10002h = a.a(-1.0d).a(new C08381(this));
        a = this.f9998d.a().a(f9995a);
        a.c = true;
        this.f10003i = a.a(1.0d).a(new C08392(this));
        this.f10006l = StickerTrashingAnimationState.DEFAULT;
        a = this.f9998d.a().a(f9995a);
        a.c = true;
        this.f10004j = a.a(new C08403(this));
        a = this.f9998d.a().a(f9995a);
        a.c = true;
        this.f10005k = a.a(new C08414(this));
    }

    public static void m11946i(MovableItemAnimationController movableItemAnimationController) {
        if (movableItemAnimationController.f10001g.get() != null) {
            ((MovableContainerView) movableItemAnimationController.f10001g.get()).invalidate();
        }
    }

    public final void m11947b() {
        if (!this.f10000f.m11510a()) {
            Spring a = this.f10002h.a(f9996b);
            a.c = false;
            a.b(-1.0d);
        }
    }
}

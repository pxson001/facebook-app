package com.facebook.chatheads.view;

import com.facebook.chatheads.view.bubble.BubbleView.C06164;
import com.facebook.inject.Assisted;
import com.facebook.springs.SimpleSpringListener;
import com.facebook.springs.Spring;
import com.facebook.springs.SpringConfig;
import com.facebook.springs.SpringSystem;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.facebook.widget.ViewTransform;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.SettableFuture;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;

/* compiled from: react_context_perf_marker */
public class SpringyPositioner {
    private static SpringConfig f5836a = SpringConfig.a(40.0d, 7.0d);
    private static SpringConfig f5837b = SpringConfig.a(220.0d, 15.0d);
    private final ViewTransform f5838c;
    public final Spring f5839d;
    public final Spring f5840e;
    private final Set<Object> f5841f = Sets.a();
    public C06164 f5842g;
    public SettableFuture<Void> f5843h;

    /* compiled from: react_context_perf_marker */
    class MySpringListener extends SimpleSpringListener {
        final /* synthetic */ SpringyPositioner f5835a;

        public MySpringListener(SpringyPositioner springyPositioner) {
            this.f5835a = springyPositioner;
        }

        public final void m6053c(Spring spring) {
            if (this.f5835a.f5842g != null) {
                this.f5835a.f5842g.m6058a();
            }
        }

        public final void m6051a(Spring spring) {
            if (spring == this.f5835a.f5839d) {
                SpringyPositioner.m6054a(this.f5835a, spring.d());
            } else if (spring == this.f5835a.f5840e) {
                SpringyPositioner.m6056b(this.f5835a, spring.d());
            }
        }

        public final void m6052b(Spring spring) {
            SpringyPositioner springyPositioner = this.f5835a;
            if (springyPositioner.f5839d.k() && springyPositioner.f5840e.k()) {
                if (springyPositioner.f5843h != null) {
                    FutureDetour.a(springyPositioner.f5843h, null, -1226777308);
                }
                if (springyPositioner.f5842g != null) {
                    springyPositioner.f5842g.m6059b();
                }
            }
        }
    }

    @Inject
    public SpringyPositioner(@Assisted ViewTransform viewTransform, SpringSystem springSystem) {
        this.f5838c = viewTransform;
        MySpringListener mySpringListener = new MySpringListener(this);
        Spring a = springSystem.a().a(f5836a);
        a.k = 0.3d;
        a = a;
        a.l = 0.3d;
        this.f5839d = a.a(mySpringListener);
        a = springSystem.a().a(f5836a);
        a.k = 0.3d;
        a = a;
        a.l = 0.3d;
        this.f5840e = a.a(mySpringListener);
    }

    public static void m6054a(SpringyPositioner springyPositioner, double d) {
        springyPositioner.f5838c.a.setX((float) d);
        springyPositioner.m6055b();
    }

    public static void m6056b(SpringyPositioner springyPositioner, double d) {
        springyPositioner.f5838c.a.setY((float) d);
        springyPositioner.m6055b();
    }

    private void m6055b() {
        Iterator it = this.f5841f.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }
}

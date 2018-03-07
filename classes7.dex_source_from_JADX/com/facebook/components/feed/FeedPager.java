package com.facebook.components.feed;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.view.ViewGroup;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.ComponentLifecycle.MountType;
import com.facebook.components.ComponentsPools;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Size;
import com.facebook.components.ThreadUtils;
import com.facebook.components.widget.BaseBinder;
import com.facebook.components.widget.PagerBinder;
import com.facebook.feed.rows.pager.RowViewPager;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: transliterator_help_used */
public final class FeedPager extends ComponentLifecycle {
    public static FeedPager f1219b = null;
    public static final SynchronizedPool<Builder> f1220c = new SynchronizedPool(2);
    private final FeedPagerSpec f1221d = new FeedPagerSpec();

    /* compiled from: transliterator_help_used */
    public class Builder extends com.facebook.components.Component.Builder<FeedPager> {
        private static String[] f1212b = new String[]{"binder"};
        private static int f1213c = 1;
        State f1214a;
        private BitSet f1215d = new BitSet(f1213c);

        public static void m1274a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f1214a = state;
            builder.f1215d.clear();
        }

        public final Builder m1275a(PagerBinder pagerBinder) {
            this.f1214a.f1216a = pagerBinder;
            this.f1215d.set(0);
            return this;
        }

        public final Component<FeedPager> m1277d() {
            int i = 0;
            if (this.f1215d == null || this.f1215d.nextClearBit(0) >= f1213c) {
                State state = this.f1214a;
                m1276a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < f1213c) {
                if (!this.f1215d.get(i)) {
                    arrayList.add(f1212b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m1276a() {
            super.a();
            this.f1214a = null;
            FeedPager.f1220c.a(this);
        }
    }

    /* compiled from: transliterator_help_used */
    public class State extends Component<FeedPager> implements Cloneable {
        PagerBinder f1216a;
        ComponentPageSwitcher f1217b = FeedPagerSpec.f1222a;
        int f1218c = 0;

        public State() {
            super(FeedPager.m1279j());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.b == state.b) {
                return true;
            }
            if (this.f1216a == null ? state.f1216a != null : !this.f1216a.equals(state.f1216a)) {
                return false;
            }
            if (this.f1217b == null ? state.f1217b != null : !this.f1217b.equals(state.f1217b)) {
                return false;
            }
            if (this.f1218c != state.f1218c) {
                return false;
            }
            return true;
        }
    }

    private FeedPager() {
    }

    public static synchronized FeedPager m1279j() {
        FeedPager feedPager;
        synchronized (FeedPager.class) {
            if (f1219b == null) {
                f1219b = new FeedPager();
            }
            feedPager = f1219b;
        }
        return feedPager;
    }

    public static Builder m1278a(ComponentContext componentContext) {
        State state = new State();
        Builder builder = (Builder) f1220c.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m1274a(builder, componentContext, 0, state);
        return builder;
    }

    protected final boolean m1283c() {
        return true;
    }

    protected final void m1280a(ComponentContext componentContext, InternalNode internalNode, int i, int i2, Size size, Component component) {
        BaseBinder baseBinder = ((State) component).f1216a;
        ComponentsPools.a(componentContext, baseBinder.m1307a(componentContext, baseBinder.f1254h)).b().a(i, i2, size);
    }

    protected final void m1281a(ComponentContext componentContext, InternalNode internalNode, Component component) {
        ((State) component).f1216a.m1309a(internalNode.c(), internalNode.d());
    }

    public final MountType m1286f() {
        return MountType.VIEW;
    }

    protected final Object m1285e(ComponentContext componentContext, Object obj, Component component) {
        State state = (State) component;
        return FeedPagerSpec.m1290a(componentContext, (RowViewPager) obj, state.f1216a, state.f1218c);
    }

    protected final void m1289h(ComponentContext componentContext, Object obj, Component component) {
        State state = (State) component;
        ViewGroup viewGroup = (RowViewPager) obj;
        BaseBinder baseBinder = state.f1216a;
        ComponentPageSwitcher componentPageSwitcher = state.f1217b;
        baseBinder.m1314c(viewGroup);
        if (componentPageSwitcher != null) {
            componentPageSwitcher.f1206a = null;
        }
    }

    protected final void m1288g(ComponentContext componentContext, Object obj, Component component) {
        State state = (State) component;
        ViewGroup viewGroup = (RowViewPager) obj;
        BaseBinder baseBinder = state.f1216a;
        ComponentPageSwitcher componentPageSwitcher = state.f1217b;
        baseBinder.m1313b(viewGroup);
        if (componentPageSwitcher != null) {
            componentPageSwitcher.f1206a = viewGroup;
        }
    }

    protected final void m1287f(ComponentContext componentContext, Object obj, Component component) {
        RowViewPager rowViewPager = (RowViewPager) obj;
        BaseBinder baseBinder = ((State) component).f1216a;
        ThreadUtils.b();
        if (rowViewPager == baseBinder.f1236g) {
            baseBinder.mo55g(baseBinder.f1236g);
            baseBinder.f1236g = null;
        }
    }

    public final boolean m1284d() {
        return true;
    }

    public final void m1282a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ FeedPager f1211c;

                public void run() {
                    this.f1211c.a(eventHandler, obj);
                }
            }, 1233703250);
        }
    }
}

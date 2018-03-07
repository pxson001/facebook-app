package com.facebook.components.widget;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.widget.ProgressBar;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.ComponentLifecycle.MountType;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Size;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: transliterator_back_pressed */
public final class Progress extends ComponentLifecycle {
    public static Progress f1260b = null;
    public static final SynchronizedPool<Builder> f1261c = new SynchronizedPool(2);
    private final ProgressSpec f1262d = new ProgressSpec();

    /* compiled from: transliterator_back_pressed */
    public class Builder extends com.facebook.components.Component.Builder<Progress> {
        State f1259a;

        public static void m1341a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f1259a = state;
        }

        public final Component<Progress> m1343d() {
            State state = this.f1259a;
            m1342a();
            return state;
        }

        protected final void m1342a() {
            super.a();
            this.f1259a = null;
            Progress.f1261c.a(this);
        }
    }

    /* compiled from: transliterator_back_pressed */
    public class State extends Component<Progress> implements Cloneable {
        public State() {
            super(Progress.m1345j());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.b == ((State) obj).b ? true : true;
        }
    }

    private Progress() {
    }

    public static synchronized Progress m1345j() {
        Progress progress;
        synchronized (Progress.class) {
            if (f1260b == null) {
                f1260b = new Progress();
            }
            progress = f1260b;
        }
        return progress;
    }

    public final boolean m1351h() {
        return true;
    }

    protected final boolean m1348c() {
        return true;
    }

    protected final void m1346a(ComponentContext componentContext, InternalNode internalNode, int i, int i2, Size size, Component component) {
        ProgressSpec.m1353a(i, i2, size);
    }

    public final MountType m1350f() {
        return MountType.VIEW;
    }

    protected final Object m1349e(ComponentContext componentContext, Object obj, Component component) {
        return ProgressSpec.m1352a(componentContext, (ProgressBar) obj);
    }

    public final void m1347a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ Progress f1258c;

                public void run() {
                    this.f1258c.a(eventHandler, obj);
                }
            }, 919726383);
        }
    }

    public static Builder m1344a(ComponentContext componentContext) {
        State state = new State();
        Builder builder = (Builder) f1261c.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m1341a(builder, componentContext, 0, state);
        return builder;
    }
}

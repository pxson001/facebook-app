package com.facebook.components.widget;

import android.os.Looper;
import android.support.annotation.ColorRes;
import android.support.v4.util.Pools.SynchronizedPool;
import android.widget.ImageView.ScaleType;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.reference.ColorDrawableReference;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: transliteration_model_ */
public final class SolidColor extends ComponentLifecycle {
    public static SolidColor f1271b = null;
    public static final SynchronizedPool<Builder> f1272c = new SynchronizedPool(2);
    private final SolidColorSpec f1273d = new SolidColorSpec();

    /* compiled from: transliteration_model_ */
    public class Builder extends com.facebook.components.Component.Builder<SolidColor> {
        private static String[] f1266b = new String[]{"color"};
        private static int f1267c = 1;
        State f1268a;
        private BitSet f1269d = new BitSet(f1267c);

        public static void m1354a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f1268a = state;
            builder.f1269d.clear();
        }

        public final Builder m1357h(@ColorRes int i) {
            this.f1268a.f1270a = d(i);
            this.f1269d.set(0);
            return this;
        }

        public final Component<SolidColor> m1356d() {
            int i = 0;
            if (this.f1269d == null || this.f1269d.nextClearBit(0) >= f1267c) {
                State state = this.f1268a;
                m1355a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < f1267c) {
                if (!this.f1269d.get(i)) {
                    arrayList.add(f1266b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m1355a() {
            super.a();
            this.f1268a = null;
            SolidColor.f1272c.a(this);
        }
    }

    /* compiled from: transliteration_model_ */
    public class State extends Component<SolidColor> implements Cloneable {
        int f1270a;

        public State() {
            super(SolidColor.m1359j());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.b == state.b || this.f1270a == state.f1270a) {
                return true;
            }
            return false;
        }
    }

    private SolidColor() {
    }

    protected final InternalNode m1361b(ComponentContext componentContext, Component component) {
        return Image.a(componentContext).a(ScaleType.FIT_XY).a(ColorDrawableReference.a(componentContext).h(((State) component).f1270a).b()).b();
    }

    public static synchronized SolidColor m1359j() {
        SolidColor solidColor;
        synchronized (SolidColor.class) {
            if (f1271b == null) {
                f1271b = new SolidColor();
            }
            solidColor = f1271b;
        }
        return solidColor;
    }

    public final void m1360a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ SolidColor f1265c;

                public void run() {
                    this.f1265c.a(eventHandler, obj);
                }
            }, 1512134156);
        }
    }

    public static Builder m1358a(ComponentContext componentContext) {
        State state = new State();
        Builder builder = (Builder) f1272c.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m1354a(builder, componentContext, 0, state);
        return builder;
    }
}

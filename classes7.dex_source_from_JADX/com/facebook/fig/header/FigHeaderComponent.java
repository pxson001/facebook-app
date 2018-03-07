package com.facebook.fig.header;

import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.Container;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Layout;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: SEND_INVITE_ALL */
public final class FigHeaderComponent extends ComponentLifecycle {
    public static FigHeaderComponent f23867b = null;
    public static final SynchronizedPool<Builder> f23868c = new SynchronizedPool(2);
    private final FigHeaderComponentSpec f23869d = new FigHeaderComponentSpec();

    /* compiled from: SEND_INVITE_ALL */
    public class Builder extends com.facebook.components.Component.Builder<FigHeaderComponent> {
        private static String[] f23860b = new String[]{"middleComponent"};
        private static int f23861c = 1;
        public State f23862a;
        public BitSet f23863d = new BitSet(f23861c);

        public static void m26000a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f23862a = state;
            builder.f23863d.clear();
        }

        public final Component<FigHeaderComponent> m26002d() {
            int i = 0;
            if (this.f23863d == null || this.f23863d.nextClearBit(0) >= f23861c) {
                State state = this.f23862a;
                m26001a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < f23861c) {
                if (!this.f23863d.get(i)) {
                    arrayList.add(f23860b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m26001a() {
            super.a();
            this.f23862a = null;
            FigHeaderComponent.f23868c.a(this);
        }
    }

    /* compiled from: SEND_INVITE_ALL */
    public class State extends Component<FigHeaderComponent> implements Cloneable {
        public Component<?> f23864a;
        public Component<?> f23865b;
        public Component<?> f23866c;

        public State() {
            super(FigHeaderComponent.m26003j());
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
            if (this.f23864a == null ? state.f23864a != null : !this.f23864a.equals(state.f23864a)) {
                return false;
            }
            if (this.f23865b == null ? state.f23865b != null : !this.f23865b.equals(state.f23865b)) {
                return false;
            }
            if (this.f23866c != null) {
                if (this.f23866c.equals(state.f23866c)) {
                    return true;
                }
            } else if (state.f23866c == null) {
                return true;
            }
            return false;
        }
    }

    private FigHeaderComponent() {
    }

    public static synchronized FigHeaderComponent m26003j() {
        FigHeaderComponent figHeaderComponent;
        synchronized (FigHeaderComponent.class) {
            if (f23867b == null) {
                f23867b = new FigHeaderComponent();
            }
            figHeaderComponent = f23867b;
        }
        return figHeaderComponent;
    }

    protected final InternalNode m26005b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        Component component2 = state.f23864a;
        return Container.a(componentContext).C(2).E(1).a(component2 == null ? null : Layout.a(componentContext, component2).l(2131427599).p(2131427598).g(6, 2131427596).g(1, 2131427595).g(7, 2131427597).g(3, 2131427591)).a(Layout.a(componentContext, state.f23865b).g(1, 2131427605).c(7, 2131427602).a(1.0f)).a(state.f23866c).j();
    }

    public final void m26004a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ FigHeaderComponent f23859c;

                public void run() {
                    this.f23859c.a(eventHandler, obj);
                }
            }, 811628687);
        }
    }
}

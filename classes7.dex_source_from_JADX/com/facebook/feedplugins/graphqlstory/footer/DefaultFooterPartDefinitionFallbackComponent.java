package com.facebook.feedplugins.graphqlstory.footer;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.view.View;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.ComponentLifecycle.MountType;
import com.facebook.components.ComponentsPools;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Output;
import com.facebook.components.Size;
import com.facebook.components.ThreadUtils;
import com.facebook.components.fallback.FallbackViewCreator;
import com.facebook.feedplugins.base.footer.ui.DefaultFooterView;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.renderers.SimpleRenderer;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: SouvenirVideoItem.serialize */
public final class DefaultFooterPartDefinitionFallbackComponent extends ComponentLifecycle {
    public static DefaultFooterPartDefinitionFallbackComponent f23192b = null;
    public static final SynchronizedPool<Builder> f23193c = new SynchronizedPool(2);
    private final DefaultFooterPartDefinitionFallbackComponentSpec f23194d = new DefaultFooterPartDefinitionFallbackComponentSpec();

    /* compiled from: SouvenirVideoItem.serialize */
    public class Builder extends com.facebook.components.Component.Builder<DefaultFooterPartDefinitionFallbackComponent> {
        private static String[] f23183b = new String[]{"partDefinition", "environment", "partDefinitionProps", "fallbackViewCreator"};
        private static int f23184c = 4;
        public State f23185a;
        public BitSet f23186d = new BitSet(f23184c);

        public static void m25579a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f23185a = state;
            builder.f23186d.clear();
        }

        public final Component<DefaultFooterPartDefinitionFallbackComponent> m25581d() {
            int i = 0;
            if (this.f23186d == null || this.f23186d.nextClearBit(0) >= f23184c) {
                State state = this.f23185a;
                m25580a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < f23184c) {
                if (!this.f23186d.get(i)) {
                    arrayList.add(f23183b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m25580a() {
            super.a();
            this.f23185a = null;
            DefaultFooterPartDefinitionFallbackComponent.f23193c.a(this);
        }
    }

    /* compiled from: SouvenirVideoItem.serialize */
    public class State extends Component<DefaultFooterPartDefinitionFallbackComponent> implements Cloneable {
        public DefaultFooterPartDefinition f23187a;
        public AnyEnvironment f23188b;
        public Object f23189c;
        SimpleRenderer f23190d;
        public FallbackViewCreator<DefaultFooterView> f23191e;

        public State() {
            super(DefaultFooterPartDefinitionFallbackComponent.m25583j());
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
            if (this.f23187a == null ? state.f23187a != null : !this.f23187a.equals(state.f23187a)) {
                return false;
            }
            if (this.f23188b == null ? state.f23188b != null : !this.f23188b.equals(state.f23188b)) {
                return false;
            }
            if (this.f23189c == null ? state.f23189c != null : !this.f23189c.equals(state.f23189c)) {
                return false;
            }
            if (this.f23191e != null) {
                if (this.f23191e.equals(state.f23191e)) {
                    return true;
                }
            } else if (state.f23191e == null) {
                return true;
            }
            return false;
        }

        protected final void m25582a(Component<DefaultFooterPartDefinitionFallbackComponent> component) {
            this.f23190d = ((State) component).f23190d;
        }
    }

    private DefaultFooterPartDefinitionFallbackComponent() {
    }

    public static synchronized DefaultFooterPartDefinitionFallbackComponent m25583j() {
        DefaultFooterPartDefinitionFallbackComponent defaultFooterPartDefinitionFallbackComponent;
        synchronized (DefaultFooterPartDefinitionFallbackComponent.class) {
            if (f23192b == null) {
                f23192b = new DefaultFooterPartDefinitionFallbackComponent();
            }
            defaultFooterPartDefinitionFallbackComponent = f23192b;
        }
        return defaultFooterPartDefinitionFallbackComponent;
    }

    protected final void m25586c(ComponentContext componentContext, Component component) {
        State state = (State) component;
        Output c = ComponentsPools.c();
        DefaultFooterPartDefinition defaultFooterPartDefinition = state.f23187a;
        AnyEnvironment anyEnvironment = state.f23188b;
        Object obj = state.f23189c;
        ThreadUtils.b();
        SimpleRenderer simpleRenderer = new SimpleRenderer(defaultFooterPartDefinition, anyEnvironment);
        simpleRenderer.a(obj);
        c.a = simpleRenderer;
        if (c.a != null) {
            state.f23190d = (SimpleRenderer) c.a;
        }
        ComponentsPools.a(c);
    }

    protected final boolean m25587c() {
        return true;
    }

    protected final void m25584a(ComponentContext componentContext, InternalNode internalNode, int i, int i2, Size size, Component component) {
        State state = (State) component;
        DefaultFooterPartDefinitionFallbackComponentSpec.m25591a(componentContext, i, i2, size, state.f23191e, state.f23190d);
    }

    public final MountType m25589f() {
        return MountType.VIEW;
    }

    protected final Object m25588e(ComponentContext componentContext, Object obj, Component component) {
        View view;
        State state = (State) component;
        DefaultFooterView defaultFooterView = (DefaultFooterView) obj;
        FallbackViewCreator fallbackViewCreator = state.f23191e;
        SimpleRenderer simpleRenderer = state.f23190d;
        ThreadUtils.b();
        if (defaultFooterView == null) {
            view = (DefaultFooterView) fallbackViewCreator.mo1573a((Context) componentContext);
        } else {
            view = defaultFooterView;
        }
        if (simpleRenderer.b()) {
            simpleRenderer.a();
        }
        simpleRenderer.a(view);
        return view;
    }

    protected final void m25590f(ComponentContext componentContext, Object obj, Component component) {
        SimpleRenderer simpleRenderer = ((State) component).f23190d;
        ThreadUtils.b();
        if (simpleRenderer.b()) {
            simpleRenderer.a();
        }
    }

    public final void m25585a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ DefaultFooterPartDefinitionFallbackComponent f23182c;

                public void run() {
                    this.f23182c.a(eventHandler, obj);
                }
            }, -1438785608);
        }
    }
}

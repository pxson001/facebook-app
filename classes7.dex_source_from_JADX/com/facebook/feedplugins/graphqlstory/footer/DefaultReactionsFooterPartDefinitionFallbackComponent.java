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
import com.facebook.feedplugins.feedbackreactions.ui.ReactionsFooterView;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.renderers.SimpleRenderer;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: SouvenirPhotoItem.serialize */
public final class DefaultReactionsFooterPartDefinitionFallbackComponent extends ComponentLifecycle {
    public static DefaultReactionsFooterPartDefinitionFallbackComponent f23208b = null;
    public static final SynchronizedPool<Builder> f23209c = new SynchronizedPool(2);
    private final DefaultReactionsFooterPartDefinitionFallbackComponentSpec f23210d = new DefaultReactionsFooterPartDefinitionFallbackComponentSpec();

    /* compiled from: SouvenirPhotoItem.serialize */
    public class Builder extends com.facebook.components.Component.Builder<DefaultReactionsFooterPartDefinitionFallbackComponent> {
        private static String[] f23199b = new String[]{"partDefinition", "environment", "partDefinitionProps", "fallbackViewCreator"};
        private static int f23200c = 4;
        public State f23201a;
        public BitSet f23202d = new BitSet(f23200c);

        public static void m25592a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f23201a = state;
            builder.f23202d.clear();
        }

        public final Component<DefaultReactionsFooterPartDefinitionFallbackComponent> m25594d() {
            int i = 0;
            if (this.f23202d == null || this.f23202d.nextClearBit(0) >= f23200c) {
                State state = this.f23201a;
                m25593a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < f23200c) {
                if (!this.f23202d.get(i)) {
                    arrayList.add(f23199b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m25593a() {
            super.a();
            this.f23201a = null;
            DefaultReactionsFooterPartDefinitionFallbackComponent.f23209c.a(this);
        }
    }

    /* compiled from: SouvenirPhotoItem.serialize */
    public class State extends Component<DefaultReactionsFooterPartDefinitionFallbackComponent> implements Cloneable {
        public DefaultReactionsFooterPartDefinition f23203a;
        public AnyEnvironment f23204b;
        public Object f23205c;
        SimpleRenderer f23206d;
        public FallbackViewCreator<ReactionsFooterView> f23207e;

        public State() {
            super(DefaultReactionsFooterPartDefinitionFallbackComponent.m25596j());
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
            if (this.f23203a == null ? state.f23203a != null : !this.f23203a.equals(state.f23203a)) {
                return false;
            }
            if (this.f23204b == null ? state.f23204b != null : !this.f23204b.equals(state.f23204b)) {
                return false;
            }
            if (this.f23205c == null ? state.f23205c != null : !this.f23205c.equals(state.f23205c)) {
                return false;
            }
            if (this.f23207e != null) {
                if (this.f23207e.equals(state.f23207e)) {
                    return true;
                }
            } else if (state.f23207e == null) {
                return true;
            }
            return false;
        }

        protected final void m25595a(Component<DefaultReactionsFooterPartDefinitionFallbackComponent> component) {
            this.f23206d = ((State) component).f23206d;
        }
    }

    private DefaultReactionsFooterPartDefinitionFallbackComponent() {
    }

    public static synchronized DefaultReactionsFooterPartDefinitionFallbackComponent m25596j() {
        DefaultReactionsFooterPartDefinitionFallbackComponent defaultReactionsFooterPartDefinitionFallbackComponent;
        synchronized (DefaultReactionsFooterPartDefinitionFallbackComponent.class) {
            if (f23208b == null) {
                f23208b = new DefaultReactionsFooterPartDefinitionFallbackComponent();
            }
            defaultReactionsFooterPartDefinitionFallbackComponent = f23208b;
        }
        return defaultReactionsFooterPartDefinitionFallbackComponent;
    }

    protected final void m25599c(ComponentContext componentContext, Component component) {
        State state = (State) component;
        Output c = ComponentsPools.c();
        DefaultReactionsFooterPartDefinition defaultReactionsFooterPartDefinition = state.f23203a;
        AnyEnvironment anyEnvironment = state.f23204b;
        Object obj = state.f23205c;
        ThreadUtils.b();
        SimpleRenderer simpleRenderer = new SimpleRenderer(defaultReactionsFooterPartDefinition, anyEnvironment);
        simpleRenderer.a(obj);
        c.a = simpleRenderer;
        if (c.a != null) {
            state.f23206d = (SimpleRenderer) c.a;
        }
        ComponentsPools.a(c);
    }

    protected final boolean m25600c() {
        return true;
    }

    protected final void m25597a(ComponentContext componentContext, InternalNode internalNode, int i, int i2, Size size, Component component) {
        State state = (State) component;
        DefaultReactionsFooterPartDefinitionFallbackComponentSpec.m25604a(componentContext, i, i2, size, state.f23207e, state.f23206d);
    }

    public final MountType m25602f() {
        return MountType.VIEW;
    }

    protected final Object m25601e(ComponentContext componentContext, Object obj, Component component) {
        View view;
        State state = (State) component;
        ReactionsFooterView reactionsFooterView = (ReactionsFooterView) obj;
        FallbackViewCreator fallbackViewCreator = state.f23207e;
        SimpleRenderer simpleRenderer = state.f23206d;
        ThreadUtils.b();
        if (reactionsFooterView == null) {
            view = (ReactionsFooterView) fallbackViewCreator.mo1573a((Context) componentContext);
        } else {
            view = reactionsFooterView;
        }
        if (simpleRenderer.b()) {
            simpleRenderer.a();
        }
        simpleRenderer.a(view);
        return view;
    }

    protected final void m25603f(ComponentContext componentContext, Object obj, Component component) {
        SimpleRenderer simpleRenderer = ((State) component).f23206d;
        ThreadUtils.b();
        if (simpleRenderer.b()) {
            simpleRenderer.a();
        }
    }

    public final void m25598a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ DefaultReactionsFooterPartDefinitionFallbackComponent f23198c;

                public void run() {
                    this.f23198c.a(eventHandler, obj);
                }
            }, -1226113215);
        }
    }
}

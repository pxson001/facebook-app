package com.facebook.feedplugins.video;

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
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.renderers.SimpleRenderer;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

/* compiled from: footer_elements */
public final class RichVideoRowPartDefinitionFallbackComponent extends ComponentLifecycle {
    public static RichVideoRowPartDefinitionFallbackComponent f13102b = null;
    public static final SynchronizedPool<Builder> f13103c = new SynchronizedPool(2);
    private final RichVideoRowPartDefinitionFallbackComponentSpec f13104d = new RichVideoRowPartDefinitionFallbackComponentSpec();

    /* compiled from: footer_elements */
    public class Builder extends com.facebook.components.Component.Builder<RichVideoRowPartDefinitionFallbackComponent> {
        private static String[] f13093b = new String[]{"partDefinition", "environment", "partDefinitionProps", "fallbackViewCreator"};
        private static int f13094c = 4;
        public State f13095a;
        public BitSet f13096d = new BitSet(f13094c);

        public static void m14756a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f13095a = state;
            builder.f13096d.clear();
        }

        public final Component<RichVideoRowPartDefinitionFallbackComponent> m14758d() {
            int i = 0;
            if (this.f13096d == null || this.f13096d.nextClearBit(0) >= f13094c) {
                State state = this.f13095a;
                m14757a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < f13094c) {
                if (!this.f13096d.get(i)) {
                    arrayList.add(f13093b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m14757a() {
            super.a();
            this.f13095a = null;
            RichVideoRowPartDefinitionFallbackComponent.f13103c.a(this);
        }
    }

    /* compiled from: footer_elements */
    public class State extends Component<RichVideoRowPartDefinitionFallbackComponent> implements Cloneable {
        public RichVideoRowPartDefinition f13097a;
        public AnyEnvironment f13098b;
        public Object f13099c;
        SimpleRenderer f13100d;
        public FallbackViewCreator<RichVideoAttachmentView> f13101e;

        public State() {
            super(RichVideoRowPartDefinitionFallbackComponent.m14760j());
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
            if (this.f13097a == null ? state.f13097a != null : !this.f13097a.equals(state.f13097a)) {
                return false;
            }
            if (this.f13098b == null ? state.f13098b != null : !this.f13098b.equals(state.f13098b)) {
                return false;
            }
            if (this.f13099c == null ? state.f13099c != null : !this.f13099c.equals(state.f13099c)) {
                return false;
            }
            if (this.f13101e != null) {
                if (this.f13101e.equals(state.f13101e)) {
                    return true;
                }
            } else if (state.f13101e == null) {
                return true;
            }
            return false;
        }

        protected final void m14759a(Component<RichVideoRowPartDefinitionFallbackComponent> component) {
            this.f13100d = ((State) component).f13100d;
        }
    }

    private RichVideoRowPartDefinitionFallbackComponent() {
    }

    public static synchronized RichVideoRowPartDefinitionFallbackComponent m14760j() {
        RichVideoRowPartDefinitionFallbackComponent richVideoRowPartDefinitionFallbackComponent;
        synchronized (RichVideoRowPartDefinitionFallbackComponent.class) {
            if (f13102b == null) {
                f13102b = new RichVideoRowPartDefinitionFallbackComponent();
            }
            richVideoRowPartDefinitionFallbackComponent = f13102b;
        }
        return richVideoRowPartDefinitionFallbackComponent;
    }

    protected final void m14763c(ComponentContext componentContext, Component component) {
        State state = (State) component;
        Output c = ComponentsPools.c();
        RichVideoRowPartDefinition richVideoRowPartDefinition = state.f13097a;
        AnyEnvironment anyEnvironment = state.f13098b;
        Object obj = state.f13099c;
        ThreadUtils.b();
        SimpleRenderer simpleRenderer = new SimpleRenderer(richVideoRowPartDefinition, anyEnvironment);
        simpleRenderer.a(obj);
        c.a = simpleRenderer;
        if (c.a != null) {
            state.f13100d = (SimpleRenderer) c.a;
        }
        ComponentsPools.a(c);
    }

    protected final boolean m14764c() {
        return true;
    }

    protected final void m14761a(ComponentContext componentContext, InternalNode internalNode, int i, int i2, Size size, Component component) {
        State state = (State) component;
        RichVideoRowPartDefinitionFallbackComponentSpec.m14768a(componentContext, i, i2, size, state.f13101e, state.f13100d);
    }

    public final MountType m14766f() {
        return MountType.VIEW;
    }

    protected final Object m14765e(ComponentContext componentContext, Object obj, Component component) {
        View view;
        State state = (State) component;
        RichVideoAttachmentView richVideoAttachmentView = (RichVideoAttachmentView) obj;
        FallbackViewCreator fallbackViewCreator = state.f13101e;
        SimpleRenderer simpleRenderer = state.f13100d;
        ThreadUtils.b();
        if (richVideoAttachmentView == null) {
            view = (RichVideoAttachmentView) fallbackViewCreator.a(componentContext);
        } else {
            view = richVideoAttachmentView;
        }
        if (simpleRenderer.b()) {
            simpleRenderer.a();
        }
        simpleRenderer.a(view);
        return view;
    }

    protected final void m14767f(ComponentContext componentContext, Object obj, Component component) {
        SimpleRenderer simpleRenderer = ((State) component).f13100d;
        ThreadUtils.b();
        if (simpleRenderer.b()) {
            simpleRenderer.a();
        }
    }

    public final void m14762a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ RichVideoRowPartDefinitionFallbackComponent f13092c;

                public void run() {
                    this.f13092c.a(eventHandler, obj);
                }
            }, -614546013);
        }
    }
}

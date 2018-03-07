package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.text.Layout;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.ComponentLifecycle.MountType;
import com.facebook.components.ComponentsPools;
import com.facebook.components.Diff;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Output;
import com.facebook.components.Size;
import com.facebook.components.widget.TextDrawable;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ignoring weigher specified without maximumWeight */
public class HeaderSubtitleComponent extends ComponentLifecycle {
    public static final Pools$SynchronizedPool<Builder> f20547b = new Pools$SynchronizedPool(2);
    private static HeaderSubtitleComponent f20548d;
    private static final Object f20549e = new Object();
    private final HeaderSubtitleComponentSpec f20550c;

    /* compiled from: ignoring weigher specified without maximumWeight */
    public class State extends Component<HeaderSubtitleComponent> implements Cloneable {
        public FeedProps<GraphQLStory> f22944a;
        CharSequence f22945b;
        Layout f22946c;
        ClickableSpan[] f22947d;
        CharSequence f22948e;
        Layout f22949f;
        ClickableSpan[] f22950g;
        final /* synthetic */ HeaderSubtitleComponent f22951h;

        public State(HeaderSubtitleComponent headerSubtitleComponent) {
            this.f22951h = headerSubtitleComponent;
            super(headerSubtitleComponent);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            State state = (State) obj;
            if (this.f22588b == state.f22588b) {
                return true;
            }
            if (this.f22944a != null) {
                if (this.f22944a.equals(state.f22944a)) {
                    return true;
                }
            } else if (state.f22944a == null) {
                return true;
            }
            return false;
        }

        protected final void mo3374a(Component<HeaderSubtitleComponent> component) {
            State state = (State) component;
            this.f22945b = state.f22945b;
            this.f22946c = state.f22946c;
            this.f22947d = state.f22947d;
            this.f22948e = state.f22948e;
            this.f22949f = state.f22949f;
            this.f22950g = state.f22950g;
        }
    }

    /* compiled from: ignoring weigher specified without maximumWeight */
    public class Builder extends com.facebook.components.Component.Builder<HeaderSubtitleComponent> {
        public State f22952a;
        private String[] f22953b = new String[]{"storyProps"};
        private int f22954c = 1;
        public BitSet f22955d = new BitSet(this.f22954c);

        public static void m31063a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.m30661a(componentContext, i, state);
            builder.f22952a = state;
            builder.f22955d.clear();
        }

        public final Component<HeaderSubtitleComponent> mo3296d() {
            int i = 0;
            if (this.f22955d == null || this.f22955d.nextClearBit(0) >= this.f22954c) {
                Component component = this.f22952a;
                mo3295a();
                return component;
            }
            List arrayList = new ArrayList();
            while (i < this.f22954c) {
                if (!this.f22955d.get(i)) {
                    arrayList.add(this.f22953b[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void mo3295a() {
            super.mo3295a();
            this.f22952a = null;
            HeaderSubtitleComponent.f20547b.mo741a(this);
        }
    }

    private static HeaderSubtitleComponent m28275b(InjectorLike injectorLike) {
        return new HeaderSubtitleComponent(HeaderSubtitleComponentSpec.m28287a(injectorLike));
    }

    @Inject
    public HeaderSubtitleComponent(HeaderSubtitleComponentSpec headerSubtitleComponentSpec) {
        this.f20550c = headerSubtitleComponentSpec;
    }

    public static HeaderSubtitleComponent m28274a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderSubtitleComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20549e) {
                HeaderSubtitleComponent headerSubtitleComponent;
                if (a2 != null) {
                    headerSubtitleComponent = (HeaderSubtitleComponent) a2.mo818a(f20549e);
                } else {
                    headerSubtitleComponent = f20548d;
                }
                if (headerSubtitleComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28275b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20549e, b3);
                        } else {
                            f20548d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerSubtitleComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    protected final boolean mo3144c() {
        return true;
    }

    protected final void mo3141a(ComponentContext componentContext, InternalNode internalNode, int i, int i2, Size size, Component component) {
        State state = (State) component;
        Output c = ComponentsPools.m30528c();
        Output c2 = ComponentsPools.m30528c();
        Output c3 = ComponentsPools.m30528c();
        this.f20550c.m28291a(componentContext, i, i2, size, state.f22944a, c, c2, c3);
        if (c.m31109a() != null) {
            state.f22945b = (CharSequence) c.m31109a();
        }
        ComponentsPools.m30526a(c);
        if (c2.m31109a() != null) {
            state.f22946c = (Layout) c2.m31109a();
        }
        ComponentsPools.m30526a(c2);
        if (c3.m31109a() != null) {
            state.f22947d = (ClickableSpan[]) c3.m31109a();
        }
        ComponentsPools.m30526a(c3);
    }

    protected final void mo3142a(ComponentContext componentContext, InternalNode internalNode, Component component) {
        State state = (State) component;
        Output c = ComponentsPools.m30528c();
        Output c2 = ComponentsPools.m30528c();
        Output c3 = ComponentsPools.m30528c();
        this.f20550c.m28292a(componentContext, internalNode, state.f22944a, state.f22945b, state.f22946c, state.f22947d, c, c2, c3);
        if (c.f22989a != null) {
            state.f22948e = (CharSequence) c.f22989a;
        }
        ComponentsPools.m30526a(c);
        if (c2.f22989a != null) {
            state.f22949f = (Layout) c2.f22989a;
        }
        ComponentsPools.m30526a(c2);
        if (c3.f22989a != null) {
            state.f22950g = (ClickableSpan[]) c3.f22989a;
        }
        ComponentsPools.m30526a(c3);
    }

    public final MountType mo3146f() {
        return MountType.DRAWABLE;
    }

    protected final Object mo3145e(ComponentContext componentContext, Object obj, Component component) {
        State state = (State) component;
        return HeaderSubtitleComponentSpec.m28286a((TextDrawable) obj, state.f22948e, state.f22949f, state.f22950g);
    }

    protected final void mo3140a(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, Component component) {
        CharSequence charSequence = ((State) component).f22948e;
        if (!TextUtils.isEmpty(charSequence)) {
            accessibilityNodeInfoCompat.c(charSequence);
        }
    }

    public final boolean mo3147g() {
        return true;
    }

    public final boolean mo3148h() {
        return true;
    }

    public final boolean mo3143b(Component component, Component component2) {
        Diff a = ComponentLifecycle.m28111a(((State) component).f22944a, ((State) component2).f22944a);
        boolean a2 = this.f20550c.m28293a(a);
        ComponentsPools.m30523a(a);
        return a2;
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 763749135);
        }
    }
}

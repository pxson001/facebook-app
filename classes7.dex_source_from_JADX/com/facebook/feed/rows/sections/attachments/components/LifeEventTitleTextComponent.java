package com.facebook.feed.rows.sections.attachments.components;

import android.content.Context;
import android.os.Looper;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.v4.util.Pools.SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLTextWithEntities;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ufiservices.flyout.FlyoutClickSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: Viewing_Comments */
public class LifeEventTitleTextComponent<E extends HasInvalidate & HasPersistentState> extends ComponentLifecycle {
    private static LifeEventTitleTextComponent f20948d;
    private static final Object f20949e = new Object();
    private final LifeEventTitleTextComponentSpec f20950b;
    public final SynchronizedPool<Builder> f20951c = new SynchronizedPool(2);

    /* compiled from: Viewing_Comments */
    public class Builder extends com.facebook.components.Component.Builder<LifeEventTitleTextComponent> {
        public State f20934a;
        final /* synthetic */ LifeEventTitleTextComponent f20935b;
        private String[] f20936c = new String[]{"attachmentProps", "storyProps", "environment", "text", "flyoutClickSource", "propertiesMapKey", "textSize", "textColor"};
        private int f20937d = 8;
        public BitSet f20938e = new BitSet(this.f20937d);

        public Builder(LifeEventTitleTextComponent lifeEventTitleTextComponent) {
            this.f20935b = lifeEventTitleTextComponent;
        }

        public static void m23853a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f20934a = state;
            builder.f20938e.clear();
        }

        public final Builder m23855a(FeedProps<GraphQLStoryAttachment> feedProps) {
            this.f20934a.f20939a = feedProps;
            this.f20938e.set(0);
            return this;
        }

        public final Builder m23860b(FeedProps<GraphQLStory> feedProps) {
            this.f20934a.f20940b = feedProps;
            this.f20938e.set(1);
            return this;
        }

        public final Builder m23854a(E e) {
            this.f20934a.f20941c = e;
            this.f20938e.set(2);
            return this;
        }

        public final Builder m23856a(GraphQLTextWithEntities graphQLTextWithEntities) {
            this.f20934a.f20942d = graphQLTextWithEntities;
            this.f20938e.set(3);
            return this;
        }

        public final Builder m23857a(FlyoutClickSource flyoutClickSource) {
            this.f20934a.f20943e = flyoutClickSource;
            this.f20938e.set(4);
            return this;
        }

        public final Builder m23858a(String str) {
            this.f20934a.f20944f = str;
            this.f20938e.set(5);
            return this;
        }

        public final Builder m23862h(@DimenRes int i) {
            this.f20934a.f20945g = e(i);
            this.f20938e.set(6);
            return this;
        }

        public final Builder m23863j(@ColorRes int i) {
            this.f20934a.f20946h = d(i);
            this.f20938e.set(7);
            return this;
        }

        public final Component<LifeEventTitleTextComponent> m23861d() {
            int i = 0;
            if (this.f20938e == null || this.f20938e.nextClearBit(0) >= this.f20937d) {
                State state = this.f20934a;
                m23859a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f20937d) {
                if (!this.f20938e.get(i)) {
                    arrayList.add(this.f20936c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m23859a() {
            super.a();
            this.f20934a = null;
            this.f20935b.f20951c.a(this);
        }
    }

    /* compiled from: Viewing_Comments */
    public class State extends Component<LifeEventTitleTextComponent> implements Cloneable {
        FeedProps<GraphQLStoryAttachment> f20939a;
        FeedProps<GraphQLStory> f20940b;
        E f20941c;
        GraphQLTextWithEntities f20942d;
        FlyoutClickSource f20943e;
        String f20944f;
        int f20945g;
        public int f20946h;
        final /* synthetic */ LifeEventTitleTextComponent f20947i;

        public State(LifeEventTitleTextComponent lifeEventTitleTextComponent) {
            this.f20947i = lifeEventTitleTextComponent;
            super(lifeEventTitleTextComponent);
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
            if (this.f20939a == null ? state.f20939a != null : !this.f20939a.equals(state.f20939a)) {
                return false;
            }
            if (this.f20940b == null ? state.f20940b != null : !this.f20940b.equals(state.f20940b)) {
                return false;
            }
            if (this.f20941c == null ? state.f20941c != null : !this.f20941c.equals(state.f20941c)) {
                return false;
            }
            if (this.f20942d == null ? state.f20942d != null : !this.f20942d.equals(state.f20942d)) {
                return false;
            }
            if (this.f20943e == null ? state.f20943e != null : !this.f20943e.equals(state.f20943e)) {
                return false;
            }
            if (this.f20944f == null ? state.f20944f != null : !this.f20944f.equals(state.f20944f)) {
                return false;
            }
            if (this.f20945g != state.f20945g) {
                return false;
            }
            if (this.f20946h != state.f20946h) {
                return false;
            }
            return true;
        }
    }

    private static LifeEventTitleTextComponent m23865b(InjectorLike injectorLike) {
        return new LifeEventTitleTextComponent(LifeEventTitleTextComponentSpec.m23869a(injectorLike));
    }

    public static LifeEventTitleTextComponent m23864a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            LifeEventTitleTextComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f20949e) {
                LifeEventTitleTextComponent lifeEventTitleTextComponent;
                if (a2 != null) {
                    lifeEventTitleTextComponent = (LifeEventTitleTextComponent) a2.a(f20949e);
                } else {
                    lifeEventTitleTextComponent = f20948d;
                }
                if (lifeEventTitleTextComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23865b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f20949e, b3);
                        } else {
                            f20948d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = lifeEventTitleTextComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    @Inject
    public LifeEventTitleTextComponent(LifeEventTitleTextComponentSpec lifeEventTitleTextComponentSpec) {
        this.f20950b = lifeEventTitleTextComponentSpec;
    }

    public final Builder m23866a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f20951c.a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.m23853a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode m23868b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20950b.m23871a(componentContext, state.f20939a, state.f20940b, state.f20941c, state.f20942d, state.f20943e, state.f20944f, state.f20945g, state.f20946h);
    }

    public final void m23867a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ LifeEventTitleTextComponent f20933c;

                public void run() {
                    this.f20933c.a(eventHandler, obj);
                }
            }, 2113722615);
        }
    }
}

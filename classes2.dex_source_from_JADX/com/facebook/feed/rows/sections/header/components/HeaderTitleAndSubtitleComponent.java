package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools$SynchronizedPool;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasFeedListType;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.feed.environment.HasRowKey;
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
/* compiled from: image/webp */
public class HeaderTitleAndSubtitleComponent<E extends HasContext & HasFeedListType & HasInvalidate & HasPersistentState & HasPrefetcher & HasRowKey> extends ComponentLifecycle {
    private static HeaderTitleAndSubtitleComponent f20501d;
    private static final Object f20502e = new Object();
    private final HeaderTitleAndSubtitleComponentSpec f20503b;
    public final Pools$SynchronizedPool<Builder> f20504c = new Pools$SynchronizedPool(2);

    /* compiled from: image/webp */
    public class State extends Component<HeaderTitleAndSubtitleComponent> implements Cloneable {
        FeedProps<GraphQLStory> f22882a;
        E f22883b;
        final /* synthetic */ HeaderTitleAndSubtitleComponent f22884c;

        public State(HeaderTitleAndSubtitleComponent headerTitleAndSubtitleComponent) {
            this.f22884c = headerTitleAndSubtitleComponent;
            super(headerTitleAndSubtitleComponent);
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
            if (this.f22882a == null ? state.f22882a != null : !this.f22882a.equals(state.f22882a)) {
                return false;
            }
            if (this.f22883b != null) {
                if (this.f22883b.equals(state.f22883b)) {
                    return true;
                }
            } else if (state.f22883b == null) {
                return true;
            }
            return false;
        }
    }

    /* compiled from: image/webp */
    public class Builder extends com.facebook.components.Component.Builder<HeaderTitleAndSubtitleComponent> {
        State f22885a;
        final /* synthetic */ HeaderTitleAndSubtitleComponent f22886b;
        private String[] f22887c = new String[]{"storyProps", "environment"};
        private int f22888d = 2;
        private BitSet f22889e = new BitSet(this.f22888d);

        public Builder(HeaderTitleAndSubtitleComponent headerTitleAndSubtitleComponent) {
            this.f22886b = headerTitleAndSubtitleComponent;
        }

        public static void m31001a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.m30661a(componentContext, i, state);
            builder.f22885a = state;
            builder.f22889e.clear();
        }

        public final Builder m31003a(FeedProps<GraphQLStory> feedProps) {
            this.f22885a.f22882a = feedProps;
            this.f22889e.set(0);
            return this;
        }

        public final Builder m31002a(E e) {
            this.f22885a.f22883b = e;
            this.f22889e.set(1);
            return this;
        }

        public final Component<HeaderTitleAndSubtitleComponent> mo3296d() {
            int i = 0;
            if (this.f22889e == null || this.f22889e.nextClearBit(0) >= this.f22888d) {
                Component component = this.f22885a;
                mo3295a();
                return component;
            }
            List arrayList = new ArrayList();
            while (i < this.f22888d) {
                if (!this.f22889e.get(i)) {
                    arrayList.add(this.f22887c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void mo3295a() {
            super.mo3295a();
            this.f22885a = null;
            this.f22886b.f20504c.mo741a(this);
        }
    }

    private static HeaderTitleAndSubtitleComponent m28243b(InjectorLike injectorLike) {
        return new HeaderTitleAndSubtitleComponent(HeaderTitleAndSubtitleComponentSpec.m28247a(injectorLike));
    }

    @Inject
    public HeaderTitleAndSubtitleComponent(HeaderTitleAndSubtitleComponentSpec headerTitleAndSubtitleComponentSpec) {
        this.f20503b = headerTitleAndSubtitleComponentSpec;
    }

    public static HeaderTitleAndSubtitleComponent m28242a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.m1499a();
        byte b = a.m1504b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().mo191b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            HeaderTitleAndSubtitleComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.m1330a(b2);
            synchronized (f20502e) {
                HeaderTitleAndSubtitleComponent headerTitleAndSubtitleComponent;
                if (a2 != null) {
                    headerTitleAndSubtitleComponent = (HeaderTitleAndSubtitleComponent) a2.mo818a(f20502e);
                } else {
                    headerTitleAndSubtitleComponent = f20501d;
                }
                if (headerTitleAndSubtitleComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.m1333a(b2, injectorThreadStack);
                    try {
                        b3 = m28243b(injectorThreadStack.m1474e());
                        if (a2 != null) {
                            a2.mo822a(f20502e, b3);
                        } else {
                            f20501d = b3;
                        }
                    } finally {
                        ContextScope.m1331a(injectorThreadStack);
                    }
                } else {
                    b3 = headerTitleAndSubtitleComponent;
                }
            }
            return b3;
        } finally {
            a.m1505c(b);
        }
    }

    public final Builder m28244a(ComponentContext componentContext) {
        State state = new State(this);
        Builder builder = (Builder) this.f20504c.mo740a();
        if (builder == null) {
            builder = new Builder(this);
        }
        Builder.m31001a(builder, componentContext, 0, state);
        return builder;
    }

    protected final InternalNode mo3135b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        return this.f20503b.m28249a(componentContext, state.f22882a, state.f22883b);
    }

    public final void mo3134a(EventHandler eventHandler, Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.f20393a, new 1(this, eventHandler, obj), 976287492);
        }
    }
}

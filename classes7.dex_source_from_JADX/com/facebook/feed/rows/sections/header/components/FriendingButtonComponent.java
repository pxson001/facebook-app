package com.facebook.feed.rows.sections.header.components;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.widget.Image;
import com.facebook.feed.environment.CanFriendPerson;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.header.FriendingButtonPartDefinition;
import com.facebook.friends.ui.FriendingButtonModel;
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
/* compiled from: Universal Feedback Completed! */
public class FriendingButtonComponent<E extends CanFriendPerson & HasInvalidate & HasPersistentState> extends ComponentLifecycle {
    private static FriendingButtonComponent f21304d;
    private static final Object f21305e = new Object();
    private final FriendingButtonComponentSpec f21306b;
    public final SynchronizedPool<Builder> f21307c = new SynchronizedPool(2);

    /* compiled from: Universal Feedback Completed! */
    public class Builder extends com.facebook.components.Component.Builder<FriendingButtonComponent> {
        public State f21295a;
        final /* synthetic */ FriendingButtonComponent f21296b;
        private String[] f21297c = new String[]{"friendingButtonModel", "storyProps", "environment"};
        private int f21298d = 3;
        public BitSet f21299e = new BitSet(this.f21298d);

        public Builder(FriendingButtonComponent friendingButtonComponent) {
            this.f21296b = friendingButtonComponent;
        }

        public static void m24068a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f21295a = state;
            builder.f21299e.clear();
        }

        public final Component<FriendingButtonComponent> m24070d() {
            int i = 0;
            if (this.f21299e == null || this.f21299e.nextClearBit(0) >= this.f21298d) {
                State state = this.f21295a;
                m24069a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f21298d) {
                if (!this.f21299e.get(i)) {
                    arrayList.add(this.f21297c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m24069a() {
            super.a();
            this.f21295a = null;
            this.f21296b.f21307c.a(this);
        }
    }

    /* compiled from: Universal Feedback Completed! */
    public class State extends Component<FriendingButtonComponent> implements Cloneable {
        public FriendingButtonModel f21300a;
        public FeedProps<GraphQLStory> f21301b;
        public E f21302c;
        final /* synthetic */ FriendingButtonComponent f21303d;

        public State(FriendingButtonComponent friendingButtonComponent) {
            this.f21303d = friendingButtonComponent;
            super(friendingButtonComponent);
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
            if (this.f21300a == null ? state.f21300a != null : !this.f21300a.equals(state.f21300a)) {
                return false;
            }
            if (this.f21301b == null ? state.f21301b != null : !this.f21301b.equals(state.f21301b)) {
                return false;
            }
            if (this.f21302c != null) {
                if (this.f21302c.equals(state.f21302c)) {
                    return true;
                }
            } else if (state.f21302c == null) {
                return true;
            }
            return false;
        }
    }

    private static FriendingButtonComponent m24073b(InjectorLike injectorLike) {
        return new FriendingButtonComponent(FriendingButtonComponentSpec.m24076a(injectorLike));
    }

    @Inject
    public FriendingButtonComponent(FriendingButtonComponentSpec friendingButtonComponentSpec) {
        this.f21306b = friendingButtonComponentSpec;
    }

    public static FriendingButtonComponent m24071a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            FriendingButtonComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f21305e) {
                FriendingButtonComponent friendingButtonComponent;
                if (a2 != null) {
                    friendingButtonComponent = (FriendingButtonComponent) a2.a(f21305e);
                } else {
                    friendingButtonComponent = f21304d;
                }
                if (friendingButtonComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24073b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f21305e, b3);
                        } else {
                            f21304d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = friendingButtonComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m24075b(ComponentContext componentContext, Component component) {
        FriendingButtonModel friendingButtonModel = ((State) component).f21300a;
        return Image.a(componentContext).h(friendingButtonModel.b()).c().t(friendingButtonModel.a()).a(ComponentLifecycle.a(componentContext, 1074322973, null)).j();
    }

    private void m24072a(View view, Component component) {
        State state = (State) component;
        FriendingButtonComponentSpec friendingButtonComponentSpec = this.f21306b;
        FriendingButtonPartDefinition.m24003a(state.f21301b, state.f21302c, friendingButtonComponentSpec.f21310a, friendingButtonComponentSpec.f21311b);
    }

    public final void m24074a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ FriendingButtonComponent f21294c;

                public void run() {
                    this.f21294c.a(eventHandler, obj);
                }
            }, -170654190);
            return;
        }
        switch (eventHandler.b) {
            case 1074322973:
                m24072a(((ClickEvent) obj).a, eventHandler.a);
                return;
            default:
                return;
        }
    }
}

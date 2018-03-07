package com.facebook.feedplugins.graphqlstory.translation;

import android.content.Context;
import android.os.Looper;
import android.support.v4.util.Pools.SynchronizedPool;
import android.view.View;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.ClickEvent;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLifecycle;
import com.facebook.components.ComponentsPools;
import com.facebook.components.EventHandler;
import com.facebook.components.InternalNode;
import com.facebook.components.Output;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.translation.TranslationMenuHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SavingStickeredPhoto_ */
public class AutoTranslationComponent<E extends HasPersistentState & HasInvalidate> extends ComponentLifecycle {
    private static AutoTranslationComponent f23424d;
    private static final Object f23425e = new Object();
    private final AutoTranslationComponentSpec f23426b;
    public final SynchronizedPool<Builder> f23427c = new SynchronizedPool(2);

    /* compiled from: SavingStickeredPhoto_ */
    public class Builder extends com.facebook.components.Component.Builder<AutoTranslationComponent> {
        public State f23415a;
        final /* synthetic */ AutoTranslationComponent f23416b;
        private String[] f23417c = new String[]{"props", "environment"};
        private int f23418d = 2;
        public BitSet f23419e = new BitSet(this.f23418d);

        public Builder(AutoTranslationComponent autoTranslationComponent) {
            this.f23416b = autoTranslationComponent;
        }

        public static void m25722a(Builder builder, ComponentContext componentContext, int i, State state) {
            super.a(componentContext, i, state);
            builder.f23415a = state;
            builder.f23419e.clear();
        }

        public final Component<AutoTranslationComponent> m25724d() {
            int i = 0;
            if (this.f23419e == null || this.f23419e.nextClearBit(0) >= this.f23418d) {
                State state = this.f23415a;
                m25723a();
                return state;
            }
            List arrayList = new ArrayList();
            while (i < this.f23418d) {
                if (!this.f23419e.get(i)) {
                    arrayList.add(this.f23417c[i]);
                }
                i++;
            }
            throw new IllegalStateException("The following props are not marked as optional and were not supplied: " + Arrays.toString(arrayList.toArray()));
        }

        protected final void m25723a() {
            super.a();
            this.f23415a = null;
            this.f23416b.f23427c.a(this);
        }
    }

    /* compiled from: SavingStickeredPhoto_ */
    public class State extends Component<AutoTranslationComponent> implements Cloneable {
        public FeedProps<GraphQLStory> f23420a;
        public E f23421b;
        TranslationMenuHelper f23422c;
        final /* synthetic */ AutoTranslationComponent f23423d;

        public State(AutoTranslationComponent autoTranslationComponent) {
            this.f23423d = autoTranslationComponent;
            super(autoTranslationComponent);
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
            if (this.f23420a == null ? state.f23420a != null : !this.f23420a.equals(state.f23420a)) {
                return false;
            }
            if (this.f23421b != null) {
                if (this.f23421b.equals(state.f23421b)) {
                    return true;
                }
            } else if (state.f23421b == null) {
                return true;
            }
            return false;
        }

        protected final void m25725a(Component<AutoTranslationComponent> component) {
            this.f23422c = ((State) component).f23422c;
        }
    }

    private static AutoTranslationComponent m25729b(InjectorLike injectorLike) {
        return new AutoTranslationComponent(AutoTranslationComponentSpec.m25736a(injectorLike));
    }

    @Inject
    public AutoTranslationComponent(AutoTranslationComponentSpec autoTranslationComponentSpec) {
        this.f23426b = autoTranslationComponentSpec;
    }

    public static AutoTranslationComponent m25726a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            AutoTranslationComponent b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f23425e) {
                AutoTranslationComponent autoTranslationComponent;
                if (a2 != null) {
                    autoTranslationComponent = (AutoTranslationComponent) a2.a(f23425e);
                } else {
                    autoTranslationComponent = f23424d;
                }
                if (autoTranslationComponent == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m25729b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f23425e, b3);
                        } else {
                            f23424d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = autoTranslationComponent;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    protected final InternalNode m25731b(ComponentContext componentContext, Component component) {
        State state = (State) component;
        Output c = ComponentsPools.c();
        InternalNode a = this.f23426b.m25740a(componentContext, state.f23420a, state.f23421b, c);
        if (c.a != null) {
            state.f23422c = (TranslationMenuHelper) c.a;
        }
        ComponentsPools.a(c);
        return a;
    }

    private void m25727a(View view, Component component) {
        ((State) component).f23422c.a(view);
    }

    public static EventHandler m25728b(ComponentContext componentContext) {
        return ComponentLifecycle.a(componentContext, 1280162859, null);
    }

    public final void m25730a(final EventHandler eventHandler, final Object obj) {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            HandlerDetour.a(ComponentLifecycle.a, new Runnable(this) {
                final /* synthetic */ AutoTranslationComponent f23414c;

                public void run() {
                    this.f23414c.a(eventHandler, obj);
                }
            }, 908363465);
            return;
        }
        switch (eventHandler.b) {
            case 1280162859:
                m25727a(((ClickEvent) obj).a, eventHandler.a);
                return;
            default:
                return;
        }
    }
}

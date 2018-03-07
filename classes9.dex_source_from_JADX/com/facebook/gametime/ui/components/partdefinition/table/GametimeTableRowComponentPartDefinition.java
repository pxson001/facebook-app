package com.facebook.gametime.ui.components.partdefinition.table;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.components.Component;
import com.facebook.components.ComponentContext;
import com.facebook.components.feed.ComponentPartDefinition;
import com.facebook.feed.environment.HasContext;
import com.facebook.feed.environment.HasPersistentState;
import com.facebook.feed.rows.core.analytics.HasIsAsync;
import com.facebook.gametime.ui.components.partdefinition.table.GametimeTableRowComponent.Builder;
import com.facebook.gametime.ui.components.partdefinition.table.GametimeTableRowComponent.State;
import com.facebook.graphql.model.interfaces.CacheableEntity;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.reaction.common.ReactionExperimentController;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;

@ContextScoped
/* compiled from: SubscriptionHandlersCollection */
public class GametimeTableRowComponentPartDefinition<E extends HasContext & HasIsAsync & HasPersistentState> extends ComponentPartDefinition<Props, E> {
    private static GametimeTableRowComponentPartDefinition f25272e;
    private static final Object f25273f = new Object();
    private final GametimeTableRowComponent f25274c;
    private final ReactionExperimentController f25275d;

    /* compiled from: SubscriptionHandlersCollection */
    public class Props {
        public final ImmutableList<String> f25268a;
        public final int[] f25269b;
        public final int f25270c;
        public final int f25271d;

        public Props(ImmutableList<String> immutableList, int[] iArr, int i, int i2) {
            this.f25268a = immutableList;
            this.f25269b = iArr;
            this.f25270c = i;
            this.f25271d = i2;
        }
    }

    private static GametimeTableRowComponentPartDefinition m27201b(InjectorLike injectorLike) {
        return new GametimeTableRowComponentPartDefinition((Context) injectorLike.getInstance(Context.class), GametimeTableRowComponent.m27195a(injectorLike), ReactionExperimentController.a(injectorLike));
    }

    public final boolean m27206a(Object obj) {
        Props props = (Props) obj;
        return !props.f25268a.isEmpty() && props.f25268a.size() == props.f25269b.length;
    }

    @Inject
    public GametimeTableRowComponentPartDefinition(Context context, GametimeTableRowComponent gametimeTableRowComponent, ReactionExperimentController reactionExperimentController) {
        super(context);
        this.f25274c = gametimeTableRowComponent;
        this.f25275d = reactionExperimentController;
    }

    public static GametimeTableRowComponentPartDefinition m27200a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            GametimeTableRowComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f25273f) {
                GametimeTableRowComponentPartDefinition gametimeTableRowComponentPartDefinition;
                if (a2 != null) {
                    gametimeTableRowComponentPartDefinition = (GametimeTableRowComponentPartDefinition) a2.a(f25273f);
                } else {
                    gametimeTableRowComponentPartDefinition = f25272e;
                }
                if (gametimeTableRowComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m27201b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f25273f, b3);
                        } else {
                            f25272e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = gametimeTableRowComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final boolean m27204a(E e) {
        return this.f25275d.d();
    }

    private Component<?> m27199a(ComponentContext componentContext, Props props) {
        State state = new State(this.f25274c);
        Builder builder = (Builder) GametimeTableRowComponent.f25265b.a();
        if (builder == null) {
            builder = new Builder();
        }
        Builder.m27192a(builder, componentContext, 0, state);
        Builder builder2 = builder;
        builder2.f25256a.f25260a = props.f25268a;
        builder2.f25259d.set(0);
        builder2 = builder2;
        builder2.f25256a.f25261b = props.f25269b;
        builder2.f25259d.set(1);
        builder2 = builder2;
        builder2.f25256a.f25262c = props.f25270c;
        builder2 = builder2;
        builder2.f25256a.f25263d = props.f25271d;
        return builder2.d();
    }

    public final CacheableEntity m27207b(Object obj) {
        return null;
    }
}

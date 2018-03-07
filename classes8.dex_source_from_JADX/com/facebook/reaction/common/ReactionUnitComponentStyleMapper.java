package com.facebook.reaction.common;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.graphql.enums.GraphQLReactionUnitComponentStyle;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.multirow.api.MultiRowPartWithIsNeeded;
import com.facebook.reaction.feed.unitcomponents.map.ReactionUnitComponentStyleMap;
import com.facebook.reaction.feed.unitcomponents.map.ReactionUnitComponentStyleMapImpl;
import com.facebook.reaction.protocol.components.ReactionComponentsGraphQLInterfaces.ReactionUnitComponentBaseFields;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

@ContextScoped
/* compiled from: block_id */
public class ReactionUnitComponentStyleMapper {
    private static ReactionUnitComponentStyleMapper f18865b;
    private static final Object f18866c = new Object();
    private final ReactionUnitComponentStyleMap f18867a;

    private static ReactionUnitComponentStyleMapper m22891b(InjectorLike injectorLike) {
        return new ReactionUnitComponentStyleMapper((ReactionUnitComponentStyleMap) ReactionUnitComponentStyleMapImpl.a(injectorLike));
    }

    @Inject
    public ReactionUnitComponentStyleMapper(ReactionUnitComponentStyleMap reactionUnitComponentStyleMap) {
        this.f18867a = reactionUnitComponentStyleMap;
    }

    public final MultiRowPartWithIsNeeded m22892a(GraphQLReactionUnitComponentStyle graphQLReactionUnitComponentStyle) {
        return this.f18867a.mo240a(graphQLReactionUnitComponentStyle);
    }

    public final boolean m22894a(@Nullable ReactionUnitComponentBaseFields reactionUnitComponentBaseFields) {
        return (reactionUnitComponentBaseFields == null || reactionUnitComponentBaseFields.a() == null || !this.f18867a.mo241a().contains(reactionUnitComponentBaseFields.a().name())) ? false : true;
    }

    public final ImmutableList<String> m22893a() {
        return this.f18867a.mo241a();
    }

    public static ReactionUnitComponentStyleMapper m22890a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionUnitComponentStyleMapper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f18866c) {
                ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper;
                if (a2 != null) {
                    reactionUnitComponentStyleMapper = (ReactionUnitComponentStyleMapper) a2.a(f18866c);
                } else {
                    reactionUnitComponentStyleMapper = f18865b;
                }
                if (reactionUnitComponentStyleMapper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22891b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f18866c, b3);
                        } else {
                            f18865b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionUnitComponentStyleMapper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

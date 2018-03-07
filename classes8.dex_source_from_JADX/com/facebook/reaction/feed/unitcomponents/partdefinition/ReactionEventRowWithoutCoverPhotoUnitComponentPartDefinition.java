package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.feed.environment.HasContext;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.reaction.feed.common.BasicReactionActionPartDefinition;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionAnalyticsParams;
import com.facebook.reaction.feed.environment.HasReactionInteractionTracker;
import com.facebook.reaction.feed.environment.HasReactionSession;
import javax.inject.Inject;

@ContextScoped
/* compiled from: alignParentBottom */
public class ReactionEventRowWithoutCoverPhotoUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession & HasReactionInteractionTracker> extends ReactionEventRowUnitComponentPartDefinition<E> {
    private static ReactionEventRowWithoutCoverPhotoUnitComponentPartDefinition f19643b;
    private static final Object f19644c = new Object();

    private static ReactionEventRowWithoutCoverPhotoUnitComponentPartDefinition m23566b(InjectorLike injectorLike) {
        return new ReactionEventRowWithoutCoverPhotoUnitComponentPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike));
    }

    @Inject
    public ReactionEventRowWithoutCoverPhotoUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition) {
        super(basicReactionActionPartDefinition);
    }

    public final boolean mo1123b() {
        return false;
    }

    public static ReactionEventRowWithoutCoverPhotoUnitComponentPartDefinition m23565a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionEventRowWithoutCoverPhotoUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19644c) {
                ReactionEventRowWithoutCoverPhotoUnitComponentPartDefinition reactionEventRowWithoutCoverPhotoUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionEventRowWithoutCoverPhotoUnitComponentPartDefinition = (ReactionEventRowWithoutCoverPhotoUnitComponentPartDefinition) a2.a(f19644c);
                } else {
                    reactionEventRowWithoutCoverPhotoUnitComponentPartDefinition = f19643b;
                }
                if (reactionEventRowWithoutCoverPhotoUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23566b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19644c, b3);
                        } else {
                            f19643b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionEventRowWithoutCoverPhotoUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

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
/* compiled from: alignParentLeft */
public class ReactionEventRowWithCoverPhotoUnitComponentPartDefinition<E extends CanLaunchReactionIntent & HasContext & HasReactionAnalyticsParams & HasReactionSession & HasReactionInteractionTracker> extends ReactionEventRowUnitComponentPartDefinition<E> {
    private static ReactionEventRowWithCoverPhotoUnitComponentPartDefinition f19641b;
    private static final Object f19642c = new Object();

    private static ReactionEventRowWithCoverPhotoUnitComponentPartDefinition m23563b(InjectorLike injectorLike) {
        return new ReactionEventRowWithCoverPhotoUnitComponentPartDefinition(BasicReactionActionPartDefinition.m22984a(injectorLike));
    }

    @Inject
    public ReactionEventRowWithCoverPhotoUnitComponentPartDefinition(BasicReactionActionPartDefinition basicReactionActionPartDefinition) {
        super(basicReactionActionPartDefinition);
    }

    public final boolean mo1123b() {
        return true;
    }

    public static ReactionEventRowWithCoverPhotoUnitComponentPartDefinition m23562a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionEventRowWithCoverPhotoUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19642c) {
                ReactionEventRowWithCoverPhotoUnitComponentPartDefinition reactionEventRowWithCoverPhotoUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionEventRowWithCoverPhotoUnitComponentPartDefinition = (ReactionEventRowWithCoverPhotoUnitComponentPartDefinition) a2.a(f19642c);
                } else {
                    reactionEventRowWithCoverPhotoUnitComponentPartDefinition = f19641b;
                }
                if (reactionEventRowWithCoverPhotoUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23563b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19642c, b3);
                        } else {
                            f19641b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionEventRowWithCoverPhotoUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

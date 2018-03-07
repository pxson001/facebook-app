package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.content.Context;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.reaction.action.ReactionIntentFactory;
import javax.inject.Inject;

@ContextScoped
/* compiled from: ad_choices_link_url */
public class ReactionPhotoZeroAspectRatioUnitComponentPartDefinition extends ReactionPhotoUnitComponentPartDefinition {
    private static ReactionPhotoZeroAspectRatioUnitComponentPartDefinition f19956b;
    private static final Object f19957c = new Object();

    private static ReactionPhotoZeroAspectRatioUnitComponentPartDefinition m23844b(InjectorLike injectorLike) {
        return new ReactionPhotoZeroAspectRatioUnitComponentPartDefinition(FbDraweeControllerBuilder.b(injectorLike), ReactionIntentFactory.m22683a(injectorLike));
    }

    @Inject
    public ReactionPhotoZeroAspectRatioUnitComponentPartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder, ReactionIntentFactory reactionIntentFactory) {
        super(fbDraweeControllerBuilder, reactionIntentFactory);
    }

    public final float mo1124b() {
        return 0.0f;
    }

    public static ReactionPhotoZeroAspectRatioUnitComponentPartDefinition m23843a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPhotoZeroAspectRatioUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19957c) {
                ReactionPhotoZeroAspectRatioUnitComponentPartDefinition reactionPhotoZeroAspectRatioUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionPhotoZeroAspectRatioUnitComponentPartDefinition = (ReactionPhotoZeroAspectRatioUnitComponentPartDefinition) a2.a(f19957c);
                } else {
                    reactionPhotoZeroAspectRatioUnitComponentPartDefinition = f19956b;
                }
                if (reactionPhotoZeroAspectRatioUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23844b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19957c, b3);
                        } else {
                            f19956b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPhotoZeroAspectRatioUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

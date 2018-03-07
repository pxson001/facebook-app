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
/* compiled from: ad_images_json */
public class ReactionPhotoOneAspectRatioUnitComponentPartDefinition extends ReactionPhotoUnitComponentPartDefinition {
    private static ReactionPhotoOneAspectRatioUnitComponentPartDefinition f19945b;
    private static final Object f19946c = new Object();

    private static ReactionPhotoOneAspectRatioUnitComponentPartDefinition m23840b(InjectorLike injectorLike) {
        return new ReactionPhotoOneAspectRatioUnitComponentPartDefinition(FbDraweeControllerBuilder.b(injectorLike), ReactionIntentFactory.m22683a(injectorLike));
    }

    @Inject
    public ReactionPhotoOneAspectRatioUnitComponentPartDefinition(FbDraweeControllerBuilder fbDraweeControllerBuilder, ReactionIntentFactory reactionIntentFactory) {
        super(fbDraweeControllerBuilder, reactionIntentFactory);
    }

    public final float mo1124b() {
        return 1.0f;
    }

    public static ReactionPhotoOneAspectRatioUnitComponentPartDefinition m23839a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReactionPhotoOneAspectRatioUnitComponentPartDefinition b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19946c) {
                ReactionPhotoOneAspectRatioUnitComponentPartDefinition reactionPhotoOneAspectRatioUnitComponentPartDefinition;
                if (a2 != null) {
                    reactionPhotoOneAspectRatioUnitComponentPartDefinition = (ReactionPhotoOneAspectRatioUnitComponentPartDefinition) a2.a(f19946c);
                } else {
                    reactionPhotoOneAspectRatioUnitComponentPartDefinition = f19945b;
                }
                if (reactionPhotoOneAspectRatioUnitComponentPartDefinition == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m23840b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19946c, b3);
                        } else {
                            f19945b = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = reactionPhotoOneAspectRatioUnitComponentPartDefinition;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

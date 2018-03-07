package com.facebook.feedplugins.storygallerysurvey.service;

import android.content.Context;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: birthday_cam_post_processing_finished */
public class StoryGallerySurveyActionsServiceHandler implements BlueServiceHandler {
    private static StoryGallerySurveyActionsServiceHandler f9532c;
    private static final Object f9533d = new Object();
    private final Provider<SingleMethodRunner> f9534a;
    private final StoryGallerySurveyActionsMethod f9535b;

    private static StoryGallerySurveyActionsServiceHandler m10074b(InjectorLike injectorLike) {
        return new StoryGallerySurveyActionsServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new StoryGallerySurveyActionsMethod());
    }

    @Inject
    public StoryGallerySurveyActionsServiceHandler(Provider<SingleMethodRunner> provider, StoryGallerySurveyActionsMethod storyGallerySurveyActionsMethod) {
        this.f9534a = provider;
        this.f9535b = storyGallerySurveyActionsMethod;
    }

    public final OperationResult m10075a(OperationParams operationParams) {
        String str = operationParams.b;
        if (str.equals("story_gallery_survey_actions_type")) {
            ((AbstractSingleMethodRunner) this.f9534a.get()).a(this.f9535b, (StoryGallerySurveyActionsParams) operationParams.c.getParcelable("story_gallery_survey_actions_params_key"), CallerContext.a(StoryGallerySurveyActionsServiceHandler.class));
            return OperationResult.a;
        }
        throw new IllegalArgumentException("unknown operation type: " + str);
    }

    public static StoryGallerySurveyActionsServiceHandler m10073a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            StoryGallerySurveyActionsServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f9533d) {
                StoryGallerySurveyActionsServiceHandler storyGallerySurveyActionsServiceHandler;
                if (a2 != null) {
                    storyGallerySurveyActionsServiceHandler = (StoryGallerySurveyActionsServiceHandler) a2.a(f9533d);
                } else {
                    storyGallerySurveyActionsServiceHandler = f9532c;
                }
                if (storyGallerySurveyActionsServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m10074b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f9533d, b3);
                        } else {
                            f9532c = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = storyGallerySurveyActionsServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

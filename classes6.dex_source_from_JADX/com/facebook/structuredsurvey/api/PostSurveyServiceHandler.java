package com.facebook.structuredsurvey.api;

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
/* compiled from: download_preview */
public class PostSurveyServiceHandler implements BlueServiceHandler {
    private static PostSurveyServiceHandler f17140d;
    private static final Object f17141e = new Object();
    private final PostSurveyAnswersMethod f17142a;
    private final PostSurveyImpressionsMethod f17143b;
    private final Provider<SingleMethodRunner> f17144c;

    private static PostSurveyServiceHandler m24821b(InjectorLike injectorLike) {
        return new PostSurveyServiceHandler(IdBasedSingletonScopeProvider.a(injectorLike, 2289), new PostSurveyAnswersMethod(), new PostSurveyImpressionsMethod());
    }

    @Inject
    public PostSurveyServiceHandler(Provider<SingleMethodRunner> provider, PostSurveyAnswersMethod postSurveyAnswersMethod, PostSurveyImpressionsMethod postSurveyImpressionsMethod) {
        this.f17144c = provider;
        this.f17142a = postSurveyAnswersMethod;
        this.f17143b = postSurveyImpressionsMethod;
    }

    public final OperationResult m24822a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("post_survey_answers".equals(str)) {
            ((AbstractSingleMethodRunner) this.f17144c.get()).a(this.f17142a, (PostSurveyAnswersParams) operationParams.c.getParcelable("postSurveyAnswersParams"), CallerContext.a(PostSurveyServiceHandler.class));
            return OperationResult.a;
        } else if ("post_survey_impressions".equals(str)) {
            ((AbstractSingleMethodRunner) this.f17144c.get()).a(this.f17143b, (PostSurveyImpressionsParams) operationParams.c.getParcelable("postSurveyImpressionsParams"), CallerContext.a(PostSurveyServiceHandler.class));
            return OperationResult.a;
        } else {
            throw new IllegalArgumentException("unknown operation type: " + str);
        }
    }

    public static PostSurveyServiceHandler m24820a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PostSurveyServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f17141e) {
                PostSurveyServiceHandler postSurveyServiceHandler;
                if (a2 != null) {
                    postSurveyServiceHandler = (PostSurveyServiceHandler) a2.a(f17141e);
                } else {
                    postSurveyServiceHandler = f17140d;
                }
                if (postSurveyServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m24821b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f17141e, b3);
                        } else {
                            f17140d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = postSurveyServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

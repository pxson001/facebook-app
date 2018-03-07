package com.facebook.identitygrowth.profilequestion.service;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.graphql.protocol.GraphQLProtocolHelper;
import com.facebook.http.protocol.ApiMethodRunner.Batch;
import com.facebook.http.protocol.ApiMethodRunnerImpl;
import com.facebook.http.protocol.BatchOperation;
import com.facebook.http.protocol.BatchOperation.Builder;
import com.facebook.identitygrowth.protocol.FetchProfileQuestionMethod;
import com.facebook.identitygrowth.protocol.FetchProfileQuestionParams;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionQueryModel;
import com.facebook.identitygrowth.protocol.SaveProfileQuestionMethod;
import com.facebook.identitygrowth.protocol.SaveProfileQuestionParams;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import javax.inject.Inject;

@ContextScoped
/* compiled from: mIsPartial */
public class ProfileQuestionServiceHandler implements BlueServiceHandler {
    private static ProfileQuestionServiceHandler f11045d;
    private static final Object f11046e = new Object();
    public final SaveProfileQuestionMethod f11047a;
    public final FetchProfileQuestionMethod f11048b;
    public final ApiMethodRunnerImpl f11049c;

    private static ProfileQuestionServiceHandler m17784b(InjectorLike injectorLike) {
        return new ProfileQuestionServiceHandler(new SaveProfileQuestionMethod(), new FetchProfileQuestionMethod(GraphQLProtocolHelper.a(injectorLike)), ApiMethodRunnerImpl.a(injectorLike));
    }

    @Inject
    public ProfileQuestionServiceHandler(SaveProfileQuestionMethod saveProfileQuestionMethod, FetchProfileQuestionMethod fetchProfileQuestionMethod, ApiMethodRunnerImpl apiMethodRunnerImpl) {
        this.f11047a = saveProfileQuestionMethod;
        this.f11048b = fetchProfileQuestionMethod;
        this.f11049c = apiMethodRunnerImpl;
    }

    public final OperationResult m17785a(OperationParams operationParams) {
        Bundle bundle = operationParams.c;
        if ("identitygrowth_save_profile_question".equals(operationParams.b)) {
            SaveProfileQuestionParams saveProfileQuestionParams = (SaveProfileQuestionParams) bundle.getParcelable("saveProfileQuestionParams");
            Batch a = this.f11049c.a();
            Builder a2 = BatchOperation.a(this.f11047a, saveProfileQuestionParams);
            a2.c = "save-profile-question";
            a.a(a2.a(false).a());
            a2 = BatchOperation.a(this.f11048b, (FetchProfileQuestionParams) bundle.getParcelable("fetchProfileQuestionParams"));
            a2.c = "fetch-profile-question";
            a2 = a2;
            a2.d = "save-profile-question";
            a.a(a2.a(true).a());
            a.a("fetch-profile-question", CallerContext.a(getClass()));
            return OperationResult.a((ProfileQuestionQueryModel) a.a("fetch-profile-question"));
        }
        throw new IllegalArgumentException("Unknown request type");
    }

    public static ProfileQuestionServiceHandler m17783a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ProfileQuestionServiceHandler b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f11046e) {
                ProfileQuestionServiceHandler profileQuestionServiceHandler;
                if (a2 != null) {
                    profileQuestionServiceHandler = (ProfileQuestionServiceHandler) a2.a(f11046e);
                } else {
                    profileQuestionServiceHandler = f11045d;
                }
                if (profileQuestionServiceHandler == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m17784b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f11046e, b3);
                        } else {
                            f11045d = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = profileQuestionServiceHandler;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }
}

package com.facebook.messaging.business.nativesignup.loaders;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQuery.NativeSignUpNewUserSignUpQueryString;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryModels.NativeSignUpNewUserSignUpQueryModel;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryModels.NativeSignUpNewUserSignUpQueryModel.MessengerCommerceModel.NewUserSignupModel;
import com.facebook.messaging.business.nativesignup.model.NativeSignUpParams;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: mute_duration */
public class SignUpQueryLoader {
    public final AbstractFbErrorReporter f8872a;
    private final GraphQLQueryExecutor f8873b;
    private final TasksManager<String> f8874c;

    /* compiled from: mute_duration */
    public interface Callback {
        void mo326a();

        void mo327a(NewUserSignupModel newUserSignupModel);
    }

    public static SignUpQueryLoader m9154b(InjectorLike injectorLike) {
        return new SignUpQueryLoader((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike));
    }

    @Inject
    public SignUpQueryLoader(AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager) {
        this.f8872a = abstractFbErrorReporter;
        this.f8873b = graphQLQueryExecutor;
        this.f8874c = tasksManager;
    }

    public final void m9156a(NativeSignUpParams nativeSignUpParams, final Callback callback) {
        GraphQlQueryString nativeSignUpNewUserSignUpQueryString = new NativeSignUpNewUserSignUpQueryString();
        nativeSignUpNewUserSignUpQueryString.a("provider_id", nativeSignUpParams.f8884a);
        if (!Strings.isNullOrEmpty(nativeSignUpParams.f8890g)) {
            nativeSignUpNewUserSignUpQueryString.a("promo_data", nativeSignUpParams.f8890g);
        }
        this.f8874c.a("task_key_fetch_native_sign_up_model", this.f8873b.a(GraphQLRequest.a(nativeSignUpNewUserSignUpQueryString).a(GraphQLCachePolicy.a).a(600)), new AbstractDisposableFutureCallback<GraphQLResult<NativeSignUpNewUserSignUpQueryModel>>(this) {
            final /* synthetic */ SignUpQueryLoader f8871b;

            protected final void m9150a(Object obj) {
                GraphQLResult graphQLResult = (GraphQLResult) obj;
                if (callback != null) {
                    if (graphQLResult == null || graphQLResult.e == null || ((NativeSignUpNewUserSignUpQueryModel) graphQLResult.e).m9119a() == null || ((NativeSignUpNewUserSignUpQueryModel) graphQLResult.e).m9119a().m9114a() == null) {
                        this.f8871b.f8872a.a("SignUpQueryLoader", "Loading empty data for Sign-Up Fragment");
                        callback.mo326a();
                        return;
                    }
                    callback.mo327a(((NativeSignUpNewUserSignUpQueryModel) graphQLResult.e).m9119a().m9114a());
                }
            }

            protected final void m9151a(Throwable th) {
                if (callback != null) {
                    callback.mo326a();
                }
                this.f8871b.f8872a.a("SignUpQueryLoader", th);
            }
        });
    }

    public final void m9155a() {
        this.f8874c.c("task_key_fetch_native_sign_up_model");
    }
}

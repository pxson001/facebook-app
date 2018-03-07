package com.facebook.messaging.business.nativesignup.mutators;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.graphql.calls.SendConfirmationCodeInputData;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpPhoneVerificationMutations.NativeSignUpSendConfirmationMutationString;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpPhoneVerificationMutationsModels.NativeSignUpSendConfirmationMutationModel;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: must be called before AppRequest.buildRequest */
public class SendConfirmationMutator {
    public final AbstractFbErrorReporter f8899a;
    private final GraphQLQueryExecutor f8900b;
    private final ExecutorService f8901c;
    public ListenableFuture<GraphQLResult<NativeSignUpSendConfirmationMutationModel>> f8902d;
    @GuardedBy("ui-thread")
    public Callback f8903e;

    /* compiled from: must be called before AppRequest.buildRequest */
    class C10121 implements FutureCallback<GraphQLResult<NativeSignUpSendConfirmationMutationModel>> {
        final /* synthetic */ SendConfirmationMutator f8898a;

        C10121(SendConfirmationMutator sendConfirmationMutator) {
            this.f8898a = sendConfirmationMutator;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f8898a.f8902d = null;
            if (graphQLResult == null) {
                this.f8898a.f8903e.mo324a();
            } else {
                this.f8898a.f8903e.mo325a((NativeSignUpSendConfirmationMutationModel) graphQLResult.e);
            }
        }

        public void onFailure(Throwable th) {
            this.f8898a.f8902d = null;
            this.f8898a.f8899a.a("SendConfirmationMutator", "Fail to request confirmation code", th);
            this.f8898a.f8903e.mo324a();
        }
    }

    /* compiled from: must be called before AppRequest.buildRequest */
    public interface Callback {
        void mo324a();

        void mo325a(@Nullable NativeSignUpSendConfirmationMutationModel nativeSignUpSendConfirmationMutationModel);
    }

    public static SendConfirmationMutator m9165b(InjectorLike injectorLike) {
        return new SendConfirmationMutator((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), GraphQLQueryExecutor.a(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public SendConfirmationMutator(AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService) {
        this.f8899a = abstractFbErrorReporter;
        this.f8900b = graphQLQueryExecutor;
        this.f8901c = executorService;
    }

    public final void m9167a(String str) {
        if (this.f8902d == null) {
            GraphQlQueryString nativeSignUpSendConfirmationMutationString = new NativeSignUpSendConfirmationMutationString();
            SendConfirmationCodeInputData sendConfirmationCodeInputData = new SendConfirmationCodeInputData();
            sendConfirmationCodeInputData.a("phone_number", str);
            nativeSignUpSendConfirmationMutationString.a("input", sendConfirmationCodeInputData);
            this.f8902d = this.f8900b.a(GraphQLRequest.a(nativeSignUpSendConfirmationMutationString));
            Futures.a(this.f8902d, new C10121(this), this.f8901c);
        }
    }

    public final void m9166a() {
        if (this.f8902d != null) {
            this.f8902d.cancel(true);
            this.f8902d = null;
        }
    }
}

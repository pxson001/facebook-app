package com.facebook.messaging.business.nativesignup.mutators;

import android.content.Context;
import android.content.Intent;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpPhoneVerificationMutationsModels.NativeSignUpConfirmPhoneCodeMutationModel;
import com.facebook.messaging.business.nativesignup.graphql.NativeSignUpQueryModels.PhoneNumberInfoModel;
import com.facebook.messaging.business.nativesignup.view.BusinessConfirmCodeFragment;
import com.facebook.messaging.business.nativesignup.view.BusinessConfirmCodeFragment.C10173;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.inject.Inject;

/* compiled from: must call AppRequest.buildRequest */
public class ConfirmPhoneCodeMutator {
    public final AbstractFbErrorReporter f8892a;
    public final GraphQLQueryExecutor f8893b;
    public final ExecutorService f8894c;
    public final Context f8895d;
    public ListenableFuture<GraphQLResult<NativeSignUpConfirmPhoneCodeMutationModel>> f8896e;
    @GuardedBy("ui-thread")
    public C10173 f8897f;

    /* compiled from: must call AppRequest.buildRequest */
    public class C10111 implements FutureCallback<GraphQLResult<NativeSignUpConfirmPhoneCodeMutationModel>> {
        final /* synthetic */ ConfirmPhoneCodeMutator f8891a;

        public C10111(ConfirmPhoneCodeMutator confirmPhoneCodeMutator) {
            this.f8891a = confirmPhoneCodeMutator;
        }

        public void onSuccess(@Nullable Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            this.f8891a.f8896e = null;
            if (graphQLResult == null || graphQLResult.e == null || ((NativeSignUpConfirmPhoneCodeMutationModel) graphQLResult.e).m9046a() == null) {
                this.f8891a.f8892a.a("ConfirmPhoneCodeMutator", "Confirmed phone number is empty");
                C10173 c10173 = this.f8891a.f8897f;
                Throwable th = new Throwable(this.f8891a.f8895d.getString(2131241097));
                c10173.m9175a();
                return;
            }
            C10173 c101732 = this.f8891a.f8897f;
            PhoneNumberInfoModel a = ((NativeSignUpConfirmPhoneCodeMutationModel) graphQLResult.e).m9046a();
            BusinessConfirmCodeFragment.as(c101732.f8923a);
            c101732.f8923a.f8933e.m9159a("success_verify_sms_code");
            Intent intent = new Intent();
            FlatBufferModelHelper.a(intent, "confirmed_phone_number", a);
            c101732.f8923a.ao().setResult(-1, intent);
            c101732.f8923a.ao().finish();
        }

        public void onFailure(Throwable th) {
            this.f8891a.f8896e = null;
            this.f8891a.f8892a.a("ConfirmPhoneCodeMutator", "Can't get request mutation result", th);
            this.f8891a.f8897f.m9175a();
        }
    }

    @Inject
    public ConfirmPhoneCodeMutator(AbstractFbErrorReporter abstractFbErrorReporter, GraphQLQueryExecutor graphQLQueryExecutor, ExecutorService executorService, Context context) {
        this.f8892a = abstractFbErrorReporter;
        this.f8893b = graphQLQueryExecutor;
        this.f8894c = executorService;
        this.f8895d = context;
    }
}

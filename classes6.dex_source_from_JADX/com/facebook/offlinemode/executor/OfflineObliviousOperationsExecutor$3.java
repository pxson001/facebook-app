package com.facebook.offlinemode.executor;

import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.offlinemode.common.PendingRequest;
import com.facebook.offlinemode.db.PendingBlueServiceRequest.Builder;
import com.facebook.offlinemode.executor.OfflineObliviousOperationsExecutor.OfflineExceptionTreatment;
import com.facebook.tools.dextr.runtime.detour.FutureDetour;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.SettableFuture;

/* compiled from: theaters */
class OfflineObliviousOperationsExecutor$3 implements FutureCallback<OperationResult> {
    final /* synthetic */ boolean f3198a;
    final /* synthetic */ Operation f3199b;
    final /* synthetic */ String f3200c;
    final /* synthetic */ long f3201d;
    final /* synthetic */ long f3202e;
    final /* synthetic */ int f3203f;
    final /* synthetic */ int f3204g;
    final /* synthetic */ SettableFuture f3205h;
    final /* synthetic */ OfflineExceptionTreatment f3206i;
    final /* synthetic */ OfflineObliviousOperationsExecutor f3207j;

    OfflineObliviousOperationsExecutor$3(OfflineObliviousOperationsExecutor offlineObliviousOperationsExecutor, boolean z, Operation operation, String str, long j, long j2, int i, int i2, SettableFuture settableFuture, OfflineExceptionTreatment offlineExceptionTreatment) {
        this.f3207j = offlineObliviousOperationsExecutor;
        this.f3198a = z;
        this.f3199b = operation;
        this.f3200c = str;
        this.f3201d = j;
        this.f3202e = j2;
        this.f3203f = i;
        this.f3204g = i2;
        this.f3205h = settableFuture;
        this.f3206i = offlineExceptionTreatment;
    }

    public void onSuccess(Object obj) {
        OperationResult operationResult = (OperationResult) obj;
        if (!this.f3198a) {
            Builder a = new Builder().a(this.f3199b);
            a.a = this.f3200c;
            PendingRequest.Builder builder = a;
            builder.c = this.f3201d;
            builder = builder;
            builder.d = this.f3202e;
            builder = builder;
            builder.e = this.f3203f;
            builder = builder;
            builder.f = this.f3204g;
            this.f3207j.l.c(builder.a());
        }
        FutureDetour.a(this.f3205h, operationResult, -1275587589);
    }

    public void onFailure(Throwable th) {
        if (this.f3207j.l.a(th)) {
            Builder a = new Builder().a(this.f3199b);
            a.a = this.f3200c;
            PendingRequest.Builder builder = a;
            builder.c = this.f3201d;
            builder = builder;
            builder.d = this.f3202e;
            builder = builder;
            builder.e = this.f3203f + 1;
            builder = builder;
            builder.f = this.f3204g;
            PendingRequest a2 = builder.a();
            this.f3207j.e.a(a2);
            this.f3207j.l.a(a2);
            if (this.f3206i == OfflineExceptionTreatment.THROW_CUSTOM_EXCEPTION) {
                this.f3205h.a(new OperationAttemptWhileOfflineException(this.f3199b, th));
                return;
            } else if (this.f3206i == OfflineExceptionTreatment.FAKE_SUCCESS) {
                FutureDetour.a(this.f3205h, null, 755380728);
                return;
            } else {
                return;
            }
        }
        this.f3205h.a(th);
    }
}

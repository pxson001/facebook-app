package com.facebook.account.recovery.service;

import com.facebook.account.recovery.protocol.AccountRecoverySearchAccountMethod;
import com.facebook.account.recovery.protocol.AccountRecoverySearchAccountMethod.Result;
import com.facebook.account.recovery.protocol.AccountRecoverySearchAccountMethodParams;
import com.facebook.account.recovery.protocol.AccountRecoverySendConfirmationCodeMethod;
import com.facebook.account.recovery.protocol.AccountRecoverySendConfirmationCodeMethod.Params;
import com.facebook.account.recovery.protocol.AccountRecoveryValidateCodeMethod;
import com.facebook.fbservice.service.ApiMethodNotFoundException;
import com.facebook.fbservice.service.BlueServiceHandler;
import com.facebook.fbservice.service.ErrorCode;
import com.facebook.fbservice.service.OperationParams;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.http.protocol.AbstractSingleMethodRunner;
import com.facebook.http.protocol.ApiMethod;
import com.facebook.http.protocol.SingleMethodRunner;
import com.facebook.inject.Lazy;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: linkshim */
public class AccountRecoveryServiceHandler implements BlueServiceHandler {
    public final Provider<SingleMethodRunner> f10325a;
    public final Lazy<AccountRecoverySearchAccountMethod> f10326b;
    public final Lazy<AccountRecoverySendConfirmationCodeMethod> f10327c;
    public final Lazy<AccountRecoveryValidateCodeMethod> f10328d;

    @Inject
    public AccountRecoveryServiceHandler(Provider<SingleMethodRunner> provider, Lazy<AccountRecoverySearchAccountMethod> lazy, Lazy<AccountRecoverySendConfirmationCodeMethod> lazy2, Lazy<AccountRecoveryValidateCodeMethod> lazy3) {
        this.f10325a = provider;
        this.f10326b = lazy;
        this.f10327c = lazy2;
        this.f10328d = lazy3;
    }

    public final OperationResult m12120a(OperationParams operationParams) {
        String str = operationParams.b;
        if ("account_recovery_search_account".equals(str)) {
            return OperationResult.a((Result) ((AbstractSingleMethodRunner) this.f10325a.get()).a((ApiMethod) this.f10326b.get(), (AccountRecoverySearchAccountMethodParams) operationParams.c.getParcelable("accountRecoverySearchAccountParamsKey"), operationParams.e));
        } else if ("account_recovery_send_code".equals(str)) {
            OperationResult operationResult;
            if (((Boolean) ((AbstractSingleMethodRunner) this.f10325a.get()).a((ApiMethod) this.f10327c.get(), (Params) operationParams.c.getParcelable("accountRecoverySendCodeParamsKey"), operationParams.e)).booleanValue()) {
                operationResult = OperationResult.a;
            } else {
                operationResult = OperationResult.a(ErrorCode.OTHER);
            }
            return operationResult;
        } else if ("account_recovery_validate_code".equals(str)) {
            return OperationResult.a((String) ((AbstractSingleMethodRunner) this.f10325a.get()).a((ApiMethod) this.f10328d.get(), (AccountRecoveryValidateCodeMethod.Params) operationParams.c.getParcelable("accountRecoveryValidateCodeParamsKey"), operationParams.e));
        } else {
            throw new ApiMethodNotFoundException(str);
        }
    }
}

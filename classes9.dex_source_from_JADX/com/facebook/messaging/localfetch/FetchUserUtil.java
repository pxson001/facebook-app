package com.facebook.messaging.localfetch;

import android.os.Bundle;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.futures.FbFutures;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.messaging.service.model.FetchThreadUsersParams;
import com.facebook.messaging.service.model.FetchThreadUsersResult;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.User;
import com.facebook.user.model.UserKey;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mPaymentTransactionId */
public class FetchUserUtil {
    public final DefaultBlueServiceOperationFactory f11372a;

    /* compiled from: mPaymentTransactionId */
    class C12551 implements Function<OperationResult, User> {
        final /* synthetic */ FetchUserUtil f11371a;

        C12551(FetchUserUtil fetchUserUtil) {
            this.f11371a = fetchUserUtil;
        }

        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult != null) {
                FetchThreadUsersResult fetchThreadUsersResult = (FetchThreadUsersResult) operationResult.k();
                if (fetchThreadUsersResult != null && fetchThreadUsersResult.f17188a.size() == 1) {
                    return (User) fetchThreadUsersResult.f17188a.get(0);
                }
            }
            return null;
        }
    }

    @Inject
    public FetchUserUtil(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory) {
        this.f11372a = defaultBlueServiceOperationFactory;
    }

    public final ListenableFuture<User> m11962a(UserKey userKey) {
        Preconditions.checkNotNull(userKey);
        ImmutableList of = ImmutableList.of(userKey);
        Bundle bundle = new Bundle();
        bundle.putParcelable("FetchThreadUsersParams", new FetchThreadUsersParams(DataFreshnessParam.DO_NOT_CHECK_SERVER, of));
        return FbFutures.a(BlueServiceOperationFactoryDetour.a(this.f11372a, "fetch_users", bundle, ErrorPropagation.BY_EXCEPTION, CallerContext.a(FetchUserUtil.class), -1722410521).c(), new C12551(this));
    }
}

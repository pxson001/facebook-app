package com.facebook.profile.inforequest.services;

import android.os.Bundle;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.graphql.enums.GraphQLInfoRequestFieldType;
import com.facebook.profile.inforequest.protocol.DeleteInfoRequestParams;
import com.facebook.profile.inforequest.protocol.InfoRequestParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;

/* compiled from: localport */
public class InfoRequestHelper {

    /* compiled from: localport */
    public interface Callback {
        void mo375a();

        void mo376b();
    }

    /* compiled from: localport */
    final class C12771 extends OperationResultFutureCallback {
        final /* synthetic */ Callback f8583a;

        C12771(Callback callback) {
            this.f8583a = callback;
        }

        protected final void m8490a(ServiceException serviceException) {
            this.f8583a.mo375a();
        }

        protected final void m8491a(Object obj) {
            this.f8583a.mo376b();
        }
    }

    public static void m8494a(GraphQLInfoRequestFieldType graphQLInfoRequestFieldType, String str, String str2, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Callback callback, Executor executor) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("operationParams", new InfoRequestParams(str, m8492a(graphQLInfoRequestFieldType), str2));
        m8495a(BlueServiceOperationFactoryDetour.a(defaultBlueServiceOperationFactory, "timeline_send_info_request", bundle, -1870287790).a(), callback, executor);
    }

    public static void m8493a(GraphQLInfoRequestFieldType graphQLInfoRequestFieldType, String str, DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, Callback callback, Executor executor) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("operationParams", new DeleteInfoRequestParams(str, m8492a(graphQLInfoRequestFieldType)));
        m8495a(BlueServiceOperationFactoryDetour.a(defaultBlueServiceOperationFactory, "timeline_delete_info_request", bundle, -134767625).a(), callback, executor);
    }

    private static void m8495a(ListenableFuture<OperationResult> listenableFuture, Callback callback, Executor executor) {
        Futures.a(listenableFuture, new C12771(callback), executor);
    }

    private static List<String> m8492a(GraphQLInfoRequestFieldType graphQLInfoRequestFieldType) {
        List<String> a = Lists.a();
        a.add(graphQLInfoRequestFieldType.name());
        return a;
    }
}

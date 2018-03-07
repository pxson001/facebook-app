package com.facebook.orca.threadview;

import android.content.Context;
import android.os.Bundle;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.fbservice.ops.BlueServiceOperationFactory.Operation;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.threads.ThreadSummary;
import com.facebook.messaging.service.model.RemoveMemberParams;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.facebook.user.model.User;
import com.google.common.util.concurrent.Futures;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: onion_tor_enabled */
public class RemoveMembersHelper {
    private DefaultBlueServiceOperationFactory f7361a;
    private ExecutorService f7362b;
    public Listener f7363c;

    /* compiled from: onion_tor_enabled */
    public interface Listener {
        void mo213a();

        void mo214a(ServiceException serviceException);
    }

    /* compiled from: onion_tor_enabled */
    class C11051 extends OperationResultFutureCallback {
        final /* synthetic */ RemoveMembersHelper f7360a;

        C11051(RemoveMembersHelper removeMembersHelper) {
            this.f7360a = removeMembersHelper;
        }

        protected final void m6995a(Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            this.f7360a.f7363c.mo213a();
        }

        protected final void m6994a(ServiceException serviceException) {
            this.f7360a.f7363c.mo214a(serviceException);
        }
    }

    public static RemoveMembersHelper m6996a(InjectorLike injectorLike) {
        return new RemoveMembersHelper(DefaultBlueServiceOperationFactory.b(injectorLike), (ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public RemoveMembersHelper(DefaultBlueServiceOperationFactory defaultBlueServiceOperationFactory, ExecutorService executorService) {
        this.f7361a = defaultBlueServiceOperationFactory;
        this.f7362b = executorService;
    }

    public final void m6997a(Context context, User user, ThreadSummary threadSummary) {
        RemoveMemberParams b = RemoveMemberParams.b(threadSummary.a, user.n());
        Bundle bundle = new Bundle();
        bundle.putParcelable("removeMemberParams", b);
        Operation a = BlueServiceOperationFactoryDetour.a(this.f7361a, "remove_member", bundle, -680131639);
        a.a(new DialogBasedProgressIndicator(context, 2131231716));
        Futures.a(a.a(), new C11051(this), this.f7362b);
    }
}

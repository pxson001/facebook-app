package com.facebook.messaging.sms.migration;

import android.os.Bundle;
import com.facebook.auth.module.UserKey_ViewerContextUserKeyMethodAutoProvider;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.DefaultExecutorService;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.contactlogs.ContactLogsUploadRunner;
import com.facebook.contactlogs.migrator.TopSmsContact;
import com.facebook.contactlogs.protocol.MatchTopSMSContactsParams;
import com.facebook.fbservice.ops.ErrorPropagation;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.sms.migration.util.ContactMatchingUtil;
import com.facebook.messaging.sms.migration.util.SMSUploadUtil;
import com.facebook.messaging.sms.migration.util.TopSmsContactsGetterUtil;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.runtimepermissions.RuntimePermissionsUtil;
import com.facebook.tools.dextr.runtime.detour.BlueServiceOperationFactoryDetour;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: qrcode_import_not_understood */
public class ContactMatchingOperationLogic {
    public final ContactMatchingUtil f4113a;
    @ForUiThread
    public final Executor f4114b;
    @DefaultExecutorService
    private final ListeningExecutorService f4115c;
    private final SMSUploadUtil f4116d;
    public final TopSmsContactsGetterUtil f4117e;
    public final FutureCallback f4118f = new C06141(this);
    public ListenableFuture f4119g;
    public OperationType f4120h = OperationType.NONE;
    @Nullable
    public Listener f4121i;

    /* compiled from: qrcode_import_not_understood */
    class C06141 implements FutureCallback<Object> {
        final /* synthetic */ ContactMatchingOperationLogic f4108a;

        C06141(ContactMatchingOperationLogic contactMatchingOperationLogic) {
            this.f4108a = contactMatchingOperationLogic;
        }

        public void onSuccess(Object obj) {
            ContactMatchingOperationLogic.m3776b(this.f4108a);
        }

        public void onFailure(Throwable th) {
            ContactMatchingOperationLogic.m3776b(this.f4108a);
        }
    }

    /* compiled from: qrcode_import_not_understood */
    class C06152 implements AsyncFunction<ImmutableList<TopSmsContact>, ContactMatchingOperationResult> {
        final /* synthetic */ ContactMatchingOperationLogic f4109a;

        C06152(ContactMatchingOperationLogic contactMatchingOperationLogic) {
            this.f4109a = contactMatchingOperationLogic;
        }

        public final ListenableFuture m3769a(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            if (immutableList == null || immutableList.isEmpty()) {
                return Futures.a(ContactMatchingOperationResult.f4122a);
            }
            return ContactMatchingOperationLogic.m3774a(this.f4109a, immutableList);
        }
    }

    /* compiled from: qrcode_import_not_understood */
    class C06174 implements Function<OperationResult, ContactMatchingOperationResult> {
        final /* synthetic */ ContactMatchingOperationLogic f4112a;

        C06174(ContactMatchingOperationLogic contactMatchingOperationLogic) {
            this.f4112a = contactMatchingOperationLogic;
        }

        public Object apply(@Nullable Object obj) {
            OperationResult operationResult = (OperationResult) obj;
            if (operationResult == null) {
                return ContactMatchingOperationResult.f4122a;
            }
            return this.f4112a.f4113a.m3863a(operationResult);
        }
    }

    /* compiled from: qrcode_import_not_understood */
    public interface Listener {
        void mo118a();

        void mo119b();
    }

    /* compiled from: qrcode_import_not_understood */
    public enum OperationType {
        NONE,
        LOCAL_CONTACT_FETCH,
        MATCHED_CONTACT_FETCH,
        COMBINED_FETCH
    }

    public static ContactMatchingOperationLogic m3775b(InjectorLike injectorLike) {
        return new ContactMatchingOperationLogic(new ContactMatchingUtil(IdBasedLazy.a(injectorLike, 2590), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), UserKey_ViewerContextUserKeyMethodAutoProvider.b(injectorLike)), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), SMSUploadUtil.m3866b(injectorLike), new TopSmsContactsGetterUtil(IdBasedSingletonScopeProvider.b(injectorLike, 609), ContentResolverMethodAutoProvider.b(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), RuntimePermissionsUtil.b(injectorLike)));
    }

    @Inject
    public ContactMatchingOperationLogic(ContactMatchingUtil contactMatchingUtil, Executor executor, ListeningExecutorService listeningExecutorService, SMSUploadUtil sMSUploadUtil, TopSmsContactsGetterUtil topSmsContactsGetterUtil) {
        this.f4113a = contactMatchingUtil;
        this.f4114b = executor;
        this.f4115c = listeningExecutorService;
        this.f4116d = sMSUploadUtil;
        this.f4117e = topSmsContactsGetterUtil;
    }

    public final void m3778a(AbstractDisposableFutureCallback<ContactMatchingOperationResult> abstractDisposableFutureCallback) {
        this.f4120h = OperationType.COMBINED_FETCH;
        this.f4119g = Futures.b(m3773a(10), new C06152(this), this.f4114b);
        Futures.a(this.f4119g, this.f4118f, this.f4114b);
        Futures.a(this.f4119g, abstractDisposableFutureCallback, this.f4114b);
        if (this.f4121i != null) {
            this.f4121i.mo118a();
        }
    }

    private ListenableFuture<ImmutableList<TopSmsContact>> m3773a(final int i) {
        return this.f4115c.a(new Callable<ImmutableList<TopSmsContact>>(this) {
            final /* synthetic */ ContactMatchingOperationLogic f4111b;

            public Object call() {
                return this.f4111b.f4117e.m3875a(i);
            }
        });
    }

    public static ListenableFuture m3774a(ContactMatchingOperationLogic contactMatchingOperationLogic, ImmutableList immutableList) {
        ContactLogsUploadRunner contactLogsUploadRunner = contactMatchingOperationLogic.f4116d.f4242a;
        Bundle bundle = new Bundle();
        bundle.putParcelable("matchTopSmsContactsParams", new MatchTopSMSContactsParams(immutableList));
        return Futures.a(BlueServiceOperationFactoryDetour.a(contactLogsUploadRunner.b, "match_top_sms_contacts", bundle, ErrorPropagation.BY_ERROR_CODE, CallerContext.a(ContactLogsUploadRunner.class), -569190019).a(), new C06174(contactMatchingOperationLogic), contactMatchingOperationLogic.f4114b);
    }

    public final void m3780b(AbstractDisposableFutureCallback<ImmutableList<TopSmsContact>> abstractDisposableFutureCallback) {
        this.f4120h = OperationType.LOCAL_CONTACT_FETCH;
        this.f4119g = m3773a(5);
        Futures.a(this.f4119g, this.f4118f, this.f4114b);
        Futures.a(this.f4119g, abstractDisposableFutureCallback, this.f4114b);
    }

    public static OperationType m3772a(@Nullable Bundle bundle) {
        if (bundle == null) {
            return OperationType.NONE;
        }
        OperationType operationType = (OperationType) bundle.getSerializable("operation_type_to_restart");
        return operationType == null ? OperationType.NONE : operationType;
    }

    public final void m3779b(Bundle bundle) {
        bundle.putSerializable("operation_type_to_restart", this.f4120h);
    }

    public final void m3777a() {
        if (this.f4119g != null && !this.f4119g.isDone()) {
            this.f4120h = OperationType.NONE;
            this.f4119g.cancel(true);
            this.f4119g = null;
        }
    }

    public static void m3776b(ContactMatchingOperationLogic contactMatchingOperationLogic) {
        contactMatchingOperationLogic.f4120h = OperationType.NONE;
        contactMatchingOperationLogic.f4119g = null;
        if (contactMatchingOperationLogic.f4121i != null) {
            contactMatchingOperationLogic.f4121i.mo119b();
        }
    }
}

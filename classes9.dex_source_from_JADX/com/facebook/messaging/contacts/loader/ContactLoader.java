package com.facebook.messaging.contacts.loader;

import com.facebook.contacts.server.FetchContactsResult;
import com.facebook.contacts.util.ContactFetchUtil;
import com.facebook.fbservice.ops.OperationResultFutureCallback;
import com.facebook.fbservice.results.DataFreshnessResult;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.fbservice.service.OperationResult;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.InjectorLike;
import com.facebook.user.model.UserKey;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;

/* compiled from: merged_dialog_video_call */
public class ContactLoader {
    private final ContactFetchUtil f10207a;
    public ListenableFuture<OperationResult> f10208b;
    public Callback f10209c;

    /* compiled from: merged_dialog_video_call */
    public interface Callback {
        void m10756a(OperationResult operationResult);

        void m10757a(Throwable th);
    }

    public static ContactLoader m10758b(InjectorLike injectorLike) {
        return new ContactLoader(ContactFetchUtil.b(injectorLike));
    }

    @Inject
    public ContactLoader(ContactFetchUtil contactFetchUtil) {
        this.f10207a = contactFetchUtil;
    }

    public final void m10760a(final UserKey userKey, DataFreshnessParam dataFreshnessParam) {
        Preconditions.checkNotNull(userKey);
        if (this.f10208b == null) {
            this.f10208b = this.f10207a.b(userKey, dataFreshnessParam);
            Futures.a(this.f10208b, new OperationResultFutureCallback(this) {
                final /* synthetic */ ContactLoader f10206b;

                public final void m10755a(Object obj) {
                    OperationResult operationResult = (OperationResult) obj;
                    this.f10206b.f10208b = null;
                    this.f10206b.f10209c.m10756a(operationResult);
                    FetchContactsResult fetchContactsResult = (FetchContactsResult) operationResult.k();
                    if (fetchContactsResult.freshness == DataFreshnessResult.FROM_SERVER) {
                        return;
                    }
                    if (fetchContactsResult.a.isEmpty() || fetchContactsResult.freshness != DataFreshnessResult.FROM_CACHE_UP_TO_DATE) {
                        this.f10206b.m10760a(userKey, DataFreshnessParam.CHECK_SERVER_FOR_NEW_DATA);
                    }
                }

                protected final void m10754a(ServiceException serviceException) {
                    this.f10206b.f10209c.m10757a((Throwable) serviceException);
                    this.f10206b.f10208b = null;
                }
            });
        }
    }

    public final void m10759a() {
        if (this.f10208b != null) {
            this.f10208b.cancel(false);
            this.f10208b = null;
        }
    }
}

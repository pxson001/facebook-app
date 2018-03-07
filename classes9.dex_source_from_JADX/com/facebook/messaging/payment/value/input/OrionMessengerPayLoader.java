package com.facebook.messaging.payment.value.input;

import android.os.Bundle;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.contacts.graphql.Contact;
import com.facebook.contacts.util.ContactFetchUtil;
import com.facebook.fbservice.service.DataFreshnessParam;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.method.verification.PaymentCardsFetcher;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.Theme;
import com.facebook.messaging.payment.pin.model.PaymentPin;
import com.facebook.messaging.payment.pin.protocol.PaymentPinProtocolUtil;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.eligibility.FetchP2PSendEligibilityResult;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17769;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: event_reminder_title */
public class OrionMessengerPayLoader implements MessengerPayLoader {
    public final GatekeeperStoreImpl f15497a;
    public final Executor f15498b;
    public final AbstractFbErrorReporter f15499c;
    public final ContactFetchUtil f15500d;
    public final PaymentCardsFetcher f15501e;
    public final PaymentPinProtocolUtil f15502f;
    public final PaymentProtocolUtil f15503g;
    public C17769 f15504h;
    public MessengerPayData f15505i;
    public ListenableFuture<PaymentPin> f15506j;
    public ListenableFuture<ImmutableList<PaymentCard>> f15507k;
    public ListenableFuture<FetchP2PSendEligibilityResult> f15508l;
    public ListenableFuture<Contact> f15509m;
    public ListenableFuture<ArrayList<Theme>> f15510n;

    /* compiled from: event_reminder_title */
    public class C18081 implements FutureCallback<PaymentPin> {
        final /* synthetic */ OrionMessengerPayLoader f15492a;

        public C18081(OrionMessengerPayLoader orionMessengerPayLoader) {
            this.f15492a = orionMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            this.f15492a.f15505i.m15745a((PaymentPin) obj);
        }

        public void onFailure(Throwable th) {
            this.f15492a.f15499c.a("OrionMessengerPayLoader", "Failed to fetch PaymentPin to confirm the sending of money");
            this.f15492a.f15504h.m15639a();
        }
    }

    /* compiled from: event_reminder_title */
    public class C18092 implements FutureCallback<ImmutableList<PaymentCard>> {
        final /* synthetic */ OrionMessengerPayLoader f15493a;

        public C18092(OrionMessengerPayLoader orionMessengerPayLoader) {
            this.f15493a = orionMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            ImmutableList immutableList = (ImmutableList) obj;
            this.f15493a.f15505i.m15754a((List) immutableList);
            if (this.f15493a.f15505i.f15449f == null || !this.f15493a.f15505i.f15449f.isPresent()) {
                this.f15493a.f15505i.m15756b(Optional.fromNullable(Iterables.a(PaymentCardsFetcher.m13433d(PaymentCardsFetcher.m13430a(immutableList)), null)));
            }
        }

        public void onFailure(Throwable th) {
            this.f15493a.f15499c.a("OrionMessengerPayLoader", "Failed to fetch PaymentCards for sending money.");
            this.f15493a.f15504h.m15639a();
        }
    }

    /* compiled from: event_reminder_title */
    public class C18103 implements FutureCallback<FetchP2PSendEligibilityResult> {
        final /* synthetic */ OrionMessengerPayLoader f15494a;

        public C18103(OrionMessengerPayLoader orionMessengerPayLoader) {
            this.f15494a = orionMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            this.f15494a.f15505i.m15755a(((FetchP2PSendEligibilityResult) obj).m15170a());
        }

        public void onFailure(Throwable th) {
            this.f15494a.f15499c.a("OrionMessengerPayLoader", "Failed to fetch eligibility of the sender to send money to recipient " + this.f15494a.f15505i.f15460q.b());
            this.f15494a.f15504h.m15639a();
        }
    }

    /* compiled from: event_reminder_title */
    public class C18114 implements FutureCallback<Contact> {
        final /* synthetic */ OrionMessengerPayLoader f15495a;

        public C18114(OrionMessengerPayLoader orionMessengerPayLoader) {
            this.f15495a = orionMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            this.f15495a.f15505i.m15749a(((Contact) obj).e());
        }

        public void onFailure(Throwable th) {
            this.f15495a.f15499c.a("OrionMessengerPayLoader", StringFormatUtil.a("Failed to fetch the Contact for recipient %s", new Object[]{this.f15495a.f15505i.f15460q.b()}));
        }
    }

    /* compiled from: event_reminder_title */
    public class C18125 implements FutureCallback<ArrayList<Theme>> {
        final /* synthetic */ OrionMessengerPayLoader f15496a;

        public C18125(OrionMessengerPayLoader orionMessengerPayLoader) {
            this.f15496a = orionMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            this.f15496a.f15505i.m15758b((ArrayList) obj);
        }

        public void onFailure(Throwable th) {
            this.f15496a.f15499c.a("OrionMessengerPayLoader", "Failed to fetch the theme list");
        }
    }

    public static OrionMessengerPayLoader m15784b(InjectorLike injectorLike) {
        return new OrionMessengerPayLoader(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ContactFetchUtil.b(injectorLike), PaymentCardsFetcher.m13429a(injectorLike), PaymentPinProtocolUtil.m14279a(injectorLike), PaymentProtocolUtil.m14937a(injectorLike));
    }

    @Inject
    public OrionMessengerPayLoader(GatekeeperStoreImpl gatekeeperStoreImpl, Executor executor, AbstractFbErrorReporter abstractFbErrorReporter, ContactFetchUtil contactFetchUtil, PaymentCardsFetcher paymentCardsFetcher, PaymentPinProtocolUtil paymentPinProtocolUtil, PaymentProtocolUtil paymentProtocolUtil) {
        this.f15497a = gatekeeperStoreImpl;
        this.f15498b = executor;
        this.f15499c = abstractFbErrorReporter;
        this.f15500d = contactFetchUtil;
        this.f15501e = paymentCardsFetcher;
        this.f15502f = paymentPinProtocolUtil;
        this.f15503g = paymentProtocolUtil;
    }

    public final void mo613a(C17769 c17769) {
        this.f15504h = c17769;
    }

    public final void mo612a(Bundle bundle, MessengerPayData messengerPayData) {
        this.f15505i = messengerPayData;
        if (m15783a(this.f15506j)) {
            this.f15506j = this.f15502f.m14283a();
            Futures.a(this.f15506j, new C18081(this), this.f15498b);
        }
        if (m15783a(this.f15507k)) {
            this.f15507k = this.f15501e.m13434a();
            Futures.a(this.f15507k, new C18092(this), this.f15498b);
        }
        if (m15783a(this.f15508l)) {
            this.f15508l = this.f15503g.m14948a(DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, this.f15505i.f15460q.b());
            Futures.a(this.f15508l, new C18103(this), this.f15498b);
        }
        if (m15783a(this.f15509m)) {
            this.f15509m = this.f15500d.a(this.f15505i.f15460q, DataFreshnessParam.STALE_DATA_OKAY);
            Futures.a(this.f15509m, new C18114(this), this.f15498b);
        }
        if (this.f15497a.a(1038, false) && m15783a(this.f15510n)) {
            this.f15510n = this.f15503g.m14965d();
            Futures.a(this.f15510n, new C18125(this), this.f15498b);
        }
    }

    public final void mo611a() {
        if (!m15783a(this.f15506j)) {
            this.f15506j.cancel(true);
            this.f15506j = null;
        }
        if (!m15783a(this.f15507k)) {
            this.f15507k.cancel(true);
            this.f15507k = null;
        }
        if (!m15783a(this.f15508l)) {
            this.f15508l.cancel(true);
            this.f15508l = null;
        }
        if (!m15783a(this.f15509m)) {
            this.f15509m.cancel(true);
            this.f15509m = null;
        }
        if (!m15783a(this.f15510n)) {
            this.f15510n.cancel(true);
            this.f15510n = null;
        }
    }

    public static boolean m15783a(ListenableFuture listenableFuture) {
        return listenableFuture == null || listenableFuture.isDone();
    }
}

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
import com.facebook.messaging.payment.model.graphql.PaymentGraphQLInterfaces.Theme;
import com.facebook.messaging.payment.protocol.PaymentProtocolUtil;
import com.facebook.messaging.payment.service.model.eligibility.FetchP2PSendEligibilityResult;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17769;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: eta_in_seconds */
public class OrionRequestMessengerPayLoader implements MessengerPayLoader {
    public final GatekeeperStoreImpl f15637a;
    public final Executor f15638b;
    public final AbstractFbErrorReporter f15639c;
    public final ContactFetchUtil f15640d;
    public final PaymentProtocolUtil f15641e;
    public C17769 f15642f;
    public MessengerPayData f15643g;
    public ListenableFuture<FetchP2PSendEligibilityResult> f15644h;
    public ListenableFuture<Contact> f15645i;
    public ListenableFuture<ArrayList<Theme>> f15646j;

    /* compiled from: eta_in_seconds */
    public class C18301 implements FutureCallback<FetchP2PSendEligibilityResult> {
        final /* synthetic */ OrionRequestMessengerPayLoader f15634a;

        public C18301(OrionRequestMessengerPayLoader orionRequestMessengerPayLoader) {
            this.f15634a = orionRequestMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            this.f15634a.f15643g.m15755a(((FetchP2PSendEligibilityResult) obj).m15170a());
        }

        public void onFailure(Throwable th) {
            this.f15634a.f15639c.a("OrionRequestMessengerPayLoader", "Failed to fetch eligibility of the sender to send money to recipient " + this.f15634a.f15643g.f15460q.b());
            this.f15634a.f15642f.m15639a();
        }
    }

    /* compiled from: eta_in_seconds */
    public class C18312 implements FutureCallback<Contact> {
        final /* synthetic */ OrionRequestMessengerPayLoader f15635a;

        public C18312(OrionRequestMessengerPayLoader orionRequestMessengerPayLoader) {
            this.f15635a = orionRequestMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            this.f15635a.f15643g.m15749a(((Contact) obj).e());
        }

        public void onFailure(Throwable th) {
            this.f15635a.f15639c.a("OrionRequestMessengerPayLoader", StringFormatUtil.a("Failed to fetch the Contact for recipient %s", new Object[]{this.f15635a.f15643g.f15460q.b()}));
        }
    }

    /* compiled from: eta_in_seconds */
    public class C18323 implements FutureCallback<ArrayList<Theme>> {
        final /* synthetic */ OrionRequestMessengerPayLoader f15636a;

        public C18323(OrionRequestMessengerPayLoader orionRequestMessengerPayLoader) {
            this.f15636a = orionRequestMessengerPayLoader;
        }

        public void onSuccess(Object obj) {
            this.f15636a.f15643g.m15758b((ArrayList) obj);
        }

        public void onFailure(Throwable th) {
            this.f15636a.f15639c.a("OrionRequestMessengerPayLoader", "Failed to fetch the theme list");
        }
    }

    public static OrionRequestMessengerPayLoader m15826b(InjectorLike injectorLike) {
        return new OrionRequestMessengerPayLoader(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ContactFetchUtil.b(injectorLike), PaymentProtocolUtil.m14937a(injectorLike));
    }

    @Inject
    public OrionRequestMessengerPayLoader(GatekeeperStoreImpl gatekeeperStoreImpl, Executor executor, AbstractFbErrorReporter abstractFbErrorReporter, ContactFetchUtil contactFetchUtil, PaymentProtocolUtil paymentProtocolUtil) {
        this.f15637a = gatekeeperStoreImpl;
        this.f15638b = executor;
        this.f15639c = abstractFbErrorReporter;
        this.f15640d = contactFetchUtil;
        this.f15641e = paymentProtocolUtil;
    }

    public final void mo613a(C17769 c17769) {
        this.f15642f = c17769;
    }

    public final void mo612a(Bundle bundle, MessengerPayData messengerPayData) {
        this.f15643g = messengerPayData;
        if (m15825a(this.f15644h)) {
            this.f15644h = this.f15641e.m14948a(DataFreshnessParam.PREFER_CACHE_IF_UP_TO_DATE, this.f15643g.f15460q.b());
            Futures.a(this.f15644h, new C18301(this), this.f15638b);
        }
        if (m15825a(this.f15645i)) {
            this.f15645i = this.f15640d.a(this.f15643g.f15460q, DataFreshnessParam.STALE_DATA_OKAY);
            Futures.a(this.f15645i, new C18312(this), this.f15638b);
        }
        if (this.f15637a.a(1038, false) && m15825a(this.f15646j)) {
            this.f15646j = this.f15641e.m14965d();
            Futures.a(this.f15646j, new C18323(this), this.f15638b);
        }
    }

    public final void mo611a() {
        if (!m15825a(this.f15644h)) {
            this.f15644h.cancel(true);
            this.f15644h = null;
        }
        if (!m15825a(this.f15645i)) {
            this.f15645i.cancel(true);
            this.f15645i = null;
        }
    }

    public static boolean m15825a(ListenableFuture listenableFuture) {
        return listenableFuture == null || listenableFuture.isDone();
    }
}

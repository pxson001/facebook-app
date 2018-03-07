package com.facebook.payments.settings;

import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache;
import com.facebook.payments.paymentmethods.picker.PickerScreenDataFetcher;
import com.facebook.payments.paymentmethods.picker.PickerScreenDataFetcher.Listener;
import com.facebook.payments.paymentmethods.picker.PickerScreenParams;
import com.facebook.payments.picker.model.PickerScreenFetcherParams;
import com.facebook.payments.settings.model.PaymentSettingsPickerScreenData;
import com.facebook.payments.settings.model.PaymentSettingsPickerScreenDataBuilder;
import com.facebook.payments.settings.model.PaymentSettingsPickerScreenFetcherParams;
import com.facebook.payments.shipping.model.MailingAddress;
import com.facebook.payments.shipping.protocol.MailingAddressProtocolUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import java.util.concurrent.Executor;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: login_alerts */
public class PaymentSettingsPickerScreenDataFetcher implements PickerScreenDataFetcher<PaymentSettingsPickerScreenParams, PaymentSettingsPickerScreenFetcherParams> {
    public final Executor f8425a;
    public final MailingAddressProtocolUtil f8426b;
    public final Provider<PaymentMethodsInfoCache> f8427c;
    public PaymentSettingsPickerScreenDataBuilder f8428d;
    public ListenableFuture<List<Object>> f8429e;

    public final void m8354a(final Listener listener, PickerScreenParams pickerScreenParams, PickerScreenFetcherParams pickerScreenFetcherParams) {
        Object obj;
        PaymentSettingsPickerScreenParams paymentSettingsPickerScreenParams = (PaymentSettingsPickerScreenParams) pickerScreenParams;
        if (this.f8429e == null || this.f8429e.isDone()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            listener.a();
            PaymentSettingsPickerScreenDataBuilder paymentSettingsPickerScreenDataBuilder = new PaymentSettingsPickerScreenDataBuilder();
            paymentSettingsPickerScreenDataBuilder.f8445c = paymentSettingsPickerScreenParams;
            this.f8428d = paymentSettingsPickerScreenDataBuilder;
            ListenableFuture b = ((PaymentMethodsInfoCache) this.f8427c.get()).b(paymentSettingsPickerScreenParams.m8357a().d, "0");
            Futures.a(b, new ResultFutureCallback<PaymentMethodsInfo>(this) {
                final /* synthetic */ PaymentSettingsPickerScreenDataFetcher f8422b;

                protected final void m8350a(Object obj) {
                    this.f8422b.f8428d.f8443a = (PaymentMethodsInfo) obj;
                }

                protected final void m8349a(ServiceException serviceException) {
                    listener.a(serviceException);
                }
            }, this.f8425a);
            ListenableFuture listenableFuture = b;
            b = this.f8426b.a();
            Futures.a(b, new ResultFutureCallback<ImmutableList<MailingAddress>>(this) {
                final /* synthetic */ PaymentSettingsPickerScreenDataFetcher f8424b;

                protected final void m8352a(Object obj) {
                    this.f8424b.f8428d.f8444b = (ImmutableList) obj;
                }

                protected final void m8351a(ServiceException serviceException) {
                    listener.a(serviceException);
                }
            }, this.f8425a);
            this.f8429e = Futures.b(ImmutableList.of(listenableFuture, b));
            Futures.a(this.f8429e, new ResultFutureCallback<Object>(this) {
                final /* synthetic */ PaymentSettingsPickerScreenDataFetcher f8420b;

                protected final void m8347a(ServiceException serviceException) {
                    listener.a(serviceException);
                }

                protected final void m8348a(Object obj) {
                    listener.a(new PaymentSettingsPickerScreenData(this.f8420b.f8428d));
                }
            }, this.f8425a);
        }
    }

    @Inject
    public PaymentSettingsPickerScreenDataFetcher(Executor executor, MailingAddressProtocolUtil mailingAddressProtocolUtil, Provider<PaymentMethodsInfoCache> provider) {
        this.f8425a = executor;
        this.f8426b = mailingAddressProtocolUtil;
        this.f8427c = provider;
    }

    public final void m8353a() {
        this.f8429e.cancel(true);
    }
}

package com.facebook.payments.paymentmethods.picker;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.http.protocol.ApiException;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.PickerScreenDataFetcher.Listener;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenData;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParams;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.picker.model.PickerScreenFetcherParams;
import com.facebook.ui.futures.TasksManager;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: boost_info_id */
public class PaymentMethodsPickerScreenDataFetcher implements PickerScreenDataFetcher<PickerScreenParams, PaymentMethodsPickerScreenFetcherParams> {
    public static final String f18749a = PaymentMethodsPickerScreenDataFetcher.class.getSimpleName();
    public final AbstractFbErrorReporter f18750b;
    public final Provider<PaymentMethodsInfoCache> f18751c;
    private final TasksManager f18752d;

    public final void mo745a(final Listener listener, final PickerScreenParams pickerScreenParams, PickerScreenFetcherParams pickerScreenFetcherParams) {
        ListenableFuture b;
        PaymentMethodsPickerScreenFetcherParams paymentMethodsPickerScreenFetcherParams = (PaymentMethodsPickerScreenFetcherParams) pickerScreenFetcherParams;
        listener.mo748a();
        C21891 c21891 = new AbstractDisposableFutureCallback<PaymentMethodsInfo>(this) {
            final /* synthetic */ PaymentMethodsPickerScreenDataFetcher f18748c;

            protected final void m18746a(Object obj) {
                listener.mo749a(this.f18748c.mo1079a((PaymentMethodsInfo) obj, pickerScreenParams));
            }

            protected final void m18747a(Throwable th) {
                ApiException apiException = (ApiException) ExceptionUtil.a(th, ApiException.class);
                this.f18748c.f18750b.b(PaymentMethodsPickerScreenDataFetcher.f18749a, "Get Payment Methods Info for the logged-in user failed. " + (apiException != null ? apiException.getMessage() : th.getMessage()), th);
                listener.mo750a(th);
            }
        };
        TasksManager tasksManager = this.f18752d;
        String str = "fetch_payment_methods";
        PickerScreenCommonParams a = pickerScreenParams.mo743a();
        if (paymentMethodsPickerScreenFetcherParams.f18847a) {
            b = ((PaymentMethodsInfoCache) this.f18751c.get()).m18739b(a.f18787d, a.f18789f, paymentMethodsPickerScreenFetcherParams.f18848b, paymentMethodsPickerScreenFetcherParams.f18849c);
        } else {
            b = ((PaymentMethodsInfoCache) this.f18751c.get()).m18737a(a.f18787d, a.f18789f, paymentMethodsPickerScreenFetcherParams.f18848b, paymentMethodsPickerScreenFetcherParams.f18849c);
        }
        tasksManager.b(str, b, c21891);
    }

    @Inject
    public PaymentMethodsPickerScreenDataFetcher(FbErrorReporter fbErrorReporter, Provider<PaymentMethodsInfoCache> provider, TasksManager tasksManager) {
        this.f18750b = fbErrorReporter;
        this.f18751c = provider;
        this.f18752d = tasksManager;
    }

    protected PickerScreenData mo1079a(PaymentMethodsInfo paymentMethodsInfo, PickerScreenParams pickerScreenParams) {
        return new PaymentMethodsPickerScreenData(paymentMethodsInfo, pickerScreenParams, pickerScreenParams.mo743a().f18784a.f18813b == null ? null : pickerScreenParams.mo743a().f18784a.f18813b.a());
    }

    public final void mo744a() {
        this.f18752d.c();
    }
}

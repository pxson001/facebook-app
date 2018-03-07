package com.facebook.payments.paymentmethods.picker;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.util.ExceptionUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.http.protocol.ApiException;
import com.facebook.payments.paymentmethods.model.PayPalBillingAgreement;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.PickerScreenDataFetcher.Listener;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenData;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParams;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParamsBuilder;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;
import javax.inject.Inject;

/* compiled from: emitNavigationEvent() not supported yet */
public class PaymentMethodsPickerScreenOnActivityResultHandler implements PickerScreenOnActivityResultHandler {
    public static final String f15825d = PaymentMethodsPickerScreenOnActivityResultHandler.class.getSimpleName();
    protected final SimplePickerScreenManager f15826a;
    protected SimplePaymentsComponentCallback f15827b;
    protected PaymentsLoadingIndicatorHelper f15828c;
    public final AbstractFbErrorReporter f15829e;
    private final AnalyticsLogger f15830f;

    @Inject
    public PaymentMethodsPickerScreenOnActivityResultHandler(AbstractFbErrorReporter abstractFbErrorReporter, AnalyticsLogger analyticsLogger, SimplePickerScreenManager simplePickerScreenManager) {
        this.f15829e = abstractFbErrorReporter;
        this.f15830f = analyticsLogger;
        this.f15826a = simplePickerScreenManager;
    }

    public final void mo649a(SimplePaymentsComponentCallback simplePaymentsComponentCallback, PaymentsLoadingIndicatorHelper paymentsLoadingIndicatorHelper) {
        this.f15827b = simplePaymentsComponentCallback;
        this.f15828c = paymentsLoadingIndicatorHelper;
    }

    public boolean mo650a(PickerScreenData pickerScreenData, int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                if (i2 != -1) {
                    return true;
                }
                m16012a(this, pickerScreenData.mo752a(), i, intent);
                return true;
            case 2:
                m16012a(this, pickerScreenData.mo752a(), i, intent);
                return true;
            default:
                return false;
        }
    }

    private void m16014a(PickerScreenData pickerScreenData, PaymentMethodsInfo paymentMethodsInfo) {
        PaymentMethod paymentMethod = (PayPalBillingAgreement) FluentIterable.a(paymentMethodsInfo.d).a(PayPalBillingAgreement.class).a().orNull();
        if (paymentMethod == null) {
            m16016b();
        } else {
            m16017a(pickerScreenData, paymentMethod);
        }
    }

    public static void m16012a(PaymentMethodsPickerScreenOnActivityResultHandler paymentMethodsPickerScreenOnActivityResultHandler, final PickerScreenParams pickerScreenParams, final int i, final Intent intent) {
        Preconditions.checkNotNull(paymentMethodsPickerScreenOnActivityResultHandler.f15828c);
        Listener c21911 = new Listener(paymentMethodsPickerScreenOnActivityResultHandler) {
            final /* synthetic */ PaymentMethodsPickerScreenOnActivityResultHandler f18758d;

            /* compiled from: emitNavigationEvent() not supported yet */
            class C21901 implements RetryClickedListener {
                final /* synthetic */ C21911 f18754a;

                C21901(C21911 c21911) {
                    this.f18754a = c21911;
                }

                public final void m18757a() {
                    PaymentMethodsPickerScreenOnActivityResultHandler.m16012a(this.f18754a.f18758d, pickerScreenParams, i, intent);
                }
            }

            public final void mo748a() {
                this.f18758d.f15828c.m18776a();
            }

            public final void mo749a(PickerScreenData pickerScreenData) {
                PaymentMethodsPickerScreenOnActivityResultHandler.m16013a(this.f18758d, pickerScreenData, i, intent);
            }

            public final void mo750a(Throwable th) {
                ApiException apiException = (ApiException) ExceptionUtil.a(th, ApiException.class);
                this.f18758d.f15829e.b(PaymentMethodsPickerScreenOnActivityResultHandler.f15825d, "Get Payment Methods Info for the logged-in user failed. " + (apiException != null ? apiException.getMessage() : th.getMessage()), th);
                this.f18758d.f15828c.m18777a(new C21901(this));
            }
        };
        PaymentMethodsPickerScreenFetcherParamsBuilder newBuilder = PaymentMethodsPickerScreenFetcherParams.newBuilder();
        PaymentMethodsPickerScreenFetcherParams paymentMethodsPickerScreenFetcherParams = (PaymentMethodsPickerScreenFetcherParams) pickerScreenParams.mo743a().f18792i;
        newBuilder.f18850a = paymentMethodsPickerScreenFetcherParams.f18847a;
        PaymentMethodsPickerScreenFetcherParamsBuilder paymentMethodsPickerScreenFetcherParamsBuilder = newBuilder;
        paymentMethodsPickerScreenFetcherParamsBuilder.f18851b = paymentMethodsPickerScreenFetcherParams.f18848b;
        paymentMethodsPickerScreenFetcherParamsBuilder = paymentMethodsPickerScreenFetcherParamsBuilder;
        paymentMethodsPickerScreenFetcherParamsBuilder.f18852c = paymentMethodsPickerScreenFetcherParams.f18849c;
        PaymentMethodsPickerScreenFetcherParamsBuilder paymentMethodsPickerScreenFetcherParamsBuilder2 = paymentMethodsPickerScreenFetcherParamsBuilder;
        paymentMethodsPickerScreenFetcherParamsBuilder2.f18850a = true;
        paymentMethodsPickerScreenOnActivityResultHandler.f15826a.m18836b(pickerScreenParams.mo743a().f18786c).mo745a(c21911, pickerScreenParams, paymentMethodsPickerScreenFetcherParamsBuilder2.m18855d());
    }

    public static void m16013a(PaymentMethodsPickerScreenOnActivityResultHandler paymentMethodsPickerScreenOnActivityResultHandler, PickerScreenData pickerScreenData, int i, Intent intent) {
        PaymentMethodsInfo paymentMethodsInfo = ((PaymentMethodsPickerScreenData) pickerScreenData).f18844a;
        switch (i) {
            case 1:
                paymentMethodsPickerScreenOnActivityResultHandler.m16015a(pickerScreenData, paymentMethodsInfo, intent);
                return;
            case 2:
                paymentMethodsPickerScreenOnActivityResultHandler.m16014a(pickerScreenData, paymentMethodsInfo);
                return;
            default:
                throw new UnsupportedOperationException("Unknown request code " + i);
        }
    }

    private void m16015a(PickerScreenData pickerScreenData, PaymentMethodsInfo paymentMethodsInfo, Intent intent) {
        Object stringExtra = intent.getStringExtra("encoded_credential_id");
        if (StringUtil.a(stringExtra)) {
            m16016b();
            return;
        }
        m16017a(pickerScreenData, (PaymentMethod) Preconditions.checkNotNull(paymentMethodsInfo.a(stringExtra), "Added credential %s was not returned by server as an available payment method, among %s", new Object[]{stringExtra, paymentMethodsInfo.d}));
    }

    protected final void m16017a(PickerScreenData pickerScreenData, PaymentMethod paymentMethod) {
        Parcelable intent = new Intent();
        intent.putExtra("selected_payment_method", paymentMethod);
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_activity_result_data", intent);
        PickerScreenParams a = pickerScreenData.mo752a();
        this.f15830f.a(PickerScreenAnalyticsEvent.m18788c("payments_payment_method_selected", a.mo743a().f18785b.f18776a).m18786a(a.mo743a()).m18787a(paymentMethod.a()).f18775a);
        this.f15827b.a(new PaymentsComponentAction(Action.FINISH_ACTIVITY, bundle));
    }

    private void m16016b() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("extra_reset_data", PaymentMethodsPickerScreenFetcherParams.newBuilder().m18855d());
        this.f15827b.a(new PaymentsComponentAction(Action.RESET, bundle));
    }
}

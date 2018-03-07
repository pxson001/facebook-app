package com.facebook.payments.paymentsflow.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.paymentmethods.model.PaymentMethodsInfo;
import com.facebook.payments.paymentmethods.picker.PaymentMethodsInfoCache;
import com.facebook.payments.paymentmethods.picker.PickerScreenActivity;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenAnalyticsParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenCommonParamsBuilder;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyle;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenStyleParamsBuilder;
import com.facebook.payments.paymentmethods.picker.model.PaymentMethodsPickerScreenFetcherParams;
import com.facebook.payments.paymentsflow.PayViewAnalyticsEvent;
import com.facebook.payments.paymentsflow.PayViewControllerParams;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: pageData */
public class PayViewController {
    public static final String f4390a = PayViewController.class.getSimpleName();
    public final Context f4391b;
    public final AnalyticsLogger f4392c;
    public final SecureContextHelper f4393d;
    private final TasksManager f4394e;
    private final PaymentMethodsInfoCache f4395f;
    public final AbstractFbErrorReporter f4396g;
    public PayViewControllerParams f4397h;
    private boolean f4398i;
    @Nullable
    public String f4399j;
    @Nullable
    public PaymentMethod f4400k;
    private OnClickListener f4401l;
    @Nullable
    public PaymentMethodChangeListener f4402m;
    private Runnable f4403n;
    private Runnable f4404o;
    @Nullable
    public PayView f4405p;

    /* compiled from: pageData */
    class C06091 implements Runnable {
        final /* synthetic */ PayViewController f4380a;

        C06091(PayViewController payViewController) {
            this.f4380a = payViewController;
        }

        public void run() {
            this.f4380a.f4392c;
        }
    }

    /* compiled from: pageData */
    class C06102 implements Runnable {
        final /* synthetic */ PayViewController f4381a;

        C06102(PayViewController payViewController) {
            this.f4381a = payViewController;
        }

        public void run() {
            this.f4381a.m5391b(this.f4381a.f4399j);
        }
    }

    /* compiled from: pageData */
    abstract class PaymentMethodInfoFetchedCallback extends AbstractDisposableFutureCallback<PaymentMethodsInfo> {
        private final Runnable f4385a;
        final /* synthetic */ PayViewController f4386c;

        protected PaymentMethodInfoFetchedCallback(PayViewController payViewController, Runnable runnable) {
            this.f4386c = payViewController;
            this.f4385a = runnable;
        }

        protected final void m5367a(Throwable th) {
            this.f4386c.f4392c.a(PayViewAnalyticsEvent.m5361c("payments_fetch_payment_info_failed", this.f4386c.f4397h.f4364a).m5358a(this.f4386c.f4397h).m5360b(th.getMessage()).f4363a);
            this.f4386c.f4396g.a(PayViewController.f4390a, th);
            if (this.f4386c.f4402m != null) {
                this.f4386c.f4402m.a(this.f4385a);
            }
        }
    }

    /* compiled from: pageData */
    enum TaskId {
        GET_PAYMENT_METHOD_DATA,
        GET_DEFAULT_PAYMENT_METHOD
    }

    public static PayViewController m5373b(InjectorLike injectorLike) {
        return new PayViewController((Context) injectorLike.getInstance(Context.class), AnalyticsLoggerMethodAutoProvider.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), TasksManager.b(injectorLike), PaymentMethodsInfoCache.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public static PayViewController m5370a(InjectorLike injectorLike) {
        return m5373b(injectorLike);
    }

    @Inject
    public PayViewController(Context context, AnalyticsLogger analyticsLogger, SecureContextHelper secureContextHelper, TasksManager tasksManager, PaymentMethodsInfoCache paymentMethodsInfoCache, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f4391b = context;
        this.f4392c = analyticsLogger;
        this.f4393d = secureContextHelper;
        this.f4394e = tasksManager;
        this.f4395f = paymentMethodsInfoCache;
        this.f4396g = abstractFbErrorReporter;
    }

    public final void m5386a(PayViewControllerParams payViewControllerParams, final int i, PaymentMethodChangeListener paymentMethodChangeListener, final Fragment fragment) {
        Preconditions.checkState(!this.f4398i, "PayView was already initialized.");
        this.f4397h = payViewControllerParams;
        this.f4403n = new C06091(this);
        this.f4404o = new C06102(this);
        this.f4402m = paymentMethodChangeListener;
        this.f4392c;
        this.f4401l = new OnClickListener(this) {
            final /* synthetic */ PayViewController f4384c;

            public void onClick(View view) {
                PaymentMethod paymentMethod;
                int a = Logger.a(2, EntryType.UI_INPUT_START, -983620612);
                PickerScreenAnalyticsParamsBuilder newBuilder = PickerScreenAnalyticsParams.newBuilder();
                newBuilder.a = this.f4384c.f4397h.f4364a;
                newBuilder = newBuilder;
                newBuilder.b = this.f4384c.f4397h.f4365b;
                newBuilder = newBuilder;
                newBuilder.c = this.f4384c.f4397h.f4366c;
                PickerScreenAnalyticsParams e = newBuilder.e();
                PickerScreenStyleParamsBuilder newBuilder2 = PickerScreenStyleParams.newBuilder();
                if (this.f4384c.f4400k == null) {
                    paymentMethod = null;
                } else {
                    paymentMethod = this.f4384c.f4400k;
                }
                newBuilder2.b = paymentMethod;
                PickerScreenStyleParams c = newBuilder2.c();
                String string = this.f4384c.f4400k != null ? this.f4384c.f4391b.getString(2131233858) : this.f4384c.f4391b.getString(2131233857);
                PickerScreenCommonParamsBuilder newBuilder3 = PickerScreenCommonParams.newBuilder();
                newBuilder3.a = e;
                PickerScreenCommonParamsBuilder pickerScreenCommonParamsBuilder = newBuilder3;
                pickerScreenCommonParamsBuilder.b = c;
                pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
                pickerScreenCommonParamsBuilder.c = PickerScreenStyle.PAYMENT_METHODS;
                pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
                pickerScreenCommonParamsBuilder.d = this.f4384c.f4397h.f4367d;
                pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
                pickerScreenCommonParamsBuilder.e = this.f4384c.f4397h.f4368e;
                pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
                pickerScreenCommonParamsBuilder.h = PaymentMethodsPickerScreenFetcherParams.newBuilder().d();
                pickerScreenCommonParamsBuilder = pickerScreenCommonParamsBuilder;
                pickerScreenCommonParamsBuilder.g = string;
                this.f4384c.f4393d.a(PickerScreenActivity.a(view.getContext(), pickerScreenCommonParamsBuilder.j()), i, fragment);
                LogUtils.a(-484873032, a);
            }
        };
        this.f4392c.a(PayViewAnalyticsEvent.m5361c("payments_select_payment_method_view_shown", this.f4397h.f4364a).m5358a(this.f4397h).m5359a(this.f4399j).f4363a);
        this.f4398i = true;
    }

    public static void m5381g(PayViewController payViewController) {
        payViewController.f4394e.b(TaskId.GET_DEFAULT_PAYMENT_METHOD, payViewController.f4395f.b(payViewController.f4397h.f4367d, "0"), new PaymentMethodInfoFetchedCallback(payViewController, payViewController.f4404o) {
            final /* synthetic */ PayViewController f4387a;

            protected final void m5368a(Object obj) {
                PaymentMethod paymentMethod;
                PaymentMethodsInfo paymentMethodsInfo = (PaymentMethodsInfo) obj;
                PayViewController payViewController = this.f4387a;
                ImmutableList immutableList = this.f4387a.f4397h.f4368e;
                int size = paymentMethodsInfo.d.size();
                for (int i = 0; i < size; i++) {
                    paymentMethod = (PaymentMethod) paymentMethodsInfo.d.get(i);
                    if (!immutableList.contains(paymentMethod.b().toNewPaymentOptionType())) {
                        break;
                    }
                }
                paymentMethod = null;
                payViewController.m5385a(paymentMethod);
            }
        });
    }

    public final void m5388a(String str) {
        this.f4392c.a(PayViewAnalyticsEvent.m5361c(str, this.f4397h.f4364a).m5358a(this.f4397h).m5359a(this.f4399j).f4363a);
    }

    public final void m5389a(String str, String str2) {
        this.f4392c.a(PayViewAnalyticsEvent.m5361c(str, this.f4397h.f4364a).m5358a(this.f4397h).m5359a(this.f4399j).m5360b(str2).f4363a);
    }

    public final void m5384a() {
        this.f4398i = false;
        this.f4394e.c();
    }

    public final String m5390b() {
        return this.f4399j;
    }

    public final void m5391b(final String str) {
        this.f4394e.c(TaskId.GET_DEFAULT_PAYMENT_METHOD);
        ListenableFuture a = this.f4395f.a(this.f4397h.f4367d, "0", null);
        C06135 c06135 = new PaymentMethodInfoFetchedCallback(this, this.f4403n) {
            final /* synthetic */ PayViewController f4389b;

            protected final void m5369a(Object obj) {
                this.f4389b.m5385a(((PaymentMethodsInfo) obj).a(str));
            }
        };
        this.f4400k = null;
        m5371a(TaskId.GET_PAYMENT_METHOD_DATA, a, c06135);
    }

    private <T> void m5371a(TaskId taskId, ListenableFuture<T> listenableFuture, AbstractDisposableFutureCallback<T> abstractDisposableFutureCallback) {
        if (listenableFuture.isDone()) {
            Futures.a(listenableFuture, abstractDisposableFutureCallback, MoreExecutors.a());
        } else {
            this.f4394e.b(taskId, listenableFuture, abstractDisposableFutureCallback);
        }
    }

    @Nullable
    public final PaymentMethod m5392c() {
        return this.f4400k;
    }

    public final void m5385a(PaymentMethod paymentMethod) {
        this.f4400k = paymentMethod;
        if (this.f4405p != null) {
            this.f4405p.m5366b(this);
        }
        if (this.f4402m != null) {
            this.f4402m.a(paymentMethod);
        }
    }

    final OnClickListener m5393d() {
        Preconditions.checkState(this.f4398i);
        return this.f4401l;
    }

    public final boolean m5394e() {
        Preconditions.checkState(this.f4398i);
        return this.f4394e.a();
    }

    final void m5387a(PayView payView) {
        this.f4405p = payView;
    }
}

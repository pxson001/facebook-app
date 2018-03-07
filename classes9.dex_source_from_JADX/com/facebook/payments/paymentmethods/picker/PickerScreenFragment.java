package com.facebook.payments.paymentmethods.picker;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.base.fragment.CanHandleBackPressed;
import com.facebook.base.fragment.FbListFragment;
import com.facebook.common.executors.ForUiThread;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.ResultFutureCallback;
import com.facebook.fbservice.service.ServiceException;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.paymentmethods.picker.PickerScreenDataFetcher.Listener;
import com.facebook.payments.paymentmethods.picker.model.PickerScreenData;
import com.facebook.payments.picker.RowItemView;
import com.facebook.payments.picker.model.PickerScreenFetcherParams;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.facebook.payments.ui.titlebar.PaymentsTitleBarViewStub;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.widget.loadingindicator.LoadingIndicator.RetryClickedListener;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: bookmark_groups */
public class PickerScreenFragment extends FbListFragment implements CanHandleBackPressed {
    @Inject
    PickerScreenAdapter al;
    @Inject
    SimplePickerScreenManager am;
    @Inject
    SecureContextHelper an;
    @Inject
    @ForUiThread
    public Executor ao;
    private Context ap;
    private ListView aq;
    public ListenableFuture ar;
    public PaymentsLoadingIndicatorHelper as;
    @Nullable
    public PickerScreenData at;
    private PickerScreenDataFetcher au;
    public PickerScreenParams av;
    private RowItemsGenerator aw;
    private PickerScreenDataMutator ax;
    private final SimplePaymentsComponentCallback ay = new C21981(this);
    @Inject
    AnalyticsLogger f18811i;

    /* compiled from: bookmark_groups */
    class C21981 extends SimplePaymentsComponentCallback {
        final /* synthetic */ PickerScreenFragment f18802a;

        C21981(PickerScreenFragment pickerScreenFragment) {
            this.f18802a = pickerScreenFragment;
        }

        public final void m18802a(FbDialogFragment fbDialogFragment) {
            fbDialogFragment.a(this.f18802a.kO_(), "payments_dialog_fragment");
        }

        public final void m18800a(Intent intent, int i) {
            this.f18802a.an.a(intent, i, this.f18802a);
        }

        public final void m18804b(Intent intent) {
            this.f18802a.an.b(intent, this.f18802a.getContext());
        }

        public final void m18805b(Intent intent, int i) {
            this.f18802a.an.b(intent, i, this.f18802a);
        }

        public final void m18801a(PaymentsComponentAction paymentsComponentAction) {
            PickerScreenFragment.m18816a(this.f18802a, paymentsComponentAction);
        }

        public final void m18803a(ListenableFuture listenableFuture) {
            PickerScreenFragment pickerScreenFragment = this.f18802a;
            if (pickerScreenFragment.ar != null) {
                pickerScreenFragment.ar.cancel(true);
            }
            pickerScreenFragment.as.m18776a();
            pickerScreenFragment.ar = listenableFuture;
            Futures.a(pickerScreenFragment.ar, new C22035(pickerScreenFragment), pickerScreenFragment.ao);
        }
    }

    /* compiled from: bookmark_groups */
    public class C21992 {
        final /* synthetic */ PickerScreenFragment f18803a;

        C21992(PickerScreenFragment pickerScreenFragment) {
            this.f18803a = pickerScreenFragment;
        }

        public final void m18806a(PickerScreenData pickerScreenData) {
            this.f18803a.at = pickerScreenData;
            PickerScreenFragment.ao(this.f18803a);
        }
    }

    /* compiled from: bookmark_groups */
    public class C22035 extends ResultFutureCallback<Object> {
        final /* synthetic */ PickerScreenFragment f18809a;

        public C22035(PickerScreenFragment pickerScreenFragment) {
            this.f18809a = pickerScreenFragment;
        }

        protected final void m18813a(Object obj) {
            this.f18809a.as.m18778b();
        }

        protected final void m18812a(ServiceException serviceException) {
            this.f18809a.as.m18778b();
        }
    }

    /* compiled from: bookmark_groups */
    /* synthetic */ class C22046 {
        static final /* synthetic */ int[] f18810a = new int[Action.values().length];

        static {
            try {
                f18810a[Action.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18810a[Action.FINISH_ACTIVITY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18810a[Action.USER_ACTION.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static void m18817a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((PickerScreenFragment) obj).m18814a(AnalyticsLoggerMethodAutoProvider.a(injectorLike), new PickerScreenAdapter((Context) injectorLike.getInstance(Context.class), SimplePickerScreenManager.m18833a(injectorLike)), SimplePickerScreenManager.m18833a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike));
    }

    private void m18814a(AnalyticsLogger analyticsLogger, PickerScreenAdapter pickerScreenAdapter, SimplePickerScreenManager simplePickerScreenManager, SecureContextHelper secureContextHelper, Executor executor) {
        this.f18811i = analyticsLogger;
        this.al = pickerScreenAdapter;
        this.am = simplePickerScreenManager;
        this.an = secureContextHelper;
        this.ao = executor;
    }

    public final void m18822a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 486458799);
        super.a(bundle);
        this.ap = ContextUtils.a(getContext(), 2130772893, 2131624691);
        Class cls = PickerScreenFragment.class;
        m18817a((Object) this, this.ap);
        this.av = (PickerScreenParams) this.s.getParcelable("extra_picker_screen_param");
        if (this.at == null && bundle != null) {
            this.at = (PickerScreenData) bundle.getParcelable("picker_screen_data");
        }
        this.au = this.am.m18836b(this.av.mo743a().f18786c);
        this.aw = this.am.m18838d(this.av.mo743a().f18786c);
        PickerScreenAdapter pickerScreenAdapter = this.al;
        PickerScreenParams pickerScreenParams = this.av;
        pickerScreenAdapter.f18773b = this.ay;
        pickerScreenAdapter.f18774c = pickerScreenAdapter.f18772a.m18842h(pickerScreenParams.mo743a().f18786c);
        this.ax = this.am.m18840f(this.av.mo743a().f18786c);
        this.ax.mo746a(new C21992(this));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -635774200, a);
    }

    public final View m18820a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1931284556);
        View inflate = layoutInflater.cloneInContext(this.ap).inflate(2130904450, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 957769214, a);
        return inflate;
    }

    public final void m18824a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.aq = (ListView) e(16908298);
        this.aq.setAdapter(this.al);
        final Activity activity = (Activity) ContextUtils.a(getContext(), Activity.class);
        PaymentsTitleBarViewStub paymentsTitleBarViewStub = (PaymentsTitleBarViewStub) e(2131558562);
        PaymentsDecoratorParams paymentsDecoratorParams = this.av.mo743a().f18784a.f18812a;
        paymentsTitleBarViewStub.a((ViewGroup) this.T, new OnBackPressedListener(this) {
            final /* synthetic */ PickerScreenFragment f18805b;

            public final void m18807a() {
                activity.onBackPressed();
            }
        }, paymentsDecoratorParams.b.getTitleBarStyle(), paymentsDecoratorParams.a.getTitleBarNavIconStyle());
        paymentsTitleBarViewStub.c.setTitle(this.av.mo743a().f18790g);
        this.as = new PaymentsLoadingIndicatorHelper((LoadingIndicatorView) e(2131560537), this.aq);
        if (this.at != null) {
            ao(this);
        } else {
            m18815a(this, this.av.mo743a().f18792i);
        }
        this.f18811i.a(PickerScreenAnalyticsEvent.m18788c("payments_initiate_select_card", this.av.mo743a().f18785b.f18776a).m18786a(this.av.mo743a()).f18775a);
    }

    public final void m18823a(View view, int i) {
        ((RowItemView) view).mo658a();
    }

    public final void m18819I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1049415500);
        super.I();
        if (this.au != null) {
            this.au.mo744a();
        }
        if (this.ar != null) {
            this.ar.cancel(true);
            this.ar = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1374833661, a);
    }

    public final void m18821a(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
            case 2:
            case 101:
            case 102:
            case 201:
            case 301:
            case 402:
                PickerScreenOnActivityResultHandler e = this.am.m18839e(this.av.mo743a().f18786c);
                e.mo649a(this.ay, this.as);
                e.mo650a(this.at, i, i2, intent);
                return;
            default:
                super.a(i, i2, intent);
                return;
        }
    }

    public final void m18825e(Bundle bundle) {
        bundle.putParcelable("picker_screen_data", this.at);
        super.e(bundle);
    }

    public final boolean O_() {
        m18818b(this.at == null ? null : this.at.mo753b());
        return false;
    }

    public static void m18815a(PickerScreenFragment pickerScreenFragment, final PickerScreenFetcherParams pickerScreenFetcherParams) {
        pickerScreenFragment.au.mo745a(new Listener(pickerScreenFragment) {
            final /* synthetic */ PickerScreenFragment f18808b;

            /* compiled from: bookmark_groups */
            class C22011 implements RetryClickedListener {
                final /* synthetic */ C22024 f18806a;

                C22011(C22024 c22024) {
                    this.f18806a = c22024;
                }

                public final void m18808a() {
                    PickerScreenFragment.m18815a(this.f18806a.f18808b, pickerScreenFetcherParams);
                }
            }

            public final void mo748a() {
                this.f18808b.as.m18776a();
            }

            public final void mo749a(PickerScreenData pickerScreenData) {
                this.f18808b.as.m18778b();
                this.f18808b.at = pickerScreenData;
                PickerScreenFragment.ao(this.f18808b);
            }

            public final void mo750a(Throwable th) {
                this.f18808b.as.m18777a(new C22011(this));
            }
        }, pickerScreenFragment.av, pickerScreenFetcherParams);
    }

    public static void m18816a(PickerScreenFragment pickerScreenFragment, PaymentsComponentAction paymentsComponentAction) {
        switch (C22046.f18810a[paymentsComponentAction.a.ordinal()]) {
            case 1:
                Parcelable a = paymentsComponentAction.a("extra_reset_data");
                Preconditions.checkNotNull(a);
                if (a instanceof PickerScreenData) {
                    pickerScreenFragment.at = (PickerScreenData) a;
                    ao(pickerScreenFragment);
                    return;
                } else if (a instanceof PickerScreenFetcherParams) {
                    m18815a(pickerScreenFragment, (PickerScreenFetcherParams) a);
                    return;
                } else {
                    return;
                }
            case 2:
                Activity activity = (Activity) ContextUtils.a(pickerScreenFragment.getContext(), Activity.class);
                if (activity != null) {
                    pickerScreenFragment.m18818b((Intent) paymentsComponentAction.a("extra_activity_result_data"));
                    activity.finish();
                    return;
                }
                return;
            case 3:
                String a2 = paymentsComponentAction.a("extra_user_action", null);
                if (a2 != null) {
                    pickerScreenFragment.ax.mo747a(pickerScreenFragment.at, a2);
                    return;
                }
                return;
            default:
                return;
        }
    }

    private void m18818b(@Nullable Intent intent) {
        Activity activity = (Activity) ContextUtils.a(getContext(), Activity.class);
        if (activity != null) {
            if (intent != null) {
                activity.setResult(-1, intent);
            } else {
                activity.setResult(0);
            }
        }
    }

    public static void ao(PickerScreenFragment pickerScreenFragment) {
        Preconditions.checkNotNull(pickerScreenFragment.at);
        ImmutableList a = pickerScreenFragment.aw.mo652a(pickerScreenFragment.at);
        pickerScreenFragment.al.setNotifyOnChange(false);
        pickerScreenFragment.al.clear();
        pickerScreenFragment.al.addAll(a);
        AdapterDetour.a(pickerScreenFragment.al, 1872306818);
    }
}

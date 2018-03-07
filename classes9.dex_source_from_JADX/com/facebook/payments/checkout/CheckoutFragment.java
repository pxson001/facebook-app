package com.facebook.payments.checkout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.checkout.model.CheckoutData;
import com.facebook.payments.checkout.model.SimpleCheckoutData;
import com.facebook.payments.checkout.model.SimpleCheckoutDataBuilder;
import com.facebook.payments.checkout.recyclerview.CheckoutAdapter;
import com.facebook.payments.checkout.recyclerview.SimpleCheckoutRowsGenerator;
import com.facebook.payments.checkout.statemachine.CheckoutStateMachineState;
import com.facebook.payments.checkout.statemachine.SimpleCheckoutStateMachineHandler;
import com.facebook.payments.decorator.PaymentsActivityDecorator;
import com.facebook.payments.decorator.PaymentsDecoratorParams;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.facebook.payments.ui.titlebar.PaymentsTitleBarViewStub;
import com.facebook.widget.recyclerview.ContentWrappingLinearLayoutManager;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: card_number */
public class CheckoutFragment extends FbFragment {
    @Inject
    public CheckoutAdapter f18471a;
    public CheckoutData al;
    public SimpleCheckoutDataMutator am;
    public SimpleCheckoutOnActivityResultHandler an;
    public SimpleCheckoutStateMachineHandler ao;
    public ListenableFuture ap;
    public ListenableFuture<Object> aq;
    public final SimplePaymentsComponentCallback ar = new C21351(this);
    @Inject
    public SimpleCheckoutManager f18472b;
    @Inject
    public PaymentsActivityDecorator f18473c;
    @Inject
    public SecureContextHelper f18474d;
    private Context f18475e;
    public ViewGroup f18476f;
    public ProgressBar f18477g;
    private RecyclerView f18478h;
    public CheckoutParams f18479i;

    /* compiled from: card_number */
    class C21351 extends SimplePaymentsComponentCallback {
        final /* synthetic */ CheckoutFragment f18464a;

        C21351(CheckoutFragment checkoutFragment) {
            this.f18464a = checkoutFragment;
        }

        public final void m18463a(Intent intent) {
            this.f18464a.f18474d.a(intent, this.f18464a.getContext());
        }

        public final void m18464a(Intent intent, int i) {
            this.f18464a.f18474d.a(intent, i, this.f18464a);
        }

        public final void m18467b(Intent intent) {
            this.f18464a.f18474d.b(intent, this.f18464a.getContext());
        }

        public final void m18465a(PaymentsComponentAction paymentsComponentAction) {
            CheckoutFragment.m18472a(this.f18464a, paymentsComponentAction);
        }

        public final void m18466a(ListenableFuture listenableFuture) {
            this.f18464a.ap = listenableFuture;
        }
    }

    /* compiled from: card_number */
    public class C21373 {
        final /* synthetic */ CheckoutFragment f18467a;

        public C21373(CheckoutFragment checkoutFragment) {
            this.f18467a = checkoutFragment;
        }

        public final void m18469a(CheckoutData checkoutData) {
            this.f18467a.al = checkoutData;
            CheckoutFragment.au(this.f18467a);
        }
    }

    /* compiled from: card_number */
    public class C21384 {
        public final /* synthetic */ CheckoutFragment f18468a;

        public C21384(CheckoutFragment checkoutFragment) {
            this.f18468a = checkoutFragment;
        }
    }

    /* compiled from: card_number */
    public class C21395 {
        public final /* synthetic */ CheckoutFragment f18469a;

        public C21395(CheckoutFragment checkoutFragment) {
            this.f18469a = checkoutFragment;
        }

        public final void m18470a() {
            CheckoutFragment.ay(this.f18469a);
            CheckoutFragment.au(this.f18469a);
        }

        public final void m18471b() {
            CheckoutFragment.ay(this.f18469a);
        }
    }

    /* compiled from: card_number */
    /* synthetic */ class C21406 {
        static final /* synthetic */ int[] f18470a = new int[Action.values().length];

        static {
            try {
                f18470a[Action.USER_ACTION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18470a[Action.FINISH_ACTIVITY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18470a[Action.RESET.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public static void m18473a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        CheckoutFragment checkoutFragment = (CheckoutFragment) obj;
        CheckoutAdapter checkoutAdapter = new CheckoutAdapter(SimpleCheckoutManager.m18489a(injectorLike));
        SimpleCheckoutManager a = SimpleCheckoutManager.m18489a(injectorLike);
        PaymentsActivityDecorator b = PaymentsActivityDecorator.b(injectorLike);
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike);
        checkoutFragment.f18471a = checkoutAdapter;
        checkoutFragment.f18472b = a;
        checkoutFragment.f18473c = b;
        checkoutFragment.f18474d = secureContextHelper;
    }

    public final void m18479c(Bundle bundle) {
        super.c(bundle);
        this.f18475e = ContextUtils.a(getContext(), 2130772893, 2131624691);
        Class cls = CheckoutFragment.class;
        m18473a((Object) this, this.f18475e);
    }

    public final View m18476a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -989038260);
        View inflate = layoutInflater.cloneInContext(this.f18475e).inflate(2130903568, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2141003238, a);
        return inflate;
    }

    public final void m18477a(int i, int i2, Intent intent) {
        switch (i) {
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
                this.an.m18497a(this.al, i, i2, intent);
                return;
            case 105:
            case 106:
                SimpleCheckoutStateMachineHandler simpleCheckoutStateMachineHandler = this.ao;
                switch (i) {
                    case 105:
                        if (i2 != -1) {
                            SimpleCheckoutStateMachineHandler.m18607g(simpleCheckoutStateMachineHandler);
                            break;
                        }
                        simpleCheckoutStateMachineHandler.f18584c.m15939a(simpleCheckoutStateMachineHandler.f18586e, intent.getStringExtra("user_entered_pin"));
                        SimpleCheckoutStateMachineHandler.m18608h(simpleCheckoutStateMachineHandler);
                        break;
                    case 106:
                        if (i2 != -1) {
                            SimpleCheckoutStateMachineHandler.m18607g(simpleCheckoutStateMachineHandler);
                            break;
                        } else {
                            simpleCheckoutStateMachineHandler.f18585d.a(new PaymentsComponentAction(Action.RESET));
                            break;
                        }
                }
                return;
            default:
                super.a(i, i2, intent);
                return;
        }
    }

    public final void m18478a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.f18479i = (CheckoutParams) this.s.getParcelable("checkout_params");
        Preconditions.checkNotNull(this.f18479i);
        this.f18478h = (RecyclerView) e(2131559427);
        PaymentsActivityDecorator paymentsActivityDecorator = this.f18473c;
        RecyclerView recyclerView = this.f18478h;
        if (paymentsActivityDecorator.a.a(403, false)) {
            recyclerView.setLayoutManager(new ContentWrappingLinearLayoutManager(recyclerView.getContext()));
        } else {
            recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        }
        this.f18478h.setAdapter(this.f18471a);
        this.f18476f = (ViewGroup) e(2131560315);
        this.f18477g = (ProgressBar) e(2131559418);
        m18474n(bundle);
    }

    public final void m18480e(Bundle bundle) {
        bundle.putParcelable("checkout_data", this.al);
        super.e(bundle);
    }

    private void m18474n(@Nullable Bundle bundle) {
        SimpleCheckoutOnActivityResultHandler simpleCheckoutOnActivityResultHandler;
        SimpleCheckoutStateMachineHandler simpleCheckoutStateMachineHandler;
        if (bundle == null) {
            SimpleCheckoutDataBuilder newBuilder = SimpleCheckoutData.newBuilder();
            newBuilder.f18503a = this.f18479i;
            newBuilder = newBuilder;
            newBuilder.f18513k = CheckoutStateMachineState.PREPARE_CHECKOUT;
            newBuilder = newBuilder;
            newBuilder.f18505c = this.f18479i.mo627a().f18461c;
            this.al = newBuilder.m18528n();
        } else {
            this.al = (CheckoutData) bundle.getParcelable("checkout_data");
        }
        final Activity activity = (Activity) ContextUtils.a(getContext(), Activity.class);
        PaymentsTitleBarViewStub paymentsTitleBarViewStub = (PaymentsTitleBarViewStub) e(2131558562);
        PaymentsDecoratorParams paymentsDecoratorParams = this.al.mo717a().mo627a().f18462d;
        paymentsTitleBarViewStub.a((ViewGroup) this.T, new OnBackPressedListener(this) {
            final /* synthetic */ CheckoutFragment f18466b;

            public final void m18468a() {
                activity.onBackPressed();
            }
        }, paymentsDecoratorParams.b.getTitleBarStyle(), paymentsDecoratorParams.a.getTitleBarNavIconStyle());
        paymentsTitleBarViewStub.c.setTitle(jW_().getString(2131241072));
        this.f18471a.f18529d = this.ar;
        this.f18471a.f18527b = this.f18479i;
        this.am = this.f18472b.m18492b(this.f18479i.mo627a().f18459a);
        this.am.f15752b = this.ar;
        this.am.f15751a = new C21373(this);
        SimpleCheckoutManager simpleCheckoutManager = this.f18472b;
        CheckoutStyle checkoutStyle = this.f18479i.mo627a().f18459a;
        if (simpleCheckoutManager.f18488a.containsKey(checkoutStyle)) {
            simpleCheckoutOnActivityResultHandler = (SimpleCheckoutOnActivityResultHandler) ((CheckoutStyleAssociation) simpleCheckoutManager.f18488a.get(checkoutStyle)).f15726d.get();
        } else {
            simpleCheckoutOnActivityResultHandler = (SimpleCheckoutOnActivityResultHandler) ((CheckoutStyleAssociation) simpleCheckoutManager.f18488a.get(CheckoutStyle.SIMPLE)).f15726d.get();
        }
        this.an = simpleCheckoutOnActivityResultHandler;
        this.an.f18489a = new C21384(this);
        simpleCheckoutManager = this.f18472b;
        checkoutStyle = this.f18479i.mo627a().f18459a;
        if (simpleCheckoutManager.f18488a.containsKey(checkoutStyle)) {
            simpleCheckoutStateMachineHandler = (SimpleCheckoutStateMachineHandler) ((CheckoutStyleAssociation) simpleCheckoutManager.f18488a.get(checkoutStyle)).f15731i.get();
        } else {
            simpleCheckoutStateMachineHandler = (SimpleCheckoutStateMachineHandler) ((CheckoutStyleAssociation) simpleCheckoutManager.f18488a.get(CheckoutStyle.SIMPLE)).f15731i.get();
        }
        this.ao = simpleCheckoutStateMachineHandler;
        this.ao.f18585d = this.ar;
        this.ao.m18611a(this.al);
        if (this.aq == null || this.aq.isDone()) {
            SimpleCheckoutDataLoader a = this.f18472b.m18491a(this.f18479i.mo627a().f18459a);
            a.f15740b = new C21395(this);
            this.f18476f.setAlpha(0.2f);
            this.f18477g.setVisibility(0);
            this.aq = a.mo638a(this.f18479i);
        }
    }

    public static void m18472a(CheckoutFragment checkoutFragment, PaymentsComponentAction paymentsComponentAction) {
        switch (C21406.f18470a[paymentsComponentAction.a.ordinal()]) {
            case 1:
                if ("pay_button_name".equals(paymentsComponentAction.a("button_name", null))) {
                    checkoutFragment.am.m15940a(checkoutFragment.al, true);
                    return;
                }
                return;
            case 2:
                Activity ao = checkoutFragment.ao();
                if (ao != null) {
                    Intent intent = (Intent) paymentsComponentAction.a("extra_activity_result_data");
                    if (intent != null) {
                        ao.setResult(-1, intent);
                    } else {
                        ao.setResult(-1);
                    }
                    ao.finish();
                    return;
                }
                return;
            case 3:
                checkoutFragment.m18474n(null);
                return;
            default:
                return;
        }
    }

    public static void au(CheckoutFragment checkoutFragment) {
        SimpleCheckoutRowsGenerator simpleCheckoutRowsGenerator;
        SimpleCheckoutManager simpleCheckoutManager = checkoutFragment.f18472b;
        CheckoutStyle checkoutStyle = checkoutFragment.f18479i.mo627a().f18459a;
        if (simpleCheckoutManager.f18488a.containsKey(checkoutStyle)) {
            simpleCheckoutRowsGenerator = (SimpleCheckoutRowsGenerator) ((CheckoutStyleAssociation) simpleCheckoutManager.f18488a.get(checkoutStyle)).f15728f.get();
        } else {
            simpleCheckoutRowsGenerator = (SimpleCheckoutRowsGenerator) ((CheckoutStyleAssociation) simpleCheckoutManager.f18488a.get(CheckoutStyle.SIMPLE)).f15728f.get();
        }
        ImmutableList a = simpleCheckoutRowsGenerator.m15887a(checkoutFragment.al);
        CheckoutAdapter checkoutAdapter = checkoutFragment.f18471a;
        checkoutAdapter.f18528c = a;
        checkoutAdapter.notifyDataSetChanged();
        checkoutFragment.ao.m18611a(checkoutFragment.al);
        checkoutFragment.ao.m18610a();
    }

    public final void m18475I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1353347085);
        super.I();
        if (this.ap != null) {
            this.ap.cancel(true);
            this.ap = null;
        }
        if (this.aq != null) {
            this.aq.cancel(true);
            this.aq = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1610718658, a);
    }

    public static void ay(CheckoutFragment checkoutFragment) {
        checkoutFragment.f18477g.setVisibility(8);
        checkoutFragment.f18476f.setAlpha(1.0f);
    }
}

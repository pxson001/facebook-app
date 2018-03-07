package com.facebook.payments.confirmation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.facebook.payments.ui.titlebar.PaymentsTitleBarNavIconStyle;
import com.facebook.payments.ui.titlebar.PaymentsTitleBarStyle;
import com.facebook.payments.ui.titlebar.PaymentsTitleBarViewStub;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnBackPressedListener;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import javax.inject.Inject;

/* compiled from: call_state */
public class ConfirmationFragment extends FbFragment {
    @Inject
    public SimpleConfirmationManager f18605a;
    private RecyclerView al;
    public final SimplePaymentsComponentCallback am = new C21561(this);
    @Inject
    public ConfirmationAdapter f18606b;
    @Inject
    public SecureContextHelper f18607c;
    private Context f18608d;
    private SimpleConfirmationData f18609e;
    public ImmutableList<ConfirmationRow> f18610f;
    public SimpleConfirmationOnActivityResultHandler f18611g;
    public SimplePostPurchaseActionHandler f18612h;
    public ConfirmationParams f18613i;

    /* compiled from: call_state */
    class C21561 extends SimplePaymentsComponentCallback {
        final /* synthetic */ ConfirmationFragment f18599a;

        C21561(ConfirmationFragment confirmationFragment) {
            this.f18599a = confirmationFragment;
        }

        public final void m18624a(Intent intent, int i) {
            this.f18599a.f18607c.a(intent, i, this.f18599a);
        }

        public final void m18626b(Intent intent) {
            this.f18599a.f18607c.b(intent, this.f18599a.getContext());
        }

        public final void m18625a(PaymentsComponentAction paymentsComponentAction) {
            ConfirmationFragment.m18629a(this.f18599a, paymentsComponentAction);
        }
    }

    /* compiled from: call_state */
    /* synthetic */ class C21594 {
        static final /* synthetic */ int[] f18604a = new int[Action.values().length];

        static {
            try {
                f18604a[Action.RESET.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18604a[Action.USER_ACTION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public static void m18630a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ConfirmationFragment confirmationFragment = (ConfirmationFragment) obj;
        SimpleConfirmationManager a = SimpleConfirmationManager.m18646a(injectorLike);
        ConfirmationAdapter confirmationAdapter = new ConfirmationAdapter(SimpleConfirmationManager.m18646a(injectorLike));
        SecureContextHelper secureContextHelper = (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike);
        confirmationFragment.f18605a = a;
        confirmationFragment.f18606b = confirmationAdapter;
        confirmationFragment.f18607c = secureContextHelper;
    }

    public final void m18635c(Bundle bundle) {
        super.c(bundle);
        this.f18608d = ContextUtils.a(getContext(), 2130772893, 2131624691);
        Class cls = ConfirmationFragment.class;
        m18630a((Object) this, this.f18608d);
        this.f18613i = (ConfirmationParams) this.s.getParcelable("confirmation_params");
        Preconditions.checkNotNull(this.f18613i);
        if (this.f18609e != null || bundle == null) {
            this.f18609e = new SimpleConfirmationData(this.f18613i);
        } else {
            this.f18609e = (SimpleConfirmationData) bundle.getParcelable("confirmation_data");
        }
    }

    public final View m18632a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -536348157);
        View inflate = layoutInflater.cloneInContext(this.f18608d).inflate(2130903752, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1354892210, a);
        return inflate;
    }

    public final void m18634a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.al = (RecyclerView) e(2131559427);
        this.al.setLayoutManager(new LinearLayoutManager(getContext()));
        this.al.setAdapter(this.f18606b);
        final Activity activity = (Activity) ContextUtils.a(getContext(), Activity.class);
        PaymentsTitleBarViewStub paymentsTitleBarViewStub = (PaymentsTitleBarViewStub) e(2131558562);
        paymentsTitleBarViewStub.a((ViewGroup) this.T, new OnBackPressedListener(this) {
            final /* synthetic */ ConfirmationFragment f18601b;

            public final void m18627a() {
                if (activity != null) {
                    activity.onBackPressed();
                }
            }
        }, PaymentsTitleBarStyle.DEFAULT, PaymentsTitleBarNavIconStyle.NO_NAV_ICON);
        FbTitleBar fbTitleBar = paymentsTitleBarViewStub.c;
        fbTitleBar.setTitle(jW_().getString(2131241072));
        TitleBarButtonSpec.a().g = jW_().getString(2131241073);
        fbTitleBar.setButtonSpecs(Arrays.asList(new TitleBarButtonSpec[]{r5.a()}));
        fbTitleBar.setOnToolbarButtonListener(new OnToolbarButtonListener(this) {
            final /* synthetic */ ConfirmationFragment f18603b;

            public final void m18628a(View view, TitleBarButtonSpec titleBarButtonSpec) {
                if (activity != null) {
                    activity.finish();
                }
            }
        });
        m18631e();
        ConfirmationStyle confirmationStyle = this.f18613i.mo732a().f18593a;
        this.f18611g = this.f18605a.m18650c(confirmationStyle);
        this.f18611g.f18633a = this.am;
        this.f18612h = this.f18605a.m18651d(confirmationStyle);
        this.f18612h.f15824b = this.am;
    }

    public final void m18636e(Bundle bundle) {
        bundle.putParcelable("confirmation_data", this.f18609e);
        super.e(bundle);
    }

    public final void m18633a(int i, int i2, Intent intent) {
        switch (i) {
            case 1:
                this.f18611g.m18652a(this.f18609e, i, i2, intent);
                return;
            default:
                super.a(i, i2, intent);
                return;
        }
    }

    public static void m18629a(ConfirmationFragment confirmationFragment, PaymentsComponentAction paymentsComponentAction) {
        switch (C21594.f18604a[paymentsComponentAction.a.ordinal()]) {
            case 1:
                confirmationFragment.aq();
                return;
            case 2:
                PostPurchaseActionType postPurchaseActionType = (PostPurchaseActionType) paymentsComponentAction.b.getSerializable("extra_user_action");
                int size = confirmationFragment.f18610f.size();
                for (int i = 0; i < size; i++) {
                    ConfirmationRow confirmationRow = (ConfirmationRow) confirmationFragment.f18610f.get(i);
                    if (confirmationRow.mo733a() == ConfirmationRowType.POST_PURCHASE_ACTION) {
                        SimplePostPurchaseAction simplePostPurchaseAction = ((PostPurchaseActionRow) confirmationRow).f18617a;
                        if (simplePostPurchaseAction.f18625b == postPurchaseActionType) {
                            confirmationFragment.f18612h.m16008a(simplePostPurchaseAction);
                            return;
                        }
                    }
                }
                return;
            default:
                return;
        }
    }

    private void m18631e() {
        this.f18606b.f18592d = this.am;
        this.f18606b.f18591c = this.f18613i;
        aq();
    }

    private void aq() {
        this.f18610f = this.f18605a.m18648a(this.f18613i.mo732a().f18593a).m18658a(this.f18609e);
        ConfirmationAdapter confirmationAdapter = this.f18606b;
        confirmationAdapter.f18590b = this.f18610f;
        confirmationAdapter.notifyDataSetChanged();
    }
}

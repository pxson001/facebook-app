package com.facebook.messaging.payment.prefs.receipts.body;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.StringUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.debug.log.BLog;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.prefs.PaymentsPreferenceActivity;
import com.facebook.messaging.payment.prefs.receipts.ReceiptFragment;
import com.facebook.messaging.payment.prefs.receipts.animation.ReceiptAnimationController;
import com.facebook.messaging.payment.prefs.receipts.nux.DeclinePaymentDialogFragment;
import com.facebook.messaging.payment.util.PaymentTransactionUtil;
import com.facebook.messaging.payment.utils.PaymentRiskFlowHelper;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.text.BetterButton;
import javax.inject.Inject;

@ContextScoped
/* compiled from: googleSignInStatus */
public class ReceiptStatusViewController {
    private static final Class<?> f14049a = ReceiptStatusViewController.class;
    private static ReceiptStatusViewController f14050q;
    private static final Object f14051r = new Object();
    private final Resources f14052b;
    private final ReceiptAnimationController f14053c;
    public final Context f14054d;
    public final PaymentRiskFlowHelper f14055e;
    public final SecureContextHelper f14056f;
    private FbTextView f14057g;
    private FbTextView f14058h;
    private FbTextView f14059i;
    private BetterButton f14060j;
    private FbTextView f14061k;
    private BetterButton f14062l;
    public PaymentTransaction f14063m;
    public ReceiptFragment f14064n;
    private boolean f14065o;
    public String f14066p;

    /* compiled from: googleSignInStatus */
    class C15981 implements OnClickListener {
        final /* synthetic */ ReceiptStatusViewController f14044a;

        C15981(ReceiptStatusViewController receiptStatusViewController) {
            this.f14044a = receiptStatusViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -652294071);
            this.f14044a.f14056f.a(new Intent(this.f14044a.f14054d, PaymentsPreferenceActivity.class), this.f14044a.f14054d);
            Logger.a(2, EntryType.UI_INPUT_END, -1627938606, a);
        }
    }

    /* compiled from: googleSignInStatus */
    class C15992 implements OnClickListener {
        final /* synthetic */ ReceiptStatusViewController f14045a;

        C15992(ReceiptStatusViewController receiptStatusViewController) {
            this.f14045a = receiptStatusViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2056333881);
            DeclinePaymentDialogFragment.m14710a(this.f14045a.f14063m.f13231d.mo527c(), this.f14045a.f14063m.f13229b).a(this.f14045a.f14064n.kO_(), "decline_payment_dialog_fragment");
            Logger.a(2, EntryType.UI_INPUT_END, -394189548, a);
        }
    }

    /* compiled from: googleSignInStatus */
    class C16003 implements OnClickListener {
        final /* synthetic */ ReceiptStatusViewController f14046a;

        C16003(ReceiptStatusViewController receiptStatusViewController) {
            this.f14046a = receiptStatusViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -261475920);
            this.f14046a.f14055e.m15537a(this.f14046a.f14063m.f13229b, this.f14046a.f14063m.f13232e.mo526b(), this.f14046a.f14054d);
            Logger.a(2, EntryType.UI_INPUT_END, 275495652, a);
        }
    }

    /* compiled from: googleSignInStatus */
    class C16014 implements OnClickListener {
        final /* synthetic */ ReceiptStatusViewController f14047a;

        C16014(ReceiptStatusViewController receiptStatusViewController) {
            this.f14047a = receiptStatusViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1410122648);
            if (StringUtil.a(this.f14047a.f14066p)) {
                Logger.a(2, EntryType.UI_INPUT_END, -1241492946, a);
                return;
            }
            this.f14047a.f14056f.b(new Intent("android.intent.action.VIEW", Uri.parse(this.f14047a.f14066p).buildUpon().build()), this.f14047a.f14054d);
            LogUtils.a(1833880254, a);
        }
    }

    private static ReceiptStatusViewController m14544b(InjectorLike injectorLike) {
        return new ReceiptStatusViewController(ResourcesMethodAutoProvider.a(injectorLike), ReceiptAnimationController.m14526a(injectorLike), (Context) injectorLike.getInstance(Context.class), PaymentRiskFlowHelper.m15536b(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike));
    }

    @Inject
    public ReceiptStatusViewController(Resources resources, ReceiptAnimationController receiptAnimationController, Context context, PaymentRiskFlowHelper paymentRiskFlowHelper, SecureContextHelper secureContextHelper) {
        this.f14052b = resources;
        this.f14053c = receiptAnimationController;
        this.f14054d = context;
        this.f14055e = paymentRiskFlowHelper;
        this.f14056f = secureContextHelper;
    }

    public static ReceiptStatusViewController m14539a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            ReceiptStatusViewController b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f14051r) {
                ReceiptStatusViewController receiptStatusViewController;
                if (a2 != null) {
                    receiptStatusViewController = (ReceiptStatusViewController) a2.a(f14051r);
                } else {
                    receiptStatusViewController = f14050q;
                }
                if (receiptStatusViewController == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m14544b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f14051r, b3);
                        } else {
                            f14050q = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = receiptStatusViewController;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final void m14548a(FbTextView fbTextView, FbTextView fbTextView2, FbTextView fbTextView3, BetterButton betterButton, FbTextView fbTextView4, BetterButton betterButton2) {
        this.f14057g = fbTextView;
        this.f14058h = fbTextView2;
        this.f14059i = fbTextView3;
        this.f14060j = betterButton;
        this.f14061k = fbTextView4;
        this.f14062l = betterButton2;
        this.f14060j.setOnClickListener(new C15981(this));
        this.f14061k.setOnClickListener(new C15992(this));
        this.f14062l.setOnClickListener(new C16003(this));
        this.f14059i.setOnClickListener(new C16014(this));
    }

    public final void m14547a(PaymentTransaction paymentTransaction, ReceiptFragment receiptFragment, boolean z) {
        this.f14063m = paymentTransaction;
        this.f14064n = receiptFragment;
        this.f14065o = z;
        m14540a();
    }

    private void m14540a() {
        int i;
        int i2;
        int i3;
        switch (this.f14063m.f13234g) {
            case R_PENDING_VERIFICATION:
                m14543a(this.f14052b.getString(2131240349), this.f14052b.getString(2131240360), true);
                return;
            case R_PENDING_VERIFICATION_PROCESSING:
                i = 2131240349;
                i2 = 2131240358;
                i3 = 2131240376;
                this.f14066p = "https://m.facebook.com/help/messenger-app/1463256903894928";
                break;
            case R_PENDING_MANUAL_REVIEW:
                i = 2131240349;
                i2 = 2131240359;
                i3 = 2131240376;
                this.f14066p = "https://m.facebook.com/help/messenger-app/1463256903894928";
                break;
            case R_CANCELED_RECIPIENT_RISK:
                i = 2131240350;
                i2 = 2131240362;
                i3 = 2131240378;
                this.f14066p = "https://m.facebook.com/help/contact/370238886476028";
                break;
            case R_CANCELED_DECLINED:
            case R_CANCELED_EXPIRED:
                i = 2131240350;
                i2 = 2131240364;
                i3 = 2131240376;
                this.f14066p = "https://m.facebook.com/help/messenger-app/1564459413784472";
                break;
            case R_CANCELED_SAME_CARD:
                i = 2131240350;
                i2 = 2131240365;
                i3 = 2131240376;
                this.f14066p = "https://m.facebook.com/help/messenger-app/818512131561533";
                break;
            case R_CANCELED:
            case R_CANCELED_SENDER_RISK:
            case R_CANCELED_CUSTOMER_SERVICE:
            case R_CANCELED_CHARGEBACK:
            case R_CANCELED_SYSTEM_FAIL:
                i = 2131240350;
                i2 = 2131240363;
                i3 = 2131240378;
                this.f14066p = "https://m.facebook.com/help/contact/614010102040957";
                break;
            case R_PENDING:
            case R_COMPLETED:
            case R_PENDING_NUX:
            case R_PENDING_PROCESSING:
                m14545b();
                return;
            case R_PENDING_PUSH_FAIL:
            case R_PENDING_PUSH_FAIL_CARD_EXPIRED:
                m14541a(this.f14052b.getString(2131240349), this.f14052b.getString(2131240361));
                return;
            case S_PENDING_VERIFICATION:
                m14543a(this.f14052b.getString(2131240349), this.f14052b.getString(2131240353), false);
                return;
            case S_PENDING_VERIFICATION_PROCESSING:
                i = 2131240349;
                i2 = 2131240351;
                i3 = 2131240376;
                this.f14066p = "https://m.facebook.com/help/messenger-app/1463256903894928";
                break;
            case S_PENDING_MANUAL_REVIEW:
                i = 2131240349;
                i2 = 2131240352;
                i3 = 2131240376;
                this.f14066p = "https://m.facebook.com/help/messenger-app/1463256903894928";
                break;
            case S_CANCELED_SENDER_RISK:
                i = 2131240350;
                i2 = 2131240354;
                i3 = 2131240378;
                this.f14066p = "https://m.facebook.com/help/contact/370238886476028";
                break;
            case S_CANCELED_RECIPIENT_RISK:
            case S_CANCELED_DECLINED:
            case S_CANCELED_EXPIRED:
                String string = this.f14052b.getString(PaymentTransactionUtil.m15521a(this.f14063m) ? 2131240357 : 2131240356, new Object[]{this.f14063m.f13232e.mo527c()});
                this.f14066p = "https://m.facebook.com/help/messenger-app/1564459413784472";
                m14542a(this.f14052b.getString(2131240350), string, this.f14052b.getString(2131240376));
                return;
            case S_CANCELED_SAME_CARD:
                i = 2131240350;
                i2 = 2131240365;
                i3 = 2131240376;
                this.f14066p = "https://m.facebook.com/help/messenger-app/818512131561533";
                break;
            case S_CANCELED:
            case S_CANCELED_CUSTOMER_SERVICE:
            case S_CANCELED_CHARGEBACK:
            case S_CANCELED_SYSTEM_FAIL:
                i = 2131240350;
                i2 = 2131240355;
                i3 = 2131240378;
                this.f14066p = "https://m.facebook.com/help/contact/614010102040957";
                break;
            case S_PENDING:
            case S_COMPLETED:
            case S_SENT:
                m14545b();
                return;
            default:
                m14545b();
                BLog.a(f14049a, "We should not see this unknown transfer status %s", new Object[]{this.f14063m.f13234g});
                return;
        }
        m14542a(this.f14052b.getString(i), this.f14052b.getString(i2), this.f14052b.getString(i3));
    }

    private void m14541a(String str, String str2) {
        m14545b();
        m14546b(str, str2);
        this.f14060j.setVisibility(0);
    }

    private void m14543a(String str, String str2, boolean z) {
        int i = 0;
        m14545b();
        m14546b(str, str2);
        this.f14062l.setVisibility(0);
        FbTextView fbTextView = this.f14061k;
        if (!z) {
            i = 8;
        }
        fbTextView.setVisibility(i);
    }

    private void m14542a(String str, String str2, String str3) {
        m14545b();
        m14546b(str, str2);
        this.f14059i.setText(str3);
        this.f14059i.setVisibility(0);
    }

    private void m14545b() {
        this.f14057g.setVisibility(8);
        this.f14058h.setVisibility(8);
        this.f14059i.setVisibility(8);
        this.f14060j.setVisibility(8);
        this.f14062l.setVisibility(8);
        this.f14061k.setVisibility(8);
    }

    private void m14546b(String str, String str2) {
        this.f14057g.setText(str);
        this.f14058h.setText(str2);
        if (this.f14065o) {
            ReceiptAnimationController.m14527a(this.f14057g, 0);
            ReceiptAnimationController.m14527a(this.f14058h, 0);
            return;
        }
        this.f14057g.setVisibility(0);
        this.f14058h.setVisibility(0);
    }
}

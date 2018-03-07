package com.facebook.messaging.payment.prefs.receipts;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.payment.model.PaymentTransaction;
import com.facebook.messaging.payment.prefs.receipts.body.ReceiptBodyViewController;
import com.facebook.messaging.payment.prefs.receipts.footer.ReceiptFooterInfoView;
import com.facebook.messaging.payment.prefs.receipts.footer.ReceiptFooterViewController;
import com.facebook.messaging.payment.prefs.receipts.header.ReceiptHeaderView;
import com.facebook.messaging.payment.prefs.receipts.header.ReceiptHeaderViewController;
import com.facebook.messaging.payment.prefs.receipts.nux.ReceiptNuxViewController;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.payments.ui.FloatingLabelTextView;
import com.facebook.payments.ui.SingleItemInfoView;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.BetterTextView;
import javax.inject.Inject;

/* compiled from: groupCommerceGetDisplayPrice() not supported yet */
public class OrionReceiptView extends CustomLinearLayout implements ReceiptView<PaymentTransaction> {
    @Inject
    ReceiptNuxViewController f13919a;
    @Inject
    ReceiptHeaderViewController f13920b;
    @Inject
    ReceiptBodyViewController f13921c;
    @Inject
    ReceiptFooterViewController f13922d;
    private ReceiptHeaderView f13923e;
    private DollarIconEditText f13924f;
    private FbTextView f13925g;
    private FbTextView f13926h;
    private FloatingLabelTextView f13927i;
    private BetterTextView f13928j;
    private BetterTextView f13929k;
    private FloatingLabelTextView f13930l;
    private FloatingLabelTextView f13931m;
    private FbTextView f13932n;
    private LinearLayout f13933o;
    private FbTextView f13934p;
    private BetterButton f13935q;
    private FbTextView f13936r;
    private FbTextView f13937s;
    private FbTextView f13938t;
    private ReceiptFooterInfoView f13939u;
    private SingleItemInfoView f13940v;
    private FloatingLabelTextView f13941w;
    private BetterButton f13942x;
    private BetterButton f13943y;

    private static <T extends View> void m14459a(Class<T> cls, T t) {
        m14460a((Object) t, t.getContext());
    }

    private static void m14460a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((OrionReceiptView) obj).m14458a(ReceiptNuxViewController.m14719a(injectorLike), ReceiptHeaderViewController.m14613a(injectorLike), ReceiptBodyViewController.m14535a(injectorLike), ReceiptFooterViewController.m14574a(injectorLike));
    }

    public final void mo553a(Object obj, ReceiptFragment receiptFragment) {
        PaymentTransaction paymentTransaction = (PaymentTransaction) obj;
        this.f13920b.m14617a(paymentTransaction);
        this.f13921c.m14537a(paymentTransaction, receiptFragment, true);
        this.f13922d.m14577a(paymentTransaction, true);
        this.f13919a.m14721a(paymentTransaction, receiptFragment);
    }

    public final void mo554b(Object obj, ReceiptFragment receiptFragment) {
        PaymentTransaction paymentTransaction = (PaymentTransaction) obj;
        this.f13920b.f14144b = this.f13923e;
        this.f13920b.m14617a(paymentTransaction);
        this.f13921c.m14538a(this.f13924f, this.f13925g, this.f13926h, this.f13938t, this.f13943y, this.f13937s, this.f13942x);
        this.f13921c.m14537a(paymentTransaction, receiptFragment, false);
        this.f13922d.m14578a(this.f13927i, this.f13928j, this.f13929k, this.f13930l, this.f13931m, this.f13940v, this.f13941w, this.f13939u);
        this.f13922d.m14577a(paymentTransaction, false);
        this.f13919a.m14722a(this.f13932n, this.f13933o, this.f13935q, this.f13936r, this.f13934p);
        this.f13919a.m14721a(paymentTransaction, receiptFragment);
    }

    private void m14458a(ReceiptNuxViewController receiptNuxViewController, ReceiptHeaderViewController receiptHeaderViewController, ReceiptBodyViewController receiptBodyViewController, ReceiptFooterViewController receiptFooterViewController) {
        this.f13919a = receiptNuxViewController;
        this.f13920b = receiptHeaderViewController;
        this.f13921c = receiptBodyViewController;
        this.f13922d = receiptFooterViewController;
    }

    public OrionReceiptView(Context context) {
        this(context, null);
    }

    public OrionReceiptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OrionReceiptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m14459a(OrionReceiptView.class, (View) this);
        setContentView(2130905930);
        this.f13923e = (ReceiptHeaderView) a(2131563922);
        this.f13924f = (DollarIconEditText) a(2131563921);
        this.f13925g = (FbTextView) a(2131565292);
        this.f13926h = (FbTextView) a(2131566835);
        this.f13927i = (FloatingLabelTextView) a(2131566811);
        this.f13928j = (BetterTextView) a(2131566812);
        this.f13929k = (BetterTextView) a(2131566813);
        this.f13930l = (FloatingLabelTextView) a(2131566809);
        this.f13931m = (FloatingLabelTextView) a(2131566810);
        this.f13932n = (FbTextView) a(2131566825);
        this.f13933o = (LinearLayout) a(2131566826);
        this.f13934p = (FbTextView) a(2131566824);
        this.f13935q = (BetterButton) a(2131566827);
        this.f13936r = (FbTextView) a(2131566828);
        this.f13937s = (FbTextView) a(2131566839);
        this.f13938t = (FbTextView) a(2131566838);
        this.f13942x = (BetterButton) a(2131566836);
        this.f13943y = (BetterButton) a(2131566837);
        this.f13940v = (SingleItemInfoView) a(2131563670);
        this.f13941w = (FloatingLabelTextView) a(2131565285);
        this.f13939u = (ReceiptFooterInfoView) a(2131563920);
    }

    public final void mo551a() {
        this.f13922d.f14099c.f14113b.m14512a();
        ReceiptNuxViewController receiptNuxViewController = this.f13919a;
        if (receiptNuxViewController.f14305k != null) {
            receiptNuxViewController.f14305k.cancel(true);
            receiptNuxViewController.f14305k = null;
        }
    }

    public final void mo552a(int i, int i2, Intent intent) {
        this.f13919a.f14300f.m13454a(i, i2, intent);
    }
}

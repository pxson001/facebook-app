package com.facebook.messaging.payment.method.input;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.prefs.receipts.nux.DeclinePaymentDialogFragment;
import com.facebook.payments.ui.PaymentsComponentRelativeLayout;
import com.facebook.resources.ui.FbTextView;

/* compiled from: incoming_peer_to_peer_payment_requests */
public class TransactionPaymentMethodSecurityInfo extends PaymentsComponentRelativeLayout {
    public FbTextView f13081a = ((FbTextView) a(2131568092));

    /* compiled from: incoming_peer_to_peer_payment_requests */
    public class C14571 implements OnClickListener {
        final /* synthetic */ TransactionPaymentMethodSecurityInfo f13076a;

        public C14571(TransactionPaymentMethodSecurityInfo transactionPaymentMethodSecurityInfo) {
            this.f13076a = transactionPaymentMethodSecurityInfo;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -7942310);
            this.f13076a.a.b(new Intent("android.intent.action.VIEW").setData(Uri.parse("https://m.facebook.com/help/messenger-app/728431013914433")));
            Logger.a(2, EntryType.UI_INPUT_END, 1865771959, a);
        }
    }

    /* compiled from: incoming_peer_to_peer_payment_requests */
    public class C14592 implements OnClickListener {
        final /* synthetic */ String f13078a;
        final /* synthetic */ String f13079b;
        public final /* synthetic */ TransactionPaymentMethodSecurityInfo f13080c;

        /* compiled from: incoming_peer_to_peer_payment_requests */
        public class C14581 {
            public final /* synthetic */ C14592 f13077a;

            C14581(C14592 c14592) {
                this.f13077a = c14592;
            }
        }

        public C14592(TransactionPaymentMethodSecurityInfo transactionPaymentMethodSecurityInfo, String str, String str2) {
            this.f13080c = transactionPaymentMethodSecurityInfo;
            this.f13078a = str;
            this.f13079b = str2;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 25485247);
            DeclinePaymentDialogFragment a2 = DeclinePaymentDialogFragment.m14710a(this.f13078a, this.f13079b);
            a2.ar = new C14581(this);
            this.f13080c.a.a(a2);
            Logger.a(2, EntryType.UI_INPUT_END, -1764422368, a);
        }
    }

    public TransactionPaymentMethodSecurityInfo(Context context) {
        super(context);
        setContentView(2130907531);
        FbTextView fbTextView = (FbTextView) a(2131568090);
        FbTextView fbTextView2 = (FbTextView) a(2131568091);
        fbTextView.setOnClickListener(new C14571(this));
        fbTextView2.setText("·");
    }
}

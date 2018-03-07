package com.facebook.messaging.payment.method.input;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.PaymentsComponentView;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.facebook.resources.ui.FbTextView;
import javax.inject.Inject;

/* compiled from: index should be non negative */
public class MessengerPayEditCardFormFooterView extends SegmentedLinearLayout implements PaymentsComponentView {
    @Inject
    public GlyphColorizer f13048a;
    public FbTextView f13049b;
    private FbTextView f13050c;
    public FbTextView f13051d;
    public PaymentCard f13052e;
    public SimplePaymentsComponentCallback f13053f;

    /* compiled from: index should be non negative */
    public class C14511 implements OnClickListener {
        final /* synthetic */ MessengerPayEditCardFormFooterView f13046a;

        public C14511(MessengerPayEditCardFormFooterView messengerPayEditCardFormFooterView) {
            this.f13046a = messengerPayEditCardFormFooterView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1032345727);
            if (this.f13046a.f13053f != null) {
                String a2 = this.f13046a.f13052e.m13499a();
                Bundle bundle = new Bundle();
                bundle.putString("extra_mutation", "action_set_primary");
                bundle.putString("payment_card_id", a2);
                this.f13046a.f13053f.a(new PaymentsComponentAction(Action.MUTATION, bundle));
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1824420491, a);
        }
    }

    /* compiled from: index should be non negative */
    public class C14522 implements OnClickListener {
        final /* synthetic */ MessengerPayEditCardFormFooterView f13047a;

        public C14522(MessengerPayEditCardFormFooterView messengerPayEditCardFormFooterView) {
            this.f13047a = messengerPayEditCardFormFooterView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 276825804);
            Object obj = this.f13047a.f13052e;
            Bundle bundle = new Bundle();
            bundle.putParcelable("payment_card", obj);
            DeletePaymentCardDialogFragment deletePaymentCardDialogFragment = new DeletePaymentCardDialogFragment();
            deletePaymentCardDialogFragment.g(bundle);
            DeletePaymentCardDialogFragment deletePaymentCardDialogFragment2 = deletePaymentCardDialogFragment;
            if (this.f13047a.f13053f != null) {
                deletePaymentCardDialogFragment2.m13307a(this.f13047a.f13053f);
                this.f13047a.f13053f.a(deletePaymentCardDialogFragment2);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 332239929, a);
        }
    }

    public static void m13350a(Object obj, Context context) {
        ((MessengerPayEditCardFormFooterView) obj).f13048a = GlyphColorizer.a(FbInjector.get(context));
    }

    public MessengerPayEditCardFormFooterView(Context context) {
        super(context);
        m13348a();
    }

    public void setPaymentsComponentCallback(SimplePaymentsComponentCallback simplePaymentsComponentCallback) {
        this.f13053f = simplePaymentsComponentCallback;
        this.f13049b.setOnClickListener(new C14511(this));
        this.f13051d.setOnClickListener(new C14522(this));
    }

    private void m13348a() {
        Class cls = MessengerPayEditCardFormFooterView.class;
        m13350a((Object) this, getContext());
        setContentView(2130905257);
        this.f13049b = (FbTextView) a(2131563852);
        this.f13050c = (FbTextView) a(2131563853);
        this.f13051d = (FbTextView) a(2131563854);
        m13351b();
    }

    private void m13351b() {
        setOrientation(1);
        setSegmentedDivider(getContext().getResources().getDrawable(2131363748));
        setSegmentedDividerThickness(getResources().getDimensionPixelSize(2131433388));
        m13354e();
    }

    public final void m13355a(boolean z) {
        if (z) {
            m13353d();
        } else {
            m13352c();
        }
    }

    private void m13352c() {
        this.f13049b.setEnabled(true);
        this.f13050c.setEnabled(true);
        m13349a(this.f13049b, 2131363757);
    }

    private void m13353d() {
        this.f13049b.setEnabled(false);
        this.f13050c.setEnabled(false);
        m13349a(this.f13049b, 2131363745);
    }

    public void setVisibilityOfMakePrimaryButton(int i) {
        this.f13049b.setVisibility(i);
        this.f13050c.setVisibility(i);
        m13354e();
    }

    public void setVisibilityOfDeleteCardButton(int i) {
        this.f13051d.setVisibility(i);
        m13354e();
    }

    private void m13354e() {
        if (this.f13051d.getVisibility() == 8 && this.f13049b.getVisibility() == 8) {
            setShowSegmentedDividers(0);
        } else {
            setShowSegmentedDividers(6);
        }
    }

    private void m13349a(FbTextView fbTextView, @ColorRes int i) {
        this.f13048a.a(fbTextView.getCompoundDrawables()[0], getResources().getColor(i));
    }
}

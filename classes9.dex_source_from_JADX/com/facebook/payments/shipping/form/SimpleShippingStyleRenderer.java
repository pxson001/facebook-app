package com.facebook.payments.shipping.form;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.shipping.model.ShippingCommonParams;
import com.facebook.payments.shipping.model.ShippingParams;
import com.facebook.payments.shipping.model.ShippingSource;
import com.facebook.payments.ui.PaymentsComponentAction;
import com.facebook.payments.ui.PaymentsComponentAction.Action;
import com.facebook.payments.ui.PaymentsComponentView;
import com.facebook.payments.ui.PaymentsFormFooterView;
import com.facebook.payments.ui.SimplePaymentsComponentCallback;
import com.google.common.base.Preconditions;

/* compiled from: in_sync */
public class SimpleShippingStyleRenderer {
    public PaymentsFormFooterView f13104a;
    public ShippingCommonParams f13105b;
    public SimplePaymentsComponentCallback f13106c;

    /* compiled from: in_sync */
    class C22331 implements OnClickListener {
        final /* synthetic */ SimpleShippingStyleRenderer f18961a;

        C22331(SimpleShippingStyleRenderer simpleShippingStyleRenderer) {
            this.f18961a = simpleShippingStyleRenderer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 364128617);
            if (this.f18961a.f13106c != null) {
                SimpleShippingStyleRenderer.m13413a(this.f18961a, "make_default_mutation");
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1124072786, a);
        }
    }

    /* compiled from: in_sync */
    public class C22342 implements OnClickListener {
        final /* synthetic */ SimpleShippingStyleRenderer f18962a;

        public C22342(SimpleShippingStyleRenderer simpleShippingStyleRenderer) {
            this.f18962a = simpleShippingStyleRenderer;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 630409737);
            if (this.f18962a.f13106c != null) {
                SimpleShippingStyleRenderer.m13413a(this.f18962a, "delete_mutation");
            }
            Logger.a(2, EntryType.UI_INPUT_END, -456124696, a);
        }
    }

    public void mo516a(Context context) {
    }

    public final PaymentsComponentView m13419a(ViewGroup viewGroup, ShippingParams shippingParams) {
        this.f13104a = new PaymentsFormFooterView(viewGroup.getContext());
        this.f13105b = shippingParams.mo759a();
        this.f13104a.a.setText(2131240100);
        if (this.f13105b.f18991e == ShippingSource.OTHERS) {
            if (!(m13414a() || m13415b())) {
                m13416c();
            }
            if (this.f13105b.f18990d != null) {
                this.f13104a.f.setText(2131240105);
                this.f13104a.setOnClickListenerForDeleteButton(new C22342(this));
                this.f13104a.setVisibilityOfDeleteButton(0);
            } else {
                this.f13104a.setVisibilityOfDeleteButton(8);
            }
        }
        return this.f13104a;
    }

    private boolean m13414a() {
        if (this.f13105b.f18990d != null || this.f13105b.f18993g <= 0) {
            this.f13104a.setVisibilityOfMakeDefaultSwitch(8);
            m13418f();
            return false;
        }
        this.f13104a.b.setText(2131240101);
        this.f13104a.setVisibilityOfMakeDefaultSwitch(0);
        m13417e();
        return true;
    }

    private boolean m13415b() {
        if (this.f13105b.f18990d == null || this.f13105b.f18990d.mo769i() || this.f13105b.f18993g <= 1) {
            this.f13104a.setVisibilityOfMakeDefaultButton(8);
            m13418f();
            return false;
        }
        this.f13104a.c.setText(2131240102);
        this.f13104a.setVisibilityOfMakeDefaultButton(0);
        this.f13104a.setOnClickListenerForMakeDefaultButton(new C22331(this));
        m13417e();
        return true;
    }

    private boolean m13416c() {
        if (this.f13105b.f18990d == null || !this.f13105b.f18990d.mo769i() || this.f13105b.f18993g <= 1) {
            this.f13104a.setVisibilityOfDefaultInfoView(8);
            m13418f();
            return false;
        }
        this.f13104a.d.setText(2131240103);
        this.f13104a.setVisibilityOfDefaultInfoView(0);
        m13417e();
        return true;
    }

    private void m13417e() {
        this.f13104a.e.setText(2131240104);
        this.f13104a.setVisibilityOfDefaultActionSummary(0);
    }

    private void m13418f() {
        this.f13104a.setVisibilityOfDefaultActionSummary(8);
    }

    public static void m13413a(SimpleShippingStyleRenderer simpleShippingStyleRenderer, String str) {
        Preconditions.checkNotNull(simpleShippingStyleRenderer.f13105b.f18990d);
        Bundle bundle = new Bundle();
        bundle.putString("extra_mutation", str);
        bundle.putString("shipping_address_id", simpleShippingStyleRenderer.f13105b.f18990d.mo760a());
        simpleShippingStyleRenderer.f13106c.a(new PaymentsComponentAction(Action.MUTATION, bundle));
    }
}

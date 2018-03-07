package com.facebook.payments.paymentmethods.picker;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.facebook.adspayments.analytics.PaymentsFlowState;
import com.facebook.adspayments.analytics.PaymentsLogger;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.payments.paymentmethods.paypalweb.PayPalWebIntentHelper;
import com.facebook.payments.paymentmethods.picker.model.AddPayPalRowItem;
import com.facebook.payments.picker.RowItemView;
import com.facebook.payments.ui.PaymentsComponentViewGroup;
import javax.inject.Inject;

/* compiled from: boosted_local_awareness_promotions */
public class AddPayPalRowItemView extends PaymentsComponentViewGroup implements RowItemView<AddPayPalRowItem> {
    @Inject
    public AnalyticsLogger f18719a;
    @Inject
    public PaymentsLogger f18720b;
    public TextView f18721c = ((TextView) getView(2131559366));

    /* compiled from: boosted_local_awareness_promotions */
    public class C21841 implements OnClickListener {
        final /* synthetic */ AddPayPalRowItem f18717a;
        final /* synthetic */ AddPayPalRowItemView f18718b;

        public C21841(AddPayPalRowItemView addPayPalRowItemView, AddPayPalRowItem addPayPalRowItem) {
            this.f18718b = addPayPalRowItemView;
            this.f18717a = addPayPalRowItem;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2120539433);
            this.f18718b.f18720b.m3878a(PaymentsFlowState.ADD_PAYPAL_STATE, this.f18717a.f18837d.m18791b());
            this.f18718b.f18719a.a(PickerScreenAnalyticsEvent.m18788c("payments_new_paypal_selected", this.f18717a.f18837d.f18785b.f18776a).m18786a(this.f18717a.f18837d).f18775a);
            this.f18718b.b(PayPalWebIntentHelper.m18718a(this.f18717a.f18835b, this.f18717a.f18834a), this.f18717a.f18836c);
            Logger.a(2, EntryType.UI_INPUT_END, 1162887879, a);
        }
    }

    public static void m18721a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        AddPayPalRowItemView addPayPalRowItemView = (AddPayPalRowItemView) obj;
        AnalyticsLogger a = AnalyticsLoggerMethodAutoProvider.a(injectorLike);
        PaymentsLogger a2 = PaymentsLogger.m3873a(injectorLike);
        addPayPalRowItemView.f18719a = a;
        addPayPalRowItemView.f18720b = a2;
    }

    public AddPayPalRowItemView(Context context) {
        super(context);
        Class cls = AddPayPalRowItemView.class;
        m18721a(this, getContext());
        setContentView(2130903163);
    }

    public final void mo658a() {
    }
}

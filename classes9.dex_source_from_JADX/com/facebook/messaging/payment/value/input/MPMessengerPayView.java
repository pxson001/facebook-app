package com.facebook.messaging.payment.value.input;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.messaging.payment.utils.PaymentTextUtils;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17747;
import com.facebook.payments.paymentmethods.model.PaymentMethod;
import com.facebook.payments.ui.SingleItemInfoView;
import com.facebook.payments.ui.SingleItemInfoViewParams;
import com.facebook.payments.ui.SingleItemInfoViewParamsBuilder;
import com.facebook.payments.util.PaymentMethodUtil;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterButton;
import java.math.BigDecimal;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: existing_payment_methods */
public class MPMessengerPayView extends CustomRelativeLayout implements MessengerPayView {
    @Inject
    public Resources f15415a;
    @Inject
    public PaymentCurrencyUtil f15416b;
    @Inject
    public PaymentTextUtils f15417c;
    public SingleItemInfoView f15418d;
    public DollarIconEditText f15419e;
    public ProgressBar f15420f;
    public FbTextView f15421g;
    public FbButton f15422h;
    public LinearLayout f15423i;
    public BetterButton f15424j;
    public C17747 f15425k;
    public MPMessengerPayViewParams f15426l;

    /* compiled from: existing_payment_methods */
    public class C17991 implements OnClickListener {
        final /* synthetic */ MPMessengerPayView f15413a;

        public C17991(MPMessengerPayView mPMessengerPayView) {
            this.f15413a = mPMessengerPayView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -316401239);
            if (this.f15413a.f15426l.f15428b == null) {
                Logger.a(2, EntryType.UI_INPUT_END, -1900138840, a);
                return;
            }
            if (this.f15413a.f15426l.f15428b.isPresent()) {
                this.f15413a.f15425k.m15635h();
            } else {
                this.f15413a.f15425k.m15632c();
            }
            LogUtils.a(-1204918832, a);
        }
    }

    /* compiled from: existing_payment_methods */
    public class C18002 implements OnClickListener {
        final /* synthetic */ MPMessengerPayView f15414a;

        public C18002(MPMessengerPayView mPMessengerPayView) {
            this.f15414a = mPMessengerPayView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1644951303);
            this.f15414a.f15425k.m15630b();
            Logger.a(2, EntryType.UI_INPUT_END, 1609818359, a);
        }
    }

    public static void m15730a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        MPMessengerPayView mPMessengerPayView = (MPMessengerPayView) obj;
        Resources a = ResourcesMethodAutoProvider.a(injectorLike);
        PaymentCurrencyUtil a2 = PaymentCurrencyUtil.m13192a(injectorLike);
        PaymentTextUtils b = PaymentTextUtils.m15538b(injectorLike);
        mPMessengerPayView.f15415a = a;
        mPMessengerPayView.f15416b = a2;
        mPMessengerPayView.f15417c = b;
    }

    public MPMessengerPayView(Context context) {
        this(context, null);
    }

    private MPMessengerPayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private MPMessengerPayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = MPMessengerPayView.class;
        m15730a(this, getContext());
        setContentView(2130905305);
        this.f15418d = (SingleItemInfoView) a(2131563670);
        this.f15419e = (DollarIconEditText) a(2131563925);
        this.f15420f = (ProgressBar) a(2131561183);
        this.f15421g = (FbTextView) a(2131561188);
        this.f15422h = (FbButton) a(2131561189);
        this.f15423i = (LinearLayout) a(2131561187);
        this.f15424j = (BetterButton) a(2131563677);
        this.f15419e.m15481a();
    }

    @Nullable
    public View getImmediateFocusView() {
        return null;
    }

    public void setListener(C17747 c17747) {
        this.f15425k = c17747;
        this.f15424j.setOnClickListener(new C17991(this));
        this.f15422h.setOnClickListener(new C18002(this));
    }

    public void setMessengerPayViewParams(MessengerPayViewParams messengerPayViewParams) {
        this.f15426l = (MPMessengerPayViewParams) messengerPayViewParams;
        String str = this.f15426l.f15429c.f15482f;
        this.f15419e.setTextSize(0, (float) this.f15417c.m15540a(str));
        this.f15419e.m15482a(this.f15426l.f15429c.f15483g, str);
        if (this.f15426l.f15428b == null) {
            this.f15423i.setVisibility(8);
            this.f15420f.setVisibility(0);
        } else {
            this.f15420f.setVisibility(8);
            if (this.f15426l.f15428b.isPresent()) {
                this.f15421g.setText(PaymentMethodUtil.b((PaymentMethod) this.f15426l.f15428b.get(), getResources()));
                this.f15423i.setVisibility(0);
            } else {
                this.f15423i.setVisibility(8);
            }
        }
        if (this.f15426l.f15429c == null) {
            this.f15418d.setVisibility(8);
            return;
        }
        MoneyPennyItemParams moneyPennyItemParams = this.f15426l.f15429c;
        SingleItemInfoViewParamsBuilder newBuilder = SingleItemInfoViewParams.newBuilder();
        newBuilder.a = moneyPennyItemParams.f15478b;
        newBuilder = newBuilder;
        newBuilder.b = getResources().getDimension(2131429257);
        newBuilder = newBuilder;
        newBuilder.c = moneyPennyItemParams.f15479c;
        newBuilder = newBuilder;
        newBuilder.d = moneyPennyItemParams.f15480d;
        newBuilder = newBuilder;
        newBuilder.e = moneyPennyItemParams.f15481e;
        this.f15418d.setViewParams(newBuilder.f());
        this.f15418d.setVisibility(0);
    }

    public final void mo621a(@Nullable MenuItem menuItem) {
        boolean z = true;
        if (this.f15426l.f15428b == null) {
            this.f15424j.setVisibility(4);
            return;
        }
        boolean z2;
        this.f15424j.setVisibility(0);
        this.f15424j.setText(this.f15426l.f15428b.isPresent() ? 2131240526 : 2131240386);
        if (this.f15416b.m13201a(this.f15426l.f15429c.f15482f, this.f15426l.f15429c.f15483g).compareTo(BigDecimal.ZERO) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        BetterButton betterButton = this.f15424j;
        if (!(z2 && this.f15426l.f15427a == MessengerPayState.PREPARE_PAYMENT)) {
            z = false;
        }
        betterButton.setEnabled(z);
    }

    public final void mo620a() {
    }
}

package com.facebook.messaging.payment.value.input;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17747;
import com.facebook.messaging.payment.value.input.EnterPaymentValueTextController.Listener;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomRelativeLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: event_attachment */
public class OrionPayMessengerPayView extends CustomRelativeLayout implements MessengerPayView {
    @Inject
    public Resources f15577a;
    @Inject
    public EnterPaymentValueTextControllerProvider f15578b;
    @Inject
    public MessengerPayViewMenuItemHelper f15579c;
    private final CallerContext f15580d = CallerContext.a(getContext());
    public DollarIconEditText f15581e;
    public ProgressBar f15582f;
    public FbTextView f15583g;
    public FbButton f15584h;
    public LinearLayout f15585i;
    public LinearLayout f15586j;
    public FbTextView f15587k;
    public FbTextView f15588l;
    public MemoInputView f15589m;
    public ViewPager f15590n;
    public C17747 f15591o;
    public EnterPaymentValueTextController f15592p;
    public OrionMessengerPayViewParams f15593q;

    /* compiled from: event_attachment */
    public class C18191 implements OnClickListener {
        final /* synthetic */ OrionPayMessengerPayView f15571a;

        public C18191(OrionPayMessengerPayView orionPayMessengerPayView) {
            this.f15571a = orionPayMessengerPayView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1566977137);
            this.f15571a.f15591o.m15630b();
            Logger.a(2, EntryType.UI_INPUT_END, 791650418, a);
        }
    }

    /* compiled from: event_attachment */
    public class C18202 implements OnClickListener {
        final /* synthetic */ OrionPayMessengerPayView f15572a;

        public C18202(OrionPayMessengerPayView orionPayMessengerPayView) {
            this.f15572a = orionPayMessengerPayView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 178504813);
            this.f15572a.f15591o.m15634g();
            Logger.a(2, EntryType.UI_INPUT_END, 340444764, a);
        }
    }

    /* compiled from: event_attachment */
    public class C18213 implements Listener {
        final /* synthetic */ OrionPayMessengerPayView f15573a;

        public C18213(OrionPayMessengerPayView orionPayMessengerPayView) {
            this.f15573a = orionPayMessengerPayView;
        }

        public final void mo625a(String str) {
            this.f15573a.f15591o.m15631b(str);
        }
    }

    /* compiled from: event_attachment */
    class C18224 implements MemoInputView.Listener {
        final /* synthetic */ OrionPayMessengerPayView f15574a;

        C18224(OrionPayMessengerPayView orionPayMessengerPayView) {
            this.f15574a = orionPayMessengerPayView;
        }

        public final void mo626a(String str) {
            this.f15574a.f15591o.m15629a(str);
        }
    }

    /* compiled from: event_attachment */
    class C18235 extends SimpleOnPageChangeListener {
        final /* synthetic */ OrionPayMessengerPayView f15575a;

        C18235(OrionPayMessengerPayView orionPayMessengerPayView) {
            this.f15575a = orionPayMessengerPayView;
        }

        public final void e_(int i) {
            this.f15575a.f15591o.m15628a(ThemeHelper.m15869a(this.f15575a.f15593q.f15560h, i));
        }
    }

    public static void m15804a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        OrionPayMessengerPayView orionPayMessengerPayView = (OrionPayMessengerPayView) obj;
        Resources a = ResourcesMethodAutoProvider.a(fbInjector);
        EnterPaymentValueTextControllerProvider enterPaymentValueTextControllerProvider = (EnterPaymentValueTextControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EnterPaymentValueTextControllerProvider.class);
        MessengerPayViewMenuItemHelper b = MessengerPayViewMenuItemHelper.m15777b(fbInjector);
        orionPayMessengerPayView.f15577a = a;
        orionPayMessengerPayView.f15578b = enterPaymentValueTextControllerProvider;
        orionPayMessengerPayView.f15579c = b;
    }

    public OrionPayMessengerPayView(Context context) {
        super(context);
        Class cls = OrionPayMessengerPayView.class;
        m15804a(this, getContext());
        setContentView(2130905928);
        this.f15590n = (ViewPager) a(2131565279);
        this.f15581e = (DollarIconEditText) a(2131561181);
        this.f15582f = (ProgressBar) a(2131561183);
        this.f15583g = (FbTextView) a(2131561188);
        this.f15584h = (FbButton) a(2131561189);
        this.f15585i = (LinearLayout) a(2131561187);
        this.f15586j = (LinearLayout) a(2131561184);
        this.f15587k = (FbTextView) a(2131561185);
        this.f15588l = (FbTextView) a(2131561186);
        this.f15589m = (MemoInputView) a(2131561190);
        this.f15581e.m15483b();
        this.f15581e.setLongClickable(false);
        this.f15584h.setOnClickListener(new C18191(this));
        this.f15588l.setOnClickListener(new C18202(this));
        this.f15592p = this.f15578b.m15673a(new C18213(this));
        this.f15592p.m15668a(this.f15581e);
    }

    @Nullable
    public View getImmediateFocusView() {
        return this.f15581e;
    }

    public void setListener(C17747 c17747) {
        this.f15591o = c17747;
        this.f15589m.setListener(new C18224(this));
        this.f15590n.setOnPageChangeListener(new C18235(this));
    }

    public void setMessengerPayViewParams(MessengerPayViewParams messengerPayViewParams) {
        this.f15593q = (OrionMessengerPayViewParams) messengerPayViewParams;
        m15805c();
    }

    public final void mo620a() {
        this.f15592p.m15667a();
    }

    public final void mo621a(@Nullable MenuItem menuItem) {
        this.f15579c.m15779a(menuItem, this.f15593q.f15554b, this.f15593q.f15558f, this.f15593q.f15553a, false);
    }

    private void m15805c() {
        this.f15592p.m15670a(this.f15593q.f15558f.f15443b, this.f15593q.f15558f.f15442a);
        this.f15592p.m15669a(this.f15593q.f15558f.f15442a);
        this.f15592p.m15672b(this.f15593q.f15558f.f15442a);
        switch (this.f15593q.f15553a) {
            case PREPARE_PAYMENT:
                this.f15592p.m15671a(true);
                break;
            default:
                this.f15592p.m15671a(false);
                break;
        }
        m15806e();
        this.f15589m.setMemoText(this.f15593q.f15559g);
        if (this.f15593q.f15560h != null) {
            if (this.f15590n.getAdapter() == null) {
                this.f15590n.setAdapter(new ThemePagerAdapter(this.f15593q.f15560h, getContext()));
            } else {
                this.f15590n.a(ThemeHelper.m15867a(this.f15593q.f15560h, this.f15593q.f15561i), false);
            }
        }
    }

    private void m15806e() {
        if (this.f15593q.f15554b == null) {
            this.f15585i.setVisibility(8);
            this.f15586j.setVisibility(8);
            this.f15582f.setVisibility(0);
        } else if (this.f15593q.f15554b.isPresent()) {
            this.f15583g.setText(this.f15577a.getString(2131240387, new Object[]{((PaymentCard) this.f15593q.f15554b.get()).f13207f, ((PaymentCard) this.f15593q.f15554b.get()).m13503e()}));
            setPaymentCardInfoVisibility(0);
        } else {
            setPaymentCardInfoVisibility(8);
        }
    }

    private void setPaymentCardInfoVisibility(int i) {
        this.f15582f.setVisibility(8);
        if (i == 0) {
            this.f15585i.setVisibility(0);
            this.f15586j.setVisibility(8);
            return;
        }
        this.f15585i.setVisibility(8);
        this.f15586j.setVisibility(0);
        this.f15587k.setText(2131240394);
        this.f15587k.setCompoundDrawablesWithIntrinsicBounds(2130841118, 0, 0, 0);
        this.f15588l.setVisibility(0);
    }
}

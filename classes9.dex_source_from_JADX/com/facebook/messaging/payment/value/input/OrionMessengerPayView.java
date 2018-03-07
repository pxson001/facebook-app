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
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17747;
import com.facebook.messaging.payment.value.input.EnterPaymentValueTextController.Listener;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.base.Optional;
import javax.annotation.Nullable;

/* compiled from: event_message_details_fragment */
public class OrionMessengerPayView extends CustomRelativeLayout implements MessengerPayView {
    public Resources f15535a;
    public EnterPaymentValueTextControllerProvider f15536b;
    public MessengerPayViewMenuItemHelper f15537c;
    private final DollarIconEditText f15538d;
    private final Optional<FbTextView> f15539e;
    private final Optional<UserTileView> f15540f;
    private final Optional<ProgressBar> f15541g;
    private final ProgressBar f15542h;
    private final FbTextView f15543i;
    private final FbButton f15544j;
    private final LinearLayout f15545k;
    private final LinearLayout f15546l;
    private final FbTextView f15547m;
    private final FbTextView f15548n;
    private final MemoInputView f15549o;
    public C17747 f15550p;
    public EnterPaymentValueTextController f15551q;
    public OrionMessengerPayViewParams f15552r;

    /* compiled from: event_message_details_fragment */
    class C18141 implements OnClickListener {
        final /* synthetic */ OrionMessengerPayView f15530a;

        C18141(OrionMessengerPayView orionMessengerPayView) {
            this.f15530a = orionMessengerPayView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1221561806);
            this.f15530a.f15550p.m15630b();
            Logger.a(2, EntryType.UI_INPUT_END, 120577131, a);
        }
    }

    /* compiled from: event_message_details_fragment */
    class C18152 implements OnClickListener {
        final /* synthetic */ OrionMessengerPayView f15531a;

        C18152(OrionMessengerPayView orionMessengerPayView) {
            this.f15531a = orionMessengerPayView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -245379536);
            this.f15531a.f15550p.m15634g();
            Logger.a(2, EntryType.UI_INPUT_END, -1566223458, a);
        }
    }

    /* compiled from: event_message_details_fragment */
    class C18163 implements Listener {
        final /* synthetic */ OrionMessengerPayView f15532a;

        C18163(OrionMessengerPayView orionMessengerPayView) {
            this.f15532a = orionMessengerPayView;
        }

        public final void mo625a(String str) {
            this.f15532a.f15550p.m15631b(str);
        }
    }

    /* compiled from: event_message_details_fragment */
    class C18174 implements MemoInputView.Listener {
        final /* synthetic */ OrionMessengerPayView f15533a;

        C18174(OrionMessengerPayView orionMessengerPayView) {
            this.f15533a = orionMessengerPayView;
        }

        public final void mo626a(String str) {
            this.f15533a.f15550p.m15629a(str);
        }
    }

    public static void m15796a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        OrionMessengerPayView orionMessengerPayView = (OrionMessengerPayView) obj;
        Resources a = ResourcesMethodAutoProvider.a(fbInjector);
        EnterPaymentValueTextControllerProvider enterPaymentValueTextControllerProvider = (EnterPaymentValueTextControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(EnterPaymentValueTextControllerProvider.class);
        MessengerPayViewMenuItemHelper b = MessengerPayViewMenuItemHelper.m15777b(fbInjector);
        orionMessengerPayView.f15535a = a;
        orionMessengerPayView.f15536b = enterPaymentValueTextControllerProvider;
        orionMessengerPayView.f15537c = b;
    }

    public OrionMessengerPayView(Context context) {
        this(context, null);
    }

    private OrionMessengerPayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private OrionMessengerPayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = OrionMessengerPayView.class;
        m15796a(this, getContext());
        setContentView(2130905927);
        this.f15538d = (DollarIconEditText) a(2131561181);
        this.f15539e = b(2131565278);
        this.f15540f = b(2131565276);
        this.f15541g = b(2131565277);
        this.f15542h = (ProgressBar) a(2131561183);
        this.f15543i = (FbTextView) a(2131561188);
        this.f15544j = (FbButton) a(2131561189);
        this.f15545k = (LinearLayout) a(2131561187);
        this.f15546l = (LinearLayout) a(2131561184);
        this.f15547m = (FbTextView) a(2131561185);
        this.f15548n = (FbTextView) a(2131561186);
        this.f15549o = (MemoInputView) a(2131561190);
        this.f15538d.m15483b();
        this.f15538d.setLongClickable(false);
        this.f15544j.setOnClickListener(new C18141(this));
        this.f15548n.setOnClickListener(new C18152(this));
        this.f15551q = this.f15536b.m15673a(new C18163(this));
        this.f15551q.m15668a(this.f15538d);
    }

    @Nullable
    public View getImmediateFocusView() {
        return this.f15538d;
    }

    public void setListener(C17747 c17747) {
        this.f15550p = c17747;
        this.f15549o.setListener(new C18174(this));
    }

    public void setMessengerPayViewParams(MessengerPayViewParams messengerPayViewParams) {
        this.f15552r = (OrionMessengerPayViewParams) messengerPayViewParams;
        m15797b();
    }

    public final void mo620a() {
        this.f15551q.m15667a();
    }

    public final void mo621a(@Nullable MenuItem menuItem) {
        this.f15537c.m15779a(menuItem, this.f15552r.f15554b, this.f15552r.f15558f, this.f15552r.f15553a, false);
    }

    private void m15797b() {
        m15798c();
        this.f15551q.m15670a(this.f15552r.f15558f.f15443b, this.f15552r.f15558f.f15442a);
        this.f15551q.m15669a(this.f15552r.f15558f.f15442a);
        this.f15551q.m15672b(this.f15552r.f15558f.f15442a);
        switch (this.f15552r.f15553a) {
            case PREPARE_PAYMENT:
                this.f15551q.m15671a(true);
                break;
            default:
                this.f15551q.m15671a(false);
                break;
        }
        m15799e();
    }

    private void m15798c() {
        if (this.f15540f.isPresent() && this.f15552r.f15556d != null) {
            ((UserTileView) this.f15540f.get()).setParams(UserTileViewParams.a(this.f15552r.f15556d, TileBadge.NONE));
            ((UserTileView) this.f15540f.get()).setVisibility(0);
        }
        if (!this.f15539e.isPresent()) {
            return;
        }
        if (this.f15552r.f15555c == null) {
            setHeaderVisibility(8);
        } else if (this.f15552r.f15555c.h() || this.f15552r.f15555c.e()) {
            ((FbTextView) this.f15539e.get()).setText(this.f15552r.f15555c.i());
            setHeaderVisibility(0);
        } else {
            setHeaderVisibility(8);
        }
    }

    private void setHeaderVisibility(int i) {
        switch (i) {
            case 0:
                ((FbTextView) this.f15539e.get()).setVisibility(0);
                ((ProgressBar) this.f15541g.get()).setVisibility(8);
                return;
            case 8:
                ((FbTextView) this.f15539e.get()).setVisibility(8);
                ((ProgressBar) this.f15541g.get()).setVisibility(0);
                return;
            default:
                throw new IllegalArgumentException("Unexpected value for visibility " + i);
        }
    }

    private void m15799e() {
        if (this.f15552r.f15554b == null) {
            this.f15545k.setVisibility(8);
            this.f15546l.setVisibility(8);
            this.f15542h.setVisibility(0);
        } else if (this.f15552r.f15554b.isPresent()) {
            this.f15543i.setText(this.f15535a.getString(2131240387, new Object[]{((PaymentCard) this.f15552r.f15554b.get()).f13207f, ((PaymentCard) this.f15552r.f15554b.get()).m13503e()}));
            setPaymentCardInfoVisibility(0);
        } else {
            setPaymentCardInfoVisibility(8);
        }
    }

    private void setPaymentCardInfoVisibility(int i) {
        this.f15542h.setVisibility(8);
        if (i == 0) {
            this.f15545k.setVisibility(0);
            this.f15546l.setVisibility(8);
            return;
        }
        this.f15545k.setVisibility(8);
        this.f15546l.setVisibility(0);
        this.f15547m.setText(2131240394);
        this.f15547m.setCompoundDrawablesWithIntrinsicBounds(2130841118, 0, 0, 0);
        this.f15548n.setVisibility(0);
    }
}

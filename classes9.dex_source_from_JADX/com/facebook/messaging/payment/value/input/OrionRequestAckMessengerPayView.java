package com.facebook.messaging.payment.value.input;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.payment.currency.PaymentCurrencyUtil;
import com.facebook.messaging.payment.model.PaymentCard;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.messaging.payment.value.input.EnterPaymentValueFragment.C17747;
import com.facebook.messaging.payment.value.input.ui.ScaleTypeFitWidth;
import com.facebook.payments.dialog.PaymentsConfirmDialogFragment;
import com.facebook.payments.ui.FloatingLabelTextView;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.tiles.TileBadge;
import java.math.BigDecimal;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: euc-kr */
public class OrionRequestAckMessengerPayView extends CustomRelativeLayout implements MessengerPayView {
    @Inject
    public Resources f15616a;
    @Inject
    public EmojiUtil f15617b;
    @Inject
    public PaymentCurrencyUtil f15618c;
    public final FbDraweeView f15619d;
    public final DollarIconEditText f15620e;
    public final FloatingLabelTextView f15621f;
    public final FloatingLabelTextView f15622g;
    public final UserTileView f15623h;
    public final ProgressBar f15624i;
    public final FbTextView f15625j;
    public final FbButton f15626k;
    public final LinearLayout f15627l;
    public BetterButton f15628m;
    public FbTextView f15629n;
    public GenericDraweeHierarchy f15630o;
    public C17747 f15631p;
    public OrionMessengerPayViewParams f15632q;

    /* compiled from: euc-kr */
    public class C18271 implements OnClickListener {
        final /* synthetic */ OrionRequestAckMessengerPayView f15613a;

        public C18271(OrionRequestAckMessengerPayView orionRequestAckMessengerPayView) {
            this.f15613a = orionRequestAckMessengerPayView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1691607534);
            this.f15613a.f15631p.m15635h();
            Logger.a(2, EntryType.UI_INPUT_END, 1381389165, a);
        }
    }

    /* compiled from: euc-kr */
    public class C18282 implements OnClickListener {
        final /* synthetic */ OrionRequestAckMessengerPayView f15614a;

        public C18282(OrionRequestAckMessengerPayView orionRequestAckMessengerPayView) {
            this.f15614a = orionRequestAckMessengerPayView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 369451137);
            this.f15614a.f15631p.m15630b();
            Logger.a(2, EntryType.UI_INPUT_END, 370010303, a);
        }
    }

    /* compiled from: euc-kr */
    public class C18293 implements OnClickListener {
        final /* synthetic */ OrionRequestAckMessengerPayView f15615a;

        public C18293(OrionRequestAckMessengerPayView orionRequestAckMessengerPayView) {
            this.f15615a = orionRequestAckMessengerPayView;
        }

        public void onClick(View view) {
            String a;
            int a2 = Logger.a(2, EntryType.UI_INPUT_START, -1722795328);
            EnterPaymentValueFragment enterPaymentValueFragment = this.f15615a.f15631p.f15276a;
            EnterPaymentValueFragment.m15646b(enterPaymentValueFragment, "p2p_initiate_decline_request");
            if (enterPaymentValueFragment.ay.f15459p.b()) {
                a = enterPaymentValueFragment.ay.f15459p.a();
            } else {
                a = enterPaymentValueFragment.ay.f15459p.g();
            }
            PaymentsConfirmDialogFragment a3 = PaymentsConfirmDialogFragment.a(enterPaymentValueFragment.jW_().getString(2131240565, new Object[]{a}), enterPaymentValueFragment.jW_().getString(2131240566, new Object[]{a}), enterPaymentValueFragment.jW_().getString(2131240567), null, false);
            a3.am = enterPaymentValueFragment.aG;
            a3.a(enterPaymentValueFragment.kO_(), "decline_request_dialog");
            Logger.a(2, EntryType.UI_INPUT_END, -1059629615, a2);
        }
    }

    public static void m15821a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        OrionRequestAckMessengerPayView orionRequestAckMessengerPayView = (OrionRequestAckMessengerPayView) obj;
        Resources a = ResourcesMethodAutoProvider.a(injectorLike);
        EmojiUtil a2 = EmojiUtil.a(injectorLike);
        PaymentCurrencyUtil a3 = PaymentCurrencyUtil.m13192a(injectorLike);
        orionRequestAckMessengerPayView.f15616a = a;
        orionRequestAckMessengerPayView.f15617b = a2;
        orionRequestAckMessengerPayView.f15618c = a3;
    }

    public OrionRequestAckMessengerPayView(Context context) {
        this(context, null);
    }

    private OrionRequestAckMessengerPayView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private OrionRequestAckMessengerPayView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = OrionRequestAckMessengerPayView.class;
        m15821a(this, getContext());
        setContentView(2130905932);
        this.f15619d = (FbDraweeView) a(2131565282);
        this.f15620e = (DollarIconEditText) a(2131563925);
        this.f15621f = (FloatingLabelTextView) a(2131565278);
        this.f15622g = (FloatingLabelTextView) a(2131563802);
        this.f15623h = (UserTileView) a(2131565276);
        this.f15624i = (ProgressBar) a(2131561183);
        this.f15625j = (FbTextView) a(2131561188);
        this.f15626k = (FbButton) a(2131561189);
        this.f15627l = (LinearLayout) a(2131561187);
        this.f15628m = (BetterButton) a(2131565283);
        this.f15629n = (FbTextView) a(2131565284);
        this.f15620e.m15483b();
    }

    @Nullable
    public View getImmediateFocusView() {
        return null;
    }

    public void setListener(C17747 c17747) {
        this.f15631p = c17747;
        this.f15628m.setOnClickListener(new C18271(this));
        this.f15626k.setOnClickListener(new C18282(this));
        this.f15629n.setOnClickListener(new C18293(this));
    }

    public void setMessengerPayViewParams(MessengerPayViewParams messengerPayViewParams) {
        this.f15632q = (OrionMessengerPayViewParams) messengerPayViewParams;
        if (this.f15632q.f15556d != null) {
            this.f15623h.setParams(UserTileViewParams.a(this.f15632q.f15556d, TileBadge.NONE));
        }
        this.f15621f.setHint(this.f15616a.getString(2131240558));
        if (this.f15632q.f15555c != null) {
            this.f15621f.setText(this.f15632q.f15555c.i());
        }
        if (StringUtil.c(this.f15632q.f15559g)) {
            this.f15622g.setVisibility(8);
        } else {
            CharSequence spannableStringBuilder = new SpannableStringBuilder(Factory.getInstance().newSpannable(this.f15632q.f15559g.trim()));
            this.f15617b.a(spannableStringBuilder, (int) this.f15622g.getTextSize());
            this.f15622g.setText(spannableStringBuilder);
            this.f15622g.setVisibility(0);
        }
        if (this.f15632q.f15558f != null) {
            this.f15620e.m15482a(this.f15632q.f15558f.f15443b, this.f15632q.f15558f.f15442a);
        }
        if (this.f15632q.f15554b == null) {
            this.f15627l.setVisibility(8);
            this.f15624i.setVisibility(0);
        } else {
            this.f15624i.setVisibility(8);
            if (this.f15632q.f15554b.isPresent()) {
                this.f15625j.setText(this.f15616a.getString(2131240387, new Object[]{((PaymentCard) this.f15632q.f15554b.get()).f13207f, ((PaymentCard) this.f15632q.f15554b.get()).m13503e()}));
                this.f15627l.setVisibility(0);
            } else {
                this.f15627l.setVisibility(8);
            }
        }
        if (this.f15632q.f15561i != null) {
            this.f15630o = new GenericDraweeHierarchyBuilder(getContext().getResources()).e(new ScaleTypeFitWidth()).u();
            this.f15619d.setHierarchy(this.f15630o);
            this.f15619d.a(ThemeHelper.m15868a(this.f15632q.f15561i), CallerContext.a(getContext()));
        }
    }

    public final void mo620a() {
    }

    public final void mo621a(@Nullable MenuItem menuItem) {
        boolean z = true;
        if (this.f15632q.f15554b == null) {
            this.f15628m.setVisibility(4);
            return;
        }
        boolean z2;
        this.f15628m.setVisibility(0);
        this.f15628m.setText(this.f15632q.f15554b.isPresent() ? 2131240560 : 2131240386);
        if (this.f15618c.m13201a(this.f15632q.f15558f.f15442a, this.f15632q.f15558f.f15443b).compareTo(BigDecimal.ZERO) > 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        BetterButton betterButton = this.f15628m;
        if (!(z2 && this.f15632q.f15553a == MessengerPayState.PREPARE_PAYMENT)) {
            z = false;
        }
        betterButton.setEnabled(z);
    }
}

package com.facebook.messaging.payment.thread;

import android.content.Context;
import android.text.Spannable.Factory;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.FbInjector;
import com.facebook.payments.ui.FloatingLabelTextView;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.widget.animatablelistview.AnimatingItemView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: fb4a_timeline_disk_cache_trim_table */
public class PaymentBubbleDetailsView extends AnimatingItemView {
    @Inject
    public EmojiUtil f14981a;
    private FloatingLabelTextView f14982b;
    private FloatingLabelTextView f14983c;

    private static <T extends View> void m15364a(Class<T> cls, T t) {
        m15365a((Object) t, t.getContext());
    }

    private static void m15365a(Object obj, Context context) {
        ((PaymentBubbleDetailsView) obj).f14981a = EmojiUtil.a(FbInjector.get(context));
    }

    public PaymentBubbleDetailsView(Context context) {
        this(context, null);
    }

    public PaymentBubbleDetailsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PaymentBubbleDetailsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m15364a(PaymentBubbleDetailsView.class, (View) this);
        setContentView(2130905805);
        this.f14982b = (FloatingLabelTextView) getView(2131563802);
        this.f14983c = (FloatingLabelTextView) getView(2131565033);
    }

    public void setMemoText(@Nullable String str) {
        if (StringUtil.c(str)) {
            this.f14982b.setVisibility(8);
            return;
        }
        CharSequence spannableStringBuilder = new SpannableStringBuilder(Factory.getInstance().newSpannable(str.trim()));
        this.f14981a.a(spannableStringBuilder, (int) this.f14982b.getTextSize());
        this.f14982b.setText(spannableStringBuilder);
        this.f14982b.setVisibility(0);
    }

    public void setStatusText(@Nullable String str) {
        if (StringUtil.c(str)) {
            this.f14983c.setVisibility(8);
            return;
        }
        this.f14983c.setText(str);
        this.f14983c.setVisibility(0);
    }

    private void m15363a(EmojiUtil emojiUtil) {
        this.f14981a = emojiUtil;
    }
}

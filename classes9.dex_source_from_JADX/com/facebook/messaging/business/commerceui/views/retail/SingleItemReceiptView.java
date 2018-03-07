package com.facebook.messaging.business.commerceui.views.retail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModel;
import com.facebook.messaging.business.commerceui.views.CommerceView;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: notifications_survey_shown */
public class SingleItemReceiptView extends CustomRelativeLayout implements CommerceView {
    private static final CallerContext f8633b = CallerContext.a(SingleItemReceiptView.class);
    @Inject
    public CommerceViewHelpers f8634a;
    private final FbDraweeView f8635c;
    private final FbDraweeView f8636d;
    private final BetterTextView f8637e;
    private final BetterTextView f8638f;
    private final BetterTextView f8639g;
    private final BetterTextView f8640h;
    private final BetterTextView f8641i;
    private final BetterTextView f8642j;
    private final ReceiptViewModelHelper f8643k;
    private PlatformGenericAttachmentItem f8644l;

    private static <T extends View> void m8856a(Class<T> cls, T t) {
        m8857a((Object) t, t.getContext());
    }

    private static void m8857a(Object obj, Context context) {
        ((SingleItemReceiptView) obj).f8634a = CommerceViewHelpers.m8755b(FbInjector.get(context));
    }

    private void m8855a(CommerceViewHelpers commerceViewHelpers) {
        this.f8634a = commerceViewHelpers;
    }

    public SingleItemReceiptView(Context context) {
        this(context, null);
    }

    public SingleItemReceiptView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SingleItemReceiptView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m8856a(SingleItemReceiptView.class, (View) this);
        setContentView(2130905618);
        this.f8643k = new ReceiptViewModelHelper(context);
        this.f8635c = (FbDraweeView) a(2131564642);
        this.f8636d = (FbDraweeView) a(2131564643);
        this.f8637e = (BetterTextView) a(2131564570);
        this.f8638f = (BetterTextView) a(2131564571);
        this.f8639g = (BetterTextView) a(2131564572);
        this.f8640h = (BetterTextView) a(2131564573);
        this.f8641i = (BetterTextView) a(2131564565);
        this.f8642j = (BetterTextView) a(2131564566);
    }

    public void setModel(CommerceBubbleModel commerceBubbleModel) {
        boolean z = true;
        if (commerceBubbleModel.c().size() != 1) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.f8643k.m8802a(commerceBubbleModel);
        this.f8644l = (PlatformGenericAttachmentItem) commerceBubbleModel.c().get(0);
        m8858b();
    }

    public final boolean mo231a() {
        return false;
    }

    private void m8858b() {
        Preconditions.checkNotNull(this.f8643k.f8574b);
        Preconditions.checkNotNull(this.f8644l);
        if (this.f8644l.d != null) {
            this.f8635c.setVisibility(0);
            this.f8635c.setBackgroundResource(2131363762);
            this.f8635c.a(this.f8644l.d, f8633b);
        } else {
            this.f8635c.setVisibility(8);
        }
        this.f8634a.m8756a(this.f8636d, this.f8643k.m8803c(), f8633b);
        this.f8641i.setText(this.f8643k.m8805f());
        this.f8642j.setText(this.f8643k.m8806g());
        m8859c();
    }

    private void m8859c() {
        int i = 0;
        this.f8637e.setText(this.f8644l.b);
        this.f8638f.setVisibility(!Strings.isNullOrEmpty(this.f8644l.g) ? 0 : 8);
        this.f8638f.setText(!Strings.isNullOrEmpty(this.f8644l.g) ? this.f8644l.g : "");
        BetterTextView betterTextView = this.f8639g;
        if (Strings.isNullOrEmpty(this.f8644l.h)) {
            i = 8;
        }
        betterTextView.setVisibility(i);
        this.f8639g.setText(!Strings.isNullOrEmpty(this.f8644l.h) ? this.f8644l.h : "");
        this.f8640h.setVisibility(8);
    }
}

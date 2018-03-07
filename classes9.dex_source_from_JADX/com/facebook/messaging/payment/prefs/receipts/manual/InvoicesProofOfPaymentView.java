package com.facebook.messaging.payment.prefs.receipts.manual;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.widget.text.GlyphWithTextView;
import com.facebook.messaging.payment.ui.DollarIconEditText;
import com.facebook.widget.text.BetterButton;
import com.facebook.widget.text.BetterTextView;

/* compiled from: getNai */
public class InvoicesProofOfPaymentView {
    public final ViewSwitcher f14194a;
    public final DollarIconEditText f14195b;
    public final BetterTextView f14196c;
    public final BetterTextView f14197d;
    public final BetterTextView f14198e;
    public final BetterTextView f14199f;
    public final GlyphWithTextView f14200g;
    public final BetterTextView f14201h;
    public final ViewGroup f14202i;
    public final BetterButton f14203j;
    public final FbDraweeView f14204k;
    public final ImageView f14205l;

    public InvoicesProofOfPaymentView(ViewGroup viewGroup) {
        this.f14194a = (ViewSwitcher) FindViewUtil.b(viewGroup, 2131560463);
        this.f14195b = (DollarIconEditText) FindViewUtil.b(viewGroup, 2131560464);
        this.f14196c = (BetterTextView) FindViewUtil.b(viewGroup, 2131560465);
        this.f14197d = (BetterTextView) FindViewUtil.b(viewGroup, 2131560466);
        this.f14198e = (BetterTextView) FindViewUtil.b(viewGroup, 2131560467);
        this.f14199f = (BetterTextView) FindViewUtil.b(viewGroup, 2131559358);
        this.f14200g = (GlyphWithTextView) FindViewUtil.b(viewGroup, 2131560468);
        this.f14201h = (BetterTextView) FindViewUtil.b(viewGroup, 2131560473);
        this.f14202i = (ViewGroup) FindViewUtil.b(viewGroup, 2131560470);
        this.f14203j = (BetterButton) FindViewUtil.b(viewGroup, 2131560469);
        this.f14204k = (FbDraweeView) FindViewUtil.b(viewGroup, 2131560471);
        this.f14205l = (ImageView) FindViewUtil.b(viewGroup, 2131560472);
        this.f14195b.m15481a();
    }

    public final Context m14658a() {
        return this.f14194a.getContext();
    }

    public final void m14660b() {
        this.f14194a.setVisibility(0);
        this.f14194a.setDisplayedChild(0);
    }

    public final void m14659a(boolean z) {
        this.f14195b.setVisibility(z ? 0 : 8);
    }
}

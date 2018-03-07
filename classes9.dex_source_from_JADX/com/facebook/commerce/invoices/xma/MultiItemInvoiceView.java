package com.facebook.commerce.invoices.xma;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import com.facebook.commerce.invoices.common.InvoicesUIHelper;
import com.facebook.commerce.invoices.xma.InvoicesViewModelHelper.C06211;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.FindViewUtil;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.glyph.GlyphColorizer;
import com.facebook.inject.FbInjector;
import com.facebook.messaging.business.attachments.model.PlatformGenericAttachmentItem;
import com.facebook.messaging.business.commerce.model.retail.CommerceBubbleModel;
import com.facebook.messaging.business.commerceui.views.CommerceView;
import com.facebook.messaging.business.commerceui.views.retail.ReceiptViewModelHelper;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.text.BetterTextView;
import com.google.common.base.Strings;
import javax.inject.Inject;

/* compiled from: qrcode */
public class MultiItemInvoiceView extends CustomRelativeLayout implements CommerceView {
    public static final CallerContext f5960b = CallerContext.a(MultiItemInvoiceView.class);
    @Inject
    public InvoicesViewModelHelper f5961a;
    public final ReceiptViewModelHelper f5962c;
    public final View f5963d;
    public final BetterTextView f5964e;

    public static void m6294a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((MultiItemInvoiceView) obj).f5961a = new InvoicesViewModelHelper(new InvoicesUIHelper(ResourcesMethodAutoProvider.a(fbInjector)), GlyphColorizer.a(fbInjector), ResourcesMethodAutoProvider.a(fbInjector));
    }

    public MultiItemInvoiceView(Context context) {
        this(context, null);
    }

    private MultiItemInvoiceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private MultiItemInvoiceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Class cls = MultiItemInvoiceView.class;
        m6294a(this, getContext());
        setContentView(2130905594);
        this.f5962c = new ReceiptViewModelHelper(context);
        this.f5963d = a(2131564529);
        this.f5964e = (BetterTextView) a(2131564530);
        LayoutParams layoutParams = this.f5964e.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        } else {
            layoutParams.width = -2;
        }
        this.f5964e.setLayoutParams(layoutParams);
        this.f5964e.setGravity(21);
        this.f5964e.setCompoundDrawablePadding((int) getResources().getDimension(2131427421));
    }

    public void setModel(@Nullable CommerceBubbleModel commerceBubbleModel) {
        Invoice invoice = (Invoice) commerceBubbleModel;
        if (commerceBubbleModel != null) {
            this.f5962c.m8802a(invoice.f5933a);
            this.f5961a.f5955d = invoice;
            m6295c();
            return;
        }
        this.f5963d.setVisibility(8);
        this.f5964e.setText(null);
    }

    public final boolean mo231a() {
        return false;
    }

    private void m6296e() {
        String str;
        this.f5964e.setTransformationMethod(null);
        BetterTextView betterTextView = this.f5964e;
        InvoicesViewModelHelper invoicesViewModelHelper = this.f5961a;
        if (invoicesViewModelHelper.f5955d != null) {
            str = invoicesViewModelHelper.f5955d.f5935c;
        } else {
            str = null;
        }
        betterTextView.setText(str);
        betterTextView = this.f5964e;
        Context context = getContext();
        InvoicesViewModelHelper invoicesViewModelHelper2 = this.f5961a;
        int i = 2131626391;
        if (invoicesViewModelHelper2.f5955d != null) {
            switch (C06211.f5951a[invoicesViewModelHelper2.f5955d.f5934b.ordinal()]) {
                case 1:
                case 2:
                    i = 2131626394;
                    break;
                default:
                    break;
            }
        }
        betterTextView.setTextAppearance(context, i);
        betterTextView = this.f5964e;
        invoicesViewModelHelper = this.f5961a;
        Drawable drawable = null;
        if (invoicesViewModelHelper.f5955d != null) {
            switch (C06211.f5951a[invoicesViewModelHelper.f5955d.f5934b.ordinal()]) {
                case 3:
                    drawable = invoicesViewModelHelper.f5953b.a(2130839776, invoicesViewModelHelper.f5954c.getColor(2131361854));
                    break;
                default:
                    break;
            }
        }
        betterTextView.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);
    }

    private void m6295c() {
        PlatformGenericAttachmentItem platformGenericAttachmentItem;
        if (this.f5962c.f8574b == null || this.f5962c.f8574b.c().isEmpty()) {
            platformGenericAttachmentItem = null;
        } else {
            platformGenericAttachmentItem = (PlatformGenericAttachmentItem) this.f5962c.f8574b.c().get(0);
        }
        PlatformGenericAttachmentItem platformGenericAttachmentItem2 = platformGenericAttachmentItem;
        if (platformGenericAttachmentItem2 == null) {
            this.f5963d.setVisibility(8);
        } else {
            this.f5963d.setVisibility(0);
            FbDraweeView fbDraweeView = (FbDraweeView) FindViewUtil.b(this.f5963d, 2131564574);
            if (platformGenericAttachmentItem2.d != null) {
                fbDraweeView.a(platformGenericAttachmentItem2.d, f5960b);
            }
            ((BetterTextView) FindViewUtil.b(this.f5963d, 2131564570)).setText(platformGenericAttachmentItem2.b);
            View view = this.f5963d;
            int i = 0;
            BetterTextView betterTextView = (BetterTextView) FindViewUtil.b(view, 2131564571);
            betterTextView.setVisibility(!Strings.isNullOrEmpty(platformGenericAttachmentItem2.g) ? 0 : 8);
            betterTextView.setText(!Strings.isNullOrEmpty(platformGenericAttachmentItem2.g) ? platformGenericAttachmentItem2.g : "");
            betterTextView = (BetterTextView) FindViewUtil.b(view, 2131564572);
            if (Strings.isNullOrEmpty(platformGenericAttachmentItem2.h)) {
                i = 8;
            }
            betterTextView.setVisibility(i);
            betterTextView.setText(!Strings.isNullOrEmpty(platformGenericAttachmentItem2.h) ? platformGenericAttachmentItem2.h : "");
            ((BetterTextView) FindViewUtil.b(view, 2131564573)).setVisibility(8);
        }
        m6296e();
    }
}

package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.util.StringUtil;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.inject.InjectorLike;
import com.facebook.richdocument.ham.HamDimensions;
import com.facebook.richdocument.ham.HamViewUtils;
import com.facebook.richdocument.model.block.RichDocumentImageData;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.presenter.BylineBlockPresenter;
import com.facebook.richdocument.view.block.BylineBlockView;
import com.facebook.richdocument.view.util.RichDocumentLayoutDirection;
import com.facebook.richdocument.view.widget.RichTextView;
import java.util.List;

/* compiled from: page_type */
public class BylineBlockViewImpl extends AbstractBlockView<BylineBlockPresenter> implements BylineBlockView {
    private static final CallerContext f6619a = CallerContext.a(BylineBlockViewImpl.class);
    private final FbDraweeView f6620b;
    private final LinearLayout f6621c;
    private final RichTextView f6622d;
    private final RichTextView f6623e;
    private final int f6624f = (this.f6627i.m5276b(2131558648) / 2);
    public FbDraweeControllerBuilder f6625g;
    public HamViewUtils f6626h;
    public HamDimensions f6627i;
    public RichDocumentLayoutDirection f6628j;

    public static void m6956a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        BylineBlockViewImpl bylineBlockViewImpl = (BylineBlockViewImpl) obj;
        FbDraweeControllerBuilder b = FbDraweeControllerBuilder.b(injectorLike);
        HamViewUtils a = HamViewUtils.m5278a(injectorLike);
        HamDimensions a2 = HamDimensions.m5268a(injectorLike);
        RichDocumentLayoutDirection a3 = RichDocumentLayoutDirection.m7366a(injectorLike);
        bylineBlockViewImpl.f6625g = b;
        bylineBlockViewImpl.f6626h = a;
        bylineBlockViewImpl.f6627i = a2;
        bylineBlockViewImpl.f6628j = a3;
    }

    public BylineBlockViewImpl(View view, FbDraweeView fbDraweeView, LinearLayout linearLayout, RichTextView richTextView, RichTextView richTextView2) {
        super(view);
        this.f6620b = fbDraweeView;
        this.f6621c = linearLayout;
        this.f6622d = richTextView;
        this.f6623e = richTextView2;
        Class cls = BylineBlockViewImpl.class;
        m6956a((Object) this, getContext());
        this.f6626h.m5280a(this.f6620b, 2131558727, 2131558727);
        this.f6626h.m5283c(this.f6620b, 0, 0, 0, 2131558648);
        if (!RichDocumentLayoutDirection.m7368c()) {
            return;
        }
        if (this.f6628j.m7369a()) {
            this.f6621c.setLayoutDirection(1);
            this.f6622d.f7393d.setGravity(5);
            this.f6623e.f7393d.setGravity(5);
            return;
        }
        this.f6621c.setLayoutDirection(0);
        this.f6622d.f7393d.setGravity(3);
        this.f6623e.f7393d.setGravity(3);
    }

    public final void mo374a(Bundle bundle) {
        super.mo374a(bundle);
        this.f6620b.setVisibility(8);
        this.f6622d.setVisibility(8);
        this.f6623e.setVisibility(8);
    }

    public final void m6959a(RichDocumentImageData richDocumentImageData) {
        this.f6620b.setVisibility(0);
        if (richDocumentImageData == null || StringUtil.a(richDocumentImageData.f5622a)) {
            this.f6620b.setBackgroundResource(2130841701);
        } else {
            this.f6620b.a(Uri.parse(richDocumentImageData.f5622a), f6619a);
        }
    }

    public final void m6961a(List<RichDocumentImageData> list) {
        this.f6621c.removeAllViews();
        this.f6621c.setVisibility(0);
        for (RichDocumentImageData richDocumentImageData : list) {
            FbDraweeView fbDraweeView = new FbDraweeView(getContext());
            LayoutParams layoutParams = new LinearLayout.LayoutParams((int) iY_().getResources().getDimension(2131431819), (int) iY_().getResources().getDimension(2131431820));
            layoutParams.setMargins(0, 0, this.f6624f, 0);
            fbDraweeView.setVisibility(0);
            fbDraweeView.setLayoutParams(layoutParams);
            if (richDocumentImageData.f5622a == null) {
                fbDraweeView.setBackgroundResource(2130841701);
            } else {
                fbDraweeView.a(Uri.parse(richDocumentImageData.f5622a), f6619a);
            }
            this.f6621c.addView(fbDraweeView);
        }
    }

    public final void m6960a(RichText richText) {
        m6955a(this.f6622d, richText);
        m6957c();
    }

    public final void m6962b(RichText richText) {
        m6955a(this.f6623e, richText);
        m6957c();
    }

    private void m6957c() {
        if (this.f6623e.getVisibility() == 0 && this.f6622d.getVisibility() == 0) {
            getContext().getResources();
            int b = this.f6627i.m5276b(2131558665);
            this.f6623e.setPadding(this.f6623e.getPaddingLeft(), this.f6627i.m5276b(2131558683) - b, this.f6623e.getPaddingRight(), this.f6623e.getPaddingBottom());
            return;
        }
        this.f6623e.setPadding(this.f6623e.getPaddingLeft(), 0, this.f6623e.getPaddingRight(), this.f6623e.getPaddingBottom());
    }

    private static void m6955a(RichTextView richTextView, RichText richText) {
        if (richText == null || StringUtil.a(richText.f5641a)) {
            richTextView.setVisibility(8);
            return;
        }
        richTextView.setVisibility(0);
        richTextView.f7393d.setText(richText);
    }
}

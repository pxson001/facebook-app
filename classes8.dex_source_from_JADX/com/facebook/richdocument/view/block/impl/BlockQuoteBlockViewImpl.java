package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.ham.HamViewUtils;
import javax.inject.Inject;

/* compiled from: page_view_referrer */
public class BlockQuoteBlockViewImpl extends TextBlockViewImpl {
    @Inject
    public HamViewUtils f6618a;

    public static void m6954a(Object obj, Context context) {
        ((BlockQuoteBlockViewImpl) obj).f6618a = HamViewUtils.m5278a(FbInjector.get(context));
    }

    public BlockQuoteBlockViewImpl(View view) {
        super(view);
        Class cls = BlockQuoteBlockViewImpl.class;
        m6954a(this, getContext());
        this.f6618a.m5283c(this.f6617d, 2131558650, 0, 2131558650, 0);
    }
}

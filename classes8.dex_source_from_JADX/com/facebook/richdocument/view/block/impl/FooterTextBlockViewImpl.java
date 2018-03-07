package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.ham.HamViewUtils;
import com.facebook.richdocument.view.block.CustomBackgroundAware;
import com.facebook.richdocument.view.block.TextBlockView;
import javax.inject.Inject;

/* compiled from: page_service_image_height */
public class FooterTextBlockViewImpl extends TextBlockViewImpl implements CustomBackgroundAware {
    @Inject
    public HamViewUtils f6632a;
    private final int f6633b = getContext().getResources().getColor(2131363478);

    public static void m6966a(Object obj, Context context) {
        ((FooterTextBlockViewImpl) obj).f6632a = HamViewUtils.m5278a(FbInjector.get(context));
    }

    private FooterTextBlockViewImpl(View view) {
        super(view);
        Class cls = FooterTextBlockViewImpl.class;
        m6966a(this, getContext());
        this.f6632a.m5281a(this.f6617d, 0, 2131558651, 0, 0);
    }

    public final int mo383a() {
        return this.f6633b;
    }

    public static TextBlockView m6965a(View view) {
        return new FooterTextBlockViewImpl(view);
    }
}

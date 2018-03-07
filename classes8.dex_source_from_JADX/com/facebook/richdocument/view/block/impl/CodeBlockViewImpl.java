package com.facebook.richdocument.view.block.impl;

import android.content.Context;
import android.view.View;
import com.facebook.inject.FbInjector;
import com.facebook.richdocument.ham.HamViewUtils;
import com.facebook.richdocument.view.block.CustomBackgroundAware;
import javax.inject.Inject;

/* compiled from: page_service_image_width */
public class CodeBlockViewImpl extends TextBlockViewImpl implements CustomBackgroundAware {
    @Inject
    public HamViewUtils f6629a;
    private final int f6630b = getContext().getResources().getColor(2131361941);
    public final int f6631e = ((int) getContext().getResources().getDimension(2131431880));

    public static void m6963a(Object obj, Context context) {
        ((CodeBlockViewImpl) obj).f6629a = HamViewUtils.m5278a(FbInjector.get(context));
    }

    public CodeBlockViewImpl(View view) {
        super(view);
        Class cls = CodeBlockViewImpl.class;
        m6963a(this, getContext());
        this.f6629a.m5283c(this.f6617d, 2131558650, 0, 2131558650, 0);
    }

    public final int mo383a() {
        return this.f6630b;
    }
}

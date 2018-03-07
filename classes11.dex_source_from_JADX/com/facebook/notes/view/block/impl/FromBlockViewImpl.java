package com.facebook.notes.view.block.impl;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.inject.FbInjector;
import com.facebook.notes.presenter.FromBlockPresenter;
import com.facebook.notes.view.block.FromBlockView;
import com.facebook.richdocument.ham.HamViewUtils;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import javax.inject.Inject;

/* compiled from: Tried to start a transaction from originator  */
public class FromBlockViewImpl extends AbstractBlockView<FromBlockPresenter> implements FromBlockView {
    public static final CallerContext f10535b = CallerContext.a(FromBlockViewImpl.class, "unknown");
    @Inject
    public HamViewUtils f10536a;
    public final TextView f10537c;
    public final FbDraweeView f10538d;

    public static void m11039a(Object obj, Context context) {
        ((FromBlockViewImpl) obj).f10536a = HamViewUtils.a(FbInjector.get(context));
    }

    public FromBlockViewImpl(View view) {
        super(view);
        Class cls = FromBlockViewImpl.class;
        m11039a(this, getContext());
        this.f10537c = (TextView) view.findViewById(2131564256);
        this.f10538d = (FbDraweeView) view.findViewById(2131564255);
        this.f10536a.a(this.f10538d, 2131558651, 2131558651);
    }
}

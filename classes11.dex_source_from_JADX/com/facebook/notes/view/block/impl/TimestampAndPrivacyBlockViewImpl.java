package com.facebook.notes.view.block.impl;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.facebook.common.timeformat.DefaultTimeFormatUtil;
import com.facebook.inject.FbInjector;
import com.facebook.notes.presenter.TimestampAndPrivacyBlockPresenter;
import com.facebook.notes.view.block.TimestampAndPrivacyBlockView;
import com.facebook.richdocument.view.block.impl.AbstractBlockView;
import javax.inject.Inject;

/* compiled from: Tried to show an alert while not attached to an Activity */
public class TimestampAndPrivacyBlockViewImpl extends AbstractBlockView<TimestampAndPrivacyBlockPresenter> implements TimestampAndPrivacyBlockView {
    @Inject
    public DefaultTimeFormatUtil f10539a;
    public final TextView f10540b;

    public static void m11040a(Object obj, Context context) {
        ((TimestampAndPrivacyBlockViewImpl) obj).f10539a = DefaultTimeFormatUtil.a(FbInjector.get(context));
    }

    public TimestampAndPrivacyBlockViewImpl(View view) {
        super(view);
        Class cls = TimestampAndPrivacyBlockViewImpl.class;
        m11040a(this, getContext());
        this.f10540b = (TextView) view.findViewById(2131564257);
    }
}

package com.facebook.feedplugins.attachments.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.google.common.base.Function;
import com.google.common.base.Functions.IdentityFunction;

/* compiled from: personal_account_password_with_work_username */
public class VideoZeroDialogPartDefinition$Props {
    public final OnClickListener f5049a;
    public final Function<View, View> f5050b;

    public VideoZeroDialogPartDefinition$Props(OnClickListener onClickListener, Function<View, View> function) {
        this.f5049a = onClickListener;
        this.f5050b = function;
    }

    public VideoZeroDialogPartDefinition$Props(OnClickListener onClickListener) {
        this.f5049a = onClickListener;
        this.f5050b = IdentityFunction.INSTANCE;
    }
}

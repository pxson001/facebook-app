package com.facebook.feedplugins.attachments.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.iorg.common.zero.ui.ZeroDialogController$Listener;
import javax.annotation.Nullable;

/* compiled from: personal_account_password_with_work_username */
public class VideoZeroDialogPartDefinition$ZeroDialogListener implements ZeroDialogController$Listener {
    private final OnClickListener f5061a;
    @Nullable
    public View f5062b;

    public VideoZeroDialogPartDefinition$ZeroDialogListener(OnClickListener onClickListener) {
        this.f5061a = onClickListener;
    }

    public final void mo443a(Object obj) {
        if (this.f5062b != null) {
            this.f5061a.onClick(this.f5062b);
        }
    }

    public final void mo442a() {
    }
}

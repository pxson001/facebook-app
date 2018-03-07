package com.facebook.places.checkin.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.facebook.fbui.widget.megaphone.Megaphone;
import com.facebook.fbui.widget.megaphone.Megaphone.OnDismissListener;
import com.facebook.inject.Assisted;
import com.facebook.widget.LazyView;
import com.google.common.annotations.VisibleForTesting;
import javax.inject.Inject;

/* compiled from: channel_type */
public class CheckinNiemMegaphoneImpl extends BaseCheckinNiemUI {
    @Inject
    public CheckinNiemMegaphoneImpl(@Assisted LazyView lazyView, @Assisted String str, Context context) {
        super(lazyView, str, context.getResources());
    }

    public final boolean mo1074a(OnClickListener onClickListener, OnDismissListener onDismissListener) {
        Megaphone megaphone = (Megaphone) mo1075b();
        if (megaphone == null) {
            return false;
        }
        if (VERSION.SDK_INT >= 16) {
            megaphone.setBackground(new ColorDrawable(-1));
        } else {
            megaphone.setBackgroundColor(-1);
        }
        megaphone.setOnSecondaryButtonClickListener(onClickListener);
        megaphone.setSecondaryButtonText(m22017a(2131235308, new String[0]));
        megaphone.setPrimaryButtonText(m22017a(2131235307, new String[0]));
        megaphone.m = onDismissListener;
        return true;
    }

    public final void mo1072a() {
        ((Megaphone) mo1075b()).setVisibility(8);
    }

    public final void mo1073a(OnClickListener onClickListener) {
        Megaphone megaphone = (Megaphone) mo1075b();
        megaphone.setVisibility(0);
        megaphone.setTitle(m22017a(2131235297, new String[0]));
        megaphone.setSubtitle(m22017a(2131235172, new String[0]));
        megaphone.setShowSecondaryButton(false);
        megaphone.setShowCloseButton(false);
        megaphone.setPrimaryButtonText(m22017a(2131235308, new String[0]));
        megaphone.setOnPrimaryButtonClickListener(onClickListener);
    }

    public final void mo1076b(OnClickListener onClickListener) {
        Megaphone megaphone = (Megaphone) mo1075b();
        megaphone.setVisibility(0);
        megaphone.setTitle(m22017a(2131235296, new String[0]));
        megaphone.setSubtitle(m22017a(2131235302, new String[0]));
        megaphone.setOnPrimaryButtonClickListener(onClickListener);
        megaphone.setImageDrawable(null);
        megaphone.setShowCloseButton(true);
        megaphone.setShowSecondaryButton(false);
    }

    public final void mo1077c(OnClickListener onClickListener) {
        Megaphone megaphone = (Megaphone) mo1075b();
        megaphone.setVisibility(0);
        megaphone.setTitle(m22017a(2131235295, new String[0]));
        megaphone.setSubtitle(m22017a(2131235301, new String[0]));
        megaphone.setPrimaryButtonText(m22017a(2131235306, new String[0]));
        megaphone.setOnPrimaryButtonClickListener(onClickListener);
        megaphone.setImageDrawable(null);
        megaphone.setShowCloseButton(true);
        megaphone.setShowSecondaryButton(false);
    }

    public final void mo1078d(OnClickListener onClickListener) {
        Megaphone megaphone = (Megaphone) mo1075b();
        megaphone.setVisibility(0);
        megaphone.setTitle(m22017a(2131235298, new String[0]));
        megaphone.setSubtitle(m22017a(2131235303, new String[0]));
        megaphone.setOnPrimaryButtonClickListener(onClickListener);
        megaphone.setImageDrawable(null);
        megaphone.setShowCloseButton(false);
        megaphone.setShowSecondaryButton(true);
    }

    public final void mo1079e(OnClickListener onClickListener) {
        Megaphone megaphone = (Megaphone) mo1075b();
        megaphone.setVisibility(0);
        megaphone.setTitle(m22017a(2131235299, new String[0]));
        megaphone.setSubtitle(m22017a(2131235304, new String[0]));
        megaphone.setOnPrimaryButtonClickListener(onClickListener);
        megaphone.setImageDrawable(null);
        megaphone.setShowCloseButton(false);
        megaphone.setShowSecondaryButton(false);
    }

    public final void mo1080f(OnClickListener onClickListener) {
        Megaphone megaphone = (Megaphone) mo1075b();
        megaphone.setVisibility(0);
        megaphone.setTitle(m22017a(2131235300, new String[0]));
        megaphone.setSubtitle(m22017a(2131235305, this.f18065b));
        megaphone.setPrimaryButtonText(m22017a(2131235309, new String[0]));
        megaphone.setOnPrimaryButtonClickListener(onClickListener);
        megaphone.setImageDrawable(null);
        megaphone.setShowCloseButton(false);
        megaphone.setShowSecondaryButton(false);
    }

    @VisibleForTesting
    protected final View mo1075b() {
        return ((LinearLayout) this.f18066c.a()).getChildAt(0);
    }
}

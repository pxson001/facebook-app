package com.facebook.tablet.sideshow.nux;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;

/* compiled from: onPageScrollStateChanged */
class PortraitSideshowNuxInterstitialController$1 implements Runnable {
    final /* synthetic */ Context f4704a;
    final /* synthetic */ PortraitSideshowNuxInterstitialController f4705b;

    PortraitSideshowNuxInterstitialController$1(PortraitSideshowNuxInterstitialController portraitSideshowNuxInterstitialController, Context context) {
        this.f4705b = portraitSideshowNuxInterstitialController;
        this.f4704a = context;
    }

    public void run() {
        PortraitSideshowNuxInterstitialController portraitSideshowNuxInterstitialController = this.f4705b;
        Context context = this.f4704a;
        View inflate = LayoutInflater.from(context).inflate(2130906345, null);
        AlertDialog a = new Builder(context, 5).a(2131241712, null).a();
        a.a(inflate, 0, 0, 0, 0);
        a.show();
    }
}

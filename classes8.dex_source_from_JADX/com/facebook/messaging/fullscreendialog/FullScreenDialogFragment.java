package com.facebook.messaging.fullscreendialog;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.facebook.common.util.ContextUtils;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;

/* compiled from: tos_terms_url */
public class FullScreenDialogFragment extends FbDialogFragment {
    public void m1686a(Bundle bundle) {
        Object obj;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -130893758);
        super.a(bundle);
        if (ContextUtils.a(getContext(), Activity.class) != null) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            a(2, 2131624640);
        } else {
            a(2, 2131624639);
        }
        LogUtils.f(1452549874, a);
    }

    public Dialog m1687c(Bundle bundle) {
        FullScreenDialogConfigurator fullScreenDialogConfigurator;
        Object obj;
        Dialog c = super.c(bundle);
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            Object obj2;
            FullScreenDialogConfigurator fullScreenDialogConfigurator2;
            if (bundle2.containsKey("arg_dialog_width") && bundle2.containsKey("arg_dialog_height")) {
                obj2 = 1;
            } else {
                obj2 = null;
            }
            if (obj2 != null) {
                fullScreenDialogConfigurator2 = new FullScreenDialogConfigurator(bundle2.getInt("arg_dialog_width"), bundle2.getInt("arg_dialog_height"), c);
            } else {
                fullScreenDialogConfigurator2 = FullScreenDialogConfigurator.m1685a(c);
            }
            fullScreenDialogConfigurator = fullScreenDialogConfigurator2;
        } else {
            fullScreenDialogConfigurator = FullScreenDialogConfigurator.m1685a(c);
        }
        FullScreenDialogConfigurator fullScreenDialogConfigurator3 = fullScreenDialogConfigurator;
        fullScreenDialogConfigurator3.f1530c.setCanceledOnTouchOutside(true);
        fullScreenDialogConfigurator3.f1530c.getWindow().setSoftInputMode(16);
        LayoutParams attributes = fullScreenDialogConfigurator3.f1530c.getWindow().getAttributes();
        attributes.windowAnimations = 2131624641;
        attributes.flags |= 16843008;
        fullScreenDialogConfigurator3.f1530c.getWindow().setAttributes(attributes);
        if (fullScreenDialogConfigurator3.f1528a == -1 || fullScreenDialogConfigurator3.f1529b == -1) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            Window window = fullScreenDialogConfigurator3.f1530c.getWindow();
            LayoutParams attributes2 = window.getAttributes();
            attributes2.width = fullScreenDialogConfigurator3.f1528a;
            attributes2.height = fullScreenDialogConfigurator3.f1529b;
            attributes2.gravity = 83;
            window.setAttributes(attributes2);
        }
        return fullScreenDialogConfigurator3.f1530c;
    }
}

package com.facebook.messaging.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.facebook.ui.dialogs.FbAlertDialogBuilder;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

/* compiled from: total_memory */
public class MenuDialogFragment extends FbDialogFragment {
    public MenuDialogParams am;
    public Listener an;

    /* compiled from: total_memory */
    class C01591 implements OnClickListener {
        final /* synthetic */ MenuDialogFragment f1509a;

        C01591(MenuDialogFragment menuDialogFragment) {
            this.f1509a = menuDialogFragment;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            if (this.f1509a.an != null) {
                if (this.f1509a.an.m1679a((MenuDialogItem) this.f1509a.am.f1522c.get(i), this.f1509a.am.f1523d)) {
                    this.f1509a.b();
                }
            }
        }
    }

    /* compiled from: total_memory */
    public interface Listener {
        boolean m1679a(MenuDialogItem menuDialogItem, Object obj);
    }

    public static MenuDialogFragment m1680a(MenuDialogParams menuDialogParams) {
        Bundle bundle = new Bundle();
        bundle.putParcelable("menu_dialog_params", menuDialogParams);
        MenuDialogFragment menuDialogFragment = new MenuDialogFragment();
        menuDialogFragment.g(bundle);
        return menuDialogFragment;
    }

    public final Dialog m1681c(Bundle bundle) {
        int i = 0;
        Bundle bundle2 = this.s;
        if (bundle2 != null) {
            this.am = (MenuDialogParams) bundle2.getParcelable("menu_dialog_params");
        }
        Preconditions.checkNotNull(this.am);
        FbAlertDialogBuilder fbAlertDialogBuilder = new FbAlertDialogBuilder(getContext());
        int i2 = this.am.f1520a;
        String str = this.am.f1521b;
        if (i2 == 0) {
            fbAlertDialogBuilder.a(str);
        } else {
            fbAlertDialogBuilder.a(i2);
        }
        CharSequence[] charSequenceArr = new CharSequence[this.am.f1522c.size()];
        ImmutableList immutableList = this.am.f1522c;
        int size = immutableList.size();
        int i3 = 0;
        while (i < size) {
            MenuDialogItem menuDialogItem = (MenuDialogItem) immutableList.get(i);
            int i4 = menuDialogItem.f1511b;
            String str2 = menuDialogItem.f1512c;
            if (i4 == 0) {
                charSequenceArr[i3] = str2;
            } else {
                charSequenceArr[i3] = b(i4);
            }
            i3++;
            i++;
        }
        fbAlertDialogBuilder.a(charSequenceArr, new C01591(this));
        return fbAlertDialogBuilder.b();
    }
}

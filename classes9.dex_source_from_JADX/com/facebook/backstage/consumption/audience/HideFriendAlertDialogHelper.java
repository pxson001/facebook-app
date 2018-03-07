package com.facebook.backstage.consumption.audience;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.facebook.backstage.consumption.BackstageFragment.C04323;
import com.facebook.backstage.consumption.BackstageFragment.C04323.C04311;
import com.facebook.fbui.dialog.AlertDialog;
import java.util.ArrayList;
import java.util.List;

/* compiled from: rtc_group_call_nux */
public class HideFriendAlertDialogHelper {
    public final C04323 f4667a;
    public AlertDialog f4668b;

    /* compiled from: rtc_group_call_nux */
    public class C04651 implements OnClickListener {
        final /* synthetic */ String f4664a;
        final /* synthetic */ HideFriendAlertDialogHelper f4665b;

        public C04651(HideFriendAlertDialogHelper hideFriendAlertDialogHelper, String str) {
            this.f4665b = hideFriendAlertDialogHelper;
            this.f4664a = str;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            C04323 c04323 = this.f4665b.f4667a;
            String str = this.f4664a;
            c04323.f4489a.ax.setRefreshing(true);
            List arrayList = new ArrayList(1);
            arrayList.add(str);
            c04323.f4489a.al.m4963a(null, arrayList, new C04311(c04323));
        }
    }

    /* compiled from: rtc_group_call_nux */
    public class C04662 implements OnClickListener {
        final /* synthetic */ HideFriendAlertDialogHelper f4666a;

        public C04662(HideFriendAlertDialogHelper hideFriendAlertDialogHelper) {
            this.f4666a = hideFriendAlertDialogHelper;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            this.f4666a.f4668b.dismiss();
        }
    }

    public HideFriendAlertDialogHelper(C04323 c04323) {
        this.f4667a = c04323;
    }
}

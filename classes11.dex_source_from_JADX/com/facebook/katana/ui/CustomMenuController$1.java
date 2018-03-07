package com.facebook.katana.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: workdev */
class CustomMenuController$1 implements OnClickListener {
    final /* synthetic */ CustomMenuController f126a;

    CustomMenuController$1(CustomMenuController customMenuController) {
        this.f126a = customMenuController;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f126a.h.a("Intentional user-triggered soft error", "message accompanying user-triggered soft errorwith embedded new\nline.");
        dialogInterface.cancel();
    }
}

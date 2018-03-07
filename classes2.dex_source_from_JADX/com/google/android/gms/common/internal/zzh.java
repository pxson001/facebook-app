package com.google.android.gms.common.internal;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public class zzh implements OnClickListener {
    private final Activity f141a;
    private final Fragment f142b;
    private final Intent f143c;
    private final int f144d;

    public zzh(Activity activity, Intent intent, int i) {
        this.f141a = activity;
        this.f142b = null;
        this.f143c = intent;
        this.f144d = i;
    }

    public zzh(Fragment fragment, Intent intent, int i) {
        this.f141a = null;
        this.f142b = fragment;
        this.f143c = intent;
        this.f144d = i;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        try {
            if (this.f143c != null && this.f142b != null) {
                this.f142b.m248a(this.f143c, this.f144d);
            } else if (this.f143c != null) {
                this.f141a.startActivityForResult(this.f143c, this.f144d);
            }
            dialogInterface.dismiss();
        } catch (ActivityNotFoundException e) {
            Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
        }
    }
}

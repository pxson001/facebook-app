package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ProgressBar;
import com.facebook.proxygen.HTTPTransportCallback;

public class GoogleApiAvailability {
    public static final int f55a = GooglePlayServicesUtil.f57a;
    public static final GoogleApiAvailability f56b = new GoogleApiAvailability();

    GoogleApiAvailability() {
    }

    public static int m148a(Context context) {
        int a = GooglePlayServicesUtil.m153a(context);
        return GooglePlayServicesUtil.m162b(context, a) ? 18 : a;
    }

    public static Dialog m149a(Activity activity, OnCancelListener onCancelListener) {
        View progressBar = new ProgressBar(activity, null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        Builder builder = new Builder(activity);
        builder.setView(progressBar);
        String e = GooglePlayServicesUtil.m167e(activity);
        builder.setMessage(activity.getResources().getString(2131233787, new Object[]{e}));
        builder.setTitle(2131233786);
        builder.setPositiveButton("", null);
        Dialog create = builder.create();
        GooglePlayServicesUtil.m155a(activity, onCancelListener, "GooglePlayServicesUpdatingDialog", create);
        return create;
    }

    public static GoogleApiAvailability m150a() {
        return f56b;
    }

    private static String m151b(Context context, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gcore_");
        stringBuilder.append(f55a);
        stringBuilder.append("-");
        if (!TextUtils.isEmpty(str)) {
            stringBuilder.append(str);
        }
        stringBuilder.append("-");
        if (context != null) {
            stringBuilder.append(context.getPackageName());
        }
        stringBuilder.append("-");
        if (context != null) {
            try {
                stringBuilder.append(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode);
            } catch (NameNotFoundException e) {
            }
        }
        return stringBuilder.toString();
    }

    public final Intent m152a(Context context, int i, String str) {
        Intent intent;
        switch (i) {
            case HTTPTransportCallback.FIRST_HEADER_BYTE_FLUSHED /*1*/:
            case HTTPTransportCallback.FIRST_BODY_BYTE_FLUSHED /*2*/:
                Object b = m151b(context, str);
                intent = new Intent("android.intent.action.VIEW");
                Uri.Builder appendQueryParameter = Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.gms");
                if (!TextUtils.isEmpty(b)) {
                    appendQueryParameter.appendQueryParameter("pcampaignid", b);
                }
                intent.setData(appendQueryParameter.build());
                intent.setPackage("com.android.vending");
                intent.addFlags(524288);
                return intent;
            case 3:
                Uri fromParts = Uri.fromParts("package", "com.google.android.gms", null);
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(fromParts);
                return intent2;
            case 42:
                intent = new Intent("com.google.android.clockwork.home.UPDATE_ANDROID_WEAR_ACTION");
                intent.setPackage("com.google.android.wearable.app");
                return intent;
            default:
                return null;
        }
    }
}

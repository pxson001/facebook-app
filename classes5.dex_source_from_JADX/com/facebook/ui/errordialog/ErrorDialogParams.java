package com.facebook.ui.errordialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import com.facebook.fbservice.service.ServiceException;

/* compiled from: commerce_checkout_style */
public class ErrorDialogParams {
    public final String f5444a;
    public final String f5445b;
    public final String f5446c;
    public final Uri f5447d;
    public final ServiceException f5448e;
    public final OnClickListener f5449f;
    public final OnCancelListener f5450g;
    public final Activity f5451h;
    public final DialogFragment f5452i;
    public final boolean f5453j;
    public final boolean f5454k;

    ErrorDialogParams(ErrorDialogParamsBuilder errorDialogParamsBuilder) {
        this.f5444a = errorDialogParamsBuilder.f5456b;
        this.f5445b = errorDialogParamsBuilder.f5457c;
        this.f5446c = errorDialogParamsBuilder.f5458d;
        this.f5447d = errorDialogParamsBuilder.f5459e;
        this.f5448e = errorDialogParamsBuilder.f5460f;
        this.f5449f = errorDialogParamsBuilder.f5461g;
        this.f5450g = errorDialogParamsBuilder.f5462h;
        this.f5451h = errorDialogParamsBuilder.f5463i;
        this.f5452i = errorDialogParamsBuilder.f5464j;
        this.f5453j = errorDialogParamsBuilder.f5465k;
        this.f5454k = errorDialogParamsBuilder.f5466l;
    }

    public static ErrorDialogParamsBuilder m10337a(Resources resources) {
        return new ErrorDialogParamsBuilder(resources);
    }

    public static ErrorDialogParamsBuilder m10336a(Context context) {
        return new ErrorDialogParamsBuilder(context.getResources());
    }
}

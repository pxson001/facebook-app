package com.facebook.ui.errordialog;

import android.app.Activity;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v4.app.DialogFragment;
import com.facebook.fbservice.service.ServiceException;

/* compiled from: commerce_checkout_conf */
public class ErrorDialogParamsBuilder {
    private final Resources f5455a;
    public String f5456b;
    public String f5457c;
    public String f5458d;
    public Uri f5459e;
    public ServiceException f5460f;
    public OnClickListener f5461g;
    public OnCancelListener f5462h;
    public Activity f5463i;
    public DialogFragment f5464j;
    public boolean f5465k;
    public boolean f5466l;

    ErrorDialogParamsBuilder(Resources resources) {
        this.f5455a = resources;
    }

    public final ErrorDialogParamsBuilder m10338a(int i) {
        this.f5456b = this.f5455a.getString(i);
        return this;
    }

    public final ErrorDialogParamsBuilder m10339b(int i) {
        this.f5457c = this.f5455a.getString(i);
        return this;
    }

    public final ErrorDialogParamsBuilder m10340c(int i) {
        this.f5458d = this.f5455a.getString(i);
        return this;
    }

    public final ErrorDialogParams m10341l() {
        return new ErrorDialogParams(this);
    }
}

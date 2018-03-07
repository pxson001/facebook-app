package com.facebook.location.gmsupsell;

import android.content.Context;
import android.content.Intent;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.inject.InjectorLike;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.GoogleLocationDialogResult;
import com.facebook.location.gmsupsell.GooglePlayServicesLocationUpsellDialogController.OnGooglePlayServicesLocationUpsellDialogFinishedListener;
import javax.inject.Inject;

/* compiled from: {app} */
public class SimpleLocationUpsellDialogFinishedListener implements OnGooglePlayServicesLocationUpsellDialogFinishedListener {
    public final SecureContextHelper f107a;
    public final Context f108b;

    public static SimpleLocationUpsellDialogFinishedListener m79b(InjectorLike injectorLike) {
        return new SimpleLocationUpsellDialogFinishedListener((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (Context) injectorLike.getInstance(Context.class));
    }

    @Inject
    public SimpleLocationUpsellDialogFinishedListener(SecureContextHelper secureContextHelper, Context context) {
        this.f107a = secureContextHelper;
        this.f108b = context;
    }

    public final void mo1a(GoogleLocationDialogResult googleLocationDialogResult) {
        switch (googleLocationDialogResult) {
            case DIALOG_SUCCESS:
            case DIALOG_CANCEL:
            case DIALOG_NOT_NEEDED:
                return;
            case DIALOG_NOT_POSSIBLE:
            case UNKNOWN_FAILURE:
                this.f107a.b(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"), this.f108b);
                return;
            default:
                throw new IllegalArgumentException("Illegal location upsell dialog result.");
        }
    }

    public static SimpleLocationUpsellDialogFinishedListener m78a(InjectorLike injectorLike) {
        return m79b(injectorLike);
    }
}

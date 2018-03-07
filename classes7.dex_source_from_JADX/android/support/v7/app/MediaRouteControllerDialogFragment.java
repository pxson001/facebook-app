package android.support.v7.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

/* compiled from: custom_cta_mobile_contact_us_tapped_all_requests */
public class MediaRouteControllerDialogFragment extends DialogFragment {
    public MediaRouteControllerDialogFragment() {
        d_(true);
    }

    public MediaRouteControllerDialog m20285a(Context context, Bundle bundle) {
        return new MediaRouteControllerDialog(context);
    }

    public final Dialog m20286c(Bundle bundle) {
        return m20285a(o(), bundle);
    }
}

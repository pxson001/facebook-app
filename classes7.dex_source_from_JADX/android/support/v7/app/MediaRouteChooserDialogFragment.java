package android.support.v7.app;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.media.MediaRouteSelector;

/* compiled from: custom_cta_mobile_contact_us_tapped_email */
public class MediaRouteChooserDialogFragment extends DialogFragment {
    private final String al = "selector";
    private MediaRouteSelector am;

    public MediaRouteChooserDialogFragment() {
        d_(true);
    }

    private MediaRouteSelector an() {
        ao();
        return this.am;
    }

    private void ao() {
        if (this.am == null) {
            Bundle bundle = this.s;
            if (bundle != null) {
                this.am = MediaRouteSelector.m20342a(bundle.getBundle("selector"));
            }
            if (this.am == null) {
                this.am = MediaRouteSelector.f16268a;
            }
        }
    }

    public final void m20276a(MediaRouteSelector mediaRouteSelector) {
        if (mediaRouteSelector == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        ao();
        if (!this.am.equals(mediaRouteSelector)) {
            this.am = mediaRouteSelector;
            Bundle bundle = this.s;
            if (bundle == null) {
                bundle = new Bundle();
            }
            bundle.putBundle("selector", mediaRouteSelector.f16269b);
            g(bundle);
            MediaRouteChooserDialog mediaRouteChooserDialog = (MediaRouteChooserDialog) this.f;
            if (mediaRouteChooserDialog != null) {
                mediaRouteChooserDialog.m20275a(mediaRouteSelector);
            }
        }
    }

    public final Dialog m20277c(Bundle bundle) {
        Dialog mediaRouteChooserDialog = new MediaRouteChooserDialog(o());
        mediaRouteChooserDialog.m20275a(an());
        return mediaRouteChooserDialog;
    }
}

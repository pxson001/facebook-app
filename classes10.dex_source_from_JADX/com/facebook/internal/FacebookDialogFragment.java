package com.facebook.internal;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.internal.WebDialog.Builder;
import com.facebook.internal.WebDialog.OnCompleteListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: SEND_SKIPPED_HAS_LOCATION_SHARE */
public class FacebookDialogFragment extends DialogFragment {
    public Dialog al;

    /* compiled from: SEND_SKIPPED_HAS_LOCATION_SHARE */
    class C34431 implements OnCompleteListener {
        final /* synthetic */ FacebookDialogFragment f23978a;

        C34431(FacebookDialogFragment facebookDialogFragment) {
            this.f23978a = facebookDialogFragment;
        }

        public final void mo1038a(Bundle bundle, FacebookException facebookException) {
            FacebookDialogFragment.m25256a(this.f23978a, bundle, facebookException);
        }
    }

    /* compiled from: SEND_SKIPPED_HAS_LOCATION_SHARE */
    class C34442 implements OnCompleteListener {
        final /* synthetic */ FacebookDialogFragment f23979a;

        C34442(FacebookDialogFragment facebookDialogFragment) {
            this.f23979a = facebookDialogFragment;
        }

        public final void mo1038a(Bundle bundle, FacebookException facebookException) {
            FacebookDialogFragment.m25257n(this.f23979a, bundle);
        }
    }

    public final void m25258a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 862053173);
        super.a(bundle);
        if (this.al == null) {
            Dialog facebookWebFallbackDialog;
            FragmentActivity o = o();
            Bundle a2 = NativeProtocol.m25296a(o.getIntent());
            String string;
            if (a2.getBoolean("is_fallback", false)) {
                string = a2.getString("url");
                if (Utility.m25345a(string)) {
                    Utility.m25339a("FacebookDialogFragment", "Cannot start a fallback WebDialog with an empty/missing 'url'");
                    o.finish();
                    LogUtils.f(-205204690, a);
                    return;
                }
                facebookWebFallbackDialog = new FacebookWebFallbackDialog(o, string, String.format("fb%s://bridge/", new Object[]{FacebookSdk.m14053i()}));
                facebookWebFallbackDialog.f23991c = new C34442(this);
            } else {
                string = a2.getString("action");
                a2 = a2.getBundle("params");
                if (Utility.m25345a(string)) {
                    Utility.m25339a("FacebookDialogFragment", "Cannot start a WebDialog with an empty/missing 'actionName'");
                    o.finish();
                    Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1653268638, a);
                    return;
                }
                Builder builder = new Builder(o, string, a2);
                builder.f24066e = new C34431(this);
                facebookWebFallbackDialog = builder.m25373a();
            }
            this.al = facebookWebFallbackDialog;
        }
        LogUtils.f(-376977009, a);
    }

    @NonNull
    public final Dialog m25259c(Bundle bundle) {
        if (this.al == null) {
            m25256a(this, null, null);
            this.d = false;
        }
        return this.al;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.al instanceof WebDialog) {
            ((WebDialog) this.al).m25270d();
        }
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2083391980);
        if (this.f != null && this.M) {
            this.f.setDismissMessage(null);
        }
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -634950780, a);
    }

    public static void m25256a(FacebookDialogFragment facebookDialogFragment, Bundle bundle, FacebookException facebookException) {
        FragmentActivity o = facebookDialogFragment.o();
        o.setResult(facebookException == null ? -1 : 0, NativeProtocol.m25295a(o.getIntent(), bundle, facebookException));
        o.finish();
    }

    public static void m25257n(FacebookDialogFragment facebookDialogFragment, Bundle bundle) {
        FragmentActivity o = facebookDialogFragment.o();
        Intent intent = new Intent();
        if (bundle == null) {
            bundle = new Bundle();
        }
        intent.putExtras(bundle);
        o.setResult(-1, intent);
        o.finish();
    }
}

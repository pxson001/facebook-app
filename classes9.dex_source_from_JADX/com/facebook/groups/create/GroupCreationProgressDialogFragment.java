package com.facebook.groups.create;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import com.facebook.fbui.dialog.ProgressDialog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: peer_name */
public class GroupCreationProgressDialogFragment extends DialogFragment {
    private boolean al;

    /* compiled from: peer_name */
    public /* synthetic */ class C06941 {
        public static final /* synthetic */ int[] f6768a = new int[GroupCreationProgress.values().length];

        static {
            try {
                f6768a[GroupCreationProgress.INITIAL.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6768a[GroupCreationProgress.INVITE_MEMBERS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6768a[GroupCreationProgress.UPLOADING_COVER_PHOTO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6768a[GroupCreationProgress.SETTING_AS_COVER.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6768a[GroupCreationProgress.COVER_PHOTO_UPDATED_SUCCESSFULLY.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: peer_name */
    public enum GroupCreationProgress {
        INITIAL,
        INVITE_MEMBERS,
        UPLOADING_COVER_PHOTO,
        SETTING_AS_COVER,
        COVER_PHOTO_UPDATED_SUCCESSFULLY
    }

    public final void m7088H() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1596134366);
        if (this.al) {
            b();
        }
        super.H();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1871438850, a);
    }

    public final Dialog m7089c(Bundle bundle) {
        Bundle bundle2 = this.s;
        int i = bundle2.getInt("message_res_id");
        boolean z = bundle2.getBoolean("is_indeterminate");
        boolean z2 = bundle2.getBoolean("is_cancelable");
        this.al = bundle2.getBoolean("dismiss_on_pause");
        ProgressDialog progressDialog = new ProgressDialog(getContext());
        progressDialog.d = 0;
        progressDialog.a(z);
        progressDialog.setCancelable(z2);
        d_(z2);
        if (i > 0) {
            progressDialog.a(a(i));
        }
        return progressDialog;
    }
}

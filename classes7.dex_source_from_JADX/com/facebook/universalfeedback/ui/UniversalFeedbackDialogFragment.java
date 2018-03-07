package com.facebook.universalfeedback.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.debug.log.BLog;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.ui.dialogs.FbDialogFragment;

/* compiled from: edit_gallery_photo_uri */
public class UniversalFeedbackDialogFragment extends FbDialogFragment {
    public UniversalFeedbackUIController am;

    public final View m19389a(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1211235387);
        View inflate = layoutInflater.inflate(2130907591, viewGroup);
        if (this.am != null) {
            this.am.m19431a(inflate, inflate.getContext());
            this.f.getWindow().setSoftInputMode(16);
        } else {
            BLog.b(UniversalFeedbackDialogFragment.class, "Required UniversalFeedbackUIController not set");
        }
        LogUtils.f(1514616479, a);
        return inflate;
    }
}

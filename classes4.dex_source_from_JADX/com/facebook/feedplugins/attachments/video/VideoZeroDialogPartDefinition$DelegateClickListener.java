package com.facebook.feedplugins.attachments.video;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.fragment.FragmentManagerHost;
import com.facebook.common.util.ContextUtils;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.zero.sdk.common.ZeroFeatureKey;

/* compiled from: personal_account_password_with_work_username */
class VideoZeroDialogPartDefinition$DelegateClickListener implements OnClickListener {
    private final VideoZeroDialogPartDefinition$State f5074a;

    public VideoZeroDialogPartDefinition$DelegateClickListener(VideoZeroDialogPartDefinition$State videoZeroDialogPartDefinition$State) {
        this.f5074a = videoZeroDialogPartDefinition$State;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 260696773);
        FragmentManagerHost fragmentManagerHost = (FragmentManagerHost) ContextUtils.a(view.getContext(), FragmentManagerHost.class);
        if (fragmentManagerHost != null) {
            this.f5074a.f5059b.a(ZeroFeatureKey.VIDEO_PLAY_INTERSTITIAL, fragmentManagerHost.kO_());
        } else {
            this.f5074a.f5058a.mo443a(null);
        }
        LogUtils.a(2004585579, a);
    }
}

package com.facebook.orca.threadview;

import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.presence.ThreadPresenceManager;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.helpers.RtcCallHandler;

/* compiled from: media upload failed */
public class ThreadViewTooltipProvider extends AbstractAssistedProvider<ThreadViewTooltip> {
    public final ThreadViewTooltip m7945a(FbFragment fbFragment) {
        ThreadViewTooltip threadViewTooltip = new ThreadViewTooltip(RtcCallHandler.a(this), ThreadPresenceManager.a(this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), ResourcesMethodAutoProvider.a(this), (BaseFbBroadcastManager) LocalFbBroadcastManager.a(this), ScheduledExecutorService_DefaultExecutorServiceMethodAutoProvider.a(this), fbFragment);
        threadViewTooltip.f8036a = (QeAccessor) QeInternalImplMethodAutoProvider.a(this);
        return threadViewTooltip;
    }
}

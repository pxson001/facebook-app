package com.facebook.rtc.audio;

import android.content.Context;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.rtc.fbwebrtc.WebrtcUiHandler.C22981;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: audio_dropout */
public class RtcAudioHandlerProvider extends AbstractAssistedProvider<RtcAudioHandler> {
    public final RtcAudioHandler m19287a(C22981 c22981) {
        return new RtcAudioHandler((Context) getInstance(Context.class), (ScheduledExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(this), (FbSharedPreferences) FbSharedPreferencesImpl.a(this), DefaultAndroidThreadUtil.b(this), ResourcesMethodAutoProvider.a(this), (RtcAudioFocusHandlerProvider) getOnDemandAssistedProviderForStaticDi(RtcAudioFocusHandlerProvider.class), c22981, (QeAccessor) QeInternalImplMethodAutoProvider.a(this));
    }
}

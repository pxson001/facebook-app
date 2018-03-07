package com.facebook.rtc.voicemail;

import com.facebook.xconfig.core.XConfigName;
import com.facebook.xconfig.core.XConfigSyncListener;
import javax.inject.Inject;

/* compiled from: sms_takeover_inbox_filter_action */
public class RtcVoicemailConfigSyncListener implements XConfigSyncListener {
    VoicemailHandler f2023a;

    @Inject
    public RtcVoicemailConfigSyncListener(VoicemailHandler voicemailHandler) {
        this.f2023a = voicemailHandler;
    }

    public final void mo138a(XConfigName xConfigName) {
        this.f2023a.m9520b();
    }

    public final XConfigName mo137a() {
        return RtcVoicemailConfig.f1880c;
    }
}

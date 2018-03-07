package com.facebook.videocodec.prober;

import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: android.telephony.extra.MMS_HTTP_STATUS */
public class VideoProbeResult {
    public final Optional<String> f20421a;

    public VideoProbeResult(String str) {
        this.f20421a = Optional.of(str);
    }

    public VideoProbeResult() {
        this.f20421a = Absent.INSTANCE;
    }
}

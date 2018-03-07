package com.facebook.sideloading;

import com.facebook.abtest.qe.bootstrap.data.QuickExperimentParameters;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: has_clicked_on_cover_photo_upload */
public class GeneratedSideloadMessengerViaDiodeQuickExperiment$Config {
    private final QuickExperimentParameters f10027a;

    public GeneratedSideloadMessengerViaDiodeQuickExperiment$Config(QuickExperimentParameters quickExperimentParameters) {
        this.f10027a = quickExperimentParameters;
    }

    public final boolean m10112a(boolean z) {
        return this.f10027a.a("able_to_sideload_messenger", z);
    }
}

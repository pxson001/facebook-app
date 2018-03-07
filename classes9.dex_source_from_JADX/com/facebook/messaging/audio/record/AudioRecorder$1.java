package com.facebook.messaging.audio.record;

import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.logger.HoneyClientEvent;

/* compiled from: optional_payment_enabled */
class AudioRecorder$1 implements Runnable {
    final /* synthetic */ Exception f8095a;
    final /* synthetic */ AudioRecorder f8096b;

    AudioRecorder$1(AudioRecorder audioRecorder, Exception exception) {
        this.f8096b = audioRecorder;
        this.f8095a = exception;
    }

    public void run() {
        AnalyticsLogger analyticsLogger = this.f8096b.e;
        HoneyClientEvent b = new HoneyClientEvent("audio_clips_recording_failed").b("error_message", this.f8095a.getStackTrace().toString());
        b.c = "audio_clips";
        analyticsLogger.c(b);
        this.f8096b.k = false;
    }
}

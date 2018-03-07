package com.facebook.photos.upload.uploaders;

import com.facebook.photos.upload.operation.TranscodeInfo;
import com.facebook.videocodec.policy.VideoResizeConfig;
import com.google.common.base.Preconditions;

/* compiled from: friends_locations_feedstory_scroll_left */
public class TranscodeSettings {
    int f14437a = VideoResizeConfig.f5563e.f5565b;
    public int f14438b = VideoResizeConfig.f5563e.f5564a;
    public boolean f14439c = false;

    TranscodeSettings() {
    }

    public final boolean m22068b() {
        if (m22069c()) {
            if ((this.f14438b == VideoResizeConfig.f5563e.f5564a ? 1 : null) != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean m22069c() {
        return this.f14437a == VideoResizeConfig.f5563e.f5565b;
    }

    static TranscodeSettings m22067a(boolean z, int i, TranscodeInfo transcodeInfo) {
        boolean z2 = true;
        TranscodeSettings transcodeSettings = new TranscodeSettings();
        Object obj = 1;
        Object obj2 = null;
        if (!z && transcodeInfo.isServerSettingsAvailable && transcodeInfo.serverSpecifiedTranscodeBitrate == ((long) TranscodeInfo.f13689a)) {
            obj2 = 1;
        }
        if (i != -2) {
            obj = obj2;
        }
        if (obj != null) {
            transcodeSettings.f14439c = true;
            return transcodeSettings;
        }
        if (!z && transcodeInfo.isServerSettingsAvailable) {
            if (transcodeInfo.serverSpecifiedTranscodeBitrate == ((long) TranscodeInfo.f13689a)) {
                z2 = false;
            }
            Preconditions.checkState(z2);
            transcodeSettings.f14437a = (int) transcodeInfo.serverSpecifiedTranscodeBitrate;
            transcodeSettings.f14438b = (int) transcodeInfo.serverSpecifiedTranscodeDimension;
        }
        if (i != -1) {
            int i2 = i * 1000;
            if (i2 > transcodeSettings.f14437a) {
                transcodeSettings.f14437a = i2;
            }
        }
        return transcodeSettings;
    }
}

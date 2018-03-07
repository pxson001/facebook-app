package com.facebook.livephotos.exoplayer.audio;

import android.annotation.TargetApi;
import java.util.Arrays;

@TargetApi(21)
/* compiled from: page_unsave_error */
public final class AudioCapabilities {
    public static final AudioCapabilities f6895a = new AudioCapabilities(new int[]{2}, 2);
    public final int[] f6896b;
    private final int f6897c;

    private AudioCapabilities(int[] iArr, int i) {
        if (iArr != null) {
            this.f6896b = Arrays.copyOf(iArr, iArr.length);
            Arrays.sort(this.f6896b);
        } else {
            this.f6896b = new int[0];
        }
        this.f6897c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AudioCapabilities)) {
            return false;
        }
        AudioCapabilities audioCapabilities = (AudioCapabilities) obj;
        if (Arrays.equals(this.f6896b, audioCapabilities.f6896b) && this.f6897c == audioCapabilities.f6897c) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f6897c + (Arrays.hashCode(this.f6896b) * 31);
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=" + this.f6897c + ", supportedEncodings=" + Arrays.toString(this.f6896b) + "]";
    }
}

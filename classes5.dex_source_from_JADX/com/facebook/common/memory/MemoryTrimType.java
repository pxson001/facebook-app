package com.facebook.common.memory;

/* compiled from: show_video_channel_subscribe_button */
public enum MemoryTrimType {
    OnCloseToDalvikHeapLimit(0.5d),
    OnSystemLowMemoryWhileAppInForeground(0.5d),
    OnSystemLowMemoryWhileAppInBackground(1.0d),
    OnAppBackgrounded(1.0d);
    
    private double mSuggestedTrimRatio;

    private MemoryTrimType(double d) {
        this.mSuggestedTrimRatio = d;
    }

    public final double getSuggestedTrimRatio() {
        return this.mSuggestedTrimRatio;
    }
}

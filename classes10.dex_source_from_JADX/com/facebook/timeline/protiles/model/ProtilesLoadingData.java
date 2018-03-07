package com.facebook.timeline.protiles.model;

/* compiled from: feed_filter_buttons */
public class ProtilesLoadingData {
    public ProtilesLoadState f12119a = ProtilesLoadState.IDLE;

    /* compiled from: feed_filter_buttons */
    public enum ProtilesLoadState {
        IDLE,
        LOADING,
        FAILED,
        COMPLETED
    }

    public final boolean m12123a() {
        return this.f12119a == ProtilesLoadState.LOADING;
    }

    public final boolean m12124b() {
        return this.f12119a == ProtilesLoadState.FAILED;
    }
}

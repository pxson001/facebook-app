package com.facebook.richdocument.view.transition;

/* compiled from: oxygen_map_place_reporter_dialog_clicked */
public enum MapState {
    VISIBLE,
    HIDDEN;

    public final int getVisibility() {
        return this == VISIBLE ? 1 : 0;
    }

    public final MapState inverse() {
        return this == VISIBLE ? HIDDEN : VISIBLE;
    }
}

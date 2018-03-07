package com.facebook.messaging.photos.editing;

/* compiled from: dialtone_switcher_enter_full_fb_dialog_confirm */
public class TextLayer extends Layer {
    public CharSequence f16272a;
    public int f16273b = -1;
    public int f16274c = 0;

    /* compiled from: dialtone_switcher_enter_full_fb_dialog_confirm */
    public enum Event {
        TEXT_CHANGE,
        TEXT_COLOR_CHANGE,
        BACKGROUND_COLOR_CHANGE
    }

    public final boolean mo676a() {
        return this.f16272a == null || this.f16272a.toString().trim().isEmpty();
    }
}

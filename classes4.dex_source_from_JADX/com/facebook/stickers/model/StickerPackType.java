package com.facebook.stickers.model;

/* compiled from: reactive_browsers_with_sig */
public enum StickerPackType {
    DOWNLOADED_PACKS("tray_packs"),
    OWNED_PACKS("owned_packs"),
    STORE_PACKS("available_packs"),
    AUTODOWNLOADED_PACKS("available_packs");
    
    private String mFieldName;

    private StickerPackType(String str) {
        this.mFieldName = str;
    }

    public final String getFieldName() {
        return this.mFieldName;
    }
}

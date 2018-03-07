package com.facebook.stickers.model;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

/* compiled from: reached end of stream after skipping  */
public enum StickerAssetType {
    STATIC("static"),
    ANIMATED("animated"),
    PREVIEW("preview");
    
    private static final ImmutableMap<String, StickerAssetType> DB_VALUE_TO_INSTANCE = null;
    private final String mValue;

    static {
        DB_VALUE_TO_INSTANCE = ImmutableMap.of(STATIC.getDbName(), STATIC, ANIMATED.getDbName(), ANIMATED, PREVIEW.getDbName(), PREVIEW);
    }

    private StickerAssetType(String str) {
        this.mValue = str;
    }

    public final String getDbName() {
        return this.mValue;
    }

    public static StickerAssetType fromDbString(String str) {
        return (StickerAssetType) Preconditions.checkNotNull(DB_VALUE_TO_INSTANCE.get(str));
    }

    public static boolean isDbString(String str) {
        return DB_VALUE_TO_INSTANCE.get(str) != null;
    }
}

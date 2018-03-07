package com.facebook.stickers.model;

import com.google.common.base.Preconditions;

/* compiled from: sendStreamInterruptedIntervalInSeconds */
public class StickerTagBuilder {
    public String f5005a = null;
    public String f5006b = null;
    public String f5007c = "";
    public boolean f5008d = false;
    public int f5009e = 0;
    public String f5010f = "";

    StickerTagBuilder() {
    }

    public static StickerTagBuilder newBuilder() {
        return new StickerTagBuilder();
    }

    public final StickerTagBuilder m7765a(String str) {
        this.f5006b = str;
        return this;
    }

    public final StickerTagBuilder m7767b(String str) {
        this.f5005a = str;
        return this;
    }

    public final StickerTagBuilder m7768c(String str) {
        this.f5007c = str;
        return this;
    }

    public final StickerTagBuilder m7766a(boolean z) {
        this.f5008d = z;
        return this;
    }

    public final StickerTagBuilder m7764a(int i) {
        this.f5009e = i;
        return this;
    }

    public final StickerTagBuilder m7769d(String str) {
        this.f5010f = str;
        return this;
    }

    public final StickerTag m7763a() {
        return new StickerTag((String) Preconditions.checkNotNull(this.f5005a), (String) Preconditions.checkNotNull(this.f5006b), this.f5007c, this.f5008d, this.f5009e, this.f5010f);
    }
}

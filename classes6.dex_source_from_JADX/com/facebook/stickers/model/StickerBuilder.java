package com.facebook.stickers.model;

import android.net.Uri;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/* compiled from: senderFbid */
public class StickerBuilder {
    public String f4946a;
    public String f4947b;
    public Uri f4948c;
    public Uri f4949d;
    public Uri f4950e;
    public Uri f4951f;
    public Uri f4952g;
    public Uri f4953h;
    private boolean f4954i = true;

    public static StickerBuilder newBuilder() {
        return new StickerBuilder();
    }

    public final StickerBuilder m7715a(Sticker sticker) {
        this.f4946a = sticker.f4938a;
        this.f4947b = sticker.f4939b;
        this.f4948c = sticker.f4940c;
        this.f4949d = sticker.f4941d;
        this.f4950e = sticker.f4942e;
        this.f4951f = sticker.f4943f;
        this.f4952g = sticker.f4944g;
        this.f4953h = sticker.f4945h;
        return this;
    }

    public final StickerBuilder m7716a(String str) {
        this.f4946a = str;
        return this;
    }

    public final StickerBuilder m7718b(String str) {
        this.f4947b = str;
        return this;
    }

    public final StickerBuilder m7714a(Uri uri) {
        this.f4948c = uri;
        return this;
    }

    public final StickerBuilder m7717b(Uri uri) {
        this.f4949d = uri;
        return this;
    }

    public final StickerBuilder m7720c(@Nullable Uri uri) {
        this.f4950e = uri;
        return this;
    }

    public final StickerBuilder m7721d(Uri uri) {
        this.f4951f = uri;
        return this;
    }

    public final StickerBuilder m7722e(@Nullable Uri uri) {
        this.f4952g = uri;
        return this;
    }

    public final StickerBuilder m7723f(Uri uri) {
        this.f4953h = uri;
        return this;
    }

    public final Sticker m7713a() {
        Preconditions.checkState(this.f4954i);
        this.f4954i = false;
        return new Sticker((String) Preconditions.checkNotNull(this.f4946a), this.f4947b, (Uri) Preconditions.checkNotNull(this.f4948c), this.f4949d, this.f4950e, this.f4951f, this.f4952g, this.f4953h);
    }

    public final void m7719b() {
        this.f4946a = null;
        this.f4947b = null;
        this.f4948c = null;
        this.f4949d = null;
        this.f4950e = null;
        this.f4951f = null;
        this.f4952g = null;
        this.f4953h = null;
        this.f4954i = true;
    }
}

package com.facebook.stickers.model;

import android.net.Uri;
import java.util.List;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: send_stream_interrupted_interval */
public class StickerPackBuilder {
    public String f4977a;
    public String f4978b;
    public String f4979c;
    public String f4980d;
    public Uri f4981e;
    public Uri f4982f;
    public Uri f4983g;
    public Uri f4984h;
    public int f4985i;
    public long f4986j;
    public boolean f4987k;
    public boolean f4988l;
    public boolean f4989m;
    public boolean f4990n;
    public boolean f4991o;
    public boolean f4992p;
    public boolean f4993q;
    public boolean f4994r;
    public List<String> f4995s;
    public List<String> f4996t;
    public boolean f4997u;
    public boolean f4998v;

    public final StickerPackBuilder m7737a(String str) {
        this.f4977a = str;
        return this;
    }

    public final StickerPackBuilder m7741b(String str) {
        this.f4978b = str;
        return this;
    }

    public final StickerPackBuilder m7745c(String str) {
        this.f4979c = str;
        return this;
    }

    public final StickerPackBuilder m7748d(String str) {
        this.f4980d = str;
        return this;
    }

    public final StickerPackBuilder m7736a(Uri uri) {
        this.f4981e = uri;
        return this;
    }

    public final StickerPackBuilder m7740b(Uri uri) {
        this.f4982f = uri;
        return this;
    }

    public final StickerPackBuilder m7744c(Uri uri) {
        this.f4983g = uri;
        return this;
    }

    public final StickerPackBuilder m7747d(Uri uri) {
        this.f4984h = uri;
        return this;
    }

    public final StickerPackBuilder m7734a(int i) {
        this.f4985i = i;
        return this;
    }

    public final StickerPackBuilder m7735a(long j) {
        this.f4986j = j;
        return this;
    }

    public final StickerPackBuilder m7739a(boolean z) {
        this.f4987k = z;
        return this;
    }

    public final StickerPackBuilder m7743b(boolean z) {
        this.f4988l = z;
        return this;
    }

    public final StickerPackBuilder m7746c(boolean z) {
        this.f4989m = z;
        return this;
    }

    public final StickerPackBuilder m7749d(boolean z) {
        this.f4990n = z;
        return this;
    }

    public final StickerPackBuilder m7750e(boolean z) {
        this.f4991o = z;
        return this;
    }

    public final StickerPackBuilder m7751f(boolean z) {
        this.f4992p = z;
        return this;
    }

    public final StickerPackBuilder m7752g(boolean z) {
        this.f4993q = z;
        return this;
    }

    public final StickerPackBuilder m7753h(boolean z) {
        this.f4994r = z;
        return this;
    }

    public final StickerPackBuilder m7738a(List<String> list) {
        this.f4995s = list;
        return this;
    }

    public final StickerPackBuilder m7742b(List<String> list) {
        this.f4996t = list;
        return this;
    }

    public final StickerPackBuilder m7754i(boolean z) {
        this.f4997u = z;
        return this;
    }

    public final StickerPackBuilder m7755j(boolean z) {
        this.f4998v = z;
        return this;
    }

    public final StickerPack m7756w() {
        return new StickerPack(this);
    }
}

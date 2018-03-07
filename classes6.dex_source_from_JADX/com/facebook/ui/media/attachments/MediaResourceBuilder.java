package com.facebook.ui.media.attachments;

import android.graphics.RectF;
import android.net.Uri;
import com.facebook.common.util.ExifOrientation;
import com.facebook.messaging.model.attribution.ContentAppAttribution;
import com.facebook.messaging.model.threadkey.ThreadKey;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Map;
import javax.annotation.concurrent.NotThreadSafe;

@NotThreadSafe
/* compiled from: search_key */
public class MediaResourceBuilder {
    public boolean f5199A;
    public String f5200B;
    public Uri f5201a;
    public Type f5202b;
    public Source f5203c = Source.UNSPECIFIED;
    public Uri f5204d;
    public MediaResource f5205e;
    public long f5206f;
    public long f5207g;
    public int f5208h;
    public int f5209i;
    public ExifOrientation f5210j = ExifOrientation.UNDEFINED;
    public String f5211k;
    public ThreadKey f5212l;
    public String f5213m;
    public long f5214n;
    public RectF f5215o = MediaResource.f5161b;
    public boolean f5216p;
    public int f5217q = -1;
    public int f5218r = -2;
    public String f5219s;
    public boolean f5220t;
    public Map<String, String> f5221u = Maps.c();
    public ContentAppAttribution f5222v;
    public Uri f5223w;
    public boolean f5224x;
    public long f5225y = -1;
    public boolean f5226z;

    public final MediaResourceBuilder m7910a(MediaResource mediaResource) {
        this.f5206f = mediaResource.f5170g;
        this.f5202b = mediaResource.f5167d;
        this.f5201a = mediaResource.f5166c;
        this.f5205e = mediaResource.f5171h;
        this.f5207g = mediaResource.f5172i;
        this.f5208h = mediaResource.f5173j;
        this.f5209i = mediaResource.f5174k;
        this.f5203c = mediaResource.f5168e;
        this.f5210j = mediaResource.f5175l;
        this.f5211k = mediaResource.f5176m;
        this.f5212l = mediaResource.f5177n;
        this.f5213m = mediaResource.f5178o;
        this.f5214n = mediaResource.f5179p;
        this.f5204d = mediaResource.f5169f;
        this.f5215o = mediaResource.f5180q;
        this.f5216p = mediaResource.f5181r;
        this.f5217q = mediaResource.f5182s;
        this.f5218r = mediaResource.f5183t;
        this.f5219s = mediaResource.f5184u;
        this.f5220t = mediaResource.f5185v;
        ImmutableMap immutableMap = mediaResource.f5186w;
        this.f5221u.clear();
        this.f5221u.putAll(immutableMap);
        this.f5222v = mediaResource.f5187x;
        this.f5223w = mediaResource.f5188y;
        this.f5224x = mediaResource.f5189z;
        this.f5225y = mediaResource.f5162A;
        this.f5226z = mediaResource.f5163B;
        this.f5199A = mediaResource.f5164C;
        this.f5200B = mediaResource.f5165D;
        return this;
    }

    public final MediaResourceBuilder m7906a(Uri uri) {
        this.f5201a = uri;
        return this;
    }

    public final Uri m7903a() {
        return this.f5201a;
    }

    public final MediaResourceBuilder m7909a(Type type) {
        this.f5202b = type;
        return this;
    }

    public final MediaResourceBuilder m7908a(Source source) {
        this.f5203c = source;
        return this;
    }

    public final Source m7919c() {
        return this.f5203c;
    }

    public final MediaResourceBuilder m7915b(Uri uri) {
        this.f5204d = uri;
        return this;
    }

    public final Uri m7922d() {
        return this.f5204d;
    }

    public final boolean m7925e() {
        return this.f5216p;
    }

    public final MediaResourceBuilder m7916b(MediaResource mediaResource) {
        this.f5205e = mediaResource;
        return this;
    }

    public final MediaResourceBuilder m7914b(long j) {
        this.f5207g = j;
        return this;
    }

    public final MediaResourceBuilder m7904a(int i) {
        this.f5208h = i;
        return this;
    }

    public final int m7926i() {
        return this.f5208h;
    }

    public final MediaResourceBuilder m7913b(int i) {
        this.f5209i = i;
        return this;
    }

    public final int m7927j() {
        return this.f5209i;
    }

    public final MediaResourceBuilder m7907a(ExifOrientation exifOrientation) {
        this.f5210j = exifOrientation;
        return this;
    }

    public final ExifOrientation m7928k() {
        return this.f5210j;
    }

    public final MediaResourceBuilder m7911a(String str) {
        this.f5211k = str;
        return this;
    }

    public final MediaResourceBuilder m7917b(String str) {
        this.f5213m = str;
        return this;
    }

    public final MediaResourceBuilder m7921c(long j) {
        this.f5214n = j;
        return this;
    }

    public final RectF m7929p() {
        return this.f5215o;
    }

    public final MediaResourceBuilder m7905a(RectF rectF) {
        this.f5215o = rectF;
        return this;
    }

    public final int m7930q() {
        return this.f5217q;
    }

    public final MediaResourceBuilder m7920c(int i) {
        this.f5217q = i;
        return this;
    }

    public final MediaResourceBuilder m7923d(int i) {
        this.f5218r = i;
        return this;
    }

    public final MediaResourceBuilder m7918b(boolean z) {
        this.f5220t = z;
        return this;
    }

    public final MediaResourceBuilder m7912a(String str, String str2) {
        this.f5221u.put(str, str2);
        return this;
    }

    public final MediaResourceBuilder m7924d(String str) {
        this.f5200B = str;
        return this;
    }

    public final MediaResource m7902C() {
        return new MediaResource(this);
    }
}

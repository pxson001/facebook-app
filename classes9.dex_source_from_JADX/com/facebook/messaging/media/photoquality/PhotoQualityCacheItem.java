package com.facebook.messaging.media.photoquality;

import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.time.SystemClock;
import com.facebook.debug.log.BLog;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.base.Strings;
import java.util.Collection;
import java.util.Collections;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@JsonDeserialize(using = PhotoQualityCacheItemDeserializer.class)
@JsonSerialize(using = PhotoQualityCacheItemSerializer.class)
/* compiled from: low latency output not supported */
public class PhotoQualityCacheItem {
    public PhotoQuality f11790a;
    public PhotoQuality f11791b;
    @JsonProperty("expirationTimeMs")
    public final Long expirationTimeMs;
    @JsonProperty("resolution")
    public final Integer resolution;
    @JsonProperty("threadKey")
    public final String threadKey;
    @JsonProperty("thumbnailResolution")
    public final Integer thumbnailResolution;

    /* compiled from: low latency output not supported */
    final class C13241 extends TypeReference<Collection<PhotoQualityCacheItem>> {
        C13241() {
        }
    }

    public final boolean m12414a() {
        return (Strings.isNullOrEmpty(this.threadKey) || this.resolution.intValue() == 0 || this.thumbnailResolution.intValue() == 0 || SystemClock.a.a() > this.expirationTimeMs.longValue()) ? false : true;
    }

    public PhotoQualityCacheItem() {
        this.resolution = Integer.valueOf(0);
        this.thumbnailResolution = Integer.valueOf(0);
        this.expirationTimeMs = Long.valueOf(0);
        this.threadKey = "";
    }

    public PhotoQualityCacheItem(int i, int i2, long j, String str) {
        this.resolution = Integer.valueOf(i);
        this.thumbnailResolution = Integer.valueOf(i2);
        this.expirationTimeMs = Long.valueOf(j);
        this.threadKey = str;
        this.f11790a = new PhotoQuality(this.resolution.intValue());
        this.f11791b = new PhotoQuality(this.thumbnailResolution.intValue());
    }

    public final void m12415b() {
        this.f11790a = new PhotoQuality(this.resolution.intValue());
        this.f11791b = new PhotoQuality(this.thumbnailResolution.intValue());
    }

    public static String m12412a(Collection<PhotoQualityCacheItem> collection) {
        try {
            return FbObjectMapper.i().a(collection);
        } catch (Throwable e) {
            BLog.b("PhotoQualityCacheItem", e, "Unable to serialize PhotoQualityCacheItem collection", new Object[0]);
            return "";
        }
    }

    public static Collection<PhotoQualityCacheItem> m12413a(String str) {
        try {
            return (Collection) FbObjectMapper.i().a(str, new C13241());
        } catch (Throwable th) {
            BLog.b("PhotoQualityCacheItem", th, "Unable to deserialize PhotoQualityCacheItem collection", new Object[0]);
            return Collections.emptyList();
        }
    }
}

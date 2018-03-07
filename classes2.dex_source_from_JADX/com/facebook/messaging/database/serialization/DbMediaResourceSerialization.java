package com.facebook.messaging.database.serialization;

import android.graphics.RectF;
import android.net.Uri;
import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.common.util.ExifOrientation;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.ui.media.attachments.MediaResource.Source;
import com.facebook.ui.media.attachments.MediaResource.Type;
import com.facebook.ui.media.attachments.MediaResourceBuilder;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: mStrokeColor */
public class DbMediaResourceSerialization {
    private final ObjectMapperWithUncheckedException f15386a;
    private final DbAppAttributionSerialization f15387b;

    public static DbMediaResourceSerialization m21926b(InjectorLike injectorLike) {
        return new DbMediaResourceSerialization(ObjectMapperWithUncheckedException.m21860a(injectorLike), DbAppAttributionSerialization.m21932b(injectorLike));
    }

    @Inject
    public DbMediaResourceSerialization(ObjectMapperWithUncheckedException objectMapperWithUncheckedException, DbAppAttributionSerialization dbAppAttributionSerialization) {
        this.f15386a = objectMapperWithUncheckedException;
        this.f15387b = dbAppAttributionSerialization;
    }

    public static DbMediaResourceSerialization m21921a(InjectorLike injectorLike) {
        return m21926b(injectorLike);
    }

    @Nullable
    public final String m21927a(List<MediaResource> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.f3121a);
        for (MediaResource a : list) {
            arrayNode.m13381a(m21923a(a));
        }
        return arrayNode.toString();
    }

    private ObjectNode m21923a(MediaResource mediaResource) {
        if (mediaResource == null) {
            return null;
        }
        String str;
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.f3121a);
        objectNode.m5137a("uri", mediaResource.c.toString());
        objectNode.m5137a("type", mediaResource.d.DBSerialValue);
        objectNode.m5137a("source", mediaResource.e.DBSerialValue);
        objectNode.m5137a("thumbnailUri", m21924a(mediaResource.f));
        objectNode.m5130a("mediaItemId", mediaResource.g);
        objectNode.m5143c("originalMediaResource", m21923a(mediaResource.h));
        objectNode.m5130a("duration", mediaResource.i);
        objectNode.m5129a("width", mediaResource.j);
        objectNode.m5129a("height", mediaResource.k);
        objectNode.m5129a("orientationHint", mediaResource.l.exifValue);
        objectNode.m5137a("offlineThreadingId", mediaResource.m);
        objectNode.m5137a("mimeType", mediaResource.o);
        objectNode.m5130a("fileSize", mediaResource.p);
        String str2 = "cropArea";
        RectF rectF = mediaResource.q;
        if (rectF == null) {
            str = null;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(rectF.left);
            stringBuilder.append(',');
            stringBuilder.append(rectF.top);
            stringBuilder.append(',');
            stringBuilder.append(rectF.right);
            stringBuilder.append(',');
            stringBuilder.append(rectF.bottom);
            str = stringBuilder.toString();
        }
        objectNode.m5137a(str2, str);
        objectNode.m5138a("wantFirstFrameForThumbnail", mediaResource.r);
        objectNode.m5129a("trimStartTimeMs", mediaResource.s);
        objectNode.m5129a("trimEndTimeMs", mediaResource.t);
        objectNode.m5137a("fbid", mediaResource.u);
        objectNode.m5137a("externalContentUri", m21924a(mediaResource.y));
        objectNode.m5138a("isTrustedExternalContentProvider", mediaResource.z);
        objectNode.m5137a("contentAppAttribution", DbAppAttributionSerialization.m21930a(mediaResource.x));
        objectNode.m5138a("renderAsSticker", mediaResource.B);
        objectNode.m5138a("isVoicemail", mediaResource.C);
        objectNode.m5137a("encryptionKeyBase64", mediaResource.D);
        return objectNode;
    }

    public final List<MediaResource> m21928a(@Nullable String str) {
        if (StringUtil.m3589a((CharSequence) str)) {
            return RegularImmutableList.f535a;
        }
        Builder builder = ImmutableList.builder();
        Iterator it = this.f15386a.m21862a(str).iterator();
        while (it.hasNext()) {
            builder.m1069c(m21922a((JsonNode) it.next()));
        }
        return builder.m1068b();
    }

    private MediaResource m21922a(JsonNode jsonNode) {
        if (jsonNode == null || jsonNode.m5205q()) {
            return null;
        }
        Source source;
        RectF rectF;
        MediaResourceBuilder a = MediaResource.a();
        a.a = Uri.parse(JSONUtil.m13458b(jsonNode.mo709b("uri")));
        a = a;
        a.b = Type.fromDBSerialValue(JSONUtil.m13458b(jsonNode.mo709b("type")));
        a = a;
        String b = JSONUtil.m13458b(jsonNode.mo709b("source"));
        if (b == null) {
            source = Source.UNSPECIFIED;
        } else {
            source = Source.fromDBSerialValue(b);
        }
        a.c = source;
        a = a;
        a.d = m21925b(JSONUtil.m13458b(jsonNode.mo709b("thumbnailUri")));
        a = a;
        a.f = JSONUtil.m13459c(jsonNode.mo709b("mediaItemId"));
        a = a;
        a.e = m21922a(jsonNode.mo709b("originalMediaResource"));
        a = a;
        a.g = JSONUtil.m13459c(jsonNode.mo709b("duration"));
        a = a;
        a.h = JSONUtil.m13460d(jsonNode.mo709b("width"));
        a = a;
        a.i = JSONUtil.m13460d(jsonNode.mo709b("height"));
        a = a;
        a.j = ExifOrientation.fromExifInterfaceOrientation(JSONUtil.m13449a(jsonNode.mo709b("orientationHint"), 0));
        a = a;
        a.k = JSONUtil.m13458b(jsonNode.mo709b("offlineThreadingId"));
        a = a;
        a.m = JSONUtil.m13458b(jsonNode.mo709b("mimeType"));
        a = a;
        a.n = (long) JSONUtil.m13460d(jsonNode.mo709b("fileSize"));
        a = a;
        CharSequence b2 = JSONUtil.m13458b(jsonNode.mo709b("cropArea"));
        if (Strings.isNullOrEmpty(b2)) {
            rectF = MediaResource.b;
        } else {
            Iterator it = Splitter.on(",").split(b2).iterator();
            rectF = new RectF(Float.parseFloat((String) it.next()), Float.parseFloat((String) it.next()), Float.parseFloat((String) it.next()), Float.parseFloat((String) it.next()));
        }
        a.o = rectF;
        a = a;
        a.p = JSONUtil.m13463g(jsonNode.mo709b("wantFirstFrameForThumbnail"));
        a = a;
        a.q = JSONUtil.m13449a(jsonNode.mo709b("trimStartTimeMs"), -1);
        a = a;
        a.r = JSONUtil.m13449a(jsonNode.mo709b("trimEndTimeMs"), -2);
        a = a;
        a.s = JSONUtil.m13458b(jsonNode.mo709b("fbid"));
        a = a;
        a.w = m21925b(JSONUtil.m13458b(jsonNode.mo709b("externalContentUri")));
        a = a;
        a.x = JSONUtil.m13463g(jsonNode.mo709b("isTrustedExternalContentProvider"));
        a = a;
        a.v = this.f15387b.m21934b(JSONUtil.m13458b(jsonNode.mo709b("contentAppAttribution")));
        a = a;
        a.z = JSONUtil.m13456a(jsonNode.mo709b("renderAsSticker"), false);
        a = a;
        a.A = JSONUtil.m13456a(jsonNode.mo709b("isVoicemail"), false);
        a = a;
        a.B = JSONUtil.m13458b(jsonNode.mo709b("encryptionKeyBase64"));
        return a.C();
    }

    private static String m21924a(Uri uri) {
        return uri != null ? uri.toString() : null;
    }

    private static Uri m21925b(String str) {
        return str != null ? Uri.parse(str) : null;
    }
}

package com.facebook.messaging.database.serialization;

import android.net.Uri;
import com.facebook.common.json.ObjectMapperWithUncheckedException;
import com.facebook.common.util.JSONUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.attachment.AttachmentBuilder;
import com.facebook.messaging.model.attachment.AttachmentBuilder.UrlBuilder;
import com.facebook.messaging.model.attachment.AttachmentImageMap;
import com.facebook.messaging.model.attachment.AttachmentImageMapBuilder;
import com.facebook.messaging.model.attachment.AttachmentImageType;
import com.facebook.messaging.model.attachment.AudioData;
import com.facebook.messaging.model.attachment.ImageData;
import com.facebook.messaging.model.attachment.ImageData.Source;
import com.facebook.messaging.model.attachment.ImageUrl;
import com.facebook.messaging.model.attachment.VideoData;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: loop_video_playback */
public class DbAttachmentSerialization {
    public final ObjectMapperWithUncheckedException f8830a;

    public static DbAttachmentSerialization m9146a(InjectorLike injectorLike) {
        return new DbAttachmentSerialization(ObjectMapperWithUncheckedException.a(injectorLike));
    }

    @Inject
    public DbAttachmentSerialization(ObjectMapperWithUncheckedException objectMapperWithUncheckedException) {
        this.f8830a = objectMapperWithUncheckedException;
    }

    public final String m9150a(List<Attachment> list) {
        if (list == null) {
            return null;
        }
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (Attachment attachment : list) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            objectNode.a("id", attachment.a);
            objectNode.a("fbid", attachment.c);
            objectNode.a("mime_type", attachment.d);
            objectNode.a("filename", attachment.e);
            objectNode.a("file_size", attachment.f);
            if (attachment.g != null) {
                objectNode.a("image_data_width", attachment.g.a);
                objectNode.a("image_data_height", attachment.g.b);
                if (attachment.g.c != null) {
                    objectNode.a("urls", m9148a(attachment.g.c));
                }
                if (attachment.g.d != null) {
                    objectNode.a("image_animated_urls", m9148a(attachment.g.d));
                }
                objectNode.a("image_data_source", attachment.g.e.intValue);
                objectNode.a("render_as_sticker", attachment.g.f);
                objectNode.a("mini_preview", attachment.g.g);
            }
            if (attachment.h != null) {
                objectNode.a("video_data_width", attachment.h.a);
                objectNode.a("video_data_height", attachment.h.b);
                objectNode.a("video_data_rotation", attachment.h.c);
                objectNode.a("video_data_length", attachment.h.d);
                objectNode.a("video_data_source", attachment.h.e.intValue);
                objectNode.a("video_data_url", attachment.h.f.toString());
                if (attachment.h.g != null) {
                    objectNode.a("video_data_thumbnail_url", attachment.h.g.toString());
                }
            }
            if (attachment.i != null) {
                objectNode.a("is_voicemail", attachment.i.a);
            }
            arrayNode.a(objectNode);
        }
        return arrayNode.toString();
    }

    public final ImmutableList<Attachment> m9149a(String str, String str2) {
        if (StringUtil.a(str)) {
            return RegularImmutableList.a;
        }
        Builder builder = ImmutableList.builder();
        Iterator it = this.f8830a.a(str).iterator();
        while (it.hasNext()) {
            JsonNode jsonNode = (JsonNode) it.next();
            AttachmentBuilder attachmentBuilder = new AttachmentBuilder(JSONUtil.b(jsonNode.b("id")), str2);
            attachmentBuilder.c = JSONUtil.b(jsonNode.b("fbid"));
            attachmentBuilder = attachmentBuilder;
            attachmentBuilder.d = JSONUtil.b(jsonNode.b("mime_type"));
            attachmentBuilder = attachmentBuilder;
            attachmentBuilder.e = JSONUtil.b(jsonNode.b("filename"));
            attachmentBuilder = attachmentBuilder;
            attachmentBuilder.f = JSONUtil.d(jsonNode.b("file_size"));
            AttachmentBuilder attachmentBuilder2 = attachmentBuilder;
            if (jsonNode.d("image_data_width") && jsonNode.d("image_data_height")) {
                attachmentBuilder2.g = new ImageData(JSONUtil.d(jsonNode.b("image_data_width")), JSONUtil.d(jsonNode.b("image_data_height")), m9147a(jsonNode.b("urls")), m9147a(jsonNode.b("image_animated_urls")), Source.fromIntVal(JSONUtil.d(jsonNode.b("image_data_source"))), JSONUtil.g(jsonNode.b("render_as_sticker")), JSONUtil.b(jsonNode.b("mini_preview")));
            }
            if (jsonNode.d("video_data_width") && jsonNode.d("video_data_height")) {
                VideoData.Source fromIntVal = VideoData.Source.fromIntVal(JSONUtil.d(jsonNode.b("video_data_source")));
                Uri uri = null;
                if (jsonNode.e("video_data_thumbnail_url")) {
                    uri = Uri.parse(JSONUtil.b(jsonNode.b("video_data_thumbnail_url")));
                }
                attachmentBuilder2.h = new VideoData(JSONUtil.d(jsonNode.b("video_data_width")), JSONUtil.d(jsonNode.b("video_data_height")), JSONUtil.d(jsonNode.b("video_data_rotation")), JSONUtil.d(jsonNode.b("video_data_length")), fromIntVal, Uri.parse(JSONUtil.b(jsonNode.b("video_data_url"))), uri);
            }
            if (jsonNode.d("is_voicemail")) {
                attachmentBuilder2.i = new AudioData(JSONUtil.g(jsonNode.b("is_voicemail")));
            }
            builder.c(attachmentBuilder2.k());
        }
        return builder.b();
    }

    private String m9148a(AttachmentImageMap attachmentImageMap) {
        ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
        if (attachmentImageMap != null) {
            Iterator it = attachmentImageMap.a.entrySet().iterator();
            while (it.hasNext()) {
                Entry entry = (Entry) it.next();
                String str = ((AttachmentImageType) entry.getKey()).serializedName;
                ImageUrl imageUrl = (ImageUrl) entry.getValue();
                ObjectNode objectNode2 = new ObjectNode(JsonNodeFactory.a);
                if (imageUrl != null) {
                    objectNode2.a("width", imageUrl.a);
                    objectNode2.a("height", imageUrl.b);
                    objectNode2.a("src", imageUrl.c);
                }
                objectNode.a(str, objectNode2.toString());
            }
        }
        return objectNode.toString();
    }

    private AttachmentImageMap m9147a(JsonNode jsonNode) {
        if (jsonNode == null || !jsonNode.o()) {
            return null;
        }
        Object B = jsonNode.B();
        AttachmentImageMapBuilder newBuilder = AttachmentImageMap.newBuilder();
        if (StringUtil.a(B)) {
            return null;
        }
        Iterator H = this.f8830a.a(B).H();
        while (H.hasNext()) {
            Entry entry = (Entry) H.next();
            AttachmentImageType fromSerializedName = AttachmentImageType.fromSerializedName((String) entry.getKey());
            if (fromSerializedName != null) {
                Object B2 = ((JsonNode) entry.getValue()).B();
                UrlBuilder urlBuilder = new UrlBuilder();
                if (!StringUtil.a(B2)) {
                    JsonNode a = this.f8830a.a(B2);
                    if (a.d("width")) {
                        urlBuilder.a = JSONUtil.d(a.b("width"));
                    }
                    if (a.d("height")) {
                        urlBuilder.b = JSONUtil.d(a.b("height"));
                    }
                    if (a.d("src")) {
                        urlBuilder.c = JSONUtil.b(a.b("src"));
                    }
                }
                newBuilder.a(fromSerializedName, urlBuilder.d());
            }
        }
        return newBuilder.b();
    }
}

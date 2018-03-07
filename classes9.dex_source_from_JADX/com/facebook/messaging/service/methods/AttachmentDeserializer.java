package com.facebook.messaging.service.methods;

import android.net.Uri;
import com.facebook.common.util.JSONUtil;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.model.attachment.Attachment;
import com.facebook.messaging.model.attachment.AttachmentBuilder;
import com.facebook.messaging.model.attachment.AudioData;
import com.facebook.messaging.model.attachment.ImageData;
import com.facebook.messaging.model.attachment.ImageData.Source;
import com.facebook.messaging.model.attachment.VideoData;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.Iterator;

/* compiled from: dbl_nux_dismiss_backward */
public class AttachmentDeserializer {
    public static AttachmentDeserializer m16860a(InjectorLike injectorLike) {
        return new AttachmentDeserializer();
    }

    static ImmutableList<Attachment> m16861a(JsonNode jsonNode, String str, MessageAttachmentIndex messageAttachmentIndex) {
        Builder builder = ImmutableList.builder();
        Iterator j = jsonNode.j();
        while (j.hasNext()) {
            JsonNode b = jsonNode.b((String) j.next());
            String b2 = JSONUtil.b(b.b("id"));
            String b3 = JSONUtil.b(b.b("fbid"));
            JSONUtil.d(b.b("type"));
            AttachmentBuilder attachmentBuilder = new AttachmentBuilder(b2, str);
            attachmentBuilder.c = b3;
            AttachmentBuilder attachmentBuilder2 = attachmentBuilder;
            attachmentBuilder2.d = JSONUtil.b(b.b("mime_type"));
            attachmentBuilder2 = attachmentBuilder2;
            attachmentBuilder2.e = JSONUtil.b(b.b("filename"));
            attachmentBuilder2 = attachmentBuilder2;
            attachmentBuilder2.f = JSONUtil.d(b.b("file_size"));
            AttachmentBuilder attachmentBuilder3 = attachmentBuilder2;
            if (b.e("image_data")) {
                JsonNode b4 = b.b("image_data");
                attachmentBuilder3.g = new ImageData(JSONUtil.d(b4.b("width")), JSONUtil.d(b4.b("height")), messageAttachmentIndex.m16970a(b2), messageAttachmentIndex.m16972b(b2), Source.fromIntVal(JSONUtil.d(b4.b("image_type"))), JSONUtil.g(b4.b("render_as_sticker")), JSONUtil.b(b4.b("mini_preview")));
            }
            if (b.e("audio_data")) {
                attachmentBuilder3.i = new AudioData(JSONUtil.g(b.b("audio_data").b("is_voicemail")));
            }
            if (b.e("video_data")) {
                JsonNode b5 = b.b("video_data");
                VideoData.Source fromIntVal = VideoData.Source.fromIntVal(JSONUtil.d(b5.b("video_type")));
                Uri uri = null;
                if (b5.e("preview_url")) {
                    uri = Uri.parse(JSONUtil.b(b5.b("preview_url")));
                }
                attachmentBuilder3.h = new VideoData(JSONUtil.d(b5.b("width")), JSONUtil.d(b5.b("height")), JSONUtil.d(b5.b("rotation")), JSONUtil.d(b5.b("length")), fromIntVal, Uri.parse(JSONUtil.b(b5.b("url"))), uri);
            }
            builder.c(attachmentBuilder3.k());
        }
        return builder.b();
    }
}

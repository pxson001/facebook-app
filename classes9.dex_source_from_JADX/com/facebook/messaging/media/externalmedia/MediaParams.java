package com.facebook.messaging.media.externalmedia;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: mContinueSearch */
public class MediaParams {
    public final ImmutableList<MediaType> f11614a;
    public final int f11615b;
    public final int f11616c;
    public final boolean f11617d;

    /* compiled from: mContinueSearch */
    public enum MediaType {
        JPG("JPG"),
        PNG("PNG"),
        GIF("GIF"),
        WEBP("WEBP"),
        MP4("MP4"),
        WEBM("WEBM");
        
        public final String jsonValue;

        private MediaType(String str) {
            this.jsonValue = str;
        }
    }

    public MediaParams(MediaParamsBuilder mediaParamsBuilder) {
        this.f11614a = ImmutableList.copyOf(mediaParamsBuilder.f11618a);
        this.f11615b = mediaParamsBuilder.f11619b;
        this.f11616c = mediaParamsBuilder.f11620c;
        this.f11617d = mediaParamsBuilder.f11621d;
    }

    public static MediaParamsBuilder newBuilder() {
        return new MediaParamsBuilder();
    }

    public static JsonNode m12244a(List<MediaParams> list) {
        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.a);
        for (MediaParams mediaParams : list) {
            ObjectNode objectNode = new ObjectNode(JsonNodeFactory.a);
            ArrayNode arrayNode2 = new ArrayNode(JsonNodeFactory.a);
            ImmutableList immutableList = mediaParams.f11614a;
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                arrayNode2.h(((MediaType) immutableList.get(i)).jsonValue);
            }
            objectNode.c("type", arrayNode2);
            if (mediaParams.f11615b >= 0) {
                objectNode.a("width", mediaParams.f11615b);
            }
            if (mediaParams.f11616c >= 0) {
                objectNode.a("height", mediaParams.f11616c);
            }
            if (mediaParams.f11617d) {
                objectNode.a("kill_animation", "true");
            }
            arrayNode.a(objectNode);
        }
        return arrayNode;
    }
}

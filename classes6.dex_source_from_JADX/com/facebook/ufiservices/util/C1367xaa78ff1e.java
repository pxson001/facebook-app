package com.facebook.ufiservices.util;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyActorsLinksGraphQLModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: crop_profile_picture */
public class C1367xaa78ff1e extends JsonSerializer<LinkableUtilApplyActorsLinksGraphQLModel> {
    public final void m26901a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        LinkableUtilApplyActorsLinksGraphQLModel linkableUtilApplyActorsLinksGraphQLModel = (LinkableUtilApplyActorsLinksGraphQLModel) obj;
        if (linkableUtilApplyActorsLinksGraphQLModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(linkableUtilApplyActorsLinksGraphQLModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            linkableUtilApplyActorsLinksGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        LinkableUtilApplyActorsLinksGraphQLParser.m26943a(linkableUtilApplyActorsLinksGraphQLModel.w_(), linkableUtilApplyActorsLinksGraphQLModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(LinkableUtilApplyActorsLinksGraphQLModel.class, new C1367xaa78ff1e());
    }
}

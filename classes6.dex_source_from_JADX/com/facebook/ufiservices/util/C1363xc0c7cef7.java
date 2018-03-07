package com.facebook.ufiservices.util;

import com.facebook.common.json.FbSerializerProvider;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLModels.LinkableUtilApplyActorsLinksGraphQLModel.RangesModel.EntityModel.PageModel;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.PageParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.nio.ByteBuffer;

/* compiled from: crop_profile_picture */
public class C1363xc0c7cef7 extends JsonSerializer<PageModel> {
    public final void m26892a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
        PageModel pageModel = (PageModel) obj;
        if (pageModel.w_() == null) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(pageModel.a(flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }
        PageParser.m26933a(pageModel.w_(), pageModel.u_(), jsonGenerator, serializerProvider);
    }

    static {
        FbSerializerProvider.a(PageModel.class, new C1363xc0c7cef7());
    }
}

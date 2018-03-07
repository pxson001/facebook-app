package com.facebook.ufiservices.util;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.directinstall.util.C0589xd643bf8b;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.linkify.LinkifyTargetGraphQLInterfaces.LinkifyTargetGraphQL.ProfilePicture;
import com.facebook.ufiservices.util.LinkifyUtilGraphQLParsers.LinkableUtilApplyActorsLinksGraphQLParser.RangesParser.EntityParser.ProfilePictureParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 842551240)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: crop_profile_picture */
public final class C1364xcfb74179 extends BaseModel implements C0589xd643bf8b, GraphQLVisitableModel, ProfilePicture {
    @Nullable
    private String f18339d;

    /* compiled from: crop_profile_picture */
    public final class Builder {
        @Nullable
        public String f18338a;
    }

    /* compiled from: crop_profile_picture */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1364xcfb74179.class, new Deserializer());
        }

        public Object m26893a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(ProfilePictureParser.m26934a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1364xcfb74179 = new C1364xcfb74179();
            ((BaseModel) c1364xcfb74179).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1364xcfb74179 instanceof Postprocessable) {
                return ((Postprocessable) c1364xcfb74179).a();
            }
            return c1364xcfb74179;
        }
    }

    /* compiled from: crop_profile_picture */
    public class Serializer extends JsonSerializer<C1364xcfb74179> {
        public final void m26894a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1364xcfb74179 c1364xcfb74179 = (C1364xcfb74179) obj;
            if (c1364xcfb74179.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1364xcfb74179.m26896a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1364xcfb74179.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            ProfilePictureParser.m26935a(c1364xcfb74179.w_(), c1364xcfb74179.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C1364xcfb74179.class, new Serializer());
        }
    }

    public C1364xcfb74179() {
        super(1);
    }

    public C1364xcfb74179(MutableFlatBuffer mutableFlatBuffer) {
        super(1);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nullable
    public final String mo962b() {
        this.f18339d = super.a(this.f18339d, 0);
        return this.f18339d;
    }

    public static C1364xcfb74179 m26895a(C1364xcfb74179 c1364xcfb74179) {
        if (c1364xcfb74179 == null) {
            return null;
        }
        if (c1364xcfb74179 instanceof C1364xcfb74179) {
            return c1364xcfb74179;
        }
        Builder builder = new Builder();
        builder.f18338a = c1364xcfb74179.mo962b();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder.f18338a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new C1364xcfb74179(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public final int jK_() {
        return 70760763;
    }

    public final GraphQLVisitableModel m26897a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m26896a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(mo962b());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}

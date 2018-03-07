package com.facebook.pages.adminedpages.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.adminedpages.protocol.C1789x4f009d7.ProfilePictureParser;
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
/* compiled from: currentEntityId must be in initialEntityIds */
public final class C1784x8c640db1 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f16547d;

    /* compiled from: currentEntityId must be in initialEntityIds */
    public final class Builder {
        @Nullable
        public String f16546a;

        public final Builder m19508a(@Nullable String str) {
            this.f16546a = str;
            return this;
        }

        public final C1784x8c640db1 m19509a() {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int b = flatBufferBuilder.b(this.f16546a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new C1784x8c640db1(new MutableFlatBuffer(wrap, null, null, true, null));
        }
    }

    /* compiled from: currentEntityId must be in initialEntityIds */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C1784x8c640db1.class, new Deserializer());
        }

        public Object m19510a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(ProfilePictureParser.m19522a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c1784x8c640db1 = new C1784x8c640db1();
            ((BaseModel) c1784x8c640db1).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c1784x8c640db1 instanceof Postprocessable) {
                return ((Postprocessable) c1784x8c640db1).a();
            }
            return c1784x8c640db1;
        }
    }

    /* compiled from: currentEntityId must be in initialEntityIds */
    public class Serializer extends JsonSerializer<C1784x8c640db1> {
        public final void m19511a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C1784x8c640db1 c1784x8c640db1 = (C1784x8c640db1) obj;
            if (c1784x8c640db1.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c1784x8c640db1.m19512a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c1784x8c640db1.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            ProfilePictureParser.m19523a(c1784x8c640db1.w_(), c1784x8c640db1.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C1784x8c640db1.class, new Serializer());
        }
    }

    public C1784x8c640db1() {
        super(1);
    }

    public C1784x8c640db1(MutableFlatBuffer mutableFlatBuffer) {
        super(1);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nullable
    public final String m19514a() {
        this.f16547d = super.a(this.f16547d, 0);
        return this.f16547d;
    }

    public final int jK_() {
        return 70760763;
    }

    public final GraphQLVisitableModel m19513a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m19512a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m19514a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}

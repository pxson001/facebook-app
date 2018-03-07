package com.facebook.photos.data.protocol;

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
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLParsers.SimpleMediaFeedbackParser.TopLevelCommentsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -2056444745)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: suggest_edits */
public final class C0220xee8e0a15 extends BaseModel implements GraphQLVisitableModel {
    private int f3834d;
    private int f3835e;

    /* compiled from: suggest_edits */
    public final class Builder {
        public int f3832a;
        public int f3833b;
    }

    /* compiled from: suggest_edits */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0220xee8e0a15.class, new Deserializer());
        }

        public Object m5346a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(TopLevelCommentsParser.m5488a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0220xee8e0a15 = new C0220xee8e0a15();
            ((BaseModel) c0220xee8e0a15).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0220xee8e0a15 instanceof Postprocessable) {
                return ((Postprocessable) c0220xee8e0a15).a();
            }
            return c0220xee8e0a15;
        }
    }

    /* compiled from: suggest_edits */
    public class Serializer extends JsonSerializer<C0220xee8e0a15> {
        public final void m5347a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0220xee8e0a15 c0220xee8e0a15 = (C0220xee8e0a15) obj;
            if (c0220xee8e0a15.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0220xee8e0a15.m5350a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0220xee8e0a15.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            TopLevelCommentsParser.m5489a(c0220xee8e0a15.w_(), c0220xee8e0a15.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0220xee8e0a15.class, new Serializer());
        }
    }

    public C0220xee8e0a15() {
        super(2);
    }

    public C0220xee8e0a15(MutableFlatBuffer mutableFlatBuffer) {
        super(2);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    public final int m5349a() {
        a(0, 0);
        return this.f3834d;
    }

    public final void m5352a(int i) {
        this.f3834d = i;
        if (this.b != null && this.b.d) {
            this.b.b(this.c, 0, i);
        }
    }

    public final int m5354b() {
        a(0, 1);
        return this.f3835e;
    }

    public final void m5355b(int i) {
        this.f3835e = i;
        if (this.b != null && this.b.d) {
            this.b.b(this.c, 1, i);
        }
    }

    public static C0220xee8e0a15 m5348a(C0220xee8e0a15 c0220xee8e0a15) {
        if (c0220xee8e0a15 == null) {
            return null;
        }
        if (c0220xee8e0a15 instanceof C0220xee8e0a15) {
            return c0220xee8e0a15;
        }
        Builder builder = new Builder();
        builder.f3832a = c0220xee8e0a15.m5349a();
        builder.f3833b = c0220xee8e0a15.m5354b();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, builder.f3832a, 0);
        flatBufferBuilder.a(1, builder.f3833b, 0);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new C0220xee8e0a15(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public final int jK_() {
        return 899897761;
    }

    public final GraphQLVisitableModel m5351a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m5350a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, this.f3834d, 0);
        flatBufferBuilder.a(1, this.f3835e, 0);
        i();
        return flatBufferBuilder.d();
    }

    public final void m5353a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3834d = mutableFlatBuffer.a(i, 0, 0);
        this.f3835e = mutableFlatBuffer.a(i, 1, 0);
    }
}

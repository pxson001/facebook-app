package com.facebook.contacts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactParser.NameEntriesParser.PrimaryFieldParser;
import com.facebook.contacts.graphql.ContactGraphQLParsers.ContactParser.NameEntriesParser.PrimaryFieldParser.ValueParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
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
@ModelWithFlatBufferFormatHash(a = 1052433638)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: photo_ */
public final class C0498x332b405b extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private GraphQLObjectType f8173d;
    @Nullable
    private ValueModel f8174e;

    /* compiled from: photo_ */
    public final class Builder {
        @Nullable
        public GraphQLObjectType f8169a;
        @Nullable
        public ValueModel f8170b;

        public final C0498x332b405b m11800a() {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, this.f8169a);
            int a2 = ModelHelper.a(flatBufferBuilder, this.f8170b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new C0498x332b405b(new MutableFlatBuffer(wrap, null, null, true, null));
        }
    }

    /* compiled from: photo_ */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0498x332b405b.class, new Deserializer());
        }

        public Object m11801a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(PrimaryFieldParser.a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0498x332b405b = new C0498x332b405b();
            ((BaseModel) c0498x332b405b).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0498x332b405b instanceof Postprocessable) {
                return ((Postprocessable) c0498x332b405b).a();
            }
            return c0498x332b405b;
        }
    }

    /* compiled from: photo_ */
    public class Serializer extends JsonSerializer<C0498x332b405b> {
        public final void m11802a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0498x332b405b c0498x332b405b = (C0498x332b405b) obj;
            if (c0498x332b405b.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0498x332b405b.m11809a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0498x332b405b.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            PrimaryFieldParser.a(c0498x332b405b.w_(), c0498x332b405b.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C0498x332b405b.class, new Serializer());
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1352864475)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_ */
    public final class ValueModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8172d;

        /* compiled from: photo_ */
        public final class Builder {
            @Nullable
            public String f8171a;
        }

        /* compiled from: photo_ */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ValueModel.class, new Deserializer());
            }

            public Object m11803a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ValueParser.a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object valueModel = new ValueModel();
                ((BaseModel) valueModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (valueModel instanceof Postprocessable) {
                    return ((Postprocessable) valueModel).a();
                }
                return valueModel;
            }
        }

        /* compiled from: photo_ */
        public class Serializer extends JsonSerializer<ValueModel> {
            public final void m11804a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ValueModel valueModel = (ValueModel) obj;
                if (valueModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(valueModel.m11805a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    valueModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ValueParser.a(valueModel.w_(), valueModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ValueModel.class, new Serializer());
            }
        }

        public ValueModel() {
            super(1);
        }

        public ValueModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m11807a() {
            this.f8172d = super.a(this.f8172d, 0);
            return this.f8172d;
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m11806a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m11805a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m11807a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    public C0498x332b405b() {
        super(2);
    }

    public C0498x332b405b(MutableFlatBuffer mutableFlatBuffer) {
        super(2);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nullable
    private GraphQLObjectType m11808j() {
        if (this.b != null && this.f8173d == null) {
            this.f8173d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
        }
        return this.f8173d;
    }

    @Nullable
    public final ValueModel m11810a() {
        this.f8174e = (ValueModel) super.a(this.f8174e, 1, ValueModel.class);
        return this.f8174e;
    }

    public final int jK_() {
        return 1418818778;
    }

    public final GraphQLVisitableModel m11811a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m11810a() != null) {
            ValueModel valueModel = (ValueModel) graphQLModelMutatingVisitor.b(m11810a());
            if (m11810a() != valueModel) {
                graphQLVisitableModel = (C0498x332b405b) ModelHelper.a(null, this);
                graphQLVisitableModel.f8174e = valueModel;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m11809a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m11808j());
        int a2 = ModelHelper.a(flatBufferBuilder, m11810a());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }
}

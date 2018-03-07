package com.facebook.graphql.querybuilder.common;

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
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoTailFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultIconFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultPageInfoFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultPageInfoTailFieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DefaultVect2FieldsParser;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Parsers.DeprecatedCurrencyQuantityFieldsParser;
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

/* compiled from: edit_page_dialog */
public class CommonGraphQL2Models {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1177228248)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: edit_page_dialog */
    public final class DefaultIconFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f4811d;
        @Nullable
        private String f4812e;
        @Nullable
        private String f4813f;
        private int f4814g;

        /* compiled from: edit_page_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultIconFieldsModel.class, new Deserializer());
            }

            public Object m9606a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultIconFieldsParser.m9650a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultIconFieldsModel = new DefaultIconFieldsModel();
                ((BaseModel) defaultIconFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultIconFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultIconFieldsModel).a();
                }
                return defaultIconFieldsModel;
            }
        }

        /* compiled from: edit_page_dialog */
        public class Serializer extends JsonSerializer<DefaultIconFieldsModel> {
            public final void m9607a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultIconFieldsModel defaultIconFieldsModel = (DefaultIconFieldsModel) obj;
                if (defaultIconFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultIconFieldsModel.m9610a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultIconFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultIconFieldsParser.m9651a(defaultIconFieldsModel.w_(), defaultIconFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(DefaultIconFieldsModel.class, new Serializer());
            }
        }

        public DefaultIconFieldsModel() {
            super(4);
        }

        @Nullable
        private String m9608a() {
            this.f4812e = super.a(this.f4812e, 1);
            return this.f4812e;
        }

        @Nullable
        private String m9609j() {
            this.f4813f = super.a(this.f4813f, 2);
            return this.f4813f;
        }

        public final int jK_() {
            return 2273433;
        }

        public final GraphQLVisitableModel m9611a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9610a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9608a());
            int b2 = flatBufferBuilder.b(m9609j());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f4811d, 0);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.a(3, this.f4814g, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9612a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4811d = mutableFlatBuffer.a(i, 0, 0);
            this.f4814g = mutableFlatBuffer.a(i, 3, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 921619519)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: edit_page_dialog */
    public final class DefaultPageInfoFieldsModel extends BaseModel implements DefaultPageInfoFields, GraphQLVisitableModel {
        @Nullable
        private String f4825d;
        private boolean f4826e;
        private boolean f4827f;
        @Nullable
        private String f4828g;

        /* compiled from: edit_page_dialog */
        public final class Builder {
            @Nullable
            public String f4821a;
            public boolean f4822b;
            public boolean f4823c;
            @Nullable
            public String f4824d;

            public final DefaultPageInfoFieldsModel m9618a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f4821a);
                int b2 = flatBufferBuilder.b(this.f4824d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f4822b);
                flatBufferBuilder.a(2, this.f4823c);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new DefaultPageInfoFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: edit_page_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultPageInfoFieldsModel.class, new Deserializer());
            }

            public Object m9619a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultPageInfoFieldsParser.m9652a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultPageInfoFieldsModel = new DefaultPageInfoFieldsModel();
                ((BaseModel) defaultPageInfoFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultPageInfoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultPageInfoFieldsModel).a();
                }
                return defaultPageInfoFieldsModel;
            }
        }

        /* compiled from: edit_page_dialog */
        public class Serializer extends JsonSerializer<DefaultPageInfoFieldsModel> {
            public final void m9620a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) obj;
                if (defaultPageInfoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultPageInfoFieldsModel.m9622a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultPageInfoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultPageInfoFieldsParser.m9653a(defaultPageInfoFieldsModel.w_(), defaultPageInfoFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(DefaultPageInfoFieldsModel.class, new Serializer());
            }
        }

        public DefaultPageInfoFieldsModel() {
            super(4);
        }

        public DefaultPageInfoFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m9624a() {
            this.f4825d = super.a(this.f4825d, 0);
            return this.f4825d;
        }

        public final boolean m9626b() {
            a(0, 1);
            return this.f4826e;
        }

        public final boolean m9627c() {
            a(0, 2);
            return this.f4827f;
        }

        @Nullable
        public final String v_() {
            this.f4828g = super.a(this.f4828g, 3);
            return this.f4828g;
        }

        public static DefaultPageInfoFieldsModel m9621a(DefaultPageInfoFields defaultPageInfoFields) {
            if (defaultPageInfoFields == null) {
                return null;
            }
            if (defaultPageInfoFields instanceof DefaultPageInfoFieldsModel) {
                return (DefaultPageInfoFieldsModel) defaultPageInfoFields;
            }
            Builder builder = new Builder();
            builder.f4821a = defaultPageInfoFields.a();
            builder.f4822b = defaultPageInfoFields.b();
            builder.f4823c = defaultPageInfoFields.c();
            builder.f4824d = defaultPageInfoFields.v_();
            return builder.m9618a();
        }

        public final int jK_() {
            return 923779069;
        }

        public final GraphQLVisitableModel m9623a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9622a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9624a());
            int b2 = flatBufferBuilder.b(v_());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f4826e);
            flatBufferBuilder.a(2, this.f4827f);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9625a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4826e = mutableFlatBuffer.a(i, 1);
            this.f4827f = mutableFlatBuffer.a(i, 2);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2005169142)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: edit_page_dialog */
    public final class DefaultPageInfoTailFieldsModel extends BaseModel implements DefaultPageInfoTailFields, GraphQLVisitableModel {
        @Nullable
        private String f4829d;
        private boolean f4830e;

        /* compiled from: edit_page_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultPageInfoTailFieldsModel.class, new Deserializer());
            }

            public Object m9628a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultPageInfoTailFieldsParser.m9654a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultPageInfoTailFieldsModel = new DefaultPageInfoTailFieldsModel();
                ((BaseModel) defaultPageInfoTailFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultPageInfoTailFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultPageInfoTailFieldsModel).a();
                }
                return defaultPageInfoTailFieldsModel;
            }
        }

        /* compiled from: edit_page_dialog */
        public class Serializer extends JsonSerializer<DefaultPageInfoTailFieldsModel> {
            public final void m9629a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultPageInfoTailFieldsModel defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) obj;
                if (defaultPageInfoTailFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultPageInfoTailFieldsModel.m9630a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultPageInfoTailFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultPageInfoTailFieldsParser.m9655a(defaultPageInfoTailFieldsModel.w_(), defaultPageInfoTailFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(DefaultPageInfoTailFieldsModel.class, new Serializer());
            }
        }

        public DefaultPageInfoTailFieldsModel() {
            super(2);
        }

        @Nullable
        public final String m9632a() {
            this.f4829d = super.a(this.f4829d, 0);
            return this.f4829d;
        }

        public final boolean m9634b() {
            a(0, 1);
            return this.f4830e;
        }

        public final int jK_() {
            return 923779069;
        }

        public final GraphQLVisitableModel m9631a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9630a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9632a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f4830e);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9633a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4830e = mutableFlatBuffer.a(i, 1);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -496435496)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: edit_page_dialog */
    public final class DefaultVect2FieldsModel extends BaseModel implements DefaultVect2Fields, GraphQLVisitableModel {
        private double f4833d;
        private double f4834e;

        /* compiled from: edit_page_dialog */
        public final class Builder {
            public double f4831a;
            public double f4832b;

            public final DefaultVect2FieldsModel m9635a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f4831a, 0.0d);
                flatBufferBuilder.a(1, this.f4832b, 0.0d);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new DefaultVect2FieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: edit_page_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultVect2FieldsModel.class, new Deserializer());
            }

            public Object m9636a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultVect2FieldsParser.m9656a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultVect2FieldsModel = new DefaultVect2FieldsModel();
                ((BaseModel) defaultVect2FieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultVect2FieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultVect2FieldsModel).a();
                }
                return defaultVect2FieldsModel;
            }
        }

        /* compiled from: edit_page_dialog */
        public class Serializer extends JsonSerializer<DefaultVect2FieldsModel> {
            public final void m9637a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) obj;
                if (defaultVect2FieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultVect2FieldsModel.m9640a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultVect2FieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultVect2FieldsParser.m9657a(defaultVect2FieldsModel.w_(), defaultVect2FieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(DefaultVect2FieldsModel.class, new Serializer());
            }
        }

        public DefaultVect2FieldsModel() {
            super(2);
        }

        public DefaultVect2FieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final double m9639a() {
            a(0, 0);
            return this.f4833d;
        }

        public final double m9643b() {
            a(0, 1);
            return this.f4834e;
        }

        public static DefaultVect2FieldsModel m9638a(DefaultVect2Fields defaultVect2Fields) {
            if (defaultVect2Fields == null) {
                return null;
            }
            if (defaultVect2Fields instanceof DefaultVect2FieldsModel) {
                return (DefaultVect2FieldsModel) defaultVect2Fields;
            }
            Builder builder = new Builder();
            builder.f4831a = defaultVect2Fields.a();
            builder.f4832b = defaultVect2Fields.b();
            return builder.m9635a();
        }

        public final int jK_() {
            return 82530482;
        }

        public final GraphQLVisitableModel m9641a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9640a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f4833d, 0.0d);
            flatBufferBuilder.a(1, this.f4834e, 0.0d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9642a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4833d = mutableFlatBuffer.a(i, 0, 0.0d);
            this.f4834e = mutableFlatBuffer.a(i, 1, 0.0d);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1587106126)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: edit_page_dialog */
    public final class DeprecatedCurrencyQuantityFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private double f4835d;
        @Nullable
        private String f4836e;

        /* compiled from: edit_page_dialog */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DeprecatedCurrencyQuantityFieldsModel.class, new Deserializer());
            }

            public Object m9644a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DeprecatedCurrencyQuantityFieldsParser.m9658a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object deprecatedCurrencyQuantityFieldsModel = new DeprecatedCurrencyQuantityFieldsModel();
                ((BaseModel) deprecatedCurrencyQuantityFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (deprecatedCurrencyQuantityFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) deprecatedCurrencyQuantityFieldsModel).a();
                }
                return deprecatedCurrencyQuantityFieldsModel;
            }
        }

        /* compiled from: edit_page_dialog */
        public class Serializer extends JsonSerializer<DeprecatedCurrencyQuantityFieldsModel> {
            public final void m9645a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DeprecatedCurrencyQuantityFieldsModel deprecatedCurrencyQuantityFieldsModel = (DeprecatedCurrencyQuantityFieldsModel) obj;
                if (deprecatedCurrencyQuantityFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(deprecatedCurrencyQuantityFieldsModel.m9647a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    deprecatedCurrencyQuantityFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DeprecatedCurrencyQuantityFieldsParser.m9659a(deprecatedCurrencyQuantityFieldsModel.w_(), deprecatedCurrencyQuantityFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(DeprecatedCurrencyQuantityFieldsModel.class, new Serializer());
            }
        }

        public DeprecatedCurrencyQuantityFieldsModel() {
            super(2);
        }

        @Nullable
        private String m9646a() {
            this.f4836e = super.a(this.f4836e, 1);
            return this.f4836e;
        }

        public final int jK_() {
            return 753818588;
        }

        public final GraphQLVisitableModel m9648a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9647a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9646a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f4835d, 0.0d);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m9649a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4835d = mutableFlatBuffer.a(i, 0, 0.0d);
        }
    }
}

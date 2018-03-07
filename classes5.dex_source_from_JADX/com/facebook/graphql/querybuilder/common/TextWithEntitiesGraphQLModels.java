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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesEntityFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesWithAggregatedRangesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesWithAggregatedRangesFields.AggregatedRanges;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntityRangesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesEntityFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser.RangesParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesWithAggregatedRangesFieldsParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesWithAggregatedRangesFieldsParser.AggregatedRangesParser;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntityRangesFieldsParser;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: e4d338791e93269e82fbd5b665244019 */
public class TextWithEntitiesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2086550517)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: e4d338791e93269e82fbd5b665244019 */
    public final class DefaultTextWithEntitiesEntityFieldsModel extends BaseModel implements DefaultTextWithEntitiesEntityFields, GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f4889d;
        @Nullable
        private List<String> f4890e;
        @Nullable
        private String f4891f;
        @Nullable
        private String f4892g;
        @Nullable
        private String f4893h;
        @Nullable
        private String f4894i;

        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f4883a;
            @Nullable
            public ImmutableList<String> f4884b;
            @Nullable
            public String f4885c;
            @Nullable
            public String f4886d;
            @Nullable
            public String f4887e;
            @Nullable
            public String f4888f;

            public final DefaultTextWithEntitiesEntityFieldsModel m9769a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f4883a);
                int c = flatBufferBuilder.c(this.f4884b);
                int b = flatBufferBuilder.b(this.f4885c);
                int b2 = flatBufferBuilder.b(this.f4886d);
                int b3 = flatBufferBuilder.b(this.f4887e);
                int b4 = flatBufferBuilder.b(this.f4888f);
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, c);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, b3);
                flatBufferBuilder.b(5, b4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new DefaultTextWithEntitiesEntityFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultTextWithEntitiesEntityFieldsModel.class, new Deserializer());
            }

            public Object m9770a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultTextWithEntitiesEntityFieldsParser.m9832a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultTextWithEntitiesEntityFieldsModel = new DefaultTextWithEntitiesEntityFieldsModel();
                ((BaseModel) defaultTextWithEntitiesEntityFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultTextWithEntitiesEntityFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultTextWithEntitiesEntityFieldsModel).a();
                }
                return defaultTextWithEntitiesEntityFieldsModel;
            }
        }

        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public class Serializer extends JsonSerializer<DefaultTextWithEntitiesEntityFieldsModel> {
            public final void m9771a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultTextWithEntitiesEntityFieldsModel defaultTextWithEntitiesEntityFieldsModel = (DefaultTextWithEntitiesEntityFieldsModel) obj;
                if (defaultTextWithEntitiesEntityFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultTextWithEntitiesEntityFieldsModel.m9773a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultTextWithEntitiesEntityFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultTextWithEntitiesEntityFieldsParser.m9833a(defaultTextWithEntitiesEntityFieldsModel.w_(), defaultTextWithEntitiesEntityFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(DefaultTextWithEntitiesEntityFieldsModel.class, new Serializer());
            }
        }

        public DefaultTextWithEntitiesEntityFieldsModel() {
            super(6);
        }

        public DefaultTextWithEntitiesEntityFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(6);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType m9776b() {
            if (this.b != null && this.f4889d == null) {
                this.f4889d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f4889d;
        }

        @Nonnull
        public final ImmutableList<String> m9777c() {
            this.f4890e = super.a(this.f4890e, 1);
            return (ImmutableList) this.f4890e;
        }

        @Nullable
        public final String m9778d() {
            this.f4891f = super.a(this.f4891f, 2);
            return this.f4891f;
        }

        @Nullable
        public final String C_() {
            this.f4892g = super.a(this.f4892g, 3);
            return this.f4892g;
        }

        @Nullable
        public final String m9779g() {
            this.f4893h = super.a(this.f4893h, 4);
            return this.f4893h;
        }

        @Nullable
        public final String D_() {
            this.f4894i = super.a(this.f4894i, 5);
            return this.f4894i;
        }

        public static DefaultTextWithEntitiesEntityFieldsModel m9772a(DefaultTextWithEntitiesEntityFields defaultTextWithEntitiesEntityFields) {
            if (defaultTextWithEntitiesEntityFields == null) {
                return null;
            }
            if (defaultTextWithEntitiesEntityFields instanceof DefaultTextWithEntitiesEntityFieldsModel) {
                return (DefaultTextWithEntitiesEntityFieldsModel) defaultTextWithEntitiesEntityFields;
            }
            Builder builder = new Builder();
            builder.f4883a = defaultTextWithEntitiesEntityFields.b();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < defaultTextWithEntitiesEntityFields.c().size(); i++) {
                builder2.c(defaultTextWithEntitiesEntityFields.c().get(i));
            }
            builder.f4884b = builder2.b();
            builder.f4885c = defaultTextWithEntitiesEntityFields.d();
            builder.f4886d = defaultTextWithEntitiesEntityFields.C_();
            builder.f4887e = defaultTextWithEntitiesEntityFields.g();
            builder.f4888f = defaultTextWithEntitiesEntityFields.D_();
            return builder.m9769a();
        }

        @Nullable
        public final String m9775a() {
            return m9778d();
        }

        public final int jK_() {
            return 2080559107;
        }

        public final GraphQLVisitableModel m9774a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9773a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9776b());
            int c = flatBufferBuilder.c(m9777c());
            int b = flatBufferBuilder.b(m9778d());
            int b2 = flatBufferBuilder.b(C_());
            int b3 = flatBufferBuilder.b(m9779g());
            int b4 = flatBufferBuilder.b(D_());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, c);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, b3);
            flatBufferBuilder.b(5, b4);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1352864475)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: e4d338791e93269e82fbd5b665244019 */
    public final class DefaultTextWithEntitiesFieldsModel extends BaseModel implements DefaultTextWithEntitiesFields, GraphQLVisitableModel {
        @Nullable
        private String f4896d;

        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public final class Builder {
            @Nullable
            public String f4895a;

            public final DefaultTextWithEntitiesFieldsModel m9780a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f4895a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new DefaultTextWithEntitiesFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultTextWithEntitiesFieldsModel.class, new Deserializer());
            }

            public Object m9781a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultTextWithEntitiesFieldsParser.m9834a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultTextWithEntitiesFieldsModel = new DefaultTextWithEntitiesFieldsModel();
                ((BaseModel) defaultTextWithEntitiesFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultTextWithEntitiesFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultTextWithEntitiesFieldsModel).a();
                }
                return defaultTextWithEntitiesFieldsModel;
            }
        }

        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public class Serializer extends JsonSerializer<DefaultTextWithEntitiesFieldsModel> {
            public final void m9782a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) obj;
                if (defaultTextWithEntitiesFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultTextWithEntitiesFieldsModel.m9784a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultTextWithEntitiesFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultTextWithEntitiesFieldsParser.m9835a(defaultTextWithEntitiesFieldsModel.w_(), defaultTextWithEntitiesFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(DefaultTextWithEntitiesFieldsModel.class, new Serializer());
            }
        }

        public DefaultTextWithEntitiesFieldsModel() {
            super(1);
        }

        public DefaultTextWithEntitiesFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m9786a() {
            this.f4896d = super.a(this.f4896d, 0);
            return this.f4896d;
        }

        public static DefaultTextWithEntitiesFieldsModel m9783a(DefaultTextWithEntitiesFields defaultTextWithEntitiesFields) {
            if (defaultTextWithEntitiesFields == null) {
                return null;
            }
            if (defaultTextWithEntitiesFields instanceof DefaultTextWithEntitiesFieldsModel) {
                return (DefaultTextWithEntitiesFieldsModel) defaultTextWithEntitiesFields;
            }
            Builder builder = new Builder();
            builder.f4895a = defaultTextWithEntitiesFields.a();
            return builder.m9780a();
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m9785a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m9784a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m9786a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1233606746)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: e4d338791e93269e82fbd5b665244019 */
    public final class DefaultTextWithEntitiesLongFieldsModel extends BaseModel implements DefaultTextWithEntitiesLongFields, GraphQLVisitableModel {
        @Nullable
        private List<RangesModel> f4905d;
        @Nullable
        private String f4906e;

        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public final class Builder {
            @Nullable
            public ImmutableList<RangesModel> f4897a;
            @Nullable
            public String f4898b;

            public final DefaultTextWithEntitiesLongFieldsModel m9787a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f4897a);
                int b = flatBufferBuilder.b(this.f4898b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new DefaultTextWithEntitiesLongFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultTextWithEntitiesLongFieldsModel.class, new Deserializer());
            }

            public Object m9788a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultTextWithEntitiesLongFieldsParser.m9842a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultTextWithEntitiesLongFieldsModel = new DefaultTextWithEntitiesLongFieldsModel();
                ((BaseModel) defaultTextWithEntitiesLongFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultTextWithEntitiesLongFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultTextWithEntitiesLongFieldsModel).a();
                }
                return defaultTextWithEntitiesLongFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -507281473)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public final class RangesModel extends BaseModel implements Ranges, GraphQLVisitableModel {
            @Nullable
            private DefaultTextWithEntitiesEntityFieldsModel f4902d;
            private int f4903e;
            private int f4904f;

            /* compiled from: e4d338791e93269e82fbd5b665244019 */
            public final class Builder {
                @Nullable
                public DefaultTextWithEntitiesEntityFieldsModel f4899a;
                public int f4900b;
                public int f4901c;

                public final RangesModel m9789a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f4899a);
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f4900b, 0);
                    flatBufferBuilder.a(2, this.f4901c, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new RangesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: e4d338791e93269e82fbd5b665244019 */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                }

                public Object m9790a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(RangesParser.m9840b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object rangesModel = new RangesModel();
                    ((BaseModel) rangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (rangesModel instanceof Postprocessable) {
                        return ((Postprocessable) rangesModel).a();
                    }
                    return rangesModel;
                }
            }

            /* compiled from: e4d338791e93269e82fbd5b665244019 */
            public class Serializer extends JsonSerializer<RangesModel> {
                public final void m9791a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RangesModel rangesModel = (RangesModel) obj;
                    if (rangesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(rangesModel.m9793a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    RangesParser.m9841b(rangesModel.w_(), rangesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(RangesModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesEntityFields m9794a() {
                return m9799j();
            }

            public RangesModel() {
                super(3);
            }

            public RangesModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final DefaultTextWithEntitiesEntityFieldsModel m9799j() {
                this.f4902d = (DefaultTextWithEntitiesEntityFieldsModel) super.a(this.f4902d, 0, DefaultTextWithEntitiesEntityFieldsModel.class);
                return this.f4902d;
            }

            public final int m9797b() {
                a(0, 1);
                return this.f4903e;
            }

            public final int m9798c() {
                a(0, 2);
                return this.f4904f;
            }

            public static RangesModel m9792a(Ranges ranges) {
                if (ranges == null) {
                    return null;
                }
                if (ranges instanceof RangesModel) {
                    return (RangesModel) ranges;
                }
                Builder builder = new Builder();
                builder.f4899a = DefaultTextWithEntitiesEntityFieldsModel.m9772a(ranges.a());
                builder.f4900b = ranges.b();
                builder.f4901c = ranges.c();
                return builder.m9789a();
            }

            public final int jK_() {
                return -1024511161;
            }

            public final GraphQLVisitableModel m9795a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9799j() != null) {
                    DefaultTextWithEntitiesEntityFieldsModel defaultTextWithEntitiesEntityFieldsModel = (DefaultTextWithEntitiesEntityFieldsModel) graphQLModelMutatingVisitor.b(m9799j());
                    if (m9799j() != defaultTextWithEntitiesEntityFieldsModel) {
                        graphQLVisitableModel = (RangesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4902d = defaultTextWithEntitiesEntityFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9793a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9799j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f4903e, 0);
                flatBufferBuilder.a(2, this.f4904f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m9796a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f4903e = mutableFlatBuffer.a(i, 1, 0);
                this.f4904f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public class Serializer extends JsonSerializer<DefaultTextWithEntitiesLongFieldsModel> {
            public final void m9800a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) obj;
                if (defaultTextWithEntitiesLongFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultTextWithEntitiesLongFieldsModel.m9802a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultTextWithEntitiesLongFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultTextWithEntitiesLongFieldsParser.m9844b(defaultTextWithEntitiesLongFieldsModel.w_(), defaultTextWithEntitiesLongFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(DefaultTextWithEntitiesLongFieldsModel.class, new Serializer());
            }
        }

        public DefaultTextWithEntitiesLongFieldsModel() {
            super(2);
        }

        public DefaultTextWithEntitiesLongFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<RangesModel> m9805b() {
            this.f4905d = super.a(this.f4905d, 0, RangesModel.class);
            return (ImmutableList) this.f4905d;
        }

        @Nullable
        public final String m9804a() {
            this.f4906e = super.a(this.f4906e, 1);
            return this.f4906e;
        }

        public static DefaultTextWithEntitiesLongFieldsModel m9801a(DefaultTextWithEntitiesLongFields defaultTextWithEntitiesLongFields) {
            if (defaultTextWithEntitiesLongFields == null) {
                return null;
            }
            if (defaultTextWithEntitiesLongFields instanceof DefaultTextWithEntitiesLongFieldsModel) {
                return (DefaultTextWithEntitiesLongFieldsModel) defaultTextWithEntitiesLongFields;
            }
            Builder builder = new Builder();
            com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
            for (int i = 0; i < defaultTextWithEntitiesLongFields.b().size(); i++) {
                builder2.c(RangesModel.m9792a((Ranges) defaultTextWithEntitiesLongFields.b().get(i)));
            }
            builder.f4897a = builder2.b();
            builder.f4898b = defaultTextWithEntitiesLongFields.a();
            return builder.m9787a();
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m9803a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9805b() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m9805b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (DefaultTextWithEntitiesLongFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4905d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9802a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9805b());
            int b = flatBufferBuilder.b(m9804a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -40449523)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: e4d338791e93269e82fbd5b665244019 */
    public final class DefaultTextWithEntitiesWithAggregatedRangesFieldsModel extends BaseModel implements DefaultTextWithEntitiesWithAggregatedRangesFields, GraphQLVisitableModel {
        @Nullable
        private List<AggregatedRangesModel> f4910d;
        @Nullable
        private List<RangesModel> f4911e;
        @Nullable
        private String f4912f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 817703281)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public final class AggregatedRangesModel extends BaseModel implements AggregatedRanges, GraphQLVisitableModel {
            private int f4907d;
            private int f4908e;
            private int f4909f;

            /* compiled from: e4d338791e93269e82fbd5b665244019 */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AggregatedRangesModel.class, new Deserializer());
                }

                public Object m9806a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AggregatedRangesParser.m9846b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object aggregatedRangesModel = new AggregatedRangesModel();
                    ((BaseModel) aggregatedRangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (aggregatedRangesModel instanceof Postprocessable) {
                        return ((Postprocessable) aggregatedRangesModel).a();
                    }
                    return aggregatedRangesModel;
                }
            }

            /* compiled from: e4d338791e93269e82fbd5b665244019 */
            public class Serializer extends JsonSerializer<AggregatedRangesModel> {
                public final void m9807a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AggregatedRangesModel aggregatedRangesModel = (AggregatedRangesModel) obj;
                    if (aggregatedRangesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(aggregatedRangesModel.m9809a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        aggregatedRangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AggregatedRangesParser.m9845a(aggregatedRangesModel.w_(), aggregatedRangesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AggregatedRangesModel.class, new Serializer());
                }
            }

            public AggregatedRangesModel() {
                super(3);
            }

            public final int m9808a() {
                a(0, 0);
                return this.f4907d;
            }

            public final int m9812b() {
                a(0, 1);
                return this.f4908e;
            }

            public final int m9813c() {
                a(0, 2);
                return this.f4909f;
            }

            public final int jK_() {
                return 1563462756;
            }

            public final GraphQLVisitableModel m9810a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9809a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f4907d, 0);
                flatBufferBuilder.a(1, this.f4908e, 0);
                flatBufferBuilder.a(2, this.f4909f, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m9811a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f4907d = mutableFlatBuffer.a(i, 0, 0);
                this.f4908e = mutableFlatBuffer.a(i, 1, 0);
                this.f4909f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultTextWithEntitiesWithAggregatedRangesFieldsModel.class, new Deserializer());
            }

            public Object m9814a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DefaultTextWithEntitiesWithAggregatedRangesFieldsParser.m9847a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object defaultTextWithEntitiesWithAggregatedRangesFieldsModel = new DefaultTextWithEntitiesWithAggregatedRangesFieldsModel();
                ((BaseModel) defaultTextWithEntitiesWithAggregatedRangesFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (defaultTextWithEntitiesWithAggregatedRangesFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultTextWithEntitiesWithAggregatedRangesFieldsModel).a();
                }
                return defaultTextWithEntitiesWithAggregatedRangesFieldsModel;
            }
        }

        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public class Serializer extends JsonSerializer<DefaultTextWithEntitiesWithAggregatedRangesFieldsModel> {
            public final void m9815a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                DefaultTextWithEntitiesWithAggregatedRangesFieldsModel defaultTextWithEntitiesWithAggregatedRangesFieldsModel = (DefaultTextWithEntitiesWithAggregatedRangesFieldsModel) obj;
                if (defaultTextWithEntitiesWithAggregatedRangesFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultTextWithEntitiesWithAggregatedRangesFieldsModel.m9816a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultTextWithEntitiesWithAggregatedRangesFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                DefaultTextWithEntitiesWithAggregatedRangesFieldsParser.m9848a(defaultTextWithEntitiesWithAggregatedRangesFieldsModel.w_(), defaultTextWithEntitiesWithAggregatedRangesFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(DefaultTextWithEntitiesWithAggregatedRangesFieldsModel.class, new Serializer());
            }
        }

        public DefaultTextWithEntitiesWithAggregatedRangesFieldsModel() {
            super(3);
        }

        @Nonnull
        public final ImmutableList<AggregatedRangesModel> m9820c() {
            this.f4910d = super.a(this.f4910d, 0, AggregatedRangesModel.class);
            return (ImmutableList) this.f4910d;
        }

        @Nonnull
        public final ImmutableList<RangesModel> m9819b() {
            this.f4911e = super.a(this.f4911e, 1, RangesModel.class);
            return (ImmutableList) this.f4911e;
        }

        @Nullable
        public final String m9818a() {
            this.f4912f = super.a(this.f4912f, 2);
            return this.f4912f;
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m9817a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9820c() != null) {
                a = ModelHelper.a(m9820c(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (DefaultTextWithEntitiesWithAggregatedRangesFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4910d = a.b();
                }
            }
            if (m9819b() != null) {
                a = ModelHelper.a(m9819b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (DefaultTextWithEntitiesWithAggregatedRangesFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4911e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9816a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9820c());
            int a2 = ModelHelper.a(flatBufferBuilder, m9819b());
            int b = flatBufferBuilder.b(m9818a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -873801115)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: e4d338791e93269e82fbd5b665244019 */
    public final class DefaultTextWithEntityRangesFieldsModel extends BaseModel implements DefaultTextWithEntityRangesFields, GraphQLVisitableModel {
        @Nullable
        private List<RangesModel> f4915d;
        @Nullable
        private String f4916e;

        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DefaultTextWithEntityRangesFieldsModel.class, new Deserializer());
            }

            public Object m9821a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = DefaultTextWithEntityRangesFieldsParser.m9853a(jsonParser);
                Object defaultTextWithEntityRangesFieldsModel = new DefaultTextWithEntityRangesFieldsModel();
                ((BaseModel) defaultTextWithEntityRangesFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (defaultTextWithEntityRangesFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) defaultTextWithEntityRangesFieldsModel).a();
                }
                return defaultTextWithEntityRangesFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 732242581)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public final class RangesModel extends BaseModel implements GraphQLVisitableModel {
            private int f4913d;
            private int f4914e;

            /* compiled from: e4d338791e93269e82fbd5b665244019 */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                }

                public Object m9822a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DefaultTextWithEntityRangesFieldsParser.RangesParser.m9852b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object rangesModel = new RangesModel();
                    ((BaseModel) rangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (rangesModel instanceof Postprocessable) {
                        return ((Postprocessable) rangesModel).a();
                    }
                    return rangesModel;
                }
            }

            /* compiled from: e4d338791e93269e82fbd5b665244019 */
            public class Serializer extends JsonSerializer<RangesModel> {
                public final void m9823a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    RangesModel rangesModel = (RangesModel) obj;
                    if (rangesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(rangesModel.m9824a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DefaultTextWithEntityRangesFieldsParser.RangesParser.m9850a(rangesModel.w_(), rangesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(RangesModel.class, new Serializer());
                }
            }

            public RangesModel() {
                super(2);
            }

            public final int jK_() {
                return -1024511161;
            }

            public final GraphQLVisitableModel m9825a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9824a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f4913d, 0);
                flatBufferBuilder.a(1, this.f4914e, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m9826a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f4913d = mutableFlatBuffer.a(i, 0, 0);
                this.f4914e = mutableFlatBuffer.a(i, 1, 0);
            }
        }

        /* compiled from: e4d338791e93269e82fbd5b665244019 */
        public class Serializer extends JsonSerializer<DefaultTextWithEntityRangesFieldsModel> {
            public final void m9827a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                DefaultTextWithEntityRangesFieldsModel defaultTextWithEntityRangesFieldsModel = (DefaultTextWithEntityRangesFieldsModel) obj;
                if (defaultTextWithEntityRangesFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(defaultTextWithEntityRangesFieldsModel.m9829a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    defaultTextWithEntityRangesFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = defaultTextWithEntityRangesFieldsModel.w_();
                int u_ = defaultTextWithEntityRangesFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("ranges");
                    DefaultTextWithEntityRangesFieldsParser.RangesParser.m9851a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("text");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(DefaultTextWithEntityRangesFieldsModel.class, new Serializer());
            }
        }

        public DefaultTextWithEntityRangesFieldsModel() {
            super(2);
        }

        @Nonnull
        private ImmutableList<RangesModel> m9828j() {
            this.f4915d = super.a(this.f4915d, 0, RangesModel.class);
            return (ImmutableList) this.f4915d;
        }

        @Nullable
        public final String m9831a() {
            this.f4916e = super.a(this.f4916e, 1);
            return this.f4916e;
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m9830a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9828j() != null) {
                Builder a = ModelHelper.a(m9828j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (DefaultTextWithEntityRangesFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4915d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9829a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9828j());
            int b = flatBufferBuilder.b(m9831a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}

package com.facebook.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feed.protocol.FetchTranslationsGraphQLParsers.TranslatedStoryMessageParser;
import com.facebook.feed.protocol.FetchTranslationsGraphQLParsers.TranslatedStoryMessageParser.TranslatabilityForViewerParser;
import com.facebook.feed.protocol.FetchTranslationsGraphQLParsers.TranslatedStoryMessageParser.TranslationMetadataParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
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

/* compiled from: min_aspect_ratio */
public class FetchTranslationsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1311208337)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: min_aspect_ratio */
    public final class TranslatedStoryMessageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f10339d;
        @Nullable
        private String f10340e;
        @Nullable
        private TranslatabilityForViewerModel f10341f;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f10342g;
        @Nullable
        private TranslationMetadataModel f10343h;

        /* compiled from: min_aspect_ratio */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TranslatedStoryMessageModel.class, new Deserializer());
            }

            public Object m16310a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TranslatedStoryMessageParser.m16350a(jsonParser);
                Object translatedStoryMessageModel = new TranslatedStoryMessageModel();
                ((BaseModel) translatedStoryMessageModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (translatedStoryMessageModel instanceof Postprocessable) {
                    return ((Postprocessable) translatedStoryMessageModel).a();
                }
                return translatedStoryMessageModel;
            }
        }

        /* compiled from: min_aspect_ratio */
        public class Serializer extends JsonSerializer<TranslatedStoryMessageModel> {
            public final void m16311a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TranslatedStoryMessageModel translatedStoryMessageModel = (TranslatedStoryMessageModel) obj;
                if (translatedStoryMessageModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(translatedStoryMessageModel.m16338a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    translatedStoryMessageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = translatedStoryMessageModel.w_();
                int u_ = translatedStoryMessageModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("translatability_for_viewer");
                    TranslatabilityForViewerParser.m16347a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("translated_message_for_viewer");
                    DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("translation_metadata");
                    TranslationMetadataParser.m16349a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TranslatedStoryMessageModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1711691574)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: min_aspect_ratio */
        public final class TranslatabilityForViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f10331d;
            @Nullable
            private String f10332e;
            @Nullable
            private String f10333f;
            @Nullable
            private String f10334g;
            @Nullable
            private TranslationMetadataModel f10335h;
            @Nullable
            private GraphQLTranslatabilityType f10336i;

            /* compiled from: min_aspect_ratio */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TranslatabilityForViewerModel.class, new Deserializer());
                }

                public Object m16312a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TranslatabilityForViewerParser.m16346a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object translatabilityForViewerModel = new TranslatabilityForViewerModel();
                    ((BaseModel) translatabilityForViewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (translatabilityForViewerModel instanceof Postprocessable) {
                        return ((Postprocessable) translatabilityForViewerModel).a();
                    }
                    return translatabilityForViewerModel;
                }
            }

            /* compiled from: min_aspect_ratio */
            public class Serializer extends JsonSerializer<TranslatabilityForViewerModel> {
                public final void m16313a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TranslatabilityForViewerModel translatabilityForViewerModel = (TranslatabilityForViewerModel) obj;
                    if (translatabilityForViewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(translatabilityForViewerModel.m16326a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        translatabilityForViewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TranslatabilityForViewerParser.m16347a(translatabilityForViewerModel.w_(), translatabilityForViewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(TranslatabilityForViewerModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1615039790)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: min_aspect_ratio */
            public final class TranslationMetadataModel extends BaseModel implements GraphQLVisitableModel {
                private int f10329d;
                @Nullable
                private String f10330e;

                /* compiled from: min_aspect_ratio */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TranslationMetadataModel.class, new Deserializer());
                    }

                    public Object m16314a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TranslatabilityForViewerParser.TranslationMetadataParser.m16344a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object translationMetadataModel = new TranslationMetadataModel();
                        ((BaseModel) translationMetadataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (translationMetadataModel instanceof Postprocessable) {
                            return ((Postprocessable) translationMetadataModel).a();
                        }
                        return translationMetadataModel;
                    }
                }

                /* compiled from: min_aspect_ratio */
                public class Serializer extends JsonSerializer<TranslationMetadataModel> {
                    public final void m16315a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TranslationMetadataModel translationMetadataModel = (TranslationMetadataModel) obj;
                        if (translationMetadataModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(translationMetadataModel.m16317a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            translationMetadataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TranslatabilityForViewerParser.TranslationMetadataParser.m16345a(translationMetadataModel.w_(), translationMetadataModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TranslationMetadataModel.class, new Serializer());
                    }
                }

                public TranslationMetadataModel() {
                    super(2);
                }

                @Nullable
                private String m16316a() {
                    this.f10330e = super.a(this.f10330e, 1);
                    return this.f10330e;
                }

                public final int jK_() {
                    return -1590309632;
                }

                public final GraphQLVisitableModel m16318a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16317a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m16316a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f10329d, 0);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m16319a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f10329d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            public TranslatabilityForViewerModel() {
                super(6);
            }

            @Nullable
            private String m16320a() {
                this.f10331d = super.a(this.f10331d, 0);
                return this.f10331d;
            }

            @Nullable
            private String m16321j() {
                this.f10332e = super.a(this.f10332e, 1);
                return this.f10332e;
            }

            @Nullable
            private String m16322k() {
                this.f10333f = super.a(this.f10333f, 2);
                return this.f10333f;
            }

            @Nullable
            private String m16323l() {
                this.f10334g = super.a(this.f10334g, 3);
                return this.f10334g;
            }

            @Nullable
            private TranslationMetadataModel m16324m() {
                this.f10335h = (TranslationMetadataModel) super.a(this.f10335h, 4, TranslationMetadataModel.class);
                return this.f10335h;
            }

            @Nullable
            private GraphQLTranslatabilityType m16325n() {
                this.f10336i = (GraphQLTranslatabilityType) super.b(this.f10336i, 5, GraphQLTranslatabilityType.class, GraphQLTranslatabilityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f10336i;
            }

            public final int jK_() {
                return -1681643917;
            }

            public final GraphQLVisitableModel m16327a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16324m() != null) {
                    TranslationMetadataModel translationMetadataModel = (TranslationMetadataModel) graphQLModelMutatingVisitor.b(m16324m());
                    if (m16324m() != translationMetadataModel) {
                        graphQLVisitableModel = (TranslatabilityForViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10335h = translationMetadataModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16326a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16320a());
                int b2 = flatBufferBuilder.b(m16321j());
                int b3 = flatBufferBuilder.b(m16322k());
                int b4 = flatBufferBuilder.b(m16323l());
                int a = ModelHelper.a(flatBufferBuilder, m16324m());
                int a2 = flatBufferBuilder.a(m16325n());
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.b(3, b4);
                flatBufferBuilder.b(4, a);
                flatBufferBuilder.b(5, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1615039790)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: min_aspect_ratio */
        public final class TranslationMetadataModel extends BaseModel implements GraphQLVisitableModel {
            private int f10337d;
            @Nullable
            private String f10338e;

            /* compiled from: min_aspect_ratio */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(TranslationMetadataModel.class, new Deserializer());
                }

                public Object m16328a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TranslationMetadataParser.m16348a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object translationMetadataModel = new TranslationMetadataModel();
                    ((BaseModel) translationMetadataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (translationMetadataModel instanceof Postprocessable) {
                        return ((Postprocessable) translationMetadataModel).a();
                    }
                    return translationMetadataModel;
                }
            }

            /* compiled from: min_aspect_ratio */
            public class Serializer extends JsonSerializer<TranslationMetadataModel> {
                public final void m16329a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    TranslationMetadataModel translationMetadataModel = (TranslationMetadataModel) obj;
                    if (translationMetadataModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(translationMetadataModel.m16331a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        translationMetadataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TranslationMetadataParser.m16349a(translationMetadataModel.w_(), translationMetadataModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(TranslationMetadataModel.class, new Serializer());
                }
            }

            public TranslationMetadataModel() {
                super(2);
            }

            @Nullable
            private String m16330a() {
                this.f10338e = super.a(this.f10338e, 1);
                return this.f10338e;
            }

            public final int jK_() {
                return -1590309632;
            }

            public final GraphQLVisitableModel m16332a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16331a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16330a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f10337d, 0);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16333a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f10337d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        public TranslatedStoryMessageModel() {
            super(5);
        }

        public final void m16341a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16342a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m16334k() {
            if (this.b != null && this.f10339d == null) {
                this.f10339d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f10339d;
        }

        @Nullable
        private String m16335l() {
            this.f10340e = super.a(this.f10340e, 1);
            return this.f10340e;
        }

        @Nullable
        private TranslatabilityForViewerModel m16336m() {
            this.f10341f = (TranslatabilityForViewerModel) super.a(this.f10341f, 2, TranslatabilityForViewerModel.class);
            return this.f10341f;
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m16343j() {
            this.f10342g = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f10342g, 3, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f10342g;
        }

        @Nullable
        private TranslationMetadataModel m16337n() {
            this.f10343h = (TranslationMetadataModel) super.a(this.f10343h, 4, TranslationMetadataModel.class);
            return this.f10343h;
        }

        @Nullable
        public final String m16340a() {
            return m16335l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m16339a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16336m() != null) {
                TranslatabilityForViewerModel translatabilityForViewerModel = (TranslatabilityForViewerModel) graphQLModelMutatingVisitor.b(m16336m());
                if (m16336m() != translatabilityForViewerModel) {
                    graphQLVisitableModel = (TranslatedStoryMessageModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10341f = translatabilityForViewerModel;
                }
            }
            if (m16343j() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m16343j());
                if (m16343j() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (TranslatedStoryMessageModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10342g = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m16337n() != null) {
                TranslationMetadataModel translationMetadataModel = (TranslationMetadataModel) graphQLModelMutatingVisitor.b(m16337n());
                if (m16337n() != translationMetadataModel) {
                    graphQLVisitableModel = (TranslatedStoryMessageModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10343h = translationMetadataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16338a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16334k());
            int b = flatBufferBuilder.b(m16335l());
            int a2 = ModelHelper.a(flatBufferBuilder, m16336m());
            int a3 = ModelHelper.a(flatBufferBuilder, m16343j());
            int a4 = ModelHelper.a(flatBufferBuilder, m16337n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, a4);
            i();
            return flatBufferBuilder.d();
        }
    }
}

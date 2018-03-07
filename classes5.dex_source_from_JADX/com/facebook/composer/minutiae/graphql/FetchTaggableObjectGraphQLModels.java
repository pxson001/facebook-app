package com.facebook.composer.minutiae.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLParsers.FetchSingleTaggableSuggestionQueryParser;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLParsers.FetchTaggableObjectsQueryParser;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLParsers.FetchTaggableSuggestionsAtPlaceQueryParser;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLParsers.MinutiaeTaggableObjectsParser;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLParsers.TaggableObjectEdgeParser;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLParsers.TaggableObjectEdgeParser.AssociatedPlacesInfoParser;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLParsers.TaggableObjectEdgeParser.IconParser;
import com.facebook.composer.minutiae.graphql.FetchTaggableObjectGraphQLParsers.TaggableObjectEdgeParser.SubtextParser;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivity;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLInterfaces.MinutiaeTaggableActivityPreviewTemplateFields;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeIconModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaePreviewTemplateModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityFieldsModel.GlyphModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityFieldsModel.IconImageLargeModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel.AllIconsModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableObjectFieldsModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLParsers.MinutiaePreviewTemplateParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCheckinPlaceResultsContext;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultPageInfoTailFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoTailFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
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
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: admin_aware_group */
public class FetchTaggableObjectGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1703611639)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: admin_aware_group */
    public final class FetchSingleTaggableSuggestionQueryModel extends BaseModel implements MinutiaeTaggableActivity, GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private AllIconsModel f11259d;
        @Nullable
        private GlyphModel f11260e;
        @Nullable
        private IconImageLargeModel f11261f;
        @Nullable
        private String f11262g;
        private boolean f11263h;
        @Nullable
        private String f11264i;
        private int f11265j;
        @Nullable
        private String f11266k;
        @Nullable
        private MinutiaePreviewTemplateModel f11267l;
        @Nullable
        private MinutiaePreviewTemplateModel f11268m;
        @Nullable
        private MinutiaePreviewTemplateModel f11269n;
        @Nullable
        private MinutiaePreviewTemplateModel f11270o;
        @Nullable
        private MinutiaePreviewTemplateModel f11271p;
        @Nullable
        private MinutiaePreviewTemplateModel f11272q;
        @Nullable
        private String f11273r;
        private boolean f11274s;
        private boolean f11275t;
        private boolean f11276u;
        @Nullable
        private MinutiaeTaggableObjectsModel f11277v;

        /* compiled from: admin_aware_group */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchSingleTaggableSuggestionQueryModel.class, new Deserializer());
            }

            public Object m19204a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchSingleTaggableSuggestionQueryParser.m19339a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchSingleTaggableSuggestionQueryModel = new FetchSingleTaggableSuggestionQueryModel();
                ((BaseModel) fetchSingleTaggableSuggestionQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchSingleTaggableSuggestionQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchSingleTaggableSuggestionQueryModel).a();
                }
                return fetchSingleTaggableSuggestionQueryModel;
            }
        }

        /* compiled from: admin_aware_group */
        public class Serializer extends JsonSerializer<FetchSingleTaggableSuggestionQueryModel> {
            public final void m19205a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FetchSingleTaggableSuggestionQueryModel fetchSingleTaggableSuggestionQueryModel = (FetchSingleTaggableSuggestionQueryModel) obj;
                if (fetchSingleTaggableSuggestionQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchSingleTaggableSuggestionQueryModel.m19217a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchSingleTaggableSuggestionQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FetchSingleTaggableSuggestionQueryParser.m19340a(fetchSingleTaggableSuggestionQueryModel.w_(), fetchSingleTaggableSuggestionQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FetchSingleTaggableSuggestionQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ GlyphModel mo1191A() {
            return m19207D();
        }

        @Nullable
        public final /* synthetic */ AllIconsModel mo1192B() {
            return m19206C();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1185t() {
            return m19214K();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1186u() {
            return m19213J();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1187v() {
            return m19212I();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1188w() {
            return m19211H();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1189x() {
            return m19210G();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1190y() {
            return m19209F();
        }

        @Nullable
        public final /* synthetic */ IconImageLargeModel mo1202z() {
            return m19208E();
        }

        public FetchSingleTaggableSuggestionQueryModel() {
            super(19);
        }

        @Nullable
        private AllIconsModel m19206C() {
            this.f11259d = (AllIconsModel) super.a(this.f11259d, 0, AllIconsModel.class);
            return this.f11259d;
        }

        @Nullable
        private GlyphModel m19207D() {
            this.f11260e = (GlyphModel) super.a(this.f11260e, 1, GlyphModel.class);
            return this.f11260e;
        }

        @Nullable
        private IconImageLargeModel m19208E() {
            this.f11261f = (IconImageLargeModel) super.a(this.f11261f, 2, IconImageLargeModel.class);
            return this.f11261f;
        }

        @Nullable
        public final String mo1193j() {
            this.f11262g = super.a(this.f11262g, 3);
            return this.f11262g;
        }

        public final boolean mo1194k() {
            a(0, 4);
            return this.f11263h;
        }

        @Nullable
        public final String mo1195l() {
            this.f11264i = super.a(this.f11264i, 5);
            return this.f11264i;
        }

        public final int mo1196m() {
            a(0, 6);
            return this.f11265j;
        }

        @Nullable
        public final String mo1197n() {
            this.f11266k = super.a(this.f11266k, 7);
            return this.f11266k;
        }

        @Nullable
        private MinutiaePreviewTemplateModel m19209F() {
            this.f11267l = (MinutiaePreviewTemplateModel) super.a(this.f11267l, 8, MinutiaePreviewTemplateModel.class);
            return this.f11267l;
        }

        @Nullable
        private MinutiaePreviewTemplateModel m19210G() {
            this.f11268m = (MinutiaePreviewTemplateModel) super.a(this.f11268m, 9, MinutiaePreviewTemplateModel.class);
            return this.f11268m;
        }

        @Nullable
        private MinutiaePreviewTemplateModel m19211H() {
            this.f11269n = (MinutiaePreviewTemplateModel) super.a(this.f11269n, 10, MinutiaePreviewTemplateModel.class);
            return this.f11269n;
        }

        @Nullable
        private MinutiaePreviewTemplateModel m19212I() {
            this.f11270o = (MinutiaePreviewTemplateModel) super.a(this.f11270o, 11, MinutiaePreviewTemplateModel.class);
            return this.f11270o;
        }

        @Nullable
        private MinutiaePreviewTemplateModel m19213J() {
            this.f11271p = (MinutiaePreviewTemplateModel) super.a(this.f11271p, 12, MinutiaePreviewTemplateModel.class);
            return this.f11271p;
        }

        @Nullable
        private MinutiaePreviewTemplateModel m19214K() {
            this.f11272q = (MinutiaePreviewTemplateModel) super.a(this.f11272q, 13, MinutiaePreviewTemplateModel.class);
            return this.f11272q;
        }

        @Nullable
        public final String mo1198o() {
            this.f11273r = super.a(this.f11273r, 14);
            return this.f11273r;
        }

        public final boolean mo1199p() {
            a(1, 7);
            return this.f11274s;
        }

        public final boolean mo1200q() {
            a(2, 0);
            return this.f11275t;
        }

        public final boolean mo1201r() {
            a(2, 1);
            return this.f11276u;
        }

        @Nullable
        public final MinutiaeTaggableObjectsModel m19230s() {
            this.f11277v = (MinutiaeTaggableObjectsModel) super.a(this.f11277v, 18, MinutiaeTaggableObjectsModel.class);
            return this.f11277v;
        }

        @Nullable
        public final String m19219a() {
            return mo1193j();
        }

        public final int jK_() {
            return -934090;
        }

        public final GraphQLVisitableModel m19218a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            MinutiaePreviewTemplateModel minutiaePreviewTemplateModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19206C() != null) {
                AllIconsModel allIconsModel = (AllIconsModel) graphQLModelMutatingVisitor.b(m19206C());
                if (m19206C() != allIconsModel) {
                    graphQLVisitableModel = (FetchSingleTaggableSuggestionQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11259d = allIconsModel;
                }
            }
            if (m19207D() != null) {
                GlyphModel glyphModel = (GlyphModel) graphQLModelMutatingVisitor.b(m19207D());
                if (m19207D() != glyphModel) {
                    graphQLVisitableModel = (FetchSingleTaggableSuggestionQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11260e = glyphModel;
                }
            }
            if (m19208E() != null) {
                IconImageLargeModel iconImageLargeModel = (IconImageLargeModel) graphQLModelMutatingVisitor.b(m19208E());
                if (m19208E() != iconImageLargeModel) {
                    graphQLVisitableModel = (FetchSingleTaggableSuggestionQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11261f = iconImageLargeModel;
                }
            }
            if (m19209F() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19209F());
                if (m19209F() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchSingleTaggableSuggestionQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11267l = minutiaePreviewTemplateModel;
                }
            }
            if (m19210G() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19210G());
                if (m19210G() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchSingleTaggableSuggestionQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11268m = minutiaePreviewTemplateModel;
                }
            }
            if (m19211H() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19211H());
                if (m19211H() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchSingleTaggableSuggestionQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11269n = minutiaePreviewTemplateModel;
                }
            }
            if (m19212I() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19212I());
                if (m19212I() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchSingleTaggableSuggestionQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11270o = minutiaePreviewTemplateModel;
                }
            }
            if (m19213J() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19213J());
                if (m19213J() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchSingleTaggableSuggestionQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11271p = minutiaePreviewTemplateModel;
                }
            }
            if (m19214K() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19214K());
                if (m19214K() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchSingleTaggableSuggestionQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11272q = minutiaePreviewTemplateModel;
                }
            }
            if (m19230s() != null) {
                MinutiaeTaggableObjectsModel minutiaeTaggableObjectsModel = (MinutiaeTaggableObjectsModel) graphQLModelMutatingVisitor.b(m19230s());
                if (m19230s() != minutiaeTaggableObjectsModel) {
                    graphQLVisitableModel = (FetchSingleTaggableSuggestionQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11277v = minutiaeTaggableObjectsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19217a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19206C());
            int a2 = ModelHelper.a(flatBufferBuilder, m19207D());
            int a3 = ModelHelper.a(flatBufferBuilder, m19208E());
            int b = flatBufferBuilder.b(mo1193j());
            int b2 = flatBufferBuilder.b(mo1195l());
            int b3 = flatBufferBuilder.b(mo1197n());
            int a4 = ModelHelper.a(flatBufferBuilder, m19209F());
            int a5 = ModelHelper.a(flatBufferBuilder, m19210G());
            int a6 = ModelHelper.a(flatBufferBuilder, m19211H());
            int a7 = ModelHelper.a(flatBufferBuilder, m19212I());
            int a8 = ModelHelper.a(flatBufferBuilder, m19213J());
            int a9 = ModelHelper.a(flatBufferBuilder, m19214K());
            int b4 = flatBufferBuilder.b(mo1198o());
            int a10 = ModelHelper.a(flatBufferBuilder, m19230s());
            flatBufferBuilder.c(19);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.a(4, this.f11263h);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.a(6, this.f11265j, 0);
            flatBufferBuilder.b(7, b3);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, a5);
            flatBufferBuilder.b(10, a6);
            flatBufferBuilder.b(11, a7);
            flatBufferBuilder.b(12, a8);
            flatBufferBuilder.b(13, a9);
            flatBufferBuilder.b(14, b4);
            flatBufferBuilder.a(15, this.f11274s);
            flatBufferBuilder.a(16, this.f11275t);
            flatBufferBuilder.a(17, this.f11276u);
            flatBufferBuilder.b(18, a10);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19220a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f11263h = mutableFlatBuffer.a(i, 4);
            this.f11265j = mutableFlatBuffer.a(i, 6, 0);
            this.f11274s = mutableFlatBuffer.a(i, 15);
            this.f11275t = mutableFlatBuffer.a(i, 16);
            this.f11276u = mutableFlatBuffer.a(i, 17);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -212894630)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: admin_aware_group */
    public final class FetchTaggableObjectsQueryModel extends BaseModel implements MinutiaeTaggableActivityPreviewTemplateFields, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f11278d;
        @Nullable
        private DefaultImageFieldsModel f11279e;
        @Nullable
        private MinutiaePreviewTemplateModel f11280f;
        @Nullable
        private MinutiaePreviewTemplateModel f11281g;
        @Nullable
        private MinutiaePreviewTemplateModel f11282h;
        @Nullable
        private MinutiaePreviewTemplateModel f11283i;
        @Nullable
        private MinutiaePreviewTemplateModel f11284j;
        @Nullable
        private MinutiaePreviewTemplateModel f11285k;
        @Nullable
        private MinutiaeTaggableObjectsModel f11286l;

        /* compiled from: admin_aware_group */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchTaggableObjectsQueryModel.class, new Deserializer());
            }

            public Object m19238a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchTaggableObjectsQueryParser.m19341a(jsonParser);
                Object fetchTaggableObjectsQueryModel = new FetchTaggableObjectsQueryModel();
                ((BaseModel) fetchTaggableObjectsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchTaggableObjectsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchTaggableObjectsQueryModel).a();
                }
                return fetchTaggableObjectsQueryModel;
            }
        }

        /* compiled from: admin_aware_group */
        public class Serializer extends JsonSerializer<FetchTaggableObjectsQueryModel> {
            public final void m19239a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchTaggableObjectsQueryModel fetchTaggableObjectsQueryModel = (FetchTaggableObjectsQueryModel) obj;
                if (fetchTaggableObjectsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchTaggableObjectsQueryModel.m19241a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchTaggableObjectsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchTaggableObjectsQueryModel.w_();
                int u_ = fetchTaggableObjectsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("iconImageLarge");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("previewTemplateAtPlace");
                    MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("previewTemplateNoTags");
                    MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("previewTemplateWithPeople");
                    MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("previewTemplateWithPeopleAtPlace");
                    MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("previewTemplateWithPerson");
                    MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 7);
                if (g != 0) {
                    jsonGenerator.a("previewTemplateWithPersonAtPlace");
                    MinutiaePreviewTemplateParser.m19518a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 8);
                if (g != 0) {
                    jsonGenerator.a("taggable_activity_suggestions");
                    MinutiaeTaggableObjectsParser.m19345a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchTaggableObjectsQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1185t() {
            return m19251o();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1186u() {
            return m19250n();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1187v() {
            return m19249m();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1188w() {
            return m19248l();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1189x() {
            return m19247k();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1190y() {
            return m19246j();
        }

        public FetchTaggableObjectsQueryModel() {
            super(9);
        }

        public final void m19244a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m19245a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m19240q() {
            if (this.b != null && this.f11278d == null) {
                this.f11278d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f11278d;
        }

        @Nullable
        public final DefaultImageFieldsModel m19242a() {
            this.f11279e = (DefaultImageFieldsModel) super.a(this.f11279e, 1, DefaultImageFieldsModel.class);
            return this.f11279e;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19246j() {
            this.f11280f = (MinutiaePreviewTemplateModel) super.a(this.f11280f, 2, MinutiaePreviewTemplateModel.class);
            return this.f11280f;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19247k() {
            this.f11281g = (MinutiaePreviewTemplateModel) super.a(this.f11281g, 3, MinutiaePreviewTemplateModel.class);
            return this.f11281g;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19248l() {
            this.f11282h = (MinutiaePreviewTemplateModel) super.a(this.f11282h, 4, MinutiaePreviewTemplateModel.class);
            return this.f11282h;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19249m() {
            this.f11283i = (MinutiaePreviewTemplateModel) super.a(this.f11283i, 5, MinutiaePreviewTemplateModel.class);
            return this.f11283i;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19250n() {
            this.f11284j = (MinutiaePreviewTemplateModel) super.a(this.f11284j, 6, MinutiaePreviewTemplateModel.class);
            return this.f11284j;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19251o() {
            this.f11285k = (MinutiaePreviewTemplateModel) super.a(this.f11285k, 7, MinutiaePreviewTemplateModel.class);
            return this.f11285k;
        }

        @Nullable
        public final MinutiaeTaggableObjectsModel m19252p() {
            this.f11286l = (MinutiaeTaggableObjectsModel) super.a(this.f11286l, 8, MinutiaeTaggableObjectsModel.class);
            return this.f11286l;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m19243a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            MinutiaePreviewTemplateModel minutiaePreviewTemplateModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19242a() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m19242a());
                if (m19242a() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FetchTaggableObjectsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11279e = defaultImageFieldsModel;
                }
            }
            if (m19246j() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19246j());
                if (m19246j() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchTaggableObjectsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11280f = minutiaePreviewTemplateModel;
                }
            }
            if (m19247k() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19247k());
                if (m19247k() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchTaggableObjectsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11281g = minutiaePreviewTemplateModel;
                }
            }
            if (m19248l() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19248l());
                if (m19248l() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchTaggableObjectsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11282h = minutiaePreviewTemplateModel;
                }
            }
            if (m19249m() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19249m());
                if (m19249m() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchTaggableObjectsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11283i = minutiaePreviewTemplateModel;
                }
            }
            if (m19250n() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19250n());
                if (m19250n() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchTaggableObjectsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11284j = minutiaePreviewTemplateModel;
                }
            }
            if (m19251o() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19251o());
                if (m19251o() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchTaggableObjectsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11285k = minutiaePreviewTemplateModel;
                }
            }
            if (m19252p() != null) {
                MinutiaeTaggableObjectsModel minutiaeTaggableObjectsModel = (MinutiaeTaggableObjectsModel) graphQLModelMutatingVisitor.b(m19252p());
                if (m19252p() != minutiaeTaggableObjectsModel) {
                    graphQLVisitableModel = (FetchTaggableObjectsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11286l = minutiaeTaggableObjectsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19241a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19240q());
            int a2 = ModelHelper.a(flatBufferBuilder, m19242a());
            int a3 = ModelHelper.a(flatBufferBuilder, m19246j());
            int a4 = ModelHelper.a(flatBufferBuilder, m19247k());
            int a5 = ModelHelper.a(flatBufferBuilder, m19248l());
            int a6 = ModelHelper.a(flatBufferBuilder, m19249m());
            int a7 = ModelHelper.a(flatBufferBuilder, m19250n());
            int a8 = ModelHelper.a(flatBufferBuilder, m19251o());
            int a9 = ModelHelper.a(flatBufferBuilder, m19252p());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            flatBufferBuilder.b(6, a7);
            flatBufferBuilder.b(7, a8);
            flatBufferBuilder.b(8, a9);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1703611639)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: admin_aware_group */
    public final class FetchTaggableSuggestionsAtPlaceQueryModel extends BaseModel implements MinutiaeTaggableActivity, GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private AllIconsModel f11306d;
        @Nullable
        private GlyphModel f11307e;
        @Nullable
        private IconImageLargeModel f11308f;
        @Nullable
        private String f11309g;
        private boolean f11310h;
        @Nullable
        private String f11311i;
        private int f11312j;
        @Nullable
        private String f11313k;
        @Nullable
        private MinutiaePreviewTemplateModel f11314l;
        @Nullable
        private MinutiaePreviewTemplateModel f11315m;
        @Nullable
        private MinutiaePreviewTemplateModel f11316n;
        @Nullable
        private MinutiaePreviewTemplateModel f11317o;
        @Nullable
        private MinutiaePreviewTemplateModel f11318p;
        @Nullable
        private MinutiaePreviewTemplateModel f11319q;
        @Nullable
        private String f11320r;
        private boolean f11321s;
        private boolean f11322t;
        private boolean f11323u;
        @Nullable
        private MinutiaeTaggableObjectsModel f11324v;

        /* compiled from: admin_aware_group */
        public final class Builder {
            @Nullable
            public AllIconsModel f11287a;
            @Nullable
            public GlyphModel f11288b;
            @Nullable
            public IconImageLargeModel f11289c;
            @Nullable
            public String f11290d;
            public boolean f11291e;
            @Nullable
            public String f11292f;
            public int f11293g;
            @Nullable
            public String f11294h;
            @Nullable
            public MinutiaePreviewTemplateModel f11295i;
            @Nullable
            public MinutiaePreviewTemplateModel f11296j;
            @Nullable
            public MinutiaePreviewTemplateModel f11297k;
            @Nullable
            public MinutiaePreviewTemplateModel f11298l;
            @Nullable
            public MinutiaePreviewTemplateModel f11299m;
            @Nullable
            public MinutiaePreviewTemplateModel f11300n;
            @Nullable
            public String f11301o;
            public boolean f11302p;
            public boolean f11303q;
            public boolean f11304r;
            @Nullable
            public MinutiaeTaggableObjectsModel f11305s;

            public final FetchTaggableSuggestionsAtPlaceQueryModel m19259a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f11287a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f11288b);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f11289c);
                int b = flatBufferBuilder.b(this.f11290d);
                int b2 = flatBufferBuilder.b(this.f11292f);
                int b3 = flatBufferBuilder.b(this.f11294h);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f11295i);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f11296j);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f11297k);
                int a7 = ModelHelper.a(flatBufferBuilder, this.f11298l);
                int a8 = ModelHelper.a(flatBufferBuilder, this.f11299m);
                int a9 = ModelHelper.a(flatBufferBuilder, this.f11300n);
                int b4 = flatBufferBuilder.b(this.f11301o);
                int a10 = ModelHelper.a(flatBufferBuilder, this.f11305s);
                flatBufferBuilder.c(19);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.a(4, this.f11291e);
                flatBufferBuilder.b(5, b2);
                flatBufferBuilder.a(6, this.f11293g, 0);
                flatBufferBuilder.b(7, b3);
                flatBufferBuilder.b(8, a4);
                flatBufferBuilder.b(9, a5);
                flatBufferBuilder.b(10, a6);
                flatBufferBuilder.b(11, a7);
                flatBufferBuilder.b(12, a8);
                flatBufferBuilder.b(13, a9);
                flatBufferBuilder.b(14, b4);
                flatBufferBuilder.a(15, this.f11302p);
                flatBufferBuilder.a(16, this.f11303q);
                flatBufferBuilder.a(17, this.f11304r);
                flatBufferBuilder.b(18, a10);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FetchTaggableSuggestionsAtPlaceQueryModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: admin_aware_group */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchTaggableSuggestionsAtPlaceQueryModel.class, new Deserializer());
            }

            public Object m19260a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FetchTaggableSuggestionsAtPlaceQueryParser.m19342a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fetchTaggableSuggestionsAtPlaceQueryModel = new FetchTaggableSuggestionsAtPlaceQueryModel();
                ((BaseModel) fetchTaggableSuggestionsAtPlaceQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fetchTaggableSuggestionsAtPlaceQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchTaggableSuggestionsAtPlaceQueryModel).a();
                }
                return fetchTaggableSuggestionsAtPlaceQueryModel;
            }
        }

        /* compiled from: admin_aware_group */
        public class Serializer extends JsonSerializer<FetchTaggableSuggestionsAtPlaceQueryModel> {
            public final void m19261a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FetchTaggableSuggestionsAtPlaceQueryModel fetchTaggableSuggestionsAtPlaceQueryModel = (FetchTaggableSuggestionsAtPlaceQueryModel) obj;
                if (fetchTaggableSuggestionsAtPlaceQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchTaggableSuggestionsAtPlaceQueryModel.m19273a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchTaggableSuggestionsAtPlaceQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FetchTaggableSuggestionsAtPlaceQueryParser.m19343a(fetchTaggableSuggestionsAtPlaceQueryModel.w_(), fetchTaggableSuggestionsAtPlaceQueryModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FetchTaggableSuggestionsAtPlaceQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ GlyphModel mo1191A() {
            return m19264C();
        }

        @Nullable
        public final /* synthetic */ AllIconsModel mo1192B() {
            return m19286s();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1185t() {
            return m19271J();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1186u() {
            return m19270I();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1187v() {
            return m19269H();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1188w() {
            return m19268G();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1189x() {
            return m19267F();
        }

        @Nullable
        public final /* synthetic */ MinutiaePreviewTemplateModel mo1190y() {
            return m19266E();
        }

        @Nullable
        public final /* synthetic */ IconImageLargeModel mo1202z() {
            return m19265D();
        }

        public FetchTaggableSuggestionsAtPlaceQueryModel() {
            super(19);
        }

        public FetchTaggableSuggestionsAtPlaceQueryModel(MutableFlatBuffer mutableFlatBuffer) {
            super(19);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final AllIconsModel m19286s() {
            this.f11306d = (AllIconsModel) super.a(this.f11306d, 0, AllIconsModel.class);
            return this.f11306d;
        }

        @Nullable
        public final GlyphModel m19264C() {
            this.f11307e = (GlyphModel) super.a(this.f11307e, 1, GlyphModel.class);
            return this.f11307e;
        }

        @Nullable
        public final IconImageLargeModel m19265D() {
            this.f11308f = (IconImageLargeModel) super.a(this.f11308f, 2, IconImageLargeModel.class);
            return this.f11308f;
        }

        @Nullable
        public final String mo1193j() {
            this.f11309g = super.a(this.f11309g, 3);
            return this.f11309g;
        }

        public final boolean mo1194k() {
            a(0, 4);
            return this.f11310h;
        }

        @Nullable
        public final String mo1195l() {
            this.f11311i = super.a(this.f11311i, 5);
            return this.f11311i;
        }

        public final int mo1196m() {
            a(0, 6);
            return this.f11312j;
        }

        @Nullable
        public final String mo1197n() {
            this.f11313k = super.a(this.f11313k, 7);
            return this.f11313k;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19266E() {
            this.f11314l = (MinutiaePreviewTemplateModel) super.a(this.f11314l, 8, MinutiaePreviewTemplateModel.class);
            return this.f11314l;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19267F() {
            this.f11315m = (MinutiaePreviewTemplateModel) super.a(this.f11315m, 9, MinutiaePreviewTemplateModel.class);
            return this.f11315m;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19268G() {
            this.f11316n = (MinutiaePreviewTemplateModel) super.a(this.f11316n, 10, MinutiaePreviewTemplateModel.class);
            return this.f11316n;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19269H() {
            this.f11317o = (MinutiaePreviewTemplateModel) super.a(this.f11317o, 11, MinutiaePreviewTemplateModel.class);
            return this.f11317o;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19270I() {
            this.f11318p = (MinutiaePreviewTemplateModel) super.a(this.f11318p, 12, MinutiaePreviewTemplateModel.class);
            return this.f11318p;
        }

        @Nullable
        public final MinutiaePreviewTemplateModel m19271J() {
            this.f11319q = (MinutiaePreviewTemplateModel) super.a(this.f11319q, 13, MinutiaePreviewTemplateModel.class);
            return this.f11319q;
        }

        @Nullable
        public final String mo1198o() {
            this.f11320r = super.a(this.f11320r, 14);
            return this.f11320r;
        }

        public final boolean mo1199p() {
            a(1, 7);
            return this.f11321s;
        }

        public final boolean mo1200q() {
            a(2, 0);
            return this.f11322t;
        }

        public final boolean mo1201r() {
            a(2, 1);
            return this.f11323u;
        }

        @Nullable
        public final MinutiaeTaggableObjectsModel m19272K() {
            this.f11324v = (MinutiaeTaggableObjectsModel) super.a(this.f11324v, 18, MinutiaeTaggableObjectsModel.class);
            return this.f11324v;
        }

        @Nullable
        public final String m19275a() {
            return mo1193j();
        }

        public final int jK_() {
            return -934090;
        }

        public final GraphQLVisitableModel m19274a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            MinutiaePreviewTemplateModel minutiaePreviewTemplateModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19286s() != null) {
                AllIconsModel allIconsModel = (AllIconsModel) graphQLModelMutatingVisitor.b(m19286s());
                if (m19286s() != allIconsModel) {
                    graphQLVisitableModel = (FetchTaggableSuggestionsAtPlaceQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11306d = allIconsModel;
                }
            }
            if (m19264C() != null) {
                GlyphModel glyphModel = (GlyphModel) graphQLModelMutatingVisitor.b(m19264C());
                if (m19264C() != glyphModel) {
                    graphQLVisitableModel = (FetchTaggableSuggestionsAtPlaceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11307e = glyphModel;
                }
            }
            if (m19265D() != null) {
                IconImageLargeModel iconImageLargeModel = (IconImageLargeModel) graphQLModelMutatingVisitor.b(m19265D());
                if (m19265D() != iconImageLargeModel) {
                    graphQLVisitableModel = (FetchTaggableSuggestionsAtPlaceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11308f = iconImageLargeModel;
                }
            }
            if (m19266E() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19266E());
                if (m19266E() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchTaggableSuggestionsAtPlaceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11314l = minutiaePreviewTemplateModel;
                }
            }
            if (m19267F() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19267F());
                if (m19267F() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchTaggableSuggestionsAtPlaceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11315m = minutiaePreviewTemplateModel;
                }
            }
            if (m19268G() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19268G());
                if (m19268G() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchTaggableSuggestionsAtPlaceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11316n = minutiaePreviewTemplateModel;
                }
            }
            if (m19269H() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19269H());
                if (m19269H() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchTaggableSuggestionsAtPlaceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11317o = minutiaePreviewTemplateModel;
                }
            }
            if (m19270I() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19270I());
                if (m19270I() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchTaggableSuggestionsAtPlaceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11318p = minutiaePreviewTemplateModel;
                }
            }
            if (m19271J() != null) {
                minutiaePreviewTemplateModel = (MinutiaePreviewTemplateModel) graphQLModelMutatingVisitor.b(m19271J());
                if (m19271J() != minutiaePreviewTemplateModel) {
                    graphQLVisitableModel = (FetchTaggableSuggestionsAtPlaceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11319q = minutiaePreviewTemplateModel;
                }
            }
            if (m19272K() != null) {
                MinutiaeTaggableObjectsModel minutiaeTaggableObjectsModel = (MinutiaeTaggableObjectsModel) graphQLModelMutatingVisitor.b(m19272K());
                if (m19272K() != minutiaeTaggableObjectsModel) {
                    graphQLVisitableModel = (FetchTaggableSuggestionsAtPlaceQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11324v = minutiaeTaggableObjectsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19273a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19286s());
            int a2 = ModelHelper.a(flatBufferBuilder, m19264C());
            int a3 = ModelHelper.a(flatBufferBuilder, m19265D());
            int b = flatBufferBuilder.b(mo1193j());
            int b2 = flatBufferBuilder.b(mo1195l());
            int b3 = flatBufferBuilder.b(mo1197n());
            int a4 = ModelHelper.a(flatBufferBuilder, m19266E());
            int a5 = ModelHelper.a(flatBufferBuilder, m19267F());
            int a6 = ModelHelper.a(flatBufferBuilder, m19268G());
            int a7 = ModelHelper.a(flatBufferBuilder, m19269H());
            int a8 = ModelHelper.a(flatBufferBuilder, m19270I());
            int a9 = ModelHelper.a(flatBufferBuilder, m19271J());
            int b4 = flatBufferBuilder.b(mo1198o());
            int a10 = ModelHelper.a(flatBufferBuilder, m19272K());
            flatBufferBuilder.c(19);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.a(4, this.f11310h);
            flatBufferBuilder.b(5, b2);
            flatBufferBuilder.a(6, this.f11312j, 0);
            flatBufferBuilder.b(7, b3);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, a5);
            flatBufferBuilder.b(10, a6);
            flatBufferBuilder.b(11, a7);
            flatBufferBuilder.b(12, a8);
            flatBufferBuilder.b(13, a9);
            flatBufferBuilder.b(14, b4);
            flatBufferBuilder.a(15, this.f11321s);
            flatBufferBuilder.a(16, this.f11322t);
            flatBufferBuilder.a(17, this.f11323u);
            flatBufferBuilder.b(18, a10);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19276a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f11310h = mutableFlatBuffer.a(i, 4);
            this.f11312j = mutableFlatBuffer.a(i, 6, 0);
            this.f11321s = mutableFlatBuffer.a(i, 15);
            this.f11322t = mutableFlatBuffer.a(i, 16);
            this.f11323u = mutableFlatBuffer.a(i, 17);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -980149308)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: admin_aware_group */
    public final class MinutiaeTaggableObjectsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<TaggableObjectEdgeModel> f11327d;
        @Nullable
        private DefaultPageInfoTailFieldsModel f11328e;

        /* compiled from: admin_aware_group */
        public final class Builder {
            @Nullable
            public ImmutableList<TaggableObjectEdgeModel> f11325a;
            @Nullable
            public DefaultPageInfoTailFieldsModel f11326b;
        }

        /* compiled from: admin_aware_group */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MinutiaeTaggableObjectsModel.class, new Deserializer());
            }

            public Object m19294a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(MinutiaeTaggableObjectsParser.m19344a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object minutiaeTaggableObjectsModel = new MinutiaeTaggableObjectsModel();
                ((BaseModel) minutiaeTaggableObjectsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (minutiaeTaggableObjectsModel instanceof Postprocessable) {
                    return ((Postprocessable) minutiaeTaggableObjectsModel).a();
                }
                return minutiaeTaggableObjectsModel;
            }
        }

        /* compiled from: admin_aware_group */
        public class Serializer extends JsonSerializer<MinutiaeTaggableObjectsModel> {
            public final void m19295a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MinutiaeTaggableObjectsModel minutiaeTaggableObjectsModel = (MinutiaeTaggableObjectsModel) obj;
                if (minutiaeTaggableObjectsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(minutiaeTaggableObjectsModel.m19296a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    minutiaeTaggableObjectsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                MinutiaeTaggableObjectsParser.m19345a(minutiaeTaggableObjectsModel.w_(), minutiaeTaggableObjectsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(MinutiaeTaggableObjectsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultPageInfoTailFields m19299b() {
            return m19300j();
        }

        public MinutiaeTaggableObjectsModel() {
            super(2);
        }

        public MinutiaeTaggableObjectsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<TaggableObjectEdgeModel> m19298a() {
            this.f11327d = super.a(this.f11327d, 0, TaggableObjectEdgeModel.class);
            return (ImmutableList) this.f11327d;
        }

        @Nullable
        public final DefaultPageInfoTailFieldsModel m19300j() {
            this.f11328e = (DefaultPageInfoTailFieldsModel) super.a(this.f11328e, 1, DefaultPageInfoTailFieldsModel.class);
            return this.f11328e;
        }

        public final int jK_() {
            return 1733656983;
        }

        public final GraphQLVisitableModel m19297a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultPageInfoTailFieldsModel defaultPageInfoTailFieldsModel;
            h();
            if (m19298a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m19298a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    MinutiaeTaggableObjectsModel minutiaeTaggableObjectsModel = (MinutiaeTaggableObjectsModel) ModelHelper.a(null, this);
                    minutiaeTaggableObjectsModel.f11327d = a.b();
                    graphQLVisitableModel = minutiaeTaggableObjectsModel;
                    if (m19300j() != null) {
                        defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m19300j());
                        if (m19300j() != defaultPageInfoTailFieldsModel) {
                            graphQLVisitableModel = (MinutiaeTaggableObjectsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f11328e = defaultPageInfoTailFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m19300j() != null) {
                defaultPageInfoTailFieldsModel = (DefaultPageInfoTailFieldsModel) graphQLModelMutatingVisitor.b(m19300j());
                if (m19300j() != defaultPageInfoTailFieldsModel) {
                    graphQLVisitableModel = (MinutiaeTaggableObjectsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11328e = defaultPageInfoTailFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m19296a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19298a());
            int a2 = ModelHelper.a(flatBufferBuilder, m19300j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -692789983)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: admin_aware_group */
    public final class TaggableObjectEdgeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AssociatedPlacesInfoModel f11347d;
        @Nullable
        private String f11348e;
        @Nullable
        private List<MinutiaeIconModel> f11349f;
        @Nullable
        private String f11350g;
        @Nullable
        private IconModel f11351h;
        @Nullable
        private DefaultImageFieldsModel f11352i;
        @Nullable
        private MinutiaeTaggableObjectFieldsModel f11353j;
        private boolean f11354k;
        @Nullable
        private SubtextModel f11355l;
        @Nullable
        private String f11356m;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1184182346)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: admin_aware_group */
        public final class AssociatedPlacesInfoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<String> f11329d;
            @Nullable
            private List<String> f11330e;
            @Nullable
            private GraphQLCheckinPlaceResultsContext f11331f;
            @Nullable
            private String f11332g;

            /* compiled from: admin_aware_group */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AssociatedPlacesInfoModel.class, new Deserializer());
                }

                public Object m19301a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AssociatedPlacesInfoParser.m19346a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object associatedPlacesInfoModel = new AssociatedPlacesInfoModel();
                    ((BaseModel) associatedPlacesInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (associatedPlacesInfoModel instanceof Postprocessable) {
                        return ((Postprocessable) associatedPlacesInfoModel).a();
                    }
                    return associatedPlacesInfoModel;
                }
            }

            /* compiled from: admin_aware_group */
            public class Serializer extends JsonSerializer<AssociatedPlacesInfoModel> {
                public final void m19302a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AssociatedPlacesInfoModel associatedPlacesInfoModel = (AssociatedPlacesInfoModel) obj;
                    if (associatedPlacesInfoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(associatedPlacesInfoModel.m19304a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        associatedPlacesInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AssociatedPlacesInfoParser.m19347a(associatedPlacesInfoModel.w_(), associatedPlacesInfoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AssociatedPlacesInfoModel.class, new Serializer());
                }
            }

            public AssociatedPlacesInfoModel() {
                super(4);
            }

            @Nonnull
            public final ImmutableList<String> m19306a() {
                this.f11329d = super.a(this.f11329d, 0);
                return (ImmutableList) this.f11329d;
            }

            @Nonnull
            public final ImmutableList<String> m19307b() {
                this.f11330e = super.a(this.f11330e, 1);
                return (ImmutableList) this.f11330e;
            }

            @Nullable
            public final GraphQLCheckinPlaceResultsContext m19308c() {
                this.f11331f = (GraphQLCheckinPlaceResultsContext) super.b(this.f11331f, 2, GraphQLCheckinPlaceResultsContext.class, GraphQLCheckinPlaceResultsContext.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f11331f;
            }

            @Nullable
            private String m19303j() {
                this.f11332g = super.a(this.f11332g, 3);
                return this.f11332g;
            }

            public final int jK_() {
                return -1497429757;
            }

            public final GraphQLVisitableModel m19305a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19304a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int c = flatBufferBuilder.c(m19306a());
                int c2 = flatBufferBuilder.c(m19307b());
                int a = flatBufferBuilder.a(m19308c());
                int b = flatBufferBuilder.b(m19303j());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, c);
                flatBufferBuilder.b(1, c2);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: admin_aware_group */
        public final class Builder {
            @Nullable
            public AssociatedPlacesInfoModel f11333a;
            @Nullable
            public String f11334b;
            @Nullable
            public ImmutableList<MinutiaeIconModel> f11335c;
            @Nullable
            public String f11336d;
            @Nullable
            public IconModel f11337e;
            @Nullable
            public DefaultImageFieldsModel f11338f;
            @Nullable
            public MinutiaeTaggableObjectFieldsModel f11339g;
            public boolean f11340h;
            @Nullable
            public SubtextModel f11341i;
            @Nullable
            public String f11342j;

            public final TaggableObjectEdgeModel m19309a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f11333a);
                int b = flatBufferBuilder.b(this.f11334b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f11335c);
                int b2 = flatBufferBuilder.b(this.f11336d);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f11337e);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f11338f);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f11339g);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f11341i);
                int b3 = flatBufferBuilder.b(this.f11342j);
                flatBufferBuilder.c(10);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, a5);
                flatBufferBuilder.a(7, this.f11340h);
                flatBufferBuilder.b(8, a6);
                flatBufferBuilder.b(9, b3);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new TaggableObjectEdgeModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: admin_aware_group */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TaggableObjectEdgeModel.class, new Deserializer());
            }

            public Object m19310a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TaggableObjectEdgeParser.m19352b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object taggableObjectEdgeModel = new TaggableObjectEdgeModel();
                ((BaseModel) taggableObjectEdgeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (taggableObjectEdgeModel instanceof Postprocessable) {
                    return ((Postprocessable) taggableObjectEdgeModel).a();
                }
                return taggableObjectEdgeModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1465483233)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: admin_aware_group */
        public final class IconModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f11343d;
            @Nullable
            private String f11344e;

            /* compiled from: admin_aware_group */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(IconModel.class, new Deserializer());
                }

                public Object m19311a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(IconParser.m19348a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object iconModel = new IconModel();
                    ((BaseModel) iconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (iconModel instanceof Postprocessable) {
                        return ((Postprocessable) iconModel).a();
                    }
                    return iconModel;
                }
            }

            /* compiled from: admin_aware_group */
            public class Serializer extends JsonSerializer<IconModel> {
                public final void m19312a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    IconModel iconModel = (IconModel) obj;
                    if (iconModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(iconModel.m19315a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        iconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    IconParser.m19349a(iconModel.w_(), iconModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(IconModel.class, new Serializer());
                }
            }

            public IconModel() {
                super(2);
            }

            @Nullable
            private String m19313j() {
                this.f11343d = super.a(this.f11343d, 0);
                return this.f11343d;
            }

            @Nullable
            private String m19314k() {
                this.f11344e = super.a(this.f11344e, 1);
                return this.f11344e;
            }

            @Nullable
            public final String m19317a() {
                return m19314k();
            }

            public final int jK_() {
                return 638969039;
            }

            public final GraphQLVisitableModel m19316a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19315a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m19313j());
                int b2 = flatBufferBuilder.b(m19314k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: admin_aware_group */
        public class Serializer extends JsonSerializer<TaggableObjectEdgeModel> {
            public final void m19318a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TaggableObjectEdgeModel taggableObjectEdgeModel = (TaggableObjectEdgeModel) obj;
                if (taggableObjectEdgeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(taggableObjectEdgeModel.m19328a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    taggableObjectEdgeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TaggableObjectEdgeParser.m19353b(taggableObjectEdgeModel.w_(), taggableObjectEdgeModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TaggableObjectEdgeModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: admin_aware_group */
        public final class SubtextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f11346d;

            /* compiled from: admin_aware_group */
            public final class Builder {
                @Nullable
                public String f11345a;
            }

            /* compiled from: admin_aware_group */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SubtextModel.class, new Deserializer());
                }

                public Object m19319a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SubtextParser.m19350a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object subtextModel = new SubtextModel();
                    ((BaseModel) subtextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (subtextModel instanceof Postprocessable) {
                        return ((Postprocessable) subtextModel).a();
                    }
                    return subtextModel;
                }
            }

            /* compiled from: admin_aware_group */
            public class Serializer extends JsonSerializer<SubtextModel> {
                public final void m19320a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SubtextModel subtextModel = (SubtextModel) obj;
                    if (subtextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(subtextModel.m19321a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        subtextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SubtextParser.m19351a(subtextModel.w_(), subtextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SubtextModel.class, new Serializer());
                }
            }

            public SubtextModel() {
                super(1);
            }

            public SubtextModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m19323a() {
                this.f11346d = super.a(this.f11346d, 0);
                return this.f11346d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m19322a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19321a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m19323a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ AssociatedPlacesInfoModel m19329a() {
            return m19324m();
        }

        @Nullable
        public final /* synthetic */ MinutiaeTaggableObjectFieldsModel af_() {
            return m19337k();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m19334d() {
            return m19336j();
        }

        @Nullable
        public final /* synthetic */ SubtextModel m19335g() {
            return m19327p();
        }

        public TaggableObjectEdgeModel() {
            super(10);
        }

        public TaggableObjectEdgeModel(MutableFlatBuffer mutableFlatBuffer) {
            super(10);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private AssociatedPlacesInfoModel m19324m() {
            this.f11347d = (AssociatedPlacesInfoModel) super.a(this.f11347d, 0, AssociatedPlacesInfoModel.class);
            return this.f11347d;
        }

        @Nullable
        private String m19325n() {
            this.f11348e = super.a(this.f11348e, 1);
            return this.f11348e;
        }

        @Nonnull
        public final ImmutableList<MinutiaeIconModel> m19332b() {
            this.f11349f = super.a(this.f11349f, 2, MinutiaeIconModel.class);
            return (ImmutableList) this.f11349f;
        }

        @Nullable
        public final String m19333c() {
            this.f11350g = super.a(this.f11350g, 3);
            return this.f11350g;
        }

        @Nullable
        private IconModel m19326o() {
            this.f11351h = (IconModel) super.a(this.f11351h, 4, IconModel.class);
            return this.f11351h;
        }

        @Nullable
        public final DefaultImageFieldsModel m19336j() {
            this.f11352i = (DefaultImageFieldsModel) super.a(this.f11352i, 5, DefaultImageFieldsModel.class);
            return this.f11352i;
        }

        @Nullable
        public final MinutiaeTaggableObjectFieldsModel m19337k() {
            this.f11353j = (MinutiaeTaggableObjectFieldsModel) super.a(this.f11353j, 6, MinutiaeTaggableObjectFieldsModel.class);
            return this.f11353j;
        }

        public final boolean m19338l() {
            a(0, 7);
            return this.f11354k;
        }

        @Nullable
        private SubtextModel m19327p() {
            this.f11355l = (SubtextModel) super.a(this.f11355l, 8, SubtextModel.class);
            return this.f11355l;
        }

        @Nullable
        public final String ae_() {
            this.f11356m = super.a(this.f11356m, 9);
            return this.f11356m;
        }

        public final int jK_() {
            return -863817930;
        }

        public final GraphQLVisitableModel m19330a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19324m() != null) {
                AssociatedPlacesInfoModel associatedPlacesInfoModel = (AssociatedPlacesInfoModel) graphQLModelMutatingVisitor.b(m19324m());
                if (m19324m() != associatedPlacesInfoModel) {
                    graphQLVisitableModel = (TaggableObjectEdgeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11347d = associatedPlacesInfoModel;
                }
            }
            if (m19332b() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m19332b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    TaggableObjectEdgeModel taggableObjectEdgeModel = (TaggableObjectEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    taggableObjectEdgeModel.f11349f = a.b();
                    graphQLVisitableModel = taggableObjectEdgeModel;
                }
            }
            if (m19326o() != null) {
                IconModel iconModel = (IconModel) graphQLModelMutatingVisitor.b(m19326o());
                if (m19326o() != iconModel) {
                    graphQLVisitableModel = (TaggableObjectEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11351h = iconModel;
                }
            }
            if (m19336j() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m19336j());
                if (m19336j() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (TaggableObjectEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11352i = defaultImageFieldsModel;
                }
            }
            if (m19337k() != null) {
                MinutiaeTaggableObjectFieldsModel minutiaeTaggableObjectFieldsModel = (MinutiaeTaggableObjectFieldsModel) graphQLModelMutatingVisitor.b(m19337k());
                if (m19337k() != minutiaeTaggableObjectFieldsModel) {
                    graphQLVisitableModel = (TaggableObjectEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11353j = minutiaeTaggableObjectFieldsModel;
                }
            }
            if (m19327p() != null) {
                SubtextModel subtextModel = (SubtextModel) graphQLModelMutatingVisitor.b(m19327p());
                if (m19327p() != subtextModel) {
                    graphQLVisitableModel = (TaggableObjectEdgeModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f11355l = subtextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19328a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19324m());
            int b = flatBufferBuilder.b(m19325n());
            int a2 = ModelHelper.a(flatBufferBuilder, m19332b());
            int b2 = flatBufferBuilder.b(m19333c());
            int a3 = ModelHelper.a(flatBufferBuilder, m19326o());
            int a4 = ModelHelper.a(flatBufferBuilder, m19336j());
            int a5 = ModelHelper.a(flatBufferBuilder, m19337k());
            int a6 = ModelHelper.a(flatBufferBuilder, m19327p());
            int b3 = flatBufferBuilder.b(ae_());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            flatBufferBuilder.a(7, this.f11354k);
            flatBufferBuilder.b(8, a6);
            flatBufferBuilder.b(9, b3);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19331a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f11354k = mutableFlatBuffer.a(i, 7);
        }
    }
}

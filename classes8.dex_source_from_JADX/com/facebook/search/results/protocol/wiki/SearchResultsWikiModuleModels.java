package com.facebook.search.results.protocol.wiki;

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
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleInterfaces.SearchResultsWikiModulePage;
import com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleParsers.SearchResultsWikiModulePageParser;
import com.facebook.search.results.protocol.wiki.SearchResultsWikiModuleParsers.SearchResultsWikiModulePageParser.BestDescriptionParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: menu_management_load_successful */
public class SearchResultsWikiModuleModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -715074287)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: menu_management_load_successful */
    public final class SearchResultsWikiModulePageModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, SearchResultsWikiModulePage {
        @Nullable
        private BestDescriptionModel f8895d;
        @Nullable
        private String f8896e;
        @Nullable
        private String f8897f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: menu_management_load_successful */
        public final class BestDescriptionModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8894d;

            /* compiled from: menu_management_load_successful */
            public final class Builder {
                @Nullable
                public String f8893a;
            }

            /* compiled from: menu_management_load_successful */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BestDescriptionModel.class, new Deserializer());
                }

                public Object m10620a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BestDescriptionParser.m10636a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object bestDescriptionModel = new BestDescriptionModel();
                    ((BaseModel) bestDescriptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (bestDescriptionModel instanceof Postprocessable) {
                        return ((Postprocessable) bestDescriptionModel).a();
                    }
                    return bestDescriptionModel;
                }
            }

            /* compiled from: menu_management_load_successful */
            public class Serializer extends JsonSerializer<BestDescriptionModel> {
                public final void m10621a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BestDescriptionModel bestDescriptionModel = (BestDescriptionModel) obj;
                    if (bestDescriptionModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(bestDescriptionModel.m10623a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        bestDescriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BestDescriptionParser.m10637a(bestDescriptionModel.w_(), bestDescriptionModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(BestDescriptionModel.class, new Serializer());
                }
            }

            public BestDescriptionModel() {
                super(1);
            }

            public BestDescriptionModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m10625a() {
                this.f8894d = super.a(this.f8894d, 0);
                return this.f8894d;
            }

            public static BestDescriptionModel m10622a(BestDescriptionModel bestDescriptionModel) {
                if (bestDescriptionModel == null) {
                    return null;
                }
                if (bestDescriptionModel instanceof BestDescriptionModel) {
                    return bestDescriptionModel;
                }
                Builder builder = new Builder();
                builder.f8893a = bestDescriptionModel.m10625a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8893a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new BestDescriptionModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10624a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10623a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10625a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: menu_management_load_successful */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsWikiModulePageModel.class, new Deserializer());
            }

            public Object m10626a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SearchResultsWikiModulePageParser.m10638a(jsonParser);
                Object searchResultsWikiModulePageModel = new SearchResultsWikiModulePageModel();
                ((BaseModel) searchResultsWikiModulePageModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (searchResultsWikiModulePageModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsWikiModulePageModel).a();
                }
                return searchResultsWikiModulePageModel;
            }
        }

        /* compiled from: menu_management_load_successful */
        public class Serializer extends JsonSerializer<SearchResultsWikiModulePageModel> {
            public final void m10627a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SearchResultsWikiModulePageModel searchResultsWikiModulePageModel = (SearchResultsWikiModulePageModel) obj;
                if (searchResultsWikiModulePageModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsWikiModulePageModel.m10631a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsWikiModulePageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = searchResultsWikiModulePageModel.w_();
                int u_ = searchResultsWikiModulePageModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("best_description");
                    BestDescriptionParser.m10637a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SearchResultsWikiModulePageModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ BestDescriptionModel jl_() {
            return m10628j();
        }

        public SearchResultsWikiModulePageModel() {
            super(3);
        }

        public final void m10634a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m10635a(String str, Object obj, boolean z) {
        }

        @Nullable
        private BestDescriptionModel m10628j() {
            this.f8895d = (BestDescriptionModel) super.a(this.f8895d, 0, BestDescriptionModel.class);
            return this.f8895d;
        }

        @Nullable
        private String m10629k() {
            this.f8896e = super.a(this.f8896e, 1);
            return this.f8896e;
        }

        @Nullable
        public final String mo573D() {
            this.f8897f = super.a(this.f8897f, 2);
            return this.f8897f;
        }

        @Nullable
        public final String m10633a() {
            return m10629k();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m10632a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10628j() != null) {
                BestDescriptionModel bestDescriptionModel = (BestDescriptionModel) graphQLModelMutatingVisitor.b(m10628j());
                if (m10628j() != bestDescriptionModel) {
                    graphQLVisitableModel = (SearchResultsWikiModulePageModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8895d = bestDescriptionModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10631a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10628j());
            int b = flatBufferBuilder.b(m10629k());
            int b2 = flatBufferBuilder.b(mo573D());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }
}

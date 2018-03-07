package com.facebook.friending.center.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friending.center.protocol.FriendsCenterDefaultFieldsGraphQLModels.FriendsCenterDefaultNodeModel;
import com.facebook.friending.center.protocol.FriendsCenterSearchFriendsGraphQLParsers.FriendsCenterSearchFriendsQueryParser;
import com.facebook.friending.center.protocol.FriendsCenterSearchFriendsGraphQLParsers.FriendsCenterSearchFriendsQueryParser.SearchResultsParser;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: ads/mobile_preview */
public class FriendsCenterSearchFriendsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 806992508)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: ads/mobile_preview */
    public final class FriendsCenterSearchFriendsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private SearchResultsModel f20040d;

        /* compiled from: ads/mobile_preview */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendsCenterSearchFriendsQueryModel.class, new Deserializer());
            }

            public Object m20306a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FriendsCenterSearchFriendsQueryParser.m20319a(jsonParser);
                Object friendsCenterSearchFriendsQueryModel = new FriendsCenterSearchFriendsQueryModel();
                ((BaseModel) friendsCenterSearchFriendsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (friendsCenterSearchFriendsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) friendsCenterSearchFriendsQueryModel).a();
                }
                return friendsCenterSearchFriendsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1065753298)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: ads/mobile_preview */
        public final class SearchResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FriendsCenterDefaultNodeModel> f20038d;
            @Nullable
            private DefaultPageInfoFieldsModel f20039e;

            /* compiled from: ads/mobile_preview */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SearchResultsModel.class, new Deserializer());
                }

                public Object m20307a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SearchResultsParser.m20317a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object searchResultsModel = new SearchResultsModel();
                    ((BaseModel) searchResultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (searchResultsModel instanceof Postprocessable) {
                        return ((Postprocessable) searchResultsModel).a();
                    }
                    return searchResultsModel;
                }
            }

            /* compiled from: ads/mobile_preview */
            public class Serializer extends JsonSerializer<SearchResultsModel> {
                public final void m20308a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SearchResultsModel searchResultsModel = (SearchResultsModel) obj;
                    if (searchResultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(searchResultsModel.m20309a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        searchResultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SearchResultsParser.m20318a(searchResultsModel.w_(), searchResultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SearchResultsModel.class, new Serializer());
                }
            }

            public SearchResultsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<FriendsCenterDefaultNodeModel> m20311a() {
                this.f20038d = super.a(this.f20038d, 0, FriendsCenterDefaultNodeModel.class);
                return (ImmutableList) this.f20038d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m20312j() {
                this.f20039e = (DefaultPageInfoFieldsModel) super.a(this.f20039e, 1, DefaultPageInfoFieldsModel.class);
                return this.f20039e;
            }

            public final int jK_() {
                return 429856034;
            }

            public final GraphQLVisitableModel m20310a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m20311a() != null) {
                    Builder a = ModelHelper.a(m20311a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        SearchResultsModel searchResultsModel = (SearchResultsModel) ModelHelper.a(null, this);
                        searchResultsModel.f20038d = a.b();
                        graphQLVisitableModel = searchResultsModel;
                        if (m20312j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20312j());
                            if (m20312j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (SearchResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f20039e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m20312j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m20312j());
                    if (m20312j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (SearchResultsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f20039e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m20309a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m20311a());
                int a2 = ModelHelper.a(flatBufferBuilder, m20312j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: ads/mobile_preview */
        public class Serializer extends JsonSerializer<FriendsCenterSearchFriendsQueryModel> {
            public final void m20313a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FriendsCenterSearchFriendsQueryModel friendsCenterSearchFriendsQueryModel = (FriendsCenterSearchFriendsQueryModel) obj;
                if (friendsCenterSearchFriendsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendsCenterSearchFriendsQueryModel.m20314a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendsCenterSearchFriendsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = friendsCenterSearchFriendsQueryModel.w_();
                int u_ = friendsCenterSearchFriendsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("search_results");
                    SearchResultsParser.m20318a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FriendsCenterSearchFriendsQueryModel.class, new Serializer());
            }
        }

        public FriendsCenterSearchFriendsQueryModel() {
            super(1);
        }

        @Nullable
        public final SearchResultsModel m20315a() {
            this.f20040d = (SearchResultsModel) super.a(this.f20040d, 0, SearchResultsModel.class);
            return this.f20040d;
        }

        public final int jK_() {
            return 476915574;
        }

        public final GraphQLVisitableModel m20316a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m20315a() != null) {
                SearchResultsModel searchResultsModel = (SearchResultsModel) graphQLModelMutatingVisitor.b(m20315a());
                if (m20315a() != searchResultsModel) {
                    graphQLVisitableModel = (FriendsCenterSearchFriendsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f20040d = searchResultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m20314a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m20315a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

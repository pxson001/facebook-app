package com.facebook.search.results.protocol.entity;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.entity.SearchResultsUserInterfaces.SearchResultsUser;
import com.facebook.search.results.protocol.entity.SearchResultsUserParsers.SearchResultsUserParser;
import com.facebook.search.results.protocol.entity.SearchResultsUserParsers.SearchResultsUserParser.BioTextParser;
import com.facebook.search.results.protocol.entity.SearchResultsUserParsers.SearchResultsUserParser.MutualFriendsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: method/user.editregistrationcontactpoint */
public class SearchResultsUserModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 610034631)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: method/user.editregistrationcontactpoint */
    public final class SearchResultsUserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, SearchResultsUser {
        @Nullable
        private GraphQLObjectType f8675d;
        @Nullable
        private BioTextModel f8676e;
        @Nullable
        private GraphQLFriendshipStatus f8677f;
        @Nullable
        private String f8678g;
        private boolean f8679h;
        @Nullable
        private MutualFriendsModel f8680i;
        @Nullable
        private String f8681j;
        @Nullable
        private DefaultImageFieldsModel f8682k;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: method/user.editregistrationcontactpoint */
        public final class BioTextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8672d;

            /* compiled from: method/user.editregistrationcontactpoint */
            public final class Builder {
                @Nullable
                public String f8671a;
            }

            /* compiled from: method/user.editregistrationcontactpoint */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(BioTextModel.class, new Deserializer());
                }

                public Object m10100a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(BioTextParser.m10130a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object bioTextModel = new BioTextModel();
                    ((BaseModel) bioTextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (bioTextModel instanceof Postprocessable) {
                        return ((Postprocessable) bioTextModel).a();
                    }
                    return bioTextModel;
                }
            }

            /* compiled from: method/user.editregistrationcontactpoint */
            public class Serializer extends JsonSerializer<BioTextModel> {
                public final void m10101a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    BioTextModel bioTextModel = (BioTextModel) obj;
                    if (bioTextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(bioTextModel.m10103a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        bioTextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    BioTextParser.m10131a(bioTextModel.w_(), bioTextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(BioTextModel.class, new Serializer());
                }
            }

            public BioTextModel() {
                super(1);
            }

            public BioTextModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m10105a() {
                this.f8672d = super.a(this.f8672d, 0);
                return this.f8672d;
            }

            public static BioTextModel m10102a(BioTextModel bioTextModel) {
                if (bioTextModel == null) {
                    return null;
                }
                if (bioTextModel instanceof BioTextModel) {
                    return bioTextModel;
                }
                Builder builder = new Builder();
                builder.f8671a = bioTextModel.m10105a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8671a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new BioTextModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m10104a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10103a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10105a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: method/user.editregistrationcontactpoint */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsUserModel.class, new Deserializer());
            }

            public Object m10106a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SearchResultsUserParser.m10134a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object searchResultsUserModel = new SearchResultsUserModel();
                ((BaseModel) searchResultsUserModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (searchResultsUserModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsUserModel).a();
                }
                return searchResultsUserModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: method/user.editregistrationcontactpoint */
        public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
            private int f8674d;

            /* compiled from: method/user.editregistrationcontactpoint */
            public final class Builder {
                public int f8673a;
            }

            /* compiled from: method/user.editregistrationcontactpoint */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                }

                public Object m10107a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MutualFriendsParser.m10132a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object mutualFriendsModel = new MutualFriendsModel();
                    ((BaseModel) mutualFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (mutualFriendsModel instanceof Postprocessable) {
                        return ((Postprocessable) mutualFriendsModel).a();
                    }
                    return mutualFriendsModel;
                }
            }

            /* compiled from: method/user.editregistrationcontactpoint */
            public class Serializer extends JsonSerializer<MutualFriendsModel> {
                public final void m10108a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                    if (mutualFriendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mutualFriendsModel.m10111a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MutualFriendsParser.m10133a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                }
            }

            public MutualFriendsModel() {
                super(1);
            }

            public MutualFriendsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m10110a() {
                a(0, 0);
                return this.f8674d;
            }

            public static MutualFriendsModel m10109a(MutualFriendsModel mutualFriendsModel) {
                if (mutualFriendsModel == null) {
                    return null;
                }
                if (mutualFriendsModel instanceof MutualFriendsModel) {
                    return mutualFriendsModel;
                }
                Builder builder = new Builder();
                builder.f8673a = mutualFriendsModel.m10110a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, builder.f8673a, 0);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new MutualFriendsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 1532278911;
            }

            public final GraphQLVisitableModel m10112a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10111a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f8674d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m10113a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f8674d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: method/user.editregistrationcontactpoint */
        public class Serializer extends JsonSerializer<SearchResultsUserModel> {
            public final void m10114a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SearchResultsUserModel searchResultsUserModel = (SearchResultsUserModel) obj;
                if (searchResultsUserModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsUserModel.m10122a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsUserModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = searchResultsUserModel.w_();
                int u_ = searchResultsUserModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("bio_text");
                    BioTextParser.m10131a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("friendship_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 2));
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                boolean a = mutableFlatBuffer.a(u_, 4);
                if (a) {
                    jsonGenerator.a("is_verified");
                    jsonGenerator.a(a);
                }
                g = mutableFlatBuffer.g(u_, 5);
                if (g != 0) {
                    jsonGenerator.a("mutual_friends");
                    MutualFriendsParser.m10133a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 6) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 6));
                }
                g = mutableFlatBuffer.g(u_, 7);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SearchResultsUserModel.class, new Serializer());
            }
        }

        public SearchResultsUserModel() {
            super(8);
        }

        public final void m10126a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m10118n();
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
                return;
            }
            consistencyTuple.a();
        }

        public final void m10127a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m10115a((GraphQLFriendshipStatus) obj);
            }
        }

        @Nullable
        private GraphQLObjectType m10116l() {
            if (this.b != null && this.f8675d == null) {
                this.f8675d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f8675d;
        }

        @Nullable
        private BioTextModel m10117m() {
            this.f8676e = (BioTextModel) super.a(this.f8676e, 1, BioTextModel.class);
            return this.f8676e;
        }

        @Nullable
        private GraphQLFriendshipStatus m10118n() {
            this.f8677f = (GraphQLFriendshipStatus) super.b(this.f8677f, 2, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8677f;
        }

        private void m10115a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f8677f = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        private String m10119o() {
            this.f8678g = super.a(this.f8678g, 3);
            return this.f8678g;
        }

        public final boolean mo562j() {
            a(0, 4);
            return this.f8679h;
        }

        @Nullable
        private MutualFriendsModel m10120p() {
            this.f8680i = (MutualFriendsModel) super.a(this.f8680i, 5, MutualFriendsModel.class);
            return this.f8680i;
        }

        @Nullable
        public final String mo563k() {
            this.f8681j = super.a(this.f8681j, 6);
            return this.f8681j;
        }

        @Nullable
        private DefaultImageFieldsModel m10121q() {
            this.f8682k = (DefaultImageFieldsModel) super.a(this.f8682k, 7, DefaultImageFieldsModel.class);
            return this.f8682k;
        }

        @Nullable
        public final String m10124a() {
            return m10119o();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m10123a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10117m() != null) {
                BioTextModel bioTextModel = (BioTextModel) graphQLModelMutatingVisitor.b(m10117m());
                if (m10117m() != bioTextModel) {
                    graphQLVisitableModel = (SearchResultsUserModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8676e = bioTextModel;
                }
            }
            if (m10120p() != null) {
                MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m10120p());
                if (m10120p() != mutualFriendsModel) {
                    graphQLVisitableModel = (SearchResultsUserModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8680i = mutualFriendsModel;
                }
            }
            if (m10121q() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m10121q());
                if (m10121q() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (SearchResultsUserModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8682k = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10122a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10116l());
            int a2 = ModelHelper.a(flatBufferBuilder, m10117m());
            int a3 = flatBufferBuilder.a(m10118n());
            int b = flatBufferBuilder.b(m10119o());
            int a4 = ModelHelper.a(flatBufferBuilder, m10120p());
            int b2 = flatBufferBuilder.b(mo563k());
            int a5 = ModelHelper.a(flatBufferBuilder, m10121q());
            flatBufferBuilder.c(8);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.a(4, this.f8679h);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, b2);
            flatBufferBuilder.b(7, a5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m10125a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8679h = mutableFlatBuffer.a(i, 4);
        }
    }
}

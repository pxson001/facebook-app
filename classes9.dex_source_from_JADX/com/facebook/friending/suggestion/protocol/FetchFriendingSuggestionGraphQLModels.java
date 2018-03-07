package com.facebook.friending.suggestion.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friending.suggestion.protocol.FetchFriendingSuggestionGraphQLParsers.FetchFriendingSuggestionQueryParser;
import com.facebook.friending.suggestion.protocol.FetchFriendingSuggestionGraphQLParsers.FetchFriendingSuggestionQueryParser.FriendSuggestionsParser;
import com.facebook.friending.suggestion.protocol.FetchFriendingSuggestionGraphQLParsers.FriendingSuggestionUserFieldsParser;
import com.facebook.friending.suggestion.protocol.FetchFriendingSuggestionGraphQLParsers.FriendingSuggestionUserFieldsParser.MutualFriendsParser;
import com.facebook.friending.suggestion.protocol.FetchFriendingSuggestionGraphQLParsers.FriendingSuggestionUserFieldsParser.ProfilePictureParser;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
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
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: TEXT_CHANGE */
public class FetchFriendingSuggestionGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -633931672)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TEXT_CHANGE */
    public final class FetchFriendingSuggestionQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private FriendSuggestionsModel f24967d;

        /* compiled from: TEXT_CHANGE */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchFriendingSuggestionQueryModel.class, new Deserializer());
            }

            public Object m26720a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchFriendingSuggestionQueryParser.m26759a(jsonParser);
                Object fetchFriendingSuggestionQueryModel = new FetchFriendingSuggestionQueryModel();
                ((BaseModel) fetchFriendingSuggestionQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchFriendingSuggestionQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchFriendingSuggestionQueryModel).a();
                }
                return fetchFriendingSuggestionQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -2095242449)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TEXT_CHANGE */
        public final class FriendSuggestionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FriendingSuggestionUserFieldsModel> f24965d;
            @Nullable
            private DefaultPageInfoFieldsModel f24966e;

            /* compiled from: TEXT_CHANGE */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FriendSuggestionsModel.class, new Deserializer());
                }

                public Object m26721a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FriendSuggestionsParser.m26757a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object friendSuggestionsModel = new FriendSuggestionsModel();
                    ((BaseModel) friendSuggestionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (friendSuggestionsModel instanceof Postprocessable) {
                        return ((Postprocessable) friendSuggestionsModel).a();
                    }
                    return friendSuggestionsModel;
                }
            }

            /* compiled from: TEXT_CHANGE */
            public class Serializer extends JsonSerializer<FriendSuggestionsModel> {
                public final void m26722a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FriendSuggestionsModel friendSuggestionsModel = (FriendSuggestionsModel) obj;
                    if (friendSuggestionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(friendSuggestionsModel.m26723a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        friendSuggestionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FriendSuggestionsParser.m26758a(friendSuggestionsModel.w_(), friendSuggestionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(FriendSuggestionsModel.class, new Serializer());
                }
            }

            public FriendSuggestionsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<FriendingSuggestionUserFieldsModel> m26725a() {
                this.f24965d = super.a(this.f24965d, 0, FriendingSuggestionUserFieldsModel.class);
                return (ImmutableList) this.f24965d;
            }

            @Nullable
            public final DefaultPageInfoFieldsModel m26726j() {
                this.f24966e = (DefaultPageInfoFieldsModel) super.a(this.f24966e, 1, DefaultPageInfoFieldsModel.class);
                return this.f24966e;
            }

            public final int jK_() {
                return -1054879985;
            }

            public final GraphQLVisitableModel m26724a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
                h();
                if (m26725a() != null) {
                    Builder a = ModelHelper.a(m26725a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        FriendSuggestionsModel friendSuggestionsModel = (FriendSuggestionsModel) ModelHelper.a(null, this);
                        friendSuggestionsModel.f24965d = a.b();
                        graphQLVisitableModel = friendSuggestionsModel;
                        if (m26726j() != null) {
                            defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m26726j());
                            if (m26726j() != defaultPageInfoFieldsModel) {
                                graphQLVisitableModel = (FriendSuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f24966e = defaultPageInfoFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m26726j() != null) {
                    defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m26726j());
                    if (m26726j() != defaultPageInfoFieldsModel) {
                        graphQLVisitableModel = (FriendSuggestionsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f24966e = defaultPageInfoFieldsModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m26723a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m26725a());
                int a2 = ModelHelper.a(flatBufferBuilder, m26726j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: TEXT_CHANGE */
        public class Serializer extends JsonSerializer<FetchFriendingSuggestionQueryModel> {
            public final void m26727a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchFriendingSuggestionQueryModel fetchFriendingSuggestionQueryModel = (FetchFriendingSuggestionQueryModel) obj;
                if (fetchFriendingSuggestionQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchFriendingSuggestionQueryModel.m26728a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchFriendingSuggestionQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchFriendingSuggestionQueryModel.w_();
                int u_ = fetchFriendingSuggestionQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friend_suggestions");
                    FriendSuggestionsParser.m26758a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchFriendingSuggestionQueryModel.class, new Serializer());
            }
        }

        public FetchFriendingSuggestionQueryModel() {
            super(1);
        }

        public final void m26731a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m26732a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final FriendSuggestionsModel m26729a() {
            this.f24967d = (FriendSuggestionsModel) super.a(this.f24967d, 0, FriendSuggestionsModel.class);
            return this.f24967d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m26730a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26729a() != null) {
                FriendSuggestionsModel friendSuggestionsModel = (FriendSuggestionsModel) graphQLModelMutatingVisitor.b(m26729a());
                if (m26729a() != friendSuggestionsModel) {
                    graphQLVisitableModel = (FetchFriendingSuggestionQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f24967d = friendSuggestionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26728a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26729a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -256736960)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TEXT_CHANGE */
    public final class FriendingSuggestionUserFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLFriendshipStatus f24970d;
        @Nullable
        private String f24971e;
        @Nullable
        private MutualFriendsModel f24972f;
        @Nullable
        private String f24973g;
        @Nullable
        private ProfilePictureModel f24974h;

        /* compiled from: TEXT_CHANGE */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FriendingSuggestionUserFieldsModel.class, new Deserializer());
            }

            public Object m26733a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FriendingSuggestionUserFieldsParser.m26764b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object friendingSuggestionUserFieldsModel = new FriendingSuggestionUserFieldsModel();
                ((BaseModel) friendingSuggestionUserFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (friendingSuggestionUserFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) friendingSuggestionUserFieldsModel).a();
                }
                return friendingSuggestionUserFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TEXT_CHANGE */
        public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
            private int f24968d;

            /* compiled from: TEXT_CHANGE */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                }

                public Object m26734a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MutualFriendsParser.m26760a(jsonParser, flatBufferBuilder));
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

            /* compiled from: TEXT_CHANGE */
            public class Serializer extends JsonSerializer<MutualFriendsModel> {
                public final void m26735a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                    if (mutualFriendsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(mutualFriendsModel.m26737a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MutualFriendsParser.m26761a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                }
            }

            public MutualFriendsModel() {
                super(1);
            }

            public final int m26736a() {
                a(0, 0);
                return this.f24968d;
            }

            public final int jK_() {
                return 1532278911;
            }

            public final GraphQLVisitableModel m26738a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m26737a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f24968d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m26739a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f24968d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: TEXT_CHANGE */
        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f24969d;

            /* compiled from: TEXT_CHANGE */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m26740a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ProfilePictureParser.m26762a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object profilePictureModel = new ProfilePictureModel();
                    ((BaseModel) profilePictureModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (profilePictureModel instanceof Postprocessable) {
                        return ((Postprocessable) profilePictureModel).a();
                    }
                    return profilePictureModel;
                }
            }

            /* compiled from: TEXT_CHANGE */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m26741a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m26742a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ProfilePictureParser.m26763a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(1);
            }

            @Nullable
            public final String m26744a() {
                this.f24969d = super.a(this.f24969d, 0);
                return this.f24969d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m26743a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m26742a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m26744a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: TEXT_CHANGE */
        public class Serializer extends JsonSerializer<FriendingSuggestionUserFieldsModel> {
            public final void m26745a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FriendingSuggestionUserFieldsModel friendingSuggestionUserFieldsModel = (FriendingSuggestionUserFieldsModel) obj;
                if (friendingSuggestionUserFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(friendingSuggestionUserFieldsModel.m26747a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    friendingSuggestionUserFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FriendingSuggestionUserFieldsParser.m26765b(friendingSuggestionUserFieldsModel.w_(), friendingSuggestionUserFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FriendingSuggestionUserFieldsModel.class, new Serializer());
            }
        }

        public FriendingSuggestionUserFieldsModel() {
            super(5);
        }

        public final void m26750a(String str, ConsistencyTuple consistencyTuple) {
            if ("friendship_status".equals(str)) {
                consistencyTuple.a = m26752j();
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
                return;
            }
            consistencyTuple.a();
        }

        public final void m26751a(String str, Object obj, boolean z) {
            if ("friendship_status".equals(str)) {
                m26746a((GraphQLFriendshipStatus) obj);
            }
        }

        @Nullable
        public final GraphQLFriendshipStatus m26752j() {
            this.f24970d = (GraphQLFriendshipStatus) super.b(this.f24970d, 0, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f24970d;
        }

        private void m26746a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
            this.f24970d = graphQLFriendshipStatus;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
            }
        }

        @Nullable
        public final String m26753k() {
            this.f24971e = super.a(this.f24971e, 1);
            return this.f24971e;
        }

        @Nullable
        public final MutualFriendsModel m26754l() {
            this.f24972f = (MutualFriendsModel) super.a(this.f24972f, 2, MutualFriendsModel.class);
            return this.f24972f;
        }

        @Nullable
        public final String m26755m() {
            this.f24973g = super.a(this.f24973g, 3);
            return this.f24973g;
        }

        @Nullable
        public final ProfilePictureModel m26756n() {
            this.f24974h = (ProfilePictureModel) super.a(this.f24974h, 4, ProfilePictureModel.class);
            return this.f24974h;
        }

        @Nullable
        public final String m26749a() {
            return m26753k();
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m26748a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26754l() != null) {
                MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m26754l());
                if (m26754l() != mutualFriendsModel) {
                    graphQLVisitableModel = (FriendingSuggestionUserFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f24972f = mutualFriendsModel;
                }
            }
            if (m26756n() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m26756n());
                if (m26756n() != profilePictureModel) {
                    graphQLVisitableModel = (FriendingSuggestionUserFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f24974h = profilePictureModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26747a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m26752j());
            int b = flatBufferBuilder.b(m26753k());
            int a2 = ModelHelper.a(flatBufferBuilder, m26754l());
            int b2 = flatBufferBuilder.b(m26755m());
            int a3 = ModelHelper.a(flatBufferBuilder, m26756n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            flatBufferBuilder.b(4, a3);
            i();
            return flatBufferBuilder.d();
        }
    }
}

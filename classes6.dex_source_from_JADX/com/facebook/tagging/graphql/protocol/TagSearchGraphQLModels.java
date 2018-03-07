package com.facebook.tagging.graphql.protocol;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLParsers.FBPersonFriendTagSuggestionsQueryParser;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLParsers.FBPersonFriendTagSuggestionsQueryParser.SuggestedWithGroupsParser;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLParsers.FBPersonFriendTagSuggestionsQueryParser.SuggestedWithGroupsParser.UsersParser;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLParsers.FBPersonFriendTagSuggestionsQueryParser.SuggestedWithGroupsParser.UsersParser.ProfilePictureParser;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLParsers.FBPersonFriendTagSuggestionsQueryParser.SuggestedWithTagsParser;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLParsers.FBPersonFriendTagSuggestionsQueryParser.SuggestedWithTagsParser.EdgesParser;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLParsers.FBPersonFriendTagSuggestionsQueryParser.SuggestedWithTagsParser.EdgesParser.NodeParser;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLParsers.FBTagSearchProfileParser;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLParsers.FBTagSearchProfileParser.SocialContextParser;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLParsers.TagSearchParser;
import com.facebook.tagging.graphql.protocol.TagSearchGraphQLParsers.TagSearchParser.ResultsParser;
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

/* compiled from: deltaVideoCall */
public class TagSearchGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 136349033)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: deltaVideoCall */
    public final class FBPersonFriendTagSuggestionsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<SuggestedWithGroupsModel> f17503d;
        @Nullable
        private SuggestedWithTagsModel f17504e;

        /* compiled from: deltaVideoCall */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBPersonFriendTagSuggestionsQueryModel.class, new Deserializer());
            }

            public Object m25374a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBPersonFriendTagSuggestionsQueryParser.m25478a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBPersonFriendTagSuggestionsQueryModel = new FBPersonFriendTagSuggestionsQueryModel();
                ((BaseModel) fBPersonFriendTagSuggestionsQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBPersonFriendTagSuggestionsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fBPersonFriendTagSuggestionsQueryModel).a();
                }
                return fBPersonFriendTagSuggestionsQueryModel;
            }
        }

        /* compiled from: deltaVideoCall */
        public class Serializer extends JsonSerializer<FBPersonFriendTagSuggestionsQueryModel> {
            public final void m25375a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBPersonFriendTagSuggestionsQueryModel fBPersonFriendTagSuggestionsQueryModel = (FBPersonFriendTagSuggestionsQueryModel) obj;
                if (fBPersonFriendTagSuggestionsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBPersonFriendTagSuggestionsQueryModel.m25428a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBPersonFriendTagSuggestionsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBPersonFriendTagSuggestionsQueryModel.w_();
                int u_ = fBPersonFriendTagSuggestionsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("suggested_with_groups");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        SuggestedWithGroupsParser.m25469b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("suggested_with_tags");
                    SuggestedWithTagsParser.m25477a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBPersonFriendTagSuggestionsQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 576382962)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: deltaVideoCall */
        public final class SuggestedWithGroupsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17493d;
            @Nullable
            private String f17494e;
            @Nullable
            private List<UsersModel> f17495f;

            /* compiled from: deltaVideoCall */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestedWithGroupsModel.class, new Deserializer());
                }

                public Object m25376a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestedWithGroupsParser.m25468b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestedWithGroupsModel = new SuggestedWithGroupsModel();
                    ((BaseModel) suggestedWithGroupsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestedWithGroupsModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestedWithGroupsModel).a();
                    }
                    return suggestedWithGroupsModel;
                }
            }

            /* compiled from: deltaVideoCall */
            public class Serializer extends JsonSerializer<SuggestedWithGroupsModel> {
                public final void m25377a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestedWithGroupsModel suggestedWithGroupsModel = (SuggestedWithGroupsModel) obj;
                    if (suggestedWithGroupsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestedWithGroupsModel.m25395a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestedWithGroupsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestedWithGroupsParser.m25469b(suggestedWithGroupsModel.w_(), suggestedWithGroupsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SuggestedWithGroupsModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 647763844)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: deltaVideoCall */
            public final class UsersModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f17490d;
                @Nullable
                private String f17491e;
                @Nullable
                private ProfilePictureModel f17492f;

                /* compiled from: deltaVideoCall */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(UsersModel.class, new Deserializer());
                    }

                    public Object m25378a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(UsersParser.m25466b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object usersModel = new UsersModel();
                        ((BaseModel) usersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (usersModel instanceof Postprocessable) {
                            return ((Postprocessable) usersModel).a();
                        }
                        return usersModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: deltaVideoCall */
                public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f17489d;

                    /* compiled from: deltaVideoCall */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                        }

                        public Object m25379a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ProfilePictureParser.m25464a(jsonParser, flatBufferBuilder));
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

                    /* compiled from: deltaVideoCall */
                    public class Serializer extends JsonSerializer<ProfilePictureModel> {
                        public final void m25380a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                            if (profilePictureModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profilePictureModel.m25381a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ProfilePictureParser.m25465a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                        }
                    }

                    public ProfilePictureModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m25383a() {
                        this.f17489d = super.a(this.f17489d, 0);
                        return this.f17489d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m25382a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m25381a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m25383a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: deltaVideoCall */
                public class Serializer extends JsonSerializer<UsersModel> {
                    public final void m25384a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        UsersModel usersModel = (UsersModel) obj;
                        if (usersModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(usersModel.m25386a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            usersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        UsersParser.m25467b(usersModel.w_(), usersModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(UsersModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ProfilePictureModel m25393d() {
                    return m25385j();
                }

                public UsersModel() {
                    super(3);
                }

                public final void m25389a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m25390a(String str, Object obj, boolean z) {
                }

                @Nullable
                public final String m25391b() {
                    this.f17490d = super.a(this.f17490d, 0);
                    return this.f17490d;
                }

                @Nullable
                public final String m25392c() {
                    this.f17491e = super.a(this.f17491e, 1);
                    return this.f17491e;
                }

                @Nullable
                private ProfilePictureModel m25385j() {
                    this.f17492f = (ProfilePictureModel) super.a(this.f17492f, 2, ProfilePictureModel.class);
                    return this.f17492f;
                }

                @Nullable
                public final String m25388a() {
                    return m25391b();
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m25387a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m25385j() != null) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m25385j());
                        if (m25385j() != profilePictureModel) {
                            graphQLVisitableModel = (UsersModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f17492f = profilePictureModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m25386a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m25391b());
                    int b2 = flatBufferBuilder.b(m25392c());
                    int a = ModelHelper.a(flatBufferBuilder, m25385j());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    flatBufferBuilder.b(2, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public SuggestedWithGroupsModel() {
                super(3);
            }

            @Nullable
            private String m25394j() {
                this.f17493d = super.a(this.f17493d, 0);
                return this.f17493d;
            }

            @Nullable
            public final String m25397a() {
                this.f17494e = super.a(this.f17494e, 1);
                return this.f17494e;
            }

            @Nonnull
            public final ImmutableList<UsersModel> m25398b() {
                this.f17495f = super.a(this.f17495f, 2, UsersModel.class);
                return (ImmutableList) this.f17495f;
            }

            public final int jK_() {
                return 426663069;
            }

            public final GraphQLVisitableModel m25396a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m25398b() != null) {
                    Builder a = ModelHelper.a(m25398b(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SuggestedWithGroupsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17495f = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m25395a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m25394j());
                int b2 = flatBufferBuilder.b(m25397a());
                int a = ModelHelper.a(flatBufferBuilder, m25398b());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 911760535)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: deltaVideoCall */
        public final class SuggestedWithTagsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f17501d;
            @Nullable
            private String f17502e;

            /* compiled from: deltaVideoCall */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SuggestedWithTagsModel.class, new Deserializer());
                }

                public Object m25399a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SuggestedWithTagsParser.m25476a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object suggestedWithTagsModel = new SuggestedWithTagsModel();
                    ((BaseModel) suggestedWithTagsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (suggestedWithTagsModel instanceof Postprocessable) {
                        return ((Postprocessable) suggestedWithTagsModel).a();
                    }
                    return suggestedWithTagsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 643738259)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: deltaVideoCall */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f17500d;

                /* compiled from: deltaVideoCall */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m25400a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m25474b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -832134646)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: deltaVideoCall */
                public final class NodeModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                    @Nullable
                    private String f17497d;
                    @Nullable
                    private String f17498e;
                    @Nullable
                    private ProfilePictureModel f17499f;

                    /* compiled from: deltaVideoCall */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m25401a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m25472a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object nodeModel = new NodeModel();
                            ((BaseModel) nodeModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (nodeModel instanceof Postprocessable) {
                                return ((Postprocessable) nodeModel).a();
                            }
                            return nodeModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = 842551240)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: deltaVideoCall */
                    public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f17496d;

                        /* compiled from: deltaVideoCall */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                            }

                            public Object m25402a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NodeParser.ProfilePictureParser.m25470a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: deltaVideoCall */
                        public class Serializer extends JsonSerializer<ProfilePictureModel> {
                            public final void m25403a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                                if (profilePictureModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(profilePictureModel.m25404a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NodeParser.ProfilePictureParser.m25471a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                            }
                        }

                        public ProfilePictureModel() {
                            super(1);
                        }

                        @Nullable
                        public final String m25406a() {
                            this.f17496d = super.a(this.f17496d, 0);
                            return this.f17496d;
                        }

                        public final int jK_() {
                            return 70760763;
                        }

                        public final GraphQLVisitableModel m25405a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m25404a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m25406a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: deltaVideoCall */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m25407a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m25409a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m25473a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ ProfilePictureModel m25416d() {
                        return m25408j();
                    }

                    public NodeModel() {
                        super(3);
                    }

                    public final void m25412a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m25413a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    public final String m25414b() {
                        this.f17497d = super.a(this.f17497d, 0);
                        return this.f17497d;
                    }

                    @Nullable
                    public final String m25415c() {
                        this.f17498e = super.a(this.f17498e, 1);
                        return this.f17498e;
                    }

                    @Nullable
                    private ProfilePictureModel m25408j() {
                        this.f17499f = (ProfilePictureModel) super.a(this.f17499f, 2, ProfilePictureModel.class);
                        return this.f17499f;
                    }

                    @Nullable
                    public final String m25411a() {
                        return m25414b();
                    }

                    public final int jK_() {
                        return 2645995;
                    }

                    public final GraphQLVisitableModel m25410a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m25408j() != null) {
                            ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m25408j());
                            if (m25408j() != profilePictureModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f17499f = profilePictureModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m25409a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m25414b());
                        int b2 = flatBufferBuilder.b(m25415c());
                        int a = ModelHelper.a(flatBufferBuilder, m25408j());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.b(2, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: deltaVideoCall */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m25417a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m25419a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m25475b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ NodeModel m25421a() {
                    return m25418j();
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m25418j() {
                    this.f17500d = (NodeModel) super.a(this.f17500d, 0, NodeModel.class);
                    return this.f17500d;
                }

                public final int jK_() {
                    return 1661797119;
                }

                public final GraphQLVisitableModel m25420a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m25418j() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m25418j());
                        if (m25418j() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f17500d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m25419a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m25418j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: deltaVideoCall */
            public class Serializer extends JsonSerializer<SuggestedWithTagsModel> {
                public final void m25422a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SuggestedWithTagsModel suggestedWithTagsModel = (SuggestedWithTagsModel) obj;
                    if (suggestedWithTagsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(suggestedWithTagsModel.m25423a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        suggestedWithTagsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SuggestedWithTagsParser.m25477a(suggestedWithTagsModel.w_(), suggestedWithTagsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(SuggestedWithTagsModel.class, new Serializer());
                }
            }

            public SuggestedWithTagsModel() {
                super(2);
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m25425a() {
                this.f17501d = super.a(this.f17501d, 0, EdgesModel.class);
                return (ImmutableList) this.f17501d;
            }

            @Nullable
            public final String m25426b() {
                this.f17502e = super.a(this.f17502e, 1);
                return this.f17502e;
            }

            public final int jK_() {
                return 2126092960;
            }

            public final GraphQLVisitableModel m25424a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m25425a() != null) {
                    Builder a = ModelHelper.a(m25425a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (SuggestedWithTagsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17501d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m25423a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m25425a());
                int b = flatBufferBuilder.b(m25426b());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ SuggestedWithTagsModel m25431b() {
            return m25427j();
        }

        public FBPersonFriendTagSuggestionsQueryModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<SuggestedWithGroupsModel> m25430a() {
            this.f17503d = super.a(this.f17503d, 0, SuggestedWithGroupsModel.class);
            return (ImmutableList) this.f17503d;
        }

        @Nullable
        private SuggestedWithTagsModel m25427j() {
            this.f17504e = (SuggestedWithTagsModel) super.a(this.f17504e, 1, SuggestedWithTagsModel.class);
            return this.f17504e;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m25429a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            SuggestedWithTagsModel suggestedWithTagsModel;
            h();
            if (m25430a() != null) {
                Builder a = ModelHelper.a(m25430a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    FBPersonFriendTagSuggestionsQueryModel fBPersonFriendTagSuggestionsQueryModel = (FBPersonFriendTagSuggestionsQueryModel) ModelHelper.a(null, this);
                    fBPersonFriendTagSuggestionsQueryModel.f17503d = a.b();
                    graphQLVisitableModel = fBPersonFriendTagSuggestionsQueryModel;
                    if (m25427j() != null) {
                        suggestedWithTagsModel = (SuggestedWithTagsModel) graphQLModelMutatingVisitor.b(m25427j());
                        if (m25427j() != suggestedWithTagsModel) {
                            graphQLVisitableModel = (FBPersonFriendTagSuggestionsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17504e = suggestedWithTagsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m25427j() != null) {
                suggestedWithTagsModel = (SuggestedWithTagsModel) graphQLModelMutatingVisitor.b(m25427j());
                if (m25427j() != suggestedWithTagsModel) {
                    graphQLVisitableModel = (FBPersonFriendTagSuggestionsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17504e = suggestedWithTagsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m25428a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25430a());
            int a2 = ModelHelper.a(flatBufferBuilder, m25427j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1374309813)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: deltaVideoCall */
    public final class FBTagSearchProfileModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f17507d;
        @Nullable
        private String f17508e;
        @Nullable
        private String f17509f;
        @Nullable
        private ProfilePictureModel f17510g;
        @Nullable
        private SocialContextModel f17511h;

        /* compiled from: deltaVideoCall */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBTagSearchProfileModel.class, new Deserializer());
            }

            public Object m25432a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBTagSearchProfileParser.m25483b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBTagSearchProfileModel = new FBTagSearchProfileModel();
                ((BaseModel) fBTagSearchProfileModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBTagSearchProfileModel instanceof Postprocessable) {
                    return ((Postprocessable) fBTagSearchProfileModel).a();
                }
                return fBTagSearchProfileModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: deltaVideoCall */
        public final class ProfilePictureModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17505d;

            /* compiled from: deltaVideoCall */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                }

                public Object m25433a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FBTagSearchProfileParser.ProfilePictureParser.m25479a(jsonParser, flatBufferBuilder));
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

            /* compiled from: deltaVideoCall */
            public class Serializer extends JsonSerializer<ProfilePictureModel> {
                public final void m25434a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                    if (profilePictureModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(profilePictureModel.m25435a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FBTagSearchProfileParser.ProfilePictureParser.m25480a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                }
            }

            public ProfilePictureModel() {
                super(1);
            }

            @Nullable
            public final String m25437a() {
                this.f17505d = super.a(this.f17505d, 0);
                return this.f17505d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m25436a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m25435a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m25437a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: deltaVideoCall */
        public class Serializer extends JsonSerializer<FBTagSearchProfileModel> {
            public final void m25438a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBTagSearchProfileModel fBTagSearchProfileModel = (FBTagSearchProfileModel) obj;
                if (fBTagSearchProfileModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBTagSearchProfileModel.m25444a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBTagSearchProfileModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBTagSearchProfileParser.m25484b(fBTagSearchProfileModel.w_(), fBTagSearchProfileModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBTagSearchProfileModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: deltaVideoCall */
        public final class SocialContextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f17506d;

            /* compiled from: deltaVideoCall */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SocialContextModel.class, new Deserializer());
                }

                public Object m25439a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SocialContextParser.m25481a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object socialContextModel = new SocialContextModel();
                    ((BaseModel) socialContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (socialContextModel instanceof Postprocessable) {
                        return ((Postprocessable) socialContextModel).a();
                    }
                    return socialContextModel;
                }
            }

            /* compiled from: deltaVideoCall */
            public class Serializer extends JsonSerializer<SocialContextModel> {
                public final void m25440a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SocialContextModel socialContextModel = (SocialContextModel) obj;
                    if (socialContextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(socialContextModel.m25441a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        socialContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SocialContextParser.m25482a(socialContextModel.w_(), socialContextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SocialContextModel.class, new Serializer());
                }
            }

            public SocialContextModel() {
                super(1);
            }

            @Nullable
            public final String m25443a() {
                this.f17506d = super.a(this.f17506d, 0);
                return this.f17506d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m25442a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m25441a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m25443a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FBTagSearchProfileModel() {
            super(5);
        }

        public final void m25447a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m25448a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLObjectType m25449j() {
            if (this.b != null && this.f17507d == null) {
                this.f17507d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f17507d;
        }

        @Nullable
        public final String m25450k() {
            this.f17508e = super.a(this.f17508e, 1);
            return this.f17508e;
        }

        @Nullable
        public final String m25451l() {
            this.f17509f = super.a(this.f17509f, 2);
            return this.f17509f;
        }

        @Nullable
        public final ProfilePictureModel m25452m() {
            this.f17510g = (ProfilePictureModel) super.a(this.f17510g, 3, ProfilePictureModel.class);
            return this.f17510g;
        }

        @Nullable
        public final SocialContextModel m25453n() {
            this.f17511h = (SocialContextModel) super.a(this.f17511h, 4, SocialContextModel.class);
            return this.f17511h;
        }

        @Nullable
        public final String m25446a() {
            return m25450k();
        }

        public final int jK_() {
            return 1355227529;
        }

        public final GraphQLVisitableModel m25445a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25452m() != null) {
                ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m25452m());
                if (m25452m() != profilePictureModel) {
                    graphQLVisitableModel = (FBTagSearchProfileModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17510g = profilePictureModel;
                }
            }
            if (m25453n() != null) {
                SocialContextModel socialContextModel = (SocialContextModel) graphQLModelMutatingVisitor.b(m25453n());
                if (m25453n() != socialContextModel) {
                    graphQLVisitableModel = (FBTagSearchProfileModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17511h = socialContextModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25444a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25449j());
            int b = flatBufferBuilder.b(m25450k());
            int b2 = flatBufferBuilder.b(m25451l());
            int a2 = ModelHelper.a(flatBufferBuilder, m25452m());
            int a3 = ModelHelper.a(flatBufferBuilder, m25453n());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 550077173)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: deltaVideoCall */
    public final class TagSearchModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ResultsModel f17513d;

        /* compiled from: deltaVideoCall */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TagSearchModel.class, new Deserializer());
            }

            public Object m25454a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TagSearchParser.m25487a(jsonParser);
                Object tagSearchModel = new TagSearchModel();
                ((BaseModel) tagSearchModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (tagSearchModel instanceof Postprocessable) {
                    return ((Postprocessable) tagSearchModel).a();
                }
                return tagSearchModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 756572553)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: deltaVideoCall */
        public final class ResultsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<FBTagSearchProfileModel> f17512d;

            /* compiled from: deltaVideoCall */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ResultsModel.class, new Deserializer());
                }

                public Object m25455a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ResultsParser.m25485a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object resultsModel = new ResultsModel();
                    ((BaseModel) resultsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (resultsModel instanceof Postprocessable) {
                        return ((Postprocessable) resultsModel).a();
                    }
                    return resultsModel;
                }
            }

            /* compiled from: deltaVideoCall */
            public class Serializer extends JsonSerializer<ResultsModel> {
                public final void m25456a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ResultsModel resultsModel = (ResultsModel) obj;
                    if (resultsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(resultsModel.m25457a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        resultsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ResultsParser.m25486a(resultsModel.w_(), resultsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ResultsModel.class, new Serializer());
                }
            }

            public ResultsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<FBTagSearchProfileModel> m25459a() {
                this.f17512d = super.a(this.f17512d, 0, FBTagSearchProfileModel.class);
                return (ImmutableList) this.f17512d;
            }

            public final int jK_() {
                return 993935826;
            }

            public final GraphQLVisitableModel m25458a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m25459a() != null) {
                    Builder a = ModelHelper.a(m25459a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (ResultsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17512d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m25457a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m25459a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: deltaVideoCall */
        public class Serializer extends JsonSerializer<TagSearchModel> {
            public final void m25460a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TagSearchModel tagSearchModel = (TagSearchModel) obj;
                if (tagSearchModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(tagSearchModel.m25461a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    tagSearchModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = tagSearchModel.w_();
                int u_ = tagSearchModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("results");
                    ResultsParser.m25486a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TagSearchModel.class, new Serializer());
            }
        }

        public TagSearchModel() {
            super(1);
        }

        @Nullable
        public final ResultsModel m25463a() {
            this.f17513d = (ResultsModel) super.a(this.f17513d, 0, ResultsModel.class);
            return this.f17513d;
        }

        public final int jK_() {
            return -681190362;
        }

        public final GraphQLVisitableModel m25462a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25463a() != null) {
                ResultsModel resultsModel = (ResultsModel) graphQLModelMutatingVisitor.b(m25463a());
                if (m25463a() != resultsModel) {
                    graphQLVisitableModel = (TagSearchModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17513d = resultsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25461a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25463a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

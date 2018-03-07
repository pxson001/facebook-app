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
import com.facebook.graphql.enums.GraphQLGroupJoinState;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLParsers.DefaultImageFieldsParser;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.search.results.protocol.entity.SearchResultsGroupInterfaces.SearchResultsGroup;
import com.facebook.search.results.protocol.entity.SearchResultsGroupParsers.SearchResultsGroupParser;
import com.facebook.search.results.protocol.entity.SearchResultsGroupParsers.SearchResultsGroupParser.GroupMembersParser;
import com.facebook.search.results.protocol.entity.SearchResultsGroupParsers.SearchResultsGroupParser.GroupMembersParser.NodesParser;
import com.facebook.search.results.protocol.entity.SearchResultsGroupParsers.SearchResultsGroupParser.SocialContextParser;
import com.facebook.search.results.protocol.entity.SearchResultsGroupParsers.SearchResultsGroupParser.VisibilitySentenceParser;
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

/* compiled from: min_color */
public class SearchResultsGroupModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1172784847)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: min_color */
    public final class SearchResultsGroupModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, SearchResultsGroup {
        @Nullable
        private GroupMembersModel f8610d;
        @Nullable
        private String f8611e;
        @Nullable
        private String f8612f;
        @Nullable
        private DefaultImageFieldsModel f8613g;
        @Nullable
        private SocialContextModel f8614h;
        @Nullable
        private GraphQLGroupJoinState f8615i;
        @Nullable
        private VisibilitySentenceModel f8616j;

        /* compiled from: min_color */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SearchResultsGroupModel.class, new Deserializer());
            }

            public Object m9915a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = SearchResultsGroupParser.m9966a(jsonParser);
                Object searchResultsGroupModel = new SearchResultsGroupModel();
                ((BaseModel) searchResultsGroupModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (searchResultsGroupModel instanceof Postprocessable) {
                    return ((Postprocessable) searchResultsGroupModel).a();
                }
                return searchResultsGroupModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2080321892)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: min_color */
        public final class GroupMembersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f8605d;

            /* compiled from: min_color */
            public final class Builder {
                @Nullable
                public ImmutableList<NodesModel> f8602a;
            }

            /* compiled from: min_color */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupMembersModel.class, new Deserializer());
                }

                public Object m9916a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupMembersParser.m9960a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupMembersModel = new GroupMembersModel();
                    ((BaseModel) groupMembersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupMembersModel instanceof Postprocessable) {
                        return ((Postprocessable) groupMembersModel).a();
                    }
                    return groupMembersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1097398158)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: min_color */
            public final class NodesModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private DefaultImageFieldsModel f8604d;

                /* compiled from: min_color */
                public final class Builder {
                    @Nullable
                    public DefaultImageFieldsModel f8603a;
                }

                /* compiled from: min_color */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m9917a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m9958b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object nodesModel = new NodesModel();
                        ((BaseModel) nodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (nodesModel instanceof Postprocessable) {
                            return ((Postprocessable) nodesModel).a();
                        }
                        return nodesModel;
                    }
                }

                /* compiled from: min_color */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m9918a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m9921a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m9959b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ DefaultImageFields m9922a() {
                    return m9920j();
                }

                public NodesModel() {
                    super(1);
                }

                public NodesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final void m9924a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m9925a(String str, Object obj, boolean z) {
                }

                @Nullable
                private DefaultImageFieldsModel m9920j() {
                    this.f8604d = (DefaultImageFieldsModel) super.a(this.f8604d, 0, DefaultImageFieldsModel.class);
                    return this.f8604d;
                }

                public static NodesModel m9919a(NodesModel nodesModel) {
                    if (nodesModel == null) {
                        return null;
                    }
                    if (nodesModel instanceof NodesModel) {
                        return nodesModel;
                    }
                    Builder builder = new Builder();
                    builder.f8603a = DefaultImageFieldsModel.a(nodesModel.m9922a());
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f8603a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new NodesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m9923a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m9920j() != null) {
                        DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m9920j());
                        if (m9920j() != defaultImageFieldsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8604d = defaultImageFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m9921a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m9920j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: min_color */
            public class Serializer extends JsonSerializer<GroupMembersModel> {
                public final void m9926a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupMembersModel groupMembersModel = (GroupMembersModel) obj;
                    if (groupMembersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupMembersModel.m9928a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupMembersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupMembersParser.m9961a(groupMembersModel.w_(), groupMembersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupMembersModel.class, new Serializer());
                }
            }

            public GroupMembersModel() {
                super(1);
            }

            public GroupMembersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<NodesModel> m9930a() {
                this.f8605d = super.a(this.f8605d, 0, NodesModel.class);
                return (ImmutableList) this.f8605d;
            }

            public static GroupMembersModel m9927a(GroupMembersModel groupMembersModel) {
                if (groupMembersModel == null) {
                    return null;
                }
                if (groupMembersModel instanceof GroupMembersModel) {
                    return groupMembersModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < groupMembersModel.m9930a().size(); i++) {
                    builder2.c(NodesModel.m9919a((NodesModel) groupMembersModel.m9930a().get(i)));
                }
                builder.f8602a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f8602a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new GroupMembersModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return 103365688;
            }

            public final GraphQLVisitableModel m9929a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m9930a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m9930a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (GroupMembersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8605d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m9928a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m9930a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: min_color */
        public class Serializer extends JsonSerializer<SearchResultsGroupModel> {
            public final void m9931a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                SearchResultsGroupModel searchResultsGroupModel = (SearchResultsGroupModel) obj;
                if (searchResultsGroupModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(searchResultsGroupModel.m9953a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    searchResultsGroupModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = searchResultsGroupModel.w_();
                int u_ = searchResultsGroupModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_members");
                    GroupMembersParser.m9961a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("profile_picture");
                    DefaultImageFieldsParser.a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 4);
                if (g != 0) {
                    jsonGenerator.a("social_context");
                    SocialContextParser.m9963a(mutableFlatBuffer, g, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 5) != 0) {
                    jsonGenerator.a("viewer_join_state");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 5));
                }
                g = mutableFlatBuffer.g(u_, 6);
                if (g != 0) {
                    jsonGenerator.a("visibility_sentence");
                    VisibilitySentenceParser.m9965a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(SearchResultsGroupModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: min_color */
        public final class SocialContextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8607d;

            /* compiled from: min_color */
            public final class Builder {
                @Nullable
                public String f8606a;
            }

            /* compiled from: min_color */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(SocialContextModel.class, new Deserializer());
                }

                public Object m9932a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(SocialContextParser.m9962a(jsonParser, flatBufferBuilder));
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

            /* compiled from: min_color */
            public class Serializer extends JsonSerializer<SocialContextModel> {
                public final void m9933a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    SocialContextModel socialContextModel = (SocialContextModel) obj;
                    if (socialContextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(socialContextModel.m9935a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        socialContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    SocialContextParser.m9963a(socialContextModel.w_(), socialContextModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(SocialContextModel.class, new Serializer());
                }
            }

            public SocialContextModel() {
                super(1);
            }

            public SocialContextModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m9937a() {
                this.f8607d = super.a(this.f8607d, 0);
                return this.f8607d;
            }

            public static SocialContextModel m9934a(SocialContextModel socialContextModel) {
                if (socialContextModel == null) {
                    return null;
                }
                if (socialContextModel instanceof SocialContextModel) {
                    return socialContextModel;
                }
                Builder builder = new Builder();
                builder.f8606a = socialContextModel.m9937a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8606a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SocialContextModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m9936a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9935a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9937a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: min_color */
        public final class VisibilitySentenceModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f8609d;

            /* compiled from: min_color */
            public final class Builder {
                @Nullable
                public String f8608a;
            }

            /* compiled from: min_color */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(VisibilitySentenceModel.class, new Deserializer());
                }

                public Object m9938a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(VisibilitySentenceParser.m9964a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object visibilitySentenceModel = new VisibilitySentenceModel();
                    ((BaseModel) visibilitySentenceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (visibilitySentenceModel instanceof Postprocessable) {
                        return ((Postprocessable) visibilitySentenceModel).a();
                    }
                    return visibilitySentenceModel;
                }
            }

            /* compiled from: min_color */
            public class Serializer extends JsonSerializer<VisibilitySentenceModel> {
                public final void m9939a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    VisibilitySentenceModel visibilitySentenceModel = (VisibilitySentenceModel) obj;
                    if (visibilitySentenceModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(visibilitySentenceModel.m9941a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        visibilitySentenceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    VisibilitySentenceParser.m9965a(visibilitySentenceModel.w_(), visibilitySentenceModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(VisibilitySentenceModel.class, new Serializer());
                }
            }

            public VisibilitySentenceModel() {
                super(1);
            }

            public VisibilitySentenceModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m9943a() {
                this.f8609d = super.a(this.f8609d, 0);
                return this.f8609d;
            }

            public static VisibilitySentenceModel m9940a(VisibilitySentenceModel visibilitySentenceModel) {
                if (visibilitySentenceModel == null) {
                    return null;
                }
                if (visibilitySentenceModel instanceof VisibilitySentenceModel) {
                    return visibilitySentenceModel;
                }
                Builder builder = new Builder();
                builder.f8608a = visibilitySentenceModel.m9943a();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f8608a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new VisibilitySentenceModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m9942a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m9941a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m9943a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public SearchResultsGroupModel() {
            super(7);
        }

        public final void m9956a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = m9948l();
                consistencyTuple.b = u_();
                consistencyTuple.c = 2;
            } else if ("viewer_join_state".equals(str)) {
                consistencyTuple.a = m9951o();
                consistencyTuple.b = u_();
                consistencyTuple.c = 5;
            } else {
                consistencyTuple.a();
            }
        }

        public final void m9957a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m9945a((String) obj);
            } else if ("viewer_join_state".equals(str)) {
                m9944a((GraphQLGroupJoinState) obj);
            }
        }

        @Nullable
        private GroupMembersModel m9946j() {
            this.f8610d = (GroupMembersModel) super.a(this.f8610d, 0, GroupMembersModel.class);
            return this.f8610d;
        }

        @Nullable
        private String m9947k() {
            this.f8611e = super.a(this.f8611e, 1);
            return this.f8611e;
        }

        @Nullable
        private String m9948l() {
            this.f8612f = super.a(this.f8612f, 2);
            return this.f8612f;
        }

        private void m9945a(@Nullable String str) {
            this.f8612f = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 2, str);
            }
        }

        @Nullable
        private DefaultImageFieldsModel m9949m() {
            this.f8613g = (DefaultImageFieldsModel) super.a(this.f8613g, 3, DefaultImageFieldsModel.class);
            return this.f8613g;
        }

        @Nullable
        private SocialContextModel m9950n() {
            this.f8614h = (SocialContextModel) super.a(this.f8614h, 4, SocialContextModel.class);
            return this.f8614h;
        }

        @Nullable
        private GraphQLGroupJoinState m9951o() {
            this.f8615i = (GraphQLGroupJoinState) super.b(this.f8615i, 5, GraphQLGroupJoinState.class, GraphQLGroupJoinState.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f8615i;
        }

        private void m9944a(GraphQLGroupJoinState graphQLGroupJoinState) {
            this.f8615i = graphQLGroupJoinState;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 5, graphQLGroupJoinState != null ? graphQLGroupJoinState.name() : null);
            }
        }

        @Nullable
        private VisibilitySentenceModel m9952p() {
            this.f8616j = (VisibilitySentenceModel) super.a(this.f8616j, 6, VisibilitySentenceModel.class);
            return this.f8616j;
        }

        @Nullable
        public final String m9955a() {
            return m9947k();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m9954a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m9946j() != null) {
                GroupMembersModel groupMembersModel = (GroupMembersModel) graphQLModelMutatingVisitor.b(m9946j());
                if (m9946j() != groupMembersModel) {
                    graphQLVisitableModel = (SearchResultsGroupModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8610d = groupMembersModel;
                }
            }
            if (m9949m() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m9949m());
                if (m9949m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (SearchResultsGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8613g = defaultImageFieldsModel;
                }
            }
            if (m9950n() != null) {
                SocialContextModel socialContextModel = (SocialContextModel) graphQLModelMutatingVisitor.b(m9950n());
                if (m9950n() != socialContextModel) {
                    graphQLVisitableModel = (SearchResultsGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8614h = socialContextModel;
                }
            }
            if (m9952p() != null) {
                VisibilitySentenceModel visibilitySentenceModel = (VisibilitySentenceModel) graphQLModelMutatingVisitor.b(m9952p());
                if (m9952p() != visibilitySentenceModel) {
                    graphQLVisitableModel = (SearchResultsGroupModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8616j = visibilitySentenceModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m9953a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m9946j());
            int b = flatBufferBuilder.b(m9947k());
            int b2 = flatBufferBuilder.b(m9948l());
            int a2 = ModelHelper.a(flatBufferBuilder, m9949m());
            int a3 = ModelHelper.a(flatBufferBuilder, m9950n());
            int a4 = flatBufferBuilder.a(m9951o());
            int a5 = ModelHelper.a(flatBufferBuilder, m9952p());
            flatBufferBuilder.c(7);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, a4);
            flatBufferBuilder.b(6, a5);
            i();
            return flatBufferBuilder.d();
        }
    }
}

package com.facebook.groups.memberlist.protocol;

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
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberSearchParsers.FetchGroupMemberSearchParser;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberSearchParsers.FetchGroupMemberSearchParser.GroupMentionsParser;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberSearchParsers.FetchGroupMemberSearchParser.GroupMentionsParser.MemberSectionParser;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberSearchParsers.FetchGroupMemberSearchParser.GroupMentionsParser.MemberSectionParser.EdgesParser;
import com.facebook.groups.memberlist.protocol.FetchGroupMemberSearchParsers.FetchGroupMemberSearchParser.GroupMentionsParser.MemberSectionParser.PageInfoParser;
import com.facebook.groups.widget.memberrow.protocol.MemberDataModels.GroupMemberDataModel;
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

/* compiled from: extra_events_discovery_suggestion_token */
public class FetchGroupMemberSearchModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -894793149)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: extra_events_discovery_suggestion_token */
    public final class FetchGroupMemberSearchModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GroupMentionsModel f14546d;

        /* compiled from: extra_events_discovery_suggestion_token */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupMemberSearchModel.class, new Deserializer());
            }

            public Object m16293a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGroupMemberSearchParser.m16332a(jsonParser);
                Object fetchGroupMemberSearchModel = new FetchGroupMemberSearchModel();
                ((BaseModel) fetchGroupMemberSearchModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGroupMemberSearchModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupMemberSearchModel).a();
                }
                return fetchGroupMemberSearchModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -507468421)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: extra_events_discovery_suggestion_token */
        public final class GroupMentionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private MemberSectionModel f14545d;

            /* compiled from: extra_events_discovery_suggestion_token */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GroupMentionsModel.class, new Deserializer());
                }

                public Object m16294a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GroupMentionsParser.m16330a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object groupMentionsModel = new GroupMentionsModel();
                    ((BaseModel) groupMentionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (groupMentionsModel instanceof Postprocessable) {
                        return ((Postprocessable) groupMentionsModel).a();
                    }
                    return groupMentionsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1075486375)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: extra_events_discovery_suggestion_token */
            public final class MemberSectionModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<EdgesModel> f14543d;
                @Nullable
                private PageInfoModel f14544e;

                /* compiled from: extra_events_discovery_suggestion_token */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MemberSectionModel.class, new Deserializer());
                    }

                    public Object m16295a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MemberSectionParser.m16328a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object memberSectionModel = new MemberSectionModel();
                        ((BaseModel) memberSectionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (memberSectionModel instanceof Postprocessable) {
                            return ((Postprocessable) memberSectionModel).a();
                        }
                        return memberSectionModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1605889339)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: extra_events_discovery_suggestion_token */
                public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private GroupMemberDataModel f14537d;

                    /* compiled from: extra_events_discovery_suggestion_token */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                        }

                        public Object m16296a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EdgesParser.m16324b(jsonParser, flatBufferBuilder));
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

                    /* compiled from: extra_events_discovery_suggestion_token */
                    public class Serializer extends JsonSerializer<EdgesModel> {
                        public final void m16297a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EdgesModel edgesModel = (EdgesModel) obj;
                            if (edgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(edgesModel.m16299a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EdgesParser.m16325b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EdgesModel.class, new Serializer());
                        }
                    }

                    public EdgesModel() {
                        super(1);
                    }

                    @Nullable
                    private GroupMemberDataModel m16298a() {
                        this.f14537d = (GroupMemberDataModel) super.a(this.f14537d, 0, GroupMemberDataModel.class);
                        return this.f14537d;
                    }

                    public final int jK_() {
                        return -959107873;
                    }

                    public final GraphQLVisitableModel m16300a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m16298a() != null) {
                            GroupMemberDataModel groupMemberDataModel = (GroupMemberDataModel) graphQLModelMutatingVisitor.b(m16298a());
                            if (m16298a() != groupMemberDataModel) {
                                graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f14537d = groupMemberDataModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m16299a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m16298a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1536830492)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: extra_events_discovery_suggestion_token */
                public final class PageInfoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f14538d;
                    @Nullable
                    private String f14539e;
                    private boolean f14540f;
                    private boolean f14541g;
                    @Nullable
                    private String f14542h;

                    /* compiled from: extra_events_discovery_suggestion_token */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PageInfoModel.class, new Deserializer());
                        }

                        public Object m16301a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PageInfoParser.m16326a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object pageInfoModel = new PageInfoModel();
                            ((BaseModel) pageInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (pageInfoModel instanceof Postprocessable) {
                                return ((Postprocessable) pageInfoModel).a();
                            }
                            return pageInfoModel;
                        }
                    }

                    /* compiled from: extra_events_discovery_suggestion_token */
                    public class Serializer extends JsonSerializer<PageInfoModel> {
                        public final void m16302a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PageInfoModel pageInfoModel = (PageInfoModel) obj;
                            if (pageInfoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(pageInfoModel.m16306a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                pageInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PageInfoParser.m16327a(pageInfoModel.w_(), pageInfoModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PageInfoModel.class, new Serializer());
                        }
                    }

                    public PageInfoModel() {
                        super(5);
                    }

                    @Nullable
                    private String m16303a() {
                        this.f14538d = super.a(this.f14538d, 0);
                        return this.f14538d;
                    }

                    @Nullable
                    private String m16304j() {
                        this.f14539e = super.a(this.f14539e, 1);
                        return this.f14539e;
                    }

                    @Nullable
                    private String m16305k() {
                        this.f14542h = super.a(this.f14542h, 4);
                        return this.f14542h;
                    }

                    public final int jK_() {
                        return 923779069;
                    }

                    public final GraphQLVisitableModel m16307a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m16306a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m16303a());
                        int b2 = flatBufferBuilder.b(m16304j());
                        int b3 = flatBufferBuilder.b(m16305k());
                        flatBufferBuilder.c(5);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, b2);
                        flatBufferBuilder.a(2, this.f14540f);
                        flatBufferBuilder.a(3, this.f14541g);
                        flatBufferBuilder.b(4, b3);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m16308a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f14540f = mutableFlatBuffer.a(i, 2);
                        this.f14541g = mutableFlatBuffer.a(i, 3);
                    }
                }

                /* compiled from: extra_events_discovery_suggestion_token */
                public class Serializer extends JsonSerializer<MemberSectionModel> {
                    public final void m16309a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MemberSectionModel memberSectionModel = (MemberSectionModel) obj;
                        if (memberSectionModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(memberSectionModel.m16312a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            memberSectionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MemberSectionParser.m16329a(memberSectionModel.w_(), memberSectionModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(MemberSectionModel.class, new Serializer());
                    }
                }

                public MemberSectionModel() {
                    super(2);
                }

                @Nonnull
                private ImmutableList<EdgesModel> m16310a() {
                    this.f14543d = super.a(this.f14543d, 0, EdgesModel.class);
                    return (ImmutableList) this.f14543d;
                }

                @Nullable
                private PageInfoModel m16311j() {
                    this.f14544e = (PageInfoModel) super.a(this.f14544e, 1, PageInfoModel.class);
                    return this.f14544e;
                }

                public final int jK_() {
                    return 359849088;
                }

                public final GraphQLVisitableModel m16313a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel;
                    PageInfoModel pageInfoModel;
                    h();
                    if (m16310a() != null) {
                        Builder a = ModelHelper.a(m16310a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            MemberSectionModel memberSectionModel = (MemberSectionModel) ModelHelper.a(null, this);
                            memberSectionModel.f14543d = a.b();
                            graphQLVisitableModel = memberSectionModel;
                            if (m16311j() != null) {
                                pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m16311j());
                                if (m16311j() != pageInfoModel) {
                                    graphQLVisitableModel = (MemberSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f14544e = pageInfoModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m16311j() != null) {
                        pageInfoModel = (PageInfoModel) graphQLModelMutatingVisitor.b(m16311j());
                        if (m16311j() != pageInfoModel) {
                            graphQLVisitableModel = (MemberSectionModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f14544e = pageInfoModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m16312a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m16310a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m16311j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: extra_events_discovery_suggestion_token */
            public class Serializer extends JsonSerializer<GroupMentionsModel> {
                public final void m16314a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GroupMentionsModel groupMentionsModel = (GroupMentionsModel) obj;
                    if (groupMentionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(groupMentionsModel.m16316a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        groupMentionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GroupMentionsParser.m16331a(groupMentionsModel.w_(), groupMentionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GroupMentionsModel.class, new Serializer());
                }
            }

            public GroupMentionsModel() {
                super(1);
            }

            @Nullable
            private MemberSectionModel m16315a() {
                this.f14545d = (MemberSectionModel) super.a(this.f14545d, 0, MemberSectionModel.class);
                return this.f14545d;
            }

            public final int jK_() {
                return -514559625;
            }

            public final GraphQLVisitableModel m16317a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16315a() != null) {
                    MemberSectionModel memberSectionModel = (MemberSectionModel) graphQLModelMutatingVisitor.b(m16315a());
                    if (m16315a() != memberSectionModel) {
                        graphQLVisitableModel = (GroupMentionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f14545d = memberSectionModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16316a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16315a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: extra_events_discovery_suggestion_token */
        public class Serializer extends JsonSerializer<FetchGroupMemberSearchModel> {
            public final void m16318a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGroupMemberSearchModel fetchGroupMemberSearchModel = (FetchGroupMemberSearchModel) obj;
                if (fetchGroupMemberSearchModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupMemberSearchModel.m16320a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupMemberSearchModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGroupMemberSearchModel.w_();
                int u_ = fetchGroupMemberSearchModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("group_mentions");
                    GroupMentionsParser.m16331a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGroupMemberSearchModel.class, new Serializer());
            }
        }

        public FetchGroupMemberSearchModel() {
            super(1);
        }

        public final void m16322a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16323a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GroupMentionsModel m16319a() {
            this.f14546d = (GroupMentionsModel) super.a(this.f14546d, 0, GroupMentionsModel.class);
            return this.f14546d;
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m16321a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16319a() != null) {
                GroupMentionsModel groupMentionsModel = (GroupMentionsModel) graphQLModelMutatingVisitor.b(m16319a());
                if (m16319a() != groupMentionsModel) {
                    graphQLVisitableModel = (FetchGroupMemberSearchModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f14546d = groupMentionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16320a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16319a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

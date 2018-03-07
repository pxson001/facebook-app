package com.facebook.auth.protocol;

import com.facebook.auth.protocol.WorkCommunityPeekGraphQLParsers.WorkCommunityPeekQueryParser;
import com.facebook.auth.protocol.WorkCommunityPeekGraphQLParsers.WorkCommunityPeekQueryParser.WorkCommunityParser;
import com.facebook.auth.protocol.WorkCommunityPeekGraphQLParsers.WorkCommunityPeekQueryParser.WorkCommunityParser.GroupLogoParser;
import com.facebook.auth.protocol.WorkCommunityPeekGraphQLParsers.WorkCommunityPeekQueryParser.WorkUsersParser;
import com.facebook.auth.protocol.WorkCommunityPeekGraphQLParsers.WorkCommunityPeekQueryParser.WorkUsersParser.CommunityParser;
import com.facebook.auth.protocol.WorkCommunityPeekGraphQLParsers.WorkCommunityPeekQueryParser.WorkUsersParser.CommunityParser.LogoParser;
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

/* compiled from: suggested_taggable_activities */
public class WorkCommunityPeekGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1848343643)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: suggested_taggable_activities */
    public final class WorkCommunityPeekQueryModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f2390d;
        @Nullable
        private WorkCommunityModel f2391e;
        @Nullable
        private String f2392f;
        @Nullable
        private List<WorkUsersModel> f2393g;

        /* compiled from: suggested_taggable_activities */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(WorkCommunityPeekQueryModel.class, new Deserializer());
            }

            public Object m3248a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(WorkCommunityPeekQueryParser.m3304a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object workCommunityPeekQueryModel = new WorkCommunityPeekQueryModel();
                ((BaseModel) workCommunityPeekQueryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (workCommunityPeekQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) workCommunityPeekQueryModel).a();
                }
                return workCommunityPeekQueryModel;
            }
        }

        /* compiled from: suggested_taggable_activities */
        public class Serializer extends JsonSerializer<WorkCommunityPeekQueryModel> {
            public final void m3249a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                WorkCommunityPeekQueryModel workCommunityPeekQueryModel = (WorkCommunityPeekQueryModel) obj;
                if (workCommunityPeekQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(workCommunityPeekQueryModel.m3286a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    workCommunityPeekQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = workCommunityPeekQueryModel.w_();
                int u_ = workCommunityPeekQueryModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("is_work_user");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("work_community");
                    WorkCommunityParser.m3296a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("work_subdomain");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("work_users");
                    jsonGenerator.d();
                    for (int i = 0; i < mutableFlatBuffer.c(g); i++) {
                        WorkUsersParser.m3303b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(WorkCommunityPeekQueryModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1734496294)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggested_taggable_activities */
        public final class WorkCommunityModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GroupLogoModel f2379d;
            @Nullable
            private String f2380e;
            @Nullable
            private String f2381f;

            /* compiled from: suggested_taggable_activities */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(WorkCommunityModel.class, new Deserializer());
                }

                public Object m3250a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(WorkCommunityParser.m3295a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object workCommunityModel = new WorkCommunityModel();
                    ((BaseModel) workCommunityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (workCommunityModel instanceof Postprocessable) {
                        return ((Postprocessable) workCommunityModel).a();
                    }
                    return workCommunityModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: suggested_taggable_activities */
            public final class GroupLogoModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f2378d;

                /* compiled from: suggested_taggable_activities */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(GroupLogoModel.class, new Deserializer());
                    }

                    public Object m3251a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(GroupLogoParser.m3293a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object groupLogoModel = new GroupLogoModel();
                        ((BaseModel) groupLogoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (groupLogoModel instanceof Postprocessable) {
                            return ((Postprocessable) groupLogoModel).a();
                        }
                        return groupLogoModel;
                    }
                }

                /* compiled from: suggested_taggable_activities */
                public class Serializer extends JsonSerializer<GroupLogoModel> {
                    public final void m3252a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        GroupLogoModel groupLogoModel = (GroupLogoModel) obj;
                        if (groupLogoModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(groupLogoModel.m3253a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            groupLogoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        GroupLogoParser.m3294a(groupLogoModel.w_(), groupLogoModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(GroupLogoModel.class, new Serializer());
                    }
                }

                public GroupLogoModel() {
                    super(1);
                }

                @Nullable
                public final String m3255a() {
                    this.f2378d = super.a(this.f2378d, 0);
                    return this.f2378d;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m3254a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m3253a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m3255a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: suggested_taggable_activities */
            public class Serializer extends JsonSerializer<WorkCommunityModel> {
                public final void m3256a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    WorkCommunityModel workCommunityModel = (WorkCommunityModel) obj;
                    if (workCommunityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(workCommunityModel.m3258a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        workCommunityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    WorkCommunityParser.m3296a(workCommunityModel.w_(), workCommunityModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(WorkCommunityModel.class, new Serializer());
                }
            }

            public WorkCommunityModel() {
                super(3);
            }

            public final void m3261a(String str, ConsistencyTuple consistencyTuple) {
                if ("name".equals(str)) {
                    consistencyTuple.a = m3265l();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m3262a(String str, Object obj, boolean z) {
                if ("name".equals(str)) {
                    m3257a((String) obj);
                }
            }

            @Nullable
            public final GroupLogoModel m3263j() {
                this.f2379d = (GroupLogoModel) super.a(this.f2379d, 0, GroupLogoModel.class);
                return this.f2379d;
            }

            @Nullable
            public final String m3264k() {
                this.f2380e = super.a(this.f2380e, 1);
                return this.f2380e;
            }

            @Nullable
            public final String m3265l() {
                this.f2381f = super.a(this.f2381f, 2);
                return this.f2381f;
            }

            private void m3257a(@Nullable String str) {
                this.f2381f = str;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, str);
                }
            }

            @Nullable
            public final String m3260a() {
                return m3264k();
            }

            public final int jK_() {
                return 69076575;
            }

            public final GraphQLVisitableModel m3259a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3263j() != null) {
                    GroupLogoModel groupLogoModel = (GroupLogoModel) graphQLModelMutatingVisitor.b(m3263j());
                    if (m3263j() != groupLogoModel) {
                        graphQLVisitableModel = (WorkCommunityModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2379d = groupLogoModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3258a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3263j());
                int b = flatBufferBuilder.b(m3264k());
                int b2 = flatBufferBuilder.b(m3265l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1651033048)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: suggested_taggable_activities */
        public final class WorkUsersModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private CommunityModel f2387d;
            @Nullable
            private String f2388e;
            @Nullable
            private String f2389f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 34097976)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: suggested_taggable_activities */
            public final class CommunityModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f2383d;
                @Nullable
                private LogoModel f2384e;
                @Nullable
                private String f2385f;
                @Nullable
                private String f2386g;

                /* compiled from: suggested_taggable_activities */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CommunityModel.class, new Deserializer());
                    }

                    public Object m3266a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CommunityParser.m3299a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object communityModel = new CommunityModel();
                        ((BaseModel) communityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (communityModel instanceof Postprocessable) {
                            return ((Postprocessable) communityModel).a();
                        }
                        return communityModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 842551240)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: suggested_taggable_activities */
                public final class LogoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f2382d;

                    /* compiled from: suggested_taggable_activities */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(LogoModel.class, new Deserializer());
                        }

                        public Object m3267a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(LogoParser.m3297a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object logoModel = new LogoModel();
                            ((BaseModel) logoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (logoModel instanceof Postprocessable) {
                                return ((Postprocessable) logoModel).a();
                            }
                            return logoModel;
                        }
                    }

                    /* compiled from: suggested_taggable_activities */
                    public class Serializer extends JsonSerializer<LogoModel> {
                        public final void m3268a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            LogoModel logoModel = (LogoModel) obj;
                            if (logoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(logoModel.m3269a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                logoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            LogoParser.m3298a(logoModel.w_(), logoModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(LogoModel.class, new Serializer());
                        }
                    }

                    public LogoModel() {
                        super(1);
                    }

                    @Nullable
                    public final String m3271a() {
                        this.f2382d = super.a(this.f2382d, 0);
                        return this.f2382d;
                    }

                    public final int jK_() {
                        return 70760763;
                    }

                    public final GraphQLVisitableModel m3270a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m3269a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m3271a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: suggested_taggable_activities */
                public class Serializer extends JsonSerializer<CommunityModel> {
                    public final void m3272a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CommunityModel communityModel = (CommunityModel) obj;
                        if (communityModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(communityModel.m3273a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            communityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CommunityParser.m3300a(communityModel.w_(), communityModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(CommunityModel.class, new Serializer());
                    }
                }

                public CommunityModel() {
                    super(4);
                }

                @Nullable
                public final String m3275a() {
                    this.f2383d = super.a(this.f2383d, 0);
                    return this.f2383d;
                }

                @Nullable
                public final LogoModel m3276j() {
                    this.f2384e = (LogoModel) super.a(this.f2384e, 1, LogoModel.class);
                    return this.f2384e;
                }

                @Nullable
                public final String m3277k() {
                    this.f2385f = super.a(this.f2385f, 2);
                    return this.f2385f;
                }

                @Nullable
                public final String m3278l() {
                    this.f2386g = super.a(this.f2386g, 3);
                    return this.f2386g;
                }

                public final int jK_() {
                    return -1282382541;
                }

                public final GraphQLVisitableModel m3274a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m3276j() != null) {
                        LogoModel logoModel = (LogoModel) graphQLModelMutatingVisitor.b(m3276j());
                        if (m3276j() != logoModel) {
                            graphQLVisitableModel = (CommunityModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f2384e = logoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m3273a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m3275a());
                    int a = ModelHelper.a(flatBufferBuilder, m3276j());
                    int b2 = flatBufferBuilder.b(m3277k());
                    int b3 = flatBufferBuilder.b(m3278l());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: suggested_taggable_activities */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(WorkUsersModel.class, new Deserializer());
                }

                public Object m3279a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(WorkUsersParser.m3302b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object workUsersModel = new WorkUsersModel();
                    ((BaseModel) workUsersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (workUsersModel instanceof Postprocessable) {
                        return ((Postprocessable) workUsersModel).a();
                    }
                    return workUsersModel;
                }
            }

            /* compiled from: suggested_taggable_activities */
            public class Serializer extends JsonSerializer<WorkUsersModel> {
                public final void m3280a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    WorkUsersModel workUsersModel = (WorkUsersModel) obj;
                    if (workUsersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(workUsersModel.m3282a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        workUsersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    WorkUsersParser.m3303b(workUsersModel.w_(), workUsersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(WorkUsersModel.class, new Serializer());
                }
            }

            public WorkUsersModel() {
                super(3);
            }

            @Nullable
            public final CommunityModel m3283a() {
                this.f2387d = (CommunityModel) super.a(this.f2387d, 0, CommunityModel.class);
                return this.f2387d;
            }

            @Nullable
            public final String m3285j() {
                this.f2388e = super.a(this.f2388e, 1);
                return this.f2388e;
            }

            @Nullable
            private String m3281k() {
                this.f2389f = super.a(this.f2389f, 2);
                return this.f2389f;
            }

            public final int jK_() {
                return -506605033;
            }

            public final GraphQLVisitableModel m3284a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m3283a() != null) {
                    CommunityModel communityModel = (CommunityModel) graphQLModelMutatingVisitor.b(m3283a());
                    if (m3283a() != communityModel) {
                        graphQLVisitableModel = (WorkUsersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f2387d = communityModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m3282a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m3283a());
                int b = flatBufferBuilder.b(m3285j());
                int b2 = flatBufferBuilder.b(m3281k());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        public WorkCommunityPeekQueryModel() {
            super(4);
        }

        public final boolean m3289a() {
            a(0, 0);
            return this.f2390d;
        }

        @Nullable
        public final WorkCommunityModel m3290j() {
            this.f2391e = (WorkCommunityModel) super.a(this.f2391e, 1, WorkCommunityModel.class);
            return this.f2391e;
        }

        @Nullable
        public final String m3291k() {
            this.f2392f = super.a(this.f2392f, 2);
            return this.f2392f;
        }

        @Nonnull
        public final ImmutableList<WorkUsersModel> m3292l() {
            this.f2393g = super.a(this.f2393g, 3, WorkUsersModel.class);
            return (ImmutableList) this.f2393g;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m3287a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m3290j() != null) {
                WorkCommunityModel workCommunityModel = (WorkCommunityModel) graphQLModelMutatingVisitor.b(m3290j());
                if (m3290j() != workCommunityModel) {
                    graphQLVisitableModel = (WorkCommunityPeekQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f2391e = workCommunityModel;
                }
            }
            if (m3292l() != null) {
                Builder a = ModelHelper.a(m3292l(), graphQLModelMutatingVisitor);
                if (a != null) {
                    WorkCommunityPeekQueryModel workCommunityPeekQueryModel = (WorkCommunityPeekQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    workCommunityPeekQueryModel.f2393g = a.b();
                    graphQLVisitableModel = workCommunityPeekQueryModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m3286a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m3290j());
            int b = flatBufferBuilder.b(m3291k());
            int a2 = ModelHelper.a(flatBufferBuilder, m3292l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.a(0, this.f2390d);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m3288a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f2390d = mutableFlatBuffer.a(i, 0);
        }
    }
}

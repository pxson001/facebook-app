package com.facebook.pages.common.protocol.graphql;

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
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.common.protocol.graphql.FetchNewLikesGraphQLParsers.FetchNewLikesQueryParser;
import com.facebook.pages.common.protocol.graphql.FetchNewLikesGraphQLParsers.FetchNewLikesQueryParser.PageLikersParser;
import com.facebook.pages.common.protocol.graphql.FetchNewLikesGraphQLParsers.FetchNewLikesQueryParser.PageLikersParser.NodesParser;
import com.facebook.pages.common.protocol.graphql.FetchNewLikesGraphQLParsers.FetchNewLikesQueryParser.PageLikersParser.NodesParser.EducationExperiencesParser;
import com.facebook.pages.common.protocol.graphql.FetchNewLikesGraphQLParsers.FetchNewLikesQueryParser.PageLikersParser.NodesParser.EducationExperiencesParser.EducationExperiencesNodesParser;
import com.facebook.pages.common.protocol.graphql.FetchNewLikesGraphQLParsers.FetchNewLikesQueryParser.PageLikersParser.NodesParser.EducationExperiencesParser.EducationExperiencesNodesParser.SchoolParser;
import com.facebook.pages.common.protocol.graphql.FetchNewLikesGraphQLParsers.FetchNewLikesQueryParser.PageLikersParser.NodesParser.WorkExperiencesParser;
import com.facebook.pages.common.protocol.graphql.FetchNewLikesGraphQLParsers.FetchNewLikesQueryParser.PageLikersParser.NodesParser.WorkExperiencesParser.WorkExperiencesNodesParser;
import com.facebook.pages.common.protocol.graphql.FetchNewLikesGraphQLParsers.FetchNewLikesQueryParser.PageLikersParser.NodesParser.WorkExperiencesParser.WorkExperiencesNodesParser.EmployerParser;
import com.facebook.pages.common.protocol.graphql.FetchNewLikesGraphQLParsers.FetchNewLikesQueryParser.PageLikersParser.NodesParser.WorkExperiencesParser.WorkExperiencesNodesParser.PositionParser;
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

/* compiled from: setReferencedStickerData */
public class FetchNewLikesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 245222512)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: setReferencedStickerData */
    public final class FetchNewLikesQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f1768d;
        @Nullable
        private String f1769e;
        @Nullable
        private PageLikersModel f1770f;

        /* compiled from: setReferencedStickerData */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchNewLikesQueryModel.class, new Deserializer());
            }

            public Object m2600a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchNewLikesQueryParser.m2686a(jsonParser);
                Object fetchNewLikesQueryModel = new FetchNewLikesQueryModel();
                ((BaseModel) fetchNewLikesQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchNewLikesQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchNewLikesQueryModel).a();
                }
                return fetchNewLikesQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 894701033)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setReferencedStickerData */
        public final class PageLikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f1766d;
            @Nullable
            private List<NodesModel> f1767e;

            /* compiled from: setReferencedStickerData */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageLikersModel.class, new Deserializer());
                }

                public Object m2601a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageLikersParser.m2684a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageLikersModel = new PageLikersModel();
                    ((BaseModel) pageLikersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageLikersModel instanceof Postprocessable) {
                        return ((Postprocessable) pageLikersModel).a();
                    }
                    return pageLikersModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1431957885)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setReferencedStickerData */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private EducationExperiencesModel f1762d;
                @Nullable
                private String f1763e;
                @Nullable
                private String f1764f;
                @Nullable
                private WorkExperiencesModel f1765g;

                /* compiled from: setReferencedStickerData */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m2602a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m2682b(jsonParser, flatBufferBuilder));
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

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1985084269)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: setReferencedStickerData */
                public final class EducationExperiencesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<EducationExperiencesNodesModel> f1756d;

                    /* compiled from: setReferencedStickerData */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EducationExperiencesModel.class, new Deserializer());
                        }

                        public Object m2603a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EducationExperiencesParser.m2672a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object educationExperiencesModel = new EducationExperiencesModel();
                            ((BaseModel) educationExperiencesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (educationExperiencesModel instanceof Postprocessable) {
                                return ((Postprocessable) educationExperiencesModel).a();
                            }
                            return educationExperiencesModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1652467971)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: setReferencedStickerData */
                    public final class EducationExperiencesNodesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private SchoolModel f1755d;

                        /* compiled from: setReferencedStickerData */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(EducationExperiencesNodesModel.class, new Deserializer());
                            }

                            public Object m2604a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(EducationExperiencesNodesParser.m2670b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object educationExperiencesNodesModel = new EducationExperiencesNodesModel();
                                ((BaseModel) educationExperiencesNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (educationExperiencesNodesModel instanceof Postprocessable) {
                                    return ((Postprocessable) educationExperiencesNodesModel).a();
                                }
                                return educationExperiencesNodesModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 273304230)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: setReferencedStickerData */
                        public final class SchoolModel extends BaseModel implements GraphQLVisitableConsistentModel {
                            @Nullable
                            private String f1754d;

                            /* compiled from: setReferencedStickerData */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(SchoolModel.class, new Deserializer());
                                }

                                public Object m2605a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(SchoolParser.m2668a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object schoolModel = new SchoolModel();
                                    ((BaseModel) schoolModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (schoolModel instanceof Postprocessable) {
                                        return ((Postprocessable) schoolModel).a();
                                    }
                                    return schoolModel;
                                }
                            }

                            /* compiled from: setReferencedStickerData */
                            public class Serializer extends JsonSerializer<SchoolModel> {
                                public final void m2606a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    SchoolModel schoolModel = (SchoolModel) obj;
                                    if (schoolModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(schoolModel.m2608a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        schoolModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    SchoolParser.m2669a(schoolModel.w_(), schoolModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(SchoolModel.class, new Serializer());
                                }
                            }

                            public SchoolModel() {
                                super(1);
                            }

                            public final void m2610a(String str, ConsistencyTuple consistencyTuple) {
                                consistencyTuple.a();
                            }

                            public final void m2611a(String str, Object obj, boolean z) {
                            }

                            @Nullable
                            private String m2607a() {
                                this.f1754d = super.a(this.f1754d, 0);
                                return this.f1754d;
                            }

                            public final int jK_() {
                                return 2479791;
                            }

                            public final GraphQLVisitableModel m2609a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m2608a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m2607a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: setReferencedStickerData */
                        public class Serializer extends JsonSerializer<EducationExperiencesNodesModel> {
                            public final void m2612a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                EducationExperiencesNodesModel educationExperiencesNodesModel = (EducationExperiencesNodesModel) obj;
                                if (educationExperiencesNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(educationExperiencesNodesModel.m2614a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    educationExperiencesNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                EducationExperiencesNodesParser.m2671b(educationExperiencesNodesModel.w_(), educationExperiencesNodesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(EducationExperiencesNodesModel.class, new Serializer());
                            }
                        }

                        public EducationExperiencesNodesModel() {
                            super(1);
                        }

                        @Nullable
                        private SchoolModel m2613a() {
                            this.f1755d = (SchoolModel) super.a(this.f1755d, 0, SchoolModel.class);
                            return this.f1755d;
                        }

                        public final int jK_() {
                            return 1264055058;
                        }

                        public final GraphQLVisitableModel m2615a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m2613a() != null) {
                                SchoolModel schoolModel = (SchoolModel) graphQLModelMutatingVisitor.b(m2613a());
                                if (m2613a() != schoolModel) {
                                    graphQLVisitableModel = (EducationExperiencesNodesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f1755d = schoolModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m2614a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m2613a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: setReferencedStickerData */
                    public class Serializer extends JsonSerializer<EducationExperiencesModel> {
                        public final void m2616a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EducationExperiencesModel educationExperiencesModel = (EducationExperiencesModel) obj;
                            if (educationExperiencesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(educationExperiencesModel.m2618a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                educationExperiencesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EducationExperiencesParser.m2673a(educationExperiencesModel.w_(), educationExperiencesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(EducationExperiencesModel.class, new Serializer());
                        }
                    }

                    public EducationExperiencesModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<EducationExperiencesNodesModel> m2617a() {
                        this.f1756d = super.a(this.f1756d, 0, EducationExperiencesNodesModel.class);
                        return (ImmutableList) this.f1756d;
                    }

                    public final int jK_() {
                        return 1010460682;
                    }

                    public final GraphQLVisitableModel m2619a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m2617a() != null) {
                            Builder a = ModelHelper.a(m2617a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (EducationExperiencesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1756d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m2618a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m2617a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: setReferencedStickerData */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m2620a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m2650a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m2683b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1788356043)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: setReferencedStickerData */
                public final class WorkExperiencesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private List<WorkExperiencesNodesModel> f1761d;

                    /* compiled from: setReferencedStickerData */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(WorkExperiencesModel.class, new Deserializer());
                        }

                        public Object m2621a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(WorkExperiencesParser.m2680a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object workExperiencesModel = new WorkExperiencesModel();
                            ((BaseModel) workExperiencesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (workExperiencesModel instanceof Postprocessable) {
                                return ((Postprocessable) workExperiencesModel).a();
                            }
                            return workExperiencesModel;
                        }
                    }

                    /* compiled from: setReferencedStickerData */
                    public class Serializer extends JsonSerializer<WorkExperiencesModel> {
                        public final void m2622a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            WorkExperiencesModel workExperiencesModel = (WorkExperiencesModel) obj;
                            if (workExperiencesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(workExperiencesModel.m2644a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                workExperiencesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            WorkExperiencesParser.m2681a(workExperiencesModel.w_(), workExperiencesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(WorkExperiencesModel.class, new Serializer());
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1753638204)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: setReferencedStickerData */
                    public final class WorkExperiencesNodesModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private EmployerModel f1759d;
                        @Nullable
                        private PositionModel f1760e;

                        /* compiled from: setReferencedStickerData */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(WorkExperiencesNodesModel.class, new Deserializer());
                            }

                            public Object m2623a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(WorkExperiencesNodesParser.m2678b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object workExperiencesNodesModel = new WorkExperiencesNodesModel();
                                ((BaseModel) workExperiencesNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (workExperiencesNodesModel instanceof Postprocessable) {
                                    return ((Postprocessable) workExperiencesNodesModel).a();
                                }
                                return workExperiencesNodesModel;
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 273304230)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: setReferencedStickerData */
                        public final class EmployerModel extends BaseModel implements GraphQLVisitableConsistentModel {
                            @Nullable
                            private String f1757d;

                            /* compiled from: setReferencedStickerData */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(EmployerModel.class, new Deserializer());
                                }

                                public Object m2624a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(EmployerParser.m2674a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object employerModel = new EmployerModel();
                                    ((BaseModel) employerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (employerModel instanceof Postprocessable) {
                                        return ((Postprocessable) employerModel).a();
                                    }
                                    return employerModel;
                                }
                            }

                            /* compiled from: setReferencedStickerData */
                            public class Serializer extends JsonSerializer<EmployerModel> {
                                public final void m2625a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    EmployerModel employerModel = (EmployerModel) obj;
                                    if (employerModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(employerModel.m2627a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        employerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    EmployerParser.m2675a(employerModel.w_(), employerModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(EmployerModel.class, new Serializer());
                                }
                            }

                            public EmployerModel() {
                                super(1);
                            }

                            public final void m2629a(String str, ConsistencyTuple consistencyTuple) {
                                consistencyTuple.a();
                            }

                            public final void m2630a(String str, Object obj, boolean z) {
                            }

                            @Nullable
                            private String m2626a() {
                                this.f1757d = super.a(this.f1757d, 0);
                                return this.f1757d;
                            }

                            public final int jK_() {
                                return 2479791;
                            }

                            public final GraphQLVisitableModel m2628a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m2627a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m2626a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 273304230)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: setReferencedStickerData */
                        public final class PositionModel extends BaseModel implements GraphQLVisitableConsistentModel {
                            @Nullable
                            private String f1758d;

                            /* compiled from: setReferencedStickerData */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(PositionModel.class, new Deserializer());
                                }

                                public Object m2631a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(PositionParser.m2676a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object positionModel = new PositionModel();
                                    ((BaseModel) positionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (positionModel instanceof Postprocessable) {
                                        return ((Postprocessable) positionModel).a();
                                    }
                                    return positionModel;
                                }
                            }

                            /* compiled from: setReferencedStickerData */
                            public class Serializer extends JsonSerializer<PositionModel> {
                                public final void m2632a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    PositionModel positionModel = (PositionModel) obj;
                                    if (positionModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(positionModel.m2634a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        positionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    PositionParser.m2677a(positionModel.w_(), positionModel.u_(), jsonGenerator);
                                }

                                static {
                                    FbSerializerProvider.a(PositionModel.class, new Serializer());
                                }
                            }

                            public PositionModel() {
                                super(1);
                            }

                            public final void m2636a(String str, ConsistencyTuple consistencyTuple) {
                                consistencyTuple.a();
                            }

                            public final void m2637a(String str, Object obj, boolean z) {
                            }

                            @Nullable
                            private String m2633a() {
                                this.f1758d = super.a(this.f1758d, 0);
                                return this.f1758d;
                            }

                            public final int jK_() {
                                return 2479791;
                            }

                            public final GraphQLVisitableModel m2635a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                h();
                                i();
                                return this;
                            }

                            public final int m2634a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int b = flatBufferBuilder.b(m2633a());
                                flatBufferBuilder.c(1);
                                flatBufferBuilder.b(0, b);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: setReferencedStickerData */
                        public class Serializer extends JsonSerializer<WorkExperiencesNodesModel> {
                            public final void m2638a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                WorkExperiencesNodesModel workExperiencesNodesModel = (WorkExperiencesNodesModel) obj;
                                if (workExperiencesNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(workExperiencesNodesModel.m2641a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    workExperiencesNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                WorkExperiencesNodesParser.m2679b(workExperiencesNodesModel.w_(), workExperiencesNodesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(WorkExperiencesNodesModel.class, new Serializer());
                            }
                        }

                        public WorkExperiencesNodesModel() {
                            super(2);
                        }

                        @Nullable
                        private EmployerModel m2639a() {
                            this.f1759d = (EmployerModel) super.a(this.f1759d, 0, EmployerModel.class);
                            return this.f1759d;
                        }

                        @Nullable
                        private PositionModel m2640j() {
                            this.f1760e = (PositionModel) super.a(this.f1760e, 1, PositionModel.class);
                            return this.f1760e;
                        }

                        public final int jK_() {
                            return 1201268603;
                        }

                        public final GraphQLVisitableModel m2642a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m2639a() != null) {
                                EmployerModel employerModel = (EmployerModel) graphQLModelMutatingVisitor.b(m2639a());
                                if (m2639a() != employerModel) {
                                    graphQLVisitableModel = (WorkExperiencesNodesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f1759d = employerModel;
                                }
                            }
                            if (m2640j() != null) {
                                PositionModel positionModel = (PositionModel) graphQLModelMutatingVisitor.b(m2640j());
                                if (m2640j() != positionModel) {
                                    graphQLVisitableModel = (WorkExperiencesNodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f1760e = positionModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m2641a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m2639a());
                            int a2 = ModelHelper.a(flatBufferBuilder, m2640j());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, a2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    public WorkExperiencesModel() {
                        super(1);
                    }

                    @Nonnull
                    private ImmutableList<WorkExperiencesNodesModel> m2643a() {
                        this.f1761d = super.a(this.f1761d, 0, WorkExperiencesNodesModel.class);
                        return (ImmutableList) this.f1761d;
                    }

                    public final int jK_() {
                        return -1378049077;
                    }

                    public final GraphQLVisitableModel m2645a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m2643a() != null) {
                            Builder a = ModelHelper.a(m2643a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (WorkExperiencesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1761d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m2644a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m2643a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public NodesModel() {
                    super(4);
                }

                public final void m2653a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m2654a(String str, Object obj, boolean z) {
                }

                @Nullable
                private EducationExperiencesModel m2646j() {
                    this.f1762d = (EducationExperiencesModel) super.a(this.f1762d, 0, EducationExperiencesModel.class);
                    return this.f1762d;
                }

                @Nullable
                private String m2647k() {
                    this.f1763e = super.a(this.f1763e, 1);
                    return this.f1763e;
                }

                @Nullable
                private String m2648l() {
                    this.f1764f = super.a(this.f1764f, 2);
                    return this.f1764f;
                }

                @Nullable
                private WorkExperiencesModel m2649m() {
                    this.f1765g = (WorkExperiencesModel) super.a(this.f1765g, 3, WorkExperiencesModel.class);
                    return this.f1765g;
                }

                @Nullable
                public final String m2652a() {
                    return m2647k();
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m2651a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m2646j() != null) {
                        EducationExperiencesModel educationExperiencesModel = (EducationExperiencesModel) graphQLModelMutatingVisitor.b(m2646j());
                        if (m2646j() != educationExperiencesModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1762d = educationExperiencesModel;
                        }
                    }
                    if (m2649m() != null) {
                        WorkExperiencesModel workExperiencesModel = (WorkExperiencesModel) graphQLModelMutatingVisitor.b(m2649m());
                        if (m2649m() != workExperiencesModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f1765g = workExperiencesModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m2650a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m2646j());
                    int b = flatBufferBuilder.b(m2647k());
                    int b2 = flatBufferBuilder.b(m2648l());
                    int a2 = ModelHelper.a(flatBufferBuilder, m2649m());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: setReferencedStickerData */
            public class Serializer extends JsonSerializer<PageLikersModel> {
                public final void m2655a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageLikersModel pageLikersModel = (PageLikersModel) obj;
                    if (pageLikersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageLikersModel.m2657a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageLikersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageLikersParser.m2685a(pageLikersModel.w_(), pageLikersModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageLikersModel.class, new Serializer());
                }
            }

            public PageLikersModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<NodesModel> m2656a() {
                this.f1767e = super.a(this.f1767e, 1, NodesModel.class);
                return (ImmutableList) this.f1767e;
            }

            public final int jK_() {
                return 637021669;
            }

            public final GraphQLVisitableModel m2658a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m2656a() != null) {
                    Builder a = ModelHelper.a(m2656a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PageLikersModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1767e = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m2657a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m2656a());
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f1766d, 0);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m2659a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f1766d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: setReferencedStickerData */
        public class Serializer extends JsonSerializer<FetchNewLikesQueryModel> {
            public final void m2660a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchNewLikesQueryModel fetchNewLikesQueryModel = (FetchNewLikesQueryModel) obj;
                if (fetchNewLikesQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchNewLikesQueryModel.m2664a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchNewLikesQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchNewLikesQueryModel.w_();
                int u_ = fetchNewLikesQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("page_likers");
                    PageLikersParser.m2685a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchNewLikesQueryModel.class, new Serializer());
            }
        }

        public FetchNewLikesQueryModel() {
            super(3);
        }

        public final void m2666a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m2667a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m2661a() {
            if (this.b != null && this.f1768d == null) {
                this.f1768d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1768d;
        }

        @Nullable
        private String m2662j() {
            this.f1769e = super.a(this.f1769e, 1);
            return this.f1769e;
        }

        @Nullable
        private PageLikersModel m2663k() {
            this.f1770f = (PageLikersModel) super.a(this.f1770f, 2, PageLikersModel.class);
            return this.f1770f;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m2665a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m2663k() != null) {
                PageLikersModel pageLikersModel = (PageLikersModel) graphQLModelMutatingVisitor.b(m2663k());
                if (m2663k() != pageLikersModel) {
                    graphQLVisitableModel = (FetchNewLikesQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1770f = pageLikersModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m2664a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m2661a());
            int b = flatBufferBuilder.b(m2662j());
            int a2 = ModelHelper.a(flatBufferBuilder, m2663k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}

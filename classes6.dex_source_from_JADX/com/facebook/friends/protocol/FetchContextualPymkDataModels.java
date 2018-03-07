package com.facebook.friends.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.friends.protocol.FetchContextualPymkDataParsers.ContextualPymkDataParser;
import com.facebook.friends.protocol.FetchContextualPymkDataParsers.ContextualPymkDataParser.CurrentCityParser;
import com.facebook.friends.protocol.FetchContextualPymkDataParsers.ContextualPymkDataParser.EducationExperiencesParser;
import com.facebook.friends.protocol.FetchContextualPymkDataParsers.ContextualPymkDataParser.EducationExperiencesParser.EdgesParser;
import com.facebook.friends.protocol.FetchContextualPymkDataParsers.ContextualPymkDataParser.EducationExperiencesParser.EdgesParser.NodeParser;
import com.facebook.friends.protocol.FetchContextualPymkDataParsers.ContextualPymkDataParser.EducationExperiencesParser.EdgesParser.NodeParser.SchoolParser;
import com.facebook.friends.protocol.FetchContextualPymkDataParsers.ContextualPymkDataParser.HometownParser;
import com.facebook.friends.protocol.FetchContextualPymkDataParsers.ContextualPymkDataParser.WorkExperiencesParser;
import com.facebook.friends.protocol.FetchContextualPymkDataParsers.ContextualPymkDataParser.WorkExperiencesParser.EdgesParser.NodeParser.EmployerParser;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: matchedLength */
public class FetchContextualPymkDataModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 578134048)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: matchedLength */
    public final class ContextualPymkDataModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private CurrentCityModel f10686d;
        @Nullable
        private EducationExperiencesModel f10687e;
        @Nullable
        private HometownModel f10688f;
        @Nullable
        private WorkExperiencesModel f10689g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 273304230)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: matchedLength */
        public final class CurrentCityModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f10676d;

            /* compiled from: matchedLength */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CurrentCityModel.class, new Deserializer());
                }

                public Object m16785a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CurrentCityParser.m16853a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object currentCityModel = new CurrentCityModel();
                    ((BaseModel) currentCityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (currentCityModel instanceof Postprocessable) {
                        return ((Postprocessable) currentCityModel).a();
                    }
                    return currentCityModel;
                }
            }

            /* compiled from: matchedLength */
            public class Serializer extends JsonSerializer<CurrentCityModel> {
                public final void m16786a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CurrentCityModel currentCityModel = (CurrentCityModel) obj;
                    if (currentCityModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(currentCityModel.m16788a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        currentCityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CurrentCityParser.m16854a(currentCityModel.w_(), currentCityModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(CurrentCityModel.class, new Serializer());
                }
            }

            public CurrentCityModel() {
                super(1);
            }

            public final void m16790a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16791a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m16787a() {
                this.f10676d = super.a(this.f10676d, 0);
                return this.f10676d;
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m16789a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16788a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16787a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: matchedLength */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ContextualPymkDataModel.class, new Deserializer());
            }

            public Object m16792a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ContextualPymkDataParser.m16873a(jsonParser);
                Object contextualPymkDataModel = new ContextualPymkDataModel();
                ((BaseModel) contextualPymkDataModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (contextualPymkDataModel instanceof Postprocessable) {
                    return ((Postprocessable) contextualPymkDataModel).a();
                }
                return contextualPymkDataModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1902757051)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: matchedLength */
        public final class EducationExperiencesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f10680d;

            /* compiled from: matchedLength */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EducationExperiencesModel.class, new Deserializer());
                }

                public Object m16793a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EducationExperiencesParser.m16861a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = -786992620)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: matchedLength */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f10679d;

                /* compiled from: matchedLength */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m16794a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m16859b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 883821335)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: matchedLength */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private SchoolModel f10678d;

                    /* compiled from: matchedLength */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m16795a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NodeParser.m16857a(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 273304230)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: matchedLength */
                    public final class SchoolModel extends BaseModel implements GraphQLVisitableConsistentModel {
                        @Nullable
                        private String f10677d;

                        /* compiled from: matchedLength */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(SchoolModel.class, new Deserializer());
                            }

                            public Object m16796a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(SchoolParser.m16855a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: matchedLength */
                        public class Serializer extends JsonSerializer<SchoolModel> {
                            public final void m16797a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                SchoolModel schoolModel = (SchoolModel) obj;
                                if (schoolModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(schoolModel.m16799a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    schoolModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                SchoolParser.m16856a(schoolModel.w_(), schoolModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(SchoolModel.class, new Serializer());
                            }
                        }

                        public SchoolModel() {
                            super(1);
                        }

                        public final void m16801a(String str, ConsistencyTuple consistencyTuple) {
                            consistencyTuple.a();
                        }

                        public final void m16802a(String str, Object obj, boolean z) {
                        }

                        @Nullable
                        private String m16798a() {
                            this.f10677d = super.a(this.f10677d, 0);
                            return this.f10677d;
                        }

                        public final int jK_() {
                            return 2479791;
                        }

                        public final GraphQLVisitableModel m16800a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m16799a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m16798a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: matchedLength */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m16803a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m16805a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NodeParser.m16858a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(1);
                    }

                    @Nullable
                    private SchoolModel m16804a() {
                        this.f10678d = (SchoolModel) super.a(this.f10678d, 0, SchoolModel.class);
                        return this.f10678d;
                    }

                    public final int jK_() {
                        return 1264055058;
                    }

                    public final GraphQLVisitableModel m16806a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m16804a() != null) {
                            SchoolModel schoolModel = (SchoolModel) graphQLModelMutatingVisitor.b(m16804a());
                            if (m16804a() != schoolModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f10678d = schoolModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m16805a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m16804a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: matchedLength */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m16807a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m16809a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m16860b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m16808a() {
                    this.f10679d = (NodeModel) super.a(this.f10679d, 0, NodeModel.class);
                    return this.f10679d;
                }

                public final int jK_() {
                    return 1323739113;
                }

                public final GraphQLVisitableModel m16810a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m16808a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m16808a());
                        if (m16808a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10679d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m16809a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m16808a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: matchedLength */
            public class Serializer extends JsonSerializer<EducationExperiencesModel> {
                public final void m16811a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EducationExperiencesModel educationExperiencesModel = (EducationExperiencesModel) obj;
                    if (educationExperiencesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(educationExperiencesModel.m16813a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        educationExperiencesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EducationExperiencesParser.m16862a(educationExperiencesModel.w_(), educationExperiencesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EducationExperiencesModel.class, new Serializer());
                }
            }

            public EducationExperiencesModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m16812a() {
                this.f10680d = super.a(this.f10680d, 0, EdgesModel.class);
                return (ImmutableList) this.f10680d;
            }

            public final int jK_() {
                return 1010460682;
            }

            public final GraphQLVisitableModel m16814a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16812a() != null) {
                    Builder a = ModelHelper.a(m16812a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (EducationExperiencesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10680d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16813a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16812a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 273304230)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: matchedLength */
        public final class HometownModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private String f10681d;

            /* compiled from: matchedLength */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(HometownModel.class, new Deserializer());
                }

                public Object m16815a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(HometownParser.m16863a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object hometownModel = new HometownModel();
                    ((BaseModel) hometownModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (hometownModel instanceof Postprocessable) {
                        return ((Postprocessable) hometownModel).a();
                    }
                    return hometownModel;
                }
            }

            /* compiled from: matchedLength */
            public class Serializer extends JsonSerializer<HometownModel> {
                public final void m16816a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    HometownModel hometownModel = (HometownModel) obj;
                    if (hometownModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(hometownModel.m16818a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        hometownModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    HometownParser.m16864a(hometownModel.w_(), hometownModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(HometownModel.class, new Serializer());
                }
            }

            public HometownModel() {
                super(1);
            }

            public final void m16820a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16821a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m16817a() {
                this.f10681d = super.a(this.f10681d, 0);
                return this.f10681d;
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m16819a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16818a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16817a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: matchedLength */
        public class Serializer extends JsonSerializer<ContextualPymkDataModel> {
            public final void m16822a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ContextualPymkDataModel contextualPymkDataModel = (ContextualPymkDataModel) obj;
                if (contextualPymkDataModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(contextualPymkDataModel.m16849a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    contextualPymkDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = contextualPymkDataModel.w_();
                int u_ = contextualPymkDataModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("current_city");
                    CurrentCityParser.m16854a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("education_experiences");
                    EducationExperiencesParser.m16862a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("hometown");
                    HometownParser.m16864a(mutableFlatBuffer, g, jsonGenerator);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("work_experiences");
                    WorkExperiencesParser.m16872a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ContextualPymkDataModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1542767767)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: matchedLength */
        public final class WorkExperiencesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f10685d;

            /* compiled from: matchedLength */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(WorkExperiencesModel.class, new Deserializer());
                }

                public Object m16823a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(WorkExperiencesParser.m16871a(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -85927139)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: matchedLength */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private NodeModel f10684d;

                /* compiled from: matchedLength */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m16824a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(WorkExperiencesParser.EdgesParser.m16869b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -684952292)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: matchedLength */
                public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private EmployerModel f10683d;

                    /* compiled from: matchedLength */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                        }

                        public Object m16825a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(WorkExperiencesParser.EdgesParser.NodeParser.m16867a(jsonParser, flatBufferBuilder));
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
                    @ModelWithFlatBufferFormatHash(a = 273304230)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: matchedLength */
                    public final class EmployerModel extends BaseModel implements GraphQLVisitableConsistentModel {
                        @Nullable
                        private String f10682d;

                        /* compiled from: matchedLength */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(EmployerModel.class, new Deserializer());
                            }

                            public Object m16826a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(EmployerParser.m16865a(jsonParser, flatBufferBuilder));
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

                        /* compiled from: matchedLength */
                        public class Serializer extends JsonSerializer<EmployerModel> {
                            public final void m16827a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                EmployerModel employerModel = (EmployerModel) obj;
                                if (employerModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(employerModel.m16829a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    employerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                EmployerParser.m16866a(employerModel.w_(), employerModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(EmployerModel.class, new Serializer());
                            }
                        }

                        public EmployerModel() {
                            super(1);
                        }

                        public final void m16831a(String str, ConsistencyTuple consistencyTuple) {
                            consistencyTuple.a();
                        }

                        public final void m16832a(String str, Object obj, boolean z) {
                        }

                        @Nullable
                        private String m16828a() {
                            this.f10682d = super.a(this.f10682d, 0);
                            return this.f10682d;
                        }

                        public final int jK_() {
                            return 2479791;
                        }

                        public final GraphQLVisitableModel m16830a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m16829a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m16828a());
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, b);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: matchedLength */
                    public class Serializer extends JsonSerializer<NodeModel> {
                        public final void m16833a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NodeModel nodeModel = (NodeModel) obj;
                            if (nodeModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(nodeModel.m16835a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            WorkExperiencesParser.EdgesParser.NodeParser.m16868a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NodeModel.class, new Serializer());
                        }
                    }

                    public NodeModel() {
                        super(1);
                    }

                    @Nullable
                    private EmployerModel m16834a() {
                        this.f10683d = (EmployerModel) super.a(this.f10683d, 0, EmployerModel.class);
                        return this.f10683d;
                    }

                    public final int jK_() {
                        return 1201268603;
                    }

                    public final GraphQLVisitableModel m16836a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m16834a() != null) {
                            EmployerModel employerModel = (EmployerModel) graphQLModelMutatingVisitor.b(m16834a());
                            if (m16834a() != employerModel) {
                                graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f10683d = employerModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m16835a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m16834a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: matchedLength */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m16837a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m16839a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        WorkExperiencesParser.EdgesParser.m16870b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(1);
                }

                @Nullable
                private NodeModel m16838a() {
                    this.f10684d = (NodeModel) super.a(this.f10684d, 0, NodeModel.class);
                    return this.f10684d;
                }

                public final int jK_() {
                    return -959641494;
                }

                public final GraphQLVisitableModel m16840a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m16838a() != null) {
                        NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m16838a());
                        if (m16838a() != nodeModel) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f10684d = nodeModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m16839a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m16838a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: matchedLength */
            public class Serializer extends JsonSerializer<WorkExperiencesModel> {
                public final void m16841a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    WorkExperiencesModel workExperiencesModel = (WorkExperiencesModel) obj;
                    if (workExperiencesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(workExperiencesModel.m16843a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        workExperiencesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    WorkExperiencesParser.m16872a(workExperiencesModel.w_(), workExperiencesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(WorkExperiencesModel.class, new Serializer());
                }
            }

            public WorkExperiencesModel() {
                super(1);
            }

            @Nonnull
            private ImmutableList<EdgesModel> m16842a() {
                this.f10685d = super.a(this.f10685d, 0, EdgesModel.class);
                return (ImmutableList) this.f10685d;
            }

            public final int jK_() {
                return -1378049077;
            }

            public final GraphQLVisitableModel m16844a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16842a() != null) {
                    Builder a = ModelHelper.a(m16842a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (WorkExperiencesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f10685d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16843a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16842a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ContextualPymkDataModel() {
            super(4);
        }

        public final void m16851a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m16852a(String str, Object obj, boolean z) {
        }

        @Nullable
        private CurrentCityModel m16845a() {
            this.f10686d = (CurrentCityModel) super.a(this.f10686d, 0, CurrentCityModel.class);
            return this.f10686d;
        }

        @Nullable
        private EducationExperiencesModel m16846j() {
            this.f10687e = (EducationExperiencesModel) super.a(this.f10687e, 1, EducationExperiencesModel.class);
            return this.f10687e;
        }

        @Nullable
        private HometownModel m16847k() {
            this.f10688f = (HometownModel) super.a(this.f10688f, 2, HometownModel.class);
            return this.f10688f;
        }

        @Nullable
        private WorkExperiencesModel m16848l() {
            this.f10689g = (WorkExperiencesModel) super.a(this.f10689g, 3, WorkExperiencesModel.class);
            return this.f10689g;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m16850a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16845a() != null) {
                CurrentCityModel currentCityModel = (CurrentCityModel) graphQLModelMutatingVisitor.b(m16845a());
                if (m16845a() != currentCityModel) {
                    graphQLVisitableModel = (ContextualPymkDataModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10686d = currentCityModel;
                }
            }
            if (m16846j() != null) {
                EducationExperiencesModel educationExperiencesModel = (EducationExperiencesModel) graphQLModelMutatingVisitor.b(m16846j());
                if (m16846j() != educationExperiencesModel) {
                    graphQLVisitableModel = (ContextualPymkDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10687e = educationExperiencesModel;
                }
            }
            if (m16847k() != null) {
                HometownModel hometownModel = (HometownModel) graphQLModelMutatingVisitor.b(m16847k());
                if (m16847k() != hometownModel) {
                    graphQLVisitableModel = (ContextualPymkDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10688f = hometownModel;
                }
            }
            if (m16848l() != null) {
                WorkExperiencesModel workExperiencesModel = (WorkExperiencesModel) graphQLModelMutatingVisitor.b(m16848l());
                if (m16848l() != workExperiencesModel) {
                    graphQLVisitableModel = (ContextualPymkDataModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f10689g = workExperiencesModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16849a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16845a());
            int a2 = ModelHelper.a(flatBufferBuilder, m16846j());
            int a3 = ModelHelper.a(flatBufferBuilder, m16847k());
            int a4 = ModelHelper.a(flatBufferBuilder, m16848l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            i();
            return flatBufferBuilder.d();
        }
    }
}

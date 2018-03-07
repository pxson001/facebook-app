package com.facebook.productionprompts.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableActivityModel;
import com.facebook.composer.minutiae.graphql.MinutiaeDefaultsGraphQLModels.MinutiaeTaggableObjectFieldsModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.heisman.protocol.imageoverlay.ImageOverlayGraphQLModels.ImageOverlayFieldsModel;
import com.facebook.photos.creativeediting.model.FrameGraphQLModels.FramePackModel;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ProductionPromptsInfoParser.SuggestedCompositionParser;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ProductionPromptsInfoParser.SuggestedCompositionParser.EdgesParser;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ProductionPromptsInfoParser.SuggestedCompositionParser.EdgesParser.NodeParser;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ProductionPromptsInfoParser.SuggestedCompositionParser.EdgesParser.NodeParser.CheckinLocationParser;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ProductionPromptsInfoParser.SuggestedCompositionParser.EdgesParser.NodeParser.LinkAttachmentParser;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ProductionPromptsInfoParser.SuggestedCompositionParser.EdgesParser.NodeParser.MemeCategoryParser;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ProductionPromptsInfoParser.SuggestedCompositionParser.EdgesParser.NodeParser.MinutiaeActionParser;
import com.facebook.productionprompts.graphql.FetchProductionPromptsGraphQLParsers.ProductionPromptsInfoParser.SuggestedCompositionParser.EdgesParser.NodeParser.MinutiaeActionParser.TaggableActivityIconParser;
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

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -2072082305)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: state_report_button_position */
public final class C0259xb568e2b0 extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private List<EdgesModel> f4223d;

    /* compiled from: state_report_button_position */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0259xb568e2b0.class, new Deserializer());
        }

        public Object m6155a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(SuggestedCompositionParser.m6244a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0259xb568e2b0 = new C0259xb568e2b0();
            ((BaseModel) c0259xb568e2b0).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0259xb568e2b0 instanceof Postprocessable) {
                return ((Postprocessable) c0259xb568e2b0).a();
            }
            return c0259xb568e2b0;
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2033713201)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: state_report_button_position */
    public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f4218d;
        @Nullable
        private NodeModel f4219e;
        @Nullable
        private String f4220f;
        @Nullable
        private String f4221g;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f4222h;

        /* compiled from: state_report_button_position */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
            }

            public Object m6156a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(EdgesParser.m6242b(jsonParser, flatBufferBuilder));
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
        @ModelWithFlatBufferFormatHash(a = 1147394797)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: state_report_button_position */
        public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private CheckinLocationModel f4211d;
            @Nullable
            private FramePackModel f4212e;
            @Nullable
            private LinkAttachmentModel f4213f;
            @Nullable
            private MemeCategoryModel f4214g;
            @Nullable
            private MinutiaeActionModel f4215h;
            @Nullable
            private ImageOverlayFieldsModel f4216i;
            @Nullable
            private List<String> f4217j;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1255661007)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: state_report_button_position */
            public final class CheckinLocationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f4199d;
                @Nullable
                private String f4200e;
                @Nullable
                private String f4201f;

                /* compiled from: state_report_button_position */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CheckinLocationModel.class, new Deserializer());
                    }

                    public Object m6157a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CheckinLocationParser.m6230a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object checkinLocationModel = new CheckinLocationModel();
                        ((BaseModel) checkinLocationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (checkinLocationModel instanceof Postprocessable) {
                            return ((Postprocessable) checkinLocationModel).a();
                        }
                        return checkinLocationModel;
                    }
                }

                /* compiled from: state_report_button_position */
                public class Serializer extends JsonSerializer<CheckinLocationModel> {
                    public final void m6158a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CheckinLocationModel checkinLocationModel = (CheckinLocationModel) obj;
                        if (checkinLocationModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(checkinLocationModel.m6161a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            checkinLocationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CheckinLocationParser.m6231a(checkinLocationModel.w_(), checkinLocationModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CheckinLocationModel.class, new Serializer());
                    }
                }

                public CheckinLocationModel() {
                    super(3);
                }

                public final void m6164a(String str, ConsistencyTuple consistencyTuple) {
                    if ("name".equals(str)) {
                        consistencyTuple.a = m6167k();
                        consistencyTuple.b = u_();
                        consistencyTuple.c = 2;
                        return;
                    }
                    consistencyTuple.a();
                }

                public final void m6165a(String str, Object obj, boolean z) {
                    if ("name".equals(str)) {
                        m6159a((String) obj);
                    }
                }

                @Nullable
                private GraphQLObjectType m6160l() {
                    if (this.b != null && this.f4199d == null) {
                        this.f4199d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f4199d;
                }

                @Nullable
                public final String m6166j() {
                    this.f4200e = super.a(this.f4200e, 1);
                    return this.f4200e;
                }

                @Nullable
                public final String m6167k() {
                    this.f4201f = super.a(this.f4201f, 2);
                    return this.f4201f;
                }

                private void m6159a(@Nullable String str) {
                    this.f4201f = str;
                    if (this.b != null && this.b.d) {
                        this.b.a(this.c, 2, str);
                    }
                }

                @Nullable
                public final String m6163a() {
                    return m6166j();
                }

                public final int jK_() {
                    return 77195495;
                }

                public final GraphQLVisitableModel m6162a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6161a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m6160l());
                    int b = flatBufferBuilder.b(m6166j());
                    int b2 = flatBufferBuilder.b(m6167k());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: state_report_button_position */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                }

                public Object m6168a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NodeParser.m6240a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = 1716483899)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: state_report_button_position */
            public final class LinkAttachmentModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f4202d;
                @Nullable
                private String f4203e;

                /* compiled from: state_report_button_position */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(LinkAttachmentModel.class, new Deserializer());
                    }

                    public Object m6169a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(LinkAttachmentParser.m6232a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object linkAttachmentModel = new LinkAttachmentModel();
                        ((BaseModel) linkAttachmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (linkAttachmentModel instanceof Postprocessable) {
                            return ((Postprocessable) linkAttachmentModel).a();
                        }
                        return linkAttachmentModel;
                    }
                }

                /* compiled from: state_report_button_position */
                public class Serializer extends JsonSerializer<LinkAttachmentModel> {
                    public final void m6170a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        LinkAttachmentModel linkAttachmentModel = (LinkAttachmentModel) obj;
                        if (linkAttachmentModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(linkAttachmentModel.m6172a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            linkAttachmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        LinkAttachmentParser.m6233a(linkAttachmentModel.w_(), linkAttachmentModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(LinkAttachmentModel.class, new Serializer());
                    }
                }

                public LinkAttachmentModel() {
                    super(2);
                }

                @Nullable
                private String m6171j() {
                    this.f4202d = super.a(this.f4202d, 0);
                    return this.f4202d;
                }

                @Nullable
                public final String m6174a() {
                    this.f4203e = super.a(this.f4203e, 1);
                    return this.f4203e;
                }

                public final int jK_() {
                    return 41461717;
                }

                public final GraphQLVisitableModel m6173a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6172a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6171j());
                    int b2 = flatBufferBuilder.b(m6174a());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1597377240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: state_report_button_position */
            public final class MemeCategoryModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<String> f4204d;
                @Nullable
                private String f4205e;

                /* compiled from: state_report_button_position */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MemeCategoryModel.class, new Deserializer());
                    }

                    public Object m6175a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MemeCategoryParser.m6234a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object memeCategoryModel = new MemeCategoryModel();
                        ((BaseModel) memeCategoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (memeCategoryModel instanceof Postprocessable) {
                            return ((Postprocessable) memeCategoryModel).a();
                        }
                        return memeCategoryModel;
                    }
                }

                /* compiled from: state_report_button_position */
                public class Serializer extends JsonSerializer<MemeCategoryModel> {
                    public final void m6176a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MemeCategoryModel memeCategoryModel = (MemeCategoryModel) obj;
                        if (memeCategoryModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(memeCategoryModel.m6178a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            memeCategoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MemeCategoryParser.m6235a(memeCategoryModel.w_(), memeCategoryModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(MemeCategoryModel.class, new Serializer());
                    }
                }

                public MemeCategoryModel() {
                    super(2);
                }

                @Nonnull
                public final ImmutableList<String> m6180a() {
                    this.f4204d = super.a(this.f4204d, 0);
                    return (ImmutableList) this.f4204d;
                }

                @Nullable
                private String m6177j() {
                    this.f4205e = super.a(this.f4205e, 1);
                    return this.f4205e;
                }

                public final int jK_() {
                    return -1748280722;
                }

                public final GraphQLVisitableModel m6179a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m6178a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int c = flatBufferBuilder.c(m6180a());
                    int b = flatBufferBuilder.b(m6177j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, c);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -770307567)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: state_report_button_position */
            public final class MinutiaeActionModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private String f4207d;
                @Nullable
                private MinutiaeTaggableObjectFieldsModel f4208e;
                @Nullable
                private MinutiaeTaggableActivityModel f4209f;
                @Nullable
                private TaggableActivityIconModel f4210g;

                /* compiled from: state_report_button_position */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MinutiaeActionModel.class, new Deserializer());
                    }

                    public Object m6181a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MinutiaeActionParser.m6238a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object minutiaeActionModel = new MinutiaeActionModel();
                        ((BaseModel) minutiaeActionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (minutiaeActionModel instanceof Postprocessable) {
                            return ((Postprocessable) minutiaeActionModel).a();
                        }
                        return minutiaeActionModel;
                    }
                }

                /* compiled from: state_report_button_position */
                public class Serializer extends JsonSerializer<MinutiaeActionModel> {
                    public final void m6182a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MinutiaeActionModel minutiaeActionModel = (MinutiaeActionModel) obj;
                        if (minutiaeActionModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(minutiaeActionModel.m6189a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            minutiaeActionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MinutiaeActionParser.m6239a(minutiaeActionModel.w_(), minutiaeActionModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(MinutiaeActionModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1157469815)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: state_report_button_position */
                public final class TaggableActivityIconModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private DefaultImageFieldsModel f4206d;

                    /* compiled from: state_report_button_position */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(TaggableActivityIconModel.class, new Deserializer());
                        }

                        public Object m6183a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TaggableActivityIconParser.m6236a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object taggableActivityIconModel = new TaggableActivityIconModel();
                            ((BaseModel) taggableActivityIconModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (taggableActivityIconModel instanceof Postprocessable) {
                                return ((Postprocessable) taggableActivityIconModel).a();
                            }
                            return taggableActivityIconModel;
                        }
                    }

                    /* compiled from: state_report_button_position */
                    public class Serializer extends JsonSerializer<TaggableActivityIconModel> {
                        public final void m6184a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            TaggableActivityIconModel taggableActivityIconModel = (TaggableActivityIconModel) obj;
                            if (taggableActivityIconModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(taggableActivityIconModel.m6185a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                taggableActivityIconModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            TaggableActivityIconParser.m6237a(taggableActivityIconModel.w_(), taggableActivityIconModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(TaggableActivityIconModel.class, new Serializer());
                        }
                    }

                    public TaggableActivityIconModel() {
                        super(1);
                    }

                    @Nullable
                    public final DefaultImageFieldsModel m6186a() {
                        this.f4206d = (DefaultImageFieldsModel) super.a(this.f4206d, 0, DefaultImageFieldsModel.class);
                        return this.f4206d;
                    }

                    public final int jK_() {
                        return 638969039;
                    }

                    public final GraphQLVisitableModel m6187a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m6186a() != null) {
                            DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m6186a());
                            if (m6186a() != defaultImageFieldsModel) {
                                graphQLVisitableModel = (TaggableActivityIconModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f4206d = defaultImageFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m6185a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m6186a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public MinutiaeActionModel() {
                    super(4);
                }

                @Nullable
                private String m6188m() {
                    this.f4207d = super.a(this.f4207d, 0);
                    return this.f4207d;
                }

                @Nullable
                public final MinutiaeTaggableObjectFieldsModel m6192j() {
                    this.f4208e = (MinutiaeTaggableObjectFieldsModel) super.a(this.f4208e, 1, MinutiaeTaggableObjectFieldsModel.class);
                    return this.f4208e;
                }

                @Nullable
                public final MinutiaeTaggableActivityModel m6193k() {
                    this.f4209f = (MinutiaeTaggableActivityModel) super.a(this.f4209f, 2, MinutiaeTaggableActivityModel.class);
                    return this.f4209f;
                }

                @Nullable
                public final TaggableActivityIconModel m6194l() {
                    this.f4210g = (TaggableActivityIconModel) super.a(this.f4210g, 3, TaggableActivityIconModel.class);
                    return this.f4210g;
                }

                @Nullable
                public final String m6191a() {
                    return m6188m();
                }

                public final int jK_() {
                    return 1291787496;
                }

                public final GraphQLVisitableModel m6190a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m6192j() != null) {
                        MinutiaeTaggableObjectFieldsModel minutiaeTaggableObjectFieldsModel = (MinutiaeTaggableObjectFieldsModel) graphQLModelMutatingVisitor.b(m6192j());
                        if (m6192j() != minutiaeTaggableObjectFieldsModel) {
                            graphQLVisitableModel = (MinutiaeActionModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4208e = minutiaeTaggableObjectFieldsModel;
                        }
                    }
                    if (m6193k() != null) {
                        MinutiaeTaggableActivityModel minutiaeTaggableActivityModel = (MinutiaeTaggableActivityModel) graphQLModelMutatingVisitor.b(m6193k());
                        if (m6193k() != minutiaeTaggableActivityModel) {
                            graphQLVisitableModel = (MinutiaeActionModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f4209f = minutiaeTaggableActivityModel;
                        }
                    }
                    if (m6194l() != null) {
                        TaggableActivityIconModel taggableActivityIconModel = (TaggableActivityIconModel) graphQLModelMutatingVisitor.b(m6194l());
                        if (m6194l() != taggableActivityIconModel) {
                            graphQLVisitableModel = (MinutiaeActionModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f4210g = taggableActivityIconModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m6189a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m6188m());
                    int a = ModelHelper.a(flatBufferBuilder, m6192j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m6193k());
                    int a3 = ModelHelper.a(flatBufferBuilder, m6194l());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, a3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: state_report_button_position */
            public class Serializer extends JsonSerializer<NodeModel> {
                public final void m6195a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodeModel nodeModel = (NodeModel) obj;
                    if (nodeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodeModel.m6196a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NodeParser.m6241a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodeModel.class, new Serializer());
                }
            }

            public NodeModel() {
                super(7);
            }

            @Nullable
            public final CheckinLocationModel m6198a() {
                this.f4211d = (CheckinLocationModel) super.a(this.f4211d, 0, CheckinLocationModel.class);
                return this.f4211d;
            }

            @Nullable
            public final FramePackModel m6199j() {
                this.f4212e = (FramePackModel) super.a(this.f4212e, 1, FramePackModel.class);
                return this.f4212e;
            }

            @Nullable
            public final LinkAttachmentModel m6200k() {
                this.f4213f = (LinkAttachmentModel) super.a(this.f4213f, 2, LinkAttachmentModel.class);
                return this.f4213f;
            }

            @Nullable
            public final MemeCategoryModel m6201l() {
                this.f4214g = (MemeCategoryModel) super.a(this.f4214g, 3, MemeCategoryModel.class);
                return this.f4214g;
            }

            @Nullable
            public final MinutiaeActionModel m6202m() {
                this.f4215h = (MinutiaeActionModel) super.a(this.f4215h, 4, MinutiaeActionModel.class);
                return this.f4215h;
            }

            @Nullable
            public final ImageOverlayFieldsModel m6203n() {
                this.f4216i = (ImageOverlayFieldsModel) super.a(this.f4216i, 5, ImageOverlayFieldsModel.class);
                return this.f4216i;
            }

            @Nonnull
            public final ImmutableList<String> m6204o() {
                this.f4217j = super.a(this.f4217j, 6);
                return (ImmutableList) this.f4217j;
            }

            public final int jK_() {
                return -1535314265;
            }

            public final GraphQLVisitableModel m6197a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m6198a() != null) {
                    CheckinLocationModel checkinLocationModel = (CheckinLocationModel) r4.b(m6198a());
                    if (m6198a() != checkinLocationModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4211d = checkinLocationModel;
                    }
                }
                if (m6199j() != null) {
                    FramePackModel framePackModel = (FramePackModel) r4.b(m6199j());
                    if (m6199j() != framePackModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4212e = framePackModel;
                    }
                }
                if (m6200k() != null) {
                    LinkAttachmentModel linkAttachmentModel = (LinkAttachmentModel) r4.b(m6200k());
                    if (m6200k() != linkAttachmentModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4213f = linkAttachmentModel;
                    }
                }
                if (m6201l() != null) {
                    MemeCategoryModel memeCategoryModel = (MemeCategoryModel) r4.b(m6201l());
                    if (m6201l() != memeCategoryModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4214g = memeCategoryModel;
                    }
                }
                if (m6202m() != null) {
                    MinutiaeActionModel minutiaeActionModel = (MinutiaeActionModel) r4.b(m6202m());
                    if (m6202m() != minutiaeActionModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4215h = minutiaeActionModel;
                    }
                }
                if (m6203n() != null) {
                    ImageOverlayFieldsModel imageOverlayFieldsModel = (ImageOverlayFieldsModel) r4.b(m6203n());
                    if (m6203n() != imageOverlayFieldsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4216i = imageOverlayFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m6196a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(r9, m6198a());
                int a2 = ModelHelper.a(r9, m6199j());
                int a3 = ModelHelper.a(r9, m6200k());
                int a4 = ModelHelper.a(r9, m6201l());
                int a5 = ModelHelper.a(r9, m6202m());
                int a6 = ModelHelper.a(r9, m6203n());
                int c = r9.c(m6204o());
                r9.c(7);
                r9.b(0, a);
                r9.b(1, a2);
                r9.b(2, a3);
                r9.b(3, a4);
                r9.b(4, a5);
                r9.b(5, a6);
                r9.b(6, c);
                i();
                return r9.d();
            }
        }

        /* compiled from: state_report_button_position */
        public class Serializer extends JsonSerializer<EdgesModel> {
            public final void m6205a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                EdgesModel edgesModel = (EdgesModel) obj;
                if (edgesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(edgesModel.m6206a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                EdgesParser.m6243b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(EdgesModel.class, new Serializer());
            }
        }

        public EdgesModel() {
            super(5);
        }

        @Nullable
        public final String m6208a() {
            this.f4218d = super.a(this.f4218d, 0);
            return this.f4218d;
        }

        @Nullable
        public final NodeModel m6209j() {
            this.f4219e = (NodeModel) super.a(this.f4219e, 1, NodeModel.class);
            return this.f4219e;
        }

        @Nullable
        public final String m6210k() {
            this.f4220f = super.a(this.f4220f, 2);
            return this.f4220f;
        }

        @Nullable
        public final String m6211l() {
            this.f4221g = super.a(this.f4221g, 3);
            return this.f4221g;
        }

        @Nullable
        public final DefaultTextWithEntitiesFieldsModel m6212m() {
            this.f4222h = (DefaultTextWithEntitiesFieldsModel) super.a(this.f4222h, 4, DefaultTextWithEntitiesFieldsModel.class);
            return this.f4222h;
        }

        public final int jK_() {
            return -1264874871;
        }

        public final GraphQLVisitableModel m6207a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m6209j() != null) {
                NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m6209j());
                if (m6209j() != nodeModel) {
                    graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4219e = nodeModel;
                }
            }
            if (m6212m() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m6212m());
                if (m6212m() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (EdgesModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4222h = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m6206a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m6208a());
            int a = ModelHelper.a(flatBufferBuilder, m6209j());
            int b2 = flatBufferBuilder.b(m6210k());
            int b3 = flatBufferBuilder.b(m6211l());
            int a2 = ModelHelper.a(flatBufferBuilder, m6212m());
            flatBufferBuilder.c(5);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: state_report_button_position */
    public class Serializer extends JsonSerializer<C0259xb568e2b0> {
        public final void m6213a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0259xb568e2b0 c0259xb568e2b0 = (C0259xb568e2b0) obj;
            if (c0259xb568e2b0.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0259xb568e2b0.m6214a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0259xb568e2b0.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            SuggestedCompositionParser.m6245a(c0259xb568e2b0.w_(), c0259xb568e2b0.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C0259xb568e2b0.class, new Serializer());
        }
    }

    public C0259xb568e2b0() {
        super(1);
    }

    @Nonnull
    public final ImmutableList<EdgesModel> m6216a() {
        this.f4223d = super.a(this.f4223d, 0, EdgesModel.class);
        return (ImmutableList) this.f4223d;
    }

    public final int jK_() {
        return -618474838;
    }

    public final GraphQLVisitableModel m6215a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6216a() != null) {
            Builder a = ModelHelper.a(m6216a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (C0259xb568e2b0) ModelHelper.a(null, this);
                graphQLVisitableModel.f4223d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m6214a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6216a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}

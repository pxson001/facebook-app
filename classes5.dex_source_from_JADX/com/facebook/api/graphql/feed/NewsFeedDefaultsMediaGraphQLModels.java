package com.facebook.api.graphql.feed;

import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.AttachmentMediaParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.AttachmentMediaParser.CreationStoryParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.AttachmentMediaParser.CreationStoryParser.ActorsParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.AttachmentMediaParser.CreationStoryParser.AttachmentsParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.AttachmentMediaParser.CreationStoryParser.AttachmentsParser.MediaParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.AttachmentMediaParser.CreationStoryParser.AttachmentsParser.SourceParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.AttachmentMediaParser.CreationStoryParser.AttachmentsParser.TargetParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.AttachmentMediaParser.CreationStoryParser.AttachmentsParser.TargetParser.ApplicationParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.AttachmentMediaParser.CreationStoryParser.ShareableParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.AttachmentMediaParser.OwnerParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.AttachmentMediaParser.PairedVideoParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.Photo360FieldsParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.Photo360FieldsParser.PhotoEncodingsParser;
import com.facebook.api.graphql.feed.NewsFeedDefaultsMediaGraphQLParsers.Photo360FieldsParser.PhotoEncodingsParser.SphericalMetadataParser;
import com.facebook.api.graphql.feedback.NewsFeedFeedbackGraphQLModels.NewsFeedDefaultsFeedbackModel;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.AttributionAppMediaMetadataModel.AttributionAppModel;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.SphericalMetadataModel.GuidedTourModel;
import com.facebook.api.graphql.media.NewsFeedMediaGraphQLModels.VideoChannelIdForVideoFragmentModel.VideoChannelModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLLiveVideoSubscriptionStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.enums.GraphQLVideoBroadcastStatus;
import com.facebook.graphql.enums.GraphQLVideoStatusType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Interfaces.DefaultVect2Fields;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultVect2FieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
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

/* compiled from: api_success_response */
public class NewsFeedDefaultsMediaGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 421720337)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: api_success_response */
    public final class AttachmentMediaModel extends BaseModel implements NewsFeedDefaultsMediaGraphQLInterfaces$AttachmentMedia, GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private DefaultImageFieldsModel f9337A;
        @Nullable
        private DefaultImageFieldsModel f9338B;
        @Nullable
        private DefaultImageFieldsModel f9339C;
        @Nullable
        private DefaultImageFieldsModel f9340D;
        @Nullable
        private DefaultImageFieldsModel f9341E;
        private int f9342F;
        private int f9343G;
        private int f9344H;
        private boolean f9345I;
        private boolean f9346J;
        private boolean f9347K;
        private boolean f9348L;
        private boolean f9349M;
        private boolean f9350N;
        private boolean f9351O;
        private boolean f9352P;
        private boolean f9353Q;
        private int f9354R;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f9355S;
        @Nullable
        private OwnerModel f9356T;
        @Nullable
        private PairedVideoModel f9357U;
        @Nullable
        private List<PhotoEncodingsModel> f9358V;
        private int f9359W;
        @Nullable
        private String f9360X;
        @Nullable
        private String f9361Y;
        private int f9362Z;
        @Nullable
        private String aa;
        @Nullable
        private String ab;
        private int ac;
        @Nullable
        private String ad;
        @Nullable
        private String ae;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel af;
        private boolean ag;
        private boolean ah;
        private boolean ai;
        private boolean aj;
        private double ak;
        private double al;
        @Nullable
        private String am;
        @Nullable
        private String an;
        private int ao;
        private boolean ap;
        private int aq;
        @Nullable
        private List<String> ar;
        @Nullable
        private VideoChannelModel as;
        private int at;
        @Nullable
        private GraphQLVideoStatusType au;
        private int av;
        @Nullable
        private GraphQLObjectType f9363d;
        @Nullable
        private DefaultImageFieldsModel f9364e;
        private int f9365f;
        @Nullable
        private AttributionAppModel f9366g;
        @Nullable
        private String f9367h;
        private int f9368i;
        @Nullable
        private GraphQLVideoBroadcastStatus f9369j;
        private boolean f9370k;
        private boolean f9371l;
        private boolean f9372m;
        private boolean f9373n;
        @Nullable
        private String f9374o;
        private long f9375p;
        @Nullable
        private CreationStoryModel f9376q;
        @Nullable
        private NewsFeedDefaultsFeedbackModel f9377r;
        @Nullable
        private DefaultVect2FieldsModel f9378s;
        @Nullable
        private GuidedTourModel f9379t;
        private boolean f9380u;
        private int f9381v;
        private int f9382w;
        private int f9383x;
        @Nullable
        private String f9384y;
        @Nullable
        private DefaultImageFieldsModel f9385z;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1929286054)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: api_success_response */
        public final class CreationStoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private List<ActorsModel> f9319d;
            @Nullable
            private List<AttachmentsModel> f9320e;
            @Nullable
            private String f9321f;
            private long f9322g;
            @Nullable
            private NewsFeedDefaultsFeedbackModel f9323h;
            @Nullable
            private String f9324i;
            @Nullable
            private ShareableModel f9325j;
            @Nullable
            private String f9326k;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -341630258)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: api_success_response */
            public final class ActorsModel extends BaseModel implements GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f9301d;
                @Nullable
                private String f9302e;

                /* compiled from: api_success_response */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActorsModel.class, new Deserializer());
                    }

                    public Object m15891a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ActorsParser.m16046b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object actorsModel = new ActorsModel();
                        ((BaseModel) actorsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (actorsModel instanceof Postprocessable) {
                            return ((Postprocessable) actorsModel).a();
                        }
                        return actorsModel;
                    }
                }

                /* compiled from: api_success_response */
                public class Serializer extends JsonSerializer<ActorsModel> {
                    public final void m15892a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActorsModel actorsModel = (ActorsModel) obj;
                        if (actorsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(actorsModel.m15895a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            actorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ActorsParser.m16045a(actorsModel.w_(), actorsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ActorsModel.class, new Serializer());
                    }
                }

                public ActorsModel() {
                    super(2);
                }

                public final void m15897a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m15898a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m15893a() {
                    if (this.b != null && this.f9301d == null) {
                        this.f9301d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f9301d;
                }

                @Nullable
                private String m15894j() {
                    this.f9302e = super.a(this.f9302e, 1);
                    return this.f9302e;
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m15896a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15895a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15893a());
                    int b = flatBufferBuilder.b(m15894j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1975144041)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: api_success_response */
            public final class AttachmentsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private MediaModel f9311d;
                @Nullable
                private SourceModel f9312e;
                @Nullable
                private List<GraphQLStoryAttachmentStyle> f9313f;
                @Nullable
                private TargetModel f9314g;
                @Nullable
                private String f9315h;
                @Nullable
                private String f9316i;

                /* compiled from: api_success_response */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AttachmentsModel.class, new Deserializer());
                    }

                    public Object m15899a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AttachmentsParser.m16056b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object attachmentsModel = new AttachmentsModel();
                        ((BaseModel) attachmentsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (attachmentsModel instanceof Postprocessable) {
                            return ((Postprocessable) attachmentsModel).a();
                        }
                        return attachmentsModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1516699231)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: api_success_response */
                public final class MediaModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                    @Nullable
                    private GraphQLObjectType f9303d;
                    @Nullable
                    private String f9304e;
                    @Nullable
                    private DefaultImageFieldsModel f9305f;

                    /* compiled from: api_success_response */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(MediaModel.class, new Deserializer());
                        }

                        public Object m15900a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(MediaParser.m16047a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object mediaModel = new MediaModel();
                            ((BaseModel) mediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (mediaModel instanceof Postprocessable) {
                                return ((Postprocessable) mediaModel).a();
                            }
                            return mediaModel;
                        }
                    }

                    /* compiled from: api_success_response */
                    public class Serializer extends JsonSerializer<MediaModel> {
                        public final void m15901a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            MediaModel mediaModel = (MediaModel) obj;
                            if (mediaModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(mediaModel.m15905a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            MediaParser.m16048a(mediaModel.w_(), mediaModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(MediaModel.class, new Serializer());
                        }
                    }

                    public MediaModel() {
                        super(3);
                    }

                    @Nullable
                    private GraphQLObjectType m15902j() {
                        if (this.b != null && this.f9303d == null) {
                            this.f9303d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f9303d;
                    }

                    @Nullable
                    private String m15903k() {
                        this.f9304e = super.a(this.f9304e, 1);
                        return this.f9304e;
                    }

                    @Nullable
                    private DefaultImageFieldsModel m15904l() {
                        this.f9305f = (DefaultImageFieldsModel) super.a(this.f9305f, 2, DefaultImageFieldsModel.class);
                        return this.f9305f;
                    }

                    @Nullable
                    public final String m15907a() {
                        return m15903k();
                    }

                    public final int jK_() {
                        return 74219460;
                    }

                    public final GraphQLVisitableModel m15906a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m15904l() != null) {
                            DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15904l());
                            if (m15904l() != defaultImageFieldsModel) {
                                graphQLVisitableModel = (MediaModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f9305f = defaultImageFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m15905a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m15902j());
                        int b = flatBufferBuilder.b(m15903k());
                        int a2 = ModelHelper.a(flatBufferBuilder, m15904l());
                        flatBufferBuilder.c(3);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        flatBufferBuilder.b(2, a2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: api_success_response */
                public class Serializer extends JsonSerializer<AttachmentsModel> {
                    public final void m15908a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AttachmentsModel attachmentsModel = (AttachmentsModel) obj;
                        if (attachmentsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(attachmentsModel.m15935a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            attachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AttachmentsParser.m16057b(attachmentsModel.w_(), attachmentsModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(AttachmentsModel.class, new Serializer());
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1352864475)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: api_success_response */
                public final class SourceModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f9306d;

                    /* compiled from: api_success_response */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(SourceModel.class, new Deserializer());
                        }

                        public Object m15909a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(SourceParser.m16049a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object sourceModel = new SourceModel();
                            ((BaseModel) sourceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (sourceModel instanceof Postprocessable) {
                                return ((Postprocessable) sourceModel).a();
                            }
                            return sourceModel;
                        }
                    }

                    /* compiled from: api_success_response */
                    public class Serializer extends JsonSerializer<SourceModel> {
                        public final void m15910a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            SourceModel sourceModel = (SourceModel) obj;
                            if (sourceModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(sourceModel.m15912a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                sourceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            SourceParser.m16050a(sourceModel.w_(), sourceModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(SourceModel.class, new Serializer());
                        }
                    }

                    public SourceModel() {
                        super(1);
                    }

                    @Nullable
                    private String m15911a() {
                        this.f9306d = super.a(this.f9306d, 0);
                        return this.f9306d;
                    }

                    public final int jK_() {
                        return -1919764332;
                    }

                    public final GraphQLVisitableModel m15913a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m15912a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m15911a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 224148772)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: api_success_response */
                public final class TargetModel extends BaseModel implements GraphQLVisitableConsistentModel {
                    @Nullable
                    private GraphQLObjectType f9309d;
                    @Nullable
                    private ApplicationModel f9310e;

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1185712657)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: api_success_response */
                    public final class ApplicationModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                        @Nullable
                        private String f9307d;
                        @Nullable
                        private String f9308e;

                        /* compiled from: api_success_response */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ApplicationModel.class, new Deserializer());
                            }

                            public Object m15914a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ApplicationParser.m16051a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object applicationModel = new ApplicationModel();
                                ((BaseModel) applicationModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (applicationModel instanceof Postprocessable) {
                                    return ((Postprocessable) applicationModel).a();
                                }
                                return applicationModel;
                            }
                        }

                        /* compiled from: api_success_response */
                        public class Serializer extends JsonSerializer<ApplicationModel> {
                            public final void m15915a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ApplicationModel applicationModel = (ApplicationModel) obj;
                                if (applicationModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(applicationModel.m15918a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    applicationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ApplicationParser.m16052a(applicationModel.w_(), applicationModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ApplicationModel.class, new Serializer());
                            }
                        }

                        public ApplicationModel() {
                            super(2);
                        }

                        @Nullable
                        private String m15916j() {
                            this.f9307d = super.a(this.f9307d, 0);
                            return this.f9307d;
                        }

                        @Nullable
                        private String m15917k() {
                            this.f9308e = super.a(this.f9308e, 1);
                            return this.f9308e;
                        }

                        @Nullable
                        public final String m15920a() {
                            return m15916j();
                        }

                        public final int jK_() {
                            return -1072845520;
                        }

                        public final GraphQLVisitableModel m15919a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m15918a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m15916j());
                            int b2 = flatBufferBuilder.b(m15917k());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, b);
                            flatBufferBuilder.b(1, b2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: api_success_response */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(TargetModel.class, new Deserializer());
                        }

                        public Object m15921a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(TargetParser.m16053a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object targetModel = new TargetModel();
                            ((BaseModel) targetModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (targetModel instanceof Postprocessable) {
                                return ((Postprocessable) targetModel).a();
                            }
                            return targetModel;
                        }
                    }

                    /* compiled from: api_success_response */
                    public class Serializer extends JsonSerializer<TargetModel> {
                        public final void m15922a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            TargetModel targetModel = (TargetModel) obj;
                            if (targetModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(targetModel.m15925a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                targetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            TargetParser.m16054a(targetModel.w_(), targetModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(TargetModel.class, new Serializer());
                        }
                    }

                    public TargetModel() {
                        super(2);
                    }

                    public final void m15927a(String str, ConsistencyTuple consistencyTuple) {
                        consistencyTuple.a();
                    }

                    public final void m15928a(String str, Object obj, boolean z) {
                    }

                    @Nullable
                    private GraphQLObjectType m15923a() {
                        if (this.b != null && this.f9309d == null) {
                            this.f9309d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f9309d;
                    }

                    @Nullable
                    private ApplicationModel m15924j() {
                        this.f9310e = (ApplicationModel) super.a(this.f9310e, 1, ApplicationModel.class);
                        return this.f9310e;
                    }

                    public final int jK_() {
                        return 2433570;
                    }

                    public final GraphQLVisitableModel m15926a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m15924j() != null) {
                            ApplicationModel applicationModel = (ApplicationModel) graphQLModelMutatingVisitor.b(m15924j());
                            if (m15924j() != applicationModel) {
                                graphQLVisitableModel = (TargetModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f9310e = applicationModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m15925a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m15923a());
                        int a2 = ModelHelper.a(flatBufferBuilder, m15924j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                public AttachmentsModel() {
                    super(6);
                }

                @Nullable
                private MediaModel m15929a() {
                    this.f9311d = (MediaModel) super.a(this.f9311d, 0, MediaModel.class);
                    return this.f9311d;
                }

                @Nullable
                private SourceModel m15930j() {
                    this.f9312e = (SourceModel) super.a(this.f9312e, 1, SourceModel.class);
                    return this.f9312e;
                }

                @Nonnull
                private ImmutableList<GraphQLStoryAttachmentStyle> m15931k() {
                    this.f9313f = super.c(this.f9313f, 2, GraphQLStoryAttachmentStyle.class);
                    return (ImmutableList) this.f9313f;
                }

                @Nullable
                private TargetModel m15932l() {
                    this.f9314g = (TargetModel) super.a(this.f9314g, 3, TargetModel.class);
                    return this.f9314g;
                }

                @Nullable
                private String m15933m() {
                    this.f9315h = super.a(this.f9315h, 4);
                    return this.f9315h;
                }

                @Nullable
                private String m15934n() {
                    this.f9316i = super.a(this.f9316i, 5);
                    return this.f9316i;
                }

                public final int jK_() {
                    return -1267730472;
                }

                public final GraphQLVisitableModel m15936a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m15929a() != null) {
                        MediaModel mediaModel = (MediaModel) graphQLModelMutatingVisitor.b(m15929a());
                        if (m15929a() != mediaModel) {
                            graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f9311d = mediaModel;
                        }
                    }
                    if (m15930j() != null) {
                        SourceModel sourceModel = (SourceModel) graphQLModelMutatingVisitor.b(m15930j());
                        if (m15930j() != sourceModel) {
                            graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9312e = sourceModel;
                        }
                    }
                    if (m15932l() != null) {
                        TargetModel targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m15932l());
                        if (m15932l() != targetModel) {
                            graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f9314g = targetModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m15935a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15929a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m15930j());
                    int d = flatBufferBuilder.d(m15931k());
                    int a3 = ModelHelper.a(flatBufferBuilder, m15932l());
                    int b = flatBufferBuilder.b(m15933m());
                    int b2 = flatBufferBuilder.b(m15934n());
                    flatBufferBuilder.c(6);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, d);
                    flatBufferBuilder.b(3, a3);
                    flatBufferBuilder.b(4, b);
                    flatBufferBuilder.b(5, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: api_success_response */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CreationStoryModel.class, new Deserializer());
                }

                public Object m15937a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CreationStoryParser.m16060a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object creationStoryModel = new CreationStoryModel();
                    ((BaseModel) creationStoryModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (creationStoryModel instanceof Postprocessable) {
                        return ((Postprocessable) creationStoryModel).a();
                    }
                    return creationStoryModel;
                }
            }

            /* compiled from: api_success_response */
            public class Serializer extends JsonSerializer<CreationStoryModel> {
                public final void m15938a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CreationStoryModel creationStoryModel = (CreationStoryModel) obj;
                    if (creationStoryModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(creationStoryModel.m15953a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        creationStoryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CreationStoryParser.m16061a(creationStoryModel.w_(), creationStoryModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CreationStoryModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: api_success_response */
            public final class ShareableModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f9317d;
                @Nullable
                private String f9318e;

                /* compiled from: api_success_response */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ShareableModel.class, new Deserializer());
                    }

                    public Object m15939a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ShareableParser.m16058a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object shareableModel = new ShareableModel();
                        ((BaseModel) shareableModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (shareableModel instanceof Postprocessable) {
                            return ((Postprocessable) shareableModel).a();
                        }
                        return shareableModel;
                    }
                }

                /* compiled from: api_success_response */
                public class Serializer extends JsonSerializer<ShareableModel> {
                    public final void m15940a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ShareableModel shareableModel = (ShareableModel) obj;
                        if (shareableModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(shareableModel.m15943a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            shareableModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ShareableParser.m16059a(shareableModel.w_(), shareableModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ShareableModel.class, new Serializer());
                    }
                }

                public ShareableModel() {
                    super(2);
                }

                @Nullable
                private GraphQLObjectType m15941j() {
                    if (this.b != null && this.f9317d == null) {
                        this.f9317d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f9317d;
                }

                @Nullable
                private String m15942k() {
                    this.f9318e = super.a(this.f9318e, 1);
                    return this.f9318e;
                }

                @Nullable
                public final String m15945a() {
                    return m15942k();
                }

                public final int jK_() {
                    return 2080559107;
                }

                public final GraphQLVisitableModel m15944a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m15943a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m15941j());
                    int b = flatBufferBuilder.b(m15942k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            public CreationStoryModel() {
                super(8);
            }

            public final void m15957a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m15958a(String str, Object obj, boolean z) {
            }

            @Nonnull
            private ImmutableList<ActorsModel> m15946j() {
                this.f9319d = super.a(this.f9319d, 0, ActorsModel.class);
                return (ImmutableList) this.f9319d;
            }

            @Nonnull
            private ImmutableList<AttachmentsModel> m15947k() {
                this.f9320e = super.a(this.f9320e, 1, AttachmentsModel.class);
                return (ImmutableList) this.f9320e;
            }

            @Nullable
            private String m15948l() {
                this.f9321f = super.a(this.f9321f, 2);
                return this.f9321f;
            }

            @Nullable
            private NewsFeedDefaultsFeedbackModel m15949m() {
                this.f9323h = (NewsFeedDefaultsFeedbackModel) super.a(this.f9323h, 4, NewsFeedDefaultsFeedbackModel.class);
                return this.f9323h;
            }

            @Nullable
            private String m15950n() {
                this.f9324i = super.a(this.f9324i, 5);
                return this.f9324i;
            }

            @Nullable
            private ShareableModel m15951o() {
                this.f9325j = (ShareableModel) super.a(this.f9325j, 6, ShareableModel.class);
                return this.f9325j;
            }

            @Nullable
            private String m15952p() {
                this.f9326k = super.a(this.f9326k, 7);
                return this.f9326k;
            }

            @Nullable
            public final String m15955a() {
                return m15950n();
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m15954a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                Builder a;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m15946j() != null) {
                    a = ModelHelper.a(m15946j(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CreationStoryModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9319d = a.b();
                    }
                }
                if (m15947k() != null) {
                    a = ModelHelper.a(m15947k(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (CreationStoryModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f9320e = a.b();
                    }
                }
                GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
                if (m15949m() != null) {
                    NewsFeedDefaultsFeedbackModel newsFeedDefaultsFeedbackModel = (NewsFeedDefaultsFeedbackModel) graphQLModelMutatingVisitor.b(m15949m());
                    if (m15949m() != newsFeedDefaultsFeedbackModel) {
                        graphQLVisitableModel2 = (CreationStoryModel) ModelHelper.a(graphQLVisitableModel2, this);
                        graphQLVisitableModel2.f9323h = newsFeedDefaultsFeedbackModel;
                    }
                }
                if (m15951o() != null) {
                    ShareableModel shareableModel = (ShareableModel) graphQLModelMutatingVisitor.b(m15951o());
                    if (m15951o() != shareableModel) {
                        graphQLVisitableModel2 = (CreationStoryModel) ModelHelper.a(graphQLVisitableModel2, this);
                        graphQLVisitableModel2.f9325j = shareableModel;
                    }
                }
                i();
                return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
            }

            public final int m15953a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15946j());
                int a2 = ModelHelper.a(flatBufferBuilder, m15947k());
                int b = flatBufferBuilder.b(m15948l());
                int a3 = ModelHelper.a(flatBufferBuilder, m15949m());
                int b2 = flatBufferBuilder.b(m15950n());
                int a4 = ModelHelper.a(flatBufferBuilder, m15951o());
                int b3 = flatBufferBuilder.b(m15952p());
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.a(3, this.f9322g, 0);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, b2);
                flatBufferBuilder.b(6, a4);
                flatBufferBuilder.b(7, b3);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15956a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9322g = mutableFlatBuffer.a(i, 3, 0);
            }
        }

        /* compiled from: api_success_response */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AttachmentMediaModel.class, new Deserializer());
            }

            public Object m15959a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AttachmentMediaParser.m16066a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object attachmentMediaModel = new AttachmentMediaModel();
                ((BaseModel) attachmentMediaModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (attachmentMediaModel instanceof Postprocessable) {
                    return ((Postprocessable) attachmentMediaModel).a();
                }
                return attachmentMediaModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 60015698)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: api_success_response */
        public final class OwnerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f9327d;
            @Nullable
            private String f9328e;
            private boolean f9329f;
            @Nullable
            private GraphQLLiveVideoSubscriptionStatus f9330g;
            @Nullable
            private String f9331h;
            private boolean f9332i;
            private boolean f9333j;
            private boolean f9334k;
            private boolean f9335l;

            /* compiled from: api_success_response */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OwnerModel.class, new Deserializer());
                }

                public Object m15960a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OwnerParser.m16062a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object ownerModel = new OwnerModel();
                    ((BaseModel) ownerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (ownerModel instanceof Postprocessable) {
                        return ((Postprocessable) ownerModel).a();
                    }
                    return ownerModel;
                }
            }

            /* compiled from: api_success_response */
            public class Serializer extends JsonSerializer<OwnerModel> {
                public final void m15961a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OwnerModel ownerModel = (OwnerModel) obj;
                    if (ownerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ownerModel.m15971a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        ownerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OwnerParser.m16063a(ownerModel.w_(), ownerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(OwnerModel.class, new Serializer());
                }
            }

            public OwnerModel() {
                super(9);
            }

            public final void m15975a(String str, ConsistencyTuple consistencyTuple) {
                if ("live_video_subscription_status".equals(str)) {
                    consistencyTuple.a = m15967l();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 3;
                } else if ("video_channel_has_viewer_subscribed".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m15969n());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 7;
                } else if ("video_channel_is_viewer_following".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m15970o());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 8;
                } else {
                    consistencyTuple.a();
                }
            }

            public final void m15976a(String str, Object obj, boolean z) {
                if ("live_video_subscription_status".equals(str)) {
                    m15962a((GraphQLLiveVideoSubscriptionStatus) obj);
                } else if ("video_channel_has_viewer_subscribed".equals(str)) {
                    m15963a(((Boolean) obj).booleanValue());
                } else if ("video_channel_is_viewer_following".equals(str)) {
                    m15964b(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private GraphQLObjectType m15965j() {
                if (this.b != null && this.f9327d == null) {
                    this.f9327d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f9327d;
            }

            @Nullable
            private String m15966k() {
                this.f9328e = super.a(this.f9328e, 1);
                return this.f9328e;
            }

            @Nullable
            private GraphQLLiveVideoSubscriptionStatus m15967l() {
                this.f9330g = (GraphQLLiveVideoSubscriptionStatus) super.b(this.f9330g, 3, GraphQLLiveVideoSubscriptionStatus.class, GraphQLLiveVideoSubscriptionStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f9330g;
            }

            private void m15962a(GraphQLLiveVideoSubscriptionStatus graphQLLiveVideoSubscriptionStatus) {
                this.f9330g = graphQLLiveVideoSubscriptionStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 3, graphQLLiveVideoSubscriptionStatus != null ? graphQLLiveVideoSubscriptionStatus.name() : null);
                }
            }

            @Nullable
            private String m15968m() {
                this.f9331h = super.a(this.f9331h, 4);
                return this.f9331h;
            }

            private boolean m15969n() {
                a(0, 7);
                return this.f9334k;
            }

            private void m15963a(boolean z) {
                this.f9334k = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 7, z);
                }
            }

            private boolean m15970o() {
                a(1, 0);
                return this.f9335l;
            }

            private void m15964b(boolean z) {
                this.f9335l = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 8, z);
                }
            }

            @Nullable
            public final String m15973a() {
                return m15966k();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m15972a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15971a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m15965j());
                int b = flatBufferBuilder.b(m15966k());
                int a2 = flatBufferBuilder.a(m15967l());
                int b2 = flatBufferBuilder.b(m15968m());
                flatBufferBuilder.c(9);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.a(2, this.f9329f);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.a(5, this.f9332i);
                flatBufferBuilder.a(6, this.f9333j);
                flatBufferBuilder.a(7, this.f9334k);
                flatBufferBuilder.a(8, this.f9335l);
                i();
                return flatBufferBuilder.d();
            }

            public final void m15974a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9329f = mutableFlatBuffer.a(i, 2);
                this.f9332i = mutableFlatBuffer.a(i, 5);
                this.f9333j = mutableFlatBuffer.a(i, 6);
                this.f9334k = mutableFlatBuffer.a(i, 7);
                this.f9335l = mutableFlatBuffer.a(i, 8);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1183183884)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: api_success_response */
        public final class PairedVideoModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f9336d;

            /* compiled from: api_success_response */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PairedVideoModel.class, new Deserializer());
                }

                public Object m15977a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PairedVideoParser.m16064a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pairedVideoModel = new PairedVideoModel();
                    ((BaseModel) pairedVideoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pairedVideoModel instanceof Postprocessable) {
                        return ((Postprocessable) pairedVideoModel).a();
                    }
                    return pairedVideoModel;
                }
            }

            /* compiled from: api_success_response */
            public class Serializer extends JsonSerializer<PairedVideoModel> {
                public final void m15978a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PairedVideoModel pairedVideoModel = (PairedVideoModel) obj;
                    if (pairedVideoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pairedVideoModel.m15980a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pairedVideoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PairedVideoParser.m16065a(pairedVideoModel.w_(), pairedVideoModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(PairedVideoModel.class, new Serializer());
                }
            }

            public PairedVideoModel() {
                super(1);
            }

            @Nullable
            private String m15979a() {
                this.f9336d = super.a(this.f9336d, 0);
                return this.f9336d;
            }

            public final int jK_() {
                return 82650203;
            }

            public final GraphQLVisitableModel m15981a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m15980a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m15979a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: api_success_response */
        public class Serializer extends JsonSerializer<AttachmentMediaModel> {
            public final void m15982a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AttachmentMediaModel attachmentMediaModel = (AttachmentMediaModel) obj;
                if (attachmentMediaModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(attachmentMediaModel.m16014a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    attachmentMediaModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AttachmentMediaParser.m16067a(attachmentMediaModel.w_(), attachmentMediaModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AttachmentMediaModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bc_() {
            return m16010w();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields bd_() {
            return m16009v();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields be_() {
            return m16006s();
        }

        @Nullable
        public final /* synthetic */ DefaultVect2Fields m16019c() {
            return m16004q();
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m16021g() {
            return m16007t();
        }

        public AttachmentMediaModel() {
            super(71);
        }

        @Nullable
        public final GraphQLObjectType m16018b() {
            if (this.b != null && this.f9363d == null) {
                this.f9363d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f9363d;
        }

        @Nullable
        private DefaultImageFieldsModel m15997j() {
            this.f9364e = (DefaultImageFieldsModel) super.a(this.f9364e, 1, DefaultImageFieldsModel.class);
            return this.f9364e;
        }

        @Nullable
        private AttributionAppModel m15998k() {
            this.f9366g = (AttributionAppModel) super.a(this.f9366g, 3, AttributionAppModel.class);
            return this.f9366g;
        }

        @Nullable
        private String m15999l() {
            this.f9367h = super.a(this.f9367h, 4);
            return this.f9367h;
        }

        @Nullable
        private GraphQLVideoBroadcastStatus m16000m() {
            this.f9369j = (GraphQLVideoBroadcastStatus) super.b(this.f9369j, 6, GraphQLVideoBroadcastStatus.class, GraphQLVideoBroadcastStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f9369j;
        }

        @Nullable
        private String m16001n() {
            this.f9374o = super.a(this.f9374o, 11);
            return this.f9374o;
        }

        @Nullable
        private CreationStoryModel m16002o() {
            this.f9376q = (CreationStoryModel) super.a(this.f9376q, 13, CreationStoryModel.class);
            return this.f9376q;
        }

        @Nullable
        private NewsFeedDefaultsFeedbackModel m16003p() {
            this.f9377r = (NewsFeedDefaultsFeedbackModel) super.a(this.f9377r, 14, NewsFeedDefaultsFeedbackModel.class);
            return this.f9377r;
        }

        @Nullable
        private DefaultVect2FieldsModel m16004q() {
            this.f9378s = (DefaultVect2FieldsModel) super.a(this.f9378s, 15, DefaultVect2FieldsModel.class);
            return this.f9378s;
        }

        @Nullable
        private GuidedTourModel m16005r() {
            this.f9379t = (GuidedTourModel) super.a(this.f9379t, 16, GuidedTourModel.class);
            return this.f9379t;
        }

        @Nullable
        public final String m16020d() {
            this.f9384y = super.a(this.f9384y, 21);
            return this.f9384y;
        }

        @Nullable
        private DefaultImageFieldsModel m16006s() {
            this.f9385z = (DefaultImageFieldsModel) super.a(this.f9385z, 22, DefaultImageFieldsModel.class);
            return this.f9385z;
        }

        @Nullable
        private DefaultImageFieldsModel m16007t() {
            this.f9337A = (DefaultImageFieldsModel) super.a(this.f9337A, 23, DefaultImageFieldsModel.class);
            return this.f9337A;
        }

        @Nullable
        private DefaultImageFieldsModel m16008u() {
            this.f9338B = (DefaultImageFieldsModel) super.a(this.f9338B, 24, DefaultImageFieldsModel.class);
            return this.f9338B;
        }

        @Nullable
        private DefaultImageFieldsModel m16009v() {
            this.f9339C = (DefaultImageFieldsModel) super.a(this.f9339C, 25, DefaultImageFieldsModel.class);
            return this.f9339C;
        }

        @Nullable
        private DefaultImageFieldsModel m16010w() {
            this.f9340D = (DefaultImageFieldsModel) super.a(this.f9340D, 26, DefaultImageFieldsModel.class);
            return this.f9340D;
        }

        @Nullable
        private DefaultImageFieldsModel m16011x() {
            this.f9341E = (DefaultImageFieldsModel) super.a(this.f9341E, 27, DefaultImageFieldsModel.class);
            return this.f9341E;
        }

        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel m16012y() {
            this.f9355S = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f9355S, 41, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f9355S;
        }

        @Nullable
        private OwnerModel m16013z() {
            this.f9356T = (OwnerModel) super.a(this.f9356T, 42, OwnerModel.class);
            return this.f9356T;
        }

        @Nullable
        private PairedVideoModel m15983A() {
            this.f9357U = (PairedVideoModel) super.a(this.f9357U, 43, PairedVideoModel.class);
            return this.f9357U;
        }

        @Nonnull
        private ImmutableList<PhotoEncodingsModel> m15984B() {
            this.f9358V = super.a(this.f9358V, 44, PhotoEncodingsModel.class);
            return (ImmutableList) this.f9358V;
        }

        @Nullable
        private String m15985C() {
            this.f9360X = super.a(this.f9360X, 46);
            return this.f9360X;
        }

        @Nullable
        private String m15986D() {
            this.f9361Y = super.a(this.f9361Y, 47);
            return this.f9361Y;
        }

        @Nullable
        private String m15987E() {
            this.aa = super.a(this.aa, 49);
            return this.aa;
        }

        @Nullable
        private String m15988F() {
            this.ab = super.a(this.ab, 50);
            return this.ab;
        }

        @Nullable
        private String m15989G() {
            this.ad = super.a(this.ad, 52);
            return this.ad;
        }

        @Nullable
        private String m15990H() {
            this.ae = super.a(this.ae, 53);
            return this.ae;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m15991I() {
            this.af = (DefaultTextWithEntitiesFieldsModel) super.a(this.af, 54, DefaultTextWithEntitiesFieldsModel.class);
            return this.af;
        }

        @Nullable
        private String m15992J() {
            this.am = super.a(this.am, 61);
            return this.am;
        }

        @Nullable
        private String m15993K() {
            this.an = super.a(this.an, 62);
            return this.an;
        }

        @Nonnull
        private ImmutableList<String> m15994L() {
            this.ar = super.a(this.ar, 66);
            return (ImmutableList) this.ar;
        }

        @Nullable
        private VideoChannelModel m15995M() {
            this.as = (VideoChannelModel) super.a(this.as, 67, VideoChannelModel.class);
            return this.as;
        }

        @Nullable
        private GraphQLVideoStatusType m15996N() {
            this.au = (GraphQLVideoStatusType) super.b(this.au, 69, GraphQLVideoStatusType.class, GraphQLVideoStatusType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.au;
        }

        @Nullable
        public final String m16016a() {
            return m16020d();
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m16015a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m15997j() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m15997j());
                if (m15997j() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9364e = defaultImageFieldsModel;
                }
            }
            if (m15998k() != null) {
                AttributionAppModel attributionAppModel = (AttributionAppModel) graphQLModelMutatingVisitor.b(m15998k());
                if (m15998k() != attributionAppModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9366g = attributionAppModel;
                }
            }
            if (m16002o() != null) {
                CreationStoryModel creationStoryModel = (CreationStoryModel) graphQLModelMutatingVisitor.b(m16002o());
                if (m16002o() != creationStoryModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9376q = creationStoryModel;
                }
            }
            if (m16003p() != null) {
                NewsFeedDefaultsFeedbackModel newsFeedDefaultsFeedbackModel = (NewsFeedDefaultsFeedbackModel) graphQLModelMutatingVisitor.b(m16003p());
                if (m16003p() != newsFeedDefaultsFeedbackModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9377r = newsFeedDefaultsFeedbackModel;
                }
            }
            if (m16004q() != null) {
                DefaultVect2FieldsModel defaultVect2FieldsModel = (DefaultVect2FieldsModel) graphQLModelMutatingVisitor.b(m16004q());
                if (m16004q() != defaultVect2FieldsModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9378s = defaultVect2FieldsModel;
                }
            }
            if (m16005r() != null) {
                GuidedTourModel guidedTourModel = (GuidedTourModel) graphQLModelMutatingVisitor.b(m16005r());
                if (m16005r() != guidedTourModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9379t = guidedTourModel;
                }
            }
            if (m16006s() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16006s());
                if (m16006s() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9385z = defaultImageFieldsModel;
                }
            }
            if (m16007t() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16007t());
                if (m16007t() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9337A = defaultImageFieldsModel;
                }
            }
            if (m16008u() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16008u());
                if (m16008u() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9338B = defaultImageFieldsModel;
                }
            }
            if (m16009v() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16009v());
                if (m16009v() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9339C = defaultImageFieldsModel;
                }
            }
            if (m16010w() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16010w());
                if (m16010w() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9340D = defaultImageFieldsModel;
                }
            }
            if (m16011x() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m16011x());
                if (m16011x() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9341E = defaultImageFieldsModel;
                }
            }
            if (m16012y() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m16012y());
                if (m16012y() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9355S = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            if (m16013z() != null) {
                OwnerModel ownerModel = (OwnerModel) graphQLModelMutatingVisitor.b(m16013z());
                if (m16013z() != ownerModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9356T = ownerModel;
                }
            }
            if (m15983A() != null) {
                PairedVideoModel pairedVideoModel = (PairedVideoModel) graphQLModelMutatingVisitor.b(m15983A());
                if (m15983A() != pairedVideoModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9357U = pairedVideoModel;
                }
            }
            if (m15984B() != null) {
                Builder a = ModelHelper.a(m15984B(), graphQLModelMutatingVisitor);
                if (a != null) {
                    AttachmentMediaModel attachmentMediaModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    attachmentMediaModel.f9358V = a.b();
                    graphQLVisitableModel = attachmentMediaModel;
                }
            }
            if (m15991I() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m15991I());
                if (m15991I() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.af = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m15995M() != null) {
                VideoChannelModel videoChannelModel = (VideoChannelModel) graphQLModelMutatingVisitor.b(m15995M());
                if (m15995M() != videoChannelModel) {
                    graphQLVisitableModel = (AttachmentMediaModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.as = videoChannelModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16014a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16018b());
            int a2 = ModelHelper.a(flatBufferBuilder, m15997j());
            int a3 = ModelHelper.a(flatBufferBuilder, m15998k());
            int b = flatBufferBuilder.b(m15999l());
            int a4 = flatBufferBuilder.a(m16000m());
            int b2 = flatBufferBuilder.b(m16001n());
            int a5 = ModelHelper.a(flatBufferBuilder, m16002o());
            int a6 = ModelHelper.a(flatBufferBuilder, m16003p());
            int a7 = ModelHelper.a(flatBufferBuilder, m16004q());
            int a8 = ModelHelper.a(flatBufferBuilder, m16005r());
            int b3 = flatBufferBuilder.b(m16020d());
            int a9 = ModelHelper.a(flatBufferBuilder, m16006s());
            int a10 = ModelHelper.a(flatBufferBuilder, m16007t());
            int a11 = ModelHelper.a(flatBufferBuilder, m16008u());
            int a12 = ModelHelper.a(flatBufferBuilder, m16009v());
            int a13 = ModelHelper.a(flatBufferBuilder, m16010w());
            int a14 = ModelHelper.a(flatBufferBuilder, m16011x());
            int a15 = ModelHelper.a(flatBufferBuilder, m16012y());
            int a16 = ModelHelper.a(flatBufferBuilder, m16013z());
            int a17 = ModelHelper.a(flatBufferBuilder, m15983A());
            int a18 = ModelHelper.a(flatBufferBuilder, m15984B());
            int b4 = flatBufferBuilder.b(m15985C());
            int b5 = flatBufferBuilder.b(m15986D());
            int b6 = flatBufferBuilder.b(m15987E());
            int b7 = flatBufferBuilder.b(m15988F());
            int b8 = flatBufferBuilder.b(m15989G());
            int b9 = flatBufferBuilder.b(m15990H());
            int a19 = ModelHelper.a(flatBufferBuilder, m15991I());
            int b10 = flatBufferBuilder.b(m15992J());
            int b11 = flatBufferBuilder.b(m15993K());
            int c = flatBufferBuilder.c(m15994L());
            int a20 = ModelHelper.a(flatBufferBuilder, m15995M());
            int a21 = flatBufferBuilder.a(m15996N());
            flatBufferBuilder.c(71);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.a(2, this.f9365f, 0);
            flatBufferBuilder.b(3, a3);
            flatBufferBuilder.b(4, b);
            flatBufferBuilder.a(5, this.f9368i, 0);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.a(7, this.f9370k);
            flatBufferBuilder.a(8, this.f9371l);
            flatBufferBuilder.a(9, this.f9372m);
            flatBufferBuilder.a(10, this.f9373n);
            flatBufferBuilder.b(11, b2);
            flatBufferBuilder.a(12, this.f9375p, 0);
            flatBufferBuilder.b(13, a5);
            flatBufferBuilder.b(14, a6);
            flatBufferBuilder.b(15, a7);
            flatBufferBuilder.b(16, a8);
            flatBufferBuilder.a(17, this.f9380u);
            flatBufferBuilder.a(18, this.f9381v, 0);
            flatBufferBuilder.a(19, this.f9382w, 0);
            flatBufferBuilder.a(20, this.f9383x, 0);
            flatBufferBuilder.b(21, b3);
            flatBufferBuilder.b(22, a9);
            flatBufferBuilder.b(23, a10);
            flatBufferBuilder.b(24, a11);
            flatBufferBuilder.b(25, a12);
            flatBufferBuilder.b(26, a13);
            flatBufferBuilder.b(27, a14);
            flatBufferBuilder.a(28, this.f9342F, 0);
            flatBufferBuilder.a(29, this.f9343G, 0);
            flatBufferBuilder.a(30, this.f9344H, 0);
            flatBufferBuilder.a(31, this.f9345I);
            flatBufferBuilder.a(32, this.f9346J);
            flatBufferBuilder.a(33, this.f9347K);
            flatBufferBuilder.a(34, this.f9348L);
            flatBufferBuilder.a(35, this.f9349M);
            flatBufferBuilder.a(36, this.f9350N);
            flatBufferBuilder.a(37, this.f9351O);
            flatBufferBuilder.a(38, this.f9352P);
            flatBufferBuilder.a(39, this.f9353Q);
            flatBufferBuilder.a(40, this.f9354R, 0);
            flatBufferBuilder.b(41, a15);
            flatBufferBuilder.b(42, a16);
            flatBufferBuilder.b(43, a17);
            flatBufferBuilder.b(44, a18);
            flatBufferBuilder.a(45, this.f9359W, 0);
            flatBufferBuilder.b(46, b4);
            flatBufferBuilder.b(47, b5);
            flatBufferBuilder.a(48, this.f9362Z, 0);
            flatBufferBuilder.b(49, b6);
            flatBufferBuilder.b(50, b7);
            flatBufferBuilder.a(51, this.ac, 0);
            flatBufferBuilder.b(52, b8);
            flatBufferBuilder.b(53, b9);
            flatBufferBuilder.b(54, a19);
            flatBufferBuilder.a(55, this.ag);
            flatBufferBuilder.a(56, this.ah);
            flatBufferBuilder.a(57, this.ai);
            flatBufferBuilder.a(58, this.aj);
            flatBufferBuilder.a(59, this.ak, 0.0d);
            flatBufferBuilder.a(60, this.al, 0.0d);
            flatBufferBuilder.b(61, b10);
            flatBufferBuilder.b(62, b11);
            flatBufferBuilder.a(63, this.ao, 0);
            flatBufferBuilder.a(64, this.ap);
            flatBufferBuilder.a(65, this.aq, 0);
            flatBufferBuilder.b(66, c);
            flatBufferBuilder.b(67, a20);
            flatBufferBuilder.a(68, this.at, 0);
            flatBufferBuilder.b(69, a21);
            flatBufferBuilder.a(70, this.av, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16017a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9365f = mutableFlatBuffer.a(i, 2, 0);
            this.f9368i = mutableFlatBuffer.a(i, 5, 0);
            this.f9370k = mutableFlatBuffer.a(i, 7);
            this.f9371l = mutableFlatBuffer.a(i, 8);
            this.f9372m = mutableFlatBuffer.a(i, 9);
            this.f9373n = mutableFlatBuffer.a(i, 10);
            this.f9375p = mutableFlatBuffer.a(i, 12, 0);
            this.f9380u = mutableFlatBuffer.a(i, 17);
            this.f9381v = mutableFlatBuffer.a(i, 18, 0);
            this.f9382w = mutableFlatBuffer.a(i, 19, 0);
            this.f9383x = mutableFlatBuffer.a(i, 20, 0);
            this.f9342F = mutableFlatBuffer.a(i, 28, 0);
            this.f9343G = mutableFlatBuffer.a(i, 29, 0);
            this.f9344H = mutableFlatBuffer.a(i, 30, 0);
            this.f9345I = mutableFlatBuffer.a(i, 31);
            this.f9346J = mutableFlatBuffer.a(i, 32);
            this.f9347K = mutableFlatBuffer.a(i, 33);
            this.f9348L = mutableFlatBuffer.a(i, 34);
            this.f9349M = mutableFlatBuffer.a(i, 35);
            this.f9350N = mutableFlatBuffer.a(i, 36);
            this.f9351O = mutableFlatBuffer.a(i, 37);
            this.f9352P = mutableFlatBuffer.a(i, 38);
            this.f9353Q = mutableFlatBuffer.a(i, 39);
            this.f9354R = mutableFlatBuffer.a(i, 40, 0);
            this.f9359W = mutableFlatBuffer.a(i, 45, 0);
            this.f9362Z = mutableFlatBuffer.a(i, 48, 0);
            this.ac = mutableFlatBuffer.a(i, 51, 0);
            this.ag = mutableFlatBuffer.a(i, 55);
            this.ah = mutableFlatBuffer.a(i, 56);
            this.ai = mutableFlatBuffer.a(i, 57);
            this.aj = mutableFlatBuffer.a(i, 58);
            this.ak = mutableFlatBuffer.a(i, 59, 0.0d);
            this.al = mutableFlatBuffer.a(i, 60, 0.0d);
            this.ao = mutableFlatBuffer.a(i, 63, 0);
            this.ap = mutableFlatBuffer.a(i, 64);
            this.aq = mutableFlatBuffer.a(i, 65, 0);
            this.at = mutableFlatBuffer.a(i, 68, 0);
            this.av = mutableFlatBuffer.a(i, 70, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 161252437)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: api_success_response */
    public final class Photo360FieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f9401d;
        @Nullable
        private List<PhotoEncodingsModel> f9402e;

        /* compiled from: api_success_response */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(Photo360FieldsModel.class, new Deserializer());
            }

            public Object m16022a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = Photo360FieldsParser.m16074a(jsonParser);
                Object photo360FieldsModel = new Photo360FieldsModel();
                ((BaseModel) photo360FieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (photo360FieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) photo360FieldsModel).a();
                }
                return photo360FieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -188419612)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: api_success_response */
        public final class PhotoEncodingsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f9396d;
            @Nullable
            private String f9397e;
            @Nullable
            private String f9398f;
            @Nullable
            private SphericalMetadataModel f9399g;
            private int f9400h;

            /* compiled from: api_success_response */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PhotoEncodingsModel.class, new Deserializer());
                }

                public Object m16023a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PhotoEncodingsParser.m16072b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object photoEncodingsModel = new PhotoEncodingsModel();
                    ((BaseModel) photoEncodingsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (photoEncodingsModel instanceof Postprocessable) {
                        return ((Postprocessable) photoEncodingsModel).a();
                    }
                    return photoEncodingsModel;
                }
            }

            /* compiled from: api_success_response */
            public class Serializer extends JsonSerializer<PhotoEncodingsModel> {
                public final void m16024a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PhotoEncodingsModel photoEncodingsModel = (PhotoEncodingsModel) obj;
                    if (photoEncodingsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(photoEncodingsModel.m16034a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        photoEncodingsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PhotoEncodingsParser.m16073b(photoEncodingsModel.w_(), photoEncodingsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PhotoEncodingsModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -2000344070)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: api_success_response */
            public final class SphericalMetadataModel extends BaseModel implements GraphQLVisitableModel {
                private int f9386d;
                private int f9387e;
                private int f9388f;
                private int f9389g;
                private int f9390h;
                private int f9391i;
                private double f9392j;
                private double f9393k;
                private double f9394l;
                private double f9395m;

                /* compiled from: api_success_response */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SphericalMetadataModel.class, new Deserializer());
                    }

                    public Object m16025a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SphericalMetadataParser.m16068a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object sphericalMetadataModel = new SphericalMetadataModel();
                        ((BaseModel) sphericalMetadataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (sphericalMetadataModel instanceof Postprocessable) {
                            return ((Postprocessable) sphericalMetadataModel).a();
                        }
                        return sphericalMetadataModel;
                    }
                }

                /* compiled from: api_success_response */
                public class Serializer extends JsonSerializer<SphericalMetadataModel> {
                    public final void m16026a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SphericalMetadataModel sphericalMetadataModel = (SphericalMetadataModel) obj;
                        if (sphericalMetadataModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(sphericalMetadataModel.m16027a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            sphericalMetadataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SphericalMetadataParser.m16069a(sphericalMetadataModel.w_(), sphericalMetadataModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SphericalMetadataModel.class, new Serializer());
                    }
                }

                public SphericalMetadataModel() {
                    super(10);
                }

                public final int jK_() {
                    return 628846766;
                }

                public final GraphQLVisitableModel m16028a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16027a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(10);
                    flatBufferBuilder.a(0, this.f9386d, 0);
                    flatBufferBuilder.a(1, this.f9387e, 0);
                    flatBufferBuilder.a(2, this.f9388f, 0);
                    flatBufferBuilder.a(3, this.f9389g, 0);
                    flatBufferBuilder.a(4, this.f9390h, 0);
                    flatBufferBuilder.a(5, this.f9391i, 0);
                    flatBufferBuilder.a(6, this.f9392j, 0.0d);
                    flatBufferBuilder.a(7, this.f9393k, 0.0d);
                    flatBufferBuilder.a(8, this.f9394l, 0.0d);
                    flatBufferBuilder.a(9, this.f9395m, 0.0d);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m16029a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f9386d = mutableFlatBuffer.a(i, 0, 0);
                    this.f9387e = mutableFlatBuffer.a(i, 1, 0);
                    this.f9388f = mutableFlatBuffer.a(i, 2, 0);
                    this.f9389g = mutableFlatBuffer.a(i, 3, 0);
                    this.f9390h = mutableFlatBuffer.a(i, 4, 0);
                    this.f9391i = mutableFlatBuffer.a(i, 5, 0);
                    this.f9392j = mutableFlatBuffer.a(i, 6, 0.0d);
                    this.f9393k = mutableFlatBuffer.a(i, 7, 0.0d);
                    this.f9394l = mutableFlatBuffer.a(i, 8, 0.0d);
                    this.f9395m = mutableFlatBuffer.a(i, 9, 0.0d);
                }
            }

            public PhotoEncodingsModel() {
                super(5);
            }

            @Nullable
            private String m16030j() {
                this.f9396d = super.a(this.f9396d, 0);
                return this.f9396d;
            }

            @Nullable
            private String m16031k() {
                this.f9397e = super.a(this.f9397e, 1);
                return this.f9397e;
            }

            @Nullable
            private String m16032l() {
                this.f9398f = super.a(this.f9398f, 2);
                return this.f9398f;
            }

            @Nullable
            private SphericalMetadataModel m16033m() {
                this.f9399g = (SphericalMetadataModel) super.a(this.f9399g, 3, SphericalMetadataModel.class);
                return this.f9399g;
            }

            @Nullable
            public final String m16036a() {
                return m16031k();
            }

            public final int jK_() {
                return -1659654779;
            }

            public final GraphQLVisitableModel m16035a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16033m() != null) {
                    SphericalMetadataModel sphericalMetadataModel = (SphericalMetadataModel) graphQLModelMutatingVisitor.b(m16033m());
                    if (m16033m() != sphericalMetadataModel) {
                        graphQLVisitableModel = (PhotoEncodingsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9399g = sphericalMetadataModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16034a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16030j());
                int b2 = flatBufferBuilder.b(m16031k());
                int b3 = flatBufferBuilder.b(m16032l());
                int a = ModelHelper.a(flatBufferBuilder, m16033m());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, b2);
                flatBufferBuilder.b(2, b3);
                flatBufferBuilder.b(3, a);
                flatBufferBuilder.a(4, this.f9400h, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16037a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9400h = mutableFlatBuffer.a(i, 4, 0);
            }
        }

        /* compiled from: api_success_response */
        public class Serializer extends JsonSerializer<Photo360FieldsModel> {
            public final void m16038a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                Photo360FieldsModel photo360FieldsModel = (Photo360FieldsModel) obj;
                if (photo360FieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(photo360FieldsModel.m16041a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    photo360FieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = photo360FieldsModel.w_();
                int u_ = photo360FieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("photo_encodings");
                    PhotoEncodingsParser.m16071a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(Photo360FieldsModel.class, new Serializer());
            }
        }

        public Photo360FieldsModel() {
            super(2);
        }

        @Nullable
        private String m16039j() {
            this.f9401d = super.a(this.f9401d, 0);
            return this.f9401d;
        }

        @Nonnull
        private ImmutableList<PhotoEncodingsModel> m16040k() {
            this.f9402e = super.a(this.f9402e, 1, PhotoEncodingsModel.class);
            return (ImmutableList) this.f9402e;
        }

        @Nullable
        public final String m16043a() {
            return m16039j();
        }

        public final int jK_() {
            return 77090322;
        }

        public final GraphQLVisitableModel m16042a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16040k() != null) {
                Builder a = ModelHelper.a(m16040k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (Photo360FieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9402e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16041a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16039j());
            int a = ModelHelper.a(flatBufferBuilder, m16040k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

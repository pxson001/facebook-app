package com.facebook.messaging.graphql.threads;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.graphql.threads.GenieMessageQueriesParsers.GenieMessageFragmentParser;
import com.facebook.messaging.graphql.threads.GenieMessageQueriesParsers.GenieMessageFragmentParser.GenieSenderParser;
import com.facebook.messaging.graphql.threads.GenieMessageQueriesParsers.GenieMessageFragmentParser.GenieSenderParser.MessagingActorParser;
import com.facebook.messaging.graphql.threads.GenieMessageQueriesParsers.GenieMessageFragmentParser.GenieSenderParser.MessagingActorParser.ProfilePhotoParser;
import com.facebook.messaging.graphql.threads.GenieMessageQueriesParsers.GenieMessageFragmentParser.GenieSenderParser.MessagingActorParser.ProfilePhotoParser.ImageParser;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: video_channel_unsubscribe */
public class GenieMessageQueriesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 987008162)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: video_channel_unsubscribe */
    public final class GenieMessageFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GenieSenderModel f1014d;
        @Nullable
        private XMAAttachmentStoryFieldsModel f1015e;

        /* compiled from: video_channel_unsubscribe */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GenieMessageFragmentModel.class, new Deserializer());
            }

            public Object m1271a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(GenieMessageFragmentParser.m1316a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object genieMessageFragmentModel = new GenieMessageFragmentModel();
                ((BaseModel) genieMessageFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (genieMessageFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) genieMessageFragmentModel).a();
                }
                return genieMessageFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1969229262)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: video_channel_unsubscribe */
        public final class GenieSenderModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private MessagingActorModel f1013d;

            /* compiled from: video_channel_unsubscribe */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(GenieSenderModel.class, new Deserializer());
                }

                public Object m1272a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(GenieSenderParser.m1314a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object genieSenderModel = new GenieSenderModel();
                    ((BaseModel) genieSenderModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (genieSenderModel instanceof Postprocessable) {
                        return ((Postprocessable) genieSenderModel).a();
                    }
                    return genieSenderModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1943790838)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: video_channel_unsubscribe */
            public final class MessagingActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f1009d;
                @Nullable
                private String f1010e;
                @Nullable
                private String f1011f;
                @Nullable
                private ProfilePhotoModel f1012g;

                /* compiled from: video_channel_unsubscribe */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MessagingActorModel.class, new Deserializer());
                    }

                    public Object m1273a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MessagingActorParser.m1312a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object messagingActorModel = new MessagingActorModel();
                        ((BaseModel) messagingActorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (messagingActorModel instanceof Postprocessable) {
                            return ((Postprocessable) messagingActorModel).a();
                        }
                        return messagingActorModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 1733618269)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: video_channel_unsubscribe */
                public final class ProfilePhotoModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private ImageModel f1008d;

                    /* compiled from: video_channel_unsubscribe */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ProfilePhotoModel.class, new Deserializer());
                        }

                        public Object m1274a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ProfilePhotoParser.m1310a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object profilePhotoModel = new ProfilePhotoModel();
                            ((BaseModel) profilePhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (profilePhotoModel instanceof Postprocessable) {
                                return ((Postprocessable) profilePhotoModel).a();
                            }
                            return profilePhotoModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -439669600)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: video_channel_unsubscribe */
                    public final class ImageModel extends BaseModel implements GraphQLVisitableModel {
                        @Nullable
                        private String f1006d;
                        private int f1007e;

                        /* compiled from: video_channel_unsubscribe */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(ImageModel.class, new Deserializer());
                            }

                            public Object m1275a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(ImageParser.m1308a(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object imageModel = new ImageModel();
                                ((BaseModel) imageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (imageModel instanceof Postprocessable) {
                                    return ((Postprocessable) imageModel).a();
                                }
                                return imageModel;
                            }
                        }

                        /* compiled from: video_channel_unsubscribe */
                        public class Serializer extends JsonSerializer<ImageModel> {
                            public final void m1276a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                ImageModel imageModel = (ImageModel) obj;
                                if (imageModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(imageModel.m1277a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    imageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                ImageParser.m1309a(imageModel.w_(), imageModel.u_(), jsonGenerator);
                            }

                            static {
                                FbSerializerProvider.a(ImageModel.class, new Serializer());
                            }
                        }

                        public ImageModel() {
                            super(2);
                        }

                        @Nullable
                        public final String m1279a() {
                            this.f1006d = super.a(this.f1006d, 0);
                            return this.f1006d;
                        }

                        public final int m1281b() {
                            a(0, 1);
                            return this.f1007e;
                        }

                        public final int jK_() {
                            return 70760763;
                        }

                        public final GraphQLVisitableModel m1278a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            h();
                            i();
                            return this;
                        }

                        public final int m1277a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int b = flatBufferBuilder.b(m1279a());
                            flatBufferBuilder.c(2);
                            flatBufferBuilder.b(0, b);
                            flatBufferBuilder.a(1, this.f1007e, 0);
                            i();
                            return flatBufferBuilder.d();
                        }

                        public final void m1280a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                            super.a(mutableFlatBuffer, i, obj);
                            this.f1007e = mutableFlatBuffer.a(i, 1, 0);
                        }
                    }

                    /* compiled from: video_channel_unsubscribe */
                    public class Serializer extends JsonSerializer<ProfilePhotoModel> {
                        public final void m1282a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ProfilePhotoModel profilePhotoModel = (ProfilePhotoModel) obj;
                            if (profilePhotoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(profilePhotoModel.m1284a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                profilePhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ProfilePhotoParser.m1311a(profilePhotoModel.w_(), profilePhotoModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(ProfilePhotoModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ ImageModel m1286a() {
                        return m1283j();
                    }

                    public ProfilePhotoModel() {
                        super(1);
                    }

                    @Nullable
                    private ImageModel m1283j() {
                        this.f1008d = (ImageModel) super.a(this.f1008d, 0, ImageModel.class);
                        return this.f1008d;
                    }

                    public final int jK_() {
                        return 77090322;
                    }

                    public final GraphQLVisitableModel m1285a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m1283j() != null) {
                            ImageModel imageModel = (ImageModel) graphQLModelMutatingVisitor.b(m1283j());
                            if (m1283j() != imageModel) {
                                graphQLVisitableModel = (ProfilePhotoModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f1008d = imageModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m1284a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m1283j());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: video_channel_unsubscribe */
                public class Serializer extends JsonSerializer<MessagingActorModel> {
                    public final void m1287a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MessagingActorModel messagingActorModel = (MessagingActorModel) obj;
                        if (messagingActorModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(messagingActorModel.m1290a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            messagingActorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MessagingActorParser.m1313a(messagingActorModel.w_(), messagingActorModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(MessagingActorModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ProfilePhotoModel m1295d() {
                    return m1289k();
                }

                public MessagingActorModel() {
                    super(4);
                }

                @Nullable
                private GraphQLObjectType m1288j() {
                    if (this.b != null && this.f1009d == null) {
                        this.f1009d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f1009d;
                }

                @Nullable
                public final String m1293b() {
                    this.f1010e = super.a(this.f1010e, 1);
                    return this.f1010e;
                }

                @Nullable
                public final String m1294c() {
                    this.f1011f = super.a(this.f1011f, 2);
                    return this.f1011f;
                }

                @Nullable
                private ProfilePhotoModel m1289k() {
                    this.f1012g = (ProfilePhotoModel) super.a(this.f1012g, 3, ProfilePhotoModel.class);
                    return this.f1012g;
                }

                @Nullable
                public final String m1292a() {
                    return m1293b();
                }

                public final int jK_() {
                    return -1575218831;
                }

                public final GraphQLVisitableModel m1291a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m1289k() != null) {
                        ProfilePhotoModel profilePhotoModel = (ProfilePhotoModel) graphQLModelMutatingVisitor.b(m1289k());
                        if (m1289k() != profilePhotoModel) {
                            graphQLVisitableModel = (MessagingActorModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f1012g = profilePhotoModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m1290a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m1288j());
                    int b = flatBufferBuilder.b(m1293b());
                    int b2 = flatBufferBuilder.b(m1294c());
                    int a2 = ModelHelper.a(flatBufferBuilder, m1289k());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: video_channel_unsubscribe */
            public class Serializer extends JsonSerializer<GenieSenderModel> {
                public final void m1296a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    GenieSenderModel genieSenderModel = (GenieSenderModel) obj;
                    if (genieSenderModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(genieSenderModel.m1298a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        genieSenderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    GenieSenderParser.m1315a(genieSenderModel.w_(), genieSenderModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(GenieSenderModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ MessagingActorModel m1300a() {
                return m1297j();
            }

            public GenieSenderModel() {
                super(1);
            }

            @Nullable
            private MessagingActorModel m1297j() {
                this.f1013d = (MessagingActorModel) super.a(this.f1013d, 0, MessagingActorModel.class);
                return this.f1013d;
            }

            public final int jK_() {
                return -1020278353;
            }

            public final GraphQLVisitableModel m1299a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m1297j() != null) {
                    MessagingActorModel messagingActorModel = (MessagingActorModel) graphQLModelMutatingVisitor.b(m1297j());
                    if (m1297j() != messagingActorModel) {
                        graphQLVisitableModel = (GenieSenderModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f1013d = messagingActorModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m1298a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m1297j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: video_channel_unsubscribe */
        public class Serializer extends JsonSerializer<GenieMessageFragmentModel> {
            public final void m1301a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                GenieMessageFragmentModel genieMessageFragmentModel = (GenieMessageFragmentModel) obj;
                if (genieMessageFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(genieMessageFragmentModel.m1304a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    genieMessageFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                GenieMessageFragmentParser.m1317a(genieMessageFragmentModel.w_(), genieMessageFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(GenieMessageFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ GenieSenderModel m1306a() {
            return m1302j();
        }

        @Nullable
        public final /* synthetic */ XMAAttachmentStoryFieldsModel m1307b() {
            return m1303k();
        }

        public GenieMessageFragmentModel() {
            super(2);
        }

        @Nullable
        private GenieSenderModel m1302j() {
            this.f1014d = (GenieSenderModel) super.a(this.f1014d, 0, GenieSenderModel.class);
            return this.f1014d;
        }

        @Nullable
        private XMAAttachmentStoryFieldsModel m1303k() {
            this.f1015e = (XMAAttachmentStoryFieldsModel) super.a(this.f1015e, 1, XMAAttachmentStoryFieldsModel.class);
            return this.f1015e;
        }

        public final int jK_() {
            return 1075434011;
        }

        public final GraphQLVisitableModel m1305a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m1302j() != null) {
                GenieSenderModel genieSenderModel = (GenieSenderModel) graphQLModelMutatingVisitor.b(m1302j());
                if (m1302j() != genieSenderModel) {
                    graphQLVisitableModel = (GenieMessageFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f1014d = genieSenderModel;
                }
            }
            if (m1303k() != null) {
                XMAAttachmentStoryFieldsModel xMAAttachmentStoryFieldsModel = (XMAAttachmentStoryFieldsModel) graphQLModelMutatingVisitor.b(m1303k());
                if (m1303k() != xMAAttachmentStoryFieldsModel) {
                    graphQLVisitableModel = (GenieMessageFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f1015e = xMAAttachmentStoryFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m1304a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1302j());
            int a2 = ModelHelper.a(flatBufferBuilder, m1303k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}

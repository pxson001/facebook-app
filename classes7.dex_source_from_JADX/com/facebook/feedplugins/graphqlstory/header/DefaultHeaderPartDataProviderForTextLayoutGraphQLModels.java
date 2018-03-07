package com.facebook.feedplugins.graphqlstory.header;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLInterfaces.GetNativeAppDetailsActorGraphQL.ProfilePicture;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLInterfaces.GetNativeAppDetailsFromActorGraphQL;
import com.facebook.directinstall.util.DirectInstallApplicationUtilsGraphQLModels.GetNativeAppDetailsAppStoreApplicationGraphQLModel;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayoutGraphQLParsers.DispatchAvatarClickGraphQLParser;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayoutGraphQLParsers.DispatchAvatarClickGraphQLParser.ActorsParser;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayoutGraphQLParsers.DispatchAvatarClickGraphQLParser.ActorsParser.ProfilePictureParser;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayoutGraphQLParsers.DispatchAvatarClickGraphQLParser.AttachmentsParser;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayoutGraphQLParsers.DispatchAvatarClickGraphQLParser.AttachmentsParser.ActionLinksParser;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayoutGraphQLParsers.DispatchAvatarClickGraphQLParser.AttachmentsParser.ActionLinksParser.LinkTargetStoreDataParser;
import com.facebook.feedplugins.graphqlstory.header.DefaultHeaderPartDataProviderForTextLayoutGraphQLParsers.DispatchAvatarClickGraphQLParser.AttachmentsParser.TargetParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLFriendshipStatus;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.intent.ModelBundleGraphQLInterfaces.ModelBundleProfileGraphQL;
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

/* compiled from: report_sent */
public class DefaultHeaderPartDataProviderForTextLayoutGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -404898342)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: report_sent */
    public final class DispatchAvatarClickGraphQLModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private List<ActorsModel> f5265d;
        @Nullable
        private List<AttachmentsModel> f5266e;
        @Nullable
        private String f5267f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1533282848)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: report_sent */
        public final class ActorsModel extends BaseModel implements GetNativeAppDetailsFromActorGraphQL, GraphQLPersistableNode, GraphQLVisitableConsistentModel, ModelBundleProfileGraphQL {
            @Nullable
            private GraphQLObjectType f5250d;
            @Nullable
            private GetNativeAppDetailsAppStoreApplicationGraphQLModel f5251e;
            @Nullable
            private GraphQLFriendshipStatus f5252f;
            @Nullable
            private String f5253g;
            @Nullable
            private String f5254h;
            @Nullable
            private ProfilePictureModel f5255i;
            @Nullable
            private String f5256j;

            /* compiled from: report_sent */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ActorsModel.class, new Deserializer());
                }

                public Object m5684a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ActorsParser.m5749b(jsonParser, flatBufferBuilder));
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

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 729935302)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: report_sent */
            public final class ProfilePictureModel extends BaseModel implements ProfilePicture, DefaultImageFields, GraphQLVisitableModel {
                private int f5247d;
                @Nullable
                private String f5248e;
                private int f5249f;

                /* compiled from: report_sent */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ProfilePictureModel.class, new Deserializer());
                    }

                    public Object m5685a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ProfilePictureParser.m5747a(jsonParser, flatBufferBuilder));
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

                /* compiled from: report_sent */
                public class Serializer extends JsonSerializer<ProfilePictureModel> {
                    public final void m5686a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ProfilePictureModel profilePictureModel = (ProfilePictureModel) obj;
                        if (profilePictureModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(profilePictureModel.m5688a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            profilePictureModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ProfilePictureParser.m5748a(profilePictureModel.w_(), profilePictureModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ProfilePictureModel.class, new Serializer());
                    }
                }

                public ProfilePictureModel() {
                    super(3);
                }

                public final int m5687a() {
                    a(0, 0);
                    return this.f5247d;
                }

                @Nullable
                public final String m5691b() {
                    this.f5248e = super.a(this.f5248e, 1);
                    return this.f5248e;
                }

                public final int m5692c() {
                    a(0, 2);
                    return this.f5249f;
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m5689a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m5688a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m5691b());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.a(0, this.f5247d, 0);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.a(2, this.f5249f, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m5690a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f5247d = mutableFlatBuffer.a(i, 0, 0);
                    this.f5249f = mutableFlatBuffer.a(i, 2, 0);
                }
            }

            /* compiled from: report_sent */
            public class Serializer extends JsonSerializer<ActorsModel> {
                public final void m5693a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ActorsModel actorsModel = (ActorsModel) obj;
                    if (actorsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(actorsModel.m5697a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        actorsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ActorsParser.m5750b(actorsModel.w_(), actorsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ActorsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields dB_() {
                return m5696k();
            }

            @Nullable
            public final /* synthetic */ ProfilePicture m5706l() {
                return m5696k();
            }

            @Nullable
            public final /* synthetic */ GetNativeAppDetailsAppStoreApplicationGraphQLModel m5707m() {
                return m5695j();
            }

            public ActorsModel() {
                super(7);
            }

            public final void m5700a(String str, ConsistencyTuple consistencyTuple) {
                if ("friendship_status".equals(str)) {
                    consistencyTuple.a = m5704d();
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 2;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m5701a(String str, Object obj, boolean z) {
                if ("friendship_status".equals(str)) {
                    m5694a((GraphQLFriendshipStatus) obj);
                }
            }

            @Nullable
            public final GraphQLObjectType m5703c() {
                if (this.b != null && this.f5250d == null) {
                    this.f5250d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f5250d;
            }

            @Nullable
            private GetNativeAppDetailsAppStoreApplicationGraphQLModel m5695j() {
                this.f5251e = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) super.a(this.f5251e, 1, GetNativeAppDetailsAppStoreApplicationGraphQLModel.class);
                return this.f5251e;
            }

            @Nullable
            public final GraphQLFriendshipStatus m5704d() {
                this.f5252f = (GraphQLFriendshipStatus) super.b(this.f5252f, 2, GraphQLFriendshipStatus.class, GraphQLFriendshipStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f5252f;
            }

            private void m5694a(GraphQLFriendshipStatus graphQLFriendshipStatus) {
                this.f5252f = graphQLFriendshipStatus;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 2, graphQLFriendshipStatus != null ? graphQLFriendshipStatus.name() : null);
                }
            }

            @Nullable
            public final String m5705g() {
                this.f5253g = super.a(this.f5253g, 3);
                return this.f5253g;
            }

            @Nullable
            public final String C_() {
                this.f5254h = super.a(this.f5254h, 4);
                return this.f5254h;
            }

            @Nullable
            private ProfilePictureModel m5696k() {
                this.f5255i = (ProfilePictureModel) super.a(this.f5255i, 5, ProfilePictureModel.class);
                return this.f5255i;
            }

            @Nullable
            public final String m5702b() {
                this.f5256j = super.a(this.f5256j, 6);
                return this.f5256j;
            }

            @Nullable
            public final String m5699a() {
                return m5705g();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m5698a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m5695j() != null) {
                    GetNativeAppDetailsAppStoreApplicationGraphQLModel getNativeAppDetailsAppStoreApplicationGraphQLModel = (GetNativeAppDetailsAppStoreApplicationGraphQLModel) graphQLModelMutatingVisitor.b(m5695j());
                    if (m5695j() != getNativeAppDetailsAppStoreApplicationGraphQLModel) {
                        graphQLVisitableModel = (ActorsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f5251e = getNativeAppDetailsAppStoreApplicationGraphQLModel;
                    }
                }
                if (m5696k() != null) {
                    ProfilePictureModel profilePictureModel = (ProfilePictureModel) graphQLModelMutatingVisitor.b(m5696k());
                    if (m5696k() != profilePictureModel) {
                        graphQLVisitableModel = (ActorsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5255i = profilePictureModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m5697a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5703c());
                int a2 = ModelHelper.a(flatBufferBuilder, m5695j());
                int a3 = flatBufferBuilder.a(m5704d());
                int b = flatBufferBuilder.b(m5705g());
                int b2 = flatBufferBuilder.b(C_());
                int a4 = ModelHelper.a(flatBufferBuilder, m5696k());
                int b3 = flatBufferBuilder.b(m5702b());
                flatBufferBuilder.c(7);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, b3);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1626061031)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: report_sent */
        public final class AttachmentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ActionLinksModel> f5262d;
            @Nullable
            private List<GraphQLStoryAttachmentStyle> f5263e;
            @Nullable
            private TargetModel f5264f;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 286668711)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: report_sent */
            public final class ActionLinksModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f5258d;
                @Nullable
                private LinkTargetStoreDataModel f5259e;

                /* compiled from: report_sent */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActionLinksModel.class, new Deserializer());
                    }

                    public Object m5708a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ActionLinksParser.m5753b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object actionLinksModel = new ActionLinksModel();
                        ((BaseModel) actionLinksModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (actionLinksModel instanceof Postprocessable) {
                            return ((Postprocessable) actionLinksModel).a();
                        }
                        return actionLinksModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1285339209)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: report_sent */
                public final class LinkTargetStoreDataModel extends BaseModel implements GraphQLVisitableModel {
                    private boolean f5257d;

                    /* compiled from: report_sent */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(LinkTargetStoreDataModel.class, new Deserializer());
                        }

                        public Object m5709a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(LinkTargetStoreDataParser.m5751a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object linkTargetStoreDataModel = new LinkTargetStoreDataModel();
                            ((BaseModel) linkTargetStoreDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (linkTargetStoreDataModel instanceof Postprocessable) {
                                return ((Postprocessable) linkTargetStoreDataModel).a();
                            }
                            return linkTargetStoreDataModel;
                        }
                    }

                    /* compiled from: report_sent */
                    public class Serializer extends JsonSerializer<LinkTargetStoreDataModel> {
                        public final void m5710a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            LinkTargetStoreDataModel linkTargetStoreDataModel = (LinkTargetStoreDataModel) obj;
                            if (linkTargetStoreDataModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(linkTargetStoreDataModel.m5711a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                linkTargetStoreDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            LinkTargetStoreDataParser.m5752a(linkTargetStoreDataModel.w_(), linkTargetStoreDataModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(LinkTargetStoreDataModel.class, new Serializer());
                        }
                    }

                    public LinkTargetStoreDataModel() {
                        super(1);
                    }

                    public final boolean m5714a() {
                        a(0, 0);
                        return this.f5257d;
                    }

                    public final int jK_() {
                        return 1258324512;
                    }

                    public final GraphQLVisitableModel m5712a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m5711a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.a(0, this.f5257d);
                        i();
                        return flatBufferBuilder.d();
                    }

                    public final void m5713a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                        super.a(mutableFlatBuffer, i, obj);
                        this.f5257d = mutableFlatBuffer.a(i, 0);
                    }
                }

                /* compiled from: report_sent */
                public class Serializer extends JsonSerializer<ActionLinksModel> {
                    public final void m5715a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActionLinksModel actionLinksModel = (ActionLinksModel) obj;
                        if (actionLinksModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(actionLinksModel.m5717a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            actionLinksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ActionLinksParser.m5754b(actionLinksModel.w_(), actionLinksModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(ActionLinksModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ LinkTargetStoreDataModel m5720b() {
                    return m5716j();
                }

                public ActionLinksModel() {
                    super(2);
                }

                @Nullable
                public final GraphQLObjectType m5718a() {
                    if (this.b != null && this.f5258d == null) {
                        this.f5258d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f5258d;
                }

                @Nullable
                private LinkTargetStoreDataModel m5716j() {
                    this.f5259e = (LinkTargetStoreDataModel) super.a(this.f5259e, 1, LinkTargetStoreDataModel.class);
                    return this.f5259e;
                }

                public final int jK_() {
                    return -1747569147;
                }

                public final GraphQLVisitableModel m5719a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m5716j() != null) {
                        LinkTargetStoreDataModel linkTargetStoreDataModel = (LinkTargetStoreDataModel) graphQLModelMutatingVisitor.b(m5716j());
                        if (m5716j() != linkTargetStoreDataModel) {
                            graphQLVisitableModel = (ActionLinksModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f5259e = linkTargetStoreDataModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m5717a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5718a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m5716j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: report_sent */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttachmentsModel.class, new Deserializer());
                }

                public Object m5721a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttachmentsParser.m5758b(jsonParser, flatBufferBuilder));
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

            /* compiled from: report_sent */
            public class Serializer extends JsonSerializer<AttachmentsModel> {
                public final void m5722a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttachmentsModel attachmentsModel = (AttachmentsModel) obj;
                    if (attachmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attachmentsModel.m5733a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttachmentsParser.m5759b(attachmentsModel.w_(), attachmentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AttachmentsModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: report_sent */
            public final class TargetModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f5260d;
                @Nullable
                private String f5261e;

                /* compiled from: report_sent */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TargetModel.class, new Deserializer());
                    }

                    public Object m5723a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TargetParser.m5755a(jsonParser, flatBufferBuilder));
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

                /* compiled from: report_sent */
                public class Serializer extends JsonSerializer<TargetModel> {
                    public final void m5724a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TargetModel targetModel = (TargetModel) obj;
                        if (targetModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(targetModel.m5726a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            targetModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TargetParser.m5756a(targetModel.w_(), targetModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TargetModel.class, new Serializer());
                    }
                }

                public TargetModel() {
                    super(2);
                }

                public final void m5729a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m5730a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m5725j() {
                    if (this.b != null && this.f5260d == null) {
                        this.f5260d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f5260d;
                }

                @Nullable
                public final String m5731b() {
                    this.f5261e = super.a(this.f5261e, 1);
                    return this.f5261e;
                }

                @Nullable
                public final String m5728a() {
                    return m5731b();
                }

                public final int jK_() {
                    return 2433570;
                }

                public final GraphQLVisitableModel m5727a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m5726a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m5725j());
                    int b = flatBufferBuilder.b(m5731b());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ TargetModel m5737c() {
                return m5732j();
            }

            public AttachmentsModel() {
                super(3);
            }

            @Nonnull
            public final ImmutableList<ActionLinksModel> m5735a() {
                this.f5262d = super.a(this.f5262d, 0, ActionLinksModel.class);
                return (ImmutableList) this.f5262d;
            }

            @Nonnull
            public final ImmutableList<GraphQLStoryAttachmentStyle> m5736b() {
                this.f5263e = super.c(this.f5263e, 1, GraphQLStoryAttachmentStyle.class);
                return (ImmutableList) this.f5263e;
            }

            @Nullable
            private TargetModel m5732j() {
                this.f5264f = (TargetModel) super.a(this.f5264f, 2, TargetModel.class);
                return this.f5264f;
            }

            public final int jK_() {
                return -1267730472;
            }

            public final GraphQLVisitableModel m5734a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                TargetModel targetModel;
                h();
                if (m5735a() != null) {
                    Builder a = ModelHelper.a(m5735a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        AttachmentsModel attachmentsModel = (AttachmentsModel) ModelHelper.a(null, this);
                        attachmentsModel.f5262d = a.b();
                        graphQLVisitableModel = attachmentsModel;
                        if (m5732j() != null) {
                            targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m5732j());
                            if (m5732j() != targetModel) {
                                graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f5264f = targetModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m5732j() != null) {
                    targetModel = (TargetModel) graphQLModelMutatingVisitor.b(m5732j());
                    if (m5732j() != targetModel) {
                        graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f5264f = targetModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m5733a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m5735a());
                int d = flatBufferBuilder.d(m5736b());
                int a2 = ModelHelper.a(flatBufferBuilder, m5732j());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, d);
                flatBufferBuilder.b(2, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: report_sent */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(DispatchAvatarClickGraphQLModel.class, new Deserializer());
            }

            public Object m5738a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(DispatchAvatarClickGraphQLParser.m5760a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object dispatchAvatarClickGraphQLModel = new DispatchAvatarClickGraphQLModel();
                ((BaseModel) dispatchAvatarClickGraphQLModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (dispatchAvatarClickGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) dispatchAvatarClickGraphQLModel).a();
                }
                return dispatchAvatarClickGraphQLModel;
            }
        }

        /* compiled from: report_sent */
        public class Serializer extends JsonSerializer<DispatchAvatarClickGraphQLModel> {
            public final void m5739a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                int i;
                DispatchAvatarClickGraphQLModel dispatchAvatarClickGraphQLModel = (DispatchAvatarClickGraphQLModel) obj;
                if (dispatchAvatarClickGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(dispatchAvatarClickGraphQLModel.m5740a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    dispatchAvatarClickGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = dispatchAvatarClickGraphQLModel.w_();
                int u_ = dispatchAvatarClickGraphQLModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("actors");
                    jsonGenerator.d();
                    for (i = 0; i < mutableFlatBuffer.c(g); i++) {
                        ActorsParser.m5750b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("attachments");
                    jsonGenerator.d();
                    for (i = 0; i < mutableFlatBuffer.c(g); i++) {
                        AttachmentsParser.m5759b(mutableFlatBuffer, mutableFlatBuffer.m(g, i), jsonGenerator, serializerProvider);
                    }
                    jsonGenerator.e();
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("cache_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(DispatchAvatarClickGraphQLModel.class, new Serializer());
            }
        }

        public DispatchAvatarClickGraphQLModel() {
            super(3);
        }

        public DispatchAvatarClickGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m5743a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m5744a(String str, Object obj, boolean z) {
        }

        @Nonnull
        public final ImmutableList<ActorsModel> m5742a() {
            this.f5265d = super.a(this.f5265d, 0, ActorsModel.class);
            return (ImmutableList) this.f5265d;
        }

        @Nonnull
        public final ImmutableList<AttachmentsModel> m5745b() {
            this.f5266e = super.a(this.f5266e, 1, AttachmentsModel.class);
            return (ImmutableList) this.f5266e;
        }

        @Nullable
        public final String m5746c() {
            this.f5267f = super.a(this.f5267f, 2);
            return this.f5267f;
        }

        public final int jK_() {
            return 80218325;
        }

        public final GraphQLVisitableModel m5741a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m5742a() != null) {
                a = ModelHelper.a(m5742a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (DispatchAvatarClickGraphQLModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f5265d = a.b();
                }
            }
            if (m5745b() != null) {
                a = ModelHelper.a(m5745b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (DispatchAvatarClickGraphQLModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f5266e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m5740a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m5742a());
            int a2 = ModelHelper.a(flatBufferBuilder, m5745b());
            int b = flatBufferBuilder.b(m5746c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}

package com.facebook.appdiscovery.lite.protocol;

import com.facebook.api.graphql.textwithentities.NewsFeedApplicationGraphQLModels.AppStoreApplicationFragmentModel;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLModels.ActorFacePileFragmentModel;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLModels.AppStoreAppFragmentModel;
import com.facebook.appdiscovery.lite.protocol.AppFragmentsGraphQLParsers.ActorFacePileFragmentParser;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLInterfaces.AppStoryQueryFragment;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLParsers.AppDiscoveryLiteQueryFragmentParser;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLParsers.AppDiscoveryLiteQueryFragmentParser.AppDiscoveryLiteParser;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLParsers.AppSectionQueryFragmentParser;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLParsers.AppSectionQueryFragmentParser.AppSectionUnitsParser;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLParsers.AppSectionQueryFragmentParser.AppSectionUnitsParser.NodesParser;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLParsers.AppStoryQueryFragmentParser;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLParsers.AppStoryQueryFragmentParser.AttachmentsParser;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLParsers.AppStoryQueryFragmentParser.AttachmentsParser.ActionLinksParser;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLParsers.AppStoryQueryFragmentParser.AttachmentsParser.DescriptionParser;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLParsers.AppStoryQueryFragmentParser.MessageParser;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLParsers.FBGenericAttachmentMediaQueryFragmentParser;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLParsers.FBGenericAttachmentMediaQueryFragmentParser.AnimatedImageParser;
import com.facebook.appdiscovery.lite.protocol.FetchLiteResultsGraphQLParsers.FetchLiteResultsQueryParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.graphql.enums.GraphQLMoreAppsUnitRenderStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStoryActionLinkDestinationType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
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

/* compiled from: sendError.errorMessage */
public class FetchLiteResultsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1394163932)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sendError.errorMessage */
    public final class AppDiscoveryLiteQueryFragmentModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private AppDiscoveryLiteModel f4080d;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1779198727)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sendError.errorMessage */
        public final class AppDiscoveryLiteModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<AppSectionQueryFragmentModel> f4079d;

            /* compiled from: sendError.errorMessage */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AppDiscoveryLiteModel.class, new Deserializer());
                }

                public Object m4051a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AppDiscoveryLiteParser.m4155a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object appDiscoveryLiteModel = new AppDiscoveryLiteModel();
                    ((BaseModel) appDiscoveryLiteModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (appDiscoveryLiteModel instanceof Postprocessable) {
                        return ((Postprocessable) appDiscoveryLiteModel).a();
                    }
                    return appDiscoveryLiteModel;
                }
            }

            /* compiled from: sendError.errorMessage */
            public class Serializer extends JsonSerializer<AppDiscoveryLiteModel> {
                public final void m4052a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AppDiscoveryLiteModel appDiscoveryLiteModel = (AppDiscoveryLiteModel) obj;
                    if (appDiscoveryLiteModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(appDiscoveryLiteModel.m4053a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        appDiscoveryLiteModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AppDiscoveryLiteParser.m4156a(appDiscoveryLiteModel.w_(), appDiscoveryLiteModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AppDiscoveryLiteModel.class, new Serializer());
                }
            }

            public AppDiscoveryLiteModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<AppSectionQueryFragmentModel> m4055a() {
                this.f4079d = super.a(this.f4079d, 0, AppSectionQueryFragmentModel.class);
                return (ImmutableList) this.f4079d;
            }

            public final int jK_() {
                return -1744614213;
            }

            public final GraphQLVisitableModel m4054a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m4055a() != null) {
                    Builder a = ModelHelper.a(m4055a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AppDiscoveryLiteModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4079d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m4053a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m4055a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sendError.errorMessage */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppDiscoveryLiteQueryFragmentModel.class, new Deserializer());
            }

            public Object m4056a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AppDiscoveryLiteQueryFragmentParser.m4157a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object appDiscoveryLiteQueryFragmentModel = new AppDiscoveryLiteQueryFragmentModel();
                ((BaseModel) appDiscoveryLiteQueryFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (appDiscoveryLiteQueryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) appDiscoveryLiteQueryFragmentModel).a();
                }
                return appDiscoveryLiteQueryFragmentModel;
            }
        }

        /* compiled from: sendError.errorMessage */
        public class Serializer extends JsonSerializer<AppDiscoveryLiteQueryFragmentModel> {
            public final void m4057a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AppDiscoveryLiteQueryFragmentModel appDiscoveryLiteQueryFragmentModel = (AppDiscoveryLiteQueryFragmentModel) obj;
                if (appDiscoveryLiteQueryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appDiscoveryLiteQueryFragmentModel.m4058a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appDiscoveryLiteQueryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AppDiscoveryLiteQueryFragmentParser.m4158a(appDiscoveryLiteQueryFragmentModel.w_(), appDiscoveryLiteQueryFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AppDiscoveryLiteQueryFragmentModel.class, new Serializer());
            }
        }

        public AppDiscoveryLiteQueryFragmentModel() {
            super(1);
        }

        public final void m4061a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m4062a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final AppDiscoveryLiteModel m4059a() {
            this.f4080d = (AppDiscoveryLiteModel) super.a(this.f4080d, 0, AppDiscoveryLiteModel.class);
            return this.f4080d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m4060a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4059a() != null) {
                AppDiscoveryLiteModel appDiscoveryLiteModel = (AppDiscoveryLiteModel) graphQLModelMutatingVisitor.b(m4059a());
                if (m4059a() != appDiscoveryLiteModel) {
                    graphQLVisitableModel = (AppDiscoveryLiteQueryFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4080d = appDiscoveryLiteModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4058a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4059a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -51800250)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sendError.errorMessage */
    public final class AppSectionQueryFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f4091d;
        @Nullable
        private GraphQLMoreAppsUnitRenderStyle f4092e;
        @Nullable
        private AppSectionUnitsModel f4093f;
        @Nullable
        private String f4094g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1765644747)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sendError.errorMessage */
        public final class AppSectionUnitsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f4090d;

            /* compiled from: sendError.errorMessage */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AppSectionUnitsModel.class, new Deserializer());
                }

                public Object m4063a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AppSectionUnitsParser.m4161a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object appSectionUnitsModel = new AppSectionUnitsModel();
                    ((BaseModel) appSectionUnitsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (appSectionUnitsModel instanceof Postprocessable) {
                        return ((Postprocessable) appSectionUnitsModel).a();
                    }
                    return appSectionUnitsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -791404125)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: sendError.errorMessage */
            public final class NodesModel extends BaseModel implements AppStoryQueryFragment, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f4081d;
                @Nullable
                private List<ActorFacePileFragmentModel> f4082e;
                @Nullable
                private AppFragmentsGraphQLModels$UserFacePileFragmentModel f4083f;
                @Nullable
                private String f4084g;
                @Nullable
                private String f4085h;
                @Nullable
                private AppStoreAppFragmentModel f4086i;
                @Nullable
                private List<AttachmentsModel> f4087j;
                @Nullable
                private String f4088k;
                @Nullable
                private MessageModel f4089l;

                /* compiled from: sendError.errorMessage */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m4064a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m4159b(jsonParser, flatBufferBuilder));
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

                /* compiled from: sendError.errorMessage */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m4065a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m4071a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m4160b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ AppFragmentsGraphQLModels$UserFacePileFragmentModel m4072a() {
                    return m4067k();
                }

                @Nullable
                public final /* synthetic */ AppStoreAppFragmentModel m4078d() {
                    return m4068l();
                }

                @Nullable
                public final /* synthetic */ MessageModel kW_() {
                    return m4070n();
                }

                public NodesModel() {
                    super(9);
                }

                public final void m4074a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m4075a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m4066j() {
                    if (this.b != null && this.f4081d == null) {
                        this.f4081d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f4081d;
                }

                @Nonnull
                public final ImmutableList<ActorFacePileFragmentModel> kV_() {
                    this.f4082e = super.a(this.f4082e, 1, ActorFacePileFragmentModel.class);
                    return (ImmutableList) this.f4082e;
                }

                @Nullable
                private AppFragmentsGraphQLModels$UserFacePileFragmentModel m4067k() {
                    this.f4083f = (AppFragmentsGraphQLModels$UserFacePileFragmentModel) super.a(this.f4083f, 2, AppFragmentsGraphQLModels$UserFacePileFragmentModel.class);
                    return this.f4083f;
                }

                @Nullable
                public final String m4076b() {
                    this.f4084g = super.a(this.f4084g, 3);
                    return this.f4084g;
                }

                @Nullable
                public final String m4077c() {
                    this.f4085h = super.a(this.f4085h, 4);
                    return this.f4085h;
                }

                @Nullable
                private AppStoreAppFragmentModel m4068l() {
                    this.f4086i = (AppStoreAppFragmentModel) super.a(this.f4086i, 5, AppStoreAppFragmentModel.class);
                    return this.f4086i;
                }

                @Nonnull
                public final ImmutableList<AttachmentsModel> mo132g() {
                    this.f4087j = super.a(this.f4087j, 6, AttachmentsModel.class);
                    return (ImmutableList) this.f4087j;
                }

                @Nullable
                private String m4069m() {
                    this.f4088k = super.a(this.f4088k, 7);
                    return this.f4088k;
                }

                @Nullable
                private MessageModel m4070n() {
                    this.f4089l = (MessageModel) super.a(this.f4089l, 8, MessageModel.class);
                    return this.f4089l;
                }

                public final int jK_() {
                    return 2433570;
                }

                public final GraphQLVisitableModel m4073a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    NodesModel nodesModel;
                    GraphQLVisitableModel graphQLVisitableModel;
                    AppFragmentsGraphQLModels$UserFacePileFragmentModel appFragmentsGraphQLModels$UserFacePileFragmentModel;
                    AppStoreAppFragmentModel appStoreAppFragmentModel;
                    Builder a;
                    MessageModel messageModel;
                    h();
                    if (kV_() != null) {
                        Builder a2 = ModelHelper.a(kV_(), graphQLModelMutatingVisitor);
                        if (a2 != null) {
                            nodesModel = (NodesModel) ModelHelper.a(null, this);
                            nodesModel.f4082e = a2.b();
                            graphQLVisitableModel = nodesModel;
                            if (m4067k() != null) {
                                appFragmentsGraphQLModels$UserFacePileFragmentModel = (AppFragmentsGraphQLModels$UserFacePileFragmentModel) graphQLModelMutatingVisitor.b(m4067k());
                                if (m4067k() != appFragmentsGraphQLModels$UserFacePileFragmentModel) {
                                    graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f4083f = appFragmentsGraphQLModels$UserFacePileFragmentModel;
                                }
                            }
                            if (m4068l() != null) {
                                appStoreAppFragmentModel = (AppStoreAppFragmentModel) graphQLModelMutatingVisitor.b(m4068l());
                                if (m4068l() != appStoreAppFragmentModel) {
                                    graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f4086i = appStoreAppFragmentModel;
                                }
                            }
                            if (mo132g() != null) {
                                a = ModelHelper.a(mo132g(), graphQLModelMutatingVisitor);
                                if (a != null) {
                                    nodesModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    nodesModel.f4087j = a.b();
                                    graphQLVisitableModel = nodesModel;
                                }
                            }
                            if (m4070n() != null) {
                                messageModel = (MessageModel) graphQLModelMutatingVisitor.b(m4070n());
                                if (m4070n() != messageModel) {
                                    graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f4089l = messageModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                        }
                    }
                    graphQLVisitableModel = null;
                    if (m4067k() != null) {
                        appFragmentsGraphQLModels$UserFacePileFragmentModel = (AppFragmentsGraphQLModels$UserFacePileFragmentModel) graphQLModelMutatingVisitor.b(m4067k());
                        if (m4067k() != appFragmentsGraphQLModels$UserFacePileFragmentModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f4083f = appFragmentsGraphQLModels$UserFacePileFragmentModel;
                        }
                    }
                    if (m4068l() != null) {
                        appStoreAppFragmentModel = (AppStoreAppFragmentModel) graphQLModelMutatingVisitor.b(m4068l());
                        if (m4068l() != appStoreAppFragmentModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f4086i = appStoreAppFragmentModel;
                        }
                    }
                    if (mo132g() != null) {
                        a = ModelHelper.a(mo132g(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            nodesModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            nodesModel.f4087j = a.b();
                            graphQLVisitableModel = nodesModel;
                        }
                    }
                    if (m4070n() != null) {
                        messageModel = (MessageModel) graphQLModelMutatingVisitor.b(m4070n());
                        if (m4070n() != messageModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f4089l = messageModel;
                        }
                    }
                    i();
                    if (graphQLVisitableModel != null) {
                    }
                }

                public final int m4071a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m4066j());
                    int a2 = ModelHelper.a(flatBufferBuilder, kV_());
                    int a3 = ModelHelper.a(flatBufferBuilder, m4067k());
                    int b = flatBufferBuilder.b(m4076b());
                    int b2 = flatBufferBuilder.b(m4077c());
                    int a4 = ModelHelper.a(flatBufferBuilder, m4068l());
                    int a5 = ModelHelper.a(flatBufferBuilder, mo132g());
                    int b3 = flatBufferBuilder.b(m4069m());
                    int a6 = ModelHelper.a(flatBufferBuilder, m4070n());
                    flatBufferBuilder.c(9);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, a3);
                    flatBufferBuilder.b(3, b);
                    flatBufferBuilder.b(4, b2);
                    flatBufferBuilder.b(5, a4);
                    flatBufferBuilder.b(6, a5);
                    flatBufferBuilder.b(7, b3);
                    flatBufferBuilder.b(8, a6);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: sendError.errorMessage */
            public class Serializer extends JsonSerializer<AppSectionUnitsModel> {
                public final void m4080a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AppSectionUnitsModel appSectionUnitsModel = (AppSectionUnitsModel) obj;
                    if (appSectionUnitsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(appSectionUnitsModel.m4081a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        appSectionUnitsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AppSectionUnitsParser.m4162a(appSectionUnitsModel.w_(), appSectionUnitsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AppSectionUnitsModel.class, new Serializer());
                }
            }

            public AppSectionUnitsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m4083a() {
                this.f4090d = super.a(this.f4090d, 0, NodesModel.class);
                return (ImmutableList) this.f4090d;
            }

            public final int jK_() {
                return -1890123010;
            }

            public final GraphQLVisitableModel m4082a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m4083a() != null) {
                    Builder a = ModelHelper.a(m4083a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AppSectionUnitsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4090d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m4081a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m4083a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sendError.errorMessage */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppSectionQueryFragmentModel.class, new Deserializer());
            }

            public Object m4084a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AppSectionQueryFragmentParser.m4163b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object appSectionQueryFragmentModel = new AppSectionQueryFragmentModel();
                ((BaseModel) appSectionQueryFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (appSectionQueryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) appSectionQueryFragmentModel).a();
                }
                return appSectionQueryFragmentModel;
            }
        }

        /* compiled from: sendError.errorMessage */
        public class Serializer extends JsonSerializer<AppSectionQueryFragmentModel> {
            public final void m4085a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                AppSectionQueryFragmentModel appSectionQueryFragmentModel = (AppSectionQueryFragmentModel) obj;
                if (appSectionQueryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appSectionQueryFragmentModel.m4086a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appSectionQueryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                AppSectionQueryFragmentParser.m4164b(appSectionQueryFragmentModel.w_(), appSectionQueryFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(AppSectionQueryFragmentModel.class, new Serializer());
            }
        }

        public AppSectionQueryFragmentModel() {
            super(4);
        }

        @Nullable
        public final String m4089j() {
            this.f4091d = super.a(this.f4091d, 0);
            return this.f4091d;
        }

        @Nullable
        public final GraphQLMoreAppsUnitRenderStyle m4090k() {
            this.f4092e = (GraphQLMoreAppsUnitRenderStyle) super.b(this.f4092e, 1, GraphQLMoreAppsUnitRenderStyle.class, GraphQLMoreAppsUnitRenderStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f4092e;
        }

        @Nullable
        public final AppSectionUnitsModel m4091l() {
            this.f4093f = (AppSectionUnitsModel) super.a(this.f4093f, 2, AppSectionUnitsModel.class);
            return this.f4093f;
        }

        @Nullable
        public final String m4092m() {
            this.f4094g = super.a(this.f4094g, 3);
            return this.f4094g;
        }

        @Nullable
        public final String m4088a() {
            return m4092m();
        }

        public final int jK_() {
            return 801243556;
        }

        public final GraphQLVisitableModel m4087a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4091l() != null) {
                AppSectionUnitsModel appSectionUnitsModel = (AppSectionUnitsModel) graphQLModelMutatingVisitor.b(m4091l());
                if (m4091l() != appSectionUnitsModel) {
                    graphQLVisitableModel = (AppSectionQueryFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4093f = appSectionUnitsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4086a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m4089j());
            int a = flatBufferBuilder.a(m4090k());
            int a2 = ModelHelper.a(flatBufferBuilder, m4091l());
            int b2 = flatBufferBuilder.b(m4092m());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -549668054)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sendError.errorMessage */
    public final class AppStoryQueryFragmentModel extends BaseModel implements AppStoryQueryFragment, GraphQLVisitableConsistentModel {
        @Nullable
        private List<ActorFacePileFragmentModel> f4108d;
        @Nullable
        private List<AttachmentsModel> f4109e;
        @Nullable
        private String f4110f;
        @Nullable
        private MessageModel f4111g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -909781165)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sendError.errorMessage */
        public final class AttachmentsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<ActionLinksModel> f4102d;
            @Nullable
            private AppStoreApplicationFragmentModel f4103e;
            @Nullable
            private DescriptionModel f4104f;
            @Nullable
            private FBGenericAttachmentMediaQueryFragmentModel f4105g;
            @Nullable
            private List<GraphQLStoryAttachmentStyle> f4106h;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -36756213)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: sendError.errorMessage */
            public final class ActionLinksModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f4095d;
                @Nullable
                private GraphQLStoryActionLinkDestinationType f4096e;
                @Nullable
                private String f4097f;
                @Nullable
                private GraphQLCallToActionType f4098g;
                @Nullable
                private String f4099h;
                @Nullable
                private String f4100i;

                /* compiled from: sendError.errorMessage */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActionLinksModel.class, new Deserializer());
                    }

                    public Object m4093a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ActionLinksParser.m4166b(jsonParser, flatBufferBuilder));
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

                /* compiled from: sendError.errorMessage */
                public class Serializer extends JsonSerializer<ActionLinksModel> {
                    public final void m4094a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActionLinksModel actionLinksModel = (ActionLinksModel) obj;
                        if (actionLinksModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(actionLinksModel.m4100a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            actionLinksModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ActionLinksParser.m4165a(actionLinksModel.w_(), actionLinksModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ActionLinksModel.class, new Serializer());
                    }
                }

                public ActionLinksModel() {
                    super(6);
                }

                @Nullable
                private GraphQLObjectType m4095j() {
                    if (this.b != null && this.f4095d == null) {
                        this.f4095d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f4095d;
                }

                @Nullable
                private GraphQLStoryActionLinkDestinationType m4096k() {
                    this.f4096e = (GraphQLStoryActionLinkDestinationType) super.b(this.f4096e, 1, GraphQLStoryActionLinkDestinationType.class, GraphQLStoryActionLinkDestinationType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f4096e;
                }

                @Nullable
                private String m4097l() {
                    this.f4097f = super.a(this.f4097f, 2);
                    return this.f4097f;
                }

                @Nullable
                private GraphQLCallToActionType m4098m() {
                    this.f4098g = (GraphQLCallToActionType) super.b(this.f4098g, 3, GraphQLCallToActionType.class, GraphQLCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                    return this.f4098g;
                }

                @Nullable
                public final String m4102a() {
                    this.f4099h = super.a(this.f4099h, 4);
                    return this.f4099h;
                }

                @Nullable
                private String m4099n() {
                    this.f4100i = super.a(this.f4100i, 5);
                    return this.f4100i;
                }

                public final int jK_() {
                    return -1747569147;
                }

                public final GraphQLVisitableModel m4101a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m4100a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m4095j());
                    int a2 = flatBufferBuilder.a(m4096k());
                    int b = flatBufferBuilder.b(m4097l());
                    int a3 = flatBufferBuilder.a(m4098m());
                    int b2 = flatBufferBuilder.b(m4102a());
                    int b3 = flatBufferBuilder.b(m4099n());
                    flatBufferBuilder.c(6);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.b(2, b);
                    flatBufferBuilder.b(3, a3);
                    flatBufferBuilder.b(4, b2);
                    flatBufferBuilder.b(5, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: sendError.errorMessage */
            public final class DescriptionModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f4101d;

                /* compiled from: sendError.errorMessage */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(DescriptionModel.class, new Deserializer());
                    }

                    public Object m4103a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(DescriptionParser.m4167a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object descriptionModel = new DescriptionModel();
                        ((BaseModel) descriptionModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (descriptionModel instanceof Postprocessable) {
                            return ((Postprocessable) descriptionModel).a();
                        }
                        return descriptionModel;
                    }
                }

                /* compiled from: sendError.errorMessage */
                public class Serializer extends JsonSerializer<DescriptionModel> {
                    public final void m4104a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        DescriptionModel descriptionModel = (DescriptionModel) obj;
                        if (descriptionModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(descriptionModel.m4106a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            descriptionModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        DescriptionParser.m4168a(descriptionModel.w_(), descriptionModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(DescriptionModel.class, new Serializer());
                    }
                }

                public DescriptionModel() {
                    super(1);
                }

                @Nullable
                private String m4105a() {
                    this.f4101d = super.a(this.f4101d, 0);
                    return this.f4101d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m4107a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m4106a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m4105a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: sendError.errorMessage */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AttachmentsModel.class, new Deserializer());
                }

                public Object m4108a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AttachmentsParser.m4171b(jsonParser, flatBufferBuilder));
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

            /* compiled from: sendError.errorMessage */
            public class Serializer extends JsonSerializer<AttachmentsModel> {
                public final void m4109a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AttachmentsModel attachmentsModel = (AttachmentsModel) obj;
                    if (attachmentsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(attachmentsModel.m4114a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        attachmentsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AttachmentsParser.m4172b(attachmentsModel.w_(), attachmentsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AttachmentsModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ FBGenericAttachmentMediaQueryFragmentModel m4117b() {
                return m4112l();
            }

            public AttachmentsModel() {
                super(5);
            }

            @Nonnull
            public final ImmutableList<ActionLinksModel> m4116a() {
                this.f4102d = super.a(this.f4102d, 0, ActionLinksModel.class);
                return (ImmutableList) this.f4102d;
            }

            @Nullable
            private AppStoreApplicationFragmentModel m4110j() {
                this.f4103e = (AppStoreApplicationFragmentModel) super.a(this.f4103e, 1, AppStoreApplicationFragmentModel.class);
                return this.f4103e;
            }

            @Nullable
            private DescriptionModel m4111k() {
                this.f4104f = (DescriptionModel) super.a(this.f4104f, 2, DescriptionModel.class);
                return this.f4104f;
            }

            @Nullable
            private FBGenericAttachmentMediaQueryFragmentModel m4112l() {
                this.f4105g = (FBGenericAttachmentMediaQueryFragmentModel) super.a(this.f4105g, 3, FBGenericAttachmentMediaQueryFragmentModel.class);
                return this.f4105g;
            }

            @Nonnull
            private ImmutableList<GraphQLStoryAttachmentStyle> m4113m() {
                this.f4106h = super.c(this.f4106h, 4, GraphQLStoryAttachmentStyle.class);
                return (ImmutableList) this.f4106h;
            }

            public final int jK_() {
                return -1267730472;
            }

            public final GraphQLVisitableModel m4115a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel;
                AppStoreApplicationFragmentModel appStoreApplicationFragmentModel;
                DescriptionModel descriptionModel;
                FBGenericAttachmentMediaQueryFragmentModel fBGenericAttachmentMediaQueryFragmentModel;
                h();
                if (m4116a() != null) {
                    Builder a = ModelHelper.a(m4116a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        AttachmentsModel attachmentsModel = (AttachmentsModel) ModelHelper.a(null, this);
                        attachmentsModel.f4102d = a.b();
                        graphQLVisitableModel = attachmentsModel;
                        if (m4110j() != null) {
                            appStoreApplicationFragmentModel = (AppStoreApplicationFragmentModel) graphQLModelMutatingVisitor.b(m4110j());
                            if (m4110j() != appStoreApplicationFragmentModel) {
                                graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f4103e = appStoreApplicationFragmentModel;
                            }
                        }
                        if (m4111k() != null) {
                            descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m4111k());
                            if (m4111k() != descriptionModel) {
                                graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f4104f = descriptionModel;
                            }
                        }
                        if (m4112l() != null) {
                            fBGenericAttachmentMediaQueryFragmentModel = (FBGenericAttachmentMediaQueryFragmentModel) graphQLModelMutatingVisitor.b(m4112l());
                            if (m4112l() != fBGenericAttachmentMediaQueryFragmentModel) {
                                graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                                graphQLVisitableModel.f4105g = fBGenericAttachmentMediaQueryFragmentModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                    }
                }
                graphQLVisitableModel = null;
                if (m4110j() != null) {
                    appStoreApplicationFragmentModel = (AppStoreApplicationFragmentModel) graphQLModelMutatingVisitor.b(m4110j());
                    if (m4110j() != appStoreApplicationFragmentModel) {
                        graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4103e = appStoreApplicationFragmentModel;
                    }
                }
                if (m4111k() != null) {
                    descriptionModel = (DescriptionModel) graphQLModelMutatingVisitor.b(m4111k());
                    if (m4111k() != descriptionModel) {
                        graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4104f = descriptionModel;
                    }
                }
                if (m4112l() != null) {
                    fBGenericAttachmentMediaQueryFragmentModel = (FBGenericAttachmentMediaQueryFragmentModel) graphQLModelMutatingVisitor.b(m4112l());
                    if (m4112l() != fBGenericAttachmentMediaQueryFragmentModel) {
                        graphQLVisitableModel = (AttachmentsModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4105g = fBGenericAttachmentMediaQueryFragmentModel;
                    }
                }
                i();
                if (graphQLVisitableModel != null) {
                }
            }

            public final int m4114a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m4116a());
                int a2 = ModelHelper.a(flatBufferBuilder, m4110j());
                int a3 = ModelHelper.a(flatBufferBuilder, m4111k());
                int a4 = ModelHelper.a(flatBufferBuilder, m4112l());
                int d = flatBufferBuilder.d(m4113m());
                flatBufferBuilder.c(5);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, a4);
                flatBufferBuilder.b(4, d);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sendError.errorMessage */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppStoryQueryFragmentModel.class, new Deserializer());
            }

            public Object m4118a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AppStoryQueryFragmentParser.m4175a(jsonParser);
                Object appStoryQueryFragmentModel = new AppStoryQueryFragmentModel();
                ((BaseModel) appStoryQueryFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (appStoryQueryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) appStoryQueryFragmentModel).a();
                }
                return appStoryQueryFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sendError.errorMessage */
        public final class MessageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f4107d;

            /* compiled from: sendError.errorMessage */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(MessageModel.class, new Deserializer());
                }

                public Object m4119a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(MessageParser.m4173a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object messageModel = new MessageModel();
                    ((BaseModel) messageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (messageModel instanceof Postprocessable) {
                        return ((Postprocessable) messageModel).a();
                    }
                    return messageModel;
                }
            }

            /* compiled from: sendError.errorMessage */
            public class Serializer extends JsonSerializer<MessageModel> {
                public final void m4120a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    MessageModel messageModel = (MessageModel) obj;
                    if (messageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(messageModel.m4121a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        messageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    MessageParser.m4174a(messageModel.w_(), messageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(MessageModel.class, new Serializer());
                }
            }

            public MessageModel() {
                super(1);
            }

            @Nullable
            public final String m4123a() {
                this.f4107d = super.a(this.f4107d, 0);
                return this.f4107d;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m4122a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m4121a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m4123a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sendError.errorMessage */
        public class Serializer extends JsonSerializer<AppStoryQueryFragmentModel> {
            public final void m4124a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AppStoryQueryFragmentModel appStoryQueryFragmentModel = (AppStoryQueryFragmentModel) obj;
                if (appStoryQueryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appStoryQueryFragmentModel.m4127a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appStoryQueryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = appStoryQueryFragmentModel.w_();
                int u_ = appStoryQueryFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("actors");
                    ActorFacePileFragmentParser.m4010a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("attachments");
                    AttachmentsParser.m4170a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("cache_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("message");
                    MessageParser.m4174a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AppStoryQueryFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ MessageModel kW_() {
            return m4126j();
        }

        public AppStoryQueryFragmentModel() {
            super(4);
        }

        public final void m4129a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m4130a(String str, Object obj, boolean z) {
        }

        @Nonnull
        public final ImmutableList<ActorFacePileFragmentModel> kV_() {
            this.f4108d = super.a(this.f4108d, 0, ActorFacePileFragmentModel.class);
            return (ImmutableList) this.f4108d;
        }

        @Nonnull
        public final ImmutableList<AttachmentsModel> mo132g() {
            this.f4109e = super.a(this.f4109e, 1, AttachmentsModel.class);
            return (ImmutableList) this.f4109e;
        }

        @Nullable
        private String m4125a() {
            this.f4110f = super.a(this.f4110f, 2);
            return this.f4110f;
        }

        @Nullable
        private MessageModel m4126j() {
            this.f4111g = (MessageModel) super.a(this.f4111g, 3, MessageModel.class);
            return this.f4111g;
        }

        public final int jK_() {
            return 80218325;
        }

        public final GraphQLVisitableModel m4128a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (kV_() != null) {
                a = ModelHelper.a(kV_(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (AppStoryQueryFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4108d = a.b();
                }
            }
            if (mo132g() != null) {
                a = ModelHelper.a(mo132g(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (AppStoryQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4109e = a.b();
                }
            }
            GraphQLVisitableModel graphQLVisitableModel2 = graphQLVisitableModel;
            if (m4126j() != null) {
                MessageModel messageModel = (MessageModel) graphQLModelMutatingVisitor.b(m4126j());
                if (m4126j() != messageModel) {
                    graphQLVisitableModel2 = (AppStoryQueryFragmentModel) ModelHelper.a(graphQLVisitableModel2, this);
                    graphQLVisitableModel2.f4111g = messageModel;
                }
            }
            i();
            return graphQLVisitableModel2 == null ? this : graphQLVisitableModel2;
        }

        public final int m4127a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, kV_());
            int a2 = ModelHelper.a(flatBufferBuilder, mo132g());
            int b = flatBufferBuilder.b(m4125a());
            int a3 = ModelHelper.a(flatBufferBuilder, m4126j());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1905865425)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sendError.errorMessage */
    public final class FBGenericAttachmentMediaQueryFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f4113d;
        @Nullable
        private AnimatedImageModel f4114e;
        @Nullable
        private DefaultImageFieldsModel f4115f;
        @Nullable
        private DefaultImageFieldsModel f4116g;
        @Nullable
        private DefaultImageFieldsModel f4117h;
        @Nullable
        private DefaultImageFieldsModel f4118i;
        private boolean f4119j;
        private int f4120k;
        @Nullable
        private String f4121l;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: sendError.errorMessage */
        public final class AnimatedImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f4112d;

            /* compiled from: sendError.errorMessage */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AnimatedImageModel.class, new Deserializer());
                }

                public Object m4132a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AnimatedImageParser.m4176a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object animatedImageModel = new AnimatedImageModel();
                    ((BaseModel) animatedImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (animatedImageModel instanceof Postprocessable) {
                        return ((Postprocessable) animatedImageModel).a();
                    }
                    return animatedImageModel;
                }
            }

            /* compiled from: sendError.errorMessage */
            public class Serializer extends JsonSerializer<AnimatedImageModel> {
                public final void m4133a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AnimatedImageModel animatedImageModel = (AnimatedImageModel) obj;
                    if (animatedImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(animatedImageModel.m4135a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        animatedImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AnimatedImageParser.m4177a(animatedImageModel.w_(), animatedImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(AnimatedImageModel.class, new Serializer());
                }
            }

            public AnimatedImageModel() {
                super(1);
            }

            @Nullable
            private String m4134a() {
                this.f4112d = super.a(this.f4112d, 0);
                return this.f4112d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m4136a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m4135a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m4134a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: sendError.errorMessage */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBGenericAttachmentMediaQueryFragmentModel.class, new Deserializer());
            }

            public Object m4137a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBGenericAttachmentMediaQueryFragmentParser.m4178a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBGenericAttachmentMediaQueryFragmentModel = new FBGenericAttachmentMediaQueryFragmentModel();
                ((BaseModel) fBGenericAttachmentMediaQueryFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBGenericAttachmentMediaQueryFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBGenericAttachmentMediaQueryFragmentModel).a();
                }
                return fBGenericAttachmentMediaQueryFragmentModel;
            }
        }

        /* compiled from: sendError.errorMessage */
        public class Serializer extends JsonSerializer<FBGenericAttachmentMediaQueryFragmentModel> {
            public final void m4138a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBGenericAttachmentMediaQueryFragmentModel fBGenericAttachmentMediaQueryFragmentModel = (FBGenericAttachmentMediaQueryFragmentModel) obj;
                if (fBGenericAttachmentMediaQueryFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBGenericAttachmentMediaQueryFragmentModel.m4146a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBGenericAttachmentMediaQueryFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBGenericAttachmentMediaQueryFragmentParser.m4179a(fBGenericAttachmentMediaQueryFragmentModel.w_(), fBGenericAttachmentMediaQueryFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBGenericAttachmentMediaQueryFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m4147a() {
            return m4143n();
        }

        public FBGenericAttachmentMediaQueryFragmentModel() {
            super(9);
        }

        @Nullable
        private GraphQLObjectType m4139j() {
            if (this.b != null && this.f4113d == null) {
                this.f4113d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f4113d;
        }

        @Nullable
        private AnimatedImageModel m4140k() {
            this.f4114e = (AnimatedImageModel) super.a(this.f4114e, 1, AnimatedImageModel.class);
            return this.f4114e;
        }

        @Nullable
        private DefaultImageFieldsModel m4141l() {
            this.f4115f = (DefaultImageFieldsModel) super.a(this.f4115f, 2, DefaultImageFieldsModel.class);
            return this.f4115f;
        }

        @Nullable
        private DefaultImageFieldsModel m4142m() {
            this.f4116g = (DefaultImageFieldsModel) super.a(this.f4116g, 3, DefaultImageFieldsModel.class);
            return this.f4116g;
        }

        @Nullable
        private DefaultImageFieldsModel m4143n() {
            this.f4117h = (DefaultImageFieldsModel) super.a(this.f4117h, 4, DefaultImageFieldsModel.class);
            return this.f4117h;
        }

        @Nullable
        private DefaultImageFieldsModel m4144o() {
            this.f4118i = (DefaultImageFieldsModel) super.a(this.f4118i, 5, DefaultImageFieldsModel.class);
            return this.f4118i;
        }

        @Nullable
        private String m4145p() {
            this.f4121l = super.a(this.f4121l, 8);
            return this.f4121l;
        }

        public final int jK_() {
            return 74219460;
        }

        public final GraphQLVisitableModel m4148a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultImageFieldsModel defaultImageFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4140k() != null) {
                AnimatedImageModel animatedImageModel = (AnimatedImageModel) graphQLModelMutatingVisitor.b(m4140k());
                if (m4140k() != animatedImageModel) {
                    graphQLVisitableModel = (FBGenericAttachmentMediaQueryFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4114e = animatedImageModel;
                }
            }
            if (m4141l() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m4141l());
                if (m4141l() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FBGenericAttachmentMediaQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4115f = defaultImageFieldsModel;
                }
            }
            if (m4142m() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m4142m());
                if (m4142m() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FBGenericAttachmentMediaQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4116g = defaultImageFieldsModel;
                }
            }
            if (m4143n() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m4143n());
                if (m4143n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FBGenericAttachmentMediaQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4117h = defaultImageFieldsModel;
                }
            }
            if (m4144o() != null) {
                defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m4144o());
                if (m4144o() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (FBGenericAttachmentMediaQueryFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4118i = defaultImageFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4146a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4139j());
            int a2 = ModelHelper.a(flatBufferBuilder, m4140k());
            int a3 = ModelHelper.a(flatBufferBuilder, m4141l());
            int a4 = ModelHelper.a(flatBufferBuilder, m4142m());
            int a5 = ModelHelper.a(flatBufferBuilder, m4143n());
            int a6 = ModelHelper.a(flatBufferBuilder, m4144o());
            int b = flatBufferBuilder.b(m4145p());
            flatBufferBuilder.c(9);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, a3);
            flatBufferBuilder.b(3, a4);
            flatBufferBuilder.b(4, a5);
            flatBufferBuilder.b(5, a6);
            flatBufferBuilder.a(6, this.f4119j);
            flatBufferBuilder.a(7, this.f4120k, 0);
            flatBufferBuilder.b(8, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m4149a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4119j = mutableFlatBuffer.a(i, 6);
            this.f4120k = mutableFlatBuffer.a(i, 7, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 878680450)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: sendError.errorMessage */
    public final class FetchLiteResultsQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private AppDiscoveryLiteQueryFragmentModel f4122d;

        /* compiled from: sendError.errorMessage */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchLiteResultsQueryModel.class, new Deserializer());
            }

            public Object m4150a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchLiteResultsQueryParser.m4180a(jsonParser);
                Object fetchLiteResultsQueryModel = new FetchLiteResultsQueryModel();
                ((BaseModel) fetchLiteResultsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchLiteResultsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchLiteResultsQueryModel).a();
                }
                return fetchLiteResultsQueryModel;
            }
        }

        /* compiled from: sendError.errorMessage */
        public class Serializer extends JsonSerializer<FetchLiteResultsQueryModel> {
            public final void m4151a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchLiteResultsQueryModel fetchLiteResultsQueryModel = (FetchLiteResultsQueryModel) obj;
                if (fetchLiteResultsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchLiteResultsQueryModel.m4152a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchLiteResultsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchLiteResultsQueryModel.w_();
                int u_ = fetchLiteResultsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("actor");
                    AppDiscoveryLiteQueryFragmentParser.m4158a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchLiteResultsQueryModel.class, new Serializer());
            }
        }

        public FetchLiteResultsQueryModel() {
            super(1);
        }

        @Nullable
        public final AppDiscoveryLiteQueryFragmentModel m4153a() {
            this.f4122d = (AppDiscoveryLiteQueryFragmentModel) super.a(this.f4122d, 0, AppDiscoveryLiteQueryFragmentModel.class);
            return this.f4122d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m4154a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m4153a() != null) {
                AppDiscoveryLiteQueryFragmentModel appDiscoveryLiteQueryFragmentModel = (AppDiscoveryLiteQueryFragmentModel) graphQLModelMutatingVisitor.b(m4153a());
                if (m4153a() != appDiscoveryLiteQueryFragmentModel) {
                    graphQLVisitableModel = (FetchLiteResultsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4122d = appDiscoveryLiteQueryFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m4152a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m4153a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

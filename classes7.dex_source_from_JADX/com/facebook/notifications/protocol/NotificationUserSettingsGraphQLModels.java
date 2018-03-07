package com.facebook.notifications.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLNotifOptionClientActionType;
import com.facebook.graphql.enums.GraphQLNotifOptionRowDisplayStyle;
import com.facebook.graphql.enums.GraphQLNotifOptionRowSetDisplayStyle;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionFragment;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment.NotifOptions;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment.NotifOptions.Nodes;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLInterfaces.NotifOptionSetFragment.NotifOptions.Nodes.ClientInfo;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLParsers.NotifOptionFragmentParser;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLParsers.NotifOptionFragmentParser.OptionDisplayParser;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLParsers.NotifOptionFragmentParser.OptionDisplayParser.ImageSourceParser;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLParsers.NotifOptionSetFragmentParser;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLParsers.NotifOptionSetFragmentParser.NotifOptionsParser;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLParsers.NotifOptionSetFragmentParser.NotifOptionsParser.NodesParser;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLParsers.NotifOptionSetFragmentParser.NotifOptionsParser.NodesParser.ClientInfoParser;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLParsers.NotifOptionSetFragmentParser.OptionSetDisplayParser;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLParsers.NotificationNodeSettingsQueryParser;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLParsers.NotificationUserSettingsFragmentParser;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLParsers.NotificationUserSettingsFragmentParser.NotifOptionSetsParser;
import com.facebook.notifications.protocol.NotificationUserSettingsGraphQLParsers.NotificationUserSettingsFragmentParser.NotifOptionSetsParser.NodesParser.NotifOptionsParser.NotifOptionsNodesParser;
import com.facebook.notifications.protocol.NotificationsOptionRowCommonGraphQLInterfaces.StyleOnlyNotifOptionSetDisplayFragment;
import com.facebook.notifications.protocol.NotificationsOptionRowCommonGraphQLInterfaces.SubmenuOptionSetFragment;
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

/* compiled from: must set swipe dismiss direction flags */
public class NotificationUserSettingsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -752662782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: must set swipe dismiss direction flags */
    public final class NotifOptionFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, NotifOptionFragment {
        @Nullable
        private String f8594d;
        @Nullable
        private OptionDisplayModel f8595e;
        @Nullable
        private String f8596f;

        /* compiled from: must set swipe dismiss direction flags */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NotifOptionFragmentModel.class, new Deserializer());
            }

            public Object m10440a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NotifOptionFragmentParser.m10614a(jsonParser);
                Object notifOptionFragmentModel = new NotifOptionFragmentModel();
                ((BaseModel) notifOptionFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (notifOptionFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) notifOptionFragmentModel).a();
                }
                return notifOptionFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1471331924)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: must set swipe dismiss direction flags */
        public final class OptionDisplayModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private GraphQLObjectType f8584d;
            @Nullable
            private String f8585e;
            @Nullable
            private String f8586f;
            @Nullable
            private ImageSourceModel f8587g;
            @Nullable
            private GraphQLNotifOptionRowDisplayStyle f8588h;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel f8589i;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel f8590j;
            @Nullable
            private String f8591k;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel f8592l;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel f8593m;

            /* compiled from: must set swipe dismiss direction flags */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f8572a;
                @Nullable
                public String f8573b;
                @Nullable
                public String f8574c;
                @Nullable
                public ImageSourceModel f8575d;
                @Nullable
                public GraphQLNotifOptionRowDisplayStyle f8576e;
                @Nullable
                public DefaultTextWithEntitiesFieldsModel f8577f;
                @Nullable
                public DefaultTextWithEntitiesFieldsModel f8578g;
                @Nullable
                public String f8579h;
                @Nullable
                public DefaultTextWithEntitiesFieldsModel f8580i;
                @Nullable
                public DefaultTextWithEntitiesFieldsModel f8581j;

                public final OptionDisplayModel m10441a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f8572a);
                    int b = flatBufferBuilder.b(this.f8573b);
                    int b2 = flatBufferBuilder.b(this.f8574c);
                    int a2 = ModelHelper.a(flatBufferBuilder, this.f8575d);
                    int a3 = flatBufferBuilder.a(this.f8576e);
                    int a4 = ModelHelper.a(flatBufferBuilder, this.f8577f);
                    int a5 = ModelHelper.a(flatBufferBuilder, this.f8578g);
                    int b3 = flatBufferBuilder.b(this.f8579h);
                    int a6 = ModelHelper.a(flatBufferBuilder, this.f8580i);
                    int a7 = ModelHelper.a(flatBufferBuilder, this.f8581j);
                    flatBufferBuilder.c(10);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, a2);
                    flatBufferBuilder.b(4, a3);
                    flatBufferBuilder.b(5, a4);
                    flatBufferBuilder.b(6, a5);
                    flatBufferBuilder.b(7, b3);
                    flatBufferBuilder.b(8, a6);
                    flatBufferBuilder.b(9, a7);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new OptionDisplayModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: must set swipe dismiss direction flags */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OptionDisplayModel.class, new Deserializer());
                }

                public Object m10442a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OptionDisplayParser.m10612a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object optionDisplayModel = new OptionDisplayModel();
                    ((BaseModel) optionDisplayModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (optionDisplayModel instanceof Postprocessable) {
                        return ((Postprocessable) optionDisplayModel).a();
                    }
                    return optionDisplayModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 842551240)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: must set swipe dismiss direction flags */
            public final class ImageSourceModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f8583d;

                /* compiled from: must set swipe dismiss direction flags */
                public final class Builder {
                    @Nullable
                    public String f8582a;
                }

                /* compiled from: must set swipe dismiss direction flags */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ImageSourceModel.class, new Deserializer());
                    }

                    public Object m10443a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ImageSourceParser.m10610a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object imageSourceModel = new ImageSourceModel();
                        ((BaseModel) imageSourceModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (imageSourceModel instanceof Postprocessable) {
                            return ((Postprocessable) imageSourceModel).a();
                        }
                        return imageSourceModel;
                    }
                }

                /* compiled from: must set swipe dismiss direction flags */
                public class Serializer extends JsonSerializer<ImageSourceModel> {
                    public final void m10444a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ImageSourceModel imageSourceModel = (ImageSourceModel) obj;
                        if (imageSourceModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(imageSourceModel.m10446a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            imageSourceModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ImageSourceParser.m10611a(imageSourceModel.w_(), imageSourceModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ImageSourceModel.class, new Serializer());
                    }
                }

                public ImageSourceModel() {
                    super(1);
                }

                public ImageSourceModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m10448a() {
                    this.f8583d = super.a(this.f8583d, 0);
                    return this.f8583d;
                }

                public static ImageSourceModel m10445a(ImageSourceModel imageSourceModel) {
                    if (imageSourceModel == null) {
                        return null;
                    }
                    if (imageSourceModel instanceof ImageSourceModel) {
                        return imageSourceModel;
                    }
                    Builder builder = new Builder();
                    builder.f8582a = imageSourceModel.m10448a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f8582a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ImageSourceModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 70760763;
                }

                public final GraphQLVisitableModel m10447a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m10446a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m10448a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: must set swipe dismiss direction flags */
            public class Serializer extends JsonSerializer<OptionDisplayModel> {
                public final void m10449a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OptionDisplayModel optionDisplayModel = (OptionDisplayModel) obj;
                    if (optionDisplayModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(optionDisplayModel.m10456a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        optionDisplayModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OptionDisplayParser.m10613a(optionDisplayModel.w_(), optionDisplayModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(OptionDisplayModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ ImageSourceModel m10461d() {
                return m10451l();
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesFields m10462g() {
                return m10452m();
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesFields gw_() {
                return m10453n();
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesFields m10463j() {
                return m10454o();
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesFields m10464k() {
                return m10455p();
            }

            public OptionDisplayModel() {
                super(10);
            }

            public OptionDisplayModel(MutableFlatBuffer mutableFlatBuffer) {
                super(10);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final GraphQLObjectType m10457a() {
                if (this.b != null && this.f8584d == null) {
                    this.f8584d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8584d;
            }

            @Nullable
            public final String m10459b() {
                this.f8585e = super.a(this.f8585e, 1);
                return this.f8585e;
            }

            @Nullable
            public final String m10460c() {
                this.f8586f = super.a(this.f8586f, 2);
                return this.f8586f;
            }

            @Nullable
            private ImageSourceModel m10451l() {
                this.f8587g = (ImageSourceModel) super.a(this.f8587g, 3, ImageSourceModel.class);
                return this.f8587g;
            }

            @Nullable
            public final GraphQLNotifOptionRowDisplayStyle gu_() {
                this.f8588h = (GraphQLNotifOptionRowDisplayStyle) super.b(this.f8588h, 4, GraphQLNotifOptionRowDisplayStyle.class, GraphQLNotifOptionRowDisplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f8588h;
            }

            @Nullable
            private DefaultTextWithEntitiesFieldsModel m10452m() {
                this.f8589i = (DefaultTextWithEntitiesFieldsModel) super.a(this.f8589i, 5, DefaultTextWithEntitiesFieldsModel.class);
                return this.f8589i;
            }

            @Nullable
            private DefaultTextWithEntitiesFieldsModel m10453n() {
                this.f8590j = (DefaultTextWithEntitiesFieldsModel) super.a(this.f8590j, 6, DefaultTextWithEntitiesFieldsModel.class);
                return this.f8590j;
            }

            @Nullable
            public final String gv_() {
                this.f8591k = super.a(this.f8591k, 7);
                return this.f8591k;
            }

            @Nullable
            private DefaultTextWithEntitiesFieldsModel m10454o() {
                this.f8592l = (DefaultTextWithEntitiesFieldsModel) super.a(this.f8592l, 8, DefaultTextWithEntitiesFieldsModel.class);
                return this.f8592l;
            }

            @Nullable
            private DefaultTextWithEntitiesFieldsModel m10455p() {
                this.f8593m = (DefaultTextWithEntitiesFieldsModel) super.a(this.f8593m, 9, DefaultTextWithEntitiesFieldsModel.class);
                return this.f8593m;
            }

            public static OptionDisplayModel m10450a(OptionDisplayModel optionDisplayModel) {
                if (optionDisplayModel == null) {
                    return null;
                }
                if (optionDisplayModel instanceof OptionDisplayModel) {
                    return optionDisplayModel;
                }
                Builder builder = new Builder();
                builder.f8572a = optionDisplayModel.m10457a();
                builder.f8573b = optionDisplayModel.m10459b();
                builder.f8574c = optionDisplayModel.m10460c();
                builder.f8575d = ImageSourceModel.m10445a(optionDisplayModel.m10461d());
                builder.f8576e = optionDisplayModel.gu_();
                builder.f8577f = DefaultTextWithEntitiesFieldsModel.a(optionDisplayModel.m10462g());
                builder.f8578g = DefaultTextWithEntitiesFieldsModel.a(optionDisplayModel.gw_());
                builder.f8579h = optionDisplayModel.gv_();
                builder.f8580i = DefaultTextWithEntitiesFieldsModel.a(optionDisplayModel.m10463j());
                builder.f8581j = DefaultTextWithEntitiesFieldsModel.a(optionDisplayModel.m10464k());
                return builder.m10441a();
            }

            public final int jK_() {
                return 1019586317;
            }

            public final GraphQLVisitableModel m10458a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10451l() != null) {
                    ImageSourceModel imageSourceModel = (ImageSourceModel) graphQLModelMutatingVisitor.b(m10451l());
                    if (m10451l() != imageSourceModel) {
                        graphQLVisitableModel = (OptionDisplayModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8587g = imageSourceModel;
                    }
                }
                if (m10452m() != null) {
                    defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m10452m());
                    if (m10452m() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (OptionDisplayModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8589i = defaultTextWithEntitiesFieldsModel;
                    }
                }
                if (m10453n() != null) {
                    defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m10453n());
                    if (m10453n() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (OptionDisplayModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8590j = defaultTextWithEntitiesFieldsModel;
                    }
                }
                if (m10454o() != null) {
                    defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m10454o());
                    if (m10454o() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (OptionDisplayModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8592l = defaultTextWithEntitiesFieldsModel;
                    }
                }
                if (m10455p() != null) {
                    defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m10455p());
                    if (m10455p() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (OptionDisplayModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8593m = defaultTextWithEntitiesFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10456a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10457a());
                int b = flatBufferBuilder.b(m10459b());
                int b2 = flatBufferBuilder.b(m10460c());
                int a2 = ModelHelper.a(flatBufferBuilder, m10451l());
                int a3 = flatBufferBuilder.a(gu_());
                int a4 = ModelHelper.a(flatBufferBuilder, m10452m());
                int a5 = ModelHelper.a(flatBufferBuilder, m10453n());
                int b3 = flatBufferBuilder.b(gv_());
                int a6 = ModelHelper.a(flatBufferBuilder, m10454o());
                int a7 = ModelHelper.a(flatBufferBuilder, m10455p());
                flatBufferBuilder.c(10);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, a5);
                flatBufferBuilder.b(7, b3);
                flatBufferBuilder.b(8, a6);
                flatBufferBuilder.b(9, a7);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: must set swipe dismiss direction flags */
        public class Serializer extends JsonSerializer<NotifOptionFragmentModel> {
            public final void m10465a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NotifOptionFragmentModel notifOptionFragmentModel = (NotifOptionFragmentModel) obj;
                if (notifOptionFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(notifOptionFragmentModel.m10469a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    notifOptionFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = notifOptionFragmentModel.w_();
                int u_ = notifOptionFragmentModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("option_display");
                    OptionDisplayParser.m10613a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("server_action");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NotifOptionFragmentModel.class, new Serializer());
            }
        }

        public NotifOptionFragmentModel() {
            super(3);
        }

        @Nullable
        private String m10466j() {
            this.f8594d = super.a(this.f8594d, 0);
            return this.f8594d;
        }

        @Nullable
        private OptionDisplayModel m10467k() {
            this.f8595e = (OptionDisplayModel) super.a(this.f8595e, 1, OptionDisplayModel.class);
            return this.f8595e;
        }

        @Nullable
        private String m10468l() {
            this.f8596f = super.a(this.f8596f, 2);
            return this.f8596f;
        }

        @Nullable
        public final String m10471a() {
            return m10466j();
        }

        public final int jK_() {
            return -1261484123;
        }

        public final GraphQLVisitableModel m10470a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10467k() != null) {
                OptionDisplayModel optionDisplayModel = (OptionDisplayModel) graphQLModelMutatingVisitor.b(m10467k());
                if (m10467k() != optionDisplayModel) {
                    graphQLVisitableModel = (NotifOptionFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8595e = optionDisplayModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10469a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10466j());
            int a = ModelHelper.a(flatBufferBuilder, m10467k());
            int b2 = flatBufferBuilder.b(m10468l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -89133256)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: must set swipe dismiss direction flags */
    public final class NotifOptionSetFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, NotifOptionSetFragment {
        @Nullable
        private String f8632d;
        @Nullable
        private NotifOptionsModel f8633e;
        @Nullable
        private OptionSetDisplayModel f8634f;

        /* compiled from: must set swipe dismiss direction flags */
        public final class Builder {
            @Nullable
            public String f8597a;
            @Nullable
            public NotifOptionsModel f8598b;
            @Nullable
            public OptionSetDisplayModel f8599c;

            public static Builder m10472a(NotifOptionSetFragmentModel notifOptionSetFragmentModel) {
                Builder builder = new Builder();
                builder.f8597a = notifOptionSetFragmentModel.mo466b();
                builder.f8598b = notifOptionSetFragmentModel.m10525j();
                builder.f8599c = notifOptionSetFragmentModel.m10526k();
                return builder;
            }

            public final NotifOptionSetFragmentModel m10473a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f8597a);
                int a = ModelHelper.a(flatBufferBuilder, this.f8598b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f8599c);
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new NotifOptionSetFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: must set swipe dismiss direction flags */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NotifOptionSetFragmentModel.class, new Deserializer());
            }

            public Object m10474a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(NotifOptionSetFragmentParser.m10625b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object notifOptionSetFragmentModel = new NotifOptionSetFragmentModel();
                ((BaseModel) notifOptionSetFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (notifOptionSetFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) notifOptionSetFragmentModel).a();
                }
                return notifOptionSetFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 536863817)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: must set swipe dismiss direction flags */
        public final class NotifOptionsModel extends BaseModel implements GraphQLVisitableModel, NotifOptions {
            @Nullable
            private List<NodesModel> f8619d;

            /* compiled from: must set swipe dismiss direction flags */
            public final class Builder {
                @Nullable
                public ImmutableList<NodesModel> f8600a;
            }

            /* compiled from: must set swipe dismiss direction flags */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NotifOptionsModel.class, new Deserializer());
                }

                public Object m10475a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NotifOptionsParser.m10619a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object notifOptionsModel = new NotifOptionsModel();
                    ((BaseModel) notifOptionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (notifOptionsModel instanceof Postprocessable) {
                        return ((Postprocessable) notifOptionsModel).a();
                    }
                    return notifOptionsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -888687615)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: must set swipe dismiss direction flags */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, Nodes {
                @Nullable
                private ClientInfoModel f8615d;
                @Nullable
                private String f8616e;
                @Nullable
                private OptionDisplayModel f8617f;
                @Nullable
                private String f8618g;

                /* compiled from: must set swipe dismiss direction flags */
                public final class Builder {
                    @Nullable
                    public ClientInfoModel f8601a;
                    @Nullable
                    public String f8602b;
                    @Nullable
                    public OptionDisplayModel f8603c;
                    @Nullable
                    public String f8604d;
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 841320717)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: must set swipe dismiss direction flags */
                public final class ClientInfoModel extends BaseModel implements GraphQLVisitableModel, ClientInfo {
                    @Nullable
                    private GraphQLObjectType f8610d;
                    @Nullable
                    private GraphQLNotifOptionClientActionType f8611e;
                    @Nullable
                    private DefaultTextWithEntitiesFieldsModel f8612f;
                    @Nullable
                    private String f8613g;
                    @Nullable
                    private String f8614h;

                    /* compiled from: must set swipe dismiss direction flags */
                    public final class Builder {
                        @Nullable
                        public GraphQLObjectType f8605a;
                        @Nullable
                        public GraphQLNotifOptionClientActionType f8606b;
                        @Nullable
                        public DefaultTextWithEntitiesFieldsModel f8607c;
                        @Nullable
                        public String f8608d;
                        @Nullable
                        public String f8609e;
                    }

                    /* compiled from: must set swipe dismiss direction flags */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ClientInfoModel.class, new Deserializer());
                        }

                        public Object m10476a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(ClientInfoParser.m10615a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object clientInfoModel = new ClientInfoModel();
                            ((BaseModel) clientInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (clientInfoModel instanceof Postprocessable) {
                                return ((Postprocessable) clientInfoModel).a();
                            }
                            return clientInfoModel;
                        }
                    }

                    /* compiled from: must set swipe dismiss direction flags */
                    public class Serializer extends JsonSerializer<ClientInfoModel> {
                        public final void m10477a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ClientInfoModel clientInfoModel = (ClientInfoModel) obj;
                            if (clientInfoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(clientInfoModel.m10480a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                clientInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            ClientInfoParser.m10616a(clientInfoModel.w_(), clientInfoModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(ClientInfoModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ DefaultTextWithEntitiesFields mo457d() {
                        return m10479j();
                    }

                    public ClientInfoModel() {
                        super(5);
                    }

                    public ClientInfoModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(5);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final GraphQLObjectType mo455a() {
                        if (this.b != null && this.f8610d == null) {
                            this.f8610d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f8610d;
                    }

                    @Nullable
                    public final GraphQLNotifOptionClientActionType mo456b() {
                        this.f8611e = (GraphQLNotifOptionClientActionType) super.b(this.f8611e, 1, GraphQLNotifOptionClientActionType.class, GraphQLNotifOptionClientActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f8611e;
                    }

                    @Nullable
                    private DefaultTextWithEntitiesFieldsModel m10479j() {
                        this.f8612f = (DefaultTextWithEntitiesFieldsModel) super.a(this.f8612f, 2, DefaultTextWithEntitiesFieldsModel.class);
                        return this.f8612f;
                    }

                    @Nullable
                    public final String gy_() {
                        this.f8613g = super.a(this.f8613g, 3);
                        return this.f8613g;
                    }

                    @Nullable
                    public final String mo458g() {
                        this.f8614h = super.a(this.f8614h, 4);
                        return this.f8614h;
                    }

                    public static ClientInfoModel m10478a(ClientInfo clientInfo) {
                        if (clientInfo == null) {
                            return null;
                        }
                        if (clientInfo instanceof ClientInfoModel) {
                            return (ClientInfoModel) clientInfo;
                        }
                        Builder builder = new Builder();
                        builder.f8605a = clientInfo.mo455a();
                        builder.f8606b = clientInfo.mo456b();
                        builder.f8607c = DefaultTextWithEntitiesFieldsModel.a(clientInfo.mo457d());
                        builder.f8608d = clientInfo.gy_();
                        builder.f8609e = clientInfo.mo458g();
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, builder.f8605a);
                        int a2 = flatBufferBuilder.a(builder.f8606b);
                        int a3 = ModelHelper.a(flatBufferBuilder, builder.f8607c);
                        int b = flatBufferBuilder.b(builder.f8608d);
                        int b2 = flatBufferBuilder.b(builder.f8609e);
                        flatBufferBuilder.c(5);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.b(2, a3);
                        flatBufferBuilder.b(3, b);
                        flatBufferBuilder.b(4, b2);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new ClientInfoModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }

                    public final int jK_() {
                        return -1672387034;
                    }

                    public final GraphQLVisitableModel m10482a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m10479j() != null) {
                            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m10479j());
                            if (m10479j() != defaultTextWithEntitiesFieldsModel) {
                                graphQLVisitableModel = (ClientInfoModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f8612f = defaultTextWithEntitiesFieldsModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m10480a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, mo455a());
                        int a2 = flatBufferBuilder.a(mo456b());
                        int a3 = ModelHelper.a(flatBufferBuilder, m10479j());
                        int b = flatBufferBuilder.b(gy_());
                        int b2 = flatBufferBuilder.b(mo458g());
                        flatBufferBuilder.c(5);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.b(2, a3);
                        flatBufferBuilder.b(3, b);
                        flatBufferBuilder.b(4, b2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: must set swipe dismiss direction flags */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m10486a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NodesParser.m10617b(jsonParser, flatBufferBuilder));
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

                /* compiled from: must set swipe dismiss direction flags */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m10487a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m10491a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NodesParser.m10618b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ClientInfo mo460b() {
                    return m10489j();
                }

                @Nullable
                public final /* synthetic */ OptionDisplayModel mo462d() {
                    return m10490k();
                }

                public NodesModel() {
                    super(4);
                }

                public NodesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(4);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                private ClientInfoModel m10489j() {
                    this.f8615d = (ClientInfoModel) super.a(this.f8615d, 0, ClientInfoModel.class);
                    return this.f8615d;
                }

                @Nullable
                public final String mo461c() {
                    this.f8616e = super.a(this.f8616e, 1);
                    return this.f8616e;
                }

                @Nullable
                private OptionDisplayModel m10490k() {
                    this.f8617f = (OptionDisplayModel) super.a(this.f8617f, 2, OptionDisplayModel.class);
                    return this.f8617f;
                }

                @Nullable
                public final String gx_() {
                    this.f8618g = super.a(this.f8618g, 3);
                    return this.f8618g;
                }

                public static NodesModel m10488a(Nodes nodes) {
                    if (nodes == null) {
                        return null;
                    }
                    if (nodes instanceof NodesModel) {
                        return (NodesModel) nodes;
                    }
                    Builder builder = new Builder();
                    builder.f8601a = ClientInfoModel.m10478a(nodes.mo460b());
                    builder.f8602b = nodes.mo461c();
                    builder.f8603c = OptionDisplayModel.m10450a(nodes.mo462d());
                    builder.f8604d = nodes.gx_();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, builder.f8601a);
                    int b = flatBufferBuilder.b(builder.f8602b);
                    int a2 = ModelHelper.a(flatBufferBuilder, builder.f8603c);
                    int b2 = flatBufferBuilder.b(builder.f8604d);
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, b2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new NodesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                @Nullable
                public final String m10493a() {
                    return mo461c();
                }

                public final int jK_() {
                    return -1261484123;
                }

                public final GraphQLVisitableModel m10492a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m10489j() != null) {
                        ClientInfoModel clientInfoModel = (ClientInfoModel) graphQLModelMutatingVisitor.b(m10489j());
                        if (m10489j() != clientInfoModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8615d = clientInfoModel;
                        }
                    }
                    if (m10490k() != null) {
                        OptionDisplayModel optionDisplayModel = (OptionDisplayModel) graphQLModelMutatingVisitor.b(m10490k());
                        if (m10490k() != optionDisplayModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8617f = optionDisplayModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m10491a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m10489j());
                    int b = flatBufferBuilder.b(mo461c());
                    int a2 = ModelHelper.a(flatBufferBuilder, m10490k());
                    int b2 = flatBufferBuilder.b(gx_());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: must set swipe dismiss direction flags */
            public class Serializer extends JsonSerializer<NotifOptionsModel> {
                public final void m10497a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NotifOptionsModel notifOptionsModel = (NotifOptionsModel) obj;
                    if (notifOptionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(notifOptionsModel.m10499a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        notifOptionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NotifOptionsParser.m10620a(notifOptionsModel.w_(), notifOptionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NotifOptionsModel.class, new Serializer());
                }
            }

            public NotifOptionsModel() {
                super(1);
            }

            public NotifOptionsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<NodesModel> mo464a() {
                this.f8619d = super.a(this.f8619d, 0, NodesModel.class);
                return (ImmutableList) this.f8619d;
            }

            public static NotifOptionsModel m10498a(NotifOptions notifOptions) {
                if (notifOptions == null) {
                    return null;
                }
                if (notifOptions instanceof NotifOptionsModel) {
                    return (NotifOptionsModel) notifOptions;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < notifOptions.mo464a().size(); i++) {
                    builder2.c(NodesModel.m10488a((Nodes) notifOptions.mo464a().get(i)));
                }
                builder.f8600a = builder2.b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f8600a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new NotifOptionsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -438337761;
            }

            public final GraphQLVisitableModel m10500a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (mo464a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(mo464a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (NotifOptionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8619d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10499a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, mo464a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1613435556)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: must set swipe dismiss direction flags */
        public final class OptionSetDisplayModel extends BaseModel implements GraphQLVisitableModel, StyleOnlyNotifOptionSetDisplayFragment {
            @Nullable
            private GraphQLObjectType f8626d;
            @Nullable
            private String f8627e;
            @Nullable
            private GraphQLNotifOptionRowSetDisplayStyle f8628f;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel f8629g;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel f8630h;
            @Nullable
            private DefaultTextWithEntitiesFieldsModel f8631i;

            /* compiled from: must set swipe dismiss direction flags */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f8620a;
                @Nullable
                public String f8621b;
                @Nullable
                public GraphQLNotifOptionRowSetDisplayStyle f8622c;
                @Nullable
                public DefaultTextWithEntitiesFieldsModel f8623d;
                @Nullable
                public DefaultTextWithEntitiesFieldsModel f8624e;
                @Nullable
                public DefaultTextWithEntitiesFieldsModel f8625f;

                public static Builder m10502a(OptionSetDisplayModel optionSetDisplayModel) {
                    Builder builder = new Builder();
                    builder.f8620a = optionSetDisplayModel.m10508a();
                    builder.f8621b = optionSetDisplayModel.m10510b();
                    builder.f8622c = optionSetDisplayModel.mo465c();
                    builder.f8623d = optionSetDisplayModel.m10514j();
                    builder.f8624e = optionSetDisplayModel.m10515k();
                    builder.f8625f = optionSetDisplayModel.m10516l();
                    return builder;
                }

                public final OptionSetDisplayModel m10503a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f8620a);
                    int b = flatBufferBuilder.b(this.f8621b);
                    int a2 = flatBufferBuilder.a(this.f8622c);
                    int a3 = ModelHelper.a(flatBufferBuilder, this.f8623d);
                    int a4 = ModelHelper.a(flatBufferBuilder, this.f8624e);
                    int a5 = ModelHelper.a(flatBufferBuilder, this.f8625f);
                    flatBufferBuilder.c(6);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, a3);
                    flatBufferBuilder.b(4, a4);
                    flatBufferBuilder.b(5, a5);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new OptionSetDisplayModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: must set swipe dismiss direction flags */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(OptionSetDisplayModel.class, new Deserializer());
                }

                public Object m10504a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(OptionSetDisplayParser.m10621a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object optionSetDisplayModel = new OptionSetDisplayModel();
                    ((BaseModel) optionSetDisplayModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (optionSetDisplayModel instanceof Postprocessable) {
                        return ((Postprocessable) optionSetDisplayModel).a();
                    }
                    return optionSetDisplayModel;
                }
            }

            /* compiled from: must set swipe dismiss direction flags */
            public class Serializer extends JsonSerializer<OptionSetDisplayModel> {
                public final void m10505a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    OptionSetDisplayModel optionSetDisplayModel = (OptionSetDisplayModel) obj;
                    if (optionSetDisplayModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(optionSetDisplayModel.m10507a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        optionSetDisplayModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    OptionSetDisplayParser.m10622a(optionSetDisplayModel.w_(), optionSetDisplayModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(OptionSetDisplayModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesFields m10512d() {
                return m10514j();
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesFields m10513g() {
                return m10516l();
            }

            @Nullable
            public final /* synthetic */ DefaultTextWithEntitiesFields gz_() {
                return m10515k();
            }

            public OptionSetDisplayModel() {
                super(6);
            }

            public OptionSetDisplayModel(MutableFlatBuffer mutableFlatBuffer) {
                super(6);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final GraphQLObjectType m10508a() {
                if (this.b != null && this.f8626d == null) {
                    this.f8626d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f8626d;
            }

            @Nullable
            public final String m10510b() {
                this.f8627e = super.a(this.f8627e, 1);
                return this.f8627e;
            }

            @Nullable
            public final GraphQLNotifOptionRowSetDisplayStyle mo465c() {
                this.f8628f = (GraphQLNotifOptionRowSetDisplayStyle) super.b(this.f8628f, 2, GraphQLNotifOptionRowSetDisplayStyle.class, GraphQLNotifOptionRowSetDisplayStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f8628f;
            }

            @Nullable
            public final DefaultTextWithEntitiesFieldsModel m10514j() {
                this.f8629g = (DefaultTextWithEntitiesFieldsModel) super.a(this.f8629g, 3, DefaultTextWithEntitiesFieldsModel.class);
                return this.f8629g;
            }

            @Nullable
            public final DefaultTextWithEntitiesFieldsModel m10515k() {
                this.f8630h = (DefaultTextWithEntitiesFieldsModel) super.a(this.f8630h, 4, DefaultTextWithEntitiesFieldsModel.class);
                return this.f8630h;
            }

            @Nullable
            public final DefaultTextWithEntitiesFieldsModel m10516l() {
                this.f8631i = (DefaultTextWithEntitiesFieldsModel) super.a(this.f8631i, 5, DefaultTextWithEntitiesFieldsModel.class);
                return this.f8631i;
            }

            public static OptionSetDisplayModel m10506a(OptionSetDisplayModel optionSetDisplayModel) {
                if (optionSetDisplayModel == null) {
                    return null;
                }
                if (optionSetDisplayModel instanceof OptionSetDisplayModel) {
                    return optionSetDisplayModel;
                }
                Builder builder = new Builder();
                builder.f8620a = optionSetDisplayModel.m10508a();
                builder.f8621b = optionSetDisplayModel.m10510b();
                builder.f8622c = optionSetDisplayModel.mo465c();
                builder.f8623d = DefaultTextWithEntitiesFieldsModel.a(optionSetDisplayModel.m10512d());
                builder.f8624e = DefaultTextWithEntitiesFieldsModel.a(optionSetDisplayModel.gz_());
                builder.f8625f = DefaultTextWithEntitiesFieldsModel.a(optionSetDisplayModel.m10513g());
                return builder.m10503a();
            }

            public final int jK_() {
                return 1752329173;
            }

            public final GraphQLVisitableModel m10509a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10514j() != null) {
                    defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m10514j());
                    if (m10514j() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (OptionSetDisplayModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8629g = defaultTextWithEntitiesFieldsModel;
                    }
                }
                if (m10515k() != null) {
                    defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m10515k());
                    if (m10515k() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (OptionSetDisplayModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8630h = defaultTextWithEntitiesFieldsModel;
                    }
                }
                if (m10516l() != null) {
                    defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m10516l());
                    if (m10516l() != defaultTextWithEntitiesFieldsModel) {
                        graphQLVisitableModel = (OptionSetDisplayModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8631i = defaultTextWithEntitiesFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10507a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10508a());
                int b = flatBufferBuilder.b(m10510b());
                int a2 = flatBufferBuilder.a(mo465c());
                int a3 = ModelHelper.a(flatBufferBuilder, m10514j());
                int a4 = ModelHelper.a(flatBufferBuilder, m10515k());
                int a5 = ModelHelper.a(flatBufferBuilder, m10516l());
                flatBufferBuilder.c(6);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, a3);
                flatBufferBuilder.b(4, a4);
                flatBufferBuilder.b(5, a5);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: must set swipe dismiss direction flags */
        public class Serializer extends JsonSerializer<NotifOptionSetFragmentModel> {
            public final void m10517a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                NotifOptionSetFragmentModel notifOptionSetFragmentModel = (NotifOptionSetFragmentModel) obj;
                if (notifOptionSetFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(notifOptionSetFragmentModel.m10519a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    notifOptionSetFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                NotifOptionSetFragmentParser.m10626b(notifOptionSetFragmentModel.w_(), notifOptionSetFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(NotifOptionSetFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ NotifOptions mo467c() {
            return m10525j();
        }

        @Nullable
        public final /* synthetic */ OptionSetDisplayModel mo468d() {
            return m10526k();
        }

        public NotifOptionSetFragmentModel() {
            super(3);
        }

        public NotifOptionSetFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(3);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String mo466b() {
            this.f8632d = super.a(this.f8632d, 0);
            return this.f8632d;
        }

        @Nullable
        public final NotifOptionsModel m10525j() {
            this.f8633e = (NotifOptionsModel) super.a(this.f8633e, 1, NotifOptionsModel.class);
            return this.f8633e;
        }

        @Nullable
        public final OptionSetDisplayModel m10526k() {
            this.f8634f = (OptionSetDisplayModel) super.a(this.f8634f, 2, OptionSetDisplayModel.class);
            return this.f8634f;
        }

        public static NotifOptionSetFragmentModel m10518a(NotifOptionSetFragment notifOptionSetFragment) {
            if (notifOptionSetFragment == null) {
                return null;
            }
            if (notifOptionSetFragment instanceof NotifOptionSetFragmentModel) {
                return (NotifOptionSetFragmentModel) notifOptionSetFragment;
            }
            Builder builder = new Builder();
            builder.f8597a = notifOptionSetFragment.mo466b();
            builder.f8598b = NotifOptionsModel.m10498a(notifOptionSetFragment.mo467c());
            builder.f8599c = OptionSetDisplayModel.m10506a(notifOptionSetFragment.mo468d());
            return builder.m10473a();
        }

        @Nullable
        public final String m10521a() {
            return mo466b();
        }

        public final int jK_() {
            return 90414717;
        }

        public final GraphQLVisitableModel m10520a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10525j() != null) {
                NotifOptionsModel notifOptionsModel = (NotifOptionsModel) graphQLModelMutatingVisitor.b(m10525j());
                if (m10525j() != notifOptionsModel) {
                    graphQLVisitableModel = (NotifOptionSetFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8633e = notifOptionsModel;
                }
            }
            if (m10526k() != null) {
                OptionSetDisplayModel optionSetDisplayModel = (OptionSetDisplayModel) graphQLModelMutatingVisitor.b(m10526k());
                if (m10526k() != optionSetDisplayModel) {
                    graphQLVisitableModel = (NotifOptionSetFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8634f = optionSetDisplayModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10519a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(mo466b());
            int a = ModelHelper.a(flatBufferBuilder, m10525j());
            int a2 = ModelHelper.a(flatBufferBuilder, m10526k());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1599592347)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: must set swipe dismiss direction flags */
    public final class NotificationNodeSettingsQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel, NotifOptionSetFragment {
        @Nullable
        private GraphQLObjectType f8646d;
        @Nullable
        private String f8647e;
        @Nullable
        private NotifOptionsModel f8648f;
        @Nullable
        private OptionSetDisplayModel f8649g;

        /* compiled from: must set swipe dismiss direction flags */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NotificationNodeSettingsQueryModel.class, new Deserializer());
            }

            public Object m10527a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NotificationNodeSettingsQueryParser.m10633a(jsonParser);
                Object notificationNodeSettingsQueryModel = new NotificationNodeSettingsQueryModel();
                ((BaseModel) notificationNodeSettingsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (notificationNodeSettingsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) notificationNodeSettingsQueryModel).a();
                }
                return notificationNodeSettingsQueryModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1985995792)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: must set swipe dismiss direction flags */
        public final class NotifOptionsModel extends BaseModel implements GraphQLVisitableModel, NotifOptions {
            @Nullable
            private List<NodesModel> f8645d;

            /* compiled from: must set swipe dismiss direction flags */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NotifOptionsModel.class, new Deserializer());
                }

                public Object m10528a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NotificationNodeSettingsQueryParser.NotifOptionsParser.m10631a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object notifOptionsModel = new NotifOptionsModel();
                    ((BaseModel) notifOptionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (notifOptionsModel instanceof Postprocessable) {
                        return ((Postprocessable) notifOptionsModel).a();
                    }
                    return notifOptionsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 258948906)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: must set swipe dismiss direction flags */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, Nodes {
                @Nullable
                private ClientInfoModel f8641d;
                @Nullable
                private String f8642e;
                @Nullable
                private OptionDisplayModel f8643f;
                @Nullable
                private String f8644g;

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 388583969)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: must set swipe dismiss direction flags */
                public final class ClientInfoModel extends BaseModel implements GraphQLVisitableModel, ClientInfo, SubmenuOptionSetFragment {
                    @Nullable
                    private GraphQLObjectType f8635d;
                    @Nullable
                    private GraphQLNotifOptionClientActionType f8636e;
                    @Nullable
                    private DefaultTextWithEntitiesFieldsModel f8637f;
                    @Nullable
                    private String f8638g;
                    @Nullable
                    private List<NotifOptionSetFragmentModel> f8639h;
                    @Nullable
                    private String f8640i;

                    /* compiled from: must set swipe dismiss direction flags */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(ClientInfoModel.class, new Deserializer());
                        }

                        public Object m10529a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NotificationNodeSettingsQueryParser.NotifOptionsParser.NodesParser.ClientInfoParser.m10627a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object clientInfoModel = new ClientInfoModel();
                            ((BaseModel) clientInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (clientInfoModel instanceof Postprocessable) {
                                return ((Postprocessable) clientInfoModel).a();
                            }
                            return clientInfoModel;
                        }
                    }

                    /* compiled from: must set swipe dismiss direction flags */
                    public class Serializer extends JsonSerializer<ClientInfoModel> {
                        public final void m10530a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            ClientInfoModel clientInfoModel = (ClientInfoModel) obj;
                            if (clientInfoModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(clientInfoModel.m10532a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                clientInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NotificationNodeSettingsQueryParser.NotifOptionsParser.NodesParser.ClientInfoParser.m10628a(clientInfoModel.w_(), clientInfoModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(ClientInfoModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ DefaultTextWithEntitiesFields mo457d() {
                        return m10531j();
                    }

                    public ClientInfoModel() {
                        super(6);
                    }

                    @Nullable
                    public final GraphQLObjectType mo455a() {
                        if (this.b != null && this.f8635d == null) {
                            this.f8635d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f8635d;
                    }

                    @Nullable
                    public final GraphQLNotifOptionClientActionType mo456b() {
                        this.f8636e = (GraphQLNotifOptionClientActionType) super.b(this.f8636e, 1, GraphQLNotifOptionClientActionType.class, GraphQLNotifOptionClientActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f8636e;
                    }

                    @Nullable
                    private DefaultTextWithEntitiesFieldsModel m10531j() {
                        this.f8637f = (DefaultTextWithEntitiesFieldsModel) super.a(this.f8637f, 2, DefaultTextWithEntitiesFieldsModel.class);
                        return this.f8637f;
                    }

                    @Nullable
                    public final String gy_() {
                        this.f8638g = super.a(this.f8638g, 3);
                        return this.f8638g;
                    }

                    @Nonnull
                    public final ImmutableList<NotifOptionSetFragmentModel> mo454c() {
                        this.f8639h = super.a(this.f8639h, 4, NotifOptionSetFragmentModel.class);
                        return (ImmutableList) this.f8639h;
                    }

                    @Nullable
                    public final String mo458g() {
                        this.f8640i = super.a(this.f8640i, 5);
                        return this.f8640i;
                    }

                    public final int jK_() {
                        return -1672387034;
                    }

                    public final GraphQLVisitableModel m10534a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m10531j() != null) {
                            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m10531j());
                            if (m10531j() != defaultTextWithEntitiesFieldsModel) {
                                graphQLVisitableModel = (ClientInfoModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f8637f = defaultTextWithEntitiesFieldsModel;
                            }
                        }
                        if (mo454c() != null) {
                            Builder a = ModelHelper.a(mo454c(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                ClientInfoModel clientInfoModel = (ClientInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                                clientInfoModel.f8639h = a.b();
                                graphQLVisitableModel = clientInfoModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m10532a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, mo455a());
                        int a2 = flatBufferBuilder.a(mo456b());
                        int a3 = ModelHelper.a(flatBufferBuilder, m10531j());
                        int b = flatBufferBuilder.b(gy_());
                        int a4 = ModelHelper.a(flatBufferBuilder, mo454c());
                        int b2 = flatBufferBuilder.b(mo458g());
                        flatBufferBuilder.c(6);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, a2);
                        flatBufferBuilder.b(2, a3);
                        flatBufferBuilder.b(3, b);
                        flatBufferBuilder.b(4, a4);
                        flatBufferBuilder.b(5, b2);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: must set swipe dismiss direction flags */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m10539a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NotificationNodeSettingsQueryParser.NotifOptionsParser.NodesParser.m10629b(jsonParser, flatBufferBuilder));
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

                /* compiled from: must set swipe dismiss direction flags */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m10540a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m10543a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NotificationNodeSettingsQueryParser.NotifOptionsParser.NodesParser.m10630b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ ClientInfo mo460b() {
                    return m10541j();
                }

                @Nullable
                public final /* synthetic */ OptionDisplayModel mo462d() {
                    return m10542k();
                }

                public NodesModel() {
                    super(4);
                }

                @Nullable
                private ClientInfoModel m10541j() {
                    this.f8641d = (ClientInfoModel) super.a(this.f8641d, 0, ClientInfoModel.class);
                    return this.f8641d;
                }

                @Nullable
                public final String mo461c() {
                    this.f8642e = super.a(this.f8642e, 1);
                    return this.f8642e;
                }

                @Nullable
                private OptionDisplayModel m10542k() {
                    this.f8643f = (OptionDisplayModel) super.a(this.f8643f, 2, OptionDisplayModel.class);
                    return this.f8643f;
                }

                @Nullable
                public final String gx_() {
                    this.f8644g = super.a(this.f8644g, 3);
                    return this.f8644g;
                }

                @Nullable
                public final String m10545a() {
                    return mo461c();
                }

                public final int jK_() {
                    return -1261484123;
                }

                public final GraphQLVisitableModel m10544a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m10541j() != null) {
                        ClientInfoModel clientInfoModel = (ClientInfoModel) graphQLModelMutatingVisitor.b(m10541j());
                        if (m10541j() != clientInfoModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8641d = clientInfoModel;
                        }
                    }
                    if (m10542k() != null) {
                        OptionDisplayModel optionDisplayModel = (OptionDisplayModel) graphQLModelMutatingVisitor.b(m10542k());
                        if (m10542k() != optionDisplayModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8643f = optionDisplayModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m10543a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m10541j());
                    int b = flatBufferBuilder.b(mo461c());
                    int a2 = ModelHelper.a(flatBufferBuilder, m10542k());
                    int b2 = flatBufferBuilder.b(gx_());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, a2);
                    flatBufferBuilder.b(3, b2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: must set swipe dismiss direction flags */
            public class Serializer extends JsonSerializer<NotifOptionsModel> {
                public final void m10549a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NotifOptionsModel notifOptionsModel = (NotifOptionsModel) obj;
                    if (notifOptionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(notifOptionsModel.m10550a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        notifOptionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NotificationNodeSettingsQueryParser.NotifOptionsParser.m10632a(notifOptionsModel.w_(), notifOptionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NotifOptionsModel.class, new Serializer());
                }
            }

            public NotifOptionsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> mo464a() {
                this.f8645d = super.a(this.f8645d, 0, NodesModel.class);
                return (ImmutableList) this.f8645d;
            }

            public final int jK_() {
                return -438337761;
            }

            public final GraphQLVisitableModel m10551a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (mo464a() != null) {
                    Builder a = ModelHelper.a(mo464a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (NotifOptionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8645d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10550a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, mo464a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: must set swipe dismiss direction flags */
        public class Serializer extends JsonSerializer<NotificationNodeSettingsQueryModel> {
            public final void m10553a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NotificationNodeSettingsQueryModel notificationNodeSettingsQueryModel = (NotificationNodeSettingsQueryModel) obj;
                if (notificationNodeSettingsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(notificationNodeSettingsQueryModel.m10557a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    notificationNodeSettingsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = notificationNodeSettingsQueryModel.w_();
                int u_ = notificationNodeSettingsQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("notif_options");
                    NotificationNodeSettingsQueryParser.NotifOptionsParser.m10632a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 3);
                if (g != 0) {
                    jsonGenerator.a("option_set_display");
                    OptionSetDisplayParser.m10622a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NotificationNodeSettingsQueryModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ NotifOptions mo467c() {
            return m10555k();
        }

        @Nullable
        public final /* synthetic */ OptionSetDisplayModel mo468d() {
            return m10556l();
        }

        public NotificationNodeSettingsQueryModel() {
            super(4);
        }

        public final void m10560a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m10561a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m10554j() {
            if (this.b != null && this.f8646d == null) {
                this.f8646d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f8646d;
        }

        @Nullable
        public final String mo466b() {
            this.f8647e = super.a(this.f8647e, 1);
            return this.f8647e;
        }

        @Nullable
        private NotifOptionsModel m10555k() {
            this.f8648f = (NotifOptionsModel) super.a(this.f8648f, 2, NotifOptionsModel.class);
            return this.f8648f;
        }

        @Nullable
        private OptionSetDisplayModel m10556l() {
            this.f8649g = (OptionSetDisplayModel) super.a(this.f8649g, 3, OptionSetDisplayModel.class);
            return this.f8649g;
        }

        @Nullable
        public final String m10559a() {
            return mo466b();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m10558a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10555k() != null) {
                NotifOptionsModel notifOptionsModel = (NotifOptionsModel) graphQLModelMutatingVisitor.b(m10555k());
                if (m10555k() != notifOptionsModel) {
                    graphQLVisitableModel = (NotificationNodeSettingsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8648f = notifOptionsModel;
                }
            }
            if (m10556l() != null) {
                OptionSetDisplayModel optionSetDisplayModel = (OptionSetDisplayModel) graphQLModelMutatingVisitor.b(m10556l());
                if (m10556l() != optionSetDisplayModel) {
                    graphQLVisitableModel = (NotificationNodeSettingsQueryModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f8649g = optionSetDisplayModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10557a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10554j());
            int b = flatBufferBuilder.b(mo466b());
            int a2 = ModelHelper.a(flatBufferBuilder, m10555k());
            int a3 = ModelHelper.a(flatBufferBuilder, m10556l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, a3);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 232436868)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: must set swipe dismiss direction flags */
    public final class NotificationUserSettingsFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private NotifOptionSetsModel f8665d;

        /* compiled from: must set swipe dismiss direction flags */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NotificationUserSettingsFragmentModel.class, new Deserializer());
            }

            public Object m10565a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NotificationUserSettingsFragmentParser.m10644a(jsonParser);
                Object notificationUserSettingsFragmentModel = new NotificationUserSettingsFragmentModel();
                ((BaseModel) notificationUserSettingsFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (notificationUserSettingsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) notificationUserSettingsFragmentModel).a();
                }
                return notificationUserSettingsFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 2048444692)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: must set swipe dismiss direction flags */
        public final class NotifOptionSetsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<NodesModel> f8664d;

            /* compiled from: must set swipe dismiss direction flags */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NotifOptionSetsModel.class, new Deserializer());
                }

                public Object m10566a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NotifOptionSetsParser.m10642a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object notifOptionSetsModel = new NotifOptionSetsModel();
                    ((BaseModel) notifOptionSetsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (notifOptionSetsModel instanceof Postprocessable) {
                        return ((Postprocessable) notifOptionSetsModel).a();
                    }
                    return notifOptionSetsModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -771445302)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: must set swipe dismiss direction flags */
            public final class NodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, NotifOptionSetFragment {
                @Nullable
                private String f8661d;
                @Nullable
                private NotifOptionsModel f8662e;
                @Nullable
                private OptionSetDisplayModel f8663f;

                /* compiled from: must set swipe dismiss direction flags */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NodesModel.class, new Deserializer());
                    }

                    public Object m10567a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NotifOptionSetsParser.NodesParser.m10640b(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = -37450351)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: must set swipe dismiss direction flags */
                public final class NotifOptionsModel extends BaseModel implements GraphQLVisitableModel, NotifOptions {
                    @Nullable
                    private List<NotifOptionsNodesModel> f8660d;

                    /* compiled from: must set swipe dismiss direction flags */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NotifOptionsModel.class, new Deserializer());
                        }

                        public Object m10568a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NotifOptionSetsParser.NodesParser.NotifOptionsParser.m10638a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object notifOptionsModel = new NotifOptionsModel();
                            ((BaseModel) notifOptionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (notifOptionsModel instanceof Postprocessable) {
                                return ((Postprocessable) notifOptionsModel).a();
                            }
                            return notifOptionsModel;
                        }
                    }

                    @JsonDeserialize(using = Deserializer.class)
                    @ModelWithFlatBufferFormatHash(a = -1749491923)
                    @JsonSerialize(using = Serializer.class)
                    @FragmentModelWithoutBridge
                    /* compiled from: must set swipe dismiss direction flags */
                    public final class NotifOptionsNodesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, Nodes {
                        @Nullable
                        private ClientInfoModel f8656d;
                        @Nullable
                        private String f8657e;
                        @Nullable
                        private OptionDisplayModel f8658f;
                        @Nullable
                        private String f8659g;

                        @JsonDeserialize(using = Deserializer.class)
                        @ModelWithFlatBufferFormatHash(a = 388583969)
                        @JsonSerialize(using = Serializer.class)
                        @FragmentModelWithoutBridge
                        /* compiled from: must set swipe dismiss direction flags */
                        public final class ClientInfoModel extends BaseModel implements GraphQLVisitableModel, ClientInfo, SubmenuOptionSetFragment {
                            @Nullable
                            private GraphQLObjectType f8650d;
                            @Nullable
                            private GraphQLNotifOptionClientActionType f8651e;
                            @Nullable
                            private DefaultTextWithEntitiesFieldsModel f8652f;
                            @Nullable
                            private String f8653g;
                            @Nullable
                            private List<NotifOptionSetFragmentModel> f8654h;
                            @Nullable
                            private String f8655i;

                            /* compiled from: must set swipe dismiss direction flags */
                            public class Deserializer extends FbJsonDeserializer {
                                static {
                                    GlobalAutoGenDeserializerCache.a(ClientInfoModel.class, new Deserializer());
                                }

                                public Object m10569a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(NotifOptionsNodesParser.ClientInfoParser.m10634a(jsonParser, flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                    Object clientInfoModel = new ClientInfoModel();
                                    ((BaseModel) clientInfoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                    if (clientInfoModel instanceof Postprocessable) {
                                        return ((Postprocessable) clientInfoModel).a();
                                    }
                                    return clientInfoModel;
                                }
                            }

                            /* compiled from: must set swipe dismiss direction flags */
                            public class Serializer extends JsonSerializer<ClientInfoModel> {
                                public final void m10570a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                    ClientInfoModel clientInfoModel = (ClientInfoModel) obj;
                                    if (clientInfoModel.w_() == null) {
                                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                        flatBufferBuilder.d(clientInfoModel.m10572a(flatBufferBuilder));
                                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                        wrap.position(0);
                                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                        clientInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                    }
                                    NotifOptionsNodesParser.ClientInfoParser.m10635a(clientInfoModel.w_(), clientInfoModel.u_(), jsonGenerator, serializerProvider);
                                }

                                static {
                                    FbSerializerProvider.a(ClientInfoModel.class, new Serializer());
                                }
                            }

                            @Nullable
                            public final /* synthetic */ DefaultTextWithEntitiesFields mo457d() {
                                return m10571j();
                            }

                            public ClientInfoModel() {
                                super(6);
                            }

                            @Nullable
                            public final GraphQLObjectType mo455a() {
                                if (this.b != null && this.f8650d == null) {
                                    this.f8650d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                                }
                                return this.f8650d;
                            }

                            @Nullable
                            public final GraphQLNotifOptionClientActionType mo456b() {
                                this.f8651e = (GraphQLNotifOptionClientActionType) super.b(this.f8651e, 1, GraphQLNotifOptionClientActionType.class, GraphQLNotifOptionClientActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                                return this.f8651e;
                            }

                            @Nullable
                            private DefaultTextWithEntitiesFieldsModel m10571j() {
                                this.f8652f = (DefaultTextWithEntitiesFieldsModel) super.a(this.f8652f, 2, DefaultTextWithEntitiesFieldsModel.class);
                                return this.f8652f;
                            }

                            @Nullable
                            public final String gy_() {
                                this.f8653g = super.a(this.f8653g, 3);
                                return this.f8653g;
                            }

                            @Nonnull
                            public final ImmutableList<NotifOptionSetFragmentModel> mo454c() {
                                this.f8654h = super.a(this.f8654h, 4, NotifOptionSetFragmentModel.class);
                                return (ImmutableList) this.f8654h;
                            }

                            @Nullable
                            public final String mo458g() {
                                this.f8655i = super.a(this.f8655i, 5);
                                return this.f8655i;
                            }

                            public final int jK_() {
                                return -1672387034;
                            }

                            public final GraphQLVisitableModel m10574a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                                GraphQLVisitableModel graphQLVisitableModel = null;
                                h();
                                if (m10571j() != null) {
                                    DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m10571j());
                                    if (m10571j() != defaultTextWithEntitiesFieldsModel) {
                                        graphQLVisitableModel = (ClientInfoModel) ModelHelper.a(null, this);
                                        graphQLVisitableModel.f8652f = defaultTextWithEntitiesFieldsModel;
                                    }
                                }
                                if (mo454c() != null) {
                                    Builder a = ModelHelper.a(mo454c(), graphQLModelMutatingVisitor);
                                    if (a != null) {
                                        ClientInfoModel clientInfoModel = (ClientInfoModel) ModelHelper.a(graphQLVisitableModel, this);
                                        clientInfoModel.f8654h = a.b();
                                        graphQLVisitableModel = clientInfoModel;
                                    }
                                }
                                i();
                                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                            }

                            public final int m10572a(FlatBufferBuilder flatBufferBuilder) {
                                h();
                                int a = ModelHelper.a(flatBufferBuilder, mo455a());
                                int a2 = flatBufferBuilder.a(mo456b());
                                int a3 = ModelHelper.a(flatBufferBuilder, m10571j());
                                int b = flatBufferBuilder.b(gy_());
                                int a4 = ModelHelper.a(flatBufferBuilder, mo454c());
                                int b2 = flatBufferBuilder.b(mo458g());
                                flatBufferBuilder.c(6);
                                flatBufferBuilder.b(0, a);
                                flatBufferBuilder.b(1, a2);
                                flatBufferBuilder.b(2, a3);
                                flatBufferBuilder.b(3, b);
                                flatBufferBuilder.b(4, a4);
                                flatBufferBuilder.b(5, b2);
                                i();
                                return flatBufferBuilder.d();
                            }
                        }

                        /* compiled from: must set swipe dismiss direction flags */
                        public class Deserializer extends FbJsonDeserializer {
                            static {
                                GlobalAutoGenDeserializerCache.a(NotifOptionsNodesModel.class, new Deserializer());
                            }

                            public Object m10579a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(NotifOptionsNodesParser.m10636b(jsonParser, flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                                Object notifOptionsNodesModel = new NotifOptionsNodesModel();
                                ((BaseModel) notifOptionsNodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                                if (notifOptionsNodesModel instanceof Postprocessable) {
                                    return ((Postprocessable) notifOptionsNodesModel).a();
                                }
                                return notifOptionsNodesModel;
                            }
                        }

                        /* compiled from: must set swipe dismiss direction flags */
                        public class Serializer extends JsonSerializer<NotifOptionsNodesModel> {
                            public final void m10580a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                                NotifOptionsNodesModel notifOptionsNodesModel = (NotifOptionsNodesModel) obj;
                                if (notifOptionsNodesModel.w_() == null) {
                                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                    flatBufferBuilder.d(notifOptionsNodesModel.m10583a(flatBufferBuilder));
                                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                    wrap.position(0);
                                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                    notifOptionsNodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                                }
                                NotifOptionsNodesParser.m10637b(notifOptionsNodesModel.w_(), notifOptionsNodesModel.u_(), jsonGenerator, serializerProvider);
                            }

                            static {
                                FbSerializerProvider.a(NotifOptionsNodesModel.class, new Serializer());
                            }
                        }

                        @Nullable
                        public final /* synthetic */ ClientInfo mo460b() {
                            return m10581j();
                        }

                        @Nullable
                        public final /* synthetic */ OptionDisplayModel mo462d() {
                            return m10582k();
                        }

                        public NotifOptionsNodesModel() {
                            super(4);
                        }

                        @Nullable
                        private ClientInfoModel m10581j() {
                            this.f8656d = (ClientInfoModel) super.a(this.f8656d, 0, ClientInfoModel.class);
                            return this.f8656d;
                        }

                        @Nullable
                        public final String mo461c() {
                            this.f8657e = super.a(this.f8657e, 1);
                            return this.f8657e;
                        }

                        @Nullable
                        private OptionDisplayModel m10582k() {
                            this.f8658f = (OptionDisplayModel) super.a(this.f8658f, 2, OptionDisplayModel.class);
                            return this.f8658f;
                        }

                        @Nullable
                        public final String gx_() {
                            this.f8659g = super.a(this.f8659g, 3);
                            return this.f8659g;
                        }

                        @Nullable
                        public final String m10585a() {
                            return mo461c();
                        }

                        public final int jK_() {
                            return -1261484123;
                        }

                        public final GraphQLVisitableModel m10584a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                            GraphQLVisitableModel graphQLVisitableModel = null;
                            h();
                            if (m10581j() != null) {
                                ClientInfoModel clientInfoModel = (ClientInfoModel) graphQLModelMutatingVisitor.b(m10581j());
                                if (m10581j() != clientInfoModel) {
                                    graphQLVisitableModel = (NotifOptionsNodesModel) ModelHelper.a(null, this);
                                    graphQLVisitableModel.f8656d = clientInfoModel;
                                }
                            }
                            if (m10582k() != null) {
                                OptionDisplayModel optionDisplayModel = (OptionDisplayModel) graphQLModelMutatingVisitor.b(m10582k());
                                if (m10582k() != optionDisplayModel) {
                                    graphQLVisitableModel = (NotifOptionsNodesModel) ModelHelper.a(graphQLVisitableModel, this);
                                    graphQLVisitableModel.f8658f = optionDisplayModel;
                                }
                            }
                            i();
                            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                        }

                        public final int m10583a(FlatBufferBuilder flatBufferBuilder) {
                            h();
                            int a = ModelHelper.a(flatBufferBuilder, m10581j());
                            int b = flatBufferBuilder.b(mo461c());
                            int a2 = ModelHelper.a(flatBufferBuilder, m10582k());
                            int b2 = flatBufferBuilder.b(gx_());
                            flatBufferBuilder.c(4);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.b(1, b);
                            flatBufferBuilder.b(2, a2);
                            flatBufferBuilder.b(3, b2);
                            i();
                            return flatBufferBuilder.d();
                        }
                    }

                    /* compiled from: must set swipe dismiss direction flags */
                    public class Serializer extends JsonSerializer<NotifOptionsModel> {
                        public final void m10589a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NotifOptionsModel notifOptionsModel = (NotifOptionsModel) obj;
                            if (notifOptionsModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(notifOptionsModel.m10590a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                notifOptionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NotifOptionSetsParser.NodesParser.NotifOptionsParser.m10639a(notifOptionsModel.w_(), notifOptionsModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NotifOptionsModel.class, new Serializer());
                        }
                    }

                    public NotifOptionsModel() {
                        super(1);
                    }

                    @Nonnull
                    public final ImmutableList<NotifOptionsNodesModel> mo464a() {
                        this.f8660d = super.a(this.f8660d, 0, NotifOptionsNodesModel.class);
                        return (ImmutableList) this.f8660d;
                    }

                    public final int jK_() {
                        return -438337761;
                    }

                    public final GraphQLVisitableModel m10591a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (mo464a() != null) {
                            Builder a = ModelHelper.a(mo464a(), graphQLModelMutatingVisitor);
                            if (a != null) {
                                graphQLVisitableModel = (NotifOptionsModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f8660d = a.b();
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m10590a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, mo464a());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: must set swipe dismiss direction flags */
                public class Serializer extends JsonSerializer<NodesModel> {
                    public final void m10593a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NodesModel nodesModel = (NodesModel) obj;
                        if (nodesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(nodesModel.m10596a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            nodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NotifOptionSetsParser.NodesParser.m10641b(nodesModel.w_(), nodesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(NodesModel.class, new Serializer());
                    }
                }

                @Nullable
                public final /* synthetic */ NotifOptions mo467c() {
                    return m10594j();
                }

                @Nullable
                public final /* synthetic */ OptionSetDisplayModel mo468d() {
                    return m10595k();
                }

                public NodesModel() {
                    super(3);
                }

                @Nullable
                public final String mo466b() {
                    this.f8661d = super.a(this.f8661d, 0);
                    return this.f8661d;
                }

                @Nullable
                private NotifOptionsModel m10594j() {
                    this.f8662e = (NotifOptionsModel) super.a(this.f8662e, 1, NotifOptionsModel.class);
                    return this.f8662e;
                }

                @Nullable
                private OptionSetDisplayModel m10595k() {
                    this.f8663f = (OptionSetDisplayModel) super.a(this.f8663f, 2, OptionSetDisplayModel.class);
                    return this.f8663f;
                }

                @Nullable
                public final String m10598a() {
                    return mo466b();
                }

                public final int jK_() {
                    return 90414717;
                }

                public final GraphQLVisitableModel m10597a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m10594j() != null) {
                        NotifOptionsModel notifOptionsModel = (NotifOptionsModel) graphQLModelMutatingVisitor.b(m10594j());
                        if (m10594j() != notifOptionsModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8662e = notifOptionsModel;
                        }
                    }
                    if (m10595k() != null) {
                        OptionSetDisplayModel optionSetDisplayModel = (OptionSetDisplayModel) graphQLModelMutatingVisitor.b(m10595k());
                        if (m10595k() != optionSetDisplayModel) {
                            graphQLVisitableModel = (NodesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f8663f = optionSetDisplayModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m10596a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(mo466b());
                    int a = ModelHelper.a(flatBufferBuilder, m10594j());
                    int a2 = ModelHelper.a(flatBufferBuilder, m10595k());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.b(1, a);
                    flatBufferBuilder.b(2, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: must set swipe dismiss direction flags */
            public class Serializer extends JsonSerializer<NotifOptionSetsModel> {
                public final void m10602a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NotifOptionSetsModel notifOptionSetsModel = (NotifOptionSetsModel) obj;
                    if (notifOptionSetsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(notifOptionSetsModel.m10603a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        notifOptionSetsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NotifOptionSetsParser.m10643a(notifOptionSetsModel.w_(), notifOptionSetsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NotifOptionSetsModel.class, new Serializer());
                }
            }

            public NotifOptionSetsModel() {
                super(1);
            }

            @Nonnull
            public final ImmutableList<NodesModel> m10605a() {
                this.f8664d = super.a(this.f8664d, 0, NodesModel.class);
                return (ImmutableList) this.f8664d;
            }

            public final int jK_() {
                return -195229343;
            }

            public final GraphQLVisitableModel m10604a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10605a() != null) {
                    Builder a = ModelHelper.a(m10605a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (NotifOptionSetsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8664d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10603a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10605a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: must set swipe dismiss direction flags */
        public class Serializer extends JsonSerializer<NotificationUserSettingsFragmentModel> {
            public final void m10606a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NotificationUserSettingsFragmentModel notificationUserSettingsFragmentModel = (NotificationUserSettingsFragmentModel) obj;
                if (notificationUserSettingsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(notificationUserSettingsFragmentModel.m10607a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    notificationUserSettingsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = notificationUserSettingsFragmentModel.w_();
                int u_ = notificationUserSettingsFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("notif_option_sets");
                    NotifOptionSetsParser.m10643a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NotificationUserSettingsFragmentModel.class, new Serializer());
            }
        }

        public NotificationUserSettingsFragmentModel() {
            super(1);
        }

        @Nullable
        public final NotifOptionSetsModel m10609a() {
            this.f8665d = (NotifOptionSetsModel) super.a(this.f8665d, 0, NotifOptionSetsModel.class);
            return this.f8665d;
        }

        public final int jK_() {
            return -1110788614;
        }

        public final GraphQLVisitableModel m10608a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10609a() != null) {
                NotifOptionSetsModel notifOptionSetsModel = (NotifOptionSetsModel) graphQLModelMutatingVisitor.b(m10609a());
                if (m10609a() != notifOptionSetsModel) {
                    graphQLVisitableModel = (NotificationUserSettingsFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8665d = notifOptionSetsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10607a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10609a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

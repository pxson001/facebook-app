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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLModels.NotifInlineActionOptionFragmentModel;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationsEdgeFieldsParser.NotifOptionSetsParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationsEdgeFieldsParser.NotifOptionSetsParser.EdgesParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationsEdgeFieldsParser.NotifOptionSetsParser.EdgesParser.NodeParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationsEdgeFieldsParser.NotifOptionSetsParser.EdgesParser.NodeParser.NotifOptionsParser;
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationsEdgeFieldsParser.NotifOptionSetsParser.EdgesParser.NodeParser.NotifOptionsParser.NotifOptionsEdgesParser;
import com.facebook.notifications.protocol.NotificationsOptionRowCommonGraphQLInterfaces.StyleOnlyNotifOptionSetDisplayFragment;
import com.facebook.notifications.protocol.NotificationsOptionRowCommonGraphQLModels.StyleOnlyNotifOptionSetDisplayFragmentModel;
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
@ModelWithFlatBufferFormatHash(a = -314753560)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: negativeFeedbackActionOnReportableEntity */
public final class C0694xee63252d extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private List<EdgesModel> f8545d;

    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public final class Builder {
        @Nullable
        public ImmutableList<EdgesModel> f8534a;

        public static Builder m10212a(C0694xee63252d c0694xee63252d) {
            Builder builder = new Builder();
            builder.f8534a = c0694xee63252d.m10256a();
            return builder;
        }

        public final C0694xee63252d m10213a() {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a = ModelHelper.a(flatBufferBuilder, this.f8534a);
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            return new C0694xee63252d(new MutableFlatBuffer(wrap, null, null, true, null));
        }
    }

    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0694xee63252d.class, new Deserializer());
        }

        public Object m10214a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(NotifOptionSetsParser.m10309a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0694xee63252d = new C0694xee63252d();
            ((BaseModel) c0694xee63252d).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0694xee63252d instanceof Postprocessable) {
                return ((Postprocessable) c0694xee63252d).a();
            }
            return c0694xee63252d;
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1790438857)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private NodeModel f8544d;

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class Builder {
            @Nullable
            public NodeModel f8535a;

            public static Builder m10215a(EdgesModel edgesModel) {
                Builder builder = new Builder();
                builder.f8535a = edgesModel.m10251j();
                return builder;
            }

            public final EdgesModel m10216a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f8535a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
            }

            public Object m10217a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(EdgesParser.m10307b(jsonParser, flatBufferBuilder));
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
        @ModelWithFlatBufferFormatHash(a = -317630483)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public final class NodeModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private NotifOptionsModel f8542d;
            @Nullable
            private StyleOnlyNotifOptionSetDisplayFragmentModel f8543e;

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public final class Builder {
                @Nullable
                public NotifOptionsModel f8536a;
                @Nullable
                public StyleOnlyNotifOptionSetDisplayFragmentModel f8537b;

                public static Builder m10218a(NodeModel nodeModel) {
                    Builder builder = new Builder();
                    builder.f8536a = nodeModel.m10244j();
                    builder.f8537b = nodeModel.m10245k();
                    return builder;
                }

                public final NodeModel m10219a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f8536a);
                    int a2 = ModelHelper.a(flatBufferBuilder, this.f8537b);
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new NodeModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(NodeModel.class, new Deserializer());
                }

                public Object m10220a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(NodeParser.m10305a(jsonParser, flatBufferBuilder));
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
            @ModelWithFlatBufferFormatHash(a = -127937190)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public final class NotifOptionsModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<NotifOptionsEdgesModel> f8541d;

                /* compiled from: negativeFeedbackActionOnReportableEntity */
                public final class Builder {
                    @Nullable
                    public ImmutableList<NotifOptionsEdgesModel> f8538a;

                    public static Builder m10221a(NotifOptionsModel notifOptionsModel) {
                        Builder builder = new Builder();
                        builder.f8538a = notifOptionsModel.m10237a();
                        return builder;
                    }

                    public final NotifOptionsModel m10222a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f8538a);
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new NotifOptionsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: negativeFeedbackActionOnReportableEntity */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(NotifOptionsModel.class, new Deserializer());
                    }

                    public Object m10223a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(NotifOptionsParser.m10303a(jsonParser, flatBufferBuilder));
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
                @ModelWithFlatBufferFormatHash(a = 469729512)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: negativeFeedbackActionOnReportableEntity */
                public final class NotifOptionsEdgesModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private NotifInlineActionOptionFragmentModel f8540d;

                    /* compiled from: negativeFeedbackActionOnReportableEntity */
                    public final class Builder {
                        @Nullable
                        public NotifInlineActionOptionFragmentModel f8539a;

                        public static Builder m10224a(NotifOptionsEdgesModel notifOptionsEdgesModel) {
                            Builder builder = new Builder();
                            builder.f8539a = notifOptionsEdgesModel.m10232j();
                            return builder;
                        }

                        public final NotifOptionsEdgesModel m10225a() {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            int a = ModelHelper.a(flatBufferBuilder, this.f8539a);
                            flatBufferBuilder.c(1);
                            flatBufferBuilder.b(0, a);
                            flatBufferBuilder.d(flatBufferBuilder.d());
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            return new NotifOptionsEdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                        }
                    }

                    /* compiled from: negativeFeedbackActionOnReportableEntity */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(NotifOptionsEdgesModel.class, new Deserializer());
                        }

                        public Object m10226a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(NotifOptionsEdgesParser.m10301b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object notifOptionsEdgesModel = new NotifOptionsEdgesModel();
                            ((BaseModel) notifOptionsEdgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (notifOptionsEdgesModel instanceof Postprocessable) {
                                return ((Postprocessable) notifOptionsEdgesModel).a();
                            }
                            return notifOptionsEdgesModel;
                        }
                    }

                    /* compiled from: negativeFeedbackActionOnReportableEntity */
                    public class Serializer extends JsonSerializer<NotifOptionsEdgesModel> {
                        public final void m10227a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            NotifOptionsEdgesModel notifOptionsEdgesModel = (NotifOptionsEdgesModel) obj;
                            if (notifOptionsEdgesModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(notifOptionsEdgesModel.m10229a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                notifOptionsEdgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            NotifOptionsEdgesParser.m10302b(notifOptionsEdgesModel.w_(), notifOptionsEdgesModel.u_(), jsonGenerator, serializerProvider);
                        }

                        static {
                            FbSerializerProvider.a(NotifOptionsEdgesModel.class, new Serializer());
                        }
                    }

                    @Nullable
                    public final /* synthetic */ NotifInlineActionOptionFragmentModel m10231a() {
                        return m10232j();
                    }

                    public NotifOptionsEdgesModel() {
                        super(1);
                    }

                    public NotifOptionsEdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                        super(1);
                        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }

                    @Nullable
                    public final NotifInlineActionOptionFragmentModel m10232j() {
                        this.f8540d = (NotifInlineActionOptionFragmentModel) super.a(this.f8540d, 0, NotifInlineActionOptionFragmentModel.class);
                        return this.f8540d;
                    }

                    public static NotifOptionsEdgesModel m10228a(NotifOptionsEdgesModel notifOptionsEdgesModel) {
                        if (notifOptionsEdgesModel == null) {
                            return null;
                        }
                        if (notifOptionsEdgesModel instanceof NotifOptionsEdgesModel) {
                            return notifOptionsEdgesModel;
                        }
                        Builder builder = new Builder();
                        builder.f8539a = NotifInlineActionOptionFragmentModel.m10097a(notifOptionsEdgesModel.m10231a());
                        return builder.m10225a();
                    }

                    public final int jK_() {
                        return -2086931778;
                    }

                    public final GraphQLVisitableModel m10230a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        GraphQLVisitableModel graphQLVisitableModel = null;
                        h();
                        if (m10232j() != null) {
                            NotifInlineActionOptionFragmentModel notifInlineActionOptionFragmentModel = (NotifInlineActionOptionFragmentModel) graphQLModelMutatingVisitor.b(m10232j());
                            if (m10232j() != notifInlineActionOptionFragmentModel) {
                                graphQLVisitableModel = (NotifOptionsEdgesModel) ModelHelper.a(null, this);
                                graphQLVisitableModel.f8540d = notifInlineActionOptionFragmentModel;
                            }
                        }
                        i();
                        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                    }

                    public final int m10229a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m10232j());
                        flatBufferBuilder.c(1);
                        flatBufferBuilder.b(0, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: negativeFeedbackActionOnReportableEntity */
                public class Serializer extends JsonSerializer<NotifOptionsModel> {
                    public final void m10233a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        NotifOptionsModel notifOptionsModel = (NotifOptionsModel) obj;
                        if (notifOptionsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(notifOptionsModel.m10235a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            notifOptionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        NotifOptionsParser.m10304a(notifOptionsModel.w_(), notifOptionsModel.u_(), jsonGenerator, serializerProvider);
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
                public final ImmutableList<NotifOptionsEdgesModel> m10237a() {
                    this.f8541d = super.a(this.f8541d, 0, NotifOptionsEdgesModel.class);
                    return (ImmutableList) this.f8541d;
                }

                public static NotifOptionsModel m10234a(NotifOptionsModel notifOptionsModel) {
                    if (notifOptionsModel == null) {
                        return null;
                    }
                    if (notifOptionsModel instanceof NotifOptionsModel) {
                        return notifOptionsModel;
                    }
                    Builder builder = new Builder();
                    Builder builder2 = ImmutableList.builder();
                    for (int i = 0; i < notifOptionsModel.m10237a().size(); i++) {
                        builder2.c(NotifOptionsEdgesModel.m10228a((NotifOptionsEdgesModel) notifOptionsModel.m10237a().get(i)));
                    }
                    builder.f8538a = builder2.b();
                    return builder.m10222a();
                }

                public final int jK_() {
                    return -438337761;
                }

                public final GraphQLVisitableModel m10236a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m10237a() != null) {
                        Builder a = ModelHelper.a(m10237a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (NotifOptionsModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f8541d = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m10235a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m10237a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: negativeFeedbackActionOnReportableEntity */
            public class Serializer extends JsonSerializer<NodeModel> {
                public final void m10238a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    NodeModel nodeModel = (NodeModel) obj;
                    if (nodeModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(nodeModel.m10240a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        nodeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    NodeParser.m10306a(nodeModel.w_(), nodeModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(NodeModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ NotifOptionsModel m10242a() {
                return m10244j();
            }

            @Nullable
            public final /* synthetic */ StyleOnlyNotifOptionSetDisplayFragment m10243b() {
                return m10245k();
            }

            public NodeModel() {
                super(2);
            }

            public NodeModel(MutableFlatBuffer mutableFlatBuffer) {
                super(2);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final NotifOptionsModel m10244j() {
                this.f8542d = (NotifOptionsModel) super.a(this.f8542d, 0, NotifOptionsModel.class);
                return this.f8542d;
            }

            @Nullable
            public final StyleOnlyNotifOptionSetDisplayFragmentModel m10245k() {
                this.f8543e = (StyleOnlyNotifOptionSetDisplayFragmentModel) super.a(this.f8543e, 1, StyleOnlyNotifOptionSetDisplayFragmentModel.class);
                return this.f8543e;
            }

            public static NodeModel m10239a(NodeModel nodeModel) {
                if (nodeModel == null) {
                    return null;
                }
                if (nodeModel instanceof NodeModel) {
                    return nodeModel;
                }
                Builder builder = new Builder();
                builder.f8536a = NotifOptionsModel.m10234a(nodeModel.m10242a());
                builder.f8537b = StyleOnlyNotifOptionSetDisplayFragmentModel.m10650a(nodeModel.m10243b());
                return builder.m10219a();
            }

            public final int jK_() {
                return 90414717;
            }

            public final GraphQLVisitableModel m10241a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10244j() != null) {
                    NotifOptionsModel notifOptionsModel = (NotifOptionsModel) graphQLModelMutatingVisitor.b(m10244j());
                    if (m10244j() != notifOptionsModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f8542d = notifOptionsModel;
                    }
                }
                if (m10245k() != null) {
                    StyleOnlyNotifOptionSetDisplayFragmentModel styleOnlyNotifOptionSetDisplayFragmentModel = (StyleOnlyNotifOptionSetDisplayFragmentModel) graphQLModelMutatingVisitor.b(m10245k());
                    if (m10245k() != styleOnlyNotifOptionSetDisplayFragmentModel) {
                        graphQLVisitableModel = (NodeModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f8543e = styleOnlyNotifOptionSetDisplayFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10240a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10244j());
                int a2 = ModelHelper.a(flatBufferBuilder, m10245k());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: negativeFeedbackActionOnReportableEntity */
        public class Serializer extends JsonSerializer<EdgesModel> {
            public final void m10246a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                EdgesModel edgesModel = (EdgesModel) obj;
                if (edgesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(edgesModel.m10248a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                EdgesParser.m10308b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(EdgesModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ NodeModel m10250a() {
            return m10251j();
        }

        public EdgesModel() {
            super(1);
        }

        public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final NodeModel m10251j() {
            this.f8544d = (NodeModel) super.a(this.f8544d, 0, NodeModel.class);
            return this.f8544d;
        }

        public static EdgesModel m10247a(EdgesModel edgesModel) {
            if (edgesModel == null) {
                return null;
            }
            if (edgesModel instanceof EdgesModel) {
                return edgesModel;
            }
            Builder builder = new Builder();
            builder.f8535a = NodeModel.m10239a(edgesModel.m10250a());
            return builder.m10216a();
        }

        public final int jK_() {
            return 1607941773;
        }

        public final GraphQLVisitableModel m10249a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10251j() != null) {
                NodeModel nodeModel = (NodeModel) graphQLModelMutatingVisitor.b(m10251j());
                if (m10251j() != nodeModel) {
                    graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f8544d = nodeModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10248a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10251j());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public class Serializer extends JsonSerializer<C0694xee63252d> {
        public final void m10252a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0694xee63252d c0694xee63252d = (C0694xee63252d) obj;
            if (c0694xee63252d.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0694xee63252d.m10254a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0694xee63252d.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            NotifOptionSetsParser.m10310a(c0694xee63252d.w_(), c0694xee63252d.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(C0694xee63252d.class, new Serializer());
        }
    }

    public C0694xee63252d() {
        super(1);
    }

    public C0694xee63252d(MutableFlatBuffer mutableFlatBuffer) {
        super(1);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nonnull
    public final ImmutableList<EdgesModel> m10256a() {
        this.f8545d = super.a(this.f8545d, 0, EdgesModel.class);
        return (ImmutableList) this.f8545d;
    }

    public static C0694xee63252d m10253a(C0694xee63252d c0694xee63252d) {
        if (c0694xee63252d == null) {
            return null;
        }
        if (c0694xee63252d instanceof C0694xee63252d) {
            return c0694xee63252d;
        }
        Builder builder = new Builder();
        Builder builder2 = ImmutableList.builder();
        for (int i = 0; i < c0694xee63252d.m10256a().size(); i++) {
            builder2.c(EdgesModel.m10247a((EdgesModel) c0694xee63252d.m10256a().get(i)));
        }
        builder.f8534a = builder2.b();
        return builder.m10213a();
    }

    public final int jK_() {
        return -1553960018;
    }

    public final GraphQLVisitableModel m10255a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m10256a() != null) {
            Builder a = ModelHelper.a(m10256a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (C0694xee63252d) ModelHelper.a(null, this);
                graphQLVisitableModel.f8545d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public final int m10254a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m10256a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }
}

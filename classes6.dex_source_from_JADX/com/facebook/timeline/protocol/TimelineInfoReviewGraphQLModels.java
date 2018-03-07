package com.facebook.timeline.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.identitygrowth.protocol.ProfileQuestionGraphQLModels.ProfileQuestionFragmentModel;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLParsers.InfoReviewItemFragmentParser;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLParsers.InfoReviewItemsFragmentParser;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLParsers.InfoReviewOverflowLinkParser;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLParsers.TimelineInfoReviewQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: date_added */
public class TimelineInfoReviewGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 73531901)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: date_added */
    public final class InfoReviewItemFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f17869d;
        @Nullable
        private DefaultImageFieldsModel f17870e;
        @Nullable
        private String f17871f;
        private boolean f17872g;
        @Nullable
        private String f17873h;
        @Nullable
        private ProfileQuestionFragmentModel f17874i;
        @Nullable
        private String f17875j;
        @Nullable
        private String f17876k;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f17877l;
        @Nullable
        private String f17878m;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f17879n;

        /* compiled from: date_added */
        public final class Builder {
            @Nullable
            public GraphQLObjectType f17858a;
            @Nullable
            public DefaultImageFieldsModel f17859b;
            @Nullable
            public String f17860c;
            public boolean f17861d;
            @Nullable
            public String f17862e;
            @Nullable
            public ProfileQuestionFragmentModel f17863f;
            @Nullable
            public String f17864g;
            @Nullable
            public String f17865h;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f17866i;
            @Nullable
            public String f17867j;
            @Nullable
            public DefaultTextWithEntitiesFieldsModel f17868k;

            public final InfoReviewItemFragmentModel m26334a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f17858a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f17859b);
                int b = flatBufferBuilder.b(this.f17860c);
                int b2 = flatBufferBuilder.b(this.f17862e);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f17863f);
                int b3 = flatBufferBuilder.b(this.f17864g);
                int b4 = flatBufferBuilder.b(this.f17865h);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f17866i);
                int b5 = flatBufferBuilder.b(this.f17867j);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f17868k);
                flatBufferBuilder.c(11);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, b);
                flatBufferBuilder.a(3, this.f17861d);
                flatBufferBuilder.b(4, b2);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.b(6, b3);
                flatBufferBuilder.b(7, b4);
                flatBufferBuilder.b(8, a4);
                flatBufferBuilder.b(9, b5);
                flatBufferBuilder.b(10, a5);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new InfoReviewItemFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: date_added */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InfoReviewItemFragmentModel.class, new Deserializer());
            }

            public Object m26335a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InfoReviewItemFragmentParser.m26376b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object infoReviewItemFragmentModel = new InfoReviewItemFragmentModel();
                ((BaseModel) infoReviewItemFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (infoReviewItemFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) infoReviewItemFragmentModel).a();
                }
                return infoReviewItemFragmentModel;
            }
        }

        /* compiled from: date_added */
        public class Serializer extends JsonSerializer<InfoReviewItemFragmentModel> {
            public final void m26336a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InfoReviewItemFragmentModel infoReviewItemFragmentModel = (InfoReviewItemFragmentModel) obj;
                if (infoReviewItemFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(infoReviewItemFragmentModel.m26342a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    infoReviewItemFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InfoReviewItemFragmentParser.m26377b(infoReviewItemFragmentModel.w_(), infoReviewItemFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(InfoReviewItemFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m26347c() {
            return m26338n();
        }

        @Nullable
        public final /* synthetic */ ProfileQuestionFragmentModel dA_() {
            return m26339o();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m26351k() {
            return m26340p();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m26353m() {
            return m26341q();
        }

        public InfoReviewItemFragmentModel() {
            super(11);
        }

        public InfoReviewItemFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(11);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final GraphQLObjectType m26346b() {
            if (this.b != null && this.f17869d == null) {
                this.f17869d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f17869d;
        }

        @Nullable
        private DefaultImageFieldsModel m26338n() {
            this.f17870e = (DefaultImageFieldsModel) super.a(this.f17870e, 1, DefaultImageFieldsModel.class);
            return this.f17870e;
        }

        @Nullable
        public final String m26348d() {
            this.f17871f = super.a(this.f17871f, 2);
            return this.f17871f;
        }

        public final boolean dy_() {
            a(0, 3);
            return this.f17872g;
        }

        @Nullable
        public final String m26349g() {
            this.f17873h = super.a(this.f17873h, 4);
            return this.f17873h;
        }

        @Nullable
        private ProfileQuestionFragmentModel m26339o() {
            this.f17874i = (ProfileQuestionFragmentModel) super.a(this.f17874i, 5, ProfileQuestionFragmentModel.class);
            return this.f17874i;
        }

        @Nullable
        public final String dz_() {
            this.f17875j = super.a(this.f17875j, 6);
            return this.f17875j;
        }

        @Nullable
        public final String m26350j() {
            this.f17876k = super.a(this.f17876k, 7);
            return this.f17876k;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m26340p() {
            this.f17877l = (DefaultTextWithEntitiesFieldsModel) super.a(this.f17877l, 8, DefaultTextWithEntitiesFieldsModel.class);
            return this.f17877l;
        }

        @Nullable
        public final String m26352l() {
            this.f17878m = super.a(this.f17878m, 9);
            return this.f17878m;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m26341q() {
            this.f17879n = (DefaultTextWithEntitiesFieldsModel) super.a(this.f17879n, 10, DefaultTextWithEntitiesFieldsModel.class);
            return this.f17879n;
        }

        public static InfoReviewItemFragmentModel m26337a(InfoReviewItemFragmentModel infoReviewItemFragmentModel) {
            if (infoReviewItemFragmentModel == null) {
                return null;
            }
            if (infoReviewItemFragmentModel instanceof InfoReviewItemFragmentModel) {
                return infoReviewItemFragmentModel;
            }
            Builder builder = new Builder();
            builder.f17858a = infoReviewItemFragmentModel.m26346b();
            builder.f17859b = DefaultImageFieldsModel.a(infoReviewItemFragmentModel.m26347c());
            builder.f17860c = infoReviewItemFragmentModel.m26348d();
            builder.f17861d = infoReviewItemFragmentModel.dy_();
            builder.f17862e = infoReviewItemFragmentModel.m26349g();
            builder.f17863f = ProfileQuestionFragmentModel.m18028a(infoReviewItemFragmentModel.dA_());
            builder.f17864g = infoReviewItemFragmentModel.dz_();
            builder.f17865h = infoReviewItemFragmentModel.m26350j();
            builder.f17866i = DefaultTextWithEntitiesFieldsModel.a(infoReviewItemFragmentModel.m26351k());
            builder.f17867j = infoReviewItemFragmentModel.m26352l();
            builder.f17868k = DefaultTextWithEntitiesFieldsModel.a(infoReviewItemFragmentModel.m26353m());
            return builder.m26334a();
        }

        @Nullable
        public final String m26344a() {
            return m26348d();
        }

        public final int jK_() {
            return 7962778;
        }

        public final GraphQLVisitableModel m26343a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26338n() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m26338n());
                if (m26338n() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (InfoReviewItemFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17870e = defaultImageFieldsModel;
                }
            }
            if (m26339o() != null) {
                ProfileQuestionFragmentModel profileQuestionFragmentModel = (ProfileQuestionFragmentModel) graphQLModelMutatingVisitor.b(m26339o());
                if (m26339o() != profileQuestionFragmentModel) {
                    graphQLVisitableModel = (InfoReviewItemFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17874i = profileQuestionFragmentModel;
                }
            }
            if (m26340p() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m26340p());
                if (m26340p() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (InfoReviewItemFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17877l = defaultTextWithEntitiesFieldsModel;
                }
            }
            if (m26341q() != null) {
                defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m26341q());
                if (m26341q() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (InfoReviewItemFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17879n = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26342a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26346b());
            int a2 = ModelHelper.a(flatBufferBuilder, m26338n());
            int b = flatBufferBuilder.b(m26348d());
            int b2 = flatBufferBuilder.b(m26349g());
            int a3 = ModelHelper.a(flatBufferBuilder, m26339o());
            int b3 = flatBufferBuilder.b(dz_());
            int b4 = flatBufferBuilder.b(m26350j());
            int a4 = ModelHelper.a(flatBufferBuilder, m26340p());
            int b5 = flatBufferBuilder.b(m26352l());
            int a5 = ModelHelper.a(flatBufferBuilder, m26341q());
            flatBufferBuilder.c(11);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            flatBufferBuilder.a(3, this.f17872g);
            flatBufferBuilder.b(4, b2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, b3);
            flatBufferBuilder.b(7, b4);
            flatBufferBuilder.b(8, a4);
            flatBufferBuilder.b(9, b5);
            flatBufferBuilder.b(10, a5);
            i();
            return flatBufferBuilder.d();
        }

        public final void m26345a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17872g = mutableFlatBuffer.a(i, 3);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1649847315)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: date_added */
    public final class InfoReviewItemsFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<InfoReviewItemFragmentModel> f17882d;
        @Nullable
        private InfoReviewOverflowLinkModel f17883e;

        /* compiled from: date_added */
        public final class Builder {
            @Nullable
            public ImmutableList<InfoReviewItemFragmentModel> f17880a;
            @Nullable
            public InfoReviewOverflowLinkModel f17881b;

            public final InfoReviewItemsFragmentModel m26354a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f17880a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f17881b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new InfoReviewItemsFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: date_added */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InfoReviewItemsFragmentModel.class, new Deserializer());
            }

            public Object m26355a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InfoReviewItemsFragmentParser.m26378a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object infoReviewItemsFragmentModel = new InfoReviewItemsFragmentModel();
                ((BaseModel) infoReviewItemsFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (infoReviewItemsFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) infoReviewItemsFragmentModel).a();
                }
                return infoReviewItemsFragmentModel;
            }
        }

        /* compiled from: date_added */
        public class Serializer extends JsonSerializer<InfoReviewItemsFragmentModel> {
            public final void m26356a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InfoReviewItemsFragmentModel infoReviewItemsFragmentModel = (InfoReviewItemsFragmentModel) obj;
                if (infoReviewItemsFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(infoReviewItemsFragmentModel.m26357a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    infoReviewItemsFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InfoReviewItemsFragmentParser.m26379a(infoReviewItemsFragmentModel.w_(), infoReviewItemsFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(InfoReviewItemsFragmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ InfoReviewOverflowLinkModel m26360b() {
            return m26361j();
        }

        public InfoReviewItemsFragmentModel() {
            super(2);
        }

        public InfoReviewItemsFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nonnull
        public final ImmutableList<InfoReviewItemFragmentModel> m26359a() {
            this.f17882d = super.a(this.f17882d, 0, InfoReviewItemFragmentModel.class);
            return (ImmutableList) this.f17882d;
        }

        @Nullable
        public final InfoReviewOverflowLinkModel m26361j() {
            this.f17883e = (InfoReviewOverflowLinkModel) super.a(this.f17883e, 1, InfoReviewOverflowLinkModel.class);
            return this.f17883e;
        }

        public final int jK_() {
            return -926506281;
        }

        public final GraphQLVisitableModel m26358a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            InfoReviewOverflowLinkModel infoReviewOverflowLinkModel;
            h();
            if (m26359a() != null) {
                com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m26359a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    InfoReviewItemsFragmentModel infoReviewItemsFragmentModel = (InfoReviewItemsFragmentModel) ModelHelper.a(null, this);
                    infoReviewItemsFragmentModel.f17882d = a.b();
                    graphQLVisitableModel = infoReviewItemsFragmentModel;
                    if (m26361j() != null) {
                        infoReviewOverflowLinkModel = (InfoReviewOverflowLinkModel) graphQLModelMutatingVisitor.b(m26361j());
                        if (m26361j() != infoReviewOverflowLinkModel) {
                            graphQLVisitableModel = (InfoReviewItemsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17883e = infoReviewOverflowLinkModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m26361j() != null) {
                infoReviewOverflowLinkModel = (InfoReviewOverflowLinkModel) graphQLModelMutatingVisitor.b(m26361j());
                if (m26361j() != infoReviewOverflowLinkModel) {
                    graphQLVisitableModel = (InfoReviewItemsFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17883e = infoReviewOverflowLinkModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m26357a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26359a());
            int a2 = ModelHelper.a(flatBufferBuilder, m26361j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1252944882)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: date_added */
    public final class InfoReviewOverflowLinkModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private DefaultImageFieldsModel f17884d;
        @Nullable
        private DefaultTextWithEntitiesFieldsModel f17885e;
        @Nullable
        private String f17886f;

        /* compiled from: date_added */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(InfoReviewOverflowLinkModel.class, new Deserializer());
            }

            public Object m26362a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(InfoReviewOverflowLinkParser.m26380a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object infoReviewOverflowLinkModel = new InfoReviewOverflowLinkModel();
                ((BaseModel) infoReviewOverflowLinkModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (infoReviewOverflowLinkModel instanceof Postprocessable) {
                    return ((Postprocessable) infoReviewOverflowLinkModel).a();
                }
                return infoReviewOverflowLinkModel;
            }
        }

        /* compiled from: date_added */
        public class Serializer extends JsonSerializer<InfoReviewOverflowLinkModel> {
            public final void m26363a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                InfoReviewOverflowLinkModel infoReviewOverflowLinkModel = (InfoReviewOverflowLinkModel) obj;
                if (infoReviewOverflowLinkModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(infoReviewOverflowLinkModel.m26366a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    infoReviewOverflowLinkModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                InfoReviewOverflowLinkParser.m26381a(infoReviewOverflowLinkModel.w_(), infoReviewOverflowLinkModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(InfoReviewOverflowLinkModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultImageFields m26367a() {
            return m26364j();
        }

        @Nullable
        public final /* synthetic */ DefaultTextWithEntitiesFields m26369b() {
            return m26365k();
        }

        public InfoReviewOverflowLinkModel() {
            super(3);
        }

        @Nullable
        private DefaultImageFieldsModel m26364j() {
            this.f17884d = (DefaultImageFieldsModel) super.a(this.f17884d, 0, DefaultImageFieldsModel.class);
            return this.f17884d;
        }

        @Nullable
        private DefaultTextWithEntitiesFieldsModel m26365k() {
            this.f17885e = (DefaultTextWithEntitiesFieldsModel) super.a(this.f17885e, 1, DefaultTextWithEntitiesFieldsModel.class);
            return this.f17885e;
        }

        @Nullable
        public final String m26370c() {
            this.f17886f = super.a(this.f17886f, 2);
            return this.f17886f;
        }

        public final int jK_() {
            return -1771989597;
        }

        public final GraphQLVisitableModel m26368a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26364j() != null) {
                DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m26364j());
                if (m26364j() != defaultImageFieldsModel) {
                    graphQLVisitableModel = (InfoReviewOverflowLinkModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17884d = defaultImageFieldsModel;
                }
            }
            if (m26365k() != null) {
                DefaultTextWithEntitiesFieldsModel defaultTextWithEntitiesFieldsModel = (DefaultTextWithEntitiesFieldsModel) graphQLModelMutatingVisitor.b(m26365k());
                if (m26365k() != defaultTextWithEntitiesFieldsModel) {
                    graphQLVisitableModel = (InfoReviewOverflowLinkModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17885e = defaultTextWithEntitiesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26366a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26364j());
            int a2 = ModelHelper.a(flatBufferBuilder, m26365k());
            int b = flatBufferBuilder.b(m26370c());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 611238419)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: date_added */
    public final class TimelineInfoReviewQueryModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private InfoReviewItemsFragmentModel f17887d;

        /* compiled from: date_added */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineInfoReviewQueryModel.class, new Deserializer());
            }

            public Object m26371a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineInfoReviewQueryParser.m26382a(jsonParser);
                Object timelineInfoReviewQueryModel = new TimelineInfoReviewQueryModel();
                ((BaseModel) timelineInfoReviewQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineInfoReviewQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineInfoReviewQueryModel).a();
                }
                return timelineInfoReviewQueryModel;
            }
        }

        /* compiled from: date_added */
        public class Serializer extends JsonSerializer<TimelineInfoReviewQueryModel> {
            public final void m26372a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineInfoReviewQueryModel timelineInfoReviewQueryModel = (TimelineInfoReviewQueryModel) obj;
                if (timelineInfoReviewQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineInfoReviewQueryModel.m26373a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineInfoReviewQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineInfoReviewQueryModel.w_();
                int u_ = timelineInfoReviewQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("info_review_items");
                    InfoReviewItemsFragmentParser.m26379a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineInfoReviewQueryModel.class, new Serializer());
            }
        }

        public TimelineInfoReviewQueryModel() {
            super(1);
        }

        @Nullable
        public final InfoReviewItemsFragmentModel m26375a() {
            this.f17887d = (InfoReviewItemsFragmentModel) super.a(this.f17887d, 0, InfoReviewItemsFragmentModel.class);
            return this.f17887d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m26374a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26375a() != null) {
                InfoReviewItemsFragmentModel infoReviewItemsFragmentModel = (InfoReviewItemsFragmentModel) graphQLModelMutatingVisitor.b(m26375a());
                if (m26375a() != infoReviewItemsFragmentModel) {
                    graphQLVisitableModel = (TimelineInfoReviewQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17887d = infoReviewItemsFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26373a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26375a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

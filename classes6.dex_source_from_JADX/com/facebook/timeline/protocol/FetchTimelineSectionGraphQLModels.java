package com.facebook.timeline.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.VirtualFlattenableResolverImpl;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQL2Models.DefaultPageInfoFieldsModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.protocol.FetchTimelineSectionGraphQLParsers.TimelinePageFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineSectionGraphQLParsers.TimelinePageFirstUnitsConnectionFieldsParser;
import com.facebook.timeline.protocol.FetchTimelineSectionGraphQLParsers.TimelinePageFirstUnitsConnectionFieldsParser.EdgesParser;
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

/* compiled from: delay_2 */
public class FetchTimelineSectionGraphQLModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 907239548)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: delay_2 */
    public final class TimelinePageFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private String f17829d;
        @Nullable
        private String f17830e;
        @Nullable
        private TimelinePageFirstUnitsConnectionFieldsModel f17831f;
        private int f17832g;

        /* compiled from: delay_2 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelinePageFieldsModel.class, new Deserializer());
            }

            public Object m26164a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelinePageFieldsParser.m26184a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelinePageFieldsModel = new TimelinePageFieldsModel();
                ((BaseModel) timelinePageFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelinePageFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelinePageFieldsModel).a();
                }
                return timelinePageFieldsModel;
            }
        }

        /* compiled from: delay_2 */
        public class Serializer extends JsonSerializer<TimelinePageFieldsModel> {
            public final void m26165a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelinePageFieldsModel timelinePageFieldsModel = (TimelinePageFieldsModel) obj;
                if (timelinePageFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelinePageFieldsModel.m26169a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelinePageFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelinePageFieldsModel.w_();
                int u_ = timelinePageFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("label");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("timeline_units");
                    TimelinePageFirstUnitsConnectionFieldsParser.m26188a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.a(u_, 3, 0);
                if (g != 0) {
                    jsonGenerator.a("year");
                    jsonGenerator.b(g);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelinePageFieldsModel.class, new Serializer());
            }
        }

        public TimelinePageFieldsModel() {
            super(4);
        }

        @Nullable
        private String m26166j() {
            this.f17829d = super.a(this.f17829d, 0);
            return this.f17829d;
        }

        @Nullable
        private String m26167k() {
            this.f17830e = super.a(this.f17830e, 1);
            return this.f17830e;
        }

        @Nullable
        private TimelinePageFirstUnitsConnectionFieldsModel m26168l() {
            this.f17831f = (TimelinePageFirstUnitsConnectionFieldsModel) super.a(this.f17831f, 2, TimelinePageFirstUnitsConnectionFieldsModel.class);
            return this.f17831f;
        }

        @Nullable
        public final String m26171a() {
            return m26166j();
        }

        public final int jK_() {
            return 1129832260;
        }

        public final GraphQLVisitableModel m26170a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26168l() != null) {
                TimelinePageFirstUnitsConnectionFieldsModel timelinePageFirstUnitsConnectionFieldsModel = (TimelinePageFirstUnitsConnectionFieldsModel) graphQLModelMutatingVisitor.b(m26168l());
                if (m26168l() != timelinePageFirstUnitsConnectionFieldsModel) {
                    graphQLVisitableModel = (TimelinePageFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17831f = timelinePageFirstUnitsConnectionFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26169a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m26166j());
            int b2 = flatBufferBuilder.b(m26167k());
            int a = ModelHelper.a(flatBufferBuilder, m26168l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.a(3, this.f17832g, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m26172a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17832g = mutableFlatBuffer.a(i, 3, 0);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1690637051)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: delay_2 */
    public final class TimelinePageFirstUnitsConnectionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<EdgesModel> f17834d;
        @Nullable
        private DefaultPageInfoFieldsModel f17835e;

        /* compiled from: delay_2 */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelinePageFirstUnitsConnectionFieldsModel.class, new Deserializer());
            }

            public Object m26173a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelinePageFirstUnitsConnectionFieldsParser.m26187a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelinePageFirstUnitsConnectionFieldsModel = new TimelinePageFirstUnitsConnectionFieldsModel();
                ((BaseModel) timelinePageFirstUnitsConnectionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelinePageFirstUnitsConnectionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelinePageFirstUnitsConnectionFieldsModel).a();
                }
                return timelinePageFirstUnitsConnectionFieldsModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -414125345)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: delay_2 */
        public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private FeedUnit f17833d;

            /* compiled from: delay_2 */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                }

                public Object m26174a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EdgesParser.m26185b(jsonParser, flatBufferBuilder));
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

            /* compiled from: delay_2 */
            public class Serializer extends JsonSerializer<EdgesModel> {
                public final void m26175a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EdgesModel edgesModel = (EdgesModel) obj;
                    if (edgesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(edgesModel.m26177a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EdgesParser.m26186b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(EdgesModel.class, new Serializer());
                }
            }

            public EdgesModel() {
                super(1);
            }

            @Nullable
            private FeedUnit m26176a() {
                this.f17833d = (FeedUnit) super.a(this.f17833d, 0, VirtualFlattenableResolverImpl.a);
                return this.f17833d;
            }

            public final int jK_() {
                return -941287704;
            }

            public final GraphQLVisitableModel m26178a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m26176a() != null) {
                    FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.b(m26176a());
                    if (m26176a() != feedUnit) {
                        graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17833d = feedUnit;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m26177a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, (MutableFlattenable) m26176a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: delay_2 */
        public class Serializer extends JsonSerializer<TimelinePageFirstUnitsConnectionFieldsModel> {
            public final void m26179a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelinePageFirstUnitsConnectionFieldsModel timelinePageFirstUnitsConnectionFieldsModel = (TimelinePageFirstUnitsConnectionFieldsModel) obj;
                if (timelinePageFirstUnitsConnectionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelinePageFirstUnitsConnectionFieldsModel.m26182a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelinePageFirstUnitsConnectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelinePageFirstUnitsConnectionFieldsParser.m26188a(timelinePageFirstUnitsConnectionFieldsModel.w_(), timelinePageFirstUnitsConnectionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelinePageFirstUnitsConnectionFieldsModel.class, new Serializer());
            }
        }

        public TimelinePageFirstUnitsConnectionFieldsModel() {
            super(2);
        }

        @Nonnull
        private ImmutableList<EdgesModel> m26180a() {
            this.f17834d = super.a(this.f17834d, 0, EdgesModel.class);
            return (ImmutableList) this.f17834d;
        }

        @Nullable
        private DefaultPageInfoFieldsModel m26181j() {
            this.f17835e = (DefaultPageInfoFieldsModel) super.a(this.f17835e, 1, DefaultPageInfoFieldsModel.class);
            return this.f17835e;
        }

        public final int jK_() {
            return 495147977;
        }

        public final GraphQLVisitableModel m26183a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            DefaultPageInfoFieldsModel defaultPageInfoFieldsModel;
            h();
            if (m26180a() != null) {
                Builder a = ModelHelper.a(m26180a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    TimelinePageFirstUnitsConnectionFieldsModel timelinePageFirstUnitsConnectionFieldsModel = (TimelinePageFirstUnitsConnectionFieldsModel) ModelHelper.a(null, this);
                    timelinePageFirstUnitsConnectionFieldsModel.f17834d = a.b();
                    graphQLVisitableModel = timelinePageFirstUnitsConnectionFieldsModel;
                    if (m26181j() != null) {
                        defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m26181j());
                        if (m26181j() != defaultPageInfoFieldsModel) {
                            graphQLVisitableModel = (TimelinePageFirstUnitsConnectionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f17835e = defaultPageInfoFieldsModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m26181j() != null) {
                defaultPageInfoFieldsModel = (DefaultPageInfoFieldsModel) graphQLModelMutatingVisitor.b(m26181j());
                if (m26181j() != defaultPageInfoFieldsModel) {
                    graphQLVisitableModel = (TimelinePageFirstUnitsConnectionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f17835e = defaultPageInfoFieldsModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m26182a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26180a());
            int a2 = ModelHelper.a(flatBufferBuilder, m26181j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}

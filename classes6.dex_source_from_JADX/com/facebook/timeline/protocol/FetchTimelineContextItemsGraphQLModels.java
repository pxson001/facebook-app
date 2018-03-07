package com.facebook.timeline.protocol;

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
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.protocol.FetchTimelineContextItemsGraphQLParsers.TimelineContextItemsParser;
import com.facebook.timeline.protocol.FetchTimelineContextItemsGraphQLParsers.TimelineContextItemsQueryParser;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemFieldsModel;
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

/* compiled from: deltaAdminAddedToGroupThread */
public class FetchTimelineContextItemsGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1326280247)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: deltaAdminAddedToGroupThread */
    public final class TimelineContextItemsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<TimelineContextListItemFieldsModel> f17644d;

        /* compiled from: deltaAdminAddedToGroupThread */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineContextItemsModel.class, new Deserializer());
            }

            public Object m25657a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineContextItemsParser.m25669a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineContextItemsModel = new TimelineContextItemsModel();
                ((BaseModel) timelineContextItemsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineContextItemsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineContextItemsModel).a();
                }
                return timelineContextItemsModel;
            }
        }

        /* compiled from: deltaAdminAddedToGroupThread */
        public class Serializer extends JsonSerializer<TimelineContextItemsModel> {
            public final void m25658a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineContextItemsModel timelineContextItemsModel = (TimelineContextItemsModel) obj;
                if (timelineContextItemsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineContextItemsModel.m25659a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineContextItemsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineContextItemsParser.m25670a(timelineContextItemsModel.w_(), timelineContextItemsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(TimelineContextItemsModel.class, new Serializer());
            }
        }

        public TimelineContextItemsModel() {
            super(1);
        }

        @Nonnull
        public final ImmutableList<TimelineContextListItemFieldsModel> m25661a() {
            this.f17644d = super.a(this.f17644d, 0, TimelineContextListItemFieldsModel.class);
            return (ImmutableList) this.f17644d;
        }

        public final int jK_() {
            return -2113882798;
        }

        public final GraphQLVisitableModel m25660a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25661a() != null) {
                Builder a = ModelHelper.a(m25661a(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (TimelineContextItemsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17644d = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25659a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25661a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1275256585)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: deltaAdminAddedToGroupThread */
    public final class TimelineContextItemsQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private TimelineContextItemsModel f17645d;

        /* compiled from: deltaAdminAddedToGroupThread */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineContextItemsQueryModel.class, new Deserializer());
            }

            public Object m25662a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineContextItemsQueryParser.m25671a(jsonParser);
                Object timelineContextItemsQueryModel = new TimelineContextItemsQueryModel();
                ((BaseModel) timelineContextItemsQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineContextItemsQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineContextItemsQueryModel).a();
                }
                return timelineContextItemsQueryModel;
            }
        }

        /* compiled from: deltaAdminAddedToGroupThread */
        public class Serializer extends JsonSerializer<TimelineContextItemsQueryModel> {
            public final void m25663a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineContextItemsQueryModel timelineContextItemsQueryModel = (TimelineContextItemsQueryModel) obj;
                if (timelineContextItemsQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineContextItemsQueryModel.m25664a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineContextItemsQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineContextItemsQueryModel.w_();
                int u_ = timelineContextItemsQueryModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("timeline_context_items");
                    TimelineContextItemsParser.m25670a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineContextItemsQueryModel.class, new Serializer());
            }
        }

        public TimelineContextItemsQueryModel() {
            super(1);
        }

        public final void m25667a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m25668a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final TimelineContextItemsModel m25666a() {
            this.f17645d = (TimelineContextItemsModel) super.a(this.f17645d, 0, TimelineContextItemsModel.class);
            return this.f17645d;
        }

        public final int jK_() {
            return 2645995;
        }

        public final GraphQLVisitableModel m25665a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25666a() != null) {
                TimelineContextItemsModel timelineContextItemsModel = (TimelineContextItemsModel) graphQLModelMutatingVisitor.b(m25666a());
                if (m25666a() != timelineContextItemsModel) {
                    graphQLVisitableModel = (TimelineContextItemsQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17645d = timelineContextItemsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25664a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25666a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

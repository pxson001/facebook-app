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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.protocol.FetchTimelineFriendingPossibilitiesGraphQLParsers.TimelineFirstUnitsViewingSelfFriendingPossibilitiesParser;
import com.facebook.timeline.protocol.FetchTimelineFriendingPossibilitiesGraphQLParsers.TimelineFriendingPossibilitiesConnectionFieldsParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: delete_photo_tag */
public class FetchTimelineFriendingPossibilitiesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1977357272)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_photo_tag */
    public final class TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private TimelineFriendingPossibilitiesConnectionFieldsModel f17646d;

        /* compiled from: delete_photo_tag */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel.class, new Deserializer());
            }

            public Object m25672a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineFirstUnitsViewingSelfFriendingPossibilitiesParser.m25683a(jsonParser);
                Object timelineFirstUnitsViewingSelfFriendingPossibilitiesModel = new TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel();
                ((BaseModel) timelineFirstUnitsViewingSelfFriendingPossibilitiesModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineFirstUnitsViewingSelfFriendingPossibilitiesModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineFirstUnitsViewingSelfFriendingPossibilitiesModel).a();
                }
                return timelineFirstUnitsViewingSelfFriendingPossibilitiesModel;
            }
        }

        /* compiled from: delete_photo_tag */
        public class Serializer extends JsonSerializer<TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel> {
            public final void m25673a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel timelineFirstUnitsViewingSelfFriendingPossibilitiesModel = (TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel) obj;
                if (timelineFirstUnitsViewingSelfFriendingPossibilitiesModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineFirstUnitsViewingSelfFriendingPossibilitiesModel.m25674a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineFirstUnitsViewingSelfFriendingPossibilitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineFirstUnitsViewingSelfFriendingPossibilitiesModel.w_();
                int u_ = timelineFirstUnitsViewingSelfFriendingPossibilitiesModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("friending_possibilities");
                    TimelineFriendingPossibilitiesConnectionFieldsParser.m25685a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel.class, new Serializer());
            }
        }

        public TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel() {
            super(1);
        }

        @Nullable
        public final TimelineFriendingPossibilitiesConnectionFieldsModel m25676a() {
            this.f17646d = (TimelineFriendingPossibilitiesConnectionFieldsModel) super.a(this.f17646d, 0, TimelineFriendingPossibilitiesConnectionFieldsModel.class);
            return this.f17646d;
        }

        public final int jK_() {
            return -1732764110;
        }

        public final GraphQLVisitableModel m25675a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m25676a() != null) {
                TimelineFriendingPossibilitiesConnectionFieldsModel timelineFriendingPossibilitiesConnectionFieldsModel = (TimelineFriendingPossibilitiesConnectionFieldsModel) graphQLModelMutatingVisitor.b(m25676a());
                if (m25676a() != timelineFriendingPossibilitiesConnectionFieldsModel) {
                    graphQLVisitableModel = (TimelineFirstUnitsViewingSelfFriendingPossibilitiesModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17646d = timelineFriendingPossibilitiesConnectionFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m25674a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m25676a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -437243616)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: delete_photo_tag */
    public final class TimelineFriendingPossibilitiesConnectionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        private int f17647d;

        /* compiled from: delete_photo_tag */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineFriendingPossibilitiesConnectionFieldsModel.class, new Deserializer());
            }

            public Object m25677a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(TimelineFriendingPossibilitiesConnectionFieldsParser.m25684a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object timelineFriendingPossibilitiesConnectionFieldsModel = new TimelineFriendingPossibilitiesConnectionFieldsModel();
                ((BaseModel) timelineFriendingPossibilitiesConnectionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (timelineFriendingPossibilitiesConnectionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineFriendingPossibilitiesConnectionFieldsModel).a();
                }
                return timelineFriendingPossibilitiesConnectionFieldsModel;
            }
        }

        /* compiled from: delete_photo_tag */
        public class Serializer extends JsonSerializer<TimelineFriendingPossibilitiesConnectionFieldsModel> {
            public final void m25678a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                TimelineFriendingPossibilitiesConnectionFieldsModel timelineFriendingPossibilitiesConnectionFieldsModel = (TimelineFriendingPossibilitiesConnectionFieldsModel) obj;
                if (timelineFriendingPossibilitiesConnectionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineFriendingPossibilitiesConnectionFieldsModel.m25680a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineFriendingPossibilitiesConnectionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                TimelineFriendingPossibilitiesConnectionFieldsParser.m25685a(timelineFriendingPossibilitiesConnectionFieldsModel.w_(), timelineFriendingPossibilitiesConnectionFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(TimelineFriendingPossibilitiesConnectionFieldsModel.class, new Serializer());
            }
        }

        public TimelineFriendingPossibilitiesConnectionFieldsModel() {
            super(1);
        }

        public final int m25679a() {
            a(0, 0);
            return this.f17647d;
        }

        public final int jK_() {
            return 1085064779;
        }

        public final GraphQLVisitableModel m25681a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m25680a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f17647d, 0);
            i();
            return flatBufferBuilder.d();
        }

        public final void m25682a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f17647d = mutableFlatBuffer.a(i, 0, 0);
        }
    }
}

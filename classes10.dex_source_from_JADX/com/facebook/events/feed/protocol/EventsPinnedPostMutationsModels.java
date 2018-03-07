package com.facebook.events.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLModels.EventPinnedPostAndRecentStoryFragmentModel;
import com.facebook.events.feed.protocol.EventPinnedPostAndRecentStoryGraphQLParsers.EventPinnedPostAndRecentStoryFragmentParser;
import com.facebook.events.feed.protocol.EventsPinnedPostMutationsParsers.EventChangeStoryPinStatusMutationParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: com.facebook.ads thread-%d %tF %<tT */
public class EventsPinnedPostMutationsModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1465092462)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: com.facebook.ads thread-%d %tF %<tT */
    public final class EventChangeStoryPinStatusMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private EventPinnedPostAndRecentStoryFragmentModel f17393d;
        @Nullable
        private String f17394e;

        /* compiled from: com.facebook.ads thread-%d %tF %<tT */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventChangeStoryPinStatusMutationModel.class, new Deserializer());
            }

            public Object m17761a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventChangeStoryPinStatusMutationParser.m17767a(jsonParser);
                Object eventChangeStoryPinStatusMutationModel = new EventChangeStoryPinStatusMutationModel();
                ((BaseModel) eventChangeStoryPinStatusMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventChangeStoryPinStatusMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) eventChangeStoryPinStatusMutationModel).a();
                }
                return eventChangeStoryPinStatusMutationModel;
            }
        }

        /* compiled from: com.facebook.ads thread-%d %tF %<tT */
        public class Serializer extends JsonSerializer<EventChangeStoryPinStatusMutationModel> {
            public final void m17762a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventChangeStoryPinStatusMutationModel eventChangeStoryPinStatusMutationModel = (EventChangeStoryPinStatusMutationModel) obj;
                if (eventChangeStoryPinStatusMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventChangeStoryPinStatusMutationModel.m17763a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventChangeStoryPinStatusMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventChangeStoryPinStatusMutationModel.w_();
                int u_ = eventChangeStoryPinStatusMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("event");
                    EventPinnedPostAndRecentStoryFragmentParser.m17756a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("new_story_sort_key");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventChangeStoryPinStatusMutationModel.class, new Serializer());
            }
        }

        public EventChangeStoryPinStatusMutationModel() {
            super(2);
        }

        @Nullable
        public final EventPinnedPostAndRecentStoryFragmentModel m17764a() {
            this.f17393d = (EventPinnedPostAndRecentStoryFragmentModel) super.a(this.f17393d, 0, EventPinnedPostAndRecentStoryFragmentModel.class);
            return this.f17393d;
        }

        @Nullable
        public final String m17766j() {
            this.f17394e = super.a(this.f17394e, 1);
            return this.f17394e;
        }

        public final int jK_() {
            return -467003247;
        }

        public final GraphQLVisitableModel m17765a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m17764a() != null) {
                EventPinnedPostAndRecentStoryFragmentModel eventPinnedPostAndRecentStoryFragmentModel = (EventPinnedPostAndRecentStoryFragmentModel) graphQLModelMutatingVisitor.b(m17764a());
                if (m17764a() != eventPinnedPostAndRecentStoryFragmentModel) {
                    graphQLVisitableModel = (EventChangeStoryPinStatusMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17393d = eventPinnedPostAndRecentStoryFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m17763a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m17764a());
            int b = flatBufferBuilder.b(m17766j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}

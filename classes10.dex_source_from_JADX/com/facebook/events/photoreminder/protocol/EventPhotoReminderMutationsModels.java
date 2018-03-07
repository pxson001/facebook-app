package com.facebook.events.photoreminder.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.events.photoreminder.protocol.EventPhotoReminderMutationsParsers.EventSendSharePhotosReminderCoreMutationParser;
import com.facebook.events.photoreminder.protocol.EventPhotoReminderMutationsParsers.EventSendSharePhotosReminderCoreMutationParser.EventParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
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
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: back_button_click */
public class EventPhotoReminderMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -448946472)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: back_button_click */
    public final class EventSendSharePhotosReminderCoreMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private EventModel f18981d;

        /* compiled from: back_button_click */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventSendSharePhotosReminderCoreMutationModel.class, new Deserializer());
            }

            public Object m19210a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EventSendSharePhotosReminderCoreMutationParser.m19225a(jsonParser);
                Object eventSendSharePhotosReminderCoreMutationModel = new EventSendSharePhotosReminderCoreMutationModel();
                ((BaseModel) eventSendSharePhotosReminderCoreMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (eventSendSharePhotosReminderCoreMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) eventSendSharePhotosReminderCoreMutationModel).a();
                }
                return eventSendSharePhotosReminderCoreMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: back_button_click */
        public final class EventModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f18980d;

            /* compiled from: back_button_click */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventModel.class, new Deserializer());
                }

                public Object m19211a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventParser.m19223a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object eventModel = new EventModel();
                    ((BaseModel) eventModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (eventModel instanceof Postprocessable) {
                        return ((Postprocessable) eventModel).a();
                    }
                    return eventModel;
                }
            }

            /* compiled from: back_button_click */
            public class Serializer extends JsonSerializer<EventModel> {
                public final void m19212a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventModel eventModel = (EventModel) obj;
                    if (eventModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventModel.m19214a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventParser.m19224a(eventModel.w_(), eventModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventModel.class, new Serializer());
                }
            }

            public EventModel() {
                super(1);
            }

            public final void m19217a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m19218a(String str, Object obj, boolean z) {
            }

            @Nullable
            private String m19213j() {
                this.f18980d = super.a(this.f18980d, 0);
                return this.f18980d;
            }

            @Nullable
            public final String m19216a() {
                return m19213j();
            }

            public final int jK_() {
                return 67338874;
            }

            public final GraphQLVisitableModel m19215a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m19214a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m19213j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: back_button_click */
        public class Serializer extends JsonSerializer<EventSendSharePhotosReminderCoreMutationModel> {
            public final void m19219a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EventSendSharePhotosReminderCoreMutationModel eventSendSharePhotosReminderCoreMutationModel = (EventSendSharePhotosReminderCoreMutationModel) obj;
                if (eventSendSharePhotosReminderCoreMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventSendSharePhotosReminderCoreMutationModel.m19221a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventSendSharePhotosReminderCoreMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = eventSendSharePhotosReminderCoreMutationModel.w_();
                int u_ = eventSendSharePhotosReminderCoreMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("event");
                    EventParser.m19224a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EventSendSharePhotosReminderCoreMutationModel.class, new Serializer());
            }
        }

        public EventSendSharePhotosReminderCoreMutationModel() {
            super(1);
        }

        @Nullable
        private EventModel m19220a() {
            this.f18981d = (EventModel) super.a(this.f18981d, 0, EventModel.class);
            return this.f18981d;
        }

        public final int jK_() {
            return 269879965;
        }

        public final GraphQLVisitableModel m19222a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19220a() != null) {
                EventModel eventModel = (EventModel) graphQLModelMutatingVisitor.b(m19220a());
                if (m19220a() != eventModel) {
                    graphQLVisitableModel = (EventSendSharePhotosReminderCoreMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f18981d = eventModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19221a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19220a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

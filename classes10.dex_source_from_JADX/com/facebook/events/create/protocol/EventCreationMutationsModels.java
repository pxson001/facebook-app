package com.facebook.events.create.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.events.create.protocol.EventCreationMutationsParsers.CreateEventCoreMutationFieldsParser;
import com.facebook.events.create.protocol.EventCreationMutationsParsers.CreateEventCoreMutationFieldsParser.EventParser;
import com.facebook.events.create.protocol.EventCreationMutationsParsers.EditEventCoreMutationFieldsParser;
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

/* compiled from: contact_invite_list_close */
public class EventCreationMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2026967714)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: contact_invite_list_close */
    public final class CreateEventCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private EventModel f16262d;

        /* compiled from: contact_invite_list_close */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(CreateEventCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m16644a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = CreateEventCoreMutationFieldsParser.m16672a(jsonParser);
                Object createEventCoreMutationFieldsModel = new CreateEventCoreMutationFieldsModel();
                ((BaseModel) createEventCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (createEventCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) createEventCoreMutationFieldsModel).a();
                }
                return createEventCoreMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contact_invite_list_close */
        public final class EventModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f16261d;

            /* compiled from: contact_invite_list_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventModel.class, new Deserializer());
                }

                public Object m16645a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EventParser.m16670a(jsonParser, flatBufferBuilder));
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

            /* compiled from: contact_invite_list_close */
            public class Serializer extends JsonSerializer<EventModel> {
                public final void m16646a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventModel eventModel = (EventModel) obj;
                    if (eventModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventModel.m16647a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EventParser.m16671a(eventModel.w_(), eventModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventModel.class, new Serializer());
                }
            }

            public EventModel() {
                super(1);
            }

            public final void m16650a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16651a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m16652j() {
                this.f16261d = super.a(this.f16261d, 0);
                return this.f16261d;
            }

            @Nullable
            public final String m16649a() {
                return m16652j();
            }

            public final int jK_() {
                return 67338874;
            }

            public final GraphQLVisitableModel m16648a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16647a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16652j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: contact_invite_list_close */
        public class Serializer extends JsonSerializer<CreateEventCoreMutationFieldsModel> {
            public final void m16653a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                CreateEventCoreMutationFieldsModel createEventCoreMutationFieldsModel = (CreateEventCoreMutationFieldsModel) obj;
                if (createEventCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(createEventCoreMutationFieldsModel.m16654a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    createEventCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = createEventCoreMutationFieldsModel.w_();
                int u_ = createEventCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("event");
                    EventParser.m16671a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(CreateEventCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public CreateEventCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        public final EventModel m16655a() {
            this.f16262d = (EventModel) super.a(this.f16262d, 0, EventModel.class);
            return this.f16262d;
        }

        public final int jK_() {
            return 108578583;
        }

        public final GraphQLVisitableModel m16656a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16655a() != null) {
                EventModel eventModel = (EventModel) graphQLModelMutatingVisitor.b(m16655a());
                if (m16655a() != eventModel) {
                    graphQLVisitableModel = (CreateEventCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16262d = eventModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16654a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16655a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -903228215)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: contact_invite_list_close */
    public final class EditEventCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private EventModel f16264d;

        /* compiled from: contact_invite_list_close */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EditEventCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m16657a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = EditEventCoreMutationFieldsParser.m16675a(jsonParser);
                Object editEventCoreMutationFieldsModel = new EditEventCoreMutationFieldsModel();
                ((BaseModel) editEventCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (editEventCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) editEventCoreMutationFieldsModel).a();
                }
                return editEventCoreMutationFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: contact_invite_list_close */
        public final class EventModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f16263d;

            /* compiled from: contact_invite_list_close */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(EventModel.class, new Deserializer());
                }

                public Object m16658a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(EditEventCoreMutationFieldsParser.EventParser.m16673a(jsonParser, flatBufferBuilder));
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

            /* compiled from: contact_invite_list_close */
            public class Serializer extends JsonSerializer<EventModel> {
                public final void m16659a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    EventModel eventModel = (EventModel) obj;
                    if (eventModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(eventModel.m16660a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        eventModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    EditEventCoreMutationFieldsParser.EventParser.m16674a(eventModel.w_(), eventModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(EventModel.class, new Serializer());
                }
            }

            public EventModel() {
                super(1);
            }

            public final void m16663a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m16664a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m16665j() {
                this.f16263d = super.a(this.f16263d, 0);
                return this.f16263d;
            }

            @Nullable
            public final String m16662a() {
                return m16665j();
            }

            public final int jK_() {
                return 67338874;
            }

            public final GraphQLVisitableModel m16661a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16660a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16665j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: contact_invite_list_close */
        public class Serializer extends JsonSerializer<EditEventCoreMutationFieldsModel> {
            public final void m16666a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                EditEventCoreMutationFieldsModel editEventCoreMutationFieldsModel = (EditEventCoreMutationFieldsModel) obj;
                if (editEventCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(editEventCoreMutationFieldsModel.m16667a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    editEventCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = editEventCoreMutationFieldsModel.w_();
                int u_ = editEventCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("event");
                    EditEventCoreMutationFieldsParser.EventParser.m16674a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(EditEventCoreMutationFieldsModel.class, new Serializer());
            }
        }

        public EditEventCoreMutationFieldsModel() {
            super(1);
        }

        @Nullable
        public final EventModel m16668a() {
            this.f16264d = (EventModel) super.a(this.f16264d, 0, EventModel.class);
            return this.f16264d;
        }

        public final int jK_() {
            return -842748471;
        }

        public final GraphQLVisitableModel m16669a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16668a() != null) {
                EventModel eventModel = (EventModel) graphQLModelMutatingVisitor.b(m16668a());
                if (m16668a() != eventModel) {
                    graphQLVisitableModel = (EditEventCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16264d = eventModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16667a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16668a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

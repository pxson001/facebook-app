package com.facebook.composer.feedattachment.graphql;

import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLInterfaces.EventAttachment;
import com.facebook.api.graphql.storyattachment.StoryAttachmentGraphQLModels.EventAttachmentModel;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.composer.feedattachment.graphql.FetchEventComposerPreviewParsers.EventStoryAttachmentParser;
import com.facebook.composer.feedattachment.graphql.FetchEventComposerPreviewParsers.FetchEventComposerPreviewParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.enums.GraphQLStoryAttachmentStyle;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: getgames_no_fill_error */
public class FetchEventComposerPreviewModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1632012858)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: getgames_no_fill_error */
    public final class EventStoryAttachmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<GraphQLStoryAttachmentStyle> f6513d;
        @Nullable
        private EventAttachmentModel f6514e;

        /* compiled from: getgames_no_fill_error */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(EventStoryAttachmentModel.class, new Deserializer());
            }

            public Object m7948a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(EventStoryAttachmentParser.m7963a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object eventStoryAttachmentModel = new EventStoryAttachmentModel();
                ((BaseModel) eventStoryAttachmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (eventStoryAttachmentModel instanceof Postprocessable) {
                    return ((Postprocessable) eventStoryAttachmentModel).a();
                }
                return eventStoryAttachmentModel;
            }
        }

        /* compiled from: getgames_no_fill_error */
        public class Serializer extends JsonSerializer<EventStoryAttachmentModel> {
            public final void m7949a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                EventStoryAttachmentModel eventStoryAttachmentModel = (EventStoryAttachmentModel) obj;
                if (eventStoryAttachmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(eventStoryAttachmentModel.m7951a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    eventStoryAttachmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                EventStoryAttachmentParser.m7964a(eventStoryAttachmentModel.w_(), eventStoryAttachmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(EventStoryAttachmentModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ EventAttachment m7954b() {
            return m7950j();
        }

        public EventStoryAttachmentModel() {
            super(2);
        }

        @Nonnull
        public final ImmutableList<GraphQLStoryAttachmentStyle> m7953a() {
            this.f6513d = super.c(this.f6513d, 0, GraphQLStoryAttachmentStyle.class);
            return (ImmutableList) this.f6513d;
        }

        @Nullable
        private EventAttachmentModel m7950j() {
            this.f6514e = (EventAttachmentModel) super.a(this.f6514e, 1, EventAttachmentModel.class);
            return this.f6514e;
        }

        public final int jK_() {
            return -1267730472;
        }

        public final GraphQLVisitableModel m7952a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7950j() != null) {
                EventAttachmentModel eventAttachmentModel = (EventAttachmentModel) graphQLModelMutatingVisitor.b(m7950j());
                if (m7950j() != eventAttachmentModel) {
                    graphQLVisitableModel = (EventStoryAttachmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6514e = eventAttachmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7951a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int d = flatBufferBuilder.d(m7953a());
            int a = ModelHelper.a(flatBufferBuilder, m7950j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, d);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1906956981)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: getgames_no_fill_error */
    public final class FetchEventComposerPreviewModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f6515d;
        @Nullable
        private EventStoryAttachmentModel f6516e;

        /* compiled from: getgames_no_fill_error */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchEventComposerPreviewModel.class, new Deserializer());
            }

            public Object m7955a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchEventComposerPreviewParser.m7965a(jsonParser);
                Object fetchEventComposerPreviewModel = new FetchEventComposerPreviewModel();
                ((BaseModel) fetchEventComposerPreviewModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchEventComposerPreviewModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchEventComposerPreviewModel).a();
                }
                return fetchEventComposerPreviewModel;
            }
        }

        /* compiled from: getgames_no_fill_error */
        public class Serializer extends JsonSerializer<FetchEventComposerPreviewModel> {
            public final void m7956a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchEventComposerPreviewModel fetchEventComposerPreviewModel = (FetchEventComposerPreviewModel) obj;
                if (fetchEventComposerPreviewModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchEventComposerPreviewModel.m7958a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchEventComposerPreviewModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchEventComposerPreviewModel.w_();
                int u_ = fetchEventComposerPreviewModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("open_graph_composer_preview");
                    EventStoryAttachmentParser.m7964a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchEventComposerPreviewModel.class, new Serializer());
            }
        }

        public FetchEventComposerPreviewModel() {
            super(2);
        }

        public final void m7961a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m7962a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m7957j() {
            if (this.b != null && this.f6515d == null) {
                this.f6515d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f6515d;
        }

        @Nullable
        public final EventStoryAttachmentModel m7959a() {
            this.f6516e = (EventStoryAttachmentModel) super.a(this.f6516e, 1, EventStoryAttachmentModel.class);
            return this.f6516e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m7960a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7959a() != null) {
                EventStoryAttachmentModel eventStoryAttachmentModel = (EventStoryAttachmentModel) graphQLModelMutatingVisitor.b(m7959a());
                if (m7959a() != eventStoryAttachmentModel) {
                    graphQLVisitableModel = (FetchEventComposerPreviewModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6516e = eventStoryAttachmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7958a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7957j());
            int a2 = ModelHelper.a(flatBufferBuilder, m7959a());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}

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
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.protocol.TimelineInfoReviewGraphQLModels.InfoReviewItemsFragmentModel;
import com.facebook.timeline.protocol.TimelineInfoReviewMutationParsers.TimelineInfoReviewItemHideMutationParser;
import com.facebook.timeline.protocol.TimelineInfoReviewMutationParsers.TimelineInfoReviewQuestionSaveMutationParser;
import com.facebook.timeline.protocol.TimelineInfoReviewMutationParsers.TimelineInfoReviewQuestionSaveMutationParser.ViewerParser;
import com.facebook.timeline.protocol.TimelineInfoReviewMutationParsers.TimelineInfoReviewQuestionSkipMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: data_source */
public class TimelineInfoReviewMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1421847203)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: data_source */
    public final class TimelineInfoReviewItemHideMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f17888d;

        /* compiled from: data_source */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineInfoReviewItemHideMutationModel.class, new Deserializer());
            }

            public Object m26387a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineInfoReviewItemHideMutationParser.m26412a(jsonParser);
                Object timelineInfoReviewItemHideMutationModel = new TimelineInfoReviewItemHideMutationModel();
                ((BaseModel) timelineInfoReviewItemHideMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineInfoReviewItemHideMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineInfoReviewItemHideMutationModel).a();
                }
                return timelineInfoReviewItemHideMutationModel;
            }
        }

        /* compiled from: data_source */
        public class Serializer extends JsonSerializer<TimelineInfoReviewItemHideMutationModel> {
            public final void m26388a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineInfoReviewItemHideMutationModel timelineInfoReviewItemHideMutationModel = (TimelineInfoReviewItemHideMutationModel) obj;
                if (timelineInfoReviewItemHideMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineInfoReviewItemHideMutationModel.m26390a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineInfoReviewItemHideMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineInfoReviewItemHideMutationModel.w_();
                int u_ = timelineInfoReviewItemHideMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("hidden_timeline_info_review_item_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineInfoReviewItemHideMutationModel.class, new Serializer());
            }
        }

        public TimelineInfoReviewItemHideMutationModel() {
            super(1);
        }

        @Nullable
        private String m26389a() {
            this.f17888d = super.a(this.f17888d, 0);
            return this.f17888d;
        }

        public final int jK_() {
            return 1192752497;
        }

        public final GraphQLVisitableModel m26391a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m26390a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m26389a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 540677771)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: data_source */
    public final class TimelineInfoReviewQuestionSaveMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerModel f17890d;

        /* compiled from: data_source */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineInfoReviewQuestionSaveMutationModel.class, new Deserializer());
            }

            public Object m26392a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineInfoReviewQuestionSaveMutationParser.m26415a(jsonParser);
                Object timelineInfoReviewQuestionSaveMutationModel = new TimelineInfoReviewQuestionSaveMutationModel();
                ((BaseModel) timelineInfoReviewQuestionSaveMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineInfoReviewQuestionSaveMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineInfoReviewQuestionSaveMutationModel).a();
                }
                return timelineInfoReviewQuestionSaveMutationModel;
            }
        }

        /* compiled from: data_source */
        public class Serializer extends JsonSerializer<TimelineInfoReviewQuestionSaveMutationModel> {
            public final void m26393a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineInfoReviewQuestionSaveMutationModel timelineInfoReviewQuestionSaveMutationModel = (TimelineInfoReviewQuestionSaveMutationModel) obj;
                if (timelineInfoReviewQuestionSaveMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineInfoReviewQuestionSaveMutationModel.m26399a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineInfoReviewQuestionSaveMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineInfoReviewQuestionSaveMutationModel.w_();
                int u_ = timelineInfoReviewQuestionSaveMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    ViewerParser.m26414a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineInfoReviewQuestionSaveMutationModel.class, new Serializer());
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 611238419)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: data_source */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private InfoReviewItemsFragmentModel f17889d;

            /* compiled from: data_source */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m26394a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerParser.m26413a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerModel = new ViewerModel();
                    ((BaseModel) viewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerModel).a();
                    }
                    return viewerModel;
                }
            }

            /* compiled from: data_source */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m26395a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m26396a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerParser.m26414a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            public final InfoReviewItemsFragmentModel m26398a() {
                this.f17889d = (InfoReviewItemsFragmentModel) super.a(this.f17889d, 0, InfoReviewItemsFragmentModel.class);
                return this.f17889d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m26397a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m26398a() != null) {
                    InfoReviewItemsFragmentModel infoReviewItemsFragmentModel = (InfoReviewItemsFragmentModel) graphQLModelMutatingVisitor.b(m26398a());
                    if (m26398a() != infoReviewItemsFragmentModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17889d = infoReviewItemsFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m26396a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m26398a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public TimelineInfoReviewQuestionSaveMutationModel() {
            super(1);
        }

        @Nullable
        public final ViewerModel m26401a() {
            this.f17890d = (ViewerModel) super.a(this.f17890d, 0, ViewerModel.class);
            return this.f17890d;
        }

        public final int jK_() {
            return 1810814401;
        }

        public final GraphQLVisitableModel m26400a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26401a() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m26401a());
                if (m26401a() != viewerModel) {
                    graphQLVisitableModel = (TimelineInfoReviewQuestionSaveMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17890d = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26399a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26401a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1201701062)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: data_source */
    public final class TimelineInfoReviewQuestionSkipMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerModel f17892d;

        /* compiled from: data_source */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TimelineInfoReviewQuestionSkipMutationModel.class, new Deserializer());
            }

            public Object m26402a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TimelineInfoReviewQuestionSkipMutationParser.m26418a(jsonParser);
                Object timelineInfoReviewQuestionSkipMutationModel = new TimelineInfoReviewQuestionSkipMutationModel();
                ((BaseModel) timelineInfoReviewQuestionSkipMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (timelineInfoReviewQuestionSkipMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) timelineInfoReviewQuestionSkipMutationModel).a();
                }
                return timelineInfoReviewQuestionSkipMutationModel;
            }
        }

        /* compiled from: data_source */
        public class Serializer extends JsonSerializer<TimelineInfoReviewQuestionSkipMutationModel> {
            public final void m26403a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TimelineInfoReviewQuestionSkipMutationModel timelineInfoReviewQuestionSkipMutationModel = (TimelineInfoReviewQuestionSkipMutationModel) obj;
                if (timelineInfoReviewQuestionSkipMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(timelineInfoReviewQuestionSkipMutationModel.m26409a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    timelineInfoReviewQuestionSkipMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = timelineInfoReviewQuestionSkipMutationModel.w_();
                int u_ = timelineInfoReviewQuestionSkipMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    TimelineInfoReviewQuestionSkipMutationParser.ViewerParser.m26417a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TimelineInfoReviewQuestionSkipMutationModel.class, new Serializer());
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 611238419)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: data_source */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private InfoReviewItemsFragmentModel f17891d;

            /* compiled from: data_source */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m26404a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(TimelineInfoReviewQuestionSkipMutationParser.ViewerParser.m26416a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object viewerModel = new ViewerModel();
                    ((BaseModel) viewerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (viewerModel instanceof Postprocessable) {
                        return ((Postprocessable) viewerModel).a();
                    }
                    return viewerModel;
                }
            }

            /* compiled from: data_source */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m26405a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m26406a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    TimelineInfoReviewQuestionSkipMutationParser.ViewerParser.m26417a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            public final InfoReviewItemsFragmentModel m26408a() {
                this.f17891d = (InfoReviewItemsFragmentModel) super.a(this.f17891d, 0, InfoReviewItemsFragmentModel.class);
                return this.f17891d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m26407a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m26408a() != null) {
                    InfoReviewItemsFragmentModel infoReviewItemsFragmentModel = (InfoReviewItemsFragmentModel) graphQLModelMutatingVisitor.b(m26408a());
                    if (m26408a() != infoReviewItemsFragmentModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f17891d = infoReviewItemsFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m26406a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m26408a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public TimelineInfoReviewQuestionSkipMutationModel() {
            super(1);
        }

        @Nullable
        public final ViewerModel m26411a() {
            this.f17892d = (ViewerModel) super.a(this.f17892d, 0, ViewerModel.class);
            return this.f17892d;
        }

        public final int jK_() {
            return -1304040065;
        }

        public final GraphQLVisitableModel m26410a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m26411a() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m26411a());
                if (m26411a() != viewerModel) {
                    graphQLVisitableModel = (TimelineInfoReviewQuestionSkipMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f17892d = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m26409a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m26411a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

package com.facebook.api.graphql.feedback;

import com.facebook.api.graphql.feedback.FeedbackSubscriptionMutationsParsers.FeedbackSubscribeMutationFragmentParser;
import com.facebook.api.graphql.feedback.FeedbackSubscriptionMutationsParsers.FeedbackSubscribeMutationFragmentParser.FeedbackParser;
import com.facebook.api.graphql.feedback.FeedbackSubscriptionMutationsParsers.FeedbackUnsubscribeMutationFragmentParser;
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

/* compiled from: answers */
public class FeedbackSubscriptionMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 606005974)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: answers */
    public final class FeedbackSubscribeMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FeedbackModel f9538d;

        /* compiled from: answers */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackSubscribeMutationFragmentModel.class, new Deserializer());
            }

            public Object m16301a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FeedbackSubscribeMutationFragmentParser.m16337a(jsonParser);
                Object feedbackSubscribeMutationFragmentModel = new FeedbackSubscribeMutationFragmentModel();
                ((BaseModel) feedbackSubscribeMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (feedbackSubscribeMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackSubscribeMutationFragmentModel).a();
                }
                return feedbackSubscribeMutationFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 379122655)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: answers */
        public final class FeedbackModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f9535d;
            private boolean f9536e;
            @Nullable
            private String f9537f;

            /* compiled from: answers */
            public final class Builder {
                @Nullable
                public String f9532a;
                public boolean f9533b;
                @Nullable
                public String f9534c;
            }

            /* compiled from: answers */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                }

                public Object m16302a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedbackParser.m16335a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object feedbackModel = new FeedbackModel();
                    ((BaseModel) feedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (feedbackModel instanceof Postprocessable) {
                        return ((Postprocessable) feedbackModel).a();
                    }
                    return feedbackModel;
                }
            }

            /* compiled from: answers */
            public class Serializer extends JsonSerializer<FeedbackModel> {
                public final void m16303a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackModel feedbackModel = (FeedbackModel) obj;
                    if (feedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackModel.m16308a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedbackParser.m16336a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                }
            }

            public FeedbackModel() {
                super(3);
            }

            public FeedbackModel(MutableFlatBuffer mutableFlatBuffer) {
                super(3);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m16312a(String str, ConsistencyTuple consistencyTuple) {
                if ("is_viewer_subscribed".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m16306k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m16313a(String str, Object obj, boolean z) {
                if ("is_viewer_subscribed".equals(str)) {
                    m16304a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private String m16305j() {
                this.f9535d = super.a(this.f9535d, 0);
                return this.f9535d;
            }

            private boolean m16306k() {
                a(0, 1);
                return this.f9536e;
            }

            private void m16304a(boolean z) {
                this.f9536e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            @Nullable
            private String m16307l() {
                this.f9537f = super.a(this.f9537f, 2);
                return this.f9537f;
            }

            @Nullable
            public final String m16310a() {
                return m16307l();
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m16309a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16308a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16305j());
                int b2 = flatBufferBuilder.b(m16307l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f9536e);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16311a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9536e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: answers */
        public class Serializer extends JsonSerializer<FeedbackSubscribeMutationFragmentModel> {
            public final void m16314a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedbackSubscribeMutationFragmentModel feedbackSubscribeMutationFragmentModel = (FeedbackSubscribeMutationFragmentModel) obj;
                if (feedbackSubscribeMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackSubscribeMutationFragmentModel.m16316a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackSubscribeMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedbackSubscribeMutationFragmentModel.w_();
                int u_ = feedbackSubscribeMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackParser.m16336a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeedbackSubscribeMutationFragmentModel.class, new Serializer());
            }
        }

        public FeedbackSubscribeMutationFragmentModel() {
            super(1);
        }

        @Nullable
        private FeedbackModel m16315a() {
            this.f9538d = (FeedbackModel) super.a(this.f9538d, 0, FeedbackModel.class);
            return this.f9538d;
        }

        public final int jK_() {
            return -364528600;
        }

        public final GraphQLVisitableModel m16317a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16315a() != null) {
                FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m16315a());
                if (m16315a() != feedbackModel) {
                    graphQLVisitableModel = (FeedbackSubscribeMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9538d = feedbackModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16316a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16315a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -478368453)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: answers */
    public final class FeedbackUnsubscribeMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FeedbackModel f9542d;

        /* compiled from: answers */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackUnsubscribeMutationFragmentModel.class, new Deserializer());
            }

            public Object m16318a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FeedbackUnsubscribeMutationFragmentParser.m16340a(jsonParser);
                Object feedbackUnsubscribeMutationFragmentModel = new FeedbackUnsubscribeMutationFragmentModel();
                ((BaseModel) feedbackUnsubscribeMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (feedbackUnsubscribeMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackUnsubscribeMutationFragmentModel).a();
                }
                return feedbackUnsubscribeMutationFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 379122655)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: answers */
        public final class FeedbackModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f9539d;
            private boolean f9540e;
            @Nullable
            private String f9541f;

            /* compiled from: answers */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeedbackModel.class, new Deserializer());
                }

                public Object m16319a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeedbackUnsubscribeMutationFragmentParser.FeedbackParser.m16338a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object feedbackModel = new FeedbackModel();
                    ((BaseModel) feedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (feedbackModel instanceof Postprocessable) {
                        return ((Postprocessable) feedbackModel).a();
                    }
                    return feedbackModel;
                }
            }

            /* compiled from: answers */
            public class Serializer extends JsonSerializer<FeedbackModel> {
                public final void m16320a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeedbackModel feedbackModel = (FeedbackModel) obj;
                    if (feedbackModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(feedbackModel.m16325a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        feedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeedbackUnsubscribeMutationFragmentParser.FeedbackParser.m16339a(feedbackModel.w_(), feedbackModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FeedbackModel.class, new Serializer());
                }
            }

            public FeedbackModel() {
                super(3);
            }

            public final void m16329a(String str, ConsistencyTuple consistencyTuple) {
                if ("is_viewer_subscribed".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m16323k());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 1;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m16330a(String str, Object obj, boolean z) {
                if ("is_viewer_subscribed".equals(str)) {
                    m16321a(((Boolean) obj).booleanValue());
                }
            }

            @Nullable
            private String m16322j() {
                this.f9539d = super.a(this.f9539d, 0);
                return this.f9539d;
            }

            private boolean m16323k() {
                a(0, 1);
                return this.f9540e;
            }

            private void m16321a(boolean z) {
                this.f9540e = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 1, z);
                }
            }

            @Nullable
            private String m16324l() {
                this.f9541f = super.a(this.f9541f, 2);
                return this.f9541f;
            }

            @Nullable
            public final String m16327a() {
                return m16324l();
            }

            public final int jK_() {
                return -126857307;
            }

            public final GraphQLVisitableModel m16326a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16325a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m16322j());
                int b2 = flatBufferBuilder.b(m16324l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f9540e);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16328a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9540e = mutableFlatBuffer.a(i, 1);
            }
        }

        /* compiled from: answers */
        public class Serializer extends JsonSerializer<FeedbackUnsubscribeMutationFragmentModel> {
            public final void m16331a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FeedbackUnsubscribeMutationFragmentModel feedbackUnsubscribeMutationFragmentModel = (FeedbackUnsubscribeMutationFragmentModel) obj;
                if (feedbackUnsubscribeMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackUnsubscribeMutationFragmentModel.m16333a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackUnsubscribeMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = feedbackUnsubscribeMutationFragmentModel.w_();
                int u_ = feedbackUnsubscribeMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FeedbackUnsubscribeMutationFragmentParser.FeedbackParser.m16339a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FeedbackUnsubscribeMutationFragmentModel.class, new Serializer());
            }
        }

        public FeedbackUnsubscribeMutationFragmentModel() {
            super(1);
        }

        @Nullable
        private FeedbackModel m16332a() {
            this.f9542d = (FeedbackModel) super.a(this.f9542d, 0, FeedbackModel.class);
            return this.f9542d;
        }

        public final int jK_() {
            return 1390916225;
        }

        public final GraphQLVisitableModel m16334a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16332a() != null) {
                FeedbackModel feedbackModel = (FeedbackModel) graphQLModelMutatingVisitor.b(m16332a());
                if (m16332a() != feedbackModel) {
                    graphQLVisitableModel = (FeedbackUnsubscribeMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9542d = feedbackModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16333a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16332a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

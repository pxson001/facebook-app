package com.facebook.universalfeedback.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.universalfeedback.graphql.UniversalFeedbackSubmissionMutationParsers.FBUniversalFeedbackSubmissionMutationFragmentParser;
import com.facebook.universalfeedback.graphql.UniversalFeedbackSubmissionMutationParsers.FBUniversalFeedbackSubmissionMutationFragmentParser.ViewerParser;
import com.facebook.universalfeedback.graphql.UniversalFeedbackSubmissionMutationParsers.FBUniversalFeedbackSubmissionMutationFragmentParser.ViewerParser.ActorParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: edts */
public class UniversalFeedbackSubmissionMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1363928159)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: edts */
    public final class FBUniversalFeedbackSubmissionMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ViewerModel f15366d;

        /* compiled from: edts */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBUniversalFeedbackSubmissionMutationFragmentModel.class, new Deserializer());
            }

            public Object m19363a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBUniversalFeedbackSubmissionMutationFragmentParser.m19386a(jsonParser);
                Object fBUniversalFeedbackSubmissionMutationFragmentModel = new FBUniversalFeedbackSubmissionMutationFragmentModel();
                ((BaseModel) fBUniversalFeedbackSubmissionMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBUniversalFeedbackSubmissionMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBUniversalFeedbackSubmissionMutationFragmentModel).a();
                }
                return fBUniversalFeedbackSubmissionMutationFragmentModel;
            }
        }

        /* compiled from: edts */
        public class Serializer extends JsonSerializer<FBUniversalFeedbackSubmissionMutationFragmentModel> {
            public final void m19364a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBUniversalFeedbackSubmissionMutationFragmentModel fBUniversalFeedbackSubmissionMutationFragmentModel = (FBUniversalFeedbackSubmissionMutationFragmentModel) obj;
                if (fBUniversalFeedbackSubmissionMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBUniversalFeedbackSubmissionMutationFragmentModel.m19380a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBUniversalFeedbackSubmissionMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBUniversalFeedbackSubmissionMutationFragmentModel.w_();
                int u_ = fBUniversalFeedbackSubmissionMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    ViewerParser.m19385a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBUniversalFeedbackSubmissionMutationFragmentModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -544748737)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: edts */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private ActorModel f15365d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1787905591)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: edts */
            public final class ActorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private GraphQLObjectType f15363d;
                @Nullable
                private String f15364e;

                /* compiled from: edts */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(ActorModel.class, new Deserializer());
                    }

                    public Object m19365a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(ActorParser.m19382a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object actorModel = new ActorModel();
                        ((BaseModel) actorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (actorModel instanceof Postprocessable) {
                            return ((Postprocessable) actorModel).a();
                        }
                        return actorModel;
                    }
                }

                /* compiled from: edts */
                public class Serializer extends JsonSerializer<ActorModel> {
                    public final void m19366a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        ActorModel actorModel = (ActorModel) obj;
                        if (actorModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(actorModel.m19369a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            actorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ActorParser.m19383a(actorModel.w_(), actorModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(ActorModel.class, new Serializer());
                    }
                }

                public ActorModel() {
                    super(2);
                }

                public final void m19372a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m19373a(String str, Object obj, boolean z) {
                }

                @Nullable
                private GraphQLObjectType m19367j() {
                    if (this.b != null && this.f15363d == null) {
                        this.f15363d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f15363d;
                }

                @Nullable
                private String m19368k() {
                    this.f15364e = super.a(this.f15364e, 1);
                    return this.f15364e;
                }

                @Nullable
                public final String m19371a() {
                    return m19368k();
                }

                public final int jK_() {
                    return 63093205;
                }

                public final GraphQLVisitableModel m19370a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m19369a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m19367j());
                    int b = flatBufferBuilder.b(m19368k());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: edts */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m19374a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerParser.m19384a(jsonParser, flatBufferBuilder));
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

            /* compiled from: edts */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m19375a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m19377a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ViewerParser.m19385a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            private ActorModel m19376a() {
                this.f15365d = (ActorModel) super.a(this.f15365d, 0, ActorModel.class);
                return this.f15365d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m19378a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m19376a() != null) {
                    ActorModel actorModel = (ActorModel) graphQLModelMutatingVisitor.b(m19376a());
                    if (m19376a() != actorModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f15365d = actorModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m19377a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m19376a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public FBUniversalFeedbackSubmissionMutationFragmentModel() {
            super(1);
        }

        @Nullable
        private ViewerModel m19379a() {
            this.f15366d = (ViewerModel) super.a(this.f15366d, 0, ViewerModel.class);
            return this.f15366d;
        }

        public final int jK_() {
            return 1621760135;
        }

        public final GraphQLVisitableModel m19381a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19379a() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m19379a());
                if (m19379a() != viewerModel) {
                    graphQLVisitableModel = (FBUniversalFeedbackSubmissionMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f15366d = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19380a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19379a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

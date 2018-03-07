package com.facebook.api.graphql.likes;

import com.facebook.api.graphql.likes.LikeMutationsParsers.FBFeedbackLikeCoreMutationFragmentParser;
import com.facebook.api.graphql.likes.LikeMutationsParsers.FBFeedbackLikeMutationFragmentParser;
import com.facebook.api.graphql.likes.LikeMutationsParsers.FBFeedbackLikeMutationFragmentParser.LikersParser;
import com.facebook.api.graphql.likes.LikeMutationsParsers.FBFeedbackUnlikeCoreMutationFragmentParser;
import com.facebook.api.graphql.likes.LikeMutationsParsers.FeedbackTextWithEntitiesWithRangesFieldsParser;
import com.facebook.api.graphql.likes.LikeMutationsParsers.FeedbackTextWithEntitiesWithRangesFieldsParser.AggregatedRangesParser;
import com.facebook.api.graphql.likes.LikeMutationsParsers.FeedbackTextWithEntitiesWithRangesFieldsParser.AggregatedRangesParser.SampleEntitiesParser;
import com.facebook.api.graphql.likes.LikeMutationsParsers.PageLikeParser;
import com.facebook.api.graphql.likes.LikeMutationsParsers.PageToggleLikeFragmentParser;
import com.facebook.api.graphql.likes.LikeMutationsParsers.PageUnlikeParser;
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
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel.RangesModel;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.nio.ByteBuffer;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/* compiled from: android_report_place_incorrect_information */
public class LikeMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1374167770)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_report_place_incorrect_information */
    public final class FBFeedbackLikeCoreMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FBFeedbackLikeMutationFragmentModel f9684d;

        /* compiled from: android_report_place_incorrect_information */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBFeedbackLikeCoreMutationFragmentModel.class, new Deserializer());
            }

            public Object m16697a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBFeedbackLikeCoreMutationFragmentParser.m16776a(jsonParser);
                Object fBFeedbackLikeCoreMutationFragmentModel = new FBFeedbackLikeCoreMutationFragmentModel();
                ((BaseModel) fBFeedbackLikeCoreMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBFeedbackLikeCoreMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBFeedbackLikeCoreMutationFragmentModel).a();
                }
                return fBFeedbackLikeCoreMutationFragmentModel;
            }
        }

        /* compiled from: android_report_place_incorrect_information */
        public class Serializer extends JsonSerializer<FBFeedbackLikeCoreMutationFragmentModel> {
            public final void m16698a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBFeedbackLikeCoreMutationFragmentModel fBFeedbackLikeCoreMutationFragmentModel = (FBFeedbackLikeCoreMutationFragmentModel) obj;
                if (fBFeedbackLikeCoreMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBFeedbackLikeCoreMutationFragmentModel.m16700a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBFeedbackLikeCoreMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBFeedbackLikeCoreMutationFragmentModel.w_();
                int u_ = fBFeedbackLikeCoreMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FBFeedbackLikeMutationFragmentParser.m16780a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBFeedbackLikeCoreMutationFragmentModel.class, new Serializer());
            }
        }

        public FBFeedbackLikeCoreMutationFragmentModel() {
            super(1);
        }

        @Nullable
        private FBFeedbackLikeMutationFragmentModel m16699a() {
            this.f9684d = (FBFeedbackLikeMutationFragmentModel) super.a(this.f9684d, 0, FBFeedbackLikeMutationFragmentModel.class);
            return this.f9684d;
        }

        public final int jK_() {
            return 721130897;
        }

        public final GraphQLVisitableModel m16701a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16699a() != null) {
                FBFeedbackLikeMutationFragmentModel fBFeedbackLikeMutationFragmentModel = (FBFeedbackLikeMutationFragmentModel) graphQLModelMutatingVisitor.b(m16699a());
                if (m16699a() != fBFeedbackLikeMutationFragmentModel) {
                    graphQLVisitableModel = (FBFeedbackLikeCoreMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9684d = fBFeedbackLikeMutationFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16700a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16699a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -152011631)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_report_place_incorrect_information */
    public final class FBFeedbackLikeMutationFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f9694d;
        @Nullable
        private String f9695e;
        @Nullable
        private String f9696f;
        @Nullable
        private FeedbackTextWithEntitiesWithRangesFieldsModel f9697g;
        @Nullable
        private LikersModel f9698h;
        @Nullable
        private FeedbackTextWithEntitiesWithRangesFieldsModel f9699i;
        @Nullable
        private FeedbackTextWithEntitiesWithRangesFieldsModel f9700j;

        /* compiled from: android_report_place_incorrect_information */
        public final class Builder {
            public boolean f9685a;
            @Nullable
            public String f9686b;
            @Nullable
            public String f9687c;
            @Nullable
            public FeedbackTextWithEntitiesWithRangesFieldsModel f9688d;
            @Nullable
            public LikersModel f9689e;
            @Nullable
            public FeedbackTextWithEntitiesWithRangesFieldsModel f9690f;
            @Nullable
            public FeedbackTextWithEntitiesWithRangesFieldsModel f9691g;

            public final FBFeedbackLikeMutationFragmentModel m16702a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f9686b);
                int b2 = flatBufferBuilder.b(this.f9687c);
                int a = ModelHelper.a(flatBufferBuilder, this.f9688d);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f9689e);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f9690f);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f9691g);
                flatBufferBuilder.c(7);
                flatBufferBuilder.a(0, this.f9685a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                flatBufferBuilder.b(3, a);
                flatBufferBuilder.b(4, a2);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.b(6, a4);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new FBFeedbackLikeMutationFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: android_report_place_incorrect_information */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBFeedbackLikeMutationFragmentModel.class, new Deserializer());
            }

            public Object m16703a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FBFeedbackLikeMutationFragmentParser.m16779a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object fBFeedbackLikeMutationFragmentModel = new FBFeedbackLikeMutationFragmentModel();
                ((BaseModel) fBFeedbackLikeMutationFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (fBFeedbackLikeMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBFeedbackLikeMutationFragmentModel).a();
                }
                return fBFeedbackLikeMutationFragmentModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1723990064)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_report_place_incorrect_information */
        public final class LikersModel extends BaseModel implements GraphQLVisitableModel {
            private int f9693d;

            /* compiled from: android_report_place_incorrect_information */
            public final class Builder {
                public int f9692a;
            }

            /* compiled from: android_report_place_incorrect_information */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LikersModel.class, new Deserializer());
                }

                public Object m16704a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LikersParser.m16777a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object likersModel = new LikersModel();
                    ((BaseModel) likersModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (likersModel instanceof Postprocessable) {
                        return ((Postprocessable) likersModel).a();
                    }
                    return likersModel;
                }
            }

            /* compiled from: android_report_place_incorrect_information */
            public class Serializer extends JsonSerializer<LikersModel> {
                public final void m16705a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LikersModel likersModel = (LikersModel) obj;
                    if (likersModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(likersModel.m16707a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        likersModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LikersParser.m16778a(likersModel.w_(), likersModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LikersModel.class, new Serializer());
                }
            }

            public LikersModel() {
                super(1);
            }

            public LikersModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final int m16706a() {
                a(0, 0);
                return this.f9693d;
            }

            public final void m16709a(int i) {
                this.f9693d = i;
                if (this.b != null && this.b.d) {
                    this.b.b(this.c, 0, i);
                }
            }

            public final int jK_() {
                return 733369288;
            }

            public final GraphQLVisitableModel m16708a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m16707a(FlatBufferBuilder flatBufferBuilder) {
                h();
                flatBufferBuilder.c(1);
                flatBufferBuilder.a(0, this.f9693d, 0);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16710a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9693d = mutableFlatBuffer.a(i, 0, 0);
            }
        }

        /* compiled from: android_report_place_incorrect_information */
        public class Serializer extends JsonSerializer<FBFeedbackLikeMutationFragmentModel> {
            public final void m16711a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FBFeedbackLikeMutationFragmentModel fBFeedbackLikeMutationFragmentModel = (FBFeedbackLikeMutationFragmentModel) obj;
                if (fBFeedbackLikeMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBFeedbackLikeMutationFragmentModel.m16720a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBFeedbackLikeMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FBFeedbackLikeMutationFragmentParser.m16780a(fBFeedbackLikeMutationFragmentModel.w_(), fBFeedbackLikeMutationFragmentModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FBFeedbackLikeMutationFragmentModel.class, new Serializer());
            }
        }

        public FBFeedbackLikeMutationFragmentModel() {
            super(7);
        }

        public FBFeedbackLikeMutationFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(7);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m16724a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16713j());
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
                return;
            }
            if ("likers.count".equals(str)) {
                LikersModel n = m16717n();
                if (n != null) {
                    consistencyTuple.a = Integer.valueOf(n.m16706a());
                    consistencyTuple.b = n.u_();
                    consistencyTuple.c = 0;
                    return;
                }
            }
            consistencyTuple.a();
        }

        public final void m16725a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m16712a(((Boolean) obj).booleanValue());
            } else if ("likers.count".equals(str)) {
                LikersModel n = m16717n();
                if (n == null) {
                    return;
                }
                if (z) {
                    n = (LikersModel) n.clone();
                    n.m16709a(((Integer) obj).intValue());
                    this.f9698h = n;
                    return;
                }
                n.m16709a(((Integer) obj).intValue());
            }
        }

        private boolean m16713j() {
            a(0, 0);
            return this.f9694d;
        }

        private void m16712a(boolean z) {
            this.f9694d = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, z);
            }
        }

        @Nullable
        private String m16714k() {
            this.f9695e = super.a(this.f9695e, 1);
            return this.f9695e;
        }

        @Nullable
        private String m16715l() {
            this.f9696f = super.a(this.f9696f, 2);
            return this.f9696f;
        }

        @Nullable
        private FeedbackTextWithEntitiesWithRangesFieldsModel m16716m() {
            this.f9697g = (FeedbackTextWithEntitiesWithRangesFieldsModel) super.a(this.f9697g, 3, FeedbackTextWithEntitiesWithRangesFieldsModel.class);
            return this.f9697g;
        }

        @Nullable
        private LikersModel m16717n() {
            this.f9698h = (LikersModel) super.a(this.f9698h, 4, LikersModel.class);
            return this.f9698h;
        }

        @Nullable
        private FeedbackTextWithEntitiesWithRangesFieldsModel m16718o() {
            this.f9699i = (FeedbackTextWithEntitiesWithRangesFieldsModel) super.a(this.f9699i, 5, FeedbackTextWithEntitiesWithRangesFieldsModel.class);
            return this.f9699i;
        }

        @Nullable
        private FeedbackTextWithEntitiesWithRangesFieldsModel m16719p() {
            this.f9700j = (FeedbackTextWithEntitiesWithRangesFieldsModel) super.a(this.f9700j, 6, FeedbackTextWithEntitiesWithRangesFieldsModel.class);
            return this.f9700j;
        }

        @Nullable
        public final String m16722a() {
            return m16715l();
        }

        public final int jK_() {
            return -126857307;
        }

        public final GraphQLVisitableModel m16721a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            FeedbackTextWithEntitiesWithRangesFieldsModel feedbackTextWithEntitiesWithRangesFieldsModel;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16716m() != null) {
                feedbackTextWithEntitiesWithRangesFieldsModel = (FeedbackTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(m16716m());
                if (m16716m() != feedbackTextWithEntitiesWithRangesFieldsModel) {
                    graphQLVisitableModel = (FBFeedbackLikeMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9697g = feedbackTextWithEntitiesWithRangesFieldsModel;
                }
            }
            if (m16717n() != null) {
                LikersModel likersModel = (LikersModel) graphQLModelMutatingVisitor.b(m16717n());
                if (m16717n() != likersModel) {
                    graphQLVisitableModel = (FBFeedbackLikeMutationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9698h = likersModel;
                }
            }
            if (m16718o() != null) {
                feedbackTextWithEntitiesWithRangesFieldsModel = (FeedbackTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(m16718o());
                if (m16718o() != feedbackTextWithEntitiesWithRangesFieldsModel) {
                    graphQLVisitableModel = (FBFeedbackLikeMutationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9699i = feedbackTextWithEntitiesWithRangesFieldsModel;
                }
            }
            if (m16719p() != null) {
                feedbackTextWithEntitiesWithRangesFieldsModel = (FeedbackTextWithEntitiesWithRangesFieldsModel) graphQLModelMutatingVisitor.b(m16719p());
                if (m16719p() != feedbackTextWithEntitiesWithRangesFieldsModel) {
                    graphQLVisitableModel = (FBFeedbackLikeMutationFragmentModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9700j = feedbackTextWithEntitiesWithRangesFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16720a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16714k());
            int b2 = flatBufferBuilder.b(m16715l());
            int a = ModelHelper.a(flatBufferBuilder, m16716m());
            int a2 = ModelHelper.a(flatBufferBuilder, m16717n());
            int a3 = ModelHelper.a(flatBufferBuilder, m16718o());
            int a4 = ModelHelper.a(flatBufferBuilder, m16719p());
            flatBufferBuilder.c(7);
            flatBufferBuilder.a(0, this.f9694d);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, a);
            flatBufferBuilder.b(4, a2);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16723a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9694d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1374167770)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_report_place_incorrect_information */
    public final class FBFeedbackUnlikeCoreMutationFragmentModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FBFeedbackLikeMutationFragmentModel f9701d;

        /* compiled from: android_report_place_incorrect_information */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBFeedbackUnlikeCoreMutationFragmentModel.class, new Deserializer());
            }

            public Object m16726a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBFeedbackUnlikeCoreMutationFragmentParser.m16781a(jsonParser);
                Object fBFeedbackUnlikeCoreMutationFragmentModel = new FBFeedbackUnlikeCoreMutationFragmentModel();
                ((BaseModel) fBFeedbackUnlikeCoreMutationFragmentModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBFeedbackUnlikeCoreMutationFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) fBFeedbackUnlikeCoreMutationFragmentModel).a();
                }
                return fBFeedbackUnlikeCoreMutationFragmentModel;
            }
        }

        /* compiled from: android_report_place_incorrect_information */
        public class Serializer extends JsonSerializer<FBFeedbackUnlikeCoreMutationFragmentModel> {
            public final void m16727a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBFeedbackUnlikeCoreMutationFragmentModel fBFeedbackUnlikeCoreMutationFragmentModel = (FBFeedbackUnlikeCoreMutationFragmentModel) obj;
                if (fBFeedbackUnlikeCoreMutationFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBFeedbackUnlikeCoreMutationFragmentModel.m16729a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBFeedbackUnlikeCoreMutationFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBFeedbackUnlikeCoreMutationFragmentModel.w_();
                int u_ = fBFeedbackUnlikeCoreMutationFragmentModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("feedback");
                    FBFeedbackLikeMutationFragmentParser.m16780a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBFeedbackUnlikeCoreMutationFragmentModel.class, new Serializer());
            }
        }

        public FBFeedbackUnlikeCoreMutationFragmentModel() {
            super(1);
        }

        @Nullable
        private FBFeedbackLikeMutationFragmentModel m16728a() {
            this.f9701d = (FBFeedbackLikeMutationFragmentModel) super.a(this.f9701d, 0, FBFeedbackLikeMutationFragmentModel.class);
            return this.f9701d;
        }

        public final int jK_() {
            return 787303320;
        }

        public final GraphQLVisitableModel m16730a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16728a() != null) {
                FBFeedbackLikeMutationFragmentModel fBFeedbackLikeMutationFragmentModel = (FBFeedbackLikeMutationFragmentModel) graphQLModelMutatingVisitor.b(m16728a());
                if (m16728a() != fBFeedbackLikeMutationFragmentModel) {
                    graphQLVisitableModel = (FBFeedbackUnlikeCoreMutationFragmentModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9701d = fBFeedbackLikeMutationFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16729a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16728a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 2106320960)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_report_place_incorrect_information */
    public final class FeedbackTextWithEntitiesWithRangesFieldsModel extends BaseModel implements DefaultTextWithEntitiesLongFields, GraphQLVisitableModel {
        @Nullable
        private List<AggregatedRangesModel> f9710d;
        @Nullable
        private List<RangesModel> f9711e;
        @Nullable
        private String f9712f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 398416264)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: android_report_place_incorrect_information */
        public final class AggregatedRangesModel extends BaseModel implements GraphQLVisitableModel {
            private int f9706d;
            private int f9707e;
            private int f9708f;
            @Nullable
            private List<SampleEntitiesModel> f9709g;

            /* compiled from: android_report_place_incorrect_information */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(AggregatedRangesModel.class, new Deserializer());
                }

                public Object m16731a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(AggregatedRangesParser.m16785b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object aggregatedRangesModel = new AggregatedRangesModel();
                    ((BaseModel) aggregatedRangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (aggregatedRangesModel instanceof Postprocessable) {
                        return ((Postprocessable) aggregatedRangesModel).a();
                    }
                    return aggregatedRangesModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1821837936)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: android_report_place_incorrect_information */
            public final class SampleEntitiesModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
                @Nullable
                private GraphQLObjectType f9702d;
                @Nullable
                private String f9703e;
                @Nullable
                private String f9704f;
                @Nullable
                private String f9705g;

                /* compiled from: android_report_place_incorrect_information */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(SampleEntitiesModel.class, new Deserializer());
                    }

                    public Object m16732a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(SampleEntitiesParser.m16784b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object sampleEntitiesModel = new SampleEntitiesModel();
                        ((BaseModel) sampleEntitiesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (sampleEntitiesModel instanceof Postprocessable) {
                            return ((Postprocessable) sampleEntitiesModel).a();
                        }
                        return sampleEntitiesModel;
                    }
                }

                /* compiled from: android_report_place_incorrect_information */
                public class Serializer extends JsonSerializer<SampleEntitiesModel> {
                    public final void m16733a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        SampleEntitiesModel sampleEntitiesModel = (SampleEntitiesModel) obj;
                        if (sampleEntitiesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(sampleEntitiesModel.m16738a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            sampleEntitiesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        SampleEntitiesParser.m16783a(sampleEntitiesModel.w_(), sampleEntitiesModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(SampleEntitiesModel.class, new Serializer());
                    }
                }

                public SampleEntitiesModel() {
                    super(4);
                }

                @Nullable
                private GraphQLObjectType m16734j() {
                    if (this.b != null && this.f9702d == null) {
                        this.f9702d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                    }
                    return this.f9702d;
                }

                @Nullable
                private String m16735k() {
                    this.f9703e = super.a(this.f9703e, 1);
                    return this.f9703e;
                }

                @Nullable
                private String m16736l() {
                    this.f9704f = super.a(this.f9704f, 2);
                    return this.f9704f;
                }

                @Nullable
                private String m16737m() {
                    this.f9705g = super.a(this.f9705g, 3);
                    return this.f9705g;
                }

                @Nullable
                public final String m16740a() {
                    return m16735k();
                }

                public final int jK_() {
                    return 2080559107;
                }

                public final GraphQLVisitableModel m16739a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m16738a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m16734j());
                    int b = flatBufferBuilder.b(m16735k());
                    int b2 = flatBufferBuilder.b(m16736l());
                    int b3 = flatBufferBuilder.b(m16737m());
                    flatBufferBuilder.c(4);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, b);
                    flatBufferBuilder.b(2, b2);
                    flatBufferBuilder.b(3, b3);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: android_report_place_incorrect_information */
            public class Serializer extends JsonSerializer<AggregatedRangesModel> {
                public final void m16741a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    AggregatedRangesModel aggregatedRangesModel = (AggregatedRangesModel) obj;
                    if (aggregatedRangesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(aggregatedRangesModel.m16743a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        aggregatedRangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    AggregatedRangesParser.m16786b(aggregatedRangesModel.w_(), aggregatedRangesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(AggregatedRangesModel.class, new Serializer());
                }
            }

            public AggregatedRangesModel() {
                super(4);
            }

            @Nonnull
            private ImmutableList<SampleEntitiesModel> m16742a() {
                this.f9709g = super.a(this.f9709g, 3, SampleEntitiesModel.class);
                return (ImmutableList) this.f9709g;
            }

            public final int jK_() {
                return 1563462756;
            }

            public final GraphQLVisitableModel m16744a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m16742a() != null) {
                    Builder a = ModelHelper.a(m16742a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (AggregatedRangesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f9709g = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m16743a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m16742a());
                flatBufferBuilder.c(4);
                flatBufferBuilder.a(0, this.f9706d, 0);
                flatBufferBuilder.a(1, this.f9707e, 0);
                flatBufferBuilder.a(2, this.f9708f, 0);
                flatBufferBuilder.b(3, a);
                i();
                return flatBufferBuilder.d();
            }

            public final void m16745a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f9706d = mutableFlatBuffer.a(i, 0, 0);
                this.f9707e = mutableFlatBuffer.a(i, 1, 0);
                this.f9708f = mutableFlatBuffer.a(i, 2, 0);
            }
        }

        /* compiled from: android_report_place_incorrect_information */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FeedbackTextWithEntitiesWithRangesFieldsModel.class, new Deserializer());
            }

            public Object m16746a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(FeedbackTextWithEntitiesWithRangesFieldsParser.m16787a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object feedbackTextWithEntitiesWithRangesFieldsModel = new FeedbackTextWithEntitiesWithRangesFieldsModel();
                ((BaseModel) feedbackTextWithEntitiesWithRangesFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (feedbackTextWithEntitiesWithRangesFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) feedbackTextWithEntitiesWithRangesFieldsModel).a();
                }
                return feedbackTextWithEntitiesWithRangesFieldsModel;
            }
        }

        /* compiled from: android_report_place_incorrect_information */
        public class Serializer extends JsonSerializer<FeedbackTextWithEntitiesWithRangesFieldsModel> {
            public final void m16747a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                FeedbackTextWithEntitiesWithRangesFieldsModel feedbackTextWithEntitiesWithRangesFieldsModel = (FeedbackTextWithEntitiesWithRangesFieldsModel) obj;
                if (feedbackTextWithEntitiesWithRangesFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(feedbackTextWithEntitiesWithRangesFieldsModel.m16749a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    feedbackTextWithEntitiesWithRangesFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                FeedbackTextWithEntitiesWithRangesFieldsParser.m16788a(feedbackTextWithEntitiesWithRangesFieldsModel.w_(), feedbackTextWithEntitiesWithRangesFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(FeedbackTextWithEntitiesWithRangesFieldsModel.class, new Serializer());
            }
        }

        public FeedbackTextWithEntitiesWithRangesFieldsModel() {
            super(3);
        }

        @Nonnull
        private ImmutableList<AggregatedRangesModel> m16748j() {
            this.f9710d = super.a(this.f9710d, 0, AggregatedRangesModel.class);
            return (ImmutableList) this.f9710d;
        }

        @Nonnull
        public final ImmutableList<RangesModel> m16752b() {
            this.f9711e = super.a(this.f9711e, 1, RangesModel.class);
            return (ImmutableList) this.f9711e;
        }

        @Nullable
        public final String m16751a() {
            this.f9712f = super.a(this.f9712f, 2);
            return this.f9712f;
        }

        public final int jK_() {
            return -1919764332;
        }

        public final GraphQLVisitableModel m16750a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16748j() != null) {
                a = ModelHelper.a(m16748j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FeedbackTextWithEntitiesWithRangesFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9710d = a.b();
                }
            }
            if (m16752b() != null) {
                a = ModelHelper.a(m16752b(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (FeedbackTextWithEntitiesWithRangesFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f9711e = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16749a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16748j());
            int a2 = ModelHelper.a(flatBufferBuilder, m16752b());
            int b = flatBufferBuilder.b(m16751a());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 991610982)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_report_place_incorrect_information */
    public final class PageLikeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PageToggleLikeFragmentModel f9714d;

        /* compiled from: android_report_place_incorrect_information */
        public final class Builder {
            @Nullable
            public PageToggleLikeFragmentModel f9713a;

            public final PageLikeModel m16753a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f9713a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageLikeModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: android_report_place_incorrect_information */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageLikeModel.class, new Deserializer());
            }

            public Object m16754a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageLikeParser.m16789a(jsonParser);
                Object pageLikeModel = new PageLikeModel();
                ((BaseModel) pageLikeModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageLikeModel instanceof Postprocessable) {
                    return ((Postprocessable) pageLikeModel).a();
                }
                return pageLikeModel;
            }
        }

        /* compiled from: android_report_place_incorrect_information */
        public class Serializer extends JsonSerializer<PageLikeModel> {
            public final void m16755a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageLikeModel pageLikeModel = (PageLikeModel) obj;
                if (pageLikeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageLikeModel.m16757a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageLikeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageLikeModel.w_();
                int u_ = pageLikeModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page");
                    PageToggleLikeFragmentParser.m16791a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageLikeModel.class, new Serializer());
            }
        }

        public PageLikeModel() {
            super(1);
        }

        public PageLikeModel(MutableFlatBuffer mutableFlatBuffer) {
            super(1);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private PageToggleLikeFragmentModel m16756a() {
            this.f9714d = (PageToggleLikeFragmentModel) super.a(this.f9714d, 0, PageToggleLikeFragmentModel.class);
            return this.f9714d;
        }

        public final int jK_() {
            return -1182462393;
        }

        public final GraphQLVisitableModel m16758a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16756a() != null) {
                PageToggleLikeFragmentModel pageToggleLikeFragmentModel = (PageToggleLikeFragmentModel) graphQLModelMutatingVisitor.b(m16756a());
                if (m16756a() != pageToggleLikeFragmentModel) {
                    graphQLVisitableModel = (PageLikeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9714d = pageToggleLikeFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16757a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16756a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1532285988)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_report_place_incorrect_information */
    public final class PageToggleLikeFragmentModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        private boolean f9717d;
        @Nullable
        private String f9718e;

        /* compiled from: android_report_place_incorrect_information */
        public final class Builder {
            public boolean f9715a;
            @Nullable
            public String f9716b;

            public final PageToggleLikeFragmentModel m16759a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f9716b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.a(0, this.f9715a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new PageToggleLikeFragmentModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: android_report_place_incorrect_information */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageToggleLikeFragmentModel.class, new Deserializer());
            }

            public Object m16760a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(PageToggleLikeFragmentParser.m16790a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object pageToggleLikeFragmentModel = new PageToggleLikeFragmentModel();
                ((BaseModel) pageToggleLikeFragmentModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (pageToggleLikeFragmentModel instanceof Postprocessable) {
                    return ((Postprocessable) pageToggleLikeFragmentModel).a();
                }
                return pageToggleLikeFragmentModel;
            }
        }

        /* compiled from: android_report_place_incorrect_information */
        public class Serializer extends JsonSerializer<PageToggleLikeFragmentModel> {
            public final void m16761a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                PageToggleLikeFragmentModel pageToggleLikeFragmentModel = (PageToggleLikeFragmentModel) obj;
                if (pageToggleLikeFragmentModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageToggleLikeFragmentModel.m16765a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageToggleLikeFragmentModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                PageToggleLikeFragmentParser.m16791a(pageToggleLikeFragmentModel.w_(), pageToggleLikeFragmentModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(PageToggleLikeFragmentModel.class, new Serializer());
            }
        }

        public PageToggleLikeFragmentModel() {
            super(2);
        }

        public PageToggleLikeFragmentModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final void m16769a(String str, ConsistencyTuple consistencyTuple) {
            if ("does_viewer_like".equals(str)) {
                consistencyTuple.a = Boolean.valueOf(m16763j());
                consistencyTuple.b = u_();
                consistencyTuple.c = 0;
                return;
            }
            consistencyTuple.a();
        }

        public final void m16770a(String str, Object obj, boolean z) {
            if ("does_viewer_like".equals(str)) {
                m16762a(((Boolean) obj).booleanValue());
            }
        }

        private boolean m16763j() {
            a(0, 0);
            return this.f9717d;
        }

        private void m16762a(boolean z) {
            this.f9717d = z;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 0, z);
            }
        }

        @Nullable
        private String m16764k() {
            this.f9718e = super.a(this.f9718e, 1);
            return this.f9718e;
        }

        @Nullable
        public final String m16767a() {
            return m16764k();
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m16766a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m16765a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m16764k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, this.f9717d);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }

        public final void m16768a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f9717d = mutableFlatBuffer.a(i, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 991610982)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: android_report_place_incorrect_information */
    public final class PageUnlikeModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PageToggleLikeFragmentModel f9719d;

        /* compiled from: android_report_place_incorrect_information */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageUnlikeModel.class, new Deserializer());
            }

            public Object m16771a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageUnlikeParser.m16792a(jsonParser);
                Object pageUnlikeModel = new PageUnlikeModel();
                ((BaseModel) pageUnlikeModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageUnlikeModel instanceof Postprocessable) {
                    return ((Postprocessable) pageUnlikeModel).a();
                }
                return pageUnlikeModel;
            }
        }

        /* compiled from: android_report_place_incorrect_information */
        public class Serializer extends JsonSerializer<PageUnlikeModel> {
            public final void m16772a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageUnlikeModel pageUnlikeModel = (PageUnlikeModel) obj;
                if (pageUnlikeModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageUnlikeModel.m16774a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageUnlikeModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageUnlikeModel.w_();
                int u_ = pageUnlikeModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page");
                    PageToggleLikeFragmentParser.m16791a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageUnlikeModel.class, new Serializer());
            }
        }

        public PageUnlikeModel() {
            super(1);
        }

        @Nullable
        private PageToggleLikeFragmentModel m16773a() {
            this.f9719d = (PageToggleLikeFragmentModel) super.a(this.f9719d, 0, PageToggleLikeFragmentModel.class);
            return this.f9719d;
        }

        public final int jK_() {
            return 1090219726;
        }

        public final GraphQLVisitableModel m16775a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m16773a() != null) {
                PageToggleLikeFragmentModel pageToggleLikeFragmentModel = (PageToggleLikeFragmentModel) graphQLModelMutatingVisitor.b(m16773a());
                if (m16773a() != pageToggleLikeFragmentModel) {
                    graphQLVisitableModel = (PageUnlikeModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f9719d = pageToggleLikeFragmentModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m16774a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m16773a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

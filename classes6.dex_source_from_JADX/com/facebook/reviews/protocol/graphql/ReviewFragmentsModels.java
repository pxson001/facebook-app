package com.facebook.reviews.protocol.graphql;

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
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultFeedbackFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultImageFields;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultFeedbackFieldsModel;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyIconFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLModels.PrivacyIconFieldsModel;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewBasicFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewCreationFields;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsInterfaces.ReviewWithFeedback;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewBasicFieldsParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewBasicFieldsParser.ValueParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewCreationFieldsParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewCreationFieldsParser.CreatorParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewCreationFieldsParser.CreatorParser.AuthoredReviewsParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewCreationFieldsParser.CreatorParser.FriendsParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewCreationFieldsParser.CreatorParser.MutualFriendsParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewCreationFieldsParser.StoryParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewWithFeedbackParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewWithFeedbackParser.ReviewerContextParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.ReviewWithFeedbackParser.ReviewerContextParser.TextParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.SelectedPrivacyOptionFieldsParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.SelectedPrivacyOptionFieldsParser.PrivacyOptionsParser;
import com.facebook.reviews.protocol.graphql.ReviewFragmentsParsers.SelectedPrivacyOptionFieldsParser.PrivacyOptionsParser.EdgesParser;
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

/* compiled from: setIsEditTagEnabled */
public class ReviewFragmentsModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 109697669)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: setIsEditTagEnabled */
    public final class ReviewBasicFieldsModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, ReviewBasicFields {
        @Nullable
        private String f4647d;
        private int f4648e;
        @Nullable
        private SelectedPrivacyOptionFieldsModel f4649f;
        @Nullable
        private ValueModel f4650g;

        /* compiled from: setIsEditTagEnabled */
        public final class Builder {
            @Nullable
            public String f4641a;
            public int f4642b;
            @Nullable
            public SelectedPrivacyOptionFieldsModel f4643c;
            @Nullable
            public ValueModel f4644d;

            public final ReviewBasicFieldsModel m7169a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(this.f4641a);
                int a = ModelHelper.a(flatBufferBuilder, this.f4643c);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f4644d);
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.a(1, this.f4642b, 0);
                flatBufferBuilder.b(2, a);
                flatBufferBuilder.b(3, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReviewBasicFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: setIsEditTagEnabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReviewBasicFieldsModel.class, new Deserializer());
            }

            public Object m7170a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReviewBasicFieldsParser.m7306a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reviewBasicFieldsModel = new ReviewBasicFieldsModel();
                ((BaseModel) reviewBasicFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reviewBasicFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reviewBasicFieldsModel).a();
                }
                return reviewBasicFieldsModel;
            }
        }

        /* compiled from: setIsEditTagEnabled */
        public class Serializer extends JsonSerializer<ReviewBasicFieldsModel> {
            public final void m7171a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReviewBasicFieldsModel reviewBasicFieldsModel = (ReviewBasicFieldsModel) obj;
                if (reviewBasicFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reviewBasicFieldsModel.m7182a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reviewBasicFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReviewBasicFieldsParser.m7307a(reviewBasicFieldsModel.w_(), reviewBasicFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReviewBasicFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1352864475)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setIsEditTagEnabled */
        public final class ValueModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f4646d;

            /* compiled from: setIsEditTagEnabled */
            public final class Builder {
                @Nullable
                public String f4645a;

                public final ValueModel m7172a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(this.f4645a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new ValueModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: setIsEditTagEnabled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ValueModel.class, new Deserializer());
                }

                public Object m7173a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ValueParser.m7304a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object valueModel = new ValueModel();
                    ((BaseModel) valueModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (valueModel instanceof Postprocessable) {
                        return ((Postprocessable) valueModel).a();
                    }
                    return valueModel;
                }
            }

            /* compiled from: setIsEditTagEnabled */
            public class Serializer extends JsonSerializer<ValueModel> {
                public final void m7174a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ValueModel valueModel = (ValueModel) obj;
                    if (valueModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(valueModel.m7176a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        valueModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ValueParser.m7305a(valueModel.w_(), valueModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ValueModel.class, new Serializer());
                }
            }

            public ValueModel() {
                super(1);
            }

            public ValueModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            public final String m7178a() {
                this.f4646d = super.a(this.f4646d, 0);
                return this.f4646d;
            }

            public static ValueModel m7175a(ValueModel valueModel) {
                if (valueModel == null) {
                    return null;
                }
                if (valueModel instanceof ValueModel) {
                    return valueModel;
                }
                Builder builder = new Builder();
                builder.f4645a = valueModel.m7178a();
                return builder.m7172a();
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m7177a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7176a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m7178a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        @Nullable
        public final /* synthetic */ SelectedPrivacyOptionFieldsModel m7187c() {
            return m7180k();
        }

        @Nullable
        public final /* synthetic */ ValueModel m7188d() {
            return m7181l();
        }

        public ReviewBasicFieldsModel() {
            super(4);
        }

        public ReviewBasicFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private String m7179j() {
            this.f4647d = super.a(this.f4647d, 0);
            return this.f4647d;
        }

        public final int m7186b() {
            a(0, 1);
            return this.f4648e;
        }

        @Nullable
        private SelectedPrivacyOptionFieldsModel m7180k() {
            this.f4649f = (SelectedPrivacyOptionFieldsModel) super.a(this.f4649f, 2, SelectedPrivacyOptionFieldsModel.class);
            return this.f4649f;
        }

        @Nullable
        private ValueModel m7181l() {
            this.f4650g = (ValueModel) super.a(this.f4650g, 3, ValueModel.class);
            return this.f4650g;
        }

        @Nullable
        public final String m7184a() {
            return m7179j();
        }

        public final int jK_() {
            return -131209055;
        }

        public final GraphQLVisitableModel m7183a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7180k() != null) {
                SelectedPrivacyOptionFieldsModel selectedPrivacyOptionFieldsModel = (SelectedPrivacyOptionFieldsModel) graphQLModelMutatingVisitor.b(m7180k());
                if (m7180k() != selectedPrivacyOptionFieldsModel) {
                    graphQLVisitableModel = (ReviewBasicFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4649f = selectedPrivacyOptionFieldsModel;
                }
            }
            if (m7181l() != null) {
                ValueModel valueModel = (ValueModel) graphQLModelMutatingVisitor.b(m7181l());
                if (m7181l() != valueModel) {
                    graphQLVisitableModel = (ReviewBasicFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4650g = valueModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7182a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m7179j());
            int a = ModelHelper.a(flatBufferBuilder, m7180k());
            int a2 = ModelHelper.a(flatBufferBuilder, m7181l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f4648e, 0);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m7185a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4648e = mutableFlatBuffer.a(i, 1, 0);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 1663901150)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: setIsEditTagEnabled */
    public final class ReviewCreationFieldsModel extends BaseModel implements GraphQLVisitableModel, ReviewCreationFields {
        private long f4675d;
        @Nullable
        private CreatorModel f4676e;
        @Nullable
        private StoryModel f4677f;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1088624178)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setIsEditTagEnabled */
        public final class CreatorModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private GraphQLObjectType f4665d;
            @Nullable
            private AuthoredReviewsModel f4666e;
            @Nullable
            private FriendsModel f4667f;
            @Nullable
            private String f4668g;
            private boolean f4669h;
            @Nullable
            private MutualFriendsModel f4670i;
            @Nullable
            private String f4671j;
            @Nullable
            private DefaultImageFieldsModel f4672k;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setIsEditTagEnabled */
            public final class AuthoredReviewsModel extends BaseModel implements GraphQLVisitableModel {
                private int f4652d;

                /* compiled from: setIsEditTagEnabled */
                public final class Builder {
                    public int f4651a;
                }

                /* compiled from: setIsEditTagEnabled */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AuthoredReviewsModel.class, new Deserializer());
                    }

                    public Object m7189a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AuthoredReviewsParser.m7308a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object authoredReviewsModel = new AuthoredReviewsModel();
                        ((BaseModel) authoredReviewsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (authoredReviewsModel instanceof Postprocessable) {
                            return ((Postprocessable) authoredReviewsModel).a();
                        }
                        return authoredReviewsModel;
                    }
                }

                /* compiled from: setIsEditTagEnabled */
                public class Serializer extends JsonSerializer<AuthoredReviewsModel> {
                    public final void m7190a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AuthoredReviewsModel authoredReviewsModel = (AuthoredReviewsModel) obj;
                        if (authoredReviewsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(authoredReviewsModel.m7193a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            authoredReviewsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        AuthoredReviewsParser.m7309a(authoredReviewsModel.w_(), authoredReviewsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AuthoredReviewsModel.class, new Serializer());
                    }
                }

                public AuthoredReviewsModel() {
                    super(1);
                }

                public AuthoredReviewsModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final int m7192a() {
                    a(0, 0);
                    return this.f4652d;
                }

                public static AuthoredReviewsModel m7191a(AuthoredReviewsModel authoredReviewsModel) {
                    if (authoredReviewsModel == null) {
                        return null;
                    }
                    if (authoredReviewsModel instanceof AuthoredReviewsModel) {
                        return authoredReviewsModel;
                    }
                    Builder builder = new Builder();
                    builder.f4651a = authoredReviewsModel.m7192a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, builder.f4651a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new AuthoredReviewsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1129813703;
                }

                public final GraphQLVisitableModel m7194a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m7193a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f4652d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m7195a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f4652d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: setIsEditTagEnabled */
            public final class Builder {
                @Nullable
                public GraphQLObjectType f4653a;
                @Nullable
                public AuthoredReviewsModel f4654b;
                @Nullable
                public FriendsModel f4655c;
                @Nullable
                public String f4656d;
                public boolean f4657e;
                @Nullable
                public MutualFriendsModel f4658f;
                @Nullable
                public String f4659g;
                @Nullable
                public DefaultImageFieldsModel f4660h;
            }

            /* compiled from: setIsEditTagEnabled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CreatorModel.class, new Deserializer());
                }

                public Object m7196a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CreatorParser.m7314a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object creatorModel = new CreatorModel();
                    ((BaseModel) creatorModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (creatorModel instanceof Postprocessable) {
                        return ((Postprocessable) creatorModel).a();
                    }
                    return creatorModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setIsEditTagEnabled */
            public final class FriendsModel extends BaseModel implements GraphQLVisitableModel {
                private int f4662d;

                /* compiled from: setIsEditTagEnabled */
                public final class Builder {
                    public int f4661a;
                }

                /* compiled from: setIsEditTagEnabled */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(FriendsModel.class, new Deserializer());
                    }

                    public Object m7197a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(FriendsParser.m7310a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object friendsModel = new FriendsModel();
                        ((BaseModel) friendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (friendsModel instanceof Postprocessable) {
                            return ((Postprocessable) friendsModel).a();
                        }
                        return friendsModel;
                    }
                }

                /* compiled from: setIsEditTagEnabled */
                public class Serializer extends JsonSerializer<FriendsModel> {
                    public final void m7198a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        FriendsModel friendsModel = (FriendsModel) obj;
                        if (friendsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(friendsModel.m7201a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            friendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        FriendsParser.m7311a(friendsModel.w_(), friendsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(FriendsModel.class, new Serializer());
                    }
                }

                public FriendsModel() {
                    super(1);
                }

                public FriendsModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final int m7200a() {
                    a(0, 0);
                    return this.f4662d;
                }

                public static FriendsModel m7199a(FriendsModel friendsModel) {
                    if (friendsModel == null) {
                        return null;
                    }
                    if (friendsModel instanceof FriendsModel) {
                        return friendsModel;
                    }
                    Builder builder = new Builder();
                    builder.f4661a = friendsModel.m7200a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, builder.f4661a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new FriendsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 569028147;
                }

                public final GraphQLVisitableModel m7202a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m7201a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f4662d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m7203a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f4662d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1723990064)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setIsEditTagEnabled */
            public final class MutualFriendsModel extends BaseModel implements GraphQLVisitableModel {
                private int f4664d;

                /* compiled from: setIsEditTagEnabled */
                public final class Builder {
                    public int f4663a;
                }

                /* compiled from: setIsEditTagEnabled */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(MutualFriendsModel.class, new Deserializer());
                    }

                    public Object m7204a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(MutualFriendsParser.m7312a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object mutualFriendsModel = new MutualFriendsModel();
                        ((BaseModel) mutualFriendsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (mutualFriendsModel instanceof Postprocessable) {
                            return ((Postprocessable) mutualFriendsModel).a();
                        }
                        return mutualFriendsModel;
                    }
                }

                /* compiled from: setIsEditTagEnabled */
                public class Serializer extends JsonSerializer<MutualFriendsModel> {
                    public final void m7205a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) obj;
                        if (mutualFriendsModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(mutualFriendsModel.m7208a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutualFriendsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        MutualFriendsParser.m7313a(mutualFriendsModel.w_(), mutualFriendsModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(MutualFriendsModel.class, new Serializer());
                    }
                }

                public MutualFriendsModel() {
                    super(1);
                }

                public MutualFriendsModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final int m7207a() {
                    a(0, 0);
                    return this.f4664d;
                }

                public static MutualFriendsModel m7206a(MutualFriendsModel mutualFriendsModel) {
                    if (mutualFriendsModel == null) {
                        return null;
                    }
                    if (mutualFriendsModel instanceof MutualFriendsModel) {
                        return mutualFriendsModel;
                    }
                    Builder builder = new Builder();
                    builder.f4663a = mutualFriendsModel.m7207a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, builder.f4663a, 0);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new MutualFriendsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return 1532278911;
                }

                public final GraphQLVisitableModel m7209a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m7208a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.a(0, this.f4664d, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m7210a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f4664d = mutableFlatBuffer.a(i, 0, 0);
                }
            }

            /* compiled from: setIsEditTagEnabled */
            public class Serializer extends JsonSerializer<CreatorModel> {
                public final void m7211a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CreatorModel creatorModel = (CreatorModel) obj;
                    if (creatorModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(creatorModel.m7217a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        creatorModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CreatorParser.m7315a(creatorModel.w_(), creatorModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CreatorModel.class, new Serializer());
                }
            }

            @Nullable
            public final /* synthetic */ MutualFriendsModel bM_() {
                return m7215m();
            }

            @Nullable
            public final /* synthetic */ AuthoredReviewsModel m7224c() {
                return m7213k();
            }

            @Nullable
            public final /* synthetic */ FriendsModel m7225d() {
                return m7214l();
            }

            @Nullable
            public final /* synthetic */ DefaultImageFields m7227j() {
                return m7216n();
            }

            public CreatorModel() {
                super(8);
            }

            public CreatorModel(MutableFlatBuffer mutableFlatBuffer) {
                super(8);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m7221a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m7222a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final GraphQLObjectType m7223b() {
                if (this.b != null && this.f4665d == null) {
                    this.f4665d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                }
                return this.f4665d;
            }

            @Nullable
            private AuthoredReviewsModel m7213k() {
                this.f4666e = (AuthoredReviewsModel) super.a(this.f4666e, 1, AuthoredReviewsModel.class);
                return this.f4666e;
            }

            @Nullable
            private FriendsModel m7214l() {
                this.f4667f = (FriendsModel) super.a(this.f4667f, 2, FriendsModel.class);
                return this.f4667f;
            }

            @Nullable
            public final String bK_() {
                this.f4668g = super.a(this.f4668g, 3);
                return this.f4668g;
            }

            public final boolean m7226g() {
                a(0, 4);
                return this.f4669h;
            }

            @Nullable
            private MutualFriendsModel m7215m() {
                this.f4670i = (MutualFriendsModel) super.a(this.f4670i, 5, MutualFriendsModel.class);
                return this.f4670i;
            }

            @Nullable
            public final String bL_() {
                this.f4671j = super.a(this.f4671j, 6);
                return this.f4671j;
            }

            @Nullable
            private DefaultImageFieldsModel m7216n() {
                this.f4672k = (DefaultImageFieldsModel) super.a(this.f4672k, 7, DefaultImageFieldsModel.class);
                return this.f4672k;
            }

            public static CreatorModel m7212a(CreatorModel creatorModel) {
                if (creatorModel == null) {
                    return null;
                }
                if (creatorModel instanceof CreatorModel) {
                    return creatorModel;
                }
                Builder builder = new Builder();
                builder.f4653a = creatorModel.m7223b();
                builder.f4654b = AuthoredReviewsModel.m7191a(creatorModel.m7224c());
                builder.f4655c = FriendsModel.m7199a(creatorModel.m7225d());
                builder.f4656d = creatorModel.bK_();
                builder.f4657e = creatorModel.m7226g();
                builder.f4658f = MutualFriendsModel.m7206a(creatorModel.bM_());
                builder.f4659g = creatorModel.bL_();
                builder.f4660h = DefaultImageFieldsModel.a(creatorModel.m7227j());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f4653a);
                int a2 = ModelHelper.a(flatBufferBuilder, builder.f4654b);
                int a3 = ModelHelper.a(flatBufferBuilder, builder.f4655c);
                int b = flatBufferBuilder.b(builder.f4656d);
                int a4 = ModelHelper.a(flatBufferBuilder, builder.f4658f);
                int b2 = flatBufferBuilder.b(builder.f4659g);
                int a5 = ModelHelper.a(flatBufferBuilder, builder.f4660h);
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.a(4, builder.f4657e);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, b2);
                flatBufferBuilder.b(7, a5);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new CreatorModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m7219a() {
                return bK_();
            }

            public final int jK_() {
                return 63093205;
            }

            public final GraphQLVisitableModel m7218a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7213k() != null) {
                    AuthoredReviewsModel authoredReviewsModel = (AuthoredReviewsModel) graphQLModelMutatingVisitor.b(m7213k());
                    if (m7213k() != authoredReviewsModel) {
                        graphQLVisitableModel = (CreatorModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4666e = authoredReviewsModel;
                    }
                }
                if (m7214l() != null) {
                    FriendsModel friendsModel = (FriendsModel) graphQLModelMutatingVisitor.b(m7214l());
                    if (m7214l() != friendsModel) {
                        graphQLVisitableModel = (CreatorModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4667f = friendsModel;
                    }
                }
                if (m7215m() != null) {
                    MutualFriendsModel mutualFriendsModel = (MutualFriendsModel) graphQLModelMutatingVisitor.b(m7215m());
                    if (m7215m() != mutualFriendsModel) {
                        graphQLVisitableModel = (CreatorModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4670i = mutualFriendsModel;
                    }
                }
                if (m7216n() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m7216n());
                    if (m7216n() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (CreatorModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4672k = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7217a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7223b());
                int a2 = ModelHelper.a(flatBufferBuilder, m7213k());
                int a3 = ModelHelper.a(flatBufferBuilder, m7214l());
                int b = flatBufferBuilder.b(bK_());
                int a4 = ModelHelper.a(flatBufferBuilder, m7215m());
                int b2 = flatBufferBuilder.b(bL_());
                int a5 = ModelHelper.a(flatBufferBuilder, m7216n());
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.b(2, a3);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.a(4, this.f4669h);
                flatBufferBuilder.b(5, a4);
                flatBufferBuilder.b(6, b2);
                flatBufferBuilder.b(7, a5);
                i();
                return flatBufferBuilder.d();
            }

            public final void m7220a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f4669h = mutableFlatBuffer.a(i, 4);
            }
        }

        /* compiled from: setIsEditTagEnabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReviewCreationFieldsModel.class, new Deserializer());
            }

            public Object m7228a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReviewCreationFieldsParser.m7318a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reviewCreationFieldsModel = new ReviewCreationFieldsModel();
                ((BaseModel) reviewCreationFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reviewCreationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) reviewCreationFieldsModel).a();
                }
                return reviewCreationFieldsModel;
            }
        }

        /* compiled from: setIsEditTagEnabled */
        public class Serializer extends JsonSerializer<ReviewCreationFieldsModel> {
            public final void m7229a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ReviewCreationFieldsModel reviewCreationFieldsModel = (ReviewCreationFieldsModel) obj;
                if (reviewCreationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reviewCreationFieldsModel.m7241a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reviewCreationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = reviewCreationFieldsModel.w_();
                int u_ = reviewCreationFieldsModel.u_();
                jsonGenerator.f();
                long a = mutableFlatBuffer.a(u_, 0, 0);
                if (a != 0) {
                    jsonGenerator.a("creation_time");
                    jsonGenerator.a(a);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("creator");
                    CreatorParser.m7315a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("story");
                    StoryParser.m7317a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ReviewCreationFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setIsEditTagEnabled */
        public final class StoryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            @Nullable
            private String f4674d;

            /* compiled from: setIsEditTagEnabled */
            public final class Builder {
                @Nullable
                public String f4673a;
            }

            /* compiled from: setIsEditTagEnabled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(StoryModel.class, new Deserializer());
                }

                public Object m7230a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(StoryParser.m7316a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object storyModel = new StoryModel();
                    ((BaseModel) storyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (storyModel instanceof Postprocessable) {
                        return ((Postprocessable) storyModel).a();
                    }
                    return storyModel;
                }
            }

            /* compiled from: setIsEditTagEnabled */
            public class Serializer extends JsonSerializer<StoryModel> {
                public final void m7231a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    StoryModel storyModel = (StoryModel) obj;
                    if (storyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(storyModel.m7233a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        storyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    StoryParser.m7317a(storyModel.w_(), storyModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(StoryModel.class, new Serializer());
                }
            }

            public StoryModel() {
                super(1);
            }

            public StoryModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            public final void m7236a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m7237a(String str, Object obj, boolean z) {
            }

            @Nullable
            public final String m7238b() {
                this.f4674d = super.a(this.f4674d, 0);
                return this.f4674d;
            }

            public static StoryModel m7232a(StoryModel storyModel) {
                if (storyModel == null) {
                    return null;
                }
                if (storyModel instanceof StoryModel) {
                    return storyModel;
                }
                Builder builder = new Builder();
                builder.f4673a = storyModel.m7238b();
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int b = flatBufferBuilder.b(builder.f4673a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new StoryModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            @Nullable
            public final String m7235a() {
                return m7238b();
            }

            public final int jK_() {
                return 80218325;
            }

            public final GraphQLVisitableModel m7234a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m7233a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m7238b());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        public ReviewCreationFieldsModel() {
            super(3);
        }

        @Nullable
        private CreatorModel m7239a() {
            this.f4676e = (CreatorModel) super.a(this.f4676e, 1, CreatorModel.class);
            return this.f4676e;
        }

        @Nullable
        private StoryModel m7240j() {
            this.f4677f = (StoryModel) super.a(this.f4677f, 2, StoryModel.class);
            return this.f4677f;
        }

        public final int jK_() {
            return -131209055;
        }

        public final GraphQLVisitableModel m7242a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7239a() != null) {
                CreatorModel creatorModel = (CreatorModel) graphQLModelMutatingVisitor.b(m7239a());
                if (m7239a() != creatorModel) {
                    graphQLVisitableModel = (ReviewCreationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4676e = creatorModel;
                }
            }
            if (m7240j() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(m7240j());
                if (m7240j() != storyModel) {
                    graphQLVisitableModel = (ReviewCreationFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4677f = storyModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7241a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7239a());
            int a2 = ModelHelper.a(flatBufferBuilder, m7240j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.a(0, this.f4675d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m7243a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4675d = mutableFlatBuffer.a(i, 0, 0);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -870683181)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: setIsEditTagEnabled */
    public final class ReviewWithFeedbackModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel, ReviewWithFeedback {
        private long f4691d;
        @Nullable
        private CreatorModel f4692e;
        @Nullable
        private DefaultFeedbackFieldsModel f4693f;
        @Nullable
        private String f4694g;
        private int f4695h;
        @Nullable
        private SelectedPrivacyOptionFieldsModel f4696i;
        @Nullable
        private ReviewerContextModel f4697j;
        @Nullable
        private StoryModel f4698k;
        @Nullable
        private ValueModel f4699l;

        /* compiled from: setIsEditTagEnabled */
        public final class Builder {
            public long f4678a;
            @Nullable
            public CreatorModel f4679b;
            @Nullable
            public DefaultFeedbackFieldsModel f4680c;
            @Nullable
            public String f4681d;
            public int f4682e;
            @Nullable
            public SelectedPrivacyOptionFieldsModel f4683f;
            @Nullable
            public ReviewerContextModel f4684g;
            @Nullable
            public StoryModel f4685h;
            @Nullable
            public ValueModel f4686i;

            public static Builder m7244a(ReviewWithFeedbackModel reviewWithFeedbackModel) {
                Builder builder = new Builder();
                builder.f4678a = reviewWithFeedbackModel.mo331g();
                builder.f4679b = reviewWithFeedbackModel.m7272l();
                builder.f4680c = reviewWithFeedbackModel.m7273m();
                builder.f4681d = reviewWithFeedbackModel.bN_();
                builder.f4682e = reviewWithFeedbackModel.mo326b();
                builder.f4683f = reviewWithFeedbackModel.m7274n();
                builder.f4684g = reviewWithFeedbackModel.m7275o();
                builder.f4685h = reviewWithFeedbackModel.m7276p();
                builder.f4686i = reviewWithFeedbackModel.m7277q();
                return builder;
            }

            public final ReviewWithFeedbackModel m7245a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f4679b);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f4680c);
                int b = flatBufferBuilder.b(this.f4681d);
                int a3 = ModelHelper.a(flatBufferBuilder, this.f4683f);
                int a4 = ModelHelper.a(flatBufferBuilder, this.f4684g);
                int a5 = ModelHelper.a(flatBufferBuilder, this.f4685h);
                int a6 = ModelHelper.a(flatBufferBuilder, this.f4686i);
                flatBufferBuilder.c(9);
                flatBufferBuilder.a(0, this.f4678a, 0);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.b(3, b);
                flatBufferBuilder.a(4, this.f4682e, 0);
                flatBufferBuilder.b(5, a3);
                flatBufferBuilder.b(6, a4);
                flatBufferBuilder.b(7, a5);
                flatBufferBuilder.b(8, a6);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReviewWithFeedbackModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: setIsEditTagEnabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ReviewWithFeedbackModel.class, new Deserializer());
            }

            public Object m7246a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ReviewWithFeedbackParser.m7323a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object reviewWithFeedbackModel = new ReviewWithFeedbackModel();
                ((BaseModel) reviewWithFeedbackModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (reviewWithFeedbackModel instanceof Postprocessable) {
                    return ((Postprocessable) reviewWithFeedbackModel).a();
                }
                return reviewWithFeedbackModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 884261792)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: setIsEditTagEnabled */
        public final class ReviewerContextModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private TextModel f4690d;

            /* compiled from: setIsEditTagEnabled */
            public final class Builder {
                @Nullable
                public TextModel f4687a;
            }

            /* compiled from: setIsEditTagEnabled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ReviewerContextModel.class, new Deserializer());
                }

                public Object m7247a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ReviewerContextParser.m7321a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object reviewerContextModel = new ReviewerContextModel();
                    ((BaseModel) reviewerContextModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (reviewerContextModel instanceof Postprocessable) {
                        return ((Postprocessable) reviewerContextModel).a();
                    }
                    return reviewerContextModel;
                }
            }

            /* compiled from: setIsEditTagEnabled */
            public class Serializer extends JsonSerializer<ReviewerContextModel> {
                public final void m7248a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ReviewerContextModel reviewerContextModel = (ReviewerContextModel) obj;
                    if (reviewerContextModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(reviewerContextModel.m7257a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        reviewerContextModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ReviewerContextParser.m7322a(reviewerContextModel.w_(), reviewerContextModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ReviewerContextModel.class, new Serializer());
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: setIsEditTagEnabled */
            public final class TextModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f4689d;

                /* compiled from: setIsEditTagEnabled */
                public final class Builder {
                    @Nullable
                    public String f4688a;
                }

                /* compiled from: setIsEditTagEnabled */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(TextModel.class, new Deserializer());
                    }

                    public Object m7249a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(TextParser.m7319a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object textModel = new TextModel();
                        ((BaseModel) textModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (textModel instanceof Postprocessable) {
                            return ((Postprocessable) textModel).a();
                        }
                        return textModel;
                    }
                }

                /* compiled from: setIsEditTagEnabled */
                public class Serializer extends JsonSerializer<TextModel> {
                    public final void m7250a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        TextModel textModel = (TextModel) obj;
                        if (textModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(textModel.m7252a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            textModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        TextParser.m7320a(textModel.w_(), textModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(TextModel.class, new Serializer());
                    }
                }

                public TextModel() {
                    super(1);
                }

                public TextModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(1);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                @Nullable
                public final String m7254a() {
                    this.f4689d = super.a(this.f4689d, 0);
                    return this.f4689d;
                }

                public static TextModel m7251a(TextModel textModel) {
                    if (textModel == null) {
                        return null;
                    }
                    if (textModel instanceof TextModel) {
                        return textModel;
                    }
                    Builder builder = new Builder();
                    builder.f4688a = textModel.m7254a();
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int b = flatBufferBuilder.b(builder.f4688a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new TextModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m7253a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m7252a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m7254a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            @Nullable
            public final /* synthetic */ TextModel m7259a() {
                return m7256j();
            }

            public ReviewerContextModel() {
                super(1);
            }

            public ReviewerContextModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nullable
            private TextModel m7256j() {
                this.f4690d = (TextModel) super.a(this.f4690d, 0, TextModel.class);
                return this.f4690d;
            }

            public static ReviewerContextModel m7255a(ReviewerContextModel reviewerContextModel) {
                if (reviewerContextModel == null) {
                    return null;
                }
                if (reviewerContextModel instanceof ReviewerContextModel) {
                    return reviewerContextModel;
                }
                Builder builder = new Builder();
                builder.f4687a = TextModel.m7251a(reviewerContextModel.m7259a());
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, builder.f4687a);
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new ReviewerContextModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }

            public final int jK_() {
                return -1499588662;
            }

            public final GraphQLVisitableModel m7258a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7256j() != null) {
                    TextModel textModel = (TextModel) graphQLModelMutatingVisitor.b(m7256j());
                    if (m7256j() != textModel) {
                        graphQLVisitableModel = (ReviewerContextModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4690d = textModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7257a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7256j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: setIsEditTagEnabled */
        public class Serializer extends JsonSerializer<ReviewWithFeedbackModel> {
            public final void m7260a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ReviewWithFeedbackModel reviewWithFeedbackModel = (ReviewWithFeedbackModel) obj;
                if (reviewWithFeedbackModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(reviewWithFeedbackModel.m7262a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    reviewWithFeedbackModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ReviewWithFeedbackParser.m7324a(reviewWithFeedbackModel.w_(), reviewWithFeedbackModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(ReviewWithFeedbackModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ DefaultFeedbackFields bO_() {
            return m7273m();
        }

        @Nullable
        public final /* synthetic */ CreatorModel bP_() {
            return m7272l();
        }

        @Nullable
        public final /* synthetic */ SelectedPrivacyOptionFieldsModel mo329c() {
            return m7274n();
        }

        @Nullable
        public final /* synthetic */ ValueModel mo330d() {
            return m7277q();
        }

        @Nullable
        public final /* synthetic */ ReviewerContextModel mo332j() {
            return m7275o();
        }

        @Nullable
        public final /* synthetic */ StoryModel mo333k() {
            return m7276p();
        }

        public ReviewWithFeedbackModel() {
            super(9);
        }

        public ReviewWithFeedbackModel(MutableFlatBuffer mutableFlatBuffer) {
            super(9);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        public final long mo331g() {
            a(0, 0);
            return this.f4691d;
        }

        @Nullable
        public final CreatorModel m7272l() {
            this.f4692e = (CreatorModel) super.a(this.f4692e, 1, CreatorModel.class);
            return this.f4692e;
        }

        @Nullable
        public final DefaultFeedbackFieldsModel m7273m() {
            this.f4693f = (DefaultFeedbackFieldsModel) super.a(this.f4693f, 2, DefaultFeedbackFieldsModel.class);
            return this.f4693f;
        }

        @Nullable
        public final String bN_() {
            this.f4694g = super.a(this.f4694g, 3);
            return this.f4694g;
        }

        public final int mo326b() {
            a(0, 4);
            return this.f4695h;
        }

        @Nullable
        public final SelectedPrivacyOptionFieldsModel m7274n() {
            this.f4696i = (SelectedPrivacyOptionFieldsModel) super.a(this.f4696i, 5, SelectedPrivacyOptionFieldsModel.class);
            return this.f4696i;
        }

        @Nullable
        public final ReviewerContextModel m7275o() {
            this.f4697j = (ReviewerContextModel) super.a(this.f4697j, 6, ReviewerContextModel.class);
            return this.f4697j;
        }

        @Nullable
        public final StoryModel m7276p() {
            this.f4698k = (StoryModel) super.a(this.f4698k, 7, StoryModel.class);
            return this.f4698k;
        }

        @Nullable
        public final ValueModel m7277q() {
            this.f4699l = (ValueModel) super.a(this.f4699l, 8, ValueModel.class);
            return this.f4699l;
        }

        public static ReviewWithFeedbackModel m7261a(ReviewWithFeedback reviewWithFeedback) {
            if (reviewWithFeedback == null) {
                return null;
            }
            if (reviewWithFeedback instanceof ReviewWithFeedbackModel) {
                return (ReviewWithFeedbackModel) reviewWithFeedback;
            }
            Builder builder = new Builder();
            builder.f4678a = reviewWithFeedback.mo331g();
            builder.f4679b = CreatorModel.m7212a(reviewWithFeedback.bP_());
            builder.f4680c = DefaultFeedbackFieldsModel.a(reviewWithFeedback.bO_());
            builder.f4681d = reviewWithFeedback.bN_();
            builder.f4682e = reviewWithFeedback.mo326b();
            builder.f4683f = SelectedPrivacyOptionFieldsModel.m7297a(reviewWithFeedback.mo329c());
            builder.f4684g = ReviewerContextModel.m7255a(reviewWithFeedback.mo332j());
            builder.f4685h = StoryModel.m7232a(reviewWithFeedback.mo333k());
            builder.f4686i = ValueModel.m7175a(reviewWithFeedback.mo330d());
            return builder.m7245a();
        }

        @Nullable
        public final String m7264a() {
            return bN_();
        }

        public final int jK_() {
            return -131209055;
        }

        public final GraphQLVisitableModel m7263a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7272l() != null) {
                CreatorModel creatorModel = (CreatorModel) graphQLModelMutatingVisitor.b(m7272l());
                if (m7272l() != creatorModel) {
                    graphQLVisitableModel = (ReviewWithFeedbackModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4692e = creatorModel;
                }
            }
            if (m7273m() != null) {
                DefaultFeedbackFieldsModel defaultFeedbackFieldsModel = (DefaultFeedbackFieldsModel) graphQLModelMutatingVisitor.b(m7273m());
                if (m7273m() != defaultFeedbackFieldsModel) {
                    graphQLVisitableModel = (ReviewWithFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4693f = defaultFeedbackFieldsModel;
                }
            }
            if (m7274n() != null) {
                SelectedPrivacyOptionFieldsModel selectedPrivacyOptionFieldsModel = (SelectedPrivacyOptionFieldsModel) graphQLModelMutatingVisitor.b(m7274n());
                if (m7274n() != selectedPrivacyOptionFieldsModel) {
                    graphQLVisitableModel = (ReviewWithFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4696i = selectedPrivacyOptionFieldsModel;
                }
            }
            if (m7275o() != null) {
                ReviewerContextModel reviewerContextModel = (ReviewerContextModel) graphQLModelMutatingVisitor.b(m7275o());
                if (m7275o() != reviewerContextModel) {
                    graphQLVisitableModel = (ReviewWithFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4697j = reviewerContextModel;
                }
            }
            if (m7276p() != null) {
                StoryModel storyModel = (StoryModel) graphQLModelMutatingVisitor.b(m7276p());
                if (m7276p() != storyModel) {
                    graphQLVisitableModel = (ReviewWithFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4698k = storyModel;
                }
            }
            if (m7277q() != null) {
                ValueModel valueModel = (ValueModel) graphQLModelMutatingVisitor.b(m7277q());
                if (m7277q() != valueModel) {
                    graphQLVisitableModel = (ReviewWithFeedbackModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4699l = valueModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7262a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7272l());
            int a2 = ModelHelper.a(flatBufferBuilder, m7273m());
            int b = flatBufferBuilder.b(bN_());
            int a3 = ModelHelper.a(flatBufferBuilder, m7274n());
            int a4 = ModelHelper.a(flatBufferBuilder, m7275o());
            int a5 = ModelHelper.a(flatBufferBuilder, m7276p());
            int a6 = ModelHelper.a(flatBufferBuilder, m7277q());
            flatBufferBuilder.c(9);
            flatBufferBuilder.a(0, this.f4691d, 0);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.a(4, this.f4695h, 0);
            flatBufferBuilder.b(5, a3);
            flatBufferBuilder.b(6, a4);
            flatBufferBuilder.b(7, a5);
            flatBufferBuilder.b(8, a6);
            i();
            return flatBufferBuilder.d();
        }

        public final void m7265a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f4691d = mutableFlatBuffer.a(i, 0, 0);
            this.f4695h = mutableFlatBuffer.a(i, 4, 0);
        }
    }

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -691187077)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: setIsEditTagEnabled */
    public final class SelectedPrivacyOptionFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private PrivacyIconFieldsModel f4708d;
        @Nullable
        private PrivacyOptionsModel f4709e;

        /* compiled from: setIsEditTagEnabled */
        public final class Builder {
            @Nullable
            public PrivacyIconFieldsModel f4700a;
            @Nullable
            public PrivacyOptionsModel f4701b;

            public final SelectedPrivacyOptionFieldsModel m7278a() {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                int a = ModelHelper.a(flatBufferBuilder, this.f4700a);
                int a2 = ModelHelper.a(flatBufferBuilder, this.f4701b);
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, a2);
                flatBufferBuilder.d(flatBufferBuilder.d());
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                return new SelectedPrivacyOptionFieldsModel(new MutableFlatBuffer(wrap, null, null, true, null));
            }
        }

        /* compiled from: setIsEditTagEnabled */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(SelectedPrivacyOptionFieldsModel.class, new Deserializer());
            }

            public Object m7279a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(SelectedPrivacyOptionFieldsParser.m7329a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object selectedPrivacyOptionFieldsModel = new SelectedPrivacyOptionFieldsModel();
                ((BaseModel) selectedPrivacyOptionFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (selectedPrivacyOptionFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) selectedPrivacyOptionFieldsModel).a();
                }
                return selectedPrivacyOptionFieldsModel;
            }
        }

        @FragmentModelWithBridge
        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1778729271)
        @JsonSerialize(using = Serializer.class)
        /* compiled from: setIsEditTagEnabled */
        public final class PrivacyOptionsModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<EdgesModel> f4707d;

            /* compiled from: setIsEditTagEnabled */
            public final class Builder {
                @Nullable
                public ImmutableList<EdgesModel> f4702a;

                public final PrivacyOptionsModel m7280a() {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    int a = ModelHelper.a(flatBufferBuilder, this.f4702a);
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.d(flatBufferBuilder.d());
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    return new PrivacyOptionsModel(new MutableFlatBuffer(wrap, null, null, true, null));
                }
            }

            /* compiled from: setIsEditTagEnabled */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PrivacyOptionsModel.class, new Deserializer());
                }

                public Object m7281a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PrivacyOptionsParser.m7327a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object privacyOptionsModel = new PrivacyOptionsModel();
                    ((BaseModel) privacyOptionsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (privacyOptionsModel instanceof Postprocessable) {
                        return ((Postprocessable) privacyOptionsModel).a();
                    }
                    return privacyOptionsModel;
                }
            }

            @FragmentModelWithBridge
            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1645471618)
            @JsonSerialize(using = Serializer.class)
            /* compiled from: setIsEditTagEnabled */
            public final class EdgesModel extends BaseModel implements GraphQLVisitableModel {
                private boolean f4705d;
                @Nullable
                private GraphQLPrivacyOption f4706e;

                /* compiled from: setIsEditTagEnabled */
                public final class Builder {
                    public boolean f4703a;
                    @Nullable
                    public GraphQLPrivacyOption f4704b;

                    public final EdgesModel m7282a() {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        int a = ModelHelper.a(flatBufferBuilder, this.f4704b);
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.a(0, this.f4703a);
                        flatBufferBuilder.b(1, a);
                        flatBufferBuilder.d(flatBufferBuilder.d());
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        return new EdgesModel(new MutableFlatBuffer(wrap, null, null, true, null));
                    }
                }

                /* compiled from: setIsEditTagEnabled */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(EdgesModel.class, new Deserializer());
                    }

                    public Object m7283a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(EdgesParser.m7325b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object edgesModel = new EdgesModel();
                        ((BaseModel) edgesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (edgesModel instanceof Postprocessable) {
                            return ((Postprocessable) edgesModel).a();
                        }
                        return edgesModel;
                    }
                }

                /* compiled from: setIsEditTagEnabled */
                public class Serializer extends JsonSerializer<EdgesModel> {
                    public final void m7284a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        EdgesModel edgesModel = (EdgesModel) obj;
                        if (edgesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(edgesModel.m7286a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            edgesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        EdgesParser.m7326b(edgesModel.w_(), edgesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(EdgesModel.class, new Serializer());
                    }
                }

                public EdgesModel() {
                    super(2);
                }

                public EdgesModel(MutableFlatBuffer mutableFlatBuffer) {
                    super(2);
                    a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }

                public final boolean m7289a() {
                    a(0, 0);
                    return this.f4705d;
                }

                @Nullable
                public final GraphQLPrivacyOption m7290b() {
                    this.f4706e = (GraphQLPrivacyOption) super.a(this.f4706e, 1, GraphQLPrivacyOption.class);
                    return this.f4706e;
                }

                public static EdgesModel m7285a(EdgesModel edgesModel) {
                    if (edgesModel == null) {
                        return null;
                    }
                    if (edgesModel instanceof EdgesModel) {
                        return edgesModel;
                    }
                    Builder builder = new Builder();
                    builder.f4703a = edgesModel.m7289a();
                    builder.f4704b = edgesModel.m7290b();
                    return builder.m7282a();
                }

                public final int jK_() {
                    return -1212476960;
                }

                public final GraphQLVisitableModel m7287a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m7290b() != null) {
                        GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) graphQLModelMutatingVisitor.b(m7290b());
                        if (m7290b() != graphQLPrivacyOption) {
                            graphQLVisitableModel = (EdgesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f4706e = graphQLPrivacyOption;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m7286a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m7290b());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.a(0, this.f4705d);
                    flatBufferBuilder.b(1, a);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m7288a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f4705d = mutableFlatBuffer.a(i, 0);
                }
            }

            /* compiled from: setIsEditTagEnabled */
            public class Serializer extends JsonSerializer<PrivacyOptionsModel> {
                public final void m7291a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PrivacyOptionsModel privacyOptionsModel = (PrivacyOptionsModel) obj;
                    if (privacyOptionsModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(privacyOptionsModel.m7293a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        privacyOptionsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PrivacyOptionsParser.m7328a(privacyOptionsModel.w_(), privacyOptionsModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PrivacyOptionsModel.class, new Serializer());
                }
            }

            public PrivacyOptionsModel() {
                super(1);
            }

            public PrivacyOptionsModel(MutableFlatBuffer mutableFlatBuffer) {
                super(1);
                a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }

            @Nonnull
            public final ImmutableList<EdgesModel> m7295a() {
                this.f4707d = super.a(this.f4707d, 0, EdgesModel.class);
                return (ImmutableList) this.f4707d;
            }

            public static PrivacyOptionsModel m7292a(PrivacyOptionsModel privacyOptionsModel) {
                if (privacyOptionsModel == null) {
                    return null;
                }
                if (privacyOptionsModel instanceof PrivacyOptionsModel) {
                    return privacyOptionsModel;
                }
                Builder builder = new Builder();
                com.google.common.collect.ImmutableList.Builder builder2 = ImmutableList.builder();
                for (int i = 0; i < privacyOptionsModel.m7295a().size(); i++) {
                    builder2.c(EdgesModel.m7285a((EdgesModel) privacyOptionsModel.m7295a().get(i)));
                }
                builder.f4702a = builder2.b();
                return builder.m7280a();
            }

            public final int jK_() {
                return 780090561;
            }

            public final GraphQLVisitableModel m7294a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m7295a() != null) {
                    com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m7295a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (PrivacyOptionsModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f4707d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m7293a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m7295a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: setIsEditTagEnabled */
        public class Serializer extends JsonSerializer<SelectedPrivacyOptionFieldsModel> {
            public final void m7296a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                SelectedPrivacyOptionFieldsModel selectedPrivacyOptionFieldsModel = (SelectedPrivacyOptionFieldsModel) obj;
                if (selectedPrivacyOptionFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(selectedPrivacyOptionFieldsModel.m7300a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    selectedPrivacyOptionFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                SelectedPrivacyOptionFieldsParser.m7330a(selectedPrivacyOptionFieldsModel.w_(), selectedPrivacyOptionFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(SelectedPrivacyOptionFieldsModel.class, new Serializer());
            }
        }

        @Nullable
        public final /* synthetic */ PrivacyIconFields m7302a() {
            return m7298j();
        }

        @Nullable
        public final /* synthetic */ PrivacyOptionsModel m7303b() {
            return m7299k();
        }

        public SelectedPrivacyOptionFieldsModel() {
            super(2);
        }

        public SelectedPrivacyOptionFieldsModel(MutableFlatBuffer mutableFlatBuffer) {
            super(2);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        private PrivacyIconFieldsModel m7298j() {
            this.f4708d = (PrivacyIconFieldsModel) super.a(this.f4708d, 0, PrivacyIconFieldsModel.class);
            return this.f4708d;
        }

        @Nullable
        private PrivacyOptionsModel m7299k() {
            this.f4709e = (PrivacyOptionsModel) super.a(this.f4709e, 1, PrivacyOptionsModel.class);
            return this.f4709e;
        }

        public static SelectedPrivacyOptionFieldsModel m7297a(SelectedPrivacyOptionFieldsModel selectedPrivacyOptionFieldsModel) {
            if (selectedPrivacyOptionFieldsModel == null) {
                return null;
            }
            if (selectedPrivacyOptionFieldsModel instanceof SelectedPrivacyOptionFieldsModel) {
                return selectedPrivacyOptionFieldsModel;
            }
            Builder builder = new Builder();
            builder.f4700a = PrivacyIconFieldsModel.a(selectedPrivacyOptionFieldsModel.m7302a());
            builder.f4701b = PrivacyOptionsModel.m7292a(selectedPrivacyOptionFieldsModel.m7303b());
            return builder.m7278a();
        }

        public final int jK_() {
            return -476351540;
        }

        public final GraphQLVisitableModel m7301a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m7298j() != null) {
                PrivacyIconFieldsModel privacyIconFieldsModel = (PrivacyIconFieldsModel) graphQLModelMutatingVisitor.b(m7298j());
                if (m7298j() != privacyIconFieldsModel) {
                    graphQLVisitableModel = (SelectedPrivacyOptionFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f4708d = privacyIconFieldsModel;
                }
            }
            if (m7299k() != null) {
                PrivacyOptionsModel privacyOptionsModel = (PrivacyOptionsModel) graphQLModelMutatingVisitor.b(m7299k());
                if (m7299k() != privacyOptionsModel) {
                    graphQLVisitableModel = (SelectedPrivacyOptionFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f4709e = privacyOptionsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m7300a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m7298j());
            int a2 = ModelHelper.a(flatBufferBuilder, m7299k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}

package com.facebook.leadgen.model.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLLeadGenContextPageContentStyle;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputDomain;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputType;
import com.facebook.graphql.enums.GraphQLLeadGenPrivacyType;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.querybuilder.common.CommonGraphQLModels.DefaultImageFieldsModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenContextCardFieldsParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenContextCardFieldsParser.ContextCardPhotoParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenContextCardFieldsParser.ContextImageParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenDeepLinkDataFragParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenDeepLinkDataFragParser.ErrorCodesParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenDeepLinkDataFragParser.LeadGenDataParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenDeepLinkDataFragParser.LeadGenDataParser.PagesParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenDeepLinkDataFragParser.LeadGenDataParser.PagesParser.PrivacyDataParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenDeepLinkDataFragParser.LeadGenDeepLinkUserStatusParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenDeepLinkDataFragParser.PageParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenInfoFieldsParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenLegalFieldsParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenLegalFieldsParser.CheckboxesParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenLegalFieldsParser.CheckboxesParser.CheckboxBodyParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenLegalFieldsParser.DisclaimerBodyParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenLegalFieldsParser.DisclaimerBodyParser.RangesParser;
import com.facebook.leadgen.model.graphql.LeadGenGraphQLParsers.LeadGenLegalFieldsParser.DisclaimerBodyParser.RangesParser.EntityParser;
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

/* compiled from: photo_urls */
public class LeadGenGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1238652435)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_urls */
    public final class LeadGenContextCardFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private ContextCardPhotoModel f6471d;
        @Nullable
        private List<String> f6472e;
        @Nullable
        private GraphQLLeadGenContextPageContentStyle f6473f;
        @Nullable
        private String f6474g;
        @Nullable
        private ContextImageModel f6475h;
        @Nullable
        private String f6476i;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 141940779)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_urls */
        public final class ContextCardPhotoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f6467d;
            @Nullable
            private FBFullImageFragmentModel f6468e;
            @Nullable
            private String f6469f;

            /* compiled from: photo_urls */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ContextCardPhotoModel.class, new Deserializer());
                }

                public Object m8299a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ContextCardPhotoParser.m8452a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object contextCardPhotoModel = new ContextCardPhotoModel();
                    ((BaseModel) contextCardPhotoModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (contextCardPhotoModel instanceof Postprocessable) {
                        return ((Postprocessable) contextCardPhotoModel).a();
                    }
                    return contextCardPhotoModel;
                }
            }

            /* compiled from: photo_urls */
            public class Serializer extends JsonSerializer<ContextCardPhotoModel> {
                public final void m8300a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ContextCardPhotoModel contextCardPhotoModel = (ContextCardPhotoModel) obj;
                    if (contextCardPhotoModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(contextCardPhotoModel.m8304a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        contextCardPhotoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ContextCardPhotoParser.m8453a(contextCardPhotoModel.w_(), contextCardPhotoModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ContextCardPhotoModel.class, new Serializer());
                }
            }

            public ContextCardPhotoModel() {
                super(3);
            }

            @Nullable
            private String m8301j() {
                this.f6467d = super.a(this.f6467d, 0);
                return this.f6467d;
            }

            @Nullable
            private FBFullImageFragmentModel m8302k() {
                this.f6468e = (FBFullImageFragmentModel) super.a(this.f6468e, 1, FBFullImageFragmentModel.class);
                return this.f6468e;
            }

            @Nullable
            private String m8303l() {
                this.f6469f = super.a(this.f6469f, 2);
                return this.f6469f;
            }

            @Nullable
            public final String m8306a() {
                return m8301j();
            }

            public final int jK_() {
                return 77090322;
            }

            public final GraphQLVisitableModel m8305a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8302k() != null) {
                    FBFullImageFragmentModel fBFullImageFragmentModel = (FBFullImageFragmentModel) graphQLModelMutatingVisitor.b(m8302k());
                    if (m8302k() != fBFullImageFragmentModel) {
                        graphQLVisitableModel = (ContextCardPhotoModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6468e = fBFullImageFragmentModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8304a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m8301j());
                int a = ModelHelper.a(flatBufferBuilder, m8302k());
                int b2 = flatBufferBuilder.b(m8303l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 842551240)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_urls */
        public final class ContextImageModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f6470d;

            /* compiled from: photo_urls */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ContextImageModel.class, new Deserializer());
                }

                public Object m8307a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ContextImageParser.m8454a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object contextImageModel = new ContextImageModel();
                    ((BaseModel) contextImageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (contextImageModel instanceof Postprocessable) {
                        return ((Postprocessable) contextImageModel).a();
                    }
                    return contextImageModel;
                }
            }

            /* compiled from: photo_urls */
            public class Serializer extends JsonSerializer<ContextImageModel> {
                public final void m8308a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ContextImageModel contextImageModel = (ContextImageModel) obj;
                    if (contextImageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(contextImageModel.m8310a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        contextImageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ContextImageParser.m8455a(contextImageModel.w_(), contextImageModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ContextImageModel.class, new Serializer());
                }
            }

            public ContextImageModel() {
                super(1);
            }

            @Nullable
            private String m8309a() {
                this.f6470d = super.a(this.f6470d, 0);
                return this.f6470d;
            }

            public final int jK_() {
                return 70760763;
            }

            public final GraphQLVisitableModel m8311a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m8310a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m8309a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_urls */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LeadGenContextCardFieldsModel.class, new Deserializer());
            }

            public Object m8312a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LeadGenContextCardFieldsParser.m8456a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object leadGenContextCardFieldsModel = new LeadGenContextCardFieldsModel();
                ((BaseModel) leadGenContextCardFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (leadGenContextCardFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) leadGenContextCardFieldsModel).a();
                }
                return leadGenContextCardFieldsModel;
            }
        }

        /* compiled from: photo_urls */
        public class Serializer extends JsonSerializer<LeadGenContextCardFieldsModel> {
            public final void m8313a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LeadGenContextCardFieldsModel leadGenContextCardFieldsModel = (LeadGenContextCardFieldsModel) obj;
                if (leadGenContextCardFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(leadGenContextCardFieldsModel.m8320a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    leadGenContextCardFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LeadGenContextCardFieldsParser.m8457a(leadGenContextCardFieldsModel.w_(), leadGenContextCardFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LeadGenContextCardFieldsModel.class, new Serializer());
            }
        }

        public LeadGenContextCardFieldsModel() {
            super(6);
        }

        @Nullable
        private ContextCardPhotoModel m8314a() {
            this.f6471d = (ContextCardPhotoModel) super.a(this.f6471d, 0, ContextCardPhotoModel.class);
            return this.f6471d;
        }

        @Nonnull
        private ImmutableList<String> m8315j() {
            this.f6472e = super.a(this.f6472e, 1);
            return (ImmutableList) this.f6472e;
        }

        @Nullable
        private GraphQLLeadGenContextPageContentStyle m8316k() {
            this.f6473f = (GraphQLLeadGenContextPageContentStyle) super.b(this.f6473f, 2, GraphQLLeadGenContextPageContentStyle.class, GraphQLLeadGenContextPageContentStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6473f;
        }

        @Nullable
        private String m8317l() {
            this.f6474g = super.a(this.f6474g, 3);
            return this.f6474g;
        }

        @Nullable
        private ContextImageModel m8318m() {
            this.f6475h = (ContextImageModel) super.a(this.f6475h, 4, ContextImageModel.class);
            return this.f6475h;
        }

        @Nullable
        private String m8319n() {
            this.f6476i = super.a(this.f6476i, 5);
            return this.f6476i;
        }

        public final int jK_() {
            return 706615818;
        }

        public final GraphQLVisitableModel m8321a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8314a() != null) {
                ContextCardPhotoModel contextCardPhotoModel = (ContextCardPhotoModel) graphQLModelMutatingVisitor.b(m8314a());
                if (m8314a() != contextCardPhotoModel) {
                    graphQLVisitableModel = (LeadGenContextCardFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6471d = contextCardPhotoModel;
                }
            }
            if (m8318m() != null) {
                ContextImageModel contextImageModel = (ContextImageModel) graphQLModelMutatingVisitor.b(m8318m());
                if (m8318m() != contextImageModel) {
                    graphQLVisitableModel = (LeadGenContextCardFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6475h = contextImageModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8320a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m8314a());
            int c = flatBufferBuilder.c(m8315j());
            int a2 = flatBufferBuilder.a(m8316k());
            int b = flatBufferBuilder.b(m8317l());
            int a3 = ModelHelper.a(flatBufferBuilder, m8318m());
            int b2 = flatBufferBuilder.b(m8319n());
            flatBufferBuilder.c(6);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, c);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b);
            flatBufferBuilder.b(4, a3);
            flatBufferBuilder.b(5, b2);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -7600582)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_urls */
    public final class LeadGenDeepLinkDataFragModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f6495A;
        private boolean f6496B;
        @Nullable
        private String f6497C;
        @Nullable
        private String f6498D;
        @Nullable
        private String f6499E;
        @Nullable
        private String f6500F;
        @Nullable
        private String f6501d;
        private int f6502e;
        @Nullable
        private String f6503f;
        @Nullable
        private String f6504g;
        @Nullable
        private List<ErrorCodesModel> f6505h;
        @Nullable
        private String f6506i;
        @Nullable
        private String f6507j;
        @Nullable
        private String f6508k;
        @Nullable
        private String f6509l;
        @Nullable
        private String f6510m;
        @Nullable
        private String f6511n;
        @Nullable
        private String f6512o;
        @Nullable
        private String f6513p;
        @Nullable
        private LeadGenDataModel f6514q;
        @Nullable
        private LeadGenDeepLinkUserStatusModel f6515r;
        @Nullable
        private PageModel f6516s;
        @Nullable
        private String f6517t;
        @Nullable
        private String f6518u;
        @Nullable
        private String f6519v;
        @Nullable
        private String f6520w;
        @Nullable
        private String f6521x;
        @Nullable
        private String f6522y;
        @Nullable
        private String f6523z;

        /* compiled from: photo_urls */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LeadGenDeepLinkDataFragModel.class, new Deserializer());
            }

            public Object m8322a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LeadGenDeepLinkDataFragParser.m8474a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object leadGenDeepLinkDataFragModel = new LeadGenDeepLinkDataFragModel();
                ((BaseModel) leadGenDeepLinkDataFragModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (leadGenDeepLinkDataFragModel instanceof Postprocessable) {
                    return ((Postprocessable) leadGenDeepLinkDataFragModel).a();
                }
                return leadGenDeepLinkDataFragModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -449724762)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_urls */
        public final class ErrorCodesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private String f6477d;
            @Nullable
            private GraphQLLeadGenInfoFieldInputType f6478e;

            /* compiled from: photo_urls */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ErrorCodesModel.class, new Deserializer());
                }

                public Object m8323a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ErrorCodesParser.m8461b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object errorCodesModel = new ErrorCodesModel();
                    ((BaseModel) errorCodesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (errorCodesModel instanceof Postprocessable) {
                        return ((Postprocessable) errorCodesModel).a();
                    }
                    return errorCodesModel;
                }
            }

            /* compiled from: photo_urls */
            public class Serializer extends JsonSerializer<ErrorCodesModel> {
                public final void m8324a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ErrorCodesModel errorCodesModel = (ErrorCodesModel) obj;
                    if (errorCodesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(errorCodesModel.m8327a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        errorCodesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ErrorCodesParser.m8459a(errorCodesModel.w_(), errorCodesModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(ErrorCodesModel.class, new Serializer());
                }
            }

            public ErrorCodesModel() {
                super(2);
            }

            @Nullable
            private String m8325a() {
                this.f6477d = super.a(this.f6477d, 0);
                return this.f6477d;
            }

            @Nullable
            private GraphQLLeadGenInfoFieldInputType m8326j() {
                this.f6478e = (GraphQLLeadGenInfoFieldInputType) super.b(this.f6478e, 1, GraphQLLeadGenInfoFieldInputType.class, GraphQLLeadGenInfoFieldInputType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                return this.f6478e;
            }

            public final int jK_() {
                return -1908897706;
            }

            public final GraphQLVisitableModel m8328a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m8327a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m8325a());
                int a = flatBufferBuilder.a(m8326j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, b);
                flatBufferBuilder.b(1, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1241055658)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_urls */
        public final class LeadGenDataModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private LeadGenContextCardFieldsModel f6483d;
            @Nullable
            private String f6484e;
            @Nullable
            private LeadGenLegalFieldsModel f6485f;
            private boolean f6486g;
            @Nullable
            private List<PagesModel> f6487h;
            @Nullable
            private String f6488i;
            @Nullable
            private String f6489j;
            private boolean f6490k;

            /* compiled from: photo_urls */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LeadGenDataModel.class, new Deserializer());
                }

                public Object m8329a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LeadGenDataParser.m8468a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object leadGenDataModel = new LeadGenDataModel();
                    ((BaseModel) leadGenDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (leadGenDataModel instanceof Postprocessable) {
                        return ((Postprocessable) leadGenDataModel).a();
                    }
                    return leadGenDataModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -3466528)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: photo_urls */
            public final class PagesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private List<LeadGenInfoFieldsModel> f6481d;
                @Nullable
                private List<PrivacyDataModel> f6482e;

                /* compiled from: photo_urls */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(PagesModel.class, new Deserializer());
                    }

                    public Object m8330a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(PagesParser.m8466b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object pagesModel = new PagesModel();
                        ((BaseModel) pagesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (pagesModel instanceof Postprocessable) {
                            return ((Postprocessable) pagesModel).a();
                        }
                        return pagesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = 236131661)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: photo_urls */
                public final class PrivacyDataModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private String f6479d;
                    @Nullable
                    private GraphQLLeadGenPrivacyType f6480e;

                    /* compiled from: photo_urls */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(PrivacyDataModel.class, new Deserializer());
                        }

                        public Object m8331a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(PrivacyDataParser.m8464b(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object privacyDataModel = new PrivacyDataModel();
                            ((BaseModel) privacyDataModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (privacyDataModel instanceof Postprocessable) {
                                return ((Postprocessable) privacyDataModel).a();
                            }
                            return privacyDataModel;
                        }
                    }

                    /* compiled from: photo_urls */
                    public class Serializer extends JsonSerializer<PrivacyDataModel> {
                        public final void m8332a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            PrivacyDataModel privacyDataModel = (PrivacyDataModel) obj;
                            if (privacyDataModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(privacyDataModel.m8335a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                privacyDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            PrivacyDataParser.m8463a(privacyDataModel.w_(), privacyDataModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(PrivacyDataModel.class, new Serializer());
                        }
                    }

                    public PrivacyDataModel() {
                        super(2);
                    }

                    @Nullable
                    private String m8333a() {
                        this.f6479d = super.a(this.f6479d, 0);
                        return this.f6479d;
                    }

                    @Nullable
                    private GraphQLLeadGenPrivacyType m8334j() {
                        this.f6480e = (GraphQLLeadGenPrivacyType) super.b(this.f6480e, 1, GraphQLLeadGenPrivacyType.class, GraphQLLeadGenPrivacyType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
                        return this.f6480e;
                    }

                    public final int jK_() {
                        return -1982153002;
                    }

                    public final GraphQLVisitableModel m8336a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m8335a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int b = flatBufferBuilder.b(m8333a());
                        int a = flatBufferBuilder.a(m8334j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, b);
                        flatBufferBuilder.b(1, a);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: photo_urls */
                public class Serializer extends JsonSerializer<PagesModel> {
                    public final void m8337a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        PagesModel pagesModel = (PagesModel) obj;
                        if (pagesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(pagesModel.m8340a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            pagesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        PagesParser.m8467b(pagesModel.w_(), pagesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(PagesModel.class, new Serializer());
                    }
                }

                public PagesModel() {
                    super(2);
                }

                @Nonnull
                private ImmutableList<LeadGenInfoFieldsModel> m8338a() {
                    this.f6481d = super.a(this.f6481d, 0, LeadGenInfoFieldsModel.class);
                    return (ImmutableList) this.f6481d;
                }

                @Nonnull
                private ImmutableList<PrivacyDataModel> m8339j() {
                    this.f6482e = super.a(this.f6482e, 1, PrivacyDataModel.class);
                    return (ImmutableList) this.f6482e;
                }

                public final int jK_() {
                    return -1255530781;
                }

                public final GraphQLVisitableModel m8341a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    Builder a;
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m8338a() != null) {
                        a = ModelHelper.a(m8338a(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (PagesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f6481d = a.b();
                        }
                    }
                    if (m8339j() != null) {
                        a = ModelHelper.a(m8339j(), graphQLModelMutatingVisitor);
                        if (a != null) {
                            graphQLVisitableModel = (PagesModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f6482e = a.b();
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m8340a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m8338a());
                    int a2 = ModelHelper.a(flatBufferBuilder, m8339j());
                    flatBufferBuilder.c(2);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.b(1, a2);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: photo_urls */
            public class Serializer extends JsonSerializer<LeadGenDataModel> {
                public final void m8342a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LeadGenDataModel leadGenDataModel = (LeadGenDataModel) obj;
                    if (leadGenDataModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(leadGenDataModel.m8349a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        leadGenDataModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LeadGenDataParser.m8469a(leadGenDataModel.w_(), leadGenDataModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(LeadGenDataModel.class, new Serializer());
                }
            }

            public LeadGenDataModel() {
                super(8);
            }

            @Nullable
            private LeadGenContextCardFieldsModel m8343a() {
                this.f6483d = (LeadGenContextCardFieldsModel) super.a(this.f6483d, 0, LeadGenContextCardFieldsModel.class);
                return this.f6483d;
            }

            @Nullable
            private String m8344j() {
                this.f6484e = super.a(this.f6484e, 1);
                return this.f6484e;
            }

            @Nullable
            private LeadGenLegalFieldsModel m8345k() {
                this.f6485f = (LeadGenLegalFieldsModel) super.a(this.f6485f, 2, LeadGenLegalFieldsModel.class);
                return this.f6485f;
            }

            @Nonnull
            private ImmutableList<PagesModel> m8346l() {
                this.f6487h = super.a(this.f6487h, 4, PagesModel.class);
                return (ImmutableList) this.f6487h;
            }

            @Nullable
            private String m8347m() {
                this.f6488i = super.a(this.f6488i, 5);
                return this.f6488i;
            }

            @Nullable
            private String m8348n() {
                this.f6489j = super.a(this.f6489j, 6);
                return this.f6489j;
            }

            public final int jK_() {
                return -1255887874;
            }

            public final GraphQLVisitableModel m8350a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8343a() != null) {
                    LeadGenContextCardFieldsModel leadGenContextCardFieldsModel = (LeadGenContextCardFieldsModel) graphQLModelMutatingVisitor.b(m8343a());
                    if (m8343a() != leadGenContextCardFieldsModel) {
                        graphQLVisitableModel = (LeadGenDataModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6483d = leadGenContextCardFieldsModel;
                    }
                }
                if (m8345k() != null) {
                    LeadGenLegalFieldsModel leadGenLegalFieldsModel = (LeadGenLegalFieldsModel) graphQLModelMutatingVisitor.b(m8345k());
                    if (m8345k() != leadGenLegalFieldsModel) {
                        graphQLVisitableModel = (LeadGenDataModel) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f6485f = leadGenLegalFieldsModel;
                    }
                }
                if (m8346l() != null) {
                    Builder a = ModelHelper.a(m8346l(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        LeadGenDataModel leadGenDataModel = (LeadGenDataModel) ModelHelper.a(graphQLVisitableModel, this);
                        leadGenDataModel.f6487h = a.b();
                        graphQLVisitableModel = leadGenDataModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8349a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8343a());
                int b = flatBufferBuilder.b(m8344j());
                int a2 = ModelHelper.a(flatBufferBuilder, m8345k());
                int a3 = ModelHelper.a(flatBufferBuilder, m8346l());
                int b2 = flatBufferBuilder.b(m8347m());
                int b3 = flatBufferBuilder.b(m8348n());
                flatBufferBuilder.c(8);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, a2);
                flatBufferBuilder.a(3, this.f6486g);
                flatBufferBuilder.b(4, a3);
                flatBufferBuilder.b(5, b2);
                flatBufferBuilder.b(6, b3);
                flatBufferBuilder.a(7, this.f6490k);
                i();
                return flatBufferBuilder.d();
            }

            public final void m8351a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f6486g = mutableFlatBuffer.a(i, 3);
                this.f6490k = mutableFlatBuffer.a(i, 7);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1034067648)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_urls */
        public final class LeadGenDeepLinkUserStatusModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
            private boolean f6491d;
            @Nullable
            private String f6492e;
            @Nullable
            private String f6493f;

            /* compiled from: photo_urls */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(LeadGenDeepLinkUserStatusModel.class, new Deserializer());
                }

                public Object m8352a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(LeadGenDeepLinkUserStatusParser.m8470a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object leadGenDeepLinkUserStatusModel = new LeadGenDeepLinkUserStatusModel();
                    ((BaseModel) leadGenDeepLinkUserStatusModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (leadGenDeepLinkUserStatusModel instanceof Postprocessable) {
                        return ((Postprocessable) leadGenDeepLinkUserStatusModel).a();
                    }
                    return leadGenDeepLinkUserStatusModel;
                }
            }

            /* compiled from: photo_urls */
            public class Serializer extends JsonSerializer<LeadGenDeepLinkUserStatusModel> {
                public final void m8353a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    LeadGenDeepLinkUserStatusModel leadGenDeepLinkUserStatusModel = (LeadGenDeepLinkUserStatusModel) obj;
                    if (leadGenDeepLinkUserStatusModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(leadGenDeepLinkUserStatusModel.m8358a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        leadGenDeepLinkUserStatusModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    LeadGenDeepLinkUserStatusParser.m8471a(leadGenDeepLinkUserStatusModel.w_(), leadGenDeepLinkUserStatusModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(LeadGenDeepLinkUserStatusModel.class, new Serializer());
                }
            }

            public LeadGenDeepLinkUserStatusModel() {
                super(3);
            }

            public final void m8362a(String str, ConsistencyTuple consistencyTuple) {
                if ("has_shared_info".equals(str)) {
                    consistencyTuple.a = Boolean.valueOf(m8355j());
                    consistencyTuple.b = u_();
                    consistencyTuple.c = 0;
                    return;
                }
                consistencyTuple.a();
            }

            public final void m8363a(String str, Object obj, boolean z) {
                if ("has_shared_info".equals(str)) {
                    m8354a(((Boolean) obj).booleanValue());
                }
            }

            private boolean m8355j() {
                a(0, 0);
                return this.f6491d;
            }

            private void m8354a(boolean z) {
                this.f6491d = z;
                if (this.b != null && this.b.d) {
                    this.b.a(this.c, 0, z);
                }
            }

            @Nullable
            private String m8356k() {
                this.f6492e = super.a(this.f6492e, 1);
                return this.f6492e;
            }

            @Nullable
            private String m8357l() {
                this.f6493f = super.a(this.f6493f, 2);
                return this.f6493f;
            }

            @Nullable
            public final String m8360a() {
                return m8356k();
            }

            public final int jK_() {
                return 771298455;
            }

            public final GraphQLVisitableModel m8359a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m8358a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m8356k());
                int b2 = flatBufferBuilder.b(m8357l());
                flatBufferBuilder.c(3);
                flatBufferBuilder.a(0, this.f6491d);
                flatBufferBuilder.b(1, b);
                flatBufferBuilder.b(2, b2);
                i();
                return flatBufferBuilder.d();
            }

            public final void m8361a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f6491d = mutableFlatBuffer.a(i, 0);
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1097398158)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_urls */
        public final class PageModel extends BaseModel implements GraphQLVisitableConsistentModel {
            @Nullable
            private DefaultImageFieldsModel f6494d;

            /* compiled from: photo_urls */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(PageModel.class, new Deserializer());
                }

                public Object m8364a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(PageParser.m8472a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object pageModel = new PageModel();
                    ((BaseModel) pageModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (pageModel instanceof Postprocessable) {
                        return ((Postprocessable) pageModel).a();
                    }
                    return pageModel;
                }
            }

            /* compiled from: photo_urls */
            public class Serializer extends JsonSerializer<PageModel> {
                public final void m8365a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    PageModel pageModel = (PageModel) obj;
                    if (pageModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(pageModel.m8367a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        pageModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    PageParser.m8473a(pageModel.w_(), pageModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(PageModel.class, new Serializer());
                }
            }

            public PageModel() {
                super(1);
            }

            public final void m8369a(String str, ConsistencyTuple consistencyTuple) {
                consistencyTuple.a();
            }

            public final void m8370a(String str, Object obj, boolean z) {
            }

            @Nullable
            private DefaultImageFieldsModel m8366a() {
                this.f6494d = (DefaultImageFieldsModel) super.a(this.f6494d, 0, DefaultImageFieldsModel.class);
                return this.f6494d;
            }

            public final int jK_() {
                return 2479791;
            }

            public final GraphQLVisitableModel m8368a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8366a() != null) {
                    DefaultImageFieldsModel defaultImageFieldsModel = (DefaultImageFieldsModel) graphQLModelMutatingVisitor.b(m8366a());
                    if (m8366a() != defaultImageFieldsModel) {
                        graphQLVisitableModel = (PageModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6494d = defaultImageFieldsModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8367a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8366a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_urls */
        public class Serializer extends JsonSerializer<LeadGenDeepLinkDataFragModel> {
            public final void m8371a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LeadGenDeepLinkDataFragModel leadGenDeepLinkDataFragModel = (LeadGenDeepLinkDataFragModel) obj;
                if (leadGenDeepLinkDataFragModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(leadGenDeepLinkDataFragModel.m8399a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    leadGenDeepLinkDataFragModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LeadGenDeepLinkDataFragParser.m8475a(leadGenDeepLinkDataFragModel.w_(), leadGenDeepLinkDataFragModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LeadGenDeepLinkDataFragModel.class, new Serializer());
            }
        }

        public LeadGenDeepLinkDataFragModel() {
            super(29);
        }

        @Nullable
        private String m8381a() {
            this.f6501d = super.a(this.f6501d, 0);
            return this.f6501d;
        }

        @Nullable
        private String m8382j() {
            this.f6503f = super.a(this.f6503f, 2);
            return this.f6503f;
        }

        @Nullable
        private String m8383k() {
            this.f6504g = super.a(this.f6504g, 3);
            return this.f6504g;
        }

        @Nonnull
        private ImmutableList<ErrorCodesModel> m8384l() {
            this.f6505h = super.a(this.f6505h, 4, ErrorCodesModel.class);
            return (ImmutableList) this.f6505h;
        }

        @Nullable
        private String m8385m() {
            this.f6506i = super.a(this.f6506i, 5);
            return this.f6506i;
        }

        @Nullable
        private String m8386n() {
            this.f6507j = super.a(this.f6507j, 6);
            return this.f6507j;
        }

        @Nullable
        private String m8387o() {
            this.f6508k = super.a(this.f6508k, 7);
            return this.f6508k;
        }

        @Nullable
        private String m8388p() {
            this.f6509l = super.a(this.f6509l, 8);
            return this.f6509l;
        }

        @Nullable
        private String m8389q() {
            this.f6510m = super.a(this.f6510m, 9);
            return this.f6510m;
        }

        @Nullable
        private String m8390r() {
            this.f6511n = super.a(this.f6511n, 10);
            return this.f6511n;
        }

        @Nullable
        private String m8391s() {
            this.f6512o = super.a(this.f6512o, 11);
            return this.f6512o;
        }

        @Nullable
        private String m8392t() {
            this.f6513p = super.a(this.f6513p, 12);
            return this.f6513p;
        }

        @Nullable
        private LeadGenDataModel m8393u() {
            this.f6514q = (LeadGenDataModel) super.a(this.f6514q, 13, LeadGenDataModel.class);
            return this.f6514q;
        }

        @Nullable
        private LeadGenDeepLinkUserStatusModel m8394v() {
            this.f6515r = (LeadGenDeepLinkUserStatusModel) super.a(this.f6515r, 14, LeadGenDeepLinkUserStatusModel.class);
            return this.f6515r;
        }

        @Nullable
        private PageModel m8395w() {
            this.f6516s = (PageModel) super.a(this.f6516s, 15, PageModel.class);
            return this.f6516s;
        }

        @Nullable
        private String m8396x() {
            this.f6517t = super.a(this.f6517t, 16);
            return this.f6517t;
        }

        @Nullable
        private String m8397y() {
            this.f6518u = super.a(this.f6518u, 17);
            return this.f6518u;
        }

        @Nullable
        private String m8398z() {
            this.f6519v = super.a(this.f6519v, 18);
            return this.f6519v;
        }

        @Nullable
        private String m8372A() {
            this.f6520w = super.a(this.f6520w, 19);
            return this.f6520w;
        }

        @Nullable
        private String m8373B() {
            this.f6521x = super.a(this.f6521x, 20);
            return this.f6521x;
        }

        @Nullable
        private String m8374C() {
            this.f6522y = super.a(this.f6522y, 21);
            return this.f6522y;
        }

        @Nullable
        private String m8375D() {
            this.f6523z = super.a(this.f6523z, 22);
            return this.f6523z;
        }

        @Nullable
        private String m8376E() {
            this.f6495A = super.a(this.f6495A, 23);
            return this.f6495A;
        }

        @Nullable
        private String m8377F() {
            this.f6497C = super.a(this.f6497C, 25);
            return this.f6497C;
        }

        @Nullable
        private String m8378G() {
            this.f6498D = super.a(this.f6498D, 26);
            return this.f6498D;
        }

        @Nullable
        private String m8379H() {
            this.f6499E = super.a(this.f6499E, 27);
            return this.f6499E;
        }

        @Nullable
        private String m8380I() {
            this.f6500F = super.a(this.f6500F, 28);
            return this.f6500F;
        }

        public final int jK_() {
            return 561538084;
        }

        public final GraphQLVisitableModel m8400a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel;
            LeadGenDataModel leadGenDataModel;
            LeadGenDeepLinkUserStatusModel leadGenDeepLinkUserStatusModel;
            PageModel pageModel;
            h();
            if (m8384l() != null) {
                Builder a = ModelHelper.a(m8384l(), graphQLModelMutatingVisitor);
                if (a != null) {
                    LeadGenDeepLinkDataFragModel leadGenDeepLinkDataFragModel = (LeadGenDeepLinkDataFragModel) ModelHelper.a(null, this);
                    leadGenDeepLinkDataFragModel.f6505h = a.b();
                    graphQLVisitableModel = leadGenDeepLinkDataFragModel;
                    if (m8393u() != null) {
                        leadGenDataModel = (LeadGenDataModel) graphQLModelMutatingVisitor.b(m8393u());
                        if (m8393u() != leadGenDataModel) {
                            graphQLVisitableModel = (LeadGenDeepLinkDataFragModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f6514q = leadGenDataModel;
                        }
                    }
                    if (m8394v() != null) {
                        leadGenDeepLinkUserStatusModel = (LeadGenDeepLinkUserStatusModel) graphQLModelMutatingVisitor.b(m8394v());
                        if (m8394v() != leadGenDeepLinkUserStatusModel) {
                            graphQLVisitableModel = (LeadGenDeepLinkDataFragModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f6515r = leadGenDeepLinkUserStatusModel;
                        }
                    }
                    if (m8395w() != null) {
                        pageModel = (PageModel) graphQLModelMutatingVisitor.b(m8395w());
                        if (m8395w() != pageModel) {
                            graphQLVisitableModel = (LeadGenDeepLinkDataFragModel) ModelHelper.a(graphQLVisitableModel, this);
                            graphQLVisitableModel.f6516s = pageModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel != null ? this : graphQLVisitableModel;
                }
            }
            graphQLVisitableModel = null;
            if (m8393u() != null) {
                leadGenDataModel = (LeadGenDataModel) graphQLModelMutatingVisitor.b(m8393u());
                if (m8393u() != leadGenDataModel) {
                    graphQLVisitableModel = (LeadGenDeepLinkDataFragModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6514q = leadGenDataModel;
                }
            }
            if (m8394v() != null) {
                leadGenDeepLinkUserStatusModel = (LeadGenDeepLinkUserStatusModel) graphQLModelMutatingVisitor.b(m8394v());
                if (m8394v() != leadGenDeepLinkUserStatusModel) {
                    graphQLVisitableModel = (LeadGenDeepLinkDataFragModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6515r = leadGenDeepLinkUserStatusModel;
                }
            }
            if (m8395w() != null) {
                pageModel = (PageModel) graphQLModelMutatingVisitor.b(m8395w());
                if (m8395w() != pageModel) {
                    graphQLVisitableModel = (LeadGenDeepLinkDataFragModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6516s = pageModel;
                }
            }
            i();
            if (graphQLVisitableModel != null) {
            }
        }

        public final int m8399a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m8381a());
            int b2 = flatBufferBuilder.b(m8382j());
            int b3 = flatBufferBuilder.b(m8383k());
            int a = ModelHelper.a(flatBufferBuilder, m8384l());
            int b4 = flatBufferBuilder.b(m8385m());
            int b5 = flatBufferBuilder.b(m8386n());
            int b6 = flatBufferBuilder.b(m8387o());
            int b7 = flatBufferBuilder.b(m8388p());
            int b8 = flatBufferBuilder.b(m8389q());
            int b9 = flatBufferBuilder.b(m8390r());
            int b10 = flatBufferBuilder.b(m8391s());
            int b11 = flatBufferBuilder.b(m8392t());
            int a2 = ModelHelper.a(flatBufferBuilder, m8393u());
            int a3 = ModelHelper.a(flatBufferBuilder, m8394v());
            int a4 = ModelHelper.a(flatBufferBuilder, m8395w());
            int b12 = flatBufferBuilder.b(m8396x());
            int b13 = flatBufferBuilder.b(m8397y());
            int b14 = flatBufferBuilder.b(m8398z());
            int b15 = flatBufferBuilder.b(m8372A());
            int b16 = flatBufferBuilder.b(m8373B());
            int b17 = flatBufferBuilder.b(m8374C());
            int b18 = flatBufferBuilder.b(m8375D());
            int b19 = flatBufferBuilder.b(m8376E());
            int b20 = flatBufferBuilder.b(m8377F());
            int b21 = flatBufferBuilder.b(m8378G());
            int b22 = flatBufferBuilder.b(m8379H());
            int b23 = flatBufferBuilder.b(m8380I());
            flatBufferBuilder.c(29);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f6502e, 0);
            flatBufferBuilder.b(2, b2);
            flatBufferBuilder.b(3, b3);
            flatBufferBuilder.b(4, a);
            flatBufferBuilder.b(5, b4);
            flatBufferBuilder.b(6, b5);
            flatBufferBuilder.b(7, b6);
            flatBufferBuilder.b(8, b7);
            flatBufferBuilder.b(9, b8);
            flatBufferBuilder.b(10, b9);
            flatBufferBuilder.b(11, b10);
            flatBufferBuilder.b(12, b11);
            flatBufferBuilder.b(13, a2);
            flatBufferBuilder.b(14, a3);
            flatBufferBuilder.b(15, a4);
            flatBufferBuilder.b(16, b12);
            flatBufferBuilder.b(17, b13);
            flatBufferBuilder.b(18, b14);
            flatBufferBuilder.b(19, b15);
            flatBufferBuilder.b(20, b16);
            flatBufferBuilder.b(21, b17);
            flatBufferBuilder.b(22, b18);
            flatBufferBuilder.b(23, b19);
            flatBufferBuilder.a(24, this.f6496B);
            flatBufferBuilder.b(25, b20);
            flatBufferBuilder.b(26, b21);
            flatBufferBuilder.b(27, b22);
            flatBufferBuilder.b(28, b23);
            i();
            return flatBufferBuilder.d();
        }

        public final void m8401a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f6502e = mutableFlatBuffer.a(i, 1, 0);
            this.f6496B = mutableFlatBuffer.a(i, 24);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -629350063)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_urls */
    public final class LeadGenInfoFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private List<String> f6524d;
        @Nullable
        private String f6525e;
        @Nullable
        private GraphQLLeadGenInfoFieldInputDomain f6526f;
        @Nullable
        private GraphQLLeadGenInfoFieldInputType f6527g;
        private boolean f6528h;
        private boolean f6529i;
        private boolean f6530j;
        @Nullable
        private String f6531k;
        @Nullable
        private String f6532l;
        @Nullable
        private List<String> f6533m;

        /* compiled from: photo_urls */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LeadGenInfoFieldsModel.class, new Deserializer());
            }

            public Object m8402a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LeadGenInfoFieldsParser.m8477b(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object leadGenInfoFieldsModel = new LeadGenInfoFieldsModel();
                ((BaseModel) leadGenInfoFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (leadGenInfoFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) leadGenInfoFieldsModel).a();
                }
                return leadGenInfoFieldsModel;
            }
        }

        /* compiled from: photo_urls */
        public class Serializer extends JsonSerializer<LeadGenInfoFieldsModel> {
            public final void m8403a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LeadGenInfoFieldsModel leadGenInfoFieldsModel = (LeadGenInfoFieldsModel) obj;
                if (leadGenInfoFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(leadGenInfoFieldsModel.m8411a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    leadGenInfoFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LeadGenInfoFieldsParser.m8476a(leadGenInfoFieldsModel.w_(), leadGenInfoFieldsModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(LeadGenInfoFieldsModel.class, new Serializer());
            }
        }

        public LeadGenInfoFieldsModel() {
            super(10);
        }

        @Nonnull
        private ImmutableList<String> m8404a() {
            this.f6524d = super.a(this.f6524d, 0);
            return (ImmutableList) this.f6524d;
        }

        @Nullable
        private String m8405j() {
            this.f6525e = super.a(this.f6525e, 1);
            return this.f6525e;
        }

        @Nullable
        private GraphQLLeadGenInfoFieldInputDomain m8406k() {
            this.f6526f = (GraphQLLeadGenInfoFieldInputDomain) super.b(this.f6526f, 2, GraphQLLeadGenInfoFieldInputDomain.class, GraphQLLeadGenInfoFieldInputDomain.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6526f;
        }

        @Nullable
        private GraphQLLeadGenInfoFieldInputType m8407l() {
            this.f6527g = (GraphQLLeadGenInfoFieldInputType) super.b(this.f6527g, 3, GraphQLLeadGenInfoFieldInputType.class, GraphQLLeadGenInfoFieldInputType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f6527g;
        }

        @Nullable
        private String m8408m() {
            this.f6531k = super.a(this.f6531k, 7);
            return this.f6531k;
        }

        @Nullable
        private String m8409n() {
            this.f6532l = super.a(this.f6532l, 8);
            return this.f6532l;
        }

        @Nonnull
        private ImmutableList<String> m8410o() {
            this.f6533m = super.a(this.f6533m, 9);
            return (ImmutableList) this.f6533m;
        }

        public final int jK_() {
            return 1236596962;
        }

        public final GraphQLVisitableModel m8412a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m8411a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int c = flatBufferBuilder.c(m8404a());
            int b = flatBufferBuilder.b(m8405j());
            int a = flatBufferBuilder.a(m8406k());
            int a2 = flatBufferBuilder.a(m8407l());
            int b2 = flatBufferBuilder.b(m8408m());
            int b3 = flatBufferBuilder.b(m8409n());
            int c2 = flatBufferBuilder.c(m8410o());
            flatBufferBuilder.c(10);
            flatBufferBuilder.b(0, c);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a);
            flatBufferBuilder.b(3, a2);
            flatBufferBuilder.a(4, this.f6528h);
            flatBufferBuilder.a(5, this.f6529i);
            flatBufferBuilder.a(6, this.f6530j);
            flatBufferBuilder.b(7, b2);
            flatBufferBuilder.b(8, b3);
            flatBufferBuilder.b(9, c2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m8413a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f6528h = mutableFlatBuffer.a(i, 4);
            this.f6529i = mutableFlatBuffer.a(i, 5);
            this.f6530j = mutableFlatBuffer.a(i, 6);
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 306099319)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_urls */
    public final class LeadGenLegalFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f6546d;
        @Nullable
        private List<CheckboxesModel> f6547e;
        @Nullable
        private List<DisclaimerBodyModel> f6548f;
        @Nullable
        private String f6549g;

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1613372803)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_urls */
        public final class CheckboxesModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private CheckboxBodyModel f6535d;
            private boolean f6536e;
            private boolean f6537f;
            @Nullable
            private String f6538g;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = -1352864475)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: photo_urls */
            public final class CheckboxBodyModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private String f6534d;

                /* compiled from: photo_urls */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(CheckboxBodyModel.class, new Deserializer());
                    }

                    public Object m8414a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(CheckboxBodyParser.m8478a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object checkboxBodyModel = new CheckboxBodyModel();
                        ((BaseModel) checkboxBodyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (checkboxBodyModel instanceof Postprocessable) {
                            return ((Postprocessable) checkboxBodyModel).a();
                        }
                        return checkboxBodyModel;
                    }
                }

                /* compiled from: photo_urls */
                public class Serializer extends JsonSerializer<CheckboxBodyModel> {
                    public final void m8415a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        CheckboxBodyModel checkboxBodyModel = (CheckboxBodyModel) obj;
                        if (checkboxBodyModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(checkboxBodyModel.m8417a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            checkboxBodyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        CheckboxBodyParser.m8479a(checkboxBodyModel.w_(), checkboxBodyModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(CheckboxBodyModel.class, new Serializer());
                    }
                }

                public CheckboxBodyModel() {
                    super(1);
                }

                @Nullable
                private String m8416a() {
                    this.f6534d = super.a(this.f6534d, 0);
                    return this.f6534d;
                }

                public final int jK_() {
                    return -1919764332;
                }

                public final GraphQLVisitableModel m8418a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m8417a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m8416a());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: photo_urls */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(CheckboxesModel.class, new Deserializer());
                }

                public Object m8419a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(CheckboxesParser.m8480b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object checkboxesModel = new CheckboxesModel();
                    ((BaseModel) checkboxesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (checkboxesModel instanceof Postprocessable) {
                        return ((Postprocessable) checkboxesModel).a();
                    }
                    return checkboxesModel;
                }
            }

            /* compiled from: photo_urls */
            public class Serializer extends JsonSerializer<CheckboxesModel> {
                public final void m8420a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    CheckboxesModel checkboxesModel = (CheckboxesModel) obj;
                    if (checkboxesModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(checkboxesModel.m8423a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        checkboxesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    CheckboxesParser.m8481b(checkboxesModel.w_(), checkboxesModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(CheckboxesModel.class, new Serializer());
                }
            }

            public CheckboxesModel() {
                super(4);
            }

            @Nullable
            private CheckboxBodyModel m8421a() {
                this.f6535d = (CheckboxBodyModel) super.a(this.f6535d, 0, CheckboxBodyModel.class);
                return this.f6535d;
            }

            @Nullable
            private String m8422j() {
                this.f6538g = super.a(this.f6538g, 3);
                return this.f6538g;
            }

            public final int jK_() {
                return -1082774601;
            }

            public final GraphQLVisitableModel m8424a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8421a() != null) {
                    CheckboxBodyModel checkboxBodyModel = (CheckboxBodyModel) graphQLModelMutatingVisitor.b(m8421a());
                    if (m8421a() != checkboxBodyModel) {
                        graphQLVisitableModel = (CheckboxesModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6535d = checkboxBodyModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8423a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8421a());
                int b = flatBufferBuilder.b(m8422j());
                flatBufferBuilder.c(4);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.a(1, this.f6536e);
                flatBufferBuilder.a(2, this.f6537f);
                flatBufferBuilder.b(3, b);
                i();
                return flatBufferBuilder.d();
            }

            public final void m8425a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                super.a(mutableFlatBuffer, i, obj);
                this.f6536e = mutableFlatBuffer.a(i, 1);
                this.f6537f = mutableFlatBuffer.a(i, 2);
            }
        }

        /* compiled from: photo_urls */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(LeadGenLegalFieldsModel.class, new Deserializer());
            }

            public Object m8426a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(LeadGenLegalFieldsParser.m8489a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object leadGenLegalFieldsModel = new LeadGenLegalFieldsModel();
                ((BaseModel) leadGenLegalFieldsModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (leadGenLegalFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) leadGenLegalFieldsModel).a();
                }
                return leadGenLegalFieldsModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -212086651)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: photo_urls */
        public final class DisclaimerBodyModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private List<RangesModel> f6544d;
            @Nullable
            private String f6545e;

            /* compiled from: photo_urls */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(DisclaimerBodyModel.class, new Deserializer());
                }

                public Object m8427a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(DisclaimerBodyParser.m8487b(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object disclaimerBodyModel = new DisclaimerBodyModel();
                    ((BaseModel) disclaimerBodyModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (disclaimerBodyModel instanceof Postprocessable) {
                        return ((Postprocessable) disclaimerBodyModel).a();
                    }
                    return disclaimerBodyModel;
                }
            }

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1995728743)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: photo_urls */
            public final class RangesModel extends BaseModel implements GraphQLVisitableModel {
                @Nullable
                private EntityModel f6541d;
                private int f6542e;
                private int f6543f;

                /* compiled from: photo_urls */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(RangesModel.class, new Deserializer());
                    }

                    public Object m8428a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(RangesParser.m8484b(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object rangesModel = new RangesModel();
                        ((BaseModel) rangesModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (rangesModel instanceof Postprocessable) {
                            return ((Postprocessable) rangesModel).a();
                        }
                        return rangesModel;
                    }
                }

                @JsonDeserialize(using = Deserializer.class)
                @ModelWithFlatBufferFormatHash(a = -1205772718)
                @JsonSerialize(using = Serializer.class)
                @FragmentModelWithoutBridge
                /* compiled from: photo_urls */
                public final class EntityModel extends BaseModel implements GraphQLVisitableModel {
                    @Nullable
                    private GraphQLObjectType f6539d;
                    @Nullable
                    private String f6540e;

                    /* compiled from: photo_urls */
                    public class Deserializer extends FbJsonDeserializer {
                        static {
                            GlobalAutoGenDeserializerCache.a(EntityModel.class, new Deserializer());
                        }

                        public Object m8429a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(EntityParser.m8482a(jsonParser, flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            mutableFlatBuffer.a(4, Boolean.valueOf(true));
                            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                            Object entityModel = new EntityModel();
                            ((BaseModel) entityModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                            if (entityModel instanceof Postprocessable) {
                                return ((Postprocessable) entityModel).a();
                            }
                            return entityModel;
                        }
                    }

                    /* compiled from: photo_urls */
                    public class Serializer extends JsonSerializer<EntityModel> {
                        public final void m8430a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                            EntityModel entityModel = (EntityModel) obj;
                            if (entityModel.w_() == null) {
                                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                                flatBufferBuilder.d(entityModel.m8433a(flatBufferBuilder));
                                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                                wrap.position(0);
                                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                                entityModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                            }
                            EntityParser.m8483a(entityModel.w_(), entityModel.u_(), jsonGenerator);
                        }

                        static {
                            FbSerializerProvider.a(EntityModel.class, new Serializer());
                        }
                    }

                    public EntityModel() {
                        super(2);
                    }

                    @Nullable
                    private GraphQLObjectType m8431a() {
                        if (this.b != null && this.f6539d == null) {
                            this.f6539d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
                        }
                        return this.f6539d;
                    }

                    @Nullable
                    private String m8432j() {
                        this.f6540e = super.a(this.f6540e, 1);
                        return this.f6540e;
                    }

                    public final int jK_() {
                        return 2080559107;
                    }

                    public final GraphQLVisitableModel m8434a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                        h();
                        i();
                        return this;
                    }

                    public final int m8433a(FlatBufferBuilder flatBufferBuilder) {
                        h();
                        int a = ModelHelper.a(flatBufferBuilder, m8431a());
                        int b = flatBufferBuilder.b(m8432j());
                        flatBufferBuilder.c(2);
                        flatBufferBuilder.b(0, a);
                        flatBufferBuilder.b(1, b);
                        i();
                        return flatBufferBuilder.d();
                    }
                }

                /* compiled from: photo_urls */
                public class Serializer extends JsonSerializer<RangesModel> {
                    public final void m8435a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        RangesModel rangesModel = (RangesModel) obj;
                        if (rangesModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(rangesModel.m8437a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            rangesModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        RangesParser.m8485b(rangesModel.w_(), rangesModel.u_(), jsonGenerator, serializerProvider);
                    }

                    static {
                        FbSerializerProvider.a(RangesModel.class, new Serializer());
                    }
                }

                public RangesModel() {
                    super(3);
                }

                @Nullable
                private EntityModel m8436a() {
                    this.f6541d = (EntityModel) super.a(this.f6541d, 0, EntityModel.class);
                    return this.f6541d;
                }

                public final int jK_() {
                    return -1024511161;
                }

                public final GraphQLVisitableModel m8438a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    GraphQLVisitableModel graphQLVisitableModel = null;
                    h();
                    if (m8436a() != null) {
                        EntityModel entityModel = (EntityModel) graphQLModelMutatingVisitor.b(m8436a());
                        if (m8436a() != entityModel) {
                            graphQLVisitableModel = (RangesModel) ModelHelper.a(null, this);
                            graphQLVisitableModel.f6541d = entityModel;
                        }
                    }
                    i();
                    return graphQLVisitableModel == null ? this : graphQLVisitableModel;
                }

                public final int m8437a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int a = ModelHelper.a(flatBufferBuilder, m8436a());
                    flatBufferBuilder.c(3);
                    flatBufferBuilder.b(0, a);
                    flatBufferBuilder.a(1, this.f6542e, 0);
                    flatBufferBuilder.a(2, this.f6543f, 0);
                    i();
                    return flatBufferBuilder.d();
                }

                public final void m8439a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
                    super.a(mutableFlatBuffer, i, obj);
                    this.f6542e = mutableFlatBuffer.a(i, 1, 0);
                    this.f6543f = mutableFlatBuffer.a(i, 2, 0);
                }
            }

            /* compiled from: photo_urls */
            public class Serializer extends JsonSerializer<DisclaimerBodyModel> {
                public final void m8440a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    DisclaimerBodyModel disclaimerBodyModel = (DisclaimerBodyModel) obj;
                    if (disclaimerBodyModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(disclaimerBodyModel.m8443a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        disclaimerBodyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    DisclaimerBodyParser.m8488b(disclaimerBodyModel.w_(), disclaimerBodyModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(DisclaimerBodyModel.class, new Serializer());
                }
            }

            public DisclaimerBodyModel() {
                super(2);
            }

            @Nonnull
            private ImmutableList<RangesModel> m8441a() {
                this.f6544d = super.a(this.f6544d, 0, RangesModel.class);
                return (ImmutableList) this.f6544d;
            }

            @Nullable
            private String m8442j() {
                this.f6545e = super.a(this.f6545e, 1);
                return this.f6545e;
            }

            public final int jK_() {
                return -1919764332;
            }

            public final GraphQLVisitableModel m8444a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m8441a() != null) {
                    Builder a = ModelHelper.a(m8441a(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLVisitableModel = (DisclaimerBodyModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f6544d = a.b();
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m8443a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m8441a());
                int b = flatBufferBuilder.b(m8442j());
                flatBufferBuilder.c(2);
                flatBufferBuilder.b(0, a);
                flatBufferBuilder.b(1, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: photo_urls */
        public class Serializer extends JsonSerializer<LeadGenLegalFieldsModel> {
            public final void m8445a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                LeadGenLegalFieldsModel leadGenLegalFieldsModel = (LeadGenLegalFieldsModel) obj;
                if (leadGenLegalFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(leadGenLegalFieldsModel.m8450a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    leadGenLegalFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                LeadGenLegalFieldsParser.m8490a(leadGenLegalFieldsModel.w_(), leadGenLegalFieldsModel.u_(), jsonGenerator, serializerProvider);
            }

            static {
                FbSerializerProvider.a(LeadGenLegalFieldsModel.class, new Serializer());
            }
        }

        public LeadGenLegalFieldsModel() {
            super(4);
        }

        @Nullable
        private String m8446a() {
            this.f6546d = super.a(this.f6546d, 0);
            return this.f6546d;
        }

        @Nonnull
        private ImmutableList<CheckboxesModel> m8447j() {
            this.f6547e = super.a(this.f6547e, 1, CheckboxesModel.class);
            return (ImmutableList) this.f6547e;
        }

        @Nonnull
        private ImmutableList<DisclaimerBodyModel> m8448k() {
            this.f6548f = super.a(this.f6548f, 2, DisclaimerBodyModel.class);
            return (ImmutableList) this.f6548f;
        }

        @Nullable
        private String m8449l() {
            this.f6549g = super.a(this.f6549g, 3);
            return this.f6549g;
        }

        public final int jK_() {
            return -1148993580;
        }

        public final GraphQLVisitableModel m8451a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            Builder a;
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m8447j() != null) {
                a = ModelHelper.a(m8447j(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (LeadGenLegalFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f6547e = a.b();
                }
            }
            if (m8448k() != null) {
                a = ModelHelper.a(m8448k(), graphQLModelMutatingVisitor);
                if (a != null) {
                    graphQLVisitableModel = (LeadGenLegalFieldsModel) ModelHelper.a(graphQLVisitableModel, this);
                    graphQLVisitableModel.f6548f = a.b();
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m8450a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m8446a());
            int a = ModelHelper.a(flatBufferBuilder, m8447j());
            int a2 = ModelHelper.a(flatBufferBuilder, m8448k());
            int b2 = flatBufferBuilder.b(m8449l());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            flatBufferBuilder.b(2, a2);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }
    }
}

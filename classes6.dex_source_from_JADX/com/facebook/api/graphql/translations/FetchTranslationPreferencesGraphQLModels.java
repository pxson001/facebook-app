package com.facebook.api.graphql.translations;

import com.facebook.api.graphql.translations.FetchTranslationPreferencesGraphQLParsers.NeverTranslateLanguageCoreMutationFieldsParser;
import com.facebook.api.graphql.translations.FetchTranslationPreferencesGraphQLParsers.NeverTranslateLanguageCoreMutationFieldsParser.ViewerParser;
import com.facebook.api.graphql.translations.FetchTranslationPreferencesGraphQLParsers.NeverTranslateLanguageCoreMutationFieldsParser.ViewerParser.AccountUserParser;
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
import com.facebook.zero.upsell.graphql.ZeroUpsellGraphQLParsers.ZeroUpsellRecoParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: prompt_display_reason */
public class FetchTranslationPreferencesGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -82227074)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: prompt_display_reason */
    public final class NeverTranslateLanguageCoreMutationFieldsModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f7152d;
        @Nullable
        private ViewerModel f7153e;

        /* compiled from: prompt_display_reason */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(NeverTranslateLanguageCoreMutationFieldsModel.class, new Deserializer());
            }

            public Object m10296a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = NeverTranslateLanguageCoreMutationFieldsParser.m10317a(jsonParser);
                Object neverTranslateLanguageCoreMutationFieldsModel = new NeverTranslateLanguageCoreMutationFieldsModel();
                ((BaseModel) neverTranslateLanguageCoreMutationFieldsModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (neverTranslateLanguageCoreMutationFieldsModel instanceof Postprocessable) {
                    return ((Postprocessable) neverTranslateLanguageCoreMutationFieldsModel).a();
                }
                return neverTranslateLanguageCoreMutationFieldsModel;
            }
        }

        /* compiled from: prompt_display_reason */
        public class Serializer extends JsonSerializer<NeverTranslateLanguageCoreMutationFieldsModel> {
            public final void m10297a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                NeverTranslateLanguageCoreMutationFieldsModel neverTranslateLanguageCoreMutationFieldsModel = (NeverTranslateLanguageCoreMutationFieldsModel) obj;
                if (neverTranslateLanguageCoreMutationFieldsModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(neverTranslateLanguageCoreMutationFieldsModel.m10313a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    neverTranslateLanguageCoreMutationFieldsModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = neverTranslateLanguageCoreMutationFieldsModel.w_();
                int u_ = neverTranslateLanguageCoreMutationFieldsModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("language_dialect");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("viewer");
                    ZeroUpsellRecoParser.a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(NeverTranslateLanguageCoreMutationFieldsModel.class, new Serializer());
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = -1590997573)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: prompt_display_reason */
        public final class ViewerModel extends BaseModel implements GraphQLVisitableModel {
            @Nullable
            private AccountUserModel f7151d;

            @JsonDeserialize(using = Deserializer.class)
            @ModelWithFlatBufferFormatHash(a = 1801334754)
            @JsonSerialize(using = Serializer.class)
            @FragmentModelWithoutBridge
            /* compiled from: prompt_display_reason */
            public final class AccountUserModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
                @Nullable
                private String f7150d;

                /* compiled from: prompt_display_reason */
                public class Deserializer extends FbJsonDeserializer {
                    static {
                        GlobalAutoGenDeserializerCache.a(AccountUserModel.class, new Deserializer());
                    }

                    public Object m10298a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(AccountUserParser.m10315a(jsonParser, flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        mutableFlatBuffer.a(4, Boolean.valueOf(true));
                        MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                        Object accountUserModel = new AccountUserModel();
                        ((BaseModel) accountUserModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                        if (accountUserModel instanceof Postprocessable) {
                            return ((Postprocessable) accountUserModel).a();
                        }
                        return accountUserModel;
                    }
                }

                /* compiled from: prompt_display_reason */
                public class Serializer extends JsonSerializer<AccountUserModel> {
                    public final void m10299a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                        AccountUserModel accountUserModel = (AccountUserModel) obj;
                        if (accountUserModel.w_() == null) {
                            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                            flatBufferBuilder.d(accountUserModel.m10301a(flatBufferBuilder));
                            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                            wrap.position(0);
                            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                            accountUserModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                        }
                        ZeroUpsellRecoParser.a(accountUserModel.w_(), accountUserModel.u_(), jsonGenerator);
                    }

                    static {
                        FbSerializerProvider.a(AccountUserModel.class, new Serializer());
                    }
                }

                public AccountUserModel() {
                    super(1);
                }

                public final void m10304a(String str, ConsistencyTuple consistencyTuple) {
                    consistencyTuple.a();
                }

                public final void m10305a(String str, Object obj, boolean z) {
                }

                @Nullable
                private String m10300j() {
                    this.f7150d = super.a(this.f7150d, 0);
                    return this.f7150d;
                }

                @Nullable
                public final String m10303a() {
                    return m10300j();
                }

                public final int jK_() {
                    return 2645995;
                }

                public final GraphQLVisitableModel m10302a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                    h();
                    i();
                    return this;
                }

                public final int m10301a(FlatBufferBuilder flatBufferBuilder) {
                    h();
                    int b = flatBufferBuilder.b(m10300j());
                    flatBufferBuilder.c(1);
                    flatBufferBuilder.b(0, b);
                    i();
                    return flatBufferBuilder.d();
                }
            }

            /* compiled from: prompt_display_reason */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(ViewerModel.class, new Deserializer());
                }

                public Object m10306a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(ViewerParser.m10316a(jsonParser, flatBufferBuilder));
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

            /* compiled from: prompt_display_reason */
            public class Serializer extends JsonSerializer<ViewerModel> {
                public final void m10307a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    ViewerModel viewerModel = (ViewerModel) obj;
                    if (viewerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(viewerModel.m10309a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        viewerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    ZeroUpsellRecoParser.a(viewerModel.w_(), viewerModel.u_(), jsonGenerator, serializerProvider);
                }

                static {
                    FbSerializerProvider.a(ViewerModel.class, new Serializer());
                }
            }

            public ViewerModel() {
                super(1);
            }

            @Nullable
            private AccountUserModel m10308a() {
                this.f7151d = (AccountUserModel) super.a(this.f7151d, 0, AccountUserModel.class);
                return this.f7151d;
            }

            public final int jK_() {
                return -1732764110;
            }

            public final GraphQLVisitableModel m10310a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                GraphQLVisitableModel graphQLVisitableModel = null;
                h();
                if (m10308a() != null) {
                    AccountUserModel accountUserModel = (AccountUserModel) graphQLModelMutatingVisitor.b(m10308a());
                    if (m10308a() != accountUserModel) {
                        graphQLVisitableModel = (ViewerModel) ModelHelper.a(null, this);
                        graphQLVisitableModel.f7151d = accountUserModel;
                    }
                }
                i();
                return graphQLVisitableModel == null ? this : graphQLVisitableModel;
            }

            public final int m10309a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int a = ModelHelper.a(flatBufferBuilder, m10308a());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, a);
                i();
                return flatBufferBuilder.d();
            }
        }

        public NeverTranslateLanguageCoreMutationFieldsModel() {
            super(2);
        }

        @Nullable
        private String m10311a() {
            this.f7152d = super.a(this.f7152d, 0);
            return this.f7152d;
        }

        @Nullable
        private ViewerModel m10312j() {
            this.f7153e = (ViewerModel) super.a(this.f7153e, 1, ViewerModel.class);
            return this.f7153e;
        }

        public final int jK_() {
            return 235655411;
        }

        public final GraphQLVisitableModel m10314a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10312j() != null) {
                ViewerModel viewerModel = (ViewerModel) graphQLModelMutatingVisitor.b(m10312j());
                if (m10312j() != viewerModel) {
                    graphQLVisitableModel = (NeverTranslateLanguageCoreMutationFieldsModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7153e = viewerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10313a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m10311a());
            int a = ModelHelper.a(flatBufferBuilder, m10312j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

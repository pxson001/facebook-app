package com.facebook.offers.graphql;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.offers.graphql.OfferMutationsParsers.OfferClaimEnableNotificationsMutationParser;
import com.facebook.offers.graphql.OfferMutationsParsers.OfferClaimMarkAsUsedMutationParser;
import com.facebook.offers.graphql.OfferMutationsParsers.OfferClaimToWalletMutationParser;
import com.facebook.offers.graphql.OfferMutationsParsers.OfferViewClaimToWalletMutationParser;
import com.facebook.offers.graphql.OfferMutationsParsers.OfferViewRemoveFromWalletMutationParser;
import com.facebook.offers.graphql.OfferQueriesModels.OfferClaimDataModel;
import com.facebook.offers.graphql.OfferQueriesParsers.OfferClaimDataParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: current_profile_picture */
public class OfferMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -788786721)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_profile_picture */
    public final class OfferClaimEnableNotificationsMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private OfferClaimDataModel f16315d;

        /* compiled from: current_profile_picture */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OfferClaimEnableNotificationsMutationModel.class, new Deserializer());
            }

            public Object m19049a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = OfferClaimEnableNotificationsMutationParser.m19074a(jsonParser);
                Object offerClaimEnableNotificationsMutationModel = new OfferClaimEnableNotificationsMutationModel();
                ((BaseModel) offerClaimEnableNotificationsMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (offerClaimEnableNotificationsMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) offerClaimEnableNotificationsMutationModel).a();
                }
                return offerClaimEnableNotificationsMutationModel;
            }
        }

        /* compiled from: current_profile_picture */
        public class Serializer extends JsonSerializer<OfferClaimEnableNotificationsMutationModel> {
            public final void m19050a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                OfferClaimEnableNotificationsMutationModel offerClaimEnableNotificationsMutationModel = (OfferClaimEnableNotificationsMutationModel) obj;
                if (offerClaimEnableNotificationsMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(offerClaimEnableNotificationsMutationModel.m19051a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    offerClaimEnableNotificationsMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = offerClaimEnableNotificationsMutationModel.w_();
                int u_ = offerClaimEnableNotificationsMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("offer_claim");
                    OfferClaimDataParser.m19401a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(OfferClaimEnableNotificationsMutationModel.class, new Serializer());
            }
        }

        public OfferClaimEnableNotificationsMutationModel() {
            super(1);
        }

        @Nullable
        public final OfferClaimDataModel m19053a() {
            this.f16315d = (OfferClaimDataModel) super.a(this.f16315d, 0, OfferClaimDataModel.class);
            return this.f16315d;
        }

        public final int jK_() {
            return 915136168;
        }

        public final GraphQLVisitableModel m19052a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19053a() != null) {
                OfferClaimDataModel offerClaimDataModel = (OfferClaimDataModel) graphQLModelMutatingVisitor.b(m19053a());
                if (m19053a() != offerClaimDataModel) {
                    graphQLVisitableModel = (OfferClaimEnableNotificationsMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16315d = offerClaimDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19051a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19053a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -788786721)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_profile_picture */
    public final class OfferClaimMarkAsUsedMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private OfferClaimDataModel f16316d;

        /* compiled from: current_profile_picture */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OfferClaimMarkAsUsedMutationModel.class, new Deserializer());
            }

            public Object m19054a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = OfferClaimMarkAsUsedMutationParser.m19075a(jsonParser);
                Object offerClaimMarkAsUsedMutationModel = new OfferClaimMarkAsUsedMutationModel();
                ((BaseModel) offerClaimMarkAsUsedMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (offerClaimMarkAsUsedMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) offerClaimMarkAsUsedMutationModel).a();
                }
                return offerClaimMarkAsUsedMutationModel;
            }
        }

        /* compiled from: current_profile_picture */
        public class Serializer extends JsonSerializer<OfferClaimMarkAsUsedMutationModel> {
            public final void m19055a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                OfferClaimMarkAsUsedMutationModel offerClaimMarkAsUsedMutationModel = (OfferClaimMarkAsUsedMutationModel) obj;
                if (offerClaimMarkAsUsedMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(offerClaimMarkAsUsedMutationModel.m19056a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    offerClaimMarkAsUsedMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = offerClaimMarkAsUsedMutationModel.w_();
                int u_ = offerClaimMarkAsUsedMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("offer_claim");
                    OfferClaimDataParser.m19401a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(OfferClaimMarkAsUsedMutationModel.class, new Serializer());
            }
        }

        public OfferClaimMarkAsUsedMutationModel() {
            super(1);
        }

        @Nullable
        public final OfferClaimDataModel m19058a() {
            this.f16316d = (OfferClaimDataModel) super.a(this.f16316d, 0, OfferClaimDataModel.class);
            return this.f16316d;
        }

        public final int jK_() {
            return 1875866289;
        }

        public final GraphQLVisitableModel m19057a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19058a() != null) {
                OfferClaimDataModel offerClaimDataModel = (OfferClaimDataModel) graphQLModelMutatingVisitor.b(m19058a());
                if (m19058a() != offerClaimDataModel) {
                    graphQLVisitableModel = (OfferClaimMarkAsUsedMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16316d = offerClaimDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19056a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19058a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -788786721)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_profile_picture */
    public final class OfferClaimToWalletMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private OfferClaimDataModel f16317d;

        /* compiled from: current_profile_picture */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OfferClaimToWalletMutationModel.class, new Deserializer());
            }

            public Object m19059a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = OfferClaimToWalletMutationParser.m19076a(jsonParser);
                Object offerClaimToWalletMutationModel = new OfferClaimToWalletMutationModel();
                ((BaseModel) offerClaimToWalletMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (offerClaimToWalletMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) offerClaimToWalletMutationModel).a();
                }
                return offerClaimToWalletMutationModel;
            }
        }

        /* compiled from: current_profile_picture */
        public class Serializer extends JsonSerializer<OfferClaimToWalletMutationModel> {
            public final void m19060a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                OfferClaimToWalletMutationModel offerClaimToWalletMutationModel = (OfferClaimToWalletMutationModel) obj;
                if (offerClaimToWalletMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(offerClaimToWalletMutationModel.m19061a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    offerClaimToWalletMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = offerClaimToWalletMutationModel.w_();
                int u_ = offerClaimToWalletMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("offer_claim");
                    OfferClaimDataParser.m19401a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(OfferClaimToWalletMutationModel.class, new Serializer());
            }
        }

        public OfferClaimToWalletMutationModel() {
            super(1);
        }

        @Nullable
        public final OfferClaimDataModel m19063a() {
            this.f16317d = (OfferClaimDataModel) super.a(this.f16317d, 0, OfferClaimDataModel.class);
            return this.f16317d;
        }

        public final int jK_() {
            return -1341046375;
        }

        public final GraphQLVisitableModel m19062a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19063a() != null) {
                OfferClaimDataModel offerClaimDataModel = (OfferClaimDataModel) graphQLModelMutatingVisitor.b(m19063a());
                if (m19063a() != offerClaimDataModel) {
                    graphQLVisitableModel = (OfferClaimToWalletMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16317d = offerClaimDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19061a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19063a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -788786721)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_profile_picture */
    public final class OfferViewClaimToWalletMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private OfferClaimDataModel f16318d;

        /* compiled from: current_profile_picture */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OfferViewClaimToWalletMutationModel.class, new Deserializer());
            }

            public Object m19064a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = OfferViewClaimToWalletMutationParser.m19077a(jsonParser);
                Object offerViewClaimToWalletMutationModel = new OfferViewClaimToWalletMutationModel();
                ((BaseModel) offerViewClaimToWalletMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (offerViewClaimToWalletMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) offerViewClaimToWalletMutationModel).a();
                }
                return offerViewClaimToWalletMutationModel;
            }
        }

        /* compiled from: current_profile_picture */
        public class Serializer extends JsonSerializer<OfferViewClaimToWalletMutationModel> {
            public final void m19065a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                OfferViewClaimToWalletMutationModel offerViewClaimToWalletMutationModel = (OfferViewClaimToWalletMutationModel) obj;
                if (offerViewClaimToWalletMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(offerViewClaimToWalletMutationModel.m19066a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    offerViewClaimToWalletMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = offerViewClaimToWalletMutationModel.w_();
                int u_ = offerViewClaimToWalletMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("offer_claim");
                    OfferClaimDataParser.m19401a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(OfferViewClaimToWalletMutationModel.class, new Serializer());
            }
        }

        public OfferViewClaimToWalletMutationModel() {
            super(1);
        }

        @Nullable
        public final OfferClaimDataModel m19068a() {
            this.f16318d = (OfferClaimDataModel) super.a(this.f16318d, 0, OfferClaimDataModel.class);
            return this.f16318d;
        }

        public final int jK_() {
            return -390772514;
        }

        public final GraphQLVisitableModel m19067a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m19068a() != null) {
                OfferClaimDataModel offerClaimDataModel = (OfferClaimDataModel) graphQLModelMutatingVisitor.b(m19068a());
                if (m19068a() != offerClaimDataModel) {
                    graphQLVisitableModel = (OfferViewClaimToWalletMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f16318d = offerClaimDataModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m19066a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m19068a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -694681681)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: current_profile_picture */
    public final class OfferViewRemoveFromWalletMutationModel extends BaseModel implements GraphQLVisitableModel {
        private boolean f16319d;

        /* compiled from: current_profile_picture */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(OfferViewRemoveFromWalletMutationModel.class, new Deserializer());
            }

            public Object m19069a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = OfferViewRemoveFromWalletMutationParser.m19078a(jsonParser);
                Object offerViewRemoveFromWalletMutationModel = new OfferViewRemoveFromWalletMutationModel();
                ((BaseModel) offerViewRemoveFromWalletMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (offerViewRemoveFromWalletMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) offerViewRemoveFromWalletMutationModel).a();
                }
                return offerViewRemoveFromWalletMutationModel;
            }
        }

        /* compiled from: current_profile_picture */
        public class Serializer extends JsonSerializer<OfferViewRemoveFromWalletMutationModel> {
            public final void m19070a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                OfferViewRemoveFromWalletMutationModel offerViewRemoveFromWalletMutationModel = (OfferViewRemoveFromWalletMutationModel) obj;
                if (offerViewRemoveFromWalletMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(offerViewRemoveFromWalletMutationModel.m19071a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    offerViewRemoveFromWalletMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = offerViewRemoveFromWalletMutationModel.w_();
                int u_ = offerViewRemoveFromWalletMutationModel.u_();
                jsonGenerator.f();
                boolean a = mutableFlatBuffer.a(u_, 0);
                if (a) {
                    jsonGenerator.a("success");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(OfferViewRemoveFromWalletMutationModel.class, new Serializer());
            }
        }

        public OfferViewRemoveFromWalletMutationModel() {
            super(1);
        }

        public final int jK_() {
            return 1189766117;
        }

        public final GraphQLVisitableModel m19072a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m19071a(FlatBufferBuilder flatBufferBuilder) {
            h();
            flatBufferBuilder.c(1);
            flatBufferBuilder.a(0, this.f16319d);
            i();
            return flatBufferBuilder.d();
        }

        public final void m19073a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f16319d = mutableFlatBuffer.a(i, 0);
        }
    }
}

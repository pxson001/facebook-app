package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.AdInterfacesAdPreviewQueryParsers.AdInterfacesAdPreviewFeedUnitQueryParser;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.flatbuffers.MutableFlattenable;
import com.facebook.graphql.deserializers.FeedUnitDeserializerResolver;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.VirtualFlattenableResolverImpl;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.SerializerHelpers;
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

/* compiled from: [IDLE] */
public class AdInterfacesAdPreviewQueryModels {

    @FragmentModelWithBridge
    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -10628989)
    @JsonSerialize(using = Serializer.class)
    /* compiled from: [IDLE] */
    public final class AdInterfacesAdPreviewFeedUnitQueryModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f21914d;
        @Nullable
        private FeedUnit f21915e;
        @Nullable
        private String f21916f;

        /* compiled from: [IDLE] */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AdInterfacesAdPreviewFeedUnitQueryModel.class, new Deserializer());
            }

            public Object m22989a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AdInterfacesAdPreviewFeedUnitQueryParser.m22999a(jsonParser);
                Object adInterfacesAdPreviewFeedUnitQueryModel = new AdInterfacesAdPreviewFeedUnitQueryModel();
                ((BaseModel) adInterfacesAdPreviewFeedUnitQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (adInterfacesAdPreviewFeedUnitQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) adInterfacesAdPreviewFeedUnitQueryModel).a();
                }
                return adInterfacesAdPreviewFeedUnitQueryModel;
            }
        }

        /* compiled from: [IDLE] */
        public class Serializer extends JsonSerializer<AdInterfacesAdPreviewFeedUnitQueryModel> {
            public final void m22990a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AdInterfacesAdPreviewFeedUnitQueryModel adInterfacesAdPreviewFeedUnitQueryModel = (AdInterfacesAdPreviewFeedUnitQueryModel) obj;
                if (adInterfacesAdPreviewFeedUnitQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(adInterfacesAdPreviewFeedUnitQueryModel.m22993a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    adInterfacesAdPreviewFeedUnitQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = adInterfacesAdPreviewFeedUnitQueryModel.w_();
                int u_ = adInterfacesAdPreviewFeedUnitQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                int g = mutableFlatBuffer.g(u_, 1);
                if (g != 0) {
                    jsonGenerator.a("feed_unit_preview");
                    FeedUnitDeserializerResolver.a(mutableFlatBuffer, g, 1, jsonGenerator, serializerProvider);
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AdInterfacesAdPreviewFeedUnitQueryModel.class, new Serializer());
            }
        }

        public AdInterfacesAdPreviewFeedUnitQueryModel() {
            super(3);
        }

        public final void m22996a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m22997a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m22991k() {
            if (this.b != null && this.f21914d == null) {
                this.f21914d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f21914d;
        }

        @Nullable
        public final FeedUnit m22998j() {
            this.f21915e = (FeedUnit) super.a(this.f21915e, 1, VirtualFlattenableResolverImpl.a);
            return this.f21915e;
        }

        @Nullable
        private String m22992l() {
            this.f21916f = super.a(this.f21916f, 2);
            return this.f21916f;
        }

        @Nullable
        public final String m22995a() {
            return m22992l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m22994a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m22998j() != null) {
                FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.b(m22998j());
                if (m22998j() != feedUnit) {
                    graphQLVisitableModel = (AdInterfacesAdPreviewFeedUnitQueryModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f21915e = feedUnit;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m22993a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m22991k());
            int a2 = ModelHelper.a(flatBufferBuilder, (MutableFlattenable) m22998j());
            int b = flatBufferBuilder.b(m22992l());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.b(2, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}

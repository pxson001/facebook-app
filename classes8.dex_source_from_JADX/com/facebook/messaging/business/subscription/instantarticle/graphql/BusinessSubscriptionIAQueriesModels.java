package com.facebook.messaging.business.subscription.instantarticle.graphql;

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
import com.facebook.graphql.modelutil.SerializerHelpers;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.messaging.business.subscription.instantarticle.graphql.BusinessSubscriptionIAQueriesParsers.BusinessSubscriptionMessengerContentSubscribedQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: trackId */
public class BusinessSubscriptionIAQueriesModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1728721644)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: trackId */
    public final class BusinessSubscriptionMessengerContentSubscribedQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f1463d;
        private boolean f1464e;

        /* compiled from: trackId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(BusinessSubscriptionMessengerContentSubscribedQueryModel.class, new Deserializer());
            }

            public Object m1655a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = BusinessSubscriptionMessengerContentSubscribedQueryParser.m1664a(jsonParser);
                Object businessSubscriptionMessengerContentSubscribedQueryModel = new BusinessSubscriptionMessengerContentSubscribedQueryModel();
                ((BaseModel) businessSubscriptionMessengerContentSubscribedQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (businessSubscriptionMessengerContentSubscribedQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) businessSubscriptionMessengerContentSubscribedQueryModel).a();
                }
                return businessSubscriptionMessengerContentSubscribedQueryModel;
            }
        }

        /* compiled from: trackId */
        public class Serializer extends JsonSerializer<BusinessSubscriptionMessengerContentSubscribedQueryModel> {
            public final void m1656a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                BusinessSubscriptionMessengerContentSubscribedQueryModel businessSubscriptionMessengerContentSubscribedQueryModel = (BusinessSubscriptionMessengerContentSubscribedQueryModel) obj;
                if (businessSubscriptionMessengerContentSubscribedQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(businessSubscriptionMessengerContentSubscribedQueryModel.m1658a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    businessSubscriptionMessengerContentSubscribedQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = businessSubscriptionMessengerContentSubscribedQueryModel.w_();
                int u_ = businessSubscriptionMessengerContentSubscribedQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                boolean a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("is_viewer_subscribed_to_messenger_content");
                    jsonGenerator.a(a);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(BusinessSubscriptionMessengerContentSubscribedQueryModel.class, new Serializer());
            }
        }

        public BusinessSubscriptionMessengerContentSubscribedQueryModel() {
            super(2);
        }

        public final void m1661a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m1662a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m1657j() {
            if (this.b != null && this.f1463d == null) {
                this.f1463d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f1463d;
        }

        public final boolean m1663a() {
            a(0, 1);
            return this.f1464e;
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m1659a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m1658a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m1657j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.a(1, this.f1464e);
            i();
            return flatBufferBuilder.d();
        }

        public final void m1660a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f1464e = mutableFlatBuffer.a(i, 1);
        }
    }
}

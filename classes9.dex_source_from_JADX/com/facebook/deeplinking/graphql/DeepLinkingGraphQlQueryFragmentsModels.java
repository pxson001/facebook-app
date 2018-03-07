package com.facebook.deeplinking.graphql;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.deeplinking.graphql.DeepLinkingGraphQlQueryFragmentsParsers.GetURLInfoParser;
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

/* compiled from: photo_edit_dialog_fragment_tag */
public class DeepLinkingGraphQlQueryFragmentsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1787905591)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: photo_edit_dialog_fragment_tag */
    public final class GetURLInfoModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f6611d;
        @Nullable
        private String f6612e;

        /* compiled from: photo_edit_dialog_fragment_tag */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(GetURLInfoModel.class, new Deserializer());
            }

            public Object m6921a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = GetURLInfoParser.m6930a(jsonParser);
                Object getURLInfoModel = new GetURLInfoModel();
                ((BaseModel) getURLInfoModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (getURLInfoModel instanceof Postprocessable) {
                    return ((Postprocessable) getURLInfoModel).a();
                }
                return getURLInfoModel;
            }
        }

        /* compiled from: photo_edit_dialog_fragment_tag */
        public class Serializer extends JsonSerializer<GetURLInfoModel> {
            public final void m6922a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                GetURLInfoModel getURLInfoModel = (GetURLInfoModel) obj;
                if (getURLInfoModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(getURLInfoModel.m6923a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    getURLInfoModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = getURLInfoModel.w_();
                int u_ = getURLInfoModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(GetURLInfoModel.class, new Serializer());
            }
        }

        public GetURLInfoModel() {
            super(2);
        }

        public final void m6926a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m6927a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLObjectType m6928j() {
            if (this.b != null && this.f6611d == null) {
                this.f6611d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f6611d;
        }

        @Nullable
        public final String m6929k() {
            this.f6612e = super.a(this.f6612e, 1);
            return this.f6612e;
        }

        @Nullable
        public final String m6925a() {
            return m6929k();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m6924a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m6923a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m6928j());
            int b = flatBufferBuilder.b(m6929k());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}

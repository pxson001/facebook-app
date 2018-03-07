package com.facebook.api.graphql.commenttranslation;

import com.facebook.api.graphql.commenttranslation.FetchCommentTranslationGraphQLParsers.TranslatedCommentBodyParser;
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
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLParsers.DefaultTextWithEntitiesLongFieldsParser;
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

/* compiled from: prompt_title */
public class FetchCommentTranslationGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -552354434)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: prompt_title */
    public final class TranslatedCommentBodyModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLObjectType f7147d;
        @Nullable
        private String f7148e;
        @Nullable
        private DefaultTextWithEntitiesLongFieldsModel f7149f;

        /* compiled from: prompt_title */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(TranslatedCommentBodyModel.class, new Deserializer());
            }

            public Object m10281a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = TranslatedCommentBodyParser.m10291a(jsonParser);
                Object translatedCommentBodyModel = new TranslatedCommentBodyModel();
                ((BaseModel) translatedCommentBodyModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (translatedCommentBodyModel instanceof Postprocessable) {
                    return ((Postprocessable) translatedCommentBodyModel).a();
                }
                return translatedCommentBodyModel;
            }
        }

        /* compiled from: prompt_title */
        public class Serializer extends JsonSerializer<TranslatedCommentBodyModel> {
            public final void m10282a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                TranslatedCommentBodyModel translatedCommentBodyModel = (TranslatedCommentBodyModel) obj;
                if (translatedCommentBodyModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(translatedCommentBodyModel.m10285a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    translatedCommentBodyModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = translatedCommentBodyModel.w_();
                int u_ = translatedCommentBodyModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("__type__");
                    SerializerHelpers.b(mutableFlatBuffer, u_, 0, jsonGenerator);
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                int g = mutableFlatBuffer.g(u_, 2);
                if (g != 0) {
                    jsonGenerator.a("translated_body_for_viewer");
                    DefaultTextWithEntitiesLongFieldsParser.b(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(TranslatedCommentBodyModel.class, new Serializer());
            }
        }

        public TranslatedCommentBodyModel() {
            super(3);
        }

        public final void m10288a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m10289a(String str, Object obj, boolean z) {
        }

        @Nullable
        private GraphQLObjectType m10283k() {
            if (this.b != null && this.f7147d == null) {
                this.f7147d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f7147d;
        }

        @Nullable
        private String m10284l() {
            this.f7148e = super.a(this.f7148e, 1);
            return this.f7148e;
        }

        @Nullable
        public final DefaultTextWithEntitiesLongFieldsModel m10290j() {
            this.f7149f = (DefaultTextWithEntitiesLongFieldsModel) super.a(this.f7149f, 2, DefaultTextWithEntitiesLongFieldsModel.class);
            return this.f7149f;
        }

        @Nullable
        public final String m10287a() {
            return m10284l();
        }

        public final int jK_() {
            return 2433570;
        }

        public final GraphQLVisitableModel m10286a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10290j() != null) {
                DefaultTextWithEntitiesLongFieldsModel defaultTextWithEntitiesLongFieldsModel = (DefaultTextWithEntitiesLongFieldsModel) graphQLModelMutatingVisitor.b(m10290j());
                if (m10290j() != defaultTextWithEntitiesLongFieldsModel) {
                    graphQLVisitableModel = (TranslatedCommentBodyModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f7149f = defaultTextWithEntitiesLongFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10285a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10283k());
            int b = flatBufferBuilder.b(m10284l());
            int a2 = ModelHelper.a(flatBufferBuilder, m10290j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            flatBufferBuilder.b(2, a2);
            i();
            return flatBufferBuilder.d();
        }
    }
}

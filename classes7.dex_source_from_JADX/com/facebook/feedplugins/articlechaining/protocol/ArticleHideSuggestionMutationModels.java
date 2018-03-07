package com.facebook.feedplugins.articlechaining.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.feedplugins.articlechaining.protocol.ArticleHideSuggestionMutationParsers.ArticleHideSuggestionMutationParser;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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

/* compiled from: TOTAL_ASSETS_WITHIN_BURSTS_COUNT */
public class ArticleHideSuggestionMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -183407208)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TOTAL_ASSETS_WITHIN_BURSTS_COUNT */
    public final class ArticleHideSuggestionMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f22537d;
        @Nullable
        private String f22538e;

        /* compiled from: TOTAL_ASSETS_WITHIN_BURSTS_COUNT */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ArticleHideSuggestionMutationModel.class, new Deserializer());
            }

            public Object m25244a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = ArticleHideSuggestionMutationParser.m25250a(jsonParser);
                Object articleHideSuggestionMutationModel = new ArticleHideSuggestionMutationModel();
                ((BaseModel) articleHideSuggestionMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (articleHideSuggestionMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) articleHideSuggestionMutationModel).a();
                }
                return articleHideSuggestionMutationModel;
            }
        }

        /* compiled from: TOTAL_ASSETS_WITHIN_BURSTS_COUNT */
        public class Serializer extends JsonSerializer<ArticleHideSuggestionMutationModel> {
            public final void m25245a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                ArticleHideSuggestionMutationModel articleHideSuggestionMutationModel = (ArticleHideSuggestionMutationModel) obj;
                if (articleHideSuggestionMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(articleHideSuggestionMutationModel.m25248a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    articleHideSuggestionMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = articleHideSuggestionMutationModel.w_();
                int u_ = articleHideSuggestionMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("client_subscription_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(ArticleHideSuggestionMutationModel.class, new Serializer());
            }
        }

        public ArticleHideSuggestionMutationModel() {
            super(2);
        }

        @Nullable
        private String m25246a() {
            this.f22537d = super.a(this.f22537d, 0);
            return this.f22537d;
        }

        @Nullable
        private String m25247j() {
            this.f22538e = super.a(this.f22538e, 1);
            return this.f22538e;
        }

        public final int jK_() {
            return 1553466129;
        }

        public final GraphQLVisitableModel m25249a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m25248a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m25246a());
            int b2 = flatBufferBuilder.b(m25247j());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            i();
            return flatBufferBuilder.d();
        }
    }
}

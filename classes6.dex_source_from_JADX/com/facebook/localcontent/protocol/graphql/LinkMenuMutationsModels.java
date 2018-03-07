package com.facebook.localcontent.protocol.graphql;

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
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.localcontent.protocol.graphql.LinkMenuMutationsParsers.PageLinkMenuCreateMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: landscape_position */
public class LinkMenuMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: landscape_position */
    public final class PageLinkMenuCreateMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f11780d;

        /* compiled from: landscape_position */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageLinkMenuCreateMutationModel.class, new Deserializer());
            }

            public Object m18574a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageLinkMenuCreateMutationParser.m18579a(jsonParser);
                Object pageLinkMenuCreateMutationModel = new PageLinkMenuCreateMutationModel();
                ((BaseModel) pageLinkMenuCreateMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageLinkMenuCreateMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) pageLinkMenuCreateMutationModel).a();
                }
                return pageLinkMenuCreateMutationModel;
            }
        }

        /* compiled from: landscape_position */
        public class Serializer extends JsonSerializer<PageLinkMenuCreateMutationModel> {
            public final void m18575a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageLinkMenuCreateMutationModel pageLinkMenuCreateMutationModel = (PageLinkMenuCreateMutationModel) obj;
                if (pageLinkMenuCreateMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageLinkMenuCreateMutationModel.m18577a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageLinkMenuCreateMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageLinkMenuCreateMutationModel.w_();
                int u_ = pageLinkMenuCreateMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageLinkMenuCreateMutationModel.class, new Serializer());
            }
        }

        public PageLinkMenuCreateMutationModel() {
            super(1);
        }

        @Nullable
        private String m18576a() {
            this.f11780d = super.a(this.f11780d, 0);
            return this.f11780d;
        }

        public final int jK_() {
            return -313995767;
        }

        public final GraphQLVisitableModel m18578a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m18577a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m18576a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}

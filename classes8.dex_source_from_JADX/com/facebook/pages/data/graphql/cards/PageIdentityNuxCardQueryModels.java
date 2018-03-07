package com.facebook.pages.data.graphql.cards;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLReactionRequestedUnit;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.pages.data.graphql.cards.PageIdentityNuxCardQueryParsers.PageIdentityNuxCardQueryParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: contentId */
public class PageIdentityNuxCardQueryModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 483496396)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: contentId */
    public final class PageIdentityNuxCardQueryModel extends BaseModel implements GraphQLVisitableConsistentModel {
        @Nullable
        private GraphQLReactionRequestedUnit f17019d;

        /* compiled from: contentId */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageIdentityNuxCardQueryModel.class, new Deserializer());
            }

            public Object m20574a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageIdentityNuxCardQueryParser.m20581a(jsonParser);
                Object pageIdentityNuxCardQueryModel = new PageIdentityNuxCardQueryModel();
                ((BaseModel) pageIdentityNuxCardQueryModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageIdentityNuxCardQueryModel instanceof Postprocessable) {
                    return ((Postprocessable) pageIdentityNuxCardQueryModel).a();
                }
                return pageIdentityNuxCardQueryModel;
            }
        }

        /* compiled from: contentId */
        public class Serializer extends JsonSerializer<PageIdentityNuxCardQueryModel> {
            public final void m20575a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageIdentityNuxCardQueryModel pageIdentityNuxCardQueryModel = (PageIdentityNuxCardQueryModel) obj;
                if (pageIdentityNuxCardQueryModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageIdentityNuxCardQueryModel.m20576a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageIdentityNuxCardQueryModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageIdentityNuxCardQueryModel.w_();
                int u_ = pageIdentityNuxCardQueryModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("page_nux");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageIdentityNuxCardQueryModel.class, new Serializer());
            }
        }

        public PageIdentityNuxCardQueryModel() {
            super(1);
        }

        public final void m20579a(String str, ConsistencyTuple consistencyTuple) {
            consistencyTuple.a();
        }

        public final void m20580a(String str, Object obj, boolean z) {
        }

        @Nullable
        public final GraphQLReactionRequestedUnit m20577a() {
            this.f17019d = (GraphQLReactionRequestedUnit) super.b(this.f17019d, 0, GraphQLReactionRequestedUnit.class, GraphQLReactionRequestedUnit.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f17019d;
        }

        public final int jK_() {
            return 2479791;
        }

        public final GraphQLVisitableModel m20578a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m20576a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = flatBufferBuilder.a(m20577a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

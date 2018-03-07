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
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryModels.MenuManagementInfoFieldsModel;
import com.facebook.localcontent.protocol.graphql.MenuManagementQueryParsers.MenuManagementInfoFieldsParser;
import com.facebook.localcontent.protocol.graphql.PageMenuVisibilityMutationParsers.PageMenuVisibilityMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: keywords_topic_trending */
public class PageMenuVisibilityMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2102699566)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: keywords_topic_trending */
    public final class PageMenuVisibilityMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private MenuManagementInfoFieldsModel f11794d;

        /* compiled from: keywords_topic_trending */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(PageMenuVisibilityMutationModel.class, new Deserializer());
            }

            public Object m18640a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = PageMenuVisibilityMutationParser.m18645a(jsonParser);
                Object pageMenuVisibilityMutationModel = new PageMenuVisibilityMutationModel();
                ((BaseModel) pageMenuVisibilityMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (pageMenuVisibilityMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) pageMenuVisibilityMutationModel).a();
                }
                return pageMenuVisibilityMutationModel;
            }
        }

        /* compiled from: keywords_topic_trending */
        public class Serializer extends JsonSerializer<PageMenuVisibilityMutationModel> {
            public final void m18641a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                PageMenuVisibilityMutationModel pageMenuVisibilityMutationModel = (PageMenuVisibilityMutationModel) obj;
                if (pageMenuVisibilityMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(pageMenuVisibilityMutationModel.m18643a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    pageMenuVisibilityMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = pageMenuVisibilityMutationModel.w_();
                int u_ = pageMenuVisibilityMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("page");
                    MenuManagementInfoFieldsParser.m18638a(mutableFlatBuffer, g, jsonGenerator, serializerProvider);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(PageMenuVisibilityMutationModel.class, new Serializer());
            }
        }

        public PageMenuVisibilityMutationModel() {
            super(1);
        }

        @Nullable
        private MenuManagementInfoFieldsModel m18642a() {
            this.f11794d = (MenuManagementInfoFieldsModel) super.a(this.f11794d, 0, MenuManagementInfoFieldsModel.class);
            return this.f11794d;
        }

        public final int jK_() {
            return -1786659805;
        }

        public final GraphQLVisitableModel m18644a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m18642a() != null) {
                MenuManagementInfoFieldsModel menuManagementInfoFieldsModel = (MenuManagementInfoFieldsModel) graphQLModelMutatingVisitor.b(m18642a());
                if (m18642a() != menuManagementInfoFieldsModel) {
                    graphQLVisitableModel = (PageMenuVisibilityMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f11794d = menuManagementInfoFieldsModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m18643a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m18642a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

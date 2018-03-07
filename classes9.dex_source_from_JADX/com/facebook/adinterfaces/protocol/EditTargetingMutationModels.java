package com.facebook.adinterfaces.protocol;

import com.facebook.adinterfaces.protocol.EditTargetingMutationParsers.FBPagePostBoostEditTargetingParser;
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
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: WebrtcMessageServerExtension */
public class EditTargetingMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: WebrtcMessageServerExtension */
    public final class FBPagePostBoostEditTargetingModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f22330d;

        /* compiled from: WebrtcMessageServerExtension */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FBPagePostBoostEditTargetingModel.class, new Deserializer());
            }

            public Object m24074a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FBPagePostBoostEditTargetingParser.m24079a(jsonParser);
                Object fBPagePostBoostEditTargetingModel = new FBPagePostBoostEditTargetingModel();
                ((BaseModel) fBPagePostBoostEditTargetingModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fBPagePostBoostEditTargetingModel instanceof Postprocessable) {
                    return ((Postprocessable) fBPagePostBoostEditTargetingModel).a();
                }
                return fBPagePostBoostEditTargetingModel;
            }
        }

        /* compiled from: WebrtcMessageServerExtension */
        public class Serializer extends JsonSerializer<FBPagePostBoostEditTargetingModel> {
            public final void m24075a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FBPagePostBoostEditTargetingModel fBPagePostBoostEditTargetingModel = (FBPagePostBoostEditTargetingModel) obj;
                if (fBPagePostBoostEditTargetingModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fBPagePostBoostEditTargetingModel.m24077a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fBPagePostBoostEditTargetingModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fBPagePostBoostEditTargetingModel.w_();
                int u_ = fBPagePostBoostEditTargetingModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FBPagePostBoostEditTargetingModel.class, new Serializer());
            }
        }

        public FBPagePostBoostEditTargetingModel() {
            super(1);
        }

        @Nullable
        private String m24076a() {
            this.f22330d = super.a(this.f22330d, 0);
            return this.f22330d;
        }

        public final int jK_() {
            return -1645952841;
        }

        public final GraphQLVisitableModel m24078a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m24077a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m24076a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}

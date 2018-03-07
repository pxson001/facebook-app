package com.facebook.groups.photos.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLGroupPostStatus;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.groups.photos.protocol.FetchGroupPhotosHeaderParsers.FetchGroupPhotosHeaderParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: TOR */
public class FetchGroupPhotosHeaderModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 198660977)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: TOR */
    public final class FetchGroupPhotosHeaderModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableConsistentModel {
        @Nullable
        private String f23082d;
        @Nullable
        private String f23083e;
        @Nullable
        private GraphQLGroupPostStatus f23084f;

        /* compiled from: TOR */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(FetchGroupPhotosHeaderModel.class, new Deserializer());
            }

            public Object m24375a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = FetchGroupPhotosHeaderParser.m24386a(jsonParser);
                Object fetchGroupPhotosHeaderModel = new FetchGroupPhotosHeaderModel();
                ((BaseModel) fetchGroupPhotosHeaderModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (fetchGroupPhotosHeaderModel instanceof Postprocessable) {
                    return ((Postprocessable) fetchGroupPhotosHeaderModel).a();
                }
                return fetchGroupPhotosHeaderModel;
            }
        }

        /* compiled from: TOR */
        public class Serializer extends JsonSerializer<FetchGroupPhotosHeaderModel> {
            public final void m24376a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                FetchGroupPhotosHeaderModel fetchGroupPhotosHeaderModel = (FetchGroupPhotosHeaderModel) obj;
                if (fetchGroupPhotosHeaderModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(fetchGroupPhotosHeaderModel.m24380a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    fetchGroupPhotosHeaderModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = fetchGroupPhotosHeaderModel.w_();
                int u_ = fetchGroupPhotosHeaderModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                if (mutableFlatBuffer.g(u_, 1) != 0) {
                    jsonGenerator.a("name");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 1));
                }
                if (mutableFlatBuffer.g(u_, 2) != 0) {
                    jsonGenerator.a("viewer_post_status");
                    jsonGenerator.b(mutableFlatBuffer.b(u_, 2));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(FetchGroupPhotosHeaderModel.class, new Serializer());
            }
        }

        public FetchGroupPhotosHeaderModel() {
            super(3);
        }

        public final void m24383a(String str, ConsistencyTuple consistencyTuple) {
            if ("name".equals(str)) {
                consistencyTuple.a = m24379l();
                consistencyTuple.b = u_();
                consistencyTuple.c = 1;
                return;
            }
            consistencyTuple.a();
        }

        public final void m24384a(String str, Object obj, boolean z) {
            if ("name".equals(str)) {
                m24377a((String) obj);
            }
        }

        @Nullable
        private String m24378k() {
            this.f23082d = super.a(this.f23082d, 0);
            return this.f23082d;
        }

        @Nullable
        private String m24379l() {
            this.f23083e = super.a(this.f23083e, 1);
            return this.f23083e;
        }

        private void m24377a(@Nullable String str) {
            this.f23083e = str;
            if (this.b != null && this.b.d) {
                this.b.a(this.c, 1, str);
            }
        }

        @Nullable
        public final GraphQLGroupPostStatus m24385j() {
            this.f23084f = (GraphQLGroupPostStatus) super.b(this.f23084f, 2, GraphQLGroupPostStatus.class, GraphQLGroupPostStatus.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
            return this.f23084f;
        }

        @Nullable
        public final String m24382a() {
            return m24378k();
        }

        public final int jK_() {
            return 69076575;
        }

        public final GraphQLVisitableModel m24381a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m24380a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m24378k());
            int b2 = flatBufferBuilder.b(m24379l());
            int a = flatBufferBuilder.a(m24385j());
            flatBufferBuilder.c(3);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.b(1, b2);
            flatBufferBuilder.b(2, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

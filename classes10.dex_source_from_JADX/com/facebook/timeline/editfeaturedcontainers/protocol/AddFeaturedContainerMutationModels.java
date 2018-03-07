package com.facebook.timeline.editfeaturedcontainers.protocol;

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
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.timeline.editfeaturedcontainers.protocol.AddFeaturedContainerMutationParsers.AddFeaturedContainerMutationParser;
import com.facebook.timeline.editfeaturedcontainers.protocol.AddFeaturedContainerMutationParsers.AddFeaturedContainerMutationParser.FeaturedContainerParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: go_launcher */
public class AddFeaturedContainerMutationModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1792209989)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: go_launcher */
    public final class AddFeaturedContainerMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private FeaturedContainerModel f10773d;

        /* compiled from: go_launcher */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AddFeaturedContainerMutationModel.class, new Deserializer());
            }

            public Object m10792a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = AddFeaturedContainerMutationParser.m10805a(jsonParser);
                Object addFeaturedContainerMutationModel = new AddFeaturedContainerMutationModel();
                ((BaseModel) addFeaturedContainerMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (addFeaturedContainerMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) addFeaturedContainerMutationModel).a();
                }
                return addFeaturedContainerMutationModel;
            }
        }

        @JsonDeserialize(using = Deserializer.class)
        @ModelWithFlatBufferFormatHash(a = 1801334754)
        @JsonSerialize(using = Serializer.class)
        @FragmentModelWithoutBridge
        /* compiled from: go_launcher */
        public final class FeaturedContainerModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
            @Nullable
            private String f10772d;

            /* compiled from: go_launcher */
            public class Deserializer extends FbJsonDeserializer {
                static {
                    GlobalAutoGenDeserializerCache.a(FeaturedContainerModel.class, new Deserializer());
                }

                public Object m10793a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(FeaturedContainerParser.m10803a(jsonParser, flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    mutableFlatBuffer.a(4, Boolean.valueOf(true));
                    MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                    Object featuredContainerModel = new FeaturedContainerModel();
                    ((BaseModel) featuredContainerModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                    if (featuredContainerModel instanceof Postprocessable) {
                        return ((Postprocessable) featuredContainerModel).a();
                    }
                    return featuredContainerModel;
                }
            }

            /* compiled from: go_launcher */
            public class Serializer extends JsonSerializer<FeaturedContainerModel> {
                public final void m10794a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                    FeaturedContainerModel featuredContainerModel = (FeaturedContainerModel) obj;
                    if (featuredContainerModel.w_() == null) {
                        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                        flatBufferBuilder.d(featuredContainerModel.m10796a(flatBufferBuilder));
                        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                        wrap.position(0);
                        MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                        featuredContainerModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                    }
                    FeaturedContainerParser.m10804a(featuredContainerModel.w_(), featuredContainerModel.u_(), jsonGenerator);
                }

                static {
                    FbSerializerProvider.a(FeaturedContainerModel.class, new Serializer());
                }
            }

            public FeaturedContainerModel() {
                super(1);
            }

            @Nullable
            private String m10795j() {
                this.f10772d = super.a(this.f10772d, 0);
                return this.f10772d;
            }

            @Nullable
            public final String m10798a() {
                return m10795j();
            }

            public final int jK_() {
                return 835091488;
            }

            public final GraphQLVisitableModel m10797a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
                h();
                i();
                return this;
            }

            public final int m10796a(FlatBufferBuilder flatBufferBuilder) {
                h();
                int b = flatBufferBuilder.b(m10795j());
                flatBufferBuilder.c(1);
                flatBufferBuilder.b(0, b);
                i();
                return flatBufferBuilder.d();
            }
        }

        /* compiled from: go_launcher */
        public class Serializer extends JsonSerializer<AddFeaturedContainerMutationModel> {
            public final void m10799a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AddFeaturedContainerMutationModel addFeaturedContainerMutationModel = (AddFeaturedContainerMutationModel) obj;
                if (addFeaturedContainerMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(addFeaturedContainerMutationModel.m10801a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    addFeaturedContainerMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = addFeaturedContainerMutationModel.w_();
                int u_ = addFeaturedContainerMutationModel.u_();
                jsonGenerator.f();
                int g = mutableFlatBuffer.g(u_, 0);
                if (g != 0) {
                    jsonGenerator.a("featured_container");
                    FeaturedContainerParser.m10804a(mutableFlatBuffer, g, jsonGenerator);
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AddFeaturedContainerMutationModel.class, new Serializer());
            }
        }

        public AddFeaturedContainerMutationModel() {
            super(1);
        }

        @Nullable
        private FeaturedContainerModel m10800a() {
            this.f10773d = (FeaturedContainerModel) super.a(this.f10773d, 0, FeaturedContainerModel.class);
            return this.f10773d;
        }

        public final int jK_() {
            return 1043851592;
        }

        public final GraphQLVisitableModel m10802a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            GraphQLVisitableModel graphQLVisitableModel = null;
            h();
            if (m10800a() != null) {
                FeaturedContainerModel featuredContainerModel = (FeaturedContainerModel) graphQLModelMutatingVisitor.b(m10800a());
                if (m10800a() != featuredContainerModel) {
                    graphQLVisitableModel = (AddFeaturedContainerMutationModel) ModelHelper.a(null, this);
                    graphQLVisitableModel.f10773d = featuredContainerModel;
                }
            }
            i();
            return graphQLVisitableModel == null ? this : graphQLVisitableModel;
        }

        public final int m10801a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m10800a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, a);
            i();
            return flatBufferBuilder.d();
        }
    }
}

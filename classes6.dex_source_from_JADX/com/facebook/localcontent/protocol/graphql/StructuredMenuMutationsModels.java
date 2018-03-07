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
import com.facebook.localcontent.protocol.graphql.StructuredMenuMutationsParsers.MenuItemLikeMutationParser;
import com.facebook.localcontent.protocol.graphql.StructuredMenuMutationsParsers.MenuItemUnlikeMutationParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

/* compiled from: keywords_entities(%s) */
public class StructuredMenuMutationsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: keywords_entities(%s) */
    public final class MenuItemLikeMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f11822d;

        /* compiled from: keywords_entities(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MenuItemLikeMutationModel.class, new Deserializer());
            }

            public Object m18766a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MenuItemLikeMutationParser.m18776a(jsonParser);
                Object menuItemLikeMutationModel = new MenuItemLikeMutationModel();
                ((BaseModel) menuItemLikeMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (menuItemLikeMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) menuItemLikeMutationModel).a();
                }
                return menuItemLikeMutationModel;
            }
        }

        /* compiled from: keywords_entities(%s) */
        public class Serializer extends JsonSerializer<MenuItemLikeMutationModel> {
            public final void m18767a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MenuItemLikeMutationModel menuItemLikeMutationModel = (MenuItemLikeMutationModel) obj;
                if (menuItemLikeMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(menuItemLikeMutationModel.m18769a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    menuItemLikeMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = menuItemLikeMutationModel.w_();
                int u_ = menuItemLikeMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MenuItemLikeMutationModel.class, new Serializer());
            }
        }

        public MenuItemLikeMutationModel() {
            super(1);
        }

        @Nullable
        private String m18768a() {
            this.f11822d = super.a(this.f11822d, 0);
            return this.f11822d;
        }

        public final int jK_() {
            return 2086229526;
        }

        public final GraphQLVisitableModel m18770a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m18769a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m18768a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -2642782)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: keywords_entities(%s) */
    public final class MenuItemUnlikeMutationModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f11823d;

        /* compiled from: keywords_entities(%s) */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(MenuItemUnlikeMutationModel.class, new Deserializer());
            }

            public Object m18771a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                MutableFlatBuffer a = MenuItemUnlikeMutationParser.m18777a(jsonParser);
                Object menuItemUnlikeMutationModel = new MenuItemUnlikeMutationModel();
                ((BaseModel) menuItemUnlikeMutationModel).a(a, FlatBuffer.a(a.a), jsonParser);
                if (menuItemUnlikeMutationModel instanceof Postprocessable) {
                    return ((Postprocessable) menuItemUnlikeMutationModel).a();
                }
                return menuItemUnlikeMutationModel;
            }
        }

        /* compiled from: keywords_entities(%s) */
        public class Serializer extends JsonSerializer<MenuItemUnlikeMutationModel> {
            public final void m18772a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                MenuItemUnlikeMutationModel menuItemUnlikeMutationModel = (MenuItemUnlikeMutationModel) obj;
                if (menuItemUnlikeMutationModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(menuItemUnlikeMutationModel.m18774a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    menuItemUnlikeMutationModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = menuItemUnlikeMutationModel.w_();
                int u_ = menuItemUnlikeMutationModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("client_mutation_id");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(MenuItemUnlikeMutationModel.class, new Serializer());
            }
        }

        public MenuItemUnlikeMutationModel() {
            super(1);
        }

        @Nullable
        private String m18773a() {
            this.f11823d = super.a(this.f11823d, 0);
            return this.f11823d;
        }

        public final int jK_() {
            return -1612906787;
        }

        public final GraphQLVisitableModel m18775a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m18774a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m18773a());
            flatBufferBuilder.c(1);
            flatBufferBuilder.b(0, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}

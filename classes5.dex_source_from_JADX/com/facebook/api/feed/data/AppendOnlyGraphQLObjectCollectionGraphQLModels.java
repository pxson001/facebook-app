package com.facebook.api.feed.data;

import com.facebook.api.feed.data.AppendOnlyGraphQLObjectCollectionGraphQLParsers.AppendOnlyPageInfoGraphQLParser;
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

/* compiled from: associated_places_info */
public class AppendOnlyGraphQLObjectCollectionGraphQLModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = 921619519)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: associated_places_info */
    public final class AppendOnlyPageInfoGraphQLModel extends BaseModel implements GraphQLVisitableModel {
        @Nullable
        private String f8770d;
        private boolean f8771e;
        private boolean f8772f;
        @Nullable
        private String f8773g;

        /* compiled from: associated_places_info */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(AppendOnlyPageInfoGraphQLModel.class, new Deserializer());
            }

            public Object m14663a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(AppendOnlyPageInfoGraphQLParser.m14672a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object appendOnlyPageInfoGraphQLModel = new AppendOnlyPageInfoGraphQLModel();
                ((BaseModel) appendOnlyPageInfoGraphQLModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (appendOnlyPageInfoGraphQLModel instanceof Postprocessable) {
                    return ((Postprocessable) appendOnlyPageInfoGraphQLModel).a();
                }
                return appendOnlyPageInfoGraphQLModel;
            }
        }

        /* compiled from: associated_places_info */
        public class Serializer extends JsonSerializer<AppendOnlyPageInfoGraphQLModel> {
            public final void m14664a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                MutableFlatBuffer mutableFlatBuffer;
                AppendOnlyPageInfoGraphQLModel appendOnlyPageInfoGraphQLModel = (AppendOnlyPageInfoGraphQLModel) obj;
                if (appendOnlyPageInfoGraphQLModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(appendOnlyPageInfoGraphQLModel.m14665a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    appendOnlyPageInfoGraphQLModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                mutableFlatBuffer = appendOnlyPageInfoGraphQLModel.w_();
                int u_ = appendOnlyPageInfoGraphQLModel.u_();
                jsonGenerator.f();
                if (mutableFlatBuffer.g(u_, 0) != 0) {
                    jsonGenerator.a("end_cursor");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 0));
                }
                boolean a = mutableFlatBuffer.a(u_, 1);
                if (a) {
                    jsonGenerator.a("has_next_page");
                    jsonGenerator.a(a);
                }
                a = mutableFlatBuffer.a(u_, 2);
                if (a) {
                    jsonGenerator.a("has_previous_page");
                    jsonGenerator.a(a);
                }
                if (mutableFlatBuffer.g(u_, 3) != 0) {
                    jsonGenerator.a("start_cursor");
                    jsonGenerator.b(mutableFlatBuffer.c(u_, 3));
                }
                jsonGenerator.g();
            }

            static {
                FbSerializerProvider.a(AppendOnlyPageInfoGraphQLModel.class, new Serializer());
            }
        }

        public AppendOnlyPageInfoGraphQLModel() {
            super(4);
        }

        public AppendOnlyPageInfoGraphQLModel(MutableFlatBuffer mutableFlatBuffer) {
            super(4);
            a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
        }

        @Nullable
        public final String m14667a() {
            this.f8770d = super.a(this.f8770d, 0);
            return this.f8770d;
        }

        public final boolean m14669b() {
            a(0, 1);
            return this.f8771e;
        }

        public final boolean m14670c() {
            a(0, 2);
            return this.f8772f;
        }

        @Nullable
        public final String m14671d() {
            this.f8773g = super.a(this.f8773g, 3);
            return this.f8773g;
        }

        public final int jK_() {
            return 923779069;
        }

        public final GraphQLVisitableModel m14666a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m14665a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int b = flatBufferBuilder.b(m14667a());
            int b2 = flatBufferBuilder.b(m14671d());
            flatBufferBuilder.c(4);
            flatBufferBuilder.b(0, b);
            flatBufferBuilder.a(1, this.f8771e);
            flatBufferBuilder.a(2, this.f8772f);
            flatBufferBuilder.b(3, b2);
            i();
            return flatBufferBuilder.d();
        }

        public final void m14668a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
            super.a(mutableFlatBuffer, i, obj);
            this.f8771e = mutableFlatBuffer.a(i, 1);
            this.f8772f = mutableFlatBuffer.a(i, 2);
        }
    }
}

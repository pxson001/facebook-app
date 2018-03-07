package com.facebook.goodwill.feed.protocol;

import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.goodwill.feed.protocol.ThrowbackFeedUnitsParsers.ThrowbackShareableParser;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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

/* compiled from: fetchInitialAlbumsListCache_%s */
public class ThrowbackFeedUnitsModels {

    @JsonDeserialize(using = Deserializer.class)
    @ModelWithFlatBufferFormatHash(a = -1787905591)
    @JsonSerialize(using = Serializer.class)
    @FragmentModelWithoutBridge
    /* compiled from: fetchInitialAlbumsListCache_%s */
    public final class ThrowbackShareableModel extends BaseModel implements GraphQLPersistableNode, GraphQLVisitableModel {
        @Nullable
        private GraphQLObjectType f13493d;
        @Nullable
        private String f13494e;

        /* compiled from: fetchInitialAlbumsListCache_%s */
        public class Deserializer extends FbJsonDeserializer {
            static {
                GlobalAutoGenDeserializerCache.a(ThrowbackShareableModel.class, new Deserializer());
            }

            public Object m15269a(JsonParser jsonParser, DeserializationContext deserializationContext) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(ThrowbackShareableParser.m15276a(jsonParser, flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                mutableFlatBuffer.a(4, Boolean.valueOf(true));
                MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
                Object throwbackShareableModel = new ThrowbackShareableModel();
                ((BaseModel) throwbackShareableModel).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
                if (throwbackShareableModel instanceof Postprocessable) {
                    return ((Postprocessable) throwbackShareableModel).a();
                }
                return throwbackShareableModel;
            }
        }

        /* compiled from: fetchInitialAlbumsListCache_%s */
        public class Serializer extends JsonSerializer<ThrowbackShareableModel> {
            public final void m15270a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
                ThrowbackShareableModel throwbackShareableModel = (ThrowbackShareableModel) obj;
                if (throwbackShareableModel.w_() == null) {
                    FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                    flatBufferBuilder.d(throwbackShareableModel.m15271a(flatBufferBuilder));
                    ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                    wrap.position(0);
                    MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                    throwbackShareableModel.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
                }
                ThrowbackShareableParser.m15277a(throwbackShareableModel.w_(), throwbackShareableModel.u_(), jsonGenerator);
            }

            static {
                FbSerializerProvider.a(ThrowbackShareableModel.class, new Serializer());
            }
        }

        public ThrowbackShareableModel() {
            super(2);
        }

        @Nullable
        public final GraphQLObjectType m15274b() {
            if (this.b != null && this.f13493d == null) {
                this.f13493d = (GraphQLObjectType) this.b.d(this.c, 0, GraphQLObjectType.class);
            }
            return this.f13493d;
        }

        @Nullable
        public final String m15275c() {
            this.f13494e = super.a(this.f13494e, 1);
            return this.f13494e;
        }

        @Nullable
        public final String m15273a() {
            return m15275c();
        }

        public final int jK_() {
            return 2080559107;
        }

        public final GraphQLVisitableModel m15272a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
            h();
            i();
            return this;
        }

        public final int m15271a(FlatBufferBuilder flatBufferBuilder) {
            h();
            int a = ModelHelper.a(flatBufferBuilder, m15274b());
            int b = flatBufferBuilder.b(m15275c());
            flatBufferBuilder.c(2);
            flatBufferBuilder.b(0, a);
            flatBufferBuilder.b(1, b);
            i();
            return flatBufferBuilder.d();
        }
    }
}

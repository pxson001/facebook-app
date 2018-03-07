package com.facebook.api.graphql.feed;

import com.facebook.api.graphql.feed.NewsFeedDefaultsFeedbackGraphQLParsers.NewsFeedDefaultsCompleteFeedbackParser.LikersParser;
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

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1723990064)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: app_center_categories */
public final class C0965x3b20b1c extends BaseModel implements GraphQLVisitableModel {
    private int f9295d;

    /* compiled from: app_center_categories */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0965x3b20b1c.class, new Deserializer());
        }

        public Object m15848a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(LikersParser.m15881a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0965x3b20b1c = new C0965x3b20b1c();
            ((BaseModel) c0965x3b20b1c).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0965x3b20b1c instanceof Postprocessable) {
                return ((Postprocessable) c0965x3b20b1c).a();
            }
            return c0965x3b20b1c;
        }
    }

    /* compiled from: app_center_categories */
    public class Serializer extends JsonSerializer<C0965x3b20b1c> {
        public final void m15849a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0965x3b20b1c c0965x3b20b1c = (C0965x3b20b1c) obj;
            if (c0965x3b20b1c.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0965x3b20b1c.m15851a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0965x3b20b1c.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            LikersParser.m15882a(c0965x3b20b1c.w_(), c0965x3b20b1c.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0965x3b20b1c.class, new Serializer());
        }
    }

    public C0965x3b20b1c() {
        super(1);
    }

    public final int m15850a() {
        a(0, 0);
        return this.f9295d;
    }

    public final void m15853a(int i) {
        this.f9295d = i;
        if (this.b != null && this.b.d) {
            this.b.b(this.c, 0, i);
        }
    }

    public final int jK_() {
        return 733369288;
    }

    public final GraphQLVisitableModel m15852a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m15851a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(1);
        flatBufferBuilder.a(0, this.f9295d, 0);
        i();
        return flatBufferBuilder.d();
    }

    public final void m15854a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f9295d = mutableFlatBuffer.a(i, 0, 0);
    }
}

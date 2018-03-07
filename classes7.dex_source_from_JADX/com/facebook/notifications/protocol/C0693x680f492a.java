package com.facebook.notifications.protocol;

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
import com.facebook.notifications.protocol.FetchNotificationsGraphQLParsers.NotificationsEdgeFieldsParser.ImportanceReasonTextParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.nio.ByteBuffer;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = -1352864475)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: negativeFeedbackActionOnReportableEntity */
public final class C0693x680f492a extends BaseModel implements GraphQLVisitableModel {
    @Nullable
    private String f8533d;

    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public final class Builder {
        @Nullable
        public String f8532a;
    }

    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(C0693x680f492a.class, new Deserializer());
        }

        public Object m10206a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            flatBufferBuilder.d(ImportanceReasonTextParser.m10299a(jsonParser, flatBufferBuilder));
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
            mutableFlatBuffer.a(4, Boolean.valueOf(true));
            MutableFlatBuffer mutableFlatBuffer2 = mutableFlatBuffer;
            Object c0693x680f492a = new C0693x680f492a();
            ((BaseModel) c0693x680f492a).a(mutableFlatBuffer2, FlatBuffer.a(mutableFlatBuffer2.a), jsonParser);
            if (c0693x680f492a instanceof Postprocessable) {
                return ((Postprocessable) c0693x680f492a).a();
            }
            return c0693x680f492a;
        }
    }

    /* compiled from: negativeFeedbackActionOnReportableEntity */
    public class Serializer extends JsonSerializer<C0693x680f492a> {
        public final void m10207a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            C0693x680f492a c0693x680f492a = (C0693x680f492a) obj;
            if (c0693x680f492a.w_() == null) {
                FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
                flatBufferBuilder.d(c0693x680f492a.m10209a(flatBufferBuilder));
                ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
                wrap.position(0);
                MutableFlatBuffer mutableFlatBuffer = new MutableFlatBuffer(wrap, null, null, true, null);
                c0693x680f492a.a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
            }
            ImportanceReasonTextParser.m10300a(c0693x680f492a.w_(), c0693x680f492a.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(C0693x680f492a.class, new Serializer());
        }
    }

    public C0693x680f492a() {
        super(1);
    }

    public C0693x680f492a(MutableFlatBuffer mutableFlatBuffer) {
        super(1);
        a(mutableFlatBuffer, FlatBuffer.a(mutableFlatBuffer.a));
    }

    @Nullable
    public final String m10211a() {
        this.f8533d = super.a(this.f8533d, 0);
        return this.f8533d;
    }

    public static C0693x680f492a m10208a(C0693x680f492a c0693x680f492a) {
        if (c0693x680f492a == null) {
            return null;
        }
        if (c0693x680f492a instanceof C0693x680f492a) {
            return c0693x680f492a;
        }
        Builder builder = new Builder();
        builder.f8532a = c0693x680f492a.m10211a();
        FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
        int b = flatBufferBuilder.b(builder.f8532a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.d(flatBufferBuilder.d());
        ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
        wrap.position(0);
        return new C0693x680f492a(new MutableFlatBuffer(wrap, null, null, true, null));
    }

    public final int jK_() {
        return -1919764332;
    }

    public final GraphQLVisitableModel m10210a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public final int m10209a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m10211a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }
}

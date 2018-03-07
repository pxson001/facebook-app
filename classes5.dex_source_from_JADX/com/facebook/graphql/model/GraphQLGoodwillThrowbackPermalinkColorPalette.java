package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackPermalinkColorPaletteDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: getTotalTcpBytesReceived */
public final class GraphQLGoodwillThrowbackPermalinkColorPalette extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackPermalinkColorPalette> CREATOR = new C03631();
    @Nullable
    public String f4029d;

    /* compiled from: getTotalTcpBytesReceived */
    final class C03631 implements Creator<GraphQLGoodwillThrowbackPermalinkColorPalette> {
        C03631() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillThrowbackPermalinkColorPalette(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillThrowbackPermalinkColorPalette[i];
        }
    }

    /* compiled from: getTotalTcpBytesReceived */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackPermalinkColorPalette.class, new Deserializer());
        }

        public Object m8061a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillThrowbackPermalinkColorPaletteDeserializer.m5054a(jsonParser, (short) 403);
            Object graphQLGoodwillThrowbackPermalinkColorPalette = new GraphQLGoodwillThrowbackPermalinkColorPalette();
            ((BaseModel) graphQLGoodwillThrowbackPermalinkColorPalette).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillThrowbackPermalinkColorPalette instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillThrowbackPermalinkColorPalette).a();
            }
            return graphQLGoodwillThrowbackPermalinkColorPalette;
        }
    }

    /* compiled from: getTotalTcpBytesReceived */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillThrowbackPermalinkColorPalette> {
        public final void m8062a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillThrowbackPermalinkColorPalette graphQLGoodwillThrowbackPermalinkColorPalette = (GraphQLGoodwillThrowbackPermalinkColorPalette) obj;
            GraphQLGoodwillThrowbackPermalinkColorPaletteDeserializer.m5055a(graphQLGoodwillThrowbackPermalinkColorPalette.w_(), graphQLGoodwillThrowbackPermalinkColorPalette.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillThrowbackPermalinkColorPalette.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillThrowbackPermalinkColorPalette.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m8065a() {
        this.f4029d = super.a(this.f4029d, 0);
        return this.f4029d;
    }

    public final int jK_() {
        return -1428097179;
    }

    public final GraphQLVisitableModel m8064a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLGoodwillThrowbackPermalinkColorPalette() {
        super(2);
    }

    public final int m8063a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m8065a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillThrowbackPermalinkColorPalette(Parcel parcel) {
        super(2);
        this.f4029d = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8065a());
    }
}

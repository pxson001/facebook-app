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
import com.facebook.graphql.deserializers.GraphQLGoodwillThrowbackPromotionColorPaletteDeserializer;
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
/* compiled from: getSensorStats */
public final class GraphQLGoodwillThrowbackPromotionColorPalette extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGoodwillThrowbackPromotionColorPalette> CREATOR = new C03661();
    @Nullable
    public String f4032d;
    @Nullable
    public String f4033e;

    /* compiled from: getSensorStats */
    final class C03661 implements Creator<GraphQLGoodwillThrowbackPromotionColorPalette> {
        C03661() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGoodwillThrowbackPromotionColorPalette(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGoodwillThrowbackPromotionColorPalette[i];
        }
    }

    /* compiled from: getSensorStats */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGoodwillThrowbackPromotionColorPalette.class, new Deserializer());
        }

        public Object m8088a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGoodwillThrowbackPromotionColorPaletteDeserializer.m5063a(jsonParser, (short) 370);
            Object graphQLGoodwillThrowbackPromotionColorPalette = new GraphQLGoodwillThrowbackPromotionColorPalette();
            ((BaseModel) graphQLGoodwillThrowbackPromotionColorPalette).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGoodwillThrowbackPromotionColorPalette instanceof Postprocessable) {
                return ((Postprocessable) graphQLGoodwillThrowbackPromotionColorPalette).a();
            }
            return graphQLGoodwillThrowbackPromotionColorPalette;
        }
    }

    /* compiled from: getSensorStats */
    public final class Serializer extends JsonSerializer<GraphQLGoodwillThrowbackPromotionColorPalette> {
        public final void m8089a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGoodwillThrowbackPromotionColorPalette graphQLGoodwillThrowbackPromotionColorPalette = (GraphQLGoodwillThrowbackPromotionColorPalette) obj;
            GraphQLGoodwillThrowbackPromotionColorPaletteDeserializer.m5064a(graphQLGoodwillThrowbackPromotionColorPalette.w_(), graphQLGoodwillThrowbackPromotionColorPalette.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLGoodwillThrowbackPromotionColorPalette.class, new Serializer());
            FbSerializerProvider.a(GraphQLGoodwillThrowbackPromotionColorPalette.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m8092a() {
        this.f4032d = super.a(this.f4032d, 0);
        return this.f4032d;
    }

    @FieldOffset
    @Nullable
    public final String m8093j() {
        this.f4033e = super.a(this.f4033e, 1);
        return this.f4033e;
    }

    public final int jK_() {
        return 676963613;
    }

    public final GraphQLVisitableModel m8091a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLGoodwillThrowbackPromotionColorPalette() {
        super(3);
    }

    public final int m8090a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m8092a());
        int b2 = flatBufferBuilder.b(m8093j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGoodwillThrowbackPromotionColorPalette(Parcel parcel) {
        super(3);
        this.f4032d = parcel.readString();
        this.f4033e = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8092a());
        parcel.writeString(m8093j());
    }
}

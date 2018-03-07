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
import com.facebook.graphql.deserializers.GraphQLQuantityDeserializer;
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
/* compiled from: VINE */
public final class GraphQLQuantity extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLQuantity> CREATOR = new C11881();
    @Nullable
    public String f12824d;
    public double f12825e;

    /* compiled from: VINE */
    final class C11881 implements Creator<GraphQLQuantity> {
        C11881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLQuantity(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLQuantity[i];
        }
    }

    /* compiled from: VINE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLQuantity.class, new Deserializer());
        }

        public Object m21140a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLQuantityDeserializer.m5732a(jsonParser, (short) 286);
            Object graphQLQuantity = new GraphQLQuantity();
            ((BaseModel) graphQLQuantity).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLQuantity instanceof Postprocessable) {
                return ((Postprocessable) graphQLQuantity).a();
            }
            return graphQLQuantity;
        }
    }

    /* compiled from: VINE */
    public final class Serializer extends JsonSerializer<GraphQLQuantity> {
        public final void m21141a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLQuantity graphQLQuantity = (GraphQLQuantity) obj;
            GraphQLQuantityDeserializer.m5733a(graphQLQuantity.w_(), graphQLQuantity.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLQuantity.class, new Serializer());
            FbSerializerProvider.a(GraphQLQuantity.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m21144a() {
        this.f12824d = super.a(this.f12824d, 0);
        return this.f12824d;
    }

    @FieldOffset
    public final double m21146j() {
        a(0, 1);
        return this.f12825e;
    }

    public final int jK_() {
        return -1220360021;
    }

    public final GraphQLVisitableModel m21143a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLQuantity() {
        super(3);
    }

    public final void m21145a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12825e = mutableFlatBuffer.a(i, 1, 0.0d);
    }

    public final int m21142a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m21144a());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, m21146j(), 0.0d);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLQuantity(Parcel parcel) {
        super(3);
        this.f12824d = parcel.readString();
        this.f12825e = parcel.readDouble();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m21144a());
        parcel.writeDouble(m21146j());
    }
}

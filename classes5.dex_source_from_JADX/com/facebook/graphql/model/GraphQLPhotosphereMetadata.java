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
import com.facebook.graphql.deserializers.GraphQLPhotosphereMetadataDeserializer;
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

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: WIFI_FORCE */
public final class GraphQLPhotosphereMetadata extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPhotosphereMetadata> CREATOR = new C11731();
    public int f12569d;
    public int f12570e;
    public int f12571f;
    public int f12572g;
    public double f12573h;
    public double f12574i;
    public double f12575j;
    public double f12576k;
    public int f12577l;
    public int f12578m;

    /* compiled from: WIFI_FORCE */
    final class C11731 implements Creator<GraphQLPhotosphereMetadata> {
        C11731() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPhotosphereMetadata(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPhotosphereMetadata[i];
        }
    }

    /* compiled from: WIFI_FORCE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPhotosphereMetadata.class, new Deserializer());
        }

        public Object m20767a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPhotosphereMetadataDeserializer.m5624a(jsonParser, (short) 245);
            Object graphQLPhotosphereMetadata = new GraphQLPhotosphereMetadata();
            ((BaseModel) graphQLPhotosphereMetadata).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPhotosphereMetadata instanceof Postprocessable) {
                return ((Postprocessable) graphQLPhotosphereMetadata).a();
            }
            return graphQLPhotosphereMetadata;
        }
    }

    /* compiled from: WIFI_FORCE */
    public final class Serializer extends JsonSerializer<GraphQLPhotosphereMetadata> {
        public final void m20768a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPhotosphereMetadata graphQLPhotosphereMetadata = (GraphQLPhotosphereMetadata) obj;
            GraphQLPhotosphereMetadataDeserializer.m5625a(graphQLPhotosphereMetadata.w_(), graphQLPhotosphereMetadata.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLPhotosphereMetadata.class, new Serializer());
            FbSerializerProvider.a(GraphQLPhotosphereMetadata.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m20769a() {
        a(0, 0);
        return this.f12569d;
    }

    @FieldOffset
    public final int m20773j() {
        a(0, 1);
        return this.f12570e;
    }

    @FieldOffset
    public final int m20774k() {
        a(0, 2);
        return this.f12571f;
    }

    @FieldOffset
    public final int m20775l() {
        a(0, 3);
        return this.f12572g;
    }

    @FieldOffset
    public final double m20776m() {
        a(0, 4);
        return this.f12573h;
    }

    @FieldOffset
    public final double m20777n() {
        a(0, 5);
        return this.f12574i;
    }

    @FieldOffset
    public final double m20778o() {
        a(0, 6);
        return this.f12575j;
    }

    @FieldOffset
    public final double m20779p() {
        a(0, 7);
        return this.f12576k;
    }

    @FieldOffset
    public final int m20780q() {
        a(1, 0);
        return this.f12577l;
    }

    @FieldOffset
    public final int m20781r() {
        a(1, 1);
        return this.f12578m;
    }

    public final int jK_() {
        return 628846766;
    }

    public final GraphQLVisitableModel m20771a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLPhotosphereMetadata() {
        super(11);
    }

    public final void m20772a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12569d = mutableFlatBuffer.a(i, 0, 0);
        this.f12570e = mutableFlatBuffer.a(i, 1, 0);
        this.f12571f = mutableFlatBuffer.a(i, 2, 0);
        this.f12572g = mutableFlatBuffer.a(i, 3, 0);
        this.f12573h = mutableFlatBuffer.a(i, 4, 0.0d);
        this.f12574i = mutableFlatBuffer.a(i, 5, 0.0d);
        this.f12575j = mutableFlatBuffer.a(i, 6, 0.0d);
        this.f12576k = mutableFlatBuffer.a(i, 7, 0.0d);
        this.f12577l = mutableFlatBuffer.a(i, 8, 0);
        this.f12578m = mutableFlatBuffer.a(i, 9, 0);
    }

    public final int m20770a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(10);
        flatBufferBuilder.a(0, m20769a(), 0);
        flatBufferBuilder.a(1, m20773j(), 0);
        flatBufferBuilder.a(2, m20774k(), 0);
        flatBufferBuilder.a(3, m20775l(), 0);
        flatBufferBuilder.a(4, m20776m(), 0.0d);
        flatBufferBuilder.a(5, m20777n(), 0.0d);
        flatBufferBuilder.a(6, m20778o(), 0.0d);
        flatBufferBuilder.a(7, m20779p(), 0.0d);
        flatBufferBuilder.a(8, m20780q(), 0);
        flatBufferBuilder.a(9, m20781r(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPhotosphereMetadata(Parcel parcel) {
        super(11);
        this.f12571f = parcel.readInt();
        this.f12572g = parcel.readInt();
        this.f12577l = parcel.readInt();
        this.f12578m = parcel.readInt();
        this.f12569d = parcel.readInt();
        this.f12570e = parcel.readInt();
        this.f12573h = parcel.readDouble();
        this.f12574i = parcel.readDouble();
        this.f12575j = parcel.readDouble();
        this.f12576k = parcel.readDouble();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m20774k());
        parcel.writeInt(m20775l());
        parcel.writeInt(m20780q());
        parcel.writeInt(m20781r());
        parcel.writeInt(m20769a());
        parcel.writeInt(m20773j());
        parcel.writeDouble(m20776m());
        parcel.writeDouble(m20777n());
        parcel.writeDouble(m20778o());
        parcel.writeDouble(m20779p());
    }
}

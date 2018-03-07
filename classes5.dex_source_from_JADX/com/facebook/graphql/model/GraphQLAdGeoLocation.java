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
import com.facebook.graphql.deserializers.GraphQLAdGeoLocationDeserializer;
import com.facebook.graphql.enums.GraphQLAdGeoLocationType;
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
/* compiled from: largeThumbnail */
public final class GraphQLAdGeoLocation extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLAdGeoLocation> CREATOR = new C02581();
    @Nullable
    public String f3293d;
    @Nullable
    public String f3294e;
    @Nullable
    public String f3295f;
    @Nullable
    public String f3296g;
    @Nullable
    public String f3297h;
    public double f3298i;
    public GraphQLAdGeoLocationType f3299j;
    public double f3300k;
    @Nullable
    public String f3301l;
    public double f3302m;
    @Nullable
    public String f3303n;
    public boolean f3304o;
    public boolean f3305p;

    /* compiled from: largeThumbnail */
    final class C02581 implements Creator<GraphQLAdGeoLocation> {
        C02581() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLAdGeoLocation(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLAdGeoLocation[i];
        }
    }

    /* compiled from: largeThumbnail */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLAdGeoLocation.class, new Deserializer());
        }

        public Object m6429a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLAdGeoLocationDeserializer.m4526a(jsonParser, (short) 253);
            Object graphQLAdGeoLocation = new GraphQLAdGeoLocation();
            ((BaseModel) graphQLAdGeoLocation).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLAdGeoLocation instanceof Postprocessable) {
                return ((Postprocessable) graphQLAdGeoLocation).a();
            }
            return graphQLAdGeoLocation;
        }
    }

    /* compiled from: largeThumbnail */
    public final class Serializer extends JsonSerializer<GraphQLAdGeoLocation> {
        public final void m6430a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLAdGeoLocation graphQLAdGeoLocation = (GraphQLAdGeoLocation) obj;
            GraphQLAdGeoLocationDeserializer.m4527a(graphQLAdGeoLocation.w_(), graphQLAdGeoLocation.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLAdGeoLocation.class, new Serializer());
            FbSerializerProvider.a(GraphQLAdGeoLocation.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m6433a() {
        this.f3293d = super.a(this.f3293d, 0);
        return this.f3293d;
    }

    @FieldOffset
    @Nullable
    public final String m6435j() {
        this.f3294e = super.a(this.f3294e, 1);
        return this.f3294e;
    }

    @FieldOffset
    @Nullable
    public final String m6436k() {
        this.f3295f = super.a(this.f3295f, 2);
        return this.f3295f;
    }

    @FieldOffset
    @Nullable
    public final String m6437l() {
        this.f3296g = super.a(this.f3296g, 3);
        return this.f3296g;
    }

    @FieldOffset
    @Nullable
    public final String m6438m() {
        this.f3297h = super.a(this.f3297h, 4);
        return this.f3297h;
    }

    @FieldOffset
    public final double m6439n() {
        a(0, 5);
        return this.f3298i;
    }

    @FieldOffset
    public final GraphQLAdGeoLocationType m6440o() {
        this.f3299j = (GraphQLAdGeoLocationType) super.a(this.f3299j, 6, GraphQLAdGeoLocationType.class, GraphQLAdGeoLocationType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f3299j;
    }

    @FieldOffset
    public final double m6441p() {
        a(0, 7);
        return this.f3300k;
    }

    @FieldOffset
    @Nullable
    public final String m6442q() {
        this.f3301l = super.a(this.f3301l, 8);
        return this.f3301l;
    }

    @FieldOffset
    public final double m6443r() {
        a(1, 1);
        return this.f3302m;
    }

    @FieldOffset
    @Nullable
    public final String m6444s() {
        this.f3303n = super.a(this.f3303n, 10);
        return this.f3303n;
    }

    @FieldOffset
    public final boolean m6445t() {
        a(1, 3);
        return this.f3304o;
    }

    @FieldOffset
    public final boolean m6446u() {
        a(1, 4);
        return this.f3305p;
    }

    public final int jK_() {
        return -68773405;
    }

    public final GraphQLVisitableModel m6432a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLAdGeoLocation() {
        super(14);
    }

    public final void m6434a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3298i = mutableFlatBuffer.a(i, 5, 0.0d);
        this.f3300k = mutableFlatBuffer.a(i, 7, 0.0d);
        this.f3302m = mutableFlatBuffer.a(i, 9, 0.0d);
        this.f3304o = mutableFlatBuffer.a(i, 11);
        this.f3305p = mutableFlatBuffer.a(i, 12);
    }

    public final int m6431a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6433a());
        int b2 = flatBufferBuilder.b(m6435j());
        int b3 = flatBufferBuilder.b(m6436k());
        int b4 = flatBufferBuilder.b(m6437l());
        int b5 = flatBufferBuilder.b(m6438m());
        int b6 = flatBufferBuilder.b(m6442q());
        int b7 = flatBufferBuilder.b(m6444s());
        flatBufferBuilder.c(13);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        flatBufferBuilder.b(3, b4);
        flatBufferBuilder.b(4, b5);
        flatBufferBuilder.a(5, m6439n(), 0.0d);
        flatBufferBuilder.a(6, m6440o() == GraphQLAdGeoLocationType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m6440o());
        flatBufferBuilder.a(7, m6441p(), 0.0d);
        flatBufferBuilder.b(8, b6);
        flatBufferBuilder.a(9, m6443r(), 0.0d);
        flatBufferBuilder.b(10, b7);
        flatBufferBuilder.a(11, m6445t());
        flatBufferBuilder.a(12, m6446u());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLAdGeoLocation(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(14);
        this.f3293d = parcel.readString();
        this.f3294e = parcel.readString();
        this.f3295f = parcel.readString();
        this.f3296g = parcel.readString();
        this.f3297h = parcel.readString();
        this.f3298i = parcel.readDouble();
        this.f3299j = GraphQLAdGeoLocationType.fromString(parcel.readString());
        this.f3300k = parcel.readDouble();
        this.f3301l = parcel.readString();
        this.f3302m = parcel.readDouble();
        this.f3303n = parcel.readString();
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f3304o = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f3305p = z2;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(m6433a());
        parcel.writeString(m6435j());
        parcel.writeString(m6436k());
        parcel.writeString(m6437l());
        parcel.writeString(m6438m());
        parcel.writeDouble(m6439n());
        parcel.writeString(m6440o().name());
        parcel.writeDouble(m6441p());
        parcel.writeString(m6442q());
        parcel.writeDouble(m6443r());
        parcel.writeString(m6444s());
        if (m6445t()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m6446u()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
    }
}

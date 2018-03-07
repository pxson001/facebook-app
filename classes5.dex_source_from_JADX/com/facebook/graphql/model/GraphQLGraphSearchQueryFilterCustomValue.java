package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.common.json.FbJsonDeserializer;
import com.facebook.common.json.FbSerializerProvider;
import com.facebook.common.json.GlobalAutoGenDeserializerCache;
import com.facebook.common.json.Postprocessable;
import com.facebook.common.parcels.ParcelUtil;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.deserializers.GraphQLGraphSearchQueryFilterCustomValueDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
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
/* compiled from: geo_region */
public final class GraphQLGraphSearchQueryFilterCustomValue extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGraphSearchQueryFilterCustomValue> CREATOR = new C03761();
    @Nullable
    public GraphQLObjectType f4084d;
    public int f4085e;
    public boolean f4086f;

    /* compiled from: geo_region */
    final class C03761 implements Creator<GraphQLGraphSearchQueryFilterCustomValue> {
        C03761() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGraphSearchQueryFilterCustomValue(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGraphSearchQueryFilterCustomValue[i];
        }
    }

    /* compiled from: geo_region */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchQueryFilterCustomValue.class, new Deserializer());
        }

        public Object m8213a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGraphSearchQueryFilterCustomValueDeserializer.m5087a(jsonParser, (short) 508);
            Object graphQLGraphSearchQueryFilterCustomValue = new GraphQLGraphSearchQueryFilterCustomValue();
            ((BaseModel) graphQLGraphSearchQueryFilterCustomValue).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGraphSearchQueryFilterCustomValue instanceof Postprocessable) {
                return ((Postprocessable) graphQLGraphSearchQueryFilterCustomValue).a();
            }
            return graphQLGraphSearchQueryFilterCustomValue;
        }
    }

    /* compiled from: geo_region */
    public final class Serializer extends JsonSerializer<GraphQLGraphSearchQueryFilterCustomValue> {
        public final void m8214a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGraphSearchQueryFilterCustomValue graphQLGraphSearchQueryFilterCustomValue = (GraphQLGraphSearchQueryFilterCustomValue) obj;
            GraphQLGraphSearchQueryFilterCustomValueDeserializer.m5088a(graphQLGraphSearchQueryFilterCustomValue.w_(), graphQLGraphSearchQueryFilterCustomValue.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLGraphSearchQueryFilterCustomValue.class, new Serializer());
            FbSerializerProvider.a(GraphQLGraphSearchQueryFilterCustomValue.class, new Serializer());
        }
    }

    @Nullable
    public final GraphQLObjectType m8216a() {
        if (this.b != null && this.f4084d == null) {
            this.f4084d = new GraphQLObjectType(this.b.b(this.c, 0));
        }
        if (this.f4084d == null || this.f4084d.g() != 0) {
            return this.f4084d;
        }
        return null;
    }

    @FieldOffset
    public final int m8219j() {
        a(0, 1);
        return this.f4085e;
    }

    @FieldOffset
    public final boolean m8220k() {
        a(0, 2);
        return this.f4086f;
    }

    public final int jK_() {
        return -287687146;
    }

    public final GraphQLVisitableModel m8217a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLGraphSearchQueryFilterCustomValue() {
        super(4);
    }

    public final void m8218a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4085e = mutableFlatBuffer.a(i, 1, 0);
        this.f4086f = mutableFlatBuffer.a(i, 2);
    }

    public final int m8215a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = flatBufferBuilder.a(m8216a() != null ? m8216a().e() : null);
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, m8219j(), 0);
        flatBufferBuilder.a(2, m8220k());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGraphSearchQueryFilterCustomValue(Parcel parcel) {
        boolean z = true;
        super(4);
        this.f4085e = parcel.readInt();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f4086f = z;
        this.f4084d = (GraphQLObjectType) ParcelUtil.m3828b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m8219j());
        parcel.writeByte((byte) (m8220k() ? 1 : 0));
        parcel.writeParcelable(this.f4084d, i);
    }
}

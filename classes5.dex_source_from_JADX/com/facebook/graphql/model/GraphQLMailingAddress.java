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
import com.facebook.graphql.deserializers.GraphQLMailingAddressDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: fb_libyuv_jni */
public final class GraphQLMailingAddress extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLMailingAddress> CREATOR = new C04291();
    @Nullable
    GraphQLStreetAddress f4415d;
    @Nullable
    GraphQLPage f4416e;
    @Nullable
    String f4417f;
    boolean f4418g;
    boolean f4419h;
    @Nullable
    String f4420i;
    @Nullable
    String f4421j;
    @Nullable
    String f4422k;
    @Nullable
    String f4423l;

    /* compiled from: fb_libyuv_jni */
    final class C04291 implements Creator<GraphQLMailingAddress> {
        C04291() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLMailingAddress(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLMailingAddress[i];
        }
    }

    /* compiled from: fb_libyuv_jni */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLMailingAddress.class, new Deserializer());
        }

        public Object m8967a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLMailingAddressDeserializer.m5336a(jsonParser, (short) 61);
            Object graphQLMailingAddress = new GraphQLMailingAddress();
            ((BaseModel) graphQLMailingAddress).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLMailingAddress instanceof Postprocessable) {
                return ((Postprocessable) graphQLMailingAddress).a();
            }
            return graphQLMailingAddress;
        }
    }

    /* compiled from: fb_libyuv_jni */
    public final class Serializer extends JsonSerializer<GraphQLMailingAddress> {
        public final void m8968a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLMailingAddress graphQLMailingAddress = (GraphQLMailingAddress) obj;
            GraphQLMailingAddressDeserializer.m5337a(graphQLMailingAddress.w_(), graphQLMailingAddress.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLMailingAddress.class, new Serializer());
            FbSerializerProvider.a(GraphQLMailingAddress.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLStreetAddress m8973j() {
        this.f4415d = (GraphQLStreetAddress) super.a(this.f4415d, 0, GraphQLStreetAddress.class);
        return this.f4415d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m8974k() {
        this.f4416e = (GraphQLPage) super.a(this.f4416e, 1, GraphQLPage.class);
        return this.f4416e;
    }

    @FieldOffset
    @Nullable
    public final String m8975l() {
        this.f4417f = super.a(this.f4417f, 2);
        return this.f4417f;
    }

    @FieldOffset
    public final boolean m8976m() {
        a(0, 3);
        return this.f4418g;
    }

    @FieldOffset
    public final boolean m8977n() {
        a(0, 4);
        return this.f4419h;
    }

    @FieldOffset
    @Nullable
    public final String m8978o() {
        this.f4420i = super.a(this.f4420i, 5);
        return this.f4420i;
    }

    @FieldOffset
    @Nullable
    public final String m8979p() {
        this.f4421j = super.a(this.f4421j, 6);
        return this.f4421j;
    }

    @FieldOffset
    @Nullable
    public final String m8980q() {
        this.f4422k = super.a(this.f4422k, 7);
        return this.f4422k;
    }

    @FieldOffset
    @Nullable
    public final String m8981r() {
        this.f4423l = super.a(this.f4423l, 8);
        return this.f4423l;
    }

    @Nullable
    public final String m8971a() {
        return m8975l();
    }

    public final int jK_() {
        return 430158537;
    }

    public final GraphQLVisitableModel m8970a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8973j() != null) {
            GraphQLStreetAddress graphQLStreetAddress = (GraphQLStreetAddress) graphQLModelMutatingVisitor.b(m8973j());
            if (m8973j() != graphQLStreetAddress) {
                graphQLVisitableModel = (GraphQLMailingAddress) ModelHelper.a(null, this);
                graphQLVisitableModel.f4415d = graphQLStreetAddress;
            }
        }
        if (m8974k() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m8974k());
            if (m8974k() != graphQLPage) {
                graphQLVisitableModel = (GraphQLMailingAddress) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4416e = graphQLPage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLMailingAddress() {
        super(10);
    }

    public final void m8972a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4418g = mutableFlatBuffer.a(i, 3);
        this.f4419h = mutableFlatBuffer.a(i, 4);
    }

    public final int m8969a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8973j());
        int a2 = ModelHelper.a(flatBufferBuilder, m8974k());
        int b = flatBufferBuilder.b(m8975l());
        int b2 = flatBufferBuilder.b(m8978o());
        int b3 = flatBufferBuilder.b(m8979p());
        int b4 = flatBufferBuilder.b(m8980q());
        int b5 = flatBufferBuilder.b(m8981r());
        flatBufferBuilder.c(9);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.a(3, m8976m());
        flatBufferBuilder.a(4, m8977n());
        flatBufferBuilder.b(5, b2);
        flatBufferBuilder.b(6, b3);
        flatBufferBuilder.b(7, b4);
        flatBufferBuilder.b(8, b5);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLMailingAddress(Parcel parcel) {
        boolean z = true;
        super(10);
        this.f4415d = (GraphQLStreetAddress) parcel.readValue(GraphQLStreetAddress.class.getClassLoader());
        this.f4416e = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f4422k = parcel.readString();
        this.f4417f = parcel.readString();
        this.f4418g = parcel.readByte() == (byte) 1;
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f4419h = z;
        this.f4420i = parcel.readString();
        this.f4423l = parcel.readString();
        this.f4421j = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeValue(m8973j());
        parcel.writeValue(m8974k());
        parcel.writeString(m8980q());
        parcel.writeString(m8975l());
        parcel.writeByte((byte) (m8976m() ? 1 : 0));
        if (!m8977n()) {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        parcel.writeString(m8978o());
        parcel.writeString(m8981r());
        parcel.writeString(m8979p());
    }
}

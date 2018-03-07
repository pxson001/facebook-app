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
import com.facebook.graphql.deserializers.GraphQLLeadGenInfoFieldDataDeserializer;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputDomain;
import com.facebook.graphql.enums.GraphQLLeadGenInfoFieldInputType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: feed_pymk */
public final class GraphQLLeadGenInfoFieldData extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLLeadGenInfoFieldData> CREATOR = new C04221();
    public List<String> f4369d;
    @Nullable
    public String f4370e;
    public GraphQLLeadGenInfoFieldInputDomain f4371f;
    public GraphQLLeadGenInfoFieldInputType f4372g;
    public boolean f4373h;
    public boolean f4374i;
    public boolean f4375j;
    @Nullable
    public String f4376k;
    @Nullable
    public String f4377l;
    public List<String> f4378m;

    /* compiled from: feed_pymk */
    final class C04221 implements Creator<GraphQLLeadGenInfoFieldData> {
        C04221() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLLeadGenInfoFieldData(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLLeadGenInfoFieldData[i];
        }
    }

    /* compiled from: feed_pymk */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLLeadGenInfoFieldData.class, new Deserializer());
        }

        public Object m8835a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLLeadGenInfoFieldDataDeserializer.m5295a(jsonParser, (short) 169);
            Object graphQLLeadGenInfoFieldData = new GraphQLLeadGenInfoFieldData();
            ((BaseModel) graphQLLeadGenInfoFieldData).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLLeadGenInfoFieldData instanceof Postprocessable) {
                return ((Postprocessable) graphQLLeadGenInfoFieldData).a();
            }
            return graphQLLeadGenInfoFieldData;
        }
    }

    /* compiled from: feed_pymk */
    public final class Serializer extends JsonSerializer<GraphQLLeadGenInfoFieldData> {
        public final void m8836a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLLeadGenInfoFieldData graphQLLeadGenInfoFieldData = (GraphQLLeadGenInfoFieldData) obj;
            GraphQLLeadGenInfoFieldDataDeserializer.m5296a(graphQLLeadGenInfoFieldData.w_(), graphQLLeadGenInfoFieldData.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLLeadGenInfoFieldData.class, new Serializer());
            FbSerializerProvider.a(GraphQLLeadGenInfoFieldData.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<String> m8839a() {
        this.f4369d = super.a(this.f4369d, 0);
        return (ImmutableList) this.f4369d;
    }

    @FieldOffset
    @Nullable
    public final String m8841j() {
        this.f4370e = super.a(this.f4370e, 1);
        return this.f4370e;
    }

    @FieldOffset
    public final GraphQLLeadGenInfoFieldInputDomain m8842k() {
        this.f4371f = (GraphQLLeadGenInfoFieldInputDomain) super.a(this.f4371f, 2, GraphQLLeadGenInfoFieldInputDomain.class, GraphQLLeadGenInfoFieldInputDomain.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4371f;
    }

    @FieldOffset
    public final GraphQLLeadGenInfoFieldInputType m8843l() {
        this.f4372g = (GraphQLLeadGenInfoFieldInputType) super.a(this.f4372g, 3, GraphQLLeadGenInfoFieldInputType.class, GraphQLLeadGenInfoFieldInputType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4372g;
    }

    @FieldOffset
    public final boolean m8844m() {
        a(0, 4);
        return this.f4373h;
    }

    @FieldOffset
    public final boolean m8845n() {
        a(0, 5);
        return this.f4374i;
    }

    @FieldOffset
    public final boolean m8846o() {
        a(0, 6);
        return this.f4375j;
    }

    @FieldOffset
    @Nullable
    public final String m8847p() {
        this.f4376k = super.a(this.f4376k, 7);
        return this.f4376k;
    }

    @FieldOffset
    @Nullable
    public final String m8848q() {
        this.f4377l = super.a(this.f4377l, 8);
        return this.f4377l;
    }

    @FieldOffset
    public final ImmutableList<String> m8849r() {
        this.f4378m = super.a(this.f4378m, 9);
        return (ImmutableList) this.f4378m;
    }

    public final int jK_() {
        return 1236596962;
    }

    public final GraphQLVisitableModel m8838a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLLeadGenInfoFieldData() {
        super(11);
    }

    public final void m8840a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4373h = mutableFlatBuffer.a(i, 4);
        this.f4374i = mutableFlatBuffer.a(i, 5);
        this.f4375j = mutableFlatBuffer.a(i, 6);
    }

    public final int m8837a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        h();
        int c = flatBufferBuilder.c(m8839a());
        int b = flatBufferBuilder.b(m8841j());
        int b2 = flatBufferBuilder.b(m8847p());
        int b3 = flatBufferBuilder.b(m8848q());
        int c2 = flatBufferBuilder.c(m8849r());
        flatBufferBuilder.c(10);
        flatBufferBuilder.b(0, c);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.a(2, m8842k() == GraphQLLeadGenInfoFieldInputDomain.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m8842k());
        if (m8843l() != GraphQLLeadGenInfoFieldInputType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m8843l();
        }
        flatBufferBuilder.a(3, enumR);
        flatBufferBuilder.a(4, m8844m());
        flatBufferBuilder.a(5, m8845n());
        flatBufferBuilder.a(6, m8846o());
        flatBufferBuilder.b(7, b2);
        flatBufferBuilder.b(8, b3);
        flatBufferBuilder.b(9, c2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLLeadGenInfoFieldData(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        super(11);
        this.f4369d = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f4370e = parcel.readString();
        this.f4371f = GraphQLLeadGenInfoFieldInputDomain.fromString(parcel.readString());
        this.f4372g = GraphQLLeadGenInfoFieldInputType.fromString(parcel.readString());
        this.f4373h = parcel.readByte() == (byte) 1;
        if (parcel.readByte() == (byte) 1) {
            z = true;
        } else {
            z = false;
        }
        this.f4374i = z;
        if (parcel.readByte() != (byte) 1) {
            z2 = false;
        }
        this.f4375j = z2;
        this.f4376k = parcel.readString();
        this.f4377l = parcel.readString();
        this.f4378m = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeList(m8839a());
        parcel.writeString(m8841j());
        parcel.writeString(m8842k().name());
        parcel.writeString(m8843l().name());
        parcel.writeByte((byte) (m8844m() ? 1 : 0));
        if (m8845n()) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!m8846o()) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(m8847p());
        parcel.writeString(m8848q());
        parcel.writeList(m8849r());
    }
}

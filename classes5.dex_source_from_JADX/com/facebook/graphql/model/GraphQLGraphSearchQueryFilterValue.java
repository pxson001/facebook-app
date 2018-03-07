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
import com.facebook.graphql.deserializers.GraphQLGraphSearchQueryFilterValueDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
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
/* compiled from: gatekeepers.txt */
public final class GraphQLGraphSearchQueryFilterValue extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGraphSearchQueryFilterValue> CREATOR = new C03781();
    public boolean f4088d;
    @Nullable
    public String f4089e;
    @Nullable
    public String f4090f;
    @Nullable
    public GraphQLNode f4091g;

    /* compiled from: gatekeepers.txt */
    final class C03781 implements Creator<GraphQLGraphSearchQueryFilterValue> {
        C03781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGraphSearchQueryFilterValue(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGraphSearchQueryFilterValue[i];
        }
    }

    /* compiled from: gatekeepers.txt */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchQueryFilterValue.class, new Deserializer());
        }

        public Object m8236a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGraphSearchQueryFilterValueDeserializer.m5098a(jsonParser, (short) 473);
            Object graphQLGraphSearchQueryFilterValue = new GraphQLGraphSearchQueryFilterValue();
            ((BaseModel) graphQLGraphSearchQueryFilterValue).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGraphSearchQueryFilterValue instanceof Postprocessable) {
                return ((Postprocessable) graphQLGraphSearchQueryFilterValue).a();
            }
            return graphQLGraphSearchQueryFilterValue;
        }
    }

    /* compiled from: gatekeepers.txt */
    public final class Serializer extends JsonSerializer<GraphQLGraphSearchQueryFilterValue> {
        public final void m8237a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGraphSearchQueryFilterValue graphQLGraphSearchQueryFilterValue = (GraphQLGraphSearchQueryFilterValue) obj;
            GraphQLGraphSearchQueryFilterValueDeserializer.m5099b(graphQLGraphSearchQueryFilterValue.w_(), graphQLGraphSearchQueryFilterValue.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGraphSearchQueryFilterValue.class, new Serializer());
            FbSerializerProvider.a(GraphQLGraphSearchQueryFilterValue.class, new Serializer());
        }
    }

    @FieldOffset
    public final boolean m8241a() {
        a(0, 0);
        return this.f4088d;
    }

    @FieldOffset
    @Nullable
    public final String m8242j() {
        this.f4089e = super.a(this.f4089e, 1);
        return this.f4089e;
    }

    @FieldOffset
    @Nullable
    public final String m8243k() {
        this.f4090f = super.a(this.f4090f, 2);
        return this.f4090f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLNode m8244l() {
        this.f4091g = (GraphQLNode) super.a(this.f4091g, 3, GraphQLNode.class);
        return this.f4091g;
    }

    public final int jK_() {
        return -2134006905;
    }

    public final GraphQLVisitableModel m8239a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8244l() != null) {
            GraphQLNode graphQLNode = (GraphQLNode) graphQLModelMutatingVisitor.b(m8244l());
            if (m8244l() != graphQLNode) {
                graphQLVisitableModel = (GraphQLGraphSearchQueryFilterValue) ModelHelper.a(null, this);
                graphQLVisitableModel.f4091g = graphQLNode;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGraphSearchQueryFilterValue() {
        super(5);
    }

    public final void m8240a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4088d = mutableFlatBuffer.a(i, 0);
    }

    public final int m8238a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m8242j());
        int b2 = flatBufferBuilder.b(m8243k());
        int a = ModelHelper.a(flatBufferBuilder, m8244l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.a(0, m8241a());
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        flatBufferBuilder.b(3, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGraphSearchQueryFilterValue(Parcel parcel) {
        boolean z = true;
        super(5);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f4088d = z;
        this.f4089e = parcel.readString();
        this.f4090f = parcel.readString();
        this.f4091g = (GraphQLNode) parcel.readValue(GraphQLNode.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m8241a() ? 1 : 0));
        parcel.writeString(m8242j());
        parcel.writeString(m8243k());
        parcel.writeValue(m8244l());
    }
}

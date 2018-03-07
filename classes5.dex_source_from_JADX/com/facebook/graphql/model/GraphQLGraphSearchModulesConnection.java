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
import com.facebook.graphql.deserializers.GraphQLGraphSearchModulesConnectionDeserializer;
import com.facebook.graphql.enums.GraphQLGraphSearchSpellerConfidence;
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
/* compiled from: getCountLocked */
public final class GraphQLGraphSearchModulesConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGraphSearchModulesConnection> CREATOR = new C03731();
    @Nullable
    GraphQLGraphSearchQuery f4050d;
    int f4051e;
    boolean f4052f;
    @Nullable
    GraphQLPageInfo f4053g;
    @Nullable
    String f4054h;
    GraphQLGraphSearchSpellerConfidence f4055i;
    @Nullable
    String f4056j;

    /* compiled from: getCountLocked */
    final class C03731 implements Creator<GraphQLGraphSearchModulesConnection> {
        C03731() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGraphSearchModulesConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGraphSearchModulesConnection[i];
        }
    }

    /* compiled from: getCountLocked */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchModulesConnection.class, new Deserializer());
        }

        public Object m8157a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGraphSearchModulesConnectionDeserializer.m5081a(jsonParser, (short) 476);
            Object graphQLGraphSearchModulesConnection = new GraphQLGraphSearchModulesConnection();
            ((BaseModel) graphQLGraphSearchModulesConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGraphSearchModulesConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLGraphSearchModulesConnection).a();
            }
            return graphQLGraphSearchModulesConnection;
        }
    }

    /* compiled from: getCountLocked */
    public final class Serializer extends JsonSerializer<GraphQLGraphSearchModulesConnection> {
        public final void m8158a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGraphSearchModulesConnection graphQLGraphSearchModulesConnection = (GraphQLGraphSearchModulesConnection) obj;
            GraphQLGraphSearchModulesConnectionDeserializer.m5082a(graphQLGraphSearchModulesConnection.w_(), graphQLGraphSearchModulesConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGraphSearchModulesConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLGraphSearchModulesConnection.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchQuery m8160a() {
        this.f4050d = (GraphQLGraphSearchQuery) super.a(this.f4050d, 0, GraphQLGraphSearchQuery.class);
        return this.f4050d;
    }

    @FieldOffset
    public final int m8163j() {
        a(0, 1);
        return this.f4051e;
    }

    @FieldOffset
    public final boolean m8164k() {
        a(0, 2);
        return this.f4052f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPageInfo m8165l() {
        this.f4053g = (GraphQLPageInfo) super.a(this.f4053g, 3, GraphQLPageInfo.class);
        return this.f4053g;
    }

    @FieldOffset
    @Nullable
    public final String m8166m() {
        this.f4054h = super.a(this.f4054h, 4);
        return this.f4054h;
    }

    @FieldOffset
    public final GraphQLGraphSearchSpellerConfidence m8167n() {
        this.f4055i = (GraphQLGraphSearchSpellerConfidence) super.a(this.f4055i, 5, GraphQLGraphSearchSpellerConfidence.class, GraphQLGraphSearchSpellerConfidence.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4055i;
    }

    @FieldOffset
    @Nullable
    public final String m8168o() {
        this.f4056j = super.a(this.f4056j, 6);
        return this.f4056j;
    }

    public final int jK_() {
        return -481462289;
    }

    public final GraphQLVisitableModel m8161a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8160a() != null) {
            GraphQLGraphSearchQuery graphQLGraphSearchQuery = (GraphQLGraphSearchQuery) graphQLModelMutatingVisitor.b(m8160a());
            if (m8160a() != graphQLGraphSearchQuery) {
                graphQLVisitableModel = (GraphQLGraphSearchModulesConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f4050d = graphQLGraphSearchQuery;
            }
        }
        if (m8165l() != null) {
            GraphQLPageInfo graphQLPageInfo = (GraphQLPageInfo) graphQLModelMutatingVisitor.b(m8165l());
            if (m8165l() != graphQLPageInfo) {
                graphQLVisitableModel = (GraphQLGraphSearchModulesConnection) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4053g = graphQLPageInfo;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGraphSearchModulesConnection() {
        super(8);
    }

    public final void m8162a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4051e = mutableFlatBuffer.a(i, 1, 0);
        this.f4052f = mutableFlatBuffer.a(i, 2);
    }

    public final int m8159a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8160a());
        int a2 = ModelHelper.a(flatBufferBuilder, m8165l());
        int b = flatBufferBuilder.b(m8166m());
        int b2 = flatBufferBuilder.b(m8168o());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, m8163j(), 0);
        flatBufferBuilder.a(2, m8164k());
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.b(4, b);
        flatBufferBuilder.a(5, m8167n() == GraphQLGraphSearchSpellerConfidence.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m8167n());
        flatBufferBuilder.b(6, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGraphSearchModulesConnection(Parcel parcel) {
        super(8);
        this.f4050d = (GraphQLGraphSearchQuery) parcel.readValue(GraphQLGraphSearchQuery.class.getClassLoader());
        this.f4051e = parcel.readInt();
        this.f4052f = parcel.readByte() == (byte) 1;
        this.f4053g = (GraphQLPageInfo) parcel.readValue(GraphQLPageInfo.class.getClassLoader());
        this.f4054h = parcel.readString();
        this.f4055i = GraphQLGraphSearchSpellerConfidence.fromString(parcel.readString());
        this.f4056j = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8160a());
        parcel.writeInt(m8163j());
        parcel.writeByte((byte) (m8164k() ? 1 : 0));
        parcel.writeValue(m8165l());
        parcel.writeString(m8166m());
        parcel.writeString(m8167n().name());
        parcel.writeString(m8168o());
    }
}

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
import com.facebook.graphql.deserializers.GraphQLContactPointDeserializer;
import com.facebook.graphql.enums.GraphQLObjectType;
import com.facebook.graphql.modelutil.BaseModel;
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
/* compiled from: isFriend */
public final class GraphQLContactPoint extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLContactPoint> CREATOR = new C02891();
    @Nullable
    public GraphQLObjectType f3498d;
    @Nullable
    public String f3499e;
    @Nullable
    public String f3500f;

    /* compiled from: isFriend */
    final class C02891 implements Creator<GraphQLContactPoint> {
        C02891() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLContactPoint(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLContactPoint[i];
        }
    }

    /* compiled from: isFriend */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLContactPoint.class, new Deserializer());
        }

        public Object m6864a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLContactPointDeserializer.m4681a(jsonParser, (short) 572);
            Object graphQLContactPoint = new GraphQLContactPoint();
            ((BaseModel) graphQLContactPoint).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLContactPoint instanceof Postprocessable) {
                return ((Postprocessable) graphQLContactPoint).a();
            }
            return graphQLContactPoint;
        }
    }

    /* compiled from: isFriend */
    public final class Serializer extends JsonSerializer<GraphQLContactPoint> {
        public final void m6865a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLContactPoint graphQLContactPoint = (GraphQLContactPoint) obj;
            GraphQLContactPointDeserializer.m4682a(graphQLContactPoint.w_(), graphQLContactPoint.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLContactPoint.class, new Serializer());
            FbSerializerProvider.a(GraphQLContactPoint.class, new Serializer());
        }
    }

    @Nullable
    public final GraphQLObjectType m6869j() {
        if (this.b != null && this.f3498d == null) {
            this.f3498d = new GraphQLObjectType(this.b.b(this.c, 0));
        }
        if (this.f3498d == null || this.f3498d.g() != 0) {
            return this.f3498d;
        }
        return null;
    }

    @FieldOffset
    @Nullable
    public final String m6870k() {
        this.f3499e = super.a(this.f3499e, 1);
        return this.f3499e;
    }

    @FieldOffset
    @Nullable
    public final String m6871l() {
        this.f3500f = super.a(this.f3500f, 2);
        return this.f3500f;
    }

    @Nullable
    public final String m6868a() {
        return m6871l();
    }

    public final int jK_() {
        return 1428236656;
    }

    public final GraphQLVisitableModel m6867a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLContactPoint() {
        super(4);
    }

    public final int m6866a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = flatBufferBuilder.a(m6869j() != null ? m6869j().e() : null);
        int b = flatBufferBuilder.b(m6870k());
        int b2 = flatBufferBuilder.b(m6871l());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLContactPoint(Parcel parcel) {
        super(4);
        this.f3499e = parcel.readString();
        this.f3500f = parcel.readString();
        this.f3498d = (GraphQLObjectType) ParcelUtil.m3828b(parcel, GraphQLObjectType.class);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m6870k());
        parcel.writeString(m6871l());
        parcel.writeParcelable(this.f3498d, i);
    }
}

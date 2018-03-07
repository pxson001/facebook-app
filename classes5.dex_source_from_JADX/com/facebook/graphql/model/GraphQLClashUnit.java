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
import com.facebook.graphql.deserializers.GraphQLClashUnitDeserializer;
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
/* compiled from: is_custom_type */
public final class GraphQLClashUnit extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLClashUnit> CREATOR = new C02831();
    @Nullable
    public String f3434d;
    @Nullable
    public String f3435e;
    public int f3436f;
    @Nullable
    public String f3437g;

    /* compiled from: is_custom_type */
    final class C02831 implements Creator<GraphQLClashUnit> {
        C02831() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLClashUnit(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLClashUnit[i];
        }
    }

    /* compiled from: is_custom_type */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLClashUnit.class, new Deserializer());
        }

        public Object m6760a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLClashUnitDeserializer.m4649a(jsonParser, (short) 583);
            Object graphQLClashUnit = new GraphQLClashUnit();
            ((BaseModel) graphQLClashUnit).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLClashUnit instanceof Postprocessable) {
                return ((Postprocessable) graphQLClashUnit).a();
            }
            return graphQLClashUnit;
        }
    }

    /* compiled from: is_custom_type */
    public final class Serializer extends JsonSerializer<GraphQLClashUnit> {
        public final void m6761a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLClashUnit graphQLClashUnit = (GraphQLClashUnit) obj;
            GraphQLClashUnitDeserializer.m4650a(graphQLClashUnit.w_(), graphQLClashUnit.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLClashUnit.class, new Serializer());
            FbSerializerProvider.a(GraphQLClashUnit.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m6766j() {
        this.f3434d = super.a(this.f3434d, 0);
        return this.f3434d;
    }

    @FieldOffset
    @Nullable
    public final String m6767k() {
        this.f3435e = super.a(this.f3435e, 1);
        return this.f3435e;
    }

    @FieldOffset
    public final int m6768l() {
        a(0, 2);
        return this.f3436f;
    }

    @FieldOffset
    @Nullable
    public final String m6769m() {
        this.f3437g = super.a(this.f3437g, 3);
        return this.f3437g;
    }

    @Nullable
    public final String m6764a() {
        return m6766j();
    }

    public final int jK_() {
        return 1984141425;
    }

    public final GraphQLVisitableModel m6763a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLClashUnit() {
        super(5);
    }

    public final void m6765a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3436f = mutableFlatBuffer.a(i, 2, 0);
    }

    public final int m6762a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m6766j());
        int b2 = flatBufferBuilder.b(m6767k());
        int b3 = flatBufferBuilder.b(m6769m());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.a(2, m6768l(), 0);
        flatBufferBuilder.b(3, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLClashUnit(Parcel parcel) {
        super(5);
        this.f3434d = parcel.readString();
        this.f3435e = parcel.readString();
        this.f3436f = parcel.readInt();
        this.f3437g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m6766j());
        parcel.writeString(m6767k());
        parcel.writeInt(m6768l());
        parcel.writeString(m6769m());
    }
}

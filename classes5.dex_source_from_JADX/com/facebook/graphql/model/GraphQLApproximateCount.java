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
import com.facebook.graphql.deserializers.GraphQLApproximateCountDeserializer;
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
/* compiled from: is_throwback_post */
public final class GraphQLApproximateCount extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLApproximateCount> CREATOR = new C02731();
    public int f3388d;
    public boolean f3389e;

    /* compiled from: is_throwback_post */
    final class C02731 implements Creator<GraphQLApproximateCount> {
        C02731() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLApproximateCount(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLApproximateCount[i];
        }
    }

    /* compiled from: is_throwback_post */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLApproximateCount.class, new Deserializer());
        }

        public Object m6590a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLApproximateCountDeserializer.m4583a(jsonParser, (short) 297);
            Object graphQLApproximateCount = new GraphQLApproximateCount();
            ((BaseModel) graphQLApproximateCount).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLApproximateCount instanceof Postprocessable) {
                return ((Postprocessable) graphQLApproximateCount).a();
            }
            return graphQLApproximateCount;
        }
    }

    /* compiled from: is_throwback_post */
    public final class Serializer extends JsonSerializer<GraphQLApproximateCount> {
        public final void m6591a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLApproximateCount graphQLApproximateCount = (GraphQLApproximateCount) obj;
            GraphQLApproximateCountDeserializer.m4584a(graphQLApproximateCount.w_(), graphQLApproximateCount.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLApproximateCount.class, new Serializer());
            FbSerializerProvider.a(GraphQLApproximateCount.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m6592a() {
        a(0, 0);
        return this.f3388d;
    }

    @FieldOffset
    public final boolean m6596j() {
        a(0, 1);
        return this.f3389e;
    }

    public final int jK_() {
        return 382256763;
    }

    public final GraphQLVisitableModel m6594a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLApproximateCount() {
        super(3);
    }

    public final void m6595a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3388d = mutableFlatBuffer.a(i, 0, 0);
        this.f3389e = mutableFlatBuffer.a(i, 1);
    }

    public final int m6593a(FlatBufferBuilder flatBufferBuilder) {
        h();
        flatBufferBuilder.c(2);
        flatBufferBuilder.a(0, m6592a(), 0);
        flatBufferBuilder.a(1, m6596j());
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLApproximateCount(Parcel parcel) {
        boolean z = true;
        super(3);
        this.f3388d = parcel.readInt();
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f3389e = z;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m6592a());
        parcel.writeByte((byte) (m6596j() ? 1 : 0));
    }
}

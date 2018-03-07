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
import com.facebook.graphql.deserializers.GraphQLNmorTwoCTwoPCashResponseDeserializer;
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
/* compiled from: event_user_location_shares_start_interval */
public final class GraphQLNmorTwoCTwoPCashResponse extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLNmorTwoCTwoPCashResponse> CREATOR = new C04461();
    @Nullable
    public String f4560d;
    @Nullable
    public String f4561e;
    @Nullable
    public String f4562f;

    /* compiled from: event_user_location_shares_start_interval */
    final class C04461 implements Creator<GraphQLNmorTwoCTwoPCashResponse> {
        C04461() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLNmorTwoCTwoPCashResponse(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLNmorTwoCTwoPCashResponse[i];
        }
    }

    /* compiled from: event_user_location_shares_start_interval */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLNmorTwoCTwoPCashResponse.class, new Deserializer());
        }

        public Object m9264a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLNmorTwoCTwoPCashResponseDeserializer.m5428a(jsonParser, (short) 565);
            Object graphQLNmorTwoCTwoPCashResponse = new GraphQLNmorTwoCTwoPCashResponse();
            ((BaseModel) graphQLNmorTwoCTwoPCashResponse).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLNmorTwoCTwoPCashResponse instanceof Postprocessable) {
                return ((Postprocessable) graphQLNmorTwoCTwoPCashResponse).a();
            }
            return graphQLNmorTwoCTwoPCashResponse;
        }
    }

    /* compiled from: event_user_location_shares_start_interval */
    public final class Serializer extends JsonSerializer<GraphQLNmorTwoCTwoPCashResponse> {
        public final void m9265a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLNmorTwoCTwoPCashResponse graphQLNmorTwoCTwoPCashResponse = (GraphQLNmorTwoCTwoPCashResponse) obj;
            GraphQLNmorTwoCTwoPCashResponseDeserializer.m5429a(graphQLNmorTwoCTwoPCashResponse.w_(), graphQLNmorTwoCTwoPCashResponse.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLNmorTwoCTwoPCashResponse.class, new Serializer());
            FbSerializerProvider.a(GraphQLNmorTwoCTwoPCashResponse.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m9269j() {
        this.f4560d = super.a(this.f4560d, 0);
        return this.f4560d;
    }

    @FieldOffset
    @Nullable
    public final String m9270k() {
        this.f4561e = super.a(this.f4561e, 1);
        return this.f4561e;
    }

    @FieldOffset
    @Nullable
    public final String m9271l() {
        this.f4562f = super.a(this.f4562f, 2);
        return this.f4562f;
    }

    @Nullable
    public final String m9268a() {
        return m9269j();
    }

    public final int jK_() {
        return -634454287;
    }

    public final GraphQLVisitableModel m9267a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLNmorTwoCTwoPCashResponse() {
        super(4);
    }

    public final int m9266a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m9269j());
        int b2 = flatBufferBuilder.b(m9270k());
        int b3 = flatBufferBuilder.b(m9271l());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLNmorTwoCTwoPCashResponse(Parcel parcel) {
        super(4);
        this.f4560d = parcel.readString();
        this.f4561e = parcel.readString();
        this.f4562f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m9269j());
        parcel.writeString(m9270k());
        parcel.writeString(m9271l());
    }
}

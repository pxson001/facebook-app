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
import com.facebook.graphql.deserializers.GraphQLErrorDeserializer;
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
/* compiled from: limited */
public final class GraphQLError extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLError> CREATOR = new C03041();
    public int f3552d;
    @Nullable
    public String f3553e;
    @Nullable
    public String f3554f;

    /* compiled from: limited */
    final class C03041 implements Creator<GraphQLError> {
        C03041() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLError(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLError[i];
        }
    }

    /* compiled from: limited */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLError.class, new Deserializer());
        }

        public Object m7104a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLErrorDeserializer.m4771a(jsonParser, (short) 281);
            Object graphQLError = new GraphQLError();
            ((BaseModel) graphQLError).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLError instanceof Postprocessable) {
                return ((Postprocessable) graphQLError).a();
            }
            return graphQLError;
        }
    }

    /* compiled from: limited */
    public final class Serializer extends JsonSerializer<GraphQLError> {
        public final void m7105a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLError graphQLError = (GraphQLError) obj;
            GraphQLErrorDeserializer.m4772a(graphQLError.w_(), graphQLError.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLError.class, new Serializer());
            FbSerializerProvider.a(GraphQLError.class, new Serializer());
        }
    }

    @FieldOffset
    public final int m7106a() {
        a(0, 0);
        return this.f3552d;
    }

    @FieldOffset
    @Nullable
    public final String m7110j() {
        this.f3553e = super.a(this.f3553e, 1);
        return this.f3553e;
    }

    @FieldOffset
    @Nullable
    public final String m7111k() {
        this.f3554f = super.a(this.f3554f, 2);
        return this.f3554f;
    }

    public final int jK_() {
        return 67232232;
    }

    public final GraphQLVisitableModel m7108a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLError() {
        super(4);
    }

    public final void m7109a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3552d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m7107a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m7110j());
        int b2 = flatBufferBuilder.b(m7111k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.a(0, m7106a(), 0);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLError(Parcel parcel) {
        super(4);
        this.f3552d = parcel.readInt();
        this.f3553e = parcel.readString();
        this.f3554f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(m7106a());
        parcel.writeString(m7110j());
        parcel.writeString(m7111k());
    }
}

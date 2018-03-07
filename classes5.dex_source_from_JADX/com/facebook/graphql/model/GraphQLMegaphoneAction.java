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
import com.facebook.graphql.deserializers.GraphQLMegaphoneActionDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.common.base.Preconditions;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: failed_resolution */
public final class GraphQLMegaphoneAction extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLMegaphoneAction> CREATOR = new C04351();
    @Nullable
    public String f4506d;
    @Nullable
    public String f4507e;
    @Nullable
    public String f4508f;

    /* compiled from: failed_resolution */
    final class C04351 implements Creator<GraphQLMegaphoneAction> {
        C04351() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLMegaphoneAction(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLMegaphoneAction[i];
        }
    }

    /* compiled from: failed_resolution */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public String f4503d;
        @Nullable
        public String f4504e;
        @Nullable
        public String f4505f;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }

        public final Builder m9089a(@Nullable String str) {
            this.f4504e = str;
            return this;
        }

        public final Builder m9091b(@Nullable String str) {
            this.f4505f = str;
            return this;
        }

        public final GraphQLMegaphoneAction m9090a() {
            return new GraphQLMegaphoneAction(this);
        }
    }

    /* compiled from: failed_resolution */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLMegaphoneAction.class, new Deserializer());
        }

        public Object m9092a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLMegaphoneActionDeserializer.m5362a(jsonParser, (short) 422);
            Object graphQLMegaphoneAction = new GraphQLMegaphoneAction();
            ((BaseModel) graphQLMegaphoneAction).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLMegaphoneAction instanceof Postprocessable) {
                return ((Postprocessable) graphQLMegaphoneAction).a();
            }
            return graphQLMegaphoneAction;
        }
    }

    /* compiled from: failed_resolution */
    public final class Serializer extends JsonSerializer<GraphQLMegaphoneAction> {
        public final void m9093a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLMegaphoneAction graphQLMegaphoneAction = (GraphQLMegaphoneAction) obj;
            GraphQLMegaphoneActionDeserializer.m5363a(graphQLMegaphoneAction.w_(), graphQLMegaphoneAction.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLMegaphoneAction.class, new Serializer());
            FbSerializerProvider.a(GraphQLMegaphoneAction.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m9096a() {
        this.f4506d = super.a(this.f4506d, 0);
        return this.f4506d;
    }

    @FieldOffset
    @Nullable
    public final String m9097j() {
        this.f4507e = super.a(this.f4507e, 1);
        return this.f4507e;
    }

    @FieldOffset
    @Nullable
    public final String m9098k() {
        this.f4508f = super.a(this.f4508f, 2);
        return this.f4508f;
    }

    public final int jK_() {
        return -1505614478;
    }

    public final GraphQLVisitableModel m9095a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLMegaphoneAction() {
        super(4);
    }

    public final int m9094a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m9096a());
        int b2 = flatBufferBuilder.b(m9097j());
        int b3 = flatBufferBuilder.b(m9098k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, b2);
        flatBufferBuilder.b(2, b3);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLMegaphoneAction(Parcel parcel) {
        super(4);
        this.f4506d = parcel.readString();
        this.f4507e = parcel.readString();
        this.f4508f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m9096a());
        parcel.writeString(m9097j());
        parcel.writeString(m9098k());
    }

    public GraphQLMegaphoneAction(Builder builder) {
        super(4);
        this.b = builder.a;
        this.c = builder.b;
        this.f4506d = builder.f4503d;
        this.f4507e = builder.f4504e;
        this.f4508f = builder.f4505f;
    }
}

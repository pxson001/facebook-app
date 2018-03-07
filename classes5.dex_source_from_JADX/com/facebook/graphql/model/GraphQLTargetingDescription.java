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
import com.facebook.graphql.deserializers.GraphQLTargetingDescriptionDeserializer;
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
/* compiled from: UNOWNED_PLACE_PHOTO_VOTING */
public final class GraphQLTargetingDescription extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTargetingDescription> CREATOR = new C12501();
    @Nullable
    public String f13283d;

    /* compiled from: UNOWNED_PLACE_PHOTO_VOTING */
    final class C12501 implements Creator<GraphQLTargetingDescription> {
        C12501() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTargetingDescription(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTargetingDescription[i];
        }
    }

    /* compiled from: UNOWNED_PLACE_PHOTO_VOTING */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLTargetingDescription.class, new Deserializer());
        }

        public Object m22085a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLTargetingDescriptionDeserializer.m6048a(jsonParser, (short) 260);
            Object graphQLTargetingDescription = new GraphQLTargetingDescription();
            ((BaseModel) graphQLTargetingDescription).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLTargetingDescription instanceof Postprocessable) {
                return ((Postprocessable) graphQLTargetingDescription).a();
            }
            return graphQLTargetingDescription;
        }
    }

    /* compiled from: UNOWNED_PLACE_PHOTO_VOTING */
    public final class Serializer extends JsonSerializer<GraphQLTargetingDescription> {
        public final void m22086a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLTargetingDescription graphQLTargetingDescription = (GraphQLTargetingDescription) obj;
            GraphQLTargetingDescriptionDeserializer.m6049a(graphQLTargetingDescription.w_(), graphQLTargetingDescription.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLTargetingDescription.class, new Serializer());
            FbSerializerProvider.a(GraphQLTargetingDescription.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m22089a() {
        this.f13283d = super.a(this.f13283d, 0);
        return this.f13283d;
    }

    public final int jK_() {
        return -682735957;
    }

    public final GraphQLVisitableModel m22088a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLTargetingDescription() {
        super(2);
    }

    public final int m22087a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m22089a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTargetingDescription(Parcel parcel) {
        super(2);
        this.f13283d = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m22089a());
    }
}

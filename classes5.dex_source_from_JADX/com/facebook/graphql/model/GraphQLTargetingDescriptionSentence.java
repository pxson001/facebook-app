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
import com.facebook.graphql.deserializers.GraphQLTargetingDescriptionSentenceDeserializer;
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
/* compiled from: UNOWNED_PLACE_PHOTO_VOTE_MODULE */
public final class GraphQLTargetingDescriptionSentence extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTargetingDescriptionSentence> CREATOR = new C12511();
    @Nullable
    public String f13284d;

    /* compiled from: UNOWNED_PLACE_PHOTO_VOTE_MODULE */
    final class C12511 implements Creator<GraphQLTargetingDescriptionSentence> {
        C12511() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLTargetingDescriptionSentence(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLTargetingDescriptionSentence[i];
        }
    }

    /* compiled from: UNOWNED_PLACE_PHOTO_VOTE_MODULE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLTargetingDescriptionSentence.class, new Deserializer());
        }

        public Object m22091a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLTargetingDescriptionSentenceDeserializer.m6051a(jsonParser, (short) 261);
            Object graphQLTargetingDescriptionSentence = new GraphQLTargetingDescriptionSentence();
            ((BaseModel) graphQLTargetingDescriptionSentence).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLTargetingDescriptionSentence instanceof Postprocessable) {
                return ((Postprocessable) graphQLTargetingDescriptionSentence).a();
            }
            return graphQLTargetingDescriptionSentence;
        }
    }

    /* compiled from: UNOWNED_PLACE_PHOTO_VOTE_MODULE */
    public final class Serializer extends JsonSerializer<GraphQLTargetingDescriptionSentence> {
        public final void m22092a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLTargetingDescriptionSentence graphQLTargetingDescriptionSentence = (GraphQLTargetingDescriptionSentence) obj;
            GraphQLTargetingDescriptionSentenceDeserializer.m6052a(graphQLTargetingDescriptionSentence.w_(), graphQLTargetingDescriptionSentence.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLTargetingDescriptionSentence.class, new Serializer());
            FbSerializerProvider.a(GraphQLTargetingDescriptionSentence.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m22095a() {
        this.f13284d = super.a(this.f13284d, 0);
        return this.f13284d;
    }

    public final int jK_() {
        return -1199790546;
    }

    public final GraphQLVisitableModel m22094a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLTargetingDescriptionSentence() {
        super(2);
    }

    public final int m22093a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m22095a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLTargetingDescriptionSentence(Parcel parcel) {
        super(2);
        this.f13284d = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m22095a());
    }
}

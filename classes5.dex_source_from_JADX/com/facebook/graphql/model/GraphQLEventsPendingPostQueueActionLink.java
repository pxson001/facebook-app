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
import com.facebook.graphql.deserializers.GraphQLEventsPendingPostQueueActionLinkDeserializer;
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
/* compiled from: imageHigh */
public final class GraphQLEventsPendingPostQueueActionLink extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEventsPendingPostQueueActionLink> CREATOR = new C03191();
    @Nullable
    GraphQLEvent f3685d;
    @Nullable
    String f3686e;
    @Nullable
    String f3687f;

    /* compiled from: imageHigh */
    final class C03191 implements Creator<GraphQLEventsPendingPostQueueActionLink> {
        C03191() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEventsPendingPostQueueActionLink(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEventsPendingPostQueueActionLink[i];
        }
    }

    /* compiled from: imageHigh */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEventsPendingPostQueueActionLink.class, new Deserializer());
        }

        public Object m7359a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEventsPendingPostQueueActionLinkDeserializer.m4859a(jsonParser, (short) 177);
            Object graphQLEventsPendingPostQueueActionLink = new GraphQLEventsPendingPostQueueActionLink();
            ((BaseModel) graphQLEventsPendingPostQueueActionLink).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEventsPendingPostQueueActionLink instanceof Postprocessable) {
                return ((Postprocessable) graphQLEventsPendingPostQueueActionLink).a();
            }
            return graphQLEventsPendingPostQueueActionLink;
        }
    }

    /* compiled from: imageHigh */
    public final class Serializer extends JsonSerializer<GraphQLEventsPendingPostQueueActionLink> {
        public final void m7360a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEventsPendingPostQueueActionLink graphQLEventsPendingPostQueueActionLink = (GraphQLEventsPendingPostQueueActionLink) obj;
            GraphQLEventsPendingPostQueueActionLinkDeserializer.m4860a(graphQLEventsPendingPostQueueActionLink.w_(), graphQLEventsPendingPostQueueActionLink.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEventsPendingPostQueueActionLink.class, new Serializer());
            FbSerializerProvider.a(GraphQLEventsPendingPostQueueActionLink.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLEvent m7362a() {
        this.f3685d = (GraphQLEvent) super.a(this.f3685d, 0, GraphQLEvent.class);
        return this.f3685d;
    }

    @FieldOffset
    @Nullable
    public final String m7364j() {
        this.f3686e = super.a(this.f3686e, 1);
        return this.f3686e;
    }

    @FieldOffset
    @Nullable
    public final String m7365k() {
        this.f3687f = super.a(this.f3687f, 2);
        return this.f3687f;
    }

    public final int jK_() {
        return -543954045;
    }

    public final GraphQLVisitableModel m7363a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7362a() != null) {
            GraphQLEvent graphQLEvent = (GraphQLEvent) graphQLModelMutatingVisitor.b(m7362a());
            if (m7362a() != graphQLEvent) {
                graphQLVisitableModel = (GraphQLEventsPendingPostQueueActionLink) ModelHelper.a(null, this);
                graphQLVisitableModel.f3685d = graphQLEvent;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventsPendingPostQueueActionLink() {
        super(4);
    }

    public final int m7361a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7362a());
        int b = flatBufferBuilder.b(m7364j());
        int b2 = flatBufferBuilder.b(m7365k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventsPendingPostQueueActionLink(Parcel parcel) {
        super(4);
        this.f3685d = (GraphQLEvent) parcel.readValue(GraphQLEvent.class.getClassLoader());
        this.f3686e = parcel.readString();
        this.f3687f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7362a());
        parcel.writeString(m7364j());
        parcel.writeString(m7365k());
    }
}

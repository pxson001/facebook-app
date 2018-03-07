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
import com.facebook.graphql.deserializers.GraphQLOverlayActionLinkDeserializer;
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
/* compiled from: eventChainingTitle */
public final class GraphQLOverlayActionLink extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLOverlayActionLink> CREATOR = new C04551();
    @Nullable
    GraphQLTextWithEntities f4670d;
    @Nullable
    GraphQLOverlayCallToActionInfo f4671e;
    @Nullable
    String f4672f;
    @Nullable
    String f4673g;

    /* compiled from: eventChainingTitle */
    final class C04551 implements Creator<GraphQLOverlayActionLink> {
        C04551() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLOverlayActionLink(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLOverlayActionLink[i];
        }
    }

    /* compiled from: eventChainingTitle */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLOverlayActionLink.class, new Deserializer());
        }

        public Object m9412a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLOverlayActionLinkDeserializer.m5471a(jsonParser, (short) 180);
            Object graphQLOverlayActionLink = new GraphQLOverlayActionLink();
            ((BaseModel) graphQLOverlayActionLink).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLOverlayActionLink instanceof Postprocessable) {
                return ((Postprocessable) graphQLOverlayActionLink).a();
            }
            return graphQLOverlayActionLink;
        }
    }

    /* compiled from: eventChainingTitle */
    public final class Serializer extends JsonSerializer<GraphQLOverlayActionLink> {
        public final void m9413a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLOverlayActionLink graphQLOverlayActionLink = (GraphQLOverlayActionLink) obj;
            GraphQLOverlayActionLinkDeserializer.m5472a(graphQLOverlayActionLink.w_(), graphQLOverlayActionLink.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLOverlayActionLink.class, new Serializer());
            FbSerializerProvider.a(GraphQLOverlayActionLink.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m9415a() {
        this.f4670d = (GraphQLTextWithEntities) super.a(this.f4670d, 0, GraphQLTextWithEntities.class);
        return this.f4670d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLOverlayCallToActionInfo m9417j() {
        this.f4671e = (GraphQLOverlayCallToActionInfo) super.a(this.f4671e, 1, GraphQLOverlayCallToActionInfo.class);
        return this.f4671e;
    }

    @FieldOffset
    @Nullable
    public final String m9418k() {
        this.f4672f = super.a(this.f4672f, 2);
        return this.f4672f;
    }

    @FieldOffset
    @Nullable
    public final String m9419l() {
        this.f4673g = super.a(this.f4673g, 3);
        return this.f4673g;
    }

    public final int jK_() {
        return -1260727392;
    }

    public final GraphQLVisitableModel m9416a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m9415a() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m9415a());
            if (m9415a() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLOverlayActionLink) ModelHelper.a(null, this);
                graphQLVisitableModel.f4670d = graphQLTextWithEntities;
            }
        }
        if (m9417j() != null) {
            GraphQLOverlayCallToActionInfo graphQLOverlayCallToActionInfo = (GraphQLOverlayCallToActionInfo) graphQLModelMutatingVisitor.b(m9417j());
            if (m9417j() != graphQLOverlayCallToActionInfo) {
                graphQLVisitableModel = (GraphQLOverlayActionLink) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4671e = graphQLOverlayCallToActionInfo;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLOverlayActionLink() {
        super(5);
    }

    public final int m9414a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m9415a());
        int a2 = ModelHelper.a(flatBufferBuilder, m9417j());
        int b = flatBufferBuilder.b(m9418k());
        int b2 = flatBufferBuilder.b(m9419l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLOverlayActionLink(Parcel parcel) {
        super(5);
        this.f4670d = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4671e = (GraphQLOverlayCallToActionInfo) parcel.readValue(GraphQLOverlayCallToActionInfo.class.getClassLoader());
        this.f4672f = parcel.readString();
        this.f4673g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m9415a());
        parcel.writeValue(m9417j());
        parcel.writeString(m9418k());
        parcel.writeString(m9419l());
    }
}

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
import com.facebook.graphql.deserializers.GraphQLVideoChannelFeedEdgeDeserializer;
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
/* compiled from: ThumbnailWidth */
public final class GraphQLVideoChannelFeedEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLVideoChannelFeedEdge> CREATOR = new C12711();
    @Nullable
    public FeedUnit f13446d;

    /* compiled from: ThumbnailWidth */
    final class C12711 implements Creator<GraphQLVideoChannelFeedEdge> {
        C12711() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLVideoChannelFeedEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLVideoChannelFeedEdge[i];
        }
    }

    /* compiled from: ThumbnailWidth */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLVideoChannelFeedEdge.class, new Deserializer());
        }

        public Object m22438a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLVideoChannelFeedEdgeDeserializer.m6180a(jsonParser, (short) 501);
            Object graphQLVideoChannelFeedEdge = new GraphQLVideoChannelFeedEdge();
            ((BaseModel) graphQLVideoChannelFeedEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLVideoChannelFeedEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLVideoChannelFeedEdge).a();
            }
            return graphQLVideoChannelFeedEdge;
        }
    }

    /* compiled from: ThumbnailWidth */
    public final class Serializer extends JsonSerializer<GraphQLVideoChannelFeedEdge> {
        public final void m22439a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLVideoChannelFeedEdge graphQLVideoChannelFeedEdge = (GraphQLVideoChannelFeedEdge) obj;
            GraphQLVideoChannelFeedEdgeDeserializer.m6183b(graphQLVideoChannelFeedEdge.w_(), graphQLVideoChannelFeedEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLVideoChannelFeedEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLVideoChannelFeedEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final FeedUnit m22441a() {
        this.f13446d = (FeedUnit) super.a(this.f13446d, 0, VirtualFlattenableResolverImpl.a);
        return this.f13446d;
    }

    public final int jK_() {
        return 1786898627;
    }

    public final GraphQLVisitableModel m22442a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22441a() != null) {
            FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.b(m22441a());
            if (m22441a() != feedUnit) {
                graphQLVisitableModel = (GraphQLVideoChannelFeedEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f13446d = feedUnit;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLVideoChannelFeedEdge() {
        super(2);
    }

    public final int m22440a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = flatBufferBuilder.a(m22441a(), VirtualFlattenableResolverImpl.a);
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLVideoChannelFeedEdge(Parcel parcel) {
        super(2);
        this.f13446d = (FeedUnit) parcel.readValue(FeedUnit.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m22441a());
    }
}

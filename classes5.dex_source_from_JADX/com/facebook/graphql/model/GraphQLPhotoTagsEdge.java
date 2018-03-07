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
import com.facebook.graphql.deserializers.GraphQLPhotoTagsEdgeDeserializer;
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
import com.google.common.base.Preconditions;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: WIKIPEDIA_CARD */
public final class GraphQLPhotoTagsEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPhotoTagsEdge> CREATOR = new C11721();
    @Nullable
    public String f12566d;
    @Nullable
    public GraphQLProfile f12567e;
    @Nullable
    public GraphQLPhotoTag f12568f;

    /* compiled from: WIKIPEDIA_CARD */
    final class C11721 implements Creator<GraphQLPhotoTagsEdge> {
        C11721() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPhotoTagsEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPhotoTagsEdge[i];
        }
    }

    /* compiled from: WIKIPEDIA_CARD */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        @Nullable
        public String f12563d;
        @Nullable
        public GraphQLProfile f12564e;
        @Nullable
        public GraphQLPhotoTag f12565f;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: WIKIPEDIA_CARD */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPhotoTagsEdge.class, new Deserializer());
        }

        public Object m20753a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPhotoTagsEdgeDeserializer.m5621a(jsonParser, (short) 278);
            Object graphQLPhotoTagsEdge = new GraphQLPhotoTagsEdge();
            ((BaseModel) graphQLPhotoTagsEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPhotoTagsEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLPhotoTagsEdge).a();
            }
            return graphQLPhotoTagsEdge;
        }
    }

    /* compiled from: WIKIPEDIA_CARD */
    public final class Serializer extends JsonSerializer<GraphQLPhotoTagsEdge> {
        public final void m20754a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPhotoTagsEdge graphQLPhotoTagsEdge = (GraphQLPhotoTagsEdge) obj;
            GraphQLPhotoTagsEdgeDeserializer.m5622b(graphQLPhotoTagsEdge.w_(), graphQLPhotoTagsEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPhotoTagsEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLPhotoTagsEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m20757a() {
        this.f12566d = super.a(this.f12566d, 0);
        return this.f12566d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m20758j() {
        this.f12567e = (GraphQLProfile) super.a(this.f12567e, 1, GraphQLProfile.class);
        return this.f12567e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPhotoTag m20759k() {
        this.f12568f = (GraphQLPhotoTag) super.a(this.f12568f, 2, GraphQLPhotoTag.class);
        return this.f12568f;
    }

    public final int jK_() {
        return 177332648;
    }

    public final GraphQLVisitableModel m20756a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20758j() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m20758j());
            if (m20758j() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLPhotoTagsEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f12567e = graphQLProfile;
            }
        }
        if (m20759k() != null) {
            GraphQLPhotoTag graphQLPhotoTag = (GraphQLPhotoTag) graphQLModelMutatingVisitor.b(m20759k());
            if (m20759k() != graphQLPhotoTag) {
                graphQLVisitableModel = (GraphQLPhotoTagsEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12568f = graphQLPhotoTag;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPhotoTagsEdge() {
        super(4);
    }

    public final int m20755a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m20757a());
        int a = ModelHelper.a(flatBufferBuilder, m20758j());
        int a2 = ModelHelper.a(flatBufferBuilder, m20759k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPhotoTagsEdge(Parcel parcel) {
        super(4);
        this.f12566d = parcel.readString();
        this.f12567e = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f12568f = (GraphQLPhotoTag) parcel.readValue(GraphQLPhotoTag.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m20757a());
        parcel.writeValue(m20758j());
        parcel.writeValue(m20759k());
    }

    public GraphQLPhotoTagsEdge(Builder builder) {
        super(4);
        this.b = builder.a;
        this.c = builder.b;
        this.f12566d = builder.f12563d;
        this.f12567e = builder.f12564e;
        this.f12568f = builder.f12565f;
    }
}

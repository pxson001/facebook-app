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
import com.facebook.graphql.deserializers.GraphQLPhotoTagDeserializer;
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
/* compiled from: WILDE_PROFILE_MORE */
public final class GraphQLPhotoTag extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPhotoTag> CREATOR = new C11711();
    boolean f12558d;
    @Nullable
    GraphQLVect2 f12559e;
    @Nullable
    GraphQLActor f12560f;
    long f12561g;

    /* compiled from: WILDE_PROFILE_MORE */
    final class C11711 implements Creator<GraphQLPhotoTag> {
        C11711() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPhotoTag(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPhotoTag[i];
        }
    }

    /* compiled from: WILDE_PROFILE_MORE */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public boolean f12554d;
        @Nullable
        public GraphQLVect2 f12555e;
        @Nullable
        public GraphQLActor f12556f;
        public long f12557g;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: WILDE_PROFILE_MORE */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLPhotoTag.class, new Deserializer());
        }

        public Object m20733a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLPhotoTagDeserializer.m5615a(jsonParser, (short) 279);
            Object graphQLPhotoTag = new GraphQLPhotoTag();
            ((BaseModel) graphQLPhotoTag).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLPhotoTag instanceof Postprocessable) {
                return ((Postprocessable) graphQLPhotoTag).a();
            }
            return graphQLPhotoTag;
        }
    }

    /* compiled from: WILDE_PROFILE_MORE */
    public final class Serializer extends JsonSerializer<GraphQLPhotoTag> {
        public final void m20734a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLPhotoTag graphQLPhotoTag = (GraphQLPhotoTag) obj;
            GraphQLPhotoTagDeserializer.m5616a(graphQLPhotoTag.w_(), graphQLPhotoTag.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLPhotoTag.class, new Serializer());
            FbSerializerProvider.a(GraphQLPhotoTag.class, new Serializer());
        }
    }

    @FieldOffset
    public final boolean m20738a() {
        a(0, 0);
        return this.f12558d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLVect2 m20739j() {
        this.f12559e = (GraphQLVect2) super.a(this.f12559e, 1, GraphQLVect2.class);
        return this.f12559e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m20740k() {
        this.f12560f = (GraphQLActor) super.a(this.f12560f, 2, GraphQLActor.class);
        return this.f12560f;
    }

    @FieldOffset
    public final long m20741l() {
        a(0, 3);
        return this.f12561g;
    }

    public final int jK_() {
        return -1209636824;
    }

    public final GraphQLVisitableModel m20736a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m20739j() != null) {
            GraphQLVect2 graphQLVect2 = (GraphQLVect2) graphQLModelMutatingVisitor.b(m20739j());
            if (m20739j() != graphQLVect2) {
                graphQLVisitableModel = (GraphQLPhotoTag) ModelHelper.a(null, this);
                graphQLVisitableModel.f12559e = graphQLVect2;
            }
        }
        if (m20740k() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m20740k());
            if (m20740k() != graphQLActor) {
                graphQLVisitableModel = (GraphQLPhotoTag) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f12560f = graphQLActor;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPhotoTag() {
        super(5);
    }

    public final void m20737a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f12558d = mutableFlatBuffer.a(i, 0);
        this.f12561g = mutableFlatBuffer.a(i, 3, 0);
    }

    public final int m20735a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m20739j());
        int a2 = ModelHelper.a(flatBufferBuilder, m20740k());
        flatBufferBuilder.c(4);
        flatBufferBuilder.a(0, m20738a());
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.a(3, m20741l(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLPhotoTag(Parcel parcel) {
        boolean z = true;
        super(5);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f12558d = z;
        this.f12559e = (GraphQLVect2) parcel.readValue(GraphQLVect2.class.getClassLoader());
        this.f12560f = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f12561g = parcel.readLong();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m20738a() ? 1 : 0));
        parcel.writeValue(m20739j());
        parcel.writeValue(m20740k());
        parcel.writeLong(m20741l());
    }

    public GraphQLPhotoTag(Builder builder) {
        super(5);
        this.b = builder.a;
        this.c = builder.b;
        this.f12558d = builder.f12554d;
        this.f12559e = builder.f12555e;
        this.f12560f = builder.f12556f;
        this.f12561g = builder.f12557g;
    }
}

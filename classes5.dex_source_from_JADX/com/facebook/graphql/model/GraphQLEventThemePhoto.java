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
import com.facebook.graphql.deserializers.GraphQLEventThemePhotoDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
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
/* compiled from: implicit_loc */
public final class GraphQLEventThemePhoto extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLEventThemePhoto> CREATOR = new C03141();
    @Nullable
    GraphQLImage f3659d;
    @Nullable
    GraphQLImage f3660e;
    @Nullable
    String f3661f;
    @Nullable
    GraphQLImage f3662g;
    @Nullable
    GraphQLImage f3663h;
    @Nullable
    GraphQLImage f3664i;
    @Nullable
    GraphQLImage f3665j;
    @Nullable
    GraphQLImage f3666k;
    @Nullable
    GraphQLImage f3667l;
    @Nullable
    GraphQLImage f3668m;
    @Nullable
    String f3669n;

    /* compiled from: implicit_loc */
    final class C03141 implements Creator<GraphQLEventThemePhoto> {
        C03141() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEventThemePhoto(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEventThemePhoto[i];
        }
    }

    /* compiled from: implicit_loc */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEventThemePhoto.class, new Deserializer());
        }

        public Object m7262a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEventThemePhotoDeserializer.m4825a(jsonParser, (short) 23);
            Object graphQLEventThemePhoto = new GraphQLEventThemePhoto();
            ((BaseModel) graphQLEventThemePhoto).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEventThemePhoto instanceof Postprocessable) {
                return ((Postprocessable) graphQLEventThemePhoto).a();
            }
            return graphQLEventThemePhoto;
        }
    }

    /* compiled from: implicit_loc */
    public final class Serializer extends JsonSerializer<GraphQLEventThemePhoto> {
        public final void m7263a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEventThemePhoto graphQLEventThemePhoto = (GraphQLEventThemePhoto) obj;
            GraphQLEventThemePhotoDeserializer.m4826a(graphQLEventThemePhoto.w_(), graphQLEventThemePhoto.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLEventThemePhoto.class, new Serializer());
            FbSerializerProvider.a(GraphQLEventThemePhoto.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7267j() {
        this.f3659d = (GraphQLImage) super.a(this.f3659d, 0, GraphQLImage.class);
        return this.f3659d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7268k() {
        this.f3660e = (GraphQLImage) super.a(this.f3660e, 1, GraphQLImage.class);
        return this.f3660e;
    }

    @FieldOffset
    @Nullable
    public final String m7269l() {
        this.f3661f = super.a(this.f3661f, 2);
        return this.f3661f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7270m() {
        this.f3662g = (GraphQLImage) super.a(this.f3662g, 3, GraphQLImage.class);
        return this.f3662g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7271n() {
        this.f3663h = (GraphQLImage) super.a(this.f3663h, 4, GraphQLImage.class);
        return this.f3663h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7272o() {
        this.f3664i = (GraphQLImage) super.a(this.f3664i, 5, GraphQLImage.class);
        return this.f3664i;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7273p() {
        this.f3665j = (GraphQLImage) super.a(this.f3665j, 6, GraphQLImage.class);
        return this.f3665j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7274q() {
        this.f3666k = (GraphQLImage) super.a(this.f3666k, 7, GraphQLImage.class);
        return this.f3666k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7275r() {
        this.f3667l = (GraphQLImage) super.a(this.f3667l, 8, GraphQLImage.class);
        return this.f3667l;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m7276s() {
        this.f3668m = (GraphQLImage) super.a(this.f3668m, 9, GraphQLImage.class);
        return this.f3668m;
    }

    @FieldOffset
    @Nullable
    public final String m7277t() {
        this.f3669n = super.a(this.f3669n, 10);
        return this.f3669n;
    }

    @Nullable
    public final String m7266a() {
        return m7269l();
    }

    public final int jK_() {
        return -893641725;
    }

    public final GraphQLVisitableModel m7265a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLImage graphQLImage;
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7267j() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7267j());
            if (m7267j() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEventThemePhoto) ModelHelper.a(null, this);
                graphQLVisitableModel.f3659d = graphQLImage;
            }
        }
        if (m7268k() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7268k());
            if (m7268k() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEventThemePhoto) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3660e = graphQLImage;
            }
        }
        if (m7270m() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7270m());
            if (m7270m() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEventThemePhoto) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3662g = graphQLImage;
            }
        }
        if (m7271n() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7271n());
            if (m7271n() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEventThemePhoto) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3663h = graphQLImage;
            }
        }
        if (m7272o() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7272o());
            if (m7272o() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEventThemePhoto) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3664i = graphQLImage;
            }
        }
        if (m7273p() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7273p());
            if (m7273p() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEventThemePhoto) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3665j = graphQLImage;
            }
        }
        if (m7274q() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7274q());
            if (m7274q() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEventThemePhoto) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3666k = graphQLImage;
            }
        }
        if (m7275r() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7275r());
            if (m7275r() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEventThemePhoto) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3667l = graphQLImage;
            }
        }
        if (m7276s() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m7276s());
            if (m7276s() != graphQLImage) {
                graphQLVisitableModel = (GraphQLEventThemePhoto) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3668m = graphQLImage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLEventThemePhoto() {
        super(12);
    }

    public final int m7264a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7267j());
        int a2 = ModelHelper.a(flatBufferBuilder, m7268k());
        int b = flatBufferBuilder.b(m7269l());
        int a3 = ModelHelper.a(flatBufferBuilder, m7270m());
        int a4 = ModelHelper.a(flatBufferBuilder, m7271n());
        int a5 = ModelHelper.a(flatBufferBuilder, m7272o());
        int a6 = ModelHelper.a(flatBufferBuilder, m7273p());
        int a7 = ModelHelper.a(flatBufferBuilder, m7274q());
        int a8 = ModelHelper.a(flatBufferBuilder, m7275r());
        int a9 = ModelHelper.a(flatBufferBuilder, m7276s());
        int b2 = flatBufferBuilder.b(m7277t());
        flatBufferBuilder.c(11);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, a3);
        flatBufferBuilder.b(4, a4);
        flatBufferBuilder.b(5, a5);
        flatBufferBuilder.b(6, a6);
        flatBufferBuilder.b(7, a7);
        flatBufferBuilder.b(8, a8);
        flatBufferBuilder.b(9, a9);
        flatBufferBuilder.b(10, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEventThemePhoto(Parcel parcel) {
        super(12);
        this.f3659d = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3660e = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3661f = parcel.readString();
        this.f3662g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3663h = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3664i = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3665j = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3666k = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3667l = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3668m = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f3669n = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7267j());
        parcel.writeValue(m7268k());
        parcel.writeString(m7269l());
        parcel.writeValue(m7270m());
        parcel.writeValue(m7271n());
        parcel.writeValue(m7272o());
        parcel.writeValue(m7273p());
        parcel.writeValue(m7274q());
        parcel.writeValue(m7275r());
        parcel.writeValue(m7276s());
        parcel.writeString(m7277t());
    }
}

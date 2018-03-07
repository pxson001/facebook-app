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
import com.facebook.graphql.deserializers.GraphQLExternalMusicAlbumDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
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
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: idTokenRequested */
public final class GraphQLExternalMusicAlbum extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLExternalMusicAlbum> CREATOR = new C03211();
    public long f3736d;
    @Nullable
    public String f3737e;
    public List<String> f3738f;
    @Nullable
    public String f3739g;
    @Nullable
    public String f3740h;
    @Nullable
    public GraphQLExternalUrl f3741i;
    @Nullable
    public String f3742j;
    @Nullable
    public String f3743k;
    @Nullable
    public GraphQLActor f3744l;
    @Nullable
    public String f3745m;

    /* compiled from: idTokenRequested */
    final class C03211 implements Creator<GraphQLExternalMusicAlbum> {
        C03211() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLExternalMusicAlbum(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLExternalMusicAlbum[i];
        }
    }

    /* compiled from: idTokenRequested */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLExternalMusicAlbum.class, new Deserializer());
        }

        public Object m7407a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLExternalMusicAlbumDeserializer.m4865a(jsonParser, (short) 70);
            Object graphQLExternalMusicAlbum = new GraphQLExternalMusicAlbum();
            ((BaseModel) graphQLExternalMusicAlbum).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLExternalMusicAlbum instanceof Postprocessable) {
                return ((Postprocessable) graphQLExternalMusicAlbum).a();
            }
            return graphQLExternalMusicAlbum;
        }
    }

    /* compiled from: idTokenRequested */
    public final class Serializer extends JsonSerializer<GraphQLExternalMusicAlbum> {
        public final void m7408a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLExternalMusicAlbum graphQLExternalMusicAlbum = (GraphQLExternalMusicAlbum) obj;
            GraphQLExternalMusicAlbumDeserializer.m4866a(graphQLExternalMusicAlbum.w_(), graphQLExternalMusicAlbum.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLExternalMusicAlbum.class, new Serializer());
            FbSerializerProvider.a(GraphQLExternalMusicAlbum.class, new Serializer());
        }
    }

    @FieldOffset
    public final long m7413j() {
        a(0, 0);
        return this.f3736d;
    }

    @FieldOffset
    @Nullable
    public final String m7414k() {
        this.f3737e = super.a(this.f3737e, 1);
        return this.f3737e;
    }

    @FieldOffset
    public final ImmutableList<String> m7415l() {
        this.f3738f = super.a(this.f3738f, 2);
        return (ImmutableList) this.f3738f;
    }

    @FieldOffset
    @Nullable
    public final String m7416m() {
        this.f3739g = super.a(this.f3739g, 3);
        return this.f3739g;
    }

    @FieldOffset
    @Nullable
    public final String m7417n() {
        this.f3740h = super.a(this.f3740h, 4);
        return this.f3740h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLExternalUrl m7418o() {
        this.f3741i = (GraphQLExternalUrl) super.a(this.f3741i, 5, GraphQLExternalUrl.class);
        return this.f3741i;
    }

    @FieldOffset
    @Nullable
    public final String m7419p() {
        this.f3742j = super.a(this.f3742j, 6);
        return this.f3742j;
    }

    @FieldOffset
    @Nullable
    public final String m7420q() {
        this.f3743k = super.a(this.f3743k, 7);
        return this.f3743k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLActor m7421r() {
        this.f3744l = (GraphQLActor) super.a(this.f3744l, 8, GraphQLActor.class);
        return this.f3744l;
    }

    @FieldOffset
    @Nullable
    public final String m7422s() {
        this.f3745m = super.a(this.f3745m, 9);
        return this.f3745m;
    }

    @Nullable
    public final String m7411a() {
        return m7419p();
    }

    public final int jK_() {
        return -2027902571;
    }

    public final GraphQLVisitableModel m7410a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7418o() != null) {
            GraphQLExternalUrl graphQLExternalUrl = (GraphQLExternalUrl) graphQLModelMutatingVisitor.b(m7418o());
            if (m7418o() != graphQLExternalUrl) {
                graphQLVisitableModel = (GraphQLExternalMusicAlbum) ModelHelper.a(null, this);
                graphQLVisitableModel.f3741i = graphQLExternalUrl;
            }
        }
        if (m7421r() != null) {
            GraphQLActor graphQLActor = (GraphQLActor) graphQLModelMutatingVisitor.b(m7421r());
            if (m7421r() != graphQLActor) {
                graphQLVisitableModel = (GraphQLExternalMusicAlbum) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3744l = graphQLActor;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLExternalMusicAlbum() {
        super(11);
    }

    public final void m7412a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3736d = mutableFlatBuffer.a(i, 0, 0);
    }

    public final int m7409a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m7414k());
        int c = flatBufferBuilder.c(m7415l());
        int b2 = flatBufferBuilder.b(m7416m());
        int b3 = flatBufferBuilder.b(m7417n());
        int a = ModelHelper.a(flatBufferBuilder, m7418o());
        int b4 = flatBufferBuilder.b(m7419p());
        int b5 = flatBufferBuilder.b(m7420q());
        int a2 = ModelHelper.a(flatBufferBuilder, m7421r());
        int b6 = flatBufferBuilder.b(m7422s());
        flatBufferBuilder.c(10);
        flatBufferBuilder.a(0, m7413j(), 0);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, c);
        flatBufferBuilder.b(3, b2);
        flatBufferBuilder.b(4, b3);
        flatBufferBuilder.b(5, a);
        flatBufferBuilder.b(6, b4);
        flatBufferBuilder.b(7, b5);
        flatBufferBuilder.b(8, a2);
        flatBufferBuilder.b(9, b6);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLExternalMusicAlbum(Parcel parcel) {
        super(11);
        this.f3736d = parcel.readLong();
        this.f3737e = parcel.readString();
        this.f3738f = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f3739g = parcel.readString();
        this.f3740h = parcel.readString();
        this.f3741i = (GraphQLExternalUrl) parcel.readValue(GraphQLExternalUrl.class.getClassLoader());
        this.f3742j = parcel.readString();
        this.f3743k = parcel.readString();
        this.f3744l = (GraphQLActor) parcel.readValue(GraphQLActor.class.getClassLoader());
        this.f3745m = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(m7413j());
        parcel.writeString(m7414k());
        parcel.writeList(m7415l());
        parcel.writeString(m7416m());
        parcel.writeString(m7417n());
        parcel.writeValue(m7418o());
        parcel.writeString(m7419p());
        parcel.writeString(m7420q());
        parcel.writeValue(m7421r());
        parcel.writeString(m7422s());
    }
}

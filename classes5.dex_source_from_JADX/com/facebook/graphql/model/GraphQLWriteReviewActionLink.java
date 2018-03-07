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
import com.facebook.graphql.deserializers.GraphQLWriteReviewActionLinkDeserializer;
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
/* compiled from: TX; */
public final class GraphQLWriteReviewActionLink extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLWriteReviewActionLink> CREATOR = new C12781();
    @Nullable
    GraphQLPage f13469d;
    int f13470e;
    @Nullable
    String f13471f;
    @Nullable
    String f13472g;

    /* compiled from: TX; */
    final class C12781 implements Creator<GraphQLWriteReviewActionLink> {
        C12781() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLWriteReviewActionLink(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLWriteReviewActionLink[i];
        }
    }

    /* compiled from: TX; */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLWriteReviewActionLink.class, new Deserializer());
        }

        public Object m22536a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLWriteReviewActionLinkDeserializer.m6220a(jsonParser, (short) 575);
            Object graphQLWriteReviewActionLink = new GraphQLWriteReviewActionLink();
            ((BaseModel) graphQLWriteReviewActionLink).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLWriteReviewActionLink instanceof Postprocessable) {
                return ((Postprocessable) graphQLWriteReviewActionLink).a();
            }
            return graphQLWriteReviewActionLink;
        }
    }

    /* compiled from: TX; */
    public final class Serializer extends JsonSerializer<GraphQLWriteReviewActionLink> {
        public final void m22537a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLWriteReviewActionLink graphQLWriteReviewActionLink = (GraphQLWriteReviewActionLink) obj;
            GraphQLWriteReviewActionLinkDeserializer.m6221a(graphQLWriteReviewActionLink.w_(), graphQLWriteReviewActionLink.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLWriteReviewActionLink.class, new Serializer());
            FbSerializerProvider.a(GraphQLWriteReviewActionLink.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLPage m22539a() {
        this.f13469d = (GraphQLPage) super.a(this.f13469d, 0, GraphQLPage.class);
        return this.f13469d;
    }

    @FieldOffset
    public final int m22542j() {
        a(0, 1);
        return this.f13470e;
    }

    @FieldOffset
    @Nullable
    public final String m22543k() {
        this.f13471f = super.a(this.f13471f, 2);
        return this.f13471f;
    }

    @FieldOffset
    @Nullable
    public final String m22544l() {
        this.f13472g = super.a(this.f13472g, 3);
        return this.f13472g;
    }

    public final int jK_() {
        return 1994746535;
    }

    public final GraphQLVisitableModel m22540a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m22539a() != null) {
            GraphQLPage graphQLPage = (GraphQLPage) graphQLModelMutatingVisitor.b(m22539a());
            if (m22539a() != graphQLPage) {
                graphQLVisitableModel = (GraphQLWriteReviewActionLink) ModelHelper.a(null, this);
                graphQLVisitableModel.f13469d = graphQLPage;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLWriteReviewActionLink() {
        super(5);
    }

    public final void m22541a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f13470e = mutableFlatBuffer.a(i, 1, 0);
    }

    public final int m22538a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m22539a());
        int b = flatBufferBuilder.b(m22543k());
        int b2 = flatBufferBuilder.b(m22544l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, m22542j(), 0);
        flatBufferBuilder.b(2, b);
        flatBufferBuilder.b(3, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLWriteReviewActionLink(Parcel parcel) {
        super(5);
        this.f13469d = (GraphQLPage) parcel.readValue(GraphQLPage.class.getClassLoader());
        this.f13470e = parcel.readInt();
        this.f13471f = parcel.readString();
        this.f13472g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m22539a());
        parcel.writeInt(m22542j());
        parcel.writeString(m22543k());
        parcel.writeString(m22544l());
    }
}

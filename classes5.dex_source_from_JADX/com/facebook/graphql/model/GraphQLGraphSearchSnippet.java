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
import com.facebook.graphql.deserializers.GraphQLGraphSearchSnippetDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
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
import com.google.common.collect.ImmutableList;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: full_pano_width_pixels */
public final class GraphQLGraphSearchSnippet extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGraphSearchSnippet> CREATOR = new C03821();
    public List<GraphQLTextWithEntities> f4124d;
    @Nullable
    public GraphQLTextWithEntities f4125e;

    /* compiled from: full_pano_width_pixels */
    final class C03821 implements Creator<GraphQLGraphSearchSnippet> {
        C03821() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGraphSearchSnippet(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGraphSearchSnippet[i];
        }
    }

    /* compiled from: full_pano_width_pixels */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public ImmutableList<GraphQLTextWithEntities> f4122d;
        @Nullable
        public GraphQLTextWithEntities f4123e;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: full_pano_width_pixels */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchSnippet.class, new Deserializer());
        }

        public Object m8312a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGraphSearchSnippetDeserializer.m5117a(jsonParser, (short) 471);
            Object graphQLGraphSearchSnippet = new GraphQLGraphSearchSnippet();
            ((BaseModel) graphQLGraphSearchSnippet).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGraphSearchSnippet instanceof Postprocessable) {
                return ((Postprocessable) graphQLGraphSearchSnippet).a();
            }
            return graphQLGraphSearchSnippet;
        }
    }

    /* compiled from: full_pano_width_pixels */
    public final class Serializer extends JsonSerializer<GraphQLGraphSearchSnippet> {
        public final void m8313a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGraphSearchSnippet graphQLGraphSearchSnippet = (GraphQLGraphSearchSnippet) obj;
            GraphQLGraphSearchSnippetDeserializer.m5120b(graphQLGraphSearchSnippet.w_(), graphQLGraphSearchSnippet.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGraphSearchSnippet.class, new Serializer());
            FbSerializerProvider.a(GraphQLGraphSearchSnippet.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLTextWithEntities> m8316a() {
        this.f4124d = super.a(this.f4124d, 0, GraphQLTextWithEntities.class);
        return (ImmutableList) this.f4124d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m8317j() {
        this.f4125e = (GraphQLTextWithEntities) super.a(this.f4125e, 1, GraphQLTextWithEntities.class);
        return this.f4125e;
    }

    public final int jK_() {
        return -38981689;
    }

    public final GraphQLVisitableModel m8315a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLTextWithEntities graphQLTextWithEntities;
        h();
        if (m8316a() != null) {
            com.google.common.collect.ImmutableList.Builder a = ModelHelper.a(m8316a(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLGraphSearchSnippet graphQLGraphSearchSnippet = (GraphQLGraphSearchSnippet) ModelHelper.a(null, this);
                graphQLGraphSearchSnippet.f4124d = a.b();
                graphQLVisitableModel = graphQLGraphSearchSnippet;
                if (m8317j() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8317j());
                    if (m8317j() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLGraphSearchSnippet) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4125e = graphQLTextWithEntities;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m8317j() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8317j());
            if (m8317j() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGraphSearchSnippet) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4125e = graphQLTextWithEntities;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLGraphSearchSnippet() {
        super(3);
    }

    public final int m8314a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8316a());
        int a2 = ModelHelper.a(flatBufferBuilder, m8317j());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGraphSearchSnippet(Parcel parcel) {
        super(3);
        this.f4124d = ImmutableListHelper.a(parcel.readArrayList(GraphQLTextWithEntities.class.getClassLoader()));
        this.f4125e = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m8316a());
        parcel.writeValue(m8317j());
    }

    public GraphQLGraphSearchSnippet(Builder builder) {
        super(3);
        this.b = builder.a;
        this.c = builder.b;
        this.f4124d = builder.f4122d;
        this.f4125e = builder.f4123e;
    }
}

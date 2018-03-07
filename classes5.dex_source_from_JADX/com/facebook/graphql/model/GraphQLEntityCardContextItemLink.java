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
import com.facebook.graphql.deserializers.GraphQLEntityCardContextItemLinkDeserializer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
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
/* compiled from: intercept_words_after_number */
public final class GraphQLEntityCardContextItemLink extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLEntityCardContextItemLink> CREATOR = new C03021();
    public List<String> f3545d;
    @Nullable
    public String f3546e;
    @Nullable
    public String f3547f;

    /* compiled from: intercept_words_after_number */
    final class C03021 implements Creator<GraphQLEntityCardContextItemLink> {
        C03021() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLEntityCardContextItemLink(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLEntityCardContextItemLink[i];
        }
    }

    /* compiled from: intercept_words_after_number */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLEntityCardContextItemLink.class, new Deserializer());
        }

        public Object m7071a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLEntityCardContextItemLinkDeserializer.m4757a(jsonParser, (short) 296);
            Object graphQLEntityCardContextItemLink = new GraphQLEntityCardContextItemLink();
            ((BaseModel) graphQLEntityCardContextItemLink).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLEntityCardContextItemLink instanceof Postprocessable) {
                return ((Postprocessable) graphQLEntityCardContextItemLink).a();
            }
            return graphQLEntityCardContextItemLink;
        }
    }

    /* compiled from: intercept_words_after_number */
    public final class Serializer extends JsonSerializer<GraphQLEntityCardContextItemLink> {
        public final void m7072a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLEntityCardContextItemLink graphQLEntityCardContextItemLink = (GraphQLEntityCardContextItemLink) obj;
            GraphQLEntityCardContextItemLinkDeserializer.m4758a(graphQLEntityCardContextItemLink.w_(), graphQLEntityCardContextItemLink.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLEntityCardContextItemLink.class, new Serializer());
            FbSerializerProvider.a(GraphQLEntityCardContextItemLink.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<String> m7075a() {
        this.f3545d = super.a(this.f3545d, 0);
        return (ImmutableList) this.f3545d;
    }

    @FieldOffset
    @Nullable
    public final String m7076j() {
        this.f3546e = super.a(this.f3546e, 1);
        return this.f3546e;
    }

    @FieldOffset
    @Nullable
    public final String m7077k() {
        this.f3547f = super.a(this.f3547f, 2);
        return this.f3547f;
    }

    public final int jK_() {
        return 1667337801;
    }

    public final GraphQLVisitableModel m7074a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLEntityCardContextItemLink() {
        super(4);
    }

    public final int m7073a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int c = flatBufferBuilder.c(m7075a());
        int b = flatBufferBuilder.b(m7076j());
        int b2 = flatBufferBuilder.b(m7077k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, c);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLEntityCardContextItemLink(Parcel parcel) {
        super(4);
        this.f3545d = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f3546e = parcel.readString();
        this.f3547f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m7075a());
        parcel.writeString(m7076j());
        parcel.writeString(m7077k());
    }
}

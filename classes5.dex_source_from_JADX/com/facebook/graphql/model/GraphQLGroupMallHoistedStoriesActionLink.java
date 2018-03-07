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
import com.facebook.graphql.deserializers.GraphQLGroupMallHoistedStoriesActionLinkDeserializer;
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
/* compiled from: friend_other */
public final class GraphQLGroupMallHoistedStoriesActionLink extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupMallHoistedStoriesActionLink> CREATOR = new C03971();
    public List<String> f4201d;
    @Nullable
    public String f4202e;
    @Nullable
    public String f4203f;

    /* compiled from: friend_other */
    final class C03971 implements Creator<GraphQLGroupMallHoistedStoriesActionLink> {
        C03971() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGroupMallHoistedStoriesActionLink(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGroupMallHoistedStoriesActionLink[i];
        }
    }

    /* compiled from: friend_other */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGroupMallHoistedStoriesActionLink.class, new Deserializer());
        }

        public Object m8438a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGroupMallHoistedStoriesActionLinkDeserializer.m5164a(jsonParser, (short) 560);
            Object graphQLGroupMallHoistedStoriesActionLink = new GraphQLGroupMallHoistedStoriesActionLink();
            ((BaseModel) graphQLGroupMallHoistedStoriesActionLink).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGroupMallHoistedStoriesActionLink instanceof Postprocessable) {
                return ((Postprocessable) graphQLGroupMallHoistedStoriesActionLink).a();
            }
            return graphQLGroupMallHoistedStoriesActionLink;
        }
    }

    /* compiled from: friend_other */
    public final class Serializer extends JsonSerializer<GraphQLGroupMallHoistedStoriesActionLink> {
        public final void m8439a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGroupMallHoistedStoriesActionLink graphQLGroupMallHoistedStoriesActionLink = (GraphQLGroupMallHoistedStoriesActionLink) obj;
            GraphQLGroupMallHoistedStoriesActionLinkDeserializer.m5165a(graphQLGroupMallHoistedStoriesActionLink.w_(), graphQLGroupMallHoistedStoriesActionLink.u_(), jsonGenerator);
        }

        static {
            FbSerializerProvider.a(GraphQLGroupMallHoistedStoriesActionLink.class, new Serializer());
            FbSerializerProvider.a(GraphQLGroupMallHoistedStoriesActionLink.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<String> m8442a() {
        this.f4201d = super.a(this.f4201d, 0);
        return (ImmutableList) this.f4201d;
    }

    @FieldOffset
    @Nullable
    public final String m8443j() {
        this.f4202e = super.a(this.f4202e, 1);
        return this.f4202e;
    }

    @FieldOffset
    @Nullable
    public final String m8444k() {
        this.f4203f = super.a(this.f4203f, 2);
        return this.f4203f;
    }

    public final int jK_() {
        return 44201556;
    }

    public final GraphQLVisitableModel m8441a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        h();
        i();
        return this;
    }

    public GraphQLGroupMallHoistedStoriesActionLink() {
        super(4);
    }

    public final int m8440a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int c = flatBufferBuilder.c(m8442a());
        int b = flatBufferBuilder.b(m8443j());
        int b2 = flatBufferBuilder.b(m8444k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, c);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGroupMallHoistedStoriesActionLink(Parcel parcel) {
        super(4);
        this.f4201d = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f4202e = parcel.readString();
        this.f4203f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m8442a());
        parcel.writeString(m8443j());
        parcel.writeString(m8444k());
    }
}

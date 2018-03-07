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
import com.facebook.graphql.deserializers.GraphQLFriendingPossibilitiesEdgeDeserializer;
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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: has_structured_menu */
public final class GraphQLFriendingPossibilitiesEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFriendingPossibilitiesEdge> CREATOR = new C03301();
    boolean f3790d;
    @Nullable
    GraphQLUser f3791e;
    List<GraphQLUser> f3792f;
    @Nullable
    String f3793g;

    /* compiled from: has_structured_menu */
    final class C03301 implements Creator<GraphQLFriendingPossibilitiesEdge> {
        C03301() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFriendingPossibilitiesEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFriendingPossibilitiesEdge[i];
        }
    }

    /* compiled from: has_structured_menu */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLFriendingPossibilitiesEdge.class, new Deserializer());
        }

        public Object m7590a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLFriendingPossibilitiesEdgeDeserializer.m4943a(jsonParser, (short) 385);
            Object graphQLFriendingPossibilitiesEdge = new GraphQLFriendingPossibilitiesEdge();
            ((BaseModel) graphQLFriendingPossibilitiesEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLFriendingPossibilitiesEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLFriendingPossibilitiesEdge).a();
            }
            return graphQLFriendingPossibilitiesEdge;
        }
    }

    /* compiled from: has_structured_menu */
    public final class Serializer extends JsonSerializer<GraphQLFriendingPossibilitiesEdge> {
        public final void m7591a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLFriendingPossibilitiesEdge graphQLFriendingPossibilitiesEdge = (GraphQLFriendingPossibilitiesEdge) obj;
            GraphQLFriendingPossibilitiesEdgeDeserializer.m4944b(graphQLFriendingPossibilitiesEdge.w_(), graphQLFriendingPossibilitiesEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLFriendingPossibilitiesEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLFriendingPossibilitiesEdge.class, new Serializer());
        }
    }

    @FieldOffset
    public final boolean m7595a() {
        a(0, 0);
        return this.f3790d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m7596j() {
        this.f3791e = (GraphQLUser) super.a(this.f3791e, 1, GraphQLUser.class);
        return this.f3791e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLUser> m7597k() {
        this.f3792f = super.a(this.f3792f, 2, GraphQLUser.class);
        return (ImmutableList) this.f3792f;
    }

    @FieldOffset
    @Nullable
    public final String m7598l() {
        this.f3793g = super.a(this.f3793g, 3);
        return this.f3793g;
    }

    public final int jK_() {
        return 923339498;
    }

    public final GraphQLVisitableModel m7593a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7596j() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.b(m7596j());
            if (m7596j() != graphQLUser) {
                graphQLVisitableModel = (GraphQLFriendingPossibilitiesEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3791e = graphQLUser;
            }
        }
        if (m7597k() != null) {
            Builder a = ModelHelper.a(m7597k(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLFriendingPossibilitiesEdge graphQLFriendingPossibilitiesEdge = (GraphQLFriendingPossibilitiesEdge) ModelHelper.a(graphQLVisitableModel, this);
                graphQLFriendingPossibilitiesEdge.f3792f = a.b();
                graphQLVisitableModel = graphQLFriendingPossibilitiesEdge;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFriendingPossibilitiesEdge() {
        super(5);
    }

    public final void m7594a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3790d = mutableFlatBuffer.a(i, 0);
    }

    public final int m7592a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7596j());
        int a2 = ModelHelper.a(flatBufferBuilder, m7597k());
        int b = flatBufferBuilder.b(m7598l());
        flatBufferBuilder.c(4);
        flatBufferBuilder.a(0, m7595a());
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.b(3, b);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLFriendingPossibilitiesEdge(Parcel parcel) {
        boolean z = true;
        super(5);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f3790d = z;
        this.f3791e = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
        this.f3792f = ImmutableListHelper.a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
        this.f3793g = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m7595a() ? 1 : 0));
        parcel.writeValue(m7596j());
        parcel.writeList(m7597k());
        parcel.writeString(m7598l());
    }
}

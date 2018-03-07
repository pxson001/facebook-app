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
import com.facebook.graphql.deserializers.GraphQLGroupMembersEdgeDeserializer;
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
/* compiled from: friend_center_search */
public final class GraphQLGroupMembersEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupMembersEdge> CREATOR = new C03991();
    public boolean f4205d;
    @Nullable
    public GraphQLUser f4206e;

    /* compiled from: friend_center_search */
    final class C03991 implements Creator<GraphQLGroupMembersEdge> {
        C03991() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGroupMembersEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGroupMembersEdge[i];
        }
    }

    /* compiled from: friend_center_search */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGroupMembersEdge.class, new Deserializer());
        }

        public Object m8460a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGroupMembersEdgeDeserializer.m5173a(jsonParser, (short) 314);
            Object graphQLGroupMembersEdge = new GraphQLGroupMembersEdge();
            ((BaseModel) graphQLGroupMembersEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGroupMembersEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLGroupMembersEdge).a();
            }
            return graphQLGroupMembersEdge;
        }
    }

    /* compiled from: friend_center_search */
    public final class Serializer extends JsonSerializer<GraphQLGroupMembersEdge> {
        public final void m8461a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGroupMembersEdge graphQLGroupMembersEdge = (GraphQLGroupMembersEdge) obj;
            GraphQLGroupMembersEdgeDeserializer.m5175b(graphQLGroupMembersEdge.w_(), graphQLGroupMembersEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGroupMembersEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLGroupMembersEdge.class, new Serializer());
        }
    }

    @FieldOffset
    public final boolean m8465a() {
        a(0, 2);
        return this.f4205d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLUser m8466j() {
        this.f4206e = (GraphQLUser) super.a(this.f4206e, 3, GraphQLUser.class);
        return this.f4206e;
    }

    public final int jK_() {
        return -1730431337;
    }

    public final GraphQLVisitableModel m8463a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8466j() != null) {
            GraphQLUser graphQLUser = (GraphQLUser) graphQLModelMutatingVisitor.b(m8466j());
            if (m8466j() != graphQLUser) {
                graphQLVisitableModel = (GraphQLGroupMembersEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f4206e = graphQLUser;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGroupMembersEdge() {
        super(5);
    }

    public final void m8464a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f4205d = mutableFlatBuffer.a(i, 2);
    }

    public final int m8462a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8466j());
        flatBufferBuilder.c(4);
        flatBufferBuilder.a(2, m8465a());
        flatBufferBuilder.b(3, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGroupMembersEdge(Parcel parcel) {
        boolean z = true;
        super(5);
        if (parcel.readByte() != (byte) 1) {
            z = false;
        }
        this.f4205d = z;
        this.f4206e = (GraphQLUser) parcel.readValue(GraphQLUser.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte((byte) (m8465a() ? 1 : 0));
        parcel.writeValue(m8466j());
    }
}

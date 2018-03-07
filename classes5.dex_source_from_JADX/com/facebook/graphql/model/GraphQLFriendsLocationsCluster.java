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
import com.facebook.graphql.deserializers.GraphQLFriendsLocationsClusterDeserializer;
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
/* compiled from: has_goal_amount */
public final class GraphQLFriendsLocationsCluster extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFriendsLocationsCluster> CREATOR = new C03321();
    @Nullable
    GraphQLLocation f3796d;
    int f3797e;

    /* compiled from: has_goal_amount */
    final class C03321 implements Creator<GraphQLFriendsLocationsCluster> {
        C03321() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFriendsLocationsCluster(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFriendsLocationsCluster[i];
        }
    }

    /* compiled from: has_goal_amount */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLFriendsLocationsCluster.class, new Deserializer());
        }

        public Object m7621a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLFriendsLocationsClusterDeserializer.m4953a(jsonParser, (short) 569);
            Object graphQLFriendsLocationsCluster = new GraphQLFriendsLocationsCluster();
            ((BaseModel) graphQLFriendsLocationsCluster).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLFriendsLocationsCluster instanceof Postprocessable) {
                return ((Postprocessable) graphQLFriendsLocationsCluster).a();
            }
            return graphQLFriendsLocationsCluster;
        }
    }

    /* compiled from: has_goal_amount */
    public final class Serializer extends JsonSerializer<GraphQLFriendsLocationsCluster> {
        public final void m7622a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLFriendsLocationsCluster graphQLFriendsLocationsCluster = (GraphQLFriendsLocationsCluster) obj;
            GraphQLFriendsLocationsClusterDeserializer.m4955b(graphQLFriendsLocationsCluster.w_(), graphQLFriendsLocationsCluster.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLFriendsLocationsCluster.class, new Serializer());
            FbSerializerProvider.a(GraphQLFriendsLocationsCluster.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLLocation m7624a() {
        this.f3796d = (GraphQLLocation) super.a(this.f3796d, 0, GraphQLLocation.class);
        return this.f3796d;
    }

    @FieldOffset
    public final int m7627j() {
        a(0, 1);
        return this.f3797e;
    }

    public final int jK_() {
        return 972458065;
    }

    public final GraphQLVisitableModel m7625a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7624a() != null) {
            GraphQLLocation graphQLLocation = (GraphQLLocation) graphQLModelMutatingVisitor.b(m7624a());
            if (m7624a() != graphQLLocation) {
                graphQLVisitableModel = (GraphQLFriendsLocationsCluster) ModelHelper.a(null, this);
                graphQLVisitableModel.f3796d = graphQLLocation;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFriendsLocationsCluster() {
        super(3);
    }

    public final void m7626a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3797e = mutableFlatBuffer.a(i, 1, 0);
    }

    public final int m7623a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m7624a());
        flatBufferBuilder.c(2);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.a(1, m7627j(), 0);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLFriendsLocationsCluster(Parcel parcel) {
        super(3);
        this.f3796d = (GraphQLLocation) parcel.readValue(GraphQLLocation.class.getClassLoader());
        this.f3797e = parcel.readInt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m7624a());
        parcel.writeInt(m7627j());
    }
}

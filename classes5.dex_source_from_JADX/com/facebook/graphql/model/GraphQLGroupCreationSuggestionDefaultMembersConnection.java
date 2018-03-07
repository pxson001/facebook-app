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
import com.facebook.graphql.deserializers.C0242xc7519942;
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

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: friendsLocationsItems */
public final class GraphQLGroupCreationSuggestionDefaultMembersConnection extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupCreationSuggestionDefaultMembersConnection> CREATOR = new C03941();
    public List<GraphQLUser> f4200d;

    /* compiled from: friendsLocationsItems */
    final class C03941 implements Creator<GraphQLGroupCreationSuggestionDefaultMembersConnection> {
        C03941() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGroupCreationSuggestionDefaultMembersConnection(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGroupCreationSuggestionDefaultMembersConnection[i];
        }
    }

    /* compiled from: friendsLocationsItems */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGroupCreationSuggestionDefaultMembersConnection.class, new Deserializer());
        }

        public Object m8418a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = C0242xc7519942.m5152a(jsonParser, (short) 346);
            Object graphQLGroupCreationSuggestionDefaultMembersConnection = new GraphQLGroupCreationSuggestionDefaultMembersConnection();
            ((BaseModel) graphQLGroupCreationSuggestionDefaultMembersConnection).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGroupCreationSuggestionDefaultMembersConnection instanceof Postprocessable) {
                return ((Postprocessable) graphQLGroupCreationSuggestionDefaultMembersConnection).a();
            }
            return graphQLGroupCreationSuggestionDefaultMembersConnection;
        }
    }

    /* compiled from: friendsLocationsItems */
    public final class Serializer extends JsonSerializer<GraphQLGroupCreationSuggestionDefaultMembersConnection> {
        public final void m8419a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGroupCreationSuggestionDefaultMembersConnection graphQLGroupCreationSuggestionDefaultMembersConnection = (GraphQLGroupCreationSuggestionDefaultMembersConnection) obj;
            C0242xc7519942.m5153a(graphQLGroupCreationSuggestionDefaultMembersConnection.w_(), graphQLGroupCreationSuggestionDefaultMembersConnection.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGroupCreationSuggestionDefaultMembersConnection.class, new Serializer());
            FbSerializerProvider.a(GraphQLGroupCreationSuggestionDefaultMembersConnection.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLUser> m8422a() {
        this.f4200d = super.a(this.f4200d, 0, GraphQLUser.class);
        return (ImmutableList) this.f4200d;
    }

    public final int jK_() {
        return 8289720;
    }

    public final GraphQLVisitableModel m8421a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8422a() != null) {
            Builder a = ModelHelper.a(m8422a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLGroupCreationSuggestionDefaultMembersConnection) ModelHelper.a(null, this);
                graphQLVisitableModel.f4200d = a.b();
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGroupCreationSuggestionDefaultMembersConnection() {
        super(2);
    }

    public final int m8420a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8422a());
        flatBufferBuilder.c(1);
        flatBufferBuilder.b(0, a);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGroupCreationSuggestionDefaultMembersConnection(Parcel parcel) {
        super(2);
        this.f4200d = ImmutableListHelper.a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m8422a());
    }
}

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
import com.facebook.graphql.deserializers.GraphQLGraphSearchResultDecorationDeserializer;
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
/* compiled from: fundraiser_page_subtitle */
public final class GraphQLGraphSearchResultDecoration extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGraphSearchResultDecoration> CREATOR = new C03791();
    List<GraphQLComment> f4101d;
    @Nullable
    GraphQLGraphSearchConnectedFriendsConnection f4102e;
    List<GraphQLGraphSearchSnippet> f4103f;
    List<GraphQLGraphSearchSnippet> f4104g;
    List<String> f4105h;
    List<GraphQLGraphSearchSnippet> f4106i;
    @Nullable
    String f4107j;
    @Nullable
    GraphQLGraphSearchSnippet f4108k;
    @Nullable
    GraphQLGraphSearchSnippet f4109l;

    /* compiled from: fundraiser_page_subtitle */
    final class C03791 implements Creator<GraphQLGraphSearchResultDecoration> {
        C03791() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGraphSearchResultDecoration(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGraphSearchResultDecoration[i];
        }
    }

    /* compiled from: fundraiser_page_subtitle */
    public class Builder extends com.facebook.graphql.modelutil.BaseModel.Builder {
        public ImmutableList<GraphQLComment> f4092d;
        @Nullable
        public GraphQLGraphSearchConnectedFriendsConnection f4093e;
        public ImmutableList<GraphQLGraphSearchSnippet> f4094f;
        public ImmutableList<GraphQLGraphSearchSnippet> f4095g;
        public ImmutableList<String> f4096h;
        public ImmutableList<GraphQLGraphSearchSnippet> f4097i;
        @Nullable
        public String f4098j;
        @Nullable
        public GraphQLGraphSearchSnippet f4099k;
        @Nullable
        public GraphQLGraphSearchSnippet f4100l;

        public Builder() {
            Preconditions.checkState(this instanceof Builder);
        }
    }

    /* compiled from: fundraiser_page_subtitle */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGraphSearchResultDecoration.class, new Deserializer());
        }

        public Object m8268a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGraphSearchResultDecorationDeserializer.m5107a(jsonParser, (short) 437);
            Object graphQLGraphSearchResultDecoration = new GraphQLGraphSearchResultDecoration();
            ((BaseModel) graphQLGraphSearchResultDecoration).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGraphSearchResultDecoration instanceof Postprocessable) {
                return ((Postprocessable) graphQLGraphSearchResultDecoration).a();
            }
            return graphQLGraphSearchResultDecoration;
        }
    }

    /* compiled from: fundraiser_page_subtitle */
    public final class Serializer extends JsonSerializer<GraphQLGraphSearchResultDecoration> {
        public final void m8269a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGraphSearchResultDecoration graphQLGraphSearchResultDecoration = (GraphQLGraphSearchResultDecoration) obj;
            GraphQLGraphSearchResultDecorationDeserializer.m5108a(graphQLGraphSearchResultDecoration.w_(), graphQLGraphSearchResultDecoration.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGraphSearchResultDecoration.class, new Serializer());
            FbSerializerProvider.a(GraphQLGraphSearchResultDecoration.class, new Serializer());
        }
    }

    @FieldOffset
    public final ImmutableList<GraphQLComment> m8272a() {
        this.f4101d = super.a(this.f4101d, 0, GraphQLComment.class);
        return (ImmutableList) this.f4101d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchConnectedFriendsConnection m8273j() {
        this.f4102e = (GraphQLGraphSearchConnectedFriendsConnection) super.a(this.f4102e, 1, GraphQLGraphSearchConnectedFriendsConnection.class);
        return this.f4102e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGraphSearchSnippet> m8274k() {
        this.f4103f = super.a(this.f4103f, 2, GraphQLGraphSearchSnippet.class);
        return (ImmutableList) this.f4103f;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGraphSearchSnippet> m8275l() {
        this.f4104g = super.a(this.f4104g, 3, GraphQLGraphSearchSnippet.class);
        return (ImmutableList) this.f4104g;
    }

    @FieldOffset
    public final ImmutableList<String> m8276m() {
        this.f4105h = super.a(this.f4105h, 4);
        return (ImmutableList) this.f4105h;
    }

    @FieldOffset
    public final ImmutableList<GraphQLGraphSearchSnippet> m8277n() {
        this.f4106i = super.a(this.f4106i, 5, GraphQLGraphSearchSnippet.class);
        return (ImmutableList) this.f4106i;
    }

    @FieldOffset
    @Nullable
    public final String m8278o() {
        this.f4107j = super.a(this.f4107j, 6);
        return this.f4107j;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchSnippet m8279p() {
        this.f4108k = (GraphQLGraphSearchSnippet) super.a(this.f4108k, 7, GraphQLGraphSearchSnippet.class);
        return this.f4108k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGraphSearchSnippet m8280q() {
        this.f4109l = (GraphQLGraphSearchSnippet) super.a(this.f4109l, 8, GraphQLGraphSearchSnippet.class);
        return this.f4109l;
    }

    public final int jK_() {
        return 379010371;
    }

    public final GraphQLVisitableModel m8271a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLGraphSearchResultDecoration graphQLGraphSearchResultDecoration;
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLGraphSearchConnectedFriendsConnection graphQLGraphSearchConnectedFriendsConnection;
        com.google.common.collect.ImmutableList.Builder a;
        GraphQLGraphSearchSnippet graphQLGraphSearchSnippet;
        h();
        if (m8272a() != null) {
            com.google.common.collect.ImmutableList.Builder a2 = ModelHelper.a(m8272a(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLGraphSearchResultDecoration = (GraphQLGraphSearchResultDecoration) ModelHelper.a(null, this);
                graphQLGraphSearchResultDecoration.f4101d = a2.b();
                graphQLVisitableModel = graphQLGraphSearchResultDecoration;
                if (m8273j() != null) {
                    graphQLGraphSearchConnectedFriendsConnection = (GraphQLGraphSearchConnectedFriendsConnection) graphQLModelMutatingVisitor.b(m8273j());
                    if (m8273j() != graphQLGraphSearchConnectedFriendsConnection) {
                        graphQLVisitableModel = (GraphQLGraphSearchResultDecoration) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4102e = graphQLGraphSearchConnectedFriendsConnection;
                    }
                }
                if (m8274k() != null) {
                    a = ModelHelper.a(m8274k(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLGraphSearchResultDecoration = (GraphQLGraphSearchResultDecoration) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLGraphSearchResultDecoration.f4103f = a.b();
                        graphQLVisitableModel = graphQLGraphSearchResultDecoration;
                    }
                }
                if (m8275l() != null) {
                    a = ModelHelper.a(m8275l(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLGraphSearchResultDecoration = (GraphQLGraphSearchResultDecoration) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLGraphSearchResultDecoration.f4104g = a.b();
                        graphQLVisitableModel = graphQLGraphSearchResultDecoration;
                    }
                }
                if (m8277n() != null) {
                    a = ModelHelper.a(m8277n(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLGraphSearchResultDecoration = (GraphQLGraphSearchResultDecoration) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLGraphSearchResultDecoration.f4106i = a.b();
                        graphQLVisitableModel = graphQLGraphSearchResultDecoration;
                    }
                }
                if (m8279p() != null) {
                    graphQLGraphSearchSnippet = (GraphQLGraphSearchSnippet) graphQLModelMutatingVisitor.b(m8279p());
                    if (m8279p() != graphQLGraphSearchSnippet) {
                        graphQLVisitableModel = (GraphQLGraphSearchResultDecoration) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4108k = graphQLGraphSearchSnippet;
                    }
                }
                if (m8280q() != null) {
                    graphQLGraphSearchSnippet = (GraphQLGraphSearchSnippet) graphQLModelMutatingVisitor.b(m8280q());
                    if (m8280q() != graphQLGraphSearchSnippet) {
                        graphQLVisitableModel = (GraphQLGraphSearchResultDecoration) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4109l = graphQLGraphSearchSnippet;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m8273j() != null) {
            graphQLGraphSearchConnectedFriendsConnection = (GraphQLGraphSearchConnectedFriendsConnection) graphQLModelMutatingVisitor.b(m8273j());
            if (m8273j() != graphQLGraphSearchConnectedFriendsConnection) {
                graphQLVisitableModel = (GraphQLGraphSearchResultDecoration) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4102e = graphQLGraphSearchConnectedFriendsConnection;
            }
        }
        if (m8274k() != null) {
            a = ModelHelper.a(m8274k(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGraphSearchResultDecoration = (GraphQLGraphSearchResultDecoration) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGraphSearchResultDecoration.f4103f = a.b();
                graphQLVisitableModel = graphQLGraphSearchResultDecoration;
            }
        }
        if (m8275l() != null) {
            a = ModelHelper.a(m8275l(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGraphSearchResultDecoration = (GraphQLGraphSearchResultDecoration) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGraphSearchResultDecoration.f4104g = a.b();
                graphQLVisitableModel = graphQLGraphSearchResultDecoration;
            }
        }
        if (m8277n() != null) {
            a = ModelHelper.a(m8277n(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLGraphSearchResultDecoration = (GraphQLGraphSearchResultDecoration) ModelHelper.a(graphQLVisitableModel, this);
                graphQLGraphSearchResultDecoration.f4106i = a.b();
                graphQLVisitableModel = graphQLGraphSearchResultDecoration;
            }
        }
        if (m8279p() != null) {
            graphQLGraphSearchSnippet = (GraphQLGraphSearchSnippet) graphQLModelMutatingVisitor.b(m8279p());
            if (m8279p() != graphQLGraphSearchSnippet) {
                graphQLVisitableModel = (GraphQLGraphSearchResultDecoration) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4108k = graphQLGraphSearchSnippet;
            }
        }
        if (m8280q() != null) {
            graphQLGraphSearchSnippet = (GraphQLGraphSearchSnippet) graphQLModelMutatingVisitor.b(m8280q());
            if (m8280q() != graphQLGraphSearchSnippet) {
                graphQLVisitableModel = (GraphQLGraphSearchResultDecoration) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4109l = graphQLGraphSearchSnippet;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLGraphSearchResultDecoration() {
        super(10);
    }

    public final int m8270a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8272a());
        int a2 = ModelHelper.a(flatBufferBuilder, m8273j());
        int a3 = ModelHelper.a(flatBufferBuilder, m8274k());
        int a4 = ModelHelper.a(flatBufferBuilder, m8275l());
        int c = flatBufferBuilder.c(m8276m());
        int a5 = ModelHelper.a(flatBufferBuilder, m8277n());
        int b = flatBufferBuilder.b(m8278o());
        int a6 = ModelHelper.a(flatBufferBuilder, m8279p());
        int a7 = ModelHelper.a(flatBufferBuilder, m8280q());
        flatBufferBuilder.c(9);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, a2);
        flatBufferBuilder.b(2, a3);
        flatBufferBuilder.b(3, a4);
        flatBufferBuilder.b(4, c);
        flatBufferBuilder.b(5, a5);
        flatBufferBuilder.b(6, b);
        flatBufferBuilder.b(7, a6);
        flatBufferBuilder.b(8, a7);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGraphSearchResultDecoration(Parcel parcel) {
        super(10);
        this.f4101d = ImmutableListHelper.a(parcel.readArrayList(GraphQLComment.class.getClassLoader()));
        this.f4102e = (GraphQLGraphSearchConnectedFriendsConnection) parcel.readValue(GraphQLGraphSearchConnectedFriendsConnection.class.getClassLoader());
        this.f4103f = ImmutableListHelper.a(parcel.readArrayList(GraphQLGraphSearchSnippet.class.getClassLoader()));
        this.f4104g = ImmutableListHelper.a(parcel.readArrayList(GraphQLGraphSearchSnippet.class.getClassLoader()));
        this.f4105h = ImmutableListHelper.a(parcel.readArrayList(String.class.getClassLoader()));
        this.f4106i = ImmutableListHelper.a(parcel.readArrayList(GraphQLGraphSearchSnippet.class.getClassLoader()));
        this.f4107j = parcel.readString();
        this.f4108k = (GraphQLGraphSearchSnippet) parcel.readValue(GraphQLGraphSearchSnippet.class.getClassLoader());
        this.f4109l = (GraphQLGraphSearchSnippet) parcel.readValue(GraphQLGraphSearchSnippet.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m8272a());
        parcel.writeValue(m8273j());
        parcel.writeList(m8274k());
        parcel.writeList(m8275l());
        parcel.writeList(m8276m());
        parcel.writeList(m8277n());
        parcel.writeString(m8278o());
        parcel.writeValue(m8279p());
        parcel.writeValue(m8280q());
    }

    public GraphQLGraphSearchResultDecoration(Builder builder) {
        super(10);
        this.b = builder.a;
        this.c = builder.b;
        this.f4101d = builder.f4092d;
        this.f4102e = builder.f4093e;
        this.f4103f = builder.f4094f;
        this.f4104g = builder.f4095g;
        this.f4105h = builder.f4096h;
        this.f4106i = builder.f4097i;
        this.f4107j = builder.f4098j;
        this.f4108k = builder.f4099k;
        this.f4109l = builder.f4100l;
    }
}

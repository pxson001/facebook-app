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
import com.facebook.graphql.deserializers.GraphQLFriendListFeedEdgeDeserializer;
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
/* compiled from: hc_friends_tab */
public final class GraphQLFriendListFeedEdge extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFriendListFeedEdge> CREATOR = new C03281();
    @Nullable
    String f3776d;
    @Nullable
    FeedUnit f3777e;
    @Nullable
    String f3778f;

    /* compiled from: hc_friends_tab */
    final class C03281 implements Creator<GraphQLFriendListFeedEdge> {
        C03281() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLFriendListFeedEdge(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLFriendListFeedEdge[i];
        }
    }

    /* compiled from: hc_friends_tab */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLFriendListFeedEdge.class, new Deserializer());
        }

        public Object m7551a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLFriendListFeedEdgeDeserializer.m4932a(jsonParser, (short) 328);
            Object graphQLFriendListFeedEdge = new GraphQLFriendListFeedEdge();
            ((BaseModel) graphQLFriendListFeedEdge).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLFriendListFeedEdge instanceof Postprocessable) {
                return ((Postprocessable) graphQLFriendListFeedEdge).a();
            }
            return graphQLFriendListFeedEdge;
        }
    }

    /* compiled from: hc_friends_tab */
    public final class Serializer extends JsonSerializer<GraphQLFriendListFeedEdge> {
        public final void m7552a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLFriendListFeedEdge graphQLFriendListFeedEdge = (GraphQLFriendListFeedEdge) obj;
            GraphQLFriendListFeedEdgeDeserializer.m4933b(graphQLFriendListFeedEdge.w_(), graphQLFriendListFeedEdge.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLFriendListFeedEdge.class, new Serializer());
            FbSerializerProvider.a(GraphQLFriendListFeedEdge.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m7555a() {
        this.f3776d = super.a(this.f3776d, 0);
        return this.f3776d;
    }

    @FieldOffset
    @Nullable
    public final FeedUnit m7556j() {
        this.f3777e = (FeedUnit) super.a(this.f3777e, 1, VirtualFlattenableResolverImpl.a);
        return this.f3777e;
    }

    @FieldOffset
    @Nullable
    public final String m7557k() {
        this.f3778f = super.a(this.f3778f, 2);
        return this.f3778f;
    }

    public final int jK_() {
        return 458652951;
    }

    public final GraphQLVisitableModel m7554a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m7556j() != null) {
            FeedUnit feedUnit = (FeedUnit) graphQLModelMutatingVisitor.b(m7556j());
            if (m7556j() != feedUnit) {
                graphQLVisitableModel = (GraphQLFriendListFeedEdge) ModelHelper.a(null, this);
                graphQLVisitableModel.f3777e = feedUnit;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFriendListFeedEdge() {
        super(4);
    }

    public final int m7553a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int b = flatBufferBuilder.b(m7555a());
        int a = flatBufferBuilder.a(m7556j(), VirtualFlattenableResolverImpl.a);
        int b2 = flatBufferBuilder.b(m7557k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLFriendListFeedEdge(Parcel parcel) {
        super(4);
        this.f3776d = parcel.readString();
        this.f3777e = (FeedUnit) parcel.readValue(FeedUnit.class.getClassLoader());
        this.f3778f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m7555a());
        parcel.writeValue(m7556j());
        parcel.writeString(m7557k());
    }
}

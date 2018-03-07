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
import com.facebook.graphql.deserializers.C0241x3cc57236;
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
/* compiled from: friends_interested */
public final class GraphQLGroupCanToggleCommentDisablingOnPostActionLink extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupCanToggleCommentDisablingOnPostActionLink> CREATOR = new C03881();
    @Nullable
    GraphQLFeedback f4188d;
    @Nullable
    String f4189e;
    @Nullable
    String f4190f;

    /* compiled from: friends_interested */
    final class C03881 implements Creator<GraphQLGroupCanToggleCommentDisablingOnPostActionLink> {
        C03881() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGroupCanToggleCommentDisablingOnPostActionLink(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGroupCanToggleCommentDisablingOnPostActionLink[i];
        }
    }

    /* compiled from: friends_interested */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGroupCanToggleCommentDisablingOnPostActionLink.class, new Deserializer());
        }

        public Object m8381a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = C0241x3cc57236.m5143a(jsonParser, (short) 183);
            Object graphQLGroupCanToggleCommentDisablingOnPostActionLink = new GraphQLGroupCanToggleCommentDisablingOnPostActionLink();
            ((BaseModel) graphQLGroupCanToggleCommentDisablingOnPostActionLink).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGroupCanToggleCommentDisablingOnPostActionLink instanceof Postprocessable) {
                return ((Postprocessable) graphQLGroupCanToggleCommentDisablingOnPostActionLink).a();
            }
            return graphQLGroupCanToggleCommentDisablingOnPostActionLink;
        }
    }

    /* compiled from: friends_interested */
    public final class Serializer extends JsonSerializer<GraphQLGroupCanToggleCommentDisablingOnPostActionLink> {
        public final void m8382a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGroupCanToggleCommentDisablingOnPostActionLink graphQLGroupCanToggleCommentDisablingOnPostActionLink = (GraphQLGroupCanToggleCommentDisablingOnPostActionLink) obj;
            C0241x3cc57236.m5144a(graphQLGroupCanToggleCommentDisablingOnPostActionLink.w_(), graphQLGroupCanToggleCommentDisablingOnPostActionLink.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGroupCanToggleCommentDisablingOnPostActionLink.class, new Serializer());
            FbSerializerProvider.a(GraphQLGroupCanToggleCommentDisablingOnPostActionLink.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m8384a() {
        this.f4188d = (GraphQLFeedback) super.a(this.f4188d, 0, GraphQLFeedback.class);
        return this.f4188d;
    }

    @FieldOffset
    @Nullable
    public final String m8386j() {
        this.f4189e = super.a(this.f4189e, 1);
        return this.f4189e;
    }

    @FieldOffset
    @Nullable
    public final String m8387k() {
        this.f4190f = super.a(this.f4190f, 2);
        return this.f4190f;
    }

    public final int jK_() {
        return -1103690310;
    }

    public final GraphQLVisitableModel m8385a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m8384a() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(m8384a());
            if (m8384a() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLGroupCanToggleCommentDisablingOnPostActionLink) ModelHelper.a(null, this);
                graphQLVisitableModel.f4188d = graphQLFeedback;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLGroupCanToggleCommentDisablingOnPostActionLink() {
        super(4);
    }

    public final int m8383a(FlatBufferBuilder flatBufferBuilder) {
        h();
        int a = ModelHelper.a(flatBufferBuilder, m8384a());
        int b = flatBufferBuilder.b(m8386j());
        int b2 = flatBufferBuilder.b(m8387k());
        flatBufferBuilder.c(3);
        flatBufferBuilder.b(0, a);
        flatBufferBuilder.b(1, b);
        flatBufferBuilder.b(2, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGroupCanToggleCommentDisablingOnPostActionLink(Parcel parcel) {
        super(4);
        this.f4188d = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f4189e = parcel.readString();
        this.f4190f = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m8384a());
        parcel.writeString(m8386j());
        parcel.writeString(m8387k());
    }
}

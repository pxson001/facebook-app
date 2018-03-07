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
import com.facebook.graphql.deserializers.GraphQLGroupCreationSuggestionDeserializer;
import com.facebook.graphql.enums.GraphQLGroupCreationSuggestionType;
import com.facebook.graphql.enums.GraphQLGroupVisibility;
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
/* compiled from: friends_center_requests */
public final class GraphQLGroupCreationSuggestion extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLGroupCreationSuggestion> CREATOR = new C03921();
    @Nullable
    public String f4192d;
    public GraphQLGroupVisibility f4193e;
    public List<GraphQLUser> f4194f;
    @Nullable
    public GraphQLImage f4195g;
    @Nullable
    public String f4196h;
    @Nullable
    public GraphQLTextWithEntities f4197i;
    public GraphQLGroupCreationSuggestionType f4198j;

    /* compiled from: friends_center_requests */
    final class C03921 implements Creator<GraphQLGroupCreationSuggestion> {
        C03921() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLGroupCreationSuggestion(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLGroupCreationSuggestion[i];
        }
    }

    /* compiled from: friends_center_requests */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLGroupCreationSuggestion.class, new Deserializer());
        }

        public Object m8400a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLGroupCreationSuggestionDeserializer.m5155a(jsonParser, (short) 182);
            Object graphQLGroupCreationSuggestion = new GraphQLGroupCreationSuggestion();
            ((BaseModel) graphQLGroupCreationSuggestion).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLGroupCreationSuggestion instanceof Postprocessable) {
                return ((Postprocessable) graphQLGroupCreationSuggestion).a();
            }
            return graphQLGroupCreationSuggestion;
        }
    }

    /* compiled from: friends_center_requests */
    public final class Serializer extends JsonSerializer<GraphQLGroupCreationSuggestion> {
        public final void m8401a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLGroupCreationSuggestion graphQLGroupCreationSuggestion = (GraphQLGroupCreationSuggestion) obj;
            GraphQLGroupCreationSuggestionDeserializer.m5156a(graphQLGroupCreationSuggestion.w_(), graphQLGroupCreationSuggestion.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLGroupCreationSuggestion.class, new Serializer());
            FbSerializerProvider.a(GraphQLGroupCreationSuggestion.class, new Serializer());
        }
    }

    @FieldOffset
    @Nullable
    public final String m8404a() {
        this.f4192d = super.a(this.f4192d, 0);
        return this.f4192d;
    }

    @FieldOffset
    public final GraphQLGroupVisibility m8405j() {
        this.f4193e = (GraphQLGroupVisibility) super.a(this.f4193e, 1, GraphQLGroupVisibility.class, GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4193e;
    }

    @FieldOffset
    public final ImmutableList<GraphQLUser> m8406k() {
        this.f4194f = super.a(this.f4194f, 2, GraphQLUser.class);
        return (ImmutableList) this.f4194f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m8407l() {
        this.f4195g = (GraphQLImage) super.a(this.f4195g, 3, GraphQLImage.class);
        return this.f4195g;
    }

    @FieldOffset
    @Nullable
    public final String m8408m() {
        this.f4196h = super.a(this.f4196h, 4);
        return this.f4196h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m8409n() {
        this.f4197i = (GraphQLTextWithEntities) super.a(this.f4197i, 5, GraphQLTextWithEntities.class);
        return this.f4197i;
    }

    @FieldOffset
    public final GraphQLGroupCreationSuggestionType m8410o() {
        this.f4198j = (GraphQLGroupCreationSuggestionType) super.a(this.f4198j, 6, GraphQLGroupCreationSuggestionType.class, GraphQLGroupCreationSuggestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f4198j;
    }

    public final int jK_() {
        return 1818481410;
    }

    public final GraphQLVisitableModel m8403a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLImage graphQLImage;
        GraphQLTextWithEntities graphQLTextWithEntities;
        h();
        if (m8406k() != null) {
            Builder a = ModelHelper.a(m8406k(), graphQLModelMutatingVisitor);
            if (a != null) {
                GraphQLGroupCreationSuggestion graphQLGroupCreationSuggestion = (GraphQLGroupCreationSuggestion) ModelHelper.a(null, this);
                graphQLGroupCreationSuggestion.f4194f = a.b();
                graphQLVisitableModel = graphQLGroupCreationSuggestion;
                if (m8407l() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8407l());
                    if (m8407l() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLGroupCreationSuggestion) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4195g = graphQLImage;
                    }
                }
                if (m8409n() != null) {
                    graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8409n());
                    if (m8409n() != graphQLTextWithEntities) {
                        graphQLVisitableModel = (GraphQLGroupCreationSuggestion) ModelHelper.a(graphQLVisitableModel, this);
                        graphQLVisitableModel.f4197i = graphQLTextWithEntities;
                    }
                }
                i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m8407l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.b(m8407l());
            if (m8407l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLGroupCreationSuggestion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4195g = graphQLImage;
            }
        }
        if (m8409n() != null) {
            graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.b(m8409n());
            if (m8409n() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLGroupCreationSuggestion) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f4197i = graphQLTextWithEntities;
            }
        }
        i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLGroupCreationSuggestion() {
        super(8);
    }

    public final int m8402a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        h();
        int b = flatBufferBuilder.b(m8404a());
        int a = ModelHelper.a(flatBufferBuilder, m8406k());
        int a2 = ModelHelper.a(flatBufferBuilder, m8407l());
        int b2 = flatBufferBuilder.b(m8408m());
        int a3 = ModelHelper.a(flatBufferBuilder, m8409n());
        flatBufferBuilder.c(7);
        flatBufferBuilder.b(0, b);
        flatBufferBuilder.a(1, m8405j() == GraphQLGroupVisibility.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m8405j());
        flatBufferBuilder.b(2, a);
        flatBufferBuilder.b(3, a2);
        flatBufferBuilder.b(4, b2);
        flatBufferBuilder.b(5, a3);
        if (m8410o() != GraphQLGroupCreationSuggestionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m8410o();
        }
        flatBufferBuilder.a(6, enumR);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLGroupCreationSuggestion(Parcel parcel) {
        super(8);
        this.f4192d = parcel.readString();
        this.f4193e = GraphQLGroupVisibility.fromString(parcel.readString());
        this.f4194f = ImmutableListHelper.a(parcel.readArrayList(GraphQLUser.class.getClassLoader()));
        this.f4195g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f4196h = parcel.readString();
        this.f4197i = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f4198j = GraphQLGroupCreationSuggestionType.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m8404a());
        parcel.writeString(m8405j().name());
        parcel.writeList(m8406k());
        parcel.writeValue(m8407l());
        parcel.writeString(m8408m());
        parcel.writeValue(m8409n());
        parcel.writeString(m8410o().name());
    }
}

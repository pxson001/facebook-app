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
import com.facebook.graphql.deserializers.GraphQLComposedDocumentDeserializer;
import com.facebook.graphql.enums.GraphQLDocumentFeedbackOptions;
import com.facebook.graphql.enums.GraphQLDocumentFormatVersion;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
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
/* compiled from: isTransient */
public final class GraphQLComposedDocument extends BaseModel implements TypeModel, GraphQLPersistableNode, GraphQLVisitableModel {
    public static final Creator<GraphQLComposedDocument> CREATOR = new C02871();
    long f3482d;
    @Nullable
    GraphQLProfile f3483e;
    @Nullable
    GraphQLFeedback f3484f;
    GraphQLDocumentFeedbackOptions f3485g;
    GraphQLDocumentFormatVersion f3486h;
    @Nullable
    String f3487i;
    long f3488j;
    long f3489k;
    @Nullable
    String f3490l;

    /* compiled from: isTransient */
    final class C02871 implements Creator<GraphQLComposedDocument> {
        C02871() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLComposedDocument(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLComposedDocument[i];
        }
    }

    /* compiled from: isTransient */
    public class Deserializer extends FbJsonDeserializer {
        static {
            GlobalAutoGenDeserializerCache.a(GraphQLComposedDocument.class, new Deserializer());
        }

        public Object m6821a(JsonParser jsonParser, DeserializationContext deserializationContext) {
            MutableFlatBuffer a = GraphQLComposedDocumentDeserializer.m4669a(jsonParser, (short) 20);
            Object graphQLComposedDocument = new GraphQLComposedDocument();
            ((BaseModel) graphQLComposedDocument).a(a, a.g(FlatBuffer.a(a.a), 1), jsonParser);
            if (graphQLComposedDocument instanceof Postprocessable) {
                return ((Postprocessable) graphQLComposedDocument).a();
            }
            return graphQLComposedDocument;
        }
    }

    /* compiled from: isTransient */
    public final class Serializer extends JsonSerializer<GraphQLComposedDocument> {
        public final void m6822a(Object obj, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) {
            GraphQLComposedDocument graphQLComposedDocument = (GraphQLComposedDocument) obj;
            GraphQLComposedDocumentDeserializer.m4670a(graphQLComposedDocument.w_(), graphQLComposedDocument.u_(), jsonGenerator, serializerProvider);
        }

        static {
            FbSerializerProvider.a(GraphQLComposedDocument.class, new Serializer());
            FbSerializerProvider.a(GraphQLComposedDocument.class, new Serializer());
        }
    }

    @FieldOffset
    public final long m6827j() {
        a(0, 0);
        return this.f3482d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLProfile m6828k() {
        this.f3483e = (GraphQLProfile) super.a(this.f3483e, 1, GraphQLProfile.class);
        return this.f3483e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLFeedback m6829l() {
        this.f3484f = (GraphQLFeedback) super.a(this.f3484f, 2, GraphQLFeedback.class);
        return this.f3484f;
    }

    @FieldOffset
    public final GraphQLDocumentFeedbackOptions m6830m() {
        this.f3485g = (GraphQLDocumentFeedbackOptions) super.a(this.f3485g, 3, GraphQLDocumentFeedbackOptions.class, GraphQLDocumentFeedbackOptions.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f3485g;
    }

    @FieldOffset
    public final GraphQLDocumentFormatVersion m6831n() {
        this.f3486h = (GraphQLDocumentFormatVersion) super.a(this.f3486h, 4, GraphQLDocumentFormatVersion.class, GraphQLDocumentFormatVersion.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f3486h;
    }

    @FieldOffset
    @Nullable
    public final String m6832o() {
        this.f3487i = super.a(this.f3487i, 5);
        return this.f3487i;
    }

    @FieldOffset
    public final long m6833p() {
        a(0, 6);
        return this.f3488j;
    }

    @FieldOffset
    public final long m6834q() {
        a(0, 7);
        return this.f3489k;
    }

    @FieldOffset
    @Nullable
    public final String m6835r() {
        this.f3490l = super.a(this.f3490l, 8);
        return this.f3490l;
    }

    @Nullable
    public final String m6825a() {
        return m6832o();
    }

    public final int jK_() {
        return 1069615213;
    }

    public final GraphQLVisitableModel m6824a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        h();
        if (m6828k() != null) {
            GraphQLProfile graphQLProfile = (GraphQLProfile) graphQLModelMutatingVisitor.b(m6828k());
            if (m6828k() != graphQLProfile) {
                graphQLVisitableModel = (GraphQLComposedDocument) ModelHelper.a(null, this);
                graphQLVisitableModel.f3483e = graphQLProfile;
            }
        }
        if (m6829l() != null) {
            GraphQLFeedback graphQLFeedback = (GraphQLFeedback) graphQLModelMutatingVisitor.b(m6829l());
            if (m6829l() != graphQLFeedback) {
                graphQLVisitableModel = (GraphQLComposedDocument) ModelHelper.a(graphQLVisitableModel, this);
                graphQLVisitableModel.f3484f = graphQLFeedback;
            }
        }
        i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLComposedDocument() {
        super(10);
    }

    public final void m6826a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.a(mutableFlatBuffer, i, obj);
        this.f3482d = mutableFlatBuffer.a(i, 0, 0);
        this.f3488j = mutableFlatBuffer.a(i, 6, 0);
        this.f3489k = mutableFlatBuffer.a(i, 7, 0);
    }

    public final int m6823a(FlatBufferBuilder flatBufferBuilder) {
        Enum enumR = null;
        h();
        int a = ModelHelper.a(flatBufferBuilder, m6828k());
        int a2 = ModelHelper.a(flatBufferBuilder, m6829l());
        int b = flatBufferBuilder.b(m6832o());
        int b2 = flatBufferBuilder.b(m6835r());
        flatBufferBuilder.c(9);
        flatBufferBuilder.a(0, m6827j(), 0);
        flatBufferBuilder.b(1, a);
        flatBufferBuilder.b(2, a2);
        flatBufferBuilder.a(3, m6830m() == GraphQLDocumentFeedbackOptions.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m6830m());
        if (m6831n() != GraphQLDocumentFormatVersion.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            enumR = m6831n();
        }
        flatBufferBuilder.a(4, enumR);
        flatBufferBuilder.b(5, b);
        flatBufferBuilder.a(6, m6833p(), 0);
        flatBufferBuilder.a(7, m6834q(), 0);
        flatBufferBuilder.b(8, b2);
        i();
        return flatBufferBuilder.d();
    }

    public GraphQLComposedDocument(Parcel parcel) {
        super(10);
        this.f3482d = parcel.readLong();
        this.f3483e = (GraphQLProfile) parcel.readValue(GraphQLProfile.class.getClassLoader());
        this.f3484f = (GraphQLFeedback) parcel.readValue(GraphQLFeedback.class.getClassLoader());
        this.f3485g = GraphQLDocumentFeedbackOptions.fromString(parcel.readString());
        this.f3486h = GraphQLDocumentFormatVersion.fromString(parcel.readString());
        this.f3487i = parcel.readString();
        this.f3488j = parcel.readLong();
        this.f3489k = parcel.readLong();
        this.f3490l = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(m6827j());
        parcel.writeValue(m6828k());
        parcel.writeValue(m6829l());
        parcel.writeString(m6830m().name());
        parcel.writeString(m6831n().name());
        parcel.writeString(m6832o());
        parcel.writeLong(m6833p());
        parcel.writeLong(m6834q());
        parcel.writeString(m6835r());
    }
}

package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLTranslatabilityType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.instagram.common.json.annotation.JsonType;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: lead_gen_continued_flow_user_info_value */
public final class GraphQLPostTranslatability extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPostTranslatability> CREATOR = new C08031();
    @Nullable
    GraphQLTextWithEntities f17706d;
    @Nullable
    String f17707e;
    @Nullable
    String f17708f;
    @Nullable
    String f17709g;
    @Nullable
    String f17710h;
    @Nullable
    GraphQLTranslationMetaData f17711i;
    GraphQLTranslatabilityType f17712j;

    /* compiled from: lead_gen_continued_flow_user_info_value */
    final class C08031 implements Creator<GraphQLPostTranslatability> {
        C08031() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPostTranslatability(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPostTranslatability[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLTextWithEntities m24905a() {
        this.f17706d = (GraphQLTextWithEntities) super.m9947a(this.f17706d, 0, GraphQLTextWithEntities.class);
        return this.f17706d;
    }

    @FieldOffset
    @Nullable
    public final String m24907j() {
        this.f17707e = super.m9948a(this.f17707e, 1);
        return this.f17707e;
    }

    @FieldOffset
    @Nullable
    public final String m24908k() {
        this.f17708f = super.m9948a(this.f17708f, 2);
        return this.f17708f;
    }

    @FieldOffset
    @Nullable
    public final String m24909l() {
        this.f17709g = super.m9948a(this.f17709g, 3);
        return this.f17709g;
    }

    @FieldOffset
    @Nullable
    public final String m24910m() {
        this.f17710h = super.m9948a(this.f17710h, 4);
        return this.f17710h;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTranslationMetaData m24911n() {
        this.f17711i = (GraphQLTranslationMetaData) super.m9947a(this.f17711i, 5, GraphQLTranslationMetaData.class);
        return this.f17711i;
    }

    @FieldOffset
    public final GraphQLTranslatabilityType m24912o() {
        this.f17712j = (GraphQLTranslatabilityType) super.m9945a(this.f17712j, 6, GraphQLTranslatabilityType.class, GraphQLTranslatabilityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f17712j;
    }

    public final int jK_() {
        return -1681643917;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24905a() != null) {
            GraphQLTextWithEntities graphQLTextWithEntities = (GraphQLTextWithEntities) graphQLModelMutatingVisitor.mo2928b(m24905a());
            if (m24905a() != graphQLTextWithEntities) {
                graphQLVisitableModel = (GraphQLPostTranslatability) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17706d = graphQLTextWithEntities;
            }
        }
        if (m24911n() != null) {
            GraphQLTranslationMetaData graphQLTranslationMetaData = (GraphQLTranslationMetaData) graphQLModelMutatingVisitor.mo2928b(m24911n());
            if (m24911n() != graphQLTranslationMetaData) {
                graphQLVisitableModel = (GraphQLPostTranslatability) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17711i = graphQLTranslationMetaData;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPostTranslatability() {
        super(8);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m24905a());
        int b = flatBufferBuilder.m21502b(m24907j());
        int b2 = flatBufferBuilder.m21502b(m24908k());
        int b3 = flatBufferBuilder.m21502b(m24909l());
        int b4 = flatBufferBuilder.m21502b(m24910m());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m24911n());
        flatBufferBuilder.m21510c(7);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, b);
        flatBufferBuilder.m21507b(2, b2);
        flatBufferBuilder.m21507b(3, b3);
        flatBufferBuilder.m21507b(4, b4);
        flatBufferBuilder.m21507b(5, a2);
        flatBufferBuilder.m21496a(6, m24912o() == GraphQLTranslatabilityType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : m24912o());
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPostTranslatability(Parcel parcel) {
        super(8);
        this.f17706d = (GraphQLTextWithEntities) parcel.readValue(GraphQLTextWithEntities.class.getClassLoader());
        this.f17707e = parcel.readString();
        this.f17708f = parcel.readString();
        this.f17709g = parcel.readString();
        this.f17710h = parcel.readString();
        this.f17711i = (GraphQLTranslationMetaData) parcel.readValue(GraphQLTranslationMetaData.class.getClassLoader());
        this.f17712j = GraphQLTranslatabilityType.fromString(parcel.readString());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m24905a());
        parcel.writeString(m24907j());
        parcel.writeString(m24908k());
        parcel.writeString(m24909l());
        parcel.writeString(m24910m());
        parcel.writeValue(m24911n());
        parcel.writeString(m24912o().name());
    }
}

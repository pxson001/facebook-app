package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.api.graphql.saved.SaveDefaultsGraphQLInterfaces$NewItemDefaultPrivacy;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.enums.GraphQLPrivacyOptionTagExpansionType;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLPersistableNode;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces$PrivacyIconFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces$PrivacyOptionFieldsForComposer;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: localsell_product_message_threads */
public final class GraphQLPrivacyOption extends BaseModel implements SaveDefaultsGraphQLInterfaces$NewItemDefaultPrivacy, TypeModel, GraphQLPersistableNode, GraphQLVisitableModel, PrivacyOptionsGraphQLInterfaces$PrivacyOptionFieldsForComposer {
    public static final Creator<GraphQLPrivacyOption> CREATOR = new C07101();
    GraphQLPrivacyOptionTagExpansionType f16767d;
    List<GraphQLPrivacyAudienceMember> f16768e;
    @Nullable
    String f16769f;
    @Nullable
    GraphQLImage f16770g;
    @Nullable
    String f16771h;
    List<GraphQLPrivacyAudienceMember> f16772i;
    @Nullable
    String f16773j;
    @Nullable
    String f16774k;
    @Nullable
    GraphQLPrivacyRowInput f16775l;
    List<GraphQLPrivacyOptionTagExpansionType> f16776m;
    @Deprecated
    @Nullable
    String f16777n;
    @Nullable
    String f16778o;

    /* compiled from: localsell_product_message_threads */
    final class C07101 implements Creator<GraphQLPrivacyOption> {
        C07101() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPrivacyOption(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPrivacyOption[i];
        }
    }

    @FieldOffset
    @Nullable
    public final /* synthetic */ PrivacyOptionsGraphQLInterfaces$PrivacyIconFields mo2948b() {
        return m23695l();
    }

    @FieldOffset
    public final GraphQLPrivacyOptionTagExpansionType E_() {
        this.f16767d = (GraphQLPrivacyOptionTagExpansionType) super.m9945a(this.f16767d, 0, GraphQLPrivacyOptionTagExpansionType.class, GraphQLPrivacyOptionTagExpansionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE);
        return this.f16767d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPrivacyAudienceMember> mo2951g() {
        this.f16768e = super.m9944a(this.f16768e, 1, GraphQLPrivacyAudienceMember.class);
        return (ImmutableList) this.f16768e;
    }

    @FieldOffset
    @Nullable
    public final String mo2952j() {
        this.f16769f = super.m9948a(this.f16769f, 2);
        return this.f16769f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLImage m23695l() {
        this.f16770g = (GraphQLImage) super.m9947a(this.f16770g, 4, GraphQLImage.class);
        return this.f16770g;
    }

    @FieldOffset
    @Nullable
    public final String m23696m() {
        this.f16771h = super.m9948a(this.f16771h, 5);
        return this.f16771h;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPrivacyAudienceMember> F_() {
        this.f16772i = super.m9944a(this.f16772i, 6, GraphQLPrivacyAudienceMember.class);
        return (ImmutableList) this.f16772i;
    }

    @FieldOffset
    @Nullable
    public final String mo2949c() {
        this.f16773j = super.m9948a(this.f16773j, 7);
        return this.f16773j;
    }

    @FieldOffset
    @Nullable
    public final String mo2950d() {
        this.f16774k = super.m9948a(this.f16774k, 8);
        return this.f16774k;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyRowInput m23697n() {
        this.f16775l = (GraphQLPrivacyRowInput) super.m9947a(this.f16775l, 9, GraphQLPrivacyRowInput.class);
        return this.f16775l;
    }

    @FieldOffset
    public final ImmutableList<GraphQLPrivacyOptionTagExpansionType> G_() {
        this.f16776m = super.m9953b(this.f16776m, 10, GraphQLPrivacyOptionTagExpansionType.class);
        return (ImmutableList) this.f16776m;
    }

    @FieldOffset
    @Nullable
    public final String mo2953k() {
        this.f16777n = super.m9948a(this.f16777n, 11);
        return this.f16777n;
    }

    @FieldOffset
    @Nullable
    public final String m23698o() {
        this.f16778o = super.m9948a(this.f16778o, 12);
        return this.f16778o;
    }

    @Nullable
    public final String mo2834a() {
        return m23696m();
    }

    public final int jK_() {
        return -1984364035;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLPrivacyOption graphQLPrivacyOption;
        GraphQLVisitableModel graphQLVisitableModel;
        GraphQLImage graphQLImage;
        Builder a;
        GraphQLPrivacyRowInput graphQLPrivacyRowInput;
        m9958h();
        if (mo2951g() != null) {
            Builder a2 = ModelHelper.m23097a(mo2951g(), graphQLModelMutatingVisitor);
            if (a2 != null) {
                graphQLPrivacyOption = (GraphQLPrivacyOption) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLPrivacyOption.f16768e = a2.m1068b();
                graphQLVisitableModel = graphQLPrivacyOption;
                if (m23695l() != null) {
                    graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23695l());
                    if (m23695l() != graphQLImage) {
                        graphQLVisitableModel = (GraphQLPrivacyOption) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16770g = graphQLImage;
                    }
                }
                if (F_() != null) {
                    a = ModelHelper.m23097a(F_(), graphQLModelMutatingVisitor);
                    if (a != null) {
                        graphQLPrivacyOption = (GraphQLPrivacyOption) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLPrivacyOption.f16772i = a.m1068b();
                        graphQLVisitableModel = graphQLPrivacyOption;
                    }
                }
                if (m23697n() != null) {
                    graphQLPrivacyRowInput = (GraphQLPrivacyRowInput) graphQLModelMutatingVisitor.mo2928b(m23697n());
                    if (m23697n() != graphQLPrivacyRowInput) {
                        graphQLVisitableModel = (GraphQLPrivacyOption) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f16775l = graphQLPrivacyRowInput;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m23695l() != null) {
            graphQLImage = (GraphQLImage) graphQLModelMutatingVisitor.mo2928b(m23695l());
            if (m23695l() != graphQLImage) {
                graphQLVisitableModel = (GraphQLPrivacyOption) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16770g = graphQLImage;
            }
        }
        if (F_() != null) {
            a = ModelHelper.m23097a(F_(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLPrivacyOption = (GraphQLPrivacyOption) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLPrivacyOption.f16772i = a.m1068b();
                graphQLVisitableModel = graphQLPrivacyOption;
            }
        }
        if (m23697n() != null) {
            graphQLPrivacyRowInput = (GraphQLPrivacyRowInput) graphQLModelMutatingVisitor.mo2928b(m23697n());
            if (m23697n() != graphQLPrivacyRowInput) {
                graphQLVisitableModel = (GraphQLPrivacyOption) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f16775l = graphQLPrivacyRowInput;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public GraphQLPrivacyOption() {
        super(14);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, mo2951g());
        int b = flatBufferBuilder.m21502b(mo2952j());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m23695l());
        int b2 = flatBufferBuilder.m21502b(m23696m());
        int a3 = ModelHelper.m23094a(flatBufferBuilder, F_());
        int b3 = flatBufferBuilder.m21502b(mo2949c());
        int b4 = flatBufferBuilder.m21502b(mo2950d());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m23697n());
        int e = flatBufferBuilder.m21514e(G_());
        int b5 = flatBufferBuilder.m21502b(mo2953k());
        int b6 = flatBufferBuilder.m21502b(m23698o());
        flatBufferBuilder.m21510c(13);
        flatBufferBuilder.m21496a(0, E_() == GraphQLPrivacyOptionTagExpansionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE ? null : E_());
        flatBufferBuilder.m21507b(1, a);
        flatBufferBuilder.m21507b(2, b);
        flatBufferBuilder.m21507b(4, a2);
        flatBufferBuilder.m21507b(5, b2);
        flatBufferBuilder.m21507b(6, a3);
        flatBufferBuilder.m21507b(7, b3);
        flatBufferBuilder.m21507b(8, b4);
        flatBufferBuilder.m21507b(9, a4);
        flatBufferBuilder.m21507b(10, e);
        flatBufferBuilder.m21507b(11, b5);
        flatBufferBuilder.m21507b(12, b6);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPrivacyOption(Parcel parcel) {
        super(14);
        this.f16767d = GraphQLPrivacyOptionTagExpansionType.fromString(parcel.readString());
        this.f16768e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPrivacyAudienceMember.class.getClassLoader()));
        this.f16769f = parcel.readString();
        this.f16770g = (GraphQLImage) parcel.readValue(GraphQLImage.class.getClassLoader());
        this.f16771h = parcel.readString();
        this.f16772i = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPrivacyAudienceMember.class.getClassLoader()));
        this.f16773j = parcel.readString();
        this.f16774k = parcel.readString();
        this.f16775l = (GraphQLPrivacyRowInput) parcel.readValue(GraphQLPrivacyRowInput.class.getClassLoader());
        this.f16776m = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLPrivacyOptionTagExpansionType.class.getClassLoader()));
        this.f16777n = parcel.readString();
        this.f16778o = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(E_().name());
        parcel.writeList(mo2951g());
        parcel.writeString(mo2952j());
        parcel.writeValue(m23695l());
        parcel.writeString(m23696m());
        parcel.writeList(F_());
        parcel.writeString(mo2949c());
        parcel.writeString(mo2950d());
        parcel.writeValue(m23697n());
        parcel.writeList(G_());
        parcel.writeString(mo2953k());
        parcel.writeString(m23698o());
    }

    public GraphQLPrivacyOption(Builder builder) {
        super(14);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f16767d = builder.d;
        this.f16768e = builder.e;
        this.f16769f = builder.f;
        this.f16770g = builder.g;
        this.f16771h = builder.h;
        this.f16772i = builder.i;
        this.f16773j = builder.j;
        this.f16774k = builder.k;
        this.f16775l = builder.l;
        this.f16776m = builder.m;
        this.f16777n = builder.n;
        this.f16778o = builder.o;
    }
}

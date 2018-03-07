package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
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
/* compiled from: inline_composer_prompt_event */
public final class GraphQLPrivacyEducationInfo extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLPrivacyEducationInfo> CREATOR = new C09801();
    @Nullable
    public GraphQLFullIndexEducationInfo f19897d;
    @Nullable
    public GraphQLPrivacyOption f19898e;
    @Nullable
    public GraphQLReshareEducationInfo f19899f;
    @Nullable
    public GraphQLTagExpansionEducationInfo f19900g;
    @Nullable
    public GraphQLGroupMallAdsEducationInfo f19901h;

    /* compiled from: inline_composer_prompt_event */
    final class C09801 implements Creator<GraphQLPrivacyEducationInfo> {
        C09801() {
        }

        public final Object createFromParcel(Parcel parcel) {
            return new GraphQLPrivacyEducationInfo(parcel);
        }

        public final Object[] newArray(int i) {
            return new GraphQLPrivacyEducationInfo[i];
        }
    }

    @FieldOffset
    @Nullable
    public final GraphQLFullIndexEducationInfo m27668a() {
        this.f19897d = (GraphQLFullIndexEducationInfo) super.m9947a(this.f19897d, 0, GraphQLFullIndexEducationInfo.class);
        return this.f19897d;
    }

    @FieldOffset
    @Nullable
    public final GraphQLPrivacyOption m27670j() {
        this.f19898e = (GraphQLPrivacyOption) super.m9947a(this.f19898e, 1, GraphQLPrivacyOption.class);
        return this.f19898e;
    }

    @FieldOffset
    @Nullable
    public final GraphQLReshareEducationInfo m27671k() {
        this.f19899f = (GraphQLReshareEducationInfo) super.m9947a(this.f19899f, 2, GraphQLReshareEducationInfo.class);
        return this.f19899f;
    }

    @FieldOffset
    @Nullable
    public final GraphQLTagExpansionEducationInfo m27672l() {
        this.f19900g = (GraphQLTagExpansionEducationInfo) super.m9947a(this.f19900g, 3, GraphQLTagExpansionEducationInfo.class);
        return this.f19900g;
    }

    @FieldOffset
    @Nullable
    public final GraphQLGroupMallAdsEducationInfo m27673m() {
        this.f19901h = (GraphQLGroupMallAdsEducationInfo) super.m9947a(this.f19901h, 4, GraphQLGroupMallAdsEducationInfo.class);
        return this.f19901h;
    }

    public final int jK_() {
        return 1177119214;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m27668a() != null) {
            GraphQLFullIndexEducationInfo graphQLFullIndexEducationInfo = (GraphQLFullIndexEducationInfo) graphQLModelMutatingVisitor.mo2928b(m27668a());
            if (m27668a() != graphQLFullIndexEducationInfo) {
                graphQLVisitableModel = (GraphQLPrivacyEducationInfo) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19897d = graphQLFullIndexEducationInfo;
            }
        }
        if (m27673m() != null) {
            GraphQLGroupMallAdsEducationInfo graphQLGroupMallAdsEducationInfo = (GraphQLGroupMallAdsEducationInfo) graphQLModelMutatingVisitor.mo2928b(m27673m());
            if (m27673m() != graphQLGroupMallAdsEducationInfo) {
                graphQLVisitableModel = (GraphQLPrivacyEducationInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19901h = graphQLGroupMallAdsEducationInfo;
            }
        }
        if (m27670j() != null) {
            GraphQLPrivacyOption graphQLPrivacyOption = (GraphQLPrivacyOption) graphQLModelMutatingVisitor.mo2928b(m27670j());
            if (m27670j() != graphQLPrivacyOption) {
                graphQLVisitableModel = (GraphQLPrivacyEducationInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19898e = graphQLPrivacyOption;
            }
        }
        if (m27671k() != null) {
            GraphQLReshareEducationInfo graphQLReshareEducationInfo = (GraphQLReshareEducationInfo) graphQLModelMutatingVisitor.mo2928b(m27671k());
            if (m27671k() != graphQLReshareEducationInfo) {
                graphQLVisitableModel = (GraphQLPrivacyEducationInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19899f = graphQLReshareEducationInfo;
            }
        }
        if (m27672l() != null) {
            GraphQLTagExpansionEducationInfo graphQLTagExpansionEducationInfo = (GraphQLTagExpansionEducationInfo) graphQLModelMutatingVisitor.mo2928b(m27672l());
            if (m27672l() != graphQLTagExpansionEducationInfo) {
                graphQLVisitableModel = (GraphQLPrivacyEducationInfo) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f19900g = graphQLTagExpansionEducationInfo;
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLPrivacyEducationInfo() {
        super(6);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23093a(flatBufferBuilder, m27668a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m27670j());
        int a3 = ModelHelper.m23093a(flatBufferBuilder, m27671k());
        int a4 = ModelHelper.m23093a(flatBufferBuilder, m27672l());
        int a5 = ModelHelper.m23093a(flatBufferBuilder, m27673m());
        flatBufferBuilder.m21510c(5);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21507b(2, a3);
        flatBufferBuilder.m21507b(3, a4);
        flatBufferBuilder.m21507b(4, a5);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLPrivacyEducationInfo(Parcel parcel) {
        super(6);
        this.f19897d = (GraphQLFullIndexEducationInfo) parcel.readValue(GraphQLFullIndexEducationInfo.class.getClassLoader());
        this.f19901h = (GraphQLGroupMallAdsEducationInfo) parcel.readValue(GraphQLGroupMallAdsEducationInfo.class.getClassLoader());
        this.f19898e = (GraphQLPrivacyOption) parcel.readValue(GraphQLPrivacyOption.class.getClassLoader());
        this.f19899f = (GraphQLReshareEducationInfo) parcel.readValue(GraphQLReshareEducationInfo.class.getClassLoader());
        this.f19900g = (GraphQLTagExpansionEducationInfo) parcel.readValue(GraphQLTagExpansionEducationInfo.class.getClassLoader());
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(m27668a());
        parcel.writeValue(m27673m());
        parcel.writeValue(m27670j());
        parcel.writeValue(m27671k());
        parcel.writeValue(m27672l());
    }
}

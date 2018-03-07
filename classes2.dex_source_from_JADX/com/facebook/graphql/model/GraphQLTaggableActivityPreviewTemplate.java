package com.facebook.graphql.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.common.json.AutoGenJsonDeserializer;
import com.facebook.common.json.AutoGenJsonSerializer;
import com.facebook.dracula.api.FieldOffset;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ImmutableListHelper;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.modelutil.TypeModel;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.instagram.common.json.annotation.JsonType;
import java.util.List;
import javax.annotation.Nullable;

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: lightswitch_optin_interstitial */
public final class GraphQLTaggableActivityPreviewTemplate extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLTaggableActivityPreviewTemplate> CREATOR = new 1();
    @Nullable
    public String f17533d;
    public List<GraphQLActivityTemplateToken> f17534e;

    @FieldOffset
    @Nullable
    public final String m24683a() {
        this.f17533d = super.m9948a(this.f17533d, 0);
        return this.f17533d;
    }

    @FieldOffset
    public final ImmutableList<GraphQLActivityTemplateToken> m24684j() {
        this.f17534e = super.m9944a(this.f17534e, 1, GraphQLActivityTemplateToken.class);
        return (ImmutableList) this.f17534e;
    }

    public final int jK_() {
        return -875449780;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24684j() != null) {
            Builder a = ModelHelper.m23097a(m24684j(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLTaggableActivityPreviewTemplate) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17534e = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLTaggableActivityPreviewTemplate() {
        super(3);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int b = flatBufferBuilder.m21502b(m24683a());
        int a = ModelHelper.m23094a(flatBufferBuilder, m24684j());
        flatBufferBuilder.m21510c(2);
        flatBufferBuilder.m21507b(0, b);
        flatBufferBuilder.m21507b(1, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLTaggableActivityPreviewTemplate(Parcel parcel) {
        super(3);
        this.f17533d = parcel.readString();
        this.f17534e = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLActivityTemplateToken.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(m24683a());
        parcel.writeList(m24684j());
    }

    public GraphQLTaggableActivityPreviewTemplate(Builder builder) {
        super(3);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17533d = builder.d;
        this.f17534e = builder.e;
    }
}

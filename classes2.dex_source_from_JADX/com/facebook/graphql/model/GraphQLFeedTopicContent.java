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

@AutoGenJsonDeserializer
@AutoGenJsonSerializer
@Deprecated
@JsonType
/* compiled from: local_awareness_promotion/?page_id=%s&source=%s&referral=%s */
public final class GraphQLFeedTopicContent extends BaseModel implements TypeModel, GraphQLVisitableModel {
    public static final Creator<GraphQLFeedTopicContent> CREATOR = new 1();
    public List<GraphQLExploreFeed> f17172d;

    @FieldOffset
    public final ImmutableList<GraphQLExploreFeed> m24195a() {
        this.f17172d = super.m9944a(this.f17172d, 0, GraphQLExploreFeed.class);
        return (ImmutableList) this.f17172d;
    }

    public final int jK_() {
        return -154297048;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel = null;
        m9958h();
        if (m24195a() != null) {
            Builder a = ModelHelper.m23097a(m24195a(), graphQLModelMutatingVisitor);
            if (a != null) {
                graphQLVisitableModel = (GraphQLFeedTopicContent) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f17172d = a.m1068b();
            }
        }
        m9959i();
        return graphQLVisitableModel == null ? this : graphQLVisitableModel;
    }

    public GraphQLFeedTopicContent() {
        super(2);
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, m24195a());
        flatBufferBuilder.m21510c(1);
        flatBufferBuilder.m21507b(0, a);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public GraphQLFeedTopicContent(Parcel parcel) {
        super(2);
        this.f17172d = ImmutableListHelper.m21625a(parcel.readArrayList(GraphQLExploreFeed.class.getClassLoader()));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(m24195a());
    }

    public GraphQLFeedTopicContent(Builder builder) {
        super(2);
        this.b = builder.f15736a;
        this.c = builder.f15737b;
        this.f17172d = builder.d;
    }
}

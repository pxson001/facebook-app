package com.facebook.graphql.story.util;

import com.facebook.flatbuffers.FlatBuffer;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.FragmentModelWithoutBridge;
import com.facebook.flatbuffers.ModelWithFlatBufferFormatHash;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.modelutil.BaseModel;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLInterfaces$ShouldDisplaySubStoryGalleryGraphQL.AllSubstories;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLModels$ShouldDisplaySubStoryGalleryGraphQLModel.ActorsModel;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLModels$ShouldDisplaySubStoryGalleryGraphQLModel.AllSubstoriesModel;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLModels$ShouldDisplaySubStoryGalleryGraphQLModel.Deserializer;
import com.facebook.graphql.story.util.GraphQLStoryUtilGraphQLModels$ShouldDisplaySubStoryGalleryGraphQLModel.Serializer;
import com.facebook.graphql.visitor.ConsistencyTuple;
import com.facebook.graphql.visitor.GraphQLModelMutatingVisitor;
import com.facebook.graphql.visitor.GraphQLVisitableConsistentModel;
import com.facebook.graphql.visitor.GraphQLVisitableModel;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.List;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@JsonDeserialize(using = Deserializer.class)
@ModelWithFlatBufferFormatHash(a = 1980296064)
@JsonSerialize(using = Serializer.class)
@FragmentModelWithoutBridge
/* compiled from: health_monitor */
public final class C0842x298717ad extends BaseModel implements C0843x6e0cef4c, GraphQLVisitableConsistentModel {
    @Nullable
    private List<ActorsModel> f21127d;
    @Nullable
    private AllSubstoriesModel f21128e;
    private boolean f21129f;

    @Nullable
    public final /* synthetic */ AllSubstories mo3153b() {
        return m28879j();
    }

    public C0842x298717ad() {
        super(3);
    }

    public C0842x298717ad(MutableFlatBuffer mutableFlatBuffer) {
        super(3);
        mo1412a(mutableFlatBuffer, FlatBuffer.m4026a(mutableFlatBuffer.f15021a));
    }

    public final void mo2835a(String str, ConsistencyTuple consistencyTuple) {
        consistencyTuple.m26322a();
    }

    public final void mo2836a(String str, Object obj, boolean z) {
    }

    @Nonnull
    public final ImmutableList<ActorsModel> mo3152a() {
        this.f21127d = super.m9944a(this.f21127d, 0, ActorsModel.class);
        return (ImmutableList) this.f21127d;
    }

    @Nullable
    private AllSubstoriesModel m28879j() {
        this.f21128e = (AllSubstoriesModel) super.m9947a(this.f21128e, 1, AllSubstoriesModel.class);
        return this.f21128e;
    }

    public final boolean mo3154c() {
        m9949a(0, 2);
        return this.f21129f;
    }

    public final int jK_() {
        return 80218325;
    }

    public final GraphQLVisitableModel mo1404a(GraphQLModelMutatingVisitor graphQLModelMutatingVisitor) {
        GraphQLVisitableModel graphQLVisitableModel;
        AllSubstoriesModel allSubstoriesModel;
        m9958h();
        if (mo3152a() != null) {
            Builder a = ModelHelper.m23097a(mo3152a(), graphQLModelMutatingVisitor);
            if (a != null) {
                C0842x298717ad c0842x298717ad = (C0842x298717ad) ModelHelper.m23095a(null, (GraphQLVisitableModel) this);
                c0842x298717ad.f21127d = a.m1068b();
                graphQLVisitableModel = c0842x298717ad;
                if (m28879j() != null) {
                    allSubstoriesModel = (AllSubstoriesModel) graphQLModelMutatingVisitor.mo2928b(m28879j());
                    if (m28879j() != allSubstoriesModel) {
                        graphQLVisitableModel = (C0842x298717ad) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                        graphQLVisitableModel.f21128e = allSubstoriesModel;
                    }
                }
                m9959i();
                return graphQLVisitableModel != null ? this : graphQLVisitableModel;
            }
        }
        graphQLVisitableModel = null;
        if (m28879j() != null) {
            allSubstoriesModel = (AllSubstoriesModel) graphQLModelMutatingVisitor.mo2928b(m28879j());
            if (m28879j() != allSubstoriesModel) {
                graphQLVisitableModel = (C0842x298717ad) ModelHelper.m23095a(graphQLVisitableModel, (GraphQLVisitableModel) this);
                graphQLVisitableModel.f21128e = allSubstoriesModel;
            }
        }
        m9959i();
        if (graphQLVisitableModel != null) {
        }
    }

    public final int mo1403a(FlatBufferBuilder flatBufferBuilder) {
        m9958h();
        int a = ModelHelper.m23094a(flatBufferBuilder, mo3152a());
        int a2 = ModelHelper.m23093a(flatBufferBuilder, m28879j());
        flatBufferBuilder.m21510c(3);
        flatBufferBuilder.m21507b(0, a);
        flatBufferBuilder.m21507b(1, a2);
        flatBufferBuilder.m21498a(2, this.f21129f);
        m9959i();
        return flatBufferBuilder.m21511d();
    }

    public final void mo1406a(MutableFlatBuffer mutableFlatBuffer, int i, Object obj) {
        super.mo1406a(mutableFlatBuffer, i, obj);
        this.f21129f = mutableFlatBuffer.m21540a(i, 2);
    }
}

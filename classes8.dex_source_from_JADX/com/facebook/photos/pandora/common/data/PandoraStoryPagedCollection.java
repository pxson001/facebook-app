package com.facebook.photos.pandora.common.data;

import com.facebook.graphql.enums.GraphQLPhotosAlbumAPIType;
import com.facebook.graphql.model.GraphQLPhoto;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.photos.pandora.common.data.model.PandoraAlbumStoryModel;
import com.facebook.photos.pandora.common.data.model.PandoraDataModel;
import com.facebook.photos.pandora.common.data.model.PandoraDataModelType;
import com.facebook.photos.pandora.common.util.PandoraGraphQLObjectExtractor;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Lists;
import java.util.Collection;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: composer_rating_selector_tapped */
public class PandoraStoryPagedCollection {
    private final Lazy<PandoraGraphQLObjectExtractor> f17362a;
    public ImmutableList<PandoraDataModel> f17363b;
    public boolean f17364c = true;
    public String f17365d;

    private static PandoraStoryPagedCollection m21365b(InjectorLike injectorLike) {
        return new PandoraStoryPagedCollection(IdBasedSingletonScopeProvider.b(injectorLike, 9393));
    }

    @Inject
    public PandoraStoryPagedCollection(Lazy<PandoraGraphQLObjectExtractor> lazy) {
        this.f17362a = lazy;
    }

    public final void m21367a(@Nullable PandoraSlicedFeedResult pandoraSlicedFeedResult) {
        if (pandoraSlicedFeedResult != null && pandoraSlicedFeedResult.f17360a != null) {
            if (Strings.isNullOrEmpty(this.f17365d) || !Objects.equal(this.f17365d, pandoraSlicedFeedResult.f17360a.a())) {
                this.f17365d = pandoraSlicedFeedResult.f17360a.a();
                this.f17364c = pandoraSlicedFeedResult.f17360a.b();
                Builder builder = ImmutableList.builder();
                if (this.f17363b == null) {
                    this.f17363b = builder.b(pandoraSlicedFeedResult.f17361b).b();
                } else if (pandoraSlicedFeedResult.f17361b != null && pandoraSlicedFeedResult.f17361b.size() != 0) {
                    Builder b;
                    PandoraDataModel pandoraDataModel = (PandoraDataModel) this.f17363b.get(this.f17363b.size() - 1);
                    PandoraDataModel pandoraDataModel2 = (PandoraDataModel) pandoraSlicedFeedResult.f17361b.get(0);
                    if (pandoraDataModel.mo1041a() == PandoraDataModelType.ALBUM_POST_SECTION && pandoraDataModel2.mo1041a() == PandoraDataModelType.ALBUM_POST_SECTION && m21364a((PandoraAlbumStoryModel) pandoraDataModel, (PandoraAlbumStoryModel) pandoraDataModel2)) {
                        b = builder.b(this.f17363b.subList(0, this.f17363b.size() - 1)).c(m21366b((PandoraAlbumStoryModel) pandoraDataModel, (PandoraAlbumStoryModel) pandoraDataModel2)).b(pandoraSlicedFeedResult.f17361b.subList(1, pandoraSlicedFeedResult.f17361b.size()));
                    } else {
                        b = builder.b(this.f17363b).b(pandoraSlicedFeedResult.f17361b);
                    }
                    this.f17363b = b.b();
                }
            }
        }
    }

    @VisibleForTesting
    private boolean m21364a(PandoraAlbumStoryModel pandoraAlbumStoryModel, PandoraAlbumStoryModel pandoraAlbumStoryModel2) {
        if (pandoraAlbumStoryModel == null || pandoraAlbumStoryModel2 == null || pandoraAlbumStoryModel.f17368a == null || pandoraAlbumStoryModel2.f17368a == null || pandoraAlbumStoryModel.f17368a.isEmpty() || pandoraAlbumStoryModel2.f17368a.isEmpty()) {
            return false;
        }
        GraphQLStory graphQLStory = (GraphQLStory) pandoraAlbumStoryModel2.f17368a.get(0);
        GraphQLPhoto a = ((PandoraGraphQLObjectExtractor) this.f17362a.get()).m21545a((GraphQLStory) pandoraAlbumStoryModel.f17368a.get(pandoraAlbumStoryModel.f17368a.size() - 1));
        GraphQLPhoto a2 = ((PandoraGraphQLObjectExtractor) this.f17362a.get()).m21545a(graphQLStory);
        return (a == null || a2 == null || a.k() == null || a2.k() == null || !Objects.equal(a.k().u(), a2.k().u()) || a.k().k() != GraphQLPhotosAlbumAPIType.NORMAL || a2.k().k() != GraphQLPhotosAlbumAPIType.NORMAL) ? false : true;
    }

    @VisibleForTesting
    private PandoraAlbumStoryModel m21366b(PandoraAlbumStoryModel pandoraAlbumStoryModel, PandoraAlbumStoryModel pandoraAlbumStoryModel2) {
        if (!m21364a(pandoraAlbumStoryModel, pandoraAlbumStoryModel2)) {
            return null;
        }
        Collection a = Lists.a(pandoraAlbumStoryModel.f17368a);
        a.addAll(pandoraAlbumStoryModel2.f17368a);
        return new PandoraAlbumStoryModel(ImmutableList.copyOf(a));
    }
}

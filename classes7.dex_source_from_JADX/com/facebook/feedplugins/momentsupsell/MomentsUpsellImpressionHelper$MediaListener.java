package com.facebook.feedplugins.momentsupsell;

import com.facebook.graphql.model.GraphQLStory;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLModels.TagInfoQueryModel.EdgesModel;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcher.MediaFetcherListener;
import com.facebook.photos.mediafetcher.interfaces.MediaFetcher.Status;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

/* compiled from: STICKER_PICKER_FRAGMENT_TAG */
public class MomentsUpsellImpressionHelper$MediaListener implements MediaFetcherListener<MediaMetadata> {
    final /* synthetic */ MomentsUpsellImpressionHelper f23552a;
    private GraphQLStory f23553b;
    private MomentsUpsellImpressionHelper$MomentsUpsellFetchedCallback f23554c;

    public final void mo1487a(Status status) {
        String str = MomentsUpsellImpressionHelper.a;
        status.toString();
        if (status != Status.CLOSED && status != Status.DONE) {
            Status status2 = Status.ERROR;
        }
    }

    public MomentsUpsellImpressionHelper$MediaListener(MomentsUpsellImpressionHelper momentsUpsellImpressionHelper, GraphQLStory graphQLStory, MomentsUpsellImpressionHelper$MomentsUpsellFetchedCallback momentsUpsellImpressionHelper$MomentsUpsellFetchedCallback) {
        this.f23552a = momentsUpsellImpressionHelper;
        this.f23553b = graphQLStory;
        this.f23554c = momentsUpsellImpressionHelper$MomentsUpsellFetchedCallback;
    }

    public final void mo1488a(ImmutableList<MediaMetadata> immutableList) {
        int size = immutableList.size();
        int i = 0;
        while (i < size) {
            Object obj;
            MediaMetadata mediaMetadata = (MediaMetadata) immutableList.get(i);
            String str = MomentsUpsellImpressionHelper.a;
            mediaMetadata.d();
            Integer.valueOf(mediaMetadata.U().a().size());
            MomentsUpsellImpressionHelper momentsUpsellImpressionHelper = this.f23552a;
            ImmutableList a = mediaMetadata.U().a();
            int size2 = a.size();
            for (int i2 = 0; i2 < size2; i2++) {
                EdgesModel edgesModel = (EdgesModel) a.get(i2);
                edgesModel.b().c();
                momentsUpsellImpressionHelper.d.get();
                if (Objects.equal(edgesModel.b().c(), momentsUpsellImpressionHelper.d.get())) {
                    obj = 1;
                    break;
                }
            }
            obj = null;
            if (obj == null || !MomentsUpsellImpressionHelper.a(this.f23552a, this.f23553b, mediaMetadata.U().a()) || !MomentsUpsellImpressionHelper.c(this.f23552a) || this.f23553b.g() == null) {
                i++;
            } else {
                this.f23552a.n.add(this.f23553b.g());
                return;
            }
        }
    }
}

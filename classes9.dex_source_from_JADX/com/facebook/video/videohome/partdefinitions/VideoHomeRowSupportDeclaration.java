package com.facebook.video.videohome.partdefinitions;

import com.facebook.feed.rows.core.FeedRowSupportDeclaration;
import com.facebook.feed.rows.core.ListItemRowController;
import com.facebook.multirow.api.ViewType;
import com.google.common.collect.ImmutableList;

/* compiled from: size_param */
public class VideoHomeRowSupportDeclaration implements FeedRowSupportDeclaration {
    public final void m2995a(ListItemRowController listItemRowController) {
        ImmutableList of = ImmutableList.of(VideoHomeGapPartDefinition.f3068a, VideoHomeVideoChannelFeedUnitPartDefinition.f3225a, VideoHomeVideoChannelFeedUnitSquareGroupPartDefinition.f3237a, VideoHomeVideoChannelFeedUnitSquareVideoPartDefinition.f3242a, VideoHomeClippedPublisherInfoPartDefinition.f3034a, VideoHomeComposerPartDefinition.f3038a, VideoHomeExploreFeedRecommendationUnitPartDefinition.f3058a, VideoHomeLoadingPageHscrollLiveVideoPartDefinition.f3085a, VideoHomeSectionHeaderPartDefinition.f3147a, VideoHomeSeeMorePartDefinition.f3156a, VideoHomeShortcutPartDefinition.f3165a, VideoHomeSingleLineDescriptionPartDefinition.f3173a, new ViewType[]{VideoHomeSpinnerPartDefinition.f3177a, VideoHomeTagsPartDefinition.f3180a, VideoHomeTopBorderPartDefinition.f3184a, VideoHomeVideoChannelRecommendationSquarePartDefinition.f3248a});
        int size = of.size();
        for (int i = 0; i < size; i++) {
            listItemRowController.a((ViewType) of.get(i));
        }
    }
}

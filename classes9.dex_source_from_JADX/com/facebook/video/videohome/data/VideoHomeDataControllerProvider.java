package com.facebook.video.videohome.data;

import com.facebook.feed.data.FeedStorySubscriber;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.reaction.ReactionUtil;
import com.facebook.reaction.common.ReactionUnitValidator;
import com.facebook.video.videohome.fragment.VideoHomeHomeFragment.C02762;
import com.facebook.video.videohome.pagination.VideoHomePaginationCoordinator;
import com.facebook.video.videohome.utils.VideoHomeLiveUpdatesHelper;

/* compiled from: status_payload */
public class VideoHomeDataControllerProvider extends AbstractAssistedProvider<VideoHomeDataController> {
    public final VideoHomeDataController m2700a(C02762 c02762) {
        return new VideoHomeDataController(c02762, FeedStorySubscriber.b(this), VideoHomeReactionItemCollection.m2722c((InjectorLike) this), new VideoHomePaginationCoordinator(), ReactionUtil.a(this), ReactionUnitValidator.b(this), (QeAccessor) QeInternalImplMethodAutoProvider.a(this), VideoHomeLiveUpdatesHelper.m3160b((InjectorLike) this));
    }
}

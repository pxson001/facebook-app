package com.facebook.feed.rows.photosfeed;

import com.facebook.api.feed.data.EndOfFeedSentinel.EndOfFeedSentinelFeedUnit;
import com.facebook.api.feed.data.LoadingMoreSentinel.LoadingMoreSentinelFeedUnit;
import com.facebook.feed.rows.core.parts.RootPartSelector;
import com.facebook.feed.rows.sections.common.EmptyPartDefinition;
import com.facebook.feed.rows.sections.common.loadingmore.LoadingMorePartDefinition;
import com.facebook.feed.rows.sections.common.unknown.UnknownFeedUnitMultiRowGroupPartDefinition;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.multirow.api.AnyEnvironment;
import com.facebook.multirow.api.BaseMultiRowGroupPartDefinition;
import com.facebook.multirow.api.BaseMultiRowSubParts;
import com.facebook.photos.data.protocol.PhotosMetadataGraphQLInterfaces.MediaMetadata;
import javax.inject.Inject;

/* compiled from: about_to_finish */
public class PhotosFeedBasicRootPartDefinition extends BaseMultiRowGroupPartDefinition<Object, Void, PhotosFeedEnvironment> {
    private final RootPartSelector<PhotosFeedEnvironment> f20198a;

    @Inject
    public PhotosFeedBasicRootPartDefinition(@Assisted Lazy<? extends BaseMultiRowGroupPartDefinition<MediaMetadata, Void, PhotosFeedEnvironment>> lazy, Lazy<LoadingMorePartDefinition> lazy2, Lazy<UnknownFeedUnitMultiRowGroupPartDefinition> lazy3, Lazy<EmptyPartDefinition> lazy4) {
        this.f20198a = RootPartSelector.a().a(MediaMetadata.class, lazy).b(LoadingMoreSentinelFeedUnit.class, lazy2).a(EndOfFeedSentinelFeedUnit.class, lazy4).a(Object.class, lazy3);
    }

    public final boolean m23332a(Object obj) {
        return true;
    }

    public final Object m23331a(BaseMultiRowSubParts baseMultiRowSubParts, Object obj, AnyEnvironment anyEnvironment) {
        this.f20198a.a(baseMultiRowSubParts, obj);
        return null;
    }
}

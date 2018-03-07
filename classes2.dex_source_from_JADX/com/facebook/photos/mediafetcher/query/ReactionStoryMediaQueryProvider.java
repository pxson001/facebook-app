package com.facebook.photos.mediafetcher.query;

import com.facebook.common.callercontext.CallerContext;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.photos.mediafetcher.query.param.IdQueryParam;
import com.facebook.photos.mediafetcher.util.MediaMetadataUtil;

/* compiled from: groups_direct_file_download */
public class ReactionStoryMediaQueryProvider extends AbstractAssistedProvider<ReactionStoryMediaQuery> {
    public final ReactionStoryMediaQuery m29270a(IdQueryParam idQueryParam, CallerContext callerContext) {
        return new ReactionStoryMediaQuery(idQueryParam, callerContext, MediaMetadataUtil.a(this));
    }
}

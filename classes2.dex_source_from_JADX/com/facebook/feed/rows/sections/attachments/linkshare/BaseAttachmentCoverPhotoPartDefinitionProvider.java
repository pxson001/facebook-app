package com.facebook.feed.rows.sections.attachments.linkshare;

import android.view.View;
import com.facebook.attachments.angora.AttachmentHasLargeImage;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasPositionInformation;
import com.facebook.feed.environment.HasPrefetcher;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;

/* compiled from: fetch_recent_stickers */
public class BaseAttachmentCoverPhotoPartDefinitionProvider extends AbstractAssistedProvider<BaseAttachmentCoverPhotoPartDefinition> {
    public final <E extends HasPositionInformation & HasPrefetcher & HasImageLoadListener, V extends View & AttachmentHasLargeImage> BaseAttachmentCoverPhotoPartDefinition<E, V> m32334a(CallerContext callerContext, float f, CoverPhotoImageProvider coverPhotoImageProvider) {
        return new BaseAttachmentCoverPhotoPartDefinition(GatekeeperStoreImplMethodAutoProvider.m2131a(this), FbDraweeControllerBuilder.m19410b((InjectorLike) this), FbErrorReporterImpl.m2317a((InjectorLike) this), callerContext, f, coverPhotoImageProvider);
    }
}

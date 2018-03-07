package com.facebook.composer.ui.underwood;

import android.content.Context;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.model.ComposerContentType.ProvidesContentType;
import com.facebook.slideshow.analytics.SlideshowLogger;
import com.facebook.widget.mediareorderview.UnderwoodBitmapWidthHelper;

/* compiled from: compactdisk-jni */
public class SlideshowAttachmentViewControllerProvider extends AbstractAssistedProvider<SlideshowAttachmentViewController> {
    public final <DataProvider extends ProvidesAttachments & ProvidesContentType & ProvidesSessionId> SlideshowAttachmentViewController<DataProvider> m21105a(DataProvider dataProvider, Integer num, AttachmentsEventListener attachmentsEventListener) {
        return new SlideshowAttachmentViewController((ProvidesAttachments) dataProvider, num, attachmentsEventListener, (Context) getInstance(Context.class), FbDraweeControllerBuilder.b(this), UnderwoodBitmapWidthHelper.a(this), SlideshowLogger.b(this));
    }
}

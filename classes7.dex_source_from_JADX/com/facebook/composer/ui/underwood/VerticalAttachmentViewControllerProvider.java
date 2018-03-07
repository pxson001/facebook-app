package com.facebook.composer.ui.underwood;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.ui.underwood.TaggingController.TagsChangedListener;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsComposerDrawn;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.photos.creativeediting.analytics.CreativeEditingUsageLogger.EventListener;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.ScrollingAwareScrollView;

/* compiled from: comment_sticker_viewed */
public class VerticalAttachmentViewControllerProvider extends AbstractAssistedProvider<VerticalAttachmentViewController> {
    public final <DataProvider extends ProvidesAttachments & ProvidesIsComposerDrawn & ProvidesTargetData> VerticalAttachmentViewController<DataProvider> m21231a(FragmentManager fragmentManager, Integer num, Integer num2, String str, boolean z, boolean z2, AttachmentsEventListener attachmentsEventListener, EventListener eventListener, DataProvider dataProvider, TagsChangedListener tagsChangedListener, boolean z3, boolean z4, ScrollingAwareScrollView scrollingAwareScrollView) {
        return new VerticalAttachmentViewController(fragmentManager, num, num2, str, z, z2, attachmentsEventListener, eventListener, (ProvidesAttachments) dataProvider, tagsChangedListener, z3, z4, scrollingAwareScrollView, (Context) getInstance(Context.class), ComposerAttachmentViewUtility.m21070a((InjectorLike) this), TasksManager.a(this));
    }
}

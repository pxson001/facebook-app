package com.facebook.feed.rows.sections;

import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.sections.attachments.AttachmentLinkPartDefinition;
import com.facebook.feed.rows.sections.attachments.calltoaction.ActionButtonPartDefinition;
import com.facebook.feed.ui.imageloader.FeedImageLoader;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: \n */
public class SubStoriesAttachmentPartDefinitionProvider extends AbstractAssistedProvider<SubStoriesAttachmentPartDefinition> {
    public final <E extends HasInvalidate> SubStoriesAttachmentPartDefinition<E> m23535a(Float f) {
        return new SubStoriesAttachmentPartDefinition(f, PhotoPartDefinition.m23515a(this), SubStoriesTitlePartDefinition.m23551a(this), SubStoriesSubtitlePartDefinition.m23547a(this), ActionButtonPartDefinition.a(this), AttachmentLinkPartDefinition.a(this), FbDraweeControllerBuilder.b(this), FeedImageLoader.a(this));
    }
}

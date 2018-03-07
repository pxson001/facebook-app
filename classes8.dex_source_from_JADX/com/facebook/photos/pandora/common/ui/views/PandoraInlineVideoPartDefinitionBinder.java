package com.facebook.photos.pandora.common.ui.views;

import com.facebook.attachments.videos.ui.InlineVideoAttachmentView;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.feed.rows.core.parts.SinglePartDefinitionBinder;
import com.facebook.feedplugins.attachments.video.InlineVideoPartDefinition;
import com.facebook.feedplugins.attachments.video.InlineVideoPartDefinition.Props;
import com.facebook.feedplugins.attachments.video.InlineVideoPartDefinition.State;
import com.facebook.inject.Assisted;
import javax.inject.Inject;

/* compiled from: com.facebook.widget.UrlImage */
public class PandoraInlineVideoPartDefinitionBinder {
    public final InlineVideoPartDefinition f17547a;
    public final PandoraInlineVideoEnvironment f17548b;
    public final AbstractFbErrorReporter f17549c;
    public SinglePartDefinitionBinder<Props, State, PandoraInlineVideoEnvironment, InlineVideoAttachmentView> f17550d;

    @Inject
    public PandoraInlineVideoPartDefinitionBinder(@Assisted PandoraInlineVideoEnvironment pandoraInlineVideoEnvironment, InlineVideoPartDefinition inlineVideoPartDefinition, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f17547a = inlineVideoPartDefinition;
        this.f17548b = pandoraInlineVideoEnvironment;
        this.f17549c = abstractFbErrorReporter;
    }
}

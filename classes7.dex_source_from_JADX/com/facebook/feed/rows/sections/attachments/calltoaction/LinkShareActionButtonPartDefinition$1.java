package com.facebook.feed.rows.sections.attachments.calltoaction;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.model.GraphQLStoryActionLink;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerShareParams.Builder;
import com.facebook.ipc.composer.model.ComposerSourceType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: WHY_AM_I_SEEING_THIS */
class LinkShareActionButtonPartDefinition$1 implements OnClickListener {
    final /* synthetic */ GraphQLStoryActionLink f20876a;
    final /* synthetic */ LinkShareActionButtonPartDefinition f20877b;

    LinkShareActionButtonPartDefinition$1(LinkShareActionButtonPartDefinition linkShareActionButtonPartDefinition, GraphQLStoryActionLink graphQLStoryActionLink) {
        this.f20877b = linkShareActionButtonPartDefinition;
        this.f20876a = graphQLStoryActionLink;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 454323362);
        LinkShareActionButtonPartDefinition linkShareActionButtonPartDefinition = this.f20877b;
        linkShareActionButtonPartDefinition.b.a(null, ComposerConfigurationFactory.a(ComposerSourceType.FEED, Builder.a(this.f20876a.aE()).b()).setIsEditTagEnabled(false).setNectarModule("newsfeed_composer").setDisableFriendTagging(true).setDisableMentions(true).a(), 1756, linkShareActionButtonPartDefinition.a);
        Logger.a(2, EntryType.UI_INPUT_END, 1161698552, a);
    }
}

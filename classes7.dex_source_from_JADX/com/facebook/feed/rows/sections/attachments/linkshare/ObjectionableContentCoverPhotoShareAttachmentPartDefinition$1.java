package com.facebook.feed.rows.sections.attachments.linkshare;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.HasImageLoadListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: VideoStripController */
class ObjectionableContentCoverPhotoShareAttachmentPartDefinition$1 implements OnClickListener {
    final /* synthetic */ GraphQLStory f20995a;
    final /* synthetic */ HasImageLoadListener f20996b;
    final /* synthetic */ FeedProps f20997c;
    final /* synthetic */ ObjectionableContentCoverPhotoShareAttachmentPartDefinition f20998d;

    ObjectionableContentCoverPhotoShareAttachmentPartDefinition$1(ObjectionableContentCoverPhotoShareAttachmentPartDefinition objectionableContentCoverPhotoShareAttachmentPartDefinition, GraphQLStory graphQLStory, HasImageLoadListener hasImageLoadListener, FeedProps feedProps) {
        this.f20998d = objectionableContentCoverPhotoShareAttachmentPartDefinition;
        this.f20995a = graphQLStory;
        this.f20996b = hasImageLoadListener;
        this.f20997c = feedProps;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1340786578);
        this.f20998d.d.a(this.f20995a.c());
        ((HasInvalidate) this.f20996b).a(new FeedProps[]{this.f20997c});
        Logger.a(2, EntryType.UI_INPUT_END, -651129481, a);
    }
}

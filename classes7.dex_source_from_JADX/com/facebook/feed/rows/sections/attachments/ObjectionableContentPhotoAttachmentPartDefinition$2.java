package com.facebook.feed.rows.sections.attachments;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.environment.HasInvalidate;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.graphql.model.GraphQLMedia;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: YourAvailableForSalePosts */
class ObjectionableContentPhotoAttachmentPartDefinition$2 implements OnClickListener {
    final /* synthetic */ GraphQLMedia f20728a;
    final /* synthetic */ HasInvalidate f20729b;
    final /* synthetic */ FeedProps f20730c;
    final /* synthetic */ ObjectionableContentPhotoAttachmentPartDefinition f20731d;

    ObjectionableContentPhotoAttachmentPartDefinition$2(ObjectionableContentPhotoAttachmentPartDefinition objectionableContentPhotoAttachmentPartDefinition, GraphQLMedia graphQLMedia, HasInvalidate hasInvalidate, FeedProps feedProps) {
        this.f20731d = objectionableContentPhotoAttachmentPartDefinition;
        this.f20728a = graphQLMedia;
        this.f20729b = hasInvalidate;
        this.f20730c = feedProps;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1099557553);
        this.f20731d.f.a(this.f20728a.b());
        this.f20729b.a(new FeedProps[]{this.f20730c});
        Logger.a(2, EntryType.UI_INPUT_END, 792926729, a);
    }
}

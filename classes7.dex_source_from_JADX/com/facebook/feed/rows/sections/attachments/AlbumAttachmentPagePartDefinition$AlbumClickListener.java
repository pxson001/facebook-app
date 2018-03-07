package com.facebook.feed.rows.sections.attachments;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.attachments.photos.launcherhelper.PhotoGalleryLauncherHelper;
import com.facebook.feed.rows.core.props.AttachmentProps;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.attachments.ui.AlbumAttachmentItemView;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.StoryAttachmentHelper;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: [createActor] Empty name */
class AlbumAttachmentPagePartDefinition$AlbumClickListener implements OnClickListener {
    final /* synthetic */ AlbumAttachmentPagePartDefinition f20490a;
    private final ImageRequest f20491b;
    private final FeedProps<GraphQLStoryAttachment> f20492c;

    public AlbumAttachmentPagePartDefinition$AlbumClickListener(AlbumAttachmentPagePartDefinition albumAttachmentPagePartDefinition, ImageRequest imageRequest, FeedProps<GraphQLStoryAttachment> feedProps) {
        this.f20490a = albumAttachmentPagePartDefinition;
        this.f20491b = imageRequest;
        this.f20492c = feedProps;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -2120229859);
        FeedProps e = AttachmentProps.e(this.f20492c);
        ((PhotoGalleryLauncherHelper) this.f20490a.e.get()).m901a(e.a(StoryAttachmentHelper.o((GraphQLStory) e.a)), this.f20492c, ((AlbumAttachmentItemView) view).f21053b, this.f20491b, false, -1, null);
        Logger.a(2, EntryType.UI_INPUT_END, -1303416016, a);
    }
}

package com.facebook.reaction.feed.unitcomponents.partdefinition;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.reaction.common.ReactionAttachmentIntent;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;

/* compiled from: addPhotosFromReaction */
class ReactionPhotoFullWidthPartDefinition$1 implements OnClickListener {
    final /* synthetic */ CanLaunchReactionIntent f19933a;
    final /* synthetic */ ReactionPhotoFullWidthPartDefinition$Props f19934b;
    final /* synthetic */ ReactionAttachmentIntent f19935c;
    final /* synthetic */ ReactionPhotoFullWidthPartDefinition f19936d;

    ReactionPhotoFullWidthPartDefinition$1(ReactionPhotoFullWidthPartDefinition reactionPhotoFullWidthPartDefinition, CanLaunchReactionIntent canLaunchReactionIntent, ReactionPhotoFullWidthPartDefinition$Props reactionPhotoFullWidthPartDefinition$Props, ReactionAttachmentIntent reactionAttachmentIntent) {
        this.f19936d = reactionPhotoFullWidthPartDefinition;
        this.f19933a = canLaunchReactionIntent;
        this.f19934b = reactionPhotoFullWidthPartDefinition$Props;
        this.f19935c = reactionAttachmentIntent;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1828165546);
        this.f19933a.mo695a(this.f19934b.f19939c, this.f19934b.f19940d, this.f19935c);
        Logger.a(2, EntryType.UI_INPUT_END, -411681181, a);
    }
}

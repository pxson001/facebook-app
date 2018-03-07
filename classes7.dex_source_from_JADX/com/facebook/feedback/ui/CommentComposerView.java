package com.facebook.feedback.ui;

import android.view.View;
import com.facebook.api.ufiservices.common.FeedbackLoggingParams;
import com.facebook.feedback.ui.CommentsHelper.C04006;
import com.facebook.feedback.ui.CommentsHelper.C04017;
import com.facebook.graphql.model.GraphQLFeedback;
import com.facebook.ipc.media.MediaItem;
import com.facebook.notifications.logging.NotificationsLogger.NotificationLogObject;
import com.facebook.tagging.model.TaggingProfile;

/* compiled from: see_photo_remix_button */
public interface CommentComposerView extends Bindable<GraphQLFeedback> {
    void mo240a(TaggingProfile taggingProfile);

    void mo242a(String str, boolean z);

    boolean mo243a(float f, float f2);

    void mo244g();

    View getPhotoButton();

    View getSelfAsView();

    boolean mo247h();

    void mo248i();

    boolean mo249j();

    void mo250k();

    void mo251l();

    void mo252m();

    void mo253n();

    void setFeedbackLoggingParams(FeedbackLoggingParams feedbackLoggingParams);

    void setGroupIdForTagging(Long l);

    void setMediaItem(MediaItem mediaItem);

    void setNotificationLogObject(NotificationLogObject notificationLogObject);

    void setOnMediaPickerOpenListener(C04006 c04006);

    void setReshareButtonExperimentClicked(boolean z);

    void setTransliterationClickListener(C04017 c04017);

    void setVisibility(int i);
}

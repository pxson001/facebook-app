package com.facebook.timeline.header.coverphoto;

import com.facebook.caspian.ui.standardheader.StandardCoverPhotoView;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.timeline.header.data.TimelineHeaderUserData;

/* compiled from: finish_registration_notif_created */
public class TimelineCoverPhotoControllerListenerProvider extends AbstractAssistedProvider<TimelineCoverPhotoControllerListener> {
    public static TimelineCoverPhotoControllerListener m11725a(StandardCoverPhotoView standardCoverPhotoView, TimelineCoverPhotoLoggingHelper timelineCoverPhotoLoggingHelper, TimelineHeaderUserData timelineHeaderUserData) {
        return new TimelineCoverPhotoControllerListener(standardCoverPhotoView, timelineCoverPhotoLoggingHelper, timelineHeaderUserData);
    }
}

package com.facebook.composer.publish.compost.story;

import android.net.Uri;
import com.google.common.base.Optional;
import javax.annotation.concurrent.Immutable;

@Immutable
/* compiled from: photo_upload_life_event */
public interface CompostStory {

    /* compiled from: photo_upload_life_event */
    public enum StoryType {
        POST,
        PROFILE_PIC,
        COVER_PHOTO
    }

    int mo930b();

    long mo931c();

    Optional<String> mo932d();

    Optional<Uri> mo933e();

    String mo934f();
}

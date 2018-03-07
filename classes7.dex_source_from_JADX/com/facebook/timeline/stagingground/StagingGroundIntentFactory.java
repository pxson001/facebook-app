package com.facebook.timeline.stagingground;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration;
import com.facebook.ipc.editgallery.EditGalleryLaunchConfiguration.Builder;
import com.facebook.ipc.videoeditgallery.VideoEditGalleryLaunchConfiguration;

/* compiled from: fallbackViewCreator */
public class StagingGroundIntentFactory {
    public static Intent m18666a(Context context, StagingGroundLaunchConfig stagingGroundLaunchConfig, @Nullable EditGalleryLaunchConfiguration editGalleryLaunchConfiguration) {
        Intent intent = new Intent(context, StagingGroundActivity.class);
        intent.putExtra("key_staging_ground_launch_config", stagingGroundLaunchConfig);
        String str = "extra_edit_gallery_launch_settings";
        if (editGalleryLaunchConfiguration == null) {
            editGalleryLaunchConfiguration = new Builder().a();
        }
        intent.putExtra(str, editGalleryLaunchConfiguration);
        return intent;
    }

    public static Intent m18667a(Context context, StagingGroundLaunchConfig stagingGroundLaunchConfig, VideoEditGalleryLaunchConfiguration videoEditGalleryLaunchConfiguration) {
        Intent intent = new Intent(context, StagingGroundActivity.class);
        intent.putExtra("key_staging_ground_launch_config", stagingGroundLaunchConfig);
        intent.putExtra("extra_video_edit_gallery_launch_settings", videoEditGalleryLaunchConfiguration);
        return intent;
    }
}

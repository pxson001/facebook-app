package com.facebook.photos.simplepicker.logging;

import com.facebook.photos.simplepicker.LegacySimplePickerFragment;
import com.facebook.photos.simplepicker.SimplePickerFragment;
import com.facebook.photos.simplepicker.launcher.SimplePickerLauncherActivity;
import com.facebook.photos.thumbnailsource.ThumbnailSource;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.google.common.collect.ImmutableSet;

/* compiled from: shadow-color */
public final class SimplePickerSequences {
    public static final LaunchSequence f3186a = new LaunchSequence();

    /* compiled from: shadow-color */
    public final class LaunchSequence extends AbstractSequenceDefinition {
        public LaunchSequence() {
            super(1310724, "SimplepickerLaunchSequence", false, ImmutableSet.of(SimplePickerLauncherActivity.class.getName(), SimplePickerFragment.class.getName(), LegacySimplePickerFragment.class.getName(), ThumbnailSource.class.getName()));
        }
    }
}

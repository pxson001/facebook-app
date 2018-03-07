package com.facebook.bitmaps.logging;

import com.facebook.bitmaps.NativeImageResizer;
import com.facebook.bitmaps.ThumbnailMaker;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.NoOpSequence;
import com.google.common.collect.ImmutableSet;

/* compiled from: android.support.PARENT_ACTIVITY */
public class BitmapSequences {
    public static final ThumbnailMakerSequence f10403a = new ThumbnailMakerSequence();
    public static final NoOpSequence<ThumbnailMakerSequence> f10404b = new NoOpSequence();

    /* compiled from: android.support.PARENT_ACTIVITY */
    public enum GenerateThumbnailMethod {
        VIDEO,
        EXIF,
        NATIVE_RESIZER,
        JAVA_RESIZER,
        MEDIASTORE_IMAGE
    }

    /* compiled from: android.support.PARENT_ACTIVITY */
    public final class ThumbnailMakerSequence extends AbstractSequenceDefinition {
        public ThumbnailMakerSequence() {
            super(851969, "ThumbnailMakerSequence", false, ImmutableSet.of(ThumbnailMaker.class.getName(), NativeImageResizer.class.getName()));
        }
    }
}

package com.facebook.photos.thumbnailsource;

import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.sequencelogger.NoOpSequence;
import com.google.common.collect.ImmutableSet;

/* compiled from: selected_existing_place */
public class ThumbnailSourceSequences {
    public static final ThumbnailDecodingSequence f3493a = new ThumbnailDecodingSequence();
    public static NoOpSequence<ThumbnailDecodingSequence> f3494b;

    /* compiled from: selected_existing_place */
    public final class ThumbnailDecodingSequence extends AbstractSequenceDefinition {
        public ThumbnailDecodingSequence() {
            super(1310725, "ThumbnailDecodingSequence", false, ImmutableSet.of(ThumbnailSource.class.getName()));
        }
    }
}

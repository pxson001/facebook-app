package com.facebook.photos.pandora.logging;

import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.google.common.collect.ImmutableSet;

/* compiled from: com.facebook.platform.extra.COMPOSER_ERROR */
public class PandoraSequences {
    public static final PandoraStartSequence f17581a = new PandoraStartSequence();

    /* compiled from: com.facebook.platform.extra.COMPOSER_ERROR */
    public final class PandoraStartSequence extends AbstractSequenceDefinition {
        public PandoraStartSequence() {
            super(1310723, "PandoraLoading", false, ImmutableSet.of("com.facebook.photos.pandora.ui.PandoraTabPagerActivity", "com.facebook.photos.pandora.ui.PandoraTabPagerFragment"));
        }
    }
}

package com.facebook.instantarticles.logging;

import com.facebook.instantarticles.InstantArticlesActivity;
import com.facebook.instantarticles.InstantArticlesExternalIntentHandler;
import com.facebook.instantarticles.InstantArticlesFragment;
import com.facebook.richdocument.BaseRichDocumentActivity;
import com.facebook.richdocument.RichDocumentFragment;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.google.common.collect.ImmutableSet;

/* compiled from: video_tapped */
public class InstantArticlesSequences {
    public static final InstantArticlesLoadSequence f482a = new InstantArticlesLoadSequence();

    /* compiled from: video_tapped */
    public class InstantArticlesLoadSequence extends AbstractSequenceDefinition {
        public InstantArticlesLoadSequence() {
            super(6029313, "RichDocumentLoad", true, ImmutableSet.of(RichDocumentFragment.class.getName(), InstantArticlesFragment.class.getName(), BaseRichDocumentActivity.class.getName(), InstantArticlesActivity.class.getName(), InstantArticlesExternalIntentHandler.class.getName()));
        }
    }
}

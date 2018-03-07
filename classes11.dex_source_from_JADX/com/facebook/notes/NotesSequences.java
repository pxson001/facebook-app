package com.facebook.notes;

import com.facebook.instantarticles.InstantArticlesActivity;
import com.facebook.instantarticles.InstantArticlesExternalIntentHandler;
import com.facebook.richdocument.RichDocumentDelegateImpl;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.google.common.collect.ImmutableSet;

/* compiled from: Unable to set reaction reviews card data */
public class NotesSequences {
    public static final NotesLoadSequence f10477a = new NotesLoadSequence();

    /* compiled from: Unable to set reaction reviews card data */
    public final class NotesLoadSequence extends AbstractSequenceDefinition {
        public NotesLoadSequence() {
            super(8585217, "NotesLoad", true, ImmutableSet.of(NotesActivity.class.getName(), NotesDelegateImpl.class.getName(), RichDocumentDelegateImpl.class.getName(), InstantArticlesActivity.class.getName(), InstantArticlesExternalIntentHandler.class.getName()));
        }
    }
}

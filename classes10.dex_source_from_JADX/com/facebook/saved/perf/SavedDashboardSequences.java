package com.facebook.saved.perf;

import com.facebook.saved.fragment.SavedFragment;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.google.common.collect.ImmutableSet;

/* compiled from: intent_model_state */
public class SavedDashboardSequences {
    public static final SavedDashboardStartSequence f9227a = new SavedDashboardStartSequence();

    /* compiled from: intent_model_state */
    public final class SavedDashboardStartSequence extends AbstractSequenceDefinition {
        public SavedDashboardStartSequence() {
            super(1572865, "SavedDashboardStartSequence", false, ImmutableSet.of(SavedFragment.class.getName()));
        }
    }
}

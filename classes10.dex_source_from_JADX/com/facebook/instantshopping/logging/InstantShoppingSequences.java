package com.facebook.instantshopping.logging;

import com.facebook.instantshopping.InstantShoppingDocumentFragment;
import com.facebook.instantshopping.InstantShoppingRichDocumentActivity;
import com.facebook.instantshopping.InstantShoppingUriIntentBuilder;
import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.google.common.collect.ImmutableSet;

/* compiled from: ShareType */
public class InstantShoppingSequences {
    public static final InstantShoppingCatalogLoadSequence f23575a = new InstantShoppingCatalogLoadSequence();

    /* compiled from: ShareType */
    public final class InstantShoppingCatalogLoadSequence extends AbstractSequenceDefinition {
        public InstantShoppingCatalogLoadSequence() {
            super(6684673, "instant_shopping_catalog_sequence_events", false, ImmutableSet.of(InstantShoppingDocumentFragment.class.getName(), InstantShoppingRichDocumentActivity.class.getName(), InstantShoppingUriIntentBuilder.class.getName()));
        }
    }
}

package com.facebook.composer.inlinesprouts;

import com.facebook.composer.inlinesprouts.model.InlineSproutsStateSpec.ProvidesInlineSproutsState;
import com.facebook.composer.inlinesprouts.model.InlineSproutsStateSpec.SetsInlineSproutsState;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;

/* compiled from: fundraiser_personal_update_mutation_failure */
public class FacecastSproutNuxControllerProvider extends AbstractAssistedProvider<FacecastSproutNuxController> {
    public final <DataProvider extends ProvidesInlineSproutsState, Transaction extends ComposerTransaction & SetsInlineSproutsState<Transaction>> FacecastSproutNuxController<DataProvider, Transaction> m8011a(DataProvider dataProvider, ComposerMutator<Transaction> composerMutator) {
        return new FacecastSproutNuxController(dataProvider, composerMutator, InlineSproutsQeWrapper.m8044a(this), TipSeenTracker.b(this));
    }
}

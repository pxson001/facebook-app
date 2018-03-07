package com.facebook.composer.inlinesprouts;

import com.facebook.composer.activity.TransactionImpl;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.inlinesprouts.model.InlineSproutsState;
import com.facebook.composer.inlinesprouts.model.InlineSproutsStateSpec.ProvidesInlineSproutsState;
import com.facebook.composer.inlinesprouts.model.InlineSproutsStateSpec.SetsInlineSproutsState;
import com.facebook.composer.prefs.ComposerPrefKeys;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.feed.util.composer.sprout.SproutNuxProvider;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerMutator;
import com.facebook.ipc.composer.dataaccessor.ComposerTransaction;
import com.facebook.uicontrib.tipseentracker.TipSeenTracker;
import javax.inject.Inject;

/* compiled from: fundraiser_personal_update_mutation_success */
public class FacecastSproutNuxController<DataProvider extends ProvidesInlineSproutsState, Transaction extends ComposerTransaction & SetsInlineSproutsState<Transaction>> implements SproutNuxProvider {
    public static final ComposerEventOriginator f6546a = ComposerEventOriginator.a(FacecastSproutNuxController.class);
    public final DataProvider f6547b;
    public final ComposerMutator<Transaction> f6548c;
    private final InlineSproutsQeWrapper f6549d;
    public final TipSeenTracker f6550e;

    @Inject
    public FacecastSproutNuxController(@Assisted DataProvider dataProvider, @Assisted ComposerMutator<Transaction> composerMutator, InlineSproutsQeWrapper inlineSproutsQeWrapper, TipSeenTracker tipSeenTracker) {
        this.f6547b = dataProvider;
        this.f6548c = composerMutator;
        this.f6549d = inlineSproutsQeWrapper;
        this.f6550e = tipSeenTracker;
        this.f6550e.a(ComposerPrefKeys.s);
        this.f6550e.b = 3;
    }

    public final int m8008a() {
        InlineSproutsState aA = this.f6547b.aA() != null ? this.f6547b.aA() : InlineSproutsState.newBuilder().m8091a();
        if (!aA.isFacecastNuxShowing()) {
            this.f6550e.a();
            ((TransactionImpl) this.f6548c.m7626a(f6546a).m7682a(InlineSproutsState.m8093a(aA).setIsFacecastNuxShowing(true).m8091a())).m7689a();
        }
        return 2130904915;
    }

    public final boolean m8009b() {
        return (this.f6550e.c() || this.f6547b.aA().isFacecastNuxShowing()) && this.f6549d.f6600d.a(ExperimentsForFeedUtilComposerAbtestModule.z, false);
    }

    public final Runnable m8010c() {
        return null;
    }
}

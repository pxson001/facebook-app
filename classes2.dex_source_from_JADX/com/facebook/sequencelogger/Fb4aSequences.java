package com.facebook.sequencelogger;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/* compiled from: ttfb */
public final class Fb4aSequences {
    public static final Fb4aColdStartSequence f2216a = new Fb4aColdStartSequence();
    public static final Fb4aColdStartFirstRunSequence f2217b = new Fb4aColdStartFirstRunSequence();
    public static final Fb4aColdStartCachedSequence f2218c = new Fb4aColdStartCachedSequence();
    public static final ImmutableList<? extends SequenceDefinition> f2219d = ImmutableList.of(f2216a, f2217b);
    public static final Fb4aWarmStartSequence f2220e = new Fb4aWarmStartSequence();
    public static final Fb4aHotStartSequence f2221f = new Fb4aHotStartSequence();
    public static final Fb4aWarmStartCachedSequence f2222g = new Fb4aWarmStartCachedSequence();
    public static final ImmutableList<? extends SequenceDefinition> f2223h = ImmutableList.of(f2220e, f2222g);
    public static final ImmutableList<? extends SequenceDefinition> f2224i = ImmutableList.of(f2221f);
    public static final SwitchToFeedReloadedSequence f2225j = new SwitchToFeedReloadedSequence();
    public static final ImmutableSet<String> f2226k = ImmutableSet.of("com.facebook.feed.ui.NewsFeedFragment", "Feed");

    /* compiled from: ttfb */
    public final class Fb4aColdStartSequence extends AbstractSequenceDefinition {
        public Fb4aColdStartSequence() {
            super(655361, "NNFColdStart", true, Fb4aSequences.f2226k);
        }
    }

    /* compiled from: ttfb */
    public final class Fb4aColdStartFirstRunSequence extends AbstractSequenceDefinition {
        public Fb4aColdStartFirstRunSequence() {
            super(655362, "NNFColdStartFirstRun", true, Fb4aSequences.f2226k);
        }
    }

    /* compiled from: ttfb */
    public final class Fb4aColdStartCachedSequence extends AbstractSequenceDefinition {
        public Fb4aColdStartCachedSequence() {
            super(655363, "NNFColdStartCached", true, Fb4aSequences.f2226k);
        }
    }

    /* compiled from: ttfb */
    public final class Fb4aWarmStartSequence extends AbstractSequenceDefinition {
        public Fb4aWarmStartSequence() {
            super(655364, "NNFWarmStart", false, Fb4aSequences.f2226k);
        }
    }

    /* compiled from: ttfb */
    public final class Fb4aHotStartSequence extends AbstractSequenceDefinition {
        public Fb4aHotStartSequence() {
            super(655366, "NNFHotStart", false, Fb4aSequences.f2226k);
        }
    }

    /* compiled from: ttfb */
    public final class Fb4aWarmStartCachedSequence extends AbstractSequenceDefinition {
        public Fb4aWarmStartCachedSequence() {
            super(655365, "NNFWarmStartCached", false, Fb4aSequences.f2226k);
        }
    }

    /* compiled from: ttfb */
    public final class SwitchToFeedReloadedSequence extends AbstractSequenceDefinition {
        public SwitchToFeedReloadedSequence() {
            super(655367, "SwitchToFeedReloadedSequence", false, Fb4aSequences.f2226k);
        }
    }
}

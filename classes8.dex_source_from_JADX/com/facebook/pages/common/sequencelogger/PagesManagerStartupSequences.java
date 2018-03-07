package com.facebook.pages.common.sequencelogger;

import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/* compiled from: creative_img_size */
public class PagesManagerStartupSequences {
    public static final PagesManagerColdStartSequenceDefinition f16598a = new PagesManagerColdStartSequenceDefinition();
    public static final PagesManagerColdStartFirstRunSequenceDefinition f16599b = new PagesManagerColdStartFirstRunSequenceDefinition();
    public static final PagesManagerWarmStartSequenceDefinition f16600c = new PagesManagerWarmStartSequenceDefinition();
    public static final ImmutableList<? extends AbstractSequenceDefinition> f16601d = ImmutableList.of(f16598a, f16599b);
    public static final ImmutableList<? extends AbstractSequenceDefinition> f16602e = ImmutableList.of(f16600c);

    /* compiled from: creative_img_size */
    public final class PagesManagerColdStartFirstRunSequenceDefinition extends AbstractSequenceDefinition {
        public PagesManagerColdStartFirstRunSequenceDefinition() {
            super(1245197, "PmaColdStartFirstRunSequence", true, ImmutableSet.of("com.facebook.pages.app.activity.PagesManagerChromeActivity"));
        }
    }

    /* compiled from: creative_img_size */
    public final class PagesManagerColdStartSequenceDefinition extends AbstractSequenceDefinition {
        public PagesManagerColdStartSequenceDefinition() {
            super(1245196, "PmaColdStartSequence", true, ImmutableSet.of("com.facebook.pages.app.activity.PagesManagerChromeActivity"));
        }
    }

    /* compiled from: creative_img_size */
    public final class PagesManagerWarmStartSequenceDefinition extends AbstractSequenceDefinition {
        public PagesManagerWarmStartSequenceDefinition() {
            super(1245198, "PmaWarmStartSequence", false, ImmutableSet.of("com.facebook.pages.app.activity.PagesManagerChromeActivity"));
        }
    }
}

package com.facebook.ui.browser.logging;

import com.facebook.sequencelogger.AbstractSequenceDefinition;
import com.facebook.ui.browser.BrowserActivity;
import com.google.common.collect.ImmutableSet;

/* compiled from: tincan/ */
public class BrowserSequences {
    public static final InAppBrowserLoadSequence f1605a = new InAppBrowserLoadSequence();

    /* compiled from: tincan/ */
    public final class InAppBrowserLoadSequence extends AbstractSequenceDefinition {
        public InAppBrowserLoadSequence() {
            super(1835009, "WebViewLoad", true, ImmutableSet.of("BrowserFragment", BrowserActivity.class.getName()));
        }
    }
}

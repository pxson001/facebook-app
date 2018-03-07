package com.facebook.goodwill.composer;

import com.facebook.base.fragment.FbFragment;
import com.facebook.goodwill.composer.GoodwillComposerActivity.ComposerFlowCallback;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: {offer_view_id} */
public abstract class GoodwillComposerFragment extends FbFragment {
    public ComposerFlowCallback f81a;

    public void mo7a(GoodwillComposerEvent goodwillComposerEvent, ComposerFlowCallback composerFlowCallback) {
        this.f81a = composerFlowCallback;
        this.f81a.m60a();
    }

    public final void m98I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -665653295);
        super.I();
        this.f81a = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1290774311, a);
    }
}

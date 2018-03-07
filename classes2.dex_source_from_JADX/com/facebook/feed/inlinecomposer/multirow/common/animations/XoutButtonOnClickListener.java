package com.facebook.feed.inlinecomposer.multirow.common.animations;

import android.view.View;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPersistentStateHelper;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPersistentStateHelper.CanHideShowPromptOnClickListener;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.inject.Assisted;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater.TapSource;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.productionprompts.events.PromptsDismissEvent;
import com.facebook.productionprompts.events.PromptsEventBus;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.logging.PromptImpressionLoggingSessionIdMap;
import com.facebook.productionprompts.model.InlineComposerPromptSession;
import com.google.common.base.Preconditions;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: integer */
public class XoutButtonOnClickListener<V extends View & HasPromptFlyout> implements CanHideShowPromptOnClickListener<V> {
    PromptViewStateUpdater f19756a;
    InlineComposerPersistentStateHelper f19757b;
    Provider<PromptImpressionLoggingSessionIdMap> f19758c;
    Provider<PromptsEventBus> f19759d;
    private View f19760e;
    private View f19761f;
    private InlineComposerPromptSession f19762g;

    @Inject
    public XoutButtonOnClickListener(Provider<PromptsEventBus> provider, InlineComposerPersistentStateHelper inlineComposerPersistentStateHelper, Provider<PromptImpressionLoggingSessionIdMap> provider2, @Assisted PromptViewStateUpdater promptViewStateUpdater) {
        this.f19756a = promptViewStateUpdater;
        this.f19758c = provider2;
        this.f19757b = inlineComposerPersistentStateHelper;
        this.f19759d = provider;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1493139775);
        Preconditions.checkNotNull(this.f19760e);
        this.f19761f.setOnClickListener(null);
        ((PromptsEventBus) this.f19759d.get()).mo651a(new PromptsDismissEvent(this.f19762g, PromptAnalytics.a(this.f19762g, ((PromptImpressionLoggingSessionIdMap) this.f19758c.get()).m19702a(this.f19762g.f13409a.mo2493b())), false, true));
        this.f19757b.m19398a(this.f19762g, this.f19756a, TapSource.XOUT);
        Logger.a(2, EntryType.UI_INPUT_END, -1952843500, a);
    }

    public final void mo2757a(V v, InlineComposerPromptSession inlineComposerPromptSession) {
        this.f19760e = v;
        this.f19761f = ((HasPromptFlyout) v).getFlyoutXoutButton();
        this.f19762g = inlineComposerPromptSession;
    }
}

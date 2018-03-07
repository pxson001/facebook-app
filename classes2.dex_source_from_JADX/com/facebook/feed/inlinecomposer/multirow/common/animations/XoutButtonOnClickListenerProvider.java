package com.facebook.feed.inlinecomposer.multirow.common.animations;

import android.view.View;
import com.facebook.feed.inlinecomposer.multirow.common.InlineComposerPersistentStateHelper;
import com.facebook.feed.inlinecomposer.multirow.common.views.HasPromptFlyout;
import com.facebook.inject.AbstractAssistedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.ipc.productionprompts.manager.PromptViewStateUpdater;

/* compiled from: mqtt_health_stats */
public class XoutButtonOnClickListenerProvider extends AbstractAssistedProvider<XoutButtonOnClickListener> {
    public final <V extends View & HasPromptFlyout> XoutButtonOnClickListener<V> m19521a(PromptViewStateUpdater promptViewStateUpdater) {
        return new XoutButtonOnClickListener(IdBasedSingletonScopeProvider.m1809a(this, 3151), InlineComposerPersistentStateHelper.m19396b((InjectorLike) this), IdBasedSingletonScopeProvider.m1809a(this, 3153), promptViewStateUpdater);
    }
}

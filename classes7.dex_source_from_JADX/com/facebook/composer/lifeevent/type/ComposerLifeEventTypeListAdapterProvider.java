package com.facebook.composer.lifeevent.type;

import android.content.Context;
import android.view.View.OnClickListener;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.inject.AbstractAssistedProvider;

/* compiled from: copyright_monitor_notify */
public class ComposerLifeEventTypeListAdapterProvider extends AbstractAssistedProvider<ComposerLifeEventTypeListAdapter> {
    public final ComposerLifeEventTypeListAdapter m20798a(Context context, ComposerLifeEventTypeSuggestionListModel composerLifeEventTypeSuggestionListModel, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return new ComposerLifeEventTypeListAdapter(I18nJoiner.b(this), context, composerLifeEventTypeSuggestionListModel, onClickListener, onClickListener2);
    }
}

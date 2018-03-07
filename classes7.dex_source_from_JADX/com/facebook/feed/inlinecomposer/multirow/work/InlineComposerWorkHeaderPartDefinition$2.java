package com.facebook.feed.inlinecomposer.multirow.work;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: android.intent.extra.ringtone.SHOW_DEFAULT */
class InlineComposerWorkHeaderPartDefinition$2 implements OnClickListener {
    final /* synthetic */ InlineComposerWorkHeaderPartDefinition f19318a;

    InlineComposerWorkHeaderPartDefinition$2(InlineComposerWorkHeaderPartDefinition inlineComposerWorkHeaderPartDefinition) {
        this.f19318a = inlineComposerWorkHeaderPartDefinition;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1219870475);
        this.f19318a.d.a(view.getContext());
        Logger.a(2, EntryType.UI_INPUT_END, 10575008, a);
    }
}

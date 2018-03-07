package com.facebook.feedplugins.graphqlstory.translation;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.translation.TranslationMenuHelper;

/* compiled from: S_HDMV/PGS */
class TranslationView$2 implements OnClickListener {
    final /* synthetic */ TranslationMenuHelper f23474a;
    final /* synthetic */ TranslationView f23475b;

    TranslationView$2(TranslationView translationView, TranslationMenuHelper translationMenuHelper) {
        this.f23475b = translationView;
        this.f23474a = translationMenuHelper;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1841252939);
        this.f23474a.a(this.f23475b.f);
        Logger.a(2, EntryType.UI_INPUT_END, 1875672711, a);
    }
}

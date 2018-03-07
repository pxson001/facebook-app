package com.facebook.feed.renderer;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.analytics.logger.HoneyClientEvent;
import com.facebook.feed.renderer.spannable.NativeThirdPartyUriClickHandler;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: skippedToEditing */
class DefaultFeedUnitRenderer$6 implements OnClickListener {
    final /* synthetic */ String f3664a;
    final /* synthetic */ HoneyClientEvent f3665b;
    final /* synthetic */ DefaultFeedUnitRenderer f3666c;

    DefaultFeedUnitRenderer$6(DefaultFeedUnitRenderer defaultFeedUnitRenderer, String str, HoneyClientEvent honeyClientEvent) {
        this.f3666c = defaultFeedUnitRenderer;
        this.f3664a = str;
        this.f3665b = honeyClientEvent;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1230448278);
        ((NativeThirdPartyUriClickHandler) this.f3666c.n.get()).m4387a(this.f3664a, view, this.f3665b);
        Logger.a(2, EntryType.UI_INPUT_END, 1355044797, a);
    }
}

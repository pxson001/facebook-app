package com.facebook.feed.inlinecomposer.multirow;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.feed.util.composer.launch.DefaultNewsfeedComposerConfigCustomizer;
import com.facebook.feed.util.composer.launch.NewsfeedLauncherContext;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: android.settings.action.MANAGE_OVERLAY_PERMISSION */
public class ScrollAwayComposerController$1 implements OnClickListener {
    final /* synthetic */ ScrollAwayComposerController f19252a;

    public ScrollAwayComposerController$1(ScrollAwayComposerController scrollAwayComposerController) {
        this.f19252a = scrollAwayComposerController;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 675981087);
        this.f19252a.e.a();
        this.f19252a.g.a(new NewsfeedLauncherContext("feed_inline"), new DefaultNewsfeedComposerConfigCustomizer()).m24954a((Optional) Absent.INSTANCE, this.f19252a.c);
        Logger.a(2, EntryType.UI_INPUT_END, 630039631, a);
    }
}

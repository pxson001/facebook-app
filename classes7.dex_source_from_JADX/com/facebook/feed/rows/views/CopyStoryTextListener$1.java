package com.facebook.feed.rows.views;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.common.util.ClipboardUtil;
import com.facebook.graphql.model.StoryTextHelper;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;

/* compiled from: UNCAUGHT_EXCEPTION */
public class CopyStoryTextListener$1 implements OnMenuItemClickListener {
    final /* synthetic */ CopyStoryTextListener f21590a;

    public CopyStoryTextListener$1(CopyStoryTextListener copyStoryTextListener) {
        this.f21590a = copyStoryTextListener;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        ClipboardUtil.a(this.f21590a.c, StoryTextHelper.a(this.f21590a.b));
        ((Toaster) this.f21590a.a.get()).a(new ToastBuilder(2131233511));
        return false;
    }
}

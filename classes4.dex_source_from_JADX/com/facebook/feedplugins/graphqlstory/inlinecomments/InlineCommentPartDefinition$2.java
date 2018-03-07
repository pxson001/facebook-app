package com.facebook.feedplugins.graphqlstory.inlinecomments;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: dispatching a set of  */
final class InlineCommentPartDefinition$2 implements OnClickListener {
    final /* synthetic */ AtomicBoolean f13768a;
    final /* synthetic */ CharSequence f13769b;

    InlineCommentPartDefinition$2(AtomicBoolean atomicBoolean, CharSequence charSequence) {
        this.f13768a = atomicBoolean;
        this.f13769b = charSequence;
    }

    public final void onClick(View view) {
        InlineCommentView inlineCommentView;
        int a = Logger.a(2, EntryType.UI_INPUT_START, 253422859);
        this.f13768a.set(true);
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof InlineCommentView) {
                inlineCommentView = (InlineCommentView) parent;
                break;
            }
        }
        inlineCommentView = null;
        InlineCommentView inlineCommentView2 = inlineCommentView;
        if (inlineCommentView2 == null) {
            Logger.a(2, EntryType.UI_INPUT_END, -900388062, a);
            return;
        }
        inlineCommentView2.post(new 1(this, inlineCommentView2));
        LogUtils.a(487619962, a);
    }
}

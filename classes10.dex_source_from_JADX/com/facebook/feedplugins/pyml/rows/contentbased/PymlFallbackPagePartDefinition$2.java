package com.facebook.feedplugins.pyml.rows.contentbased;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: android.intent.category.OPENABLE */
class PymlFallbackPagePartDefinition$2 implements OnClickListener {
    final /* synthetic */ PagesYouMayLikeItemViewModelProps f19878a;
    final /* synthetic */ PymlFallbackPagePartDefinition f19879b;

    PymlFallbackPagePartDefinition$2(PymlFallbackPagePartDefinition pymlFallbackPagePartDefinition, PagesYouMayLikeItemViewModelProps pagesYouMayLikeItemViewModelProps) {
        this.f19879b = pymlFallbackPagePartDefinition;
        this.f19878a = pagesYouMayLikeItemViewModelProps;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 242010869);
        this.f19879b.f.a(view, LinkifyTargetBuilder.a(this.f19878a.f19875b.m()), null);
        Logger.a(2, EntryType.UI_INPUT_END, 482071164, a);
    }
}

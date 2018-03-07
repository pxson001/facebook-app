package com.facebook.feedplugins.pyml.rows.contentbased;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.linkify.LinkifyTargetBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: android.intent.action.INSERT_OR_EDIT */
class PymlPhotoPagePartDefinition$2 implements OnClickListener {
    final /* synthetic */ PagesYouMayLikeItemViewModelProps f19880a;
    final /* synthetic */ PymlPhotoPagePartDefinition f19881b;

    PymlPhotoPagePartDefinition$2(PymlPhotoPagePartDefinition pymlPhotoPagePartDefinition, PagesYouMayLikeItemViewModelProps pagesYouMayLikeItemViewModelProps) {
        this.f19881b = pymlPhotoPagePartDefinition;
        this.f19880a = pagesYouMayLikeItemViewModelProps;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -74141852);
        this.f19881b.f.a(view, LinkifyTargetBuilder.a(this.f19880a.f19875b.m()), null);
        Logger.a(2, EntryType.UI_INPUT_END, -1828085048, a);
    }
}

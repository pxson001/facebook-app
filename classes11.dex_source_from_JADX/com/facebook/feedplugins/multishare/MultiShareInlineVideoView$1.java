package com.facebook.feedplugins.multishare;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: connection_subtype */
class MultiShareInlineVideoView$1 implements OnClickListener {
    final /* synthetic */ OnClickListener f8007a;
    final /* synthetic */ View f8008b;
    final /* synthetic */ MultiShareInlineVideoView f8009c;

    MultiShareInlineVideoView$1(MultiShareInlineVideoView multiShareInlineVideoView, OnClickListener onClickListener, View view) {
        this.f8009c = multiShareInlineVideoView;
        this.f8007a = onClickListener;
        this.f8008b = view;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1075539650);
        if (this.f8007a != null) {
            this.f8007a.onClick(this.f8008b);
        }
        Logger.a(2, EntryType.UI_INPUT_END, 1606701388, a);
    }
}

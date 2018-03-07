package com.facebook.messaging.composer.botcomposer;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.composer.botcomposer.QuickReplyController.C02852;
import com.facebook.messaging.composer.botcomposer.QuickReplyController.C02852.C02841;
import com.facebook.messaging.model.messagemetadata.QuickReplyItem;
import com.facebook.widget.text.BetterTextView;

/* compiled from: terms_and_policies_uri */
public class QuickReplyViewHolder extends ViewHolder {
    public final BetterTextView f1778l;
    public final View f1779m;

    /* compiled from: terms_and_policies_uri */
    public class C02911 implements OnClickListener {
        final /* synthetic */ C02852 f1775a;
        final /* synthetic */ QuickReplyItem f1776b;
        final /* synthetic */ QuickReplyViewHolder f1777c;

        public C02911(QuickReplyViewHolder quickReplyViewHolder, C02852 c02852, QuickReplyItem quickReplyItem) {
            this.f1777c = quickReplyViewHolder;
            this.f1775a = c02852;
            this.f1776b = quickReplyItem;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -254469329);
            C02852 c02852 = this.f1775a;
            QuickReplyController.m1723a(c02852.f1749a, new C02841(c02852, this.f1776b));
            Logger.a(2, EntryType.UI_INPUT_END, 329289206, a);
        }
    }

    public QuickReplyViewHolder(View view) {
        super(view);
        this.f1778l = (BetterTextView) view.findViewById(2131564695);
        this.f1779m = view;
    }
}

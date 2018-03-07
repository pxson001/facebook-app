package com.facebook.feedplugins.placetips;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: friend_suggestions_and_selector */
public class PlaceTipsFooterFeatherUpsellView extends CustomLinearLayout {
    public PlaceTipsFooterFeatherUpsellView(Context context, final Runnable runnable, final Runnable runnable2) {
        super(context);
        setContentView(2130906273);
        a(2131566030).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PlaceTipsFooterFeatherUpsellView f12926c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 316452405);
                runnable2.run();
                runnable.run();
                Logger.a(2, EntryType.UI_INPUT_END, -1135140064, a);
            }
        });
    }
}

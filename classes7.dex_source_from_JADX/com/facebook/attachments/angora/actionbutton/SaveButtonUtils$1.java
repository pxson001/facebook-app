package com.facebook.attachments.angora.actionbutton;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.graphql.enums.GraphQLSavedDashboardSectionType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.saved.analytics.SaveAnalyticsLogger.Referer;

/* compiled from: user_ids */
class SaveButtonUtils$1 implements OnClickListener {
    final /* synthetic */ SaveButtonUtils f876a;

    SaveButtonUtils$1(SaveButtonUtils saveButtonUtils) {
        this.f876a = saveButtonUtils;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, -1536618855);
        SaveButtonUtils.a(this.f876a, view.getContext(), GraphQLSavedDashboardSectionType.ALL, Referer.SAVED_TOAST_RECENT_ITEM_COUNT);
        Logger.a(2, EntryType.UI_INPUT_END, -1762121179, a);
    }
}

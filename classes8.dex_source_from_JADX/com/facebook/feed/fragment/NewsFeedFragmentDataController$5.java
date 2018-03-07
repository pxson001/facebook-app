package com.facebook.feed.fragment;

import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.accessibility.ViewAccessibilityHelper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.refreshableview.ConnectionRetrySnackbarView;

/* compiled from: group_tag_suggestion_clicked */
class NewsFeedFragmentDataController$5 implements OnClickListener {
    final /* synthetic */ ConnectionRetrySnackbarView f11873a;
    final /* synthetic */ NewsFeedFragmentDataController f11874b;

    NewsFeedFragmentDataController$5(NewsFeedFragmentDataController newsFeedFragmentDataController, ConnectionRetrySnackbarView connectionRetrySnackbarView) {
        this.f11874b = newsFeedFragmentDataController;
        this.f11873a = connectionRetrySnackbarView;
    }

    public void onClick(View view) {
        int a = Logger.a(2, EntryType.UI_INPUT_START, 1023742238);
        this.f11874b.ae.b();
        ((ViewAccessibilityHelper) this.f11874b.x.get()).a(this.f11873a, this.f11874b.S.getString(2131233428));
        NewsFeedFragmentDataController.H(this.f11874b);
        Logger.a(2, EntryType.UI_INPUT_END, 769602049, a);
    }
}

package com.facebook.feed.menu.base;

import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.bugreporter.BugReportFlowStartParams;
import com.facebook.bugreporter.BugReportSource;
import com.facebook.bugreporter.BugReporter;
import com.facebook.feed.menu.base.BaseFeedStoryMenuHelper.BaseFeedStoryMenuOptions;
import com.facebook.graphql.model.FeedUnit;
import com.google.common.collect.ImmutableSet;

/* compiled from: analytics_extra_data */
public class BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$4 implements OnMenuItemClickListener {
    final /* synthetic */ Context f19412a;
    final /* synthetic */ FeedUnit f19413b;
    final /* synthetic */ BaseFeedStoryMenuOptions f19414c;

    public BaseFeedStoryMenuHelper$BaseFeedStoryMenuOptions$4(BaseFeedStoryMenuOptions baseFeedStoryMenuOptions, Context context, FeedUnit feedUnit) {
        this.f19414c = baseFeedStoryMenuOptions;
        this.f19412a = context;
        this.f19413b = feedUnit;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        if (this.f19414c.a.g() != null) {
            ((BugReporter) this.f19414c.a.g().get()).a(BugReportFlowStartParams.newBuilder().a(this.f19412a).a(BugReportSource.FEED_STORY).a(ImmutableSet.of(new BaseFeedStoryMenuHelper$SerializedStoryDataFileProvider(this.f19414c.a, BaseFeedStoryMenuOptions.d(this.f19414c, this.f19413b)))).a(Long.valueOf(299922733459834L)).a());
        } else {
            BaseFeedStoryMenuOptions baseFeedStoryMenuOptions = this.f19414c;
            FeedUnit feedUnit = this.f19413b;
            Context context = this.f19412a;
            Intent intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType("plain/text");
            intent.putExtra("android.intent.extra.SUBJECT", "Feed story debug info");
            intent.putExtra("android.intent.extra.TEXT", BaseFeedStoryMenuOptions.d(baseFeedStoryMenuOptions, feedUnit));
            baseFeedStoryMenuOptions.a.d().b(Intent.createChooser(intent, "Send story debug info using:"), context);
        }
        return true;
    }
}

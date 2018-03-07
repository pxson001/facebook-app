package com.facebook.feed.menu.newsfeed;

import android.content.Context;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.feed.menu.newsfeed.NewsFeedStoryMenuHelper.NewsFeedStoryMenuOptions;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.util.composer.abtest.ExperimentsForFeedUtilComposerAbtestModule;
import com.facebook.flatbuffers.Flattenable;
import com.facebook.graphql.model.FeedUnit;
import com.facebook.graphql.model.GraphQLStory;
import com.facebook.graphql.model.StoryCommerceHelper;

/* compiled from: all_cards_enabled_message */
class NewsFeedStoryMenuHelper$NewsFeedStoryMenuOptions$2 implements OnMenuItemClickListener {
    final /* synthetic */ FeedProps f19510a;
    final /* synthetic */ String f19511b;
    final /* synthetic */ GraphQLStory f19512c;
    final /* synthetic */ Context f19513d;
    final /* synthetic */ NewsFeedStoryMenuOptions f19514e;

    NewsFeedStoryMenuHelper$NewsFeedStoryMenuOptions$2(NewsFeedStoryMenuOptions newsFeedStoryMenuOptions, FeedProps feedProps, String str, GraphQLStory graphQLStory, Context context) {
        this.f19514e = newsFeedStoryMenuOptions;
        this.f19510a = feedProps;
        this.f19511b = str;
        this.f19512c = graphQLStory;
        this.f19513d = context;
    }

    public boolean onMenuItemClick(MenuItem menuItem) {
        this.f19514e.b.a(this.f19510a, menuItem.getItemId(), this.f19511b, true);
        if (StoryCommerceHelper.e(this.f19512c)) {
            this.f19514e.b.a(this.f19510a, this.f19513d);
        } else if (((Boolean) this.f19514e.b.B.get()).booleanValue() && StoryCommerceHelper.f(this.f19512c)) {
            this.f19514e.b.b(this.f19510a, this.f19513d);
        } else if (this.f19514e.b.g((FeedUnit) this.f19510a.a) && this.f19514e.b.H.a(ExperimentsForFeedUtilComposerAbtestModule.ad, false)) {
            r0 = this.f19514e.b;
            r1 = this.f19510a;
            r2 = this.f19513d;
            AlertDialog b = new Builder(r2).a(r2.getResources().getString(2131233464)).b(r2.getResources().getString(2131233443)).c(2131233464, new NewsFeedStoryMenuHelper$4(r0, r1)).b(2131233471, new NewsFeedStoryMenuHelper$3(r0, r1, r2)).a(2131233563, null).b();
            b.a(-3).setTextColor(b.a(-1).getTextColors());
            b.a(-1).setTextColor(b.a(-2).getTextColors());
        } else {
            r0 = this.f19514e.b;
            r1 = this.f19510a;
            r2 = this.f19513d;
            Flattenable flattenable = r1.a;
            new Builder(r2).b(r2.getResources().getString(2131233442)).a(2131233456, new NewsFeedStoryMenuHelper$2(r0, r1)).b(2131233563, null).b();
        }
        return true;
    }
}

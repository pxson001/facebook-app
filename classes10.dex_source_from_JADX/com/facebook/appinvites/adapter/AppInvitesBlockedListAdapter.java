package com.facebook.appinvites.adapter;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.appinvites.data.AppInvitesBlockedListData;
import com.facebook.appinvites.data.AppInvitesBlockedListData.AppInvitesBlockedListDataEntry;
import com.facebook.appinvites.data.AppInvitesGraphqlMutationHelper;
import com.facebook.appinvites.protocol.AppInvitesMutations.AppRequestUnblockApplicationCoreMutationString;
import com.facebook.appinvites.protocol.AppInvitesMutations.AppRequestUnblockUserCoreMutationString;
import com.facebook.appinvites.ui.AppInviteBlockListEntryView;
import com.facebook.graphql.calls.ApplicationRequestUnblockApplicationInputData;
import com.facebook.graphql.calls.ApplicationRequestUnblockUserInputData;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.widget.listview.FbBaseAdapter;
import javax.inject.Inject;

/* compiled from: education */
public class AppInvitesBlockedListAdapter extends FbBaseAdapter {
    public final AppInvitesGraphqlMutationHelper f14556a;
    private final AppInvitesBlockedListData f14557b;
    public final Integer f14558c;

    @Inject
    public AppInvitesBlockedListAdapter(AppInvitesGraphqlMutationHelper appInvitesGraphqlMutationHelper, @Assisted Integer num, @Assisted AppInvitesBlockedListData appInvitesBlockedListData) {
        this.f14556a = appInvitesGraphqlMutationHelper;
        this.f14558c = num;
        this.f14557b = appInvitesBlockedListData;
    }

    public int getCount() {
        return this.f14557b.f14563a.size();
    }

    public Object getItem(int i) {
        return (AppInvitesBlockedListDataEntry) this.f14557b.f14563a.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public final View m14736a(int i, ViewGroup viewGroup) {
        return new AppInviteBlockListEntryView(viewGroup.getContext());
    }

    public final void m14737a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        final AppInvitesBlockedListDataEntry appInvitesBlockedListDataEntry = (AppInvitesBlockedListDataEntry) obj;
        final AppInviteBlockListEntryView appInviteBlockListEntryView = (AppInviteBlockListEntryView) view;
        appInviteBlockListEntryView.f14684a.setTitleText(appInvitesBlockedListDataEntry.f14560b);
        appInviteBlockListEntryView.f14684a.setThumbnailUri(Uri.parse(appInvitesBlockedListDataEntry.f14561c));
        appInviteBlockListEntryView.setBlocked(appInvitesBlockedListDataEntry.f14562d);
        OnClickListener c20361 = new OnClickListener(this) {
            final /* synthetic */ AppInvitesBlockedListAdapter f14555c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -350180754);
                AppInvitesGraphqlMutationHelper appInvitesGraphqlMutationHelper;
                String str;
                if (this.f14555c.f14558c.intValue() == 2) {
                    if (appInvitesBlockedListDataEntry.f14562d) {
                        appInvitesGraphqlMutationHelper = this.f14555c.f14556a;
                        str = appInvitesBlockedListDataEntry.f14559a;
                        ApplicationRequestUnblockApplicationInputData applicationRequestUnblockApplicationInputData = new ApplicationRequestUnblockApplicationInputData();
                        applicationRequestUnblockApplicationInputData.a("application_id", str);
                        appInvitesGraphqlMutationHelper.f14577a.a(GraphQLRequest.a((AppRequestUnblockApplicationCoreMutationString) new AppRequestUnblockApplicationCoreMutationString().a("input", applicationRequestUnblockApplicationInputData)));
                    } else {
                        this.f14555c.f14556a.m14751b(appInvitesBlockedListDataEntry.f14559a);
                    }
                } else if (appInvitesBlockedListDataEntry.f14562d) {
                    appInvitesGraphqlMutationHelper = this.f14555c.f14556a;
                    str = appInvitesBlockedListDataEntry.f14559a;
                    ApplicationRequestUnblockUserInputData applicationRequestUnblockUserInputData = new ApplicationRequestUnblockUserInputData();
                    applicationRequestUnblockUserInputData.a("user_id", str);
                    appInvitesGraphqlMutationHelper.f14577a.a(GraphQLRequest.a((AppRequestUnblockUserCoreMutationString) new AppRequestUnblockUserCoreMutationString().a("input", applicationRequestUnblockUserInputData)));
                } else {
                    this.f14555c.f14556a.m14750a(appInvitesBlockedListDataEntry.f14559a, "630212950389510");
                }
                appInvitesBlockedListDataEntry.f14562d = !appInvitesBlockedListDataEntry.f14562d;
                appInviteBlockListEntryView.setBlocked(appInvitesBlockedListDataEntry.f14562d);
                LogUtils.a(1147286003, a);
            }
        };
        appInviteBlockListEntryView.f14684a.setActionButtonOnClickListener(c20361);
        appInviteBlockListEntryView.f14684a.getSubtitleView().setOnClickListener(c20361);
    }
}

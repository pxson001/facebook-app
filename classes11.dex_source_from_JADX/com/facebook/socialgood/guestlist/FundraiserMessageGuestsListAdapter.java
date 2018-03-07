package com.facebook.socialgood.guestlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ultralight.Inject;

/* compiled from: OutOfOrder */
public class FundraiserMessageGuestsListAdapter extends FundraiserGuestListBaseAdapter {
    @Inject
    public Context f12707b;

    @Inject
    public FundraiserMessageGuestsListAdapter(Context context) {
        this.f12707b = context;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new FundraiserMessageGuestsRowView(this.f12707b);
        } else {
            FundraiserMessageGuestsRowView fundraiserMessageGuestsRowView = (FundraiserMessageGuestsRowView) view;
        }
        FundraiserGuestListUser fundraiserGuestListUser = (FundraiserGuestListUser) this.f12617a.get(i);
        view.setTitleText(fundraiserGuestListUser.m13190c());
        view.setSubtitleText(fundraiserGuestListUser.m13189a(view.getResources()));
        view.setThumbnailUri(fundraiserGuestListUser.m13191d());
        view.setChecked(fundraiserGuestListUser.f12683b);
        return view;
    }
}

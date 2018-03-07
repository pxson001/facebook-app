package com.facebook.socialgood.guestlist;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.ultralight.Inject;

/* compiled from: PATTERN */
public class FundraiserGuestListAdapter extends FundraiserGuestListBaseAdapter {
    @Inject
    public Context f12618b;

    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new FundraiserGuestListRowView(this.f12618b);
        } else {
            FundraiserGuestListRowView fundraiserGuestListRowView = (FundraiserGuestListRowView) view;
        }
        FundraiserGuestListUser fundraiserGuestListUser = (FundraiserGuestListUser) this.f12617a.get(i);
        view.setTitleText(fundraiserGuestListUser.m13190c());
        view.setSubtitleText(fundraiserGuestListUser.m13189a(view.getResources()));
        view.setThumbnailUri(fundraiserGuestListUser.m13191d());
        return view;
    }
}

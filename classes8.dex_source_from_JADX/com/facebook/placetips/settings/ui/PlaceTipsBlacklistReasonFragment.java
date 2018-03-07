package com.facebook.placetips.settings.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.graphql.calls.GravityNegativeFeedbackInputData.FeedbackType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.placetips.settings.PlaceTipsLocationData;

/* compiled from: captcha_fetch_request_succeeded */
public class PlaceTipsBlacklistReasonFragment extends FbFragment {
    public final View m22368a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1697210181);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2130906277, viewGroup, false);
        ViewGroup viewGroup3 = (SegmentedLinearLayout) viewGroup2.findViewById(2131566038);
        ViewStub viewStub = (ViewStub) viewGroup2.findViewById(2131566039);
        viewStub.setLayoutResource(2130906280);
        viewStub.inflate();
        m22367a(FeedbackType.INCORRECT_LOCATION, viewGroup3, 2131239386);
        m22367a(FeedbackType.ANNOYING, viewGroup3, 2131239387);
        m22367a(FeedbackType.SINGLE_PAGE_OPT_OUT, viewGroup3, 2131239388);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 637504470, a);
        return viewGroup2;
    }

    private void m22367a(FeedbackType feedbackType, ViewGroup viewGroup, int i) {
        PlaceTipsLocationData placeTipsLocationData;
        String str;
        PlaceTipsBlacklistFeedbackItem placeTipsBlacklistFeedbackItem = new PlaceTipsBlacklistFeedbackItem(getContext());
        FragmentManager fragmentManager = this.D;
        if (ao() == null || ao().getIntent() == null) {
            placeTipsLocationData = null;
        } else {
            placeTipsLocationData = (PlaceTipsLocationData) ao().getIntent().getParcelableExtra("gravity_location_data");
        }
        PlaceTipsLocationData placeTipsLocationData2 = placeTipsLocationData;
        int ordinal = ContentFragmentType.PLACE_TIPS_BLACKLIST_CONFIRMATION_FRAGMENT.ordinal();
        if (ao() == null || ao().getIntent() == null) {
            str = null;
        } else {
            str = ao().getIntent().getStringExtra("place_id");
        }
        placeTipsBlacklistFeedbackItem.m22363a(feedbackType, fragmentManager, placeTipsLocationData2, ordinal, str, i);
        viewGroup.addView(placeTipsBlacklistFeedbackItem);
    }
}

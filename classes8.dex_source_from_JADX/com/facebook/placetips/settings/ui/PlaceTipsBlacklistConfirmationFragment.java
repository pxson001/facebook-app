package com.facebook.placetips.settings.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.graphql.calls.GravityNegativeFeedbackInputData.FeedbackType;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Strings;
import javax.annotation.Nullable;

/* compiled from: caption_description_extra_large_style */
public class PlaceTipsBlacklistConfirmationFragment extends FbFragment {

    /* compiled from: caption_description_extra_large_style */
    /* synthetic */ class C20171 {
        static final /* synthetic */ int[] f18413a = new int[FeedbackType.values().length];

        static {
            try {
                f18413a[FeedbackType.INCORRECT_LOCATION.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18413a[FeedbackType.SINGLE_PAGE_OPT_OUT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18413a[FeedbackType.ANNOYING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    public final View m22349a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1360811351);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2130906277, viewGroup, false);
        ViewStub viewStub = (ViewStub) viewGroup2.findViewById(2131566039);
        viewStub.setLayoutResource(2130906279);
        viewStub.inflate();
        TextView textView = (TextView) viewGroup2.findViewById(2131566040);
        textView.setTextAppearance(getContext(), 2131626249);
        FeedbackType feedbackType = (FeedbackType) this.s.getSerializable("negative_feedback_type");
        textView.setText(m22347a(feedbackType));
        if (feedbackType == FeedbackType.SINGLE_PAGE_OPT_OUT) {
            SegmentedLinearLayout segmentedLinearLayout = (SegmentedLinearLayout) viewGroup2.findViewById(2131566038);
            PlaceTipsBlacklistFeedbackItem placeTipsBlacklistFeedbackItem = new PlaceTipsBlacklistFeedbackItem(getContext());
            placeTipsBlacklistFeedbackItem.m22362a(this.D, ContentFragmentType.PLACE_TIPS_SETTINGS_FRAGMENT.ordinal(), 2131239376);
            segmentedLinearLayout.addView(placeTipsBlacklistFeedbackItem);
        }
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1289338183, a);
        return viewGroup2;
    }

    private String m22348a(String str) {
        if (ao() == null || ao().getIntent() == null) {
            return str;
        }
        if (Strings.isNullOrEmpty(ao().getIntent().getStringExtra("place_name"))) {
            return str;
        }
        return jW_().getString(2131239390, new Object[]{r0});
    }

    private String m22347a(@Nullable FeedbackType feedbackType) {
        String string = jW_().getString(2131239389);
        if (feedbackType == null) {
            return string;
        }
        switch (C20171.f18413a[feedbackType.ordinal()]) {
            case 1:
                return m22348a(string);
            case 2:
                return jW_().getString(2131239391);
            default:
                return string;
        }
    }
}

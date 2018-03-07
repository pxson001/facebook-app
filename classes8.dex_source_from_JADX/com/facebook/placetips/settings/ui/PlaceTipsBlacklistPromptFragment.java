package com.facebook.placetips.settings.ui;

import android.app.Activity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.TextView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.fbui.widget.layout.SegmentedLinearLayout;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.base.Strings;

/* compiled from: captcha_solve_request_succeeded */
public class PlaceTipsBlacklistPromptFragment extends FbFragment {

    /* compiled from: captcha_solve_request_succeeded */
    public interface OnUndoItemClickedListener {
        void mo1098i();
    }

    /* compiled from: captcha_solve_request_succeeded */
    class C20211 implements OnClickListener {
        final /* synthetic */ PlaceTipsBlacklistPromptFragment f18431a;

        C20211(PlaceTipsBlacklistPromptFragment placeTipsBlacklistPromptFragment) {
            this.f18431a = placeTipsBlacklistPromptFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -789014375);
            Activity ao = this.f18431a.ao();
            if (ao instanceof OnUndoItemClickedListener) {
                ((OnUndoItemClickedListener) ao).mo1098i();
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1078185499, a);
        }
    }

    public final View m22365a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1711146083);
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(2130906277, viewGroup, false);
        SegmentedLinearLayout segmentedLinearLayout = (SegmentedLinearLayout) viewGroup2.findViewById(2131566038);
        if (ao() == null || ao().getIntent() == null) {
            str = null;
        } else {
            str = ao().getIntent().getStringExtra("place_name");
        }
        String str2 = str;
        if (!Strings.isNullOrEmpty(str2)) {
            ViewStub viewStub = (ViewStub) viewGroup2.findViewById(2131566039);
            viewStub.setLayoutResource(2130906279);
            viewStub.inflate();
            TextView textView = (TextView) viewGroup2.findViewById(2131566040);
            textView.setText(m22364a(str2));
            textView.setOnClickListener(new C20211(this));
        }
        PlaceTipsBlacklistFeedbackItem placeTipsBlacklistFeedbackItem = new PlaceTipsBlacklistFeedbackItem(getContext());
        placeTipsBlacklistFeedbackItem.m22362a(this.D, ContentFragmentType.PLACE_TIPS_BLACKLIST_REASON_FRAGMENT.ordinal(), 2131239384);
        segmentedLinearLayout.addView(placeTipsBlacklistFeedbackItem);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -61277672, a);
        return viewGroup2;
    }

    private CharSequence m22364a(String str) {
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(jW_().getString(2131239383, new Object[]{str}));
        spannableStringBuilder.append(" ");
        int length = spannableStringBuilder.length();
        spannableStringBuilder.setSpan(new TextAppearanceSpan(getContext(), 2131626249), 0, length, 33);
        spannableStringBuilder.append(jW_().getString(2131230753));
        spannableStringBuilder.setSpan(new TextAppearanceSpan(getContext(), 2131626248), length, spannableStringBuilder.length(), 33);
        return spannableStringBuilder;
    }
}

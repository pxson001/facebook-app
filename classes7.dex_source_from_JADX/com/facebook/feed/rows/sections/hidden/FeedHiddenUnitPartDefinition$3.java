package com.facebook.feed.rows.sections.hidden;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.feed.rows.core.props.FeedProps;
import com.facebook.feed.rows.sections.hidden.ui.FeedHiddenUnitView;

/* compiled from: Unable to provide an image due to stuck input/output */
class FeedHiddenUnitPartDefinition$3 extends ClickableSpan {
    final /* synthetic */ FeedHiddenUnitView f21436a;
    final /* synthetic */ FeedProps f21437b;
    final /* synthetic */ FeedHiddenUnitPartDefinition$State f21438c;
    final /* synthetic */ FeedHiddenUnitPartDefinition f21439d;

    FeedHiddenUnitPartDefinition$3(FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition, FeedHiddenUnitView feedHiddenUnitView, FeedProps feedProps, FeedHiddenUnitPartDefinition$State feedHiddenUnitPartDefinition$State) {
        this.f21439d = feedHiddenUnitPartDefinition;
        this.f21436a = feedHiddenUnitView;
        this.f21437b = feedProps;
        this.f21438c = feedHiddenUnitPartDefinition$State;
    }

    public void updateDrawState(TextPaint textPaint) {
        textPaint.setColor(textPaint.linkColor);
        textPaint.setUnderlineText(false);
    }

    public void onClick(View view) {
        FeedHiddenUnitPartDefinition feedHiddenUnitPartDefinition = this.f21439d;
        FeedHiddenUnitView feedHiddenUnitView = this.f21436a;
        feedHiddenUnitView.m24142a(new FeedHiddenUnitPartDefinition$8(feedHiddenUnitPartDefinition, feedHiddenUnitView, this.f21437b, this.f21438c));
        this.f21436a.setEnabled(false);
    }
}

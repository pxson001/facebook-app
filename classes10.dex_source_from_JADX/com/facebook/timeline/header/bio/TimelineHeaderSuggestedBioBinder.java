package com.facebook.timeline.header.bio;

import android.content.Context;
import android.view.View.OnClickListener;
import com.facebook.qe.api.QeAccessor;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import javax.inject.Inject;

/* compiled from: form_data */
public class TimelineHeaderSuggestedBioBinder {
    private final Context f11596a;
    private final QeAccessor f11597b;
    private String f11598c = this.f11596a.getString(2131230738);

    @Inject
    public TimelineHeaderSuggestedBioBinder(Context context, QeAccessor qeAccessor) {
        this.f11596a = context;
        this.f11597b = qeAccessor;
    }

    public final void m11624a(TimelineHeaderSuggestedBioView timelineHeaderSuggestedBioView, CharSequence charSequence, OnClickListener onClickListener, OnClickListener onClickListener2) {
        timelineHeaderSuggestedBioView.setSubtitle(m11623a(charSequence));
        timelineHeaderSuggestedBioView.setOnClickListener(onClickListener);
        timelineHeaderSuggestedBioView.setOnCloseListener(onClickListener2);
        timelineHeaderSuggestedBioView.setClickableColor(this.f11597b.a(ExperimentsForTimelineAbTestModule.am, false) ? 2131362082 : 2131361917);
    }

    private CharSequence m11623a(CharSequence charSequence) {
        if (charSequence.length() > 101) {
            return new StringBuilder().append(charSequence, 0, 101).append(this.f11598c);
        }
        return charSequence;
    }
}

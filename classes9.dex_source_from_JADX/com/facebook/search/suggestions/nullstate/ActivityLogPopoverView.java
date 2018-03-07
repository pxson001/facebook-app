package com.facebook.search.suggestions.nullstate;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.fbui.popover.PopoverWindow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.search.constants.SearchActivityLogFilter;
import com.facebook.search.suggestions.SuggestionsFragment;
import com.facebook.search.suggestions.SuggestionsFragment.C00135;
import com.facebook.search.util.GraphSearchConfig;
import com.facebook.search.util.bugreporter.SearchBugReportEvent;
import com.facebook.widget.CustomLinearLayout;

/* compiled from: xma_action_cta_clicked */
public class ActivityLogPopoverView extends CustomLinearLayout {
    public FbTextView f173a = ((FbTextView) a(2131562604));
    public C00135 f174b;
    public PopoverWindow f175c;

    /* compiled from: xma_action_cta_clicked */
    public class C00231 implements OnClickListener {
        final /* synthetic */ ActivityLogPopoverView f172a;

        public C00231(ActivityLogPopoverView activityLogPopoverView) {
            this.f172a = activityLogPopoverView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1065758283);
            if (!(this.f172a.f174b == null || this.f172a.f175c == null)) {
                C00135 c00135 = this.f172a.f174b;
                this.f172a.f175c.l();
                SuggestionsFragment suggestionsFragment = c00135.f84a;
                suggestionsFragment.aH.m332a(suggestionsFragment.ba.mo21i()).e();
                suggestionsFragment.aM.a(SuggestionsFragment.f99b, SearchBugReportEvent.ACTIVITY_LOG_LAUNCHED);
                ((FbUriIntentHandler) suggestionsFragment.ap.get()).a(suggestionsFragment.getContext(), GraphSearchConfig.b(suggestionsFragment.ba.mo21i()) ? StringFormatUtil.formatStrLocaleSafe(FBLinks.be, suggestionsFragment.aq, SearchActivityLogFilter.VIDEOS) : StringFormatUtil.formatStrLocaleSafe(FBLinks.bd, suggestionsFragment.aq));
            }
            Logger.a(2, EntryType.UI_INPUT_END, -206750413, a);
        }
    }

    public ActivityLogPopoverView(Context context) {
        super(context);
        setContentView(2130904623);
        setOrientation(1);
        this.f173a.setOnClickListener(new C00231(this));
    }

    public void onMeasure(int i, int i2) {
        Resources resources = getResources();
        super.onMeasure(MeasureSpec.makeMeasureSpec((int) (((float) resources.getDisplayMetrics().widthPixels) - (resources.getDimension(2131431687) * 2.0f)), 1073741824), i2);
    }
}

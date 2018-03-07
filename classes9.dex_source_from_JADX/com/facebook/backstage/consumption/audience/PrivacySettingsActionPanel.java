package com.facebook.backstage.consumption.audience;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.consumption.audience.PrivacySettingsRecyclerAdapter.C04681;
import com.facebook.backstage.data.AudienceControlData;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: rtc_free_international_call_promoted */
public class PrivacySettingsActionPanel extends ViewHolder {
    public final FbTextView f4671l;
    public final FbTextView f4672m;
    public boolean f4673n;

    public PrivacySettingsActionPanel(View view, final C04681 c04681) {
        super(view);
        this.f4672m = (FbTextView) view.findViewById(2131566279);
        this.f4672m.setSelected(false);
        this.f4671l = (FbTextView) view.findViewById(2131566278);
        this.f4672m.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PrivacySettingsActionPanel f4670b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1957752147);
                if (this.f4670b.f4673n) {
                    C04681 c04681 = c04681;
                    int size = c04681.f4677a.f4684i.size();
                    for (int i = 0; i < size; i++) {
                        PrivacySettingsRecyclerAdapter.m4573a(c04681.f4677a, ((AudienceControlData) c04681.f4677a.f4684i.get(i)).f5103a, true);
                    }
                    c04681.f4677a.f4680d.m4264a(Event.AUDIENCE_SELECT_ALL);
                    c04681.f4677a.notifyDataSetChanged();
                } else {
                    c04681.m4572b();
                }
                LogUtils.a(2102132396, a);
            }
        });
    }
}

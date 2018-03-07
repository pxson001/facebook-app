package com.facebook.timeline.header;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.facebook.timeline.delegate.ProfileControllerDelegate;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemFieldsModel;

/* compiled from: friends_day_2016 */
public class TimelineContextItemHelper {

    /* compiled from: friends_day_2016 */
    public final class C16411 extends ClickableSpan {
        final /* synthetic */ ProfileControllerDelegate f11320a;
        final /* synthetic */ TimelineContextListItemFieldsModel f11321b;
        final /* synthetic */ boolean f11322c;

        public C16411(ProfileControllerDelegate profileControllerDelegate, TimelineContextListItemFieldsModel timelineContextListItemFieldsModel, boolean z) {
            this.f11320a = profileControllerDelegate;
            this.f11321b = timelineContextListItemFieldsModel;
            this.f11322c = z;
        }

        public final void onClick(View view) {
            this.f11320a.mo482r().mo504a(this.f11321b, true);
            if (this.f11322c) {
                this.f11320a.mn_();
            }
        }

        public final void updateDrawState(TextPaint textPaint) {
            textPaint.setUnderlineText(false);
        }
    }
}

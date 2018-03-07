package com.facebook.messaging.xma.hscroll;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel.SubattachmentsModel;
import com.facebook.messaging.xma.SimpleStyleRenderer;
import com.facebook.widget.ListViewFriendlyViewPager;

/* compiled from: thumbnail_ms */
public class HScrollAttachmentViewPager extends ListViewFriendlyViewPager {
    public HScrollAttachmentViewPager(Context context) {
        super(context);
    }

    protected int getMeasuredHeightOfFirstItem() {
        int i;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824);
        HScrollAttachmentAdapter hScrollAttachmentAdapter = (HScrollAttachmentAdapter) getAdapter();
        if (hScrollAttachmentAdapter.f1585f == null) {
            i = 0;
        } else {
            SimpleStyleRenderer simpleStyleRenderer = hScrollAttachmentAdapter.f1585f;
            View a = simpleStyleRenderer.m1729a(hScrollAttachmentAdapter.f1582c);
            int size = hScrollAttachmentAdapter.f1584e.size();
            int i2 = 0;
            i = 0;
            while (i2 < size) {
                simpleStyleRenderer.m1732a(a, (SubattachmentsModel) hScrollAttachmentAdapter.f1584e.get(i2));
                a.measure(makeMeasureSpec, 0);
                i2++;
                i = a.getMeasuredHeight() > i ? a.getMeasuredHeight() : i;
            }
            hScrollAttachmentAdapter.f1585f.m1731a(a);
        }
        return i;
    }
}

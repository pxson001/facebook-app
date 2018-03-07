package com.facebook.pages.browser.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.RecyclableView;

/* compiled from: story_gallery_survey_feed_unit_finish */
public class PagesBrowserListExploreView extends CustomRelativeLayout implements RecyclableView {
    public final View f1317a;
    public FbUriIntentHandler f1318b;
    public boolean f1319c;

    /* compiled from: story_gallery_survey_feed_unit_finish */
    class C01781 implements OnClickListener {
        final /* synthetic */ PagesBrowserListExploreView f1316a;

        C01781(PagesBrowserListExploreView pagesBrowserListExploreView) {
            this.f1316a = pagesBrowserListExploreView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -16952177);
            this.f1316a.f1318b.a(this.f1316a.getContext(), FBLinks.aJ, new Bundle());
            Logger.a(2, EntryType.UI_INPUT_END, -695396531, a);
        }
    }

    public static void m1975a(Object obj, Context context) {
        ((PagesBrowserListExploreView) obj).f1318b = FbUriIntentHandler.a(FbInjector.get(context));
    }

    public PagesBrowserListExploreView(Context context) {
        this(context, null);
    }

    private PagesBrowserListExploreView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Class cls = PagesBrowserListExploreView.class;
        m1975a(this, getContext());
        setContentView(2130906098);
        this.f1317a = a(2131565676);
        this.f1317a.setOnClickListener(new C01781(this));
    }

    protected void onAttachedToWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, 1784187931);
        super.onAttachedToWindow();
        this.f1319c = true;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1936468602, a);
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -1819138462);
        super.onDetachedFromWindow();
        this.f1319c = false;
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, -1718022709, a);
    }

    public final boolean m1976a() {
        return this.f1319c;
    }
}

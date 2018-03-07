package com.facebook.pages.fb4a.admin_activity.views;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.fb4a.admin_activity.fragment.PageActivityFragment.UpdateViewListener;
import com.facebook.pages.fb4a.admin_activity.views.PageIdentityLinkView.WebViewLaunchedListener;
import com.google.common.base.Optional;

/* compiled from: qcam_%d */
public class PageIdentityDefaultLinkView extends PageIdentityLinkView {
    public PageIdentityDefaultLinkView(Context context) {
        super(context);
    }

    public PageIdentityDefaultLinkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PageIdentityDefaultLinkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void mo75a(String str, long j, Optional<? extends WebViewLaunchedListener> optional) {
        final long j2 = j;
        final String str2 = str;
        final Optional<? extends WebViewLaunchedListener> optional2 = optional;
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageIdentityDefaultLinkView f2890d;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1140708119);
                this.f2890d.m3855a(j2);
                Intent a2 = this.f2890d.f2895e.a(this.f2890d.getContext(), StringFormatUtil.formatStrLocaleSafe(str2, Long.valueOf(j2)));
                a2.putExtra("uri_unhandled_report_category_name", "PageFacewebUriNotHandled");
                if (optional2.isPresent()) {
                    ((UpdateViewListener) optional2.get()).m3741a();
                }
                this.f2890d.f2893c.a(a2, this.f2890d.getContext());
                Logger.a(2, EntryType.UI_INPUT_END, 1374138409, a);
            }
        });
    }
}

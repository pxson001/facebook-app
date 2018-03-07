package com.facebook.commerce.core.ui;

import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.commerce.core.util.CommerceNavigationUtil;
import com.facebook.common.util.StringUtil;
import com.facebook.fbui.widget.contentview.ContentView;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: preview_call_to_action_text */
public class PageInfoView {
    public final CommerceNavigationUtil f7517a;
    public final ContentView f7518b;
    @Nullable
    public String f7519c;

    /* compiled from: preview_call_to_action_text */
    public class C04501 implements OnClickListener {
        final /* synthetic */ PageInfoView f7516a;

        public C04501(PageInfoView pageInfoView) {
            this.f7516a = pageInfoView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -915299428);
            if (!StringUtil.a(this.f7516a.f7519c)) {
                this.f7516a.f7517a.m10692a(this.f7516a.f7519c, null);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1478743382, a);
        }
    }

    @Inject
    public PageInfoView(CommerceNavigationUtil commerceNavigationUtil, @Assisted ContentView contentView) {
        this.f7517a = commerceNavigationUtil;
        this.f7518b = contentView;
        this.f7518b.setOnClickListener(new C04501(this));
    }

    public final void m10649a(String str) {
        this.f7518b.setTitleText(str);
    }

    public final void m10650a(String str, int i) {
        this.f7518b.setSubtitleText(this.f7518b.getContext().getResources().getQuantityString(2131689602, i, new Object[]{str, Integer.valueOf(i)}));
    }

    public final void m10648a(Uri uri) {
        this.f7518b.setThumbnailUri(uri);
    }

    public final void m10651a(boolean z) {
        this.f7518b.setVisibility(z ? 0 : 8);
    }
}

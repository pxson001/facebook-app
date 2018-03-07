package com.facebook.pages.fb4a.admin_activity.views;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.inject.FbInjector;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.fb4a.admin_activity.views.PageIdentityLinkView.WebViewLaunchedListener;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: pyml */
public class PageIdentityMessagesLinkView extends PageIdentityLinkView {
    @Inject
    public UriIntentMapper f2902h;

    private static <T extends View> void m3859a(Class<T> cls, T t) {
        m3860a((Object) t, t.getContext());
    }

    private static void m3860a(Object obj, Context context) {
        ((PageIdentityMessagesLinkView) obj).f2902h = (UriIntentMapper) Fb4aUriIntentMapper.a(FbInjector.get(context));
    }

    public PageIdentityMessagesLinkView(Context context) {
        this(context, null);
    }

    public PageIdentityMessagesLinkView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PageIdentityMessagesLinkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3859a(PageIdentityMessagesLinkView.class, (View) this);
    }

    public final void mo75a(final String str, final long j, Optional<? extends WebViewLaunchedListener> optional) {
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageIdentityMessagesLinkView f2901c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 519718137);
                this.f2901c.m3855a(j);
                Intent a2 = this.f2901c.f2902h.a(this.f2901c.getContext(), StringFormatUtil.formatStrLocaleSafe(str, Long.valueOf(j)));
                if (a2 != null) {
                    this.f2901c.f2893c.b(a2, this.f2901c.getContext());
                }
                Logger.a(2, EntryType.UI_INPUT_END, -1261673819, a);
            }
        });
    }

    private void m3858a(UriIntentMapper uriIntentMapper) {
        this.f2902h = uriIntentMapper;
    }
}

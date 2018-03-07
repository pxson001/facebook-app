package com.facebook.pages.fb4a.admin_activity.views;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.fb4a.admin_activity.views.PageIdentityLinkView.WebViewLaunchedListener;
import com.facebook.reaction.action.PagesReactionManager;
import com.google.common.base.Optional;
import javax.inject.Inject;

/* compiled from: pyma_promote */
public class PageIdentityPageTipView extends PageIdentityLinkView {
    @Inject
    PagesReactionManager f2913h;
    @Inject
    FbUriIntentHandler f2914i;

    private static <T extends View> void m3872a(Class<T> cls, T t) {
        m3873a((Object) t, t.getContext());
    }

    private static void m3873a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((PageIdentityPageTipView) obj).m3871a(PagesReactionManager.b(fbInjector), FbUriIntentHandler.a(fbInjector));
    }

    public PageIdentityPageTipView(Context context) {
        super(context);
        m3870a();
    }

    public PageIdentityPageTipView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m3870a();
    }

    public PageIdentityPageTipView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3870a();
    }

    private void m3870a() {
        m3872a(PageIdentityPageTipView.class, (View) this);
    }

    public final void mo75a(String str, final long j, Optional<? extends WebViewLaunchedListener> optional) {
        setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ PageIdentityPageTipView f2912b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -908009128);
                String uuid = SafeUUIDGenerator.a().toString();
                this.f2912b.f2913h.a(Surface.ANDROID_PAGE_ADS_AFTER_PARTY_AYMT_ACTIVITIES_TAB_ITEM, j, uuid);
                Bundle a2 = PageIdentityPageTipView.m3869a(this.f2912b.getContext(), uuid, j);
                this.f2912b.f2914i.a(this.f2912b.getContext(), StringFormatUtil.a(FBLinks.ao, new Object[]{Long.valueOf(j)}), a2);
                Logger.a(2, EntryType.UI_INPUT_END, 315689888, a);
            }
        });
    }

    private void m3871a(PagesReactionManager pagesReactionManager, FbUriIntentHandler fbUriIntentHandler) {
        this.f2913h = pagesReactionManager;
        this.f2914i = fbUriIntentHandler;
    }

    public static Bundle m3869a(Context context, String str, long j) {
        Bundle bundle = new Bundle();
        bundle.putString("reaction_session_id", str);
        bundle.putString("page_context_item_type", context.getString(2131235548));
        bundle.putLong("com.facebook.katana.profile.id", j);
        bundle.putInt("empty_view", 2130906016);
        bundle.putString("source_name", context.getString(2131235548));
        return bundle;
    }
}

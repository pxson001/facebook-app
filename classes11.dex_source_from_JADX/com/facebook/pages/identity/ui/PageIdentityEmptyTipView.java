package com.facebook.pages.identity.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.inject.FbInjector;
import com.facebook.intent.feed.DefaultFeedIntentBuilder;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.constants.PagesConstants.URL;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ui.compat.fbrelativelayout.FbRelativeLayout;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: page_identity_message_fail */
public class PageIdentityEmptyTipView extends FbRelativeLayout {
    public IFeedIntentBuilder f4238a;

    /* compiled from: page_identity_message_fail */
    class C05911 implements OnClickListener {
        final /* synthetic */ PageIdentityEmptyTipView f4237a;

        C05911(PageIdentityEmptyTipView pageIdentityEmptyTipView) {
            this.f4237a = pageIdentityEmptyTipView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1079008805);
            this.f4237a.f4238a.a(this.f4237a.getContext(), URL.j);
            Logger.a(2, EntryType.UI_INPUT_END, -1275036116, a);
        }
    }

    private static <T extends View> void m5221a(Class<T> cls, T t) {
        m5222a((Object) t, t.getContext());
    }

    private static void m5222a(Object obj, Context context) {
        ((PageIdentityEmptyTipView) obj).f4238a = (IFeedIntentBuilder) DefaultFeedIntentBuilder.a(FbInjector.get(context));
    }

    public PageIdentityEmptyTipView(Context context) {
        super(context);
        m5219a();
    }

    public PageIdentityEmptyTipView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m5219a();
    }

    public PageIdentityEmptyTipView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m5219a();
    }

    private void m5219a() {
        m5221a(PageIdentityEmptyTipView.class, (View) this);
    }

    @Inject
    private void m5220a(IFeedIntentBuilder iFeedIntentBuilder) {
        this.f4238a = iFeedIntentBuilder;
    }

    protected void onFinishInflate() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -569771702);
        ((FbTextView) findViewById(2131565489)).setOnClickListener(new C05911(this));
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1205383659, a);
    }
}

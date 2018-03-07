package com.facebook.photos.pandora.ui.listview;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.inject.FbInjector;
import com.facebook.photos.pandora.ui.PandoraAdapter;
import com.facebook.widget.CustomViewUtils;
import com.facebook.widget.listview.BetterListView;

/* compiled from: com.android.browser.headers */
public class PandoraFeedListView extends BetterListView {
    public PandoraAdapter f17748a;

    /* compiled from: com.android.browser.headers */
    class C18981 implements OnScrollListener {
        final /* synthetic */ PandoraFeedListView f17747a;

        C18981(PandoraFeedListView pandoraFeedListView) {
            this.f17747a = pandoraFeedListView;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 >= i3 - 5 && i3 > 0 && this.f17747a.f17748a != null) {
                this.f17747a.f17748a.f17594a.mo1054d();
            }
        }
    }

    private static <T extends View> void m21727a(Class<T> cls, T t) {
        FbInjector.get(t.getContext());
    }

    private static void m21728a(Object obj, Context context) {
        FbInjector.get(context);
    }

    public PandoraFeedListView(Context context) {
        super(context);
        m21729g();
    }

    public PandoraFeedListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21729g();
    }

    public PandoraFeedListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m21729g();
    }

    private void m21729g() {
        m21727a(PandoraFeedListView.class, (View) this);
        Drawable colorDrawable = new ColorDrawable(getResources().getColor(2131363271));
        setDrawingCacheBackgroundColor(getResources().getColor(2131363271));
        CustomViewUtils.b(this, colorDrawable);
        setSelector(colorDrawable);
        setDivider(colorDrawable);
        setOverscrollFooter(colorDrawable);
        setDividerHeight(getResources().getDimensionPixelSize(2131430943));
        setCacheColorHint(0);
        a(new C18981(this));
    }

    public void setPandoraStoryFetcher(PandoraAdapter pandoraAdapter) {
        this.f17748a = pandoraAdapter;
    }
}

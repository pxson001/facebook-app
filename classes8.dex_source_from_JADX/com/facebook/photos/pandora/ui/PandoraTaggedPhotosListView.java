package com.facebook.photos.pandora.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.facebook.inject.FbInjector;
import com.facebook.widget.listview.BetterListView;

/* compiled from: com.facebook.composer.shareintent.ImplicitShareIntentHandler */
public class PandoraTaggedPhotosListView extends BetterListView {

    /* compiled from: com.facebook.composer.shareintent.ImplicitShareIntentHandler */
    public class C18971 implements OnScrollListener {
        final /* synthetic */ PandoraTaggedPhotosListView f17742a;

        public C18971(PandoraTaggedPhotosListView pandoraTaggedPhotosListView) {
            this.f17742a = pandoraTaggedPhotosListView;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            if (i + i2 >= i3 - 5 && i3 > 0) {
                ((PandoraTaggedPhotosAdapter) ((PandoraTaggedPhotosMainAdapter) this.f17742a.getAdapter()).f17745c.get()).mo1054d();
            }
        }
    }

    public PandoraTaggedPhotosListView(Context context) {
        super(context);
        Class cls = PandoraTaggedPhotosListView.class;
        FbInjector.get(getContext());
        int color = getResources().getColor(2131363277);
        Drawable colorDrawable = new ColorDrawable(color);
        setDrawingCacheBackgroundColor(color);
        setBackgroundDrawable(colorDrawable);
        setSelector(colorDrawable);
        setDivider(colorDrawable);
        setOverscrollFooter(colorDrawable);
        setDividerHeight(getResources().getDimensionPixelSize(2131430950));
        setCacheColorHint(0);
        a(new C18971(this));
    }
}

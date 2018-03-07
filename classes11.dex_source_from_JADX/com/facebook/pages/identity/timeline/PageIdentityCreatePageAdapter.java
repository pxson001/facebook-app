package com.facebook.pages.identity.timeline;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.logging.analytics.PagesAnalytics;
import com.facebook.pages.common.logging.analytics.TapEvent;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.listview.FbBaseAdapter;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: page_photos_max_num */
public class PageIdentityCreatePageAdapter extends FbBaseAdapter {
    public long f4148a;
    public Context f4149b;
    public FbUriIntentHandler f4150c;
    public PagesAnalytics f4151d;
    private OnClickListener f4152e = new C05681(this);

    /* compiled from: page_photos_max_num */
    class C05681 implements OnClickListener {
        final /* synthetic */ PageIdentityCreatePageAdapter f4147a;

        C05681(PageIdentityCreatePageAdapter pageIdentityCreatePageAdapter) {
            this.f4147a = pageIdentityCreatePageAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 823705131);
            this.f4147a.f4151d.g(this.f4147a.f4148a, TapEvent.EVENT_TAPPED_TIMELINE_FOOTER_CREATE_PAGE.getName());
            this.f4147a.f4150c.a(this.f4147a.f4149b, FBLinks.aE);
            Logger.a(2, EntryType.UI_INPUT_END, 1030789845, a);
        }
    }

    public static PageIdentityCreatePageAdapter m5099b(InjectorLike injectorLike) {
        return new PageIdentityCreatePageAdapter((Context) injectorLike.getInstance(Context.class), FbUriIntentHandler.a(injectorLike), PagesAnalytics.a(injectorLike));
    }

    @Inject
    public PageIdentityCreatePageAdapter(Context context, FbUriIntentHandler fbUriIntentHandler, PagesAnalytics pagesAnalytics) {
        this.f4149b = context;
        this.f4150c = fbUriIntentHandler;
        this.f4151d = pagesAnalytics;
    }

    public final View m5100a(int i, ViewGroup viewGroup) {
        FbTextView fbTextView = (FbTextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130906012, viewGroup, false);
        fbTextView.setOnClickListener(this.f4152e);
        return fbTextView;
    }

    public final void m5101a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
    }

    public int getCount() {
        return 1;
    }

    public Object getItem(int i) {
        return null;
    }

    public long getItemId(int i) {
        return 0;
    }

    public View getView(int i, @Nullable View view, ViewGroup viewGroup) {
        return view != null ? view : a(0, viewGroup);
    }
}

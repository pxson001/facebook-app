package com.facebook.pages.common.services;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.common.services.PagesServiceCarousel.PagesServiceCarouselItemClickListener;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLInterfaces.PageServiceItem;
import com.facebook.pages.identity.protocol.graphql.ServicesListGraphQLModels.PageServiceItemModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: rotateEnabled */
public class PagesServiceCarouselPagerAdapter extends PagerAdapter {
    private Context f2337a;
    public PagesServiceCarouselItemClickListener f2338b;
    private final List<PageServiceItem> f2339c = new ArrayList();

    public PagesServiceCarouselPagerAdapter(Context context) {
        this.f2337a = context;
    }

    public final void m3297a(List<PageServiceItem> list) {
        this.f2339c.clear();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Object obj;
                PageServiceItemModel pageServiceItemModel = (PageServiceItemModel) it.next();
                if (PagesServiceUtils.m3305a(pageServiceItemModel) != null) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    this.f2339c.add(pageServiceItemModel);
                }
            }
        }
        kR_();
    }

    public final Object m3295a(ViewGroup viewGroup, int i) {
        PagesServiceCarouselItem pagesServiceCarouselItem = new PagesServiceCarouselItem(this.f2337a);
        final PageServiceItemModel pageServiceItemModel = (PageServiceItemModel) this.f2339c.get(i);
        Uri a = PagesServiceUtils.m3305a(pageServiceItemModel);
        CharSequence eC_ = pageServiceItemModel.eC_();
        CharSequence c = pageServiceItemModel.c();
        OnClickListener c02891 = new OnClickListener(this) {
            final /* synthetic */ PagesServiceCarouselPagerAdapter f2336b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 409712126);
                this.f2336b.f2338b.mo44a(pageServiceItemModel);
                Logger.a(2, EntryType.UI_INPUT_END, 676808552, a);
            }
        };
        if (a != null) {
            pagesServiceCarouselItem.f2332c.a(a, PagesServiceCarouselItem.f2330a);
            pagesServiceCarouselItem.f2332c.setVisibility(0);
        } else {
            pagesServiceCarouselItem.f2332c.setVisibility(8);
        }
        pagesServiceCarouselItem.f2333d.setText(eC_);
        if (c == null || StringUtil.a(c)) {
            pagesServiceCarouselItem.f2334e.setText(2131235473);
        } else {
            pagesServiceCarouselItem.f2334e.setText(c);
        }
        pagesServiceCarouselItem.f2331b.setOnClickListener(c02891);
        viewGroup.addView(pagesServiceCarouselItem);
        return pagesServiceCarouselItem;
    }

    public final int m3294a(Object obj) {
        return -2;
    }

    public final void m3296a(ViewGroup viewGroup, int i, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public final int m3299b() {
        return this.f2339c.size();
    }

    public final boolean m3298a(View view, Object obj) {
        return view == obj;
    }

    public final CharSequence J_(int i) {
        return "";
    }
}

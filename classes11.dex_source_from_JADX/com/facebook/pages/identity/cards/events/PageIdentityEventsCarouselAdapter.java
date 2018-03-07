package com.facebook.pages.identity.cards.events;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.events.model.EventsCollection;
import com.facebook.feed.hscroll.FeedRecyclablePagerAdapter;
import com.facebook.graphql.model.GraphQLEvent;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.pages.identity.ui.carousel.PageIdentityUpcomingEventsCardView.C05962;
import com.facebook.ui.recyclablepager.PagerViewType;
import com.facebook.ui.recyclableviewpool.RecyclableViewPoolManager;
import javax.inject.Inject;

/* compiled from: privacy_checkup_intro_step_close */
public class PageIdentityEventsCarouselAdapter extends FeedRecyclablePagerAdapter<GraphQLEvent> {
    private final PagerViewType f3513a = new C04781(this);
    public long f3514b;
    public C05962 f3515c;
    public EventsCollection<GraphQLEvent> f3516d;

    /* compiled from: privacy_checkup_intro_step_close */
    class C04781 implements PagerViewType {
        final /* synthetic */ PageIdentityEventsCarouselAdapter f3510a;

        C04781(PageIdentityEventsCarouselAdapter pageIdentityEventsCarouselAdapter) {
            this.f3510a = pageIdentityEventsCarouselAdapter;
        }

        public final Class m4559a() {
            return PageIdentityEventGalleryItem.class;
        }

        public final View m4558a(Context context) {
            PageIdentityEventGalleryItem pageIdentityEventGalleryItem = new PageIdentityEventGalleryItem(context);
            pageIdentityEventGalleryItem.setBackgroundResource(2130840254);
            return pageIdentityEventGalleryItem;
        }
    }

    /* compiled from: privacy_checkup_intro_step_close */
    class InternalItemClickListener implements OnClickListener {
        final /* synthetic */ PageIdentityEventsCarouselAdapter f3511a;
        private int f3512b;

        public InternalItemClickListener(PageIdentityEventsCarouselAdapter pageIdentityEventsCarouselAdapter, int i) {
            this.f3511a = pageIdentityEventsCarouselAdapter;
            this.f3512b = i;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -1381092740);
            if (this.f3511a.f3515c != null) {
                C05962 c05962 = this.f3511a.f3515c;
                c05962.f4259a.m4543a(this.f3512b);
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1583728620, a);
        }
    }

    protected final void m4560a(View view, Object obj, int i) {
        PageIdentityEventGalleryItem pageIdentityEventGalleryItem = (PageIdentityEventGalleryItem) view;
        pageIdentityEventGalleryItem.a((GraphQLEvent) obj, this.f3514b);
        pageIdentityEventGalleryItem.setOnClickListener(new InternalItemClickListener(this, i));
    }

    @Inject
    public PageIdentityEventsCarouselAdapter(Context context, RecyclableViewPoolManager recyclableViewPoolManager) {
        super(recyclableViewPoolManager);
    }

    protected final PagerViewType m4561d() {
        return this.f3513a;
    }
}

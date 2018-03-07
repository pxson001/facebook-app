package com.facebook.events.carousel;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import com.facebook.common.util.StringUtil;
import com.facebook.events.carousel.EventsCarouselPagerAdapter.EventsSuggestionsPagerAdapterEmptiedListener;
import com.facebook.events.common.EventAnalyticsParams;
import com.facebook.events.logging.EventEventLogger;
import com.facebook.fbui.widget.text.ImageWithTextView;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.widget.CustomLinearLayout;
import com.facebook.widget.ListViewFriendlyViewPager;
import com.facebook.widget.text.BetterTextView;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.inject.Inject;

/* compiled from: contacts_tabs */
public abstract class EventsCarouselCard extends CustomLinearLayout implements EventsSuggestionsPagerAdapterEmptiedListener {
    @Inject
    public EventEventLogger f16004a;
    public OnClickListener f16005b;
    private ProgressBar f16006c;
    private ListViewFriendlyViewPager f16007d;
    private BetterTextView f16008e;
    private FbTextView f16009f;
    private Set<Integer> f16010g;

    /* compiled from: contacts_tabs */
    class C22341 extends SimpleOnPageChangeListener {
        final /* synthetic */ EventsCarouselCard f16003a;

        C22341(EventsCarouselCard eventsCarouselCard) {
            this.f16003a = eventsCarouselCard;
        }

        public final void e_(int i) {
            EventsCarouselCard.m16422d(this.f16003a, i);
        }
    }

    public static void m16419a(Object obj, Context context) {
        ((EventsCarouselCard) obj).f16004a = EventEventLogger.m18119b(FbInjector.get(context));
    }

    protected abstract String mo800c(int i);

    protected abstract EventAnalyticsParams getEventAnalyticsParams();

    protected abstract String getModule();

    protected abstract CharSequence getTitle();

    protected abstract CharSequence getViewAllText();

    public EventsCarouselCard(Context context) {
        super(context);
        m16420b();
    }

    private void m16420b() {
        Class cls = EventsCarouselCard.class;
        m16419a(this, getContext());
        setContentView(2130904170);
        this.f16010g = Sets.a();
        this.f16006c = (ProgressBar) a(2131561572);
        this.f16008e = (BetterTextView) a(2131561479);
        this.f16009f = (FbTextView) a(2131561574);
        this.f16007d = (ListViewFriendlyViewPager) a(2131561575);
        this.f16007d.setPageMargin(getResources().getDimensionPixelSize(2131431083));
        this.f16007d.setOnPageChangeListener(new C22341(this));
        m16421c();
    }

    private void m16421c() {
        CharSequence title = getTitle();
        if (StringUtil.a(title)) {
            throw new IllegalArgumentException("Dashboard cards must have a title.");
        }
        ((FbTextView) a(2131561476)).setText(title);
        CharSequence viewAllText = getViewAllText();
        if (StringUtil.a(viewAllText)) {
            this.f16008e.setVisibility(8);
            this.f16008e.setOnClickListener(null);
            this.f16009f.setOnClickListener(null);
            return;
        }
        this.f16008e.setText(viewAllText);
        this.f16009f.setText(viewAllText);
        this.f16008e.setVisibility(0);
        this.f16008e.setOnClickListener(this.f16005b);
        this.f16009f.setOnClickListener(this.f16005b);
    }

    public void setPagerAdapter(@Nonnull EventsCarouselPagerAdapter eventsCarouselPagerAdapter) {
        if (eventsCarouselPagerAdapter.b() == 0) {
            this.f16006c.setVisibility(8);
            a(2131561573).setVisibility(0);
            return;
        }
        this.f16006c.setVisibility(8);
        m16421c();
        this.f16007d.setAdapter(eventsCarouselPagerAdapter);
        eventsCarouselPagerAdapter.f16024j = this;
        this.f16007d.setVisibility(0);
        m16422d(this, 0);
    }

    public static void m16422d(EventsCarouselCard eventsCarouselCard, int i) {
        String c = eventsCarouselCard.mo800c(i);
        EventAnalyticsParams eventAnalyticsParams = eventsCarouselCard.getEventAnalyticsParams();
        if (!eventsCarouselCard.f16010g.contains(Integer.valueOf(i)) && !StringUtil.a(c) && eventAnalyticsParams != null) {
            eventsCarouselCard.f16010g.add(Integer.valueOf(i));
            eventsCarouselCard.f16004a.m18131a(c, eventsCarouselCard.getModule(), i, eventsCarouselCard.getEventAnalyticsParams().b.e.getParamValue());
        }
    }

    public void mo774a() {
        if (VERSION.SDK_INT < 11) {
            ((FbTextView) a(2131561479)).setVisibility(4);
            ((FbTextView) a(2131561574)).setVisibility(0);
            return;
        }
        m16423e();
    }

    @TargetApi(11)
    private void m16423e() {
        float height;
        BetterTextView betterTextView = this.f16008e;
        FbTextView fbTextView = this.f16009f;
        long integer = (long) getResources().getInteger(17694720);
        betterTextView.setVisibility(4);
        fbTextView.setVisibility(0);
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        Rect rect3 = new Rect();
        betterTextView.getGlobalVisibleRect(rect2);
        fbTextView.getHitRect(rect);
        fbTextView.getGlobalVisibleRect(rect3);
        int i = rect.top - (rect3.top - rect2.top);
        int i2 = rect.left - (rect3.left - rect2.left);
        rect3 = new Rect(i2, i, rect2.width() + i2, rect2.height() + i);
        float width;
        if (((float) rect.width()) / ((float) rect.height()) > ((float) rect3.width()) / ((float) rect3.height())) {
            height = ((float) rect3.height()) / ((float) rect.height());
            width = ((float) rect.width()) * height;
            rect3.width();
            width = (width - ((float) rect3.width())) / 2.0f;
            rect3.left = (int) (((float) rect3.left) - width);
            rect3.right = (int) (width + ((float) rect3.right));
        } else {
            height = ((float) rect3.width()) / ((float) rect.width());
            width = ((((float) rect.height()) * height) - ((float) rect3.height())) / 2.0f;
            rect3.top = (int) (((float) rect3.top) - width);
            rect3.bottom = (int) (width + ((float) rect3.bottom));
        }
        fbTextView.setPivotX(0.0f);
        fbTextView.setPivotY(0.0f);
        EventsCarouselViewAnimator.m16436a(fbTextView, rect3, rect, height, integer);
    }

    public final void m16425a(int i, int i2, int i3) {
        int color = getResources().getColor(i3);
        Drawable drawable = getResources().getDrawable(i2);
        drawable.setColorFilter(color, Mode.SRC_ATOP);
        ImageWithTextView imageWithTextView = (ImageWithTextView) findViewById(2131561576);
        imageWithTextView.setText(i);
        imageWithTextView.setTextColor(color);
        imageWithTextView.setImageDrawable(drawable);
        imageWithTextView.setVisibility(0);
        findViewById(2131561571).setVisibility(8);
        this.f16008e.setVisibility(8);
    }
}

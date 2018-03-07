package com.facebook.events.permalink.about;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.common.util.StringUtil;
import com.facebook.events.common.EventDrawDividerUtil;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonTextWithEntitiesModel;
import com.facebook.events.graphql.EventsGraphQLModels.FetchEventPermalinkFragmentModel;
import com.facebook.events.model.Event;
import com.facebook.events.model.EventArtist;
import com.facebook.events.permalink.about.DetailsTextView.DetailsTextViewListener;
import com.facebook.events.protocol.EventGraphQLModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: canReplyTo */
public class EventPermalinkDetailsView extends CustomLinearLayout {
    @Inject
    public LinkifyUtil f17925a;
    private View f17926b;
    private FbTextView f17927c;
    private DetailsTextView f17928d;
    private ViewGroup f17929e;
    private String f17930f;
    private EventDrawDividerUtil f17931g;

    /* compiled from: canReplyTo */
    class C25381 implements DetailsTextViewListener {
        final /* synthetic */ EventPermalinkDetailsView f17924a;

        C25381(EventPermalinkDetailsView eventPermalinkDetailsView) {
            this.f17924a = eventPermalinkDetailsView;
        }

        public final void mo817a() {
            this.f17924a.requestLayout();
        }

        public final void mo818b() {
            this.f17924a.requestLayout();
        }
    }

    private static <T extends View> void m18335a(Class<T> cls, T t) {
        m18336a((Object) t, t.getContext());
    }

    private static void m18336a(Object obj, Context context) {
        ((EventPermalinkDetailsView) obj).f17925a = LinkifyUtil.a(FbInjector.get(context));
    }

    public EventPermalinkDetailsView(Context context) {
        super(context);
        m18333a();
    }

    public EventPermalinkDetailsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18333a();
    }

    private void m18334a(LinkifyUtil linkifyUtil) {
        this.f17925a = linkifyUtil;
    }

    protected EventPermalinkDetailsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private void m18333a() {
        m18335a(EventPermalinkDetailsView.class, (View) this);
        setContentView(2130904065);
        setOrientation(1);
        int dimensionPixelSize = getResources().getDimensionPixelSize(2131427417);
        setPadding(0, dimensionPixelSize, 0, dimensionPixelSize);
        this.f17931g = new EventDrawDividerUtil(getResources());
        this.f17927c = (FbTextView) a(2131561351);
        this.f17926b = a(2131561350);
        this.f17928d = (DetailsTextView) a(2131561349);
        this.f17928d.m18319a();
        this.f17929e = (ViewGroup) a(2131561352);
        this.f17928d.f17907l = new C25381(this);
    }

    public void setTitle(@StringRes int i) {
        this.f17927c.setText(i);
    }

    public final void m18337a(Event event, @Nullable FetchEventPermalinkFragmentModel fetchEventPermalinkFragmentModel) {
        boolean z = true;
        this.f17930f = event.a;
        EventCommonTextWithEntitiesModel eventCommonTextWithEntitiesModel = event.c;
        if (eventCommonTextWithEntitiesModel == null || StringUtil.a(eventCommonTextWithEntitiesModel.a())) {
            this.f17926b.setVisibility(8);
        } else {
            this.f17928d.setText(this.f17925a.a(eventCommonTextWithEntitiesModel, true, null));
            this.f17926b.setVisibility(0);
        }
        if (fetchEventPermalinkFragmentModel != null) {
            ImmutableList a = EventGraphQLModelHelper.m19260a(fetchEventPermalinkFragmentModel);
            if (a.isEmpty()) {
                this.f17929e.setVisibility(8);
            } else {
                this.f17929e.setVisibility(0);
                this.f17929e.removeAllViews();
                LayoutInflater from = LayoutInflater.from(getContext());
                int size = a.size();
                for (int i = 0; i < size; i++) {
                    EventArtist eventArtist = (EventArtist) a.get(i);
                    if (!z) {
                        from.inflate(2130903990, this.f17929e);
                    } else if (this.f17926b.getVisibility() == 0) {
                        from.inflate(2130903991, this.f17929e);
                        z = false;
                    } else {
                        z = false;
                    }
                    EventArtistRowView eventArtistRowView = new EventArtistRowView(getContext());
                    eventArtistRowView.m18323a(eventArtist);
                    this.f17929e.addView(eventArtistRowView);
                }
            }
        }
        if (this.f17928d.getVisibility() == 8 && this.f17929e.getVisibility() == 8) {
            setVisibility(8);
        } else {
            setVisibility(0);
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f17931g.a(canvas, (float) getPaddingTop());
        this.f17931g.b(canvas, (float) getPaddingBottom());
    }
}

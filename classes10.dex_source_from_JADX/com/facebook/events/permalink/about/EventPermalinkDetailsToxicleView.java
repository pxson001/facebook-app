package com.facebook.events.permalink.about;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import com.facebook.common.util.StringUtil;
import com.facebook.events.common.EventDrawDividerUtil;
import com.facebook.events.graphql.EventsGraphQLModels.EventCommonTextWithEntitiesModel;
import com.facebook.events.model.Event;
import com.facebook.events.permalink.about.DetailsTextView.DetailsTextViewListener;
import com.facebook.inject.FbInjector;
import com.facebook.ufiservices.util.LinkifyUtil;
import com.facebook.widget.CustomLinearLayout;
import javax.inject.Inject;

/* compiled from: cancel_event_task */
public class EventPermalinkDetailsToxicleView extends CustomLinearLayout {
    @Inject
    public LinkifyUtil f17921a;
    private DetailsTextView f17922b;
    private EventDrawDividerUtil f17923c;

    /* compiled from: cancel_event_task */
    class C25371 implements DetailsTextViewListener {
        final /* synthetic */ EventPermalinkDetailsToxicleView f17920a;

        C25371(EventPermalinkDetailsToxicleView eventPermalinkDetailsToxicleView) {
            this.f17920a = eventPermalinkDetailsToxicleView;
        }

        public final void mo817a() {
            this.f17920a.requestLayout();
        }

        public final void mo818b() {
            this.f17920a.requestLayout();
        }
    }

    private static <T extends View> void m18328a(Class<T> cls, T t) {
        m18329a((Object) t, t.getContext());
    }

    private static void m18329a(Object obj, Context context) {
        ((EventPermalinkDetailsToxicleView) obj).f17921a = LinkifyUtil.a(FbInjector.get(context));
    }

    public EventPermalinkDetailsToxicleView(Context context) {
        super(context);
        m18326a();
    }

    public EventPermalinkDetailsToxicleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m18326a();
    }

    public EventPermalinkDetailsToxicleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m18326a();
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m18326a() {
        m18328a(EventPermalinkDetailsToxicleView.class, (View) this);
        setContentView(2130904064);
        this.f17923c = new EventDrawDividerUtil(getResources());
        this.f17922b = (DetailsTextView) a(2131561349);
        this.f17922b.m18319a();
        this.f17922b.f17907l = new C25371(this);
    }

    private void m18327a(LinkifyUtil linkifyUtil) {
        this.f17921a = linkifyUtil;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f17923c.b(canvas);
    }

    public final void m18330a(Event event) {
        EventCommonTextWithEntitiesModel eventCommonTextWithEntitiesModel = event.c;
        if (eventCommonTextWithEntitiesModel == null || StringUtil.a(eventCommonTextWithEntitiesModel.a())) {
            setVisibility(8);
            return;
        }
        this.f17922b.setText(this.f17921a.a(eventCommonTextWithEntitiesModel, true, null));
        setVisibility(0);
    }
}

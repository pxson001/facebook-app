package com.facebook.groups.widget.groupeventrow;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.widget.TextView;
import com.facebook.auth.annotations.LoggedInUserId;
import com.facebook.auth.module.String_LoggedInUserIdMethodAutoProvider;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.model.Event;
import com.facebook.graphql.calls.TimeframeInputTimeframe;
import com.facebook.inject.FbInjector;
import com.facebook.widget.CustomLinearLayout;
import com.google.common.base.Objects;
import javax.inject.Inject;

/* compiled from: THREADS_LOADING */
public class GroupEventRowView extends CustomLinearLayout {
    @Inject
    public Resources f23214a;
    @Inject
    public EventsDashboardTimeFormatUtil f23215b;
    @Inject
    @LoggedInUserId
    public String f23216c;
    public GroupEventProfilePictureView f23217d;
    public TextView f23218e;
    public TextView f23219f;
    public TextView f23220g;
    public GroupEventSocialContextView f23221h;
    public GroupEventRsvpStatusIconView f23222i;
    public GroupEventRsvpStatusButtonsView f23223j;
    public Event f23224k;
    private TimeframeInputTimeframe f23225l;
    private GroupEventRsvpViewListener f23226m;
    private boolean f23227n;
    public final Paint f23228o = new Paint(1);
    public float f23229p;
    public float f23230q;

    public static void m24566a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        GroupEventRowView groupEventRowView = (GroupEventRowView) obj;
        Resources a = ResourcesMethodAutoProvider.a(fbInjector);
        EventsDashboardTimeFormatUtil a2 = EventsDashboardTimeFormatUtil.a(fbInjector);
        String b = String_LoggedInUserIdMethodAutoProvider.b(fbInjector);
        groupEventRowView.f23214a = a;
        groupEventRowView.f23215b = a2;
        groupEventRowView.f23216c = b;
    }

    public GroupEventRowView(Context context) {
        super(context);
        Class cls = GroupEventRowView.class;
        m24566a(this, getContext());
        setContentView(2130904653);
        setOrientation(1);
        this.f23217d = (GroupEventProfilePictureView) a(2131562662);
        this.f23218e = (TextView) a(2131562663);
        this.f23219f = (TextView) a(2131562664);
        this.f23220g = (TextView) a(2131562665);
        this.f23221h = (GroupEventSocialContextView) a(2131562666);
        this.f23222i = (GroupEventRsvpStatusIconView) a(2131562667);
        this.f23223j = (GroupEventRsvpStatusButtonsView) a(2131562668);
        this.f23228o.setColor(this.f23214a.getColor(2131363505));
        this.f23228o.setStyle(Style.FILL);
        this.f23229p = this.f23214a.getDimension(2131431925);
        this.f23230q = this.f23214a.getDimension(2131431927);
        setWillNotDraw(false);
    }

    public void setGroupEventRsvpUpdateListener(GroupEventRsvpViewListener groupEventRsvpViewListener) {
        if (this.f23226m == null && groupEventRsvpViewListener != null) {
            this.f23226m = groupEventRsvpViewListener;
        }
    }

    public final void m24568a(Event event, TimeframeInputTimeframe timeframeInputTimeframe, boolean z) {
        this.f23224k = event;
        this.f23225l = timeframeInputTimeframe;
        this.f23227n = z;
        this.f23217d.m24565a(this.f23224k);
        this.f23218e.setText(this.f23224k.b);
        this.f23219f.setText(this.f23215b.a(this.f23224k.M, this.f23224k.J(), this.f23224k.L()));
        this.f23220g.setVisibility(0);
        if (!StringUtil.a(this.f23224k.P)) {
            this.f23220g.setText(this.f23224k.P);
        } else if (StringUtil.a(this.f23224k.Q)) {
            this.f23220g.setVisibility(8);
        } else {
            this.f23220g.setText(this.f23224k.Q);
        }
        if (this.f23225l == TimeframeInputTimeframe.PAST || !this.f23224k.A) {
            Object obj;
            this.f23222i.setVisibility(8);
            this.f23223j.setVisibility(8);
            Event event2 = this.f23224k;
            if (StringUtil.a(this.f23216c) || !Objects.equal(this.f23216c, event2.u)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj != null) {
                this.f23221h.setText(2131242103);
                return;
            } else {
                this.f23221h.setVisibility(8);
                return;
            }
        }
        this.f23221h.m24594a(this.f23224k);
        m24567b();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f23227n) {
            Canvas canvas2 = canvas;
            canvas2.drawRect(this.f23229p, ((float) getHeight()) - this.f23230q, ((float) getWidth()) - this.f23229p, (float) getHeight(), this.f23228o);
        }
    }

    private void m24567b() {
        if (!this.f23224k.A) {
            this.f23222i.setVisibility(8);
            this.f23222i.setVisibility(8);
        } else if (this.f23224k.G) {
            this.f23222i.setVisibility(8);
            this.f23223j.setVisibility(0);
            this.f23223j.m24581a(this.f23224k, this.f23226m);
        } else {
            this.f23222i.setVisibility(0);
            this.f23222i.m24586a(this.f23224k, this.f23226m);
            this.f23223j.setVisibility(8);
        }
    }
}

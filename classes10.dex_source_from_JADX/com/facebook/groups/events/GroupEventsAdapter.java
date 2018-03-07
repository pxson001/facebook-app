package com.facebook.groups.events;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.content.SecureContextHelper;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil;
import com.facebook.events.dateformatter.EventsDashboardTimeFormatUtil.CalendarBucket;
import com.facebook.events.dateformatter.TimeRange;
import com.facebook.events.model.Event;
import com.facebook.events.widget.eventcard.EventActionButtonStateSelectorProvider;
import com.facebook.graphql.calls.TimeframeInputTimeframe;
import com.facebook.groups.constants.GroupMsiteUrls;
import com.facebook.groups.staticadapter.StaticAdapter.AbstractSection;
import com.facebook.groups.staticadapter.StaticAdapter.Section;
import com.facebook.groups.staticadapter.StaticAdapter.StaticSection;
import com.facebook.groups.staticadapter.StaticAdapter.ViewType;
import com.facebook.groups.widget.groupeventrow.GroupEventRowView;
import com.facebook.groups.widget.groupeventrow.GroupEventRsvpViewListener;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.listview.StickyHeader.StickyHeaderAdapter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: UPLOAD_GROUP_FILE_BODY */
public class GroupEventsAdapter extends FbBaseAdapter implements StickyHeaderAdapter {
    public final FbUriIntentHandler f21798a;
    private final EventsDashboardTimeFormatUtil f21799b;
    private final Resources f21800c;
    public final SecureContextHelper f21801d;
    public final Provider<ComponentName> f21802e;
    public final TimeframeInputTimeframe f21803f;
    public final GroupEventRsvpViewListener f21804g;
    private final List<String> f21805h = new ArrayList();
    private ImmutableList<Section> f21806i = RegularImmutableList.a;
    public ImmutableList<Event> f21807j = RegularImmutableList.a;
    public boolean f21808k;

    /* compiled from: UPLOAD_GROUP_FILE_BODY */
    /* synthetic */ class C31134 {
        static final /* synthetic */ int[] f21797a = new int[CalendarBucket.values().length];

        static {
            try {
                f21797a[CalendarBucket.YESTERDAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21797a[CalendarBucket.TODAY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21797a[CalendarBucket.TOMORROW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21797a[CalendarBucket.THIS_WEEK.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f21797a[CalendarBucket.NEXT_WEEK.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f21797a[CalendarBucket.FUTURE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f21797a[CalendarBucket.PAST.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    /* compiled from: UPLOAD_GROUP_FILE_BODY */
    enum ItemTypes {
        EVENT_ROW,
        EVENT_TIME_BUCKET_HEADER,
        LOADING_BAR
    }

    @Inject
    public GroupEventsAdapter(@Assisted TimeframeInputTimeframe timeframeInputTimeframe, EventActionButtonStateSelectorProvider eventActionButtonStateSelectorProvider, @Assisted GroupEventRsvpViewListener groupEventRsvpViewListener, SecureContextHelper secureContextHelper, @FragmentChromeActivity Provider<ComponentName> provider, EventsDashboardTimeFormatUtil eventsDashboardTimeFormatUtil, Resources resources, FbUriIntentHandler fbUriIntentHandler) {
        this.f21803f = timeframeInputTimeframe;
        this.f21804g = groupEventRsvpViewListener;
        this.f21801d = secureContextHelper;
        this.f21802e = provider;
        this.f21799b = eventsDashboardTimeFormatUtil;
        this.f21800c = resources;
        this.f21798a = fbUriIntentHandler;
        m22892b();
    }

    private void m22892b() {
        this.f21806i = RegularImmutableList.a;
        Builder builder = ImmutableList.builder();
        this.f21805h.clear();
        long currentTimeMillis = System.currentTimeMillis();
        TimeRange a = TimeRange.a(currentTimeMillis);
        TimeRange b = TimeRange.b(currentTimeMillis);
        if (!this.f21807j.isEmpty()) {
            final String a2 = m22891a((Event) this.f21807j.get(0), currentTimeMillis, a, b);
            builder.c(new AbstractSection<GroupEventTimeStickyHeaderView>(this, GroupEventsAdapterRows.f21810b) {
                final /* synthetic */ GroupEventsAdapter f21791b;

                public final void mo11a(View view) {
                    ((GroupEventTimeStickyHeaderView) view).m22887a(a2);
                }
            });
            this.f21805h.add(a2);
            int size = this.f21807j.size();
            int i = 0;
            while (i < size) {
                String str;
                final Event event = (Event) this.f21807j.get(i);
                final String a3 = m22891a(event, currentTimeMillis, a, b);
                if (a3.equals(a2)) {
                    str = a2;
                } else {
                    builder.c(new AbstractSection<GroupEventTimeStickyHeaderView>(this, GroupEventsAdapterRows.f21810b) {
                        final /* synthetic */ GroupEventsAdapter f21793b;

                        public final void mo11a(View view) {
                            ((GroupEventTimeStickyHeaderView) view).m22887a(a3);
                        }
                    });
                    this.f21805h.add(a3);
                    str = a3;
                }
                builder.c(new AbstractSection<GroupEventRowView>(this, GroupEventsAdapterRows.f21809a) {
                    final /* synthetic */ GroupEventsAdapter f21796b;

                    /* compiled from: UPLOAD_GROUP_FILE_BODY */
                    class C31111 implements OnClickListener {
                        final /* synthetic */ C31123 f21794a;

                        C31111(C31123 c31123) {
                            this.f21794a = c31123;
                        }

                        public void onClick(View view) {
                            int a = Logger.a(2, EntryType.UI_INPUT_START, 1187954382);
                            GroupEventsAdapter groupEventsAdapter = this.f21794a.f21796b;
                            Context context = view.getContext();
                            String b = GroupMsiteUrls.b(event.a);
                            if (!groupEventsAdapter.f21798a.a(context, b)) {
                                groupEventsAdapter.f21801d.a(new Intent("android.intent.action.VIEW").setComponent((ComponentName) groupEventsAdapter.f21802e.get()).setData(Uri.parse(b)), context);
                            }
                            Logger.a(2, EntryType.UI_INPUT_END, 110034309, a);
                        }
                    }

                    public final void mo11a(View view) {
                        GroupEventRowView groupEventRowView = (GroupEventRowView) view;
                        groupEventRowView.setGroupEventRsvpUpdateListener(this.f21796b.f21804g);
                        groupEventRowView.m24568a(event, this.f21796b.f21803f, true);
                        groupEventRowView.setOnClickListener(new C31111(this));
                    }
                });
                this.f21805h.add(a3);
                i++;
                a2 = str;
            }
        }
        if (this.f21808k) {
            builder.c(new StaticSection(GroupEventsAdapterRows.f21811c));
        }
        this.f21806i = builder.b();
    }

    public final View m22893a(int i, ViewGroup viewGroup) {
        return ((ViewType) GroupEventsAdapterRows.f21812d.get(i)).mo12a(viewGroup);
    }

    public final void m22894a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ((Section) obj).mo11a(view);
    }

    public int getItemViewType(int i) {
        return GroupEventsAdapterRows.f21812d.indexOf(((Section) this.f21806i.get(i)).mo10a());
    }

    public int getViewTypeCount() {
        return GroupEventsAdapterRows.f21812d.size();
    }

    public int getCount() {
        return this.f21806i.size();
    }

    public Object getItem(int i) {
        return this.f21806i.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public void notifyDataSetChanged() {
        m22892b();
        super.notifyDataSetChanged();
    }

    private String m22891a(Event event, long j, TimeRange timeRange, TimeRange timeRange2) {
        Date J = event.J();
        long time = J.getTime();
        switch (C31134.f21797a[this.f21799b.a(time, j).ordinal()]) {
            case 1:
                return this.f21799b.o;
            case 2:
                return this.f21799b.p;
            case 3:
                return this.f21799b.q;
            case 4:
                return this.f21799b.e(J);
            case 5:
                return this.f21800c.getString(2131242098);
            case 6:
                if (timeRange.c(time)) {
                    return this.f21799b.h(J);
                }
                break;
        }
        if (timeRange2.c(time)) {
            return this.f21799b.f(J);
        }
        return this.f21799b.g(J);
    }

    public final View m22895b(int i, View view, ViewGroup viewGroup) {
        GroupEventTimeStickyHeaderView groupEventTimeStickyHeaderView;
        if (view == null) {
            groupEventTimeStickyHeaderView = new GroupEventTimeStickyHeaderView(viewGroup.getContext());
        } else {
            groupEventTimeStickyHeaderView = view;
        }
        groupEventTimeStickyHeaderView = groupEventTimeStickyHeaderView;
        if (!this.f21807j.isEmpty() && i < this.f21805h.size()) {
            groupEventTimeStickyHeaderView.m22887a((String) this.f21805h.get(i));
        }
        return groupEventTimeStickyHeaderView;
    }

    public final int o_(int i) {
        if (i == 0) {
            return ItemTypes.EVENT_TIME_BUCKET_HEADER.ordinal();
        }
        return 0;
    }

    public final int m22897e(int i) {
        return this.f21800c.getDimensionPixelOffset(2131434270) + this.f21800c.getDimensionPixelOffset(2131431927);
    }

    public final int m22896d() {
        return 0;
    }

    public final boolean m22898f(int i) {
        return false;
    }
}

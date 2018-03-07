package com.facebook.timeline.contextual;

import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.inject.Assisted;
import com.facebook.ipc.profile.TimelineContext;
import com.facebook.timeline.contextual.TimelineContextListItemPresenter.TimelineContextItemData;
import com.facebook.timeline.header.ui.LoadMoreItemsView;
import com.facebook.timeline.protocol.FetchTimelineHeaderGraphQLModels.TimelineContextListItemFieldsModel;
import com.facebook.timeline.ui.TimelineComponentViewType;
import com.facebook.tools.dextr.runtime.detour.TracerDetour;
import com.facebook.uicontrib.contextitem.PlutoniumContextualItemView;
import com.facebook.widget.listview.FbBaseAdapter;
import com.facebook.widget.text.BetterTextView;
import com.facebook.widget.text.BetterTextViewBorderDrawHook;
import com.facebook.widget.text.BetterTextViewBorderDrawHook.Side;
import com.facebook.widget.viewdiagnostics.SupportsViewDiagnostics;
import com.facebook.widget.viewdiagnostics.ViewDiagnostics;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: group_thread_contained */
public class TimelineContextualInfoAdapter extends FbBaseAdapter {
    private static final Object f10317a = new Object();
    private final AbstractFbErrorReporter f10318b;
    private final Provider<TimelineContextListItemPresenter> f10319c;
    private final Provider<TimelineAboutProtilePresenter> f10320d;
    private final TimelineIntroCardContextListItemPresenterProvider f10321e;
    private final Provider<TimelineIntroCardAboutItemsPresenter> f10322f;
    private final ContextItemsRenderingStyle f10323g;
    private final TimelineContext f10324h;
    private final TimelineContextualInfoData f10325i;
    private final OnClickListener f10326j;
    @Nullable
    private final String f10327k;

    /* compiled from: group_thread_contained */
    public enum ViewTypes {
        CONTEXTUAL_ITEM_TOP,
        CONTEXTUAL_ITEM_MIDDLE,
        CONTEXTUAL_ITEM_BOTTOM,
        INTRO_CARD_CONTEXTUAL_VIEW,
        LOAD_MORE_INDICATOR,
        UNKNOWN
    }

    @Inject
    public TimelineContextualInfoAdapter(@Assisted TimelineContext timelineContext, @Assisted TimelineContextualInfoData timelineContextualInfoData, @Assisted ContextItemsRenderingStyle contextItemsRenderingStyle, @Assisted OnClickListener onClickListener, @Nullable @Assisted String str, FbErrorReporter fbErrorReporter, Provider<TimelineContextListItemPresenter> provider, Provider<TimelineAboutProtilePresenter> provider2, TimelineIntroCardContextListItemPresenterProvider timelineIntroCardContextListItemPresenterProvider, Provider<TimelineIntroCardAboutItemsPresenter> provider3) {
        this.f10324h = (TimelineContext) Preconditions.checkNotNull(timelineContext);
        this.f10325i = (TimelineContextualInfoData) Preconditions.checkNotNull(timelineContextualInfoData);
        this.f10326j = onClickListener;
        this.f10327k = str;
        this.f10318b = fbErrorReporter;
        this.f10319c = provider;
        this.f10320d = provider2;
        this.f10321e = timelineIntroCardContextListItemPresenterProvider;
        this.f10322f = provider3;
        this.f10323g = contextItemsRenderingStyle;
    }

    public final View m10454a(int i, ViewGroup viewGroup) {
        switch (ViewTypes.values()[i]) {
            case CONTEXTUAL_ITEM_TOP:
            case CONTEXTUAL_ITEM_MIDDLE:
            case CONTEXTUAL_ITEM_BOTTOM:
                return new PlutoniumContextualItemView(viewGroup.getContext());
            case INTRO_CARD_CONTEXTUAL_VIEW:
                BetterTextView betterTextView = (BetterTextView) LayoutInflater.from(viewGroup.getContext()).inflate(2130907438, viewGroup, false);
                betterTextView.a(new BetterTextViewBorderDrawHook(betterTextView, 0, betterTextView.getResources().getColor(2131362991), Side.BOTTOM));
                return betterTextView;
            case LOAD_MORE_INDICATOR:
                return new LoadMoreItemsView(viewGroup.getContext(), this.f10327k);
            default:
                throw new IllegalArgumentException("Unknown item type for TimelineContextualInfoAdapter of type " + i);
        }
    }

    public final void m10455a(int i, Object obj, View view, int i2, ViewGroup viewGroup) {
        ViewDiagnostics viewDiagnostics;
        Object obj2;
        Throwable th;
        long j;
        Object obj3 = null;
        if (viewGroup instanceof SupportsViewDiagnostics) {
            ViewDiagnostics viewDiagnostics2 = ((SupportsViewDiagnostics) viewGroup).getViewDiagnostics();
            if (viewDiagnostics2 != null && (viewDiagnostics2.c() || viewDiagnostics2.b())) {
                obj3 = 1;
                TracerDetour.a("renderTimelineContextItemView", -1854235179);
            }
            viewDiagnostics = viewDiagnostics2;
            obj2 = obj3;
        } else {
            viewDiagnostics = null;
            obj2 = null;
        }
        boolean a;
        try {
            if (obj instanceof TimelineContextListItemFieldsModel) {
                TimelineContextListItemFieldsModel timelineContextListItemFieldsModel = (TimelineContextListItemFieldsModel) obj;
                switch (this.f10323g) {
                    case PROTILE_STYLE:
                        a = ((TimelineAboutProtilePresenter) this.f10320d.get()).mo502a((PlutoniumContextualItemView) view, new TimelineContextItemData(timelineContextListItemFieldsModel, m10453a(i2)));
                        break;
                    case CLASSIC_STYLE:
                        a = ((TimelineContextListItemPresenter) this.f10319c.get()).mo502a((PlutoniumContextualItemView) view, new TimelineContextItemData(timelineContextListItemFieldsModel, m10453a(i2)));
                        break;
                    case INTRO_CARD_CONTEXT_ITEMS_STYLE:
                        this.f10321e.m10477a(timelineContextListItemFieldsModel, Boolean.valueOf(this.f10324h.i())).a((BetterTextView) view);
                        a = true;
                        break;
                    case INTRO_CARD_PUBLIC_ABOUT_ITEMS_STYLE:
                        a = ((TimelineIntroCardAboutItemsPresenter) this.f10322f.get()).mo502a((PlutoniumContextualItemView) view, new TimelineContextItemData(timelineContextListItemFieldsModel, m10453a(i2)));
                        break;
                    default:
                        this.f10318b.b("TimelineContextualInfoAdapter.unknownRenderingStyle", "Unsupported rendering style: " + this.f10323g.name());
                        break;
                }
            }
            a = false;
            try {
                boolean a2;
                if (obj == f10317a && (view instanceof LoadMoreItemsView)) {
                    a2 = ((LoadMoreItemsView) view).m12025a(this.f10325i.f() == 1, this.f10326j);
                } else {
                    a2 = a;
                }
                long j2 = 0;
                if (obj2 != null) {
                    j2 = TracerDetour.b(684405236);
                }
                if (obj2 != null && r4) {
                    viewDiagnostics.c(j2);
                    viewDiagnostics.a(view);
                } else if (viewDiagnostics != null) {
                    viewDiagnostics.b(false);
                }
            } catch (Throwable th2) {
                th = th2;
                j = 0;
                if (obj2 != null) {
                    j = TracerDetour.b(-369999787);
                }
                if (obj2 == null && r3) {
                    viewDiagnostics.c(j);
                    viewDiagnostics.a(view);
                } else if (viewDiagnostics != null) {
                    viewDiagnostics.b(false);
                }
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            a = false;
            j = 0;
            if (obj2 != null) {
                j = TracerDetour.b(-369999787);
            }
            if (obj2 == null) {
            }
            if (viewDiagnostics != null) {
                viewDiagnostics.b(false);
            }
            throw th;
        }
    }

    public int getCount() {
        if (!this.f10325i.d()) {
            return 0;
        }
        if (this.f10325i.d != 2) {
            return (Math.min(this.f10325i.f10338f, ((TimelineContextItemsData) this.f10325i.a().get()).f10311a.size()) + 0) + 1;
        }
        return ((TimelineContextItemsData) this.f10325i.a().get()).f10311a.size() + 0;
    }

    public Object getItem(int i) {
        boolean z = true;
        Preconditions.checkArgument(i >= 0);
        if (i >= getCount()) {
            z = false;
        }
        Preconditions.checkArgument(z);
        if (this.f10325i.d == 2 || i < Math.min(this.f10325i.f10338f, ((TimelineContextItemsData) this.f10325i.a().get()).f10311a.size())) {
            return ((TimelineContextItemsData) this.f10325i.a().get()).f10311a.get(i);
        }
        return f10317a;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public int getViewTypeCount() {
        return ViewTypes.values().length;
    }

    public int getItemViewType(int i) {
        Object item = getItem(i);
        ViewTypes viewTypes = ViewTypes.UNKNOWN;
        if (item instanceof TimelineContextListItemFieldsModel) {
            int count = getCount();
            if (this.f10323g == ContextItemsRenderingStyle.INTRO_CARD_CONTEXT_ITEMS_STYLE) {
                viewTypes = ViewTypes.INTRO_CARD_CONTEXTUAL_VIEW;
            } else if (i == count - 1 || (i == count - 2 && getItem(i + 1) == f10317a)) {
                viewTypes = ViewTypes.CONTEXTUAL_ITEM_BOTTOM;
            } else if (i == 0) {
                viewTypes = ViewTypes.CONTEXTUAL_ITEM_TOP;
            } else {
                viewTypes = ViewTypes.CONTEXTUAL_ITEM_MIDDLE;
            }
        }
        if (item == f10317a) {
            viewTypes = ViewTypes.LOAD_MORE_INDICATOR;
        }
        if (viewTypes == ViewTypes.UNKNOWN) {
            this.f10318b.a("TimelineContextualInfoAdapter.unknown_viewtype", "Unknown view type for postition: " + i + " and item: " + (item == null ? null : item.getClass().getCanonicalName()));
        }
        return viewTypes.ordinal();
    }

    private static TimelineComponentViewType m10453a(int i) {
        switch (ViewTypes.values()[i]) {
            case CONTEXTUAL_ITEM_TOP:
                return TimelineComponentViewType.BEGIN;
            case CONTEXTUAL_ITEM_MIDDLE:
                return TimelineComponentViewType.MIDDLE;
            case CONTEXTUAL_ITEM_BOTTOM:
                return TimelineComponentViewType.END;
            case LOAD_MORE_INDICATOR:
                return TimelineComponentViewType.LOAD_MORE_INDICATOR;
            default:
                return TimelineComponentViewType.WHOLE;
        }
    }
}

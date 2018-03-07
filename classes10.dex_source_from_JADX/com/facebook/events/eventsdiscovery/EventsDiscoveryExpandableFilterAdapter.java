package com.facebook.events.eventsdiscovery;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.util.StringUtil;
import com.facebook.events.eventsdiscovery.EventsDiscoveryFilterFragment.C24231;
import com.facebook.events.eventsdiscovery.EventsDiscoveryFilterFragment.OnChooseLocationClickedListener;
import com.facebook.events.eventsdiscovery.protocol.EventsDiscoveryGraphQLModels.FetchEventDiscoveryCategoryListModel.EventCategoryListModel;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.model.LocationStatusUtil.LocationStatus;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataModel;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel.EdgesModel.NodeModel;
import com.facebook.nearby.v2.typeahead.model.NearbyPlacesLocationResult;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/* compiled from: com.facebook.nobreak.DefaultCatchMeIfYouCan.uncaughtException */
public class EventsDiscoveryExpandableFilterAdapter extends BaseExpandableListAdapter {
    private List<EventsDiscoveryFilterGroup> f17247a;
    private List<EventCategoryListModel> f17248b;
    public HashSet<String> f17249c;
    private NearbyPlacesLocationResult f17250d;
    @Nullable
    public NearbyPlacesSearchDataModel f17251e;
    public Context f17252f;
    public C24231 f17253g;
    public HashMap<Integer, Integer> f17254h;
    private int f17255i = this.f17252f.getResources().getDimensionPixelSize(2131434213);
    private int f17256j = this.f17252f.getResources().getDimensionPixelSize(2131434214);
    private int f17257k = this.f17252f.getResources().getDimensionPixelSize(2131434215);

    /* compiled from: com.facebook.nobreak.DefaultCatchMeIfYouCan.uncaughtException */
    public enum CheckBoxTypes {
        MULTIPLE_SELECTION,
        SINGLE_SELECTION,
        NO_SELECTION
    }

    /* compiled from: com.facebook.nobreak.DefaultCatchMeIfYouCan.uncaughtException */
    public class EventsDiscoveryFilterChild {
        public String f17236a;
        public String f17237b;
        public boolean f17238c;
        CheckBoxTypes f17239d;

        public EventsDiscoveryFilterChild(String str, String str2, boolean z, CheckBoxTypes checkBoxTypes) {
            this.f17236a = str;
            this.f17237b = str2;
            this.f17238c = z;
            this.f17239d = checkBoxTypes;
        }
    }

    /* compiled from: com.facebook.nobreak.DefaultCatchMeIfYouCan.uncaughtException */
    public class EventsDiscoveryFilterGroup {
        int f17240a;
        public List<EventsDiscoveryFilterChild> f17241b;
        public int f17242c;
        public String f17243d;
        @Nullable
        public String f17244e;
        public boolean f17245f;
        public final /* synthetic */ EventsDiscoveryExpandableFilterAdapter f17246g;

        public EventsDiscoveryFilterGroup(EventsDiscoveryExpandableFilterAdapter eventsDiscoveryExpandableFilterAdapter, int i, List<EventsDiscoveryFilterChild> list, int i2, int i3, @Nullable String str, boolean z) {
            this.f17246g = eventsDiscoveryExpandableFilterAdapter;
            this.f17240a = i;
            this.f17241b = list;
            this.f17242c = i2;
            this.f17245f = z;
            this.f17243d = eventsDiscoveryExpandableFilterAdapter.f17252f.getResources().getString(i3);
            this.f17244e = str;
        }
    }

    public /* synthetic */ Object getChild(int i, int i2) {
        return m17545a(i, i2);
    }

    public /* synthetic */ Object getGroup(int i) {
        return m17549b(i);
    }

    public EventsDiscoveryExpandableFilterAdapter(Context context, List<EventCategoryListModel> list, HashSet<String> hashSet, NearbyPlacesLocationResult nearbyPlacesLocationResult, @Nullable NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel, OnChooseLocationClickedListener onChooseLocationClickedListener) {
        this.f17252f = context;
        this.f17248b = list;
        this.f17249c = hashSet;
        this.f17250d = nearbyPlacesLocationResult;
        this.f17251e = nearbyPlacesSearchDataModel;
        this.f17253g = onChooseLocationClickedListener;
        m17550c();
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m17550c() {
        String str;
        boolean z;
        this.f17247a = new ArrayList(2);
        this.f17254h = new HashMap(2);
        this.f17247a.add(new EventsDiscoveryFilterGroup(this, 2131558814, m17548a(this.f17248b, this.f17249c), 2130840114, 2131241897, m17546a(this.f17252f, this.f17249c), !this.f17249c.isEmpty()));
        this.f17254h.put(Integer.valueOf(2131558814), Integer.valueOf(this.f17247a.size() - 1));
        List a = m17547a(this.f17250d, this.f17251e);
        if (this.f17251e != null) {
            str = this.f17251e.e;
        } else {
            str = null;
        }
        if (this.f17251e != null) {
            z = true;
        } else {
            z = false;
        }
        this.f17247a.add(new EventsDiscoveryFilterGroup(this, 2131558815, a, 2130840024, 2131241898, str, z));
        this.f17254h.put(Integer.valueOf(2131558815), Integer.valueOf(this.f17247a.size() - 1));
    }

    public int getGroupCount() {
        return this.f17247a.size();
    }

    public int getChildrenCount(int i) {
        return m17549b(i).f17241b.size();
    }

    private EventsDiscoveryFilterGroup m17549b(int i) {
        return (EventsDiscoveryFilterGroup) this.f17247a.get(i);
    }

    private EventsDiscoveryFilterChild m17545a(int i, int i2) {
        return (EventsDiscoveryFilterChild) m17549b(i).f17241b.get(i2);
    }

    public long getGroupId(int i) {
        return (long) m17549b(i).f17240a;
    }

    public long getChildId(int i, int i2) {
        return Long.parseLong(m17545a(i, i2).f17236a);
    }

    public boolean hasStableIds() {
        return true;
    }

    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        View eventsDiscoveryFilterGroupView;
        EventsDiscoveryFilterGroup b = m17549b(i);
        if (view == null) {
            eventsDiscoveryFilterGroupView = new EventsDiscoveryFilterGroupView(this.f17252f);
        } else {
            eventsDiscoveryFilterGroupView = view;
        }
        EventsDiscoveryFilterGroupView eventsDiscoveryFilterGroupView2 = (EventsDiscoveryFilterGroupView) eventsDiscoveryFilterGroupView;
        eventsDiscoveryFilterGroupView2.f17262h.setImageResource(b.f17242c);
        eventsDiscoveryFilterGroupView2.f17262h.setGlyphColor(b.f17245f ? -12425294 : -4275511);
        eventsDiscoveryFilterGroupView2.f17263i.setText(b.f17243d);
        if (StringUtil.a(b.f17244e)) {
            eventsDiscoveryFilterGroupView2.f17264j.setVisibility(8);
        } else {
            eventsDiscoveryFilterGroupView2.f17264j.setVisibility(0);
            eventsDiscoveryFilterGroupView2.f17264j.setText(b.f17244e);
        }
        return eventsDiscoveryFilterGroupView;
    }

    public View getChildView(final int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        CheckedContentView checkedContentView;
        final EventsDiscoveryFilterChild a = m17545a(i, i2);
        if (view == null) {
            checkedContentView = new CheckedContentView(this.f17252f);
        } else {
            checkedContentView = view;
        }
        checkedContentView = checkedContentView;
        checkedContentView.setCheckMarkDrawable(m17544a(a.f17239d));
        checkedContentView.setTitleText(a.f17237b);
        checkedContentView.setChecked(a.f17238c);
        checkedContentView.setBackgroundColor(this.f17252f.getResources().getColor(2131361920));
        checkedContentView.setPadding(this.f17255i, this.f17257k, this.f17256j, this.f17257k);
        checkedContentView.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ EventsDiscoveryExpandableFilterAdapter f17234c;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 136053277);
                if (a.f17239d != CheckBoxTypes.NO_SELECTION) {
                    this.f17234c.m17551a(i, a);
                } else {
                    C24231 c24231 = this.f17234c.f17253g;
                    Intent component = new Intent().setComponent((ComponentName) c24231.f17258a.am.get());
                    component.putExtra("target_fragment", ContentFragmentType.EVENTS_DISCOVERY_LOCATION_PICKER_FRAGMENT.ordinal());
                    component.putExtra("extra_location_range", c24231.f17258a.au);
                    c24231.f17258a.an.a(component, 101, c24231.f17258a);
                }
                LogUtils.a(1079105982, a);
            }
        });
        return checkedContentView;
    }

    public boolean isChildSelectable(int i, int i2) {
        return false;
    }

    private static List<EventsDiscoveryFilterChild> m17548a(List<EventCategoryListModel> list, HashSet<String> hashSet) {
        List arrayList = new ArrayList(list.size());
        for (EventCategoryListModel eventCategoryListModel : list) {
            if (!(eventCategoryListModel == null || eventCategoryListModel.m17628a() == null)) {
                boolean z;
                if (hashSet == null) {
                    z = false;
                } else {
                    z = hashSet.contains(eventCategoryListModel.m17628a());
                }
                arrayList.add(new EventsDiscoveryFilterChild(eventCategoryListModel.m17628a(), eventCategoryListModel.m17629j(), z, CheckBoxTypes.MULTIPLE_SELECTION));
            }
        }
        return arrayList;
    }

    private List<EventsDiscoveryFilterChild> m17547a(NearbyPlacesLocationResult nearbyPlacesLocationResult, NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel) {
        List list = nearbyPlacesLocationResult.f5211b;
        List arrayList = new ArrayList(list.size());
        for (int i = 0; i < Math.min(3, list.size()); i++) {
            NodeModel nodeModel = (NodeModel) list.get(i);
            if (!(nodeModel == null || nodeModel.j() == null)) {
                boolean z;
                if (nearbyPlacesSearchDataModel == null || nearbyPlacesSearchDataModel.d == null) {
                    z = false;
                } else {
                    z = nearbyPlacesSearchDataModel.d.equals(nodeModel.j());
                }
                arrayList.add(new EventsDiscoveryFilterChild(nodeModel.j(), nodeModel.l(), z, CheckBoxTypes.SINGLE_SELECTION));
            }
        }
        arrayList.add(new EventsDiscoveryFilterChild(Integer.toString(2131558816), this.f17252f.getResources().getString(2131241899), false, CheckBoxTypes.NO_SELECTION));
        return arrayList;
    }

    public final void m17551a(int i, @Nullable EventsDiscoveryFilterChild eventsDiscoveryFilterChild) {
        EventsDiscoveryFilterGroup b = m17549b(i);
        boolean z;
        if (b.f17240a == 2131558814) {
            if (eventsDiscoveryFilterChild == null) {
                this.f17249c.clear();
            } else if (this.f17249c.contains(eventsDiscoveryFilterChild.f17236a)) {
                this.f17249c.remove(eventsDiscoveryFilterChild.f17236a);
            } else {
                this.f17249c.add(eventsDiscoveryFilterChild.f17236a);
            }
            HashSet hashSet = this.f17249c;
            if (hashSet == null || hashSet.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            b.f17245f = z;
            b.f17244e = m17546a(b.f17246g.f17252f, hashSet);
            for (EventsDiscoveryFilterChild eventsDiscoveryFilterChild2 : b.f17241b) {
                eventsDiscoveryFilterChild2.f17238c = hashSet == null ? false : hashSet.contains(eventsDiscoveryFilterChild2.f17236a);
            }
        } else if (b.f17240a == 2131558815) {
            NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel;
            if (eventsDiscoveryFilterChild == null) {
                nearbyPlacesSearchDataModel = null;
            } else {
                nearbyPlacesSearchDataModel = new NearbyPlacesSearchDataModel(LocationStatus.OKAY);
            }
            this.f17251e = nearbyPlacesSearchDataModel;
            if (this.f17251e != null) {
                this.f17251e.b = false;
                this.f17251e.d = eventsDiscoveryFilterChild.f17236a;
                this.f17251e.e = eventsDiscoveryFilterChild.f17237b;
            }
            if (eventsDiscoveryFilterChild != null) {
                z = true;
            } else {
                z = false;
            }
            b.f17245f = z;
            b.f17244e = eventsDiscoveryFilterChild == null ? "" : eventsDiscoveryFilterChild.f17237b;
            for (EventsDiscoveryFilterChild eventsDiscoveryFilterChild22 : b.f17241b) {
                eventsDiscoveryFilterChild22.f17238c = eventsDiscoveryFilterChild == null ? false : eventsDiscoveryFilterChild22.f17236a.equals(eventsDiscoveryFilterChild.f17236a);
            }
        }
        notifyDataSetChanged();
    }

    @Nullable
    public static String m17546a(Context context, HashSet<String> hashSet) {
        if (hashSet == null || hashSet.isEmpty()) {
            return null;
        }
        return context.getResources().getQuantityString(2131689806, hashSet.size(), new Object[]{Integer.valueOf(hashSet.size())});
    }

    @Nullable
    private Drawable m17544a(CheckBoxTypes checkBoxTypes) {
        switch (checkBoxTypes) {
            case MULTIPLE_SELECTION:
                return this.f17252f.getResources().getDrawable(2130839773);
            case SINGLE_SELECTION:
                return this.f17252f.getResources().getDrawable(2130840069);
            case NO_SELECTION:
                return null;
            default:
                throw new UnsupportedOperationException("checkbox type is not supported");
        }
    }
}

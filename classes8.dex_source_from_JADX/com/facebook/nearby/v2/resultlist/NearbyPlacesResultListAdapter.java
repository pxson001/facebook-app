package com.facebook.nearby.v2.resultlist;

import android.graphics.drawable.ColorDrawable;
import android.location.Location;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.resultlist.NearbyPlacesV2ResultListFragment.C16923;
import com.facebook.nearby.v2.resultlist.NearbyPlacesV2ResultListFragment.C16934;
import com.facebook.nearby.v2.resultlist.NearbyPlacesV2ResultsFragment.Options;
import com.facebook.nearby.v2.resultlist.NearbyPlacesV2ResultsFragment.Options.Builder;
import com.facebook.nearby.v2.resultlist.logging.NearbyPlacesResultListLogger.TapAction;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListModel;
import com.facebook.nearby.v2.resultlist.model.NearbyPlacesResultListSearchType;
import com.facebook.nearby.v2.resultlist.views.NearbyPlacesResultListPaginationLoadingView;
import com.facebook.nearby.v2.resultlist.views.SetSearchPlaceView;
import com.facebook.nearby.v2.resultlist.views.SetSearchPlaceView.Accessory;
import com.facebook.nearby.v2.resultlist.views.SetSearchPlaceView.SimplePlaceViewListener;
import com.facebook.nearby.v2.resultlist.views.SetSearchPlaceViewBinder;
import com.facebook.nearby.v2.resultlist.views.itemview.NearbyPlacesResultListItemView;
import com.facebook.nearby.v2.resultlist.views.itemview.NearbyPlacesResultListItemView.OnResultListItemViewClickedListener;
import com.facebook.nearby.v2.resultlist.views.itemview.actionbar.NearbyPlacesActionBarView.ActionBarItemType;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.CustomViewUtils;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.ArrayList;
import javax.inject.Inject;

/* compiled from: delete_dialog_confirmation_button_tap */
public class NearbyPlacesResultListAdapter extends BaseAdapter {
    private final Options f15798a;
    private Lazy<SetSearchPlaceViewBinder> f15799b;
    private NearbyPlacesResultListModel f15800c;
    public C16923 f15801d;
    private final OnClickListener f15802e = new C16841(this);
    private final SimplePlaceViewListener f15803f = new C16852(this);

    /* compiled from: delete_dialog_confirmation_button_tap */
    class C16841 implements OnClickListener {
        final /* synthetic */ NearbyPlacesResultListAdapter f15793a;

        C16841(NearbyPlacesResultListAdapter nearbyPlacesResultListAdapter) {
            this.f15793a = nearbyPlacesResultListAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1033400334);
            int intValue = ((Integer) view.getTag()).intValue();
            if (this.f15793a.f15801d != null) {
                this.f15793a.f15801d.m18666a(intValue);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -695156532, a);
        }
    }

    /* compiled from: delete_dialog_confirmation_button_tap */
    class C16852 extends SimplePlaceViewListener {
        final /* synthetic */ NearbyPlacesResultListAdapter f15794a;

        C16852(NearbyPlacesResultListAdapter nearbyPlacesResultListAdapter) {
            this.f15794a = nearbyPlacesResultListAdapter;
        }

        public final void mo954a(SetSearchPlaceView setSearchPlaceView, int i) {
            int intValue = ((Integer) setSearchPlaceView.getTag()).intValue();
            if (this.f15794a.f15801d != null) {
                this.f15794a.f15801d.m18667a(intValue, i);
            }
        }
    }

    /* compiled from: delete_dialog_confirmation_button_tap */
    enum ItemViewType {
        HUGE_CELL,
        SET_SEARCH_CELL,
        PAGINATION_LOADING_CELL,
        COUNT
    }

    @Inject
    public NearbyPlacesResultListAdapter(@Assisted Options options, Lazy<SetSearchPlaceViewBinder> lazy) {
        if (options == null) {
            this.f15798a = new Builder().m18687a();
        } else {
            this.f15798a = options;
        }
        this.f15799b = lazy;
    }

    public final void m18638a(NearbyPlacesResultListModel nearbyPlacesResultListModel) {
        Preconditions.checkNotNull(nearbyPlacesResultListModel);
        this.f15800c = nearbyPlacesResultListModel;
        AdapterDetour.a(this, 1760227711);
    }

    public int getCount() {
        if (!this.f15800c.m18712c()) {
            return 0;
        }
        int size = m18637a().size();
        return m18639b() ? size + 1 : size;
    }

    public Object getItem(int i) {
        ArrayList a = m18637a();
        boolean b = m18639b();
        if (a == null || i < 0 || (i >= a.size() && !b)) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (i == a.size() && b) {
            return null;
        } else {
            return a.get(i);
        }
    }

    public int getItemViewType(int i) {
        if (i < 0 || !this.f15800c.m18712c()) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (i < m18637a().size()) {
            return this.f15798a.f15836a ? ItemViewType.SET_SEARCH_CELL.ordinal() : ItemViewType.HUGE_CELL.ordinal();
        } else {
            if (m18639b()) {
                return ItemViewType.PAGINATION_LOADING_CELL.ordinal();
            }
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public long getItemId(int i) {
        ArrayList a = m18637a();
        if (a == null || i < 0 || (i >= a.size() && !m18639b())) {
            throw new ArrayIndexOutOfBoundsException();
        } else if (i == a.size()) {
            return -1;
        } else {
            String b = ((NearbyPlacesPlaceModel) a.get(i)).m17738b();
            return Strings.isNullOrEmpty(b) ? 0 : Long.parseLong(b);
        }
    }

    public int getViewTypeCount() {
        return ItemViewType.COUNT.ordinal();
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        switch (ItemViewType.values()[getItemViewType(i)]) {
            case PAGINATION_LOADING_CELL:
                return m18635a(view, viewGroup);
            case HUGE_CELL:
                return m18634a(i, view, viewGroup);
            case SET_SEARCH_CELL:
                return m18636b(i, view, viewGroup);
            default:
                throw new IllegalArgumentException();
        }
    }

    public final ArrayList<NearbyPlacesPlaceModel> m18637a() {
        if (this.f15800c.m18712c()) {
            return this.f15800c.f15863c.m18703i();
        }
        return null;
    }

    public final boolean m18639b() {
        if (this.f15800c.m18712c()) {
            return this.f15800c.f15863c.f15858m;
        }
        return false;
    }

    private View m18634a(final int i, View view, ViewGroup viewGroup) {
        boolean z;
        if (view == null) {
            view = new NearbyPlacesResultListItemView(viewGroup.getContext());
        } else {
            Preconditions.checkArgument(view instanceof NearbyPlacesResultListItemView);
            NearbyPlacesResultListItemView nearbyPlacesResultListItemView = (NearbyPlacesResultListItemView) view;
        }
        NearbyPlacesPlaceModel nearbyPlacesPlaceModel = (NearbyPlacesPlaceModel) getItem(i);
        Location location = null;
        if (!(this.f15800c.f15863c == null || this.f15800c.f15863c.f15846a == null)) {
            location = this.f15800c.f15863c.f15846a;
        }
        if (this.f15800c.f15863c.f15851f == NearbyPlacesResultListSearchType.USER_CENTERED) {
            z = true;
        } else {
            z = false;
        }
        view.m18798a(nearbyPlacesPlaceModel, location, z);
        view.f15994i = new OnResultListItemViewClickedListener(this) {
            final /* synthetic */ NearbyPlacesResultListAdapter f15796b;

            public final void mo957a(ActionBarItemType actionBarItemType) {
                if (this.f15796b.f15801d != null) {
                    C16923 c16923 = this.f15796b.f15801d;
                    int i = i;
                    Preconditions.checkArgument(i >= 0);
                    NearbyPlacesPlaceModel g = NearbyPlacesV2ResultListFragment.m18676g(c16923.f15817a, i);
                    if (g != null) {
                        TapAction tapAction;
                        switch (C16934.f15818a[actionBarItemType.ordinal()]) {
                            case 1:
                                c16923.f15817a.f15823b.m18733b(g, c16923.f15817a.getContext(), NearbyPlacesV2ResultListFragment.f15821e);
                                tapAction = TapAction.DISTANCE;
                                break;
                            case 2:
                                NearbyPlacesV2ResultListFragment.m18672a(c16923.f15817a, g);
                                tapAction = TapAction.LIKES;
                                break;
                            case 3:
                                c16923.f15817a.f15823b.m18729a(g, c16923.f15817a.getContext(), NearbyPlacesV2ResultListFragment.f15821e);
                                tapAction = TapAction.REVIEW_RATING;
                                break;
                            case 4:
                                c16923.f15817a.f15823b.m18731a(g.m17738b(), c16923.f15817a.getContext(), NearbyPlacesV2ResultListFragment.f15821e);
                                tapAction = TapAction.OPEN_NOW;
                                break;
                            case 5:
                                c16923.f15817a.f15823b.m18731a(g.m17738b(), c16923.f15817a.getContext(), NearbyPlacesV2ResultListFragment.f15821e);
                                tapAction = TapAction.PRICE_RATING;
                                break;
                            default:
                                c16923.f15817a.f15823b.m18728a(c16923.f15817a.getContext(), g, null, c16923.f15817a.f15829i, c16923.f15817a, NearbyPlacesV2ResultListFragment.f15821e);
                                tapAction = TapAction.CELL;
                                break;
                        }
                        c16923.f15817a.m18670a(i, g, tapAction, null, null);
                    }
                }
            }

            public final void mo955a() {
                if (this.f15796b.f15801d != null) {
                    this.f15796b.f15801d.m18666a(i);
                }
            }

            public final void mo956a(int i) {
                if (this.f15796b.f15801d != null) {
                    this.f15796b.f15801d.m18667a(i, i);
                }
            }

            public final void mo958b() {
                if (this.f15796b.f15801d != null) {
                    C16923 c16923 = this.f15796b.f15801d;
                    NearbyPlacesPlaceModel g = NearbyPlacesV2ResultListFragment.m18676g(c16923.f15817a, i);
                    if (g != null) {
                        NearbyPlacesV2ResultListFragment.m18672a(c16923.f15817a, g);
                    }
                }
            }
        };
        if (this.f15801d != null) {
            this.f15801d.m18668a(nearbyPlacesPlaceModel);
        }
        return view;
    }

    private View m18636b(int i, View view, ViewGroup viewGroup) {
        if (view == null || !(view instanceof SetSearchPlaceView)) {
            Accessory accessory;
            SetSearchPlaceView c = new SetSearchPlaceView(viewGroup.getContext()).m18773a(this.f15798a.f15838c).m18777b(true).m18778c(true);
            if (this.f15798a.f15839d) {
                accessory = Accessory.BOOKMARK;
            } else {
                accessory = Accessory.NONE;
            }
            view = c.m18772a(accessory).m18780e(this.f15798a.f15840e).m18781f(true).m18782g(this.f15798a.f15841f);
            CustomViewUtils.b(view, new ColorDrawable(-1));
            view.setOnClickListener(this.f15802e);
            view.f15928F = this.f15803f;
        } else {
            SetSearchPlaceView setSearchPlaceView = (SetSearchPlaceView) view;
        }
        view.setTag(Integer.valueOf(i));
        NearbyPlacesPlaceModel nearbyPlacesPlaceModel = (NearbyPlacesPlaceModel) getItem(i);
        ((SetSearchPlaceViewBinder) this.f15799b.get()).m18787a(view, nearbyPlacesPlaceModel);
        if (this.f15801d != null) {
            this.f15801d.m18668a(nearbyPlacesPlaceModel);
        }
        return view;
    }

    private static View m18635a(View view, ViewGroup viewGroup) {
        if (view == null) {
            return new NearbyPlacesResultListPaginationLoadingView(viewGroup.getContext());
        }
        Preconditions.checkArgument(view instanceof NearbyPlacesResultListPaginationLoadingView);
        return view;
    }
}

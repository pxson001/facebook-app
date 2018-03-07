package com.facebook.nearby.v2.intent;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.fbui.widget.header.SectionHeaderView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.intent.NearbyPlacesV2IntentFragment.C07092;
import com.facebook.nearby.v2.intent.NearbyPlacesV2IntentFragment.C07125;
import com.facebook.nearby.v2.intent.categorypicker.NearbyPlacesCategoryPickerView;
import com.facebook.nearby.v2.intent.categorypicker.NearbyPlacesCategoryPickerView.OnClickCategoryPickerIconListener;
import com.facebook.nearby.v2.intent.categorypicker.icons.NearbyPlacesCategoryPickerIconType;
import com.facebook.nearby.v2.intent.model.FBNearbyPlacesIntentModel;
import com.facebook.nearby.v2.intent.views.NearbyPlacesLocationServicesView;
import com.facebook.nearby.v2.model.LocationStatusUtil.LocationStatus;
import com.facebook.nearby.v2.model.NearbyPlacesPlaceModel;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataProvider;
import com.facebook.nearby.v2.network.BrowseNearbyPlacesGraphQLModels.Photo320FragmentModel;
import com.facebook.nearby.v2.resultlist.views.NearbyPlacesResultListPaginationLoadingView;
import com.facebook.nearby.v2.resultlist.views.itemview.NearbyPlacesResultListItemView;
import com.facebook.nearby.v2.resultlist.views.itemview.NearbyPlacesResultListItemView.OnResultListItemViewClickedListener;
import com.facebook.nearby.v2.resultlist.views.itemview.actionbar.NearbyPlacesActionBarView.ActionBarItemType;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;

/* compiled from: people_tab_permanent_row */
public class NearbyPlacesIntentListAdapter extends BaseAdapter {
    private Context f5120a;
    private FBNearbyPlacesIntentModel f5121b;
    private NearbyPlacesSearchDataProvider f5122c;
    public OnClickCategoryPickerIconListener f5123d;
    public OnClickListener f5124e;
    public C07092 f5125f;

    /* compiled from: people_tab_permanent_row */
    class C07041 implements OnClickCategoryPickerIconListener {
        final /* synthetic */ NearbyPlacesIntentListAdapter f5114a;

        C07041(NearbyPlacesIntentListAdapter nearbyPlacesIntentListAdapter) {
            this.f5114a = nearbyPlacesIntentListAdapter;
        }

        public final void mo139a(NearbyPlacesCategoryPickerIconType nearbyPlacesCategoryPickerIconType) {
            if (this.f5114a.f5123d != null) {
                this.f5114a.f5123d.mo139a(nearbyPlacesCategoryPickerIconType);
            }
        }
    }

    /* compiled from: people_tab_permanent_row */
    class C07052 implements OnClickListener {
        final /* synthetic */ NearbyPlacesIntentListAdapter f5115a;

        C07052(NearbyPlacesIntentListAdapter nearbyPlacesIntentListAdapter) {
            this.f5115a = nearbyPlacesIntentListAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1235778485);
            if (this.f5115a.f5124e != null) {
                this.f5115a.f5124e.onClick(view);
            }
            Logger.a(2, EntryType.UI_INPUT_END, -1672086897, a);
        }
    }

    /* compiled from: people_tab_permanent_row */
    /* synthetic */ class C07074 {
        static final /* synthetic */ int[] f5119b = new int[LocationStatus.values().length];

        static {
            try {
                f5119b[LocationStatus.LOCATION_PERMISSION_OFF.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f5119b[LocationStatus.DEVICE_LOCATION_OFF.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f5119b[LocationStatus.DEVICE_NON_OPTIMAL_LOCATION_SETTING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            f5118a = new int[IntentListItemViewType.values().length];
            try {
                f5118a[IntentListItemViewType.HEADER_CATEGORY_PICKER.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f5118a[IntentListItemViewType.CELL_CATEGORY_PICKER.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f5118a[IntentListItemViewType.HEADER_NEAR_YOUR_LOCATION.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f5118a[IntentListItemViewType.CELL_TURN_ON_LOCATION_SERVICES.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f5118a[IntentListItemViewType.PLACES_HUGE_CELL.ordinal()] = 5;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f5118a[IntentListItemViewType.LOADING_CELL.ordinal()] = 6;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* compiled from: people_tab_permanent_row */
    public enum IntentListItemViewType {
        HEADER_CATEGORY_PICKER(0, -1),
        CELL_CATEGORY_PICKER(1, -2),
        HEADER_NEAR_YOUR_LOCATION(0, -3),
        CELL_TURN_ON_LOCATION_SERVICES(2, -4),
        LOADING_CELL(3, -5),
        PLACES_HUGE_CELL(4, -6);
        
        private final int mCellId;
        private final int mCellViewType;

        private IntentListItemViewType(int i, int i2) {
            this.mCellViewType = i;
            this.mCellId = i2;
        }

        public final int getCellViewType() {
            return this.mCellViewType;
        }

        public final int getCellId() {
            return this.mCellId;
        }
    }

    private boolean m4626a() {
        return !this.f5122c.c().f();
    }

    public NearbyPlacesIntentListAdapter(Context context, FBNearbyPlacesIntentModel fBNearbyPlacesIntentModel, NearbyPlacesSearchDataProvider nearbyPlacesSearchDataProvider) {
        Preconditions.checkNotNull(context);
        Preconditions.checkNotNull(fBNearbyPlacesIntentModel);
        Preconditions.checkNotNull(nearbyPlacesSearchDataProvider);
        this.f5120a = context;
        this.f5121b = fBNearbyPlacesIntentModel;
        this.f5122c = nearbyPlacesSearchDataProvider;
    }

    public int getCount() {
        if (m4626a() || this.f5121b.f5151a.isEmpty()) {
            return 4;
        }
        return this.f5121b.f5151a.size() + 3;
    }

    private IntentListItemViewType m4625a(int i) {
        IntentListItemViewType[] values = IntentListItemViewType.values();
        if (i < 3) {
            return values[i];
        }
        if (m4626a() && i == IntentListItemViewType.CELL_TURN_ON_LOCATION_SERVICES.ordinal()) {
            return IntentListItemViewType.CELL_TURN_ON_LOCATION_SERVICES;
        }
        if (this.f5121b.f5151a.isEmpty()) {
            return IntentListItemViewType.LOADING_CELL;
        }
        return IntentListItemViewType.PLACES_HUGE_CELL;
    }

    public Object getItem(int i) {
        IntentListItemViewType a = m4625a(i);
        if (a == IntentListItemViewType.PLACES_HUGE_CELL) {
            Preconditions.checkArgument(!m4626a());
            return this.f5121b.f5151a.get(i - 3);
        } else if (a != null) {
            return null;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public int getItemViewType(int i) {
        IntentListItemViewType a = m4625a(i);
        if (a != null) {
            return a.getCellViewType();
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public long getItemId(int i) {
        IntentListItemViewType a = m4625a(i);
        if (a != null) {
            return (long) a.getCellId();
        }
        throw new ArrayIndexOutOfBoundsException();
    }

    public int getViewTypeCount() {
        return IntentListItemViewType.values().length;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        IntentListItemViewType a = m4625a(i);
        if (a == null) {
            throw new IllegalArgumentException();
        }
        switch (a) {
            case HEADER_CATEGORY_PICKER:
                return m4623a(view);
            case CELL_CATEGORY_PICKER:
                return m4627b(view);
            case HEADER_NEAR_YOUR_LOCATION:
                return m4628c(view);
            case CELL_TURN_ON_LOCATION_SERVICES:
                return m4629d(view);
            case PLACES_HUGE_CELL:
                return m4622a(i, view);
            case LOADING_CELL:
                return m4630e(view);
            default:
                throw new IllegalArgumentException();
        }
    }

    private View m4624a(View view, int i) {
        if (view == null) {
            view = new SectionHeaderView(this.f5120a);
            view.setBackgroundResource(2131361993);
            view.setTopDivider(2131363245);
            view.setTitleText(i);
            return view;
        }
        Preconditions.checkArgument(view instanceof SectionHeaderView);
        return (SectionHeaderView) view;
    }

    private View m4623a(View view) {
        return m4624a(view, 2131236635);
    }

    private View m4627b(View view) {
        if (view == null) {
            view = new NearbyPlacesCategoryPickerView(this.f5120a);
            view.f5143c = new C07041(this);
            return view;
        }
        Preconditions.checkArgument(view instanceof NearbyPlacesCategoryPickerView);
        return (NearbyPlacesCategoryPickerView) view;
    }

    private View m4628c(View view) {
        return m4624a(view, 2131236636);
    }

    private View m4629d(View view) {
        if (view == null) {
            view = new NearbyPlacesLocationServicesView(this.f5120a);
            view.setOnClickListener(new C07052(this));
        } else {
            Preconditions.checkArgument(view instanceof NearbyPlacesLocationServicesView);
            NearbyPlacesLocationServicesView nearbyPlacesLocationServicesView = (NearbyPlacesLocationServicesView) view;
        }
        switch (C07074.f5119b[this.f5122c.c().a.ordinal()]) {
            case 1:
            case 2:
                view.setTitle(this.f5120a.getResources().getString(2131236628));
                view.setPrimaryButtonText(this.f5120a.getResources().getString(2131236629));
                break;
            case 3:
                view.setTitle(this.f5120a.getResources().getString(2131236630));
                view.setPrimaryButtonText(this.f5120a.getResources().getString(2131236631));
                break;
        }
        return view;
    }

    private View m4630e(View view) {
        if (view == null) {
            return new NearbyPlacesResultListPaginationLoadingView(this.f5120a);
        }
        Preconditions.checkArgument(view instanceof NearbyPlacesResultListPaginationLoadingView);
        return view;
    }

    private View m4622a(final int i, View view) {
        if (view == null) {
            view = new NearbyPlacesResultListItemView(this.f5120a);
        } else {
            Preconditions.checkArgument(view instanceof NearbyPlacesResultListItemView);
            NearbyPlacesResultListItemView nearbyPlacesResultListItemView = (NearbyPlacesResultListItemView) view;
        }
        view.a((NearbyPlacesPlaceModel) getItem(i), this.f5122c.c().c, true);
        view.i = new OnResultListItemViewClickedListener(this) {
            final /* synthetic */ NearbyPlacesIntentListAdapter f5117b;

            public final void m4620a(ActionBarItemType actionBarItemType) {
                if (this.f5117b.f5125f != null) {
                    C07092 c07092 = this.f5117b.f5125f;
                    int i = i;
                    Preconditions.checkArgument(i >= 0);
                    NearbyPlacesPlaceModel nearbyPlacesPlaceModel = (NearbyPlacesPlaceModel) c07092.f5127a.f5139i.getItem(i);
                    if (nearbyPlacesPlaceModel != null) {
                        NearbyPlacesV2IntentFragment nearbyPlacesV2IntentFragment;
                        switch (C07125.f5130a[actionBarItemType.ordinal()]) {
                            case 1:
                                nearbyPlacesV2IntentFragment = c07092.f5127a;
                                nearbyPlacesV2IntentFragment.f5133b.b(nearbyPlacesPlaceModel, nearbyPlacesV2IntentFragment.getContext(), NearbyPlacesV2IntentFragment.f5131c);
                                break;
                            case 2:
                                nearbyPlacesV2IntentFragment = c07092.f5127a;
                                nearbyPlacesV2IntentFragment.f5133b.a(nearbyPlacesPlaceModel.b(), nearbyPlacesPlaceModel.a(), nearbyPlacesV2IntentFragment.getContext(), SafeUUIDGenerator.a().toString());
                                break;
                            case 3:
                                nearbyPlacesV2IntentFragment = c07092.f5127a;
                                nearbyPlacesV2IntentFragment.f5133b.a(nearbyPlacesPlaceModel, nearbyPlacesV2IntentFragment.getContext(), NearbyPlacesV2IntentFragment.f5131c);
                                break;
                            case 4:
                            case 5:
                                nearbyPlacesV2IntentFragment = c07092.f5127a;
                                Object b = nearbyPlacesPlaceModel.b();
                                Preconditions.checkArgument(!TextUtils.isEmpty(b));
                                nearbyPlacesV2IntentFragment.f5133b.a(b, nearbyPlacesV2IntentFragment.getContext(), NearbyPlacesV2IntentFragment.f5131c);
                                break;
                            default:
                                NearbyPlacesV2IntentFragment.m4633g(c07092.f5127a, i);
                                break;
                        }
                    }
                }
            }

            public final void m4618a() {
                if (this.f5117b.f5125f != null) {
                    C07092 c07092 = this.f5117b.f5125f;
                    NearbyPlacesV2IntentFragment.m4633g(c07092.f5127a, i);
                }
            }

            public final void m4619a(int i) {
                if (this.f5117b.f5125f != null) {
                    C07092 c07092 = this.f5117b.f5125f;
                    int i2 = i;
                    NearbyPlacesV2IntentFragment nearbyPlacesV2IntentFragment = c07092.f5127a;
                    boolean z = true;
                    Preconditions.checkArgument(i >= 0);
                    NearbyPlacesPlaceModel nearbyPlacesPlaceModel = (NearbyPlacesPlaceModel) nearbyPlacesV2IntentFragment.f5139i.getItem(i2);
                    Preconditions.checkNotNull(nearbyPlacesPlaceModel, "Null place model cannot have hscroll photos");
                    ImmutableList<Photo320FragmentModel> l = nearbyPlacesPlaceModel.l();
                    if (i >= l.size()) {
                        z = false;
                    }
                    Preconditions.checkArgument(z);
                    Builder builder = new Builder();
                    for (Photo320FragmentModel photo320FragmentModel : l) {
                        Preconditions.checkNotNull(photo320FragmentModel.g());
                        builder.c(photo320FragmentModel.g());
                    }
                    ImmutableList b = builder.b();
                    nearbyPlacesV2IntentFragment.f5133b.a(b, (String) b.get(i), nearbyPlacesV2IntentFragment.getContext());
                }
            }

            public final void m4621b() {
                if (this.f5117b.f5125f != null) {
                    C07092 c07092 = this.f5117b.f5125f;
                    NearbyPlacesPlaceModel nearbyPlacesPlaceModel = (NearbyPlacesPlaceModel) c07092.f5127a.f5139i.getItem(i);
                    if (nearbyPlacesPlaceModel != null) {
                        NearbyPlacesV2IntentFragment nearbyPlacesV2IntentFragment = c07092.f5127a;
                        nearbyPlacesV2IntentFragment.f5133b.a(nearbyPlacesPlaceModel.b(), nearbyPlacesPlaceModel.a(), nearbyPlacesV2IntentFragment.getContext(), SafeUUIDGenerator.a().toString());
                    }
                }
            }
        };
        return view;
    }
}

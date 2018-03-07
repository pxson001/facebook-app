package com.facebook.nearby.v2.typeahead;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.tagging.AnalyticsFragment;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.intent.feed.IFeedIntentBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.nearby.v2.NearbyPlacesV2Fragment;
import com.facebook.nearby.v2.model.NearbyPlacesFragmentModel;
import com.facebook.nearby.v2.model.NearbyPlacesResultListQueryTopic;
import com.facebook.nearby.v2.model.NearbyPlacesSearchDataModel;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesTypeaheadLocationResultsConnectionFragmentModel.EdgesModel.NodeModel;
import com.facebook.nearby.v2.network.NearbyPlacesTypeaheadGraphQLModels.FBNearbyPlacesTypeaheadPlaceFragmentModel;
import com.facebook.nearby.v2.typeahead.NearbyPlacesPlacesAndTopicsAdapter.ItemViewType;
import com.facebook.nearby.v2.typeahead.logging.NearbyPlacesTypeaheadLogger;
import com.facebook.nearby.v2.typeahead.logging.NearbyPlacesTypeaheadLogger.TypeaheadSearchType;
import com.facebook.nearby.v2.typeahead.logging.NearbyPlacesTypeaheadLoggerData;
import com.facebook.nearby.v2.typeahead.logging.NearbyPlacesTypeaheadLoggerProvider;
import com.facebook.nearby.v2.typeahead.model.NearbyPlacesLocationResult;
import com.facebook.nearby.v2.typeahead.model.NearbyPlacesPlacesAndTopicsResult;
import com.facebook.nearby.v2.typeahead.model.NearbyPlacesTypeaheadModel;
import com.facebook.places.future.SimpleExecutor;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.widget.listview.BetterListView;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FutureCallback;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: password_change */
public class NearbyPlacesTypeaheadFragment extends FbFragment implements AnalyticsFragment {
    @Inject
    NearbyPlacesTypeaheadLoggerProvider f5191a;
    public final OnItemClickListener aA = new C07307(this);
    public BetterListView al;
    public NearbyPlacesTypeaheadEditText am;
    public NearbyPlacesTypeaheadEditText an;
    public ProgressBar ao;
    public NearbyPlacesLocationTypeaheadAdapter ap;
    public NearbyPlacesPlacesAndTopicsAdapter aq;
    public NearbyPlacesV2Fragment ar;
    public NearbyPlacesTypeaheadLogger as;
    public NearbyPlacesFragmentModel at;
    private final OnFocusChangeListener au = new C07241(this);
    private final OnScrollListener av = new C07252(this);
    private final TextWatcher aw = new C07263(this);
    private final OnEditorActionListener ax = new C07274(this);
    private final TextWatcher ay = new C07285(this);
    public final OnItemClickListener az = new C07296(this);
    @Inject
    NearbyPlacesLocationTypeaheadRunner f5192b;
    @Inject
    NearbyPlacesPlacesAndTopicsTypeaheadRunner f5193c;
    @Inject
    Provider<IFeedIntentBuilder> f5194d;
    @Inject
    SecureContextHelper f5195e;
    public NearbyPlacesTypeaheadModel f5196f;
    public NearbyPlacesTypeaheadLoggerData f5197g;
    private ViewGroup f5198h;
    public ViewGroup f5199i;

    /* compiled from: password_change */
    class C07241 implements OnFocusChangeListener {
        final /* synthetic */ NearbyPlacesTypeaheadFragment f5182a;

        C07241(NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment) {
            this.f5182a = nearbyPlacesTypeaheadFragment;
        }

        public void onFocusChange(View view, boolean z) {
            if (z) {
                this.f5182a.f5199i.setVisibility(0);
                if (view == this.f5182a.an) {
                    this.f5182a.f5197g.m4675b();
                    this.f5182a.as.m4673c(TypeaheadSearchType.LOCATIONS);
                    this.f5182a.al.setAdapter(this.f5182a.ap);
                    this.f5182a.al.setOnItemClickListener(this.f5182a.aA);
                    AdapterDetour.a(this.f5182a.ap, 1648209738);
                    NearbyPlacesTypeaheadFragment.az(this.f5182a);
                } else if (view == this.f5182a.am) {
                    this.f5182a.f5197g.m4674a();
                    this.f5182a.as.m4673c(TypeaheadSearchType.PLACES_TOPICS);
                    this.f5182a.al.setAdapter(this.f5182a.aq);
                    this.f5182a.al.setOnItemClickListener(this.f5182a.az);
                    AdapterDetour.a(this.f5182a.aq, 1650270256);
                    NearbyPlacesTypeaheadFragment.ay(this.f5182a);
                }
            }
        }
    }

    /* compiled from: password_change */
    class C07252 implements OnScrollListener {
        final /* synthetic */ NearbyPlacesTypeaheadFragment f5183a;

        C07252(NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment) {
            this.f5183a = nearbyPlacesTypeaheadFragment;
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            this.f5183a.as();
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }
    }

    /* compiled from: password_change */
    class C07263 implements TextWatcher {
        final /* synthetic */ NearbyPlacesTypeaheadFragment f5184a;

        C07263(NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment) {
            this.f5184a = nearbyPlacesTypeaheadFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f5184a.an.setTextColor(this.f5184a.jW_().getColor(2131361921));
            this.f5184a.f5196f.f5217a.b = false;
            this.f5184a.f5196f.f5217a.d = null;
            this.f5184a.f5196f.f5217a.e = null;
            NearbyPlacesTypeaheadFragment.az(this.f5184a);
        }
    }

    /* compiled from: password_change */
    class C07274 implements OnEditorActionListener {
        final /* synthetic */ NearbyPlacesTypeaheadFragment f5185a;

        C07274(NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment) {
            this.f5185a = nearbyPlacesTypeaheadFragment;
        }

        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            return true;
        }
    }

    /* compiled from: password_change */
    class C07285 implements TextWatcher {
        final /* synthetic */ NearbyPlacesTypeaheadFragment f5186a;

        C07285(NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment) {
            this.f5186a = nearbyPlacesTypeaheadFragment;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            this.f5186a.f5196f.f5217a.h = null;
            NearbyPlacesTypeaheadFragment.ay(this.f5186a);
        }
    }

    /* compiled from: password_change */
    class C07296 implements OnItemClickListener {
        final /* synthetic */ NearbyPlacesTypeaheadFragment f5187a;

        C07296(NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment) {
            this.f5187a = nearbyPlacesTypeaheadFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            ItemViewType itemViewType = ItemViewType.values()[this.f5187a.aq.getItemViewType(i)];
            if (itemViewType == ItemViewType.QUERY_SUGGESTION_CELL) {
                String str = (String) this.f5187a.aq.getItem(i);
                this.f5187a.as.m4669a(str, i, i);
                this.f5187a.f5196f.f5217a.h = new NearbyPlacesResultListQueryTopic(str, str);
                this.f5187a.am.setText(str);
                if (this.f5187a.ar == null || !this.f5187a.f5196f.f5217a.h()) {
                    this.f5187a.an.requestFocus();
                } else {
                    this.f5187a.ar.a(this.f5187a.f5196f.f5217a);
                }
            } else if (itemViewType == ItemViewType.PLACE_CELL) {
                FBNearbyPlacesTypeaheadPlaceFragmentModel fBNearbyPlacesTypeaheadPlaceFragmentModel = (FBNearbyPlacesTypeaheadPlaceFragmentModel) this.f5187a.aq.getItem(i);
                this.f5187a.as.m4672b(fBNearbyPlacesTypeaheadPlaceFragmentModel.k(), i, this.f5187a.aq.m4649a(i));
                this.f5187a.f5195e.a(((IFeedIntentBuilder) this.f5187a.f5194d.get()).b(this.f5187a.getContext(), StringFormatUtil.formatStrLocaleSafe(FBLinks.af, fBNearbyPlacesTypeaheadPlaceFragmentModel.k())), this.f5187a.getContext());
            }
        }
    }

    /* compiled from: password_change */
    class C07307 implements OnItemClickListener {
        final /* synthetic */ NearbyPlacesTypeaheadFragment f5188a;

        C07307(NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment) {
            this.f5188a = nearbyPlacesTypeaheadFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            NearbyPlacesLocationTypeaheadAdapter.ItemViewType itemViewType = NearbyPlacesLocationTypeaheadAdapter.ItemViewType.values()[this.f5188a.ap.getItemViewType(i)];
            if (itemViewType == NearbyPlacesLocationTypeaheadAdapter.ItemViewType.CURRENT_LOCATION_CELL) {
                this.f5188a.f5196f.f5217a.b = true;
                this.f5188a.f5196f.f5217a.d = null;
                this.f5188a.f5196f.f5217a.e = null;
                NearbyPlacesTypeaheadFragment.aw(this.f5188a);
                this.f5188a.as.m4670a(null, null, i, this.f5188a.ap.m4644a(i), true);
            } else if (itemViewType == NearbyPlacesLocationTypeaheadAdapter.ItemViewType.LOCATION_CELL) {
                NodeModel nodeModel = (NodeModel) this.f5188a.ap.getItem(i);
                this.f5188a.f5196f.f5217a.d = nodeModel.j();
                this.f5188a.f5196f.f5217a.e = nodeModel.l();
                this.f5188a.f5196f.f5217a.f = nodeModel.k().a();
                this.f5188a.f5196f.f5217a.g = nodeModel.k().j();
                this.f5188a.f5196f.f5217a.b = false;
                NearbyPlacesTypeaheadFragment.m4654a(this.f5188a, nodeModel.l());
                this.f5188a.as.m4670a(nodeModel.j(), nodeModel.l(), i, this.f5188a.ap.m4644a(i), false);
            }
            if (this.f5188a.ar == null || !this.f5188a.f5196f.f5217a.h()) {
                this.f5188a.am.requestFocus();
            } else {
                this.f5188a.ar.a(this.f5188a.f5196f.f5217a);
            }
        }
    }

    /* compiled from: password_change */
    class C07318 implements FutureCallback<NearbyPlacesPlacesAndTopicsResult> {
        final /* synthetic */ NearbyPlacesTypeaheadFragment f5189a;

        C07318(NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment) {
            this.f5189a = nearbyPlacesTypeaheadFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            NearbyPlacesPlacesAndTopicsResult nearbyPlacesPlacesAndTopicsResult = (NearbyPlacesPlacesAndTopicsResult) obj;
            this.f5189a.ao.setVisibility(8);
            if (nearbyPlacesPlacesAndTopicsResult != null) {
                this.f5189a.f5196f.f5218b = nearbyPlacesPlacesAndTopicsResult;
                this.f5189a.as.m4668a(TypeaheadSearchType.PLACES_TOPICS);
                this.f5189a.as.m4671b(TypeaheadSearchType.PLACES_TOPICS);
                if (this.f5189a.al.getAdapter() == this.f5189a.aq) {
                    AdapterDetour.a(this.f5189a.aq, 1242780953);
                }
            }
        }

        public void onFailure(Throwable th) {
            this.f5189a.ao.setVisibility(8);
            Toast.makeText(this.f5189a.getContext(), this.f5189a.jW_().getString(2131236710), 0).show();
        }
    }

    /* compiled from: password_change */
    class C07329 implements FutureCallback<NearbyPlacesLocationResult> {
        final /* synthetic */ NearbyPlacesTypeaheadFragment f5190a;

        C07329(NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment) {
            this.f5190a = nearbyPlacesTypeaheadFragment;
        }

        public void onSuccess(@Nullable Object obj) {
            NearbyPlacesLocationResult nearbyPlacesLocationResult = (NearbyPlacesLocationResult) obj;
            this.f5190a.ao.setVisibility(8);
            if (nearbyPlacesLocationResult != null) {
                this.f5190a.f5196f.f5219c = nearbyPlacesLocationResult;
                this.f5190a.as.m4668a(TypeaheadSearchType.LOCATIONS);
                this.f5190a.as.m4671b(TypeaheadSearchType.LOCATIONS);
                if (this.f5190a.al.getAdapter() == this.f5190a.ap) {
                    AdapterDetour.a(this.f5190a.ap, 250314451);
                }
            }
        }

        public void onFailure(Throwable th) {
            this.f5190a.ao.setVisibility(8);
            Toast.makeText(this.f5190a.getContext(), this.f5190a.jW_().getString(2131236710), 0).show();
        }
    }

    public static void m4656a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((NearbyPlacesTypeaheadFragment) obj).m4655a((NearbyPlacesTypeaheadLoggerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(NearbyPlacesTypeaheadLoggerProvider.class), NearbyPlacesLocationTypeaheadRunner.m4645b(fbInjector), new NearbyPlacesPlacesAndTopicsTypeaheadRunner(GraphQLQueryExecutor.a(fbInjector), SimpleExecutor.b(fbInjector)), IdBasedSingletonScopeProvider.a(fbInjector, 2347), (SecureContextHelper) DefaultSecureContextHelper.a(fbInjector));
    }

    private void m4655a(NearbyPlacesTypeaheadLoggerProvider nearbyPlacesTypeaheadLoggerProvider, NearbyPlacesLocationTypeaheadRunner nearbyPlacesLocationTypeaheadRunner, NearbyPlacesPlacesAndTopicsTypeaheadRunner nearbyPlacesPlacesAndTopicsTypeaheadRunner, Provider<IFeedIntentBuilder> provider, SecureContextHelper secureContextHelper) {
        this.f5191a = nearbyPlacesTypeaheadLoggerProvider;
        this.f5192b = nearbyPlacesLocationTypeaheadRunner;
        this.f5193c = nearbyPlacesPlacesAndTopicsTypeaheadRunner;
        this.f5194d = provider;
        this.f5195e = secureContextHelper;
    }

    public final void m4658a(NearbyPlacesSearchDataModel nearbyPlacesSearchDataModel) {
        Preconditions.checkNotNull(nearbyPlacesSearchDataModel);
        this.f5196f.f5217a = new NearbyPlacesSearchDataModel(nearbyPlacesSearchDataModel);
        av();
    }

    private void av() {
        if (this.am != null) {
            if (this.f5196f.f5217a.h != null) {
                this.am.setText(this.f5196f.f5217a.h.a);
            } else {
                this.am.setText("");
            }
        }
        if (this.an == null) {
            return;
        }
        if (!TextUtils.isEmpty(this.f5196f.f5217a.e)) {
            m4654a(this, this.f5196f.f5217a.e);
        } else if (this.f5196f.f5217a.b) {
            aw(this);
        } else {
            m4654a(this, "");
        }
    }

    public final boolean aq() {
        if (this.f5199i != null && this.f5199i.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void ar() {
        this.an.clearFocus();
        this.am.clearFocus();
        this.f5199i.setVisibility(8);
        as();
    }

    public final void as() {
        InputMethodManager inputMethodManager = (InputMethodManager) o().getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(this.T.getWindowToken(), 0);
        }
    }

    public final void m4659c(Bundle bundle) {
        super.c(bundle);
        Class cls = NearbyPlacesTypeaheadFragment.class;
        m4656a((Object) this, getContext());
    }

    public final void mi_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1658879712);
        super.mi_();
        if (this.al.getAdapter() == this.aq) {
            if (this.f5196f.f5218b != null) {
                this.as.m4671b(TypeaheadSearchType.PLACES_TOPICS);
            }
        } else if (this.al.getAdapter() == this.ap && this.f5196f.f5219c != null) {
            this.as.m4671b(TypeaheadSearchType.LOCATIONS);
        }
        LogUtils.f(-1841633668, a);
    }

    public final void mj_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 541679467);
        this.f5193c.m4650a();
        this.f5192b.m4646a();
        super.mj_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1847058100, a);
    }

    public final View m4657a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1326943287);
        this.f5198h = (ViewGroup) layoutInflater.inflate(2130905389, viewGroup, false);
        this.f5199i = (ViewGroup) this.f5198h.findViewById(2131564103);
        this.al = (BetterListView) this.f5198h.findViewById(2131564104);
        this.al.setOnScrollListener(this.av);
        this.am = (NearbyPlacesTypeaheadEditText) this.f5198h.findViewById(2131564101);
        this.am.setOnFocusChangeListener(this.au);
        this.am.setInputTextListener(this.ay);
        this.am.setOnEditorActionListener(this.ax);
        this.an = (NearbyPlacesTypeaheadEditText) this.f5198h.findViewById(2131564102);
        this.ao = (ProgressBar) this.f5198h.findViewById(2131564105);
        Preconditions.checkNotNull(this.ao);
        this.an.setOnFocusChangeListener(this.au);
        this.an.setInputTextListener(this.aw);
        this.an.setOnEditorActionListener(this.ax);
        View view = this.f5198h;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 218977303, a);
        return view;
    }

    public final void m4660d(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 446359208);
        super.d(bundle);
        if (bundle != null) {
            this.f5196f = (NearbyPlacesTypeaheadModel) bundle.getParcelable("typeahead_model_state");
            this.f5199i.setVisibility(bundle.getBoolean("typeahead_is_visible_state") ? 0 : 8);
            this.f5197g = (NearbyPlacesTypeaheadLoggerData) bundle.getParcelable("typeahead_logger_data_state");
        } else {
            this.f5196f = new NearbyPlacesTypeaheadModel(new NearbyPlacesSearchDataModel((NearbyPlacesSearchDataModel) this.s.getParcelable("nearby_places_search_data")));
            this.f5197g = new NearbyPlacesTypeaheadLoggerData();
        }
        Preconditions.checkNotNull(this.f5196f.f5217a);
        av();
        this.as = new NearbyPlacesTypeaheadLogger(this.at, this, this, AnalyticsLoggerMethodAutoProvider.a(this.f5191a));
        if (this.ap == null) {
            this.ap = new NearbyPlacesLocationTypeaheadAdapter(getContext(), this.f5196f, false);
        }
        if (this.aq == null) {
            this.aq = new NearbyPlacesPlacesAndTopicsAdapter(getContext(), this.f5196f);
        }
        LogUtils.f(-115009227, a);
    }

    public static void aw(NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment) {
        nearbyPlacesTypeaheadFragment.an.setText(nearbyPlacesTypeaheadFragment.jW_().getString(2131236708));
        nearbyPlacesTypeaheadFragment.an.setTextColor(nearbyPlacesTypeaheadFragment.jW_().getColor(2131361917));
    }

    public static void m4654a(NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment, String str) {
        nearbyPlacesTypeaheadFragment.an.setText(str);
        nearbyPlacesTypeaheadFragment.an.setTextColor(nearbyPlacesTypeaheadFragment.jW_().getColor(2131361921));
    }

    public final void m4661e(Bundle bundle) {
        super.e(bundle);
        bundle.putParcelable("typeahead_model_state", this.f5196f);
        bundle.putBoolean("typeahead_is_visible_state", aq());
        bundle.putParcelable("typeahead_logger_data_state", this.f5197g);
    }

    public static void ay(NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment) {
        Location location;
        NearbyPlacesTypeaheadParams nearbyPlacesTypeaheadParams;
        nearbyPlacesTypeaheadFragment.ao.setVisibility(0);
        nearbyPlacesTypeaheadFragment.f5196f.f5218b = null;
        if (nearbyPlacesTypeaheadFragment.al.getAdapter() == nearbyPlacesTypeaheadFragment.aq) {
            AdapterDetour.a(nearbyPlacesTypeaheadFragment.aq, -357726699);
        }
        String trim = nearbyPlacesTypeaheadFragment.am.getText().toString().trim();
        if (nearbyPlacesTypeaheadFragment.f5196f.f5217a.d != null && nearbyPlacesTypeaheadFragment.f5196f.f5217a.f != 0.0d && nearbyPlacesTypeaheadFragment.f5196f.f5217a.g != 0.0d) {
            location = new Location("");
            location.setLatitude(nearbyPlacesTypeaheadFragment.f5196f.f5217a.f);
            location.setLongitude(nearbyPlacesTypeaheadFragment.f5196f.f5217a.g);
        } else if (nearbyPlacesTypeaheadFragment.f5196f.f5217a.b) {
            location = nearbyPlacesTypeaheadFragment.f5196f.f5217a.c;
        } else {
            location = null;
        }
        Location location2 = location;
        if (location2 == null) {
            nearbyPlacesTypeaheadParams = new NearbyPlacesTypeaheadParams(trim);
        } else {
            nearbyPlacesTypeaheadParams = new NearbyPlacesTypeaheadParams(trim, location2.getLatitude(), location2.getLongitude());
        }
        nearbyPlacesTypeaheadFragment.f5193c.m4651a(nearbyPlacesTypeaheadParams, new C07318(nearbyPlacesTypeaheadFragment));
    }

    public static void az(NearbyPlacesTypeaheadFragment nearbyPlacesTypeaheadFragment) {
        String str;
        nearbyPlacesTypeaheadFragment.ao.setVisibility(0);
        nearbyPlacesTypeaheadFragment.f5196f.m4676b();
        if (nearbyPlacesTypeaheadFragment.al.getAdapter() == nearbyPlacesTypeaheadFragment.ap) {
            AdapterDetour.a(nearbyPlacesTypeaheadFragment.ap, -678305053);
        }
        if (nearbyPlacesTypeaheadFragment.f5196f.f5217a.b) {
            str = "";
        } else {
            str = nearbyPlacesTypeaheadFragment.an.getText().toString().trim();
        }
        nearbyPlacesTypeaheadFragment.f5192b.m4647a(new NearbyPlacesTypeaheadParams(str), new C07329(nearbyPlacesTypeaheadFragment));
    }

    public final String am_() {
        return "nearby_places_typeahead";
    }
}

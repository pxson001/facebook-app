package com.facebook.places.suggestions;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.crowdsourcing.logging.CrowdEndpoint;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.places.graphql.PlacesGraphQLInterfaces.CheckinPlace;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.suggestions.common.CrowdsourcingSource;
import com.facebook.places.suggestions.common.SuggestPlaceInfoParams;
import com.facebook.places.suggestions.common.SuggestPlaceInfoRunner;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.AdapterDetour;
import com.facebook.ui.dialogs.ProgressDialogFragment;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableSet;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.FutureCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* compiled from: seconds_until_expires */
public class MarkAsDuplicatesFragment extends FbFragment {
    private static final Class<?> f3632a = MarkAsDuplicatesFragment.class;
    private SuggestPlaceInfoRunner al;
    public FbTitleBar am;
    public DialogFragment f3633b;
    private List<TitleBarButtonSpec> f3634c;
    private List<TitleBarButtonSpec> f3635d;
    public CrowdEntryPoint f3636e;
    private final Set<FragmentListener> f3637f = Sets.a();
    private CheckinPlaceModel f3638g;
    private MarkAsDuplicatesAdapter f3639h;
    public Toaster f3640i;

    /* compiled from: seconds_until_expires */
    public interface FragmentListener {
        void mo194a();
    }

    /* compiled from: seconds_until_expires */
    class C04671 implements FutureCallback<Void> {
        final /* synthetic */ MarkAsDuplicatesFragment f3630a;

        C04671(MarkAsDuplicatesFragment markAsDuplicatesFragment) {
            this.f3630a = markAsDuplicatesFragment;
        }

        public void onFailure(Throwable th) {
            this.f3630a.f3633b.a();
            this.f3630a.f3640i.b(new ToastBuilder(2131237626));
        }

        public void onSuccess(Object obj) {
            this.f3630a.f3633b.a();
            this.f3630a.f3640i.b(new ToastBuilder(2131237625));
            MarkAsDuplicatesFragment.ar(this.f3630a);
        }
    }

    /* compiled from: seconds_until_expires */
    class C04682 implements OnItemClickListener {
        final /* synthetic */ MarkAsDuplicatesFragment f3631a;

        C04682(MarkAsDuplicatesFragment markAsDuplicatesFragment) {
            this.f3631a = markAsDuplicatesFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            PlaceRowView placeRowView = (PlaceRowView) view;
            placeRowView.m3588a();
            if (placeRowView.f3657h.f3649e) {
                this.f3631a.m3565a(true);
            } else {
                this.f3631a.m3565a(MarkAsDuplicatesFragment.aq(this.f3631a));
            }
        }
    }

    public final void m3577a(ImmutableList<CheckinPlace> immutableList) {
        m3564a((ImmutableList) immutableList, (ImmutableSet) RegularImmutableSet.a);
    }

    public final void m3579c(Bundle bundle) {
        super.c(bundle);
        FbInjector an = an();
        this.f3640i = Toaster.b(an);
        this.al = SuggestPlaceInfoRunner.m3646b(an);
        this.f3639h = new MarkAsDuplicatesAdapter((Context) an().getInstance(Context.class));
        m3570e();
    }

    public final View m3572a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 149782998);
        super.a(layoutInflater, viewGroup, bundle);
        View inflate = layoutInflater.inflate(2130905162, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 484794560, a);
        return inflate;
    }

    private void m3570e() {
        Builder a = TitleBarButtonSpec.a();
        a.g = b(2131230752);
        a = a;
        a.d = true;
        this.f3634c = ImmutableList.of(a.a());
        a = TitleBarButtonSpec.a();
        a.g = b(2131230752);
        a = a;
        a.d = false;
        this.f3635d = ImmutableList.of(a.a());
    }

    public final void m3574a(CheckinPlaceModel checkinPlaceModel) {
        this.f3638g = checkinPlaceModel;
        ((PlaceRowView) e(2131563667)).setInfo(PlaceRow.m3583a(this.f3638g).m3582a());
    }

    public final void m3573a(CrowdEntryPoint crowdEntryPoint) {
        this.f3636e = crowdEntryPoint;
    }

    public final void m3576a(FbTitleBar fbTitleBar) {
        this.am = fbTitleBar;
    }

    private void m3564a(ImmutableList<CheckinPlace> immutableList, ImmutableSet<String> immutableSet) {
        ImmutableList.Builder builder = ImmutableList.builder();
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) immutableList.get(i);
            PlaceRow.Builder a = PlaceRow.m3583a(checkinPlaceModel);
            a.f3642b = true;
            PlaceRow a2 = a.m3582a();
            if (immutableSet.contains(checkinPlaceModel.cf_())) {
                a2.m3584a(true);
            }
            builder.c(a2);
        }
        m3567b(builder.b());
    }

    public final void m3578b() {
        ImmutableList.Builder builder = ImmutableList.builder();
        ImmutableList immutableList = this.f3639h.f3629b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PlaceRow placeRow = (PlaceRow) immutableList.get(i);
            if (placeRow.f3649e) {
                builder.c(Long.valueOf(Long.parseLong(placeRow.f3645a.cf_())));
            }
        }
        ImmutableList b = builder.b();
        if (b.isEmpty()) {
            this.f3640i.b(new ToastBuilder(2131235197));
            return;
        }
        SuggestPlaceInfoParams.Builder a = SuggestPlaceInfoParams.m3645a(this.f3638g.cf_());
        Preconditions.checkNotNull(b);
        Preconditions.checkArgument(b.size() > 0);
        a.f3734o = b;
        a.f3715A = CrowdsourcingSource.COMPOSER_EDIT;
        a.f3718D = this.f3636e;
        a.f3719E = CrowdEndpoint.MARK_DUPLICATES;
        this.f3633b = ProgressDialogFragment.a(2131230757, true, false);
        this.f3633b.a(this.D, null);
        this.al.m3648a(a.m3637a(), new C04671(this));
    }

    public final void m3575a(FragmentListener fragmentListener) {
        synchronized (this.f3637f) {
            Preconditions.checkState(!this.f3637f.contains(fragmentListener));
            this.f3637f.add(fragmentListener);
        }
    }

    public final void m3580e(Bundle bundle) {
        super.e(bundle);
        FlatBufferModelHelper.a(bundle, "target_place", this.f3638g);
        ArrayList a = Lists.a();
        List a2 = Lists.a();
        ImmutableList immutableList = this.f3639h.f3629b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PlaceRow placeRow = (PlaceRow) immutableList.get(i);
            a2.add(placeRow.f3645a);
            if (placeRow.f3649e) {
                a.add(placeRow.f3645a.cf_());
            }
        }
        FlatBufferModelHelper.a(bundle, "place_list", a2);
        bundle.putStringArrayList("checked_places", a);
        bundle.putString("entry_point", this.f3636e.toString());
    }

    public final void m3581h(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 123398806);
        super.h(bundle);
        if (bundle != null) {
            CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(bundle, "target_place");
            if (checkinPlaceModel != null) {
                m3574a(checkinPlaceModel);
            }
            ImmutableList copyOf = ImmutableList.copyOf(FlatBufferModelHelper.b(bundle, "place_list"));
            ArrayList stringArrayList = bundle.getStringArrayList("checked_places");
            ImmutableSet.Builder builder = ImmutableSet.builder();
            if (stringArrayList != null) {
                int size = stringArrayList.size();
                for (int i = 0; i < size; i++) {
                    builder.c((String) stringArrayList.get(i));
                }
            }
            if (copyOf != null) {
                m3564a(copyOf, builder.b());
            }
            this.f3636e = CrowdEntryPoint.valueOf(bundle.getString("entry_point"));
        }
        LogUtils.f(1955062904, a);
    }

    private void m3565a(boolean z) {
        if (z) {
            this.am.setButtonSpecs(this.f3634c);
        } else {
            this.am.setButtonSpecs(this.f3635d);
        }
    }

    public static boolean aq(MarkAsDuplicatesFragment markAsDuplicatesFragment) {
        ImmutableList immutableList = markAsDuplicatesFragment.f3639h.f3629b;
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            if (((PlaceRow) immutableList.get(i)).f3649e) {
                return true;
            }
        }
        return false;
    }

    public final void m3571I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 833479806);
        this.al.m3647a();
        super.I();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1930500056, a);
    }

    private void m3567b(ImmutableList<PlaceRow> immutableList) {
        BaseAdapter baseAdapter = this.f3639h;
        baseAdapter.f3629b = immutableList;
        AdapterDetour.a(baseAdapter, 1781835964);
        ListView listView = (ListView) e(16908298);
        listView.setAdapter(this.f3639h);
        listView.setOnItemClickListener(new C04682(this));
    }

    public static void ar(MarkAsDuplicatesFragment markAsDuplicatesFragment) {
        synchronized (markAsDuplicatesFragment.f3637f) {
            for (FragmentListener a : markAsDuplicatesFragment.f3637f) {
                a.mo194a();
            }
        }
    }
}

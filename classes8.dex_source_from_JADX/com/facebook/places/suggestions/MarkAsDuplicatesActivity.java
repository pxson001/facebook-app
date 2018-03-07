package com.facebook.places.suggestions;

import android.os.Bundle;
import android.view.View;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.base.activity.UsesSimpleStringTitle;
import com.facebook.crowdsourcing.logging.CrowdEntryPoint;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.places.suggestions.MarkAsDuplicatesFragment.FragmentListener;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import com.facebook.widget.titlebar.TitleBarButtonSpec.Builder;
import com.google.common.collect.ImmutableList;

/* compiled from: section_key */
public class MarkAsDuplicatesActivity extends FbFragmentActivity implements UsesSimpleStringTitle {
    private MarkAsDuplicatesFragment f3626p;
    private FbTitleBar f3627q;

    /* compiled from: section_key */
    class C04651 extends OnToolbarButtonListener {
        final /* synthetic */ MarkAsDuplicatesActivity f3624a;

        C04651(MarkAsDuplicatesActivity markAsDuplicatesActivity) {
            this.f3624a = markAsDuplicatesActivity;
        }

        public final void m3552a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            MarkAsDuplicatesActivity.m3558k(this.f3624a);
        }
    }

    /* compiled from: section_key */
    class C04662 implements FragmentListener {
        final /* synthetic */ MarkAsDuplicatesActivity f3625a;

        C04662(MarkAsDuplicatesActivity markAsDuplicatesActivity) {
            this.f3625a = markAsDuplicatesActivity;
        }

        public final void mo194a() {
            this.f3625a.finish();
        }
    }

    protected final void m3560b(Bundle bundle) {
        super.b(bundle);
        m3556i();
        m3557j();
    }

    private void m3556i() {
        setContentView(2130905161);
        FbTitleBarUtil.b(this);
        this.f3627q = (FbTitleBar) a(2131558563);
        FbTitleBar fbTitleBar = this.f3627q;
        Builder a = TitleBarButtonSpec.a();
        a.g = getString(2131230752);
        a = a;
        a.d = false;
        fbTitleBar.setButtonSpecs(ImmutableList.of(a.a()));
        this.f3627q.setOnToolbarButtonListener(new C04651(this));
    }

    private void m3557j() {
        CheckinPlaceModel checkinPlaceModel = (CheckinPlaceModel) FlatBufferModelHelper.a(getIntent(), "duplicate_place");
        ImmutableList copyOf = ImmutableList.copyOf(FlatBufferModelHelper.b(getIntent(), "extra_place_list"));
        CrowdEntryPoint crowdEntryPoint = (CrowdEntryPoint) getIntent().getSerializableExtra("entry_point");
        this.f3626p = (MarkAsDuplicatesFragment) kO_().a(2131563666);
        this.f3626p.m3575a(new C04662(this));
        this.f3626p.am = this.f3627q;
        this.f3626p.m3574a(checkinPlaceModel);
        this.f3626p.m3577a(copyOf);
        this.f3626p.f3636e = crowdEntryPoint;
    }

    public static void m3558k(MarkAsDuplicatesActivity markAsDuplicatesActivity) {
        markAsDuplicatesActivity.f3626p.m3578b();
    }

    public final String m3559a() {
        return getString(2131237629);
    }
}

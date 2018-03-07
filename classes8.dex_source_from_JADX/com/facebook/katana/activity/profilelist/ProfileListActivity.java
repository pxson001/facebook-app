package com.facebook.katana.activity.profilelist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.facebook.base.activity.FbFragmentActivity;
import com.facebook.inject.FbInjector;
import com.facebook.widget.listview.BetterListView;
import com.facebook.widget.listview.SectionedListAdapter;

/* compiled from: unfollowed_profiles */
public abstract class ProfileListActivity extends FbFragmentActivity {
    protected ProfileListAdapter f1192B;
    protected BetterListView f1193C;
    private OnItemClickListener f1194p = new C01211(this);

    /* compiled from: unfollowed_profiles */
    public abstract class ProfileListAdapter extends SectionedListAdapter {
    }

    /* compiled from: unfollowed_profiles */
    class C01211 implements OnItemClickListener {
        final /* synthetic */ ProfileListActivity f1263a;

        C01211(ProfileListActivity profileListActivity) {
            this.f1263a = profileListActivity;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f1263a.mo54a(view, i);
        }
    }

    protected abstract void mo54a(View view, int i);

    protected void mo55b(Bundle bundle) {
        super.b(bundle);
        Class cls = ProfileListActivity.class;
        FbInjector.get(this);
    }

    protected final void m1431i() {
        View findViewById = findViewById(16908292);
        this.f1193C = (BetterListView) findViewById(16908298);
        this.f1193C.setEmptyView(findViewById);
        this.f1193C.setOnItemClickListener(this.f1194p);
    }
}

package com.facebook.groups.fb4a.createrpanel;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.uri.FbUriIntentHandler;
import com.facebook.groups.gysc.GYSCRowView;
import com.facebook.groups.gysc.controller.GYSCDataFetcher;
import com.facebook.groups.gysc.controller.GYSCHscrollViewAdapter;
import com.facebook.groups.gysc.model.Enums.Location;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: action_item_type */
public class FB4AGroupsCreateTabFragment extends FbFragment {
    @Inject
    public Context f10137a;
    @Inject
    public FbUriIntentHandler f10138b;
    @Inject
    public GYSCDataFetcher f10139c;
    @Inject
    public GYSCHscrollViewAdapter f10140d;
    private Button f10141e;
    public OnClickListener f10142f;
    private GYSCRowView f10143g;

    /* compiled from: action_item_type */
    public class C11841 implements OnClickListener {
        final /* synthetic */ FB4AGroupsCreateTabFragment f10136a;

        public C11841(FB4AGroupsCreateTabFragment fB4AGroupsCreateTabFragment) {
            this.f10136a = fB4AGroupsCreateTabFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1819775638);
            Bundle bundle = new Bundle();
            bundle.putString("ref", "creation_tab_upsell");
            this.f10136a.f10138b.a(this.f10136a.f10137a, FBLinks.D, bundle);
            Logger.a(2, EntryType.UI_INPUT_END, 764811389, a);
        }
    }

    public static void m10484a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        FB4AGroupsCreateTabFragment fB4AGroupsCreateTabFragment = (FB4AGroupsCreateTabFragment) obj;
        Context context2 = (Context) fbInjector.getInstance(Context.class);
        FbUriIntentHandler a = FbUriIntentHandler.a(fbInjector);
        GYSCDataFetcher b = GYSCDataFetcher.b(fbInjector);
        GYSCHscrollViewAdapter b2 = GYSCHscrollViewAdapter.b(fbInjector);
        fB4AGroupsCreateTabFragment.f10137a = context2;
        fB4AGroupsCreateTabFragment.f10138b = a;
        fB4AGroupsCreateTabFragment.f10139c = b;
        fB4AGroupsCreateTabFragment.f10140d = b2;
    }

    public final void m10488c(@Nullable Bundle bundle) {
        super.c(bundle);
        Class cls = FB4AGroupsCreateTabFragment.class;
        m10484a((Object) this, getContext());
        GYSCHscrollViewAdapter gYSCHscrollViewAdapter = this.f10140d;
        gYSCHscrollViewAdapter.c.a(gYSCHscrollViewAdapter.f);
        this.f10139c.a(this.f10140d);
    }

    public final View m10486a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -2041807751);
        View inflate = layoutInflater.inflate(2130904254, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1337786636, a);
        return inflate;
    }

    public final void m10487a(View view, @Nullable Bundle bundle) {
        super.a(view, bundle);
        this.f10141e = (Button) e(2131561769);
        this.f10143g = (GYSCRowView) e(2131561771);
        Button button = this.f10141e;
        if (this.f10142f == null) {
            this.f10142f = new C11841(this);
        }
        button.setOnClickListener(this.f10142f);
        this.f10143g.setAdapter(this.f10140d);
        this.f10140d.e = Location.CREATION_TAB;
    }

    public final void m10485I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 225848799);
        super.I();
        GYSCHscrollViewAdapter gYSCHscrollViewAdapter = this.f10140d;
        gYSCHscrollViewAdapter.c.b(gYSCHscrollViewAdapter.f);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1523914050, a);
    }
}

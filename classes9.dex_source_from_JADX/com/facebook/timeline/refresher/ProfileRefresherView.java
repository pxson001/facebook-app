package com.facebook.timeline.refresher;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.fbui.widget.text.caps.AllCapsTransformationMethod;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLProfileWizardStepType;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.resources.ui.FbButton;
import com.facebook.resources.ui.FbTextView;
import com.facebook.timeline.abtest.ExperimentsForTimelineAbTestModule;
import com.facebook.widget.CustomRelativeLayout;
import com.facebook.widget.loadingindicator.LoadingIndicatorView;
import com.facebook.widget.titlebar.FbTitleBar;
import com.facebook.widget.titlebar.FbTitleBar.OnToolbarButtonListener;
import com.facebook.widget.titlebar.FbTitleBarUtil;
import com.facebook.widget.titlebar.TitleBarButtonSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

/* compiled from: up/ */
public class ProfileRefresherView extends CustomRelativeLayout {
    public static final CallerContext f1041a = CallerContext.a(ProfileRefresherView.class, "timeline");
    @Inject
    AllCapsTransformationMethod f1042b;
    @Inject
    QeAccessor f1043c;
    private FbTitleBar f1044d;
    public ViewStub f1045e;
    public FbTextView f1046f;
    public FbTextView f1047g;
    private FbButton f1048h;
    private FbButton f1049i;
    private FbButton f1050j;
    public View f1051k;
    public ProfileRefresherPagerAdapter f1052l;
    public FrameLayout f1053m;
    public LinearLayout f1054n;
    public LoadingIndicatorView f1055o;
    public EventListener f1056p;
    private boolean f1057q;
    private final OnClickListener f1058r = new C01031(this);
    public final OnToolbarButtonListener f1059s = new C01042(this);

    /* compiled from: up/ */
    interface EventListener {
        void mo51d();

        void mo52e();

        void mo54i();

        void mo55j();
    }

    /* compiled from: up/ */
    class C01031 implements OnClickListener {
        final /* synthetic */ ProfileRefresherView f1036a;

        C01031(ProfileRefresherView profileRefresherView) {
            this.f1036a = profileRefresherView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 43538511);
            this.f1036a.f1056p.mo52e();
            Logger.a(2, EntryType.UI_INPUT_END, 745341184, a);
        }
    }

    /* compiled from: up/ */
    class C01042 extends OnToolbarButtonListener {
        final /* synthetic */ ProfileRefresherView f1037a;

        C01042(ProfileRefresherView profileRefresherView) {
            this.f1037a = profileRefresherView;
        }

        public final void m1051a(View view, TitleBarButtonSpec titleBarButtonSpec) {
            this.f1037a.f1056p.mo51d();
        }
    }

    /* compiled from: up/ */
    class C01053 implements OnClickListener {
        final /* synthetic */ ProfileRefresherView f1038a;

        C01053(ProfileRefresherView profileRefresherView) {
            this.f1038a = profileRefresherView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 44460364);
            this.f1038a.f1056p.mo54i();
            Logger.a(2, EntryType.UI_INPUT_END, -1025380879, a);
        }
    }

    /* compiled from: up/ */
    class C01064 implements OnClickListener {
        final /* synthetic */ ProfileRefresherView f1039a;

        C01064(ProfileRefresherView profileRefresherView) {
            this.f1039a = profileRefresherView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -494960996);
            this.f1039a.f1056p.mo54i();
            Logger.a(2, EntryType.UI_INPUT_END, -2096264542, a);
        }
    }

    /* compiled from: up/ */
    class C01075 implements OnClickListener {
        final /* synthetic */ ProfileRefresherView f1040a;

        C01075(ProfileRefresherView profileRefresherView) {
            this.f1040a = profileRefresherView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 826108387);
            this.f1040a.f1056p.mo55j();
            Logger.a(2, EntryType.UI_INPUT_END, 1298576383, a);
        }
    }

    private static <T extends View> void m1054a(Class<T> cls, T t) {
        m1055a((Object) t, t.getContext());
    }

    private static void m1055a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((ProfileRefresherView) obj).m1053a(AllCapsTransformationMethod.b(fbInjector), (QeAccessor) QeInternalImplMethodAutoProvider.a(fbInjector));
    }

    public ProfileRefresherView(Context context) {
        super(context);
        m1056b();
    }

    public ProfileRefresherView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m1056b();
    }

    private void m1056b() {
        m1054a(ProfileRefresherView.class, (View) this);
        setContentView(2130906474);
        setClickable(true);
        this.f1057q = this.f1043c.a(ExperimentsForTimelineAbTestModule.aG, false);
        m1057c();
    }

    private void m1057c() {
        this.f1046f = (FbTextView) a(2131566386);
        this.f1045e = (ViewStub) a(2131566387);
        this.f1047g = (FbTextView) a(2131566388);
        this.f1053m = (FrameLayout) a(2131566389);
        this.f1054n = (LinearLayout) a(2131566385);
        ViewStub viewStub = (ViewStub) a(2131566404);
        if (this.f1057q) {
            viewStub.setLayoutResource(2130906467);
            this.f1051k = viewStub.inflate();
            this.f1050j = (FbButton) a(2131566390);
        } else {
            viewStub.setLayoutResource(2130906468);
            this.f1051k = viewStub.inflate();
            this.f1048h = (FbButton) a(2131566391);
            this.f1048h.setTransformationMethod(this.f1042b);
            this.f1049i = (FbButton) a(2131566392);
            this.f1049i.setTransformationMethod(this.f1042b);
        }
        this.f1055o = (LoadingIndicatorView) a(2131560537);
    }

    private void m1053a(AllCapsTransformationMethod allCapsTransformationMethod, QeAccessor qeAccessor) {
        this.f1042b = allCapsTransformationMethod;
        this.f1043c = qeAccessor;
    }

    public final void m1061a(FragmentManager fragmentManager, ProfileRefresherModel profileRefresherModel, Bundle bundle) {
        Fragment a;
        Object obj;
        List arrayList = new ArrayList();
        Map hashMap = new HashMap();
        Map hashMap2 = new HashMap();
        if (profileRefresherModel.m1028b(GraphQLProfileWizardStepType.PROFILE_PICTURE) || profileRefresherModel.m1028b(GraphQLProfileWizardStepType.COVER_PHOTO)) {
            a = ProfileRefresherPagerAdapterFactory.m1040a(fragmentManager, bundle, "nux_refresher_header_fragment");
            if (a instanceof ProfileRefresherHeaderFragment) {
                obj = (ProfileRefresherHeaderFragment) a;
            } else {
                obj = new ProfileRefresherHeaderFragment();
            }
            arrayList.add(obj);
            hashMap.put(GraphQLProfileWizardStepType.PROFILE_PICTURE, obj);
            hashMap.put(GraphQLProfileWizardStepType.COVER_PHOTO, obj);
            hashMap2.put(GraphQLProfileWizardStepType.PROFILE_PICTURE, Integer.valueOf(arrayList.size() - 1));
            hashMap2.put(GraphQLProfileWizardStepType.COVER_PHOTO, Integer.valueOf(arrayList.size() - 1));
        }
        if (profileRefresherModel.m1028b(GraphQLProfileWizardStepType.CORE_PROFILE_FIELD)) {
            a = ProfileRefresherPagerAdapterFactory.m1040a(fragmentManager, bundle, "nux_refresher_info_fragment");
            if (a instanceof ProfileRefresherInfoFragment) {
                obj = (ProfileRefresherInfoFragment) a;
            } else {
                obj = new ProfileRefresherInfoFragment();
            }
            arrayList.add(obj);
            hashMap.put(GraphQLProfileWizardStepType.CORE_PROFILE_FIELD, obj);
            hashMap2.put(GraphQLProfileWizardStepType.CORE_PROFILE_FIELD, Integer.valueOf(arrayList.size() - 1));
        }
        if (profileRefresherModel.m1028b(GraphQLProfileWizardStepType.COMPOSER)) {
            a = ProfileRefresherPagerAdapterFactory.m1040a(fragmentManager, bundle, "nux_refresher_composer_fragment");
            if (a instanceof ProfileNuxComposerFragment) {
                obj = (ProfileNuxComposerFragment) a;
            } else {
                obj = new ProfileNuxComposerFragment();
                Bundle bundle2 = new Bundle();
                FlatBufferModelHelper.a(bundle2, "post_item_privacy", profileRefresherModel.f1019g);
                obj.g(bundle2);
            }
            arrayList.add(obj);
            hashMap.put(GraphQLProfileWizardStepType.COMPOSER, obj);
            hashMap2.put(GraphQLProfileWizardStepType.COMPOSER, Integer.valueOf(arrayList.size() - 1));
        }
        a = ProfileRefresherPagerAdapterFactory.m1040a(fragmentManager, bundle, "nux_refresher_finished_fragment");
        if (a instanceof ProfileRefresherFinishedFragment) {
            obj = (ProfileRefresherFinishedFragment) a;
        } else {
            obj = new ProfileRefresherFinishedFragment();
        }
        arrayList.add(obj);
        hashMap.put(null, obj);
        hashMap2.put(null, Integer.valueOf(arrayList.size() - 1));
        this.f1052l = new ProfileRefresherPagerAdapter(fragmentManager, arrayList, hashMap, hashMap2);
    }

    public void setListener(EventListener eventListener) {
        this.f1056p = eventListener;
        m1058d();
        m1059e();
    }

    private void m1058d() {
        this.f1051k.setVisibility(8);
        if (this.f1057q) {
            this.f1050j.setOnClickListener(new C01053(this));
            return;
        }
        this.f1048h.setOnClickListener(new C01064(this));
        this.f1049i.setOnClickListener(new C01075(this));
    }

    private void m1059e() {
        FbTitleBarUtil.a(this);
        this.f1044d = (FbTitleBar) a(2131558563);
        this.f1044d.a(this.f1058r);
        this.f1044d.setOnToolbarButtonListener(this.f1059s);
    }

    public void setName(String str) {
        this.f1044d.setTitle(str);
    }

    public void setTitleBarButtonSpecs(List<TitleBarButtonSpec> list) {
        this.f1044d.setButtonSpecs(list);
    }

    public void setTitleBarButtonListener(OnToolbarButtonListener onToolbarButtonListener) {
        this.f1044d.setOnToolbarButtonListener(onToolbarButtonListener);
    }

    public final void m1060a() {
        if (this.f1050j != null) {
            this.f1050j.setText(getContext().getString(2131235048));
        }
    }

    public View getPhotoBar() {
        return this.f1051k;
    }

    public ProfileRefresherPagerAdapter getAdapter() {
        return this.f1052l;
    }

    public FbTextView getStepTitleTextView() {
        return this.f1046f;
    }

    public FbTextView getStepDescriptionTextView() {
        return this.f1047g;
    }

    public ViewStub getProgressBarViewStub() {
        return this.f1045e;
    }

    public OnToolbarButtonListener getSkipListener() {
        return this.f1059s;
    }

    public FrameLayout getHolder() {
        return this.f1053m;
    }

    public LinearLayout getStepTextLayout() {
        return this.f1054n;
    }

    public LoadingIndicatorView getLoadingIndicatorView() {
        return this.f1055o;
    }
}

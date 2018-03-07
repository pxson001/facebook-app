package com.facebook.adinterfaces.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent.IntentHandler;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ServerValidationRequestEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.TargetingChangedEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.TargetingValidationEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.TargetingValidationEventSubscriber;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesDataValidation;
import com.facebook.adinterfaces.model.AdInterfacesTargetingData;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.InterestModel;
import com.facebook.adinterfaces.ui.AdInterfacesAgeTargetingView.OnAgeRangeChangeListener;
import com.facebook.adinterfaces.ui.AdInterfacesGenderView.Gender;
import com.facebook.adinterfaces.ui.selector.TargetingSelectorActivityHelper;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil;
import com.facebook.common.util.StringUtil.StringProcessor;
import com.facebook.content.event.FbEvent;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLAdsTargetingGender;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VIDEO_EDIT */
public class AdInterfacesBaseTargetingViewController<T extends AdInterfacesBaseTargetingView, D extends AdInterfacesDataModel> extends BaseAdInterfacesViewController<T, D> {
    protected static final StringProcessor f22575h = new C25821();
    protected static final StringProcessor f22576i = new C25832();
    protected BaseAdInterfacesData f22577a;
    protected ImmutableList<GeoLocationModel> f22578b = RegularImmutableList.a;
    protected ImmutableList<GeoLocationModel> f22579c = RegularImmutableList.a;
    protected ImmutableList<InterestModel> f22580d = RegularImmutableList.a;
    public T f22581e;
    public AdInterfacesCardLayout f22582f;
    protected AdInterfacesDataHelper f22583g;

    /* compiled from: VIDEO_EDIT */
    public /* synthetic */ class AnonymousClass10 {
        public static final /* synthetic */ int[] f22566a = new int[GraphQLAdsTargetingGender.values().length];

        static {
            f22567b = new int[Gender.values().length];
            try {
                f22567b[Gender.MALE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22567b[Gender.FEMALE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f22566a[GraphQLAdsTargetingGender.ALL.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f22566a[GraphQLAdsTargetingGender.MALE.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f22566a[GraphQLAdsTargetingGender.FEMALE.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    /* compiled from: VIDEO_EDIT */
    final class C25821 implements StringProcessor {
        C25821() {
        }

        public final String m24432a(Object obj) {
            return ((GeoLocationModel) obj).m23443j();
        }
    }

    /* compiled from: VIDEO_EDIT */
    final class C25832 implements StringProcessor {
        C25832() {
        }

        public final String m24433a(Object obj) {
            return ((InterestModel) obj).m23464k();
        }
    }

    /* compiled from: VIDEO_EDIT */
    class C25843 implements OnCheckedChangeListener {
        final /* synthetic */ AdInterfacesBaseTargetingViewController f22568a;

        C25843(AdInterfacesBaseTargetingViewController adInterfacesBaseTargetingViewController) {
            this.f22568a = adInterfacesBaseTargetingViewController;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            this.f22568a.m24447b();
        }
    }

    /* compiled from: VIDEO_EDIT */
    class C25854 implements OnClickListener {
        final /* synthetic */ AdInterfacesBaseTargetingViewController f22569a;

        C25854(AdInterfacesBaseTargetingViewController adInterfacesBaseTargetingViewController) {
            this.f22569a = adInterfacesBaseTargetingViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 266337378);
            this.f22569a.f22440b.m22429a(new IntentEvent(TargetingSelectorActivityHelper.m25224a(this.f22569a.f22581e.getContext(), this.f22569a.f22579c, this.f22569a.f22578b), 0));
            Logger.a(2, EntryType.UI_INPUT_END, 1239120176, a);
        }
    }

    /* compiled from: VIDEO_EDIT */
    class C25865 implements OnClickListener {
        final /* synthetic */ AdInterfacesBaseTargetingViewController f22570a;

        C25865(AdInterfacesBaseTargetingViewController adInterfacesBaseTargetingViewController) {
            this.f22570a = adInterfacesBaseTargetingViewController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -357605023);
            this.f22570a.f22440b.m22429a(new IntentEvent(TargetingSelectorActivityHelper.m25223a(this.f22570a.f22581e.getContext(), this.f22570a.f22580d), 1));
            Logger.a(2, EntryType.UI_INPUT_END, -647196976, a);
        }
    }

    /* compiled from: VIDEO_EDIT */
    class C25876 implements OnAgeRangeChangeListener {
        final /* synthetic */ AdInterfacesBaseTargetingViewController f22571a;

        C25876(AdInterfacesBaseTargetingViewController adInterfacesBaseTargetingViewController) {
            this.f22571a = adInterfacesBaseTargetingViewController;
        }

        public final void mo989a() {
            this.f22571a.m24447b();
        }
    }

    /* compiled from: VIDEO_EDIT */
    class C25887 implements IntentHandler {
        final /* synthetic */ AdInterfacesBaseTargetingViewController f22572a;

        C25887(AdInterfacesBaseTargetingViewController adInterfacesBaseTargetingViewController) {
            this.f22572a = adInterfacesBaseTargetingViewController;
        }

        public final void mo980a(int i, Intent intent) {
            if (i == -1) {
                Collection collection = (ArrayList) FlatBufferModelHelper.b(intent, "selectedTokens");
                AdInterfacesBaseTargetingViewController adInterfacesBaseTargetingViewController = this.f22572a;
                if (collection == null) {
                    collection = Collections.EMPTY_LIST;
                }
                adInterfacesBaseTargetingViewController.f22578b = ImmutableList.copyOf(collection);
                this.f22572a.f22581e.m24429a(this.f22572a.f22578b, AdInterfacesBaseTargetingViewController.f22575h);
                this.f22572a.f22579c = ImmutableList.copyOf(this.f22572a.f22578b);
                this.f22572a.m24447b();
                AdInterfacesUiUtil.m25234a(this.f22572a.f22582f);
            }
        }
    }

    /* compiled from: VIDEO_EDIT */
    class C25898 implements IntentHandler {
        final /* synthetic */ AdInterfacesBaseTargetingViewController f22573a;

        C25898(AdInterfacesBaseTargetingViewController adInterfacesBaseTargetingViewController) {
            this.f22573a = adInterfacesBaseTargetingViewController;
        }

        public final void mo980a(int i, Intent intent) {
            if (i == -1) {
                Collection collection = (ArrayList) FlatBufferModelHelper.b(intent, "selectedTokens");
                AdInterfacesBaseTargetingViewController adInterfacesBaseTargetingViewController = this.f22573a;
                if (collection == null) {
                    collection = Collections.EMPTY_LIST;
                }
                adInterfacesBaseTargetingViewController.f22580d = ImmutableList.copyOf(collection);
                this.f22573a.f22581e.m24431b(this.f22573a.f22580d, AdInterfacesBaseTargetingViewController.f22576i);
                this.f22573a.m24447b();
                AdInterfacesUiUtil.m25234a(this.f22573a.f22582f);
            }
        }
    }

    /* compiled from: VIDEO_EDIT */
    class C25909 extends TargetingValidationEventSubscriber {
        final /* synthetic */ AdInterfacesBaseTargetingViewController f22574a;

        C25909(AdInterfacesBaseTargetingViewController adInterfacesBaseTargetingViewController) {
            this.f22574a = adInterfacesBaseTargetingViewController;
        }

        public final void m24437b(FbEvent fbEvent) {
            this.f22574a.f22582f.m24584a(((TargetingValidationEvent) fbEvent).f21655a);
        }
    }

    private static AdInterfacesBaseTargetingViewController m24439b(InjectorLike injectorLike) {
        return new AdInterfacesBaseTargetingViewController(AdInterfacesDataHelper.m22789a(injectorLike));
    }

    protected void mo991e() {
        this.f22440b.m22428a(0, new C25887(this));
        this.f22440b.m22428a(1, new C25898(this));
        this.f22440b.m22430a(new C25909(this));
    }

    @Inject
    public AdInterfacesBaseTargetingViewController(AdInterfacesDataHelper adInterfacesDataHelper) {
        this.f22583g = adInterfacesDataHelper;
    }

    public void mo983a(D d) {
        this.f22577a = d;
    }

    public void mo990a(T t, AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo982a(t, adInterfacesCardLayout);
        this.f22581e = t;
        this.f22582f = adInterfacesCardLayout;
        m24438a(this.f22582f);
    }

    protected final void m24446a(boolean z) {
        if (z) {
            this.f22581e.setGenderViewVisibility(0);
            this.f22581e.f22558f.setOnCheckedChangeListener(new C25843(this));
            return;
        }
        this.f22581e.setGenderViewVisibility(8);
    }

    protected void mo993b(boolean z) {
        if (z) {
            this.f22581e.setLocationsSelectorVisibility(0);
            AdInterfacesBaseTargetingView adInterfacesBaseTargetingView = this.f22581e;
            adInterfacesBaseTargetingView.f22561i.setOnClickListener(new C25854(this));
            return;
        }
        this.f22581e.setLocationsSelectorVisibility(8);
    }

    protected final void m24451c(boolean z) {
        if (z) {
            this.f22581e.setInterestsSelectorVisibility(0);
            AdInterfacesBaseTargetingView adInterfacesBaseTargetingView = this.f22581e;
            adInterfacesBaseTargetingView.f22563k.setOnClickListener(new C25865(this));
            return;
        }
        this.f22581e.setInterestsSelectorVisibility(8);
    }

    protected final void m24453d(boolean z) {
        int i;
        int i2 = 0;
        AdInterfacesBaseTargetingView adInterfacesBaseTargetingView = this.f22581e;
        if (z) {
            i = 0;
        } else {
            i = 8;
        }
        adInterfacesBaseTargetingView.f22554b.setVisibility(i);
        adInterfacesBaseTargetingView.f22556d.setVisibility(i);
        AdInterfacesBaseTargetingView adInterfacesBaseTargetingView2 = this.f22581e;
        if (!z) {
            i2 = 8;
        }
        adInterfacesBaseTargetingView2.setAgeViewTopDividerVisibility(i2);
        if (z) {
            this.f22581e.f22554b.f22544h = new C25876(this);
        }
    }

    protected static void m24438a(AdInterfacesCardLayout adInterfacesCardLayout) {
        adInterfacesCardLayout.m24585a(adInterfacesCardLayout.getResources().getString(2131233884), 2130843648);
    }

    protected final void m24447b() {
        this.f22577a.f21754j = mo1012c();
        this.f22440b.m22429a(new TargetingChangedEvent(this.f22577a.f21754j));
        this.f22440b.m22429a(new ServerValidationRequestEvent());
        m24452d();
    }

    @Nullable
    public AdInterfacesTargetingData mo1012c() {
        GraphQLAdsTargetingGender graphQLAdsTargetingGender;
        switch (this.f22581e.f22558f.getSelectedGender()) {
            case MALE:
                graphQLAdsTargetingGender = GraphQLAdsTargetingGender.MALE;
                break;
            case FEMALE:
                graphQLAdsTargetingGender = GraphQLAdsTargetingGender.FEMALE;
                break;
            default:
                graphQLAdsTargetingGender = GraphQLAdsTargetingGender.ALL;
                break;
        }
        return new AdInterfacesTargetingData(graphQLAdsTargetingGender, this.f22581e.f22554b.f22539c, this.f22581e.f22554b.f22540d, this.f22579c, this.f22578b, this.f22580d, this.f22577a.f21754j.f21728h, this.f22577a.f21754j.f21729i);
    }

    protected final void m24452d() {
        if (AdInterfacesDataHelper.m22814j(this.f22577a) && (this.f22577a instanceof AdInterfacesBoostedComponentDataModel) && this.f22577a.mo962b() != ObjectiveType.LOCAL_AWARENESS) {
            this.f22440b.m22431a(AdInterfacesDataValidation.UNEDITED_DATA, AdInterfacesDataHelper.m22804c((AdInterfacesBoostedComponentDataModel) this.f22577a));
        }
    }

    protected final void m24455e(boolean z) {
        if (z) {
            this.f22581e.getAudienceOptionsView().setVisibility(0);
        } else {
            this.f22581e.getAudienceOptionsView().setVisibility(8);
        }
    }

    protected final void m24443a(AdInterfacesTargetingData adInterfacesTargetingData) {
        if (adInterfacesTargetingData != null) {
            this.f22577a.f21754j = adInterfacesTargetingData;
            if (adInterfacesTargetingData.f21724d != null) {
                this.f22579c = adInterfacesTargetingData.f21724d;
            }
            if (adInterfacesTargetingData.f21725e != null) {
                ImmutableList copyOf = ImmutableList.copyOf(adInterfacesTargetingData.f21725e);
                this.f22579c = copyOf;
                this.f22578b = copyOf;
                this.f22581e.m24429a(this.f22579c, f22575h);
            }
            if (adInterfacesTargetingData.f21726f != null) {
                this.f22580d = ImmutableList.copyOf(adInterfacesTargetingData.f21726f);
                this.f22581e.m24431b(this.f22580d, f22576i);
            }
            this.f22581e.f22554b.m24411a(13, 65);
            this.f22581e.f22554b.m24412b(adInterfacesTargetingData.f21722b, adInterfacesTargetingData.f21723c);
            switch (AnonymousClass10.f22566a[adInterfacesTargetingData.f21721a.ordinal()]) {
                case 1:
                    this.f22581e.f22558f.setGender(Gender.ALL);
                    break;
                case 2:
                    this.f22581e.f22558f.setGender(Gender.MALE);
                    break;
                case 3:
                    this.f22581e.f22558f.setGender(Gender.FEMALE);
                    break;
            }
        }
    }

    public void mo981a() {
        super.mo981a();
        this.f22582f = null;
        this.f22581e = null;
    }

    public void mo984a(Bundle bundle) {
        bundle.putParcelable("targeting_data", mo1012c());
        super.mo984a(bundle);
    }

    public void mo985b(@Nullable Bundle bundle) {
        if (bundle != null) {
            m24443a((AdInterfacesTargetingData) bundle.getParcelable("targeting_data"));
            super.mo985b(bundle);
        }
    }
}

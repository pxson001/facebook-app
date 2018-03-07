package com.facebook.adinterfaces.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidatePreviewEvent;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.events.AdInterfacesBoostEventDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel;
import com.facebook.adinterfaces.ui.AdInterfacesBoostTypeRadioGroupView.OnCheckChangeListener;
import com.facebook.fbui.widget.contentview.CheckedContentView;
import com.facebook.graphql.calls.BoostedComponentCreateInputData.EventSpec.EventBoostType;
import com.google.common.collect.ImmutableList;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: V2_RECENT_VIDEO */
public class AdInterfacesEventBoostTypeRadioGroupViewController extends BaseAdInterfacesViewController<AdInterfacesBoostTypeRadioGroupView, AdInterfacesBoostEventDataModel> {
    public ImmutableList<EventBoostType> f22714a = ImmutableList.copyOf(EventBoostType.values());
    public AdInterfacesBoostEventDataModel f22715b;
    private AdInterfacesBoostTypeRadioGroupView f22716c;
    private Resources f22717d;

    /* compiled from: V2_RECENT_VIDEO */
    class C26221 implements OnCheckChangeListener {
        final /* synthetic */ AdInterfacesEventBoostTypeRadioGroupViewController f22712a;

        C26221(AdInterfacesEventBoostTypeRadioGroupViewController adInterfacesEventBoostTypeRadioGroupViewController) {
            this.f22712a = adInterfacesEventBoostTypeRadioGroupViewController;
        }

        public final void mo1011a(int i) {
            BaseAdInterfacesViewController baseAdInterfacesViewController = this.f22712a;
            baseAdInterfacesViewController.f22715b.f21806b = (EventBoostType) this.f22712a.f22714a.get(i);
            baseAdInterfacesViewController.f22440b.m22429a(new InvalidatePreviewEvent());
        }
    }

    /* compiled from: V2_RECENT_VIDEO */
    /* synthetic */ class C26232 {
        static final /* synthetic */ int[] f22713a = new int[EventBoostType.values().length];

        static {
            try {
                f22713a[EventBoostType.RSVP.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f22713a[EventBoostType.TICKET.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public final void mo982a(View view, AdInterfacesCardLayout adInterfacesCardLayout) {
        AdInterfacesBoostTypeRadioGroupView adInterfacesBoostTypeRadioGroupView = (AdInterfacesBoostTypeRadioGroupView) view;
        super.mo982a(adInterfacesBoostTypeRadioGroupView, adInterfacesCardLayout);
        this.f22716c = adInterfacesBoostTypeRadioGroupView;
        this.f22716c.setSelected(this.f22715b.f21806b.ordinal());
        adInterfacesCardLayout.setHeaderTitleResource(2131234106);
        this.f22716c.f22607b = new C26221(this);
        for (int i = 0; i < this.f22714a.size(); i++) {
            EventBoostType eventBoostType = (EventBoostType) this.f22714a.get(i);
            CheckedContentView d = this.f22716c.m24533d(i);
            d.setTitleText(m24639a(eventBoostType));
            d.setSubtitleText(m24640b(eventBoostType));
        }
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22715b = (AdInterfacesBoostEventDataModel) baseAdInterfacesData;
    }

    @Inject
    public AdInterfacesEventBoostTypeRadioGroupViewController(Resources resources) {
        this.f22717d = resources;
    }

    private String m24639a(EventBoostType eventBoostType) {
        switch (C26232.f22713a[eventBoostType.ordinal()]) {
            case 1:
                return this.f22717d.getString(2131234101);
            case 2:
                return this.f22717d.getString(2131234102);
            default:
                throw new IllegalArgumentException("Unknown boost types");
        }
    }

    private String m24640b(EventBoostType eventBoostType) {
        switch (C26232.f22713a[eventBoostType.ordinal()]) {
            case 1:
                return this.f22717d.getString(2131234103);
            case 2:
                String str;
                Resources resources = this.f22717d;
                Object[] objArr = new Object[1];
                StoryPromotionModel storyPromotionModel = this.f22715b.f21780a;
                if (storyPromotionModel == null || storyPromotionModel.m23714m() == null) {
                    str = null;
                } else {
                    str = storyPromotionModel.m23714m().m23427a();
                }
                objArr[0] = str;
                return resources.getString(2131234104, objArr);
            default:
                throw new IllegalArgumentException("Unknown boost types");
        }
    }

    public final void mo984a(Bundle bundle) {
        super.mo984a(bundle);
        bundle.putInt("BOOST_EVENT_TYPE", this.f22716c.f22608c);
    }

    public final void mo985b(@Nullable Bundle bundle) {
        super.mo985b(bundle);
        if (bundle != null) {
            this.f22716c.setSelected(bundle.getInt("BOOST_EVENT_TYPE"));
        }
    }
}

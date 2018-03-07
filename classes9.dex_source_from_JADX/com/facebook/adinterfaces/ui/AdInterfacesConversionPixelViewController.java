package com.facebook.adinterfaces.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedAdAccountChangeEventSubscriber;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.ConversionPixelModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionInfoModel;
import com.facebook.adinterfaces.ui.AdInterfacesSpinnerAdapter.SpinnerAdapterItem;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.google.common.collect.ImmutableList;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VA */
public class AdInterfacesConversionPixelViewController extends BaseAdInterfacesViewController<AdInterfacesSpinnerView, AdInterfacesBoostPostDataModel> {
    public AdInterfacesBoostPostDataModel f22664a;
    private AdInterfacesSpinnerAdapterProvider f22665b;
    public AdInterfacesSpinnerView f22666c;
    public ImmutableList<ConversionPixelModel> f22667d;
    private AdInterfacesCardLayout f22668e;

    /* compiled from: VA */
    class C26091 implements OnItemSelectedListener {
        final /* synthetic */ AdInterfacesConversionPixelViewController f22662a;

        C26091(AdInterfacesConversionPixelViewController adInterfacesConversionPixelViewController) {
            this.f22662a = adInterfacesConversionPixelViewController;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.f22662a.f22666c.m24924a()) {
                if (i > this.f22662a.f22667d.size()) {
                    i = 0;
                }
                if (i == 0) {
                    this.f22662a.f22664a.f21784e = null;
                    return;
                }
                this.f22662a.f22664a.f21784e = ((ConversionPixelModel) this.f22662a.f22667d.get(i - 1)).m23411j();
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* compiled from: VA */
    public class C26102 extends SelectedAdAccountChangeEventSubscriber {
        final /* synthetic */ AdInterfacesConversionPixelViewController f22663a;

        public C26102(AdInterfacesConversionPixelViewController adInterfacesConversionPixelViewController) {
            this.f22663a = adInterfacesConversionPixelViewController;
        }

        public final void m24589b(FbEvent fbEvent) {
            this.f22663a.f22664a.f21784e = null;
            this.f22663a.f22667d = AdInterfacesDataHelper.m22806e(this.f22663a.f22664a).m23143q();
            AdInterfacesConversionPixelViewController.m24590b(this.f22663a);
        }
    }

    public final void mo982a(View view, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        AdInterfacesSpinnerView adInterfacesSpinnerView = (AdInterfacesSpinnerView) view;
        super.mo982a(adInterfacesSpinnerView, adInterfacesCardLayout);
        this.f22666c = adInterfacesSpinnerView;
        this.f22668e = adInterfacesCardLayout;
        AdInterfacesStatus adInterfacesStatus = this.f22664a.f21748d;
        this.f22440b.m22430a(new C26102(this));
        StoryPromotionInfoModel l = this.f22664a.f21780a.m23713l();
        if (adInterfacesStatus == AdInterfacesStatus.ACTIVE || adInterfacesStatus == AdInterfacesStatus.PENDING || adInterfacesStatus == AdInterfacesStatus.EXTENDABLE || adInterfacesStatus == AdInterfacesStatus.PAUSED) {
            ConversionPixelModel p = l.m23673p();
            this.f22666c.m24923a(p.m23412k(), p.m23413l());
        } else if (adInterfacesStatus == AdInterfacesStatus.INACTIVE || adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED) {
            this.f22667d = AdInterfacesDataHelper.m22806e(this.f22664a).m23143q();
            m24590b(this);
        }
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22664a = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
    }

    @Inject
    public AdInterfacesConversionPixelViewController(AdInterfacesSpinnerAdapterProvider adInterfacesSpinnerAdapterProvider) {
        this.f22665b = adInterfacesSpinnerAdapterProvider;
    }

    public static void m24590b(AdInterfacesConversionPixelViewController adInterfacesConversionPixelViewController) {
        if (adInterfacesConversionPixelViewController.f22667d == null || adInterfacesConversionPixelViewController.f22667d.isEmpty()) {
            adInterfacesConversionPixelViewController.f22668e.setVisibility(8);
            return;
        }
        adInterfacesConversionPixelViewController.f22668e.setVisibility(0);
        List linkedList = new LinkedList();
        String string = adInterfacesConversionPixelViewController.f22666c.getResources().getString(2131233888);
        linkedList.add(new SpinnerAdapterItem(string, null, string));
        int size = adInterfacesConversionPixelViewController.f22667d.size();
        for (int i = 0; i < size; i++) {
            ConversionPixelModel conversionPixelModel = (ConversionPixelModel) adInterfacesConversionPixelViewController.f22667d.get(i);
            linkedList.add(new SpinnerAdapterItem(conversionPixelModel.m23412k(), conversionPixelModel.m23413l(), conversionPixelModel.m23412k()));
        }
        adInterfacesConversionPixelViewController.f22666c.m24922a(adInterfacesConversionPixelViewController.f22665b.m24920a(linkedList), new C26091(adInterfacesConversionPixelViewController));
    }

    public final void mo981a() {
        super.mo981a();
        this.f22664a = null;
        this.f22664a = null;
        this.f22666c = null;
        this.f22668e = null;
        this.f22667d = null;
    }

    public final void mo984a(Bundle bundle) {
        bundle.putString("selected_conversion_pixel_id", this.f22664a.f21784e);
    }

    public final void mo985b(@Nullable Bundle bundle) {
        if (bundle != null) {
            int i;
            String string = bundle.getString("selected_conversion_pixel_id");
            this.f22664a.f21784e = string;
            if (string == null) {
                i = -1;
            } else {
                i = 0;
                while (i < this.f22667d.size()) {
                    if (this.f22667d.get(i) != null && StringUtil.a(((ConversionPixelModel) this.f22667d.get(i)).m23411j(), string)) {
                        break;
                    }
                    i++;
                }
                i = -1;
            }
            int i2 = i;
            if (i2 == -1) {
                this.f22664a.f21784e = null;
                this.f22666c.setSelected(0);
                return;
            }
            this.f22666c.setSelected(i2 + 1);
        }
    }
}

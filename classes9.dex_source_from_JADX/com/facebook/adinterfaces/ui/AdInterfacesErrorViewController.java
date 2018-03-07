package com.facebook.adinterfaces.ui;

import android.text.method.LinkMovementMethod;
import android.view.View;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ErrorMessageEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.ErrorMessageEventSubscriber;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountModel;
import com.facebook.adinterfaces.util.AdInterfacesHelper;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil;
import com.facebook.common.unicode.CodePointRange;
import com.facebook.common.unicode.CodePointRangeTarget;
import com.facebook.content.event.FbEvent;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: V2_RECENT_VIDEOS */
public class AdInterfacesErrorViewController extends BaseAdInterfacesViewController<TextWithEntitiesView, AdInterfacesDataModel> {
    private BaseAdInterfacesData f22707a;
    public TextWithEntitiesView f22708b;
    public AdInterfacesCardLayout f22709c;
    private AdAccountModel f22710d;
    public AdInterfacesHelper f22711e;

    /* compiled from: V2_RECENT_VIDEOS */
    public class C26201 extends ErrorMessageEventSubscriber {
        final /* synthetic */ AdInterfacesErrorViewController f22705a;

        public C26201(AdInterfacesErrorViewController adInterfacesErrorViewController) {
            this.f22705a = adInterfacesErrorViewController;
        }

        public final void m24630b(FbEvent fbEvent) {
            ErrorMessageEvent errorMessageEvent = (ErrorMessageEvent) fbEvent;
            AdInterfacesHelper.m25228a(this.f22705a.f22708b, this.f22705a.f22709c, 0);
            this.f22705a.f22708b.setText(errorMessageEvent.f21664a);
            AdInterfacesUiUtil.m25234a(this.f22705a.f22708b);
        }
    }

    public static AdInterfacesErrorViewController m24633b(InjectorLike injectorLike) {
        return new AdInterfacesErrorViewController(AdInterfacesHelper.m25227a(injectorLike));
    }

    public final void mo982a(View view, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        TextWithEntitiesView textWithEntitiesView = (TextWithEntitiesView) view;
        super.mo982a(textWithEntitiesView, adInterfacesCardLayout);
        AdInterfacesStatus adInterfacesStatus = this.f22707a.f21748d;
        this.f22708b = textWithEntitiesView;
        this.f22709c = adInterfacesCardLayout;
        this.f22440b.m22430a(new C26201(this));
        if (AdInterfacesDataHelper.m22812h(this.f22707a)) {
            switch (adInterfacesStatus) {
                case ACTIVE:
                case PENDING:
                    AdAccountModel adAccountModel = this.f22710d;
                    Object obj = null;
                    if (!(adAccountModel == null || adAccountModel.m23151y() == null || adAccountModel.m23151y().m23103a() == null || adAccountModel.m23151y().m23105j() == null || Long.valueOf(Long.parseLong(adAccountModel.m23151y().m23103a().m23091a())).compareTo(Long.valueOf(Long.parseLong(adAccountModel.m23151y().m23105j().m23100a()))) != 0)) {
                        obj = 1;
                    }
                    if (obj != null) {
                        m24634c();
                        return;
                    }
                    return;
                case REJECTED:
                    AdInterfacesHelper.m25228a(textWithEntitiesView, adInterfacesCardLayout, 0);
                    m24632a(textWithEntitiesView);
                    return;
                case UNSET_OR_UNRECOGNIZED_ENUM_VALUE:
                    return;
                default:
                    return;
            }
        }
        AdInterfacesHelper.m25228a(this.f22708b, this.f22709c, 0);
        this.f22708b.setText(this.f22711e.m25230a(2131233872, "https://m.facebook.com/ads/manage/accounts/?select", this.f22708b, this.f22440b));
    }

    @Inject
    public AdInterfacesErrorViewController(AdInterfacesHelper adInterfacesHelper) {
        this.f22711e = adInterfacesHelper;
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22707a = baseAdInterfacesData;
        this.f22710d = AdInterfacesDataHelper.m22806e(this.f22707a);
    }

    public static AdInterfacesErrorViewController m24631a(InjectorLike injectorLike) {
        return m24633b(injectorLike);
    }

    private void m24634c() {
        AdInterfacesHelper.m25228a(this.f22708b, this.f22709c, 0);
        this.f22708b.setText(this.f22711e.m25230a(2131233871, "https://m.facebook.com/ads/manage/billing?account_id=" + this.f22710d.m23146t(), this.f22708b, this.f22440b));
    }

    private void m24632a(TextWithEntitiesView textWithEntitiesView) {
        DefaultTextWithEntitiesLongFields m = this.f22707a.mo954m();
        if (m != null) {
            String a = m.a();
            List a2 = Lists.a();
            if (m.b() != null) {
                ImmutableList b = m.b();
                int size = b.size();
                for (int i = 0; i < size; i++) {
                    Ranges ranges = (Ranges) b.get(i);
                    Object obj = null;
                    if (!(ranges.a() == null || ranges.a().D_() == null)) {
                        obj = ranges.a().D_();
                    }
                    a2.add(new CodePointRangeTarget(new CodePointRange(ranges.c(), ranges.b()), obj));
                }
            }
            textWithEntitiesView.a(a, a2);
            textWithEntitiesView.setMovementMethod(LinkMovementMethod.getInstance());
            return;
        }
        textWithEntitiesView.setText(2131233881);
    }

    public final void mo981a() {
        super.mo981a();
        this.f22708b = null;
        this.f22709c = null;
    }
}

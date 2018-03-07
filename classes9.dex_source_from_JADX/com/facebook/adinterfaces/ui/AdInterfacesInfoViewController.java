package com.facebook.adinterfaces.ui;

import android.content.Intent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.IntentEvent.IntentHandler;
import com.facebook.adinterfaces.events.AdInterfacesEvents.InvalidateEvent;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountModel;
import com.facebook.adinterfaces.util.AdInterfacesHelper;
import com.facebook.adinterfaces.util.PaymentsHelper;
import com.facebook.fbservice.ops.DialogBasedProgressIndicator;
import com.facebook.inject.InjectorLike;
import com.facebook.widget.text.textwithentitiesview.TextWithEntitiesView;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VERIFICATION_REASON_RISK */
public class AdInterfacesInfoViewController extends BaseAdInterfacesViewController<TextWithEntitiesView, AdInterfacesDataModel> {
    public TextWithEntitiesView f22597a;
    private AdInterfacesCardLayout f22598b;
    public BaseAdInterfacesData f22599c;
    private AdAccountModel f22600d;
    private AdInterfacesHelper f22601e;

    /* compiled from: VERIFICATION_REASON_RISK */
    class C26291 implements IntentHandler {
        final /* synthetic */ AdInterfacesInfoViewController f22731a;

        C26291(AdInterfacesInfoViewController adInterfacesInfoViewController) {
            this.f22731a = adInterfacesInfoViewController;
        }

        public final void mo980a(int i, Intent intent) {
            DialogBasedProgressIndicator dialogBasedProgressIndicator = new DialogBasedProgressIndicator(this.f22731a.f22597a.getContext(), this.f22731a.f22597a.getContext().getString(2131234089));
            dialogBasedProgressIndicator.a();
            this.f22731a.f22440b.m22429a(new InvalidateEvent(dialogBasedProgressIndicator));
        }
    }

    public static AdInterfacesInfoViewController m24510a(InjectorLike injectorLike) {
        return new AdInterfacesInfoViewController(AdInterfacesHelper.m25227a(injectorLike));
    }

    @Inject
    public AdInterfacesInfoViewController(AdInterfacesHelper adInterfacesHelper) {
        this.f22601e = adInterfacesHelper;
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22599c = baseAdInterfacesData;
        this.f22600d = AdInterfacesDataHelper.m22806e(this.f22599c);
    }

    public static AdInterfacesInfoViewController m24512b(InjectorLike injectorLike) {
        return m24510a(injectorLike);
    }

    public void mo1004a(TextWithEntitiesView textWithEntitiesView, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo982a(textWithEntitiesView, adInterfacesCardLayout);
        this.f22597a = textWithEntitiesView;
        this.f22598b = adInterfacesCardLayout;
        this.f22440b.m22428a(5, new C26291(this));
        if (this.f22599c.f21745a.m23196t() && this.f22599c.f21745a.m23183a().m23158a().isEmpty()) {
            m24516a(2131233868);
        } else if (!AdInterfacesDataHelper.m22811g(this.f22599c)) {
            m24516a(2131233869);
        } else if (AdInterfacesDataHelper.m22813i(this.f22599c)) {
            switch (this.f22599c.f21748d) {
                case PAUSED:
                    m24516a(2131233874);
                    if (!BudgetHelper.m25100a(this.f22599c)) {
                        m24516a(2131233875);
                        return;
                    }
                    return;
                case ACTIVE:
                    if (!BudgetHelper.m25100a(this.f22599c)) {
                        m24516a(2131233875);
                    }
                    if (PaymentsHelper.m25293b(this.f22600d)) {
                        m24513c();
                        return;
                    }
                    return;
                case PENDING:
                    m24516a(2131233877);
                    if (PaymentsHelper.m25293b(this.f22600d)) {
                        m24513c();
                        return;
                    }
                    return;
                case CREATING:
                    m24516a(2131234073);
                    return;
                case UNSET_OR_UNRECOGNIZED_ENUM_VALUE:
                    m24516a(2131234074);
                    return;
                default:
                    return;
            }
        } else {
            m24514d();
        }
    }

    public final void mo981a() {
        super.mo981a();
        this.f22599c = null;
        this.f22597a = null;
        this.f22598b = null;
    }

    protected final void m24516a(int i) {
        AdInterfacesHelper.m25228a(this.f22597a, this.f22598b, 0);
        m24511a(this.f22597a.getResources().getString(i));
    }

    private void m24511a(CharSequence charSequence) {
        AdInterfacesHelper.m25228a(this.f22597a, this.f22598b, 0);
        this.f22597a.setText(charSequence);
    }

    private void m24513c() {
        m24511a(this.f22601e.m25230a(2131233870, "https://m.facebook.com/ads/manage/billing?account_id=" + this.f22600d.m23146t(), this.f22597a, this.f22440b));
    }

    private void m24514d() {
        m24511a(this.f22601e.m25230a(2131233872, "https://m.facebook.com/ads/manage/accounts/?select", this.f22597a, this.f22440b));
    }
}

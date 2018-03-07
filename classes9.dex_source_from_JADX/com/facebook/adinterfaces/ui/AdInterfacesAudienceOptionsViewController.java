package com.facebook.adinterfaces.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.facebook.adinterfaces.AdInterfacesContext;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEvents.AudienceChangedEvent;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryBuilder;
import com.facebook.adinterfaces.protocol.FetchSavedAudiencesMethod;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: VIDEO_POST_PROCESS_COMPLETED */
public class AdInterfacesAudienceOptionsViewController extends BaseAdInterfacesViewController<AdInterfacesAudienceOptionsView, AdInterfacesDataModel> {
    private AdInterfacesAudienceOptionsView f22550a;
    private AdInterfacesSavedAudienceOptionsViewController f22551b;
    private BaseAdInterfacesData f22552c;

    /* compiled from: VIDEO_POST_PROCESS_COMPLETED */
    class C25811 implements OnCheckedChangeListener {
        final /* synthetic */ AdInterfacesAudienceOptionsViewController f22549a;

        C25811(AdInterfacesAudienceOptionsViewController adInterfacesAudienceOptionsViewController) {
            this.f22549a = adInterfacesAudienceOptionsViewController;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (((RadioButton) radioGroup.findViewById(i)).isChecked() && i != -1) {
                this.f22549a.m24417a(i, radioGroup);
            }
        }
    }

    public static AdInterfacesAudienceOptionsViewController m24419b(InjectorLike injectorLike) {
        return new AdInterfacesAudienceOptionsViewController(new AdInterfacesSavedAudienceOptionsViewController(new FetchSavedAudiencesMethod(GraphQLQueryExecutor.a(injectorLike), AdInterfacesQueryBuilder.m23051a(injectorLike)), TasksManager.b(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike)));
    }

    @Inject
    public AdInterfacesAudienceOptionsViewController(AdInterfacesSavedAudienceOptionsViewController adInterfacesSavedAudienceOptionsViewController) {
        this.f22551b = adInterfacesSavedAudienceOptionsViewController;
    }

    public final void mo988a(AdInterfacesContext adInterfacesContext) {
        super.mo988a(adInterfacesContext);
        this.f22551b.mo988a(adInterfacesContext);
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22552c = baseAdInterfacesData;
        this.f22551b.mo983a(baseAdInterfacesData);
    }

    public static AdInterfacesAudienceOptionsViewController m24416a(InjectorLike injectorLike) {
        return m24419b(injectorLike);
    }

    public final void m24426a(AdInterfacesAudienceOptionsView adInterfacesAudienceOptionsView, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo982a(adInterfacesAudienceOptionsView, adInterfacesCardLayout);
        this.f22550a = adInterfacesAudienceOptionsView;
        this.f22550a.setOnCheckChangedListener(new C25811(this));
        m24420b();
        this.f22551b.m24877a(this.f22550a, adInterfacesCardLayout);
    }

    private void m24417a(int i, RadioGroup radioGroup) {
        GraphQLBoostedPostAudienceOption graphQLBoostedPostAudienceOption;
        GraphQLBoostedPostAudienceOption graphQLBoostedPostAudienceOption2 = GraphQLBoostedPostAudienceOption.NCPP;
        if (i == AdInterfacesAudienceOptionsView.f22546b) {
            graphQLBoostedPostAudienceOption = GraphQLBoostedPostAudienceOption.GROUPER;
        } else {
            graphQLBoostedPostAudienceOption = graphQLBoostedPostAudienceOption2;
        }
        this.f22552c.f21754j.m22838a(graphQLBoostedPostAudienceOption);
        View findViewById = radioGroup.findViewById(i);
        if (findViewById instanceof AdInterfacesSavedAudienceRadioButton) {
            this.f22552c.f21754j.f21729i = ((AdInterfacesSavedAudienceRadioButton) findViewById).f22917a;
        }
        this.f22440b.m22429a(new AudienceChangedEvent(graphQLBoostedPostAudienceOption));
    }

    private void m24420b() {
        if (this.f22552c.f21748d == AdInterfacesStatus.INACTIVE || this.f22552c.f21748d == AdInterfacesStatus.NEVER_BOOSTED) {
            int i;
            AdInterfacesAudienceOptionsView adInterfacesAudienceOptionsView = this.f22550a;
            if (this.f22552c.f21745a.m23189m() == GraphQLBoostedPostAudienceOption.GROUPER) {
                i = AdInterfacesAudienceOptionsView.f22546b;
            } else {
                i = AdInterfacesAudienceOptionsView.f22545a;
            }
            adInterfacesAudienceOptionsView.m24415c(i);
        } else if (this.f22552c.f21754j != null) {
            this.f22550a.m24415c(this.f22552c.f21754j.f21728h == GraphQLBoostedPostAudienceOption.GROUPER ? AdInterfacesAudienceOptionsView.f22546b : AdInterfacesAudienceOptionsView.f22545a);
        }
    }

    public final void mo981a() {
        super.mo981a();
        this.f22551b.mo981a();
        this.f22550a = null;
    }

    public final void mo985b(@Nullable Bundle bundle) {
        super.mo985b(bundle);
        if (bundle != null && this.f22439a) {
            GraphQLBoostedPostAudienceOption graphQLBoostedPostAudienceOption = (GraphQLBoostedPostAudienceOption) bundle.getSerializable("adinterfaces_audience");
            if (graphQLBoostedPostAudienceOption != null) {
                this.f22550a.m24415c(graphQLBoostedPostAudienceOption == GraphQLBoostedPostAudienceOption.GROUPER ? AdInterfacesAudienceOptionsView.f22546b : AdInterfacesAudienceOptionsView.f22545a);
            }
        }
        this.f22551b.mo985b(bundle);
    }

    public final void mo984a(Bundle bundle) {
        super.mo984a(bundle);
        this.f22551b.mo984a(bundle);
        bundle.putSerializable("adinterfaces_audience", this.f22552c.f21754j.f21728h);
    }
}

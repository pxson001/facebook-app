package com.facebook.adinterfaces.objective;

import android.content.Intent;
import com.facebook.adinterfaces.abtest.ExperimentsForAdInterfacesModule;
import com.facebook.adinterfaces.component.AdInterfacesComponent;
import com.facebook.adinterfaces.component.AdInterfacesInlineComponent;
import com.facebook.adinterfaces.component.InsightsCardClicksComponent;
import com.facebook.adinterfaces.component.InsightsCardEngagementComponent;
import com.facebook.adinterfaces.component.InsightsCardReachComponent;
import com.facebook.adinterfaces.component.SpacerComponent;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.external.ComponentType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.AdInterfacesDataModel$AdInterfacesDataModelCallback;
import com.facebook.adinterfaces.model.AdInterfacesStatus;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.protocol.FetchInsightsMethod;
import com.facebook.adinterfaces.protocol.FetchInsightsMethod.C25461;
import com.facebook.adinterfaces.protocol.FetchInsightsMethod.Key;
import com.facebook.adinterfaces.protocol.FetchStoryPromotionInsightsQuery.FetchStoryPromotionInsightsQueryString;
import com.facebook.adinterfaces.ui.AdInterfacesInsightsBoostPostViewController;
import com.facebook.adinterfaces.ui.AdInterfacesInsightsClicksViewController;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.MoreExecutors;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: [[tap_to_view]] */
public class BoostPostInsightsObjective implements AdInterfacesObjective {
    ImmutableList<AdInterfacesComponent> f21859g;
    AdInterfacesComponentStatus f21860h = new C25241(this);
    private Provider<FetchInsightsMethod> f21861i;
    private TasksManager f21862j;
    public AdInterfacesErrorReporter f21863k;
    public QeAccessor f21864l;

    /* compiled from: [[tap_to_view]] */
    class C25241 implements AdInterfacesComponentStatus {
        final /* synthetic */ BoostPostInsightsObjective f21856a;

        C25241(BoostPostInsightsObjective boostPostInsightsObjective) {
            this.f21856a = boostPostInsightsObjective;
        }

        public final boolean mo967a(@Nullable BaseAdInterfacesData baseAdInterfacesData) {
            AdInterfacesBoostPostDataModel adInterfacesBoostPostDataModel = (AdInterfacesBoostPostDataModel) baseAdInterfacesData;
            if (adInterfacesBoostPostDataModel.f21786g == null || adInterfacesBoostPostDataModel.f21786g.getIntExtra("title", -1) == -1) {
                return false;
            }
            return (baseAdInterfacesData.f21748d == AdInterfacesStatus.INACTIVE || baseAdInterfacesData.f21748d == AdInterfacesStatus.PAUSED || baseAdInterfacesData.f21748d == AdInterfacesStatus.REJECTED || baseAdInterfacesData.f21748d == AdInterfacesStatus.ACTIVE || baseAdInterfacesData.f21748d == AdInterfacesStatus.PENDING || baseAdInterfacesData.f21748d == AdInterfacesStatus.FINISHED || baseAdInterfacesData.f21748d == AdInterfacesStatus.EXTENDABLE) ? this.f21856a.f21864l.a(ExperimentsForAdInterfacesModule.f21608e, false) : false;
        }
    }

    public static BoostPostInsightsObjective m22932b(InjectorLike injectorLike) {
        return new BoostPostInsightsObjective(IdBasedProvider.a(injectorLike, 4652), TasksManager.b(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike), new InsightsCardClicksComponent(new AdInterfacesInsightsClicksViewController(AdInterfacesDataHelper.m22789a(injectorLike))), InsightsCardEngagementComponent.m22679b(injectorLike), InsightsCardReachComponent.m22684b(injectorLike), SpacerComponent.m22703a(injectorLike), AdInterfacesInsightsBoostPostViewController.m24650a(injectorLike), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike));
    }

    @Inject
    BoostPostInsightsObjective(Provider<FetchInsightsMethod> provider, TasksManager tasksManager, AdInterfacesErrorReporter adInterfacesErrorReporter, InsightsCardClicksComponent insightsCardClicksComponent, InsightsCardEngagementComponent insightsCardEngagementComponent, InsightsCardReachComponent insightsCardReachComponent, SpacerComponent spacerComponent, AdInterfacesInsightsBoostPostViewController adInterfacesInsightsBoostPostViewController, QeAccessor qeAccessor) {
        this.f21864l = qeAccessor;
        this.f21861i = provider;
        this.f21862j = tasksManager;
        this.f21863k = adInterfacesErrorReporter;
        this.f21859g = new Builder().c(insightsCardReachComponent).c(insightsCardEngagementComponent).c(insightsCardClicksComponent).c(spacerComponent).c(new AdInterfacesInlineComponent(2130903118, adInterfacesInsightsBoostPostViewController, this.f21860h, ComponentType.FOOTER)).b();
    }

    public final ImmutableList<AdInterfacesComponent> mo968a() {
        return this.f21859g;
    }

    public final void mo969a(Intent intent, final AdInterfacesDataModel$AdInterfacesDataModelCallback adInterfacesDataModel$AdInterfacesDataModelCallback) {
        BaseAdInterfacesData baseAdInterfacesData = (BaseAdInterfacesData) intent.getParcelableExtra("data");
        if (baseAdInterfacesData != null) {
            adInterfacesDataModel$AdInterfacesDataModelCallback.mo941a(baseAdInterfacesData);
            return;
        }
        String stringExtra = intent.getStringExtra("storyId");
        Intent intent2 = (Intent) intent.getParcelableExtra("intent");
        if (stringExtra != null) {
            TasksManager tasksManager = this.f21862j;
            Key key = Key.FETCH_INSIGHTS;
            FetchInsightsMethod fetchInsightsMethod = (FetchInsightsMethod) this.f21861i.get();
            Preconditions.checkNotNull(stringExtra, "no storyId");
            tasksManager.a(key, Futures.a(fetchInsightsMethod.f22368a.a(GraphQLRequest.a((FetchStoryPromotionInsightsQueryString) new FetchStoryPromotionInsightsQueryString().a("story_id", stringExtra))), new C25461(fetchInsightsMethod, stringExtra, intent2), MoreExecutors.a()), new AbstractDisposableFutureCallback<AdInterfacesDataModel>(this) {
                final /* synthetic */ BoostPostInsightsObjective f21858b;

                protected final void m22930a(Object obj) {
                    adInterfacesDataModel$AdInterfacesDataModelCallback.mo941a((BaseAdInterfacesData) obj);
                }

                protected final void m22931a(Throwable th) {
                    this.f21858b.f21863k.m22727a(BoostPostInsightsObjective.class, "Fetch Insights failed", th);
                    adInterfacesDataModel$AdInterfacesDataModelCallback.mo941a(null);
                }
            });
        }
    }
}

package com.facebook.adinterfaces.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.events.AdInterfacesEvents.AudienceChangedEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedAdAccountChangeEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedAdAccountChangeEventSubscriber;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountAudiencesModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountAudiencesModel.AudiencesModel.NodesModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountAudiencesModel.AudiencesModel.NodesModel.TargetingSentencesModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountModel;
import com.facebook.adinterfaces.protocol.FetchSavedAudiencesMethod;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.content.event.FbEvent;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.qe.api.QeAccessor;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: Use IntentParser.fromXml() */
public class AdInterfacesSavedAudienceOptionsViewController extends BaseAdInterfacesViewController<AdInterfacesAudienceOptionsView, AdInterfacesDataModel> {
    public BaseAdInterfacesData f22904a;
    public AdInterfacesAudienceOptionsView f22905b;
    public AdInterfacesCardLayout f22906c;
    public View f22907d;
    private final QeAccessor f22908e;
    public final AdInterfacesErrorReporter f22909f;
    public List<AdInterfacesSavedAudienceRadioButton> f22910g;
    public ArrayList<NodesModel> f22911h;
    private String f22912i = null;
    private ArrayList<NodesModel> f22913j;
    private String f22914k;
    public FetchSavedAudiencesMethod f22915l;
    public TasksManager f22916m;

    /* compiled from: Use IntentParser.fromXml() */
    public class C26672 extends SelectedAdAccountChangeEventSubscriber {
        final /* synthetic */ AdInterfacesSavedAudienceOptionsViewController f22903a;

        public C26672(AdInterfacesSavedAudienceOptionsViewController adInterfacesSavedAudienceOptionsViewController) {
            this.f22903a = adInterfacesSavedAudienceOptionsViewController;
        }

        public final void m24867b(FbEvent fbEvent) {
            SelectedAdAccountChangeEvent selectedAdAccountChangeEvent = (SelectedAdAccountChangeEvent) fbEvent;
            if (!selectedAdAccountChangeEvent.f21674a.equals(selectedAdAccountChangeEvent.f21675b)) {
                if (this.f22903a.f22904a.f21754j.f21729i != null) {
                    this.f22903a.f22904a.f21754j.f21729i = null;
                    this.f22903a.f22904a.f21754j.m22838a(GraphQLBoostedPostAudienceOption.NCPP);
                    this.f22903a.f22905b.m24415c(AdInterfacesAudienceOptionsView.f22545a);
                    AdInterfacesUiUtil.m25234a(this.f22903a.f22906c);
                    this.f22903a.f22440b.m22429a(new AudienceChangedEvent(GraphQLBoostedPostAudienceOption.NCPP));
                }
                AdInterfacesSavedAudienceOptionsViewController.m24872d(this.f22903a);
            }
        }
    }

    @Inject
    public AdInterfacesSavedAudienceOptionsViewController(FetchSavedAudiencesMethod fetchSavedAudiencesMethod, TasksManager tasksManager, AdInterfacesErrorReporter adInterfacesErrorReporter, QeAccessor qeAccessor) {
        this.f22915l = fetchSavedAudiencesMethod;
        this.f22916m = tasksManager;
        this.f22909f = adInterfacesErrorReporter;
        this.f22908e = qeAccessor;
        this.f22910g = new ArrayList();
        this.f22911h = new ArrayList();
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22904a = baseAdInterfacesData;
    }

    public final void m24877a(AdInterfacesAudienceOptionsView adInterfacesAudienceOptionsView, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo982a(adInterfacesAudienceOptionsView, adInterfacesCardLayout);
        this.f22906c = adInterfacesCardLayout;
        this.f22905b = adInterfacesAudienceOptionsView;
        this.f22907d = adInterfacesAudienceOptionsView.findViewById(2131559259);
        m24872d(this);
        this.f22440b.m22430a(new C26672(this));
    }

    public final void mo984a(Bundle bundle) {
        super.mo984a(bundle);
        if (this.f22910g != null && !this.f22910g.isEmpty()) {
            for (AdInterfacesSavedAudienceRadioButton adInterfacesSavedAudienceRadioButton : this.f22910g) {
                if (adInterfacesSavedAudienceRadioButton.isChecked()) {
                    bundle.putString("savedAudienceTargeting", adInterfacesSavedAudienceRadioButton.f22917a);
                    break;
                }
            }
            if (!this.f22911h.isEmpty()) {
                bundle.putString("fetchedSavedAudienceAccount", AdInterfacesDataHelper.m22806e(this.f22904a).m23145s());
                FlatBufferModelHelper.a(bundle, "fetchedSavedAudience", this.f22911h);
            }
        }
    }

    public final void mo985b(@Nullable Bundle bundle) {
        super.mo985b(bundle);
        this.f22912i = bundle.getString("savedAudienceTargeting");
        this.f22913j = (ArrayList) FlatBufferModelHelper.b(bundle, "fetchedSavedAudience");
        this.f22914k = bundle.getString("fetchedSavedAudienceAccount");
        m24871c();
        m24868a(this.f22912i);
    }

    public static void m24870b(AdInterfacesSavedAudienceOptionsViewController adInterfacesSavedAudienceOptionsViewController) {
        adInterfacesSavedAudienceOptionsViewController.f22907d.setVisibility(adInterfacesSavedAudienceOptionsViewController.f22910g.size() < AdInterfacesDataHelper.m22806e(adInterfacesSavedAudienceOptionsViewController.f22904a).m23140n().m23074a() ? 0 : 8);
    }

    private void m24871c() {
        AdAccountModel e = AdInterfacesDataHelper.m22806e(this.f22904a);
        if (this.f22913j != null && this.f22914k.equals(e.m23145s())) {
            int size = this.f22913j.size();
            for (int i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) this.f22913j.get(i);
                this.f22911h.add(nodesModel);
                this.f22910g.add(this.f22905b.m24414a(nodesModel.m23070j(), nodesModel.m23071k(), m24869b(nodesModel)));
            }
            this.f22913j = null;
            this.f22914k = null;
            m24870b(this);
        }
    }

    private void m24868a(String str) {
        if (str != null && this.f22910g != null) {
            for (int i = 0; i < this.f22910g.size(); i++) {
                AdInterfacesSavedAudienceRadioButton adInterfacesSavedAudienceRadioButton = (AdInterfacesSavedAudienceRadioButton) this.f22910g.get(i);
                if (adInterfacesSavedAudienceRadioButton.f22917a.equals(str)) {
                    this.f22905b.m24415c(adInterfacesSavedAudienceRadioButton.getId());
                    this.f22912i = null;
                }
            }
        }
    }

    public final void mo981a() {
        super.mo981a();
        this.f22916m.c("fetch_saved_audiences_task_key");
        this.f22905b = null;
        this.f22906c = null;
        this.f22907d = null;
    }

    public static ArrayList<String> m24869b(NodesModel nodesModel) {
        ArrayList<String> arrayList = new ArrayList();
        for (TargetingSentencesModel targetingSentencesModel : nodesModel.m23072l()) {
            arrayList.add(targetingSentencesModel.m23064a());
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            ImmutableList j = targetingSentencesModel.m23065j();
            int size = j.size();
            int i = 0;
            while (i < size) {
                stringBuilder.append(obj != null ? "" : ", ").append((String) j.get(i));
                i++;
                obj = null;
            }
            arrayList.add(stringBuilder.toString());
        }
        return arrayList;
    }

    public static void m24872d(AdInterfacesSavedAudienceOptionsViewController adInterfacesSavedAudienceOptionsViewController) {
        Object obj;
        for (AdInterfacesSavedAudienceRadioButton a : adInterfacesSavedAudienceOptionsViewController.f22910g) {
            a.m24880a();
        }
        adInterfacesSavedAudienceOptionsViewController.f22910g.clear();
        adInterfacesSavedAudienceOptionsViewController.f22911h.clear();
        if (AdInterfacesDataHelper.m22806e(adInterfacesSavedAudienceOptionsViewController.f22904a) == null || AdInterfacesDataHelper.m22806e(adInterfacesSavedAudienceOptionsViewController.f22904a).m23140n() == null || AdInterfacesDataHelper.m22806e(adInterfacesSavedAudienceOptionsViewController.f22904a).m23140n().m23078j() == null || AdInterfacesDataHelper.m22806e(adInterfacesSavedAudienceOptionsViewController.f22904a).m23140n().m23078j().isEmpty()) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            adInterfacesSavedAudienceOptionsViewController.f22907d.setVisibility(8);
            return;
        }
        final AdAccountModel e = AdInterfacesDataHelper.m22806e(adInterfacesSavedAudienceOptionsViewController.f22904a);
        ImmutableList j = e.m23140n().m23078j();
        int size = j.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) j.get(i);
            adInterfacesSavedAudienceOptionsViewController.f22910g.add(adInterfacesSavedAudienceOptionsViewController.f22905b.m24414a(nodesModel.m23070j(), nodesModel.m23071k(), m24869b(nodesModel)));
        }
        m24870b(adInterfacesSavedAudienceOptionsViewController);
        adInterfacesSavedAudienceOptionsViewController.f22907d.setOnClickListener(new OnClickListener(adInterfacesSavedAudienceOptionsViewController) {
            final /* synthetic */ AdInterfacesSavedAudienceOptionsViewController f22902b;

            /* compiled from: Use IntentParser.fromXml() */
            class C26651 extends AbstractDisposableFutureCallback<GraphQLResult<AdAccountAudiencesModel>> {
                final /* synthetic */ C26661 f22900a;

                C26651(C26661 c26661) {
                    this.f22900a = c26661;
                }

                protected final void m24865a(Object obj) {
                    GraphQLResult graphQLResult = (GraphQLResult) obj;
                    int i = 0;
                    if (this.f22900a.f22902b.f22439a) {
                        this.f22900a.f22902b.f22906c.m24586a(false);
                        AdAccountAudiencesModel adAccountAudiencesModel = (AdAccountAudiencesModel) graphQLResult.e;
                        if (adAccountAudiencesModel != null) {
                            ImmutableList j = adAccountAudiencesModel.m23082a().m23078j();
                            int size = j.size();
                            while (i < size) {
                                NodesModel nodesModel = (NodesModel) j.get(i);
                                this.f22900a.f22902b.f22911h.add(nodesModel);
                                this.f22900a.f22902b.f22910g.add(this.f22900a.f22902b.f22905b.m24414a(nodesModel.m23070j(), nodesModel.m23071k(), AdInterfacesSavedAudienceOptionsViewController.m24869b(nodesModel)));
                                i++;
                            }
                            AdInterfacesSavedAudienceOptionsViewController.m24870b(this.f22900a.f22902b);
                        }
                    }
                }

                protected final void m24866a(Throwable th) {
                    if (this.f22900a.f22902b.f22439a) {
                        this.f22900a.f22902b.f22906c.m24586a(false);
                        this.f22900a.f22902b.f22907d.setVisibility(0);
                        this.f22900a.f22902b.f22909f.m22727a(AdInterfacesSavedAudienceOptionsViewController.class, "Error Fetching Saved Audiences", th);
                    }
                }
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 544867461);
                this.f22902b.f22906c.m24586a(true);
                this.f22902b.f22907d.setVisibility(4);
                this.f22902b.f22916m.a("fetch_saved_audiences_task_key", this.f22902b.f22915l.m24237a(e.m23145s(), ((AdInterfacesSavedAudienceRadioButton) this.f22902b.f22910g.get(this.f22902b.f22910g.size() - 1)).f22917a, 5), new C26651(this));
                Logger.a(2, EntryType.UI_INPUT_END, 511654068, a);
            }
        });
        adInterfacesSavedAudienceOptionsViewController.m24871c();
        adInterfacesSavedAudienceOptionsViewController.m24868a(adInterfacesSavedAudienceOptionsViewController.f22912i);
    }
}

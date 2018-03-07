package com.facebook.adinterfaces.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedAdAccountChangeEvent;
import com.facebook.adinterfaces.events.AdInterfacesEvents.SelectedAdAccountChangeEventSubscriber;
import com.facebook.adinterfaces.events.AdInterfacesEvents.UnifiedAudienceChangedEvent;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.AdInterfacesDataModel;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryBuilder;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AvailableAudienceFragmentModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AvailableAudienceFragmentModel.DefaultSpecModel.AvailableAudiencesModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AvailableAudienceFragmentModel.DefaultSpecModel.AvailableAudiencesModel.EdgesModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel.TargetingSentencesModel;
import com.facebook.adinterfaces.protocol.FetchAvailableAudiencesMethod;
import com.facebook.adinterfaces.protocol.FetchAvailableAudiencesMethod.C25431;
import com.facebook.adinterfaces.protocol.FetchAvailableAudiencesQueryModels.FetchAvailableAudiencesQueryModel;
import com.facebook.adinterfaces.protocol.FetchAvailableAudiencesQueryModels.FetchAvailableAudiencesQueryModel.AdminInfoModel;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.StringUtil;
import com.facebook.content.event.FbEvent;
import com.facebook.gk.GatekeeperStoreImplMethodAutoProvider;
import com.facebook.gk.store.GatekeeperStoreImpl;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: UpdateWhiteListMutation */
public class AdInterfacesUnifiedAudienceOptionsViewController extends BaseAdInterfacesViewController<AdInterfacesUnifiedAudienceOptionsView, AdInterfacesDataModel> {
    public BaseAdInterfacesData f22968a;
    public AdInterfacesUnifiedAudienceOptionsView f22969b;
    public View f22970c;
    public AdInterfacesCardLayout f22971d;
    public List<AdInterfacesRadioButtonWithDetails> f22972e = new ArrayList();
    public int f22973f = 0;
    private GatekeeperStoreImpl f22974g;
    public TasksManager f22975h;
    public FetchAvailableAudiencesMethod f22976i;
    public boolean f22977j = false;
    public AdInterfacesDataHelper f22978k;

    /* compiled from: UpdateWhiteListMutation */
    class C26761 implements OnCheckedChangeListener {
        final /* synthetic */ AdInterfacesUnifiedAudienceOptionsViewController f22962a;

        C26761(AdInterfacesUnifiedAudienceOptionsViewController adInterfacesUnifiedAudienceOptionsViewController) {
            this.f22962a = adInterfacesUnifiedAudienceOptionsViewController;
        }

        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (((RadioButton) radioGroup.findViewById(i)).isChecked() && i != -1) {
                this.f22962a.m24941a(i, radioGroup);
            }
        }
    }

    /* compiled from: UpdateWhiteListMutation */
    class C26772 extends SelectedAdAccountChangeEventSubscriber {
        final /* synthetic */ AdInterfacesUnifiedAudienceOptionsViewController f22963a;

        C26772(AdInterfacesUnifiedAudienceOptionsViewController adInterfacesUnifiedAudienceOptionsViewController) {
            this.f22963a = adInterfacesUnifiedAudienceOptionsViewController;
        }

        public final void m24930b(FbEvent fbEvent) {
            SelectedAdAccountChangeEvent selectedAdAccountChangeEvent = (SelectedAdAccountChangeEvent) fbEvent;
            if (!selectedAdAccountChangeEvent.f21674a.equals(selectedAdAccountChangeEvent.f21675b)) {
                if (this.f22963a.f22968a.f21754j.f21729i != null) {
                    this.f22963a.f22968a.f21754j.f21729i = null;
                    this.f22963a.f22968a.f21754j.m22838a(GraphQLBoostedPostAudienceOption.NCPP);
                    this.f22963a.f22969b.m24929a(GraphQLBoostedPostAudienceOption.NCPP, null);
                    AdInterfacesUiUtil.m25234a(this.f22963a.f22971d);
                    this.f22963a.f22440b.m22429a(new UnifiedAudienceChangedEvent(AdInterfacesDataHelper.m22816m(this.f22963a.f22968a)));
                }
                if (selectedAdAccountChangeEvent.f21674a.equals(this.f22963a.f22978k.m22827c(this.f22963a.f22968a))) {
                    AdInterfacesDataHelper.m22817o(this.f22963a.f22968a);
                    this.f22963a.f22978k;
                    this.f22963a.f22971d;
                    return;
                }
                this.f22963a.m24944a(selectedAdAccountChangeEvent.f21674a);
            }
        }
    }

    /* compiled from: UpdateWhiteListMutation */
    class C26804 extends AbstractDisposableFutureCallback<GraphQLResult<FetchAvailableAudiencesQueryModel>> {
        final /* synthetic */ AdInterfacesUnifiedAudienceOptionsViewController f22967a;

        C26804(AdInterfacesUnifiedAudienceOptionsViewController adInterfacesUnifiedAudienceOptionsViewController) {
            this.f22967a = adInterfacesUnifiedAudienceOptionsViewController;
        }

        protected final void m24933a(Object obj) {
            GraphQLResult graphQLResult = (GraphQLResult) obj;
            if (this.f22967a.f22439a) {
                this.f22967a.f22971d.m24586a(false);
                this.f22967a.f22968a.f21758n = this.f22967a.m24940a(graphQLResult);
                this.f22967a.f22968a.f21759o = this.f22967a.m24947b(graphQLResult);
                this.f22967a.f22978k;
                this.f22967a.f22971d;
            }
        }

        protected final void m24934a(Throwable th) {
            if (this.f22967a.f22439a) {
                this.f22967a.f22971d.m24586a(false);
            }
        }
    }

    public static AdInterfacesUnifiedAudienceOptionsViewController m24949b(InjectorLike injectorLike) {
        return new AdInterfacesUnifiedAudienceOptionsViewController(GatekeeperStoreImplMethodAutoProvider.a(injectorLike), TasksManager.b(injectorLike), new FetchAvailableAudiencesMethod(GraphQLQueryExecutor.a(injectorLike), AdInterfacesQueryBuilder.m23051a(injectorLike)), AdInterfacesDataHelper.m22789a(injectorLike));
    }

    public static AdInterfacesUnifiedAudienceOptionsViewController m24938a(InjectorLike injectorLike) {
        return m24949b(injectorLike);
    }

    private void m24951b() {
        this.f22440b.m22430a(new C26772(this));
    }

    @Inject
    public AdInterfacesUnifiedAudienceOptionsViewController(GatekeeperStoreImpl gatekeeperStoreImpl, TasksManager tasksManager, FetchAvailableAudiencesMethod fetchAvailableAudiencesMethod, AdInterfacesDataHelper adInterfacesDataHelper) {
        this.f22974g = gatekeeperStoreImpl;
        this.f22975h = tasksManager;
        this.f22976i = fetchAvailableAudiencesMethod;
        this.f22978k = adInterfacesDataHelper;
    }

    public final void mo983a(BaseAdInterfacesData baseAdInterfacesData) {
        this.f22968a = baseAdInterfacesData;
    }

    public final void m24972a(AdInterfacesUnifiedAudienceOptionsView adInterfacesUnifiedAudienceOptionsView, @Nullable AdInterfacesCardLayout adInterfacesCardLayout) {
        super.mo982a(adInterfacesUnifiedAudienceOptionsView, adInterfacesCardLayout);
        this.f22969b = adInterfacesUnifiedAudienceOptionsView;
        this.f22971d = adInterfacesCardLayout;
        if (this.f22974g.a(470, false)) {
            this.f22969b.setOnCheckChangedListener(new C26761(this));
            this.f22969b.setVisibility(0);
            this.f22970c = adInterfacesUnifiedAudienceOptionsView.findViewById(2131559259);
            this.f22978k;
            this.f22971d;
            m24951b();
        }
    }

    private void m24941a(int i, RadioGroup radioGroup) {
        View findViewById = radioGroup.findViewById(i);
        GraphQLBoostedPostAudienceOption graphQLBoostedPostAudienceOption = GraphQLBoostedPostAudienceOption.NCPP;
        if (findViewById instanceof AdInterfacesRadioButtonWithDetails) {
            BoostedComponentAudienceModel boostedComponentAudienceModel = (BoostedComponentAudienceModel) findViewById.getTag();
            graphQLBoostedPostAudienceOption = boostedComponentAudienceModel.m23230a();
            this.f22968a.f21754j.m22839a(boostedComponentAudienceModel.m23232j(), graphQLBoostedPostAudienceOption);
            this.f22440b.m22429a(new UnifiedAudienceChangedEvent(boostedComponentAudienceModel));
        }
    }

    public static void m24954c(AdInterfacesUnifiedAudienceOptionsViewController adInterfacesUnifiedAudienceOptionsViewController) {
        adInterfacesUnifiedAudienceOptionsViewController.f22969b.m24929a(adInterfacesUnifiedAudienceOptionsViewController.f22968a.f21754j.f21728h, adInterfacesUnifiedAudienceOptionsViewController.f22968a.f21754j.f21729i);
    }

    public static void m24956d(AdInterfacesUnifiedAudienceOptionsViewController adInterfacesUnifiedAudienceOptionsViewController) {
        adInterfacesUnifiedAudienceOptionsViewController.m24959f();
        ImmutableList immutableList = adInterfacesUnifiedAudienceOptionsViewController.f22968a.f21758n;
        if (immutableList != null && adInterfacesUnifiedAudienceOptionsViewController.f22968a.f21759o >= 2) {
            int min = Math.min(4, immutableList.size());
            adInterfacesUnifiedAudienceOptionsViewController.f22973f += min;
            BoostedComponentAudienceModel boostedComponentAudienceModel = null;
            ImmutableList subList = immutableList.subList(0, min);
            int size = subList.size();
            int i = 0;
            while (i < size) {
                BoostedComponentAudienceModel boostedComponentAudienceModel2 = (BoostedComponentAudienceModel) subList.get(i);
                if (boostedComponentAudienceModel2 != null) {
                    if (m24945a(boostedComponentAudienceModel2)) {
                        i++;
                        boostedComponentAudienceModel = boostedComponentAudienceModel2;
                    } else {
                        adInterfacesUnifiedAudienceOptionsViewController.f22972e.add(adInterfacesUnifiedAudienceOptionsViewController.m24936a(boostedComponentAudienceModel2, (adInterfacesUnifiedAudienceOptionsViewController.f22977j ? 1 : 0) + 1));
                    }
                }
                boostedComponentAudienceModel2 = boostedComponentAudienceModel;
                i++;
                boostedComponentAudienceModel = boostedComponentAudienceModel2;
            }
            if (!(boostedComponentAudienceModel == null || min == 1)) {
                adInterfacesUnifiedAudienceOptionsViewController.f22972e.add(adInterfacesUnifiedAudienceOptionsViewController.m24936a(boostedComponentAudienceModel, 0));
                adInterfacesUnifiedAudienceOptionsViewController.f22977j = true;
            }
            adInterfacesUnifiedAudienceOptionsViewController.m24957e();
            final AdAccountModel e = AdInterfacesDataHelper.m22806e(adInterfacesUnifiedAudienceOptionsViewController.f22968a);
            adInterfacesUnifiedAudienceOptionsViewController.f22970c.setOnClickListener(new OnClickListener(adInterfacesUnifiedAudienceOptionsViewController) {
                final /* synthetic */ AdInterfacesUnifiedAudienceOptionsViewController f22966b;

                /* compiled from: UpdateWhiteListMutation */
                class C26781 extends AbstractDisposableFutureCallback<GraphQLResult<FetchAvailableAudiencesQueryModel>> {
                    final /* synthetic */ C26793 f22964a;

                    C26781(C26793 c26793) {
                        this.f22964a = c26793;
                    }

                    protected final void m24931a(Object obj) {
                        GraphQLResult graphQLResult = (GraphQLResult) obj;
                        if (this.f22964a.f22966b.f22439a) {
                            this.f22964a.f22966b.f22971d.m24586a(false);
                            ImmutableList a = this.f22964a.f22966b.m24940a(graphQLResult);
                            if (!a.isEmpty()) {
                                GraphQLBoostedPostAudienceOption graphQLBoostedPostAudienceOption = this.f22964a.f22966b.f22968a.f21754j.f21728h;
                                String str = this.f22964a.f22966b.f22968a.f21754j.f21729i;
                                int size = a.size();
                                for (int i = 0; i < size; i++) {
                                    BoostedComponentAudienceModel boostedComponentAudienceModel = (BoostedComponentAudienceModel) a.get(i);
                                    this.f22964a.f22966b.f22973f = this.f22964a.f22966b.f22973f + 1;
                                    if (boostedComponentAudienceModel != null) {
                                        int i2;
                                        boolean z;
                                        AdInterfacesUnifiedAudienceOptionsViewController adInterfacesUnifiedAudienceOptionsViewController = this.f22964a.f22966b;
                                        if (this.f22964a.f22966b.f22977j) {
                                            i2 = 1;
                                        } else {
                                            i2 = 0;
                                        }
                                        AdInterfacesRadioButtonWithDetails a2 = adInterfacesUnifiedAudienceOptionsViewController.m24936a(boostedComponentAudienceModel, i2 + 1);
                                        if (StringUtil.a(str, boostedComponentAudienceModel.m23232j()) && graphQLBoostedPostAudienceOption == boostedComponentAudienceModel.m23230a()) {
                                            z = true;
                                        } else {
                                            z = false;
                                        }
                                        a2.setChecked(z);
                                        this.f22964a.f22966b.f22972e.add(a2);
                                    }
                                }
                                this.f22964a.f22966b.m24957e();
                            }
                        }
                    }

                    protected final void m24932a(Throwable th) {
                        if (this.f22964a.f22966b.f22439a) {
                            this.f22964a.f22966b.f22971d.m24586a(false);
                            this.f22964a.f22966b.f22970c.setVisibility(0);
                        }
                    }
                }

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -1439318189);
                    this.f22966b.f22971d.m24586a(true);
                    this.f22966b.f22970c.setVisibility(4);
                    this.f22966b.f22975h.a("fetch_unified_audiences_task_key", this.f22966b.f22976i.m24108a(this.f22966b.f22968a.f21747c, e.m23145s(), String.valueOf(this.f22966b.f22973f - 1), 5, this.f22966b.f22968a.mo962b()), new C26781(this));
                    Logger.a(2, EntryType.UI_INPUT_END, -62079874, a);
                }
            });
        }
    }

    @Nullable
    private ImmutableList<BoostedComponentAudienceModel> m24940a(GraphQLResult<FetchAvailableAudiencesQueryModel> graphQLResult) {
        AvailableAudiencesModel c = m24952c((GraphQLResult) graphQLResult);
        if (c == null) {
            return null;
        }
        ImmutableList j = c.m23210j();
        Collection arrayList = new ArrayList();
        for (int i = 0; i < j.size(); i++) {
            arrayList.add(((EdgesModel) j.get(i)).m23203a());
        }
        return ImmutableList.copyOf(arrayList);
    }

    private int m24947b(GraphQLResult<FetchAvailableAudiencesQueryModel> graphQLResult) {
        AvailableAudiencesModel c = m24952c((GraphQLResult) graphQLResult);
        if (c == null) {
            return 0;
        }
        return c.m23206a();
    }

    private AvailableAudiencesModel m24952c(GraphQLResult<FetchAvailableAudiencesQueryModel> graphQLResult) {
        FetchAvailableAudiencesQueryModel fetchAvailableAudiencesQueryModel = (FetchAvailableAudiencesQueryModel) graphQLResult.e;
        if (fetchAvailableAudiencesQueryModel == null) {
            return null;
        }
        if (fetchAvailableAudiencesQueryModel.m24127j() == null) {
            return null;
        }
        ObjectiveType b = this.f22968a.mo962b();
        AvailableAudienceFragmentModel availableAudienceFragmentModel = null;
        AdminInfoModel j = fetchAvailableAudiencesQueryModel.m24127j();
        if (j != null) {
            ImmutableList a;
            switch (C25431.f22340a[b.ordinal()]) {
                case 1:
                    a = j.m24116j().m23492a();
                    break;
                case 2:
                    a = j.m24114a().m23487a();
                    break;
                case 3:
                    a = j.m24117k().m23497a();
                    break;
                default:
                    a = null;
                    break;
            }
            if (a != null && a.size() > 0) {
                availableAudienceFragmentModel = (AvailableAudienceFragmentModel) a.get(0);
            }
        }
        AvailableAudienceFragmentModel availableAudienceFragmentModel2 = availableAudienceFragmentModel;
        return (availableAudienceFragmentModel2 == null || availableAudienceFragmentModel2.m23219a() == null || availableAudienceFragmentModel2.m23219a().m23214a() == null) ? null : availableAudienceFragmentModel2.m23219a().m23214a();
    }

    private void m24944a(String str) {
        this.f22975h.a("fetch_first_batch_audiences_task_key", this.f22976i.m24108a(this.f22968a.f21747c, str, null, 4, this.f22968a.mo962b()), new C26804(this));
    }

    private void m24957e() {
        int i;
        if (this.f22968a.f21759o <= 1 || this.f22972e.size() >= this.f22968a.f21759o) {
            i = 8;
        } else {
            i = 0;
        }
        this.f22970c.setVisibility(i);
    }

    private static boolean m24945a(BoostedComponentAudienceModel boostedComponentAudienceModel) {
        return boostedComponentAudienceModel.m23230a() == GraphQLBoostedPostAudienceOption.NCPP && boostedComponentAudienceModel.m23232j() == null;
    }

    private AdInterfacesRadioButtonWithDetails m24936a(BoostedComponentAudienceModel boostedComponentAudienceModel, int i) {
        AdInterfacesRadioButtonWithDetails a = this.f22969b.m24928a(boostedComponentAudienceModel.m23233k(), m24950b(boostedComponentAudienceModel), i);
        a.setTag(boostedComponentAudienceModel);
        return a;
    }

    private static ArrayList<String> m24950b(BoostedComponentAudienceModel boostedComponentAudienceModel) {
        ArrayList<String> arrayList = new ArrayList();
        for (TargetingSentencesModel targetingSentencesModel : boostedComponentAudienceModel.m23234l()) {
            arrayList.add(targetingSentencesModel.m23227a());
            StringBuilder stringBuilder = new StringBuilder();
            Object obj = 1;
            ImmutableList j = targetingSentencesModel.m23228j();
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

    private void m24959f() {
        for (AdInterfacesRadioButtonWithDetails a : this.f22972e) {
            a.m24848a();
        }
        this.f22972e.clear();
        this.f22973f = 0;
        this.f22977j = false;
        this.f22970c.setVisibility(8);
    }

    public final void mo981a() {
        super.mo981a();
        this.f22975h.c("fetch_first_batch_audiences_task_key");
        this.f22975h.c("fetch_unified_audiences_task_key");
        this.f22969b = null;
        this.f22970c = null;
        this.f22972e = null;
        this.f22973f = 0;
        this.f22977j = false;
    }
}

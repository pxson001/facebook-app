package com.facebook.privacy.checkup.manager;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.graphql.enums.GraphQLPrivacyCheckupActionType;
import com.facebook.graphql.enums.GraphQLPrivacyCheckupSectionType;
import com.facebook.graphql.enums.GraphQLPrivacyOptionType;
import com.facebook.graphql.enums.GraphQLPrivacyReviewCoreSectionType;
import com.facebook.graphql.executor.GraphQLResult;
import com.facebook.graphql.model.GraphQLImage;
import com.facebook.graphql.model.GraphQLPrivacyOption;
import com.facebook.graphql.model.GraphQLPrivacyOptionsContentEdge;
import com.facebook.inject.InjectorLike;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupHeaderRow;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupInfoRow;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupItemRow;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupRowType;
import com.facebook.privacy.checkup.manager.PrivacyCheckupStepData.PrivacyCheckupStepType;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupInterfaces.PrivacyCheckupItemsFragment;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupInterfaces.PrivacyReviewCoreItemsFragment;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchGenericPrivacyReviewQueryModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchGenericPrivacyReviewQueryModel.PrivacyReviewExperiencesModel.ReviewStepsModel.NodesModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchPrivacyCheckupAppsStepQueryModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchPrivacyCheckupAppsStepQueryModel.AudienceInfoModel.PrivacyCheckupInfoModel.AppReviewModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchPrivacyCheckupComposerStepQueryModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchPrivacyCheckupComposerStepQueryModel.AudienceInfoModel.PrivacyCheckupInfoModel.ComposerReviewModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchPrivacyCheckupProfileStepQueryModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.FetchPrivacyCheckupProfileStepQueryModel.AudienceInfoModel.PrivacyCheckupInfoModel.ProfileReviewModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.PrivacyCheckupItemPrivacyScopeFragmentModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.PrivacyCheckupItemsFragmentModel;
import com.facebook.privacy.checkup.protocol.FetchPrivacyCheckupModels.PrivacyReviewCoreItemsFragmentModel;
import com.facebook.privacy.model.PrivacyOptionHelper;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyIconFields;
import com.facebook.privacy.protocol.options.PrivacyOptionsGraphQLInterfaces.PrivacyOptionFieldsWithExplanation;
import com.facebook.privacy.spinner.AudienceSpinnerData;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Story gallery survey post action  */
public class PrivacyCheckupStepDataPager {
    private static volatile PrivacyCheckupStepDataPager f10984b;
    private final AbstractFbErrorReporter f10985a;

    /* compiled from: Story gallery survey post action  */
    /* synthetic */ class C13011 {
        static final /* synthetic */ int[] f10982a = new int[GraphQLPrivacyCheckupSectionType.values().length];
        static final /* synthetic */ int[] f10983b = new int[GraphQLPrivacyReviewCoreSectionType.values().length];

        static {
            try {
                f10983b[GraphQLPrivacyReviewCoreSectionType.SECTION_HEADER_ITEM_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f10983b[GraphQLPrivacyReviewCoreSectionType.SECTION_DATA_ITEM_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f10982a[GraphQLPrivacyCheckupSectionType.SECTION_HEADER_ITEM_TYPE.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f10982a[GraphQLPrivacyCheckupSectionType.SECTION_INFORMATION_ITEM_TYPE.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f10982a[GraphQLPrivacyCheckupSectionType.SECTION_DATA_ITEM_TYPE.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public static com.facebook.privacy.checkup.manager.PrivacyCheckupStepDataPager m11372a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003b in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f10984b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.privacy.checkup.manager.PrivacyCheckupStepDataPager.class;
        monitor-enter(r1);
        r0 = f10984b;	 Catch:{ all -> 0x003a }
        if (r0 != 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000b:
        if (r5 == 0) goto L_0x0031;	 Catch:{ all -> 0x003a }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x003a }
        r3 = r2.b();	 Catch:{ all -> 0x003a }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x003a }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x003a }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x003a }
        r4 = r0.enterScope();	 Catch:{ all -> 0x003a }
        r0 = r5.getApplicationInjector();	 Catch:{ all -> 0x0035 }
        r0 = m11377b(r0);	 Catch:{ all -> 0x0035 }
        f10984b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f10984b;
        return r0;
    L_0x0035:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0035 }
        throw r0;	 Catch:{ all -> 0x0035 }
    L_0x003a:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x003a }
        throw r0;	 Catch:{ all -> 0x003a }
    L_0x003f:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x003a }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.privacy.checkup.manager.PrivacyCheckupStepDataPager.a(com.facebook.inject.InjectorLike):com.facebook.privacy.checkup.manager.PrivacyCheckupStepDataPager");
    }

    private static PrivacyCheckupStepDataPager m11377b(InjectorLike injectorLike) {
        return new PrivacyCheckupStepDataPager((AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public PrivacyCheckupStepDataPager(AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f10985a = abstractFbErrorReporter;
    }

    public final PrivacyCheckupStepData m11378a(GraphQLResult<FetchPrivacyCheckupComposerStepQueryModel> graphQLResult) {
        if (graphQLResult == null || graphQLResult.e == null || ((FetchPrivacyCheckupComposerStepQueryModel) graphQLResult.e).m5615a() == null || ((FetchPrivacyCheckupComposerStepQueryModel) graphQLResult.e).m5615a().m5610a() == null || ((FetchPrivacyCheckupComposerStepQueryModel) graphQLResult.e).m5615a().m5610a().m5606a() == null) {
            return null;
        }
        PrivacyCheckupStepData privacyCheckupStepData = new PrivacyCheckupStepData(PrivacyCheckupStepType.COMPOSER_STEP);
        ComposerReviewModel a = ((FetchPrivacyCheckupComposerStepQueryModel) graphQLResult.e).m5615a().m5610a().m5606a();
        if (!a.m5601c()) {
            return privacyCheckupStepData;
        }
        privacyCheckupStepData.f10973i = a.m5601c();
        privacyCheckupStepData.m11369a(a.m5598a());
        privacyCheckupStepData.m11370a(m11374a(a.m5600b(), PrivacyCheckupStepType.COMPOSER_STEP));
        privacyCheckupStepData.f10975k = false;
        return privacyCheckupStepData;
    }

    public final PrivacyCheckupStepData m11381b(GraphQLResult<FetchPrivacyCheckupAppsStepQueryModel> graphQLResult) {
        if (graphQLResult == null || graphQLResult.e == null || ((FetchPrivacyCheckupAppsStepQueryModel) graphQLResult.e).m5591a() == null || ((FetchPrivacyCheckupAppsStepQueryModel) graphQLResult.e).m5591a().m5586a() == null || ((FetchPrivacyCheckupAppsStepQueryModel) graphQLResult.e).m5591a().m5586a().m5582a() == null) {
            return null;
        }
        PrivacyCheckupStepData privacyCheckupStepData = new PrivacyCheckupStepData(PrivacyCheckupStepType.APPS_STEP);
        AppReviewModel a = ((FetchPrivacyCheckupAppsStepQueryModel) graphQLResult.e).m5591a().m5586a().m5582a();
        if (!a.m5577c()) {
            return privacyCheckupStepData;
        }
        privacyCheckupStepData.f10973i = a.m5577c();
        privacyCheckupStepData.m11369a(a.m5574a());
        privacyCheckupStepData.m11370a(m11374a(a.m5576b(), PrivacyCheckupStepType.APPS_STEP));
        if (a.m5576b() == null || a.m5576b().m5566a() == null) {
            privacyCheckupStepData.f10975k = false;
            privacyCheckupStepData.f10974j = null;
        } else {
            privacyCheckupStepData.f10975k = a.m5576b().m5566a().b();
            privacyCheckupStepData.f10974j = a.m5576b().m5566a().a();
        }
        return privacyCheckupStepData;
    }

    public final PrivacyCheckupStepData m11382c(GraphQLResult<FetchPrivacyCheckupProfileStepQueryModel> graphQLResult) {
        if (graphQLResult == null || graphQLResult.e == null || ((FetchPrivacyCheckupProfileStepQueryModel) graphQLResult.e).m5646a() == null || ((FetchPrivacyCheckupProfileStepQueryModel) graphQLResult.e).m5646a().m5641a() == null || ((FetchPrivacyCheckupProfileStepQueryModel) graphQLResult.e).m5646a().m5641a().m5637a() == null) {
            return null;
        }
        PrivacyCheckupStepData privacyCheckupStepData = new PrivacyCheckupStepData(PrivacyCheckupStepType.PROFILE_STEP);
        ProfileReviewModel a = ((FetchPrivacyCheckupProfileStepQueryModel) graphQLResult.e).m5646a().m5641a().m5637a();
        if (!a.m5633c()) {
            return privacyCheckupStepData;
        }
        privacyCheckupStepData.f10973i = a.m5633c();
        privacyCheckupStepData.m11369a(a.m5630a());
        privacyCheckupStepData.m11370a(m11374a(a.m5632b(), PrivacyCheckupStepType.PROFILE_STEP));
        if (a.m5632b() == null || a.m5632b().m5622a() == null) {
            privacyCheckupStepData.f10975k = false;
            privacyCheckupStepData.f10974j = null;
        } else {
            privacyCheckupStepData.f10975k = a.m5632b().m5622a().b();
            privacyCheckupStepData.f10974j = a.m5632b().m5622a().a();
        }
        return privacyCheckupStepData;
    }

    public final PrivacyCheckupStepData m11379a(GraphQLResult<FetchGenericPrivacyReviewQueryModel> graphQLResult, String str) {
        if (graphQLResult == null || graphQLResult.e == null) {
            return null;
        }
        return m11376b((FetchGenericPrivacyReviewQueryModel) graphQLResult.e, str);
    }

    private PrivacyCheckupStepData m11376b(FetchGenericPrivacyReviewQueryModel fetchGenericPrivacyReviewQueryModel, String str) {
        return m11371a(fetchGenericPrivacyReviewQueryModel, str, 0);
    }

    private PrivacyCheckupStepData m11371a(FetchGenericPrivacyReviewQueryModel fetchGenericPrivacyReviewQueryModel, String str, int i) {
        if (fetchGenericPrivacyReviewQueryModel.m5560a() == null || fetchGenericPrivacyReviewQueryModel.m5560a().m5556a() == null || fetchGenericPrivacyReviewQueryModel.m5560a().m5556a().m5552a() == null || fetchGenericPrivacyReviewQueryModel.m5560a().m5556a().m5552a().isEmpty()) {
            return null;
        }
        NodesModel nodesModel = (NodesModel) fetchGenericPrivacyReviewQueryModel.m5560a().m5556a().m5552a().get(i);
        PrivacyCheckupStepData privacyCheckupStepData = new PrivacyCheckupStepData(PrivacyCheckupStepType.GENERIC_STEP);
        privacyCheckupStepData.f10973i = true;
        privacyCheckupStepData.m11369a(ImmutableList.of(GraphQLPrivacyCheckupActionType.CHANGE_PRIVACY));
        privacyCheckupStepData.m11370a(m11375a(nodesModel.m5540j(), str));
        privacyCheckupStepData.f10969e = nodesModel.m5546p();
        privacyCheckupStepData.f10970f = nodesModel.m5548r();
        privacyCheckupStepData.f10971g = nodesModel.m5544n();
        privacyCheckupStepData.f10972h = nodesModel.m5545o();
        if (nodesModel.m5540j() == null || nodesModel.m5540j().m5535j() == null) {
            privacyCheckupStepData.f10975k = false;
            privacyCheckupStepData.f10974j = null;
        } else {
            privacyCheckupStepData.f10975k = nodesModel.m5540j().m5535j().b();
            privacyCheckupStepData.f10974j = nodesModel.m5540j().m5535j().a();
        }
        if (nodesModel.m5539a() != null) {
            privacyCheckupStepData.f10976l = nodesModel.m5539a().m5734j();
            privacyCheckupStepData.f10977m = nodesModel.m5539a().m5733a();
        }
        privacyCheckupStepData.f10978n = nodesModel.m5542l();
        privacyCheckupStepData.f10979o = nodesModel.m5541k();
        privacyCheckupStepData.f10980p = nodesModel.m5543m();
        privacyCheckupStepData.f10981q = nodesModel.m5547q();
        return privacyCheckupStepData;
    }

    public final List<PrivacyCheckupStepData> m11380a(FetchGenericPrivacyReviewQueryModel fetchGenericPrivacyReviewQueryModel, String str) {
        if (fetchGenericPrivacyReviewQueryModel.m5560a() == null || fetchGenericPrivacyReviewQueryModel.m5560a().m5556a() == null || fetchGenericPrivacyReviewQueryModel.m5560a().m5556a().m5552a() == null || fetchGenericPrivacyReviewQueryModel.m5560a().m5556a().m5552a().isEmpty()) {
            return null;
        }
        List<PrivacyCheckupStepData> arrayList = new ArrayList();
        int size = fetchGenericPrivacyReviewQueryModel.m5560a().m5556a().m5552a().size();
        for (int i = 0; i < size; i++) {
            arrayList.add(m11371a(fetchGenericPrivacyReviewQueryModel, str, i));
        }
        return arrayList;
    }

    private ImmutableList<PrivacyCheckupRowType> m11374a(PrivacyCheckupItemsFragment privacyCheckupItemsFragment, PrivacyCheckupStepType privacyCheckupStepType) {
        if (privacyCheckupItemsFragment == null || privacyCheckupItemsFragment.mo113b() == null) {
            this.f10985a.a("privacy_checkup_manager_no_items", "Null or zero items received for step: " + privacyCheckupStepType.toString());
            return null;
        }
        Builder builder = new Builder();
        ImmutableList b = privacyCheckupItemsFragment.mo113b();
        int size = b.size();
        for (int i = 0; i < size; i++) {
            PrivacyCheckupItemsFragmentModel.NodesModel nodesModel = (PrivacyCheckupItemsFragmentModel.NodesModel) b.get(i);
            if (nodesModel != null) {
                switch (C13011.f10982a[nodesModel.m5677d().ordinal()]) {
                    case 1:
                        if (nodesModel.m5675b() != null) {
                            builder.c(new PrivacyCheckupHeaderRow(nodesModel.m5675b().m5695a()));
                            break;
                        }
                        this.f10985a.a("privacy_checkup_manager_empty_section_header", "Empty section header for step: " + privacyCheckupStepType.toString());
                        break;
                    case 2:
                        if (nodesModel.m5676c() != null) {
                            builder.c(new PrivacyCheckupInfoRow(nodesModel.m5676c().m5700a()));
                            break;
                        }
                        this.f10985a.a("privacy_checkup_manager_empty_section_header", "Empty section information for step: " + privacyCheckupStepType.toString());
                        break;
                    case 3:
                        if (nodesModel.m5674a() != null && nodesModel.m5674a().m5690d() != null) {
                            PrivacyCheckupItemPrivacyScopeFragmentModel c = nodesModel.m5674a().m5690d().m5742c();
                            PrivacyIconFields privacyIconFields = null;
                            if (!(c == null || c.m5664b() == null)) {
                                privacyIconFields = new GraphQLImage.Builder().a(c.m5664b().m5652a()).a();
                            }
                            boolean z = privacyCheckupStepType == PrivacyCheckupStepType.PROFILE_STEP || privacyCheckupStepType == PrivacyCheckupStepType.APPS_STEP;
                            builder.c(new PrivacyCheckupItemRow(nodesModel.m5674a().m5690d().m5740a(), nodesModel.m5674a().m5690d().m5741b(), nodesModel.m5674a().m5689c(), nodesModel.m5674a().m5687a(), nodesModel.m5674a().m5688b(), m11373a(c, z), c != null ? c.m5663a() : null, privacyIconFields, false));
                            break;
                        }
                        this.f10985a.a("privacy_checkup_manager_empty_section_data", "Empty section data or edit privacy scope for step: " + privacyCheckupStepType.toString());
                        break;
                        break;
                    default:
                        break;
                }
            }
            this.f10985a.a("privacy_checkup_manager_empty_item", "Null item received in list for step: " + privacyCheckupStepType.toString());
        }
        return builder.b();
    }

    private ImmutableList<PrivacyCheckupRowType> m11375a(PrivacyReviewCoreItemsFragment privacyReviewCoreItemsFragment, String str) {
        if (privacyReviewCoreItemsFragment == null || privacyReviewCoreItemsFragment.mo112a() == null || privacyReviewCoreItemsFragment.mo112a().isEmpty()) {
            return ImmutableList.of();
        }
        Builder builder = new Builder();
        ImmutableList a = privacyReviewCoreItemsFragment.mo112a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            PrivacyReviewCoreItemsFragmentModel.NodesModel nodesModel = (PrivacyReviewCoreItemsFragmentModel.NodesModel) a.get(i);
            if (nodesModel != null) {
                switch (C13011.f10983b[nodesModel.m5710c().ordinal()]) {
                    case 1:
                        if (nodesModel.m5709b() != null) {
                            builder.c(new PrivacyCheckupHeaderRow(nodesModel.m5709b().m5727a()));
                            break;
                        }
                        this.f10985a.a("privacy_checkup_manager_empty_review_section_header", "Empty section header for step: " + str);
                        break;
                    case 2:
                        if (nodesModel.m5708a() != null && nodesModel.m5708a().m5722c() != null) {
                            PrivacyCheckupItemPrivacyScopeFragmentModel c = nodesModel.m5708a().m5722c().m5742c();
                            PrivacyIconFields privacyIconFields = null;
                            if (!(c == null || c.m5664b() == null)) {
                                privacyIconFields = new GraphQLImage.Builder().a(c.m5664b().m5652a()).a();
                            }
                            builder.c(new PrivacyCheckupItemRow(nodesModel.m5708a().m5722c().m5740a(), nodesModel.m5708a().m5722c().m5741b(), nodesModel.m5708a().m5721b(), nodesModel.m5708a().m5720a(), null, m11373a(c, false), c != null ? c.m5663a() : null, privacyIconFields, false));
                            break;
                        }
                        this.f10985a.a("privacy_checkup_manager_empty_review_section_data", "Empty section data or edit privacy scope for step: " + str);
                        break;
                    default:
                        break;
                }
            }
            this.f10985a.a("privacy_checkup_manager_empty_review_item", "Null item received in list for step: " + str);
        }
        return builder.b();
    }

    private static AudienceSpinnerData m11373a(PrivacyCheckupItemPrivacyScopeFragmentModel privacyCheckupItemPrivacyScopeFragmentModel, boolean z) {
        if (privacyCheckupItemPrivacyScopeFragmentModel == null || privacyCheckupItemPrivacyScopeFragmentModel.m5665c() == null || privacyCheckupItemPrivacyScopeFragmentModel.m5665c().m5657a() == null || privacyCheckupItemPrivacyScopeFragmentModel.m5665c().m5657a().isEmpty()) {
            return null;
        }
        Builder builder = new Builder();
        ImmutableList a = privacyCheckupItemPrivacyScopeFragmentModel.m5665c().m5657a();
        int size = a.size();
        int i = 0;
        PrivacyOptionFieldsWithExplanation privacyOptionFieldsWithExplanation = null;
        GraphQLPrivacyOptionsContentEdge graphQLPrivacyOptionsContentEdge = null;
        while (i < size) {
            GraphQLPrivacyOptionsContentEdge graphQLPrivacyOptionsContentEdge2 = (GraphQLPrivacyOptionsContentEdge) a.get(i);
            GraphQLPrivacyOption j = graphQLPrivacyOptionsContentEdge2.j();
            if (graphQLPrivacyOptionsContentEdge2.a()) {
                privacyOptionFieldsWithExplanation = j;
            }
            if (!z || j == null || PrivacyOptionHelper.a(j) != GraphQLPrivacyOptionType.FRIENDS_OF_FRIENDS) {
                builder.b(new PrivacyOptionFieldsWithExplanation[]{j});
                if (j == null || PrivacyOptionHelper.a(j) != GraphQLPrivacyOptionType.ONLY_ME || graphQLPrivacyOptionsContentEdge == null) {
                    graphQLPrivacyOptionsContentEdge2 = graphQLPrivacyOptionsContentEdge;
                } else {
                    builder.b(new PrivacyOptionFieldsWithExplanation[]{graphQLPrivacyOptionsContentEdge.j()});
                    graphQLPrivacyOptionsContentEdge2 = null;
                }
            }
            i++;
            graphQLPrivacyOptionsContentEdge = graphQLPrivacyOptionsContentEdge2;
        }
        if (graphQLPrivacyOptionsContentEdge != null) {
            builder.b(new PrivacyOptionFieldsWithExplanation[]{graphQLPrivacyOptionsContentEdge.j()});
        }
        return new AudienceSpinnerData(builder.b(), privacyOptionFieldsWithExplanation);
    }
}

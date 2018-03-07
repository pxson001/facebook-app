package com.facebook.adinterfaces.model;

import android.content.Context;
import android.content.res.Resources;
import android.location.Location;
import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesTargetingData.Builder;
import com.facebook.adinterfaces.model.AdInterfacesTargetingData.LocationType;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.model.events.AdInterfacesBoostEventDataModel;
import com.facebook.adinterfaces.model.localawareness.AdInterfacesLocalAwarenessDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdminInfoModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentAudienceModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BoostedComponentModel.DefaultSpecModel.AvailableAudiencesModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BudgetRecommendationDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BudgetRecommendationModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BudgetRecommendationModel.EdgesModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.GeoLocationModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.InterestModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.StoryPromotionModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetSpecificationsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetSpecificationsModel.GeoLocationsModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.TargetSpecificationsModel.InterestsModel;
import com.facebook.adinterfaces.ui.BudgetHelper;
import com.facebook.adinterfaces.util.BoostEventComponentModelConversionUtil;
import com.facebook.adinterfaces.util.BoostPostBoostComponentModelConversionUtil;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.numbers.NumberTruncationUtil;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.calls.BoostedComponentEditInputData.Creative;
import com.facebook.graphql.enums.GraphQLAdsTargetingGender;
import com.facebook.graphql.enums.GraphQLBoostedComponentBudgetType;
import com.facebook.graphql.enums.GraphQLBoostedComponentStatus;
import com.facebook.graphql.enums.GraphQLBoostedPostAudienceOption;
import com.facebook.graphql.enums.GraphQLBoostedPostStatus;
import com.facebook.graphql.enums.GraphQLCallToActionType;
import com.facebook.inject.InjectorLike;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: \d{3}-\d{4} */
public class AdInterfacesDataHelper {
    private static volatile AdInterfacesDataHelper f21691f;
    private final Resources f21692a;
    private final NumberTruncationUtil f21693b;
    private final NumberFormat f21694c = NumberFormat.getNumberInstance(Locale.getDefault());
    private final Clock f21695d;
    private final AdInterfacesErrorReporter f21696e;

    /* compiled from: \d{3}-\d{4} */
    public /* synthetic */ class C25081 {
        public static final /* synthetic */ int[] f21688a = new int[GraphQLBoostedPostStatus.values().length];
        public static final /* synthetic */ int[] f21689b = new int[GraphQLBoostedComponentStatus.values().length];
        public static final /* synthetic */ int[] f21690c = new int[AdInterfacesStatus.values().length];

        static {
            try {
                f21690c[AdInterfacesStatus.INACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f21690c[AdInterfacesStatus.NEVER_BOOSTED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f21690c[AdInterfacesStatus.ACTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f21690c[AdInterfacesStatus.PAUSED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f21690c[AdInterfacesStatus.FINISHED.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f21690c[AdInterfacesStatus.EXTENDABLE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f21690c[AdInterfacesStatus.REJECTED.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f21690c[AdInterfacesStatus.PENDING.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f21690c[AdInterfacesStatus.ERROR.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f21689b[GraphQLBoostedComponentStatus.INACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f21689b[GraphQLBoostedComponentStatus.ACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f21689b[GraphQLBoostedComponentStatus.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f21689b[GraphQLBoostedComponentStatus.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f21689b[GraphQLBoostedComponentStatus.REJECTED.ordinal()] = 5;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f21689b[GraphQLBoostedComponentStatus.PENDING.ordinal()] = 6;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f21689b[GraphQLBoostedComponentStatus.ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f21689b[GraphQLBoostedComponentStatus.CREATING.ordinal()] = 8;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f21688a[GraphQLBoostedPostStatus.INACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f21688a[GraphQLBoostedPostStatus.ACTIVE.ordinal()] = 2;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f21688a[GraphQLBoostedPostStatus.PAUSED.ordinal()] = 3;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f21688a[GraphQLBoostedPostStatus.EXTENDABLE.ordinal()] = 4;
            } catch (NoSuchFieldError e21) {
            }
            try {
                f21688a[GraphQLBoostedPostStatus.FINISHED.ordinal()] = 5;
            } catch (NoSuchFieldError e22) {
            }
            try {
                f21688a[GraphQLBoostedPostStatus.REJECTED.ordinal()] = 6;
            } catch (NoSuchFieldError e23) {
            }
            try {
                f21688a[GraphQLBoostedPostStatus.ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError e24) {
            }
            try {
                f21688a[GraphQLBoostedPostStatus.PENDING.ordinal()] = 8;
            } catch (NoSuchFieldError e25) {
            }
        }
    }

    /* compiled from: \d{3}-\d{4} */
    public enum ScheduleOption {
        SEVEN_DAYS(7),
        FOURTEEN_DAYS(14),
        TWENTY_EIGHT_DAYS(28),
        CONTINUOUS(0),
        SPECIFIC_DATE(-1);
        
        private int mDuration;

        private ScheduleOption(int i) {
            this.mDuration = i;
        }

        public final int getDuration() {
            return this.mDuration;
        }

        public final boolean isFixedDuration() {
            return this.mDuration > 0;
        }
    }

    public static com.facebook.adinterfaces.model.AdInterfacesDataHelper m22789a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f21691f;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.adinterfaces.model.AdInterfacesDataHelper.class;
        monitor-enter(r1);
        r0 = f21691f;	 Catch:{ all -> 0x003a }
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
        r0 = m22803b(r0);	 Catch:{ all -> 0x0035 }
        f21691f = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f21691f;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.model.AdInterfacesDataHelper.a(com.facebook.inject.InjectorLike):com.facebook.adinterfaces.model.AdInterfacesDataHelper");
    }

    private static AdInterfacesDataHelper m22803b(InjectorLike injectorLike) {
        return new AdInterfacesDataHelper(ResourcesMethodAutoProvider.a(injectorLike), NumberTruncationUtil.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), AdInterfacesErrorReporter.m22724a(injectorLike));
    }

    @Inject
    public AdInterfacesDataHelper(Resources resources, NumberTruncationUtil numberTruncationUtil, Clock clock, AdInterfacesErrorReporter adInterfacesErrorReporter) {
        this.f21692a = resources;
        this.f21693b = numberTruncationUtil;
        this.f21695d = clock;
        this.f21696e = adInterfacesErrorReporter;
        this.f21694c.setMinimumFractionDigits(0);
        this.f21694c.setMaximumFractionDigits(1);
    }

    private int m22809f(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel) {
        if (adInterfacesBoostedComponentDataModel.f21797b != null && m22814j(adInterfacesBoostedComponentDataModel)) {
            return m22820a(adInterfacesBoostedComponentDataModel.f21797b.m23354u() * 1000);
        }
        if (adInterfacesBoostedComponentDataModel.f21797b == null || adInterfacesBoostedComponentDataModel.f21797b.m23349p() == null) {
            return 2;
        }
        return adInterfacesBoostedComponentDataModel.f21797b.m23349p().m23315m();
    }

    public final boolean m22825b(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel) {
        return m22820a(adInterfacesBoostedComponentDataModel.f21797b.m23354u() * 1000) != adInterfacesBoostedComponentDataModel.f21753i;
    }

    @Nullable
    public static AdInterfacesBoostedComponentDataModel m22791a(BaseAdInterfacesData baseAdInterfacesData) {
        if (baseAdInterfacesData instanceof AdInterfacesBoostedComponentDataModel) {
            return (AdInterfacesBoostedComponentDataModel) baseAdInterfacesData;
        }
        if (baseAdInterfacesData instanceof AdInterfacesBoostPostDataModel) {
            return BoostPostBoostComponentModelConversionUtil.m25253a((AdInterfacesBoostPostDataModel) baseAdInterfacesData);
        }
        return baseAdInterfacesData instanceof AdInterfacesBoostEventDataModel ? BoostEventComponentModelConversionUtil.m25240a((AdInterfacesBoostEventDataModel) baseAdInterfacesData) : null;
    }

    public final BaseAdInterfacesData m22824b(BaseAdInterfacesData baseAdInterfacesData) {
        if (baseAdInterfacesData == null) {
            this.f21696e.m22726a(getClass(), "Null data cannot be initialized");
            return null;
        } else if (baseAdInterfacesData.f21745a == null) {
            this.f21696e.m22726a(getClass(), "Data cannot be initialized without admin info");
            return null;
        } else {
            BudgetRecommendationDataModel budgetRecommendationDataModel;
            baseAdInterfacesData.f21749e = m22827c(baseAdInterfacesData);
            BudgetRecommendationModel o = baseAdInterfacesData.f21745a.m23191o();
            int i = 0;
            if (o == null || o.m23380a() == 0) {
                budgetRecommendationDataModel = null;
            } else {
                EdgesModel edgesModel;
                for (int i2 = 0; i2 < o.m23380a(); i2++) {
                    edgesModel = (EdgesModel) o.m23384j().get(i2);
                    if (edgesModel.m23377a() && edgesModel.m23378j().m23367a().m23422k() != null) {
                        budgetRecommendationDataModel = edgesModel.m23378j();
                        break;
                    }
                }
                while (i < o.m23380a()) {
                    edgesModel = (EdgesModel) o.m23384j().get(i);
                    if (edgesModel.m23378j().m23367a().m23422k() != null) {
                        budgetRecommendationDataModel = edgesModel.m23378j();
                        break;
                    }
                    i++;
                }
                budgetRecommendationDataModel = null;
            }
            BudgetRecommendationDataModel budgetRecommendationDataModel2 = budgetRecommendationDataModel;
            if (budgetRecommendationDataModel2 != null) {
                baseAdInterfacesData.m22848b(budgetRecommendationDataModel2.m23367a(), budgetRecommendationDataModel2.m23370j());
            } else {
                baseAdInterfacesData.m22848b(null, null);
            }
            if (baseAdInterfacesData.mo962b() == ObjectiveType.BOOST_POST || baseAdInterfacesData.mo962b() == ObjectiveType.BOOST_EVENT) {
                int r = baseAdInterfacesData.f21745a.m23194r();
                if (r <= 0) {
                    this.f21696e.m22726a(getClass(), "Server returned invalid day duration " + r);
                    r = 1;
                }
                baseAdInterfacesData.f21753i = r;
            } else if (baseAdInterfacesData instanceof AdInterfacesBoostedComponentDataModel) {
                baseAdInterfacesData.f21753i = m22809f((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData);
            } else {
                baseAdInterfacesData.f21753i = ScheduleOption.CONTINUOUS.getDuration();
            }
            baseAdInterfacesData.f21754j = m22818p(baseAdInterfacesData);
            BudgetHelper.m25094a(baseAdInterfacesData, baseAdInterfacesData.f21745a.m23191o());
            m22817o(baseAdInterfacesData);
            return baseAdInterfacesData;
        }
    }

    public static boolean m22813i(BaseAdInterfacesData baseAdInterfacesData) {
        return (baseAdInterfacesData.f21745a.m23183a() == null || baseAdInterfacesData.f21745a.m23183a().m23158a() == null || baseAdInterfacesData.f21745a.m23183a().m23158a().isEmpty()) ? false : true;
    }

    public final String m22827c(BaseAdInterfacesData baseAdInterfacesData) {
        if (baseAdInterfacesData instanceof AdInterfacesBoostPostDataModel) {
            StoryPromotionModel storyPromotionModel = ((AdInterfacesBoostPostDataModel) baseAdInterfacesData).f21780a;
            if ((baseAdInterfacesData.f21748d == AdInterfacesStatus.ACTIVE || baseAdInterfacesData.f21748d == AdInterfacesStatus.PAUSED || baseAdInterfacesData.f21748d == AdInterfacesStatus.FINISHED || baseAdInterfacesData.f21748d == AdInterfacesStatus.EXTENDABLE || baseAdInterfacesData.f21748d == AdInterfacesStatus.REJECTED || baseAdInterfacesData.f21748d == AdInterfacesStatus.PENDING || baseAdInterfacesData.f21748d == AdInterfacesStatus.CREATING) && storyPromotionModel != null) {
                return storyPromotionModel.m23713l().m23664a().m23120j();
            }
            return m22799a(baseAdInterfacesData.f21745a.m23183a());
        } else if ((baseAdInterfacesData instanceof AdInterfacesBoostedComponentDataModel) && m22814j(baseAdInterfacesData)) {
            return ((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData).f21797b.m23340a().m23120j();
        } else {
            return m22799a(baseAdInterfacesData.f21745a.m23183a());
        }
    }

    public static boolean m22814j(BaseAdInterfacesData baseAdInterfacesData) {
        AdInterfacesStatus adInterfacesStatus = baseAdInterfacesData.f21748d;
        if (adInterfacesStatus == AdInterfacesStatus.ACTIVE || adInterfacesStatus == AdInterfacesStatus.EXTENDABLE || adInterfacesStatus == AdInterfacesStatus.PENDING || adInterfacesStatus == AdInterfacesStatus.PAUSED) {
            return true;
        }
        return false;
    }

    public static boolean m22815k(BaseAdInterfacesData baseAdInterfacesData) {
        AdInterfacesStatus adInterfacesStatus = baseAdInterfacesData.f21748d;
        return adInterfacesStatus == AdInterfacesStatus.NEVER_BOOSTED || adInterfacesStatus == AdInterfacesStatus.REJECTED || adInterfacesStatus == AdInterfacesStatus.INACTIVE || adInterfacesStatus == AdInterfacesStatus.FINISHED;
    }

    public static String m22805d(BaseAdInterfacesData baseAdInterfacesData) {
        AdAccountModel e = m22806e(baseAdInterfacesData);
        if (e == null || e.m23139m() == null) {
            return null;
        }
        return e.m23139m().m23419a();
    }

    private AdInterfacesTargetingData m22818p(BaseAdInterfacesData baseAdInterfacesData) {
        String str = null;
        AdminInfoModel adminInfoModel;
        if (baseAdInterfacesData instanceof AdInterfacesBoostPostDataModel) {
            StoryPromotionModel storyPromotionModel = ((AdInterfacesBoostPostDataModel) baseAdInterfacesData).f21780a;
            if (storyPromotionModel != null && (baseAdInterfacesData.f21748d == AdInterfacesStatus.ACTIVE || baseAdInterfacesData.f21748d == AdInterfacesStatus.PAUSED || baseAdInterfacesData.f21748d == AdInterfacesStatus.FINISHED || baseAdInterfacesData.f21748d == AdInterfacesStatus.EXTENDABLE || baseAdInterfacesData.f21748d == AdInterfacesStatus.REJECTED || baseAdInterfacesData.f21748d == AdInterfacesStatus.PENDING || baseAdInterfacesData.f21748d == AdInterfacesStatus.CREATING)) {
                return m22790a(storyPromotionModel.m23713l().m23667j(), null, storyPromotionModel.m23713l().m23680w());
            }
            adminInfoModel = baseAdInterfacesData.f21745a;
            if (adminInfoModel.m23189m() != null && adminInfoModel.m23189m() != GraphQLBoostedPostAudienceOption.UNSET_OR_UNRECOGNIZED_ENUM_VALUE && adminInfoModel.m23197u() != null) {
                return m22790a(adminInfoModel.m23189m(), null, adminInfoModel.m23197u());
            }
            Builder builder = new Builder();
            builder.f21718f = GraphQLBoostedPostAudienceOption.NCPP;
            builder = builder;
            builder.f21720h = null;
            builder = builder;
            builder.f21714b = 13;
            builder = builder;
            builder.f21715c = 65;
            builder = builder;
            builder.f21713a = GraphQLAdsTargetingGender.ALL;
            return builder.m22830a();
        }
        if (baseAdInterfacesData instanceof AdInterfacesBoostedComponentDataModel) {
            AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel = (AdInterfacesBoostedComponentDataModel) baseAdInterfacesData;
            if (baseAdInterfacesData.mo962b() == ObjectiveType.LOCAL_AWARENESS) {
                return m22810g((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData);
            }
            if (m22814j(baseAdInterfacesData) && adInterfacesBoostedComponentDataModel.f21797b != null && adInterfacesBoostedComponentDataModel.f21797b.m23355v() != null) {
                GraphQLBoostedPostAudienceOption a;
                BoostedComponentAudienceModel j = adInterfacesBoostedComponentDataModel.f21797b.m23343j();
                if (j != null) {
                    a = j.m23230a();
                } else {
                    a = GraphQLBoostedPostAudienceOption.NCPP;
                }
                if (j != null) {
                    str = j.m23232j();
                }
                return m22790a(a, str, adInterfacesBoostedComponentDataModel.f21797b.m23355v());
            } else if (adInterfacesBoostedComponentDataModel.f21797b != null && adInterfacesBoostedComponentDataModel.f21797b.m23349p() != null && adInterfacesBoostedComponentDataModel.f21797b.m23349p().m23314l() != null) {
                return m22790a(GraphQLBoostedPostAudienceOption.NCPP, null, adInterfacesBoostedComponentDataModel.f21797b.m23349p().m23314l());
            } else {
                adminInfoModel = baseAdInterfacesData.f21745a;
                if (adminInfoModel.m23197u() != null) {
                    return m22790a(GraphQLBoostedPostAudienceOption.NCPP, null, adminInfoModel.m23197u());
                }
            }
        }
        builder = new Builder();
        builder.f21718f = GraphQLBoostedPostAudienceOption.NCPP;
        builder = builder;
        builder.f21720h = null;
        builder = builder;
        builder.f21714b = 13;
        builder = builder;
        builder.f21715c = 65;
        builder = builder;
        builder.f21713a = GraphQLAdsTargetingGender.ALL;
        return builder.m22830a();
    }

    private AdInterfacesTargetingData m22810g(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel) {
        int i;
        TargetSpecificationsModel targetSpecificationsModel = null;
        if (!m22814j(adInterfacesBoostedComponentDataModel) || adInterfacesBoostedComponentDataModel.f21797b == null || adInterfacesBoostedComponentDataModel.f21797b.m23355v() == null) {
            i = 0;
        } else {
            i = 1;
        }
        if (i != 0) {
            GraphQLBoostedPostAudienceOption a;
            String j;
            BoostedComponentAudienceModel j2 = adInterfacesBoostedComponentDataModel.f21797b.m23343j();
            if (j2 != null) {
                a = j2.m23230a();
            } else {
                a = GraphQLBoostedPostAudienceOption.NCPP;
            }
            if (j2 != null) {
                j = j2.m23232j();
            }
            AdInterfacesTargetingData a2 = m22790a(a, j, adInterfacesBoostedComponentDataModel.f21797b.m23355v());
            a2.f21727g = ImmutableList.of(LocationType.HOME, LocationType.RECENT);
            return a2;
        }
        int i2 = 13;
        i = 65;
        if (!(adInterfacesBoostedComponentDataModel.f21797b == null || adInterfacesBoostedComponentDataModel.f21797b.m23349p() == null || adInterfacesBoostedComponentDataModel.f21797b.m23349p().m23314l() == null)) {
            targetSpecificationsModel = adInterfacesBoostedComponentDataModel.f21797b.m23349p().m23314l();
            i2 = targetSpecificationsModel.m23734m();
            i = targetSpecificationsModel.m23733l();
        }
        Builder builder = new Builder();
        builder.f21714b = i2;
        Builder builder2 = builder;
        builder2.f21715c = i;
        Builder builder3 = builder2;
        builder3.f21713a = GraphQLAdsTargetingGender.ALL;
        builder3 = builder3;
        builder3.f21719g = ImmutableList.of(LocationType.HOME, LocationType.RECENT);
        builder3 = builder3;
        if (!(targetSpecificationsModel == null || targetSpecificationsModel.m23731j() == null || targetSpecificationsModel.m23731j().m23720a().isEmpty())) {
            GeoLocationModel geoLocationModel = (GeoLocationModel) targetSpecificationsModel.m23731j().m23720a().get(0);
            GeoLocationModel a3 = GeoLocationModel.m23434a(geoLocationModel);
            GeoLocationModel.Builder builder4 = new GeoLocationModel.Builder();
            builder4.f22132a = a3.m23437a();
            builder4.f22133b = a3.m23439b();
            builder4.f22134c = a3.m23440c();
            builder4.f22135d = a3.m23441d();
            builder4.f22136e = a3.mL_();
            builder4.f22137f = a3.m23442g();
            builder4.f22138g = a3.mM_();
            builder4.f22139h = a3.mN_();
            builder4.f22140i = a3.m23443j();
            builder4.f22141j = a3.m23444k();
            builder4.f22142k = a3.m23445l();
            builder4.f22143l = a3.m23446m();
            builder4.f22144m = a3.m23447n();
            GeoLocationModel.Builder builder5 = builder4;
            m22800a(geoLocationModel, builder5, ((AdInterfacesLocalAwarenessDataModel) adInterfacesBoostedComponentDataModel).f21803h);
            builder3.f21716d = ImmutableList.of(builder5.m23431a());
        }
        return builder3.m22830a();
    }

    private void m22800a(GeoLocationModel geoLocationModel, GeoLocationModel.Builder builder, GeoLocationModel geoLocationModel2) {
        if (geoLocationModel2 != null) {
            float[] fArr = new float[1];
            Location.distanceBetween(geoLocationModel.m23442g(), geoLocationModel.mN_(), geoLocationModel2.m23442g(), geoLocationModel2.mN_(), fArr);
            builder.f22132a = fArr[0] < 100.0f ? geoLocationModel2.m23437a() : this.f21692a.getString(2131234098);
        }
    }

    private static AdInterfacesTargetingData m22790a(GraphQLBoostedPostAudienceOption graphQLBoostedPostAudienceOption, String str, TargetSpecificationsModel targetSpecificationsModel) {
        Builder builder = new Builder();
        builder.f21718f = graphQLBoostedPostAudienceOption;
        builder = builder;
        builder.f21720h = str;
        builder = builder;
        builder.f21714b = targetSpecificationsModel.m23734m();
        builder = builder;
        builder.f21715c = targetSpecificationsModel.m23733l();
        builder = builder;
        builder.f21713a = m22793a(targetSpecificationsModel.m23729a());
        builder = builder;
        builder.f21717e = m22796a(targetSpecificationsModel.m23732k());
        builder = builder;
        builder.f21716d = m22795a(targetSpecificationsModel.m23731j());
        return builder.m22830a();
    }

    public static GraphQLAdsTargetingGender m22793a(ImmutableList<GraphQLAdsTargetingGender> immutableList) {
        GraphQLAdsTargetingGender graphQLAdsTargetingGender = GraphQLAdsTargetingGender.ALL;
        if (immutableList == null || immutableList.size() != 1) {
            return graphQLAdsTargetingGender;
        }
        return (GraphQLAdsTargetingGender) immutableList.get(0);
    }

    public static ImmutableList<GeoLocationModel> m22795a(GeoLocationsModel geoLocationsModel) {
        if (geoLocationsModel != null) {
            return geoLocationsModel.m23720a();
        }
        return RegularImmutableList.a;
    }

    public static ImmutableList<InterestModel> m22796a(InterestsModel interestsModel) {
        if (interestsModel != null) {
            return interestsModel.m23725a();
        }
        return RegularImmutableList.a;
    }

    public static int m22788a(ImmutableList<AdAccountModel> immutableList, String str) {
        int i = 0;
        while (i < immutableList.size()) {
            if (immutableList.get(i) != null && StringUtil.a(((AdAccountModel) immutableList.get(i)).m23146t(), str)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private String m22799a(AdAccountsModel adAccountsModel) {
        if (adAccountsModel == null) {
            this.f21696e.m22726a(getClass(), "Insufficient data to find default ad account id; adAccounts is null");
            return null;
        } else if (adAccountsModel.m23158a() == null || adAccountsModel.m23158a().isEmpty()) {
            this.f21696e.m22726a(getClass(), "Insufficient data to find default ad account id; adAccounts.getNodes() is null");
            return null;
        } else if (adAccountsModel.m23158a().get(0) == null) {
            this.f21696e.m22726a(getClass(), "Insufficient data to find default ad account id; first add is null");
            return null;
        } else if (((AdAccountModel) adAccountsModel.m23158a().get(0)).m23146t() != null) {
            return ((AdAccountModel) adAccountsModel.m23158a().get(0)).m23146t();
        } else {
            this.f21696e.m22726a(getClass(), "Insufficient data to find default ad account id; first ad account id is null");
            return null;
        }
    }

    public static AdAccountModel m22806e(BaseAdInterfacesData baseAdInterfacesData) {
        Preconditions.checkNotNull(baseAdInterfacesData, "Ad interfaces data is null");
        Preconditions.checkNotNull(baseAdInterfacesData.m22853i(), "No selected ad account Id");
        return m22792a(baseAdInterfacesData, baseAdInterfacesData.m22853i());
    }

    public static int m22808f(BaseAdInterfacesData baseAdInterfacesData) {
        return m22806e(baseAdInterfacesData).m23139m().m23421j();
    }

    public static boolean m22811g(BaseAdInterfacesData baseAdInterfacesData) {
        if (!m22812h(baseAdInterfacesData) || baseAdInterfacesData.f21745a == null) {
            return false;
        }
        if (!baseAdInterfacesData.f21745a.m23196t()) {
            return true;
        }
        if (!m22813i(baseAdInterfacesData)) {
            return false;
        }
        ImmutableList a = baseAdInterfacesData.f21745a.m23183a().m23158a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            if (((AdAccountModel) a.get(i)).m23144r()) {
                return true;
            }
        }
        return false;
    }

    public static boolean m22812h(BaseAdInterfacesData baseAdInterfacesData) {
        if (m22814j(baseAdInterfacesData)) {
            try {
                m22806e(baseAdInterfacesData);
            } catch (IllegalArgumentException e) {
                return false;
            }
        }
        return true;
    }

    public static AdAccountModel m22792a(BaseAdInterfacesData baseAdInterfacesData, String str) {
        Preconditions.checkNotNull(baseAdInterfacesData, "Ad interfaces data is null");
        Preconditions.checkNotNull(baseAdInterfacesData.f21745a, "Admin Info is null");
        Preconditions.checkNotNull(baseAdInterfacesData.f21745a.m23183a(), "Ad accounts are null");
        Preconditions.checkNotNull(baseAdInterfacesData.f21745a.m23183a().m23158a(), "No ad accounts found");
        Preconditions.checkNotNull(str, "No ad account id specified");
        ImmutableList a = baseAdInterfacesData.f21745a.m23183a().m23158a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            AdAccountModel adAccountModel = (AdAccountModel) a.get(i);
            if (adAccountModel != null && StringUtil.a(adAccountModel.m23146t(), str)) {
                return adAccountModel;
            }
        }
        throw new IllegalArgumentException("Ad account " + str + " was not found");
    }

    public final String m22822a(int i) {
        return this.f21693b.a((double) i, this.f21694c);
    }

    public static String m22797a(int i, Context context) {
        return NumberFormat.getInstance(context.getResources().getConfiguration().locale).format((long) i);
    }

    public static long m22802b(int i) {
        if (i <= 0) {
            return 86400;
        }
        return 86400 * ((long) i);
    }

    public static String m22798a(long j, Context context) {
        return DateFormat.getDateTimeInstance(1, 3, context.getResources().getConfiguration().locale).format(new Date(1000 * j));
    }

    public final long m22821a() {
        return this.f21695d.a() / 1000;
    }

    public final long m22826c(int i) {
        if (i == ScheduleOption.CONTINUOUS.getDuration()) {
            return 0;
        }
        long a = this.f21695d.a() / 1000;
        if (i <= 0) {
            return a + 86400;
        }
        return a + (((long) i) * 86400);
    }

    public final int m22820a(long j) {
        if (j == 0) {
            return 0;
        }
        int a = (int) ((((j - this.f21695d.a()) + 86400000) - 1) / 86400000);
        if (a <= 0) {
            return 1;
        }
        return a;
    }

    public final long m22823b(long j) {
        long a = this.f21695d.a() / 1000;
        if (j < a + 86400) {
            return a + 86400;
        }
        return j;
    }

    public static boolean m22801a(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel) {
        if (adInterfacesBoostedComponentDataModel.f21750f == null) {
            return false;
        }
        if (adInterfacesBoostedComponentDataModel.f21797b.m23346m() == GraphQLBoostedComponentBudgetType.LIFETIME_BUDGET) {
            if (adInterfacesBoostedComponentDataModel.mo962b() == ObjectiveType.PROMOTE_PRODUCT) {
                return true;
            }
            return false;
        } else if (adInterfacesBoostedComponentDataModel.f21797b.m23345l().m23422k().equals(adInterfacesBoostedComponentDataModel.f21750f.m23422k()) && adInterfacesBoostedComponentDataModel.f21797b.m23345l().m23419a().equals(adInterfacesBoostedComponentDataModel.f21750f.m23419a())) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean m22804c(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel) {
        return !adInterfacesBoostedComponentDataModel.f21754j.equals(m22790a(null, null, adInterfacesBoostedComponentDataModel.f21797b.m23355v()));
    }

    public static Creative m22807e(AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel) {
        CreativeAdModel C = adInterfacesBoostedComponentDataModel.mo951C();
        adInterfacesBoostedComponentDataModel.f21797b.m23348o();
        Creative creative = new Creative();
        creative.a("object_id", adInterfacesBoostedComponentDataModel.f21747c);
        creative = creative;
        if (C.f21774g == GraphQLCallToActionType.LIKE_PAGE) {
            creative.a("body", C.f21770c);
            creative.a("image_url", C.f21773f);
        }
        return creative;
    }

    public static AvailableAudiencesModel m22819q(BaseAdInterfacesData baseAdInterfacesData) {
        if (!(baseAdInterfacesData instanceof AdInterfacesBoostedComponentDataModel)) {
            return null;
        }
        AdInterfacesBoostedComponentDataModel adInterfacesBoostedComponentDataModel = (AdInterfacesBoostedComponentDataModel) baseAdInterfacesData;
        if (adInterfacesBoostedComponentDataModel.f21797b == null || adInterfacesBoostedComponentDataModel.f21797b.m23349p() == null || adInterfacesBoostedComponentDataModel.f21797b.m23349p().m23312j() == null) {
            return null;
        }
        return adInterfacesBoostedComponentDataModel.f21797b.m23349p().m23312j();
    }

    public static BoostedComponentAudienceModel m22816m(BaseAdInterfacesData baseAdInterfacesData) {
        ImmutableList immutableList = baseAdInterfacesData.f21758n;
        if (immutableList == null) {
            return null;
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            BoostedComponentAudienceModel boostedComponentAudienceModel = (BoostedComponentAudienceModel) immutableList.get(i);
            if (boostedComponentAudienceModel != null && boostedComponentAudienceModel.m23230a() == GraphQLBoostedPostAudienceOption.NCPP && boostedComponentAudienceModel.m23232j() == null) {
                return boostedComponentAudienceModel;
            }
        }
        return null;
    }

    public final AdInterfacesTargetingData m22828n(BaseAdInterfacesData baseAdInterfacesData) {
        BoostedComponentAudienceModel m = m22816m(baseAdInterfacesData);
        if (m == null || m.m23235m() == null) {
            return m22818p(baseAdInterfacesData);
        }
        TargetSpecificationsModel m2 = m.m23235m();
        return new AdInterfacesTargetingData(m2.m23729a().size() > 0 ? (GraphQLAdsTargetingGender) m2.m23729a().get(0) : GraphQLAdsTargetingGender.ALL, m2.m23734m(), m2.m23733l(), m2.m23731j().m23720a(), m2.m23731j().m23720a(), m2.m23732k().m23725a(), GraphQLBoostedPostAudienceOption.NCPP, m.m23232j());
    }

    public static void m22817o(BaseAdInterfacesData baseAdInterfacesData) {
        AvailableAudiencesModel q = m22819q(baseAdInterfacesData);
        if (q != null) {
            baseAdInterfacesData.f21758n = m22794a(q);
        }
        q = m22819q(baseAdInterfacesData);
        if (q != null) {
            baseAdInterfacesData.f21759o = q.m23280a();
        } else {
            baseAdInterfacesData.f21759o = 0;
        }
    }

    public static ImmutableList<BoostedComponentAudienceModel> m22794a(AvailableAudiencesModel availableAudiencesModel) {
        Collection arrayList = new ArrayList();
        for (int i = 0; i < availableAudiencesModel.m23284j().size(); i++) {
            arrayList.add(((AvailableAudiencesModel.EdgesModel) availableAudiencesModel.m23284j().get(i)).m23277a());
        }
        return ImmutableList.copyOf(arrayList);
    }
}

package com.facebook.adinterfaces.ui;

import com.facebook.adinterfaces.error.AdInterfacesErrorReporter;
import com.facebook.adinterfaces.external.ObjectiveType;
import com.facebook.adinterfaces.model.AdInterfacesDataHelper;
import com.facebook.adinterfaces.model.BaseAdInterfacesData;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostPostDataModel;
import com.facebook.adinterfaces.model.boostpost.AdInterfacesBoostedComponentDataModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdAccountModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.AdminInfoModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BudgetRecommendationModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.BudgetRecommendationModel.EdgesModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel;
import com.facebook.adinterfaces.protocol.AdInterfacesQueryFragmentsModels.CurrencyQuantityModel.Builder;
import com.facebook.flatbuffers.FlatBufferBuilder;
import com.facebook.flatbuffers.MutableFlatBuffer;
import com.facebook.graphql.enums.GraphQLBoostedComponentBudgetType;
import com.facebook.graphql.modelutil.ModelHelper;
import com.facebook.inject.InjectorLike;
import com.google.common.collect.ImmutableList;
import java.math.BigDecimal;
import java.nio.ByteBuffer;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: Unsubscribe page id is null */
public class BudgetHelper {
    public static final ObjectiveType[] f23125a = new ObjectiveType[]{ObjectiveType.PROMOTE_PRODUCT, ObjectiveType.BOOST_POST, ObjectiveType.BOOST_EVENT, ObjectiveType.BOOSTED_COMPONENT_BOOST_POST};
    private static volatile BudgetHelper f23126c;
    private final AdInterfacesErrorReporter f23127b;

    /* compiled from: Unsubscribe page id is null */
    public enum BudgetTipType {
        NONE,
        MIN,
        MAX
    }

    public static com.facebook.adinterfaces.ui.BudgetHelper m25096a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f23126c;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.adinterfaces.ui.BudgetHelper.class;
        monitor-enter(r1);
        r0 = f23126c;	 Catch:{ all -> 0x003a }
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
        r0 = m25101b(r0);	 Catch:{ all -> 0x0035 }
        f23126c = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f23126c;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.adinterfaces.ui.BudgetHelper.a(com.facebook.inject.InjectorLike):com.facebook.adinterfaces.ui.BudgetHelper");
    }

    private static BudgetHelper m25101b(InjectorLike injectorLike) {
        return new BudgetHelper(AdInterfacesErrorReporter.m22724a(injectorLike));
    }

    @Inject
    public BudgetHelper(AdInterfacesErrorReporter adInterfacesErrorReporter) {
        this.f23127b = adInterfacesErrorReporter;
    }

    private static boolean m25099a(ObjectiveType objectiveType) {
        for (ObjectiveType objectiveType2 : f23125a) {
            if (objectiveType == objectiveType2) {
                return true;
            }
        }
        return false;
    }

    public static boolean m25100a(BaseAdInterfacesData baseAdInterfacesData) {
        return m25102b(baseAdInterfacesData) == m25099a(baseAdInterfacesData.mo962b());
    }

    public static boolean m25102b(BaseAdInterfacesData baseAdInterfacesData) {
        if (!AdInterfacesDataHelper.m22814j(baseAdInterfacesData)) {
            return m25099a(baseAdInterfacesData.mo962b());
        }
        if (!(baseAdInterfacesData instanceof AdInterfacesBoostedComponentDataModel) || ((AdInterfacesBoostedComponentDataModel) baseAdInterfacesData).f21797b.m23346m() == GraphQLBoostedComponentBudgetType.LIFETIME_BUDGET) {
            return true;
        }
        return false;
    }

    @Nullable
    public static String m25103c(BaseAdInterfacesData baseAdInterfacesData) {
        if (baseAdInterfacesData instanceof AdInterfacesBoostPostDataModel) {
            return ((AdInterfacesBoostPostDataModel) baseAdInterfacesData).f21781b;
        }
        return null;
    }

    public static String m25097a(int i, long j, NumberFormat numberFormat) {
        if (i > 0) {
            return numberFormat.format(((double) j) / ((double) i)).replaceAll("\\s", "");
        }
        return numberFormat.format(((double) j) / Math.pow(10.0d, (double) numberFormat.getCurrency().getDefaultFractionDigits())).replaceAll("\\s", "");
    }

    public static BigDecimal m25104d(BaseAdInterfacesData baseAdInterfacesData) {
        return m25098a(AdInterfacesDataHelper.m22806e(baseAdInterfacesData).m23147u());
    }

    public static BigDecimal m25105e(BaseAdInterfacesData baseAdInterfacesData) {
        return m25098a(AdInterfacesDataHelper.m22806e(baseAdInterfacesData).m23148v());
    }

    public static BigDecimal m25106f(BaseAdInterfacesData baseAdInterfacesData) {
        return m25105e(baseAdInterfacesData).multiply(BigDecimal.valueOf((long) baseAdInterfacesData.f21753i));
    }

    public static BigDecimal m25098a(CurrencyQuantityModel currencyQuantityModel) {
        if (currencyQuantityModel == null) {
            return new BigDecimal(0);
        }
        return new BigDecimal(currencyQuantityModel.m23422k());
    }

    public static NumberFormat m25107g(BaseAdInterfacesData baseAdInterfacesData) {
        AdAccountModel e = AdInterfacesDataHelper.m22806e(baseAdInterfacesData);
        if (e == null || e.m23139m() == null || e.m23139m().m23419a() == null) {
            return null;
        }
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        currencyInstance.setCurrency(Currency.getInstance(e.m23139m().m23419a()));
        currencyInstance.setMinimumFractionDigits(0);
        currencyInstance.setMaximumFractionDigits(2);
        return currencyInstance;
    }

    public static CurrencyQuantityModel m25095a(BigDecimal bigDecimal, BaseAdInterfacesData baseAdInterfacesData) {
        Builder builder = new Builder();
        builder.f22126c = bigDecimal.toString();
        builder = builder;
        builder.f22125b = AdInterfacesDataHelper.m22808f(baseAdInterfacesData);
        builder = builder;
        builder.f22124a = m25107g(baseAdInterfacesData).getCurrency().getCurrencyCode();
        return builder.m23414a();
    }

    public static int m25108h(BaseAdInterfacesData baseAdInterfacesData) {
        AdAccountModel e = AdInterfacesDataHelper.m22806e(baseAdInterfacesData);
        return (e == null || e.m23139m() == null) ? 0 : e.m23139m().m23421j();
    }

    public static BaseAdInterfacesData m25094a(BaseAdInterfacesData baseAdInterfacesData, BudgetRecommendationModel budgetRecommendationModel) {
        BudgetRecommendationModel budgetRecommendationModel2;
        ImmutableList.Builder builder = new ImmutableList.Builder();
        Set hashSet = new HashSet();
        if (budgetRecommendationModel == null) {
            budgetRecommendationModel2 = null;
        } else {
            for (int i = 0; i < budgetRecommendationModel.m23384j().size(); i++) {
                CurrencyQuantityModel a = ((EdgesModel) budgetRecommendationModel.m23384j().get(i)).m23378j().m23367a();
                if (!hashSet.contains(Long.valueOf(m25098a(a).longValue()))) {
                    hashSet.add(Long.valueOf(m25098a(a).longValue()));
                    builder.c(budgetRecommendationModel.m23384j().get(i));
                }
            }
            ImmutableList b = builder.b();
            BudgetRecommendationModel.Builder builder2 = new BudgetRecommendationModel.Builder();
            builder2.f22108a = b.size();
            builder2 = builder2;
            builder2.f22109b = b;
            BudgetRecommendationModel.Builder builder3 = builder2;
            FlatBufferBuilder flatBufferBuilder = new FlatBufferBuilder(128);
            int a2 = ModelHelper.a(flatBufferBuilder, builder3.f22109b);
            flatBufferBuilder.c(2);
            flatBufferBuilder.a(0, builder3.f22108a, 0);
            flatBufferBuilder.b(1, a2);
            flatBufferBuilder.d(flatBufferBuilder.d());
            ByteBuffer wrap = ByteBuffer.wrap(flatBufferBuilder.e());
            wrap.position(0);
            budgetRecommendationModel2 = new BudgetRecommendationModel(new MutableFlatBuffer(wrap, null, null, true, null));
        }
        BudgetRecommendationModel budgetRecommendationModel3 = budgetRecommendationModel2;
        AdminInfoModel.Builder builder4 = new AdminInfoModel.Builder();
        builder4 = AdminInfoModel.Builder.m23178a(baseAdInterfacesData.m22850d());
        builder4.f21995g = budgetRecommendationModel3;
        baseAdInterfacesData.f21745a = builder4.m23179a();
        return baseAdInterfacesData;
    }

    public final BigDecimal m25109a(CurrencyQuantityModel currencyQuantityModel, CurrencyQuantityModel currencyQuantityModel2) {
        BigDecimal subtract = m25098a(currencyQuantityModel2).subtract(m25098a(currencyQuantityModel));
        if (subtract.compareTo(BigDecimal.ZERO) > 0) {
            return subtract;
        }
        this.f23127b.m22726a(getClass(), "The difference between the current total budget and the new budget must be greater than zero");
        return null;
    }
}

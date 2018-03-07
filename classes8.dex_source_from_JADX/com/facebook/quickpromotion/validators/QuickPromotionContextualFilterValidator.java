package com.facebook.quickpromotion.validators;

import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.inject.InjectorLike;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.quickpromotion.filter.ContextualFilterPassingCheck;
import com.facebook.quickpromotion.filter.QuickPromotionFilterClauseChecker;
import com.facebook.quickpromotion.model.QuickPromotionDefinition;
import com.facebook.quickpromotion.model.QuickPromotionDefinition$FilterClause.BooleanType;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.BooleanFilter;
import com.facebook.quickpromotion.model.QuickPromotionDefinition.ContextualFilter;
import com.facebook.quickpromotion.validators.QuickPromotionValidatorResult.Builder;
import javax.annotation.Nonnull;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: query_removed_tag_store */
public class QuickPromotionContextualFilterValidator implements QuickPromotionValidator {
    private static volatile QuickPromotionContextualFilterValidator f4860d;
    private final AbstractFbErrorReporter f4861a;
    public final QuickPromotionFilterClauseChecker f4862b;
    private final ContextualFilterPassingCheck f4863c;

    public static com.facebook.quickpromotion.validators.QuickPromotionContextualFilterValidator m4741a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f4860d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.quickpromotion.validators.QuickPromotionContextualFilterValidator.class;
        monitor-enter(r1);
        r0 = f4860d;	 Catch:{ all -> 0x003a }
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
        r0 = m4743b(r0);	 Catch:{ all -> 0x0035 }
        f4860d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f4860d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.quickpromotion.validators.QuickPromotionContextualFilterValidator.a(com.facebook.inject.InjectorLike):com.facebook.quickpromotion.validators.QuickPromotionContextualFilterValidator");
    }

    private static QuickPromotionContextualFilterValidator m4743b(InjectorLike injectorLike) {
        return new QuickPromotionContextualFilterValidator(QuickPromotionFilterClauseChecker.m4587b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), ContextualFilterPassingCheck.m4548a(injectorLike));
    }

    @Inject
    public QuickPromotionContextualFilterValidator(QuickPromotionFilterClauseChecker quickPromotionFilterClauseChecker, AbstractFbErrorReporter abstractFbErrorReporter, ContextualFilterPassingCheck contextualFilterPassingCheck) {
        this.f4861a = abstractFbErrorReporter;
        this.f4862b = quickPromotionFilterClauseChecker;
        this.f4863c = contextualFilterPassingCheck;
    }

    @Nonnull
    public final QuickPromotionValidatorResult m4745a(QuickPromotionDefinition quickPromotionDefinition, InterstitialTrigger interstitialTrigger) {
        Object obj;
        BooleanFilter booleanFilter = quickPromotionDefinition.booleanFilter;
        if (booleanFilter == null || booleanFilter.a == null || booleanFilter.a.type == null || booleanFilter.a.type == BooleanType.UNKNOWN) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj == null) {
            return m4744b(quickPromotionDefinition, interstitialTrigger);
        }
        QuickPromotionValidatorResult quickPromotionValidatorResult;
        if (this.f4862b.m4589b(quickPromotionDefinition, quickPromotionDefinition.booleanFilter.a)) {
            quickPromotionValidatorResult = QuickPromotionValidatorResult.f4869a;
        } else {
            Builder builder = new Builder(false);
            builder.f4867d = quickPromotionDefinition.booleanFilter.a;
            quickPromotionValidatorResult = builder.m4746a();
        }
        return quickPromotionValidatorResult;
    }

    private QuickPromotionValidatorResult m4744b(QuickPromotionDefinition quickPromotionDefinition, InterstitialTrigger interstitialTrigger) {
        for (ContextualFilter contextualFilter : quickPromotionDefinition.d()) {
            try {
                if (!this.f4863c.m4550a(contextualFilter, quickPromotionDefinition, interstitialTrigger)) {
                    return m4742a(contextualFilter);
                }
            } catch (Throwable e) {
                this.f4861a.a("QuickPromotion_filter", "Invalid filter", e);
                return m4742a(contextualFilter);
            } catch (Throwable e2) {
                this.f4861a.a("QuickPromotion_filter", "Invalid filter", e2);
                return m4742a(contextualFilter);
            }
        }
        return QuickPromotionValidatorResult.f4869a;
    }

    private static QuickPromotionValidatorResult m4742a(ContextualFilter contextualFilter) {
        Builder builder = new Builder(false);
        builder.f4865b = contextualFilter;
        return builder.m4746a();
    }
}

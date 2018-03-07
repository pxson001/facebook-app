package com.facebook.reaction.feed.unitcomponents.spec.body;

import android.content.res.Resources;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import com.facebook.common.locale.Locales;
import com.facebook.common.time.SystemClock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.components.ComponentContext;
import com.facebook.components.ComponentLayout;
import com.facebook.components.Container;
import com.facebook.components.annotations.LayoutSpec;
import com.facebook.components.widget.Text;
import com.facebook.feed.environment.HasContext;
import com.facebook.graphql.querybuilder.common.CommonGraphQLInterfaces.DefaultTimeRangeFields;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.action.ReactionActionHandler;
import com.facebook.reaction.feed.environment.CanLaunchReactionIntent;
import com.facebook.reaction.feed.environment.HasReactionSession;
import com.facebook.reaction.feed.unitcomponents.util.ReactionActionClickableSpan;
import com.facebook.reaction.feed.unitcomponents.util.ReactionSpannableStringUtil;
import com.facebook.reaction.feed.unitcomponents.util.ReactionSpannableStringUtil.TokenReplacerProps;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitPlaceInfoBlurbWithBreadcrumbsComponentFragment.PlaceInfoBlurbBreadcrumbs;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitPlaceInfoBlurbWithBreadcrumbsComponentFragmentModel.PlaceInfoBlurbBreadcrumbsModel;
import com.google.common.collect.ImmutableList;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@LayoutSpec
/* compiled from: _instantiation */
public class ReactionPlaceInfoBlurbWithBreadcrumbsComponentSpec<E extends CanLaunchReactionIntent & HasContext & HasReactionSession> {
    private static volatile ReactionPlaceInfoBlurbWithBreadcrumbsComponentSpec f20358d;
    private final ReactionActionHandler f20359a;
    private final SystemClock f20360b;
    private final Locales f20361c;

    public static com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbWithBreadcrumbsComponentSpec m24174a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f20358d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbWithBreadcrumbsComponentSpec.class;
        monitor-enter(r1);
        r0 = f20358d;	 Catch:{ all -> 0x003a }
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
        r0 = m24176b(r0);	 Catch:{ all -> 0x0035 }
        f20358d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f20358d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbWithBreadcrumbsComponentSpec.a(com.facebook.inject.InjectorLike):com.facebook.reaction.feed.unitcomponents.spec.body.ReactionPlaceInfoBlurbWithBreadcrumbsComponentSpec");
    }

    private static ReactionPlaceInfoBlurbWithBreadcrumbsComponentSpec m24176b(InjectorLike injectorLike) {
        return new ReactionPlaceInfoBlurbWithBreadcrumbsComponentSpec(ReactionActionHandler.m22673a(injectorLike), SystemClockMethodAutoProvider.a(injectorLike), Locales.a(injectorLike));
    }

    @Inject
    public ReactionPlaceInfoBlurbWithBreadcrumbsComponentSpec(ReactionActionHandler reactionActionHandler, SystemClock systemClock, Locales locales) {
        this.f20359a = reactionActionHandler;
        this.f20360b = systemClock;
        this.f20361c = locales;
    }

    protected final ComponentLayout m24177a(ComponentContext componentContext, ImmutableList<PlaceInfoBlurbBreadcrumbs> immutableList, String str, ImmutableList<? extends DefaultTimeRangeFields> immutableList2, String str2, double d, double d2, String str3, E e, String str4, String str5) {
        Resources resources = componentContext.getResources();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append(str);
        if (m24175a((ImmutableList) immutableList)) {
            spannableStringBuilder.append(resources.getString(2131237290));
            if (immutableList.size() > 1) {
                spannableStringBuilder.append(m24173a(immutableList, e, str4, str5, resources));
            } else {
                ReactionSpannableStringUtil.m24376a(spannableStringBuilder, ((PlaceInfoBlurbBreadcrumbsModel) immutableList.get(0)).b().a(), ((PlaceInfoBlurbBreadcrumbsModel) immutableList.get(0)).a() == null ? null : new ReactionActionClickableSpan(((PlaceInfoBlurbBreadcrumbsModel) immutableList.get(0)).a(), this.f20359a, e, str4, str5));
            }
        }
        return Container.a(componentContext).C(0).F(2130773596).n(5, 2131431413).a(Text.a(componentContext).o(2131427400).l(2131362106).a(Alignment.ALIGN_CENTER).a(spannableStringBuilder).b()).a(Text.a(componentContext).o(2131427400).l(2131362106).a(Alignment.ALIGN_CENTER).a(ReactionSpannableStringUtil.m24372a(this.f20360b, this.f20361c.a(), immutableList2, str2, d, d2, str3, componentContext.getResources())).b()).j();
    }

    private static boolean m24175a(ImmutableList<PlaceInfoBlurbBreadcrumbs> immutableList) {
        if (immutableList.isEmpty()) {
            return false;
        }
        int size = immutableList.size();
        for (int i = 0; i < size; i++) {
            PlaceInfoBlurbBreadcrumbsModel placeInfoBlurbBreadcrumbsModel = (PlaceInfoBlurbBreadcrumbsModel) immutableList.get(i);
            if (placeInfoBlurbBreadcrumbsModel.b() == null || TextUtils.isEmpty(placeInfoBlurbBreadcrumbsModel.b().a())) {
                return false;
            }
        }
        return true;
    }

    private SpannableString m24173a(ImmutableList<PlaceInfoBlurbBreadcrumbs> immutableList, E e, String str, String str2, Resources resources) {
        PlaceInfoBlurbBreadcrumbsModel placeInfoBlurbBreadcrumbsModel = (PlaceInfoBlurbBreadcrumbsModel) immutableList.get(0);
        PlaceInfoBlurbBreadcrumbsModel placeInfoBlurbBreadcrumbsModel2 = (PlaceInfoBlurbBreadcrumbsModel) immutableList.get(1);
        String string = resources.getString(2131237291, new Object[]{"{neighborhood}", "{city}"});
        TokenReplacerProps[] tokenReplacerPropsArr = new TokenReplacerProps[2];
        tokenReplacerPropsArr[0] = new TokenReplacerProps("{neighborhood}", placeInfoBlurbBreadcrumbsModel.b().a(), placeInfoBlurbBreadcrumbsModel.a() == null ? null : new ReactionActionClickableSpan(placeInfoBlurbBreadcrumbsModel.a(), this.f20359a, e, str, str2));
        tokenReplacerPropsArr[1] = new TokenReplacerProps("{city}", placeInfoBlurbBreadcrumbsModel2.b().a(), placeInfoBlurbBreadcrumbsModel2.a() == null ? null : new ReactionActionClickableSpan(placeInfoBlurbBreadcrumbsModel2.a(), this.f20359a, e, str, str2));
        return ReactionSpannableStringUtil.m24368a(string, resources, tokenReplacerPropsArr);
    }
}

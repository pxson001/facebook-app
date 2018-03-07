package com.facebook.fbreact.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.facebook.base.activity.ReactFragmentActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.fbreact.fragment.ImmersiveReactFragment;
import com.facebook.fbreact.fragment.ImmersiveReactFragment.Builder;
import com.facebook.fbreact.fragment.ReactActivity;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import javax.inject.Inject;
import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: anon_id */
public class FbReactNavigationUriIntentBuilder extends UriIntentBuilder {
    private static volatile FbReactNavigationUriIntentBuilder f19644b;
    private final Provider<Boolean> f19645a;

    public static com.facebook.fbreact.navigation.FbReactNavigationUriIntentBuilder m19920a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f19644b;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.fbreact.navigation.FbReactNavigationUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f19644b;	 Catch:{ all -> 0x003a }
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
        r0 = m19922b(r0);	 Catch:{ all -> 0x0035 }
        f19644b = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f19644b;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.fbreact.navigation.FbReactNavigationUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.fbreact.navigation.FbReactNavigationUriIntentBuilder");
    }

    private static FbReactNavigationUriIntentBuilder m19922b(InjectorLike injectorLike) {
        return new FbReactNavigationUriIntentBuilder(IdBasedProvider.a(injectorLike, 3967));
    }

    @Inject
    public FbReactNavigationUriIntentBuilder(Provider<Boolean> provider) {
        this.f19645a = provider;
        String str = FBLinks.en;
        Builder newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "AnniversaryVideoRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = FBLinks.ep;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "FriendsDayRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = StringFormatUtil.formatStrLocaleSafe(FBLinks.er, "{campaign_id}", "{campaign_type}", "{direct_source}");
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "GoodwillVideoCardEditorRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = FBLinks.fm;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "TopicCustomizationRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = FBLinks.n;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "AdsManagerCampaignGroupInsightsRoute";
        newBuilder = newBuilder;
        newBuilder.d = 2131233964;
        m19921a(str, newBuilder.a());
        str = FBLinks.p;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "AdsManagerImagePickerRoute";
        newBuilder = newBuilder;
        newBuilder.d = 2131234052;
        newBuilder = newBuilder;
        newBuilder.h = 1;
        newBuilder = newBuilder;
        newBuilder.i = "AMAImagePickerFinishSelection";
        newBuilder = newBuilder;
        newBuilder.j = 2131233985;
        m19921a(str, newBuilder.a());
        str = FBLinks.eh;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "PokesDashboardRoute";
        newBuilder = newBuilder;
        newBuilder.d = 2131241961;
        newBuilder = newBuilder;
        newBuilder.e = true;
        m19921a(str, newBuilder.a());
        str = FBLinks.fl;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "SampleIntegrationAppRoute";
        m19923b(str, newBuilder.a());
        str = FBLinks.eH;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "ShopsFeedRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        newBuilder = newBuilder;
        newBuilder.d = 2131234807;
        m19921a(str, newBuilder.a());
        str = FBLinks.ei;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "PageServiceAddEditRoute";
        newBuilder = newBuilder;
        newBuilder.d = 2131235513;
        newBuilder = newBuilder;
        newBuilder.j = 2131235377;
        newBuilder = newBuilder;
        newBuilder.i = "PageServiceAddEditSaveSelection";
        m19921a(str, newBuilder.a());
        str = FBLinks.fG;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "LocalSellHomeRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = StringFormatUtil.formatStrLocaleSafe(FBLinks.fH, "{assetIDs}");
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "LocalSellComposerRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = StringFormatUtil.formatStrLocaleSafe(FBLinks.fI, "{storyID}", "{referralSurface}");
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "LocalSellEditComposerRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = FBLinks.fJ;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "LocalSellForSaleGroupsHomeRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = FBLinks.fL;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "LocalSellProductDetailsRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = FBLinks.fM;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "LocalSellMessageRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = FBLinks.fO;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "LocalSellProductMessageThreadsRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19921a(str, newBuilder.a());
        str = FBLinks.fY;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "MarketplaceNotificationsRoute";
        newBuilder = newBuilder;
        newBuilder.d = 2131241960;
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19921a(str, newBuilder.a());
        str = FBLinks.fP;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "LocalSellInitialMessageRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = FBLinks.fQ;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "LocalSellLocationRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = FBLinks.fR;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "MarketplaceSearchRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = FBLinks.fS;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "SearchTypeaheadResultsRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = FBLinks.fT;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "LocalSellCategorySearchRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = FBLinks.fV;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "LocalSellSavedSearchResultsRoute";
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19923b(str, newBuilder.a());
        str = FBLinks.fU;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "MarketplaceSavedItemsRoute";
        newBuilder = newBuilder;
        newBuilder.d = 2131238120;
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19921a(str, newBuilder.a());
        str = FBLinks.fW;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "MarketplaceCategoryBrowseRoute";
        newBuilder = newBuilder;
        newBuilder.d = 2131241958;
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19921a(str, newBuilder.a());
        str = FBLinks.fX;
        newBuilder = ImmersiveReactFragment.newBuilder();
        newBuilder.b = "MarketplaceYourItemsRoute";
        newBuilder = newBuilder;
        newBuilder.d = 2131241959;
        newBuilder = newBuilder;
        newBuilder.h = 1;
        m19921a(str, newBuilder.a());
    }

    public final Intent m19924a(Context context, String str) {
        Intent a = super.a(context, str);
        if (a != null && str.startsWith(FBLinks.b)) {
            a.putExtra("uri", str.substring(FBLinks.b.length() - 1));
        }
        return a;
    }

    protected final boolean m19925a() {
        return ((Boolean) this.f19645a.get()).booleanValue();
    }

    private void m19921a(String str, Bundle bundle) {
        a(str, ReactFragmentActivity.class, ContentFragmentType.IMMERSIVE_REACT_FRAGMENT.ordinal(), bundle);
    }

    private void m19923b(String str, Bundle bundle) {
        a(str, ReactActivity.class, bundle);
    }
}

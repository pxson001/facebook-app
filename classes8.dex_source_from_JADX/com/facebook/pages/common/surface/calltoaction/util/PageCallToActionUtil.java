package com.facebook.pages.common.surface.calltoaction.util;

import android.content.Context;
import android.os.Handler;
import android.support.v4.app.FragmentManager;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout.LayoutParams;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLPageCallToActionActionType;
import com.facebook.graphql.enums.GraphQLPageCallToActionType;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionAdminConfigModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionAdminConfigModel.ConfigFieldsModel.NodesModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.CallToActionConfigFieldsModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PageAdminCallToActionModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PageAdminCallToActionModel.PageCallToActionModel.CtaAdminInfoModel.EligibleCallToActionsModel;
import com.facebook.pages.common.surface.calltoaction.graphql.PageAdminCallToActionGraphQLModels.PhoneNumberCommonFieldsModel;
import com.facebook.pages.common.surface.calltoaction.ui.PageCallToActionInputFieldsContainer;
import com.facebook.pages.data.graphql.pageheader.FetchPageHeaderGraphQLModels.PageCallToActionDataModel.PageCallToActionModel;
import com.facebook.pages.data.model.pageheader.PageHeaderData;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: could not extract TruncateAt from =  */
public final class PageCallToActionUtil {
    private static volatile PageCallToActionUtil f16884d;
    public Context f16885a;
    private Handler f16886b;
    private Lazy<FbErrorReporter> f16887c;

    /* compiled from: could not extract TruncateAt from =  */
    class C18291 implements Runnable {
        final /* synthetic */ PageCallToActionUtil f16881a;

        C18291(PageCallToActionUtil pageCallToActionUtil) {
            this.f16881a = pageCallToActionUtil;
        }

        public void run() {
            ((InputMethodManager) this.f16881a.f16885a.getSystemService("input_method")).toggleSoftInput(2, 0);
        }
    }

    /* compiled from: could not extract TruncateAt from =  */
    /* synthetic */ class C18302 {
        static final /* synthetic */ int[] f16882a = new int[GraphQLPageCallToActionActionType.values().length];
        static final /* synthetic */ int[] f16883b = new int[GraphQLPageCallToActionType.values().length];

        static {
            try {
                f16883b[GraphQLPageCallToActionType.CALL_NOW.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f16883b[GraphQLPageCallToActionType.MESSAGE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f16883b[GraphQLPageCallToActionType.EMAIL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f16883b[GraphQLPageCallToActionType.CONTACT_US.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f16882a[GraphQLPageCallToActionActionType.LEAD_GEN.ordinal()] = 1;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f16882a[GraphQLPageCallToActionActionType.PHONE_CALL.ordinal()] = 2;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f16882a[GraphQLPageCallToActionActionType.MESSENGER.ordinal()] = 3;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f16882a[GraphQLPageCallToActionActionType.EMAIL.ordinal()] = 4;
            } catch (NoSuchFieldError e8) {
            }
        }
    }

    /* compiled from: could not extract TruncateAt from =  */
    public enum PageCallToActionErrorState {
        NONE,
        EMPTY,
        INVALID,
        SERVER,
        UNKNOWN
    }

    public static com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil m20160a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f16884d;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.class;
        monitor-enter(r1);
        r0 = f16884d;	 Catch:{ all -> 0x003a }
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
        r0 = m20170b(r0);	 Catch:{ all -> 0x0035 }
        f16884d = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f16884d;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil.a(com.facebook.inject.InjectorLike):com.facebook.pages.common.surface.calltoaction.util.PageCallToActionUtil");
    }

    private static PageCallToActionUtil m20170b(InjectorLike injectorLike) {
        return new PageCallToActionUtil((Context) injectorLike.getInstance(Context.class), IdBasedSingletonScopeProvider.b(injectorLike, 494), Handler_ForUiThreadMethodAutoProvider.b(injectorLike));
    }

    @Inject
    public PageCallToActionUtil(Context context, Lazy<FbErrorReporter> lazy, Handler handler) {
        this.f16885a = context;
        this.f16887c = lazy;
        this.f16886b = handler;
    }

    public static boolean m20169a(String str) {
        if (StringUtil.a(str)) {
            return false;
        }
        return Patterns.WEB_URL.matcher(str).find();
    }

    public static String m20172c(String str) {
        if (StringUtil.a(str)) {
            return str;
        }
        String toLowerCase = str.trim().toLowerCase(Locale.US);
        if (!(toLowerCase.startsWith("http://") || toLowerCase.startsWith("https://"))) {
            toLowerCase = "http://" + toLowerCase;
        }
        return toLowerCase;
    }

    public static String m20174d(String str) {
        return StringUtil.a(str) ? str : str.trim().toLowerCase(Locale.US);
    }

    public final void m20177a() {
        HandlerDetour.b(this.f16886b, new C18291(this), 250, -246356777);
    }

    public final void m20178a(View view) {
        ((InputMethodManager) this.f16885a.getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public final FbTextView m20176a(CharSequence charSequence, ViewGroup viewGroup) {
        FbTextView a = m20161a(charSequence, viewGroup, 2131427442);
        a.setTextAppearance(this.f16885a, 2131626257);
        return a;
    }

    public final FbTextView m20182b(CharSequence charSequence, ViewGroup viewGroup) {
        FbTextView a = m20161a(charSequence, viewGroup, 2131427443);
        a.setTextAppearance(this.f16885a, 2131626258);
        return a;
    }

    public final FbTextView m20183c(CharSequence charSequence, ViewGroup viewGroup) {
        FbTextView a = m20161a(charSequence, viewGroup, 2131427416);
        a.setTextAppearance(this.f16885a, 2131626259);
        return a;
    }

    public static boolean m20168a(PageHeaderData pageHeaderData) {
        return (pageHeaderData == null || pageHeaderData.f17308e == null || pageHeaderData.f17308e.m20884G() == null) ? false : true;
    }

    public final boolean m20180a(PageHeaderData pageHeaderData, List<GraphQLPageCallToActionType> list) {
        return m20168a(pageHeaderData) && list.contains(pageHeaderData.f17308e.m20884G().m21019g());
    }

    private FbTextView m20161a(CharSequence charSequence, ViewGroup viewGroup, int i) {
        FbTextView fbTextView = (FbTextView) LayoutInflater.from(this.f16885a).inflate(2130905995, viewGroup, false);
        fbTextView.setText(charSequence);
        LayoutParams layoutParams = (LayoutParams) fbTextView.getLayoutParams();
        layoutParams.setMargins(0, (int) this.f16885a.getResources().getDimension(i), 0, 0);
        fbTextView.setLayoutParams(layoutParams);
        return fbTextView;
    }

    public final int m20181b(PhoneNumberCommonFieldsModel phoneNumberCommonFieldsModel) {
        if (!(phoneNumberCommonFieldsModel == null || phoneNumberCommonFieldsModel.m19908j() == null)) {
            try {
                return Integer.parseInt(phoneNumberCommonFieldsModel.m19908j());
            } catch (Throwable e) {
                ((AbstractFbErrorReporter) this.f16887c.get()).a(PageCallToActionInputFieldsContainer.class.getSimpleName(), e);
            }
        }
        return -1;
    }

    public final void m20179a(CallToActionAdminConfigModel callToActionAdminConfigModel, PageCallToActionInputFieldsContainer pageCallToActionInputFieldsContainer, PhoneNumberCommonFieldsModel phoneNumberCommonFieldsModel, String str, boolean z) {
        if (callToActionAdminConfigModel != null && callToActionAdminConfigModel.m19785a() != null) {
            ImmutableList a = callToActionAdminConfigModel.m19785a().m19768a();
            int size = a.size();
            for (int i = 0; i < size; i++) {
                NodesModel nodesModel = (NodesModel) a.get(i);
                if (nodesModel.m19763j() != null) {
                    GraphQLPageCallToActionActionType a2 = nodesModel.m19760a();
                    if (!z || a2 != GraphQLPageCallToActionActionType.WEBSITE) {
                        if (z) {
                            continue;
                        } else {
                            Object obj;
                            if (a2 == GraphQLPageCallToActionActionType.LEAD_GEN || a2 == GraphQLPageCallToActionActionType.PHONE_CALL || a2 == GraphQLPageCallToActionActionType.MESSENGER || a2 == GraphQLPageCallToActionActionType.EMAIL) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                            }
                        }
                    }
                    pageCallToActionInputFieldsContainer.m20082a(phoneNumberCommonFieldsModel, m20162a(nodesModel, callToActionAdminConfigModel.m19789m()), nodesModel.m19763j().m19757a(), str);
                    return;
                }
            }
        }
    }

    private String m20162a(NodesModel nodesModel, String str) {
        switch (C18302.f16882a[nodesModel.m19760a().ordinal()]) {
            case 1:
                return this.f16885a.getResources().getString(2131239558);
            case 2:
                return this.f16885a.getResources().getString(2131239559);
            case 3:
                return this.f16885a.getResources().getString(2131239560);
            case 4:
                return this.f16885a.getResources().getString(2131239561);
            default:
                return str;
        }
    }

    public static NodesModel m20159a(GraphQLPageCallToActionActionType graphQLPageCallToActionActionType, CallToActionAdminConfigModel callToActionAdminConfigModel) {
        if (callToActionAdminConfigModel == null || callToActionAdminConfigModel.m19785a() == null || callToActionAdminConfigModel.m19785a().m19768a() == null) {
            return null;
        }
        ImmutableList a = callToActionAdminConfigModel.m19785a().m19768a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) a.get(i);
            if (nodesModel.m19760a().equals(graphQLPageCallToActionActionType)) {
                return nodesModel;
            }
        }
        return null;
    }

    public static String m20163a(boolean z, GraphQLPageCallToActionType graphQLPageCallToActionType) {
        if (z) {
            return "cta_linkout_view";
        }
        switch (C18302.f16883b[graphQLPageCallToActionType.ordinal()]) {
            case 1:
                return "cta_phone_view";
            case 2:
                return "cta_message_view";
            case 3:
                return "cta_email_view";
            default:
                return "cta_leadgen_view";
        }
    }

    @Nullable
    public static ImmutableList<CallToActionConfigFieldsModel> m20175e(CallToActionAdminConfigModel callToActionAdminConfigModel) {
        if (callToActionAdminConfigModel == null || callToActionAdminConfigModel.m19785a() == null || callToActionAdminConfigModel.m19785a().m19768a() == null) {
            return null;
        }
        ImmutableList a = callToActionAdminConfigModel.m19785a().m19768a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            NodesModel nodesModel = (NodesModel) a.get(i);
            if (nodesModel.m19763j() != null && nodesModel.m19760a().equals(GraphQLPageCallToActionActionType.WEBSITE)) {
                return nodesModel.m19763j().m19757a();
            }
        }
        return null;
    }

    public static boolean m20173c(PageAdminCallToActionModel pageAdminCallToActionModel) {
        return pageAdminCallToActionModel.m19902l() == null || StringUtil.a(pageAdminCallToActionModel.m19902l().m19892m());
    }

    public static LinkedHashMap<String, List<CallToActionAdminConfigModel>> m20164a(EligibleCallToActionsModel eligibleCallToActionsModel) {
        Preconditions.checkNotNull(eligibleCallToActionsModel);
        LinkedHashMap<String, List<CallToActionAdminConfigModel>> linkedHashMap = new LinkedHashMap();
        ImmutableList a = eligibleCallToActionsModel.m19877a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            boolean z;
            CallToActionAdminConfigModel callToActionAdminConfigModel = (CallToActionAdminConfigModel) a.get(i);
            CharSequence k = callToActionAdminConfigModel.m19787k();
            if (StringUtil.a(k)) {
                z = false;
            } else {
                z = true;
            }
            Preconditions.checkArgument(z);
            if (linkedHashMap.containsKey(k)) {
                ((List) linkedHashMap.get(k)).add(callToActionAdminConfigModel);
            } else {
                List arrayList = new ArrayList();
                arrayList.add(callToActionAdminConfigModel);
                linkedHashMap.put(k, arrayList);
            }
        }
        return linkedHashMap;
    }

    public static boolean m20167a(PageCallToActionModel pageCallToActionModel) {
        return (pageCallToActionModel == null || m20166a(pageCallToActionModel.m21019g()) || pageCallToActionModel.kD_() == null) ? false : true;
    }

    public static boolean m20171b(PageCallToActionModel pageCallToActionModel) {
        switch (C18302.f16883b[pageCallToActionModel.m21019g().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return true;
            case 4:
                return (pageCallToActionModel.m21020j() == null || pageCallToActionModel.m21020j().m21008a() == null || pageCallToActionModel.m21020j().m21008a().isEmpty()) ? false : true;
            default:
                return false;
        }
    }

    public static boolean m20166a(GraphQLPageCallToActionType graphQLPageCallToActionType) {
        return graphQLPageCallToActionType == GraphQLPageCallToActionType.UNSET_OR_UNRECOGNIZED_ENUM_VALUE || graphQLPageCallToActionType == GraphQLPageCallToActionType.NONE;
    }

    public static void m20165a(FragmentManager fragmentManager, FbFragment fbFragment, FbFragment fbFragment2) {
        fragmentManager.a().a(2130968748, 2130968757, 2130968747, 2130968758).b(fbFragment.H, fbFragment2).a(null).b();
    }
}

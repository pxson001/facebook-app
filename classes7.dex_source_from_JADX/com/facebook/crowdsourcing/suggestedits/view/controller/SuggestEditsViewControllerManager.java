package com.facebook.crowdsourcing.suggestedits.view.controller;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.crowdsourcing.enums.SuggestEditsInputType;
import com.facebook.crowdsourcing.enums.SuggestEditsListViewType;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsInterfaces.SuggestEditsSections;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsSectionModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsSectionModel.FieldSectionsModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsSectionsModel;
import com.facebook.crowdsourcing.protocol.graphql.SuggestEditsModels.SuggestEditsSectionsModel.CrowdsourcingSuggestEditsCardsModel.EdgesModel;
import com.facebook.crowdsourcing.suggestedits.controller.SuggestEditsController;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldHolder;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsFieldHolderProvider;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsHeaderHolder;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsHeaderHolderProvider;
import com.facebook.crowdsourcing.suggestedits.data.SuggestEditsHeaderState;
import com.facebook.crowdsourcing.suggestedits.helper.FieldTypesHelper;
import com.facebook.crowdsourcing.suggestedits.helper.SuggestEditsSupportedFieldOptions;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestEditsFieldChangedListener;
import com.facebook.crowdsourcing.suggestedits.listener.SuggestionEditedListener;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.MultiBinderSet;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbButton;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.Maps;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
/* compiled from: characters */
public class SuggestEditsViewControllerManager {
    public static final Class<?> f17834a = SuggestEditsViewControllerManager.class;
    private static volatile SuggestEditsViewControllerManager f17835h;
    private final SuggestEditsFieldHolderProvider f17836b;
    private final SuggestEditsHeaderHolderProvider f17837c;
    public final UriIntentMapper f17838d;
    public final SecureContextHelper f17839e;
    public final AbstractFbErrorReporter f17840f;
    public Map<SuggestEditsListViewType, SuggestEditsViewController> f17841g = Maps.c();

    /* compiled from: characters */
    class C15071 implements SuggestEditsFieldChangedListener {
        final /* synthetic */ SuggestEditsViewControllerManager f17830a;

        C15071(SuggestEditsViewControllerManager suggestEditsViewControllerManager) {
            this.f17830a = suggestEditsViewControllerManager;
        }

        public final void mo1369a(Object obj) {
        }

        public final String mo1368a() {
            return "";
        }
    }

    public static com.facebook.crowdsourcing.suggestedits.view.controller.SuggestEditsViewControllerManager m21665a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
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
        r0 = f17835h;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r1 = com.facebook.crowdsourcing.suggestedits.view.controller.SuggestEditsViewControllerManager.class;
        monitor-enter(r1);
        r0 = f17835h;	 Catch:{ all -> 0x003a }
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
        r0 = m21668b(r0);	 Catch:{ all -> 0x0035 }
        f17835h = r0;	 Catch:{ all -> 0x0035 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0031:
        monitor-exit(r1);	 Catch:{  }
    L_0x0032:
        r0 = f17835h;
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
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.crowdsourcing.suggestedits.view.controller.SuggestEditsViewControllerManager.a(com.facebook.inject.InjectorLike):com.facebook.crowdsourcing.suggestedits.view.controller.SuggestEditsViewControllerManager");
    }

    private static SuggestEditsViewControllerManager m21668b(InjectorLike injectorLike) {
        return new SuggestEditsViewControllerManager(new MultiBinderSet(injectorLike.getScopeAwareInjector(), new STATICDI_MULTIBIND_PROVIDER$SuggestEditsViewController(injectorLike)), (SuggestEditsFieldHolderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SuggestEditsFieldHolderProvider.class), (SuggestEditsHeaderHolderProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(SuggestEditsHeaderHolderProvider.class), (UriIntentMapper) Fb4aUriIntentMapper.a(injectorLike), (SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public SuggestEditsViewControllerManager(Set<SuggestEditsViewController> set, SuggestEditsFieldHolderProvider suggestEditsFieldHolderProvider, SuggestEditsHeaderHolderProvider suggestEditsHeaderHolderProvider, UriIntentMapper uriIntentMapper, SecureContextHelper secureContextHelper, FbErrorReporter fbErrorReporter) {
        for (SuggestEditsViewController suggestEditsViewController : set) {
            this.f17841g.put(suggestEditsViewController.mo1371a(), suggestEditsViewController);
        }
        this.f17836b = suggestEditsFieldHolderProvider;
        this.f17837c = suggestEditsHeaderHolderProvider;
        this.f17838d = uriIntentMapper;
        this.f17839e = secureContextHelper;
        this.f17840f = fbErrorReporter;
    }

    private View m21664a(ViewGroup viewGroup, SuggestEditsListViewType suggestEditsListViewType) {
        SuggestEditsViewController suggestEditsViewController = (SuggestEditsViewController) this.f17841g.get(suggestEditsListViewType);
        if (suggestEditsViewController != null) {
            return suggestEditsViewController.mo1370a(viewGroup);
        }
        throw new IllegalArgumentException("No view viewController defined for view type: " + suggestEditsListViewType);
    }

    public final void m21672a(View view, Object obj, @Nullable Object obj2, SuggestEditsListViewType suggestEditsListViewType, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener, SuggestEditsController suggestEditsController, @Nullable SuggestEditsInputType suggestEditsInputType, Fragment fragment, String str) {
        SuggestEditsViewController suggestEditsViewController = (SuggestEditsViewController) this.f17841g.get(suggestEditsListViewType);
        if (suggestEditsViewController == null) {
            throw new IllegalArgumentException("No view viewController defined for view type: " + suggestEditsListViewType);
        }
        suggestEditsViewController.mo1373a(view, obj, obj2, suggestEditsFieldChangedListener, suggestEditsController, suggestEditsInputType, fragment, str);
    }

    public final void m21671a(View view, Object obj, SuggestEditsListViewType suggestEditsListViewType, SuggestEditsFieldChangedListener suggestEditsFieldChangedListener) {
        SuggestEditsViewController suggestEditsViewController = (SuggestEditsViewController) this.f17841g.get(suggestEditsListViewType);
        if (suggestEditsViewController == null) {
            throw new IllegalArgumentException("No view viewController defined for view type: " + suggestEditsListViewType);
        }
        suggestEditsViewController.mo1372a(view, obj, suggestEditsFieldChangedListener);
    }

    public final SuggestEditsHeaderHolder m21669a(Fragment fragment, SuggestEditsController suggestEditsController, LinearLayout linearLayout, SuggestEditsHeaderState suggestEditsHeaderState, String str) {
        SuggestEditsListViewType suggestEditsListViewType = SuggestEditsListViewType.PAGE_HEADER;
        View a = m21664a(linearLayout, suggestEditsListViewType);
        SuggestEditsHeaderHolder a2 = this.f17837c.m21515a(fragment, suggestEditsController, a, suggestEditsHeaderState, str);
        m21672a(a, a2, null, suggestEditsListViewType, a2, suggestEditsController, null, fragment, str);
        linearLayout.addView(a, 0);
        return a2;
    }

    public final ImmutableList<SuggestEditsFieldHolder> m21670a(Fragment fragment, SuggestionEditedListener suggestionEditedListener, LinearLayout linearLayout, SuggestEditsSections suggestEditsSections, String str) {
        if (suggestEditsSections.m2874a() == null || suggestEditsSections.m2874a().m2869a().isEmpty()) {
            m21666a(linearLayout);
            return ImmutableList.of();
        }
        Object obj = 1;
        Builder builder = ImmutableList.builder();
        ImmutableList a = suggestEditsSections.m2874a().m2869a();
        int size = a.size();
        int i = 0;
        while (i < size) {
            Object obj2;
            SuggestEditsSectionModel a2 = ((EdgesModel) a.get(i)).m2864a();
            if (!(a2 == null || a2.m2856a() == null)) {
                int i2 = 0;
                ImmutableList a3 = a2.m2856a().m2852a();
                int size2 = a3.size();
                int i3 = 0;
                while (i3 < size2) {
                    int i4;
                    FieldSectionsModel.EdgesModel edgesModel = (FieldSectionsModel.EdgesModel) a3.get(i3);
                    if (edgesModel.m2847a() != null && FieldTypesHelper.m21545b(edgesModel.m2847a()) && SuggestEditsSupportedFieldOptions.m21552a(edgesModel.m2847a().ew_())) {
                        SuggestEditsListViewType a4 = FieldTypesHelper.m21544a(edgesModel.m2847a());
                        SuggestEditsInputType c = FieldTypesHelper.m21546c(edgesModel.m2847a());
                        View a5 = m21664a(linearLayout, a4);
                        SuggestEditsFieldChangedListener a6 = this.f17836b.m21490a(fragment, suggestionEditedListener, edgesModel.m2847a(), c, a5, a4, str);
                        m21672a(a5, edgesModel.m2847a(), null, a4, a6, suggestionEditedListener, c, fragment, str);
                        linearLayout.addView(a5);
                        builder.c(a6);
                        i4 = i2 + 1;
                    } else {
                        i4 = i2;
                    }
                    i3++;
                    i2 = i4;
                }
                if (i2 > 0) {
                    View a7 = m21664a(linearLayout, SuggestEditsListViewType.SECTION_TITLE);
                    m21672a(a7, a2.m2858b(), null, SuggestEditsListViewType.SECTION_TITLE, new C15071(this), suggestionEditedListener, null, fragment, str);
                    if (obj == null) {
                        linearLayout.addView(LayoutInflater.from(linearLayout.getContext()).inflate(2130907299, linearLayout, false), linearLayout.getChildCount() - i2);
                    }
                    linearLayout.addView(a7, linearLayout.getChildCount() - i2);
                    obj2 = null;
                    i++;
                    obj = obj2;
                }
            }
            obj2 = obj;
            i++;
            obj = obj2;
        }
        m21667a(linearLayout, str, suggestEditsSections);
        return builder.b();
    }

    private static void m21666a(LinearLayout linearLayout) {
        LayoutInflater.from(linearLayout.getContext()).inflate(2130907295, linearLayout, true);
    }

    private void m21667a(final LinearLayout linearLayout, final String str, SuggestEditsSectionsModel suggestEditsSectionsModel) {
        FbButton fbButton = (FbButton) LayoutInflater.from(linearLayout.getContext()).inflate(2130907308, linearLayout, false);
        linearLayout.addView(fbButton);
        if (suggestEditsSectionsModel.m2879b() > 0) {
            fbButton.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ SuggestEditsViewControllerManager f17833c;

                public void onClick(View view) {
                    int a = Logger.a(2, EntryType.UI_INPUT_START, -104124521);
                    Intent a2 = this.f17833c.f17838d.a(linearLayout.getContext(), StringFormatUtil.a(FBLinks.ak, new Object[]{str}));
                    if (a2 != null) {
                        this.f17833c.f17839e.a(a2, linearLayout.getContext());
                    } else {
                        this.f17833c.f17840f.a(SuggestEditsViewControllerManager.f17834a.getSimpleName(), "Could not open the recent edits view because the intent was null");
                    }
                    LogUtils.a(-1417585566, a);
                }
            });
        } else {
            fbButton.setEnabled(false);
        }
    }
}

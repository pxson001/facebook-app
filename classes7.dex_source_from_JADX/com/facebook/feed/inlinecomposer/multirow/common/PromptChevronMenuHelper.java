package com.facebook.feed.inlinecomposer.multirow.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.common.propertybag.PropertyBag;
import com.facebook.common.util.ContextUtils;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLInterfaces.DefaultTextWithEntitiesLongFields.Ranges;
import com.facebook.inject.ContextScope;
import com.facebook.inject.ContextScoped;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.InjectorThreadStack;
import com.facebook.inject.Lazy;
import com.facebook.inject.ProvisioningException;
import com.facebook.inject.ScopeSet;
import com.facebook.ipc.productionprompts.ui.v2.PromptPartDefinitionProps;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.negativefeedback.video.ui.SystemUIAwareDialogHelper;
import com.facebook.productionprompts.events.PromptsDismissEvent;
import com.facebook.productionprompts.events.PromptsEventBus;
import com.facebook.productionprompts.logging.PromptAnalytics;
import com.facebook.productionprompts.logging.PromptImpressionLoggingSessionIdMap;
import com.facebook.productionprompts.model.PromptDisplayReason;
import com.facebook.widget.bottomsheet.BottomSheetAdapter;
import com.facebook.widget.bottomsheet.BottomSheetDialog;
import javax.inject.Inject;
import javax.inject.Provider;

@ContextScoped
/* compiled from: android.media.intent.category.LIVE_VIDEO */
public class PromptChevronMenuHelper {
    private static PromptChevronMenuHelper f19291e;
    private static final Object f19292f = new Object();
    public final Provider<PromptsEventBus> f19293a;
    public final Provider<BottomSheetDialog> f19294b;
    public final Provider<PromptImpressionLoggingSessionIdMap> f19295c;
    public final Lazy<SecureContextHelper> f19296d;

    /* compiled from: android.media.intent.category.LIVE_VIDEO */
    public class C16752 implements OnMenuItemClickListener {
        final /* synthetic */ PromptPartDefinitionProps f19286a;
        final /* synthetic */ PromptChevronMenuHelper f19287b;

        public C16752(PromptChevronMenuHelper promptChevronMenuHelper, PromptPartDefinitionProps promptPartDefinitionProps) {
            this.f19287b = promptChevronMenuHelper;
            this.f19286a = promptPartDefinitionProps;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            ((PromptsEventBus) this.f19287b.f19293a.get()).a(new PromptsDismissEvent(this.f19286a.a, PromptAnalytics.a(this.f19286a.a, ((PromptImpressionLoggingSessionIdMap) this.f19287b.f19295c.get()).a(this.f19286a.a.a.b())), false, true));
            return true;
        }
    }

    /* compiled from: android.media.intent.category.LIVE_VIDEO */
    public class C16763 implements OnMenuItemClickListener {
        final /* synthetic */ PromptDisplayReason f19288a;
        final /* synthetic */ Context f19289b;
        final /* synthetic */ PromptChevronMenuHelper f19290c;

        public C16763(PromptChevronMenuHelper promptChevronMenuHelper, PromptDisplayReason promptDisplayReason, Context context) {
            this.f19290c = promptChevronMenuHelper;
            this.f19288a = promptDisplayReason;
            this.f19289b = context;
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            ((SecureContextHelper) this.f19290c.f19296d.get()).a(new Intent().setData(Uri.parse(((Ranges) this.f19288a.textWithEntities.b().get(0)).a().D_())), this.f19289b);
            return true;
        }
    }

    private static PromptChevronMenuHelper m22774b(InjectorLike injectorLike) {
        return new PromptChevronMenuHelper(IdBasedSingletonScopeProvider.a(injectorLike, 3151), IdBasedProvider.a(injectorLike, 11752), IdBasedSingletonScopeProvider.a(injectorLike, 3153), IdBasedSingletonScopeProvider.b(injectorLike, 968));
    }

    @Inject
    public PromptChevronMenuHelper(Provider<PromptsEventBus> provider, Provider<BottomSheetDialog> provider2, Provider<PromptImpressionLoggingSessionIdMap> provider3, Lazy<SecureContextHelper> lazy) {
        this.f19293a = provider;
        this.f19294b = provider2;
        this.f19295c = provider3;
        this.f19296d = lazy;
    }

    public static PromptChevronMenuHelper m22773a(InjectorLike injectorLike) {
        ScopeSet a = ScopeSet.a();
        byte b = a.b((byte) 8);
        try {
            Context b2 = injectorLike.getScopeAwareInjector().b();
            if (b2 == null) {
                throw new ProvisioningException("Called context scoped provider outside of context scope");
            }
            PromptChevronMenuHelper b3;
            ContextScope contextScope = (ContextScope) injectorLike.getInstance(ContextScope.class);
            PropertyBag a2 = ContextScope.a(b2);
            synchronized (f19292f) {
                PromptChevronMenuHelper promptChevronMenuHelper;
                if (a2 != null) {
                    promptChevronMenuHelper = (PromptChevronMenuHelper) a2.a(f19292f);
                } else {
                    promptChevronMenuHelper = f19291e;
                }
                if (promptChevronMenuHelper == null) {
                    InjectorThreadStack injectorThreadStack = injectorLike.getInjectorThreadStack();
                    contextScope.a(b2, injectorThreadStack);
                    try {
                        b3 = m22774b(injectorThreadStack.e());
                        if (a2 != null) {
                            a2.a(f19292f, b3);
                        } else {
                            f19291e = b3;
                        }
                    } finally {
                        ContextScope.a(injectorThreadStack);
                    }
                } else {
                    b3 = promptChevronMenuHelper;
                }
            }
            return b3;
        } finally {
            a.c(b);
        }
    }

    public final OnClickListener m22775a(final PromptPartDefinitionProps promptPartDefinitionProps) {
        return new OnClickListener(this) {
            final /* synthetic */ PromptChevronMenuHelper f19285b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1632595069);
                PromptChevronMenuHelper promptChevronMenuHelper = this.f19285b;
                PromptPartDefinitionProps promptPartDefinitionProps = promptPartDefinitionProps;
                BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) promptChevronMenuHelper.f19294b.get();
                Activity activity = (Activity) ContextUtils.a(bottomSheetDialog.getContext(), Activity.class);
                if (!(activity == null || activity.isFinishing())) {
                    Object obj;
                    Adapter bottomSheetAdapter = new BottomSheetAdapter(activity);
                    if (promptPartDefinitionProps == null || promptPartDefinitionProps.c == null) {
                        obj = null;
                    } else {
                        MenuItem add = bottomSheetAdapter.add(2131235735);
                        add.setIcon(2130839920);
                        add.setOnMenuItemClickListener(new C16752(promptChevronMenuHelper, promptPartDefinitionProps));
                        PromptDisplayReason h = promptPartDefinitionProps.c == null ? null : promptPartDefinitionProps.c.h();
                        if (!(h == null || h.textWithEntities == null || h.textWithEntities.a() == null)) {
                            MenuItem add2 = bottomSheetAdapter.add(2131235736);
                            if (add2 instanceof MenuItemImpl) {
                                ((MenuItemImpl) add2).a(h.b());
                            }
                            add2.setIcon(2130839943);
                            add2.setOnMenuItemClickListener(new C16763(promptChevronMenuHelper, h, activity));
                        }
                        obj = 1;
                    }
                    if (obj != null) {
                        bottomSheetDialog.m19815a(bottomSheetAdapter);
                        SystemUIAwareDialogHelper.a(bottomSheetDialog);
                    }
                }
                Logger.a(2, EntryType.UI_INPUT_END, 162143323, a);
            }
        };
    }
}

package com.facebook.orca.threadview;

import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.contextbanner.ContextItemsFuturesHelper;
import com.facebook.messaging.contextbanner.ui.ContextBannerView;
import com.facebook.messaging.threadview.rows.RowSocialContextItem;
import com.facebook.messaging.ui.name.ThreadNameViewComputer_DefaultThreadNameViewComputerMethodAutoProvider;
import com.facebook.orca.threadview.MessageListAdapter.C10763;
import java.util.concurrent.ExecutorService;
import javax.inject.Inject;

/* compiled from: more_section_id */
public class ContextBannerMessageListAdapterHelper {
    private final ContextItemsFuturesHelper f6889a;

    public static ContextBannerMessageListAdapterHelper m6519a(InjectorLike injectorLike) {
        return new ContextBannerMessageListAdapterHelper(new ContextItemsFuturesHelper((ExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), ThreadNameViewComputer_DefaultThreadNameViewComputerMethodAutoProvider.b(injectorLike)));
    }

    @Inject
    public ContextBannerMessageListAdapterHelper(ContextItemsFuturesHelper contextItemsFuturesHelper) {
        this.f6889a = contextItemsFuturesHelper;
    }

    public final void m6520a(RowSocialContextItem rowSocialContextItem, ContextBannerView contextBannerView, C10763 c10763) {
        if (!rowSocialContextItem.f4768c) {
            c10763 = null;
        }
        contextBannerView.f2235d = c10763;
        this.f6889a.m2009a(rowSocialContextItem.f4767b, contextBannerView, rowSocialContextItem.f4766a, rowSocialContextItem.f4769d, rowSocialContextItem.f4770e);
    }
}

package com.facebook.messaging.composer.botcomposer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.internal.widget.ViewStubCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import com.facebook.base.broadcast.BaseFbBroadcastManager;
import com.facebook.base.broadcast.LocalFbBroadcastManager;
import com.facebook.common.time.AwakeTimeSinceBootClockMethodAutoProvider;
import com.facebook.common.time.MonotonicClock;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.model.messagemetadata.QuickReplyItem;
import com.facebook.ultralight.Inject;
import com.facebook.widget.CustomLinearLayout;
import javax.annotation.Nullable;

/* compiled from: there are no object associate with location */
public class BotComposerView extends CustomLinearLayout {
    private static final Class<?> f1716c = BotComposerView.class;
    @Inject
    QuickReplyControllerProvider f1717a;
    @Inject
    BotMenuControllerProvider f1718b;
    @Nullable
    public Callback f1719d;
    private QuickReplyController f1720e;
    private BotMenuController f1721f;
    private View f1722g;
    private boolean f1723h = false;

    /* compiled from: there are no object associate with location */
    class C02761 implements OnClickListener {
        final /* synthetic */ BotComposerView f1714a;

        C02761(BotComposerView botComposerView) {
            this.f1714a = botComposerView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1559477689);
            if (this.f1714a.f1719d != null) {
                this.f1714a.f1719d.mo140a();
            }
            Logger.a(2, EntryType.UI_INPUT_END, 1574315586, a);
        }
    }

    /* compiled from: there are no object associate with location */
    public class C02772 {
        final /* synthetic */ BotComposerView f1715a;

        C02772(BotComposerView botComposerView) {
            this.f1715a = botComposerView;
        }

        public final void m1704a(QuickReplyItem quickReplyItem) {
            if (this.f1715a.f1719d != null) {
                this.f1715a.f1719d.mo141a(quickReplyItem);
            }
        }
    }

    /* compiled from: there are no object associate with location */
    public interface Callback {
        void mo140a();

        void mo141a(QuickReplyItem quickReplyItem);
    }

    private static <T extends View> void m1709a(Class<T> cls, T t) {
        m1710a((Object) t, t.getContext());
    }

    private static void m1710a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((BotComposerView) obj).m1708a((QuickReplyControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(QuickReplyControllerProvider.class), (BotMenuControllerProvider) fbInjector.getOnDemandAssistedProviderForStaticDi(BotMenuControllerProvider.class));
    }

    public BotComposerView(Context context) {
        super(context);
        m1711b();
    }

    public BotComposerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        m1711b();
    }

    public BotComposerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m1711b();
    }

    public void setCallback(@Nullable Callback callback) {
        this.f1719d = callback;
    }

    @SuppressLint({"ConstructorMayLeakThis"})
    private void m1711b() {
        m1709a(BotComposerView.class, (View) this);
        setOrientation(1);
        setGravity(80);
        setContentView(2130905572);
        a(2131564460).setOnClickListener(new C02761(this));
        m1712c();
        m1713d();
    }

    private void m1712c() {
        this.f1722g = a(2131564456);
        ViewStubCompat viewStubCompat = (ViewStubCompat) a(2131564457);
        QuickReplyControllerProvider quickReplyControllerProvider = this.f1717a;
        this.f1720e = new QuickReplyController((BaseFbBroadcastManager) LocalFbBroadcastManager.a(quickReplyControllerProvider), (QuickReplyAdapterProvider) quickReplyControllerProvider.getOnDemandAssistedProviderForStaticDi(QuickReplyAdapterProvider.class), BotComposerAnalyticsLogger.m1699b(quickReplyControllerProvider), (MonotonicClock) AwakeTimeSinceBootClockMethodAutoProvider.a(quickReplyControllerProvider), viewStubCompat, new C02772(this));
        QuickReplyController quickReplyController = this.f1720e;
        if (!quickReplyController.f1767f.a()) {
            quickReplyController.f1767f.b();
        }
    }

    private void m1708a(QuickReplyControllerProvider quickReplyControllerProvider, BotMenuControllerProvider botMenuControllerProvider) {
        this.f1717a = quickReplyControllerProvider;
        this.f1718b = botMenuControllerProvider;
    }

    private void m1713d() {
        ViewStubCompat viewStubCompat = (ViewStubCompat) a(2131564459);
        BotMenuControllerProvider botMenuControllerProvider = this.f1718b;
        this.f1721f = new BotMenuController((BotMenuContentAdapterProvider) botMenuControllerProvider.getOnDemandAssistedProviderForStaticDi(BotMenuContentAdapterProvider.class), BotComposerAnalyticsLogger.m1699b(botMenuControllerProvider), getContext(), viewStubCompat);
    }

    public final void m1714a() {
        this.f1723h = true;
    }

    public final void m1715c(int i) {
        if (this.f1720e.f1765d.d() && this.f1723h) {
            this.f1722g.scrollTo(0, -(getOverlapY() - Math.max(0, i)));
        }
    }

    public int getOverlapY() {
        return getMeasuredHeight();
    }
}

package com.facebook.photos.creativeediting.stickers.stickers;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import com.facebook.auth.module.ViewerContextManagerProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.content.DefaultSecureContextHelper;
import com.facebook.content.SecureContextHelper;
import com.facebook.fbservice.ops.DefaultBlueServiceOperationFactory;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.creativeediting.analytics.CreativeEditingAnalyticsLogger;
import com.facebook.photos.creativeediting.analytics.CreativeEditingAnalyticsLogger.Events;
import com.facebook.photos.creativeediting.analytics.CreativeEditingLogger;
import com.facebook.photos.creativeediting.stickers.services.StickerPackMetadataLoader;
import com.facebook.photos.creativeediting.stickers.services.StickerPackMetadataLoader.Params;
import com.facebook.photos.creativeediting.stickers.stickers.StickersTrayAdapter.C07881;
import com.facebook.photos.creativeediting.stickers.ui.StickersViewPagerAdapter;
import com.facebook.photos.creativeediting.stickers.ui.StickersViewPagerAdapterProvider;
import com.facebook.sequencelogger.Sequence;
import com.facebook.stickers.data.StickerCache;
import com.facebook.stickers.model.StickerInterface;
import com.facebook.stickers.store.StickerStoreActivity;
import com.facebook.tools.dextr.runtime.detour.SequenceLoggerDetour;
import com.facebook.widget.CustomRelativeLayout;
import it.sephiroth.android.library.widget.HListView;
import java.util.concurrent.Executor;
import javax.inject.Inject;

/* compiled from: mParams */
public class StickerPicker extends CustomRelativeLayout {
    @Inject
    SecureContextHelper f9631a;
    @Inject
    StickersTrayAdapterProvider f9632b;
    @Inject
    StickersViewPagerAdapterProvider f9633c;
    @Inject
    CreativeEditingAnalyticsLogger f9634d;
    @Inject
    CreativeEditingLogger f9635e;
    public HListView f9636f;
    public ViewPager f9637g;
    public StickersTrayAdapter f9638h;
    public StickersViewPagerAdapter f9639i;
    private DataSetObserver f9640j;
    public InputMethodManager f9641k;
    public TranslateAnimation f9642l;
    private TranslateAnimation f9643m;
    public String f9644n;

    /* compiled from: mParams */
    class C07821 implements AnimationListener {
        final /* synthetic */ StickerPicker f9622a;

        C07821(StickerPicker stickerPicker) {
            this.f9622a = stickerPicker;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            this.f9622a.setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* compiled from: mParams */
    public class C07843 {
        final /* synthetic */ StickerPicker f9625a;

        C07843(StickerPicker stickerPicker) {
            this.f9625a = stickerPicker;
        }

        public final void m11548a(int i) {
            this.f9625a.f9637g.a(i, true);
        }
    }

    /* compiled from: mParams */
    class C07865 implements OnPageChangeListener {
        final /* synthetic */ StickerPicker f9628a;

        C07865(StickerPicker stickerPicker) {
            this.f9628a = stickerPicker;
        }

        public final void m11549a(int i, float f, int i2) {
            this.f9628a.f9641k.hideSoftInputFromWindow(this.f9628a.getWindowToken(), 0);
        }

        public final void e_(int i) {
            if (this.f9628a.f9638h != null && this.f9628a.f9638h.getCount() > i) {
                this.f9628a.f9636f.setSelection(i);
            }
        }

        public final void m11550b(int i) {
        }
    }

    /* compiled from: mParams */
    class C07876 implements OnLayoutChangeListener {
        final /* synthetic */ StickerPicker f9629a;
        private boolean f9630b = false;

        C07876(StickerPicker stickerPicker) {
            this.f9629a = stickerPicker;
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            if (!this.f9630b) {
                this.f9629a.startAnimation(this.f9629a.f9642l);
                this.f9630b = true;
            }
        }
    }

    private static <T extends View> void m11554a(Class<T> cls, T t) {
        m11555a((Object) t, t.getContext());
    }

    private static void m11555a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((StickerPicker) obj).m11553a((SecureContextHelper) DefaultSecureContextHelper.a(injectorLike), (StickersTrayAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(StickersTrayAdapterProvider.class), (StickersViewPagerAdapterProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(StickersViewPagerAdapterProvider.class), CreativeEditingAnalyticsLogger.m11459a(injectorLike), CreativeEditingLogger.m11468b(injectorLike));
    }

    public StickerPicker(Context context) {
        super(context);
        m11560e();
    }

    public StickerPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11560e();
    }

    public StickerPicker(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11560e();
    }

    private void m11560e() {
        m11554a(StickerPicker.class, (View) this);
        setContentView(2130906582);
        this.f9636f = (HListView) findViewById(2131566572);
        this.f9636f.setChoiceMode(1);
        this.f9636f.setDividerWidth(getContext().getResources().getDimensionPixelSize(2131431907));
        this.f9641k = (InputMethodManager) getContext().getSystemService("input_method");
        this.f9642l = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        this.f9642l.setDuration(150);
        this.f9643m = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 0.0f, 2, 1.0f);
        this.f9643m.setDuration(150);
        this.f9643m.setAnimationListener(new C07821(this));
    }

    private void m11553a(SecureContextHelper secureContextHelper, StickersTrayAdapterProvider stickersTrayAdapterProvider, StickersViewPagerAdapterProvider stickersViewPagerAdapterProvider, CreativeEditingAnalyticsLogger creativeEditingAnalyticsLogger, CreativeEditingLogger creativeEditingLogger) {
        this.f9631a = secureContextHelper;
        this.f9632b = stickersTrayAdapterProvider;
        this.f9633c = stickersViewPagerAdapterProvider;
        this.f9634d = creativeEditingAnalyticsLogger;
        this.f9635e = creativeEditingLogger;
    }

    public final void m11564a(String str, String str2, final StickerInterface stickerInterface) {
        this.f9644n = str;
        this.f9635e.m11480a(str, str2);
        findViewById(2131566571).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ StickerPicker f9624b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 1779902734);
                Intent intent = new Intent(this.f9624b.getContext(), StickerStoreActivity.class);
                intent.putExtra("stickerContext", stickerInterface);
                this.f9624b.f9631a.a(intent, this.f9624b.getContext());
                this.f9624b.f9634d.m11462a(this.f9624b.f9644n, Events.ENTER_STICKER_STORE);
                this.f9624b.f9635e.m11481b();
                Logger.a(2, EntryType.UI_INPUT_END, 738075887, a);
            }
        });
        StickersTrayAdapterProvider stickersTrayAdapterProvider = this.f9632b;
        this.f9638h = new StickersTrayAdapter(getContext(), new StickerPackMetadataLoader(StickerCache.a(stickersTrayAdapterProvider), DefaultBlueServiceOperationFactory.b(stickersTrayAdapterProvider), ViewerContextManagerProvider.b(stickersTrayAdapterProvider), (Executor) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(stickersTrayAdapterProvider)), IdBasedProvider.a(stickersTrayAdapterProvider, 724));
        this.f9636f.setAdapter(this.f9638h);
        this.f9636f.ah = new C07843(this);
        this.f9640j = new DataSetObserver(this) {
            final /* synthetic */ StickerPicker f9627b;

            public void onChanged() {
                this.f9627b.f9639i = new StickersViewPagerAdapter(this.f9627b.f9638h, stickerInterface, IdBasedSingletonScopeProvider.b(this.f9627b.f9633c, 9280));
                this.f9627b.f9637g.setAdapter(this.f9627b.f9639i);
            }
        };
        this.f9638h.registerDataSetObserver(this.f9640j);
        this.f9637g = (ViewPager) findViewById(2131566569);
        this.f9637g.setOnPageChangeListener(new C07865(this));
    }

    public final void m11563a() {
        this.f9641k.hideSoftInputFromWindow(getWindowToken(), 0);
        this.f9638h.unregisterDataSetObserver(this.f9640j);
    }

    public final void m11565b() {
        if (this.f9638h.m11572b() && this.f9638h.getCount() > 1) {
            this.f9637g.a(1, false);
            this.f9636f.setSelection(0);
        }
        this.f9637g.setVisibility(0);
        setVisibility(0);
        addOnLayoutChangeListener(new C07876(this));
        CreativeEditingAnalyticsLogger creativeEditingAnalyticsLogger = this.f9634d;
        Sequence b = creativeEditingAnalyticsLogger.f9511b.b(CreativeEditingAnalyticsLogger.f9509a, this.f9644n);
        if (b != null) {
            SequenceLoggerDetour.e(b, Events.STICKER_PICKER_OPENED.name, -18256472);
        }
    }

    public final void m11566c() {
        ((InputMethodManager) getContext().getSystemService("input_method")).hideSoftInputFromWindow(getWindowToken(), 0);
        startAnimation(this.f9643m);
        CreativeEditingAnalyticsLogger creativeEditingAnalyticsLogger = this.f9634d;
        Sequence b = creativeEditingAnalyticsLogger.f9511b.b(CreativeEditingAnalyticsLogger.f9509a, this.f9644n);
        if (b != null) {
            SequenceLoggerDetour.e(b, Events.STICKER_PICKER_CLOSED.name, -1726601730);
        }
    }

    public final void m11567d() {
        if (this.f9638h != null) {
            StickersTrayAdapter stickersTrayAdapter = this.f9638h;
            stickersTrayAdapter.f9649d.m11545a(new C07881(stickersTrayAdapter));
            stickersTrayAdapter.f9649d.m11546a(new Params(false));
            stickersTrayAdapter.f9649d.m11546a(new Params(true));
        }
    }
}

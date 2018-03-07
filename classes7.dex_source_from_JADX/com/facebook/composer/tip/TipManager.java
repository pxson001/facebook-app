package com.facebook.composer.tip;

import android.content.Context;
import android.view.ViewGroup;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.composer.activity.ComposerDataProviderImpl;
import com.facebook.composer.activity.ComposerFragment.10;
import com.facebook.composer.attachments.ComposerAttachment.ProvidesAttachments;
import com.facebook.composer.audienceeducator.ComposerAudienceEducatorData.ProvidesAudienceEducatorData;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.tip.MinutiaeNuxBubbleInterstitialController.Listener;
import com.facebook.composer.tip.StickyGuardrailInterstitialController.DataProvider;
import com.facebook.composer.tip.StickyGuardrailInterstitialController.StickyGuardrailCallback;
import com.facebook.inject.Assisted;
import com.facebook.interstitial.manager.InterstitialManager;
import com.facebook.interstitial.manager.InterstitialTrigger;
import com.facebook.interstitial.manager.InterstitialTrigger.Action;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsMinutiaeSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesIsPrivacyPillSupported;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesTargetAlbum;
import com.facebook.ipc.composer.intent.ComposerConfigurationSpec.ProvidesConfiguration;
import com.facebook.ipc.composer.intent.ComposerTargetData.ProvidesTargetData;
import com.facebook.ipc.composer.model.PublishMode.ProvidesPublishMode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import javax.annotation.Nullable;
import javax.annotation.concurrent.NotThreadSafe;
import javax.inject.Inject;

@NotThreadSafe
/* compiled from: composer_filter_viewed */
public class TipManager<DataProvider extends ProvidesAttachments & ProvidesAudienceEducatorData & ProvidesIsMinutiaeSupported & ProvidesIsPrivacyPillSupported & ProvidesSessionId & ProvidesTargetAlbum & ProvidesConfiguration & ProvidesTargetData & ProvidesMinutiae & ProvidesPublishMode> implements ComposerEventHandler {
    public static final InterstitialTrigger f17054a = new InterstitialTrigger(Action.COMPOSER);
    public final LinkedHashMap<Tip, TipControllerInterface> f17055b = Maps.d();
    public final InterstitialManager f17056c;
    private final AbstractFbErrorReporter f17057d;
    public final ComposerTipSessionControl<DataProvider> f17058e;
    public final ImmutableSet<ComposerTip> f17059f;
    private final ViewGroup f17060g;
    private Tip f17061h = null;
    public boolean f17062i = false;
    public EnumSet<Tip> f17063j = EnumSet.noneOf(Tip.class);
    private ComposerInterstitialTip f17064k;

    @Inject
    public TipManager(InterstitialManager interstitialManager, FbErrorReporter fbErrorReporter, ComposerTipSessionControlProvider composerTipSessionControlProvider, @Assisted ViewGroup viewGroup, @Assisted ViewGroup viewGroup2, @Assisted DataProvider dataProvider, @Assisted Listener listener, @Assisted DataProvider dataProvider2, @Assisted StickyGuardrailCallback stickyGuardrailCallback) {
        this.f17056c = interstitialManager;
        this.f17057d = fbErrorReporter;
        this.f17058e = composerTipSessionControlProvider.m20940a(viewGroup, viewGroup2, dataProvider, listener, dataProvider2, stickyGuardrailCallback);
        this.f17059f = this.f17058e.m20939a();
        this.f17060g = viewGroup;
    }

    public final void m21009c() {
        ComposerTipSessionControl composerTipSessionControl = this.f17058e;
        MinutiaeNuxBubbleInterstitialController minutiaeNuxBubbleInterstitialController = (MinutiaeNuxBubbleInterstitialController) composerTipSessionControl.f16983b.a(ComposerInterstitialControllers.MINUTIAE_RESHARE_NUX.interstitialId);
        Context context = composerTipSessionControl.f16982a;
        ViewGroup viewGroup = composerTipSessionControl.f16990i;
        ComposerDataProviderImpl composerDataProviderImpl = (ComposerDataProviderImpl) composerTipSessionControl.f16992k;
        10 10 = composerTipSessionControl.f16993l;
        minutiaeNuxBubbleInterstitialController.f17019d = context;
        if (viewGroup.findViewById(2131560662) instanceof ViewGroup) {
            minutiaeNuxBubbleInterstitialController.f17020e = ((ViewGroup) viewGroup.findViewById(2131560662)).findViewById(2131560514);
        }
        minutiaeNuxBubbleInterstitialController.f17022g = composerDataProviderImpl;
        minutiaeNuxBubbleInterstitialController.f17023h = 10;
        minutiaeNuxBubbleInterstitialController.f17016a.a(ComposerInterstitialControllers.forControllerClass(minutiaeNuxBubbleInterstitialController.getClass()).prefKey);
        RidgeNuxBubbleInterstitialController ridgeNuxBubbleInterstitialController = (RidgeNuxBubbleInterstitialController) composerTipSessionControl.f16983b.a(ComposerInterstitialControllers.RIDGE_NUX.interstitialId);
        context = composerTipSessionControl.f16982a;
        viewGroup = composerTipSessionControl.f16990i;
        ProvidesTargetAlbum providesTargetAlbum = (ProvidesTargetAlbum) composerTipSessionControl.f16992k;
        ridgeNuxBubbleInterstitialController.f17029d = context;
        if (viewGroup.findViewById(2131560662) instanceof ViewGroup) {
            ridgeNuxBubbleInterstitialController.f17030e = ((ViewGroup) viewGroup.findViewById(2131560662)).findViewById(2131560514);
        }
        ridgeNuxBubbleInterstitialController.f17032g = providesTargetAlbum;
        ridgeNuxBubbleInterstitialController.f17026a.a(ComposerInterstitialControllers.forControllerClass(ridgeNuxBubbleInterstitialController.getClass()).prefKey);
        PublishModeSelectorNuxBubbleInterstitialController publishModeSelectorNuxBubbleInterstitialController = (PublishModeSelectorNuxBubbleInterstitialController) composerTipSessionControl.f16983b.a(ComposerInterstitialControllers.PUBLISH_MODE_SELECTOR_NUX.interstitialId);
        Context context2 = composerTipSessionControl.f16982a;
        ViewGroup viewGroup2 = composerTipSessionControl.f16990i;
        ProvidesAttachments providesAttachments = composerTipSessionControl.f16992k;
        publishModeSelectorNuxBubbleInterstitialController.b = context2;
        publishModeSelectorNuxBubbleInterstitialController.d = viewGroup2;
        publishModeSelectorNuxBubbleInterstitialController.e = providesAttachments;
        publishModeSelectorNuxBubbleInterstitialController.a.a(ComposerInterstitialControllers.forControllerClass(publishModeSelectorNuxBubbleInterstitialController.getClass()).prefKey);
        TopicComposerNuxInterstitialController topicComposerNuxInterstitialController = (TopicComposerNuxInterstitialController) composerTipSessionControl.f16983b.a(ComposerInterstitialControllers.TOPIC_COMPOSER_NUX.interstitialId);
        context2 = composerTipSessionControl.f16982a;
        viewGroup2 = composerTipSessionControl.f16990i;
        topicComposerNuxInterstitialController.f17067c = context2;
        topicComposerNuxInterstitialController.f17069e = viewGroup2;
        topicComposerNuxInterstitialController.f17065a.a(ComposerInterstitialControllers.forControllerClass(topicComposerNuxInterstitialController.getClass()).prefKey);
        FeedOnlyPostInterstitialController feedOnlyPostInterstitialController = (FeedOnlyPostInterstitialController) composerTipSessionControl.f16983b.a(ComposerInterstitialControllers.FEED_ONLY_POST_NUX.interstitialId);
        context2 = composerTipSessionControl.f16982a;
        viewGroup2 = composerTipSessionControl.f16990i;
        feedOnlyPostInterstitialController.f16998b = context2;
        feedOnlyPostInterstitialController.f16997a.a(ComposerInterstitialControllers.forControllerClass(feedOnlyPostInterstitialController.getClass()).prefKey);
        feedOnlyPostInterstitialController.f16999c = viewGroup2.findViewById(2131560501);
        m21003g();
    }

    public final void m21005a(Tip tip, TipControllerInterface tipControllerInterface) {
        this.f17055b.put(tip, tipControllerInterface);
    }

    public final void m21007a(Tip... tipArr) {
        for (Object add : tipArr) {
            this.f17063j.add(add);
        }
    }

    public final boolean m21010d() {
        boolean z;
        ComposerTipSessionControl composerTipSessionControl = this.f17058e;
        Collection<TipControllerInterface> values = this.f17055b.values();
        ImmutableSet immutableSet = this.f17059f;
        for (ComposerInterstitialControllers composerInterstitialControllers : ComposerInterstitialControllers.values()) {
            if (((ComposerInterstitialTip) composerTipSessionControl.f16983b.a(composerInterstitialControllers.interstitialId)).hH_()) {
                z = true;
                break;
            }
        }
        Iterator it = immutableSet.iterator();
        while (it.hasNext()) {
            if (((ComposerTip) it.next()).hH_()) {
                z = true;
                break;
            }
        }
        for (TipControllerInterface d : values) {
            if (d.m20999d()) {
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    public final void m21004a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        if (composerEvent == ComposerEvent.ON_DATASET_CHANGE) {
            m21003g();
        } else if (!m21010d()) {
            Iterator it = this.f17059f.iterator();
            boolean z = false;
            while (it.hasNext()) {
                ComposerTip composerTip = (ComposerTip) it.next();
                ComposerTip$Action a = composerTip.a(composerEvent);
                if (a == ComposerTip$Action.SHOW && !r1 && !this.f17062i) {
                    m21000a(composerTip);
                    z = true;
                } else if (a == ComposerTip$Action.HIDE) {
                    m21001a(composerTip, true);
                }
            }
        }
    }

    private void m21000a(ComposerTip composerTip) {
        try {
            composerTip.hG_();
        } catch (Throwable e) {
            this.f17057d.a(getClass().getName() + "#show failed with controller " + composerTip.getClass().getName(), e);
        }
    }

    private void m21001a(ComposerTip composerTip, boolean z) {
        try {
            composerTip.a(z);
        } catch (Throwable e) {
            this.f17057d.a(getClass().getName() + "#hide failed with controller " + composerTip.getClass().getName(), e);
        }
    }

    @VisibleForTesting
    private void m21003g() {
        if (this.f17060g != null && !m21010d() && !this.f17062i) {
            ComposerInterstitialTip composerInterstitialTip = (ComposerInterstitialTip) this.f17056c.a(f17054a, ComposerInterstitialTip.class);
            if (composerInterstitialTip != null) {
                this.f17064k = composerInterstitialTip;
                m21000a(this.f17064k);
                this.f17061h = Tip.INTERSTITIAL_NUX;
                return;
            }
            Iterator it = this.f17063j.iterator();
            while (it.hasNext()) {
                Tip tip = (Tip) it.next();
                TipControllerInterface tipControllerInterface = (TipControllerInterface) this.f17055b.get(tip);
                if (tipControllerInterface != null && tipControllerInterface.m20997b()) {
                    tipControllerInterface.m20996a();
                    this.f17061h = tip;
                    this.f17063j.remove(tip);
                    Iterator it2 = this.f17063j.iterator();
                    while (it2.hasNext()) {
                        m21008a((Tip) it2.next(), false);
                    }
                    return;
                }
            }
        }
    }

    public final boolean m21008a(Tip tip, boolean z) {
        if (this.f17061h == null || this.f17061h != tip) {
            return false;
        }
        if (this.f17061h == Tip.INTERSTITIAL_NUX) {
            m21002b(z);
            return true;
        }
        this.f17061h = null;
        return ((TipControllerInterface) this.f17055b.get(tip)).m20998c();
    }

    public final void m21006a(boolean z) {
        for (Tip a : this.f17055b.keySet()) {
            m21008a(a, false);
        }
        Iterator it = this.f17059f.iterator();
        while (it.hasNext()) {
            m21001a((ComposerTip) it.next(), z);
        }
        m21002b(z);
    }

    @VisibleForTesting
    private void m21002b(boolean z) {
        if (this.f17064k != null) {
            m21001a(this.f17064k, z);
            if (z) {
                this.f17056c.a().a(this.f17064k.b());
            }
            this.f17064k = null;
            this.f17061h = null;
        }
    }
}

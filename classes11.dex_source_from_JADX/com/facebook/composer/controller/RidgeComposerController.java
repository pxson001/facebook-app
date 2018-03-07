package com.facebook.composer.controller;

import android.support.v4.app.Fragment;
import com.facebook.audiofingerprinting.AudioFingerprintingSession;
import com.facebook.audiofingerprinting.AudioFingerprintingSession.Callback;
import com.facebook.audiofingerprinting.AudioFingerprintingSession.ErrorCode;
import com.facebook.audiofingerprinting.AudioFingerprintingSuggestionsCache;
import com.facebook.base.fragment.AbstractFbFragmentListener;
import com.facebook.common.util.TriState;
import com.facebook.composer.activity.ComposerFragment;
import com.facebook.composer.activity.ComposerFragment.AnonymousClass29;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger;
import com.facebook.composer.minutiae.analytics.RidgeAnalyticsLogger.RidgeView;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLInterfaces.MinutiaeTaggableSuggestions;
import com.facebook.composer.minutiae.model.MinutiaeObject.ProvidesMinutiae;
import com.facebook.composer.minutiae.music.MusicMetadataHelper;
import com.facebook.composer.minutiae.util.RidgeOptInController;
import com.facebook.inject.Assisted;
import com.facebook.ipc.composer.dataaccessor.ComposerBasicDataProviders.ProvidesSessionId;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicInteger;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: has_hidden */
public class RidgeComposerController<DataProvider extends ProvidesSessionId & ProvidesMinutiae> extends AbstractFbFragmentListener {
    private final Provider<TriState> f6335a;
    private final RidgeOptInController f6336b;
    public final AudioFingerprintingSession f6337c;
    public final RidgeAnalyticsLogger f6338d;
    private final MusicMetadataHelper f6339e;
    private final AtomicInteger f6340f = new AtomicInteger(0);
    public boolean f6341g;
    public AnonymousClass29 f6342h;
    private WeakReference<DataProvider> f6343i;
    private boolean f6344j;
    public boolean f6345k;
    public AudioFingerprintingSuggestionsCache f6346l;

    @Inject
    public RidgeComposerController(@Assisted DataProvider dataProvider, Provider<TriState> provider, RidgeOptInController ridgeOptInController, AudioFingerprintingSession audioFingerprintingSession, AudioFingerprintingSuggestionsCache audioFingerprintingSuggestionsCache, RidgeAnalyticsLogger ridgeAnalyticsLogger, MusicMetadataHelper musicMetadataHelper) {
        this.f6343i = new WeakReference(dataProvider);
        this.f6335a = provider;
        this.f6336b = ridgeOptInController;
        this.f6337c = audioFingerprintingSession;
        this.f6346l = audioFingerprintingSuggestionsCache;
        this.f6338d = ridgeAnalyticsLogger;
        this.f6339e = musicMetadataHelper;
    }

    public final void m7768d(Fragment fragment) {
        if (m7766i()) {
            ImmutableList g = m7772g();
            final ProvidesSessionId providesSessionId = (ProvidesSessionId) Preconditions.checkNotNull(this.f6343i.get());
            if (m7766i() && ((ProvidesMinutiae) providesSessionId).l() == null && g == null) {
                this.f6337c.a(new Callback(this) {
                    final /* synthetic */ RidgeComposerController f6334b;

                    public final void m7762a(String str) {
                        this.f6334b.f6345k = false;
                        RidgeComposerController.m7764a(this.f6334b, true, 0);
                        this.f6334b.f6338d.a(providesSessionId.ab(), RidgeView.COMPOSER, str);
                    }

                    public final void m7758a() {
                        this.f6334b.f6337c.b();
                        RidgeComposerController.m7765h(this.f6334b);
                        this.f6334b.f6338d.a(providesSessionId.ab(), RidgeView.COMPOSER);
                    }

                    public final void m7761a(ImmutableList<? extends MinutiaeTaggableSuggestions> immutableList, String str) {
                        this.f6334b.f6345k = true;
                        this.f6334b.f6346l.a = immutableList;
                        RidgeComposerController.m7764a(this.f6334b, this.f6334b.f6341g, immutableList.size());
                        this.f6334b.f6338d.c(providesSessionId.ab(), RidgeView.COMPOSER, str);
                        RidgeComposerController.m7763a(this.f6334b, str);
                    }

                    public final void m7760a(ErrorCode errorCode, String str) {
                        RidgeComposerController.m7765h(this.f6334b);
                        RidgeComposerController.m7763a(this.f6334b, str);
                    }

                    public final void m7759a(double d) {
                    }
                }, this.f6339e.b());
                return;
            } else if (g == null || this.f6344j) {
                m7764a(this, false, m7769e());
                return;
            } else {
                m7764a(this, true, g.size());
                return;
            }
        }
        m7764a(this, false, m7769e());
    }

    public final int m7769e() {
        return this.f6340f.get();
    }

    public static void m7764a(RidgeComposerController ridgeComposerController, boolean z, int i) {
        ridgeComposerController.f6341g = z;
        ridgeComposerController.f6340f.set(i);
        ridgeComposerController.f6342h.f6059a.aU.m7627a(ComposerEvent.ON_DATASET_CHANGE, ComposerFragment.cn);
    }

    public static void m7763a(RidgeComposerController ridgeComposerController, String str) {
        ridgeComposerController.f6338d.b(((ProvidesSessionId) Preconditions.checkNotNull(ridgeComposerController.f6343i.get())).ab(), RidgeView.COMPOSER, str);
    }

    public final void m7767c(Fragment fragment) {
        if (m7766i()) {
            m7764a(this, this.f6341g, -1);
            this.f6337c.b();
        }
    }

    public final void m7770e(Fragment fragment) {
        if (m7766i()) {
            AudioFingerprintingSuggestionsCache audioFingerprintingSuggestionsCache = this.f6346l;
            audioFingerprintingSuggestionsCache.b = null;
            audioFingerprintingSuggestionsCache.a = null;
        }
    }

    public static void m7765h(RidgeComposerController ridgeComposerController) {
        ridgeComposerController.f6345k = false;
        m7764a(ridgeComposerController, false, ridgeComposerController.m7769e());
    }

    public final void m7771f() {
        if (m7766i() && m7772g() != null) {
            this.f6344j = true;
        }
    }

    public final ImmutableList<? extends MinutiaeTaggableSuggestions> m7772g() {
        if (!m7766i()) {
            return null;
        }
        this.f6346l.b = null;
        return this.f6346l.a();
    }

    private boolean m7766i() {
        return ((TriState) this.f6335a.get()).asBoolean(false) && this.f6336b.c() && this.f6336b.e();
    }
}

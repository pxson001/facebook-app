package com.facebook.composer.minutiae.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.IBinder;
import com.facebook.audiofingerprinting.AudioFingerprintingSession;
import com.facebook.audiofingerprinting.AudioFingerprintingSession.Callback;
import com.facebook.audiofingerprinting.AudioFingerprintingSession.ErrorCode;
import com.facebook.base.service.FbService;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.references.CloseableReference;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLInterfaces.MinutiaeTaggableSuggestions;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLModels.MinutiaeTaggableSuggestionsModel;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.composer.minutiae.widget.RidgeWidgetController.RidgePrompt;
import com.facebook.composer.minutiae.widget.RidgeWidgetController.RidgePromptViewDelegate;
import com.facebook.composer.minutiae.widget.RidgeWidgetController.RidgeResultViewDelegate;
import com.facebook.composer.minutiae.widget.RidgeWidgetController.RidgeViewDelegate;
import com.facebook.composer.minutiae.widget.RidgeWidgetController.WidgetView;
import com.facebook.graphql.linkutil.GraphQLLinkExtractor;
import com.facebook.imagepipeline.image.CloseableBitmap;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.inject.FbInjector;
import com.facebook.ipc.composer.intent.ComposerConfigurationFactory;
import com.facebook.ipc.composer.intent.ComposerTargetData;
import com.facebook.ipc.composer.launch.ComposerLaunchActivity;
import com.facebook.ipc.composer.model.ComposerSourceSurface;
import com.facebook.katana.urimap.Fb4aUriIntentMapper;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import java.util.Random;
import javax.inject.Inject;

/* compiled from: task_key_newsfeed_set_like_ */
public class RidgeWidgetService extends FbService {
    private AudioFingerprintingSession f1947a;
    public RidgeWidgetBackgroundMaker f1948b;
    private RidgeWidgetProfilePictureFetcher f1949c;
    private UriIntentMapper f1950d;
    private GraphQLLinkExtractor f1951e;
    private Random f1952f;
    private Handler f1953g;

    /* compiled from: task_key_newsfeed_set_like_ */
    public enum Commands {
        INITIALIZE,
        START_FINGERPRINTING
    }

    private static <T extends Context> void m1897a(Class<T> cls, T t) {
        m1898a((Object) t, (Context) t);
    }

    public static void m1898a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ((RidgeWidgetService) obj).m1891a(AudioFingerprintingSession.m1015b(fbInjector), new RidgeWidgetBackgroundMaker(ResourcesMethodAutoProvider.a(fbInjector)), RidgeWidgetProfilePictureFetcher.m1877a(fbInjector), (UriIntentMapper) Fb4aUriIntentMapper.a(fbInjector), GraphQLLinkExtractor.a(fbInjector));
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Inject
    private void m1891a(AudioFingerprintingSession audioFingerprintingSession, RidgeWidgetBackgroundMaker ridgeWidgetBackgroundMaker, RidgeWidgetProfilePictureFetcher ridgeWidgetProfilePictureFetcher, UriIntentMapper uriIntentMapper, GraphQLLinkExtractor graphQLLinkExtractor) {
        this.f1947a = audioFingerprintingSession;
        this.f1948b = ridgeWidgetBackgroundMaker;
        this.f1949c = ridgeWidgetProfilePictureFetcher;
        this.f1950d = uriIntentMapper;
        this.f1951e = graphQLLinkExtractor;
        this.f1952f = new Random();
        this.f1953g = new Handler();
    }

    public final int m1902a(Intent intent, int i, int i2) {
        if (intent == null) {
            return super.a(intent, i, i2);
        }
        if (this.f1947a == null) {
            Class cls = RidgeWidgetService.class;
            m1898a((Object) this, (Context) this);
        }
        int[] appWidgetIds = AppWidgetManager.getInstance(this).getAppWidgetIds(new ComponentName(this, RidgeWidgetProvider.class));
        if (appWidgetIds == null || appWidgetIds.length == 0) {
            return super.a(intent, i, i2);
        }
        Commands valueOf = Commands.valueOf(intent.getAction());
        final RidgeWidgetController ridgeWidgetController = new RidgeWidgetController(appWidgetIds, getApplicationContext());
        this.f1948b.m1863a();
        this.f1947a.m1019b();
        this.f1953g.removeCallbacksAndMessages(null);
        switch (valueOf) {
            case INITIALIZE:
                m1900b(ridgeWidgetController);
                break;
            case START_FINGERPRINTING:
                this.f1947a.m1017a(new Callback(this) {
                    final /* synthetic */ RidgeWidgetService f1938b;

                    public final void mo89a(String str) {
                        ridgeWidgetController.m1875a().m1876b().m1870a(RidgePrompt.BLANK).m1871b().m1869a(this.f1938b.f1948b.f1913l).m1867c();
                    }

                    public final void mo85a() {
                    }

                    public final void mo88a(ImmutableList<? extends MinutiaeTaggableSuggestions> immutableList, String str) {
                        this.f1938b.m1893a(ridgeWidgetController, (MinutiaeTaggableSuggestionsModel) immutableList.get(0));
                    }

                    public final void mo87a(ErrorCode errorCode, String str) {
                        this.f1938b.m1892a(ridgeWidgetController);
                    }

                    public final void mo86a(double d) {
                        this.f1938b.m1890a(d, ridgeWidgetController);
                    }
                }, Absent.INSTANCE, Optional.of(Long.valueOf(15000 / ((long) this.f1948b.f1911j))));
                break;
        }
        return super.a(intent, i, i2);
    }

    private void m1893a(RidgeWidgetController ridgeWidgetController, MinutiaeTaggableSuggestionsModel minutiaeTaggableSuggestionsModel) {
        final Intent a = ComposerLaunchActivity.a(getApplicationContext(), null, ComposerConfigurationFactory.a(ComposerSourceSurface.WIDGET, "ridgeWidget").setInitialTargetData(ComposerTargetData.a).setMinutiaeObjectTag(MinutiaeObject.a(minutiaeTaggableSuggestionsModel)).setIsFireAndForget(true).a());
        final String a2 = this.f1951e.a(minutiaeTaggableSuggestionsModel.c().a().b(), minutiaeTaggableSuggestionsModel.c().a().d());
        RidgeViewDelegate a3 = m1888a(ridgeWidgetController, minutiaeTaggableSuggestionsModel, a, a2);
        a3.f1917a.f1932o.setImageViewResource(RidgeWidgetController.f1924g, 2130842608);
        a3.m1867c();
        final RidgeWidgetController ridgeWidgetController2 = ridgeWidgetController;
        final MinutiaeTaggableSuggestionsModel minutiaeTaggableSuggestionsModel2 = minutiaeTaggableSuggestionsModel;
        this.f1949c.m1879a(Uri.parse(minutiaeTaggableSuggestionsModel.c().a().ad_().b()), new AbstractDisposableFutureCallback<CloseableReference<CloseableImage>>(this) {
            final /* synthetic */ RidgeWidgetService f1943e;

            protected final void m1885a(Object obj) {
                CloseableImage closeableImage = (CloseableImage) ((CloseableReference) obj).a();
                if (closeableImage instanceof CloseableBitmap) {
                    CloseableBitmap closeableBitmap = (CloseableBitmap) closeableImage;
                    RidgeResultViewDelegate a = this.f1943e.m1888a(ridgeWidgetController2, minutiaeTaggableSuggestionsModel2, a, a2);
                    RidgeWidgetController.m1872a(a.f1917a, RidgeWidgetController.f1924g, closeableBitmap.a());
                    a.m1867c();
                }
            }

            protected final void m1886a(Throwable th) {
            }
        });
    }

    private RidgeResultViewDelegate m1888a(RidgeWidgetController ridgeWidgetController, MinutiaeTaggableSuggestionsModel minutiaeTaggableSuggestionsModel, Intent intent, String str) {
        RidgeWidgetController a = ridgeWidgetController.m1875a();
        a.f1932o.setDisplayedChild(RidgeWidgetController.f1918a, WidgetView.RESULT.index);
        RidgeViewDelegate ridgeResultViewDelegate = new RidgeResultViewDelegate(a);
        RidgeWidgetController.m1873a(ridgeResultViewDelegate.f1917a, RidgeWidgetController.f1925h, minutiaeTaggableSuggestionsModel.b());
        ridgeResultViewDelegate = ridgeResultViewDelegate;
        RidgeWidgetController.m1873a(ridgeResultViewDelegate.f1917a, RidgeWidgetController.f1926i, minutiaeTaggableSuggestionsModel.d().a());
        return (RidgeResultViewDelegate) ((RidgeResultViewDelegate) ((RidgeResultViewDelegate) ridgeResultViewDelegate.m1866b(RidgeWidgetController.f1928k, intent)).m1865a(RidgeWidgetController.f1927j, m1899b())).m1866b(RidgeWidgetController.f1924g, this.f1950d.a(this, str));
    }

    private void m1892a(final RidgeWidgetController ridgeWidgetController) {
        ((RidgePromptViewDelegate) ridgeWidgetController.m1875a().m1876b().m1868a().m1870a(RidgePrompt.FAILED).m1869a(this.f1948b.m1863a().f1913l).m1865a(RidgeWidgetController.f1923f, m1899b())).m1867c();
        HandlerDetour.b(this.f1953g, new Runnable(this) {
            final /* synthetic */ RidgeWidgetService f1945b;

            public void run() {
                this.f1945b.m1900b(ridgeWidgetController);
            }
        }, 5000, 1233944489);
    }

    private void m1890a(double d, RidgeWidgetController ridgeWidgetController) {
        double abs = (Math.abs(Math.sqrt(Math.pow(10.0d, d / 10.0d)) * 1000.0d) / 100.0d) + (((double) this.f1952f.nextFloat()) * 0.4000000059604645d);
        this.f1948b.m1864a(Math.min(abs, 1.0d - (((double) this.f1952f.nextFloat()) * 0.4000000059604645d)));
        ridgeWidgetController.m1875a().m1876b().m1871b().m1870a(RidgePrompt.BLANK).m1869a(this.f1948b.f1913l).m1867c();
    }

    private Intent m1899b() {
        Intent intent = new Intent(getApplicationContext(), RidgeWidgetService.class);
        intent.setAction(Commands.START_FINGERPRINTING.name());
        return intent;
    }

    private void m1900b(RidgeWidgetController ridgeWidgetController) {
        ((RidgePromptViewDelegate) ridgeWidgetController.m1875a().m1876b().m1868a().m1870a(RidgePrompt.WHAT_ARE_YOU_DOING).m1869a(this.f1948b.m1863a().f1913l).m1865a(RidgeWidgetController.f1923f, m1899b())).m1867c();
    }
}

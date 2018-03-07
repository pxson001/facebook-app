package com.facebook.audiofingerprinting;

import android.media.AudioRecord;
import android.os.Handler;
import android.util.Base64;
import com.facebook.audiofingerprinting.graphql.FetchSuggestionFromFingerprintRequest;
import com.facebook.audiofingerprinting.graphql.GraphQLFingerprintingParams;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.errorreporting.SoftError;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.Handler_ForUiThreadMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.identifiers.SafeUUIDGenerator;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQL.RidgeSuggestionsQueryString;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLInterfaces.MinutiaeTaggableSuggestions;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLInterfaces.RidgeSuggestionsQuery.SuggestedTaggableActivities;
import com.facebook.composer.minutiae.graphql.MinutiaeSuggestionDefaultsGraphQLModels.RidgeSuggestionsQueryModel.SuggestedTaggableActivitiesModel;
import com.facebook.graphql.executor.GraphQLCachePolicy;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.querybuilder.common.GraphQlQueryDefaults;
import com.facebook.graphql.querybuilder.common.ScaleInputPixelRatio;
import com.facebook.inject.InjectorLike;
import com.facebook.tools.dextr.runtime.detour.ExecutorDetour;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.ui.futures.TasksManager;
import com.facebook.ui.toaster.ToastBuilder;
import com.facebook.ui.toaster.Toaster;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutorService;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: uploadContactBatchForFriendFinder */
public class AudioFingerprintingSession {
    public final AudioFingerprintCapturer f1052a;
    public final TasksManager<String> f1053b;
    public final FetchSuggestionFromFingerprintRequest f1054c;
    public final Toaster f1055d;
    public final ExecutorService f1056e;
    private final ExecutorService f1057f;
    public final AbstractFbErrorReporter f1058g;
    public final Handler f1059h = new Handler();
    public Set<String> f1060i;
    public Optional<SuggestedTaggableActivities> f1061j;
    public ImmutableList<? extends MinutiaeTaggableSuggestions> f1062k;
    public Callback f1063l;
    public int f1064m = 0;
    public AudioFingerprintingSuggestionsCache f1065n;
    public Optional<String> f1066o = Absent.INSTANCE;
    public Optional<MusicMetadata> f1067p = Absent.INSTANCE;

    /* compiled from: uploadContactBatchForFriendFinder */
    public class C01032 implements Runnable {
        final /* synthetic */ AudioFingerprintingSession f1043a;

        public C01032(AudioFingerprintingSession audioFingerprintingSession) {
            this.f1043a = audioFingerprintingSession;
        }

        public void run() {
            this.f1043a.f1063l.mo86a(this.f1043a.m1020c());
        }
    }

    /* compiled from: uploadContactBatchForFriendFinder */
    public class C01043 implements Runnable {
        final /* synthetic */ String f1044a;
        final /* synthetic */ AudioFingerprintingSession f1045b;

        public C01043(AudioFingerprintingSession audioFingerprintingSession, String str) {
            this.f1045b = audioFingerprintingSession;
            this.f1044a = str;
        }

        public void run() {
            try {
                byte[] b = this.f1045b.f1052a.m1000b();
                int d = this.f1045b.f1064m / this.f1045b.f1052a.m1001d();
                int length = (b.length / this.f1045b.f1052a.m1001d()) - d;
                String encodeToString = Base64.encodeToString(b, 0);
                AudioFingerprintingSession.m1013a(this.f1045b, this.f1045b.f1052a.m1001d() * length);
                AudioFingerprintingSession.m1014a(this.f1045b, this.f1044a, Optional.of(GraphQLFingerprintingParams.m1043a().m1042b(encodeToString).m1038a(length).m1041b(d).m1039a((String) this.f1045b.f1066o.get()).m1037a(this.f1045b.f1052a.m1002e()).m1040a()), Absent.withType());
            } catch (Throwable e) {
                this.f1045b.f1058g.a(SoftError.a("ridge_library_error", "getFingerprint() failed").a(e).a(true).a(1).g());
                if (this.f1045b.f1063l != null) {
                    this.f1045b.f1063l.mo87a(ErrorCode.LIBRARY_ERROR, (String) this.f1045b.f1066o.get());
                    this.f1045b.m1019b();
                }
            }
        }
    }

    /* compiled from: uploadContactBatchForFriendFinder */
    public interface Callback {
        void mo85a();

        void mo86a(double d);

        void mo87a(ErrorCode errorCode, String str);

        void mo88a(ImmutableList<? extends MinutiaeTaggableSuggestions> immutableList, String str);

        void mo89a(String str);
    }

    /* compiled from: uploadContactBatchForFriendFinder */
    public enum ErrorCode {
        COMMERCIAL,
        NO_MATCH,
        LIBRARY_ERROR
    }

    public static AudioFingerprintingSession m1015b(InjectorLike injectorLike) {
        return new AudioFingerprintingSession(new AudioFingerprintCapturer(Handler_ForUiThreadMethodAutoProvider.b(injectorLike), AudioReceiver.m1025a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike)), Toaster.b(injectorLike), TasksManager.b(injectorLike), new FetchSuggestionFromFingerprintRequest(GraphQLQueryExecutor.a(injectorLike)), (ExecutorService) ListeningExecutorService_ForegroundExecutorServiceMethodAutoProvider.a(injectorLike), (ExecutorService) ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), AudioFingerprintingSuggestionsCache.m1021a(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    public final Optional<String> m1016a(Callback callback, Optional<MusicMetadata> optional) {
        return m1017a(callback, optional, Absent.INSTANCE);
    }

    public final Optional<String> m1017a(Callback callback, final Optional<MusicMetadata> optional, final Optional<Long> optional2) {
        this.f1061j = Absent.INSTANCE;
        this.f1062k = null;
        this.f1063l = callback;
        this.f1064m = 0;
        m1019b();
        if (this.f1052a.f1032c.m1029d()) {
            this.f1066o = Optional.of(SafeUUIDGenerator.a().toString());
            ExecutorDetour.a(this.f1057f, new Runnable(this) {
                public final /* synthetic */ AudioFingerprintingSession f1042c;

                /* compiled from: uploadContactBatchForFriendFinder */
                public class C01011 {
                    public final /* synthetic */ C01021 f1039a;

                    C01011(C01021 c01021) {
                        this.f1039a = c01021;
                    }
                }

                public void run() {
                    AudioFingerprintCapturer audioFingerprintCapturer = this.f1042c.f1052a;
                    C01011 c01011 = new C01011(this);
                    audioFingerprintCapturer.f1031b.b("Do not start recording on UI thread.");
                    Preconditions.checkNotNull(c01011);
                    audioFingerprintCapturer.f1038i = c01011;
                    if (audioFingerprintCapturer.f1032c.m1030e()) {
                        int minBufferSize = AudioRecord.getMinBufferSize(8000, 16, 2);
                        if (minBufferSize == -2 || minBufferSize == -1) {
                            HandlerDetour.a(audioFingerprintCapturer.f1035f, audioFingerprintCapturer.f1034e, 167310618);
                            return;
                        }
                        audioFingerprintCapturer.f1037h = new AudioRecord(0, 8000, 16, 2, minBufferSize * 10);
                        if (audioFingerprintCapturer.f1037h.getState() != 1) {
                            HandlerDetour.a(audioFingerprintCapturer.f1035f, audioFingerprintCapturer.f1034e, 697446188);
                            return;
                        }
                        audioFingerprintCapturer.f1037h.startRecording();
                        audioFingerprintCapturer.f1036g.set(true);
                        HandlerDetour.a(audioFingerprintCapturer.f1035f, audioFingerprintCapturer.f1033d, 209078033);
                        return;
                    }
                    HandlerDetour.a(audioFingerprintCapturer.f1035f, audioFingerprintCapturer.f1034e, -1587878517);
                }
            }, 1317150056);
            return this.f1066o;
        }
        callback.mo85a();
        return Absent.INSTANCE;
    }

    static /* synthetic */ int m1013a(AudioFingerprintingSession audioFingerprintingSession, int i) {
        int i2 = audioFingerprintingSession.f1064m + i;
        audioFingerprintingSession.f1064m = i2;
        return i2;
    }

    @Inject
    public AudioFingerprintingSession(AudioFingerprintCapturer audioFingerprintCapturer, Toaster toaster, TasksManager tasksManager, FetchSuggestionFromFingerprintRequest fetchSuggestionFromFingerprintRequest, ExecutorService executorService, ExecutorService executorService2, AudioFingerprintingSuggestionsCache audioFingerprintingSuggestionsCache, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f1052a = audioFingerprintCapturer;
        this.f1053b = tasksManager;
        this.f1054c = fetchSuggestionFromFingerprintRequest;
        this.f1056e = executorService;
        this.f1057f = executorService2;
        this.f1065n = audioFingerprintingSuggestionsCache;
        this.f1058g = abstractFbErrorReporter;
        this.f1055d = toaster;
        this.f1060i = Sets.a();
        this.f1061j = Absent.INSTANCE;
    }

    public static void m1014a(AudioFingerprintingSession audioFingerprintingSession, final String str, final Optional optional, final Optional optional2) {
        audioFingerprintingSession.f1053b.a(str, new Callable<ListenableFuture<SuggestedTaggableActivities>>(audioFingerprintingSession) {
            final /* synthetic */ AudioFingerprintingSession f1048c;

            public Object call() {
                FetchSuggestionFromFingerprintRequest fetchSuggestionFromFingerprintRequest = this.f1048c.f1054c;
                Optional optional = optional;
                Optional optional2 = optional2;
                boolean z = optional.isPresent() || optional2.isPresent();
                Preconditions.checkArgument(z);
                GraphQLQueryExecutor graphQLQueryExecutor = fetchSuggestionFromFingerprintRequest.f1078a;
                ScaleInputPixelRatio a = GraphQlQueryDefaults.a();
                RidgeSuggestionsQueryString ridgeSuggestionsQueryString = new RidgeSuggestionsQueryString();
                ridgeSuggestionsQueryString.a("image_scale", a).a("taggable_object_image_scale", a).a("taggable_activity_icon_image_scale", a).a("taggable_object_pp_size", FetchSuggestionFromFingerprintRequest.f1077c).a("minutiae_image_size_large", FetchSuggestionFromFingerprintRequest.f1076b);
                if (optional.isPresent()) {
                    GraphQLFingerprintingParams graphQLFingerprintingParams = (GraphQLFingerprintingParams) optional.get();
                    ridgeSuggestionsQueryString.a("fingerprint_segment_length", String.valueOf(graphQLFingerprintingParams.f1084a));
                    ridgeSuggestionsQueryString.a("fingerprint_segment_offset", String.valueOf(graphQLFingerprintingParams.f1085b));
                    ridgeSuggestionsQueryString.a("version", String.valueOf(graphQLFingerprintingParams.f1086c));
                    ridgeSuggestionsQueryString.a("audio_fingerprint", graphQLFingerprintingParams.f1088e);
                    ridgeSuggestionsQueryString.a("session_token", graphQLFingerprintingParams.f1087d);
                }
                if (optional2.isPresent()) {
                    MusicMetadata musicMetadata = (MusicMetadata) optional2.get();
                    if (musicMetadata.f1072a != null) {
                        ridgeSuggestionsQueryString.a("current_song_artist", musicMetadata.f1072a);
                    }
                    if (musicMetadata.f1073b != null) {
                        ridgeSuggestionsQueryString.a("current_song_album", musicMetadata.f1073b);
                    }
                    if (musicMetadata.f1074c != null) {
                        ridgeSuggestionsQueryString.a("current_song_title", musicMetadata.f1074c);
                    }
                }
                return FetchSuggestionFromFingerprintRequest.m1036a(graphQLQueryExecutor.a(GraphQLRequest.a(ridgeSuggestionsQueryString).a(GraphQLCachePolicy.c)));
            }
        }, new AbstractDisposableFutureCallback<SuggestedTaggableActivities>(audioFingerprintingSession) {
            final /* synthetic */ AudioFingerprintingSession f1051c;

            protected final void m1005a(@Nullable Object obj) {
                SuggestedTaggableActivitiesModel suggestedTaggableActivitiesModel = (SuggestedTaggableActivitiesModel) obj;
                if (str.equals("local")) {
                    this.f1051c.f1067p = optional2;
                }
                if (suggestedTaggableActivitiesModel != null) {
                    this.f1051c.f1061j = Optional.of(suggestedTaggableActivitiesModel);
                }
                m1004b();
            }

            protected final void m1006a(Throwable th) {
                this.f1051c.f1055d.b(new ToastBuilder(th.getMessage()));
                m1004b();
            }

            protected final void m1007a(CancellationException cancellationException) {
                m1004b();
            }

            private void m1004b() {
                this.f1051c.f1060i.remove(str);
                if (!(!this.f1051c.f1061j.isPresent() || ((SuggestedTaggableActivitiesModel) this.f1051c.f1061j.get()).a() == null || ((SuggestedTaggableActivitiesModel) this.f1051c.f1061j.get()).a().isEmpty())) {
                    this.f1051c.f1062k = this.f1051c.f1065n.m1024b(((SuggestedTaggableActivitiesModel) this.f1051c.f1061j.get()).a());
                }
                if (this.f1051c.f1062k != null || (!this.f1051c.f1053b.a() && this.f1051c.f1060i.isEmpty())) {
                    this.f1051c.m1018a();
                }
            }
        });
    }

    public final void m1018a() {
        if (this.f1063l == null) {
            m1019b();
            return;
        }
        if (this.f1062k != null) {
            this.f1063l.mo88a(this.f1062k, (String) this.f1066o.get());
            this.f1065n.f1069a = ((SuggestedTaggableActivitiesModel) this.f1061j.get()).a();
        } else if (this.f1061j.isPresent() && ((SuggestedTaggableActivitiesModel) this.f1061j.get()).b()) {
            this.f1063l.mo87a(ErrorCode.COMMERCIAL, (String) this.f1066o.get());
        } else {
            this.f1063l.mo87a(ErrorCode.NO_MATCH, (String) this.f1066o.get());
        }
        m1019b();
    }

    public final void m1019b() {
        this.f1053b.c();
        this.f1052a.m1003f();
        this.f1059h.removeCallbacksAndMessages(null);
        this.f1060i.clear();
    }

    public final double m1020c() {
        return this.f1052a.f1032c.m1033h();
    }
}

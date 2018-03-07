package com.facebook.backstage.consumption.importflow;

import android.database.Cursor;
import com.facebook.backstage.StacksConstants;
import com.facebook.backstage.abtest.BackstageGatekeepers;
import com.facebook.common.android.ContentResolverMethodAutoProvider;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.executors.ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider;
import com.facebook.common.time.Clock;
import com.facebook.common.time.SystemClockMethodAutoProvider;
import com.facebook.debug.log.BLog;
import com.facebook.inject.InjectorLike;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListeningExecutorService;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: screen_data */
public class ImportFlowDataProvider {
    public static final String f4728a = ImportFlowDataProvider.class.getSimpleName();
    private final DelegatingFutureCallback f4729b = new DelegatingFutureCallback(this);
    public final Object f4730c = new Object();
    public final LocalMediaCursorUtil f4731d;
    private final ListeningExecutorService f4732e;
    private final ListeningExecutorService f4733f;
    public final FbSharedPreferences f4734g;
    public final Clock f4735h;
    public volatile ImmutableList<ImportMedia> f4736i = RegularImmutableList.a;

    /* compiled from: screen_data */
    public interface CallBack {
        void mo153a(@Nullable ImmutableList<ImportMedia> immutableList);
    }

    /* compiled from: screen_data */
    public class DelegatingFutureCallback implements FutureCallback {
        final /* synthetic */ ImportFlowDataProvider f4726a;
        public WeakReference<CallBack> f4727b = new WeakReference(null);

        public DelegatingFutureCallback(ImportFlowDataProvider importFlowDataProvider) {
            this.f4726a = importFlowDataProvider;
        }

        public void onSuccess(@Nullable Object obj) {
            CallBack callBack = (CallBack) this.f4727b.get();
            if (callBack != null) {
                callBack.mo153a(m4615a());
            }
        }

        public void onFailure(Throwable th) {
            BLog.b(ImportFlowDataProvider.f4728a, "Unable to query media files.", th);
        }

        private ImmutableList<ImportMedia> m4615a() {
            ImmutableList<ImportMedia> immutableList;
            synchronized (this.f4726a.f4730c) {
                immutableList = this.f4726a.f4736i;
            }
            return immutableList;
        }
    }

    public static ImportFlowDataProvider m4619b(InjectorLike injectorLike) {
        return new ImportFlowDataProvider(new LocalMediaCursorUtil(ContentResolverMethodAutoProvider.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike), BackstageGatekeepers.m4256b(injectorLike)), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), (ListeningExecutorService) ListeningScheduledExecutorService_ForUiThreadMethodAutoProvider.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), (Clock) SystemClockMethodAutoProvider.a(injectorLike));
    }

    @Inject
    public ImportFlowDataProvider(LocalMediaCursorUtil localMediaCursorUtil, ListeningExecutorService listeningExecutorService, ListeningExecutorService listeningExecutorService2, FbSharedPreferences fbSharedPreferences, Clock clock) {
        this.f4731d = localMediaCursorUtil;
        this.f4732e = listeningExecutorService;
        this.f4733f = listeningExecutorService2;
        this.f4734g = fbSharedPreferences;
        this.f4735h = clock;
    }

    public final void m4621a(CallBack callBack, final boolean z) {
        this.f4729b.f4727b = new WeakReference(callBack);
        Futures.a(this.f4732e.a(new Runnable(this) {
            final /* synthetic */ ImportFlowDataProvider f4725b;

            /* compiled from: screen_data */
            class C04811 implements Comparator<ImportMedia> {
                final /* synthetic */ C04821 f4723a;

                C04811(C04821 c04821) {
                    this.f4723a = c04821;
                }

                public int compare(Object obj, Object obj2) {
                    return ((ImportMedia) obj).f4821e.compareTo(((ImportMedia) obj2).f4821e);
                }
            }

            public void run() {
                synchronized (this.f4725b.f4730c) {
                    Iterable arrayList = new ArrayList();
                    ImportFlowDataProvider.m4618a(arrayList, this.f4725b.f4731d.m4725a(z), false);
                    ImportFlowDataProvider.m4618a(arrayList, this.f4725b.f4731d.m4726b(z), true);
                    Collections.sort(arrayList, new C04811(this));
                    this.f4725b.f4736i = new Builder().b(arrayList).b();
                }
            }
        }), this.f4729b, this.f4733f);
    }

    private static void m4618a(List<ImportMedia> list, Cursor cursor, boolean z) {
        if (cursor == null) {
            String str = f4728a;
            String str2 = "No media type : %s found.";
            Object[] objArr = new Object[1];
            objArr[0] = z ? "video" : "photo";
            BLog.b(str, str2, objArr);
            return;
        }
        while (cursor.moveToNext()) {
            try {
                list.add(LocalMediaCursorUtil.m4722a(cursor, z));
            } finally {
                cursor.close();
            }
        }
    }

    public final void m4620a() {
        this.f4734g.edit().a(StacksConstants.f4257g, this.f4735h.a()).commit();
    }
}

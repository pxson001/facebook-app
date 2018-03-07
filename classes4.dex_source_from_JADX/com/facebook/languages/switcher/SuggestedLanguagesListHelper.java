package com.facebook.languages.switcher;

import com.facebook.androidcompat.AndroidCompat;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.json.FbObjectMapper;
import com.facebook.common.json.FbObjectMapperMethodAutoProvider;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectorLike;
import com.facebook.inject.Lazy;
import com.facebook.languages.switcher.logging.LanguageSwitcherLoginLogger;
import com.facebook.prefs.shared.FbSharedPreferences;
import com.facebook.prefs.shared.FbSharedPreferencesImpl;
import com.facebook.ui.futures.TasksManager;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableList;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: udp_sending_task */
public class SuggestedLanguagesListHelper {
    public LanguageSwitcher f646a;
    private final FbSharedPreferences f647b;
    private final TasksManager f648c;
    private final FbObjectMapper f649d;
    public final Lazy<LanguageSwitcherLoginLogger> f650e;
    private final AbstractFbErrorReporter f651f;
    public ImmutableList<String> f652g;

    /* compiled from: udp_sending_task */
    class C00563 extends TypeReference<List<String>> {
        final /* synthetic */ SuggestedLanguagesListHelper f913b;

        C00563(SuggestedLanguagesListHelper suggestedLanguagesListHelper) {
            this.f913b = suggestedLanguagesListHelper;
        }
    }

    /* compiled from: udp_sending_task */
    enum Tasks {
        FETCH_LANGUAGE_LIST
    }

    /* compiled from: udp_sending_task */
    class C00571 implements Callable<ListenableFuture<ImmutableList<String>>> {
        final /* synthetic */ SuggestedLanguagesListHelper f917a;

        C00571(SuggestedLanguagesListHelper suggestedLanguagesListHelper) {
            this.f917a = suggestedLanguagesListHelper;
        }

        public Object call() {
            return this.f917a.f646a.e();
        }
    }

    public static SuggestedLanguagesListHelper m1017b(InjectorLike injectorLike) {
        return new SuggestedLanguagesListHelper(LanguageSwitcher.a(injectorLike), (FbSharedPreferences) FbSharedPreferencesImpl.a(injectorLike), TasksManager.b(injectorLike), FbObjectMapperMethodAutoProvider.a(injectorLike), IdBasedLazy.a(injectorLike, 2454), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public SuggestedLanguagesListHelper(LanguageSwitcher languageSwitcher, FbSharedPreferences fbSharedPreferences, TasksManager tasksManager, FbObjectMapper fbObjectMapper, Lazy<LanguageSwitcherLoginLogger> lazy, FbErrorReporter fbErrorReporter) {
        this.f646a = languageSwitcher;
        this.f647b = fbSharedPreferences;
        this.f648c = tasksManager;
        this.f649d = fbObjectMapper;
        this.f650e = lazy;
        this.f651f = fbErrorReporter;
    }

    public static SuggestedLanguagesListHelper m1014a(InjectorLike injectorLike) {
        return m1017b(injectorLike);
    }

    public final void m1019a() {
        this.f652g = m1018d();
        if (this.f652g == null || this.f652g.size() < 2) {
            final List arrayList = new ArrayList();
            this.f648c.a(Tasks.FETCH_LANGUAGE_LIST.name(), new C00571(this), new AbstractDisposableFutureCallback<ImmutableList<String>>(this) {
                final /* synthetic */ SuggestedLanguagesListHelper f919b;

                public final void m1254a(Object obj) {
                    ImmutableList immutableList = (ImmutableList) obj;
                    synchronized (this.f919b) {
                        if (immutableList != null) {
                            if (immutableList.size() >= 2) {
                                arrayList.addAll(immutableList);
                                this.f919b.f652g = ImmutableList.copyOf(arrayList);
                                ((LanguageSwitcherLoginLogger) this.f919b.f650e.get()).m1115a(this.f919b.f652g);
                                SuggestedLanguagesListHelper.m1016a(this.f919b, arrayList);
                            }
                        }
                        ((LanguageSwitcherLoginLogger) this.f919b.f650e.get()).m1114a();
                    }
                }

                public final void m1255a(Throwable th) {
                    synchronized (this.f919b) {
                        ((LanguageSwitcherLoginLogger) this.f919b.f650e.get()).m1116b();
                    }
                }
            });
        }
    }

    public final ImmutableList<String> m1020c() {
        if (this.f652g != null) {
            return this.f652g;
        }
        return RegularImmutableList.a;
    }

    @Nullable
    private ImmutableList<String> m1018d() {
        Throwable th;
        try {
            Throwable th2;
            JsonParser a = this.f649d.b().a(this.f647b.a(LanguageSwitcherPrefKeys.f912b, ""));
            try {
                ImmutableList<String> copyOf = ImmutableList.copyOf((List) a.a(new C00563(this)));
                if (a == null) {
                    return copyOf;
                }
                a.close();
                return copyOf;
            } catch (Throwable th22) {
                Throwable th3 = th22;
                th22 = th;
                th = th3;
            }
            if (a != null) {
                if (th22 != null) {
                    try {
                        a.close();
                    } catch (Throwable th4) {
                        AndroidCompat.addSuppressed(th22, th4);
                    }
                } else {
                    a.close();
                }
            }
            throw th;
            throw th;
        } catch (IOException e) {
            return null;
        }
    }

    public static void m1016a(SuggestedLanguagesListHelper suggestedLanguagesListHelper, List list) {
        try {
            suggestedLanguagesListHelper.f647b.edit().a(LanguageSwitcherPrefKeys.f912b, suggestedLanguagesListHelper.f649d.a(list)).commit();
        } catch (Throwable e) {
            suggestedLanguagesListHelper.f651f.a("save_suggested_locales_failed", "Couldn't save suggested locales in prefkeys.", e);
        }
    }
}

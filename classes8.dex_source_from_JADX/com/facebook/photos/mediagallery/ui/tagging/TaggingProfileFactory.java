package com.facebook.photos.mediagallery.ui.tagging;

import com.facebook.auth.userscope.UserScoped;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.inject.InjectorLike;
import com.facebook.photos.data.TaggingProfileProvider;
import com.facebook.photos.mediagallery.ui.tagging.DefaultSuggestionController.DefaultTagSuggestionsListener;
import com.facebook.tagging.model.SetTagSuggestionsCallback;
import com.facebook.tagging.model.TaggingProfile;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

@UserScoped
/* compiled from: skip_recent_story */
public class TaggingProfileFactory {
    private static final Object f2555e = new Object();
    public final TaggingProfileProvider f2556a;
    public final DefaultSuggestionController f2557b;
    public final AbstractFbErrorReporter f2558c;
    public final DefaultAndroidThreadUtil f2559d;

    /* compiled from: skip_recent_story */
    public class C03171 extends AbstractDisposableFutureCallback<Map<String, TaggingProfile>> {
        final /* synthetic */ List f2552a;
        final /* synthetic */ SetTagSuggestionsCallback f2553b;
        final /* synthetic */ TaggingProfileFactory f2554c;

        /* compiled from: skip_recent_story */
        class C03161 implements DefaultTagSuggestionsListener {
            final /* synthetic */ C03171 f2551a;

            C03161(C03171 c03171) {
                this.f2551a = c03171;
            }

            public final void mo129a(ImmutableList<TaggingProfile> immutableList) {
                this.f2551a.f2553b.setTagSuggestions(immutableList);
            }
        }

        public C03171(TaggingProfileFactory taggingProfileFactory, List list, SetTagSuggestionsCallback setTagSuggestionsCallback) {
            this.f2554c = taggingProfileFactory;
            this.f2552a = list;
            this.f2553b = setTagSuggestionsCallback;
        }

        protected final void m2659a(Object obj) {
            Map map = (Map) obj;
            List a = Lists.a();
            for (String str : this.f2552a) {
                a.add(map.get(str));
            }
            this.f2553b.setTagSuggestions(a);
        }

        protected final void m2660a(Throwable th) {
            this.f2554c.f2558c.a("TaggingProfileFactorytag_suggestion_lookup_failed", th);
            this.f2554c.f2557b.m2570a(new C03161(this));
        }
    }

    private static TaggingProfileFactory m2662b(InjectorLike injectorLike) {
        return new TaggingProfileFactory(TaggingProfileProvider.b(injectorLike), DefaultSuggestionController.m2568a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public TaggingProfileFactory(TaggingProfileProvider taggingProfileProvider, DefaultSuggestionController defaultSuggestionController, DefaultAndroidThreadUtil defaultAndroidThreadUtil, AbstractFbErrorReporter abstractFbErrorReporter) {
        this.f2556a = taggingProfileProvider;
        this.f2557b = defaultSuggestionController;
        this.f2559d = defaultAndroidThreadUtil;
        this.f2558c = abstractFbErrorReporter;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.facebook.photos.mediagallery.ui.tagging.TaggingProfileFactory m2661a(com.facebook.inject.InjectorLike r7) {
        /*
        r2 = com.facebook.inject.ScopeSet.a();
        r0 = com.facebook.auth.userscope.UserScope.class;
        r0 = r7.getInstance(r0);
        r0 = (com.facebook.auth.userscope.UserScope) r0;
        r1 = r7.getScopeAwareInjector();
        r1 = r1.b();
        if (r1 != 0) goto L_0x001e;
    L_0x0016:
        r0 = new com.facebook.inject.ProvisioningException;
        r1 = "Called user scoped provider outside of context scope";
        r0.<init>(r1);
        throw r0;
    L_0x001e:
        r3 = r0.a(r1);
        r4 = r3.b();	 Catch:{ all -> 0x006c }
        r1 = f2555e;	 Catch:{ all -> 0x006c }
        r1 = r4.get(r1);	 Catch:{ all -> 0x006c }
        r5 = com.facebook.auth.userscope.UserScope.a;	 Catch:{ all -> 0x006c }
        if (r1 != r5) goto L_0x0035;
    L_0x0030:
        r3.c();
        r0 = 0;
    L_0x0034:
        return r0;
    L_0x0035:
        if (r1 != 0) goto L_0x007c;
    L_0x0037:
        r1 = 4;
        r5 = r2.b(r1);	 Catch:{  }
        r6 = r0.a(r3);	 Catch:{ all -> 0x0067 }
        r0 = r6.e();	 Catch:{ all -> 0x0062 }
        r1 = m2662b(r0);	 Catch:{ all -> 0x0062 }
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        if (r1 != 0) goto L_0x0071;
    L_0x004d:
        r0 = f2555e;	 Catch:{  }
        r6 = com.facebook.auth.userscope.UserScope.a;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r6);	 Catch:{  }
        r0 = (com.facebook.photos.mediagallery.ui.tagging.TaggingProfileFactory) r0;	 Catch:{  }
    L_0x0057:
        if (r0 == 0) goto L_0x007a;
    L_0x0059:
        r2.c(r5);	 Catch:{  }
    L_0x005c:
        r0 = (com.facebook.photos.mediagallery.ui.tagging.TaggingProfileFactory) r0;	 Catch:{  }
        r3.c();
        goto L_0x0034;
    L_0x0062:
        r0 = move-exception;
        com.facebook.auth.userscope.UserScope.a(r6);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x0067:
        r0 = move-exception;
        r2.c(r5);	 Catch:{  }
        throw r0;	 Catch:{  }
    L_0x006c:
        r0 = move-exception;
        r3.c();
        throw r0;
    L_0x0071:
        r0 = f2555e;	 Catch:{  }
        r0 = r4.putIfAbsent(r0, r1);	 Catch:{  }
        r0 = (com.facebook.photos.mediagallery.ui.tagging.TaggingProfileFactory) r0;	 Catch:{  }
        goto L_0x0057;
    L_0x007a:
        r0 = r1;
        goto L_0x0059;
    L_0x007c:
        r0 = r1;
        goto L_0x005c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.photos.mediagallery.ui.tagging.TaggingProfileFactory.a(com.facebook.inject.InjectorLike):com.facebook.photos.mediagallery.ui.tagging.TaggingProfileFactory");
    }
}

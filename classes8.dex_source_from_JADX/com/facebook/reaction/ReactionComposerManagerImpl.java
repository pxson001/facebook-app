package com.facebook.reaction;

import android.content.Context;
import com.facebook.common.unicode.UTF16Range;
import com.facebook.composer.minutiae.model.MinutiaeObject;
import com.facebook.graphql.calls.ReactionTriggerInputTriggerData.Surface;
import com.facebook.hashtag.parser.HashtagParser;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.ComposerShareParams;
import com.facebook.places.graphql.PlacesGraphQLModels.CheckinPlaceModel;
import com.facebook.reaction.common.ReactionExperimentController;
import com.facebook.reaction.composer.ReactionComposerManager;
import com.facebook.reaction.util.ReactionSurfaceUtil;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: c5c55936676a93efb3ca87c98618c2f0 */
public class ReactionComposerManagerImpl implements ReactionComposerManager {
    public final ReactionExperimentController f18592a;
    private final ReactionQueryParams f18593b = new ReactionQueryParams();
    private final ReactionUtil f18594c;
    private final String f18595d;
    private final Context f18596e;
    private boolean f18597f;
    private final boolean f18598g;
    private final boolean f18599h;
    private final boolean f18600i;
    private final Lazy<ReactionPlaceTipsPostComposeManager> f18601j;
    private final boolean f18602k;
    private final ReactionSessionManager f18603l;
    private final boolean f18604m;
    private final Surface f18605n;
    private final String f18606o;

    /* compiled from: c5c55936676a93efb3ca87c98618c2f0 */
    /* synthetic */ class C20581 {
        static final /* synthetic */ int[] f18591a = new int[Surface.values().length];

        static {
            try {
                f18591a[Surface.ANDROID_PAGE_ADMIN_COMPOSER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18591a[Surface.ANDROID_PMA_PAGE_ADMIN_COMPOSER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18591a[Surface.ANDROID_FEED_COMPOSER.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18591a[Surface.ANDROID_PAGE_LIKES_CONTEXT_ITEM.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18591a[Surface.ANDROID_POPULAR_AT_PLACE_CONTEXT_ITEM.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f18591a[Surface.ANDROID_PAGE_FRIENDS_CONTENT_CONTEXT_ITEM.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f18591a[Surface.ANDROID_PAGE_SANDBOX.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    @Inject
    public ReactionComposerManagerImpl(@Assisted String str, @Assisted Boolean bool, @Assisted Surface surface, Context context, Lazy<ReactionPlaceTipsPostComposeManager> lazy, Provider<String> provider, ReactionExperimentController reactionExperimentController, ReactionSessionManager reactionSessionManager, ReactionUtil reactionUtil) {
        this.f18595d = str;
        this.f18596e = context;
        this.f18592a = reactionExperimentController;
        this.f18601j = lazy;
        this.f18594c = reactionUtil;
        this.f18605n = m22495a(surface);
        this.f18606o = (String) provider.get();
        boolean z = (this.f18592a.e() && !bool.booleanValue() && m22499c(surface)) ? false : true;
        this.f18598g = z;
        this.f18599h = this.f18592a.h();
        this.f18600i = this.f18592a.m();
        this.f18602k = reactionExperimentController.g();
        this.f18604m = this.f18592a.p();
        this.f18603l = reactionSessionManager;
        if (!this.f18598g) {
            long j;
            ReactionSessionManager reactionSessionManager2 = this.f18603l;
            Surface surface2 = this.f18605n;
            if (ReactionSurfaceUtil.m4778d(surface)) {
                j = 1500;
            } else {
                j = 4000;
            }
            reactionSessionManager2.m22604a(str, surface2, j);
        }
    }

    public final void mo238b() {
        if (!this.f18598g) {
            this.f18603l.m22608a(this.f18595d);
        }
    }

    public final void mo239c() {
        if (!this.f18598g) {
            if (this.f18597f) {
                this.f18593b.m22525a(new HashtagParser(this.f18593b.f18633n).b());
                m22496a();
            }
            if (!((ReactionPlaceTipsPostComposeManager) this.f18601j.get()).m22522a(this.f18603l, this.f18595d, this.f18593b)) {
                this.f18603l.m22616c(this.f18595d);
                if (ReactionSurfaceUtil.m4778d(this.f18605n)) {
                    this.f18603l.m22609a(this.f18595d, this.f18596e);
                }
            }
        }
    }

    public final void mo236a(CharSequence charSequence) {
        if (!this.f18598g && this.f18599h) {
            HashtagParser hashtagParser = new HashtagParser(charSequence);
            List b = hashtagParser.b();
            Matcher matcher = HashtagParser.g.matcher(hashtagParser.a);
            Collection b2 = Lists.b();
            while (matcher.find()) {
                b2.add(new UTF16Range(matcher.start(2), matcher.end(2) - matcher.start(2)));
            }
            List copyOf = ImmutableList.copyOf(b2);
            List list = this.f18593b.f18625f;
            this.f18593b.f18633n = charSequence.toString();
            if (!b.isEmpty() || !list.isEmpty()) {
                if (!list.containsAll(b) || !b.containsAll(list)) {
                    if (b.size() < list.size()) {
                        m22497a(b);
                        return;
                    }
                    int i = 0;
                    while (i < b.size() - 1) {
                        if (list.contains((String) b.get(i))) {
                            i++;
                        } else {
                            this.f18593b.m22525a(b);
                            this.f18597f = true;
                            return;
                        }
                    }
                    if (m22498b(copyOf)) {
                        m22497a(b);
                    } else {
                        this.f18597f = true;
                    }
                }
            }
        }
    }

    public final void mo234a(ImmutableList<Long> immutableList) {
        if (!this.f18598g && this.f18600i && !this.f18593b.f18627h.equals(immutableList)) {
            this.f18593b.f18627h = immutableList;
            m22496a();
        }
    }

    public final void mo231a(@Nullable MinutiaeObject minutiaeObject) {
        if (!this.f18598g) {
            if (minutiaeObject == null || minutiaeObject.object == null || minutiaeObject.object.k() == null || minutiaeObject.verb == null) {
                this.f18593b.f18629j = null;
                this.f18593b.f18630k = null;
            } else {
                this.f18593b.f18629j = minutiaeObject.verb.l();
                this.f18593b.f18630k = minutiaeObject.object.k().d();
            }
            m22496a();
        }
    }

    public final void mo233a(@Nullable CheckinPlaceModel checkinPlaceModel) {
        String str = null;
        if (!this.f18598g) {
            Long valueOf = (checkinPlaceModel == null || checkinPlaceModel.cf_() == null || checkinPlaceModel.cf_().isEmpty()) ? null : Long.valueOf(Long.parseLong(checkinPlaceModel.cf_()));
            if (checkinPlaceModel != null) {
                str = checkinPlaceModel.j();
            }
            if (this.f18593b.f18631l != null || valueOf != null) {
                if (this.f18593b.f18631l == null || !this.f18593b.f18631l.equals(valueOf)) {
                    this.f18593b.f18631l = valueOf;
                    this.f18593b.f18632m = str;
                    m22496a();
                }
            }
        }
    }

    public final void mo235a(ImmutableSet<Long> immutableSet) {
        if (!this.f18598g) {
            this.f18593b.f18637r = immutableSet;
            m22496a();
        }
    }

    public final void mo232a(ComposerShareParams composerShareParams) {
        if (!this.f18598g && this.f18604m) {
            if (composerShareParams == null || composerShareParams.shareable == null) {
                this.f18593b.f18636q = null;
            } else {
                this.f18593b.f18636q = composerShareParams.shareable.d();
            }
            m22496a();
        }
    }

    public final void mo237a(Long l) {
        if (!this.f18598g) {
            Long l2 = this.f18593b.f18639t;
            if (l != null && !l.equals(l2)) {
                if (l2 == null && this.f18606o.equals(Long.toString(l.longValue()))) {
                    this.f18593b.f18639t = l;
                    return;
                }
                this.f18593b.f18639t = l;
                if (this.f18602k) {
                    m22496a();
                }
            }
        }
    }

    private Surface m22495a(Surface surface) {
        Object obj;
        if (surface == Surface.ANDROID_FEED_COMPOSER && this.f18592a.a()) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj == null) {
            return surface;
        }
        if (this.f18592a.i()) {
            return Surface.ANDROID_SEARCH_LOCAL_PLACE_TIPS_CHECKIN;
        }
        return Surface.ANDROID_FEED_CHECKIN_SUGGESTION;
    }

    private static boolean m22499c(Surface surface) {
        if (ReactionSurfaceUtil.m4783j(surface)) {
            return true;
        }
        switch (C20581.f18591a[surface.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
            default:
                return false;
        }
    }

    private void m22497a(List<String> list) {
        this.f18593b.m22525a((List) list);
        this.f18597f = false;
        m22496a();
    }

    private boolean m22498b(List<UTF16Range> list) {
        int size = list.size() - 1;
        int i = ((UTF16Range) list.get(size)).b + ((UTF16Range) list.get(size)).a;
        return i < this.f18593b.f18633n.length() && this.f18593b.f18633n.codePointAt(i) == 32;
    }

    private void m22496a() {
        this.f18594c.m22660a(this.f18593b, this.f18595d, this.f18605n);
    }
}

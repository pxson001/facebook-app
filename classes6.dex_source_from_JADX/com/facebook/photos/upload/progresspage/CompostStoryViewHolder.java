package com.facebook.photos.upload.progresspage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.LinearLayout;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.i18n.StringLengthHelper;
import com.facebook.common.network.FbNetworkManager;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil;
import com.facebook.common.timeformat.TimeFormatUtil.TimeFormatStyle;
import com.facebook.common.uri.UriIntentMapper;
import com.facebook.common.util.StringUtil;
import com.facebook.composer.publish.cache.pendingstory.PendingStoryStore;
import com.facebook.composer.publish.common.PendingStory;
import com.facebook.composer.publish.compost.story.CompostDraftStory;
import com.facebook.composer.publish.compost.story.CompostStory;
import com.facebook.composer.publish.compost.story.CompostStory.StoryType;
import com.facebook.composer.publish.compost.story.RecentlyUploadedStory;
import com.facebook.compost.abtest.ExperimentsForCompostAbTestModule;
import com.facebook.content.SecureContextHelper;
import com.facebook.drawee.fbpipeline.FbDraweeView;
import com.facebook.fbui.dialog.AlertDialog;
import com.facebook.fbui.dialog.AlertDialog.Builder;
import com.facebook.fbui.menu.MenuItemImpl;
import com.facebook.fbui.menu.PopoverMenu;
import com.facebook.fbui.popover.PopoverMenuWindow;
import com.facebook.inject.Assisted;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.model.RetrySource;
import com.facebook.ipc.feed.StoryPermalinkParamsType;
import com.facebook.ipc.feed.ViewPermalinkIntentFactory;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.photos.upload.compost.CompostPendingPost;
import com.facebook.photos.upload.compost.analytics.CompostAnalyticsLogger;
import com.facebook.photos.upload.progresspage.CompostFragment.C08912;
import com.facebook.photos.upload.progresspage.CompostRecyclerViewAdapter.C09001;
import com.facebook.photos.upload.progresspage.CompostRecyclerViewAdapter.C09012;
import com.facebook.photos.upload.progresspage.CompostRecyclerViewAdapter.CompostSectionType;
import com.facebook.qe.api.QeAccessor;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;
import com.facebook.user.model.User;
import com.google.common.base.Absent;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: getSignatureFingerprint() does not exist in KeyHelper. This should never happen. */
public class CompostStoryViewHolder extends ViewHolder {
    public static final CallerContext f13914m = CallerContext.a(CompostStoryViewHolder.class);
    public final long f13915A;
    public final String f13916B;
    public View f13917C;
    public FbDraweeView f13918D = ((FbDraweeView) this.f13927n.findViewById(2131568190));
    public FbTextView f13919E = ((FbTextView) this.f13927n.findViewById(2131568191));
    public FbTextView f13920F = ((FbTextView) this.f13927n.findViewById(2131568192));
    public FbTextView f13921G = ((FbTextView) this.f13927n.findViewById(2131568193));
    public C09012 f13922H;
    public Optional<OnUnbindListener> f13923I = Absent.INSTANCE;
    public Optional<DraftViewHolderListener> f13924J;
    @Nullable
    public Runnable f13925K;
    public Context f13926l;
    public final LinearLayout f13927n;
    public final CompostStoryViewUtil f13928o;
    private final FbNetworkManager f13929p;
    private final PendingStoryStore f13930q;
    public final TimeFormatUtil f13931r;
    public final ViewPermalinkIntentFactory f13932s;
    public final SecureContextHelper f13933t;
    public final CompostAnalyticsLogger f13934u;
    public final Lazy<User> f13935v;
    public final Lazy<UriIntentMapper> f13936w;
    private final QeAccessor f13937x;
    public final Handler f13938y;
    public final boolean f13939z;

    /* compiled from: getSignatureFingerprint() does not exist in KeyHelper. This should never happen. */
    public class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ CompostPendingPost f13881a;
        final /* synthetic */ CompostStoryViewHolder f13882b;

        public AnonymousClass10(CompostStoryViewHolder compostStoryViewHolder, CompostPendingPost compostPendingPost) {
            this.f13882b = compostStoryViewHolder;
            this.f13881a = compostPendingPost;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            CompostStoryViewHolder.m21672x(this.f13882b);
            dialogInterface.dismiss();
            this.f13882b.f13928o.m21677a(this.f13881a.m21217a());
            this.f13882b.f13922H.m21644a();
            this.f13882b.f13934u.m21263d(this.f13881a.mo934f());
        }
    }

    /* compiled from: getSignatureFingerprint() does not exist in KeyHelper. This should never happen. */
    public interface OnUnbindListener {
        void mo1144a();
    }

    /* compiled from: getSignatureFingerprint() does not exist in KeyHelper. This should never happen. */
    public class AnonymousClass12 implements OnUnbindListener {
        final /* synthetic */ AlertDialog f13884a;
        final /* synthetic */ CompostStoryViewHolder f13885b;

        public AnonymousClass12(CompostStoryViewHolder compostStoryViewHolder, AlertDialog alertDialog) {
            this.f13885b = compostStoryViewHolder;
            this.f13884a = alertDialog;
        }

        public final void mo1144a() {
            this.f13884a.dismiss();
        }
    }

    /* compiled from: getSignatureFingerprint() does not exist in KeyHelper. This should never happen. */
    public class AnonymousClass13 implements OnClickListener {
        final /* synthetic */ CompostDraftStory f13886a;
        final /* synthetic */ CompostStoryViewHolder f13887b;

        public AnonymousClass13(CompostStoryViewHolder compostStoryViewHolder, CompostDraftStory compostDraftStory) {
            this.f13887b = compostStoryViewHolder;
            this.f13886a = compostDraftStory;
        }

        public void onClick(DialogInterface dialogInterface, int i) {
            CompostStoryViewHolder.m21672x(this.f13887b);
            dialogInterface.dismiss();
            if (this.f13887b.f13924J.isPresent()) {
                C09001 c09001 = (C09001) this.f13887b.f13924J.get();
                CompostDraftStory compostDraftStory = this.f13886a;
                if (c09001.f13870a.f13880f.isPresent()) {
                    ((C08912) c09001.f13870a.f13880f.get()).f13837a.f13847f.f13556e.mo928a(compostDraftStory.mo934f());
                }
            }
            this.f13887b.f13922H.m21644a();
            this.f13887b.f13934u.m21267e(this.f13886a.mo934f(), this.f13886a.mo930b(), this.f13886a.mo932d().isPresent() ? StringLengthHelper.a((String) this.f13886a.mo932d().get()) : 0);
        }
    }

    /* compiled from: getSignatureFingerprint() does not exist in KeyHelper. This should never happen. */
    public class AnonymousClass15 implements OnUnbindListener {
        final /* synthetic */ AlertDialog f13889a;
        final /* synthetic */ CompostStoryViewHolder f13890b;

        public AnonymousClass15(CompostStoryViewHolder compostStoryViewHolder, AlertDialog alertDialog) {
            this.f13890b = compostStoryViewHolder;
            this.f13889a = alertDialog;
        }

        public final void mo1144a() {
            this.f13889a.dismiss();
        }
    }

    /* compiled from: getSignatureFingerprint() does not exist in KeyHelper. This should never happen. */
    public class C09129 implements Runnable {
        final /* synthetic */ CompostPendingPost f13912a;
        final /* synthetic */ CompostStoryViewHolder f13913b;

        public C09129(CompostStoryViewHolder compostStoryViewHolder, CompostPendingPost compostPendingPost) {
            this.f13913b = compostStoryViewHolder;
            this.f13912a = compostPendingPost;
        }

        public void run() {
            CompostStoryViewHolder.m21669b(this.f13913b, this.f13912a.mo930b(), CompostStoryViewHolder.m21671e(this.f13913b, this.f13912a));
            this.f13913b.f13925K = null;
        }
    }

    public static void m21672x(CompostStoryViewHolder compostStoryViewHolder) {
        compostStoryViewHolder.f13923I = Absent.INSTANCE;
    }

    @Inject
    public CompostStoryViewHolder(@Assisted Context context, @Assisted View view, CompostStoryViewUtil compostStoryViewUtil, FbNetworkManager fbNetworkManager, PendingStoryStore pendingStoryStore, TimeFormatUtil timeFormatUtil, ViewPermalinkIntentFactory viewPermalinkIntentFactory, SecureContextHelper secureContextHelper, CompostAnalyticsLogger compostAnalyticsLogger, Lazy<User> lazy, Lazy<UriIntentMapper> lazy2, QeAccessor qeAccessor) {
        super(view);
        this.f13926l = context;
        this.f13927n = (LinearLayout) view;
        this.f13928o = compostStoryViewUtil;
        this.f13929p = fbNetworkManager;
        this.f13930q = pendingStoryStore;
        this.f13931r = timeFormatUtil;
        this.f13932s = viewPermalinkIntentFactory;
        this.f13933t = secureContextHelper;
        this.f13917C = view.findViewById(2131568194);
        this.f13934u = compostAnalyticsLogger;
        this.f13935v = lazy;
        this.f13936w = lazy2;
        this.f13937x = qeAccessor;
        this.f13924J = Absent.withType();
        this.f13938y = new Handler();
        this.f13939z = m21665A();
        this.f13915A = m21667C();
        if (this.f13939z) {
            this.f13916B = m21666B();
        } else {
            this.f13916B = "";
        }
        this.f13925K = null;
    }

    public final void m21674a(@Nullable C09001 c09001) {
        this.f13924J = Optional.fromNullable(c09001);
    }

    public static void m21668a(CompostStoryViewHolder compostStoryViewHolder, OnUnbindListener onUnbindListener) {
        compostStoryViewHolder.f13923I = Optional.of(onUnbindListener);
    }

    public final void m21673a(CompostStory compostStory, CompostSectionType compostSectionType) {
        this.f13927n.setOnClickListener(null);
        this.f13917C.setVisibility(8);
        final PopoverMenuWindow popoverMenuWindow;
        PopoverMenu c;
        MenuItemImpl a;
        switch (compostSectionType) {
            case PENDING_SECTION:
                final CompostPendingPost compostPendingPost = (CompostPendingPost) compostStory;
                this.f13917C.setVisibility(0);
                popoverMenuWindow = new PopoverMenuWindow(this.f13926l);
                c = popoverMenuWindow.c();
                MenuItemImpl a2 = c.a(2131236100);
                a = c.a(2131236101);
                a2.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ CompostStoryViewHolder f13893b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        CompostStoryViewHolder.m21672x(this.f13893b);
                        CompostStoryViewHolder compostStoryViewHolder = this.f13893b;
                        CompostPendingPost compostPendingPost = compostPendingPost;
                        compostStoryViewHolder.f13928o.m21678a(compostPendingPost.m21217a(), RetrySource.COMPOST, true);
                        if (compostStoryViewHolder.f13939z) {
                            compostStoryViewHolder.f13919E.setText(compostStoryViewHolder.f13916B);
                            HandlerDetour.a(compostStoryViewHolder.f13938y, compostStoryViewHolder.f13925K);
                            compostStoryViewHolder.f13925K = new C09129(compostStoryViewHolder, compostPendingPost);
                            HandlerDetour.b(compostStoryViewHolder.f13938y, compostStoryViewHolder.f13925K, compostStoryViewHolder.f13915A, -1049620713);
                        }
                        this.f13893b.f13934u.m21266e(compostPendingPost.mo934f());
                        return true;
                    }
                });
                a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ CompostStoryViewHolder f13895b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        CompostStoryViewHolder.m21672x(this.f13895b);
                        CompostStoryViewHolder compostStoryViewHolder = this.f13895b;
                        AlertDialog a = new Builder(compostStoryViewHolder.f13926l).a(false).b(compostStoryViewHolder.f13926l.getResources().getString(2131233519)).b(2131233465, new OnClickListener(compostStoryViewHolder) {
                            final /* synthetic */ CompostStoryViewHolder f13883a;

                            {
                                this.f13883a = r1;
                            }

                            public void onClick(DialogInterface dialogInterface, int i) {
                                CompostStoryViewHolder.m21672x(this.f13883a);
                                dialogInterface.dismiss();
                                this.f13883a.f13934u.m21259c("uploads_in_progress");
                            }
                        }).a(2131233440, new AnonymousClass10(compostStoryViewHolder, compostPendingPost)).a();
                        CompostStoryViewHolder.m21668a(compostStoryViewHolder, new AnonymousClass12(compostStoryViewHolder, a));
                        a.show();
                        this.f13895b.f13934u.m21255b("uploads_in_progress");
                        return true;
                    }
                });
                this.f13917C.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ CompostStoryViewHolder f13899c;

                    /* compiled from: getSignatureFingerprint() does not exist in KeyHelper. This should never happen. */
                    class C09041 implements OnUnbindListener {
                        final /* synthetic */ C09053 f13896a;

                        C09041(C09053 c09053) {
                            this.f13896a = c09053;
                        }

                        public final void mo1144a() {
                            popoverMenuWindow.l();
                        }
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1694316968);
                        popoverMenuWindow.c(view);
                        CompostStoryViewHolder.m21668a(this.f13899c, new C09041(this));
                        popoverMenuWindow.d();
                        this.f13899c.f13934u.m21251a("uploads_in_progress", compostPendingPost.mo934f());
                        Logger.a(2, EntryType.UI_INPUT_END, -606148526, a);
                    }
                });
                m21669b(this, compostStory.mo930b(), m21671e(this, compostPendingPost));
                break;
            case UPLOADED_SECTION:
                final RecentlyUploadedStory recentlyUploadedStory = (RecentlyUploadedStory) compostStory;
                this.f13927n.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ CompostStoryViewHolder f13909b;

                    public void onClick(View view) {
                        Object obj;
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 935365416);
                        RecentlyUploadedStory recentlyUploadedStory = recentlyUploadedStory;
                        if (recentlyUploadedStory.f8058b != StoryType.POST || recentlyUploadedStory.m11632g() == null) {
                            obj = null;
                        } else {
                            obj = 1;
                        }
                        String g;
                        if (obj != null) {
                            g = recentlyUploadedStory.m11632g();
                            this.f13909b.f13934u.m21268f(g);
                            ViewPermalinkIntentFactory viewPermalinkIntentFactory = this.f13909b.f13932s;
                            Bundle bundle = new Bundle();
                            bundle.putString("extra_permalink_param_type", StoryPermalinkParamsType.FEED_STORY_ID_KEY.name());
                            bundle.putString("story_id", g);
                            bundle.putBoolean("include_comments_disabled_fields", false);
                            bundle.putInt("target_fragment", ContentFragmentType.NATIVE_PERMALINK_PAGE_FRAGMENT.ordinal());
                            Intent intent = new Intent(viewPermalinkIntentFactory.a);
                            intent.putExtras(bundle);
                            viewPermalinkIntentFactory.c.a(intent);
                            this.f13909b.f13933t.a(intent, view.getContext());
                        } else {
                            recentlyUploadedStory = recentlyUploadedStory;
                            if (recentlyUploadedStory.f8058b == StoryType.COVER_PHOTO || recentlyUploadedStory.f8058b == StoryType.PROFILE_PIC) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                this.f13909b.f13934u.m21269g(((User) this.f13909b.f13935v.get()).a);
                                Intent a2 = ((UriIntentMapper) this.f13909b.f13936w.get()).a(view.getContext(), StringFormatUtil.a(FBLinks.aX, new Object[]{g}));
                                if (a2 != null) {
                                    this.f13909b.f13933t.a(a2, view.getContext());
                                }
                            }
                        }
                        LogUtils.a(-494150036, a);
                    }
                });
                m21670c(2131236023);
                break;
            case DRAFT_SECTION:
                final CompostDraftStory compostDraftStory = (CompostDraftStory) compostStory;
                this.f13917C.setVisibility(0);
                popoverMenuWindow = new PopoverMenuWindow(this.f13926l);
                c = popoverMenuWindow.c();
                c.a(2131236102).setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ CompostStoryViewHolder f13901b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        CompostStoryViewHolder.m21672x(this.f13901b);
                        CompostStoryViewHolder compostStoryViewHolder = this.f13901b;
                        AlertDialog a = new Builder(compostStoryViewHolder.f13926l).a(false).b(compostStoryViewHolder.f13926l.getResources().getString(2131236105)).b(2131236104, new OnClickListener(compostStoryViewHolder) {
                            final /* synthetic */ CompostStoryViewHolder f13888a;

                            {
                                this.f13888a = r1;
                            }

                            public void onClick(DialogInterface dialogInterface, int i) {
                                CompostStoryViewHolder.m21672x(this.f13888a);
                                dialogInterface.dismiss();
                                this.f13888a.f13934u.m21259c("drafts");
                            }
                        }).a(2131233440, new AnonymousClass13(compostStoryViewHolder, compostDraftStory)).a();
                        CompostStoryViewHolder.m21668a(compostStoryViewHolder, new AnonymousClass15(compostStoryViewHolder, a));
                        a.show();
                        this.f13901b.f13934u.m21255b("drafts");
                        return true;
                    }
                });
                a = c.a(2131236103);
                this.f13917C.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ CompostStoryViewHolder f13905c;

                    /* compiled from: getSignatureFingerprint() does not exist in KeyHelper. This should never happen. */
                    class C09071 implements OnUnbindListener {
                        final /* synthetic */ C09085 f13902a;

                        C09071(C09085 c09085) {
                            this.f13902a = c09085;
                        }

                        public final void mo1144a() {
                            popoverMenuWindow.l();
                        }
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1294036573);
                        popoverMenuWindow.c(view);
                        CompostStoryViewHolder.m21668a(this.f13905c, new C09071(this));
                        popoverMenuWindow.d();
                        this.f13905c.f13934u.m21251a("drafts", compostDraftStory.mo934f());
                        Logger.a(2, EntryType.UI_INPUT_END, -1317067810, a);
                    }
                });
                a.setOnMenuItemClickListener(new OnMenuItemClickListener(this) {
                    final /* synthetic */ CompostStoryViewHolder f13907b;

                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (this.f13907b.f13924J.isPresent()) {
                            this.f13907b.f13934u.m21252a("menu", compostDraftStory.mo934f(), compostDraftStory.mo930b(), compostDraftStory.mo932d().isPresent() ? StringLengthHelper.a((String) compostDraftStory.mo932d().get()) : 0);
                            ((C09001) this.f13907b.f13924J.get()).m21643a(compostDraftStory);
                        }
                        return true;
                    }
                });
                this.f13927n.setOnClickListener(new View.OnClickListener(this) {
                    final /* synthetic */ CompostStoryViewHolder f13911b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1099505056);
                        if (this.f13911b.f13924J.isPresent()) {
                            this.f13911b.f13934u.m21252a("view_holder", compostDraftStory.mo934f(), compostDraftStory.mo930b(), compostDraftStory.mo932d().isPresent() ? StringLengthHelper.a((String) compostDraftStory.mo932d().get()) : 0);
                            ((C09001) this.f13911b.f13924J.get()).m21643a(compostDraftStory);
                        }
                        LogUtils.a(-1144937515, a);
                    }
                });
                m21670c(2131236024);
                break;
        }
        Optional e = compostStory.mo933e();
        if (e.isPresent()) {
            this.f13918D.a((Uri) e.get(), f13914m);
        } else {
            this.f13918D.setImageResource(2130843572);
        }
        e = compostStory.mo932d();
        if (!e.isPresent() || StringUtil.c((CharSequence) e.get())) {
            this.f13920F.setVisibility(8);
        } else {
            this.f13920F.setVisibility(0);
            this.f13920F.setText((CharSequence) e.get());
        }
        this.f13921G.setText(this.f13931r.a(TimeFormatStyle.STREAM_RELATIVE_STYLE, compostStory.mo931c()));
    }

    private boolean m21665A() {
        return this.f13937x.a(ExperimentsForCompostAbTestModule.f8093l, true);
    }

    private String m21666B() {
        return this.f13937x.a(ExperimentsForCompostAbTestModule.f8104w, this.f13926l.getResources().getString(2131236022));
    }

    private long m21667C() {
        return this.f13937x.a(ExperimentsForCompostAbTestModule.f8103v, 3000);
    }

    public static void m21669b(CompostStoryViewHolder compostStoryViewHolder, int i, boolean z) {
        if (z) {
            if (i == 1) {
                compostStoryViewHolder.f13919E.setText(compostStoryViewHolder.f13926l.getResources().getQuantityString(2131689650, 1));
                return;
            }
            compostStoryViewHolder.f13919E.setText(compostStoryViewHolder.f13926l.getResources().getQuantityString(2131689650, i, new Object[]{Integer.valueOf(i)}));
        } else if (compostStoryViewHolder.f13929p.d()) {
            compostStoryViewHolder.f13919E.setText(compostStoryViewHolder.f13926l.getResources().getQuantityString(2131689648, i, new Object[]{Integer.valueOf(i)}));
        } else {
            compostStoryViewHolder.f13919E.setText(compostStoryViewHolder.f13926l.getResources().getQuantityString(2131689649, i, new Object[]{Integer.valueOf(i)}));
        }
    }

    private void m21670c(int i) {
        this.f13919E.setText(i);
    }

    public static boolean m21671e(CompostStoryViewHolder compostStoryViewHolder, CompostPendingPost compostPendingPost) {
        Optional d = compostStoryViewHolder.f13930q.d(compostPendingPost.m21217a().T());
        return (!d.isPresent() || ((PendingStory) d.get()).b().b() == null || ((PendingStory) d.get()).b().b().errorCode == 0 || ((PendingStory) d.get()).b().b().isRetriable) ? false : true;
    }
}

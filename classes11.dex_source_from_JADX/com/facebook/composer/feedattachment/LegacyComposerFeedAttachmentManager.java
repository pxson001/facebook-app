package com.facebook.composer.feedattachment;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventHandler;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.facebook.widget.LazyView;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: graphURI */
public class LegacyComposerFeedAttachmentManager implements ComposerEventHandler {
    public final TasksManager<String> f6468a;
    private final Context f6469b;
    private final ImmutableSet<ComposerFeedAttachmentController> f6470c;
    private final LazyView<View> f6471d;
    private final int f6472e = (this.f6469b.getResources().getDimensionPixelSize(2131428032) + this.f6469b.getResources().getDimensionPixelSize(2131429655));
    @Nullable
    private ViewGroup f6473f;
    @Nullable
    private View f6474g;
    @Nullable
    public ComposerFeedAttachmentController f6475h;
    @Nullable
    private String f6476i;

    /* compiled from: graphURI */
    class C08171 extends AbstractDisposableFutureCallback<GraphQLStoryAttachment> {
        final /* synthetic */ LegacyComposerFeedAttachmentManager f6465a;

        C08171(LegacyComposerFeedAttachmentManager legacyComposerFeedAttachmentManager) {
            this.f6465a = legacyComposerFeedAttachmentManager;
        }

        protected final void m7894a(Object obj) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
            if (graphQLStoryAttachment == null) {
                m7895a(new NullPointerException("minutiae_story_attachment_null"));
            } else {
                LegacyComposerFeedAttachmentManager.m7897a(this.f6465a, graphQLStoryAttachment);
            }
        }

        protected final void m7895a(Throwable th) {
            this.f6465a.f6475h.mo200i();
            Optional a = this.f6465a.f6475h.mo193a(th);
            if (a.isPresent()) {
                LegacyComposerFeedAttachmentManager.m7897a(this.f6465a, (GraphQLStoryAttachment) a.get());
            } else {
                LegacyComposerFeedAttachmentManager.m7903g(this.f6465a);
            }
        }
    }

    /* compiled from: graphURI */
    class C08182 implements OnClickListener {
        final /* synthetic */ LegacyComposerFeedAttachmentManager f6466a;

        C08182(LegacyComposerFeedAttachmentManager legacyComposerFeedAttachmentManager) {
            this.f6466a = legacyComposerFeedAttachmentManager;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1484205393);
            if (this.f6466a.f6475h != null) {
                this.f6466a.f6475h.mo199h();
            }
            LegacyComposerFeedAttachmentManager.m7903g(this.f6466a);
            LegacyComposerFeedAttachmentManager.m7901e(this.f6466a);
            Logger.a(2, EntryType.UI_INPUT_END, 10424977, a);
        }
    }

    /* compiled from: graphURI */
    /* synthetic */ class C08193 {
        static final /* synthetic */ int[] f6467a = new int[ComposerEvent.values().length];

        static {
            try {
                f6467a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6467a[ComposerEvent.ON_LAUNCH_FACECAST.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6467a[ComposerEvent.ON_DESTROY_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @Inject
    public LegacyComposerFeedAttachmentManager(TasksManager tasksManager, Context context, @Assisted ImmutableSet<ComposerFeedAttachmentController> immutableSet, @Assisted ViewStub viewStub) {
        this.f6468a = tasksManager;
        this.f6469b = context;
        this.f6470c = immutableSet;
        this.f6471d = new LazyView(viewStub);
        m7901e(this);
    }

    public final void m7906a(ComposerEvent composerEvent, @Nullable ComposerEventOriginator composerEventOriginator) {
        switch (C08193.f6467a[composerEvent.ordinal()]) {
            case 1:
                m7901e(this);
                return;
            case 2:
                m7903g(this);
                return;
            case 3:
                if (this.f6475h != null) {
                    this.f6475h.mo199h();
                }
                this.f6468a.c();
                return;
            default:
                return;
        }
    }

    @Nullable
    @VisibleForTesting
    private ComposerFeedAttachmentController m7896a() {
        Iterator it = this.f6470c.iterator();
        while (it.hasNext()) {
            ComposerFeedAttachmentController composerFeedAttachmentController = (ComposerFeedAttachmentController) it.next();
            if (composerFeedAttachmentController.mo196e()) {
                return composerFeedAttachmentController;
            }
        }
        return null;
    }

    private ViewGroup m7899b() {
        if (this.f6473f == null) {
            this.f6473f = (ViewGroup) this.f6471d.a().findViewById(2131563411);
        }
        return this.f6473f;
    }

    private View m7900c() {
        if (this.f6474g == null) {
            this.f6474g = this.f6471d.a().findViewById(2131563412);
        }
        return this.f6474g;
    }

    public static void m7901e(LegacyComposerFeedAttachmentManager legacyComposerFeedAttachmentManager) {
        ComposerFeedAttachmentController a = legacyComposerFeedAttachmentManager.m7896a();
        if (a == null) {
            m7903g(legacyComposerFeedAttachmentManager);
        } else if (legacyComposerFeedAttachmentManager.f6475h == null || legacyComposerFeedAttachmentManager.f6475h != a || !a.mo198g().equals(legacyComposerFeedAttachmentManager.f6476i)) {
            legacyComposerFeedAttachmentManager.f6475h = a;
            legacyComposerFeedAttachmentManager.f6476i = legacyComposerFeedAttachmentManager.f6475h.mo198g();
            legacyComposerFeedAttachmentManager.m7902f();
            legacyComposerFeedAttachmentManager.f6468a.a("fetchAttachment", legacyComposerFeedAttachmentManager.f6475h.mo195d(), new C08171(legacyComposerFeedAttachmentManager));
        }
    }

    private void m7902f() {
        if (this.f6475h != null) {
            m7898a(null);
            ViewGroup b = m7899b();
            b.removeAllViews();
            b.addView(this.f6475h.mo191a(this.f6469b, b));
            this.f6471d.a().setVisibility(0);
            m7905i();
        }
    }

    public static void m7897a(LegacyComposerFeedAttachmentManager legacyComposerFeedAttachmentManager, GraphQLStoryAttachment graphQLStoryAttachment) {
        if (legacyComposerFeedAttachmentManager.f6475h != null) {
            if (GraphQLStoryAttachmentUtil.a(graphQLStoryAttachment, legacyComposerFeedAttachmentManager.f6475h.mo194c())) {
                legacyComposerFeedAttachmentManager.m7898a(graphQLStoryAttachment.z());
                ViewGroup b = legacyComposerFeedAttachmentManager.m7899b();
                b.removeAllViews();
                b.addView(legacyComposerFeedAttachmentManager.f6475h.mo192a(graphQLStoryAttachment, b));
                legacyComposerFeedAttachmentManager.f6471d.a().setVisibility(0);
                legacyComposerFeedAttachmentManager.m7905i();
                return;
            }
            m7903g(legacyComposerFeedAttachmentManager);
        }
    }

    public static void m7903g(LegacyComposerFeedAttachmentManager legacyComposerFeedAttachmentManager) {
        legacyComposerFeedAttachmentManager.f6471d.c();
        if (legacyComposerFeedAttachmentManager.f6473f != null) {
            legacyComposerFeedAttachmentManager.f6473f.removeAllViews();
        }
        legacyComposerFeedAttachmentManager.f6475h = null;
        legacyComposerFeedAttachmentManager.f6476i = null;
        legacyComposerFeedAttachmentManager.f6468a.c();
    }

    private View m7904h() {
        if (this.f6475h == null || this.f6475h.mo201j() == null) {
            return m7900c();
        }
        return this.f6475h.mo201j();
    }

    private void m7905i() {
        if (this.f6475h != null) {
            int i = this.f6475h.mo202k() ? 0 : this.f6472e;
            ViewGroup b = m7899b();
            b.setPadding(i, b.getPaddingTop(), i, b.getPaddingBottom());
        }
    }

    private void m7898a(GraphQLNode graphQLNode) {
        Preconditions.checkNotNull(this.f6475h);
        View h = m7904h();
        boolean f = this.f6475h.mo197f();
        if (h != m7900c()) {
            m7900c().setVisibility(8);
        }
        if (f) {
            h.setVisibility(8);
            h.setOnClickListener(null);
            return;
        }
        h.setVisibility(0);
        h.setOnClickListener(new C08182(this));
        if (h != m7900c()) {
            return;
        }
        if (graphQLNode == null || graphQLNode.aZ() == null || graphQLNode.aZ().isEmpty()) {
            h.setContentDescription(this.f6469b.getString(2131234675));
            return;
        }
        h.setContentDescription(this.f6469b.getString(2131234674, new Object[]{graphQLNode.aZ().get(0)}));
    }
}

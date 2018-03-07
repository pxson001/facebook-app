package com.facebook.composer.feedattachment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.composer.event.ComposerEvent;
import com.facebook.composer.event.ComposerEventOriginator;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.Assisted;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Optional;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: granted_scopes */
public class LegacyFeedAttachmentAdapter implements ComposerFeedAttachment {
    private final TasksManager<String> f6480a;
    private final Context f6481b;
    private final int f6482c = (this.f6481b.getResources().getDimensionPixelSize(2131428032) + this.f6481b.getResources().getDimensionPixelSize(2131429655));
    public final ComposerFeedAttachmentController f6483d;
    @Nullable
    private String f6484e;
    private ViewGroup f6485f;
    private ViewGroup f6486g;
    private View f6487h;

    /* compiled from: granted_scopes */
    class C08201 extends AbstractDisposableFutureCallback<GraphQLStoryAttachment> {
        final /* synthetic */ LegacyFeedAttachmentAdapter f6477a;

        C08201(LegacyFeedAttachmentAdapter legacyFeedAttachmentAdapter) {
            this.f6477a = legacyFeedAttachmentAdapter;
        }

        protected final void m7907a(Object obj) {
            GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
            if (graphQLStoryAttachment == null) {
                m7908a(new NullPointerException("minutiae_story_attachment_null"));
            } else {
                LegacyFeedAttachmentAdapter.m7909a(this.f6477a, graphQLStoryAttachment);
            }
        }

        protected final void m7908a(Throwable th) {
            this.f6477a.f6483d.mo200i();
            Optional a = this.f6477a.f6483d.mo193a(th);
            if (a.isPresent()) {
                LegacyFeedAttachmentAdapter.m7909a(this.f6477a, (GraphQLStoryAttachment) a.get());
            } else {
                LegacyFeedAttachmentAdapter.m7915g(this.f6477a);
            }
        }
    }

    /* compiled from: granted_scopes */
    class C08212 implements OnClickListener {
        final /* synthetic */ LegacyFeedAttachmentAdapter f6478a;

        C08212(LegacyFeedAttachmentAdapter legacyFeedAttachmentAdapter) {
            this.f6478a = legacyFeedAttachmentAdapter;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -891063472);
            this.f6478a.f6483d.mo199h();
            Logger.a(2, EntryType.UI_INPUT_END, -214030633, a);
        }
    }

    /* compiled from: granted_scopes */
    /* synthetic */ class C08223 {
        static final /* synthetic */ int[] f6479a = new int[ComposerEvent.values().length];

        static {
            try {
                f6479a[ComposerEvent.ON_DATASET_CHANGE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
        }
    }

    @Inject
    public LegacyFeedAttachmentAdapter(TasksManager tasksManager, Context context, @Assisted ComposerFeedAttachmentController composerFeedAttachmentController) {
        this.f6480a = tasksManager;
        this.f6481b = context;
        this.f6483d = composerFeedAttachmentController;
    }

    public final void m7919a(ComposerEvent composerEvent, ComposerEventOriginator composerEventOriginator) {
        switch (C08223.f6479a[composerEvent.ordinal()]) {
            case 1:
                if (mo189a() && !this.f6483d.mo198g().equals(this.f6484e)) {
                    m7913e();
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final boolean mo189a() {
        return this.f6483d.mo196e();
    }

    public final void mo188a(ViewGroup viewGroup) {
        this.f6485f = (ViewGroup) LayoutInflater.from(viewGroup.getContext()).inflate(2130905032, viewGroup);
        m7913e();
    }

    public final void mo190b() {
        this.f6484e = null;
        this.f6485f = null;
        this.f6486g = null;
        this.f6487h = null;
        this.f6480a.c();
    }

    private ViewGroup m7911c() {
        if (this.f6486g == null) {
            this.f6486g = (ViewGroup) this.f6485f.findViewById(2131563411);
        }
        return this.f6486g;
    }

    private View m7912d() {
        if (this.f6487h == null) {
            this.f6487h = this.f6485f.findViewById(2131563412);
        }
        return this.f6487h;
    }

    private void m7913e() {
        this.f6484e = this.f6483d.mo198g();
        m7914f();
        this.f6480a.a("fetchAttachment", this.f6483d.mo195d(), new C08201(this));
    }

    private void m7914f() {
        m7910a(null);
        ViewGroup c = m7911c();
        c.removeAllViews();
        c.addView(this.f6483d.mo191a(this.f6481b, c));
        m7917i();
    }

    public static void m7909a(LegacyFeedAttachmentAdapter legacyFeedAttachmentAdapter, GraphQLStoryAttachment graphQLStoryAttachment) {
        if (GraphQLStoryAttachmentUtil.a(graphQLStoryAttachment, legacyFeedAttachmentAdapter.f6483d.mo194c())) {
            legacyFeedAttachmentAdapter.m7910a(graphQLStoryAttachment.z());
            ViewGroup c = legacyFeedAttachmentAdapter.m7911c();
            c.removeAllViews();
            c.addView(legacyFeedAttachmentAdapter.f6483d.mo192a(graphQLStoryAttachment, c));
            legacyFeedAttachmentAdapter.m7917i();
            return;
        }
        m7915g(legacyFeedAttachmentAdapter);
    }

    public static void m7915g(LegacyFeedAttachmentAdapter legacyFeedAttachmentAdapter) {
        legacyFeedAttachmentAdapter.f6485f.removeAllViews();
        legacyFeedAttachmentAdapter.mo190b();
    }

    private View m7916h() {
        if (this.f6483d.mo201j() == null) {
            return m7912d();
        }
        return this.f6483d.mo201j();
    }

    private void m7917i() {
        int i = this.f6483d.mo202k() ? 0 : this.f6482c;
        ViewGroup c = m7911c();
        c.setPadding(i, c.getPaddingTop(), i, c.getPaddingBottom());
    }

    private void m7910a(GraphQLNode graphQLNode) {
        View h = m7916h();
        boolean f = this.f6483d.mo197f();
        if (h != m7912d()) {
            m7912d().setVisibility(8);
        }
        if (f) {
            h.setVisibility(8);
            h.setOnClickListener(null);
            return;
        }
        h.setVisibility(0);
        h.setOnClickListener(new C08212(this));
        if (h != m7912d()) {
            return;
        }
        if (graphQLNode == null || graphQLNode.aZ() == null || graphQLNode.aZ().isEmpty()) {
            h.setContentDescription(this.f6481b.getString(2131234675));
            return;
        }
        h.setContentDescription(this.f6481b.getString(2131234674, new Object[]{graphQLNode.aZ().get(0)}));
    }
}

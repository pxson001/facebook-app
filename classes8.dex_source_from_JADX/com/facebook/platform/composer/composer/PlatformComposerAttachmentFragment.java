package com.facebook.platform.composer.composer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.common.util.FindViewUtil;
import com.facebook.graphql.model.GraphQLNode;
import com.facebook.graphql.model.GraphQLStoryAttachment;
import com.facebook.graphql.model.GraphQLStoryAttachmentUtil;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Absent;
import com.google.common.base.Optional;

/* compiled from: richdocument_async_get */
public class PlatformComposerAttachmentFragment extends FbFragment {
    public PlatformComposerAttachmentController f3994a;
    public TasksManager<String> f3995b;
    public Optional<String> f3996c = Absent.INSTANCE;
    public View f3997d;
    public FrameLayout f3998e;
    public ImageView f3999f;
    public boolean f4000g;

    public static void m3962a(Object obj, Context context) {
        ((PlatformComposerAttachmentFragment) obj).f3995b = TasksManager.b(FbInjector.get(context));
    }

    public final void m3965c(Bundle bundle) {
        super.c(bundle);
        Class cls = PlatformComposerAttachmentFragment.class;
        m3962a(this, getContext());
    }

    public final View m3963a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1606618316);
        View inflate = layoutInflater.inflate(2130906298, viewGroup, false);
        this.f3997d = FindViewUtil.b(inflate, 2131566093);
        this.f3998e = (FrameLayout) FindViewUtil.b(inflate, 2131563411);
        this.f3999f = (ImageView) FindViewUtil.b(inflate, 2131563412);
        aq(this);
        m3964b();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -1096467582, a);
        return inflate;
    }

    public final void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 817311530);
        this.f3995b.c();
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1493581725, a);
    }

    public final void m3964b() {
        if (this.f3997d != null) {
            if (this.f3994a == null) {
                aq(this);
                return;
            }
            this.f4000g = true;
            StringBuilder stringBuilder = new StringBuilder();
            PlatformComposerAttachmentController platformComposerAttachmentController = this.f3994a;
            final String stringBuilder2 = stringBuilder.append(String.valueOf(platformComposerAttachmentController.f3990g.m4014b()) + String.valueOf(platformComposerAttachmentController.f3990g.m4015c())).append(":").append(this.f3994a.getClass().getSimpleName()).toString();
            if (!this.f3996c.isPresent() || !((String) this.f3996c.get()).equals(stringBuilder2)) {
                this.f3997d.setVisibility(0);
                if (!this.f4000g) {
                    this.f3999f.setVisibility(0);
                }
                this.f3998e.setVisibility(0);
                this.f3998e.removeAllViews();
                this.f3998e.addView(this.f3994a.m3954a(getContext(), this.f3998e));
                this.f3995b.a("fetchAttachment", this.f3994a.m3957b(), new AbstractDisposableFutureCallback<GraphQLStoryAttachment>(this) {
                    final /* synthetic */ PlatformComposerAttachmentFragment f3993b;

                    protected final void m3959a(Object obj) {
                        GraphQLStoryAttachment graphQLStoryAttachment = (GraphQLStoryAttachment) obj;
                        if (graphQLStoryAttachment == null) {
                            m3960a(new NullPointerException("story_attachment_null"));
                            return;
                        }
                        this.f3993b.f3996c = Optional.of(stringBuilder2);
                        PlatformComposerAttachmentFragment.m3961a(this.f3993b, graphQLStoryAttachment, this.f3993b.f3994a);
                    }

                    protected final void m3960a(Throwable th) {
                        PlatformComposerAttachmentController platformComposerAttachmentController = this.f3993b.f3994a;
                        Optional a = this.f3993b.f3994a.m3956a(th);
                        if (a.isPresent()) {
                            PlatformComposerAttachmentFragment.m3961a(this.f3993b, (GraphQLStoryAttachment) a.get(), this.f3993b.f3994a);
                        } else {
                            PlatformComposerAttachmentFragment.aq(this.f3993b);
                        }
                    }
                });
            }
        }
    }

    public static void m3961a(PlatformComposerAttachmentFragment platformComposerAttachmentFragment, GraphQLStoryAttachment graphQLStoryAttachment, PlatformComposerAttachmentController platformComposerAttachmentController) {
        if (GraphQLStoryAttachmentUtil.a(graphQLStoryAttachment, PlatformComposerAttachmentController.f3984a)) {
            platformComposerAttachmentFragment.f3999f.setVisibility(platformComposerAttachmentFragment.f4000g ? 8 : 0);
            platformComposerAttachmentFragment.f3997d.setVisibility(0);
            platformComposerAttachmentFragment.f3998e.setVisibility(0);
            platformComposerAttachmentFragment.f3998e.removeAllViews();
            platformComposerAttachmentFragment.f3998e.addView(platformComposerAttachmentController.m3955a(graphQLStoryAttachment, platformComposerAttachmentFragment.f3998e));
            GraphQLNode z = graphQLStoryAttachment.z();
            if (z == null || z.aZ() == null || z.aZ().isEmpty()) {
                platformComposerAttachmentFragment.f3999f.setContentDescription(platformComposerAttachmentFragment.getContext().getString(2131238360));
                return;
            } else {
                platformComposerAttachmentFragment.f3999f.setContentDescription(platformComposerAttachmentFragment.getContext().getString(2131238359, new Object[]{z.aZ().get(0)}));
                return;
            }
        }
        aq(platformComposerAttachmentFragment);
    }

    public static void aq(PlatformComposerAttachmentFragment platformComposerAttachmentFragment) {
        platformComposerAttachmentFragment.f3999f.setVisibility(8);
        platformComposerAttachmentFragment.f3997d.setVisibility(8);
        platformComposerAttachmentFragment.f3998e.setVisibility(8);
        platformComposerAttachmentFragment.f3998e.removeAllViews();
        platformComposerAttachmentFragment.f3996c = Absent.INSTANCE;
        platformComposerAttachmentFragment.f3995b.c();
    }
}

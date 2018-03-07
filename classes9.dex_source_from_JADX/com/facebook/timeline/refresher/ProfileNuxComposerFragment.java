package com.facebook.timeline.refresher;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.base.fragment.FbFragment;
import com.facebook.common.locale.Locales;
import com.facebook.composer.publish.ComposerPublishServiceHelper;
import com.facebook.feed.inlinecomposer.InlineComposerFooterView;
import com.facebook.feed.inlinecomposer.model.InlineComposerFooterState;
import com.facebook.feed.inlinecomposer.model.InlineComposerModel;
import com.facebook.feed.inlinecomposer.model.InlineComposerModelBuilder;
import com.facebook.flatbuffers.helpers.FlatBufferModelHelper;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.IdBasedSingletonScopeProvider;
import com.facebook.inject.Lazy;
import com.facebook.ipc.composer.intent.graphql.FetchComposerTargetDataPrivacyScopeInterfaces.ComposerTargetDataPrivacyScopeFields;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.timeline.refresher.ProfileNuxComposerClickHandler.C00871;
import com.facebook.timeline.refresher.ProfileNuxComposerClickHandler.C00882;
import com.facebook.timeline.refresher.ProfileNuxComposerClickHandler.C00893;
import com.facebook.timeline.ui.common.InlineComposerHeaderView;
import com.facebook.user.model.User;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: updatedMessageSendErrorParams */
public class ProfileNuxComposerFragment extends FbFragment {
    @Inject
    @LoggedInUser
    public Provider<User> f930a;
    @Inject
    public Lazy<ComposerPublishServiceHelper> f931b;
    @Inject
    public ProfileNuxComposerClickHandler f932c;
    @Inject
    public Locales f933d;
    private InlineComposerHeaderView f934e;
    private InlineComposerFooterView f935f;
    private ComposerFragmentListener f936g;

    /* compiled from: updatedMessageSendErrorParams */
    public interface ComposerFragmentListener {
        void mo45a();
    }

    public static void m926a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        ProfileNuxComposerFragment profileNuxComposerFragment = (ProfileNuxComposerFragment) obj;
        Provider a = IdBasedProvider.a(fbInjector, 3595);
        Lazy a2 = IdBasedLazy.a(fbInjector, 5272);
        ProfileNuxComposerClickHandler profileNuxComposerClickHandler = new ProfileNuxComposerClickHandler(IdBasedProvider.a(fbInjector, 3595), IdBasedLazy.a(fbInjector, 2371), IdBasedSingletonScopeProvider.a(fbInjector, 849), IdBasedSingletonScopeProvider.a(fbInjector, 11389));
        Locales a3 = Locales.a(fbInjector);
        profileNuxComposerFragment.f930a = a;
        profileNuxComposerFragment.f931b = a2;
        profileNuxComposerFragment.f932c = profileNuxComposerClickHandler;
        profileNuxComposerFragment.f933d = a3;
    }

    public final View m927a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -333041984);
        View inflate = layoutInflater.inflate(2130906446, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 2009085015, a);
        return inflate;
    }

    public final void m930c(Bundle bundle) {
        super.c(bundle);
        Class cls = ProfileNuxComposerFragment.class;
        m926a((Object) this, getContext());
    }

    public final void m929a(View view, Bundle bundle) {
        int i;
        super.a(view, bundle);
        this.f934e = (InlineComposerHeaderView) e(2131566360);
        this.f935f = (InlineComposerFooterView) e(2131566361);
        User user = (User) this.f930a.get();
        Context context = view.getContext();
        InlineComposerModelBuilder inlineComposerModelBuilder = new InlineComposerModelBuilder(user.a, user.x());
        inlineComposerModelBuilder.i = context.getString(2131234528);
        InlineComposerModelBuilder inlineComposerModelBuilder2 = inlineComposerModelBuilder;
        inlineComposerModelBuilder2.f = context.getString(2131234879);
        inlineComposerModelBuilder2 = inlineComposerModelBuilder2;
        inlineComposerModelBuilder2.g = context.getString(2131235010);
        inlineComposerModelBuilder2 = inlineComposerModelBuilder2;
        inlineComposerModelBuilder2.h = context.getString(2131234881);
        inlineComposerModelBuilder2 = inlineComposerModelBuilder2;
        inlineComposerModelBuilder2.e = 2130841040;
        InlineComposerModel a = inlineComposerModelBuilder2.a();
        InlineComposerFooterState a2 = InlineComposerFooterState.a(jW_(), a, this.f933d);
        this.f934e.a(a.b);
        this.f934e.setComposerHintText(jW_().getString(2131234528));
        this.f935f.setCheckinButtonDrawable(a2.d);
        InlineComposerFooterView inlineComposerFooterView = this.f935f;
        if (a.e) {
            i = 0;
        } else {
            i = 8;
        }
        inlineComposerFooterView.setCheckinButtonVisibility(i);
        this.f935f.a(a2.b, a2.a, a2.c);
        ComposerTargetDataPrivacyScopeFields composerTargetDataPrivacyScopeFields = (ComposerTargetDataPrivacyScopeFields) FlatBufferModelHelper.a(this.s, "post_item_privacy");
        ProfileNuxComposerClickHandler profileNuxComposerClickHandler = this.f932c;
        FragmentActivity o = o();
        InlineComposerHeaderView inlineComposerHeaderView = this.f934e;
        InlineComposerFooterView inlineComposerFooterView2 = this.f935f;
        if (profileNuxComposerClickHandler.f923a == null) {
            profileNuxComposerClickHandler.f923a = new C00871(profileNuxComposerClickHandler, composerTargetDataPrivacyScopeFields, o);
        }
        inlineComposerHeaderView.setHeaderSectionOnClickListener(profileNuxComposerClickHandler.f923a);
        inlineComposerFooterView2.setStatusButtonOnClickListener(profileNuxComposerClickHandler.f923a);
        profileNuxComposerClickHandler = this.f932c;
        o = o();
        InlineComposerFooterView inlineComposerFooterView3 = this.f935f;
        if (profileNuxComposerClickHandler.f924b == null) {
            profileNuxComposerClickHandler.f924b = new C00882(profileNuxComposerClickHandler, o, composerTargetDataPrivacyScopeFields);
        }
        inlineComposerFooterView3.setPhotoButtonOnClickListener(profileNuxComposerClickHandler.f924b);
        ProfileNuxComposerClickHandler profileNuxComposerClickHandler2 = this.f932c;
        FragmentActivity o2 = o();
        inlineComposerFooterView = this.f935f;
        if (profileNuxComposerClickHandler2.f925c == null) {
            profileNuxComposerClickHandler2.f925c = new C00893(profileNuxComposerClickHandler2, o2);
        }
        inlineComposerFooterView.setCheckinButtonOnClickListener(profileNuxComposerClickHandler2.f925c);
    }

    public final void a_(Context context) {
        super.a_(context);
        this.f936g = (ComposerFragmentListener) context;
    }

    public final void m928a(int i, int i2, Intent intent) {
        super.a(i, i2, intent);
        if (i2 == -1) {
            if (i == 1756) {
                if (intent.getBooleanExtra("is_uploading_media", false)) {
                    ((ComposerPublishServiceHelper) this.f931b.get()).b(intent);
                } else {
                    ((ComposerPublishServiceHelper) this.f931b.get()).c(intent);
                }
            } else if (i == 1760 && !intent.getBooleanExtra("is_uploading_media", false)) {
                ((ComposerPublishServiceHelper) this.f931b.get()).d(intent);
            }
            this.f936g.mo45a();
        }
    }
}

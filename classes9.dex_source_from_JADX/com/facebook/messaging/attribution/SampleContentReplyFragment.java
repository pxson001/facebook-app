package com.facebook.messaging.attribution;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.inject.FbInjector;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.orca.compose.ComposeFragment.5;
import com.facebook.ui.dialogs.FbDialogFragment;
import com.facebook.ui.media.attachments.MediaResource;
import com.facebook.widget.bottomsheet.SingleItemRecyclerViewAdapter;
import com.facebook.widget.bottomsheet.SlideUpDialogView;
import com.facebook.widget.bottomsheet.SlideUpDialogView.Listener;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: other_user_app_scoped_ids */
public class SampleContentReplyFragment extends FbDialogFragment {
    @Inject
    public PlatformAttributionLogging am;
    private SingleItemRecyclerViewAdapter an;
    public SlideUpDialogView ao;
    private InlineReplyView ap;
    public MediaResource aq;
    @Nullable
    public 5 ar;

    /* compiled from: other_user_app_scoped_ids */
    class C08841 implements Listener {
        final /* synthetic */ SampleContentReplyFragment f7923a;

        C08841(SampleContentReplyFragment sampleContentReplyFragment) {
            this.f7923a = sampleContentReplyFragment;
        }

        public final void m8131a() {
            this.f7923a.b();
            this.f7923a.am.m8088c(this.f7923a.aq.x.b);
        }
    }

    /* compiled from: other_user_app_scoped_ids */
    class C08852 implements InlineReplyView.Listener {
        final /* synthetic */ SampleContentReplyFragment f7924a;

        C08852(SampleContentReplyFragment sampleContentReplyFragment) {
            this.f7924a = sampleContentReplyFragment;
        }

        public final void mo287a() {
            this.f7924a.am.m8091e(this.f7924a.aq.x.b);
            if (this.f7924a.ar != null) {
                5 5 = this.f7924a.ar;
            }
            this.f7924a.ao.a();
        }

        public final void mo288b() {
            this.f7924a.am.m8090d(this.f7924a.aq.x.b);
            if (this.f7924a.ar != null) {
                this.f7924a.ar.a(this.f7924a.aq);
            }
            this.f7924a.b();
        }
    }

    public static void m8134a(Object obj, Context context) {
        ((SampleContentReplyFragment) obj).am = PlatformAttributionLogging.m8077a(FbInjector.get(context));
    }

    public final void m8136a(Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 798245918);
        super.a(bundle);
        Class cls = SampleContentReplyFragment.class;
        m8134a((Object) this, getContext());
        this.aq = (MediaResource) this.s.getParcelable("media_resource");
        a(0, 2131625148);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 194667960, a);
    }

    public final View m8135a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -73937768);
        this.ap = new InlineReplyView(getContext());
        this.ao = new SlideUpDialogView(getContext());
        this.ao.e = 1.0f;
        this.ao.d = 1.0f;
        this.ao.setRecyclerViewBackground(new ColorDrawable(0));
        this.an = new SingleItemRecyclerViewAdapter(this.ap);
        this.ao.setAdapter(this.an);
        this.ao.o = new C08841(this);
        SlideUpDialogView slideUpDialogView = this.ao;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -108896462, a);
        return slideUpDialogView;
    }

    public final void m8137a(View view, Bundle bundle) {
        super.a(view, bundle);
        this.ap.f7831g = new C08852(this);
        this.ap.setMediaResource(this.aq);
        this.ap.m8068a();
    }
}

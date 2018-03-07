package com.facebook.checkin.socialsearch.conversion;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import javax.annotation.Nullable;

/* compiled from: design_name */
public class SocialSearchConversionAcceptFragment extends FbFragment {
    public Listener f15079a;
    private Button f15080b;
    private Button f15081c;

    /* compiled from: design_name */
    public class C20941 implements OnClickListener {
        final /* synthetic */ SocialSearchConversionAcceptFragment f15077a;

        public C20941(SocialSearchConversionAcceptFragment socialSearchConversionAcceptFragment) {
            this.f15077a = socialSearchConversionAcceptFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -485971148);
            this.f15077a.f15079a.mo752a();
            Logger.a(2, EntryType.UI_INPUT_END, 540379155, a);
        }
    }

    /* compiled from: design_name */
    public class C20952 implements OnClickListener {
        final /* synthetic */ SocialSearchConversionAcceptFragment f15078a;

        public C20952(SocialSearchConversionAcceptFragment socialSearchConversionAcceptFragment) {
            this.f15078a = socialSearchConversionAcceptFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -2083023021);
            this.f15078a.f15079a.mo753b();
            Logger.a(2, EntryType.UI_INPUT_END, -1896309182, a);
        }
    }

    /* compiled from: design_name */
    public interface Listener {
        void mo752a();

        void mo753b();
    }

    public final void a_(Context context) {
        super.a_(context);
        if (context instanceof Listener) {
            this.f15079a = (Listener) context;
            return;
        }
        throw new ClassCastException(context.toString() + " must implement SocialSearchConversionAcceptFragment.Listener");
    }

    public final View m15601a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 354612319);
        View inflate = layoutInflater.inflate(2130907156, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 557978089, a);
        return inflate;
    }

    public final void m15602a(View view, @Nullable Bundle bundle) {
        this.f15080b = (Button) e(2131567514);
        this.f15081c = (Button) e(2131567513);
        this.f15080b.setOnClickListener(new C20941(this));
        this.f15081c.setOnClickListener(new C20952(this));
    }

    public final void m15600I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1442690571);
        super.I();
        this.f15079a = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1105632811, a);
    }
}

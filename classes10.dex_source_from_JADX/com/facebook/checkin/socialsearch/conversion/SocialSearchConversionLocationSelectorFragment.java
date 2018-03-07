package com.facebook.checkin.socialsearch.conversion;

import android.content.Context;
import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.facebook.base.fragment.FbFragment;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.widget.text.BetterTextView;
import javax.annotation.Nullable;

/* compiled from: description_length */
public class SocialSearchConversionLocationSelectorFragment extends FbFragment {
    public Listener f15098a;
    public String f15099b;
    private Button f15100c;
    private Button f15101d;
    public BetterTextView f15102e;

    /* compiled from: description_length */
    public interface Listener {
        void mo754i();

        void mo755j();
    }

    /* compiled from: description_length */
    public class C20991 implements OnClickListener {
        final /* synthetic */ SocialSearchConversionLocationSelectorFragment f15096a;

        public C20991(SocialSearchConversionLocationSelectorFragment socialSearchConversionLocationSelectorFragment) {
            this.f15096a = socialSearchConversionLocationSelectorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 2083420296);
            this.f15096a.f15098a.mo754i();
            Logger.a(2, EntryType.UI_INPUT_END, 2058639344, a);
        }
    }

    /* compiled from: description_length */
    public class C21002 implements OnClickListener {
        final /* synthetic */ SocialSearchConversionLocationSelectorFragment f15097a;

        public C21002(SocialSearchConversionLocationSelectorFragment socialSearchConversionLocationSelectorFragment) {
            this.f15097a = socialSearchConversionLocationSelectorFragment;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 934574065);
            this.f15097a.f15098a.mo755j();
            Logger.a(2, EntryType.UI_INPUT_END, -444044224, a);
        }
    }

    public final void a_(Context context) {
        super.a_(context);
        if (context instanceof Listener) {
            this.f15098a = (Listener) context;
            return;
        }
        throw new ClassCastException(context.toString() + " must implement SocialSearchConversionLocationSelectorFragment.Listener");
    }

    public final void m15625c(@Nullable Bundle bundle) {
        String string;
        super.c(bundle);
        if (bundle == null) {
            string = this.s.getString("place_name");
        } else {
            string = bundle.getString("place_name");
        }
        this.f15099b = string;
    }

    public final View m15623a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 646599555);
        View inflate = layoutInflater.inflate(2130907158, viewGroup, false);
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1324628360, a);
        return inflate;
    }

    public final void m15624a(View view, @Nullable Bundle bundle) {
        this.f15100c = (Button) e(2131567520);
        this.f15101d = (Button) e(2131567519);
        this.f15102e = (BetterTextView) e(2131567517);
        this.f15100c.setOnClickListener(new C20991(this));
        this.f15101d.setOnClickListener(new C21002(this));
        String str = this.f15099b != null ? this.f15099b : "______________";
        this.f15102e.setText(Html.fromHtml(getContext().getString(2131241851, new Object[]{str})));
    }

    public final void m15626e(Bundle bundle) {
        super.e(bundle);
        bundle.putString("place_name", this.f15099b);
    }

    public final void m15622I() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, 1100044875);
        super.I();
        this.f15098a = null;
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1412032476, a);
    }
}

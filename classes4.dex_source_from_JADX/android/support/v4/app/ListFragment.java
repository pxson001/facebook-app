package android.support.v4.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.detour.HandlerDetour;

/* compiled from: external_app_data_size */
public class ListFragment extends Fragment {
    public ListAdapter f12544a;
    private final Runnable al = new C05931(this);
    private final OnItemClickListener am = new C05942(this);
    ListView f12545b;
    View f12546c;
    TextView f12547d;
    View f12548e;
    View f12549f;
    CharSequence f12550g;
    boolean f12551h;
    private final Handler f12552i = new Handler();

    /* compiled from: external_app_data_size */
    class C05931 implements Runnable {
        final /* synthetic */ ListFragment f12553a;

        C05931(ListFragment listFragment) {
            this.f12553a = listFragment;
        }

        public void run() {
            this.f12553a.f12545b.focusableViewAvailable(this.f12553a.f12545b);
        }
    }

    /* compiled from: external_app_data_size */
    class C05942 implements OnItemClickListener {
        final /* synthetic */ ListFragment f12554a;

        C05942(ListFragment listFragment) {
            this.f12554a = listFragment;
        }

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            this.f12554a.mo909a(view, i);
        }
    }

    public View mo907a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -180638148);
        Context context = getContext();
        View frameLayout = new FrameLayout(context);
        View linearLayout = new LinearLayout(context);
        linearLayout.setId(16711682);
        linearLayout.setOrientation(1);
        linearLayout.setVisibility(8);
        linearLayout.setGravity(17);
        linearLayout.addView(new ProgressBar(context, null, 16842874), new LayoutParams(-2, -2));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        linearLayout = new FrameLayout(context);
        linearLayout.setId(16711683);
        View textView = new TextView(getContext());
        textView.setId(16711681);
        textView.setGravity(17);
        linearLayout.addView(textView, new LayoutParams(-1, -1));
        textView = new ListView(getContext());
        textView.setId(16908298);
        textView.setDrawSelectorOnTop(false);
        linearLayout.addView(textView, new LayoutParams(-1, -1));
        frameLayout.addView(linearLayout, new LayoutParams(-1, -1));
        frameLayout.setLayoutParams(new LayoutParams(-1, -1));
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, 1971848927, a);
        return frameLayout;
    }

    public void m13321a(View view, Bundle bundle) {
        super.a(view, bundle);
        mo911c();
    }

    public void mY_() {
        int a = Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_START, -1448722178);
        HandlerDetour.a(this.f12552i, this.al);
        this.f12545b = null;
        this.f12551h = false;
        this.f12549f = null;
        this.f12548e = null;
        this.f12546c = null;
        this.f12547d = null;
        super.mY_();
        Logger.a(2, EntryType.LIFECYCLE_FRAGMENT_END, -460919217, a);
    }

    public void mo909a(View view, int i) {
    }

    public final void m13322a(ListAdapter listAdapter) {
        boolean z = false;
        boolean z2 = this.f12544a != null;
        this.f12544a = listAdapter;
        if (this.f12545b != null) {
            this.f12545b.setAdapter(listAdapter);
            if (!this.f12551h && !z2) {
                if (this.T.getWindowToken() != null) {
                    z = true;
                }
                m13316a(true, z);
            }
        }
    }

    public final ListView m13319a() {
        mo911c();
        return this.f12545b;
    }

    private void m13316a(boolean z, boolean z2) {
        mo911c();
        if (this.f12548e == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        } else if (this.f12551h != z) {
            this.f12551h = z;
            if (z) {
                if (z2) {
                    this.f12548e.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
                    this.f12549f.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                } else {
                    this.f12548e.clearAnimation();
                    this.f12549f.clearAnimation();
                }
                this.f12548e.setVisibility(8);
                this.f12549f.setVisibility(0);
                return;
            }
            if (z2) {
                this.f12548e.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432576));
                this.f12549f.startAnimation(AnimationUtils.loadAnimation(getContext(), 17432577));
            } else {
                this.f12548e.clearAnimation();
                this.f12549f.clearAnimation();
            }
            this.f12548e.setVisibility(0);
            this.f12549f.setVisibility(8);
        }
    }

    private void mo911c() {
        if (this.f12545b == null) {
            View view = this.T;
            if (view == null) {
                throw new IllegalStateException("Content view not yet created");
            }
            if (view instanceof ListView) {
                this.f12545b = (ListView) view;
            } else {
                this.f12547d = (TextView) view.findViewById(16711681);
                if (this.f12547d == null) {
                    this.f12546c = view.findViewById(16908292);
                } else {
                    this.f12547d.setVisibility(8);
                }
                this.f12548e = view.findViewById(16711682);
                this.f12549f = view.findViewById(16711683);
                view = view.findViewById(16908298);
                if (view instanceof ListView) {
                    this.f12545b = (ListView) view;
                    if (this.f12546c != null) {
                        this.f12545b.setEmptyView(this.f12546c);
                    } else if (this.f12550g != null) {
                        this.f12547d.setText(this.f12550g);
                        this.f12545b.setEmptyView(this.f12547d);
                    }
                } else if (view == null) {
                    throw new RuntimeException("Your content must have a ListView whose id attribute is 'android.R.id.list'");
                } else {
                    throw new RuntimeException("Content has view with id attribute 'android.R.id.list' that is not a ListView class");
                }
            }
            this.f12551h = true;
            this.f12545b.setOnItemClickListener(this.am);
            if (this.f12544a != null) {
                ListAdapter listAdapter = this.f12544a;
                this.f12544a = null;
                m13322a(listAdapter);
            } else if (this.f12548e != null) {
                m13316a(false, false);
            }
            HandlerDetour.a(this.f12552i, this.al, 1341550199);
        }
    }
}

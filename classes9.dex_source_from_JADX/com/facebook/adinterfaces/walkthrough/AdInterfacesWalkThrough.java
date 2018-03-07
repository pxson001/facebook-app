package com.facebook.adinterfaces.walkthrough;

import android.graphics.Rect;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.facebook.adinterfaces.logging.BoostedComponentLogger;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil;
import com.facebook.adinterfaces.util.AdInterfacesUiUtil.ScrollEndedCallback;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.tools.dextr.runtime.LogUtils;
import java.util.List;
import javax.inject.Inject;

/* compiled from: Unexpected throwable decrypting reply token */
public class AdInterfacesWalkThrough {
    public ImageView f23374a;
    public int f23375b;
    public int f23376c;
    public ViewGroup f23377d;
    private Rect f23378e;
    public Rect f23379f;
    public Rect f23380g;
    public HoleView f23381h;
    public TextView f23382i;
    public TextView f23383j;
    public List<Pair<Integer, Integer>> f23384k;
    public int f23385l;
    private View f23386m;
    public TextView f23387n;
    public String f23388o;
    @Inject
    public BoostedComponentLogger f23389p;

    /* compiled from: Unexpected throwable decrypting reply token */
    public class C27871 implements Runnable {
        final /* synthetic */ AdInterfacesWalkThrough f23371a;

        /* compiled from: Unexpected throwable decrypting reply token */
        class C27851 implements OnClickListener {
            final /* synthetic */ C27871 f23369a;

            C27851(C27871 c27871) {
                this.f23369a = c27871;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -509377562);
                AdInterfacesWalkThrough adInterfacesWalkThrough = this.f23369a.f23371a;
                adInterfacesWalkThrough.f23385l++;
                if (this.f23369a.f23371a.f23385l == this.f23369a.f23371a.f23384k.size()) {
                    this.f23369a.f23371a.f23389p.m22770b(this.f23369a.f23371a.f23388o);
                    this.f23369a.f23371a.f23389p.m22774d(this.f23369a.f23371a.f23388o);
                    this.f23369a.f23371a.f23381h.m25332a();
                    this.f23369a.f23371a.f23377d.removeView(this.f23369a.f23371a.f23377d.findViewById(2131568503));
                    this.f23369a.f23371a.f23377d.getRootView().findViewById(2131559287).setVisibility(0);
                    Logger.a(2, EntryType.UI_INPUT_END, -1725602387, a);
                    return;
                }
                this.f23369a.f23371a.f23383j.setText(2131234119);
                AdInterfacesWalkThrough.m25325a(this.f23369a.f23371a, this.f23369a.f23371a.f23382i);
                if (this.f23369a.f23371a.f23385l == this.f23369a.f23371a.f23384k.size() - 1) {
                    this.f23369a.f23371a.f23382i.setText(2131234120);
                }
                LogUtils.a(-1823313085, a);
            }
        }

        /* compiled from: Unexpected throwable decrypting reply token */
        class C27862 implements OnClickListener {
            final /* synthetic */ C27871 f23370a;

            C27862(C27871 c27871) {
                this.f23370a = c27871;
            }

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, -1110133045);
                if (this.f23370a.f23371a.f23385l == 0) {
                    Logger.a(2, EntryType.UI_INPUT_END, -1806095810, a);
                    return;
                }
                AdInterfacesWalkThrough adInterfacesWalkThrough = this.f23370a.f23371a;
                adInterfacesWalkThrough.f23385l--;
                if (this.f23370a.f23371a.f23385l == 0) {
                    this.f23370a.f23371a.f23383j.setText(null);
                }
                this.f23370a.f23371a.f23382i.setText(2131234118);
                AdInterfacesWalkThrough.m25325a(this.f23370a.f23371a, this.f23370a.f23371a.f23383j);
                LogUtils.a(-128147856, a);
            }
        }

        public C27871(AdInterfacesWalkThrough adInterfacesWalkThrough) {
            this.f23371a = adInterfacesWalkThrough;
        }

        public void run() {
            this.f23371a.f23382i = (TextView) this.f23371a.f23377d.findViewById(2131568508);
            this.f23371a.f23383j = (TextView) this.f23371a.f23377d.findViewById(2131568507);
            this.f23371a.f23381h = (HoleView) this.f23371a.f23377d.findViewById(2131568504);
            this.f23371a.f23387n = (TextView) this.f23371a.f23377d.findViewById(2131568505);
            this.f23371a.f23374a = (ImageView) this.f23371a.f23377d.findViewById(2131568506);
            this.f23371a.f23375b = this.f23371a.f23374a.getHeight();
            this.f23371a.f23376c = this.f23371a.f23374a.getWidth();
            this.f23371a.f23382i.setOnClickListener(new C27851(this));
            this.f23371a.f23383j.setOnClickListener(new C27862(this));
            this.f23371a.f23379f = new Rect();
            this.f23371a.f23380g = new Rect();
            this.f23371a.f23382i.getGlobalVisibleRect(this.f23371a.f23379f);
            this.f23371a.f23383j.getGlobalVisibleRect(this.f23371a.f23380g);
            AdInterfacesWalkThrough.m25325a(this.f23371a, this.f23371a.f23382i);
        }
    }

    @Inject
    public AdInterfacesWalkThrough(BoostedComponentLogger boostedComponentLogger) {
        this.f23389p = boostedComponentLogger;
    }

    public final void m25326a(ViewGroup viewGroup, View view, List<Pair<Integer, Integer>> list, String str) {
        if (viewGroup == null || view == null || list == null || list.isEmpty()) {
            throw new IllegalArgumentException("One of the walkthrough parameters is null");
        }
        this.f23377d = viewGroup;
        this.f23378e = new Rect();
        this.f23377d.getGlobalVisibleRect(this.f23378e);
        this.f23386m = view;
        this.f23384k = list;
        this.f23385l = 0;
        this.f23388o = str;
        this.f23377d.getRootView().findViewById(2131559287).setVisibility(4);
        LayoutInflater.from(this.f23377d.getContext()).inflate(2130907762, this.f23377d);
        this.f23389p.m22768a(this.f23388o);
        this.f23377d.findViewById(2131568503).setTag(this.f23388o);
        this.f23377d.post(new C27871(this));
    }

    private int m25323a(Rect rect) {
        int centerX = rect.centerX() + rect.left;
        return rect.bottom < this.f23377d.getHeight() / 2 ? centerX < this.f23377d.getWidth() / 2 ? 1 : 2 : centerX > this.f23377d.getWidth() / 2 ? 3 : 4;
    }

    private void m25324a(int i) {
        switch (i) {
            case 1:
                this.f23374a.setScaleX(1.0f);
                this.f23374a.setScaleY(-1.0f);
                return;
            case 2:
                this.f23374a.setScaleX(-1.0f);
                this.f23374a.setScaleY(-1.0f);
                return;
            case 3:
                this.f23374a.setScaleX(-1.0f);
                this.f23374a.setScaleY(1.0f);
                return;
            case 4:
                this.f23374a.setScaleX(1.0f);
                this.f23374a.setScaleY(1.0f);
                return;
            default:
                return;
        }
    }

    public static void m25325a(AdInterfacesWalkThrough adInterfacesWalkThrough, final View view) {
        View findViewById;
        try {
            findViewById = adInterfacesWalkThrough.f23386m.findViewById(((Integer) ((Pair) adInterfacesWalkThrough.f23384k.get(adInterfacesWalkThrough.f23385l)).first).intValue());
        } catch (Exception e) {
            findViewById = null;
        }
        if (findViewById == null || findViewById.getVisibility() != 0) {
            view.callOnClick();
            return;
        }
        Rect rect = new Rect();
        if (!findViewById.getGlobalVisibleRect(rect) || rect.bottom > adInterfacesWalkThrough.f23378e.bottom || rect.top < adInterfacesWalkThrough.f23378e.top || rect.bottom > adInterfacesWalkThrough.f23379f.top || rect.bottom > adInterfacesWalkThrough.f23380g.top) {
            AdInterfacesUiUtil.m25235a(findViewById, new ScrollEndedCallback(adInterfacesWalkThrough) {
                final /* synthetic */ AdInterfacesWalkThrough f23373b;

                public final void mo1007a() {
                    AdInterfacesWalkThrough.m25325a(this.f23373b, view);
                }
            });
            return;
        }
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        rect.top -= adInterfacesWalkThrough.f23378e.top;
        rect.bottom -= adInterfacesWalkThrough.f23378e.top;
        adInterfacesWalkThrough.f23381h.m25333a(rect);
        adInterfacesWalkThrough.f23387n.setText(((Integer) ((Pair) adInterfacesWalkThrough.f23384k.get(adInterfacesWalkThrough.f23385l)).second).intValue());
        int a = adInterfacesWalkThrough.m25323a(rect);
        adInterfacesWalkThrough.m25324a(a);
        LayoutParams layoutParams = (LayoutParams) adInterfacesWalkThrough.f23387n.getLayoutParams();
        switch (a) {
            case 1:
                layoutParams.setMargins(adInterfacesWalkThrough.f23387n.getLeft(), adInterfacesWalkThrough.f23387n.getTop(), 0, 0);
                layoutParams.gravity = 51;
                adInterfacesWalkThrough.f23387n.setLayoutParams(layoutParams);
                a = (rect.right + rect.left) / 2;
                i = rect.bottom + adInterfacesWalkThrough.f23375b;
                i2 = a;
                i3 = rect.bottom;
                i4 = a;
                a = 0;
                i5 = i;
                i = 0;
                break;
            case 2:
                layoutParams.setMargins(adInterfacesWalkThrough.f23387n.getLeft(), adInterfacesWalkThrough.f23387n.getTop(), 0, 0);
                layoutParams.gravity = 51;
                adInterfacesWalkThrough.f23387n.setLayoutParams(layoutParams);
                i2 = (findViewById.getLeft() + (findViewById.getWidth() / 2)) - adInterfacesWalkThrough.f23376c;
                i5 = rect.bottom;
                a = adInterfacesWalkThrough.f23375b + rect.bottom;
                i = (adInterfacesWalkThrough.f23377d.getWidth() - (findViewById.getRight() / 2)) - (findViewById.getLeft() / 2);
                i3 = i5;
                i4 = i2;
                i2 = 0;
                i5 = a;
                a = 0;
                break;
            case 3:
                layoutParams.setMargins(0, 0, adInterfacesWalkThrough.f23387n.getRight(), adInterfacesWalkThrough.f23377d.getHeight() - adInterfacesWalkThrough.f23387n.getBottom());
                layoutParams.gravity = 85;
                adInterfacesWalkThrough.f23387n.setLayoutParams(layoutParams);
                i2 = ((findViewById.getRight() / 2) + (findViewById.getLeft() / 2)) - adInterfacesWalkThrough.f23376c;
                i = (adInterfacesWalkThrough.f23377d.getWidth() - (findViewById.getRight() / 2)) - (findViewById.getLeft() / 2);
                a = (adInterfacesWalkThrough.f23377d.getHeight() - rect.top) + adInterfacesWalkThrough.f23375b;
                i3 = rect.top - adInterfacesWalkThrough.f23375b;
                i4 = i2;
                i5 = 0;
                i2 = 0;
                break;
            case 4:
                layoutParams.setMargins(adInterfacesWalkThrough.f23387n.getLeft(), 0, 0, adInterfacesWalkThrough.f23377d.getHeight() - adInterfacesWalkThrough.f23387n.getBottom());
                layoutParams.gravity = 83;
                adInterfacesWalkThrough.f23387n.setLayoutParams(layoutParams);
                i2 = (findViewById.getRight() / 2) + (findViewById.getLeft() / 2);
                a = (findViewById.getLeft() / 2) + (findViewById.getRight() / 2);
                i = (adInterfacesWalkThrough.f23377d.getHeight() - rect.top) + adInterfacesWalkThrough.f23375b;
                i3 = rect.top - adInterfacesWalkThrough.f23375b;
                i4 = i2;
                i5 = 0;
                i2 = a;
                a = i;
                i = 0;
                break;
            default:
                i = 0;
                a = 0;
                i5 = 0;
                i2 = 0;
                i3 = 0;
                i4 = 0;
                break;
        }
        AnimatorUtils.m25327a(adInterfacesWalkThrough.f23374a, new Rect(i4, i3, 0, 0));
        AnimatorUtils.m25327a(adInterfacesWalkThrough.f23387n, new Rect(i2, i5, i, a));
    }
}

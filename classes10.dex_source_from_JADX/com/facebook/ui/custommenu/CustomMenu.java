package com.facebook.ui.custommenu;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.facebook.analytics.AnalyticsLoggerMethodAutoProvider;
import com.facebook.analytics.InteractionLogger;
import com.facebook.analytics.logger.AnalyticsLogger;
import com.facebook.analytics.util.LoggerUtils;
import com.facebook.inject.FbInjector;
import com.facebook.katana.activity.faceweb.FacewebFragment;
import com.facebook.katana.ui.CustomMenuController;
import com.facebook.katana.util.logging.FB4A_AnalyticEntities.UIElements;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.menu.ExportMenuToFbHostActivity;
import com.facebook.ui.toaster.Toaster;
import java.util.ArrayList;

/* compiled from: extra_event_model */
public abstract class CustomMenu {
    protected final CustomMenuController f12897a;
    protected final AnalyticsLogger f12898b;
    protected final InteractionLogger f12899c;
    private ArrayList<CustomMenuItem> f12900d = new ArrayList();
    public Context f12901e = null;
    private LayoutInflater f12902f = null;
    private PopupWindow f12903g = null;
    public boolean f12904h = false;
    public boolean f12905i = false;
    private int f12906j = 0;
    private View f12907k;
    private View f12908l;

    /* compiled from: extra_event_model */
    class C18031 implements OnTouchListener {
        final /* synthetic */ CustomMenu f12894a;

        C18031(CustomMenu customMenu) {
            this.f12894a = customMenu;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            this.f12894a.m12897d();
            return true;
        }
    }

    protected abstract String m12893a();

    protected abstract void m12895a(CustomMenuItem customMenuItem);

    public final synchronized void m12896a(ArrayList<CustomMenuItem> arrayList) {
        if (!this.f12904h) {
            this.f12900d = arrayList;
        }
    }

    public CustomMenu(Context context, LayoutInflater layoutInflater) {
        this.f12901e = context;
        this.f12902f = layoutInflater;
        FbInjector fbInjector = FbInjector.get(context);
        this.f12898b = AnalyticsLoggerMethodAutoProvider.a(fbInjector);
        this.f12899c = InteractionLogger.a(fbInjector);
        this.f12897a = CustomMenuController.a(fbInjector);
    }

    public final synchronized void m12894a(View view, boolean z, boolean z2) {
        m12892e();
        this.f12904h = true;
        this.f12905i = z;
        int size = this.f12900d.size();
        if (size > 0 && this.f12903g == null) {
            Object obj;
            int i;
            Display defaultDisplay = ((WindowManager) this.f12901e.getSystemService("window")).getDefaultDisplay();
            if (defaultDisplay.getWidth() > defaultDisplay.getHeight()) {
                obj = 1;
            } else {
                obj = null;
            }
            if (this.f12908l == null) {
                this.f12908l = new View(this.f12901e);
                this.f12908l.setBackgroundColor(this.f12901e.getResources().getColor(17170445));
                this.f12908l.setOnTouchListener(new C18031(this));
                ((ViewGroup) view).addView(this.f12908l, new LayoutParams(-1, -1));
            }
            this.f12908l.bringToFront();
            this.f12907k = this.f12902f.inflate(2130905218, null);
            this.f12903g = new PopupWindow(this.f12907k, -1, -2, false);
            if (z2) {
                this.f12903g.setAnimationStyle(16973910);
            }
            this.f12903g.setWidth(defaultDisplay.getWidth());
            this.f12903g.showAtLocation(view, 80, 0, 0);
            int i2 = obj != null ? 6 : 3;
            int i3 = obj != null ? 1 : 2;
            this.f12906j = (size % i2 == 0 ? 0 : 1) + (size / i2);
            if (z) {
                i = this.f12906j;
            } else {
                i = i3;
            }
            TableLayout tableLayout = (TableLayout) this.f12907k.findViewById(2131563808);
            tableLayout.removeAllViews();
            int i4 = 0;
            while (i4 < i) {
                View tableRow = new TableRow(this.f12901e);
                tableRow.setLayoutParams(new LayoutParams(-1, -2));
                int i5 = 0;
                while (i5 < i2 && (i4 * i2) + i5 < size) {
                    CustomMenuItem customMenuItem;
                    if (i4 != i - 1 || i5 != i2 - 1 || size <= i * i2 || z) {
                        customMenuItem = (CustomMenuItem) this.f12900d.get((i4 * i2) + i5);
                    } else {
                        CustomMenuItem customMenuItem2 = new CustomMenuItem();
                        customMenuItem2.m12900a(this.f12901e.getResources().getString(2131236892));
                        customMenuItem2.m12902b(1006);
                        customMenuItem2.m12899a(2130841201);
                        customMenuItem = customMenuItem2;
                    }
                    View inflate = this.f12902f.inflate(2130905219, null);
                    TextView textView = (TextView) inflate.findViewById(2131563810);
                    textView.setText(customMenuItem.m12898a());
                    ImageView imageView = (ImageView) inflate.findViewById(2131563809);
                    imageView.setImageResource(customMenuItem.m12901b());
                    if (customMenuItem.m12903d()) {
                        inflate.setOnClickListener(new OnClickListener(this) {
                            final /* synthetic */ CustomMenu f12896b;

                            public void onClick(View view) {
                                int a = Logger.a(2, EntryType.UI_INPUT_START, -2084874522);
                                this.f12896b.m12895a(customMenuItem);
                                this.f12896b.f12897a.a(customMenuItem);
                                if (this.f12896b.f12901e instanceof FacewebFragment) {
                                    FacewebFragment facewebFragment = (FacewebFragment) this.f12896b.f12901e;
                                    CustomMenuItem customMenuItem = customMenuItem;
                                    switch (customMenuItem.f12911c) {
                                        case 100:
                                            facewebFragment.aK.a(UIElements.p, null);
                                            facewebFragment.at.m1374b();
                                            break;
                                        case 101:
                                            facewebFragment.aK.a(UIElements.q, null);
                                            Toaster.a(facewebFragment.getContext(), "Faceweb href: " + facewebFragment.aE);
                                            facewebFragment.ar();
                                            new StringBuilder("Faceweb href: ").append(facewebFragment.aE);
                                            break;
                                        case 2100:
                                            facewebFragment.aK.a(UIElements.r, null);
                                            if (!(facewebFragment.ay == null || facewebFragment.ay.f775c == null)) {
                                                facewebFragment.an.a(facewebFragment.ay.f775c, null);
                                                break;
                                            }
                                    }
                                    if (facewebFragment.aS != null && facewebFragment.aS.length > 0) {
                                        for (int i = 0; i < facewebFragment.aS.length; i++) {
                                            if (customMenuItem.f12911c == i + 2000) {
                                                facewebFragment.an.a(facewebFragment.aS[i].optString("callback"), null);
                                            }
                                        }
                                    }
                                }
                                if (this.f12896b.f12901e instanceof ExportMenuToFbHostActivity) {
                                    ((ExportMenuToFbHostActivity) this.f12896b.f12901e).B_(customMenuItem.f12911c);
                                }
                                if (customMenuItem.f12911c != 1006) {
                                    this.f12896b.m12897d();
                                }
                                Logger.a(2, EntryType.UI_INPUT_END, -174908862, a);
                            }
                        });
                    } else {
                        imageView.setAlpha(75);
                        textView.setTextColor(this.f12901e.getResources().getColor(2131363326));
                        inflate.setClickable(false);
                    }
                    tableRow.addView(inflate);
                    i5++;
                }
                tableLayout.addView(tableRow);
                i4++;
            }
            LoggerUtils.a(this.f12901e).a(m12893a(), false);
        }
    }

    public final synchronized void m12897d() {
        this.f12904h = false;
        this.f12905i = false;
        if (this.f12903g != null) {
            this.f12903g.dismiss();
            this.f12903g = null;
            LoggerUtils.a(this.f12901e).c(m12893a());
        }
        if (this.f12908l != null) {
            ((ViewGroup) this.f12908l.getParent()).removeView(this.f12908l);
            this.f12908l = null;
        }
    }

    private void m12892e() {
        this.f12897a.nc_();
    }
}

package com.facebook.backstage.consumption;

import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import com.facebook.backstage.consumption.BackstageFragment.C04323;
import com.facebook.backstage.consumption.BackstageNavigatorApi.NavigationState;
import com.facebook.backstage.data.BackstageProfile;
import com.facebook.backstage.ui.LazyView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;

/* compiled from: rtc_video_copresence_nux */
public class MainListActionPanelController extends ViewHolder {
    public final BackstageImportButton f4610l;
    public final C04323 f4611m;
    private final LazyView<BackstagePanelImageView> f4612n;

    /* compiled from: rtc_video_copresence_nux */
    class C04512 implements OnClickListener {
        final /* synthetic */ MainListActionPanelController f4606a;

        C04512(MainListActionPanelController mainListActionPanelController) {
            this.f4606a = mainListActionPanelController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 1409807138);
            this.f4606a.f4611m.f4489a.au.m4492a(NavigationState.MAIN_LIST, NavigationState.TEXT_ONLY);
            Logger.a(2, EntryType.UI_INPUT_END, 1848357315, a);
        }
    }

    /* compiled from: rtc_video_copresence_nux */
    class C04523 implements OnClickListener {
        final /* synthetic */ MainListActionPanelController f4607a;

        C04523(MainListActionPanelController mainListActionPanelController) {
            this.f4607a = mainListActionPanelController;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, 380128864);
            this.f4607a.f4611m.f4489a.au.m4492a(NavigationState.MAIN_LIST, NavigationState.CAMERA);
            Logger.a(2, EntryType.UI_INPUT_END, -1749176356, a);
        }
    }

    public MainListActionPanelController(final View view, C04323 c04323) {
        super(view);
        this.f4611m = c04323;
        GlyphView glyphView = (GlyphView) view.findViewById(2131559861);
        this.f4610l = (BackstageImportButton) view.findViewById(2131559860);
        this.f4610l.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MainListActionPanelController f4605b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 204016908);
                C04323 c04323 = this.f4605b.f4611m;
                view.findViewById(2131559860);
                c04323.f4489a.au.m4492a(NavigationState.MAIN_LIST, NavigationState.IMPORT);
                Logger.a(2, EntryType.UI_INPUT_END, 1417568818, a);
            }
        });
        GlyphView glyphView2 = (GlyphView) view.findViewById(2131559862);
        glyphView2.setOnClickListener(new C04512(this));
        this.f4612n = new LazyView((ViewStub) view.findViewById(2131559863));
        glyphView.setGlyphColor(view.getContext().getResources().getColor(2131361859));
        glyphView2.setGlyphColor(view.getContext().getResources().getColor(2131361859));
        glyphView.setOnClickListener(new C04523(this));
    }

    public final void m4533a(final BackstageProfile backstageProfile) {
        if (backstageProfile == null || backstageProfile.m4897b() == null) {
            ((BackstagePanelImageView) this.f4612n.m5715a()).setVisibility(8);
            ((BackstagePanelImageView) this.f4612n.m5715a()).setOnClickListener(null);
            return;
        }
        ((BackstagePanelImageView) this.f4612n.m5715a()).m4505a(false);
        ((BackstagePanelImageView) this.f4612n.m5715a()).setImage(backstageProfile.m4897b());
        ((BackstagePanelImageView) this.f4612n.m5715a()).setVisibility(0);
        ((BackstagePanelImageView) this.f4612n.m5715a()).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ MainListActionPanelController f4609b;

            public void onClick(View view) {
                int a = Logger.a(2, EntryType.UI_INPUT_START, 122580542);
                this.f4609b.f4611m.m4463a(backstageProfile);
                Logger.a(2, EntryType.UI_INPUT_END, -787585972, a);
            }
        });
    }
}

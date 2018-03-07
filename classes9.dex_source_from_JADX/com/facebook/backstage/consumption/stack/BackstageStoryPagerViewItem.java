package com.facebook.backstage.consumption.stack;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewStub;
import com.facebook.backstage.camera.CameraFlowView.CameraInteractionListener;
import com.facebook.backstage.camera.CameraHolder;
import com.facebook.backstage.consumption.camera.CameraFlowLauncher;
import com.facebook.backstage.consumption.camera.CameraOptions;
import com.facebook.backstage.consumption.reply.BackstagePopupReplyWindowAdapter;
import com.facebook.backstage.consumption.stack.BackstageStoryModeController.C05261;
import com.facebook.backstage.consumption.swipe.BackstageStoryCommonController;
import com.facebook.backstage.consumption.swipe.BaseBackstageStoryPagerViewItem;
import com.facebook.backstage.data.BackstageProfile.BackstageStory;
import com.facebook.backstage.data.MediaItem;
import com.facebook.backstage.ui.LazyView;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.fbui.popover.PopoverListViewWindow;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.facebook.tools.dextr.runtime.LogUtils;

/* compiled from: retr_txt */
public class BackstageStoryPagerViewItem extends BaseBackstageStoryPagerViewItem {
    private final BackstagePopupReplyWindowAdapter f5046a;
    public final PopoverListViewWindow f5047b;
    public final BackstageStoryCommonController<BackstageStory> f5048c;
    public final CameraHolder f5049d;
    public final FbTextView f5050e;
    private final C05261 f5051f;
    public final CameraFlowLauncher f5052g;

    public BackstageStoryPagerViewItem(Context context, FbDraweeControllerBuilder fbDraweeControllerBuilder, FbTextView fbTextView, CameraHolder cameraHolder, C05261 c05261, CameraFlowLauncher cameraFlowLauncher) {
        super(context);
        View inflate = LayoutInflater.from(getContext()).inflate(2130903374, this);
        this.f5048c = new BackstageStoryCommonController(getContext(), fbDraweeControllerBuilder, new LazyView((ViewStub) inflate.findViewById(2131559859)), new LazyView((ViewStub) inflate.findViewById(2131559880)), new LazyView((ViewStub) inflate.findViewById(2131559881)));
        this.f5049d = cameraHolder;
        this.f5052g = cameraFlowLauncher;
        this.f5050e = fbTextView;
        this.f5051f = c05261;
        this.f5046a = new BackstagePopupReplyWindowAdapter(m4852b(true), m4852b(false));
        this.f5047b = new PopoverListViewWindow(getContext());
        this.f5047b.e = true;
        this.f5047b.e(true);
        this.f5047b.c(false);
        this.f5047b.m = this.f5046a;
    }

    protected BackstageStoryCommonController getController() {
        return this.f5048c;
    }

    public final void mo179a(ViewGroup viewGroup, BackstageStory backstageStory, int i, float f, float f2, float f3, boolean z) {
        super.mo179a(viewGroup, backstageStory, i, f, f2, f3, z);
        if (f == 0.0f && z) {
            if (backstageStory.f5106d) {
                m4853k();
            } else {
                this.f5050e.setText(2131239931);
            }
        } else if (f != 0.0f && this.f5049d.m4321b()) {
            this.f5049d.m4322c().mo160b(false);
        }
    }

    public final void mo180f() {
        if (!((BackstageStory) this.f5048c.f5083f).f5106d) {
            if (this.f5049d.m4322c().getVisibility() == 0) {
                getController().m4877b();
            } else {
                this.f5047b.a(this.f5050e);
            }
        }
    }

    private OnClickListener m4852b(final boolean z) {
        return new OnClickListener(this) {
            final /* synthetic */ BackstageStoryPagerViewItem f5045b;

            /* compiled from: retr_txt */
            class C05371 implements CameraInteractionListener {
                final /* synthetic */ C05381 f5043a;

                C05371(C05381 c05381) {
                    this.f5043a = c05381;
                }

                public final void mo157a() {
                    this.f5043a.f5045b.m4858h();
                    if (this.f5043a.f5045b.f5049d.m4321b()) {
                        this.f5043a.f5045b.f5049d.m4322c().m4314b((CameraInteractionListener) this);
                    }
                }

                public final void mo158b() {
                    if (this.f5043a.f5045b.f5049d.m4321b()) {
                        this.f5043a.f5045b.f5049d.m4322c().m4314b((CameraInteractionListener) this);
                    }
                }
            }

            public void onClick(View view) {
                CameraOptions a;
                int a2 = Logger.a(2, EntryType.UI_INPUT_START, 1870565033);
                CameraFlowLauncher cameraFlowLauncher = this.f5045b.f5052g;
                CameraHolder cameraHolder = this.f5045b.f5049d;
                if (z) {
                    a = CameraOptions.m4603a(((BackstageStory) this.f5045b.f5048c.f5083f).f5104b, null);
                } else {
                    a = CameraOptions.m4605b(((BackstageStory) this.f5045b.f5048c.f5083f).f5104b, null);
                }
                cameraFlowLauncher.m4601a(cameraHolder, a, new C05371(this));
                this.f5045b.f5047b.l();
                this.f5045b.getController().m4878b(true);
                LogUtils.a(-1712907991, a2);
            }
        };
    }

    public final void m4858h() {
        ((BackstageStory) this.f5048c.f5083f).f5106d = true;
        m4853k();
        C05261 c05261 = this.f5051f;
        c05261.f4990a.f5028o.m4544a(c05261.f4990a.f5034u.f5112a, ((BackstageStory) this.f5048c.f5083f).f5104b, null);
        c05261.f4990a.f5016c.m4830a((MediaItem) c05261.f4990a.f5022i.f5097f.f18378C);
    }

    public final boolean mo181g() {
        if (this.f5049d.m4321b() && this.f5049d.m4322c().m4312a(true)) {
            return true;
        }
        this.f5050e.setCompoundDrawables(null, null, null, null);
        return false;
    }

    private void m4853k() {
        this.f5050e.setText(2131239932);
    }
}

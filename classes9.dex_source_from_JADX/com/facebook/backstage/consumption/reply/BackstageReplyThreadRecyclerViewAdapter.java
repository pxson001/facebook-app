package com.facebook.backstage.consumption.reply;

import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger;
import com.facebook.backstage.analytics.BackstageAnalyticsLogger.Event;
import com.facebook.backstage.camera.CameraFlowView.CameraInteractionListener;
import com.facebook.backstage.camera.CameraHolder;
import com.facebook.backstage.consumption.BackstageFragment;
import com.facebook.backstage.consumption.ScreenUtil;
import com.facebook.backstage.consumption.camera.CameraFlowLauncher;
import com.facebook.backstage.consumption.camera.CameraOptions;
import com.facebook.backstage.data.BackstageProfile.Reply;
import com.facebook.backstage.data.ReplyThread;
import com.facebook.backstage.ui.BackstageRichVideoView;
import com.facebook.backstage.util.LocaleTimeUtil;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.locale.Locales;
import com.facebook.drawee.fbpipeline.FbDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.fbui.popover.PopoverListViewWindow;
import com.facebook.imagepipeline.request.ImageRequest.ImageType;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.resources.ui.FbTextView;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import java.text.DateFormat;
import javax.inject.Inject;

/* compiled from: ride_providers */
public class BackstageReplyThreadRecyclerViewAdapter extends Adapter<ReplyThreadViewBaseItemHolder> {
    private final ScreenUtil f4889a;
    private final ReplyThreadViewMediaItemHolderProvider f4890b;
    public final BackstageAnalyticsLogger f4891c;
    public CameraHolder f4892d;
    public CameraFlowLauncher f4893e;
    public ReplyThread f4894f;

    public final ViewHolder m4748a(ViewGroup viewGroup, int i) {
        switch (i) {
            case 1:
            case 3:
                int i2;
                FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130903369, viewGroup, false);
                int a = this.f4889a.m4551a();
                if (i == 3) {
                    i2 = (int) (((Reply) this.f4894f.f5138b.get(0)).f5110d * ((float) a));
                } else {
                    i2 = (int) (((float) a) * 1.0f);
                }
                LayoutParams layoutParams = new FrameLayout.LayoutParams(a, i2);
                layoutParams.topMargin = frameLayout.getResources().getDimensionPixelSize(2131433268);
                layoutParams.leftMargin = frameLayout.getResources().getDimensionPixelSize(2131433268);
                layoutParams.rightMargin = frameLayout.getResources().getDimensionPixelSize(2131433268);
                frameLayout.setLayoutParams(layoutParams);
                ReplyThreadViewMediaItemHolderProvider replyThreadViewMediaItemHolderProvider = this.f4890b;
                final ReplyThreadViewMediaItemHolder replyThreadViewMediaItemHolder = new ReplyThreadViewMediaItemHolder(frameLayout, viewGroup.getContext(), Locales.a(replyThreadViewMediaItemHolderProvider), FbDraweeControllerBuilder.b(replyThreadViewMediaItemHolderProvider));
                frameLayout.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ BackstageReplyThreadRecyclerViewAdapter f4876b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -328261401);
                        BackstageReplyThreadItemController backstageReplyThreadItemController = replyThreadViewMediaItemHolder.f4973l;
                        if (backstageReplyThreadItemController.f4874j != null && backstageReplyThreadItemController.f4874j.mo172g()) {
                            if (((BackstageRichVideoView) backstageReplyThreadItemController.f4868d.m5715a()).m()) {
                                if (backstageReplyThreadItemController.f4868d.m5716b() && ((BackstageRichVideoView) backstageReplyThreadItemController.f4868d.m5715a()).f5480j && !((BackstageRichVideoView) backstageReplyThreadItemController.f4868d.m5715a()).f5479i) {
                                    ((BackstageRichVideoView) backstageReplyThreadItemController.f4868d.m5715a()).m5710b();
                                }
                            } else if (backstageReplyThreadItemController.f4868d.m5716b()) {
                                ((BackstageRichVideoView) backstageReplyThreadItemController.f4868d.m5715a()).m5712t();
                            }
                        }
                        Logger.a(2, EntryType.UI_INPUT_END, 938021472, a);
                    }
                });
                return replyThreadViewMediaItemHolder;
            case 2:
                LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(2130903368, viewGroup, false);
                final View findViewById = linearLayout.findViewById(2131559886);
                final View findViewById2 = linearLayout.findViewById(2131559885);
                findViewById.setLayoutParams(new LinearLayout.LayoutParams(this.f4889a.m4551a(), this.f4889a.m4554d()));
                findViewById.setVisibility(8);
                final PopoverListViewWindow popoverListViewWindow = new PopoverListViewWindow(linearLayout.getContext());
                popoverListViewWindow.e = true;
                popoverListViewWindow.e(true);
                popoverListViewWindow.c(false);
                popoverListViewWindow.m = new BackstagePopupReplyWindowAdapter(new OnClickListener(this) {
                    final /* synthetic */ BackstageReplyThreadRecyclerViewAdapter f4881d;

                    /* compiled from: ride_providers */
                    class C05031 implements CameraInteractionListener {
                        final /* synthetic */ C05042 f4877a;

                        C05031(C05042 c05042) {
                            this.f4877a = c05042;
                        }

                        public final void mo157a() {
                            this.f4877a.f4881d.f4891c.m4264a(Event.SUBMITTED_REPLY);
                        }

                        public final void mo158b() {
                            if (this.f4877a.f4881d.f4892d.m4321b()) {
                                this.f4877a.f4881d.f4892d.m4322c().m4314b((CameraInteractionListener) this);
                            }
                            findViewById.setVisibility(8);
                            findViewById2.setVisibility(0);
                        }
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -283668588);
                        popoverListViewWindow.l();
                        findViewById.setVisibility(0);
                        findViewById2.setVisibility(8);
                        ImmutableList immutableList = this.f4881d.f4894f.f5138b;
                        this.f4881d.f4893e.m4601a(this.f4881d.f4892d, CameraOptions.m4603a(((Reply) immutableList.get(immutableList.size() - 1)).f5108b, this.f4881d.f4894f.f5137a), new C05031(this));
                        Logger.a(2, EntryType.UI_INPUT_END, 59072690, a);
                    }
                }, new OnClickListener(this) {
                    final /* synthetic */ BackstageReplyThreadRecyclerViewAdapter f4886d;

                    /* compiled from: ride_providers */
                    class C05051 implements CameraInteractionListener {
                        final /* synthetic */ C05063 f4882a;

                        C05051(C05063 c05063) {
                            this.f4882a = c05063;
                        }

                        public final void mo157a() {
                        }

                        public final void mo158b() {
                            this.f4882a.f4886d.f4892d.m4322c().m4314b((CameraInteractionListener) this);
                            findViewById.setVisibility(8);
                            findViewById2.setVisibility(0);
                        }
                    }

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, 1218088106);
                        popoverListViewWindow.l();
                        findViewById.setVisibility(0);
                        findViewById2.setVisibility(8);
                        ImmutableList immutableList = this.f4886d.f4894f.f5138b;
                        this.f4886d.f4893e.m4601a(this.f4886d.f4892d, CameraOptions.m4605b(((Reply) immutableList.get(immutableList.size() - 1)).f5108b, this.f4886d.f4894f.f5137a), new C05051(this));
                        Logger.a(2, EntryType.UI_INPUT_END, 2118865565, a);
                    }
                });
                findViewById2.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ BackstageReplyThreadRecyclerViewAdapter f4888b;

                    public void onClick(View view) {
                        int a = Logger.a(2, EntryType.UI_INPUT_START, -1498078649);
                        popoverListViewWindow.a(view);
                        Logger.a(2, EntryType.UI_INPUT_END, 685479765, a);
                    }
                });
                return new ReplyThreadViewBaseItemHolder(linearLayout);
            default:
                return null;
        }
    }

    public final void m4749a(ViewHolder viewHolder, int i) {
        ReplyThreadViewBaseItemHolder replyThreadViewBaseItemHolder = (ReplyThreadViewBaseItemHolder) viewHolder;
        if (i < this.f4894f.f5138b.size()) {
            ImageRequestBuilder a;
            Reply reply = (Reply) this.f4894f.f5138b.get(i);
            BackstageReplyThreadItemController backstageReplyThreadItemController = ((ReplyThreadViewMediaItemHolder) replyThreadViewBaseItemHolder).f4973l;
            backstageReplyThreadItemController.f4874j = reply;
            if (backstageReplyThreadItemController.f4867c.m5716b()) {
                ((GenericDraweeView) backstageReplyThreadItemController.f4867c.m5715a()).setController(null);
                ((GenericDraweeView) backstageReplyThreadItemController.f4867c.m5715a()).setVisibility(8);
            }
            if (backstageReplyThreadItemController.f4869e.m5716b()) {
                ((FbTextView) backstageReplyThreadItemController.f4869e.m5715a()).setText("");
                ((FbTextView) backstageReplyThreadItemController.f4869e.m5715a()).setVisibility(8);
            }
            if (backstageReplyThreadItemController.f4868d.m5716b()) {
                if (((BackstageRichVideoView) backstageReplyThreadItemController.f4868d.m5715a()).m()) {
                    ((BackstageRichVideoView) backstageReplyThreadItemController.f4868d.m5715a()).m5710b();
                }
                ((BackstageRichVideoView) backstageReplyThreadItemController.f4868d.m5715a()).setVisibility(8);
            }
            if (reply.mo172g()) {
                ((BackstageRichVideoView) backstageReplyThreadItemController.f4868d.m5715a()).setVisibility(0);
                ((BackstageRichVideoView) backstageReplyThreadItemController.f4868d.m5715a()).setShouldCropToFit(true);
                ((BackstageRichVideoView) backstageReplyThreadItemController.f4868d.m5715a()).m5711b(reply.mo174i(), reply.mo171f());
            } else {
                ((GenericDraweeView) backstageReplyThreadItemController.f4867c.m5715a()).setVisibility(0);
                a = ImageRequestBuilder.a(Uri.parse(reply.mo171f()));
                a.f = ImageType.DEFAULT;
                ((GenericDraweeView) backstageReplyThreadItemController.f4867c.m5715a()).setController(((FbDraweeControllerBuilder) backstageReplyThreadItemController.f4866b.c(a.m())).a(CallerContext.a(BackstageFragment.class)).s());
            }
            if (!Strings.isNullOrEmpty(reply.mo173h())) {
                ((FbTextView) backstageReplyThreadItemController.f4869e.m5715a()).setText(reply.mo173h());
                ((FbTextView) backstageReplyThreadItemController.f4869e.m5715a()).setVisibility(0);
            }
            if (Strings.isNullOrEmpty(reply.f5109c)) {
                backstageReplyThreadItemController.f4870f.setVisibility(8);
            } else {
                backstageReplyThreadItemController.f4870f.setVisibility(0);
                a = ImageRequestBuilder.a(Uri.parse(reply.f5109c));
                a.f = ImageType.DEFAULT;
                backstageReplyThreadItemController.f4870f.setController(((FbDraweeControllerBuilder) backstageReplyThreadItemController.f4866b.c(a.m())).a(CallerContext.a(BackstageFragment.class)).s());
                ((GenericDraweeHierarchy) backstageReplyThreadItemController.f4870f.getHierarchy()).a(backstageReplyThreadItemController.f4872h);
            }
            backstageReplyThreadItemController.f4871g.setText(DateFormat.getTimeInstance(3).format(Long.valueOf(reply.f4821e.getTime() - LocaleTimeUtil.m5777a(backstageReplyThreadItemController.f4873i, reply.f4821e.mTimezoneOffset))));
        }
    }

    @Inject
    public BackstageReplyThreadRecyclerViewAdapter(ReplyThreadViewMediaItemHolderProvider replyThreadViewMediaItemHolderProvider, ScreenUtil screenUtil, BackstageAnalyticsLogger backstageAnalyticsLogger) {
        this.f4890b = replyThreadViewMediaItemHolderProvider;
        this.f4889a = screenUtil;
        this.f4891c = backstageAnalyticsLogger;
    }

    public int getItemViewType(int i) {
        if (i == 0) {
            return 3;
        }
        if (i < this.f4894f.f5138b.size()) {
            return 1;
        }
        return 2;
    }

    public final int aZ_() {
        return this.f4894f == null ? 0 : this.f4894f.f5138b.size() + 1;
    }
}

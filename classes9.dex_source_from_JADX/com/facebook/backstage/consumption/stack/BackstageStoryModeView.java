package com.facebook.backstage.consumption.stack;

import android.content.Context;
import android.net.Uri;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.backstage.camera.CameraHolder;
import com.facebook.backstage.consumption.BackstageUploadService;
import com.facebook.backstage.consumption.SimpleAnimationHelper;
import com.facebook.backstage.consumption.SimpleAnimationHelper.AnimationListener;
import com.facebook.backstage.consumption.SimpleAnimationHelper.AnimationType;
import com.facebook.backstage.consumption.camera.CameraFlowLauncher;
import com.facebook.backstage.consumption.reply.EmojiMenuView;
import com.facebook.backstage.consumption.reply.EmojiMenuView.OnEmojiClickListener;
import com.facebook.backstage.consumption.stack.BackstageStoryModeController.C05304;
import com.facebook.backstage.consumption.stack.BackstageStoryModeController.C05315;
import com.facebook.backstage.consumption.stack.BackstageStoryModeController.C05326;
import com.facebook.backstage.consumption.stack.BackstageStoryModeController.C05337;
import com.facebook.backstage.consumption.swipe.BaseBackstageStoryPagerViewItem;
import com.facebook.backstage.data.BackstageProfile;
import com.facebook.backstage.data.BackstageProfile.BackstageStory;
import com.facebook.backstage.data.BackstageProfile.SeenByUser;
import com.facebook.backstage.data.LocalShot;
import com.facebook.backstage.data.UploadShot;
import com.facebook.backstage.graphql.BackstageMarkSeenMutationHelper;
import com.facebook.backstage.graphql.BackstageMarkSeenMutationHelper.C05571;
import com.facebook.backstage.graphql.FBBackstageMutationFragments.FBBackstageSeenMutationString;
import com.facebook.backstage.ui.ViewAnimator;
import com.facebook.backstage.util.EmojiReplyUtil;
import com.facebook.drawee.view.GenericDraweeView;
import com.facebook.fbui.glyph.GlyphView;
import com.facebook.graphql.calls.BackstagePostUpdateSeenStateInputData;
import com.facebook.graphql.calls.GraphQlCallInput;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.inject.FbInjector;
import com.facebook.resources.ui.FbTextView;
import com.facebook.user.model.User;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import java.util.Iterator;
import javax.annotation.Nullable;
import javax.inject.Inject;

/* compiled from: retr_txt_cs */
public class BackstageStoryModeView extends FrameLayout {
    @Inject
    public BackstageStoryModeController f5041a;
    private final SimpleAnimationHelper f5042b;

    /* compiled from: retr_txt_cs */
    class C05361 implements AnimationListener {
        final /* synthetic */ BackstageStoryModeView f5040a;

        C05361(BackstageStoryModeView backstageStoryModeView) {
            this.f5040a = backstageStoryModeView;
        }

        public final void mo168a() {
            BackstageStoryModeController backstageStoryModeController = this.f5040a.f5041a;
            backstageStoryModeController.f5035v = false;
            backstageStoryModeController.f5033t = null;
            backstageStoryModeController.f5022i.m4891d();
            for (int i = backstageStoryModeController.f5034u.f5118g; i < backstageStoryModeController.f5034u.f5117f.size(); i++) {
                BackstageStory backstageStory = (BackstageStory) backstageStoryModeController.f5034u.f5117f.get(i);
                if (backstageStory.f5107e) {
                    BackstageMarkSeenMutationHelper backstageMarkSeenMutationHelper = backstageStoryModeController.f5027n;
                    String str = backstageStory.f5104b;
                    GraphQlQueryString fBBackstageSeenMutationString = new FBBackstageSeenMutationString();
                    BackstagePostUpdateSeenStateInputData backstagePostUpdateSeenStateInputData = new BackstagePostUpdateSeenStateInputData();
                    backstagePostUpdateSeenStateInputData.a("actor_id", (String) backstageMarkSeenMutationHelper.f5211d.get());
                    GraphQlCallInput graphQlCallInput = backstagePostUpdateSeenStateInputData;
                    graphQlCallInput.a("post_fbid", str);
                    graphQlCallInput = graphQlCallInput;
                    graphQlCallInput.a("client_mutation_id", fBBackstageSeenMutationString.d);
                    fBBackstageSeenMutationString.a("0", graphQlCallInput);
                    Futures.a(backstageMarkSeenMutationHelper.f5210c.a(GraphQLRequest.a(fBBackstageSeenMutationString)), new C05571(backstageMarkSeenMutationHelper), backstageMarkSeenMutationHelper.f5209b);
                }
            }
            backstageStoryModeController.f5038y.removeAllViews();
        }

        public final void mo169b() {
            this.f5040a.setX(0.0f);
        }
    }

    private static <T extends View> void m4844a(Class<T> cls, T t) {
        m4845a((Object) t, t.getContext());
    }

    private static void m4845a(Object obj, Context context) {
        ((BackstageStoryModeView) obj).f5041a = BackstageStoryModeController.m4836b(FbInjector.get(context));
    }

    public BackstageStoryModeView(Context context) {
        this(context, null);
    }

    private void m4843a(BackstageStoryModeController backstageStoryModeController) {
        this.f5041a = backstageStoryModeController;
    }

    public BackstageStoryModeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackstageStoryModeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5042b = new SimpleAnimationHelper(this, new C05361(this));
        m4844a(BackstageStoryModeView.class, (View) this);
        View inflate = LayoutInflater.from(getContext()).inflate(2130903376, this);
        BackstageStoryModeController backstageStoryModeController = this.f5041a;
        SimpleAnimationHelper simpleAnimationHelper = this.f5042b;
        backstageStoryModeController.f5008E = inflate;
        backstageStoryModeController.f5014K = simpleAnimationHelper;
        backstageStoryModeController.f5038y = (ViewGroup) inflate.findViewById(2131559893);
        backstageStoryModeController.f5039z = (FbTextView) inflate.findViewById(2131559889);
        backstageStoryModeController.f5037x = (GenericDraweeView) inflate.findViewById(2131559888);
        backstageStoryModeController.f5004A = (FbTextView) inflate.findViewById(2131559896);
        backstageStoryModeController.f5005B = (FrameLayout) inflate.findViewById(2131559894);
        backstageStoryModeController.f5006C = (GlyphView) inflate.findViewById(2131559895);
        backstageStoryModeController.f5006C.setGlyphColor(backstageStoryModeController.f5021h.getResources().getColor(2131361867));
        backstageStoryModeController.f5007D = (GlyphView) inflate.findViewById(2131559898);
        backstageStoryModeController.f5007D.setGlyphColor(inflate.getResources().getColor(17170443));
        backstageStoryModeController.f5007D.setOnClickListener(new C05304(backstageStoryModeController));
        backstageStoryModeController.f5004A.setOnClickListener(new C05315(backstageStoryModeController));
        backstageStoryModeController.f5006C.setOnClickListener(new C05326(backstageStoryModeController));
        inflate.setOnTouchListener(new C05337(backstageStoryModeController));
        backstageStoryModeController.f5011H = (EmojiMenuView) inflate.findViewById(2131559897);
        if (backstageStoryModeController.f5011H != null) {
            Builder builder = ImmutableList.builder();
            Iterator it = EmojiReplyUtil.f5567a.iterator();
            while (it.hasNext()) {
                builder.c(new SpannableStringBuilder((String) it.next()));
            }
            backstageStoryModeController.f5011H.setAvailableEmojis(builder.b());
            backstageStoryModeController.f5011H.f4939c = new OnEmojiClickListener(backstageStoryModeController) {
                final /* synthetic */ BackstageStoryModeController f4988a;

                {
                    this.f4988a = r1;
                }

                public final void mo183a(CharSequence charSequence) {
                    boolean z;
                    BackstageStoryModeController backstageStoryModeController = this.f4988a;
                    if (backstageStoryModeController.f5034u.f5115d) {
                        z = false;
                    } else {
                        z = true;
                    }
                    Preconditions.checkArgument(z);
                    BackstageStory backstageStory = (BackstageStory) backstageStoryModeController.f5022i.f5097f.f18378C;
                    SeenByUser seenByUser = new SeenByUser(((User) backstageStoryModeController.f5031r.get()).h(), null, Uri.parse(((User) backstageStoryModeController.f5031r.get()).x()));
                    seenByUser.f5111a = charSequence.toString();
                    backstageStory.m4892a(seenByUser);
                    backstageStoryModeController.f5028o.m4544a(backstageStoryModeController.f5034u.f5112a, backstageStory.f5104b, seenByUser);
                    BackstageStoryModeController.m4835a(backstageStoryModeController, ImmutableList.of(seenByUser));
                    backstageStoryModeController = this.f4988a;
                    Futures.a(backstageStoryModeController.f5030q.m4815a(charSequence.toString(), -16776961), new FutureCallback<LocalShot>(backstageStoryModeController) {
                        final /* synthetic */ BackstageStoryModeController f4989a;

                        {
                            this.f4989a = r1;
                        }

                        public void onSuccess(@Nullable Object obj) {
                            LocalShot localShot = (LocalShot) obj;
                            UploadShot uploadShot = new UploadShot(localShot.f5129e, localShot.f5132h, localShot.f5126b, localShot.f5125a.getTime(), ((BackstageStory) this.f4989a.f5022i.f5097f.f18378C).f5104b, null);
                            BackstageUploadService.m4523a(this.f4989a.f5019f, this.f4989a.f5021h, uploadShot);
                        }

                        public void onFailure(Throwable th) {
                            this.f4989a.f5020g.a(BackstageStoryModeController.f5003a, "Error unable to create 1x1 image.", th);
                        }
                    }, backstageStoryModeController.f5012I);
                }
            };
        }
    }

    public final void m4848a(BackstageProfile backstageProfile) {
        ViewAnimator.m5752a((View) this).m5761e();
        setFocusable(true);
        requestFocus();
        if (backstageProfile.f5118g == 0) {
            this.f5042b.m4560a(AnimationType.SLIDE_FROM_RIGHT);
        } else {
            this.f5042b.m4560a(AnimationType.ALPHA);
        }
        this.f5041a.m4839a(backstageProfile);
    }

    public final boolean m4849a() {
        Object obj;
        BackstageStoryModeController backstageStoryModeController = this.f5041a;
        if (backstageStoryModeController.f5022i.m4890c() != null && ((BaseBackstageStoryPagerViewItem) backstageStoryModeController.f5022i.m4890c()).mo181g()) {
            obj = 1;
        } else if (backstageStoryModeController.f5011H.m4791b()) {
            backstageStoryModeController.f5011H.m4789a();
            int i = 1;
        } else {
            backstageStoryModeController.f5026m.m4266a(backstageStoryModeController.f5034u.f5115d);
            obj = null;
        }
        if (obj != null) {
            return true;
        }
        if (!this.f5042b.m4561a()) {
            return false;
        }
        m4846b();
        return true;
    }

    private void m4846b() {
        this.f5042b.m4562b(AnimationType.SLIDE_FROM_RIGHT);
    }

    public final void m4847a(CameraHolder cameraHolder, CameraFlowLauncher cameraFlowLauncher) {
        BackstageStoryModeController backstageStoryModeController = this.f5041a;
        backstageStoryModeController.f5036w = cameraHolder;
        backstageStoryModeController.f5013J = cameraFlowLauncher;
    }
}

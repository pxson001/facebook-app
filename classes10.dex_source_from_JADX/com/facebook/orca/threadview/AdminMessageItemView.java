package com.facebook.orca.threadview;

import android.content.Context;
import android.content.res.Resources;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.auth.annotations.LoggedInUser;
import com.facebook.common.util.ContextUtils;
import com.facebook.common.util.StyledStringBuilder;
import com.facebook.graphql.enums.GraphQLExtensibleMessageAdminTextType;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.loom.logger.LogEntry.EntryType;
import com.facebook.loom.logger.Logger;
import com.facebook.messaging.annotations.ShouldShowManageGroupUpsellExperiment;
import com.facebook.messaging.attachments.AttachmentDataFactory;
import com.facebook.messaging.attachments.ImageAttachmentData;
import com.facebook.messaging.bball.BballGameFeature;
import com.facebook.messaging.blocking.AdManageBlockingParam;
import com.facebook.messaging.blocking.AdManageBlockingParam.AdManageBlockingParamBuilder;
import com.facebook.messaging.blocking.ManageBlockingParam;
import com.facebook.messaging.business.ride.gating.IsRideServiceComposerEnabled;
import com.facebook.messaging.business.ride.utils.RideServiceParams;
import com.facebook.messaging.business.ride.utils.RideServiceParams.RideServiceParamsBuilder;
import com.facebook.messaging.customthreads.DefaultThreadViewTheme;
import com.facebook.messaging.customthreads.ThreadViewTheme.Listener;
import com.facebook.messaging.customthreads.annotations.IsCustomBubbleColorsEnabled;
import com.facebook.messaging.customthreads.annotations.IsCustomNicknamesEnabled;
import com.facebook.messaging.customthreads.annotations.IsHotEmojilikesEnabled;
import com.facebook.messaging.events.abtest.LightweightEventsGatekeepers;
import com.facebook.messaging.graphql.threads.ThreadQueriesModels.XMAAttachmentStoryFieldsModel;
import com.facebook.messaging.model.messages.Message;
import com.facebook.messaging.model.messages.MessageType;
import com.facebook.messaging.model.messages.MessageUtil;
import com.facebook.messaging.model.messages.ParticipantInfo;
import com.facebook.messaging.model.messages.annotations.IsChangeableAdminTextEnabled;
import com.facebook.messaging.modifiers.SlashMeAdminMessageFeature;
import com.facebook.messaging.photos.tiles.UserTileViewParamsFactory;
import com.facebook.messaging.rtc.adminmsg.model.RtcCallLogClassifierHelper;
import com.facebook.messaging.rtc.adminmsg.model.RtcCallLogClassifierHelperProvider;
import com.facebook.messaging.threadview.rows.RowMessageItem;
import com.facebook.orca.threadview.MessageListAdapter.C10741;
import com.facebook.qe.api.QeAccessor;
import com.facebook.qe.module.QeInternalImplMethodAutoProvider;
import com.facebook.ui.emoji.EmojiUtil;
import com.facebook.user.model.User;
import com.facebook.user.model.User.Type;
import com.facebook.user.model.UserKey;
import com.facebook.user.tiles.UserTileView;
import com.facebook.user.tiles.UserTileViewParams;
import com.facebook.widget.CustomViewGroup;
import com.facebook.widget.tiles.TileBadge;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: multiple_accounts_user_ids */
public class AdminMessageItemView extends CustomViewGroup implements ThreadImageClickListener {
    public static final ImmutableMap<MessageType, Integer> f6800r = ImmutableMap.builder().b(MessageType.ADD_MEMBERS, Integer.valueOf(2130773148)).b(MessageType.REMOVE_MEMBERS, Integer.valueOf(2130773149)).b(MessageType.SET_NAME, Integer.valueOf(2130773150)).b(MessageType.SET_IMAGE, Integer.valueOf(2130773151)).b(MessageType.REMOVED_IMAGE, Integer.valueOf(2130773151)).b(MessageType.VIDEO_CALL, Integer.valueOf(2130773152)).b(MessageType.MISSED_VIDEO_CALL, Integer.valueOf(2130773153)).b(MessageType.INCOMING_CALL, Integer.valueOf(2130773154)).b(MessageType.MISSED_CALL, Integer.valueOf(2130773153)).b(MessageType.OUTGOING_CALL, Integer.valueOf(2130773155)).b(MessageType.P2P_PAYMENT, Integer.valueOf(2130773156)).b(MessageType.P2P_PAYMENT_CANCELED, Integer.valueOf(2130773157)).b(MessageType.P2P_PAYMENT_GROUP, Integer.valueOf(2130773156)).b();
    public AdminMessageFacepile f6801A;
    public FrameLayout f6802B;
    public AdminMessageRoundedItemView f6803C;
    public UserTileView f6804D;
    public ThreadViewImageAttachmentView f6805E;
    private int f6806F;
    private boolean f6807G;
    public C10741 f6808H;
    @Inject
    public AttachmentDataFactory f6809a;
    @Inject
    BballGameFeature f6810b;
    @Inject
    EmojiUtil f6811c;
    @Inject
    public MessageUtil f6812d;
    @Inject
    @IsChangeableAdminTextEnabled
    Provider<Boolean> f6813e;
    @Inject
    @IsRideServiceComposerEnabled
    Provider<Boolean> f6814f;
    @IsCustomBubbleColorsEnabled
    @Inject
    Provider<Boolean> f6815g;
    @Inject
    @IsCustomNicknamesEnabled
    Provider<Boolean> f6816h;
    @Inject
    @IsHotEmojilikesEnabled
    Provider<Boolean> f6817i;
    @Inject
    SlashMeAdminMessageFeature f6818j;
    @Inject
    UserTileViewParamsFactory f6819k;
    @Inject
    CommerceAdminMessageItemViewHelper f6820l;
    @Inject
    RtcCallLogClassifierHelperProvider f6821m;
    @Inject
    @ShouldShowManageGroupUpsellExperiment
    Provider<Boolean> f6822n;
    @Inject
    QeAccessor f6823o;
    @Inject
    @LoggedInUser
    Provider<User> f6824p;
    @Inject
    LightweightEventsGatekeepers f6825q;
    public final Listener f6826s = new C10181(this);
    public RowMessageItem f6827t;
    public Message f6828u;
    public DefaultThreadViewTheme f6829v;
    public View f6830w;
    public TextView f6831x;
    public TextView f6832y;
    public TextView f6833z;

    /* compiled from: multiple_accounts_user_ids */
    class C10181 implements Listener {
        final /* synthetic */ AdminMessageItemView f6793a;

        C10181(AdminMessageItemView adminMessageItemView) {
            this.f6793a = adminMessageItemView;
        }

        public final void m6472a() {
            AdminMessageItemView.m6494h(this.f6793a);
        }
    }

    /* compiled from: multiple_accounts_user_ids */
    public class C10192 {
        public final /* synthetic */ AdminMessageItemView f6794a;

        C10192(AdminMessageItemView adminMessageItemView) {
            this.f6794a = adminMessageItemView;
        }
    }

    /* compiled from: multiple_accounts_user_ids */
    class C10203 implements OnClickListener {
        final /* synthetic */ AdminMessageItemView f6795a;

        C10203(AdminMessageItemView adminMessageItemView) {
            this.f6795a = adminMessageItemView;
        }

        public void onClick(View view) {
            int a = Logger.a(2, EntryType.UI_INPUT_START, -215204651);
            if (this.f6795a.f6808H != null) {
                C10741 c10741 = this.f6795a.f6808H;
                RowMessageItem rowMessageItem = this.f6795a.f6827t;
                if (c10741.f7165a.f7175A != null) {
                    c10741.f7165a.f7175A.mo284a(rowMessageItem);
                }
            }
            Logger.a(2, EntryType.UI_INPUT_END, 975646169, a);
        }
    }

    public static void m6482a(Object obj, Context context) {
        InjectorLike injectorLike = FbInjector.get(context);
        ((AdminMessageItemView) obj).m6481a(AttachmentDataFactory.a(injectorLike), BballGameFeature.a(injectorLike), EmojiUtil.a(injectorLike), MessageUtil.a(injectorLike), IdBasedProvider.a(injectorLike, 4169), IdBasedProvider.a(injectorLike, 4121), IdBasedProvider.a(injectorLike, 4145), IdBasedProvider.a(injectorLike, 4147), IdBasedProvider.a(injectorLike, 4149), SlashMeAdminMessageFeature.m3202a(injectorLike), UserTileViewParamsFactory.a(injectorLike), CommerceAdminMessageItemViewHelper.m6515a(injectorLike), (RtcCallLogClassifierHelperProvider) injectorLike.getOnDemandAssistedProviderForStaticDi(RtcCallLogClassifierHelperProvider.class), IdBasedProvider.a(injectorLike, 4100), (QeAccessor) QeInternalImplMethodAutoProvider.a(injectorLike), IdBasedProvider.a(injectorLike, 3595), LightweightEventsGatekeepers.m2153a(injectorLike));
    }

    private void m6481a(AttachmentDataFactory attachmentDataFactory, BballGameFeature bballGameFeature, EmojiUtil emojiUtil, MessageUtil messageUtil, Provider<Boolean> provider, Provider<Boolean> provider2, Provider<Boolean> provider3, Provider<Boolean> provider4, Provider<Boolean> provider5, SlashMeAdminMessageFeature slashMeAdminMessageFeature, UserTileViewParamsFactory userTileViewParamsFactory, CommerceAdminMessageItemViewHelper commerceAdminMessageItemViewHelper, RtcCallLogClassifierHelperProvider rtcCallLogClassifierHelperProvider, Provider<Boolean> provider6, QeAccessor qeAccessor, Provider<User> provider7, LightweightEventsGatekeepers lightweightEventsGatekeepers) {
        this.f6809a = attachmentDataFactory;
        this.f6810b = bballGameFeature;
        this.f6811c = emojiUtil;
        this.f6812d = messageUtil;
        this.f6813e = provider;
        this.f6814f = provider2;
        this.f6815g = provider3;
        this.f6816h = provider4;
        this.f6817i = provider5;
        this.f6818j = slashMeAdminMessageFeature;
        this.f6819k = userTileViewParamsFactory;
        this.f6820l = commerceAdminMessageItemViewHelper;
        this.f6821m = rtcCallLogClassifierHelperProvider;
        this.f6822n = provider6;
        this.f6823o = qeAccessor;
        this.f6824p = provider7;
        this.f6825q = lightweightEventsGatekeepers;
    }

    public AdminMessageItemView(Context context) {
        super(context);
        Class cls = AdminMessageItemView.class;
        m6482a((Object) this, getContext());
        setContentView(2130905559);
        this.f6830w = getView(2131564429);
        this.f6831x = (TextView) getView(2131564435);
        this.f6832y = (TextView) getView(2131564436);
        this.f6833z = (TextView) getView(2131564437);
        this.f6801A = (AdminMessageFacepile) getView(2131564434);
        this.f6802B = (FrameLayout) getView(2131564430);
        this.f6803C = (AdminMessageRoundedItemView) getView(2131564431);
        this.f6804D = (UserTileView) getView(2131564432);
        this.f6805E = (ThreadViewImageAttachmentView) getView(2131564433);
        this.f6805E.setNeedsUserRequestToLoad(false);
    }

    public final void mo242a(ImageAttachmentData imageAttachmentData) {
        if (this.f6808H != null) {
            C10741 c10741 = this.f6808H;
            RowMessageItem rowMessageItem = this.f6827t;
            if (c10741.f7165a.f7175A != null) {
                c10741.f7165a.f7175A.mo286a(rowMessageItem, imageAttachmentData);
            }
        }
    }

    public final void mo243b(ImageAttachmentData imageAttachmentData) {
    }

    public Message getMessage() {
        return this.f6828u;
    }

    public void setRowMessageItem(RowMessageItem rowMessageItem) {
        this.f6827t = rowMessageItem;
        this.f6828u = this.f6827t.f4732a;
        m6485b();
        StringBuilder stringBuilder = new StringBuilder();
        if (MessageUtil.q(this.f6828u)) {
            if (this.f6812d.P(this.f6828u)) {
                stringBuilder.append(getResources().getString(2131231088));
            } else {
                stringBuilder.append(getResources().getString(2131231090));
            }
        }
        CharSequence stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2.isEmpty()) {
            this.f6832y.setText("");
            this.f6832y.setVisibility(8);
        } else {
            this.f6832y.setText(stringBuilder2);
            this.f6832y.setVisibility(0);
        }
        m6489d();
        if (!this.f6809a.a(this.f6828u)) {
            this.f6802B.setVisibility(8);
            this.f6805E.setVisibility(8);
        } else if (MessageType.SET_IMAGE.equals(this.f6828u.l)) {
            this.f6803C.setMessage(this.f6828u);
            this.f6803C.m6497a(this);
            this.f6804D.setParams(UserTileViewParams.a(this.f6828u.e.b, TileBadge.NONE));
            this.f6802B.setVisibility(0);
            this.f6805E.setVisibility(8);
        } else {
            this.f6802B.setVisibility(8);
            this.f6805E.setVisibility(0);
            this.f6805E.setMessage(this.f6828u);
            this.f6805E.m7315a((ThreadImageClickListener) this);
        }
        m6492f();
        m6493g();
    }

    private void m6485b() {
        this.f6807G = false;
        Resources resources = getResources();
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        StyledStringBuilder styledStringBuilder = new StyledStringBuilder(spannableStringBuilder, resources);
        MessageType messageType = this.f6828u.l;
        m6480a(styledStringBuilder, this.f6828u);
        if (this.f6828u.l == MessageType.CALL_LOG) {
            this.f6831x.setText(m6484b(styledStringBuilder, this.f6828u));
        } else if (this.f6828u.l == MessageType.COMMERCE_LINK || this.f6828u.l == MessageType.COMMERCE_UNLINK) {
            this.f6820l.f6884f = new C10192(this);
            this.f6820l.m6518a(this.f6828u, this.f6831x);
        } else if (m6487b(this.f6828u) && (MessageUtil.m(this.f6828u) || MessageUtil.k(this.f6828u) || this.f6810b.a(this.f6828u) || m6491e(this.f6828u))) {
            int i = this.f6810b.a(this.f6828u) ? 2131240215 : 2131231794;
            this.f6807G = true;
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(m6483b(this, resources));
            styledStringBuilder.a(resources.getString(2131231793, new Object[]{this.f6828u.f, "%2$s"}));
            styledStringBuilder.a("%2$s", resources.getString(i), foregroundColorSpan, 18);
            this.f6811c.a(spannableStringBuilder, (int) this.f6831x.getTextSize());
            this.f6831x.setText(spannableStringBuilder);
        } else if (messageType == MessageType.MISSED_CALL || messageType == MessageType.MISSED_VIDEO_CALL) {
            this.f6831x.setText(m6477a(styledStringBuilder, m6475a(this.f6812d.a().equals(this.f6828u.e.b)), this.f6828u.f));
        } else if (messageType == MessageType.P2P_PAYMENT_CANCELED) {
            this.f6831x.setText(m6477a(styledStringBuilder, 2131240500, this.f6828u.f));
        } else if (MessageUtil.q(this.f6828u)) {
            this.f6831x.setText(m6476a(styledStringBuilder));
        } else if (MessageUtil.I(this.f6828u)) {
            m6479a(styledStringBuilder, this.f6831x);
        } else {
            Object obj;
            Message message = this.f6828u;
            if (message.I != null) {
                Object obj2;
                if (message.I.c == GraphQLExtensibleMessageAdminTextType.AD_MANAGE_MESSAGE) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (obj2 != null) {
                    obj = 1;
                    if (obj == null) {
                        m6486b(styledStringBuilder, this.f6831x);
                    }
                    if (this.f6818j.m3205a(this.f6828u)) {
                        styledStringBuilder.a(this.f6828u.f);
                    } else {
                        styledStringBuilder.a(this.f6818j.m3207b(this.f6828u));
                    }
                    this.f6811c.a(spannableStringBuilder, (int) this.f6831x.getTextSize());
                    this.f6831x.setText(spannableStringBuilder);
                    return;
                }
            }
            obj = null;
            if (obj == null) {
                if (this.f6818j.m3205a(this.f6828u)) {
                    styledStringBuilder.a(this.f6828u.f);
                } else {
                    styledStringBuilder.a(this.f6818j.m3207b(this.f6828u));
                }
                this.f6811c.a(spannableStringBuilder, (int) this.f6831x.getTextSize());
                this.f6831x.setText(spannableStringBuilder);
                return;
            }
            m6486b(styledStringBuilder, this.f6831x);
        }
    }

    private void m6480a(StyledStringBuilder styledStringBuilder, Message message) {
        if (!m6488c(message) && f6800r.containsKey(message.l)) {
            int b = ContextUtils.b(getContext(), ((Integer) f6800r.get(message.l)).intValue(), 0);
            if (b != 0) {
                m6478a(styledStringBuilder, b);
            }
        }
    }

    private void m6478a(StyledStringBuilder styledStringBuilder, int i) {
        styledStringBuilder.a(new ImageSpan(getContext(), i), 33);
        styledStringBuilder.a(" ");
        styledStringBuilder.a();
        styledStringBuilder.a(" ");
    }

    private void m6489d() {
        boolean z;
        Message message = this.f6828u;
        if (message.m == null || this.f6828u.m.size() <= 0) {
            z = false;
        } else {
            z = MessageUtil.a(message.l);
        }
        if (z) {
            this.f6801A.m6471a(this.f6828u.m, this.f6819k);
            this.f6801A.setVisibility(0);
        } else if (MessageUtil.q(this.f6828u)) {
            this.f6801A.m6471a(ImmutableList.of(this.f6828u.e), this.f6819k);
            this.f6801A.setVisibility(0);
        } else if (m6490d(this.f6828u)) {
            this.f6801A.m6470a(ImmutableList.of(new ParticipantInfo(((User) this.f6824p.get()).T, ((User) this.f6824p.get()).k()), new ParticipantInfo(new UserKey(Type.FACEBOOK, String.valueOf(this.f6828u.b.d)), "")));
            this.f6801A.setVisibility(0);
        } else {
            this.f6801A.removeAllViews();
            this.f6801A.setVisibility(8);
        }
    }

    private void m6492f() {
        StringBuilder stringBuilder = new StringBuilder();
        if (MessageUtil.q(this.f6828u)) {
            stringBuilder.append(getResources().getString(2131231091));
        } else if (m6490d(this.f6828u)) {
            stringBuilder.append(getResources().getString(2131231092));
        }
        CharSequence stringBuilder2 = stringBuilder.toString();
        if (stringBuilder2.isEmpty()) {
            this.f6833z.setText("");
            this.f6833z.setVisibility(8);
            return;
        }
        this.f6833z.setText(stringBuilder2);
        this.f6833z.setTextColor(this.f6829v != null ? this.f6829v.e() : getResources().getColor(2131362241));
        this.f6833z.setVisibility(0);
    }

    private void m6493g() {
        if (m6487b(this.f6828u)) {
            this.f6830w.setClickable(true);
            this.f6830w.setOnClickListener(new C10203(this));
            return;
        }
        this.f6830w.setClickable(false);
    }

    private static SpannableString m6477a(StyledStringBuilder styledStringBuilder, int i, String str) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-65536);
        UnderlineSpan underlineSpan = new UnderlineSpan();
        styledStringBuilder.a(foregroundColorSpan, 18);
        styledStringBuilder.a(str);
        styledStringBuilder.a(" ");
        styledStringBuilder.a(underlineSpan, 18);
        styledStringBuilder.a(i);
        styledStringBuilder.a();
        styledStringBuilder.a();
        return styledStringBuilder.b();
    }

    private SpannableString m6476a(StyledStringBuilder styledStringBuilder) {
        boolean P = this.f6812d.P(this.f6828u);
        String string = getResources().getString(2131230720);
        if (P) {
            styledStringBuilder.a(getResources().getString(2131231087, new Object[]{string}));
        } else {
            styledStringBuilder.a(getResources().getString(2131231089, new Object[]{this.f6828u.e.c, string}));
        }
        return styledStringBuilder.b();
    }

    private void m6479a(StyledStringBuilder styledStringBuilder, TextView textView) {
        String str;
        m6478a(styledStringBuilder, 2130841330);
        styledStringBuilder.a(this.f6828u.f);
        if (this.f6828u.I != null) {
            str = this.f6828u.I.p;
        } else {
            str = null;
        }
        if (!((Boolean) this.f6814f.get()).booleanValue() || this.f6812d.a().equals(this.f6828u.e.b)) {
            textView.setText(styledStringBuilder.b());
            return;
        }
        C10214 c10214 = new ClickableSpan(this) {
            final /* synthetic */ AdminMessageItemView f6797b;

            public void onClick(View view) {
                if (this.f6797b.f6808H != null) {
                    C10741 c10741 = this.f6797b.f6808H;
                    RideServiceParamsBuilder newBuilder = RideServiceParams.newBuilder();
                    newBuilder.a = "admin_message";
                    newBuilder = newBuilder;
                    newBuilder.d = str;
                    RideServiceParams j = newBuilder.j();
                    if (c10741.f7165a.f7175A != null) {
                        c10741.f7165a.f7175A.mo281a(j);
                    }
                }
            }

            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(AdminMessageItemView.m6483b(this.f6797b, this.f6797b.getResources()));
                textPaint.setUnderlineText(false);
            }
        };
        CharSequence spannableString = new SpannableString(getResources().getString(2131240763));
        spannableString.setSpan(c10214, 0, spannableString.length(), 33);
        styledStringBuilder.a("\n");
        styledStringBuilder.a(spannableString);
        textView.setText(styledStringBuilder.b());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void m6486b(StyledStringBuilder styledStringBuilder, TextView textView) {
        ManageBlockingParam manageBlockingParam;
        styledStringBuilder.a(this.f6828u.f);
        styledStringBuilder.a(" · ");
        String str = null;
        boolean z = false;
        if (!(this.f6828u.I == null || this.f6828u.I.q == null)) {
            str = this.f6828u.I.q.preferenceLink;
            z = this.f6828u.I.q.isOffsiteAd;
        }
        if (Strings.isNullOrEmpty(str)) {
            manageBlockingParam = ManageBlockingParam.c;
        } else {
            AdManageBlockingParamBuilder adManageBlockingParamBuilder = new AdManageBlockingParamBuilder();
            adManageBlockingParamBuilder.a = str;
            AdManageBlockingParamBuilder adManageBlockingParamBuilder2 = adManageBlockingParamBuilder;
            adManageBlockingParamBuilder2.b = z;
            manageBlockingParam = new AdManageBlockingParam(adManageBlockingParamBuilder2);
        }
        C10225 c10225 = new ClickableSpan(this) {
            final /* synthetic */ AdminMessageItemView f6799b;

            public void onClick(View view) {
                if (this.f6799b.f6808H != null) {
                    this.f6799b.f6808H.m6764a(manageBlockingParam);
                }
            }
        };
        Spannable spannableString = new SpannableString(getResources().getString(2131231789));
        spannableString.setSpan(c10225, 0, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(textView.getCurrentTextColor()), 0, spannableString.length(), 18);
        styledStringBuilder.a(spannableString);
        textView.setText(styledStringBuilder.b());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
    }

    protected void onDetachedFromWindow() {
        int a = Logger.a(2, EntryType.LIFECYCLE_VIEW_START, -358642654);
        super.onDetachedFromWindow();
        CommerceAdminMessageItemViewHelper commerceAdminMessageItemViewHelper = this.f6820l;
        CommerceAdminMessageItemViewHelper.m6517d(commerceAdminMessageItemViewHelper);
        if (commerceAdminMessageItemViewHelper.f6888j != null) {
            commerceAdminMessageItemViewHelper.f6888j.dismiss();
            commerceAdminMessageItemViewHelper.f6888j = null;
        }
        if (commerceAdminMessageItemViewHelper.f6887i != null) {
            commerceAdminMessageItemViewHelper.f6887i.cancel(true);
            commerceAdminMessageItemViewHelper.f6887i = null;
        }
        Logger.a(2, EntryType.LIFECYCLE_VIEW_END, 1526399053, a);
    }

    public static int m6483b(AdminMessageItemView adminMessageItemView, Resources resources) {
        return adminMessageItemView.f6829v != null ? adminMessageItemView.f6829v.e() : resources.getColor(2131362241);
    }

    private boolean m6487b(Message message) {
        if (MessageUtil.t(message) || MessageUtil.x(message) || MessageUtil.y(message) || MessageUtil.z(message) || MessageUtil.q(message) || m6490d(message) || m6488c(message) || m6491e(message) || this.f6810b.a(message)) {
            return true;
        }
        if (!((Boolean) this.f6813e.get()).booleanValue()) {
            return false;
        }
        if (message.l == MessageType.ADMIN) {
            if (message.I.d()) {
                return ((Boolean) this.f6817i.get()).booleanValue();
            }
            if (message.I.c()) {
                return ((Boolean) this.f6815g.get()).booleanValue();
            }
            if (message.I.e() && message.I.g != null) {
                return ((Boolean) this.f6816h.get()).booleanValue();
            }
        }
        return false;
    }

    private boolean m6488c(Message message) {
        return ((Boolean) this.f6822n.get()).booleanValue() && MessageUtil.k(message);
    }

    public static void m6494h(AdminMessageItemView adminMessageItemView) {
        adminMessageItemView.f6831x.setTextColor(adminMessageItemView.f6829v.d());
        adminMessageItemView.f6832y.setTextColor(adminMessageItemView.f6829v.d());
        int e = adminMessageItemView.f6829v.e();
        if (e != adminMessageItemView.f6806F && adminMessageItemView.f6807G) {
            adminMessageItemView.setRowMessageItem(adminMessageItemView.f6827t);
        }
        adminMessageItemView.f6806F = e;
    }

    private SpannableString m6484b(StyledStringBuilder styledStringBuilder, Message message) {
        int intValue;
        XMAAttachmentStoryFieldsModel l = message.G.l();
        CharSequence l2 = l.l();
        RtcCallLogClassifierHelper a = this.f6821m.a(l.b());
        if (a.a()) {
            intValue = ((Integer) f6800r.get(MessageType.MISSED_CALL)).intValue();
        } else if (a.b()) {
            intValue = ((Integer) f6800r.get(MessageType.INCOMING_CALL)).intValue();
        } else {
            intValue = ((Integer) f6800r.get(MessageType.OUTGOING_CALL)).intValue();
        }
        int b = ContextUtils.b(getContext(), intValue, 0);
        if (b != 0) {
            styledStringBuilder.a(new ImageSpan(getContext(), b), 33);
            styledStringBuilder.a(" ");
            styledStringBuilder.a();
            styledStringBuilder.a(" ");
        }
        if (a.a()) {
            return m6477a(styledStringBuilder, m6475a(a.b()), l2);
        }
        return styledStringBuilder.a(l2).b();
    }

    private static int m6475a(boolean z) {
        return z ? 2131232046 : 2131232047;
    }

    private boolean m6490d(Message message) {
        return MessageUtil.r(message) && this.f6823o.a(ExperimentsForThreadViewModule.f6912a, false);
    }

    private boolean m6491e(Message message) {
        return MessageUtil.Y(message) & this.f6825q.f2277a.a(254, false);
    }
}

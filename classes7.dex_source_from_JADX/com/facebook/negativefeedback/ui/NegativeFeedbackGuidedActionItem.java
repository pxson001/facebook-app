package com.facebook.negativefeedback.ui;

import com.facebook.graphql.enums.GraphQLNegativeFeedbackActionType;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryInterfaces.NegativeFeedbackPromptQueryFragment.Responses;
import com.facebook.negativefeedback.protocol.NegativeFeedbackQueryModels.NegativeFeedbackPromptQueryFragmentModel.ResponsesModel;
import java.util.Set;

/* compiled from: non_self_add_intro_upsell_impression */
public class NegativeFeedbackGuidedActionItem {
    public ResponsesModel f8072a;
    public Set<GraphQLNegativeFeedbackActionType> f8073b;
    public NegativeFeedbackGuidedActionItemViewType f8074c;

    /* compiled from: non_self_add_intro_upsell_impression */
    /* synthetic */ class C06481 {
        static final /* synthetic */ int[] f8071a = new int[GraphQLNegativeFeedbackActionType.values().length];

        static {
            try {
                f8071a[GraphQLNegativeFeedbackActionType.BLOCK_ACTOR.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.BLOCK_APP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.CONTACT_FORM.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.DELETE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.HELP_CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.MESSAGE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.REDIRECT.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.REPORT_CONTENT.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.REPORT_IP_VIOLATION.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.REPORT_CONTENT_EDUCATION.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.SPAM_CLEANUP_CHECKPOINT.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.UNFRIEND.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.UNLIKE.ordinal()] = 13;
            } catch (NoSuchFieldError e13) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.HIDE_ADVERTISER.ordinal()] = 14;
            } catch (NoSuchFieldError e14) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE.ordinal()] = 15;
            } catch (NoSuchFieldError e15) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_OWNER.ordinal()] = 16;
            } catch (NoSuchFieldError e16) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_PAGE.ordinal()] = 17;
            } catch (NoSuchFieldError e17) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_RESHARER.ordinal()] = 18;
            } catch (NoSuchFieldError e18) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_ATTACHED_STORY_ACTOR.ordinal()] = 19;
            } catch (NoSuchFieldError e19) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.UNSUBSCRIBE_DIRECTED_TARGET.ordinal()] = 20;
            } catch (NoSuchFieldError e20) {
            }
            try {
                f8071a[GraphQLNegativeFeedbackActionType.UNTAG.ordinal()] = 21;
            } catch (NoSuchFieldError e21) {
            }
        }
    }

    public NegativeFeedbackGuidedActionItem(Responses responses, Set<GraphQLNegativeFeedbackActionType> set) {
        this.f8072a = responses;
        this.f8073b = set;
        if (m9754h()) {
            this.f8074c = NegativeFeedbackGuidedActionItemViewType.COMPLETED;
        } else {
            this.f8074c = NegativeFeedbackGuidedActionItemViewType.INITIAL;
        }
    }

    private boolean m9754h() {
        return (this.f8073b != null && this.f8073b.contains(this.f8072a.m9683g())) || this.f8072a.m9680b();
    }

    public final String m9755a() {
        return m9754h() ? this.f8072a.m9682d() != null ? this.f8072a.m9682d().m9635a() : "" : this.f8072a.m9686l() != null ? this.f8072a.m9686l().m9667a() : "";
    }

    public final String m9756b() {
        return m9754h() ? this.f8072a.m9681c() != null ? this.f8072a.m9681c().m9630a() : "" : this.f8072a.gN_() != null ? this.f8072a.gN_().m9652a() : "";
    }

    public final GraphQLNegativeFeedbackActionType m9757c() {
        if (this.f8072a != null) {
            return this.f8072a.m9683g();
        }
        return null;
    }

    public final int m9758f() {
        if (m9754h()) {
            return 2130839777;
        }
        switch (C06481.f8071a[this.f8072a.m9683g().ordinal()]) {
            case 1:
            case 2:
                return 2130839878;
            case 3:
                return 2130839809;
            case 4:
                return 2130840135;
            case 5:
                return 2130839943;
            case 6:
                return 2130839805;
            case 7:
                return 2130840005;
            case 8:
            case 9:
                return 2130843018;
            case 10:
                return 2130840005;
            case 11:
                return 2130839901;
            case 12:
                return 2130839890;
            case 13:
                return 2130839687;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                return 2130840145;
            case 21:
                return 2130840123;
            default:
                return 2130839681;
        }
    }
}

package com.facebook.reaction.common;

import com.facebook.common.util.CollectionUtil;
import com.facebook.graphql.enums.GraphQLReactionStoryAttachmentsStyle;
import com.facebook.graphql.enums.GraphQLReactionUnitHeaderStyle;
import com.facebook.graphql.enums.GraphQLReactionUnitStyle;
import com.facebook.inject.InjectorLike;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionFacepileProfile;
import com.facebook.reaction.protocol.common.ReactionCommonGraphQLInterfaces.ReactionImageFields;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitDefaultFields;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLInterfaces.ReactionUnitFragment;
import com.facebook.reaction.protocol.graphql.FetchReactionGraphQLModels.ReactionStoryFragmentModel.ReactionAttachmentsModel;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLInterfaces.ReactionUnitComponentFields;
import com.facebook.reaction.protocol.graphql.ReactionUnitComponentsGraphQLModels.ReactionUnitComponentModel;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList.Builder;
import javax.inject.Inject;

/* compiled from: blackListPageReview */
public class ReactionUnitValidator {
    private final ReactionAttachmentStyleMapper f18872a;
    private final ReactionUnitComponentStyleMapper f18873b;

    /* compiled from: blackListPageReview */
    /* synthetic */ class C20791 {
        static final /* synthetic */ int[] f18870a = new int[GraphQLReactionUnitStyle.values().length];
        static final /* synthetic */ int[] f18871b = new int[GraphQLReactionUnitHeaderStyle.values().length];

        static {
            try {
                f18871b[GraphQLReactionUnitHeaderStyle.ICON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f18871b[GraphQLReactionUnitHeaderStyle.ICON_INLINE_ACTION.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f18871b[GraphQLReactionUnitHeaderStyle.ICON_PIVOT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f18871b[GraphQLReactionUnitHeaderStyle.CENTER_ALIGNED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f18871b[GraphQLReactionUnitHeaderStyle.DESCRIPTIVE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f18871b[GraphQLReactionUnitHeaderStyle.THIN_FACEPILE.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f18870a[GraphQLReactionUnitStyle.STORY.ordinal()] = 1;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f18870a[GraphQLReactionUnitStyle.UNIT_STACK.ordinal()] = 2;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f18870a[GraphQLReactionUnitStyle.PLACEHOLDER.ordinal()] = 3;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f18870a[GraphQLReactionUnitStyle.FLUSH_TO_BOTTOM.ordinal()] = 4;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f18870a[GraphQLReactionUnitStyle.VERTICAL_COMPONENTS.ordinal()] = 5;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f18870a[GraphQLReactionUnitStyle.VERTICAL_COMPONENTS_WITH_TRANSPARENT_BACKGROUND.ordinal()] = 6;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    public static ReactionUnitValidator m22908b(InjectorLike injectorLike) {
        return new ReactionUnitValidator(ReactionAttachmentStyleMapper.m22863a(injectorLike), ReactionUnitComponentStyleMapper.m22890a(injectorLike));
    }

    @Inject
    public ReactionUnitValidator(ReactionAttachmentStyleMapper reactionAttachmentStyleMapper, ReactionUnitComponentStyleMapper reactionUnitComponentStyleMapper) {
        this.f18872a = reactionAttachmentStyleMapper;
        this.f18873b = reactionUnitComponentStyleMapper;
    }

    public static ReactionUnitValidator m22907a(InjectorLike injectorLike) {
        return m22908b(injectorLike);
    }

    private ReactionValidationResult m22912c(ReactionUnitDefaultFields reactionUnitDefaultFields) {
        Object obj = null;
        ReactionAttachmentsModel fx_ = reactionUnitDefaultFields.fx_();
        Object obj2 = (fx_ == null || fx_.b().isEmpty()) ? 1 : null;
        if (fx_ == null || fx_.d() == null || fx_.d() == GraphQLReactionStoryAttachmentsStyle.UNSET_OR_UNRECOGNIZED_ENUM_VALUE) {
            obj = 1;
        }
        if (obj2 == null && r0 != null) {
            return new ReactionValidationResult("NO_STYLES_PROVIDED");
        }
        if (obj2 != null && r0 == null) {
            return new ReactionValidationResult("EMPTY_ATTACHMENTS");
        }
        if (obj2 != null && r0 != null) {
            return m22911b(reactionUnitDefaultFields) ? new ReactionValidationResult("SUCCESS") : new ReactionValidationResult("NO_CONTENT");
        } else {
            ReactionAttachmentHandler a = this.f18872a.m22865a(fx_.d());
            if (a == null || !a.mo1140a(fx_)) {
                return new ReactionValidationResult("NO_SUPPORTED_STYLE");
            }
            return new ReactionValidationResult("SUCCESS", a, fx_.d());
        }
    }

    public final ReactionValidationResult m22914a(ReactionUnitDefaultFields reactionUnitDefaultFields) {
        Object obj;
        ReactionAttachmentsModel fx_ = reactionUnitDefaultFields.fx_();
        if (fx_ == null || !(GraphQLReactionStoryAttachmentsStyle.FEED_STORY_SINGLE == fx_.d() || GraphQLReactionStoryAttachmentsStyle.PAGE_POST_STORY == fx_.d())) {
            obj = null;
        } else {
            obj = 1;
        }
        if (obj != null) {
            return new ReactionValidationResult("SUCCESS");
        }
        String d = reactionUnitDefaultFields.d();
        String n = reactionUnitDefaultFields.n();
        GraphQLReactionUnitStyle m = reactionUnitDefaultFields.m();
        if (d == null || n == null || m == null) {
            return new ReactionValidationResult("ERROR_INVALID_UNIT");
        }
        switch (C20791.f18870a[m.ordinal()]) {
            case 1:
                return m22912c(reactionUnitDefaultFields);
            case 2:
                return m22913e(reactionUnitDefaultFields);
            case 3:
                return new ReactionValidationResult(m22909b((Object) reactionUnitDefaultFields));
            case 4:
            case 5:
            case 6:
                return new ReactionValidationResult(m22916a((Object) reactionUnitDefaultFields));
            default:
                return new ReactionValidationResult("NO_SUPPORTED_STYLE");
        }
    }

    private static String m22909b(Object obj) {
        if (!(obj instanceof ReactionUnitFragment)) {
            return "ERROR_INVALID_UNIT";
        }
        ReactionUnitFragment reactionUnitFragment = (ReactionUnitFragment) obj;
        if (Strings.isNullOrEmpty(reactionUnitFragment.d()) || Strings.isNullOrEmpty(reactionUnitFragment.n())) {
            return "ERROR_INVALID_UNIT";
        }
        return "SUCCESS";
    }

    private ReactionValidationResult m22913e(ReactionUnitDefaultFields reactionUnitDefaultFields) {
        if (!(reactionUnitDefaultFields instanceof ReactionUnitFragment)) {
            return new ReactionValidationResult("ERROR_INVALID_UNIT");
        }
        ReactionUnitFragment reactionUnitFragment = (ReactionUnitFragment) reactionUnitDefaultFields;
        if (reactionUnitFragment.r() == null || reactionUnitFragment.r().a().isEmpty()) {
            return new ReactionValidationResult("NO_AGGREGATED_UNITS");
        }
        Builder builder = ImmutableList.builder();
        ImmutableList a = reactionUnitFragment.r().a();
        int size = a.size();
        for (int i = 0; i < size; i++) {
            ReactionValidationResult c = m22912c((ReactionUnitDefaultFields) a.get(i));
            if (!"SUCCESS".equals(c.f18877d)) {
                return new ReactionValidationResult(c.f18877d);
            }
            builder.c(c);
        }
        return new ReactionValidationResult("SUCCESS", builder.b());
    }

    public final String m22916a(Object obj) {
        if (!(obj instanceof ReactionUnitFragment)) {
            return "ERROR_INVALID_UNIT";
        }
        ReactionUnitFragment reactionUnitFragment = (ReactionUnitFragment) obj;
        ImmutableList s = reactionUnitFragment.s();
        if (Strings.isNullOrEmpty(reactionUnitFragment.d()) || Strings.isNullOrEmpty(reactionUnitFragment.n())) {
            return "ERROR_INVALID_UNIT";
        }
        if (s.isEmpty()) {
            return "EMPTY_COMPONENTS";
        }
        int size = s.size();
        for (int i = 0; i < size; i++) {
            if (!this.f18873b.m22894a((ReactionUnitComponentModel) s.get(i))) {
                return "UNSUPPORTED_COMPONENT_STYLE";
            }
        }
        return "SUCCESS";
    }

    public static boolean m22911b(ReactionUnitDefaultFields reactionUnitDefaultFields) {
        if (reactionUnitDefaultFields.fw_() == null || reactionUnitDefaultFields.fw_().c() == null) {
            return false;
        }
        switch (C20791.f18871b[reactionUnitDefaultFields.fw_().c().ordinal()]) {
            case 1:
                if (reactionUnitDefaultFields.fw_().fA_() == null || Strings.isNullOrEmpty(reactionUnitDefaultFields.fw_().fA_().a()) || (reactionUnitDefaultFields.fw_().b() != null && !reactionUnitDefaultFields.fw_().fA_().b().isEmpty())) {
                    return false;
                }
                return true;
            case 2:
                if (reactionUnitDefaultFields.fw_().fA_() == null || Strings.isNullOrEmpty(reactionUnitDefaultFields.fw_().fA_().a()) || reactionUnitDefaultFields.fw_().b() == null || reactionUnitDefaultFields.fw_().b().j() == null || reactionUnitDefaultFields.fw_().b().fU_() == null) {
                    return false;
                }
                return true;
            case 3:
                if (reactionUnitDefaultFields.fw_().fA_() == null || Strings.isNullOrEmpty(reactionUnitDefaultFields.fw_().fA_().a()) || reactionUnitDefaultFields.fw_().b() == null) {
                    return false;
                }
                return true;
            case 4:
                if (reactionUnitDefaultFields.fw_().fA_() == null || Strings.isNullOrEmpty(reactionUnitDefaultFields.fw_().fA_().a()) || reactionUnitDefaultFields.fw_().fz_() == null || Strings.isNullOrEmpty(reactionUnitDefaultFields.fw_().fz_().a()) || (reactionUnitDefaultFields.fw_().b() != null && !reactionUnitDefaultFields.fw_().fA_().b().isEmpty())) {
                    return false;
                }
                return true;
            case 5:
                if (reactionUnitDefaultFields.fw_().fA_() == null || Strings.isNullOrEmpty(reactionUnitDefaultFields.fw_().fA_().a())) {
                    return false;
                }
                return true;
            case 6:
                if (!(reactionUnitDefaultFields.fw_().fA_() == null || Strings.isNullOrEmpty(reactionUnitDefaultFields.fw_().fA_().a()))) {
                    ImmutableList g = reactionUnitDefaultFields.fw_().g();
                    Object obj = null;
                    if (!g.isEmpty()) {
                        int i = 0;
                        while (i < g.size()) {
                            ReactionFacepileProfile reactionFacepileProfile = (ReactionFacepileProfile) g.get(i);
                            ReactionImageFields d = reactionFacepileProfile.d();
                            if (!(d == null || Strings.isNullOrEmpty(d.b()) || Strings.isNullOrEmpty(reactionFacepileProfile.c()))) {
                                i++;
                            }
                        }
                        obj = 1;
                    }
                    if (obj != null) {
                        return true;
                    }
                }
                return false;
            default:
                return false;
        }
    }

    public final String m22915a(ReactionUnitComponentNode reactionUnitComponentNode) {
        ImmutableList b = ReactionUnitComponentUtil.m22902b(reactionUnitComponentNode);
        if (b == null) {
            return "ERROR_INVALID_COMPONENT";
        }
        if (b.isEmpty()) {
            return "EMPTY_SUB_COMPONENTS";
        }
        int size = b.size();
        for (int i = 0; i < size; i++) {
            if (!this.f18873b.m22894a((ReactionUnitComponentFields) b.get(i))) {
                return "UNSUPPORTED_COMPONENT_STYLE";
            }
        }
        return "SUCCESS";
    }

    public static boolean m22910b(ReactionUnitComponentNode reactionUnitComponentNode) {
        return !CollectionUtil.a(ReactionUnitComponentUtil.m22904d(reactionUnitComponentNode));
    }
}

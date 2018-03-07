package com.facebook.structuredsurvey;

import android.content.res.Resources;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLStructuredSurveyCustomQuestionType;
import com.facebook.graphql.enums.GraphQLStructuredSurveyQuestionType;
import com.facebook.infer.annotation.Assertions;
import com.facebook.structuredsurvey.StructuredSurveyState.Answer;
import com.facebook.structuredsurvey.items.SurveyCheckboxItem;
import com.facebook.structuredsurvey.items.SurveyEditTextItem;
import com.facebook.structuredsurvey.items.SurveyImageBlockItem;
import com.facebook.structuredsurvey.items.SurveyItem;
import com.facebook.structuredsurvey.items.SurveyItem.ItemType;
import com.facebook.structuredsurvey.items.SurveyMessageItem;
import com.facebook.structuredsurvey.items.SurveyNotificationItem;
import com.facebook.structuredsurvey.items.SurveyQuestionItem;
import com.facebook.structuredsurvey.items.SurveyRadioItem;
import com.facebook.structuredsurvey.items.SurveySpaceItem;
import com.facebook.structuredsurvey.items.SurveyWriteInItem;
import com.facebook.structuredsurvey.util.SurveyNotificationWrapper;
import com.facebook.structuredsurvey.util.tokenparams.SurveyTokenParamResolver;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyConfiguredQuestionFragmentModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyQuestionTokenParamFragmentModel;
import com.facebook.survey.graphql.StructuredSurveySessionFragmentsModels.StructuredSurveyResponseOptionFragmentModel;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: draft_story */
public class StructuredSurveyBuilder {
    private String f17086a;
    private String f17087b;
    private String f17088c;
    public int f17089d;
    private int f17090e;
    public SurveyNotificationWrapper f17091f;
    private final Resources f17092g;
    private final SurveyTokenParamResolver f17093h;

    /* compiled from: draft_story */
    /* synthetic */ class C12361 {
        static final /* synthetic */ int[] f17085a = new int[GraphQLStructuredSurveyQuestionType.values().length];

        static {
            try {
                f17085a[GraphQLStructuredSurveyQuestionType.RADIO.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f17085a[GraphQLStructuredSurveyQuestionType.CHECKBOX.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f17085a[GraphQLStructuredSurveyQuestionType.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f17085a[GraphQLStructuredSurveyQuestionType.MESSAGE.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f17085a[GraphQLStructuredSurveyQuestionType.CUSTOM.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
        }
    }

    public StructuredSurveyBuilder(Resources resources, SurveyTokenParamResolver surveyTokenParamResolver) {
        this.f17092g = resources;
        this.f17093h = surveyTokenParamResolver;
    }

    public final void m24790a(int i) {
        this.f17089d = i;
    }

    public final void m24792a(String str) {
        if (StringUtil.a(str)) {
            throw new IllegalArgumentException("Null/Empty Intro Toast Text");
        }
        this.f17086a = str;
    }

    public final void m24795b(String str) {
        if (StringUtil.a(str)) {
            throw new IllegalArgumentException("Null/Empty Intro Toast Button Text");
        }
        this.f17087b = str;
    }

    public final void m24797c(String str) {
        if (StringUtil.a(str)) {
            throw new IllegalArgumentException("Null/Empty Outro Toast Text");
        }
        this.f17088c = str;
    }

    public final void m24791a(@Nullable SurveyNotificationWrapper surveyNotificationWrapper) {
        if (surveyNotificationWrapper == null) {
            throw new IllegalArgumentException("Null SurveyNotificationWrapper");
        }
        this.f17091f = surveyNotificationWrapper;
    }

    public final List<SurveyItem> m24788a() {
        List<SurveyItem> a = Lists.a();
        a.add(new SurveyImageBlockItem(this.f17086a, this.f17087b));
        return a;
    }

    public final List<SurveyItem> m24793b() {
        List<SurveyItem> a = Lists.a();
        a.add(new SurveyMessageItem(this.f17088c));
        return a;
    }

    public final List<SurveyItem> m24789a(List<StructuredSurveyConfiguredQuestionFragmentModel> list) {
        Preconditions.checkNotNull(list);
        List<SurveyItem> a = Lists.a();
        for (StructuredSurveyConfiguredQuestionFragmentModel structuredSurveyConfiguredQuestionFragmentModel : list) {
            if (structuredSurveyConfiguredQuestionFragmentModel != null) {
                this.f17090e++;
                if (this.f17089d == -1 || this.f17090e <= this.f17089d) {
                    switch (C12361.f17085a[structuredSurveyConfiguredQuestionFragmentModel.m25027m().ordinal()]) {
                        case 1:
                            a.addAll(m24782a(structuredSurveyConfiguredQuestionFragmentModel));
                            a.add(new SurveySpaceItem(16));
                            break;
                        case 2:
                            a.addAll(m24785b(structuredSurveyConfiguredQuestionFragmentModel));
                            a.add(new SurveySpaceItem(16));
                            break;
                        case 3:
                            a.addAll(m24787d(structuredSurveyConfiguredQuestionFragmentModel));
                            a.add(new SurveySpaceItem(16));
                            break;
                        case 4:
                            a.addAll(m24786c(structuredSurveyConfiguredQuestionFragmentModel));
                            a.add(new SurveySpaceItem(16));
                            this.f17090e--;
                            break;
                        case 5:
                            if (structuredSurveyConfiguredQuestionFragmentModel.m25025k() != GraphQLStructuredSurveyCustomQuestionType.NOTIFICATION) {
                                break;
                            }
                            List a2 = Lists.a();
                            a2.add(new SurveyNotificationItem(this.f17091f));
                            a.addAll(a2);
                            a.add(new SurveySpaceItem(16));
                            this.f17090e--;
                            break;
                        default:
                            break;
                    }
                } else if (a.isEmpty()) {
                    return a;
                } else {
                    throw new IllegalArgumentException("No Valid Types In Question List");
                }
            }
        }
        if (a.isEmpty()) {
            return a;
        }
        throw new IllegalArgumentException("No Valid Types In Question List");
    }

    private List<SurveyItem> m24782a(StructuredSurveyConfiguredQuestionFragmentModel structuredSurveyConfiguredQuestionFragmentModel) {
        List<SurveyItem> a = Lists.a();
        a.add(m24781a(structuredSurveyConfiguredQuestionFragmentModel, this.f17090e));
        a.add(new SurveySpaceItem(12));
        a.add(new SurveyItem(ItemType.DIVIDER, structuredSurveyConfiguredQuestionFragmentModel.m25028n()));
        ImmutableList<StructuredSurveyResponseOptionFragmentModel> o = structuredSurveyConfiguredQuestionFragmentModel.m25029o();
        if (structuredSurveyConfiguredQuestionFragmentModel.m25023a()) {
            for (StructuredSurveyResponseOptionFragmentModel a2 : Iterables.c(o, o.size() - 1)) {
                m24783a(structuredSurveyConfiguredQuestionFragmentModel, a2, false, a);
            }
            m24783a(structuredSurveyConfiguredQuestionFragmentModel, (StructuredSurveyResponseOptionFragmentModel) Iterables.g(o), true, a);
        } else {
            for (StructuredSurveyResponseOptionFragmentModel a22 : o) {
                m24783a(structuredSurveyConfiguredQuestionFragmentModel, a22, false, a);
            }
        }
        return a;
    }

    private void m24783a(StructuredSurveyConfiguredQuestionFragmentModel structuredSurveyConfiguredQuestionFragmentModel, StructuredSurveyResponseOptionFragmentModel structuredSurveyResponseOptionFragmentModel, boolean z, List<SurveyItem> list) {
        Object surveyWriteInItem;
        Answer a = m24780a(structuredSurveyResponseOptionFragmentModel, structuredSurveyConfiguredQuestionFragmentModel.m25030p());
        if (z) {
            surveyWriteInItem = new SurveyWriteInItem(ItemType.RADIOWRITEIN, a, structuredSurveyConfiguredQuestionFragmentModel.m25028n());
        } else {
            surveyWriteInItem = new SurveyRadioItem(a, structuredSurveyConfiguredQuestionFragmentModel.m25028n());
        }
        list.add(surveyWriteInItem);
        list.add(new SurveyItem(ItemType.DIVIDER, structuredSurveyConfiguredQuestionFragmentModel.m25028n()));
    }

    private List<SurveyItem> m24785b(StructuredSurveyConfiguredQuestionFragmentModel structuredSurveyConfiguredQuestionFragmentModel) {
        List<SurveyItem> a = Lists.a();
        a.add(m24781a(structuredSurveyConfiguredQuestionFragmentModel, this.f17090e));
        a.add(new SurveySpaceItem(12));
        a.add(new SurveyItem(ItemType.DIVIDER, structuredSurveyConfiguredQuestionFragmentModel.m25028n()));
        ImmutableList o = structuredSurveyConfiguredQuestionFragmentModel.m25029o();
        for (StructuredSurveyResponseOptionFragmentModel a2 : Iterables.c(o, o.size() - 1)) {
            m24784a(a, new SurveyCheckboxItem(m24780a(a2, structuredSurveyConfiguredQuestionFragmentModel.m25030p()), structuredSurveyConfiguredQuestionFragmentModel.m25028n()), structuredSurveyConfiguredQuestionFragmentModel.m25028n());
        }
        Assertions.a(!o.isEmpty());
        Answer a3 = m24780a((StructuredSurveyResponseOptionFragmentModel) Iterables.g(o), structuredSurveyConfiguredQuestionFragmentModel.m25030p());
        if (structuredSurveyConfiguredQuestionFragmentModel.m25023a()) {
            m24784a(a, new SurveyWriteInItem(ItemType.CHECKBOXWRITEIN, a3, structuredSurveyConfiguredQuestionFragmentModel.m25028n()), structuredSurveyConfiguredQuestionFragmentModel.m25028n());
        } else {
            m24784a(a, new SurveyCheckboxItem(a3, structuredSurveyConfiguredQuestionFragmentModel.m25028n()), structuredSurveyConfiguredQuestionFragmentModel.m25028n());
        }
        return a;
    }

    private static void m24784a(List<SurveyItem> list, SurveyItem surveyItem, String str) {
        list.add(surveyItem);
        list.add(new SurveyItem(ItemType.DIVIDER, str));
    }

    private Answer m24780a(StructuredSurveyResponseOptionFragmentModel structuredSurveyResponseOptionFragmentModel, @Nullable ImmutableList<StructuredSurveyQuestionTokenParamFragmentModel> immutableList) {
        String a = structuredSurveyResponseOptionFragmentModel.m25090j().a();
        if (!(immutableList == null || immutableList.isEmpty())) {
            a = this.f17093h.a(a, immutableList);
        }
        return new Answer(structuredSurveyResponseOptionFragmentModel.m25086a(), structuredSurveyResponseOptionFragmentModel.m25091k(), a);
    }

    private List<SurveyItem> m24786c(StructuredSurveyConfiguredQuestionFragmentModel structuredSurveyConfiguredQuestionFragmentModel) {
        List<SurveyItem> arrayList = new ArrayList();
        arrayList.add(m24781a(structuredSurveyConfiguredQuestionFragmentModel, -1));
        arrayList.add(new SurveySpaceItem(12));
        arrayList.add(new SurveyMessageItem(structuredSurveyConfiguredQuestionFragmentModel.m25026l().a()));
        arrayList.add(new SurveySpaceItem(12));
        arrayList.add(new SurveyItem(ItemType.DIVIDER, structuredSurveyConfiguredQuestionFragmentModel.m25028n()));
        return arrayList;
    }

    private List<SurveyItem> m24787d(StructuredSurveyConfiguredQuestionFragmentModel structuredSurveyConfiguredQuestionFragmentModel) {
        List<SurveyItem> arrayList = new ArrayList();
        arrayList.add(m24781a(structuredSurveyConfiguredQuestionFragmentModel, this.f17090e));
        arrayList.add(new SurveyEditTextItem(structuredSurveyConfiguredQuestionFragmentModel.m25028n()));
        return arrayList;
    }

    public final List<SurveyItem> m24794b(List<StructuredSurveyConfiguredQuestionFragmentModel> list) {
        if (list == null || list.isEmpty() || ((StructuredSurveyConfiguredQuestionFragmentModel) list.get(0)).m25027m() != GraphQLStructuredSurveyQuestionType.TEXT) {
            return null;
        }
        return m24787d((StructuredSurveyConfiguredQuestionFragmentModel) list.get(0));
    }

    public final List<SurveyItem> m24796c(List<StructuredSurveyConfiguredQuestionFragmentModel> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StructuredSurveyConfiguredQuestionFragmentModel structuredSurveyConfiguredQuestionFragmentModel = (StructuredSurveyConfiguredQuestionFragmentModel) list.get(0);
        List<SurveyItem> arrayList = new ArrayList();
        arrayList.add(m24781a(structuredSurveyConfiguredQuestionFragmentModel, this.f17090e));
        ImmutableList<StructuredSurveyResponseOptionFragmentModel> o = structuredSurveyConfiguredQuestionFragmentModel.m25029o();
        if (o != null) {
            for (StructuredSurveyResponseOptionFragmentModel a : o) {
                arrayList.add(new SurveyRadioItem(m24780a(a, structuredSurveyConfiguredQuestionFragmentModel.m25030p()), structuredSurveyConfiguredQuestionFragmentModel.m25028n()));
            }
        }
        return arrayList;
    }

    private SurveyQuestionItem m24781a(StructuredSurveyConfiguredQuestionFragmentModel structuredSurveyConfiguredQuestionFragmentModel, int i) {
        String str;
        String str2 = null;
        String a = structuredSurveyConfiguredQuestionFragmentModel.m25024j().a();
        String n = structuredSurveyConfiguredQuestionFragmentModel.m25028n();
        ImmutableList p = structuredSurveyConfiguredQuestionFragmentModel.m25030p();
        if (i == -1) {
            str = null;
        } else if (this.f17089d == -1) {
            str = this.f17092g.getString(2131236122, new Object[]{Integer.valueOf(i)});
        } else {
            str = this.f17092g.getString(2131236121, new Object[]{Integer.valueOf(i), Integer.valueOf(this.f17089d)});
        }
        if (!(p == null || p.isEmpty())) {
            a = this.f17093h.a(a, p);
        }
        if (structuredSurveyConfiguredQuestionFragmentModel.m25027m() == GraphQLStructuredSurveyQuestionType.CHECKBOX) {
            str2 = this.f17092g.getString(2131236124);
        }
        return new SurveyQuestionItem(str, a, str2, n);
    }
}

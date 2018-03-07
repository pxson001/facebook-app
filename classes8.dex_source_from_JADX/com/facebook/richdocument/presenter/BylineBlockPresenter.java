package com.facebook.richdocument.presenter;

import android.content.Context;
import android.text.format.DateUtils;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.common.util.StringUtil;
import com.facebook.entitycards.contextitems.graphql.ContextItemsQueryModels.FBFullImageFragmentModel;
import com.facebook.graphql.enums.GraphQLDocumentAuthorStyle;
import com.facebook.graphql.enums.GraphQLDocumentDateStyle;
import com.facebook.inject.FbInjector;
import com.facebook.inject.IdBasedLazy;
import com.facebook.inject.InjectableComponentWithContext;
import com.facebook.inject.Lazy;
import com.facebook.richdocument.RichDocumentInfo;
import com.facebook.richdocument.model.block.RichDocumentImageData;
import com.facebook.richdocument.model.block.RichDocumentTextType;
import com.facebook.richdocument.model.block.RichText;
import com.facebook.richdocument.model.block.RichText.RichTextBuilder;
import com.facebook.richdocument.model.data.BlockData;
import com.facebook.richdocument.model.data.BylineBlockData;
import com.facebook.richdocument.model.data.impl.AuthorBlockDataImpl;
import com.facebook.richdocument.model.data.impl.BylineBlockDataImpl;
import com.facebook.richdocument.model.graphql.RichDocumentGraphQlModels.RichDocumentAuthorModel.ProfileModel;
import com.facebook.richdocument.view.block.BylineBlockView;
import com.facebook.richdocument.view.block.impl.BylineBlockViewImpl;
import com.google.common.collect.ImmutableList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import javax.inject.Inject;

/* compiled from: photoFilePath */
public class BylineBlockPresenter extends AbstractBlockPresenter<BylineBlockView, BylineBlockData> implements InjectableComponentWithContext {
    @Inject
    public Lazy<I18nJoiner> f6401d;
    @Inject
    public Lazy<RichDocumentInfo> f6402e;

    /* compiled from: photoFilePath */
    /* synthetic */ class C07241 {
        static final /* synthetic */ int[] f6400a = new int[GraphQLDocumentDateStyle.values().length];

        static {
            try {
                f6400a[GraphQLDocumentDateStyle.MONTH_AND_DAY.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f6400a[GraphQLDocumentDateStyle.MONTH_DAY_YEAR.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f6400a[GraphQLDocumentDateStyle.MONTH_DAY_TIME.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f6400a[GraphQLDocumentDateStyle.MONTH.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f6400a[GraphQLDocumentDateStyle.DAY_TIME.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f6400a[GraphQLDocumentDateStyle.MONTH_AND_YEAR.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f6400a[GraphQLDocumentDateStyle.MONTH_DAY_YEAR_TIME.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f6400a[GraphQLDocumentDateStyle.YEAR.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f6400a[GraphQLDocumentDateStyle.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public static void m6788a(Object obj, Context context) {
        FbInjector fbInjector = FbInjector.get(context);
        BylineBlockPresenter bylineBlockPresenter = (BylineBlockPresenter) obj;
        Lazy a = IdBasedLazy.a(fbInjector, 550);
        Lazy a2 = IdBasedLazy.a(fbInjector, 10295);
        bylineBlockPresenter.f6401d = a;
        bylineBlockPresenter.f6402e = a2;
    }

    public final void mo366a(BlockData blockData) {
        BylineBlockDataImpl bylineBlockDataImpl = (BylineBlockDataImpl) blockData;
        ImmutableList immutableList = bylineBlockDataImpl.f5697a;
        ((BylineBlockViewImpl) m6772a()).mo374a(null);
        if (immutableList != null && immutableList.size() > 0) {
            Locale locale = getContext().getResources().getConfiguration().locale;
            Map linkedHashMap = new LinkedHashMap();
            List linkedList = new LinkedList();
            int size = immutableList.size();
            for (int i = 0; i < size; i++) {
                AuthorBlockDataImpl authorBlockDataImpl = (AuthorBlockDataImpl) immutableList.get(i);
                if (authorBlockDataImpl.m5489d() && !StringUtil.a(authorBlockDataImpl.m5487a())) {
                    String d;
                    int bD_;
                    int a;
                    Object c = authorBlockDataImpl.m5488c();
                    if (c == null) {
                        c = "";
                    }
                    if (!linkedHashMap.containsKey(c)) {
                        linkedHashMap.put(c, new LinkedList());
                    }
                    ((List) linkedHashMap.get(c)).add(authorBlockDataImpl.m5487a());
                    if (m6789a(authorBlockDataImpl)) {
                        FBFullImageFragmentModel g = authorBlockDataImpl.m5490e().mo313g();
                        d = g.d();
                        bD_ = g.bD_();
                        a = g.a();
                    } else {
                        a = 0;
                        bD_ = 0;
                        d = null;
                    }
                    linkedList.add(new RichDocumentImageData(d, bD_, a));
                }
            }
            if (!(((RichDocumentInfo) this.f6402e.get()).m5106f() == null || ((RichDocumentInfo) this.f6402e.get()).m5106f().m6350c() == null || ((RichDocumentInfo) this.f6402e.get()).m5106f().m6350c().m5840a() == GraphQLDocumentAuthorStyle.TEXT)) {
                if (linkedList.size() > 1) {
                    ((BylineBlockViewImpl) m6772a()).m6961a(linkedList);
                } else if (linkedList.size() == 1) {
                    ((BylineBlockViewImpl) m6772a()).m6959a((RichDocumentImageData) linkedList.get(0));
                }
            }
            Object a2 = m6787a(linkedHashMap);
            if (!StringUtil.c(a2)) {
                ((BylineBlockViewImpl) m6772a()).m6960a(m6784a(getContext(), a2.toUpperCase(locale)));
            }
        }
        if (bylineBlockDataImpl.m5509b() > 0) {
            GraphQLDocumentDateStyle graphQLDocumentDateStyle;
            GraphQLDocumentDateStyle graphQLDocumentDateStyle2 = GraphQLDocumentDateStyle.NONE;
            if (((RichDocumentInfo) this.f6402e.get()).m5106f() == null || ((RichDocumentInfo) this.f6402e.get()).m5106f().m6350c() == null) {
                graphQLDocumentDateStyle = graphQLDocumentDateStyle2;
            } else {
                graphQLDocumentDateStyle = ((RichDocumentInfo) this.f6402e.get()).m5106f().m6350c().m5842b();
            }
            String a3 = m6785a(getContext(), bylineBlockDataImpl.m5509b() * 1000, graphQLDocumentDateStyle);
            if (!StringUtil.a(a3)) {
                ((BylineBlockViewImpl) m6772a()).m6962b(m6784a(getContext(), a3));
            }
        }
    }

    public BylineBlockPresenter(BylineBlockViewImpl bylineBlockViewImpl) {
        super(bylineBlockViewImpl);
        Class cls = BylineBlockPresenter.class;
        m6788a((Object) this, getContext());
    }

    private String m6787a(Map<String, List<String>> map) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!map.isEmpty()) {
            List list = (List) map.get("");
            if (list != null) {
                stringBuilder.append(m6786a("", list));
            }
            for (Entry entry : map.entrySet()) {
                String str = (String) entry.getKey();
                if (!str.equals("")) {
                    stringBuilder.append('\n').append(m6786a(str, (List) entry.getValue()));
                }
            }
        }
        return stringBuilder.toString();
    }

    private String m6786a(String str, List<String> list) {
        if (list.size() == 1) {
            String string;
            if (str.equals("")) {
                string = getContext().getString(2131237712, new Object[]{list.get(0)});
            } else {
                string = getContext().getString(2131237714, new Object[]{str, list.get(0)});
            }
            return string;
        } else if (list.size() > 1) {
            return m6790c(str, list);
        } else {
            return "";
        }
    }

    private String m6790c(String str, List<String> list) {
        int size = list.size() - 1;
        String str2 = (String) list.get(size);
        String a = ((I18nJoiner) this.f6401d.get()).a(list.subList(0, size));
        if (str.equals("")) {
            return getContext().getString(2131237713, new Object[]{a, str2});
        }
        return getContext().getString(2131237715, new Object[]{str, a, str2});
    }

    private static boolean m6789a(AuthorBlockDataImpl authorBlockDataImpl) {
        ProfileModel e = authorBlockDataImpl.m5490e();
        return (e == null || e.mo313g() == null || e.mo313g().d() == null) ? false : true;
    }

    private static RichText m6784a(Context context, String str) {
        RichTextBuilder richTextBuilder = new RichTextBuilder(context);
        richTextBuilder.f5636d = str;
        return richTextBuilder.m5441a(2131626003).m5444a(RichDocumentTextType.BYLINE).m5446a();
    }

    private static String m6785a(Context context, long j, GraphQLDocumentDateStyle graphQLDocumentDateStyle) {
        int i;
        Locale locale = context.getResources().getConfiguration().locale;
        switch (C07241.f6400a[graphQLDocumentDateStyle.ordinal()]) {
            case 1:
                i = 65560;
                break;
            case 2:
                i = 65556;
                break;
            case 3:
                i = 84497;
                break;
            case 4:
                i = 65536;
                break;
            case 5:
                i = 18961;
                break;
            case 6:
                i = 65540;
                break;
            case 7:
                i = 84501;
                break;
            case 8:
                i = 4;
                break;
            default:
                return null;
        }
        return DateUtils.formatDateTime(context, j, i).toUpperCase(locale);
    }
}

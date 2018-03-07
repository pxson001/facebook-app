package com.facebook.timeline.aboutpage;

import com.facebook.base.activity.FragmentChromeActivity;
import com.facebook.common.fblinks.FBLinks;
import com.facebook.common.fragmentconstants.FragmentConstants.ContentFragmentType;
import com.facebook.common.stringformat.StringFormatUtil;
import com.facebook.common.uri.UriIntentBuilder;
import com.facebook.common.uri.UriMapPattern;
import com.facebook.common.util.StringUtil;
import com.facebook.graphql.enums.GraphQLTimelineAppCollectionStyle;
import com.facebook.graphql.enums.GraphQLTimelineAppSectionType;
import com.facebook.timeline.aboutpage.protocol.CollectionsHelperGraphQLInterfaces.CollectionsNodeIdFields;
import com.facebook.timeline.aboutpage.protocol.FetchTimelineCollectionItemsGraphQLInterfaces.CollectionWithItemsAndSuggestions;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
@UriMapPattern
/* compiled from: NNF_PermalinkNotificationLoad */
public class CollectionsUriIntentBuilder extends UriIntentBuilder {
    private static volatile CollectionsUriIntentBuilder f13019a;

    public static com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder m13782a(@javax.annotation.Nullable com.facebook.inject.InjectorLike r5) {
        /* JADX: method processing error */
/*
Error: jadx.core.utils.exceptions.JadxRuntimeException: Can't find immediate dominator for block B:24:0x003a in {17, 19, 21, 23, 26, 28} preds:[]
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.computeDominators(BlockProcessor.java:129)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.processBlocksTree(BlockProcessor.java:48)
	at jadx.core.dex.visitors.blocksmaker.BlockProcessor.rerun(BlockProcessor.java:44)
	at jadx.core.dex.visitors.blocksmaker.BlockFinallyExtract.visit(BlockFinallyExtract.java:57)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JadxDecompiler$1.run(JadxDecompiler.java:199)
*/
        /*
        r0 = f13019a;
        if (r0 != 0) goto L_0x0031;
    L_0x0004:
        r1 = com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder.class;
        monitor-enter(r1);
        r0 = f13019a;	 Catch:{ all -> 0x0039 }
        if (r0 != 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000b:
        if (r5 == 0) goto L_0x0030;	 Catch:{ all -> 0x0039 }
    L_0x000d:
        r2 = com.facebook.inject.ScopeSet.a();	 Catch:{ all -> 0x0039 }
        r3 = r2.b();	 Catch:{ all -> 0x0039 }
        r0 = com.facebook.inject.SingletonScope.class;	 Catch:{ all -> 0x0039 }
        r0 = r5.getInstance(r0);	 Catch:{ all -> 0x0039 }
        r0 = (com.facebook.inject.SingletonScope) r0;	 Catch:{ all -> 0x0039 }
        r4 = r0.enterScope();	 Catch:{ all -> 0x0039 }
        r5.getApplicationInjector();	 Catch:{ all -> 0x0034 }
        r0 = m13785b();	 Catch:{ all -> 0x0034 }
        f13019a = r0;	 Catch:{ all -> 0x0034 }
        com.facebook.inject.SingletonScope.a(r4);
        r2.c(r3);
    L_0x0030:
        monitor-exit(r1);	 Catch:{  }
    L_0x0031:
        r0 = f13019a;
        return r0;
    L_0x0034:
        r0 = move-exception;
        com.facebook.inject.SingletonScope.a(r4);	 Catch:{ all -> 0x0034 }
        throw r0;	 Catch:{ all -> 0x0034 }
    L_0x0039:
        r0 = move-exception;
        r2.c(r3);	 Catch:{ all -> 0x0039 }
        throw r0;	 Catch:{ all -> 0x0039 }
    L_0x003e:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0039 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder.a(com.facebook.inject.InjectorLike):com.facebook.timeline.aboutpage.CollectionsUriIntentBuilder");
    }

    private static CollectionsUriIntentBuilder m13785b() {
        return new CollectionsUriIntentBuilder();
    }

    @Inject
    public CollectionsUriIntentBuilder() {
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("profile/{%s}/info/inner"), "com.facebook.katana.profile.id"), FragmentChromeActivity.class, ContentFragmentType.COLLECTIONS_SUMMARY_FRAGMENT.ordinal(), null);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("app_section/{%s}/{%s}"), "com.facebook.katana.profile.id", "section_id"), FragmentChromeActivity.class, ContentFragmentType.COLLECTIONS_SECTION_FRAGMENT.ordinal(), null);
        a(StringFormatUtil.formatStrLocaleSafe(FBLinks.a("collection/{%s}/{%s}/{%s}"), "com.facebook.katana.profile.id", "section_id", "collection_id"), FragmentChromeActivity.class, ContentFragmentType.COLLECTIONS_COLLECTION_FRAGMENT.ordinal());
    }

    public final String m13786a(CollectionWithItemsAndSuggestions collectionWithItemsAndSuggestions, @Nullable GraphQLTimelineAppSectionType graphQLTimelineAppSectionType, GraphQLTimelineAppCollectionStyle graphQLTimelineAppCollectionStyle) {
        if (graphQLTimelineAppCollectionStyle.equals(GraphQLTimelineAppCollectionStyle.ABOUT)) {
            if (collectionWithItemsAndSuggestions.mo397b() != null) {
                return collectionWithItemsAndSuggestions.mo397b();
            }
            return null;
        } else if (!collectionWithItemsAndSuggestions.mo399n() || !graphQLTimelineAppCollectionStyle.equals(GraphQLTimelineAppCollectionStyle.LIST)) {
            return null;
        } else {
            Object obj = null;
            if (!(graphQLTimelineAppSectionType == null || Strings.isNullOrEmpty(collectionWithItemsAndSuggestions.mo397b()) || (graphQLTimelineAppSectionType != GraphQLTimelineAppSectionType.MOVIES && graphQLTimelineAppSectionType != GraphQLTimelineAppSectionType.BOOKS && graphQLTimelineAppSectionType != GraphQLTimelineAppSectionType.TV_SHOWS && graphQLTimelineAppSectionType != GraphQLTimelineAppSectionType.MUSIC))) {
                obj = 1;
            }
            if (obj != null) {
                return collectionWithItemsAndSuggestions.mo397b();
            }
            return null;
        }
    }

    public static String m13783a(CollectionsNodeIdFields collectionsNodeIdFields, String str, String str2) {
        return m13784a(str, str2, collectionsNodeIdFields.mo395c());
    }

    public static String m13784a(String str, String str2, String str3) {
        boolean z;
        if (StringUtil.a(str)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (StringUtil.a(str2)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        if (StringUtil.a(str3)) {
            z = false;
        } else {
            z = true;
        }
        Preconditions.checkArgument(z);
        return StringFormatUtil.a(FBLinks.dg, new Object[]{str, str2, str3});
    }
}

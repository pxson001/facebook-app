package com.facebook.messaging.photoreminders;

import android.content.res.Resources;
import com.facebook.common.android.ResourcesMethodAutoProvider;
import com.facebook.common.callercontext.CallerContext;
import com.facebook.common.executors.AndroidThreadUtil;
import com.facebook.common.executors.DefaultAndroidThreadUtil;
import com.facebook.common.executors.ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider;
import com.facebook.common.i18n.I18nJoiner;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.messaging.database.handlers.DbFetchThreadUsersHandler;
import com.facebook.messaging.database.handlers.DbInsertThreadUsersHandler;
import com.facebook.messaging.graphql.fetch.GQLUserConverter;
import com.facebook.messaging.graphql.fetch.GQLUserRequestHelper;
import com.facebook.user.cache.UserCache;
import com.google.common.util.concurrent.ListeningExecutorService;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: registration_used_saved_form_data */
public class PhotoRemindersStringUtil {
    private static final String f3540a = PhotoRemindersStringUtil.class.getSimpleName();
    private static final CallerContext f3541b = CallerContext.a(PhotoRemindersStringUtil.class);
    private final Resources f3542c;
    private final I18nJoiner f3543d;
    private final GQLUserConverter f3544e;
    private final GQLUserRequestHelper f3545f;
    private final GraphQLQueryExecutor f3546g;
    private final DbInsertThreadUsersHandler f3547h;
    private final DbFetchThreadUsersHandler f3548i;
    private final ListeningExecutorService f3549j;
    private final DefaultAndroidThreadUtil f3550k;
    private final Provider<UserCache> f3551l;

    private static PhotoRemindersStringUtil m3399b(InjectorLike injectorLike) {
        return new PhotoRemindersStringUtil(ResourcesMethodAutoProvider.a(injectorLike), I18nJoiner.b(injectorLike), GQLUserConverter.a(injectorLike), GQLUserRequestHelper.b(injectorLike), GraphQLQueryExecutor.a(injectorLike), DbInsertThreadUsersHandler.a(injectorLike), DbFetchThreadUsersHandler.a(injectorLike), ListeningExecutorService_DefaultExecutorServiceMethodAutoProvider.a(injectorLike), DefaultAndroidThreadUtil.b(injectorLike), IdBasedProvider.a(injectorLike, 3593));
    }

    @Inject
    public PhotoRemindersStringUtil(Resources resources, I18nJoiner i18nJoiner, GQLUserConverter gQLUserConverter, GQLUserRequestHelper gQLUserRequestHelper, GraphQLQueryExecutor graphQLQueryExecutor, DbInsertThreadUsersHandler dbInsertThreadUsersHandler, DbFetchThreadUsersHandler dbFetchThreadUsersHandler, ListeningExecutorService listeningExecutorService, AndroidThreadUtil androidThreadUtil, Provider<UserCache> provider) {
        this.f3542c = resources;
        this.f3543d = i18nJoiner;
        this.f3544e = gQLUserConverter;
        this.f3545f = gQLUserRequestHelper;
        this.f3546g = graphQLQueryExecutor;
        this.f3547h = dbInsertThreadUsersHandler;
        this.f3548i = dbFetchThreadUsersHandler;
        this.f3549j = listeningExecutorService;
        this.f3550k = androidThreadUtil;
        this.f3551l = provider;
    }
}

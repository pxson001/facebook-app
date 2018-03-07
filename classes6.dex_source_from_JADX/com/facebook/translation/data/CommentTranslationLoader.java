package com.facebook.translation.data;

import com.facebook.api.graphql.commenttranslation.FetchCommentTranslationGraphQL.TranslatedCommentBodyString;
import com.facebook.api.graphql.commenttranslation.FetchCommentTranslationGraphQLModels.TranslatedCommentBodyModel;
import com.facebook.common.errorreporting.AbstractFbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporter;
import com.facebook.common.errorreporting.FbErrorReporterImpl;
import com.facebook.common.futures.AbstractDisposableFutureCallback;
import com.facebook.graphql.executor.GraphQLQueryExecutor;
import com.facebook.graphql.executor.GraphQLRequest;
import com.facebook.graphql.query.GraphQlQueryString;
import com.facebook.graphql.querybuilder.common.TextWithEntitiesGraphQLModels.DefaultTextWithEntitiesLongFieldsModel;
import com.facebook.inject.IdBasedProvider;
import com.facebook.inject.InjectorLike;
import com.facebook.translation.cache.CommentTranslationCache;
import com.facebook.translation.ui.TranslatableView;
import com.facebook.ui.futures.TasksManager;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.Callables;
import com.google.common.util.concurrent.ListenableFuture;
import javax.inject.Inject;
import javax.inject.Provider;

/* compiled from: data4 */
public class CommentTranslationLoader {
    private Provider<Boolean> f17949a;
    public CommentTranslationCache f17950b;
    private GraphQLQueryExecutor f17951c;
    private TasksManager<String> f17952d;
    private AbstractFbErrorReporter f17953e;

    public static CommentTranslationLoader m26476b(InjectorLike injectorLike) {
        return new CommentTranslationLoader(IdBasedProvider.a(injectorLike, 4354), CommentTranslationCache.m26471a(injectorLike), GraphQLQueryExecutor.a(injectorLike), TasksManager.b(injectorLike), (AbstractFbErrorReporter) FbErrorReporterImpl.a(injectorLike));
    }

    @Inject
    public CommentTranslationLoader(Provider<Boolean> provider, CommentTranslationCache commentTranslationCache, GraphQLQueryExecutor graphQLQueryExecutor, TasksManager tasksManager, FbErrorReporter fbErrorReporter) {
        this.f17949a = provider;
        this.f17950b = commentTranslationCache;
        this.f17951c = graphQLQueryExecutor;
        this.f17952d = tasksManager;
        this.f17953e = fbErrorReporter;
    }

    public static CommentTranslationLoader m26474a(InjectorLike injectorLike) {
        return m26476b(injectorLike);
    }

    public final void m26477a(final String str, final TranslatableView translatableView) {
        if (str != null && ((Boolean) this.f17949a.get()).booleanValue()) {
            Object obj;
            if (this.f17950b.f17945b.a(str) != null) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                translatableView.m26488a((DefaultTextWithEntitiesLongFieldsModel) this.f17950b.f17945b.a(str));
                return;
            }
            GraphQlQueryString translatedCommentBodyString = new TranslatedCommentBodyString();
            translatedCommentBodyString.a("comment_id", str);
            ListenableFuture a = GraphQLQueryExecutor.a(this.f17951c.a(GraphQLRequest.a(translatedCommentBodyString)));
            this.f17952d.a("fetch_comment_translation_" + str, Callables.a(a), new AbstractDisposableFutureCallback<TranslatedCommentBodyModel>(this) {
                final /* synthetic */ CommentTranslationLoader f17948c;

                protected final void m26472a(Object obj) {
                    TranslatedCommentBodyModel translatedCommentBodyModel = (TranslatedCommentBodyModel) obj;
                    if (translatedCommentBodyModel == null || translatedCommentBodyModel.m10290j() == null) {
                        CommentTranslationLoader.m26475a(this.f17948c, new NullPointerException("Null comment translation"), translatableView);
                        return;
                    }
                    DefaultTextWithEntitiesLongFieldsModel j = translatedCommentBodyModel.m10290j();
                    translatableView.m26488a(j);
                    CommentTranslationCache commentTranslationCache = this.f17948c.f17950b;
                    String str = str;
                    if (!Strings.isNullOrEmpty(str)) {
                        commentTranslationCache.f17945b.a(str, j);
                    }
                }

                protected final void m26473a(Throwable th) {
                    CommentTranslationLoader.m26475a(this.f17948c, th, translatableView);
                }
            });
        }
    }

    public static void m26475a(CommentTranslationLoader commentTranslationLoader, Throwable th, TranslatableView translatableView) {
        commentTranslationLoader.f17953e.a("FetchCommentTranslationFailed", th);
        translatableView.m26487a();
    }
}

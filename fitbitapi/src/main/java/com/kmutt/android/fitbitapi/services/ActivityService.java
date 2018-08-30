package com.kmutt.android.fitbitapi.services;

import android.app.Activity;
        import android.content.Loader;
import android.support.annotation.RestrictTo;

import com.kmutt.android.fitbitapi.exception.MissingScopesException;
import com.kmutt.android.fitbitapi.exception.TokenExpiredException;
import com.kmutt.android.fitbitapi.loaders.ResourceLoaderFactory;
import com.kmutt.android.fitbitapi.loaders.ResourceLoaderResult;
import com.kmutt.android.fitbitapi.models.DailyActivitySummary;

import java.text.DateFormat;
        import java.text.SimpleDateFormat;
        import java.util.Date;
        import java.util.Locale;

public class ActivityService {

    private final static String ACTIVITIES_URL = "https://api.fitbit.com/1/user/-/activities/date/%s.json";
    private static final ResourceLoaderFactory<DailyActivitySummary> USER_ACTIVITIES_LOADER_FACTORY = new ResourceLoaderFactory<>(ACTIVITIES_URL, DailyActivitySummary.class);
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static Loader<ResourceLoaderResult<DailyActivitySummary>> getDailyActivitySummaryLoader(Activity activityContext, Date date) throws MissingScopesException, TokenExpiredException {
        return USER_ACTIVITIES_LOADER_FACTORY.newResourceLoader(activityContext, new Scope[]{RestrictTo.Scope.activity}, dateFormat.format(date));
    }

}

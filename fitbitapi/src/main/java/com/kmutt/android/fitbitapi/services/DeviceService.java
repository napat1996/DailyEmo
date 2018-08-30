package com.kmutt.android.fitbitapi.services;

import android.app.Activity;
import android.content.Loader;

import com.kmutt.android.fitbitapi.exception.MissingScopesException;
import com.kmutt.android.fitbitapi.exception.TokenExpiredException;
import com.kmutt.android.fitbitapi.loaders.ResourceLoaderFactory;
import com.kmutt.android.fitbitapi.loaders.ResourceLoaderResult;
import com.kmutt.android.fitbitapi.models.Device;

public class DeviceService {

    private final static String DEVICE_URL = "https://api.fitbit.com/1/user/-/devices.json";
    private static final ResourceLoaderFactory<Device[]> USER_DEVICES_LOADER_FACTORY = new ResourceLoaderFactory<>
            (DEVICE_URL, Device[].class);

    public static Loader<ResourceLoaderResult<Device[]>> getUserDevicesLoader(Activity activityContext)
            throws MissingScopesException, TokenExpiredException {
        return USER_DEVICES_LOADER_FACTORY.newResourceLoader(activityContext, new Scop[]{Scope.settings});
    }

}

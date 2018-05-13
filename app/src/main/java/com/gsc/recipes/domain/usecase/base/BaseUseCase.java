package com.gsc.recipes.domain.usecase.base;

import android.os.Handler;
import android.os.Looper;


public abstract class BaseUseCase<Param, Callback> {

    public void execute(Param param, Callback callback) {
        new Thread(() -> getData(param, callback)).start();
    }


    protected abstract void getData(Param param, Callback callback);


    public void toMainThread(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }


    public interface Callback<Result> {
        void onSuccess(Result result);
        void onError();
    }
}

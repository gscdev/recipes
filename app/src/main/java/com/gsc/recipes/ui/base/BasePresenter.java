package com.gsc.recipes.ui.base;

public abstract class BasePresenter<T extends BasePresenter.View> {

    private T view;

    public void setView(T view) {
        this.view = view;
    }

    public T getView() {
        return view;
    }


    public abstract void create();

    public void destroy() {
        view = null;
    }


    public interface View {
    }
}

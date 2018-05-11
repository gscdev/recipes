package com.gsc.recipes.ui.base;

public class BasePresenter<T extends BasePresenter.View> {

    private T view;

    public void setView(T view) {
        this.view = view;
    }

    public T getView() {
        return view;
    }

    public void destroy() {
        view = null;
    }


    public interface View {
    }
}

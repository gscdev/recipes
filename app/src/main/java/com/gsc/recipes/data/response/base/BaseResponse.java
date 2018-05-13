package com.gsc.recipes.data.response.base;

import com.google.gson.annotations.SerializedName;

public class BaseResponse {

    @SerializedName("title")
    public String title;
    @SerializedName("version")
    public Float version;
    @SerializedName("href")
    public String href;
}

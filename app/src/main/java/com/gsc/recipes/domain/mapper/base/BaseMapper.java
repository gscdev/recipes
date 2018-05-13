package com.gsc.recipes.domain.mapper.base;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;


public abstract class BaseMapper<From, To> {

    public abstract To map(From fromItem);


    public List<To> map(List<From> fromList) {
        List<To> toList;

        if (fromList == null) {
            toList = emptyList();
        } else {
            toList = new ArrayList<>(fromList.size());

            for (From fromItem : fromList) {
                toList.add(map(fromItem));
            }
        }

        return toList;
    }
}
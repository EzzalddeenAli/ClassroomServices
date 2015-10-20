/**
 * COPYRIGHT (C) 2013 KonyLabs. All Rights Reserved.
 * 
 * @author rbanking
 */
package com.abharana.services.facade.dto;

import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

public class ListConverter {

    /**
     * Returns an immutable list that applies function to each element of
     * fromList.
     * 
     * @param <F>
     *            the generic type
     * @param <T>
     *            the generic type
     * @param fromList
     *            the from list
     * @param function
     *            the function
     * @return an immutable list containing the given elements
     */
    public static <F, T> List<T> transform(List<F> fromList,
            Function<? super F, ? extends T> function) {
        return ImmutableList.copyOf(Lists.transform(fromList, function));
    }
}

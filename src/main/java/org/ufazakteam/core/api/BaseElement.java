package org.ufazakteam.core.api;

import org.ufazakteam.utils.enums.ElementType;

import java.util.List;

/**
 * Created by Toktar on 14.04.2018.
 */
public abstract class BaseElement<T> {

    protected T data;
    protected ElementType type;
    protected BaseElement<T> parent;
    protected List<BaseElement<T>> children;

}

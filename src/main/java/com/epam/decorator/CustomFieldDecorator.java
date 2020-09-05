package com.epam.decorator;

import java.lang.reflect.Field;

import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.DefaultFieldDecorator;
import org.openqa.selenium.support.pagefactory.ElementLocator;

public class CustomFieldDecorator extends DefaultFieldDecorator {

    public CustomFieldDecorator(SearchContext searchContext) {
        super(new DefaultElementLocatorFactory(searchContext));
    }

    /**
     * Method is called by factory for every field in class
     */
    @Override
    public Object decorate(ClassLoader loader, Field field) {
        Class<?> decoratableClass = decoratableClass(field);
        // if field class is decoratable
        if (decoratableClass != null) {
            ElementLocator locator = factory.createLocator(field);
            if (locator == null) {
                return null;
            }

            // элемент
            return createElement(loader, locator, decoratableClass);
        }
        return null;
    }

    /**
     * Returns decoratable class for field. Or null if class is not suitable for decorator
     */
    private Class<?> decoratableClass(Field field) {

        Class<?> clazz = field.getType();

        // Element has to have a constructor with WebElement as a parameter
        try {
            clazz.getConstructor(WebElement.class);
        } catch (Exception e) {
            return null;
        }

        return clazz;
    }

    /**
     * Creation of an element. Finding WebElement and sending it to a custom class
     */
    protected <T> T createElement(ClassLoader loader,
                                  ElementLocator locator, Class<T> clazz) {
        WebElement proxy = proxyForLocator(loader, locator);
        return createInstance(clazz, proxy);
    }

    /**
     * Creating class instance by calling a constructor with WebElement as an argument
     */
    private <T> T createInstance(Class<T> clazz, WebElement element) {
        try {
            return (T) clazz.getConstructor(WebElement.class)
                    .newInstance(element);
        } catch (Exception e) {
            throw new AssertionError(
                    "WebElement can't be represented as " + clazz
            );
        }
    }
}

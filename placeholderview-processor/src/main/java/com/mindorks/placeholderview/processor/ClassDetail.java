package com.mindorks.placeholderview.processor;

import com.squareup.javapoet.ClassName;

import java.util.List;

import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;

/**
 * Created by janisharali on 26/02/18.
 */

public class ClassDetail {
    private TypeElement typeElement;
    private String packageName;
    private String typeName;
    private ClassName className;
    private ClassName generatedClassName;
    private ClassName superClassName;
    private ClassName androidViewClassName;
    private ClassName androidOnClickListenerClassName;
    private ClassName androidOnLongClickListenerClassName;
    private List<VariableElement> variableElements;
    private List<ExecutableElement> executableElements;

    protected ClassDetail(TypeElement typeElement, String packageName,
                          String baseClassName, String generatedClassNameSuffix) {
        this.typeElement = typeElement;
        this.packageName = packageName;
        typeName = typeElement.getSimpleName().toString();

        className = ClassName.get(packageName, typeName);

        generatedClassName = ClassName.get(
                packageName,
                typeName + generatedClassNameSuffix);

        superClassName = ClassName.get(
                NameStore.Package.PLACE_HOLDER_VIEW,
                baseClassName);

        androidViewClassName = ClassName.get(
                NameStore.Package.ANDROID_VIEW,
                NameStore.Class.ANDROID_VIEW);

        androidOnClickListenerClassName = ClassName.get(
                NameStore.Package.ANDROID_VIEW,
                NameStore.Class.ANDROID_VIEW,
                NameStore.Class.ANDROID_VIEW_ON_CLICK_LISTENER);

        androidOnLongClickListenerClassName = ClassName.get(
                NameStore.Package.ANDROID_VIEW,
                NameStore.Class.ANDROID_VIEW,
                NameStore.Class.ANDROID_VIEW_ON_LONG_CLICK_LISTENER);

        variableElements = ElementFilter.fieldsIn(typeElement.getEnclosedElements());
        executableElements = ElementFilter.methodsIn(typeElement.getEnclosedElements());
    }

    public TypeElement getTypeElement() {
        return typeElement;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getTypeName() {
        return typeName;
    }

    public ClassName getClassName() {
        return className;
    }

    public ClassName getGeneratedClassName() {
        return generatedClassName;
    }

    public ClassName getSuperClassName() {
        return superClassName;
    }

    public ClassName getAndroidViewClassName() {
        return androidViewClassName;
    }

    public List<VariableElement> getVariableElements() {
        return variableElements;
    }

    public List<ExecutableElement> getExecutableElements() {
        return executableElements;
    }

    public ClassName getAndroidOnClickListenerClassName() {
        return androidOnClickListenerClassName;
    }

    public ClassName getAndroidOnLongClickListenerClassName() {
        return androidOnLongClickListenerClassName;
    }
}
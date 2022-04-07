package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithDependencyImpl implements MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependencyImpl(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int numero = 1;
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde la implentacion con un bean con dependencia");
    }
}

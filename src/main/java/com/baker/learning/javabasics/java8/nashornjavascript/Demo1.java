package com.baker.learning.javabasics.java8.nashornjavascript;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @description java 执行 js
 * js 执行 java
 * @date 2019/12/31 9:07
 */
public class Demo1 {

    public static void main(String[] args) {

        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine nashorn = scriptEngineManager.getEngineByName("nashorn");

        String name = "demo";

        try {
            nashorn.eval("print('" + name + "')");
            System.out.println(nashorn.eval("1+1"));
        } catch (ScriptException e) {
            e.printStackTrace();
        }

    }
}

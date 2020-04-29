package com.baker.learning.javabasics.math;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * @description 在需要精确的小数计算时再使用BigDecimal，BigDecimal的性能比double和float差，在处理庞大，复杂的运算时尤为明显。故一般精度的计算没必要使用BigDecimal。
 * 尽量使用参数类型为String的构造函数。
 *  BigDecimal都是不可变的（immutable）的， 在进行每一次四则运算时，都会产生一个新的对象 ，所以在做加减乘除运算时要记得要保存操作后的值。
 * @date 2020/4/18 12:09
 */
public class TestBigDecimal {

    /**
     * add(BigDecimal)            BigDecimal对象中的值相加，然后返回这个对象。
     * subtract(BigDecimal)    BigDecimal对象中的值相减，然后返回这个对象。
     * multiply(BigDecimal)    BigDecimal对象中的值相乘，然后返回这个对象。
     * divide(BigDecimal)        BigDecimal对象中的值相除，然后返回这个对象。
     * toString()                         将BigDecimal对象的数值转换成字符串。
     * doubleValue()                 将BigDecimal对象中的值以双精度数返回。
     * floatValue()                     将BigDecimal对象中的值以单精度数返回。
     * longValue()                     将BigDecimal对象中的值以长整数返回。
     * intValue()                       将BigDecimal对象中的值以整数返回。
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(0.999 + 0.1111111111111);
        BigDecimal bigDecimal = new BigDecimal("0.999");
        System.out.println(bigDecimal.add(new BigDecimal("0.1111111111111")).doubleValue());
        System.out.println(bigDecimal.multiply(new BigDecimal("0.1111111111111")).doubleValue());
        System.out.println(bigDecimal.multiply(new BigDecimal("0.1111111111111")).toString());
        System.out.println(bigDecimal.multiply(new BigDecimal("0.1111111111111")).toEngineeringString());
        System.out.println(bigDecimal.multiply(new BigDecimal("0.1111111111111")).toPlainString());
        System.out.println(bigDecimal.multiply(new BigDecimal("0.1111111111111")).toBigInteger());
        //除法保留2位小数   四舍五入
        System.out.println(bigDecimal.divide(new BigDecimal("0.1111111111111"), 2, BigDecimal.ROUND_HALF_UP).doubleValue());
        System.out.println(bigDecimal.divide(new BigDecimal("0.1111111111111"), 2, BigDecimal.ROUND_HALF_UP).toBigInteger());

        System.out.println("===========结合 NumberFormat ==============");
//        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance();
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.CHINA);//货币单位，不指定默认当前系统环境
        NumberFormat percentInstance = NumberFormat.getPercentInstance();
        //最大取百分比小数点后的几位数字，四舍五入
        percentInstance.setMaximumFractionDigits(2);

        BigDecimal loanAmount = new BigDecimal("15000.48"); //贷款金额
        BigDecimal interestRate = new BigDecimal("0.00018"); //利率
        BigDecimal interest = loanAmount.multiply(interestRate); //相乘
        System.out.println("贷款金额:\t" + currencyInstance.format(loanAmount));
        System.out.println("利率:\t" + percentInstance.format(interestRate));
        System.out.println("利息:\t" + currencyInstance.format(interest));


    }
}

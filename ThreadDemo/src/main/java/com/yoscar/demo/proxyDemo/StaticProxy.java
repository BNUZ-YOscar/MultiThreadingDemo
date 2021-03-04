package com.yoscar.demo.proxyDemo;


// 静态代理模式总结：
// 真是对象和代理对象都要实现同一个接口
// 代理对象要代理真实角色，就可以调用真实对象的代理方法

// 代理对象可以替真实对象做复杂的事情，真实对象只需要专注本身业务
public class StaticProxy {

    public static void main(String[] args) {
        WeddingCompany weddingCompany = new WeddingCompany(new You());
        weddingCompany.HappyMarry();
    }
}

interface Marry {

    void HappyMarry();
}

// 真实角色
class You implements Marry {
    public void HappyMarry() {
        System.out.println("1号结婚");
    }
}

// 代理角色
class WeddingCompany implements Marry {

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }


    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void before() {
        System.out.println("婚前布置");
    }

    private void after() {
        System.out.println("婚后布置");
    }

}

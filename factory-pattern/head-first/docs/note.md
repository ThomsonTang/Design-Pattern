# Factory Pattern 烘烤OO的精华

> 当看到`new`, 就会想到**"具体"**  

先看如下代码片段,有何问题?

```java
Duck duck;
if (picnic) {
duck = new MallardDuck();
} else if (hunting) {
duck = new DecoyDuck();
} else if (inBathTub) {
duck = new RubberDuck();
}
```
以上代码包含了许多**不同的鸭子类**，但是**直到代码运行时**，才能知道应该实例化哪一个具体的类。一旦有变化或者扩展，那么就的重新检查和修改这段代码。  

> 针对接口编程，可以隔离掉以后系统可能发生的一大堆改变。如果代码是针对接口而写，那么通过**多态**，它可以与任何新类实现该接口。

解决方案：利用**第一个原则**（对扩展开发，对修改关闭），**找出会变化的方面，把他们从不变的部分分离出来**。

## 识别变化的方面

```java
Pizza orderPizza() {
  Pizza pizza = new Pizza();

  pizza.prepare();
  pizza.bake();
  pizza.cut();
  pizza.box();
  return pizza;
}
```
为了让系统有**弹性**，`Pizza pizza = new Pizza()`最好实现为**抽象类**或**接口**。但是如此一来，却又不能直接实例化了。

## 增加披萨类型, 区分哪些会改变，哪些不会改变

```java
Pizza orderPizza(String type) {
  Pizza pizza;

  if ("cheese".equals(type)) {
    pizza = new CheesePizza();
  } else if ("greek".equals(type)) {
    pizza = new GreekPizza();
  }

  pizza.prepare();
  pizza.bake();
  pizza.cut();
  pizza.box();
  return pizza;
}
```
根据pizza的类型，我们实例化正确的具体类，之后赋值给实例变量。但是随着需求的深入和用户的使用习惯，我们可能会有更多的**披萨类型**，或者会移除最近行情不稳的披萨类型。

```java
Pizza orderPizza(String type) {
  Pizza pizza;

  //这是变化的部分，随着时间会一改再改，例如增加更多的披萨类型
  if ("cheese".equals(type)) {
    pizza = new CheesePizza();
  } else if ("greek".equals(type)) {
    pizza = new GreekPizza();
  } else if ("clam".equals(type)) {
    pizza = new ClamPizza;
  }

  //这是不变化的部分
  pizza.prepare();
  pizza.bake();
  pizza.cut();
  pizza.box();
  return pizza;
}
```
那么可以将**变化的**与**不变化的**部分区分开，并使用**封装**

## 封装创建对象的代码
当区分开**改变**与**不改变**之后，我们就可以**使用封装将变化的部分移到`orderPizza()`方法之外，而用一个专职的新对象来创建披萨**。这个新对象只管如何创建披萨，只要任何对象想创建披萨，那么找这个新对象就可以了。

> 我们将这个新对象称之为**工厂**。工厂处理创建对象的细节。

如下，创建一个简单的披萨工厂：

```java
public class SimplePizzaFactory {
  public Pizza createPizza(String type) {
    Pizza pizza = null;
    if ("cheese".equals(type)) {
      pizza = new CheesePizza();
    } else if ("greek".equals(type)) {
      pizza = new GreekPizza();
    } else if ("clam".equals(type)) {
      pizza = new ClamPizza;
    }
    return pizza;
  }
}
```

## 关于静态工厂
还有一种比较常见的技巧是将**创建新对象的方法**声明为`static`的。这样就省去了创建简单工厂对象实例的过程。称之为**静态工厂方法**。但是需要注意的是，静态工厂也有它自己的缺点，例如无法通过继承来改变创建方法的行为。

```java
public class SimpleStaticPizzaFactory {
  public static Pizza createPizza(String type) {
    // 同上
    ......
  }
}
```

## 重构客户端代码PizzaStore
创建好**工厂**之后，我们就可以修改客户端的代码了，我们要做的就是**让工厂为我们创造出Pizza**。如下代码：

```java
public class PizzaStore {
  private SimplePizzaFactory factory;

  //这里通过构造方法注入依赖的SimplePizzaFactory
  public PizzaStore(SimplePizzaFactory factory) {
    this.factory = factory;
  }

  public Pizza orderPizza(String type) {
    // 此处调用工厂方法来创建Pizza
    Pizza pizza = factory.createPizza(type);

    // 其他统一的流程工序
    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();
    return pizza;
  }
}
```

## 为PizzaStore授权经营分店
假设PizzaStore可以授权在不同地域经营分店，每个分店的pizza拥有当地的特色口味，那么该如何实现呢？

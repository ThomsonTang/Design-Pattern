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

## 重构PizzaStore类
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

## 给PizzaStore授权经营加盟店
假设PizzaStore可以授权在不同地域经营加盟店，并且每个加盟店做出的pizza拥有当地的特色口味，那么该如何实现呢？

### 为每个加盟店创建一个对应的工厂
鉴于前面例子中`PizzaStore`和`SimplePizzaFactory`的组合，我们考虑到可以**创建不同地域的PizzaFactory**，然后选择合适的Factory，再与PizzaStore组合，最终完成一个加盟店的功能。可能的代码实现如下：

```java
NYSimplePizzaFactory nySimplePizzaFactory = new NYSimplePizzaFactory();
PizzaStore nyPizzaStore = new PizzaStore(nySimplePizzaFactory);
nyPizzaStore.orderPizza("cheese");

ChicagoPizzaFactory chicagoPizzaFactory = new ChicagoPizzaFactory();
PizzaStore chicagoPizzaStore = new PizzaStore(chicagoPizzaStore);
chicagoPizzaStore.orderPizza("cheese");
```
这种做法保证了加盟店是采用我们创建的工厂来制作pizza，但是对于订单的其他流程他们可能会采用自己的方式，比如某些加盟店烘烤的时间可能会短一些，或者忘记切块，或者使用不同的包装等。例如有人可能会创建如下所述的一个`TexasPizzaStore`：

```java
public class TexasPizzaStore {
  SimplePizzaFactory factory;
  public Pizza orderPizza(String type) {
    Pizza pizza = factory.createPizza(type);

    pizza.prepare();
    //可能会烘烤两次
    pizza.bake();
    pizza.bake();

    //或者可能会取消切块
    //pizza.cut();

    pizza.box();

    return pizza;
  }
}
```
也就是说在这种情况下，我们无法控制加盟店在制作流程上的质量，我们希望能够对质量也做到把关。

### 让每个加盟店作为子类来自己创建风味披萨
仔细思考一下之前的问题，我们真正的需求无非就是**创建一套机制，能够将加盟店和创建Pizza捆绑起来的同时又保持一定的弹性**。那么如何做到这两点呢？

1. 将`createPizza()`方法放回到`PizzaStore`中，这样就将创建披萨与披萨店捆绑起来了。
2. 要保持一定的弹性，也就意味着对扩展开发，那么我们可以考虑将创建披萨的方法声明为**抽象方法**，然后为每个地域创建一个`PizzaStore`的子类来表示该加盟店。  

先来看看更改后的`PizzaStore`:

```java
public abstract class PizzaStore {
  public Pizza orderPizza(String type) {
    Pizza pizza;

    pizza = createPizza(type);

    pizza.prepare();
    pizza.bake();
    pizza.cut();
    pizza.box();

    return pizza;
  }

  abstract Pizza createPizza(String type);
}
```

由于`createPizza()`是一个抽象方法，所以`PizzaStore`作为超类也应该是抽象的。这样如果要创建一个加盟店，只需创建一个`PizzaStore`的子类即可，然后由每个子类来决定如何创建披萨。与此同时，方法`orderPizza()`是专门处理订单的，正如之前所说的，我们希望各个加盟店对于订单的处理要保持一致。

如上方法实质上是将**创建披萨的过程放在了子类中进行**，由每个子类负责定义自己的`createPizza()`方法。对于`orderPizza()`方法而言，虽然它对Pizza这个产品做了许多事情，但是Pizza对象对它来讲始终都是抽象的，它并不知道实际上是哪个具体的子类创建了披萨。当`orderPizza()`调用`createPizza()`时，会有一个PizzaStore的子类负责创建披萨。创建什么样的披萨呢？是由具体的比萨店来决定的。那么到底是哪个披萨店呢？这就只能由用户决定要哪家风味的披萨店了。

## 尝试开一家披萨店
要开加盟店，我们只需要继承`PizzaStore`，然后实现自己的`createPizza()`方法就可以了，其他的功能`PizzaStore`已为我们免费提供了。

如下我们尝试创建一个New York PizzaStore。

```java
public class NYPizzaStore extends PizzaStore {
  public Pizza createPizza(String type) {
    if (type.equals("cheese")) {
      return new NYStyleCheesePizza();
    } else if (type.equals("clam")) {
      return new NYStyleClamPizza();
    } else if (type.equals("veggie")) {
      return new NYStyleVeggiePizza();
    } else return null;
  }
}
```

同理，我们再创建一个Chicago PizzaStore:

```java
public class ChicagoPizzaStore {
  public Pizza createPizza() {
    if (type.equals("cheese")) {
      return new ChicagoStyleCheesePizza();
    } else if (type.equals("clam")) {
      return new ChicagoStyleClamPizza();
    } else if (type.equals("veggie")) {
      return new ChicagoStyleVeggiePizza();
    } else return null;
  }
}
```
以上实例中，我们定义的抽象方法`createPizza()`就是一个**工厂方法(factory method)**。

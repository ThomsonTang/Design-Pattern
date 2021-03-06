# 设计模式之依赖倒置原则DIP（Dependence Inversion Principle）

## 定义
> 1. High level modules should not depend upon low level modules. Both should depend upon **abstractions**. （高层模块不应该依赖低层模块，两者都应该依赖**抽象**。）
> 2. Abstractions should not depend upon details.（抽象不应该依赖细节。）
> 3. Details should depend upon abstractions. （细节应该依赖抽象。）

## 问题
类A（高层模块）直接依赖类B（低层模块），假如要将类A改为依赖类C（低层模块），则需要直接修改类A的代码来实现。因为类A是高层模块，一般负责较复杂的业务逻辑，如果直接修改类A的代码，就会给程序带来潜在的风险。

## 解决方案
定义一个接口I，类B和类C都实现该接口，而将类A修改为依赖接口I。这样类A是通过接口I与类B和类C发生关系，降低了类A与类B、类C的耦合度，从而也就减小了修改类A代码的几率。

依赖倒置原则是基于这样一个事实的：**相对于细节的多变性，抽象的东西要稳定的多**。换言之，以抽象为基础搭建的架构要比以细节为基础搭建的架构稳定的多。依赖倒置原则在Java中的表现是：

- 模块间的依赖通过抽象发生，实现类之间不该发生直接的依赖关系，而是通过接口或抽象类产生的。
- 接口或抽象类不依赖于实现类。
- 实现类依赖接口或抽象类。

依赖倒置原则的核心思想就是**面向接口编程**。

## 实例
下面通过司机驾驶汽车的实例来验证依赖导致原则的好处。

假设司机驾驶奔驰汽车，其场景对应的类图和代码如下：

![driver][image-1]

```java
//奔驰汽车
public class Benz {
	//汽车可以运行
	public void run() {
	System.out.println("奔驰汽车开始运行......");
	}
}
```

```java
 //司机类
public class Driver {
	//司机驾驶汽车
	public void drive(Benz benz) {
	    benz.run();
	}
}
```

```java
/**
 * DIP依赖导致原则场景类
 */
public class Client {
	public static void main(String[] args) {
	    Driver driver = new Driver();
	    Benz benz = new Benz();
	    driver.drive(benz); //司机驾驶奔驰汽车
	}
}
```

运行结果如下：
> 奔驰汽车开始运行......

假设现在需求有改动了，司机不仅能驾驶奔驰，还可以驾驶宝马汽车。那该如何实现呢？

```java
/**
 * 宝马汽车
 */
public class BMW {
	//宝马也可以运行的
	public void run() {
	    System.out.println("宝马汽车开始运行......");
	}
}
```

宝马汽车有了，可是司机的drive()方法只能接受Benz实例，也就是说司机只能驾驶奔驰，而无法驾驶宝马。显然这是不合理的，Driver和Benz的耦合关系太紧密了，导致系统的稳定性、代码的可维护性和可读性等大大降低。程序整体的设计是不合理的。

那如何解决以上问题呢？引入**依赖导致原则**看看。

1. 先来看类图的设计：

![driver2][image-2]

分别建立了两个接口，或者说抽象出来了两个接口：**IDriver**和**ICar**。分别定义了司机和汽车的核心功能：司机驾驶汽车，汽车可以运行。一个司机要驾驶汽车就必须实现**IDriver**接口；对应的，要新增一类汽车，就要实现**ICar**接口。具体的代码如下：

```java
/**
 * 汽车接口
 */
public interface ICar {
	public void run();
}
```

```java
/**
 * 司机接口
 */
public interface IDriver {
	public void drive(ICar car);
}
```

```java
/**
 * 奔驰汽车实现类
 */
public class Benz implements ICar {
	@Override public void run() {
	    System.out.println("奔驰汽车开始运行......");
	}
}
```

```java
/**
 * 司机实现类
 */
public class Driver implements IDriver {
	@Override public void drive(ICar car) {
	    car.run();
	}
}
```

```java
public class Client {
	public static void main(String[] args) {
	    IDriver driver = new Driver();
	    ICar car = new Benz(); //生成一辆奔驰车
	    driver.drive(car); 
	}
}
```

运行结果如下：
> 奔驰汽车开始运行......

我们再来看，假如司机要驾驶宝马汽车，那我们该怎么实现？

1. 宝马类**实现ICar接口**。
2. 修改场景类，生成宝马汽车实例，**直接给司机驾驶**即可。

代码如下：

```java
/**
 * 宝马汽车
 */
public class BMW implements ICar {
	@Override public void run() {
	    System.out.println("宝马汽车开始运行......");
	}
}  
```

```java
public class Client {
	public static void main(String[] args) {
	    IDriver driver = new Driver();
	    ICar car = new BMW(); //生成一辆宝马车
	    driver.drive(car);
	}
}
```

可以看出，运用依赖倒置原则后，**Driver**和**Benz**、**BMW**有了很好的解耦关系，更换驾驶汽车时再也不用修改Driver类了。由此可见，**遵循依赖倒置原则可以很好的降低类之间的耦合性，提高系统的稳定性，代码的可读性以及可维护性，也降低了修改程序带来的风险**。

采用依赖倒置原则还有一大好处就是为多人并行开发带来了极大的便利性。只要制定好相关的接口或者抽象类，即协议契约，各项目成员就可以按照该协议契约独立开始开发，而不必等待某一方完成后才能开始。

## 依赖传递的三种方式

### 1. 接口传递
以上实例使用的就是此种方法

### 2. 构造方法传递
示例代码如下：

```java
//司机接口
public interface IDriver {
	public void drive();
}
```

```java
/**
 * 司机实现类
 *
 * @author Thomson Tang
 */
public class Driver implements IDriver {
	private ICar car = null;
	
	public Driver(ICar car) {
	    this.car = car;
	}
	
	@Override public void drive() {
	    this.car.run();
	}
}
```

### 3. setter方法传递

示例代码如下：

```java
/**
 * 司机接口
 *
 * @author Thomson Tang
 */
public interface IDriver {
	public void setCar(ICar car);
	public void drive();
}
```

```java
/**
 * 司机实现类
 *
 * @author Thomson Tang
 */
public class Driver implements IDriver {
	private ICar car = null;
	
	@Override public void drive() {
	    this.car.run();
	}
	
	@Override public void setCar(ICar car) {
	    this.car = car;
	}
}
```

## 实践总结

- 每个类尽量都有接口或者抽象类，或者抽象类和接口两者皆有
- 变量的表面类型尽量是接口或者抽象类
- 任何类都不应该从具体类派生
- 尽量不要覆写基类的方法
- 充分结合里氏替换原则使用

[image-1]:	https://cloud.githubusercontent.com/assets/980216/6945382/f0f45800-d8cb-11e4-9c99-cbefe0a63069.png
[image-2]:	https://cloud.githubusercontent.com/assets/980216/6945434/4b0ed842-d8cc-11e4-9dec-24b3de63dd6c.png

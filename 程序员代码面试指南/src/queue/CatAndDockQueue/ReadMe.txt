猫狗队列要求：
（难度一颗星）
· 用户可以调用add方法将cat或dog的实例放入队列中
· 用户可以调用pollAll方法，将队列中的实例按照进队列的先后顺序依次弹出
· 用户可以调用pollDog方法，将队列中dog类的实例按照进队列的先后顺序依次弹出
· 用户可以调用pollCat方法，将队列中cat类的实例按照进队列的先后顺序依次弹出
· 用户可以调用isEmpty方法，检查队列中是否还有dog或cat的实例
· 用户可以调用isDogEmpty方法，检查队列中是否还有dog的实例
· 用户可以调用isCatEmpty方法，检查队列中是否还有cat的实例

已经给出的类：
public class Pet {
    private String type;
    public Pet(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }
}

public class Dog extends Pet {
    public Dog() {
        super("dog");
    }
}

public class Cat extends Pet {
    public Cat() {
        super("cat");
    }
}

---------------------------------------------------------
tips：
如果只用一个队列来实现的话，那可太蠢了。
更新和查找的效率低问题太严重。
比如说判断Dog（Cat）类是否为空 -> 判断个数，而不是一个个地遍历
比如说把Dog（Cat类）poll -> 直接poll，而不是一个个判断是Dog或是Cat

虽然可以保证顺序问题，但还是太蠢了
---------------------------------------------------------
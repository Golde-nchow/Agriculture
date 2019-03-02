package 程序员代码面试指南.queue.CatAndDockQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * TODO 2019/2/23 :
 *
 * @author User : Golden_chow
 */
@SuppressWarnings("all")
public class CatDogQueue {
    private Queue<PetQueue> catQueue;
    private Queue<PetQueue> dogQueue;
    private long count;

    public CatDogQueue() {
        catQueue = new LinkedList<>();
        dogQueue = new LinkedList<>();
    }

    /**
     * 添加到队列中
     * @param pet pet类实例
     */
    public void add(Pet pet) {
        if ("dog".equals(pet.getPetType())) {
            dogQueue.add(new PetQueue(pet, this.count++));
        } else if ("cat".equals(pet.getPetType())) {
            catQueue.add(new PetQueue(pet, this.count++));
        }
    }

    /**
     * 谁最先进入，就弹出谁
     */
    public Pet pollAll() {
        // 查看是否空队列
        if (!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()) {
            // 检查猫狗队列的顺序
            // 如果狗的大于猫的，就说明猫先插入队列的
            if (this.dogQueue.poll().getCount() > this.catQueue.poll().getCount()) {
                return this.catQueue.poll().getPet();
            } else {
                return this.dogQueue.poll().getPet();
            }
        } else if (!this.dogQueue.isEmpty()) {
            return this.dogQueue.poll().getPet();

        } else if (!this.catQueue.isEmpty()) {
            return this.catQueue.poll().getPet();

        } else {
            throw new RuntimeException("队列为空");
        }
    }

    /**
     * 弹出最先进入的 Dog 实例
     */
    public Dog pollDog() {
        if (!this.isDogEmpty()) {
            return (Dog) this.dogQueue.poll().getPet();
        } else {
            throw new RuntimeException("队列为空");
        }
    }

    /**
     * 弹出最先进入的 Cat 实例
     */
    public Cat pollCat() {
        if (!this.isDogEmpty()) {
            return (Cat) this.catQueue.poll().getPet();
        } else {
            throw new RuntimeException("队列为空");
        }
    }

    /**
     * 队列是否为空
     * @return 空则返回 true，不空返回 false
     */
    public boolean isEmpty() {
        return this.dogQueue.isEmpty() && this.catQueue.isEmpty();
    }

    /**
     * Dog在队列中是否为空
     * @return 空则返回 true，不空返回 false
     */
    public boolean isDogEmpty() {
        return this.dogQueue.isEmpty();
    }

    /**
     * Cat在队列中是否为空
     * @return 空则返回 true，不空返回 false
     */
    public boolean isCatEmpty() {
        return this.catQueue.isEmpty();
    }

}

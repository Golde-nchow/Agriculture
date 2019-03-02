package 程序员代码面试指南.queue.CatAndDockQueue;

/**
 * TODO 2019/2/23 :
 * 宠物队列
 * @author User : Golden_chow
 */
public class PetQueue {
    private Pet pet;
    /**
     * 用于保存整数的顺序值，因为我们使用了两个队列，但是要保证顺序的一致性
     */
    private long count;

    public PetQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return this.pet;
    }

    public long getCount() {
        return count;
    }

    public String getPetType() {
        return this.pet.getPetType();
    }
}

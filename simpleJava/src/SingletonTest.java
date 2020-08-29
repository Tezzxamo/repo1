/**
 * @author Tethamo_zzx
 * @date 2019-10-31  下午 12:15
 */
public class SingletonTest {
    public static void main(String[] args) {
        Teacher teacher1=Teacher.getTeacher();
        Teacher teacher2=Teacher.getTeacher();
        System.out.println(teacher1==teacher2);
    }
}
class Teacher{
    /**
     * 在类加载的时候初始化一次，保证是单例的原因是static
     */
    private static final Teacher teacher = new Teacher();
    private Teacher(){ }
    /**
     * 对外暴露的方法
     * @return
     */
    public static Teacher getTeacher() {
        return teacher;
    }
}
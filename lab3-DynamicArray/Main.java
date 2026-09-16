//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        DynamicArray<Integer> list = new DynamicArray<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.println("Size: " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println("Adding 7 more numbers...");
        list.add(50);
        list.add(60);
        list.add(70);
        list.add(80);
        list.add(90);
        list.add(100);
        list.add(110);
        System.out.println("Size after adding: " + list.size());
        System.out.println("Whole list:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}

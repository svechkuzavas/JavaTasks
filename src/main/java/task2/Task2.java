package task2;

public class Task2 {
    public static void main(String[] args) {
        From objectFrom = new From("From", 1);
        To objectTo = new To("To", 2);
        BeanUtils.assign(objectTo, objectFrom);
        System.out.println("Строковое поле совпадает: " + (objectFrom.getName().equals(objectTo.getName())));
        System.out.println("Числовое поле совпадает: " + (objectFrom.getNumber().equals(objectTo.getNumber())));
    }
}

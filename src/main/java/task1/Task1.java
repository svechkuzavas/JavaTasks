package task1;

import java.util.*;

public class Task1 {

    private final static String input = """
            lorem ipsum is simply 
            dummy text of the printing and 
            typysetting industry lorem ipsum has been 
            the industry standard dummy text ever 
            since the when unknown printer 
            took a galley of type and 
            scrambled it to make a type specimen book 
            it has survived not only five centuries 
            but also the leap into electronic you 
            remaining essentially unchanged 
            it was popularised in the with the""";

    public static void main(String[] args) {
        List<String> allWords = new ArrayList<>(List.of(input.trim().split("\\W+")));
        // п1 - подсчитайте количество различных слов в файле
        Set<String> uniqueWords = new HashSet<>(allWords);
        System.out.println("Различных слов в файле: " + uniqueWords.size());

        // п2 - отсортировать список по длине, а потом по алфавиту
        System.out.println("Список слов, отсортированный по длине и по тексту");
        Comparator<String> comparator = Comparator.comparing(String::length).thenComparing(String::toString);
        List<String> uniqueWordsList = new ArrayList<>(uniqueWords);
        uniqueWordsList.sort(comparator);
        for (String word: uniqueWordsList) {
            System.out.println(word);
        }

        // п3 - встречаемость каждого слова в файле
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word: allWords) {
            if (wordsCount.get(word) == null) {
                wordsCount.put(word, 1);
            } else {
                wordsCount.put(word, wordsCount.get(word)+1);
            }
        }
        System.out.println();
        for (Map.Entry<String, Integer> pair: wordsCount.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }

        // п4 - строки файла в обратном порядке
        List<String> fileLines = new ArrayList<>(List.of(input.split("\n")));
        for (int i = fileLines.size()-1; i >= 0; i--) {
            System.out.println(fileLines.get(i));
        }

        // п5 - итератор для реверсивного прохода, пример использования реализованного task1.ReverseIterator
        ReverseIterator<String> linesReverseIterator = new ReverseIterator<>(fileLines);
        while (linesReverseIterator.hasNext()) {
            System.out.println(linesReverseIterator.next());
        }

        // п6 - вывод строк, запрошенных пользователем
        Scanner in = new Scanner(System.in);
        System.out.println("Введите номера строк через пробел: ");
        String userInput = in.nextLine();
        for (String input: userInput.split(" ")) {
            try {
                int lineNum = Integer.parseInt(input) - 1; // т. к. индексация с 0, а пользователь считает с 1
                System.out.println("Строка " + (lineNum+1) + ": " + fileLines.get(lineNum));
            } catch (NumberFormatException e) {
                System.out.println(input + " не является числом");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("В файле нет строки с номером: " + input);
            }
        }
    }
}

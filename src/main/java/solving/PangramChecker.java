package solving;

/**
 * Класс описывает проверку строки на панграмму
 *
 * @author Афонин А.И.
 * @version 1.0.
 */
public class PangramChecker {
    /**
     * метод проверки строки на панграмму
     *
     * @param sentence обьект в качестве строки
     * @return является парграммой true, false - не является
     */
    boolean check(final String sentence) {
        return sentence.chars()
                .filter(Character::isLetter)
                .map(Character::toLowerCase)
                .distinct()
                .count() == 26;
    }
}



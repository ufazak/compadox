package org.ufazakteam.utils;

/**
 * Created by Toktar on 27.05.2018.
 */
public class StringUtils {
    public static final String DESC_RU = "(Закон|Кодекс) Республики Казахстан от [0-3]?\\d .{2,7}[ая]{1} \\d\\d\\d\\d года (N|№) \\d+(-[\\w-І]+ ЗРК|-[\\w-І]+)?\\.";
    public static final String DESC_KZ = "Қазақстан Республикасының (Заңы|Кодексі)?\\s?\\d\\d\\d\\d жылғы [0-3]?\\d .{5,9}(дағы|дегі) (N|№) \\d+(-[\\w-І]+)?\\s?(Заңы|Кодексі|ҚРЗ)?\\.";

}
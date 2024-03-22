package io.vjattich.parser;

import io.vjattich.connect.DocumentConnect;
import org.jsoup.Jsoup;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import static io.vjattich.TestUtils.toUri;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LentaChequeParserTest {

    @Test
    void parse_test_1() throws IOException, URISyntaxException {

        //GIVEN
        var path = toUri("cheques\\lenta 16.03.24.html");

        var parser = new LentaChequeHtmlFileParser(Paths.get(path).toFile());

        //WHEN
        var elements = parser.parse();

        //THEN
        assertThat(elements).containsExactly(
                "Пакет ЛЕНТА 9кг ; шт.",
                "5 x 7.49",
                "37.45",
                "Вода пит.РОДНИК ПРИКАМЬЯ 1 кат.н/газ5L ; шт.",
                "1 x 86.39",
                "86.39",
                "Уголь 365 ДНЕЙ древесный 30л 2,5 кг ; шт.",
                "2 x 209.99",
                "419.98",
                "Закуска КИТЕД морков по-Корейск мгс 230г ; шт.",
                "1 x 61.99",
                "61.99",
                "Нектар BONVIDA Яблочно-вишневый т/пак.2L ; шт.",
                "1 x 159.99",
                "159.99",
                "Нектар BONVIDA Мультифруктовый т/пак. 2L ; шт.",
                "1 x 159.99",
                "159.99",
                "Нап пив KRONENBOURG 1664 4,5% ст 0.46L ; шт.",
                "3 x 83.99",
                "251.97",
                "Пиво EFES Pilsener СвПаст 5% ст 0.45L ; шт.",
                "8 x 59.99",
                "479.92",
                "Вода пит.РОДНИК ПРИКАМЬЯ 1 кат.н/газ1.5L ; шт.",
                "1 x 40.99",
                "40.99",
                "Морковь По-Корейски вес ; кг",
                "0.401 x 319.99",
                "128.32",
                "Шашлык ЛF филе бедра инд/мед/горч п/ф ох ; кг",
                "0.527 x 579.99",
                "305.65",
                "Крылья ЛЕНТА FRESH кур в маринаде п/ф ох ; кг",
                "0.645 x 359.99",
                "232.19",
                "Стакан 365 ДНЕЙ Однораз.200мл 12шт ; шт.",
                "1 x 17.99",
                "17.99",
                "Шашлык свин шеи в бруснич марин п/ф ох ; кг",
                "0.825 x 599.99",
                "494.99",
                "Шашлык свин шеи Премиум в майонез п/ф ох ; кг",
                "0.746 x 539.99",
                "402.83",
                "Вода пит.РОДНИК ПРИКАМЬЯ 1 кат.н/газ1.5L ; шт.",
                "1 x 40.99",
                "40.99",
                "Тарелка 365 ДНЕЙ однораз.12шт ; шт.",
                "2 x 41.99",
                "83.98",
                "Баранки ЛЕНТА Ванильные 300г ; шт.",
                "1 x 45.99",
                "45.99",
                "Напиток пивн CORONA Extra 4,5%ст0.355L ; шт.",
                "4 x 134.99",
                "539.96",
                "Сидр FERN CIDER ябл с арбузом 5% ст0.5L ; шт.",
                "1 x 119.99",
                "119.99",
                "Салфетки 365 ДНЕЙ 24*24см 1-сл. 100шт ; шт.",
                "1 x 64.99",
                "64.99",
                "Кетчуп МАХЕЕВЪ Шашлычный 300г ; шт.",
                "1 x 79.99",
                "79.99",
                "Пряники ЯШКИНО С вареной сгущенкой 350г ; шт.",
                "1 x 69.99",
                "69.99",
                "Вилки 365 ДНЕЙ однораз.12шт ; шт.",
                "1 x 18.99",
                "18.99",
                "Салфетки 365 ДНЕЙ Ice Tea влаж осв 20шт ; шт.",
                "3 x 17.99",
                "53.97",
                "Спички BOYSCOUT каминные 205мм 40шт ; шт.",
                "1 x 129.99",
                "129.99",
                "Кетчуп БАЛТИМОР Шашлычный дой-пак 260г ; шт.",
                "2 x 64.49",
                "128.98",
                "Огурцы короткоплодные колюч вес ; кг",
                "0.55 x 299.99",
                "164.99",
                "Лаваш MISSION FOODS Оригинальный 3*90г ; шт.",
                "2 x 114.99",
                "229.98",
                "Сыр РАДОСТЬ ВКУСА для жарки 45% 200г ; шт.",
                "1 x 159.99",
                "159.99",
                "Чеснок Фермерский сетка-чулок 100г ; шт.",
                "1 x 129.99",
                "129.99",
                "Лук зеленый свежий уп 100г ; шт.",
                "1 x 92.99",
                "92.99",
                "Набор свежей зелени укроп/петрушка 40г ; шт.",
                "1 x 66.99",
                "66.99",
                "Томаты ФЛАМЕНКО сливовид красн ветке вес ; кг",
                "0.64 x 399.99",
                "255.99",
                "Майонез СЛОБОДА Провансаль 67% 230мл ; шт.",
                "1 x 74.99",
                "74.99",
                "Сыр БУТЕРБРОДОВ Халуми расс 50% бзмж130г ; шт.",
                "1 x 119.99",
                "119.99",
                "Игрушка СКЕЙТЕРРРЫ Домаш.питомец ; шт.",
                "3 x 0.00",
                "0.00"
        );

    }

    @Test
    void parse_test_2() throws URISyntaxException, IOException {

        var path = toUri("cheques\\lenta 18.03.24.html");
        var mock = mock(DocumentConnect.class);
        when(mock.connect()).thenReturn(Jsoup.parse(Paths.get(path).toFile()));

        //GIVEN
        var parser = new LentaChequeUrlParser(mock);

        //WHEN
        var elements = parser.parse();

        //THEN
        assertThat(elements).containsExactly(
                "Пакет ЛЕНТА 9кг ; шт.",
                "5 x 7.49",
                "37.45",
                "Вода пит.РОДНИК ПРИКАМЬЯ 1 кат.н/газ5L ; шт.",
                "1 x 86.39",
                "86.39",
                "Уголь 365 ДНЕЙ древесный 30л 2,5 кг ; шт.",
                "2 x 209.99",
                "419.98",
                "Закуска КИТЕД морков по-Корейск мгс 230г ; шт.",
                "1 x 61.99",
                "61.99",
                "Нектар BONVIDA Яблочно-вишневый т/пак.2L ; шт.",
                "1 x 159.99",
                "159.99",
                "Нектар BONVIDA Мультифруктовый т/пак. 2L ; шт.",
                "1 x 159.99",
                "159.99",
                "Нап пив KRONENBOURG 1664 4,5% ст 0.46L ; шт.",
                "3 x 83.99",
                "251.97",
                "Пиво EFES Pilsener СвПаст 5% ст 0.45L ; шт.",
                "8 x 59.99",
                "479.92",
                "Вода пит.РОДНИК ПРИКАМЬЯ 1 кат.н/газ1.5L ; шт.",
                "1 x 40.99",
                "40.99",
                "Морковь По-Корейски вес ; кг",
                "0.401 x 319.99",
                "128.32",
                "Шашлык ЛF филе бедра инд/мед/горч п/ф ох ; кг",
                "0.527 x 579.99",
                "305.65",
                "Крылья ЛЕНТА FRESH кур в маринаде п/ф ох ; кг",
                "0.645 x 359.99",
                "232.19",
                "Стакан 365 ДНЕЙ Однораз.200мл 12шт ; шт.",
                "1 x 17.99",
                "17.99",
                "Шашлык свин шеи в бруснич марин п/ф ох ; кг",
                "0.825 x 599.99",
                "494.99",
                "Шашлык свин шеи Премиум в майонез п/ф ох ; кг",
                "0.746 x 539.99",
                "402.83",
                "Вода пит.РОДНИК ПРИКАМЬЯ 1 кат.н/газ1.5L ; шт.",
                "1 x 40.99",
                "40.99",
                "Тарелка 365 ДНЕЙ однораз.12шт ; шт.",
                "2 x 41.99",
                "83.98",
                "Баранки ЛЕНТА Ванильные 300г ; шт.",
                "1 x 45.99",
                "45.99",
                "Напиток пивн CORONA Extra 4,5%ст0.355L ; шт.",
                "4 x 134.99",
                "539.96",
                "Сидр FERN CIDER ябл с арбузом 5% ст0.5L ; шт.",
                "1 x 119.99",
                "119.99",
                "Салфетки 365 ДНЕЙ 24*24см 1-сл. 100шт ; шт.",
                "1 x 64.99",
                "64.99",
                "Кетчуп МАХЕЕВЪ Шашлычный 300г ; шт.",
                "1 x 79.99",
                "79.99",
                "Пряники ЯШКИНО С вареной сгущенкой 350г ; шт.",
                "1 x 69.99",
                "69.99",
                "Вилки 365 ДНЕЙ однораз.12шт ; шт.",
                "1 x 18.99",
                "18.99",
                "Салфетки 365 ДНЕЙ Ice Tea влаж осв 20шт ; шт.",
                "3 x 17.99",
                "53.97",
                "Спички BOYSCOUT каминные 205мм 40шт ; шт.",
                "1 x 129.99",
                "129.99",
                "Кетчуп БАЛТИМОР Шашлычный дой-пак 260г ; шт.",
                "2 x 64.49",
                "128.98",
                "Огурцы короткоплодные колюч вес ; кг",
                "0.55 x 299.99",
                "164.99",
                "Лаваш MISSION FOODS Оригинальный 3*90г ; шт.",
                "2 x 114.99",
                "229.98",
                "Сыр РАДОСТЬ ВКУСА для жарки 45% 200г ; шт.",
                "1 x 159.99",
                "159.99",
                "Чеснок Фермерский сетка-чулок 100г ; шт.",
                "1 x 129.99",
                "129.99",
                "Лук зеленый свежий уп 100г ; шт.",
                "1 x 92.99",
                "92.99",
                "Набор свежей зелени укроп/петрушка 40г ; шт.",
                "1 x 66.99",
                "66.99",
                "Томаты ФЛАМЕНКО сливовид красн ветке вес ; кг",
                "0.64 x 399.99",
                "255.99",
                "Майонез СЛОБОДА Провансаль 67% 230мл ; шт.",
                "1 x 74.99",
                "74.99",
                "Сыр БУТЕРБРОДОВ Халуми расс 50% бзмж130г ; шт.",
                "1 x 119.99",
                "119.99",
                "Игрушка СКЕЙТЕРРРЫ Домаш.питомец ; шт.",
                "3 x 0.00",
                "0.00"
        );

    }

}
-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Дек 23 2024 г., 14:44
-- Версия сервера: 8.0.24
-- Версия PHP: 8.0.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `gamingplatform`
--

-- --------------------------------------------------------

--
-- Структура таблицы `achievements`
--

CREATE TABLE `achievements` (
  `id_achievement` int NOT NULL,
  `achievement_name` text NOT NULL,
  `game_id` int NOT NULL,
  `gamer_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `achievements`
--

INSERT INTO `achievements` (`id_achievement`, `achievement_name`, `game_id`, `gamer_id`) VALUES
(1, 'Прыжок', 1, 1),
(2, 'Покупка игры', 2, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `developers`
--

CREATE TABLE `developers` (
  `id_developer` int NOT NULL,
  `developer_name` text NOT NULL,
  `developer_year` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `developers`
--

INSERT INTO `developers` (`id_developer`, `developer_name`, `developer_year`) VALUES
(1, 'ubisoft', 2000),
(2, 'CDPR', 2007);

-- --------------------------------------------------------

--
-- Структура таблицы `gamers`
--

CREATE TABLE `gamers` (
  `id_gamer` int NOT NULL,
  `gamer_nick` text NOT NULL,
  `reg_fullyears` int NOT NULL,
  `game_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `gamers`
--

INSERT INTO `gamers` (`id_gamer`, `gamer_nick`, `reg_fullyears`, `game_id`) VALUES
(1, '_Krutoi_', 16, 1),
(2, 'SuperKrutoi', 4, 1),
(3, 'Ировой ник', 5, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `games`
--

CREATE TABLE `games` (
  `id_game` int NOT NULL,
  `game_name` text NOT NULL,
  `game_year` int NOT NULL,
  `developer_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `games`
--

INSERT INTO `games` (`id_game`, `game_name`, `game_year`, `developer_id`) VALUES
(1, 'battlefield', 2004, 1),
(2, 'SkulAndBones', 2024, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `levels`
--

CREATE TABLE `levels` (
  `id_level` int NOT NULL,
  `level_name` text NOT NULL,
  `game_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `levels`
--

INSERT INTO `levels` (`id_level`, `level_name`, `game_id`) VALUES
(1, 'Начало', 1),
(2, 'Акт 2', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `mods`
--

CREATE TABLE `mods` (
  `id_mod` int NOT NULL,
  `mod_name` text NOT NULL,
  `game_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `mods`
--

INSERT INTO `mods` (`id_mod`, `mod_name`, `game_id`) VALUES
(1, 'creed', 1),
(2, 'Расширение', 1);

-- --------------------------------------------------------

--
-- Структура таблицы `purchases`
--

CREATE TABLE `purchases` (
  `id_purchase` int NOT NULL,
  `unique_code` text NOT NULL,
  `gamer_id` int NOT NULL,
  `game_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `purchases`
--

INSERT INTO `purchases` (`id_purchase`, `unique_code`, `gamer_id`, `game_id`) VALUES
(1, '00000001', 1, 1),
(2, '00000002', 1, 2);

-- --------------------------------------------------------

--
-- Структура таблицы `reviews`
--

CREATE TABLE `reviews` (
  `id_review` int NOT NULL,
  `review_text` text NOT NULL,
  `game_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `reviews`
--

INSERT INTO `reviews` (`id_review`, `review_text`, `game_id`) VALUES
(1, 'Игра прикольная', 1),
(2, 'Игра очень большая, захватывающая и т.п.', 2);

-- --------------------------------------------------------

--
-- Структура таблицы `subscriptions`
--

CREATE TABLE `subscriptions` (
  `id_subscription` int NOT NULL,
  `unique_code` text NOT NULL,
  `gamer_id` int NOT NULL,
  `game_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `subscriptions`
--

INSERT INTO `subscriptions` (`id_subscription`, `unique_code`, `gamer_id`, `game_id`) VALUES
(1, '00000002', 1, 2),
(2, '00000001', 1, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `tournaments`
--

CREATE TABLE `tournaments` (
  `id_tournament` int NOT NULL,
  `tournament_name` text NOT NULL,
  `tournament_location` text NOT NULL,
  `tournament_moneyprize` int NOT NULL,
  `game_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Дамп данных таблицы `tournaments`
--

INSERT INTO `tournaments` (`id_tournament`, `tournament_name`, `tournament_location`, `tournament_moneyprize`, `game_id`) VALUES
(1, 'Прыжки в высоту', 'Москва', 50, 1),
(2, 'Гонка самодельных плотов', 'Карибское море', 1000000, 2);

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `achievements`
--
ALTER TABLE `achievements`
  ADD PRIMARY KEY (`id_achievement`);

--
-- Индексы таблицы `developers`
--
ALTER TABLE `developers`
  ADD PRIMARY KEY (`id_developer`);

--
-- Индексы таблицы `gamers`
--
ALTER TABLE `gamers`
  ADD PRIMARY KEY (`id_gamer`);

--
-- Индексы таблицы `games`
--
ALTER TABLE `games`
  ADD PRIMARY KEY (`id_game`);

--
-- Индексы таблицы `levels`
--
ALTER TABLE `levels`
  ADD PRIMARY KEY (`id_level`);

--
-- Индексы таблицы `mods`
--
ALTER TABLE `mods`
  ADD PRIMARY KEY (`id_mod`);

--
-- Индексы таблицы `purchases`
--
ALTER TABLE `purchases`
  ADD PRIMARY KEY (`id_purchase`);

--
-- Индексы таблицы `reviews`
--
ALTER TABLE `reviews`
  ADD PRIMARY KEY (`id_review`);

--
-- Индексы таблицы `subscriptions`
--
ALTER TABLE `subscriptions`
  ADD PRIMARY KEY (`id_subscription`);

--
-- Индексы таблицы `tournaments`
--
ALTER TABLE `tournaments`
  ADD PRIMARY KEY (`id_tournament`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `achievements`
--
ALTER TABLE `achievements`
  MODIFY `id_achievement` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `developers`
--
ALTER TABLE `developers`
  MODIFY `id_developer` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `gamers`
--
ALTER TABLE `gamers`
  MODIFY `id_gamer` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `games`
--
ALTER TABLE `games`
  MODIFY `id_game` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `levels`
--
ALTER TABLE `levels`
  MODIFY `id_level` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `mods`
--
ALTER TABLE `mods`
  MODIFY `id_mod` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `purchases`
--
ALTER TABLE `purchases`
  MODIFY `id_purchase` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `reviews`
--
ALTER TABLE `reviews`
  MODIFY `id_review` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `subscriptions`
--
ALTER TABLE `subscriptions`
  MODIFY `id_subscription` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `tournaments`
--
ALTER TABLE `tournaments`
  MODIFY `id_tournament` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
